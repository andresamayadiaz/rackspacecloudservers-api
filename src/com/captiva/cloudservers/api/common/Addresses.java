package com.captiva.cloudservers.api.common;

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
public class Addresses
{
    private Public _public;
    private Private _private;

    /** 
     * Get the 'public' element value.
     * 
     * @return value
     */
    public Public getPublic() {
        return _public;
    }

    /** 
     * Set the 'public' element value.
     * 
     * @param _public
     */
    public void setPublic(Public _public) {
        this._public = _public;
    }

    /** 
     * Get the 'private' element value.
     * 
     * @return value
     */
    public Private getPrivate() {
        return _private;
    }

    /** 
     * Set the 'private' element value.
     * 
     * @param _private
     */
    public void setPrivate(Private _private) {
        this._private = _private;
    }
}