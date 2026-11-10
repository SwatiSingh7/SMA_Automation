package com.morrisons.common.utility;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.utils.URIBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import com.morrisons.sma.pojo.service.PricePrompPOJO.PrinterPojo;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.Glh_WalkIdMain;

import com.morrisons.sma.step_definitions.service.old.RestAssuredSteps;
import com.morrisons.sma.step_definitions.mobile.old.MarkdownStepDef;


public class MarkdownServiceData {
	public static URI currentUri;
	static String mdLogin = null;
	public static Map<String, String> headers = new HashMap<>();
	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
	public static String mDAccessTocken;

	public static String postPayload;
	public static String printerBody;
	public static Integer EventID;
	static Response getResponse;

	public static void markdownservice()

	{
		/*
		 * RestAssured.baseURI ="https://sit-api.morrisons.com/user/v1/login";
		 * RequestSpecification request = RestAssured.given();
		 * request.header("Content-Type","application/json");
		 * request.queryParam("apikey", "ZwQGsEN0f65kORZ8EVQlJWA2bGNbHls0"); JSONObject
		 * requestParams = new JSONObject(); requestParams.put("provider", "morrisons");
		 * requestParams.put("userName", "11223344"); requestParams.put("password",
		 * "147741"); request.body(requestParams.toString()); Response response =
		 * request.post(); System.out.println(""+response.asString()); int statusCode =
		 * response.getStatusCode(); System.out.println(""+statusCode);
		 * Assert.assertEquals(statusCode, 200); String accesstoken =
		 * response.jsonPath().get("accessToken"); System.out.println(""+accesstoken);
		 * //Assert.assertEquals( "Correct Success code was returned", accesstoken,
		 * "Requested resource is not foun");
		 */}

