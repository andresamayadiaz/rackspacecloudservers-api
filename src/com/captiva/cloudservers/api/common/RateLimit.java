package com.captiva.cloudservers.api.common;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://docs.rackspacecloud.com/servers/api/v1.0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="RateLimit">
 *   &lt;xs:attribute type="ns:HTTPVerb" use="required" name="verb"/>
 *   &lt;xs:attribute type="xs:string" use="required" name="URI"/>
 *   &lt;xs:attribute type="xs:string" use="required" name="regex"/>
 *   &lt;xs:attribute type="xs:int" use="required" name="value"/>
 *   &lt;xs:attribute type="xs:int" use="required" name="remaining"/>
 *   &lt;xs:attribute type="ns:RateLimitUnit" use="required" name="unit"/>
 *   &lt;xs:attribute type="xs:long" use="required" name="resetTime"/>
 * &lt;/xs:complexType>
 * </pre>
 */
public class RateLimit
{
    private HTTPVerb verb;
    private String URI;
    private String regex;
    private int value;
    private int remaining;
    private RateLimitUnit unit;
    private long resetTime;

    /** 
     * Get the 'verb' attribute value.
     * 
     * @return value
     */
    public HTTPVerb getVerb() {
        return verb;
    }

    /** 
     * Set the 'verb' attribute value.
     * 
     * @param verb
     */
    public void setVerb(HTTPVerb verb) {
        this.verb = verb;
    }

    /** 
     * Get the 'URI' attribute value.
     * 
     * @return value
     */
    public String getURI() {
        return URI;
    }

    /** 
     * Set the 'URI' attribute value.
     * 
     * @param URI
     */
    public void setURI(String URI) {
        this.URI = URI;
    }

    /** 
     * Get the 'regex' attribute value.
     * 
     * @return value
     */
    public String getRegex() {
        return regex;
    }

    /** 
     * Set the 'regex' attribute value.
     * 
     * @param regex
     */
    public void setRegex(String regex) {
        this.regex = regex;
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

    /** 
     * Get the 'remaining' attribute value.
     * 
     * @return value
     */
    public int getRemaining() {
        return remaining;
    }

    /** 
     * Set the 'remaining' attribute value.
     * 
     * @param remaining
     */
    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    /** 
     * Get the 'unit' attribute value.
     * 
     * @return value
     */
    public RateLimitUnit getUnit() {
        return unit;
    }

    /** 
     * Set the 'unit' attribute value.
     * 
     * @param unit
     */
    public void setUnit(RateLimitUnit unit) {
        this.unit = unit;
    }

    /** 
     * Get the 'resetTime' attribute value.
     * 
     * @return value
     */
    public long getResetTime() {
        return resetTime;
    }

    /** 
     * Set the 'resetTime' attribute value.
     * 
     * @param resetTime
     */
    public void setResetTime(long resetTime) {
        this.resetTime = resetTime;
    }
}
