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

package com.abiquo.vsm.model.transport;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "virtualmachine")
@XmlType(propOrder = {"id", "name", "lastKnownState", "physicalMachine"})
public class VirtualMachineDto implements Serializable
{
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String lastKnownState;

    private PhysicalMachineDto physicalMachine;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getLastKnownState()
    {
        return lastKnownState;
    }

    public void setLastKnownState(String lastKnownState)
    {
        this.lastKnownState = lastKnownState;
    }

    public PhysicalMachineDto getPhysicalMachine()
    {
        return physicalMachine;
    }

    public void setPhysicalMachine(PhysicalMachineDto physicalMachine)
    {
        this.physicalMachine = physicalMachine;
    }

}
