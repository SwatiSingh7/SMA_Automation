package com.morrisons.sma.pojo.service.StockAdjustmentServicePojo;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import com.morrisons.common.utility.WebServiceClient;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class StockAdjustmentServiceData {

	public URI currentUri;
	public Map<String, String> headers = new HashMap<>();
	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();

	// public String postPayload;

	public URI getStockAdjustment(String storeId, String min) throws URISyntaxException {

		String baseURI = applicationConfig.getGetStockAdjustment().getURI();
		baseURI = baseURI.replaceAll("\\bstoreId\\b", storeId);
		baseURI = baseURI.replaceAll("\\bitemId\\b", min);
		currentUri = new URI(baseURI);
		System.out.println(currentUri);
		return currentUri;
	}

	public Map<String, String> getHeaders() {

		String Header1Key = applicationConfig.getStockAdjustmentServiceHeaders().getKey();
		String Header1value = applicationConfig.getStockAdjustmentServiceHeaders().getValue();
		headers.put(Header1Key, Header1value);
		System.out.println(headers);
		return headers;
	}

	public HttpResponse performGetOperation() throws ClientProtocolException, IOException {
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

}
