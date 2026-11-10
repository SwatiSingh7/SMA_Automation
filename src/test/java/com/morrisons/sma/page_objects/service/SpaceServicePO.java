package com.morrisons.sma.page_objects.service;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.CloseableHttpClientBuilder;
import com.morrisons.common.utility.ConfigLoader;
import com.morrisons.common.utility.WebServiceClient;
import com.morrisons.sma.pojo.service.MarkdownPOJO.MarkdownLoginVo;
import com.morrisons.sma.pojo.service.SpaceServicePOJO.Location;
import com.morrisons.sma.pojo.service.SpaceServicePOJO.SpaceServiceRoot;
import com.morrisons.sma.pojo.service.SpaceServicePOJO.StandardSpace;
import io.appium.java_client.android.AndroidDriver;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.utils.URIBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class SpaceServicePO {

	public static Map<String, String> headers = new HashMap<>();
	static ObjectMapper objectMapper = new ObjectMapper();
	public static HttpResponse Response;
	public static io.restassured.response.Response restResponse;

	private static AndroidDriver driveR;
	static MarkdownLoginVo mDLoginJsonResp = new MarkdownLoginVo();
	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();

	static String accessTocken;
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

	private static SpaceServiceRoot spaceServiceRootJsonResp = new SpaceServiceRoot();

	/// Get space 
	static String getSpace_storeNumber = null;
	static String getSpace_min = null;
	static double getSpace_totalFillQty = 0;
	static double getSpace_startOfDayQty = 0;
	static double getSpace_endOfDayQty = 0;
	static String getSpace_status = null;
	static String getSpace_dateFrom = null;
	static String getSpace_dateTo = null;
	static double getSpace_totalFillQty1 = 0;
	static double getSpace_startOfDayQty1 = 0;
	static double getSpace_endOfDayQty1 = 0;
	static int getSpace_planClass = 0;
	static String getSpace_planName = null;
	static String getSpace_planType = null;
	static String getSpace_gondola = null;
	static String getSpace_aisle = null;
	static String getSpace_side = null;
	static String getSpace_bayNumber = null;
	static String getSpace_shelfNumber = null;
	static String getSpace_position = null;
	static String getSpace_merchandiseType = null;
	static int getSpace_unitsWide = 0;
	static int getSpace_unitsHigh = 0;
	static int getSpace_unitsDeep = 0;
	static double getSpace_fillQty = 0;	
	static int getSpace_facings = 0;
	static String getSpace_dateFrom1 = null;
	static String getSpace_storeWalkSequence = null;
	static String getSpace_planBaySequence = null;
	static double getSpace_selBlockwidth = 0;
	static int getSpace_locationCount = 0;
	

	public static String getGeneratedAccessTokenAppLogin() throws Throwable {
		accessTocken = mDLoginJsonResp.getAccessToken();
		System.out.println("Access Tocken is " + accessTocken);

		return accessTocken;
	}

		public static Map<String, String> headerForGetService() {
			
			String HeaderKey =	applicationConfig.getGetSpaceServiceHeader().getKey();
					String HeaderValue = applicationConfig.getGetSpaceServiceHeader().getValue();

		headers.put(HeaderKey, HeaderValue);
		System.out.println("Headers and access token - " + headers);
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

	///// Get - Get Space
		public void getSpaceServiceUrl(String storeID, String productMin) throws URISyntaxException, InterruptedException, ClientProtocolException, IOException {

			Date date = new Date();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String currentDate = sdf.format(date);
			System.out.println("Current date : " + currentDate);
			
			String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
			String resource = applicationConfig.getGetSpace().getResource();
			String queryParameter = applicationConfig.getGetSpace().getQueryParameter();
			resource = resource.replaceAll("\\bstoreid\\b", storeID);
			resource = resource.replaceAll("\\bitemId\\b", productMin);
			resource = resource.replaceAll("\\bcurrentDate\\b", currentDate);

			URIBuilder uriBuilder = new URIBuilder(baseURI + resource + queryParameter);

			currentUri = uriBuilder.build();
			System.out.println(currentUri);
			mDAccessTocken = accessTocken;

			Thread.sleep(500);
		}
		
		
	///// Get - Get space service response
		public static void getSpaceServiceResponse()throws Throwable{

			System.out.println(Response);
			int responseCode = Response.getStatusLine().getStatusCode();
			System.out.println("Get space response : " + responseCode);

			int responseCodeE = 200;

			assertEquals(responseCode, responseCodeE, " Space location details does not exist. Response code");
			objectMapper.setSerializationInclusion(Include.NON_NULL);
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			spaceServiceRootJsonResp = objectMapper.readValue(Response.getEntity().getContent(), SpaceServiceRoot.class);
			String spaceServiceJsonResp = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(spaceServiceRootJsonResp);

			System.out.println("GetSpace Response:\n" + spaceServiceJsonResp);

			getSpace_storeNumber = spaceServiceRootJsonResp.getStoreNumber();
			System.out.println("Store number : " + getSpace_storeNumber);
			
			getSpace_min = spaceServiceRootJsonResp.getMin();
			System.out.println("Product min : " + getSpace_min);
			
			getSpace_totalFillQty = spaceServiceRootJsonResp.getTotalFillQty();
			System.out.println("Totally fill qty : " + getSpace_totalFillQty);
			
			getSpace_startOfDayQty = spaceServiceRootJsonResp.getStartOfDayQty();
			System.out.println("Start of the day qty : " + getSpace_startOfDayQty);
			
			getSpace_endOfDayQty = spaceServiceRootJsonResp.getEndOfDayQty();
			System.out.println("End of day qty : " + getSpace_endOfDayQty);
			
			getSpace_status = spaceServiceRootJsonResp.getStatus();
			System.out.println("Status : " + getSpace_status);
			

			StandardSpace standardSpace = spaceServiceRootJsonResp.getStandardSpace();
			
			getSpace_dateFrom = standardSpace.getDateFrom();
			System.out.println("Date from : " + getSpace_dateFrom);
			
			getSpace_dateTo = standardSpace.getDateTo();
			System.out.println("Date to : " + getSpace_dateTo);
			
			getSpace_totalFillQty1 = standardSpace.getTotalFillQty();
			System.out.println("Total fill qty1 : " + getSpace_totalFillQty1);
			
			getSpace_startOfDayQty1 = standardSpace.getStartOfDayQty();
			System.out.println("Start of the day qty1 : " + getSpace_startOfDayQty1);
			
			getSpace_endOfDayQty1 = standardSpace.getEndOfDayQty();
			System.out.println("End of the day qty1 : " + getSpace_endOfDayQty1);
			
			List<Location> locations = standardSpace.getLocations();
			
			for(Location location : locations){
			getSpace_planClass = location.getPlanClass();
			System.out.println("Plan class : " + getSpace_planClass);
			
			getSpace_planName = location.getPlanName();
			System.out.println("Plan name : " + getSpace_planName);
			
			getSpace_planType = location.getPlanType();
			System.out.println("Plan type : " + getSpace_planType);
			
			getSpace_gondola = location.getGondola();
			System.out.println("Gondola : " + getSpace_gondola);
			
			getSpace_aisle = location.getAisle();
			System.out.println("Aisle : " + getSpace_aisle);
			
			getSpace_side = location.getSide();
			System.out.println("Side : " + getSpace_side);
			
			getSpace_bayNumber = location.getBayNumber();
			System.out.println("Bay number : " + getSpace_bayNumber);
			
			getSpace_shelfNumber = location.getShelfNumber();
			System.out.println("Shelf number : " + getSpace_shelfNumber);
			
			getSpace_position = location.getPosition();
			System.out.println("Space position : " + getSpace_position);
			
			getSpace_merchandiseType = location.getMerchandiseType();
			System.out.println("Merchandise Type : " + getSpace_merchandiseType);
			
			getSpace_unitsWide = location.getUnitsWide();
			System.out.println("Units wide : " + getSpace_unitsWide);
			
			getSpace_unitsHigh = location.getUnitsHigh();
			System.out.println("Units high : " + getSpace_unitsHigh);
			
			getSpace_unitsDeep = location.getUnitsDeep();
			System.out.println("Units deep : " + getSpace_unitsDeep);
			
			getSpace_fillQty = location.getFillQty();
			System.out.println("Fill qty : " + getSpace_fillQty);
			
			getSpace_facings = location.getFacings();
			System.out.println("Facings : " + getSpace_facings);
			
			getSpace_dateFrom1 = location.getDateFrom();
			System.out.println("Date From1 : " + getSpace_dateFrom1);
			
			getSpace_storeWalkSequence = location.getStoreWalkSequence();
			System.out.println("Storewalk sequence : " + getSpace_storeWalkSequence);
			
			getSpace_planBaySequence = location.getPlanBaySequence();
			System.out.println("Plan bay sequence : " + getSpace_planBaySequence);
			
			getSpace_selBlockwidth = location.getSelBlockwidth();
			System.out.println("Sel block width : " + getSpace_selBlockwidth);
			
			getSpace_locationCount = location.getLocationCount();
			System.out.println("Location count : " + getSpace_locationCount);
			}
		}
}
