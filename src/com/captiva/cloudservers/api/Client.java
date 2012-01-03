package com.captiva.cloudservers.api;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.HttpException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;

import com.captiva.cloudservers.api.common.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Client extends Connection {
	private static final Logger logger = Logger.getLogger(Client.class.getName());
	
	public Client(String username, String apiKey) throws Exception {
		super(username, apiKey);
	}
	
	public List<Flavor> getFlavors() throws Exception {
        logger.info("Retrieving flavors information...");
        HttpGet request = new HttpGet(getServerManagementURL() + "/flavors/detail");
        return buildListOfFlavors(request);
    }
	
	public Flavor getFlavorDetails(int flavorID) throws Exception {
        logger.log(Level.INFO, "Retrieving detailed information for flavor {0}...", flavorID);
        validateFlavorID(flavorID);
        HttpGet request = new HttpGet(getServerManagementURL() + "/flavors/" + flavorID);
        
        JsonObject response = makeRequestInt(request, JsonObject.class);    
        Flavor flavor = null;
        Gson gson = new Gson();
        flavor = gson.fromJson(response.get("flavor"), Flavor.class);
        
        return buildFlavor(flavor);
    }
	
	private List<Flavor> buildListOfFlavors(HttpGet request) throws Exception {
        JsonObject response = makeRequestInt(request, JsonObject.class);
        JsonArray flavarray = response.get("flavors").getAsJsonArray();
        List<Flavor> flavors = new ArrayList<Flavor>(flavarray.size());
        Gson gson = new Gson();
        for (JsonElement flavor : flavarray){
        	Flavor flav = gson.fromJson(flavor, Flavor.class);
        	flavors.add(buildFlavor(flav));
        }
        
        return flavors;
    }
	
    private Flavor buildFlavor(Flavor response) {
        return new Flavor(response.getId(), response.getName(), response.getRam(), response.getDisk());
    }
    
    public List<Image> getImages() throws Exception {
        logger.info("Retrieving detailed images information...");
        HttpGet request = new HttpGet(getServerManagementURL() + "/images/detail");
        
        return buildListOfImages(request);
    }
    
    public Image getImageDetails(int imageID) throws Exception {
        logger.log(Level.INFO, "Retrieving detailed information for image {0}...", imageID);
        validateImageID(imageID);
        HttpGet request = new HttpGet(getServerManagementURL() + "/images/" + imageID);
        
        JsonObject response = makeRequestInt(request, JsonObject.class);    
        Image image = null;
        Gson gson = new Gson();
        image = gson.fromJson(response.get("image"), Image.class);
        
        return buildImage(image);
    }
    
    private List<Image> buildListOfImages(HttpGet request) throws Exception {
    	JsonObject response = makeRequestInt(request, JsonObject.class);
        JsonArray imgarray = response.get("images").getAsJsonArray();
        List<Image> images = new ArrayList<Image>(imgarray.size());
        Gson gson = new Gson();
        for (JsonElement image : imgarray){
        	Image img = gson.fromJson(image, Image.class);
        	images.add(buildImage(img));
        }
        return images;
    }
    
    private Image buildImage(Image created) {
        return new Image(
                created.getId(), created.getName(), created.getServerId(),
                created.getUpdated(), created.getCreated(), created.getProgress(),
                created.getStatus() == null ? null : Image.Status.valueOf(created.getStatus().name())
        );
    }
    
    public List<Server> getServers() throws Exception {
        logger.info("Retrieving detailed servers information...");
        HttpGet request = new HttpGet(getServerManagementURL() + "/servers/detail");
        return buildListOfServers(request);
    }
    
    // @TODO: buildServer parameters as JsonObject
    public Server getServerDetails(int serverID) throws Exception {
        logger.log(Level.INFO, "Retrieving detailed information for server {0}...", serverID);
        validateServerID(serverID);
        HttpGet request = new HttpGet(getServerManagementURL() + "/servers/" + serverID);
        
        JsonObject response = makeRequestInt(request, JsonObject.class);    
        Server server = null;
        Gson gson = new Gson();
        server = gson.fromJson(response.get("server"), Server.class);
        
        return buildServer(server);
    }
    
    private List<Server> buildListOfServers(HttpGet request) throws Exception {
    	JsonObject response = makeRequestInt(request, JsonObject.class);
        JsonArray srvarray = response.get("servers").getAsJsonArray();
        List<Server> servers = new ArrayList<Server>(srvarray.size());
        Gson gson = new Gson();
        for (JsonElement server : srvarray){
        	Server srv = gson.fromJson(server, Server.class);
        	servers.add(buildServer(srv));
        }
        
        return servers;
    }
    
    public Server createServer(String name, int imageID, int flavorID) throws Exception {
        return createServer(name, imageID, flavorID, null);
    }
    
    public Server createServer(String name, int imageID, int flavorID, Map<String, String> metadata) throws Exception {
        logger.log(Level.INFO, "Creating server {0} from image {1} running on flavor {2}...",
                new Object[]{name, imageID, flavorID});
        if (name == null)
            throw new IllegalArgumentException("Server name has to be specified!");
        if (imageID == 0)
            throw new IllegalArgumentException("Image ID has to be specified!");
        if (flavorID == 0)
            throw new IllegalArgumentException("Flavor ID has to be specified!");
        HttpPost request = new HttpPost(getServerManagementURL() + "/servers");
        Server server = new Server();
        server.setName(name);
        server.setImageId(imageID);
        server.setFlavorId(flavorID);
        if (metadata != null && !metadata.isEmpty()) {
            Metadata rawMetadata = new Metadata();
            List<MetadataItem> metadataItems = rawMetadata.getMetadatas();
            for (Map.Entry<String, String> entry : metadata.entrySet()) {
                MetadataItem item = new MetadataItem();
                item.setKey(entry.getKey());
                item.setString(entry.getValue());
                metadataItems.add(item);
            }
            server.setMetadata(rawMetadata);
        }
        
        // Serialize entity Object as Json
    	// {"server":{"name":"NOMBRE_SERVIDOR","imageId":112,"flavorId":1}}
    	Gson gson = new Gson();
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("server", server);
    	String entityJson = gson.toJson(map, map.getClass());
    	logger.log(Level.INFO, "Entity As Json: {0}",entityJson);
        JsonObject objResponse = makeEntityRequestInt(request, entityJson, JsonObject.class);  
        Server serverResponse = null;
        serverResponse = gson.fromJson(objResponse.get("server"), Server.class);
        
        return buildServer(serverResponse);
    }
    
    public void rebootServer(int serverID) throws Exception {
        rebootServer(serverID, RebootType.SOFT);
    }
    
    public void rebootServer(int serverID, RebootType type) throws Exception {
        logger.log(Level.INFO, "Rebooting server {0} via {1} reboot...", new Object[]{serverID, type.name()});
        validateServerID(serverID);
        HttpPost request = new HttpPost(getServerManagementURL() + "/servers/" + serverID + "/action");
        Reboot reboot = new Reboot();
        reboot.setType(RebootType.valueOf(type.name()));
        
        // Serialize Reboot Object
        Gson gson = new Gson();
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("reboot", reboot);
    	String entityJson = gson.toJson(map, map.getClass());
    	logger.log(Level.INFO, "Entity As Json: {0}",entityJson);
        
        makeEntityRequestInt(request, entityJson);
    }
    
    public void rebuildServer(int serverID) throws Exception {
        logger.log(Level.INFO, "Rebuilding server {0}...", serverID);
        validateServerID(serverID);
        HttpPost request = new HttpPost(getServerManagementURL() + "/servers/" + serverID + "/action");
        makeEntityRequestInt(request, new Rebuild());
    }
    
    public void rebuildServer(int serverID, int imageID) throws Exception {
        logger.log(Level.INFO, "Rebuilding server {0} from image {1}...", new Object[]{serverID, imageID});
        validateServerID(serverID);
        HttpPost request = new HttpPost(getServerManagementURL() + "/servers/" + serverID + "/action");
        Rebuild rebuild = new Rebuild();
        rebuild.setImageId(imageID);
        
        // Serialize Rebuild Object
        Gson gson = new Gson();
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("rebuild", rebuild);
    	String entityJson = gson.toJson(map, map.getClass());
    	logger.log(Level.INFO, "Entity As Json: {0}",entityJson);
        
        makeEntityRequestInt(request, entityJson);
    }
    
    public void resizeServer(int serverID, int flavorID) throws Exception {
        logger.log(Level.INFO, "Resizing server {0} to run on flavor {1}...", new Object[]{serverID, flavorID});
        validateServerID(serverID);
        HttpPost request = new HttpPost(getServerManagementURL() + "/servers/" + serverID + "/action");
        Resize resize = new Resize();
        resize.setFlavorId(flavorID);
        
        // Serialize Resize Object
        Gson gson = new Gson();
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("resize", resize);
    	String entityJson = gson.toJson(map, map.getClass());
    	logger.log(Level.INFO, "Entity As Json: {0}",entityJson);
        
        makeEntityRequestInt(request, entityJson);
    }
    
    public void confirmResize(int serverID) throws Exception {
        logger.log(Level.INFO, "Confirming resize of server {0}...", serverID);
        validateServerID(serverID);
        HttpPost request = new HttpPost(getServerManagementURL() + "/servers/" + serverID + "/action");
        
        // Serialize ConfirmResize Object
        Gson gson = new GsonBuilder().serializeNulls().create();
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("confirmResize", new ConfirmResize());
    	String entityJson = gson.toJson(map, map.getClass());
    	logger.log(Level.INFO, "Entity As Json: {0}",entityJson);
        
        makeEntityRequestInt(request, entityJson);
    }
    
    public void revertResize(int serverID) throws Exception {
        logger.log(Level.INFO, "Cancelling resize of server {0}...", serverID);
        validateServerID(serverID);
        HttpPost request = new HttpPost(getServerManagementURL() + "/servers/" + serverID + "/action");
        
        // Serialize RevertResize Object
        Gson gson = new GsonBuilder().serializeNulls().create();
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("revertResize", new ConfirmResize());
    	String entityJson = gson.toJson(map, map.getClass());
    	logger.log(Level.INFO, "Entity As Json: {0}",entityJson);
        
        makeEntityRequestInt(request, entityJson);
    }
    
    public void updateServerName(int serverID, String name) throws Exception {
        updateServerNameAndPassword(serverID, name, null);
    }
    
    public void updateServerPassword(int serverID, String password) throws Exception {
        updateServerNameAndPassword(serverID, null, password);
    }
    
    public void updateServerNameAndPassword(final int serverID, final String name, final String password) throws Exception {
        validateServerID(serverID);
        HttpPut request = new HttpPut(getServerManagementURL() + "/servers/" + serverID);
        Server server = new Server();
        server.setId(serverID);
        if (name != null)
            server.setName(name);
        if (password != null)
            server.setAdminPass(password);
        
        // Serialize Server Object
    	Gson gson = new Gson();
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("server", server);
    	String entityJson = gson.toJson(map, map.getClass());
    	logger.log(Level.INFO, "Entity As Json: {0}",entityJson);
        
        makeEntityRequestInt(request, entityJson);
    }
    
    public void deleteServer(int serverID) throws Exception {
        logger.log(Level.INFO, "Deleting server {0}...", serverID);
        validateServerID(serverID);
        HttpDelete request = new HttpDelete(getServerManagementURL() + "/servers/" + serverID);
        makeRequestInt(request);
    }
    
    private Server buildServer(Server response) throws Exception {
        try {
            return new Server(
                    response.getId(), response.getHostId(), response.getName(), response.getAdminPass(),
                    response.getImageId(), response.getFlavorId(),
                    response.getStatus() == null ? null : ServerStatus.valueOf(response.getStatus().name()),
                    response.getMetadata(), //metadataAsMap(response.getMetadata()),
                    response.getAddresses(), //new Addresses(response.getAddresses()),
                    response.getPersonality() //new Personality(response.getPersonality())
            );
        } catch (Exception e) {
            throw new Exception("Can't build server", e);
        }
    }
    
    public Limits getLimits() throws Exception {
        HttpGet request = new HttpGet(getServerManagementURL() + "/limits");
        Limits response = makeRequestInt(request, Limits.class);
        List<RateLimit> rateLimits = new ArrayList<RateLimit>(response.getRate().getRateLimits().size());
        for (RateLimit limit : response.getRate().getRateLimits())
            rateLimits.add(new RateLimit(
                    HTTPVerb.valueOf(limit.getVerb().name()),
                    limit.getURI(),
                    limit.getRegex(),
                    limit.getValue(),
                    limit.getRemaining(),
                    RateLimit.Unit.valueOf(limit.getUnit().name()),
                    limit.getResetTime()
            ));
        List<AbsoluteLimit> absoluteLimits = new ArrayList<AbsoluteLimit>(response.getAbsolute().getAbsoluteLimits().size());
        for (AbsoluteLimit limit : response.getAbsolute().getAbsoluteLimits())
            absoluteLimits.add(new AbsoluteLimit(limit.getName(), limit.getValue()));
        return new Limits(rateLimits, absoluteLimits);
    }
    
    private static Map<String, String> metadataAsMap(Metadata metadata) {
        if (metadata == null)
            return Collections.emptyMap();
        Map<String, String> meta = new HashMap<String, String>();
        for (MetadataItem item : metadata.getMetadatas()) {
            meta.put(item.getKey(), item.getString());
        }
        return meta;
    }
	
    protected void makeRequestInt(HttpRequestBase request) throws Exception {
        makeRequestInt(request, Void.class);
    }
    
    protected <T> T makeRequestInt(HttpRequestBase request, Class<T> respType) throws Exception {
        try {
            return makeRequest(request, respType);
        } catch (MalformedURLException e) {
            throw new Exception(e.getMessage(), e);
        } catch (IOException e) {
            throw new Exception(e.getMessage(), e);
        } catch (HttpException e) {
            throw new Exception(e.getMessage(), e);
        } catch (Exception e){
        	throw new Exception (e.getMessage(), e);
        }
    }
    
    protected void makeEntityRequestInt(HttpEntityEnclosingRequestBase request, final Object entity) throws Exception {
        makeEntityRequestInt(request, entity, Void.class);
    }
    
    protected <T> T makeEntityRequestInt(HttpEntityEnclosingRequestBase request, final Object entity, Class<T> respType) throws Exception {
    	
    	// Set the entity in the request
    	StringEntity myEntity = new StringEntity(entity.toString(), "UTF-8");
    	// TODO: evaluar si se requiere el encoding, probar enviar un nombre de entity con acentos
    	//myEntity.setContentEncoding("UTF-8");
    	request.setEntity(myEntity);
    	
        return makeRequestInt(request, respType);
    }
    
    private void validateServerID(int serverID) throws IllegalArgumentException {
        if (serverID == 0)
            throw new IllegalArgumentException("Invalid serverID " + serverID);
    }

    private void validateFlavorID(int flavorID) throws IllegalArgumentException {
        if (flavorID == 0)
            throw new IllegalArgumentException("Invalid flavorID " + flavorID);
    }

    private void validateImageID(int imageID) throws IllegalArgumentException {
        if (imageID == 0)
            throw new IllegalArgumentException("Invalid imageID " + imageID);
    }

    private void validateSharedIPGroupID(int groupID) throws IllegalArgumentException {
        if (groupID == 0)
            throw new IllegalArgumentException("Invalid shared IP group ID " + groupID);
    }
	
}
