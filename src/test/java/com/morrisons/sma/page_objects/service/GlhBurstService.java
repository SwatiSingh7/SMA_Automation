package com.morrisons.sma.page_objects.service;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.utils.URIBuilder;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.morrisons.sma.pojo.service.CleanNRotateServicePOJO.CleanAndRotateLogin;
import com.morrisons.sma.pojo.service.MarkdownPOJO.MarkdownLoginVo;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.GlhBurst_Departments;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.GlhBurst_Storewalk;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.Storewalk_CreationAudit;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.Storewalk_Department;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.Storewalk_GetStorewalk;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.Storewalk_Group;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.Storewalk_Section;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.Storewalk_Storewalks;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import com.morrisons.common.utility.MarkdownServiceData;
import com.morrisons.common.utility.WebServiceClient;

public class GlhBurstService {

	public static Map<String, String> headers = new HashMap<>();
	static ObjectMapper objectMapper = new ObjectMapper();
	static ObjectMapper objectMapper1 = new ObjectMapper();
	public static HttpResponse Response;
	public static io.restassured.response.Response restResponse;

	static String accessTocken;
	public static URI currentUri;
	public static String mDAccessTocken;

	String env = applicationConfig.getWebElementEnviroment().getEnv();

	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
	String collegueUsername = applicationConfig.getUserCredentials().getCollegueUsername();
	String colleguePassword = applicationConfig.getUserCredentials().getColleguePassword();
	String managerUsername = applicationConfig.getUserCredentials().getManagerUsername();
	String managerPassword = applicationConfig.getUserCredentials().getManagerPassword();

	MarkdownLoginVo mDLoginJsonResp = new MarkdownLoginVo();

	private static GlhBurst_Storewalk glhBurst_StoreWalkJsonResp;
	private static GlhBurst_Departments glhBurst_DepartmentsJsonResp;
	private static Storewalk_CreationAudit glhBurst_CreationAuditJsonResp;
	private static Storewalk_Section glhBurst_SectionsJsonResp;
	private static Storewalk_Storewalks storewalk_StorewalksJsonResp;

	//String d = new Date().toString();
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private static String currentDate = sdf.format(new Date());

	public static String departmentIdService;
	public static String groupIdService;
	public static String sessionIdService;

	public static Map<String,String> storewalkDetails = new HashMap<String,String>(); 

	public static String departmentId = null;
	public static String departmentName = null;
	public static String departmentSortOrder = null;
	public static String groupId = null;
	public static String groupName = null;
	public static String groupSortOrder = null;
	public static String sectionId = null;
	public static String sectionSortOrder = null;
	public static String sectionStatus = null;
	public static String sectionName = null;
	public static String captureType = null;
	public static String productId = null;


	public static Map<String,String> sectionDetails = new HashMap<String,String>(); 

	public static String sectionApiId = null;
	public static String sectionApiName = null;
	public static String sectionApiSortOrder = null;
	public static String sectionApiStatus = null;

	public static Map<String, String> headers1 = new HashMap<>();

