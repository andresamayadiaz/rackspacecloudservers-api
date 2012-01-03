package com.captiva.cloudservers.api.common;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://docs.rackspacecloud.com/servers/api/v1.0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="Resize">
 *   &lt;xs:complexContent>
 *     &lt;xs:extension base="ns:Action">
 *       &lt;xs:attribute type="xs:int" use="required" name="flavorId"/>
 *     &lt;/xs:extension>
 *   &lt;/xs:complexContent>
 * &lt;/xs:complexType>
 * </pre>
 */
public class Resize extends Action
{
    private int flavorId;

    /** 
     * Get the 'flavorId' attribute value.
     * 
     * @return value
     */
    public int getFlavorId() {
        return flavorId;
    }

    /** 
     * Set the 'flavorId' attribute value.
     * 
     * @param flavorId
     */
    public void setFlavorId(int flavorId) {
        this.flavorId = flavorId;
    }
}
