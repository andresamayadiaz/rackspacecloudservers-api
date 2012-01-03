package com.captiva.cloudservers.api.common;

import java.util.ArrayList;
import java.util.List;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://docs.rackspacecloud.com/servers/api/v1.0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="AbsoluteLimits">
 *   &lt;xs:sequence>
 *     &lt;xs:element type="ns:AbsoluteLimit" name="limit" minOccurs="1" maxOccurs="unbounded"/>
 *   &lt;/xs:sequence>
 * &lt;/xs:complexType>
 * </pre>
 */
public class AbsoluteLimits
{
    private List<AbsoluteLimit> absoluteLimitList = new ArrayList<AbsoluteLimit>();

    /** 
     * Get the list of 'limit' element items.
     * 
     * @return list
     */
    public List<AbsoluteLimit> getAbsoluteLimits() {
        return absoluteLimitList;
    }

    /** 
     * Set the list of 'limit' element items.
     * 
     * @param list
     */
    public void setAbsoluteLimits(List<AbsoluteLimit> list) {
        absoluteLimitList = list;
    }
}
