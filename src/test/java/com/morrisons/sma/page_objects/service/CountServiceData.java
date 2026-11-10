package com.morrisons.sma.page_objects.service;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.utils.URIBuilder;

import io.restassured.response.Response;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import com.morrisons.common.utility.WebServiceClient;

public class CountServiceData {

	public static URI currentUri;
	static String mdLogin=null;
	public static Map<String, String> headers = new HashMap<>();
	public static Map<String, String> headers1 = new HashMap<>();
	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
	public static String mDAccessTocken;
	public static String postPayload;
	public static String printerBody;
	public static Integer EventID;
	static Response getResponse;
	public static String token;
	
	public static URI postLoginForCount(String mdLoginBody,String storeID) throws URISyntaxException {

		String baseURI = applicationConfig.getCountDetails().getBaseURI();
		String resource = applicationConfig.getCountDetails().getResource();
		String queryparameter = applicationConfig.getCountDetails().getQueryParameter();
		resource = resource.replaceAll("\\bstoreId\\b", storeID);
		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);
		uriBuilder.setCustomQuery(queryparameter);
		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mdLogin=mdLoginBody;
		return currentUri;
	}
	
	public static URI deleteCount(String storeId, String walkId) throws URISyntaxException {
		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getDeleteCounts().getResource();
		resource = resource.replaceAll("\\bstoreId\\b", storeId);
		resource = resource.replaceAll("\\bwalkId\\b", walkId);
		
		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);
		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		
		return currentUri;
	}
	
	
	
	public static Map<String, String> getPostHeadersForCount() {
		String Header1Key = "Content-Type";
		String Header1value = "application/json";
		
		String Header2Key = "Authorization";
		String Header2value = "Bearer "+token;
		headers.put(Header1Key, Header1value);
		headers.put(Header2Key, Header2value);
		System.out.println(headers);
		return headers;
	}
	
	public static void getAccessToken(String accessToken){
		
		token = accessToken;
	}
	
	public static HttpResponse postOperationForCount() throws ClientProtocolException, IOException {
		HttpResponse getResponse = null;
		
		getPostHeadersForCount();
		System.out.println("URI is \t" + currentUri + "headers are\t" + headers);
		System.out.println("payload details is = " + mdLogin);
		if (currentUri != null)
			getResponse = WebServiceClient.postMethodResponse(currentUri, headers,mdLogin);
		
		else {
			System.out.println("\n URL value is missing.Please send valid URL to perform operation");
		}
		return getResponse;
	}
	
	public static Map<String, String> deletCounts() {

		String Header1Key = "Authorization";

		headers1.put(Header1Key,"Basic VmdmUFhFWnhqTUR1ZGdKQUF6V1p3MENVb21BdXpKS0I6RXlhdXFJMGx2Tm1SQlJYQQ==");
		System.out.println("Headers for markdown are - "+headers);
		return headers1;
	}
	
	
	public static HttpResponse deleteOperationCounts() throws ClientProtocolException, IOException {
		HttpResponse getResponse = null;
		
		deletCounts();
		System.out.println("URI is \t" + currentUri + "headers1 are\t" + headers1);	
		if (currentUri != null)
			getResponse = WebServiceClient.deleteMethod(currentUri, headers1);
		
		else {
			System.out.println("\n URL value is missing.Please send valid URL to perform operation");
		}
		return getResponse;
	}
}
