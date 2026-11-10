package com.morrisons.sma.page_objects.service;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.utils.URIBuilder;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.android.AndroidDriver;
import com.morrisons.sma.pojo.service.CleanNRotateServicePOJO.CleanAndRotateLogin;
import com.morrisons.sma.pojo.service.MarkdownPOJO.MarkdownEventVo;
import com.morrisons.sma.pojo.service.MarkdownPOJO.MarkdownLoginVo;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.GlhBurst_Departments;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.GlhBurst_Groups;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.GlhBurst_Sections;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.GlhNegPrompt_StorewalkItemPost;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.GlhNegPrompt_StorewalkPost;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.Glh_Delivery;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.Glh_Order;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.Glh_Ordered;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.NegPrompt_GetStorewalkPojo;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.NegPrompt_StorewalkItemPOJO;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.Storewalk_CreationAudit;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.Storewalk_GetCaptures;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.Storewalk_GetStorewalkItems;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.Storewalk_Plan;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.Storewalk_Who;
import com.morrisons.sma.step_definitions.service.old.RestAssuredSteps;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import com.morrisons.common.utility.MarkdownServiceData;
import com.morrisons.common.utility.WebServiceClient;

public class GlhNegativePromptServicePO {

	public static Map<String, String> headers = new HashMap<>();
	static ObjectMapper objectMapper = new ObjectMapper();
	public static HttpResponse Response;
	public static io.restassured.response.Response restResponse;
	MarkdownLoginVo mDLoginJsonResp = new MarkdownLoginVo();
	RestAssuredSteps loginTocken = new RestAssuredSteps();
	private static AndroidDriver driveR;

	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();

	MarkdownEventVo markdownEventResp = new MarkdownEventVo();
	static String accessTocken;
	String accessTockenGLH;
	String markdownBarcodeTest;
	String complete;
	String tokenaccess;
	String env = applicationConfig.getWebElementEnviroment().getEnv();
	public static URI currentUri;
	public static String mDAccessTocken;

	String collegueUsername = applicationConfig.getUserCredentials().getCollegueUsername();
	String colleguePassword = applicationConfig.getUserCredentials().getColleguePassword();
	String managerUsername = applicationConfig.getUserCredentials().getManagerUsername();
	String managerPassword = applicationConfig.getUserCredentials().getManagerPassword();
	private static String walkId;

	private static String departmentId;
	private static String departmentName;
	private static String departmentSortOrder;
	private static String groupId;
	private static String groupName;
	private static String groupSortOrder;
	private static String sectionId;
	private static String sectionName;
	private static String sectionSortOrder;
	private static String sectionStatus;

	private static NegPrompt_GetStorewalkPojo negPrompt_GetStorewalkPojoJsonResp = new NegPrompt_GetStorewalkPojo();
	private static NegPrompt_StorewalkItemPOJO negPrompt_StorewalkItemPOJOJsonResp = new NegPrompt_StorewalkItemPOJO();
	private static Storewalk_GetCaptures glhCapturePojoJsonResp = new Storewalk_GetCaptures();
	private static Storewalk_GetStorewalkItems glhStoreWalkItemsPoJoJsonResp =new Storewalk_GetStorewalkItems();
	private static String storewalk_WalkId;
	private static String walkType;
	private static String storeNumber;
	private static String isCurfewStore;

	private static String walkItem;
	private static String description;
	private static String isDeliveryExpected;
	private static String isreceited;
	private static String packSize;
	private static String partOfCount;
	private static String plan;
	private static String productId;
	private static String qtyInTransit;
	private static String qtyOnHand;
	private static String qtyUnitI;
	private static String rangeStatus;
	private static String sohValue;
	private static String standardUnitOfMeasure;
	private static String stockState;
	private static String stockUom;

	private static String order;
	private static String quantity;
	private static String quantityType;
	private static String quantityUnit;

	private static String deliveryExpected;
	private static String deliveryAvailabilityExpected;


	static String mdLogin = null;
	static String mdStorewalk = null;
	static String mdStorewalkItem = null;

	static String when = null;
	static String empId = null;
	static String username = null;

	static String class1 = null;
	static String fillQty = null;
	static String name = null;
	static String planLocation = null;
	static String walkSequence = null;
	static String type = null;


