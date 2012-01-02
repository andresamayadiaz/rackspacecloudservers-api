package com.captiva.cloudservers.api;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.captiva.cloudservers.api.common.*;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ContentProducer;
import org.apache.http.entity.EntityTemplate;


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
        Flavors response = makeRequestInt(request, Flavors.class); // Flavors.class
        List<Flavor> flavors = new ArrayList<Flavor>(response.getFlavors().size());
        for (Flavor flavor : response.getFlavors())
            flavors.add(buildFlavor(flavor));
        return flavors;
    }

    private Flavor buildFlavor(Flavor response) {
        return new Flavor(response.getId(), response.getName(), response.getRam(), response.getDisk());
    }
	
	protected <T> T makeEntityRequestInt(HttpEntityEnclosingRequestBase request, final Object entity, Class<T> respType) throws Exception {
        request.setEntity(new EntityTemplate(new ContentProducer() {
            public void writeTo(OutputStream output) throws IOException {
                try {
                    /*IBindingFactory bindingFactory = BindingDirectory.getFactory(entity.getClass());
                    final IMarshallingContext marshallingCxt = bindingFactory.createMarshallingContext();
                    marshallingCxt.marshalDocument(entity, "UTF-8", true, output);*/
                	logger.log(Level.INFO, ">>> makeEntityRequestInt Entity: {0}", entity.toString());
                	
                } catch (Exception e) {
                    IOException ioe = new IOException("Can't marshal server details");
                    ioe.initCause(e);
                    e.printStackTrace();
                    throw ioe;
                }
            }
        }));
        return makeRequestInt(request, respType);
    }

    protected void makeRequestInt(HttpRequestBase request) throws Exception {
        makeRequestInt(request, Void.class);
    }

    protected <T> T makeRequestInt(HttpRequestBase request, Class<T> respType) throws Exception {
        try {
            return makeRequest(request, respType);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
	
}
