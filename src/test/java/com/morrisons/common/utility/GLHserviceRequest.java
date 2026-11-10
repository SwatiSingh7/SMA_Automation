package com.morrisons.common.utility;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.utils.URIBuilder;

public class GLHserviceRequest {

	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
	public static URI currentUri;
	static String mdLogin=null;
	public static Map<String, String> headers = new HashMap<>();
	public static Map<String, String> headers1 = new HashMap<>();
	public static String token;
	
	public static URI postLoginForGLH(String mdLoginBody, String storeId) throws URISyntaxException {

		String baseURI = applicationConfig.getPostGLH().getBaseURI();
		String resource = applicationConfig.getPostGLH().getResource();
		String queryparameter = applicationConfig.getPostGLH().getQueryParameter();
		
		resource = resource.replaceAll("\\bstoreid\\b", storeId);
		
		
		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);
		uriBuilder.setCustomQuery(queryparameter);
		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mdLogin=mdLoginBody;
		return currentUri;
	}
	
	public static void getAccessTokenGLH(String accessToken){
		
		token = accessToken;
	}
	public static Map<String, String> getPostHeadersForGLH() {
		String Header1Key = "Content-Type";
		String Header1value = "application/json";
		
		String Header2Key = "Authorization";
		String Header2value = "Bearer "+token;
		headers.put(Header1Key, Header1value);
		headers.put(Header2Key, Header2value);
		System.out.println(headers);
		return headers;
	}
	
	
	public static HttpResponse postOperationForMdLogin() throws ClientProtocolException, IOException {
		HttpResponse getResponse = null;
		
		getPostHeadersForGLH();
		System.out.println("URI is \t" + currentUri + "headers are\t" + headers);
		System.out.println("payload details is = " + mdLogin);
		if (currentUri != null)
			getResponse = WebServiceClient.postMethodResponse(currentUri, headers,mdLogin);
		
		else {
			System.out.println("\n URL value is missing.Please send valid URL to perform operation");
		}
		return getResponse;
	}
}
