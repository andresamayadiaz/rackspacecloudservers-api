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
			List<Flavor> flavors = con.getFlavors();
			
			//String flavJSON = "{'flavors':[{'id':1,'ram':256,'disk':10,'name':'256 server'},{'id':2,'ram':512,'disk':20,'name':'512 server'}]}";
			//String flavJSON = "{\"flavors\":[{\"id\":1,\"ram\":256,\"disk\":10,\"name\":\"256 server\"},{\"id\":2,\"ram\":512,\"disk\":20,\"name\":\"512 server\"}]}";
			//flavJSON = "{[{'id':1,'name':'256 server'},{'id':2,'name':'512 server'}]}";
			// DETAIL: {"flavors":[{"id":1,"ram":256,"disk":10,"name":"256 server"},{"id":2,"ram":512,"disk":20,"name":"512 server"},{"id":3,"ram":1024,"disk":40,"name":"1GB server"},{"id":4,"ram":2048,"disk":80,"name":"2GB server"},{"id":5,"ram":4096,"disk":160,"name":"4GB server"},{"id":6,"ram":8192,"disk":320,"name":"8GB server"},{"id":7,"ram":15872,"disk":620,"name":"15.5GB server"},{"id":8,"ram":30720,"disk":1200,"name":"30GB server"}]}
			
			/*@SuppressWarnings("unused")
			Gson gson = new Gson();
			Type genType = new TypeToken<Collection<String>>(){}.getType();
			
			JsonParser parser = new JsonParser();
			JsonObject obj = parser.parse(flavJSON).getAsJsonObject();
			
			JsonArray arr = obj.get("flavors").getAsJsonArray();
			
			System.out.println("RESULT: ");*/
			
			/*
			Gson gson = new Gson();
            Type genType = new TypeToken<Flavors>(){}.getType();
            
            Flavors flavors = gson.fromJson(flavJSON, genType);
            
            Type typeListaRegistros = new TypeToken<List<LinkedHashMap<String, Object>>>(){}.getType();
            List<LinkedHashMap<String, Object>> objetos = new ArrayList<LinkedHashMap<String, Object>>();
            objetos = gson.fromJson(flavJSON, typeListaRegistros);
            
            Type registrosType = new TypeToken<LinkedHashMap<String, ArrayList<Flavor>>>(){}.getType();
            LinkedHashMap<String, ArrayList<Flavor>> datosRegistro = new LinkedHashMap<String, ArrayList<Flavor>>();
            datosRegistro = gson.fromJson(flavJSON, registrosType);
            
            System.out.println("SIZE: "+datosRegistro.get("flavors").size());
            System.out.println("NAME del 0: "+datosRegistro.get("flavors").get(0).getName());
			*/
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
