package com.morrisons.common.utility;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.utils.URIBuilder;

/*import com.morrisons.automation.common.config.ApplicationConfig;
import com.morrisons.automation.common.service.ConfigLoader;
import com.morrisons.automation.common.utils.WebServiceClient;*/

public class PriceServiceData {
	public URI currentUri;
	public Map<String, String> headers = new HashMap<>();
	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
	// String date1;

	public String postPayload;

	public URI getCurrentEndURI(String storeID, String productId) throws URISyntaxException {

		String baseURI = applicationConfig.getGetCurrentPrice().getURI();
		baseURI = baseURI.replaceAll("\\bstoreid\\b", storeID);
		baseURI = baseURI.replaceAll("\\bitemid\\b", productId);

		currentUri = new URI(baseURI);
		System.out.println(currentUri);
		// date1 = date;
		return currentUri;
	}

	public URI getOnDateEndURI(String storeID, String productId, String date) throws URISyntaxException {

		String baseURI = applicationConfig.getGetOnDatePrice().getURI();
		baseURI = baseURI.replaceAll("\\bstoreid\\b", storeID);
		baseURI = baseURI.replaceAll("\\bitemid\\b", productId);
		baseURI = baseURI.replaceAll("\\binputDate\\b", date);
		currentUri = new URI(baseURI);
		System.out.println(currentUri);
		return currentUri;
	}

	public URI getPriceHistory(String storeID, String productId, String sinceDate, String untilDate)
			throws URISyntaxException {

		String baseURI = applicationConfig.getGetPriceHistory().getURI();
		baseURI = baseURI.replaceAll("\\bstoreid\\b", storeID);
		baseURI = baseURI.replaceAll("\\bitemid\\b", productId);
		baseURI = baseURI.replaceAll("\\binputSince\\b", sinceDate);
		baseURI = baseURI.replaceAll("\\binputUntil\\b", untilDate);
		currentUri = new URI(baseURI);
		System.out.println(currentUri);
		return currentUri;
	}

	public URI getPriceChangeDetails(String storeID, String productId, String date) throws URISyntaxException {

		String baseURI = applicationConfig.getGetPriceChangeDetails().getURI();
		baseURI = baseURI.replaceAll("\\bstoreid\\b", storeID);
		baseURI = baseURI.replaceAll("\\bitemid\\b", productId);
		baseURI = baseURI.replaceAll("\\binputDate\\b", date);
		currentUri = new URI(baseURI);
		System.out.println(currentUri);
		return currentUri;

	}

	// public URI getPriceChangeDetailsWithOnDate(String storeID, String
	// productId, String date)
	// throws URISyntaxException {
	//
	// String baseURI = applicationConfig.getGetPriceChangeDetails().getURI();
	// baseURI = baseURI.replaceAll("\\bstoreid\\b", storeID);
	// baseURI = baseURI.replaceAll("\\bitemid\\b", productId);
	// currentUri = new URI(baseURI);
	// System.out.println(currentUri);
	// return currentUri;
	//
	// }

	public URI getPriceHistoryBFF(String storeID, String productId) throws URISyntaxException {

		String baseURI = applicationConfig.getGetPriceHistoryForBFF().getURI();
		baseURI = baseURI.replaceAll("\\bstoreid\\b", storeID);
		baseURI = baseURI.replaceAll("\\bitemid\\b", productId);
		currentUri = new URI(baseURI);
		System.out.println(currentUri);
		return currentUri;
	}

	public URI getPriceOnDateEndURI(String storeID, String onDate) throws URISyntaxException {

		String baseURI = applicationConfig.getGetPriceOndateNewEndPoint().getURI();
		baseURI = baseURI.replaceAll("\\bstoreid\\b", storeID);
		baseURI = baseURI.replaceAll("\\binputDate\\b", onDate);
		currentUri = new URI(baseURI);
		System.out.println(currentUri);
		return currentUri;
	}

	public URI getPriceWithoutOnDateEndURI(String storeID) throws URISyntaxException {

		String baseURI = applicationConfig.getGetPriceNewEndPointWithoutOnDate().getURI();
		baseURI = baseURI.replaceAll("\\bstoreid\\b", storeID);
		currentUri = new URI(baseURI);
		System.out.println(currentUri);
		return currentUri;
	}

	public URI postPriceV2service(String storeId, String min, String payloadParam) throws URISyntaxException {

		String baseURI = applicationConfig.getPostPricev2Service().getBaseURI();
		String resource = applicationConfig.getPostPricev2Service().getResource();
		String queryparameter = applicationConfig.getPostPricev2Service().getQueryParameter();
		resource = resource.replaceAll("\\bstoreid\\b", storeId);
		resource = resource.replaceAll("\\bitemid\\b", min);
		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);
		uriBuilder.setCustomQuery(queryparameter);
		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		postPayload = payloadParam;
		return currentUri;
	}
	
	public URI getPriceChangeDetails(String storeID, String productId) throws URISyntaxException {

		String baseURI = applicationConfig.getGetPriceChangeDetails().getURI();
		baseURI = baseURI.replaceAll("\\bstoreid\\b", storeID);
		baseURI = baseURI.replaceAll("\\bitemid\\b", productId);
		currentUri = new URI(baseURI);
		System.out.println(currentUri);
		return currentUri;

		}

	public URI getPriceEventSince(String storeID, String productId, String eventId) throws URISyntaxException {
		String baseURI = applicationConfig.getGetPriceEvent().getURI();
		baseURI = baseURI.replaceAll("\\bstoreid\\b", storeID);
		baseURI = baseURI.replaceAll("\\bitemid\\b", productId);
		baseURI = baseURI.replaceAll("\\binputEventId\\b", eventId);
		currentUri = new URI(baseURI);
		System.out.println(currentUri);
		return currentUri;
	}
	
	public URI getPriceWithDate(String storeID, String productId, String sinceDate, String untilDate)
			throws URISyntaxException {

		String baseURI = applicationConfig.getGetPriceWithDate().getURI();
		baseURI = baseURI.replaceAll("\\bstoreid\\b", storeID);
		baseURI = baseURI.replaceAll("\\bitemid\\b", productId);
		baseURI = baseURI.replaceAll("\\binputSince\\b", sinceDate);
		baseURI = baseURI.replaceAll("\\binputUntil\\b", untilDate);
		currentUri = new URI(baseURI);
		System.out.println(currentUri);
		return currentUri;
	}

	public Map<String, String> getHeaders() {

		String Header1Key = applicationConfig.getPriceServiceHeaders().getKey();
		String Header1value = applicationConfig.getPriceServiceHeaders().getValue();
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
		System.out.println("Passed Payload body is " + postPayload);
		if (currentUri != null)
			getResponse = WebServiceClient.postMethodResponse(currentUri, headers, postPayload);

		else {
			System.out.println("\n URL value is missing.Please send valid URL to perform operation");
		}
		return getResponse;
	}
}
