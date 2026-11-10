package com.morrisons.sma.page_objects.service;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TimeZone;
import java.util.TreeMap;

import com.morrisons.common.utility.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.utils.URIBuilder;
import org.testng.Assert;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.android.AndroidDriver;
import com.morrisons.sma.page_objects.mobile.old.MarkDownPO;
import com.morrisons.sma.pojo.service.MarkdownPOJO.MarkdownLoginVo;
import com.morrisons.sma.pojo.service.MarkdownPOJO.Markdown_Blueyonder;
import com.morrisons.sma.pojo.service.MarkdownPOJO.Markdown_Error;
import com.morrisons.sma.pojo.service.MarkdownPOJO.Markdown_GetList;
import com.morrisons.sma.pojo.service.MarkdownPOJO.Markdown_GetListRoot;
import com.morrisons.sma.pojo.service.MarkdownPOJO.Markdown_GetMarkdownRoot;
import com.morrisons.sma.pojo.service.MarkdownPOJO.Markdown_MarkdownCap;
import com.morrisons.sma.pojo.service.MarkdownPOJO.Markdown_MarkdownPercentage;
import com.morrisons.sma.pojo.service.MarkdownPOJO.Markdown_OptimisedPrice;
import com.morrisons.sma.pojo.service.MarkdownPOJO.Markdown_Price;
import com.morrisons.sma.pojo.service.MarkdownPOJO.Markdown_Product;
import com.morrisons.sma.pojo.service.MarkdownPOJO.Markdown_UnprintedMarkdownEvent;

public class MarkdownServicePages {
	public static Map<String, String> headers = new HashMap<>();
	static ObjectMapper objectMapper = new ObjectMapper();
	public static HttpResponse Response;
	public static io.restassured.response.Response restResponse;
	static String mdStorewalk = null;
	private static AndroidDriver driveR;
	MarkdownLoginVo mDLoginJsonResp = new MarkdownLoginVo();
	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();

	static String accessTocken;
	String tokenaccess;
	String env = applicationConfig.getWebElementEnviroment().getEnv();
	public static String mDAccessTocken;
	static String mdLogin = null;
	public static URI currentUri;
	private static CloseableHttpClientBuilder cc = new CloseableHttpClientBuilder();

	private static Markdown_GetMarkdownRoot markdown_GetMarkdownRootJsonResp = new Markdown_GetMarkdownRoot();
	private static Markdown_Blueyonder markdown_Blueyonder = new Markdown_Blueyonder();
	public static Markdown_GetListRoot markdown_GetListRoot = new Markdown_GetListRoot();
	public static String expectedDateeee = null;
	public static String exepctedTimee = null;
	public static String expectedNextDate = null;

	/// Get Markdown details
	public static String minIdentifier = null;
	public static String barcode = null;
	public static String productName = null;
	public static String productDescription = null;
	public static String currentSellingPrice = null;
	public static String minimumSellingPrice = null;
	public static String maximumSellingPrice = null;
	public static String isPriceOptimisationApplicable = null;
	public static String departmentId = null;
	public static String categoryId = null;
	public static int blueYonderResponseCodeE = 0;
	public static int markdownDetailsResponseCodeE = 0;
	public static String sellingUnitOfMeasure = null;
	public static String priceEditable = null;
	public static String multipleEventsAllowed = null;
	public static String isRestrictedDepartment = null;
	public static String firstMarkdownWindow = null;
	public static String eventId = null;
	public static String markedDownPrice = null;
	public static String percentageMarkdown = null;
	public static String quantity = null;
	public static String markdownBarcode = null;
	public static String optimisedPricePercentage = null;
	public static String unprintedOptimisedPriceMarkdownPrice = null;
	public static float optimisedPriceMarkdownPrice;
	public static String markdownOptimizedPrice;
	public static String calculatedOptimizedMarkdownPrice = null;
	public static String optimisedPriceQuantity = null;
	public static String unitOfMeasure = null;
	public static String isComplete = null;
	public static String isOptimisedPriceUsed = null;
	public static String optimisedPriceApplicable = null;
	public static String byRecommendedPrice = null;
	public static String markdownSequence = null;
	public static String percentageCap = null;
	public static String markdownPercentageee = null;
	public static String markdownPrice = null;
	public static String colleagueApplicable = null;
	public static String isDefault = null;
	public static int markdownCode = 0;

	//// Get Blueyonder service
	public static String blueyonder_LocationID = null;
	public static String blueyonder_ProductID = null;
	public static String blueyonder_ValidFrom = null;
	public static String blueyonder_CurrentPrice = null;
	public static String blueyonder_Price = null;
	public static String blueyonder_Currency = null;
	public static String blueyonder_MarkdownPercentage = null;
	public static String blueyonder_expirationDate = null;

	private ApplicationContext applicationContext = new ApplicationContext();
	StorewalkServicePage storewalkServicePage;

	public static Map<String,String> markdownPercentageService = new TreeMap<String,String>();

	public String getGeneratedAccessTokenAppLogin() throws Throwable {
		String mdAccessToken = storewalkServicePage.getGeneratedAccessTokenAppLogin();
		accessTocken = mdAccessToken;

		return accessTocken;
	}

