package com.captiva.cloudservers.api.common;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:simpleType xmlns:xs="http://www.w3.org/2001/XMLSchema" name="RateLimitUnit">
 *   &lt;xs:restriction base="xs:string">
 *     &lt;xs:enumeration value="MINUTE"/>
 *     &lt;xs:enumeration value="HOUR"/>
 *     &lt;xs:enumeration value="DAY"/>
 *   &lt;/xs:restriction>
 * &lt;/xs:simpleType>
 * </pre>
 */
public enum RateLimitUnit {
    MINUTE, HOUR, DAY
}
