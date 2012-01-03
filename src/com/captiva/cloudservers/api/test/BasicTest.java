package com.captiva.cloudservers.api.test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.captiva.cloudservers.api.common.*;
import com.captiva.cloudservers.api.Client;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public class BasicTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			Client con = new Client("andresamaya", "93eff8920da9ff17ea378eea54cf5207");
			
			// Flavors Test
			//List<Flavor> flavors = con.getFlavors();
			//Flavor flavor = con.getFlavorDetails(2);
			
			// Images Test
			//List<Image> images = con.getImages();
			//Image image = con.getImageDetails(112);
			
			// Servers List Test
			//List<Server> servers = con.getServers();
			
			// Server Details Test
			//Server server = con.getServerDetails(servers.get(0).getId());
			
			// Server Create Server Test
			//Server server = con.createServer("apiTest", 112, 1);
			//System.out.println("Server ID: " + server.getId() + " Name: " + server.getName() + " adminPass: " + server.getAdminPass() + " Public IP: " + server.getAddresses().getPublic());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
