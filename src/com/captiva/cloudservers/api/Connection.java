package com.captiva.cloudservers.api;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.HostnameVerifier;

import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.entity.EntityTemplate;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HttpContext;

import com.captiva.cloudservers.api.common.Flavor;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

@SuppressWarnings("deprecation")
public class Connection {

	private int maxRetries = 5;
    private String userAgent = "Elastic-Grid/";
    private HttpClient hc = null;
    private int maxConnections = 100;
    private String proxyHost = null;
    private int proxyPort;
    private int connectionManagerTimeout = 0;
    private int soTimeout = 0;
    private int connectionTimeout = 0;

    private final String username;
    private final String apiKey;
    private String serverManagementURL;
    private String storageURL;
    private String cdnManagementURL;
    private String authToken;
    
    private boolean authenticated = false;
    
    private static final String API_AUTH_URL = "https://auth.api.rackspacecloud.com/v1.0";
    
    private static final Logger logger = Logger.getLogger(Connection.class.getName());
    
    public Connection(String username, String apiKey) throws Exception{
    	this.username = username;
    	this.apiKey = apiKey;
    	
    	authenticate();
    }
	
    public String authenticate() throws Exception {
        logger.info("Authenticating to Rackspace API...");
        
        HttpGet request = new HttpGet(API_AUTH_URL);
        request.addHeader("X-Auth-User", username);
        request.addHeader("X-Auth-Key", apiKey);
        try{
        	
        	HttpResponse response = getHttpClient().execute(request);
        	int statusCode = response.getStatusLine().getStatusCode();
	        switch (statusCode) {
	            case 204:
	                if (response.getFirstHeader("X-Server-Management-Url") != null)
	                    serverManagementURL = response.getFirstHeader("X-Server-Management-Url").getValue();
	                if (response.getFirstHeader("X-Storage-Url") != null)
	                    storageURL = response.getFirstHeader("X-Storage-Url").getValue();
	                if (response.getFirstHeader("X-CDN-Management-Url") != null)
	                    cdnManagementURL = response.getFirstHeader("X-CDN-Management-Url").getValue();
	                authToken = response.getFirstHeader("X-Auth-Token").getValue();
	                authenticated = true;
	                logger.log(Level.INFO, "Correct Authentication");
	                return authToken;
	            case 401:
	                throw new Exception("Invalid credentials: " + response.getStatusLine().getReasonPhrase());
	            default:
	                throw new Exception("Unexpected HTTP response");
	        }
        } catch(javax.net.ssl.SSLException ex){
        	throw new Exception(ex.toString());
        }
    }
    