	public static Map<String, String> headerBasic() {
		String Header1Key = "Authorization";

		headers.put(Header1Key, "Basic VmdmUFhFWnhqTUR1ZGdKQUF6V1p3MENVb21BdXpKS0I6RXlhdXFJMGx2Tm1SQlJYQQ==");
		System.out.println("Headers and access token  - " + headers);

		return headers;
	}

	public static Map<String, String> headerForGetService() {
		String Header1Key = "Authorization";
		headers.clear();
		headers.put(Header1Key, "Bearer " + accessTocken);
		System.out.println("Headers and access token - " + headers);
		return headers;
	}

	public static Map<String, String> headerForPostService() {

		String Header1Key = "Authorization";
		headers.put(Header1Key, "Bearer " + accessTocken);
		headers.put("Content-Type", "application/json");
		System.out.println(headers);
		return headers;
	}

	public static Map<String, String> headerForBlueyonderService() {

		headers.put("Authorization", "Basic dGVzdC5hcGlAbW9ycmlzb25zLmJsdWUteW9uZGVyLmNvbTpqb294MURlYiFwZWVwNUlwaA==");
		headers.put("Accept", "application/com.blue-yonder.realtime_prices-v2.0.0+json");
		System.out.println("Headers and access token - " + headers);
		return headers;
	}

	public static Map<String, String> headerForPatchService() {

		String Header1Key = "Authorization";
		// headers.put("Accept", "application/json, application/xml");
		headers.put("Content-Type", "application/json");
		headers.put(Header1Key, "Bearer " + accessTocken);
		System.out.println(headers);
		return headers;
	}

	public static HttpResponse getServicePerformOperation() throws ClientProtocolException, IOException {
		headers = headerForGetService();
		System.out.println("URI is \t" + currentUri + "headers are\t" + headers);
		if (currentUri != null)
			Response = WebServiceClient.getMethodResponse(currentUri, headers);
		else {
			System.out.println("\n URL value is missing.Please send valid URL to perform operation");
		}
		return Response;
	}

	public static HttpResponse postServicePerformOperation() throws ClientProtocolException, IOException {
		headers = headerForPostService();
		System.out.println("URI is \t" + currentUri + "headers are\t" + headers);
		System.out.println("payload details is 2 = " + mdStorewalk);
		if (currentUri != null)
			Response = WebServiceClient.postMethodResponse(currentUri, headers, mdStorewalk);

		else {
			System.out.println("\n URL value is missing.Please send valid URL to perform operation");
		}
		return Response;
	}

	public static HttpResponse deleteServicePerformOperation() throws ClientProtocolException, IOException {
		headers = headerBasic();
		System.out.println("URI is \t" + currentUri + "headers are\t" + headers);
		if (currentUri != null)
			Response = WebServiceClient.deleteMethod(currentUri, headers);

		else {
			System.out.println("\n URL value is missing.Please send valid URL to perform operation");
		}
		return Response;
	}

	public static HttpResponse patchServicePerformOperation() throws ClientProtocolException, IOException {
		headers = headerForPatchService();
		System.out.println("URI is \t" + currentUri + "headers are\t" + headers);
		String uri = currentUri.toString();
		System.out.println("payload details is 2 = " + mdStorewalk);
		if (currentUri != null)
			// Response = WebServiceClient.patchMethod(currentUri, headers,
			// mdStorewalk);
			Response = WebServiceClient.sendPATCH(uri, headers, mdStorewalk);

		else {
			System.out.println("\n URL value is missing.Please send valid URL to perform operation");
		}
		return Response;
	}

	public static HttpResponse getBlueyonderPerformOperation() throws ClientProtocolException, IOException {
		headers = headerForBlueyonderService();
		System.out.println("URI is \t" + currentUri + "headers are\t" + headers);
		if (currentUri != null)
			Response = WebServiceClient.getMethodResponse(currentUri, headers);
		else {
			System.out.println("\n URL value is missing.Please send valid URL to perform operation");
		}
		return Response;
	}

	public static HttpResponse deleteMethod(URI currentUri, Map<String, String> headerMap)
			throws ClientProtocolException, IOException {

		HttpClient client = cc.build();
		HttpDelete deleteRequest = new HttpDelete(currentUri);
		String headerKey = "";
		String headerValue = "";

		Iterator entries = headerMap.entrySet().iterator();
		while (entries.hasNext()) {
			Map.Entry entry = (Map.Entry) entries.next();
			headerKey = (String) entry.getKey();
			headerValue = (String) entry.getValue();
			System.out.println("Key = " + headerKey + ", Value = " + headerValue);
			deleteRequest.addHeader(headerKey, headerValue);
		}

		HttpResponse response = client.execute(deleteRequest);

		return response;
	}

	///// Get - Get Markdown Details url after scan
	public void getMarkdownDetailsUrl(String storeID, String productID, String accessTocken)
			throws URISyntaxException, InterruptedException, ClientProtocolException, IOException {

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getGetMarkdownDetails().getResource();
		resource = resource.replaceAll("\\bstoreid\\b", storeID);
		resource = resource.replaceAll("\\bitemid\\b", productID);

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;

		Thread.sleep(500);
	}

