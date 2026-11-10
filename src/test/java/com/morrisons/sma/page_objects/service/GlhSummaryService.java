package com.morrisons.sma.page_objects.service;

import static org.testng.Assert.assertEquals;

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

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.android.AndroidDriver;
import com.morrisons.sma.pojo.service.MarkdownPOJO.MarkdownLoginVo;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.GetStorewalksss_Storewalk;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.GlhSummary_Gaps;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.GlhSummary_Highs;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.GlhSummary_Level1;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.GlhSummary_Level2;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.GlhSummary_Lows;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.GlhSummary_Root;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.Storewalk_Root;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.CloseableHttpClientBuilder;
import com.morrisons.common.utility.ConfigLoader;
import com.morrisons.common.utility.ConstantFile;
import com.morrisons.common.utility.WebServiceClient;

public class GlhSummaryService {

	public static Map<String, String> headers = new HashMap<>();
	static ObjectMapper objectMapper = new ObjectMapper();
	public static HttpResponse Response;
	public static io.restassured.response.Response restResponse;

	private static AndroidDriver driveR;
	static MarkdownLoginVo mDLoginJsonResp = new MarkdownLoginVo();
	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();

	public static String accessTocken;
	String tokenaccess;
	String env = applicationConfig.getWebElementEnviroment().getEnv();
	public static String mDAccessTocken;
	static String mdLogin = null;
	public static URI currentUri;
	private static CloseableHttpClientBuilder cc = new CloseableHttpClientBuilder();

	String collegueUsername = applicationConfig.getUserCredentials().getCollegueUsername();
	String colleguePassword = applicationConfig.getUserCredentials().getColleguePassword();
	String managerUsername = applicationConfig.getUserCredentials().getManagerUsername();
	String managerPassword = applicationConfig.getUserCredentials().getManagerPassword();

	static String mdStorewalk = null;
	static String GlhSummaryJSONresult1 = null;

	////// Get GLH summary service attributes
	public static String storewalk_walkId = null;
	public static String storewalk_walkType = null;
	public static String storewalk_storeNumber = null;

	///// Level 1
	public static int level1_id = 0;
	public static String level1_name = null;
	public static int level1_sortOrder = 0;
	public static String level1_Gaps = null;
	public static String level1_Highs = null;
	public static String level1_Lows = null;
	public static String level1_totalGaps = null;
	public static String level1_totalHighs = null;
	public static String level1_totalLows = null;
	public static String level1_type = null;

	public static int level1_gaps_positiveStock = 0;
	public static int level1_gaps_incompleteCounts = 0;
	public static int level1_gaps_stockFound = 0;

	public static int level1_lows_incompleteCounts = 0;
	public static int level1_lows_stockFound = 0;

	public static int level1_highs_incompleteCounts = 0;

	////Level 2

	public static int level2_id = 0;
	public static String level2_name = null;
	public static int level2_sortOrder = 0;
	public static String level2_Gaps = null;
	public static String level2_Highs = null;
	public static String level2_Lows = null;
	public static String level2_totalGaps = null;
	public static String level2_totalHighs = null;
	public static String level2_totalLows = null;
	public static String level2_type = null;

	public static int level2_gaps_positiveStock = 0;
	public static int level2_gaps_incompleteCounts = 0;
	public static int level2_gaps_stockFound = 0;

	public static int level2_lows_incompleteCounts = 0;
	public static int level2_lows_stockFound = 0;

	public static int level2_highs_incompleteCounts = 0;

	public static Storewalk_Root createStorewalk_RootJsonResp = new Storewalk_Root();
	public static GlhSummary_Root glhSummary_RootJsonResp = new GlhSummary_Root();
	public static List<String> glhMSglhDepartments = new ArrayList<String>();
	public static List<String> marketSteetSectionsList = new ArrayList<String>();

	public static Map<String, String> headerForGetService() throws Throwable {
		String Header1Key = "Authorization";
		accessTocken = StorewalkServicePage.getGeneratedAccessTokenAppLogin(); 

		headers.put(Header1Key, "Bearer " + accessTocken);
		System.out.println("Headers and access token - " + headers);
		return headers;
	}

