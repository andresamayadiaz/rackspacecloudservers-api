package com.captiva.cloudservers.api.common;

import java.util.ArrayList;
import java.util.List;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://docs.rackspacecloud.com/servers/api/v1.0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="Metadata">
 *   &lt;xs:sequence>
 *     &lt;xs:element type="ns:MetadataItem" name="meta" minOccurs="0" maxOccurs="5"/>
 *   &lt;/xs:sequence>
 * &lt;/xs:complexType>
 * </pre>
 */
public class Metadata
{
    private List<MetadataItem> metadataList = new ArrayList<MetadataItem>();

    /** 
     * Get the list of 'meta' element items.
     * 
     * @return list
     */
    public List<MetadataItem> getMetadatas() {
        return metadataList;
    }

    /** 
     * Set the list of 'meta' element items.
     * 
     * @param list
     */
    public void setMetadatas(List<MetadataItem> list) {
        metadataList = list;
    }
}
