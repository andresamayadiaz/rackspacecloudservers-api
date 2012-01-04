package com.captiva.cloudservers.api.common;

import java.util.List;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://docs.rackspacecloud.com/servers/api/v1.0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="Limits">
 *   &lt;xs:sequence>
 *     &lt;xs:element type="ns:RateLimits" name="rate"/>
 *     &lt;xs:element type="ns:AbsoluteLimits" name="absolute"/>
 *   &lt;/xs:sequence>
 * &lt;/xs:complexType>
 * </pre>
 */
public class Limits
{
    private RateLimits rate;
    private AbsoluteLimits absolute;
    
    public Limits(RateLimits rateLimits, AbsoluteLimits absoluteLimits){
    	this.rate = rateLimits;
    	this.absolute = absoluteLimits;
    }
    
    /** 
     * Get the 'rate' element value.
     * 
     * @return value
     */
    public RateLimits getRate() {
        return rate;
    }

    /** 
     * Set the 'rate' element value.
     * 
     * @param rate
     */
    public void setRate(RateLimits rate) {
        this.rate = rate;
    }

    /** 
     * Get the 'absolute' element value.
     * 
     * @return value
     */
    public AbsoluteLimits getAbsolute() {
        return absolute;
    }

    /** 
     * Set the 'absolute' element value.
     * 
     * @param absolute
     */
    public void setAbsolute(AbsoluteLimits absolute) {
        this.absolute = absolute;
    }
}
