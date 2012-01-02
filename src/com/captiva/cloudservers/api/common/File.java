package com.captiva.cloudservers.api.common;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:xs="http://www.w3.org/2001/XMLSchema" name="File">
 *   &lt;xs:simpleContent>
 *     &lt;xs:extension base="xs:base64Binary">
 *       &lt;xs:attribute type="xs:string" use="required" name="path"/>
 *     &lt;/xs:extension>
 *   &lt;/xs:simpleContent>
 * &lt;/xs:complexType>
 * </pre>
 */
public class File
{
    private byte[] base64Binary;
    private String path;

    /** 
     * Get the extension value.
     * 
     * @return value
     */
    public byte[] getBase64Binary() {
        return base64Binary;
    }

    /** 
     * Set the extension value.
     * 
     * @param base64Binary
     */
    public void setBase64Binary(byte[] base64Binary) {
        this.base64Binary = base64Binary;
    }

    /** 
     * Get the 'path' attribute value.
     * 
     * @return value
     */
    public String getPath() {
        return path;
    }

    /** 
     * Set the 'path' attribute value.
     * 
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
    }
}