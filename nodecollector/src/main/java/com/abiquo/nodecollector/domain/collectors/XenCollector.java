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

package com.abiquo.nodecollector.domain.collectors;

import org.libvirt.Connect;
import org.libvirt.Domain;
import org.libvirt.LibvirtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.abiquo.model.enumerator.HypervisorType;
import com.abiquo.nodecollector.aim.impl.AimCollectorImpl;
import com.abiquo.nodecollector.constants.MessageValues;
import com.abiquo.nodecollector.domain.Collector;
import com.abiquo.nodecollector.exception.CollectorException;
import com.abiquo.nodecollector.exception.ConnectionException;
import com.abiquo.nodecollector.exception.libvirt.AimException;

/**
 * Specified connection for the XEN Hypervisor.
 * 
 * @author jdevesa
 */
@Collector(type = HypervisorType.XEN_3, order = 4)
public class XenCollector extends AbstractLibvirtCollector
{
    private static final Logger LOGGER = LoggerFactory.getLogger(XenCollector.class);

    @Override
    public void connect(final String user, final String password) throws ConnectionException
    {
        try
        {
            setConn(new Connect("xen+tcp://" + getIpAddress() + "/?no_tty=1"));
            try
            {
                aimcollector = new AimCollectorImpl(getIpAddress(), getAimPort());
                aimcollector.checkAIM();
            }
            catch (AimException e)
            {
                try
                {
                    this.disconnect();
                }
                catch (CollectorException e1)
                {
                    LOGGER.error("Error freeing libvirt connection to address " + getIpAddress(),
                        e1);
                    return;
                }
                throw new ConnectionException(MessageValues.CONN_EXCP_IV, e);
            }

        }
        catch (LibvirtException e)
        {
            try
            {
                this.disconnect();
            }
            catch (CollectorException e1)
            {
                LOGGER.error("Error freeing libvirt connection to address " + getIpAddress(), e1);
                // return;
            }

            LOGGER.warn("Could not connect at hypervisor {} at cloud node {}", this
                .getHypervisorType().name(), getIpAddress());
            throw new ConnectionException(MessageValues.CONN_EXCP_IV, e);
        }

    }

    @Override
    protected boolean isDomain0(final Domain domain) throws LibvirtException
    {
        return domain.getUUIDString().equals("00000000-0000-0000-0000-000000000000");
    }
}
