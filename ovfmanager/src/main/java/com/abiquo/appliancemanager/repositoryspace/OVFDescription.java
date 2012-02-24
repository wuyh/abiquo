//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.02.23 at 01:07:44 PM CET 
//


package com.abiquo.appliancemanager.repositoryspace;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.dmtf.schemas.ovf.envelope._1.ProductSectionType;


/**
 * <p>Java class for OVFDescription complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OVFDescription">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.dmtf.org/ovf/envelope/1}ProductSection_Type">
 *       &lt;attribute name="RepositoryURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="RepositoryName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="OVFFile" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="OVFCategories" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="DiskFormat" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="DiskSize" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;anyAttribute processContents='lax'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OVFDescription")
public class OVFDescription
    extends ProductSectionType
{

    @XmlAttribute(name = "RepositoryURI", namespace = "http://www.abiquo.com/appliancemanager/repositoryspace")
    @XmlSchemaType(name = "anyURI")
    protected String repositoryURI;
    @XmlAttribute(name = "RepositoryName", namespace = "http://www.abiquo.com/appliancemanager/repositoryspace")
    protected String repositoryName;
    @XmlAttribute(name = "OVFFile", namespace = "http://www.abiquo.com/appliancemanager/repositoryspace", required = true)
    protected String ovfFile;
    @XmlAttribute(name = "OVFCategories", namespace = "http://www.abiquo.com/appliancemanager/repositoryspace")
    protected String ovfCategories;
    @XmlAttribute(name = "DiskFormat", namespace = "http://www.abiquo.com/appliancemanager/repositoryspace", required = true)
    protected String diskFormat;
    @XmlAttribute(name = "DiskSize", namespace = "http://www.abiquo.com/appliancemanager/repositoryspace", required = true)
    protected String diskSize;

    /**
     * Gets the value of the repositoryURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRepositoryURI() {
        return repositoryURI;
    }

    /**
     * Sets the value of the repositoryURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRepositoryURI(String value) {
        this.repositoryURI = value;
    }

    /**
     * Gets the value of the repositoryName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRepositoryName() {
        return repositoryName;
    }

    /**
     * Sets the value of the repositoryName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRepositoryName(String value) {
        this.repositoryName = value;
    }

    /**
     * Gets the value of the ovfFile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOVFFile() {
        return ovfFile;
    }

    /**
     * Sets the value of the ovfFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOVFFile(String value) {
        this.ovfFile = value;
    }

    /**
     * Gets the value of the ovfCategories property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOVFCategories() {
        return ovfCategories;
    }

    /**
     * Sets the value of the ovfCategories property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOVFCategories(String value) {
        this.ovfCategories = value;
    }

    /**
     * Gets the value of the diskFormat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiskFormat() {
        return diskFormat;
    }

    /**
     * Sets the value of the diskFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiskFormat(String value) {
        this.diskFormat = value;
    }

    /**
     * Gets the value of the diskSize property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiskSize() {
        return diskSize;
    }

    /**
     * Sets the value of the diskSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiskSize(String value) {
        this.diskSize = value;
    }

}