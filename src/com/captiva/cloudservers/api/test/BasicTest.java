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
			
			Client con = new Client("andresamaya", "");
			
			// List Flavors Test
			//List<Flavor> flavors = con.getFlavors();
			
			// Get Flavor Details Test
			//Flavor flavor = con.getFlavorDetails(2);
			
			// List Images Test
			//List<Image> images = con.getImages();
			
			// Get Image Details Test
			//Image image = con.getImageDetails(112);
			
			// Servers List Test
			//List<Server> servers = con.getServers();
			
			// Server Details Test
			//Server server = con.getServerDetails(servers.get(0).getId());
			
			// Server Create Server Test
			// TODO: evaluar si se requiere el encoding, probar enviar un nombre de entity con acentos
			// TODO: probar el envio de metadata y que funcione
			//Server server = con.createServer("apiTest3", 112, 1);
			//System.out.println("Server ID: " + server.getId() + " Name: " + server.getName() + " adminPass: " + server.getAdminPass() + " Public IP: " + server.getAddresses().getPublic());
			
			// Reboot Server Test
			//Reboot reboot = new Reboot();
			//reboot.setType(RebootType.SOFT);
			// TODO: lanza un java.lang.Exception not a JSONObject, debugear y corregir
			//con.rebootServer(ID); // 20475981
			
			// Rebuild Server Test
			// TODO: no se probo
			//Integer serverId = 20475981;
			//Integer imageId = 112; // Se puede omitir y lo regenera con su misma imagen
			//con.rebuildServer(serverId);
			
			// Delete Server Test
			// TODO: no se probo
			//Integer serverId = 20475981;
			////con.deleteServer(serverId);
			
			// Resize Server Test
			//Integer serverId = 20475981;
			//Integer flavorId = 1;
			//con.resizeServer(serverId, flavorId);
			
			// Confirm Resize Server Test
			// TODO: no se probo
			//Integer serverId = 20475981;
			//con.confirmResize(serverId);
			
			// Revert Resize Server
			// TODO: no se probo
			//Integer serverId = 20475981;
			//con.revertResize(serverId);
			
			// Update Server Name
			// TODO falla al retornar la llamada vacia
			//Integer serverId = 20479120;
			//con.updateServerName(serverId, "NewName");
			
			// Update Server Password
			// Server ID: 20479120 Name: apiTest3 adminPass: apiTest35q77vQNSm Public IP: 108.166.124.232
			//Integer serverId = 20479120;
			//con.updateServerPassword(serverId, "ceis12345");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
