package com.captiva.cloudservers.api.common;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://docs.rackspacecloud.com/servers/api/v1.0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="Server">
 *   &lt;xs:sequence>
 *     &lt;xs:element type="ns:Metadata" name="metadata" minOccurs="0"/>
 *     &lt;xs:element ref="ns:addresses" minOccurs="0"/>
 *     &lt;xs:element type="ns:Personality" name="personality" minOccurs="0"/>
 *   &lt;/xs:sequence>
 *   &lt;xs:attribute type="xs:string" use="optional" name="name"/>
 *   &lt;xs:attribute type="xs:int" use="optional" name="id"/>
 *   &lt;xs:attribute type="xs:string" use="optional" name="adminPass"/>
 *   &lt;xs:attribute type="xs:int" use="optional" name="imageId"/>
 *   &lt;xs:attribute type="xs:int" use="optional" name="flavorId"/>
 *   &lt;xs:attribute type="xs:string" use="optional" name="hostId"/>
 *   &lt;xs:attribute type="xs:int" use="optional" name="progress"/>
 *   &lt;xs:attribute type="ns:ServerStatus" use="optional" name="status"/>
 *   &lt;xs:attribute type="xs:int" use="optional" name="sharedIpGroupId"/>
 * &lt;/xs:complexType>
 * 
 * &lt;xs:element xmlns:ns="http://docs.rackspacecloud.com/servers/api/v1.0" xmlns:xs="http://www.w3.org/2001/XMLSchema" type="ns:Addresses" name="addresses"/>
 * </pre>
 */

 /**
  * Server: collection of information related to a server.
  *
  * @author Andres Amaya
  */

public class Server
{
    private Metadata metadata;
    private Addresses addresses;
    private Personality personality;
    private String name;
    private Integer id;
    private String adminPass;
    private Integer imageId;
    private Integer flavorId;
    private String hostId;
    private Integer progress;
    private ServerStatus status;
    private Integer sharedIpGroupId;

    /*
    response.getId(), response.getName(), response.getAdminPass(),
    response.getImageId(), response.getFlavorId(),
    response.getStatus() == null ? null : ServerStatus.valueOf(response.getStatus().name()),
    metadataAsMap(response.getMetadata()),
    new Addresses(response.getAddresses()),
    new Personality(response.getPersonality())
    */
    
    public Server(Integer id, String name, String adminPass, Integer imageId, Integer flavorId, ServerStatus status, Metadata metadata, Addresses addresses, Personality personality ){
    	
    	this.id = id;
    	this.name = name;
    	this.adminPass = adminPass;
    	this.imageId = imageId;
    	this.flavorId = flavorId;
    	this.status = status;
    	this.metadata = metadata;
    	this.addresses = addresses;
    	this.personality = personality;
    	
    }
    
    /** 
     * Get the 'metadata' element value.
     * 
     * @return value
     */
    public Metadata getMetadata() {
        return metadata;
    }

    /** 
     * Set the 'metadata' element value.
     * 
     * @param metadata
     */
    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    /** 
     * Get the 'addresses' element value. 
          <p xmlns="http://www.w3.org/1999/xhtml">
            A list of addresses (public and private) belonging to a
            particular server.
          </p>
        
     * 
     * @return value
     */
    public Addresses getAddresses() {
        return addresses;
    }

    /** 
     * Set the 'addresses' element value. 
          <p xmlns="http://www.w3.org/1999/xhtml">
            A list of addresses (public and private) belonging to a
            particular server.
          </p>
        
     * 
     * @param addresses
     */
    public void setAddresses(Addresses addresses) {
        this.addresses = addresses;
    }

    /** 
     * Get the 'personality' element value.
     * 
     * @return value
     */
    public Personality getPersonality() {
        return personality;
    }

    /** 
     * Set the 'personality' element value.
     * 
     * @param personality
     */
    public void setPersonality(Personality personality) {
        this.personality = personality;
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
     * Get the 'id' attribute value.
     * 
     * @return value
     */
    public Integer getId() {
        return id;
    }

    /** 
     * Set the 'id' attribute value.
     * 
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 
     * Get the 'adminPass' attribute value.
     * 
     * @return value
     */
    public String getAdminPass() {
        return adminPass;
    }

    /** 
     * Set the 'adminPass' attribute value.
     * 
     * @param adminPass
     */
    public void setAdminPass(String adminPass) {
        this.adminPass = adminPass;
    }

    /** 
     * Get the 'imageId' attribute value.
     * 
     * @return value
     */
    public Integer getImageId() {
        return imageId;
    }

    /** 
     * Set the 'imageId' attribute value.
     * 
     * @param imageId
     */
    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    /** 
     * Get the 'flavorId' attribute value.
     * 
     * @return value
     */
    public Integer getFlavorId() {
        return flavorId;
    }

    /** 
     * Set the 'flavorId' attribute value.
     * 
     * @param flavorId
     */
    public void setFlavorId(Integer flavorId) {
        this.flavorId = flavorId;
    }

    /** 
     * Get the 'hostId' attribute value.
     * 
     * @return value
     */
    public String getHostId() {
        return hostId;
    }

    /** 
     * Set the 'hostId' attribute value.
     * 
     * @param hostId
     */
    public void setHostId(String hostId) {
        this.hostId = hostId;
    }

    /** 
     * Get the 'progress' attribute value.
     * 
     * @return value
     */
    public Integer getProgress() {
        return progress;
    }

    /** 
     * Set the 'progress' attribute value.
     * 
     * @param progress
     */
    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    /** 
     * Get the 'status' attribute value.
     * 
     * @return value
     */
    public ServerStatus getStatus() {
        return status;
    }

    /** 
     * Set the 'status' attribute value.
     * 
     * @param status
     */
    public void setStatus(ServerStatus status) {
        this.status = status;
    }

    /** 
     * Get the 'sharedIpGroupId' attribute value.
     * 
     * @return value
     */
    public Integer getSharedIpGroupId() {
        return sharedIpGroupId;
    }

    /** 
     * Set the 'sharedIpGroupId' attribute value.
     * 
     * @param sharedIpGroupId
     */
    public void setSharedIpGroupId(Integer sharedIpGroupId) {
        this.sharedIpGroupId = sharedIpGroupId;
    }
}
