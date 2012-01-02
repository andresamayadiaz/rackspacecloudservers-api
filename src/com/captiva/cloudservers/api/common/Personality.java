package com.captiva.cloudservers.api.common;

import java.util.ArrayList;
import java.util.List;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://docs.rackspacecloud.com/servers/api/v1.0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="Personality">
 *   &lt;xs:sequence>
 *     &lt;xs:element type="ns:File" name="file" minOccurs="0" maxOccurs="5"/>
 *   &lt;/xs:sequence>
 * &lt;/xs:complexType>
 * </pre>
 */
public class Personality
{
    private List<File> personalityList = new ArrayList<File>();

    /** 
     * Get the list of 'file' element items.
     * 
     * @return list
     */
    public List<File> getPersonalities() {
        return personalityList;
    }

    /** 
     * Set the list of 'file' element items.
     * 
     * @param list
     */
    public void setPersonalities(List<File> list) {
        personalityList = list;
    }
}
