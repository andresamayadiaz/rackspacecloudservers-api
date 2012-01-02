package com.captiva.cloudservers.api.common;

import java.util.ArrayList;
import java.util.List;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://docs.rackspacecloud.com/servers/api/v1.0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="Images">
 *   &lt;xs:sequence>
 *     &lt;xs:element type="ns:Image" name="image" minOccurs="0" maxOccurs="1000"/>
 *   &lt;/xs:sequence>
 * &lt;/xs:complexType>
 * </pre>
 */
public class Images
{
    private List<Image> imageList = new ArrayList<Image>();

    /** 
     * Get the list of 'image' element items.
     * 
     * @return list
     */
    public List<Image> getImages() {
        return imageList;
    }

    /** 
     * Set the list of 'image' element items.
     * 
     * @param list
     */
    public void setImages(List<Image> list) {
        imageList = list;
    }
}