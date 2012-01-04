package com.captiva.cloudservers.api.common;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:xs="http://www.w3.org/2001/XMLSchema" name="AbsoluteLimit">
 *   &lt;xs:attribute type="xs:string" use="required" name="name"/>
 *   &lt;xs:attribute type="xs:int" use="required" name="value"/>
 * &lt;/xs:complexType>
 * </pre>
 */
public class AbsoluteLimit
{
    private String name;
    private int value;
    
    public AbsoluteLimit(String name, int value){
    	this.name = name;
    	this.value = value;
    }
    
    /** 
     * Get the 'name' attribute value.
     * 
     * @return value
     */
    public String getName() {
        return name;
    }

    /** 
     * Set the 'name' attribute value.
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /** 
     * Get the 'value' attribute value.
     * 
     * @return value
     */
    public int getValue() {
        return value;
    }

    /** 
     * Set the 'value' attribute value.
     * 
     * @param value
     */
    public void setValue(int value) {
        this.value = value;
    }
}