	public static URI postLoginForMarkdown(String mdLoginBody) throws URISyntaxException {

		String baseURI = applicationConfig.getLoginServiceMarkdown().getBaseURI();
		String resource = applicationConfig.getLoginServiceMarkdown().getResource();
		String queryparameter = applicationConfig.getLoginServiceMarkdown().getQueryParameter();
		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);
		uriBuilder.setCustomQuery(queryparameter);
		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mdLogin = mdLoginBody;
		return currentUri;
	}

	/*
	 * public static URI postLoginForCnR(String mdLoginBody) throws
	 * URISyntaxException {
	 * 
	 * String baseURI = applicationConfig.getLoginServiceMarkdown().getBaseURI();
	 * 
	 * String resource = applicationConfig.getLoginServiceMarkdown().getResource();
	 * String queryparameter =
	 * applicationConfig.getLoginServiceMarkdown().getQueryParameter();
	 * 
	 * URIBuilder uriBuilder = new URIBuilder(baseURI);
	 * uriBuilder.setCustomQuery(queryparameter); currentUri = uriBuilder.build();
	 * System.out.println(currentUri); mdLogin = mdLoginBody; return currentUri;
	 * 
	 * }
	 */

	public static URI getMarkdown(String storeId, String min, String accessTocken) throws URISyntaxException {

		String baseURI = applicationConfig.getGetMarkdownService().getBaseURI();
		String resource = applicationConfig.getGetMarkdownService().getResource();
		String queryparameter = applicationConfig.getGetMarkdownService().getQueryParameter();
		resource = resource.replaceAll("\\bstoreid\\b", storeId);
		resource = resource.replaceAll("\\bitemid\\b", min);
		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);
		uriBuilder.setCustomQuery(queryparameter);
		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;
		return currentUri;

	}
	
	public static URI getScheduleCR(String storeId,String accessTocken,String weekNumber, String accessToken) throws URISyntaxException {

		String baseURI = applicationConfig.getGetSchedules().getURI();
		baseURI = baseURI.replaceAll("\\bstoreid\\b", storeId);
		baseURI = baseURI.replaceAll("\\bweekNumber\\b", weekNumber);
		URIBuilder uriBuilder = new URIBuilder(baseURI);
		
		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessToken;
		return currentUri;

	}
	
	
	
	public static URI getDepartments(String storeId,String yeaR, String weeK,String accessTocken) throws URISyntaxException {

		String baseURI = applicationConfig.getGetDepartments().getURI();
		baseURI = baseURI.replaceAll("\\bstoreid\\b", storeId);
		baseURI = baseURI.replaceAll("\\byeaR\\b", yeaR);
		baseURI = baseURI.replaceAll("\\bweeK\\b", weeK);
		URIBuilder uriBuilder = new URIBuilder(baseURI);
		
		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;
		return currentUri;

	}

	public static URI getWalkId(String storeId, String min, String accessTocken) throws URISyntaxException {

		String baseURI = applicationConfig.getGetgapLowHigh().getBaseURI();
		URIBuilder uriBuilder = new URIBuilder(baseURI);
		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;
		return currentUri;
	}

	public static URI getWalkIdDetails(String storeId, String walkid, String accessTocken) throws URISyntaxException {

		String baseURI = applicationConfig.getWalkIdDetails().getBaseURI();
		String resource = applicationConfig.getWalkIdDetails().getResource();
		String queryparameter = applicationConfig.getWalkIdDetails().getQueryParameter();
		resource = resource.replaceAll("\\bstoreid\\b", storeId);
		resource = resource.replaceAll("\\bitemid\\b", walkid);
		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);
		uriBuilder.setCustomQuery(queryparameter);
		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;
		return currentUri;
	}

	public static Response getWalkId() {
		System.out.println("token toekn = " + mDAccessTocken);
		ResponseBody code = RestAssured.given().relaxedHTTPSValidation()
				.header(new Header("Authorization", "Bearer " + mDAccessTocken)).when().get(currentUri).getBody();

		Glh_WalkIdMain getWalkId = RestAssured.given().relaxedHTTPSValidation()
				.header(new Header("Authorization", "Bearer " + mDAccessTocken)).when().get(currentUri).getBody()
				.as(Glh_WalkIdMain.class);
		System.out.println(
				"Walk ID Details are = " + getWalkId.getStoreWalkItems().get(0).getItems().get(0).getProductId());

		int status = RestAssured.given().relaxedHTTPSValidation()
				.header(new Header("Authorization", "Bearer " + mDAccessTocken)).when().get(currentUri).getStatusCode();

		System.out.println("Response Body from server " + getWalkId);
		MarkdownStepDef.getrestresponse(getWalkId, status);

		getResponse = null;

		getResponse = RestAssured.given().relaxedHTTPSValidation()
				.header(new Header("Authorization", "Bearer " + mDAccessTocken)).when().get(currentUri).then()
				.contentType(ContentType.JSON).extract().response();
		System.out.println("Response from the get =" + getResponse.asString());
		System.out.println("Response status from the get =" + getResponse.getStatusCode());

		ArrayList<String> walkid = new ArrayList<String>();
		walkid = getResponse.path("StoreWalkItems.walkid");
		System.out.println("Walk id is = " + walkid);

		return getResponse;

	}

	public static void doGetRequest() {

	}

	public static void restcall() {
		System.out.println("token toekn = " + mDAccessTocken);
		String code = RestAssured.given().relaxedHTTPSValidation()
				.header(new Header("Authorization", "Bearer " + mDAccessTocken)).when().get(currentUri).getBody()
				.asString();

		int status = RestAssured.given().relaxedHTTPSValidation()
				.header(new Header("Authorization", "Bearer " + mDAccessTocken)).when().get(currentUri).getStatusCode();

		System.out.println("Response Body from server " + code);
		MarkdownStepDef.getrestPayload(code, status);

	}

	public static URI postMarkdownEvent(String storeId, String min, String payloadParam) throws URISyntaxException {

		String baseURI = applicationConfig.getPostMarkdownEvent().getBaseURI();
		String resource = applicationConfig.getPostMarkdownEvent().getResource();
		String queryparameter = applicationConfig.getPostMarkdownEvent().getQueryParameter();
		resource = resource.replaceAll("\\bstoreid\\b", storeId);
		resource = resource.replaceAll("\\bitemid\\b", min);
		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);
		uriBuilder.setCustomQuery(queryparameter);
		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		postPayload = payloadParam;
		return currentUri;
	}

	public static URI postMarkdownPrint(String storeId, String min, String payloadParam) throws URISyntaxException {

		String baseURI = applicationConfig.getPrintServiceMarkdown().getBaseURI();
		String resource = applicationConfig.getPrintServiceMarkdown().getResource();
		String queryparameter = applicationConfig.getPrintServiceMarkdown().getQueryParameter();
		resource = resource.replaceAll("\\bstoreid\\b", storeId);
		resource = resource.replaceAll("\\bitemid\\b", min);
		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);
		uriBuilder.setCustomQuery(queryparameter);
		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		postPayload = payloadParam;
		return currentUri;
	}

	public Map<String, String> getHeaders() {

		String Header1Key = applicationConfig.getPriceServiceHeaders().getKey();
		String Header1value = applicationConfig.getPriceServiceHeaders().getValue();
		headers.put(Header1Key, Header1value);
		System.out.println(headers);
		return headers;
	}

	public static Map<String, String> getPostHeaders() {

		String Header1Key = applicationConfig.getPriceServiceHeaders().getKey();
		String Header1value = applicationConfig.getPriceServiceHeaders().getValue();
		headers.put(Header1Key, Header1value);
		headers.put("Content-Type", "application/json");
		System.out.println(headers);
		return headers;
	}

	public static Map<String, String> getPostHeadersForMarkdownEvent() {

		String Header1Key = "Authorization";
		headers.put(Header1Key, "Bearer " + mDAccessTocken);
		headers.put("Content-Type", "application/json");
		System.out.println(headers);
		return headers;
	}

	public static Map<String, String> getPostHeadersForMdLogin() {

		headers.put("Content-Type", "application/json");
		System.out.println(headers);
		return headers;
	}

	public static Map<String, String> getHeadersForMarkdown() {
		String Header1Key = "Authorization";
//		String Header1Key = applicationConfig.getPriceServiceHeaders().getKey();
		headers.put(Header1Key, "Bearer " + mDAccessTocken);
		System.out.println("Headers for markdown are - " + headers);
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

	public static HttpResponse performOperationMarkdown() throws ClientProtocolException, IOException {
		HttpResponse getResponse = null;
		getHeadersForMarkdown();
		System.out.println("URI is \t" + currentUri + "headers are\t" + headers);
		if (currentUri != null)
			getResponse = WebServiceClient.getMethodResponse(currentUri, headers);
		else {
			System.out.println("\n URL value is missing.Please send valid URL to perform operation");
		}
		return getResponse;
	}

	public static HttpResponse performPostOperation() throws ClientProtocolException, IOException {
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

	public static HttpResponse performPostOperationForMarkdownEvent() throws ClientProtocolException, IOException {
		HttpResponse getResponse = null;

		getPostHeadersForMarkdownEvent();
		System.out.println("URI is \t" + currentUri + "headers are\t" + headers);
		System.out.println("Passed Payload body is " + postPayload);
		if (currentUri != null)
			getResponse = WebServiceClient.postMethodResponse(currentUri, headers, postPayload);

		else {
			System.out.println("\n URL value is missing.Please send valid URL to perform operation");
		}
		return getResponse;
	}

	public static HttpResponse postOperationForMdLogin() throws ClientProtocolException, IOException {
		HttpResponse getResponse = null;

		getPostHeadersForMdLogin();
		System.out.println("URI is \t" + currentUri + "headers are\t" + headers);
		System.out.println("payload details is 2 = " + mdLogin);
		if (currentUri != null)
			getResponse = WebServiceClient.postMethodResponse(currentUri, headers, mdLogin);

		else {
			System.out.println("\n URL value is missing.Please send valid URL to perform operation");
		}
		return getResponse;
	}

	public static HttpResponse performPostOperationForMarkdownPrint() throws ClientProtocolException, IOException {
		HttpResponse getResponse = null;

		getPostHeadersForMarkdownEvent();
		System.out.println("URI is \t" + currentUri + " = headers are\t" + headers);
		System.out.println("Passed Payload body is " + printerBody);
		if (currentUri != null)
			getResponse = WebServiceClient.postMethodResponse(currentUri, headers, printerBody);

		else {
			System.out.println("\n URL value is missing.Please send valid URL to perform operation");
		}
		return getResponse;
	}

	public static Integer markDownEventID(Integer iD) {
		EventID = iD;
		System.out.println("Event ID Received here =" + EventID);
		return EventID;

	}

	public static URI postMarkdownPrint(String userid, String storeid)
			throws URISyntaxException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		PrinterPojo printer = new PrinterPojo();
		List<Integer> eventIds = new ArrayList<>();
		eventIds.add(EventID);
		printer.setMarkdownEventIds(eventIds);

		printer.setPrinterId("XXQPH184360260");
		printerBody = objectMapper.writeValueAsString(printer);
		System.out.println("Payload body is " + printerBody);

		String baseURI = applicationConfig.getPostMarkdownEvent().getBaseURI();
		baseURI = baseURI.replaceAll("\\bstoreid\\b", storeid);
		baseURI = baseURI.replaceAll("\\buserid\\b", userid);

		currentUri = new URI(baseURI);
		URIBuilder uriBuilder = new URIBuilder(baseURI);

		currentUri = uriBuilder.build();
		System.out.println(currentUri);

		System.out.println(currentUri);
		return currentUri;

	}

	public static URI getMarkdownRest(String storeId, String min, String accessTocken) throws URISyntaxException {

		String baseURI = applicationConfig.getGetMarkdownService().getBaseURI();
		String resource = applicationConfig.getGetMarkdownService().getResource();
		String queryparameter = applicationConfig.getGetMarkdownService().getQueryParameter();
		resource = resource.replaceAll("\\bstoreid\\b", storeId);
		resource = resource.replaceAll("\\bitemid\\b", min);
		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);
		uriBuilder.setCustomQuery(queryparameter);
		currentUri = uriBuilder.build();
		System.out.println("uri is = " + currentUri);
		RestAssuredSteps.getUrl(currentUri);
		return currentUri;
	}

	public static URI getStoreWalkId(String storeId, String min, String accessTocken) throws URISyntaxException {

		String baseURI = applicationConfig.getGetgapLowHigh().getBaseURI();
		String resource = applicationConfig.getGetgapLowHigh().getResource();
		String queryparameter = applicationConfig.getGetgapLowHigh().getQueryParameter();
		resource = resource.replaceAll("\\bstoreid\\b", storeId);
		resource = resource.replaceAll("\\bitemid\\b", min);
		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);
		uriBuilder.setCustomQuery(queryparameter);
		currentUri = uriBuilder.build();
		System.out.println("uri is = " + currentUri);
		RestAssuredSteps.getUrlGLH(currentUri);
		return currentUri;
	}

}
