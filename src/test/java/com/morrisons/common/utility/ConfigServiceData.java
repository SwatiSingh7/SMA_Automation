package com.morrisons.common.utility;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.utils.URIBuilder;

public class ConfigServiceData {
	public URI currentUri;
	public Map<String, String> headers = new HashMap<>();
	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();

	public String postPayload;
	
	public URI getConfigDetails() throws URISyntaxException {

		String baseURI = applicationConfig.getGetConfigService().getBaseURI();
		String resource = applicationConfig.getGetConfigService().getResource();
		String queryparameter = applicationConfig.getGetConfigService().getQueryParameter();
		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);
		uriBuilder.setCustomQuery(queryparameter);
		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		return currentUri;
	}

	public Map<String, String> getHeaders() {

		String Header1Key = applicationConfig.getConfigServiceHeaders().getKey();
		String Header1value = applicationConfig.getConfigServiceHeaders().getValue();
		headers.put(Header1Key, Header1value);
		System.out.println(headers);
		return headers;
	}
	public Map<String, String> getPostHeaders() {

		String Header1Key = applicationConfig.getPriceServiceHeaders().getKey();
		String Header1value = applicationConfig.getPriceServiceHeaders().getValue();
		headers.put(Header1Key, Header1value);
		headers.put("Content-Type", "application/json");
		System.out.println(headers);
		return headers;
	}
	public HttpResponse performOperation() throws ClientProtocolException, IOException {
		HttpResponse getResponse = null;
		getHeaders();
		System.out.println("URI is \t" + currentUri + "headers are\t" + headers);
		if (currentUri != null)
			getResponse = WebServiceClient.getMethodResponse(currentUri, headers);
		else {
			System.out.println("\n URL value is missing.Please send valid URL to perform operation");
		}
		return getResponse;
	}

	public HttpResponse performPostOperation() throws ClientProtocolException, IOException {
		HttpResponse getResponse = null;
		
		getPostHeaders();
		System.out.println("URI is \t" + currentUri + "headers are\t" + headers);
		System.out.println("Passed Payload body is "+postPayload);
		if (currentUri != null)
			getResponse = WebServiceClient.postMethodResponse(currentUri, headers,postPayload);
		
		else {
			System.out.println("\n URL value is missing.Please send valid URL to perform operation");
		}
		return getResponse;
	}
}
