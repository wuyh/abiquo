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

package com.abiquo.api.resources;

import static com.abiquo.api.resources.RoleResource.createTransferObject;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.apache.wink.common.annotations.Workspace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.abiquo.api.services.RoleService;
import com.abiquo.api.util.IRESTBuilder;
import com.abiquo.server.core.enterprise.Role;
import com.abiquo.server.core.enterprise.RoleDto;
import com.abiquo.server.core.enterprise.RolesDto;
import com.abiquo.server.core.util.PagedList;

@Path(RolesResource.ROLES_PATH)
@Controller
@Workspace(workspaceTitle = "Abiquo administration workspace", collectionTitle = "Roles")
public class RolesResource extends AbstractResource
{
    public static final String ROLES_PATH = "admin/roles";

    @Autowired
    private RoleService service;

    @Context
    UriInfo uriInfo;

    @GET
    public RolesDto getRoles(@Context final IRESTBuilder restBuilder) throws Exception
    {
        Collection<Role> all = service.getRoles();
        RolesDto roles = new RolesDto();

        if (all != null && !all.isEmpty())
        {
            for (Role r : all)
            {
                roles.add(createTransferObject(r, restBuilder));
            }
        }

        return roles;
    }

    @GET
    public RolesDto getRoles(@PathParam(EnterpriseResource.ENTERPRISE) final int enterpriseId,
        @QueryParam("filter") final String filter, @QueryParam("orderBy") final String orderBy,
        @QueryParam("desc") final boolean desc, @QueryParam("connected") final boolean connected,
        @QueryParam("page") Integer page, @QueryParam("numResults") Integer numResults,
        @Context final IRESTBuilder restBuilder) throws Exception
    {
        if (page == null)
        {
            page = 0;
        }

        if (numResults == null)
        {
            numResults = DEFAULT_PAGE_LENGTH;
        }

        Collection<Role> all =
            service.getRolesByEnterprise(enterpriseId, filter, orderBy, desc, connected, page,
                numResults);
        RolesDto roles = new RolesDto();

        if (all != null && !all.isEmpty())
        {
            for (Role r : all)
            {
                roles.add(createTransferObject(r, restBuilder));
            }

            if (all instanceof PagedList< ? >)
            {
                PagedList<Role> list = (PagedList<Role>) all;
                roles.setLinks(restBuilder.buildPaggingLinks(uriInfo.getAbsolutePath().toString(),
                    list));
                roles.setTotalSize(list.getTotalResults());
            }
        }

        return roles;
    }

    // @POST
    // Not supported yet
    public RoleDto postRole(final RoleDto role, @Context final IRESTBuilder restBuilder)
        throws Exception
    {
        Role r = service.addRole(role);

        return createTransferObject(r, restBuilder);
    }
}