	///// Get - Get Markdown Details url before scan
	public void getMarkdownDetailsUrlBeforeItemScan(String storeID, String productID, String accessTocken)
			throws URISyntaxException, InterruptedException, ClientProtocolException, IOException {

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getGetMarkdownDetailsBeforeScan().getResource();
		resource = resource.replaceAll("\\bstoreid\\b", storeID);
		resource = resource.replaceAll("\\bitemid\\b", productID);

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;

		Thread.sleep(500);
	}

	///// Get - Get Markdown Details service response before scanning product
	public static void getMarkdownDetailsServiceBeforeScan() throws Throwable {

		System.out.println(Response);
		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("Get Markdown details response : " + responseCode);

		int responseCodeE = 200;

		if (responseCodeE == 200 || responseCodeE == 201) {
			objectMapper.setSerializationInclusion(Include.NON_NULL);
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			markdown_GetMarkdownRootJsonResp = objectMapper.readValue(Response.getEntity().getContent(),
					Markdown_GetMarkdownRoot.class);
			String ProductJSONresult1 = objectMapper.writerWithDefaultPrettyPrinter()
					.writeValueAsString(markdown_GetMarkdownRootJsonResp);

			System.out.println("GetMarkdown details Response:\n" + ProductJSONresult1);

			Markdown_Product markdown_Product = markdown_GetMarkdownRootJsonResp.getProduct();

			minIdentifier = markdown_Product.getMinIdentifier();
			System.out.println("Min indentifier : " + minIdentifier);
			barcode = markdown_Product.getBarcode();
			System.out.println("Barcode : " + barcode);
			productName = markdown_Product.getProductName();
			System.out.println("Product name : " + productName);
			productDescription = markdown_Product.getProductDescription();
			System.out.println("Product description : " + productDescription);
			currentSellingPrice = markdown_Product.getCurrentSellingPrice();
			System.out.println("Current selling price : " + currentSellingPrice);
			minimumSellingPrice = markdown_Product.getMinimumSellingPrice();
			System.out.println("Minimum selling price : " + minimumSellingPrice);
			maximumSellingPrice = markdown_Product.getMaximumSellingPrice();
			System.out.println("Maximum selling price : " + maximumSellingPrice);
			isPriceOptimisationApplicable = markdown_Product.getIsPriceOptimisationApplicable();
			System.out.println("Is price optimisation applicable : " + isPriceOptimisationApplicable);
			departmentId = markdown_Product.getDepartmentId();
			System.out.println("Department id : " + departmentId);
			categoryId = markdown_Product.getCategoryId();
			System.out.println("Category id : " + categoryId);
			sellingUnitOfMeasure = markdown_Product.getSellingUnitOfMeasure();
			System.out.println("Selling unit of measure : " + sellingUnitOfMeasure);
			priceEditable = markdown_Product.getPriceEditable();
			System.out.println("Price editable : " + priceEditable);
			multipleEventsAllowed = markdown_Product.getMultipleEventsAllowed();
			System.out.println("Multiple events allowed : " + multipleEventsAllowed);

			isRestrictedDepartment = markdown_GetMarkdownRootJsonResp.isRestrictedDepartment();
			System.out.println("Is restricted department : " + isRestrictedDepartment);

			firstMarkdownWindow = markdown_GetMarkdownRootJsonResp.getFirstMarkdownWindow();
			System.out.println("FirstMarkdownWindow attribute : " + firstMarkdownWindow);

			Markdown_MarkdownCap markdown_MarkdownCap = markdown_GetMarkdownRootJsonResp.getMarkdownCap();
			percentageCap = markdown_MarkdownCap.getPercentageCap();
			System.out.println("Percentage cap : " + percentageCap);

			List<Markdown_MarkdownPercentage> markdown_MarkdownPercentage = markdown_GetMarkdownRootJsonResp
					.getMarkdownPercentages();

			for (Markdown_MarkdownPercentage markdownPercentage : markdown_MarkdownPercentage) {
				markdownPercentageee = markdownPercentage.getPercentage();
				System.out.println("Markdown percentage : " + markdownPercentageee);
				markdownPrice = markdownPercentage.getMarkdownPrice();
				System.out.println("Markdown price : " + markdownPrice);
				colleagueApplicable = markdownPercentage.getColleagueApplicable();
				System.out.println("Collegue applicable : " + colleagueApplicable);
				isDefault = markdownPercentage.getIsDefault();
				System.out.println("Is default : " + isDefault);
			}

			Markdown_OptimisedPrice markdown_OptimisedPrice = markdown_GetMarkdownRootJsonResp.getOptimisedPrice();
			if(markdown_OptimisedPrice.getPrice()!=null){
				Markdown_Price markdown_Price = markdown_OptimisedPrice.getPrice();
				optimisedPricePercentage = markdown_Price.getPercentage();
                markdownOptimizedPrice = markdown_Price.getMarkdownPrice();
				System.out.println("Optimised Price Percentage : " + optimisedPricePercentage);
				optimisedPriceMarkdownPrice = Float.parseFloat(markdown_Price.getMarkdownPrice()) / 100;
				calculatedOptimizedMarkdownPrice = Float.toString(optimisedPriceMarkdownPrice);
				System.out.println("Optimised Markdown price : " + calculatedOptimizedMarkdownPrice);
				optimisedPriceQuantity = markdown_Price.getQuantity();
				System.out.println("Quantity : " + optimisedPriceQuantity);
				unitOfMeasure = markdown_Price.getUnitOfMeasure();
				System.out.println("Unit of measure : " + unitOfMeasure);
			}
			else{

				Markdown_Error markdown_Error = markdown_OptimisedPrice.getError();
				markdownCode = markdown_Error.getCode();
			}
		}
	}
	