	public static HttpResponse getServicePerformOperation() throws Throwable {
		headers = headerForGetService();
		System.out.println("URI is \t" + currentUri + "headers are\t" + headers);
		if (currentUri != null)
			Response = WebServiceClient.getMethodResponse(currentUri, headers);
		else {
			System.out.println("\n URL value is missing.Please send valid URL to perform operation");
		}
		return Response;
	}
	
	


	//// Generating GLH summary api url - GLH and MS GLH walktype
	public void getGlhSummaryForGLH_MSGlh(String storeID) throws URISyntaxException, InterruptedException, ClientProtocolException, IOException {

		List<String> glhWalkIdList = StorewalkServicePage.glhWalkid;
		List<String> msGlhWalkid = StorewalkServicePage.msGlhWalkid;
		String walkIds  = "["+glhWalkIdList.get(0)+","+msGlhWalkid.get(0)+"]";//// Creating an array object [GLH walkid, MS glh walk id]


		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getGetGlhSummary().getResource();
		resource = resource.replaceAll("\\bstoreid\\b", storeID);
		resource =  resource + walkIds ;
		System.out.println("resource : " + resource); 
		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;

		Thread.sleep(500);
	}

	////Generating GLH summary api url - GLH / MS_Glh / Gaps walktype
	public void getGlhSummaryServiceUrl(String storeID,String walkType) throws URISyntaxException, InterruptedException, ClientProtocolException, IOException {
		List<String> walkidList = new ArrayList<String>();

		if(walkType.equals(ConstantFile.GAPSHIGHSLOWS)){
			walkidList = StorewalkServicePage.glhWalkid; ///Get GLH walk id list
		}
		if(walkType.equals(ConstantFile.MARKETSTREETGAPSHIGHSLOWS)){
			walkidList = StorewalkServicePage.msGlhWalkid; ///Get MS GLH walk id list
		}

		if(walkType.equals(ConstantFile.GAPS)){
			walkidList = StorewalkServicePage.gapsWalkid; ///Get Gap (PM gap) walk id list
		}

		String walkIds = "["+walkidList.get(0)+"]"; //// Creating Walk id object

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getGetGlhSummary().getResource();
		resource = resource.replaceAll("\\bstoreid\\b", storeID);
		resource =  resource + walkIds ;
		System.out.println("resource : " + resource); 
		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;

		Thread.sleep(500);
	}

