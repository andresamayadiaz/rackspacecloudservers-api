package com.captiva.cloudservers.api.common;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://docs.rackspacecloud.com/servers/api/v1.0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="Addresses">
 *   &lt;xs:sequence>
 *     &lt;xs:element ref="ns:public" minOccurs="0"/>
 *     &lt;xs:element ref="ns:private" minOccurs="0"/>
 *   &lt;/xs:sequence>
 * &lt;/xs:complexType>
 * </pre>
 */
public class Addresses implements Serializable
{
	@SerializedName("public")
    private String _public;
	
	@SerializedName("private")
    private String _private;

    /** 
     * Get the 'public' element value.
     * 
     * @return value
     */
    public String getPublic() {
        return _public;
    }

    /** 
     * Set the 'public' element value.
     * 
     * @param _public
     */
    public void setPublic(String _public) {
        this._public = _public;
    }

    /** 
     * Get the 'private' element value.
     * 
     * @return value
     */
    public String getPrivate() {
        return _private;
    }

    /** 
     * Set the 'private' element value.
     * 
     * @param _private
     */
    public void setPrivate(String _private) {
        this._private = _private;
    }
}