	public void verifyCurrencyUnit()throws Throwable {
		assertEquals(sellingUnitOfMeasure, "EA","Currency is mismatched");
		assertEquals(unitOfMeasure, "PCS","Unit of measure is mismatched");
	}
	
	

	///// Get - Get Markdown Details service response after scanning product
	public static void getMarkdownDetailsServiceAfterScan() throws Throwable {

		System.out.println(Response);
		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("Get Markdown details response : " + responseCode);

		int responseCodeE = 200;

		if (responseCode == 200 || responseCode == 201) {
			objectMapper.setSerializationInclusion(Include.NON_NULL);
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			markdown_GetMarkdownRootJsonResp = objectMapper.readValue(Response.getEntity().getContent(),
					Markdown_GetMarkdownRoot.class);
			String ProductJSONresult1 = objectMapper.writerWithDefaultPrettyPrinter()
					.writeValueAsString(markdown_GetMarkdownRootJsonResp);

			System.out.println("GetMarkdown details Response:\n" + markdown_GetMarkdownRootJsonResp);

			Markdown_Product markdown_Product = markdown_GetMarkdownRootJsonResp.getProduct();

			minIdentifier = markdown_Product.getMinIdentifier();
			System.out.println("Min indentifier : " + minIdentifier);
			barcode = markdown_Product.getBarcode();
			System.out.println("Barcode : " + barcode);
			productName = markdown_Product.getProductName();
			System.out.println("Product name : " + productName);
			productDescription = markdown_Product.getProductDescription();
			System.out.println("Product description : " + productDescription);
			currentSellingPrice = markdown_Product.getCurrentSellingPrice();
			System.out.println("Current selling price : " + currentSellingPrice);
			minimumSellingPrice = markdown_Product.getMinimumSellingPrice();
			System.out.println("Minimum selling price : " + minimumSellingPrice);
			maximumSellingPrice = markdown_Product.getMaximumSellingPrice();
			System.out.println("Maximum selling price : " + maximumSellingPrice);
			isPriceOptimisationApplicable = markdown_Product.getIsPriceOptimisationApplicable();
			System.out.println("Is price optimisation applicable : " + isPriceOptimisationApplicable);
			departmentId = markdown_Product.getDepartmentId();
			System.out.println("Department id : " + departmentId);
			categoryId = markdown_Product.getCategoryId();
			System.out.println("Category id : " + categoryId);
			sellingUnitOfMeasure = markdown_Product.getSellingUnitOfMeasure();
			System.out.println("Selling unit of measure : " + sellingUnitOfMeasure);
			priceEditable = markdown_Product.getPriceEditable();
			System.out.println("Price editable : " + priceEditable);
			multipleEventsAllowed = markdown_Product.getMultipleEventsAllowed();
			System.out.println("Multiple events allowed : " + multipleEventsAllowed);

			isRestrictedDepartment = markdown_GetMarkdownRootJsonResp.isRestrictedDepartment();
			System.out.println("Is restricted department : " + isRestrictedDepartment);

			firstMarkdownWindow = markdown_GetMarkdownRootJsonResp.getFirstMarkdownWindow();
			System.out.println("FirstMarkdownWindow attribute : " + firstMarkdownWindow);

			Markdown_UnprintedMarkdownEvent markdown_UnprintedMarkdownEvent = markdown_GetMarkdownRootJsonResp
					.getUnprintedMarkdownEvent();
try {
			eventId = markdown_UnprintedMarkdownEvent.getId();
			System.out.println("ID : " + eventId);
			markedDownPrice = markdown_UnprintedMarkdownEvent.getMarkedDownPrice();
			System.out.println("Markdown price : " + markedDownPrice);
			percentageMarkdown = markdown_UnprintedMarkdownEvent.getPercentageMarkdown();
			System.out.println("Percentage markdown : " + percentageMarkdown);
			quantity = markdown_UnprintedMarkdownEvent.getQuantity();
			System.out.println("Quantity : " + quantity);
			markdownBarcode = markdown_UnprintedMarkdownEvent.getMarkdownBarcode();
			System.out.println("Markdown barcode : " + markdownBarcode);

			isComplete = markdown_UnprintedMarkdownEvent.getIsComplete();
			System.out.println("Is complete : " + isComplete);
			isOptimisedPriceUsed = markdown_UnprintedMarkdownEvent.getIsOptimisedPriceUsed();
			System.out.println("Is optimised price used : " + isOptimisedPriceUsed);
			optimisedPriceApplicable = markdown_UnprintedMarkdownEvent.getOptimisedPriceApplicable();
			System.out.println("Optimised price applicable : " + optimisedPriceApplicable);
			byRecommendedPrice = markdown_UnprintedMarkdownEvent.getByRecommendedPrice();
			System.out.println("By recommended price : " + byRecommendedPrice);
			markdownSequence = markdown_UnprintedMarkdownEvent.getMarkdownSequence();
			System.out.println("Markdown sequence : " + markdownSequence);




			Markdown_OptimisedPrice markdown_OptimisedPrice = markdown_UnprintedMarkdownEvent.getOptimisedPrice();

			if(markdown_OptimisedPrice.getPrice()!=null){
				Markdown_Price markdown_Price = markdown_OptimisedPrice.getPrice();
				optimisedPricePercentage = markdown_Price.getPercentage();

				System.out.println("Optimised Price Percentage : " + optimisedPricePercentage);
				optimisedPriceMarkdownPrice = Float.parseFloat(markdown_Price.getMarkdownPrice()) / 100;
				calculatedOptimizedMarkdownPrice = Float.toString(optimisedPriceMarkdownPrice);
				System.out.println("Optimised Markdown price : " + calculatedOptimizedMarkdownPrice);
				optimisedPriceQuantity = markdown_Price.getQuantity();
				System.out.println("Quantity : " + optimisedPriceQuantity);
				unitOfMeasure = markdown_Price.getUnitOfMeasure();
				System.out.println("Unit of measure : " + unitOfMeasure);
			}
			else{

				Markdown_Error markdown_Error = markdown_OptimisedPrice.getError();
				markdownCode = markdown_Error.getCode();
			}
}catch(Exception ex) {}

			Markdown_MarkdownCap markdown_MarkdownCap = markdown_GetMarkdownRootJsonResp.getMarkdownCap();
			percentageCap = markdown_MarkdownCap.getPercentageCap();
			System.out.println("Percentage cap : " + percentageCap);

			List<Markdown_MarkdownPercentage> markdown_MarkdownPercentage = markdown_GetMarkdownRootJsonResp
					.getMarkdownPercentages();

			for (Markdown_MarkdownPercentage markdownPercentage : markdown_MarkdownPercentage) {
				markdownPercentageee = markdownPercentage.getPercentage();
				System.out.println("Markdown percentage : " + markdownPercentageee);
				markdownPrice = markdownPercentage.getMarkdownPrice();
				System.out.println("Markdown price : " + markdownPrice);
				double price = Integer.parseInt(markdownPrice);
				double i = (double) price /100;

				DecimalFormat format = new DecimalFormat("0.00"); 
				String markdownPriceService = format.format(i);

				colleagueApplicable = markdownPercentage.getColleagueApplicable();
				System.out.println("Collegue applicable : " + colleagueApplicable);
				isDefault = markdownPercentage.getIsDefault();
				System.out.println("Is default : " + isDefault);

				markdownPercentageService.put(markdownPercentageee, markdownPriceService);
			}
		}
	}