	public void requestMadeToSMAGLHCollegueLogin() throws Throwable{
		CleanAndRotateLogin crLgoin = new CleanAndRotateLogin();
		crLgoin.setUserName(collegueUsername);

		crLgoin.setPassword(colleguePassword);

		crLgoin.setProvider("morrisons");
		String crLoginBody = objectMapper.writeValueAsString(crLgoin);
		System.out.println("Payload body is " + crLoginBody);
		MarkdownServiceData.postLoginForMarkdown(crLoginBody);
		Response = MarkdownServiceData.postOperationForMdLogin();

		Thread.sleep(500);
	}

	public void requestMadeToSMAGLHManagerLogin() throws Throwable{
		CleanAndRotateLogin crLgoin = new CleanAndRotateLogin();
		crLgoin.setUserName(managerUsername);

		crLgoin.setPassword(managerPassword);

		crLgoin.setProvider("morrisons");
		String crLoginBody = objectMapper.writeValueAsString(crLgoin);
		System.out.println("Payload body is " + crLoginBody);
		MarkdownServiceData.postLoginForMarkdown(crLoginBody);
		Response = MarkdownServiceData.postOperationForMdLogin();

		Thread.sleep(500);
	}

	public void serviceShouldReturnSMAGlhLogin() throws Throwable{
		int responseCode = Response.getStatusLine().getStatusCode();
		int responseCodeE = 200;

		assertEquals(responseCode, responseCodeE, "Issues observed while generating access token");
		mDLoginJsonResp = objectMapper.readValue(Response.getEntity().getContent(), MarkdownLoginVo.class);
		String ProductJSONresult = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mDLoginJsonResp);
		System.out.println("Markdown Login Response:\n" + ProductJSONresult);
		Thread.sleep(500);
	}

	public String getGeneratedAccessTokenForGLH() throws Throwable {
		accessTocken = mDLoginJsonResp.getAccessToken();
		System.out.println("Access Tocken is " + accessTocken);

		return accessTocken;
	}

	public static Map<String, String> getHeadersForApp() {
		String Header1Key = "Authorization";

		headers.put(Header1Key, "Bearer " + mDAccessTocken);
		System.out.println("Headers for markdown are - " + headers);
		return headers;
	}

	public static HttpResponse performOperation() throws ClientProtocolException, IOException {
		getHeadersForApp();
		System.out.println("URI is \t" + currentUri + "headers are\t" + headers);
		if (currentUri != null)
			Response = WebServiceClient.getMethodResponse(currentUri, headers);
		else {
			System.out.println("\n URL value is missing.Please send valid URL to perform operation");
		}
		return Response;
	}

	public static void getScheduleResponse() throws Throwable {
		int responseCode = Response.getStatusLine().getStatusCode();
		String errorMessage = Response.getStatusLine().getReasonPhrase();
		int responseCodeE = 200;
		System.out.println("Error Message is - " + errorMessage);

		assertEquals(responseCode, responseCodeE, " Schedule details does not exist. Response code");
	}



	public static HttpResponse postOperationStorewalkService() throws ClientProtocolException, IOException {
		HttpResponse getResponse = null;

		getPostHeadersForGlh();
		System.out.println("URI is \t" + currentUri + "headers are\t" + headers);
		System.out.println("payload details is 2 = " + mdStorewalk);
		if (currentUri != null)
			getResponse = WebServiceClient.postMethodResponse(currentUri, headers, mdStorewalk);

		else {
			System.out.println("\n URL value is missing.Please send valid URL to perform operation");
		}
		return getResponse;
	}

	public static HttpResponse postOperationStorewalItemService() throws ClientProtocolException, IOException {
		HttpResponse getResponse = null;

		getPostHeadersForGlh();
		System.out.println("URI is \t" + currentUri + "headers are\t" + headers);
		System.out.println("payload details is 2 = " + mdStorewalkItem);
		if (currentUri != null)
			getResponse = WebServiceClient.postMethodResponse(currentUri, headers, mdStorewalkItem);

		else {
			System.out.println("\n URL value is missing.Please send valid URL to perform operation");
		}
		return getResponse;
	}

	public static Map<String, String> getPostHeadersForMdLogin() {

		headers.put("Content-Type", "application/json");
		System.out.println(headers);
		return headers;
	}

	public static Map<String, String> getPostHeadersForGlh() {

		String Header1Key = "Authorization";
		headers.put(Header1Key, "Bearer " + mDAccessTocken);
		headers.put("Content-Type", "application/json");
		System.out.println(headers);
		return headers;
	}

	public static URI getScheduleForCreateStorewalk(String storewalkServiceBody,String storeId,String accessTocken)
			throws URISyntaxException {

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getCreateStorewalk().getResource();
		resource = resource.replaceAll("\\bstoreId\\b", storeId);
		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		//uriBuilder.setCustomQuery(queryparameter);
		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mdStorewalk = storewalkServiceBody;
		System.out.println(mdStorewalk);
		mDAccessTocken = accessTocken;
		return currentUri;

		//		
		//		
		//		currentUri = uriBuilder.build();
		//		System.out.println(currentUri);
		//		mDAccessTocken = accessTocken;
		//		return currentUri;
	}

	public static URI getScheduleForCreateWalkItem(String storewalkItemServiceBody,String storeId, String accessTocken)
			throws URISyntaxException {

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getCreateWalkitem().getResource();
		resource = resource.replaceAll("\\bstoreId\\b", storeId);
		resource = resource.replaceAll("\\bwalkId\\b", storewalk_WalkId);
		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mdStorewalkItem = storewalkItemServiceBody;
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;
		return currentUri;
	}

	
	public void postCreateStorewalkService(String storeId,String type,String accessTocken) throws Throwable{
		GlhNegPrompt_StorewalkPost negativePromptPostBody = new GlhNegPrompt_StorewalkPost();
		negativePromptPostBody.setType(type);

		String storewalkServiceBody = objectMapper.writeValueAsString(negativePromptPostBody);
		System.out.println("Payload body is " + storewalkServiceBody);
		getScheduleForCreateStorewalk(storewalkServiceBody,storeId,accessTocken);
		Response = postOperationStorewalkService();
		System.out.println(Response);
		Thread.sleep(500);
	}


	public void postCreateStorewalkItemService(String storeId,String product,String accessTocken) throws Throwable{
		GlhNegPrompt_StorewalkItemPost negPrompt_StorewalkItemPost = new GlhNegPrompt_StorewalkItemPost();
		negPrompt_StorewalkItemPost.setProductId(product);

		String storewalkItemServiceBody = objectMapper.writeValueAsString(negPrompt_StorewalkItemPost);
		System.out.println("Payload body is " + storewalkItemServiceBody);
		getScheduleForCreateWalkItem(storewalkItemServiceBody,storeId,accessTocken);
		Response = postOperationStorewalItemService();

		Thread.sleep(500);
	}


	public static void verifyStorewalkItemAPIRepsonse()throws Throwable{

		int responseCode = Response.getStatusLine().getStatusCode();
		int responseCodeE = 200;

		assertEquals(responseCode, responseCodeE, " Storewalk service response code is not as expected");
	}

	public static void getCreateStorewalkServicesStatus()throws Throwable{

		System.out.println(Response);
		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("Create storewalk response : " + responseCode);

		int responseCodeE = 200;

		assertEquals(responseCode, responseCodeE, " Storewalk details does not exist. Response code");
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		negPrompt_GetStorewalkPojoJsonResp = objectMapper.readValue(Response.getEntity().getContent(), NegPrompt_GetStorewalkPojo.class);
		String ProductJSONresult1 = objectMapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(negPrompt_GetStorewalkPojoJsonResp);
		System.out.println("CreateStorewalk Response:\n" + negPrompt_GetStorewalkPojoJsonResp);


		storewalk_WalkId = negPrompt_GetStorewalkPojoJsonResp.getWalkId();
		System.out.println("Walk id status from Service---" + storewalk_WalkId);

		walkType = negPrompt_GetStorewalkPojoJsonResp.getWalkType();
		System.out.println("Walk type status from Service---" + walkType);

		storeNumber = negPrompt_GetStorewalkPojoJsonResp.getStoreNumber();
		System.out.println("Store number status from Service---" + storeNumber);

		isCurfewStore = negPrompt_GetStorewalkPojoJsonResp.getIsCurfewStore();
		System.out.println("Is curfew store status from Service---" + isCurfewStore);

		Storewalk_CreationAudit creationAudits = negPrompt_GetStorewalkPojoJsonResp.getCreationAudit();
		when = creationAudits.getWhen();
		System.out.println("When attribute status from Service---" + when);

		Storewalk_Who whoPO = creationAudits.getWho();

		empId = whoPO.getEmpId();
		System.out.println("Emp id attribute status from Service---" + empId);

		username = whoPO.getUsername();
		System.out.println("Username attribute status from Service---" + username);

		try{
			List<GlhBurst_Departments> allDepartments = negPrompt_GetStorewalkPojoJsonResp.getDepartments();
			for (GlhBurst_Departments departments : allDepartments) {

				departmentId = departments.getId();
				System.out.println("Department Id from Service---" + departmentId);

				departmentName = departments.getName();
				System.out.println("Department Name from Service---" + departmentName);

				departmentSortOrder = departments.getSortOrder();
				System.out.println("Department Sort Order from Service---" + departmentSortOrder);

				List<GlhBurst_Groups> allGroups = departments.getGroups();
				for (GlhBurst_Groups groups : allGroups) {

					groupId = groups.getId();
					System.out.println("Group Id from Service---" + groupId);

					groupName = groups.getName();
					System.out.println("Group Name from Service---" + groupName);

					groupSortOrder = groups.getSortOrder();
					System.out.println("Group Sort Order from Service---" + groupSortOrder);

					List<GlhBurst_Sections> allSections = groups.getSections();
					for (GlhBurst_Sections section : allSections) {

						sectionId = section.getId();
						System.out.println("Section Id from Service---" + sectionId);

						sectionName = section.getName();
						System.out.println("Section Name from Service---" + sectionName);

						sectionSortOrder = section.getSortOrder();
						System.out.println("Section Sort Order from Service---" + sectionSortOrder);

						sectionStatus = section.getStatus();
						System.out.println("Section Status from Service---" + sectionStatus);
					}
				}
			}
		}
		catch(Exception e){}
	}

	public static void getCreateWalItemServicesStatus()throws Throwable{

		int responseCode = Response.getStatusLine().getStatusCode();
		int responseCodeE = 200;

		assertEquals(responseCode, responseCodeE, " Storewalk details does not exist. Response code");
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		negPrompt_StorewalkItemPOJOJsonResp = objectMapper.readValue(Response.getEntity().getContent(), NegPrompt_StorewalkItemPOJO.class);
		String ProductJSONresult1 = objectMapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(negPrompt_StorewalkItemPOJOJsonResp);
		System.out.println("CreateStorewalk Response:\n" + negPrompt_StorewalkItemPOJOJsonResp);

		walkItem = negPrompt_StorewalkItemPOJOJsonResp.getWalkItemId();
		System.out.println("Walk item Status from Service---" + walkItem);

		description = negPrompt_StorewalkItemPOJOJsonResp.getDescription();
		System.out.println("Description Status from Service---" + description);

		isDeliveryExpected = negPrompt_StorewalkItemPOJOJsonResp.getIsDeliveryExpectedDateToday();
		System.out.println("Is delivery expected Status from Service---" + isDeliveryExpected);

		isreceited = negPrompt_StorewalkItemPOJOJsonResp.getIsReceited();
		System.out.println("Is recited Status from Service---" + isreceited);

		packSize = negPrompt_StorewalkItemPOJOJsonResp.getPackSize();
		System.out.println("Pack size Status from Service---" + packSize);

		partOfCount = negPrompt_StorewalkItemPOJOJsonResp.getPartOfCount();
		System.out.println("Part of count Status from Service---" + partOfCount);

		List<Storewalk_Plan> plan = negPrompt_StorewalkItemPOJOJsonResp.getPlan();

		for(Storewalk_Plan p : plan){
			class1 = p.getClass1();
			System.out.println("class Status from Service---" + class1);				

			fillQty = p.getFillQty();
			System.out.println("Fill quantity Status from Service---" + fillQty);

			name =p.getName();
			System.out.println("Name Status from Service---" + name);

			planLocation = p.getPlanLocation();
			System.out.println("Plan location Status from Service---" + planLocation);

			walkSequence = p.getStoreWalkSequence();
			System.out.println("Storewalk sequence Status from Service---" + walkSequence);

			type = p.getType();
			System.out.println("Type Status from Service---" + type);
		}


		productId = negPrompt_StorewalkItemPOJOJsonResp.getProductId();
		System.out.println("Product id Status from Service---" + productId);

		qtyInTransit = negPrompt_StorewalkItemPOJOJsonResp.getQtyInTransit();
		System.out.println("Quantity in transit Status from Service---" + qtyInTransit);

		qtyOnHand = negPrompt_StorewalkItemPOJOJsonResp.getQtyOnHand();
		System.out.println("Quantity on hand from Service---" + qtyOnHand);

		qtyUnitI = negPrompt_StorewalkItemPOJOJsonResp.getQuantityUnitId();
		System.out.println("Quantity unit from Service---" + qtyUnitI);

		rangeStatus = negPrompt_StorewalkItemPOJOJsonResp.getRangeStatus();
		System.out.println("Range Status from Service---" + rangeStatus);

		sohValue = negPrompt_StorewalkItemPOJOJsonResp.getSOHValue();
		System.out.println("SOH value from Service---" + sohValue);

		standardUnitOfMeasure = negPrompt_StorewalkItemPOJOJsonResp.getStandardUnitOfMeasure();
		System.out.println("Stock unit of measure from Service---" + standardUnitOfMeasure);

		stockState = negPrompt_StorewalkItemPOJOJsonResp.getStockState();
		System.out.println("Stock state from Service---" + stockState);

		stockUom = negPrompt_StorewalkItemPOJOJsonResp.getStockUom();
		System.out.println("Stock UOM from Service---" + stockUom);

		Glh_Order orderDetails = negPrompt_StorewalkItemPOJOJsonResp.getOrder();

		Glh_Ordered orderDetail = orderDetails.getOrdered();

		order = orderDetail.getDate();
		System.out.println("Order from Service---" + order);

		quantity = orderDetail.getQuantity();
		System.out.println("Quantity from Service---" + quantity);

		quantityType = orderDetail.getQuantityType();
		System.out.println("Quantity type from Service---" + quantityType);

		quantityUnit = orderDetail.getQuantityUnit();
		System.out.println("Quantity unit from Service---" + quantityUnit);

		Glh_Delivery deliveryDetail = orderDetails.getDelivery();

		deliveryExpected = deliveryDetail.getDateDeliveryExpected();
		System.out.println("Delivery excepcted from Service---" + deliveryExpected);

		deliveryAvailabilityExpected = deliveryDetail.getDateAvailabilityExpected();
		System.out.println("Delivery availability expected from Service---" + deliveryAvailabilityExpected);

	}


	
	public static void verifywalkId() {
			boolean isNotEmpty = false;
			if(!storewalk_WalkId.isEmpty()){
						isNotEmpty = true;
							boolean walkIdUI =  negPrompt_GetStorewalkPojoJsonResp.getWalkId()!= null;
					assertEquals(walkIdUI, true, "Walk Id is not present");
			}
	}
	
	public void verifyCurfewflag() {
		if(!isCurfewStore.isEmpty()){
						boolean curfewflagUI =  isCurfewStore!= null;
				assertEquals(curfewflagUI, true, "Walk Id is not present");	
		}
	}
	public static URI getStoreWalkAllcaptures(String storeId, String walkId, String userId)throws URISyntaxException {
		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI(); 
		String resource = applicationConfig.getGetallCapture().getResource();
		
		resource = resource.replaceAll("\\bstoreid\\b", storeId);
		resource = resource.replaceAll("\\bwalkid\\b", storewalk_WalkId);
		resource = resource.replaceAll("\\buserid\\b", userId);
				
		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;
		return currentUri; 
		}

	public static URI getStoreWalkItems(String storeId, String walkId)throws URISyntaxException {
		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI(); 
		String resource = applicationConfig.getGetStoreWalkitems().getResource();
		
		resource = resource.replaceAll("\\bstoreid\\b", storeId);
		resource = resource.replaceAll("\\bwalkid\\b", storewalk_WalkId);
				
		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;
		return currentUri; 
		}
	
	
	public static void getStoreWalkAllcapturesStatus()throws Throwable{

		System.out.println(Response);
		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("GET storewalk all Captures : " + responseCode);

		int responseCodeE = 200;

		assertEquals(responseCode, responseCodeE, " Storewalk details does not exist. Response code");
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		glhCapturePojoJsonResp = objectMapper.readValue(Response.getEntity().getContent(), Storewalk_GetCaptures.class);
		
		String ProductJSONresult2 = objectMapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(glhCapturePojoJsonResp);
		
		System.out.println("GET storewalk all Captures Response:\n" + ProductJSONresult2);
	}
	
	public static void getStoreWalkItemsStatus()throws Throwable{

		System.out.println(Response);
		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("GET storewalkItems: " + responseCode);

		int responseCodeE = 200;

		assertEquals(responseCode, responseCodeE, " Storewalk details does not exist. Response code");
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		glhStoreWalkItemsPoJoJsonResp = objectMapper.readValue(Response.getEntity().getContent(), Storewalk_GetStorewalkItems.class);
		
		String ProductJSONresult2 = objectMapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(glhStoreWalkItemsPoJoJsonResp);
		
		System.out.println("GET storewalkItem response:\n" + ProductJSONresult2);
	}
	
	

	public void verifywalkType(String type1) {
		assertEquals(walkType, type1, "Walk Type does not match");

	}

		
}


