package com.captiva.cloudservers.api.common;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:xs="http://www.w3.org/2001/XMLSchema" name="Address">
 *   &lt;xs:attribute type="xs:string" use="required" name="addr"/>
 * &lt;/xs:complexType>
 * </pre>
 */
public class Address
{
    private String addr;

    /** 
     * Get the 'addr' attribute value.
     * 
     * @return value
     */
    public String getAddr() {
        return addr;
    }

    /** 
     * Set the 'addr' attribute value.
     * 
     * @param addr
     */
    public void setAddr(String addr) {
        this.addr = addr;
    }
}