	public static void verifyOptimizedPriceService() throws Throwable {
		boolean verifyPercentage = optimisedPricePercentage!=null;
		assertEquals(verifyPercentage, true,"Optimized percentage is null");
		boolean verifyOptimizedPrice = calculatedOptimizedMarkdownPrice!=null;
		assertEquals(verifyOptimizedPrice, true,"Optimized markdown price is null");
	}
	
	public static void verifyIsCompleteValue(String expectedValue) throws Throwable {
	assertEquals(isComplete, expectedValue,"IsComplete attribute value is not as expected");
	}


	///// Get - Get First markdown attribute from Markdown Details service response 
	public static void getFirstMarkdownAttribute() throws Throwable {

		System.out.println(Response);
		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("Get Markdown details response : " + responseCode);

		int responseCodeE = 200;

		if (responseCode == 200 || responseCode == 201) {
			objectMapper.setSerializationInclusion(Include.NON_NULL);
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			markdown_GetMarkdownRootJsonResp = objectMapper.readValue(Response.getEntity().getContent(),
					Markdown_GetMarkdownRoot.class);
			String ProductJSONresult1 = objectMapper.writerWithDefaultPrettyPrinter()
					.writeValueAsString(markdown_GetMarkdownRootJsonResp);

			System.out.println("GetMarkdown details Response:\n" + markdown_GetMarkdownRootJsonResp);

			firstMarkdownWindow = markdown_GetMarkdownRootJsonResp.getFirstMarkdownWindow();
			System.out.println("FirstMarkdownWindow attribute : " + firstMarkdownWindow);
		}
	}

	public void verifyFirstmarkdownwindowAttribute(String firstmarkdownwindow){

		String expectedValue = firstmarkdownwindow;
		System.out.println("FirstMArkdownWindow attribute value : " + firstMarkdownWindow);
		assertEquals(firstMarkdownWindow,expectedValue, "FirstMArkdownWindow attribute value is not as expected");

	}
	//// Verifying firstMarkdownWindow attribute value is in HH:MM:SS format
	public void verifyFirstMarkdownFormat(){

		String inputDate = firstMarkdownWindow;
		String[] split = inputDate.split(":");
		int hours = Integer.valueOf(split[0]);
		int minutes = Integer.valueOf(split[1]);
		int seconds = Integer.valueOf(split[2]);

		boolean isHour = hours>=1 && hours<=24;
		boolean isMinutes = minutes>=1 && hours<=59;
		boolean isSeconds = seconds>=1 && seconds<=59;


		assertEquals(isHour,true,"First markdown window is not in HH:MM:SS format");
		assertEquals(isMinutes,true,"First markdown window is not in HH:MM:SS format");
		assertEquals(isSeconds,true,"First markdown window is not in HH:MM:SS format");
	}