	///// GLH summary api response
	public static void getGlhSummaryResponse()throws Throwable{

		System.out.println(Response);
		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("Get storewalkss response : " + responseCode);

		int responseCodeE = 200;

		if(responseCode==200 || responseCode==201){
			assertEquals(responseCode, responseCodeE, " Storewalk details does not exist. Response code");
			objectMapper.setSerializationInclusion(Include.NON_NULL);
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			glhSummary_RootJsonResp = objectMapper.readValue(Response.getEntity().getContent(), GlhSummary_Root.class);
			GlhSummaryJSONresult1 = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(glhSummary_RootJsonResp);
			System.out.println("GlhSummaryJSONresult1 : " + GlhSummaryJSONresult1);
			System.out.println("Get GLHSummary Response:\n" + glhSummary_RootJsonResp);

			List<GetStorewalksss_Storewalk> getStorewalksss_Storewalk = glhSummary_RootJsonResp.getStorewalks();

			for(GetStorewalksss_Storewalk storewalks : getStorewalksss_Storewalk){
				storewalk_storeNumber = storewalks.getStoreNumber();
				System.out.println("storewalk_storeNumber : " + storewalk_storeNumber);
				storewalk_walkId = storewalks.getWalkId();
				System.out.println("storewalk_walkId : " + storewalk_walkId);
				storewalk_walkType = storewalks.getWalkType();
				System.out.println("storewalk_walkType : " + storewalk_walkType);
			}

			//////// Level 1
			List<GlhSummary_Level1> glhSummary_Level1 = glhSummary_RootJsonResp.getLevel1();

			for(GlhSummary_Level1 level1 : glhSummary_Level1){

				level1_id = level1.getId();
				System.out.println("level1_id : " + level1_id);
				level1_name = level1.getName();
				System.out.println("level1_name : " + level1_name);
				level1_type = level1.getType();
				System.out.println("level1_type : " + level1_type);
				level1_sortOrder = level1.getSortOrder();
				System.out.println("level1_sortOrder : " + level1_sortOrder);

				GlhSummary_Gaps level1_Gaps = level1.getGaps();
				try {
				level1_gaps_incompleteCounts = level1_Gaps.getIncompleteCounts();
				System.out.println("gaps_incompleteCounts : " + level1_gaps_incompleteCounts);
				level1_gaps_positiveStock = level1_Gaps.getPositiveStock();
				System.out.println("gaps_positiveStock : " + level1_gaps_positiveStock);
				level1_gaps_stockFound = level1_Gaps.getStockFound();
				System.out.println("gaps_stockFound : " + level1_gaps_stockFound);

				GlhSummary_Lows level1_Lows = level1.getLows();
				level1_lows_incompleteCounts = level1_Lows.getIncompleteCounts();
				System.out.println("lows_incompleteCounts : " + level1_lows_incompleteCounts);
				level1_lows_stockFound = level1_Lows.getStockFound();
				System.out.println("lows_stockFound : " + level1_lows_stockFound);

				GlhSummary_Highs level1_Highs = level1.getHighs();
				level1_highs_incompleteCounts = level1_Highs.getIncompleteCounts();
				System.out.println("highs_incompleteCounts : " + level1_highs_incompleteCounts);

				level1_totalGaps = level1.getTotalGaps();
				System.out.println("level1_totalGaps : " + level1_totalGaps);
				level1_totalLows = level1.getTotalLows();
				System.out.println("level1_totalLows : " + level1_totalLows);
				level1_totalHighs = level1.getTotalHighs();
				System.out.println("level1_totalHighs : " + level1_totalHighs);
				}
				catch(Exception e){
				}
				
				//////// Level 2
				List<GlhSummary_Level2> glhSummary_Level2 = level1.getLevel2();

				for(GlhSummary_Level2 level2 : glhSummary_Level2){

					level2_id = level2.getId();
					System.out.println("level2_id : " + level2_id);
					level2_name = level2.getName();
					System.out.println("level2_name : " + level2_name);
					level2_type = level2.getType();
					System.out.println("level2_type : " + level2_type);
					level2_sortOrder = level2.getSortOrder();
					System.out.println("level2_sortOrder : " + level2_sortOrder);

					GlhSummary_Gaps level2_Gaps = level2.getGaps();
					try { 
					level2_gaps_incompleteCounts = level2_Gaps.getIncompleteCounts();
					System.out.println("level2_gaps_incompleteCounts : " + level2_gaps_incompleteCounts);
					level2_gaps_stockFound = level2_Gaps.getPositiveStock();
					System.out.println("level2_gaps_stockFound : " + level2_gaps_stockFound);
					level2_gaps_positiveStock = level2_Gaps.getStockFound();
					System.out.println("level2_gaps_positiveStock : " + level2_gaps_positiveStock);

					GlhSummary_Lows level2_Lows = level2.getLows();
					level2_lows_incompleteCounts = level2_Lows.getIncompleteCounts();
					System.out.println("level2_lows_incompleteCounts : " + level2_lows_incompleteCounts);
					level2_lows_stockFound = level2_Lows.getStockFound();
					System.out.println("level2_lows_stockFound : " + level2_lows_stockFound);

					GlhSummary_Highs level2_Highs = level2.getHighs();
					level2_highs_incompleteCounts = level2_Highs.getIncompleteCounts();
					System.out.println("level2_highs_incompleteCounts : " + level2_highs_incompleteCounts);

					level2_totalGaps = level2.getTotalGaps();
					System.out.println("level2_totalGaps : " + level2_totalGaps);
					level2_totalLows = level2.getTotalLows();
					System.out.println("level2_totalLows : " + level2_totalLows);
					level2_totalHighs = level2.getTotalHighs();
					System.out.println("level2_totalHighs : " + level2_totalHighs);
					}
					catch(Exception e){
					}
				}
			}
		}
	}

	
	//// Get Department list from GLH summary api response.
	public static void getDepartmentListFromApi(String storeId)throws Throwable{

		System.out.println(Response);
		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("Get storewalkss response : " + responseCode);

		int responseCodeE = 200;

		if(responseCode==200){
			assertEquals(responseCode, responseCodeE, " Storewalk details does not exist. Response code");
			objectMapper.setSerializationInclusion(Include.NON_NULL);
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			glhSummary_RootJsonResp = objectMapper.readValue(Response.getEntity().getContent(), GlhSummary_Root.class);
			GlhSummaryJSONresult1 = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(glhSummary_RootJsonResp);
			System.out.println("GlhSummaryJSONresult1 : " + GlhSummaryJSONresult1);
			System.out.println("Get GLHSummary Response:\n" + glhSummary_RootJsonResp);

			//////// Level 1
			List<GlhSummary_Level1> glhSummary_Level1 = glhSummary_RootJsonResp.getLevel1();

			for(GlhSummary_Level1 level1 : glhSummary_Level1){

				level1_id = level1.getId();
				System.out.println("level1_id : " + level1_id);
				level1_name = level1.getName();
				System.out.println("level1_name : " + level1_name);
				level1_type = level1.getType();
				System.out.println("level1_type : " + level1_type);
				level1_sortOrder = level1.getSortOrder();
				System.out.println("level1_sortOrder : " + level1_sortOrder);

				glhMSglhDepartments.add(level1_name); ////Storing Department name in List

				//////// Level 2
				List<GlhSummary_Level2> glhSummary_Level2 = level1.getLevel2();

				for(GlhSummary_Level2 level2 : glhSummary_Level2){

					level2_id = level2.getId();
					System.out.println("level2_id : " + level2_id);
					level2_name = level2.getName();
					System.out.println("level2_name : " + level2_name);
					level2_type = level2.getType();
					System.out.println("level2_type : " + level2_type);
					level2_sortOrder = level2.getSortOrder();
					System.out.println("level2_sortOrder : " + level2_sortOrder);

					if(level1_name.equals(ConstantFile.MARKETSTEET_DEPARTMENT)){
						marketSteetSectionsList.add(level2_name);////Storing Ms glh Sections name in List
					}
				}
			}
		}
	}
	