    private void configureHttpClient() {
        HttpParams params = new BasicHttpParams();

        HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(params, "UTF-8");
        HttpProtocolParams.setUserAgent(params, userAgent);
        HttpProtocolParams.setUseExpectContinue(params, true);

        HostnameVerifier hostnameVerifier = org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;
        SSLSocketFactory socketFactory = SSLSocketFactory.getSocketFactory();
        socketFactory.setHostnameVerifier((X509HostnameVerifier) hostnameVerifier);
        
//        params.setBooleanParameter("http.tcp.nodelay", true);
//        params.setBooleanParameter("http.coonection.stalecheck", false);
        ConnManagerParams.setTimeout(params, connectionManagerTimeout);
        ConnManagerParams.setMaxTotalConnections(params, maxConnections);
        ConnManagerParams.setMaxConnectionsPerRoute(params, new ConnPerRouteBean(maxConnections));
        params.setIntParameter("http.socket.timeout", soTimeout);
        params.setIntParameter("http.connection.timeout", connectionTimeout);
        
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", socketFactory, 443));
        ClientConnectionManager connMgr = new ThreadSafeClientConnManager(params, schemeRegistry);
        hc = new DefaultHttpClient(connMgr, params);
        
        ((DefaultHttpClient) hc).addRequestInterceptor(new HttpRequestInterceptor() {
            public void process(HttpRequest request, HttpContext context) throws HttpException, IOException {
            	// aad
                /*if (!request.containsHeader("Accept-Encoding")) {
                    request.addHeader("Accept-Encoding", "gzip");
                }*/
            }
        });
        ((DefaultHttpClient) hc).addResponseInterceptor(new HttpResponseInterceptor() {
            public void process(HttpResponse response, HttpContext context) throws HttpException, IOException {
                HttpEntity entity = response.getEntity();
                if (entity == null)
                    return;
                Header ceHeader = entity.getContentEncoding();
                if (ceHeader != null) {
                    for (HeaderElement codec : ceHeader.getElements()) {
                        if (codec.getName().equalsIgnoreCase("gzip")) {
                            response.setEntity(response.getEntity());
                            return;
                        }
                    }
                }
            }
        });

        if (proxyHost != null) {
            HttpHost proxy = new HttpHost(proxyHost, proxyPort);
            hc.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);
            logger.info("Proxy Host set to " + proxyHost + ":" + proxyPort);
        }
    }
    
    protected HttpClient getHttpClient() {
        if (hc == null) {
            configureHttpClient();
        }
        return hc;
    }
    
    public String getAuthToken() {
        return authToken;
    }
    
    public String getServerManagementURL(){
    	return serverManagementURL;
    }
    
    public void setHttpClient(HttpClient hc) {
        this.hc = hc;
    }
    
    protected <T> T makeRequest(HttpRequestBase request, Class<T> respType)
            throws Exception {
    	
        if (!authenticated)
            authenticate();
        
        // add auth params, and protocol specific headers
        request.addHeader("X-Auth-Token", getAuthToken());
        
        // set accept and content-type headers
        request.setHeader("Accept", "application/json; charset=UTF-8");
        //request.setHeader("Accept-Encoding", "gzip");
        request.setHeader("Content-Type", "application/json; charset=UTF-8");
        
        // send the request
        T result = null;
        boolean done = false;
        int retries = 0;
        boolean doRetry = false;
        Exception error = null;
        do {
            HttpResponse response = null;
            if (retries > 0)
                logger.log(Level.INFO, "Retry #{0}: querying via {1} {2}",
                        new Object[]{retries, request.getMethod(), request.getURI()});
            else
                logger.log(Level.INFO, "Querying via {0} {1}", new Object[]{request.getMethod(), request.getURI()});
            	
            if (logger.isLoggable(Level.FINEST) && request instanceof HttpEntityEnclosingRequestBase) {
                HttpEntity entity = ((HttpEntityEnclosingRequestBase) request).getEntity();

                if (entity instanceof EntityTemplate) {
                    EntityTemplate template = (EntityTemplate) entity;
                    ByteArrayOutputStream baos = null;
                    try {
                        baos = new ByteArrayOutputStream();
                        template.writeTo(baos);
                        logger.log(Level.FINEST, "Request body:\n{0}", baos.toString());
                    } finally {
                        IOUtils.closeQuietly(baos);
                    }
                }
            }
            
            InputStream entityStream = null;
            HttpEntity entity = null;
            
            if (logger.isLoggable(Level.FINEST)) {
                response = getHttpClient().execute(request);
                entity = response.getEntity();
                try {
                    entityStream = entity.getContent();
                    logger.log(Level.FINEST, "Response body on " + request.getURI()
                            + " via " + request.getMethod() + ":\n" + IOUtils.toString(entityStream));
                } finally {
                    IOUtils.closeQuietly(entityStream);
                }
            }
            
            response = getHttpClient().execute(request);
            int statusCode = response.getStatusLine().getStatusCode();
            entity = response.getEntity();
            
            switch (statusCode) {
                case 200:
                case 202:
                case 203:
                    try {
                    	// Validate not null response
                    	if(!entity.getContent().toString().isEmpty()){
                    		
	                        entityStream = entity.getContent();
	                        JsonParser parser = new JsonParser();
	            			String ent = IOUtils.toString(entityStream);
	                        logger.log(Level.INFO, ">>> case 203 Entity: {0}", ent);
	                        JsonObject obj = parser.parse(ent).getAsJsonObject();
	                        result = (T) obj;
                        
                    	} else {
                    		logger.log(Level.INFO, ">>> case 203 Entity: NULL Response");
                    	}
 
                    } finally {
                        entity.consumeContent();
                        IOUtils.closeQuietly(entityStream);
                    }
                    done = true;
                    break;
                case 503:   // service unavailable
                    logger.log(Level.WARNING, "Service unavailable on {0} via {1}. Will retry in {2} seconds.",
                            new Object[]{request.getURI(), request.getMethod(), Math.pow(2.0, retries + 1)});
                    doRetry = true;
                    break;
                case 401:   // unauthorized
                    logger.warning("Not authenticated or authentication token expired. Authenticating...");
                    authenticate();
                    doRetry = true;
                    break;
                case 417:
                    throw new Exception(new IllegalArgumentException("Some parameters are invalid!")); // TODO: temp hack 'til Rackspace API is fixed!
                case 409:
                	entityStream = entity.getContent();
                    logger.log(Level.INFO, ">>> case 409 Entity: {0}", IOUtils.toString(entityStream));
                    done = true;
                    throw new Exception("Can't Accomplish Requested Action");
                case 400:
                case 500:
                default:
                    try {
                        entityStream = entity.getContent();
                        logger.log(Level.INFO, ">>> case default Entity: {0}", IOUtils.toString(entityStream));
                        done = true;
                        throw new Exception("case default");
                    } finally {
                        entity.consumeContent();
                        IOUtils.closeQuietly(entityStream);
                    }
            }

            if (doRetry) {
                retries++;
                if (retries > maxRetries) {
                    throw new HttpException("Number of retries exceeded for " + request.getURI(), error);
                }
                doRetry = false;
                try {
                    Thread.sleep((int) Math.pow(2.0, retries) * 1000);
                } catch (InterruptedException ex) {
                    // do nothing
                }
            }
        } while (!done);

        return result;
    }
    
    
}
