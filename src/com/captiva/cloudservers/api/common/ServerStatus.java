package com.captiva.cloudservers.api.common;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:simpleType xmlns:xs="http://www.w3.org/2001/XMLSchema" name="ServerStatus">
 *   &lt;xs:restriction base="xs:string">
 *     &lt;xs:enumeration value="ACTIVE"/>
 *     &lt;xs:enumeration value="SUSPENDED"/>
 *     &lt;xs:enumeration value="DELETED"/>
 *     &lt;xs:enumeration value="QUEUE_RESIZE"/>
 *     &lt;xs:enumeration value="PREP_RESIZE"/>
 *     &lt;xs:enumeration value="RESIZE"/>
 *     &lt;xs:enumeration value="VERIFY_RESIZE"/>
 *     &lt;xs:enumeration value="QUEUE_MOVE"/>
 *     &lt;xs:enumeration value="PREP_MOVE"/>
 *     &lt;xs:enumeration value="MOVE"/>
 *     &lt;xs:enumeration value="VERIFY_MOVE"/>
 *     &lt;xs:enumeration value="RESCUE"/>
 *     &lt;xs:enumeration value="ERROR"/>
 *     &lt;xs:enumeration value="BUILD"/>
 *     &lt;xs:enumeration value="RESTORING"/>
 *     &lt;xs:enumeration value="PASSWORD"/>
 *     &lt;xs:enumeration value="REBUILD"/>
 *     &lt;xs:enumeration value="DELETE_IP"/>
 *     &lt;xs:enumeration value="SHARE_IP_NO_CONFIG"/>
 *     &lt;xs:enumeration value="SHARE_IP"/>
 *     &lt;xs:enumeration value="REBOOT"/>
 *     &lt;xs:enumeration value="HARD_REBOOT"/>
 *     &lt;xs:enumeration value="UNKNOWN"/>
 *   &lt;/xs:restriction>
 * &lt;/xs:simpleType>
 * </pre>
 */
public enum ServerStatus {
    ACTIVE, SUSPENDED, DELETED, QUEUE_RESIZE, PREP_RESIZE, RESIZE, VERIFY_RESIZE, QUEUE_MOVE, PREP_MOVE, MOVE, VERIFY_MOVE, RESCUE, ERROR, BUILD, RESTORING, PASSWORD, REBUILD, DELETE_IP, SHARE_IP_NO_CONFIG, SHARE_IP, REBOOT, HARD_REBOOT, UNKNOWN
}