	public void requestMadeToSMACollegueLogin() throws Throwable{
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

	public void requestMadeToSMAManagerLogin() throws Throwable{
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

	public void serviceShouldReturnSMALogin() throws Throwable{
		int responseCode = Response.getStatusLine().getStatusCode();
		String errorMessage = Response.getStatusLine().getReasonPhrase();
		int responseCodeE = 200;

		System.out.println("PostMan Response Message is - " + errorMessage);
		assertEquals(responseCode, responseCodeE, "Issues observed while generating access token");
		mDLoginJsonResp = objectMapper.readValue(Response.getEntity().getContent(), MarkdownLoginVo.class);
		String ProductJSONresult = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mDLoginJsonResp);
		System.out.println("Markdown Login Response:\n" + ProductJSONresult);
		Thread.sleep(500);
	}

	public String getGeneratedAccessTokenForCR() throws Throwable {
		accessTocken = mDLoginJsonResp.getAccessToken();
		System.out.println("Access Tocken is " + accessTocken);

		return accessTocken;
	}

	public static URI getStoreWalkUrl()throws URISyntaxException {

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getGetStoreWalks().getResource();
		resource = resource.replaceAll("\\bcurrentDate/\\b", currentDate);

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;
		return currentUri;
	}

	public static URI getStoreWalkStoreUrl(String storeId, String walkId)throws URISyntaxException {

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getGetStoreWalkForStore().getResource();
		resource = resource.replaceAll("\\bstoreid\\b", storeId);
		resource = resource.replaceAll("\\bwalkid\\b", walkId);

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;
		return currentUri;
	}

	public static URI getStoreWalkAttributesUrl(String storeId, String walkId)throws URISyntaxException {

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getGetStoreWalkForAttributes().getResource();
		resource = resource.replaceAll("\\bstoreid\\b", storeId);
		resource = resource.replaceAll("\\bwalkid\\b", walkId);

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;
		return currentUri;
	}
	

	public static URI getCaptureTypeUrl(String storeId, String walkId, String captureType)throws URISyntaxException {

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getGetStoreWalkCaptureType().getResource();
		resource = resource.replaceAll("\\bstoreid\\b", storeId);
		resource = resource.replaceAll("\\bwalkid\\b", walkId);
		resource = resource.replaceAll("\\bcaptureType\\b", captureType);

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;
		return currentUri;
	}

	public static URI getSectionApiUrl(String storeId, String walkId)throws URISyntaxException {

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getGetSectionApiServices().getResource();
		resource = resource.replaceAll("\\bstoreid\\b", storeId);
		resource = resource.replaceAll("\\bwalkid\\b", walkId);
		resource = resource.replaceAll("\\bdepartmentId\\b", departmentId);
		resource = resource.replaceAll("\\bgroupId\\b", groupId);
		resource = resource.replaceAll("\\bsectionId\\b", sectionId);

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;
		return currentUri;
	}

	public static URI getSectionAttributesApiUrl(String storeId, String walkId, String captureType)throws URISyntaxException {

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getGetSectionAttributesApiServices().getResource();
		resource = resource.replaceAll("\\bstoreid\\b", storeId);
		resource = resource.replaceAll("\\bwalkid\\b", walkId);
		resource = resource.replaceAll("\\bdepartmentId\\b", departmentId);
		resource = resource.replaceAll("\\bgroupId\\b", groupId);
		resource = resource.replaceAll("\\bsectionId\\b", sectionId);
		resource = resource.replaceAll("\\bcaptureType\\b", captureType);


		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;
		return currentUri;
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



	public static List<String> getWalkIdServices(String storeId) throws Throwable {

		List<String> walkIds = new ArrayList<String>();

		String walkIdText = null;
		String storeNumberText;
		String walkTypeText;

		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("Response code : "+ responseCode);
		int responseCodeE = 200;

		if(responseCode!=404){

			assertEquals(responseCode, responseCodeE, "Walk id details does not exist. Response code");

			objectMapper.setSerializationInclusion(Include.NON_NULL);
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			storewalk_StorewalksJsonResp = objectMapper.readValue(Response.getEntity().getContent(), Storewalk_Storewalks.class);
			String StoreWalkJSONresult = objectMapper.writerWithDefaultPrettyPrinter()
					.writeValueAsString(storewalk_StorewalksJsonResp);
			System.out.println("Sales order:\n" + StoreWalkJSONresult);

			System.out.println("Sales order:\n" + storewalk_StorewalksJsonResp);

			List<Storewalk_GetStorewalk> storewalks = storewalk_StorewalksJsonResp.getStorewalks();
			System.out.println("Storewalks : " + storewalks);

			for(Storewalk_GetStorewalk storewalk : storewalks){
				storeNumberText = storewalk.getStoreNumber();
				walkTypeText = storewalk.getWalkType();
				if(storeNumberText.equals(storeId) && (walkTypeText.equals("Gaps") || walkTypeText.equals("GapsHighsLows") || walkTypeText.equals("MarketStreetGapsHighsLows")))	
				{
					System.out.println("Store number : " + storeNumberText );

					walkIdText = storewalk.getWalkId();
					System.out.println("Walk id : " + walkIdText );
					System.out.println("Walk type : " + walkTypeText );


					walkIds.add(walkIdText);

					//				List<GlhBurst_Departments> departments = storewalk.getDepartments();
					//				for(GlhBurst_Departments department : departments){
					//					departmentIdService = department.getId();
					//
					//					System.out.println("Department id : " + departmentIdService );	
					//				}

					//				List<GlhBurst_Groups> groups = storewalk.getGroups();
					//				for(GlhBurst_Groups group : groups){
					//					groupIdService = group.getId();
					//
					//					System.out.println("Group id : " + groupIdService );
					//				}

					//				List<GlhBurst_Sections> sections = storewalk.getSections();
					//				for(GlhBurst_Sections section : sections){
					//					sessionIdService = section.getId();
					//
					//					System.out.println("Session id : " + sessionIdService );
					//				}	

				}
			}
		}
		return walkIds;
	 }


	public static void getWalkIdStoreServices() throws Throwable {
		int responseCode = Response.getStatusLine().getStatusCode();
		int responseCodeE = 200;

		assertEquals(responseCode, responseCodeE, "Walk id details does not exist. Response code");

		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		glhBurst_StoreWalkJsonResp = objectMapper.readValue(Response.getEntity().getContent(), GlhBurst_Storewalk.class);
		String StoreWalkJSONresult = objectMapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(glhBurst_StoreWalkJsonResp);
		System.out.println("Sales order:\n" + StoreWalkJSONresult);

		System.out.println("Sales order:\n" + glhBurst_StoreWalkJsonResp);

		String walkId = glhBurst_StoreWalkJsonResp.getWalkId();
		System.out.println("Walk id : " + walkId);

		String storeNumber = glhBurst_StoreWalkJsonResp.getStoreNumber();
		System.out.println("Store number : " + storeNumber);

		String walkType = glhBurst_StoreWalkJsonResp.getWalkType();
		System.out.println("Walk type : " + walkType);


		List<Storewalk_Department> allDepartments = glhBurst_StoreWalkJsonResp.getDepartments();
		for(Storewalk_Department details : allDepartments){

			departmentId = details.getId();
			System.out.println("Department Id : " + departmentId);

			departmentName = details.getName();
			System.out.println("Department Name : " + departmentName);

			departmentSortOrder = details.getSortOrder();
			System.out.println("Department Sort order : " + departmentSortOrder);

			List<Storewalk_Group> allGroups = details.getGroups();
			for(Storewalk_Group group : allGroups){

				groupId = group.getId();
				System.out.println("Group Id : " + groupId);

				groupName = group.getName();
				System.out.println("Group Name : " + groupName);

				groupSortOrder = group.getSortOrder();
				System.out.println("Group Sort order : " + groupSortOrder);

				List<Storewalk_Section> allSection = group.getSections();
				for(Storewalk_Section section : allSection){

					sectionId = section.getId();
					System.out.println("Section Id : " + sectionId);

					sectionName = section.getName();
					System.out.println("Section Name : " + sectionId);

					sectionSortOrder = section.getSortOrder();
					System.out.println("Section Sort Order : " + sectionSortOrder);

					sectionStatus = section.getStatus();
					System.out.println("Section Status : " + sectionStatus);
					
					//items
//					List<GlhBurst_Items> allItems = section.getItems();
//					for(GlhBurst_Items item : allItems){
//						//productId
//						productId = item.getProductId();
//						System.out.println("product Id : " + productId);
//						
//						List<GlhBurst_Captures> allcaptures = item.getCaptures();
//						for(GlhBurst_Captures captures : allcaptures){
//							
//							captureType = captures.getCaptureType();
//							System.out.println("Capture Type : " + captureType);
//						}
//						
//					}
				}
			}

			storewalkDetails.put("DepartmentId", departmentId);
			storewalkDetails.put("DepartmentName", departmentName);
			storewalkDetails.put("DepartmentSortOrder", departmentSortOrder);
			storewalkDetails.put("GroupId", groupId);
			storewalkDetails.put("GroupName", groupName);
			storewalkDetails.put("GroupSortOrder", groupSortOrder);
			storewalkDetails.put("SectionId", sectionId);
			storewalkDetails.put("SectionName", sectionName);
			storewalkDetails.put("SectionSortOrder", sectionSortOrder);
			storewalkDetails.put("SectionStatus", sectionStatus);
			storewalkDetails.put("productId", productId);
			storewalkDetails.put("captureType", captureType);
		}
	}

	public static void verifyStorewalkResponse()throws Throwable {

		boolean isNotEmpty = false;

		if(!storewalkDetails.isEmpty()){

			isNotEmpty = true;

			boolean deptId = storewalkDetails.get("DepartmentId") != null;
			assertEquals(deptId, true, "Department Id are not present for storewalks");

			boolean deptName = storewalkDetails.get("DepartmentName") != null;
			assertEquals(deptName, true, "Department Name are not present for storewalks");

			boolean deptSortOrder = storewalkDetails.get("DepartmentSortOrder") != null;
			assertEquals(deptSortOrder, true, "Department Sort Order  are not present for storewalks");

			boolean groupId = storewalkDetails.get("GroupId") != null;
			assertEquals(groupId, true, "Group Id are not present for storewalks");

			boolean groupName = storewalkDetails.get("GroupName") != null;
			assertEquals(groupName, true, "Group Name are not present for storewalks");

			boolean groupSortOrder = storewalkDetails.get("GroupSortOrder") != null;
			assertEquals(groupSortOrder, true, "Group Sort Order are not present for storewalks");

			boolean sectionId = storewalkDetails.get("SectionId") != null;
			assertEquals(sectionId, true, "Section Id are not present for storewalks");

			boolean sectionName = storewalkDetails.get("SectionName") != null;
			assertEquals(sectionName, true, "Section Name are not present for storewalks");

			boolean sectionSortOrder = storewalkDetails.get("SectionSortOrder") != null;
			assertEquals(sectionSortOrder, true, "Section Sort Order are not present for storewalks");

			boolean sectionStatus = storewalkDetails.get("SectionStatus") != null;
			assertEquals(sectionStatus, true, "Section Status are not present for storewalks");
			
			boolean captureType = storewalkDetails.get("captureType") != null;
			assertEquals(captureType, true, "Capture Type not present for storewalks");
			//isLargeAdjustment
		}



	}

	public static void verifyStorewalkResponseCaptureType()throws Throwable {
		boolean isNotEmpty = false;

		if(!storewalkDetails.isEmpty()){

			isNotEmpty = true;

			boolean deptId = storewalkDetails.get("DepartmentId") != null;
			assertEquals(deptId, true, "Department Id are not present for storewalks");

			boolean deptName = storewalkDetails.get("DepartmentName") != null;
			assertEquals(deptName, true, "Department Name are not present for storewalks");

			boolean deptSortOrder = storewalkDetails.get("DepartmentSortOrder") != null;
			assertEquals(deptSortOrder, true, "Department Sort Order  are not present for storewalks");

			boolean groupId = storewalkDetails.get("GroupId") != null;
			assertEquals(groupId, true, "Group Id are not present for storewalks");

			boolean groupName = storewalkDetails.get("GroupName") != null;
			assertEquals(groupName, true, "Group Name are not present for storewalks");

			boolean groupSortOrder = storewalkDetails.get("GroupSortOrder") != null;
			assertEquals(groupSortOrder, true, "Group Sort Order are not present for storewalks");

			boolean sectionId = storewalkDetails.get("SectionId") != null;
			assertEquals(sectionId, true, "Section Id are not present for storewalks");

			boolean sectionName = storewalkDetails.get("SectionName") != null;
			assertEquals(sectionName, true, "Section Name are not present for storewalks");

			boolean sectionSortOrder = storewalkDetails.get("SectionSortOrder") != null;
			assertEquals(sectionSortOrder, true, "Section Sort Order are not present for storewalks");

			boolean sectionStatus = storewalkDetails.get("SectionStatus") != null;
			assertEquals(sectionStatus, true, "Section Status are not present for storewalks");

			boolean captureType = storewalkDetails.containsKey("CaptureType");
			assertEquals(captureType, false, "Capture type are not present for storewalks");
		}

		assertEquals(isNotEmpty, true, "All attributes are not present for storewalks");

	}

	public static void getSectionServiceResponse()throws Throwable {
		int responseCode = Response.getStatusLine().getStatusCode();
		int responseCodeE = 200;

		assertEquals(responseCode, responseCodeE, "Walk id details does not exist. Response code");

		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		glhBurst_SectionsJsonResp = objectMapper.readValue(Response.getEntity().getContent(), Storewalk_Section.class);
		String StoreWalkJSONresult = objectMapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(glhBurst_SectionsJsonResp);
		System.out.println("Sales order:\n" + StoreWalkJSONresult);

		System.out.println("Sales order:\n" + glhBurst_SectionsJsonResp);


		sectionApiId = glhBurst_SectionsJsonResp.getId();
		System.out.println("Section id : " + sectionApiId);

		sectionApiName = glhBurst_SectionsJsonResp.getName();
		System.out.println("Section name : " + sectionApiName);

		sectionApiSortOrder = glhBurst_SectionsJsonResp.getSortOrder();
		System.out.println("Section sort order : " + sectionApiSortOrder);

		sectionApiStatus = glhBurst_SectionsJsonResp.getStatus();
		System.out.println("Section status : " + sectionApiStatus);


		sectionDetails.put("SecionId", sectionApiId);
		sectionDetails.put("SectionName", sectionApiName);
		sectionDetails.put("SectionSortOrder", sectionApiSortOrder);
		sectionDetails.put("SectionStatus", sectionApiStatus);

	}


	public static void verifySectionResponse()throws Throwable {

		boolean isNotEmpty = false;

		if(!sectionDetails.isEmpty()){

			isNotEmpty = true;

			boolean deptId = storewalkDetails.get("SecionId") != null;
			assertEquals(deptId, true, "Secion Id are not present for section api");

			boolean deptName = storewalkDetails.get("SectionName") != null;
			assertEquals(deptName, true, "Section Name are not present for section api");

			boolean deptSortOrder = storewalkDetails.get("SectionSortOrder") != null;
			assertEquals(deptSortOrder, true, "Section Sort Order are not present for section api");

			boolean groupId = storewalkDetails.get("SectionStatus") != null;
			assertEquals(groupId, true, "Section Status are not present for section api");

		}

		assertEquals(isNotEmpty, true, "All attributes are not present for section api");

	}

	public static void verifySectionResponseCaptureType()throws Throwable {
		boolean isNotEmpty = false;

		if(!sectionDetails.isEmpty()){

			isNotEmpty = true;

			boolean deptId = storewalkDetails.get("SecionId") != null;
			assertEquals(deptId, true, "Secion Id are not present for section api");

			boolean deptName = storewalkDetails.get("SectionName") != null;
			assertEquals(deptName, true, "Section Name are not present for section api");

			boolean deptSortOrder = storewalkDetails.get("SectionSortOrder") != null;
			assertEquals(deptSortOrder, true, "Section Sort Order are not present for section api");

			boolean groupId = storewalkDetails.get("SectionStatus") != null;
			assertEquals(groupId, true, "Section Status are not present for section api");

			boolean captureType = storewalkDetails.containsKey("CaptureType");
			assertEquals(captureType, false, "Capture type are not present for section api");
		}

		assertEquals(isNotEmpty, true, "All attributes are not present for section api");
	}


	public static void deleteCount(String storeId, List<String> walkIds) throws URISyntaxException, ClientProtocolException, IOException {

		List<String> allWalkIds = walkIds;

		if(allWalkIds!=null)
		{

			for(String walkID : allWalkIds){

				String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
				String resource = applicationConfig.getDeleteCounts().getResource();
				resource = resource.replaceAll("\\bstoreId\\b", storeId);
				resource = resource.replaceAll("\\bwalkId\\b", walkID);

				URIBuilder uriBuilder = new URIBuilder(baseURI + resource);
				currentUri = uriBuilder.build();
				System.out.println(currentUri);

				HttpResponse getResponse = null;

				String Header1Key = "Authorization";

				headers1.put(Header1Key,"Basic VmdmUFhFWnhqTUR1ZGdKQUF6V1p3MENVb21BdXpKS0I6RXlhdXFJMGx2Tm1SQlJYQQ==");
				System.out.println("Headers for markdown are - "+headers);

				System.out.println("URI is \t" + currentUri + "headers1 are\t" + headers1);	
				if (currentUri != null)
					getResponse = WebServiceClient.deleteMethod(currentUri, headers1);

				else {
					System.out.println("\n URL value is missing.Please send valid URL to perform operation");
				}

				System.out.println("Delete walkid : " + walkID);
			}
		}

	}
	
	public static List<String> getWalkIdServicesMS(String storeId) throws Throwable {

		List<String> walkIds = new ArrayList<String>();

		String walkIdText = null;
		String storeNumberText;
		String walkTypeText;

		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("Response code : " + responseCode);
		int responseCodeE = 200;

		if (responseCode != 404) {

			assertEquals(responseCode, responseCodeE, "Walk id details does not exist. Response code");

			objectMapper.setSerializationInclusion(Include.NON_NULL);
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			storewalk_StorewalksJsonResp = objectMapper.readValue(Response.getEntity().getContent(),
					Storewalk_Storewalks.class);
			String StoreWalkJSONresult = objectMapper.writerWithDefaultPrettyPrinter()
					.writeValueAsString(storewalk_StorewalksJsonResp);
			System.out.println("Sales order:\n" + StoreWalkJSONresult);

			System.out.println("Sales order:\n" + storewalk_StorewalksJsonResp);

			List<Storewalk_GetStorewalk> storewalks = storewalk_StorewalksJsonResp.getStorewalks();
			System.out.println("Storewalks : " + storewalks);

			for (Storewalk_GetStorewalk storewalk : storewalks) {
				storeNumberText = storewalk.getStoreNumber();
				walkTypeText = storewalk.getWalkType();
				if (storeNumberText.equals(storeId) && (walkTypeText.equals("MarketStreetGapsHighsLows"))) {
					System.out.println("Store number : " + storeNumberText);
					walkIdText = storewalk.getWalkId();
					System.out.println("Walk id : " + walkIdText);
					System.out.println("Walk type : " + walkTypeText);
					walkIds.add(walkIdText);

				}
			}
		}
		return walkIds;
	}

	
}