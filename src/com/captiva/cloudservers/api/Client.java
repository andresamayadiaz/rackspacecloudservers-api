package com.captiva.cloudservers.api;

import java.io.IOException;
import java.net.MalformedURLException;

import java.util.List;
import java.util.logging.Logger;

import com.captiva.cloudservers.api.common.*;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.apache.http.HttpException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;

public class Client extends Connection {
	private static final Logger logger = Logger.getLogger(Client.class.getName());
	
	public Client(String username, String apiKey) throws Exception {
		super(username, apiKey);
		// TODO Auto-generated constructor stub
	}
	
	public List<Flavor> getFlavors() throws Exception {
        logger.info("Retrieving flavors information...");
        HttpGet request = new HttpGet(getServerManagementURL() + "/flavors/detail");
        return buildListOfFlavors(request);
    }
	
	private List<Flavor> buildListOfFlavors(HttpGet request) throws Exception {
        JsonObject response = makeRequestInt(request, JsonObject.class); // Flavors.class
        
        JsonArray flavarray = response.get("flavors").getAsJsonArray();
        List<Flavor> flavors = null;
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
	
}
