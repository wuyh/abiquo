/**
 * Abiquo community edition
 * cloud management application for hybrid clouds
 * Copyright (C) 2008-2010 - Abiquo Holdings S.L.
 *
 * This application is free software; you can redistribute it and/or
 * modify it under the terms of the GNU LESSER GENERAL PUBLIC
 * LICENSE as published by the Free Software Foundation under
 * version 3 of the License
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * LESSER GENERAL PUBLIC LICENSE v.3 for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA 02111-1307, USA.
 */
package com.abiquo.api.tracer.hierarchy.processors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abiquo.api.resources.UsersResource;
import com.abiquo.api.tracer.hierarchy.AbstractHierarchyProcessor;
import com.abiquo.server.core.enterprise.EnterpriseRep;
import com.abiquo.server.core.enterprise.User;

/**
 * Processes the hierarchy to extract {@link User} data.
 * 
 * @author ibarrera
 */
@Service
public class UserProcessor extends AbstractHierarchyProcessor<User>
{
    /** The DAO used to get the resource information. */
    @Autowired
    private EnterpriseRep dao;

    @Override
    protected String getIdentifierPrefix()
    {
        return UsersResource.USERS_PATH;
    }

    @Override
    @Transactional(readOnly = true)
    protected String getResourceName(final String resourceId)
    {
        User user = dao.findUserById(Integer.valueOf(resourceId));
        return user != null ? user.getName() : null;
    }

}