	///// Get - Get Markdown Percentage from GetMarkdownDetails service 
	public static void getMarkdownPercentageFromService() throws Throwable {

		System.out.println(Response);
		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("Get Markdown details response : " + responseCode);

		int responseCodeE = 200;

		if (responseCode == 200 || responseCode == 201) {
			objectMapper.setSerializationInclusion(Include.NON_NULL);
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			markdown_GetMarkdownRootJsonResp = objectMapper.readValue(Response.getEntity().getContent(),
					Markdown_GetMarkdownRoot.class);
			String ProductJSONresult1 = objectMapper.writerWithDefaultPrettyPrinter()
					.writeValueAsString(markdown_GetMarkdownRootJsonResp);

			System.out.println("GetMarkdown details Response:\n" + markdown_GetMarkdownRootJsonResp);

			List<Markdown_MarkdownPercentage> markdown_MarkdownPercentage = markdown_GetMarkdownRootJsonResp
					.getMarkdownPercentages();

			for (Markdown_MarkdownPercentage markdownPercentage : markdown_MarkdownPercentage) {
				markdownPercentageee = markdownPercentage.getPercentage();
				System.out.println("Markdown percentage : " + markdownPercentageee);
				markdownPrice = markdownPercentage.getMarkdownPrice();
				System.out.println("Markdown price : " + markdownPrice);
				double price = Integer.parseInt(markdownPrice);
				double i = (double) price /100;

				DecimalFormat format = new DecimalFormat("0.00"); 
				String markdownPriceService = format.format(i);

				colleagueApplicable = markdownPercentage.getColleagueApplicable();
				System.out.println("Collegue applicable : " + colleagueApplicable);
				isDefault = markdownPercentage.getIsDefault();
				System.out.println("Is default : " + isDefault);

				markdownPercentageService.put(markdownPercentageee, markdownPriceService);
			}
		}
	}


	///////////// Blueyonder details service

	public void CurrentTimeToGMT() throws InterruptedException, ParseException {
		Date date = new Date();
		DateFormat gmtFormat = new SimpleDateFormat();
		TimeZone gmtTimeZone = TimeZone.getTimeZone("GMT");
		gmtFormat.setTimeZone(gmtTimeZone);
		System.out.println("Current Time: " + date);
		System.out.println("GMT Time: " + gmtFormat.format(date));
		////
		String gmtTimestamp = gmtFormat.format(date);
		String gmtDatee = gmtTimestamp.split(" ")[0];
		String gmtTimee = gmtTimestamp.split(" ")[1];
		String gmtMeridiem = gmtTimestamp.split(" ")[2];

		System.out.println("gmtTimee:" + gmtTimee);
		String timeText = gmtTimee.split(":")[0];
		int i = Integer.parseInt(timeText);

		if (i < 10) {
			timeText = "0" + gmtTimee + " " + gmtMeridiem;
			System.out.println("Gmt time:" + timeText);
		} else {
			timeText = gmtTimee + " " + gmtMeridiem;
			System.out.println("Gmt time:" + timeText);
		}
		SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm");
		SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");
		Date datee = parseFormat.parse(timeText);
		exepctedTimee = displayFormat.format(datee) + ":00";

		SimpleDateFormat inSDF = new SimpleDateFormat("MM/dd/yy");
		SimpleDateFormat outSDF = new SimpleDateFormat("yyyy-MM-dd");
		if (gmtDatee != null) {
			try {
				Date expectedDate = inSDF.parse(gmtDatee);
				expectedDateeee = outSDF.format(expectedDate);
				int MILLIS_IN_DAY = 1000 * 60 * 60 * 24;
				String nextDate = inSDF.format(expectedDate.getTime() + MILLIS_IN_DAY);

				Date date1 = inSDF.parse(nextDate);
				expectedNextDate = outSDF.format(date1);
			} catch (ParseException ex) {
			}
		}

		System.out.println("exepctedTimee:" + exepctedTimee);
		System.out.println("expectedDateeee:" + expectedDateeee);
		System.out.println("expectedNextDate:" + expectedNextDate);

	}

	///// Get - Get Blueyonder details service url
	public void getBlueyonderDetailsUrl(String storeID, String productID, String accessTocken)
			throws URISyntaxException, InterruptedException, ClientProtocolException, IOException, ParseException {
		CurrentTimeToGMT();
		String date = expectedDateeee + "T" + exepctedTimee;
		String baseURI = applicationConfig.getGetBlueyonderService().getURI();
		String resource = applicationConfig.getGetBlueyonderService().getResource();
		resource = resource.replaceAll("\\bstoreid\\b", storeID);
		resource = resource.replaceAll("\\bitemid\\b", productID);
		resource = resource.replaceAll("\\bexpiryDate\\b", expectedNextDate);
		resource = resource.replaceAll("\\bdatee\\b", date);

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;

		Thread.sleep(500);

	}

	// Get - Get Blueyonder details service response for Item with no price
	public static void getBlueyonderServiceResponsePriceNotFound() throws Throwable {

		System.out.println(Response);
		blueYonderResponseCodeE = Response.getStatusLine().getStatusCode();
		System.out.println("Get Markdown Blueyonder details response : " + blueYonderResponseCodeE);



	}

