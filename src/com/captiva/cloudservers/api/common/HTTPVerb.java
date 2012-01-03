package com.captiva.cloudservers.api.common;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:simpleType xmlns:xs="http://www.w3.org/2001/XMLSchema" name="HTTPVerb">
 *   &lt;xs:restriction base="xs:string">
 *     &lt;xs:enumeration value="POST"/>
 *     &lt;xs:enumeration value="PUT"/>
 *     &lt;xs:enumeration value="GET"/>
 *     &lt;xs:enumeration value="DELETE"/>
 *     &lt;xs:enumeration value="HEAD"/>
 *   &lt;/xs:restriction>
 * &lt;/xs:simpleType>
 * </pre>
 */
public enum HTTPVerb {
    POST, PUT, GET, DELETE, HEAD
}
