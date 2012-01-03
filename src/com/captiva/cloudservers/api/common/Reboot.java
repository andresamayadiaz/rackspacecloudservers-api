package com.captiva.cloudservers.api.common;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://docs.rackspacecloud.com/servers/api/v1.0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="Reboot">
 *   &lt;xs:complexContent>
 *     &lt;xs:extension base="ns:Action">
 *       &lt;xs:attribute type="ns:RebootType" use="required" name="type"/>
 *     &lt;/xs:extension>
 *   &lt;/xs:complexContent>
 * &lt;/xs:complexType>
 * </pre>
 */
public class Reboot extends Action
{
    private RebootType type;

    /** 
     * Get the 'type' attribute value.
     * 
     * @return value
     */
    public RebootType getType() {
        return type;
    }

    /** 
     * Set the 'type' attribute value.
     * 
     * @param type
     */
    public void setType(RebootType type) {
        this.type = type;
    }
}