	// Get - Get Blueyonder details service response
	public static void getBlueyonderServiceResponse() throws Throwable {

		System.out.println(Response);
		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("Get Markdown Blueyonder details response : " + responseCode);

		int responseCodeE = 200;

		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		markdown_Blueyonder = objectMapper.readValue(Response.getEntity().getContent(), Markdown_Blueyonder.class);
		String ProductJSONresult1 = objectMapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(markdown_Blueyonder);

		System.out.println("Get Markdown Blueyonder details Response:\n" + ProductJSONresult1);

		blueyonder_LocationID = markdown_Blueyonder.getLocation_id();
		System.out.println("LocationID : " + blueyonder_LocationID);
		blueyonder_ProductID = markdown_Blueyonder.getProduct_id();
		System.out.println("ProductID : " + blueyonder_ProductID);
		blueyonder_ValidFrom = markdown_Blueyonder.getValid_from();
		System.out.println("ValidFrom : " + blueyonder_ValidFrom);
		blueyonder_CurrentPrice = markdown_Blueyonder.getCurrent_Price();
		System.out.println("CurrentPrice : " + blueyonder_CurrentPrice);

		blueyonder_Price = markdown_Blueyonder.getMarkdown_price();
		System.out.println("Price : " + blueyonder_Price);
		blueyonder_Currency = markdown_Blueyonder.getCurrency();
		System.out.println("Currency : " + blueyonder_Currency);
		blueyonder_MarkdownPercentage = markdown_Blueyonder.getMarkdown_percentage();
		System.out.println("Markdown percentage : " + blueyonder_MarkdownPercentage);
		blueyonder_expirationDate = markdown_Blueyonder.getExpiration_date();
		System.out.println("CurrentPrice : " + blueyonder_expirationDate);

	}


	///// Get - Get Markdown List url
	public void getMarkdownListUrl(String storeID, String accessTocken)
			throws URISyntaxException, InterruptedException, ClientProtocolException, IOException {

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getGetMarkdownList().getResource();
		resource = resource.replaceAll("\\bstoreid\\b", storeID);

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;

		Thread.sleep(500);
	}

	///// Get - Get Markdown List service response
	public static void getMarkdownListServiceResponse() throws Throwable {

		System.out.println(Response);
		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("Get Markdown details response : " + responseCode);

		int responseCodeE = 200;

		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		markdown_GetListRoot = objectMapper.readValue(Response.getEntity().getContent(), Markdown_GetListRoot.class);
		String ProductJSONresult1 = objectMapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(markdown_GetListRoot);

		System.out.println("GetMarkdown details Response:\n" + markdown_GetListRoot);

		List<Markdown_GetList> markdown_GetList = markdown_GetListRoot.getMyArray();

		for (Markdown_GetList getList : markdown_GetList) {

			Markdown_Product markdown_Product = getList.getProduct();

			minIdentifier = markdown_Product.getMinIdentifier();
			System.out.println("Min indentifier : " + minIdentifier);
			barcode = markdown_Product.getBarcode();
			System.out.println("Barcode : " + barcode);
			productName = markdown_Product.getProductName();
			System.out.println("Product name : " + productName);
			productDescription = markdown_Product.getProductDescription();
			System.out.println("Product description : " + productDescription);
			currentSellingPrice = markdown_Product.getCurrentSellingPrice();
			System.out.println("Current selling price : " + currentSellingPrice);
			minimumSellingPrice = markdown_Product.getMinimumSellingPrice();
			System.out.println("Minimum selling price : " + minimumSellingPrice);
			maximumSellingPrice = markdown_Product.getMaximumSellingPrice();
			System.out.println("Maximum selling price : " + maximumSellingPrice);
			isPriceOptimisationApplicable = markdown_Product.getIsPriceOptimisationApplicable();
			System.out.println("Is price optimisation applicable : " + isPriceOptimisationApplicable);
			departmentId = markdown_Product.getDepartmentId();
			System.out.println("Department id : " + departmentId);
			categoryId = markdown_Product.getCategoryId();
			System.out.println("Category id : " + categoryId);
			sellingUnitOfMeasure = markdown_Product.getSellingUnitOfMeasure();
			System.out.println("Selling unit of measure : " + sellingUnitOfMeasure);
			priceEditable = markdown_Product.getPriceEditable();
			System.out.println("Price editable : " + priceEditable);
			multipleEventsAllowed = markdown_Product.getMultipleEventsAllowed();
			System.out.println("Multiple events allowed : " + multipleEventsAllowed);

			isRestrictedDepartment = getList.getIsRestrictedDepartment();
			System.out.println("Is restricted department : " + isRestrictedDepartment);

			Markdown_UnprintedMarkdownEvent markdown_UnprintedMarkdownEvent = getList.getUnprintedMarkdownEvent();
			eventId = markdown_UnprintedMarkdownEvent.getId();
			System.out.println("ID : " + eventId);
			markedDownPrice = markdown_UnprintedMarkdownEvent.getMarkedDownPrice();
			System.out.println("Markdown price : " + markedDownPrice);
			percentageMarkdown = markdown_UnprintedMarkdownEvent.getPercentageMarkdown();
			System.out.println("Percentage markdown : " + percentageMarkdown);
			quantity = markdown_UnprintedMarkdownEvent.getQuantity();
			System.out.println("Quantity : " + quantity);
			markdownBarcode = markdown_UnprintedMarkdownEvent.getMarkdownBarcode();
			System.out.println("Markdown barcode : " + markdownBarcode);

			isComplete = markdown_UnprintedMarkdownEvent.getIsComplete();
			System.out.println("Is complete : " + isComplete);
			isOptimisedPriceUsed = markdown_UnprintedMarkdownEvent.getIsOptimisedPriceUsed();
			System.out.println("Is optimised price used : " + isOptimisedPriceUsed);
			optimisedPriceApplicable = markdown_UnprintedMarkdownEvent.getOptimisedPriceApplicable();
			System.out.println("Optimised price applicable : " + optimisedPriceApplicable);
			byRecommendedPrice = markdown_UnprintedMarkdownEvent.getByRecommendedPrice();
			System.out.println("By recommended price : " + byRecommendedPrice);
			markdownSequence = markdown_UnprintedMarkdownEvent.getMarkdownSequence();
			System.out.println("Markdown sequence : " + markdownSequence);

		}
	}

