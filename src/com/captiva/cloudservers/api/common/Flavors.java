package com.captiva.cloudservers.api.common;

import java.util.ArrayList;
import java.util.List;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://docs.rackspacecloud.com/servers/api/v1.0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="Flavors">
 *   &lt;xs:sequence>
 *     &lt;xs:element type="ns:Flavor" name="flavor" minOccurs="0" maxOccurs="1000"/>
 *   &lt;/xs:sequence>
 * &lt;/xs:complexType>
 * </pre>
 */
public class Flavors
{
    private String name = null;
	private List<Flavor> flavorList = new ArrayList<Flavor>();
    
	public Flavors(String name, List<Flavor> flavors){
		this.setName(name);
		this.flavorList = flavors;
	}
	
    public Flavors(List<Flavor> flavors){
    	this.flavorList = flavors;
    }
    
    /** 
     * Get the list of 'flavor' element items.
     * 
     * @return list
     */
    public List<Flavor> getFlavors() {
        return flavorList;
    }

    /** 
     * Set the list of 'flavor' element items.
     * 
     * @param list
     */
    public void setFlavors(List<Flavor> list) {
        flavorList = list;
    }

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}