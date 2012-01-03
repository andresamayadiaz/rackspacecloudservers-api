package com.captiva.cloudservers.api.common;

import java.util.ArrayList;
import java.util.List;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://docs.rackspacecloud.com/servers/api/v1.0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="RateLimits">
 *   &lt;xs:sequence>
 *     &lt;xs:element type="ns:RateLimit" name="limit" minOccurs="1" maxOccurs="unbounded"/>
 *   &lt;/xs:sequence>
 * &lt;/xs:complexType>
 * </pre>
 */
public class RateLimits
{
    private List<RateLimit> rateLimitList = new ArrayList<RateLimit>();

    /** 
     * Get the list of 'limit' element items.
     * 
     * @return list
     */
    public List<RateLimit> getRateLimits() {
        return rateLimitList;
    }

    /** 
     * Set the list of 'limit' element items.
     * 
     * @param list
     */
    public void setRateLimits(List<RateLimit> list) {
        rateLimitList = list;
    }
}