	public void getglhSummaryResponseIs200()throws Throwable {
		System.out.println(Response);
		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("GET GLH Summary response : " + responseCode);
		int responseCodeE = 200;
		assertEquals(responseCode, responseCodeE, "GET GLH Summary response is not 200");

	}

	public void verifyPositivestockundersection() {
		System.out.println("Glh Summary json response : " + GlhSummaryJSONresult1);
		boolean isPresent = GlhSummaryJSONresult1.contains("positiveStock");
		assertEquals(isPresent, true,"positiveStock is not displayed");		
	}

	public void verifyStockfoundunderSection() {
		System.out.println("Glh Summary json response : " + GlhSummaryJSONresult1);
		boolean isPresent = GlhSummaryJSONresult1.contains("stockFound");
		assertEquals(isPresent, true,"stockFound is not displayed");		
	}

	public void verifyIncompleteCountunderSection() {
		System.out.println("Glh Summary json response : " + GlhSummaryJSONresult1);
		boolean isPresent = GlhSummaryJSONresult1.contains("incompleteCounts");
		assertEquals(isPresent, true,"incompleteCounts is not displayed");			
	}

	public void verifyPositivestockunderDepartment() {
		System.out.println("Glh Summary json response : " + GlhSummaryJSONresult1);
		boolean isPresent = GlhSummaryJSONresult1.contains("positiveStock");
		assertEquals(isPresent, true,"positiveStock is not displayed");			
	}

	public void verifyStockfoundunderDepartment() {
		System.out.println("Glh Summary json response : " + GlhSummaryJSONresult1);
		boolean isPresent = GlhSummaryJSONresult1.contains("stockFound");
		assertEquals(isPresent, true,"stockFound is not displayed");			
	}

