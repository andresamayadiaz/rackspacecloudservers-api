package com.captiva.cloudservers.api.common;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://docs.rackspacecloud.com/servers/api/v1.0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="Rebuild">
 *   &lt;xs:complexContent>
 *     &lt;xs:extension base="ns:Action">
 *       &lt;xs:attribute type="xs:int" use="required" name="imageId"/>
 *     &lt;/xs:extension>
 *   &lt;/xs:complexContent>
 * &lt;/xs:complexType>
 * </pre>
 */
public class Rebuild extends Action
{
    private int imageId;

    /** 
     * Get the 'imageId' attribute value.
     * 
     * @return value
     */
    public int getImageId() {
        return imageId;
    }

    /** 
     * Set the 'imageId' attribute value.
     * 
     * @param imageId
     */
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}