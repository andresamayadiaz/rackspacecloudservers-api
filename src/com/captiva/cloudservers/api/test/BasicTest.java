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
			// TODO: evaluar si se requiere el encoding, probar enviar un nombre de entity con acentos
			// TODO: probar el envio de metadata y que funcione
			//Server server = con.createServer("apiTest2", 112, 1);
			//System.out.println("Server ID: " + server.getId() + " Name: " + server.getName() + " adminPass: " + server.getAdminPass() + " Public IP: " + server.getAddresses().getPublic());
			
			// Reboot Server Test
			//Reboot reboot = new Reboot();
			//reboot.setType(RebootType.SOFT);
			// TODO: lanza un java.lang.Exception not a JSONObject, debugear y corregir
			//con.rebootServer(ID); // 20475981
			
			// Rebuild Server Test
			// TODO: no se probo correctamente la funcionalidad
			//Integer serverId = 20475981;
			//Integer imageId = 112; // Se puede omitir y lo regenera con su misma imagen
			//con.rebuildServer(serverId);
			
			// Resize Server Test
			//Integer serverId = 20475981;
			//Integer flavorId = 1;
			//con.resizeServer(serverId, flavorId);
			
			// Confirm Resize Server Test
			//Integer serverId = 20475981;
			//con.confirmResize(serverId);
			
			// Revert Resize Server
			//Integer serverId = 20475981;
			//con.revertResize(serverId);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