	////// Delete print list - markdown

	public void deletePrintListServiceUrl(String storeID, String accessTocken)
			throws URISyntaxException, ClientProtocolException, IOException, InterruptedException {

		String eventIdText = eventId;

		System.out.println("Payload body is " + "[" + eventIdText + "]");

		String deletePrintListBody = "[" + eventIdText + "]";

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getDeletePrintList().getResource();
		resource = resource.replaceAll("\\bstoreid\\b", storeID);

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);
		mdStorewalk = deletePrintListBody;
		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;

	}


	public void compareBYpriceOptimizedPrice() {
		if (blueyonder_ProductID.equals(minIdentifier)) {

			Assert.assertEquals(blueYonderResponseCodeE, optimisedPricePercentage,
					"BlueYonder percentage did not matched with markdown percentage in get markdown API");
			Assert.assertEquals(blueyonder_Price, calculatedOptimizedMarkdownPrice,
					"BlueYonder markdown price did not matched with markdown price in get markdown API");

		}

	}

	public void compareBYpriceOptimizedPriceNotFound() {
		System.out.println("1:"+blueyonder_MarkdownPercentage+"  2:"+markdownCode);
		Assert.assertEquals(blueyonder_MarkdownPercentage, markdownCode,
				"BlueYonder error code did not matched with markdown optimied price error code in get markdown API");


	}

	public void markdownPercentageOnUISevice(){
		boolean isVerify = false;
		for(Entry<String, String> entry1: MarkDownPO.percentageListUI.entrySet()) {
			String key1 = entry1.getKey();
			String value1 = entry1.getValue();

			if(markdownPercentageService.containsKey(key1)){
				String value2 = markdownPercentageService.get(key1);

				if(value1.equals(value2)){
					isVerify = true;
				}
			}
			assertEquals(isVerify, true, "Markdown percentage and price data is mismatched");
		}
	}

	public void verifyMarkdownPercentageValue(String percentage){
		boolean isVerify = false;
		for(Entry<String, String> entry1: MarkDownPO.percentageListUI.entrySet()) {
			String key1 = entry1.getKey();
			String value1 = entry1.getValue();

			if(markdownPercentageService.containsKey(key1)){
				String value2 = markdownPercentageService.get(key1);

				if(value1.equals(value2)){
					isVerify = true;
				}
			}
			assertEquals(isVerify, true, "Markdown percentage and price data is mismatched");
		}
	}

	public void verifyCalculatePrice(){
		String priceUI = MarkDownPO.newPriceOnUI.substring(1);
		double d=Double.parseDouble(priceUI);

		priceUI = String.format("%.1f",d);
		System.out.println("priceUI % : " + priceUI);

		assertEquals(priceUI,blueyonder_CurrentPrice, "Calculate price on UI and service mismatched");
	}

	public void verifyCalculatePriceForManager(){
		String priceUI = MarkDownPO.calculatedPriceUI.substring(1);
		double d=Double.parseDouble(priceUI);

		priceUI = String.format("%.1f",d);
		System.out.println("priceUI % : " + priceUI);

		assertEquals(priceUI,blueyonder_CurrentPrice, "Calculate price on UI and service mismatched");
	}

	public static void verifyIsCompleteAttribute()throws Throwable{
		assertEquals(isComplete, "Y","IsComplete flag value is not as expected");
	}

	public void verifyCurrentPriceDisplayed(){
		double price = Integer.parseInt(currentSellingPrice);
		double i = (double) price /100;

		DecimalFormat format = new DecimalFormat("0.00"); 
		String currentPriceService = format.format(i);

		String currentPriceUI= MarkDownPO.originalPriceOnUI.substring(1);

		assertEquals(currentPriceUI, currentPriceService, "Current price on UI and sevice is mismatched");
	}

	public void verifyMarkdownPercentage(){

		boolean isNotEmpty = !markdownPercentageService.isEmpty();

		assertEquals(isNotEmpty, true, "Markdown percentage and price is not present");
	}
}
