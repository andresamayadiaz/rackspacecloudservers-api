package com.captiva.cloudservers.api.common;

import java.util.ArrayList;
import java.util.List;


/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://docs.rackspacecloud.com/servers/api/v1.0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="AddressList">
 *   &lt;xs:sequence>
 *     &lt;xs:element type="ns:Address" name="ip" minOccurs="0" maxOccurs="unbounded"/>
 *   &lt;/xs:sequence>
 * &lt;/xs:complexType>
 * </pre>
 */
public class AddressList
{
    private List<Address> addressListList = new ArrayList<Address>();

    /** 
     * Get the list of 'ip' element items.
     * 
     * @return list
     */
    public List<Address> getAddressLists() {
        return addressListList;
    }

    /** 
     * Set the list of 'ip' element items.
     * 
     * @param list
     */
    public void setAddressLists(List<Address> list) {
        addressListList = list;
    }
}