	public void verifyIncompleteCountunder() {
		System.out.println("Glh Summary json response : " + GlhSummaryJSONresult1);
		boolean isPresent = GlhSummaryJSONresult1.contains("incompleteCounts");
		assertEquals(isPresent, true,"incompleteCounts is not displayed");			
	}

	public void verifyGapsattribute() {
		System.out.println("Glh Summary json response : " + GlhSummaryJSONresult1);
		boolean isPresent = GlhSummaryJSONresult1.contains("gaps");
		assertEquals(isPresent, true,"gaps is not displayed");		
	}

	public void verifyLowsattribute() {
		System.out.println("Glh Summary json response : " + GlhSummaryJSONresult1);
		boolean isPresent = GlhSummaryJSONresult1.contains("lows");
		assertEquals(isPresent, true,"lows is not displayed");			
	}

	public void verifyHighsattribute() {
		System.out.println("Glh Summary json response : " + GlhSummaryJSONresult1);
		boolean isPresent = GlhSummaryJSONresult1.contains("highs");
		assertEquals(isPresent, true,"highs is not displayed");			
	}

	//Generating incorrect Authorization
	public static Map<String, String> headerForGetServiceError() throws Throwable {
		String Header1Key = "Authorization";
		accessTocken = StorewalkServicePage.getGeneratedAccessTokenAppLogin()+"xxx"; 

		headers.put(Header1Key, "Bearer " + accessTocken);
		System.out.println("Headers and access token - " + headers);
		return headers;
	}

	public static HttpResponse getServicePerformOperationError() throws Throwable {
		headers = headerForGetServiceError();
		System.out.println("URI is \t" + currentUri + "headers are\t" + headers);
		if (currentUri != null)
			Response = WebServiceClient.getMethodResponse(currentUri, headers);
		else {
			System.out.println("\n URL value is missing.Please send valid URL to perform operation");
		}
		return Response;
	}
	
	public void verifyAPIResponse400Or401() throws Throwable {
		System.out.println(Response);
		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("Create walkitem response : " + responseCode);

		boolean isExpected = false;

		if(responseCode==400 || responseCode==401)
		{
			isExpected = true;
		}
		assertEquals(true, isExpected, " Response code for service is not as expected");
	}
	
	public void verifyAPIResponse404() throws Throwable {
		System.out.println(Response);
		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("Create walkitem response : " + responseCode);

		boolean isExpected = false;

		if(responseCode==404)
		{
			isExpected = true;
		}

		assertEquals(true, isExpected, " Response code for service is not as expected");
	}
	
////Generating GLH summary api url - GLH and MS GLH walktype incorrect
	public void getGlhSummaryForGLH_MSGlhincorrect(String storeID) throws URISyntaxException, InterruptedException, ClientProtocolException, IOException {

		List<String> glhWalkIdList = StorewalkServicePage.glhWalkid;
		List<String> msGlhWalkid = StorewalkServicePage.msGlhWalkid;
		String walkIds  = "["+glhWalkIdList.get(0)+"11"+","+msGlhWalkid.get(0)+"11"+"]"; //// Creating an array object [GLH walkid, MS glh walk id]


		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getGetGlhSummary().getResource();
		resource = resource.replaceAll("\\bstoreid\\b", storeID);
		resource =  resource + walkIds ;
		System.out.println("resource : " + resource); 
		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;

		Thread.sleep(500);
	}

	public void verifyDepartmentidnName() {
			System.out.println("Glh Summary json response : " + GlhSummaryJSONresult1);
			boolean isPresent = GlhSummaryJSONresult1.contains(level1_name);
					assertEquals(isPresent, true,"name is not displayed");			
					boolean isPresent1 = GlhSummaryJSONresult1.contains("id");
					assertEquals(isPresent, true,"id is not displayed");			

	}

	public void verifySectionidnName() {
		System.out.println("Glh Summary json response : " + GlhSummaryJSONresult1);
		boolean isPresent = GlhSummaryJSONresult1.contains(level2_name);
				assertEquals(isPresent, true,"name is not displayed");			
				boolean isPresent1 = GlhSummaryJSONresult1.contains("id");
				assertEquals(isPresent, true,"id is not displayed");			

	}

}
