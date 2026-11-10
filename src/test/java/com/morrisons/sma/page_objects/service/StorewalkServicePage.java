package com.morrisons.sma.page_objects.service;

import static com.morrisons.sma.step_definitions.service.Product.API_ServiceStepDef.*;
import static org.testng.Assert.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.morrisons.common.utility.*;

import com.morrisons.sma.page_objects.mobile.old.DynamicRequestMethods;
import com.morrisons.sma.step_definitions.Web.OpticsFocalStepDef;
import com.morrisons.sma.step_definitions.service.Product.API_ServiceStepDef;
import com.morrisons.sma.step_definitions.service.old.StorewalkStepDefService;
import com.morrisons.sma.step_definitions.service.old.opticFocalStrategies;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.utils.URIBuilder;
import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.android.AndroidDriver;
import com.morrisons.sma.page_objects.mobile.old.GlhNegativePromptPO;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.CreateCapture_PostBody;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.CreateCapture_Root;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.CreateStorewalk_PostBody;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.CreateWalkitemBody;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.CreateWalkitem_PostBody;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.GetAllCaptures_Capture;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.GetAllCaptures_Root;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.GetCaptures_Root;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.GetCountLocationDetails;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.GetCountsDept;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.GetCountsGrp;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.GetCountsItems;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.GetCountsSect;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.GetCountsStorewalk;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.GetCountsStorewalkRoot;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.GetSections_Item;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.GetSections_Root;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.GetStorewalk_Capture;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.GetStorewalksss_Metadata;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.GetStorewalksss_Root;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.GetStorewalksss_Storewalk;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.PostStorewalk_Capture;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.PostStorewalk_CapturesRoot;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.Storewalk_Action;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.Storewalk_Capture;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.Storewalk_CommercialHierarchy;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.Storewalk_CountType;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.Storewalk_CreationAudit;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.Storewalk_Department;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.Storewalk_Group;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.Storewalk_Item;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.Storewalk_Pack;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.Storewalk_Plan;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.Storewalk_Root;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.Storewalk_Section;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.Storewalk_Who;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.Walkitem_Root;
import com.morrisons.sma.pojo.service.MarkdownPOJO.MarkdownLoginVo;
import com.morrisons.sma.pojo.service.CleanNRotateServicePOJO.CleanAndRotateLogin;
import com.morrisons.sma.step_definitions.mobile.old.CountPostStepDefService;

public class StorewalkServicePage {

	public static Map<String, String> headers = new HashMap<>();
	static ObjectMapper objectMapper = new ObjectMapper();
	public static HttpResponse Response;
	public static io.restassured.response.Response restResponse;
	private final Logger log = Logger.getLogger(StorewalkServicePage.class);
	private static AndroidDriver driveR;
	static MarkdownLoginVo mDLoginJsonResp = new MarkdownLoginVo();
	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
	static String accessTocken;
	static int oRespCodeCtr;
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

	private static Storewalk_Root createStorewalk_RootJsonResp = new Storewalk_Root();
	//private static Storewalk_Root createStorewalk_RootJsonResp = new Storewalk_Root();
	private static GetStorewalksss_Root getStorewalksss_RootJsonResp = new GetStorewalksss_Root();
	private static Walkitem_Root createWalkitem_RootJsonResp = new Walkitem_Root();
	private static Walkitem_Root getWalkitem_RootJsonResp =new Walkitem_Root();
	private static CreateCapture_Root createCapture_RootJsonResp = new CreateCapture_Root();
	private static GetCaptures_Root getCaptures_RootJsonResp = new GetCaptures_Root();
	private static GetAllCaptures_Root getAllCaptures_RootJsonResp = new GetAllCaptures_Root();
	private static GetSections_Root getSections_RootJsonResp = new GetSections_Root();
	private static GetCountsStorewalkRoot getCountsStorewalkRootJsonResp = new GetCountsStorewalkRoot();
	private static GetCountsStorewalk getCountsStorewalkJsonResp = new GetCountsStorewalk();

	//// Create Storewalk
	static String createStorewalk_walkId = null;
	static String createStorewalk_storeNumber = null;
	static String createStorewalk_walkType = null;
	static boolean createStorewalk_isCurfewStore;
	static String createStorewalk_when = null;
	static String createStorewalk_empId = null;
	static String createStorewalk_username = null;
	static String createStorewalk_dept_id = null;
	static String createStorewalk_dept_name = null;
	static String createStorewalk_dept_sortOrder = null;
	static String createStorewalk_grp_id = null;
	static String createStorewalk_grp_name = null;
	static String createStorewalk_grp_sortOrder = null;
	static String createStorewalk_section_id = null;
	static String createStorewalk_section_name = null;
	static String createStorewalk_section_sortOrder = null;
	static String createStorewalk_productId = null;
	static String createStorewalk_description = null;
	static String createStorewalk_qtyOnHand = null;
	static String createStorewalk_SOHValue = null;

	static String glh_walkId = null;

	//// Get Storewalk service
	static String getStorewalk_walkId = null;
	static String getStorewalk_storeNumber = null;
	static String getStorewalk_walkType = null;
	static boolean getStorewalk_isCurfewStore;
	static List<String> getStorewalk_locations = null;
	static String getStorewalk_when = null;
	static String getStorewalk_empId = null;
	static String getStorewalk_username = null;

	static String getStorewalk_name = null; 
	static String getStorewalk_scheduleReferenece = null;
	static String getStorewalk_date = null;
	static String getStorewalk_startTime = null;
	static String getStorewalk_endTime = null;
	static String getStorewalk_mode = null;
	static String getStorewalk_storewalkStatus = null;

	static String getStorewalk_dept_id = null;
	static String getStorewalk_dept_name = null;
	static String getStorewalk_dept_sortOrder = null;
	static String getStorewalk_grp_id = null;
	static String getStorewalk_grp_name = null;
	static String getStorewalk_grp_sortOrder = null;
	static String getStorewalk_section_id = null;
	static String getStorewalk_section_name = null;
	static String getStorewalk_section_sortOrder = null;
	static String getStorewalk_section_status = null;
	static String getStorewalk_productId = null;
	static String getStorewalk_description = null;
	static String getStorewalk_qtyOnHand = null;
	static String getStorewalk_SOHValue = null;

	//String d = new Date().toString();
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private static String currentDate = sdf.format(new Date());

	//// Get Storewalks service
	static String getStorewalkss_walkId = null;
	static String getStorewalkss_storeNumber = null;
	static String getStorewalkss_walkType = null;
	static String getStorewalkss_isCurfewStore = null;
	static List<String> getStorewalkss_locations = null;
	static String getStorewalkss_when = null;
	static String getStorewalkss_empId = null;
	static String getStorewalkss_username = null;

	static String getStorewalkss_limit = null;
	static String getStorewalkss_count = null;
	static String getStorewalkss_offset = null;

	static String getStorewalkss_mode = null;
	static String getStorewalkss_name = null;
	static String getStorewalkss_storewalkstatus = null;


	//// Create Walkitem service
	static String createWalkitem_productId = null;
	static String createWalkitem_standardUnitOfMeasure = null;
	static String createWalkitem_stockUom = null;
	static String createWalkitem_description = null;
	static String createWalkitem_qtyOnHand = null;
	static String createWalkitem_sOHValue = null;
	static String createWalkitem_qtyInTransit = null;
	static String createWalkitem_stockState = null;
	static String createWalkitem_isDeliveryExpectedDateToday = null;
	static String createWalkitem_isReceited = null;
	static String createWalkitem_price = null;
	static String createWalkitem_adjustmentPrice = null;
	static String createWalkitem_isLargeAdjustment = null;
	static String createWalkitem_packSize = null;
	static String createWalkitem_variance = null;
	static String createWalkitem_variancePercentage = null;
	static String createWalkitem_partOfCount = null;
	static String createWalkitem_reviewCaptureCount = null;
	static String createWalkitem_actionType = null;
	static String createWalkitem_when = null;
	static String createWalkitem_empId = null;
	static String createWalkitem_username = null;
	static String createWalkitem_type = null;
	static String createWalkitem_pin = null;
	static String createWalkitem_weight = null;
	static String createWalkitem_quantity = null;
	static String createWalkitem_group = null;
	static String createWalkitem_class_ = null;
	static String createWalkitem_division = null;
	static String createWalkitem_subclass = null;
	static String createWalkitem_className = null;
	static String createWalkitem_groupName = null;
	static String createWalkitem_department = null;
	static String createWalkitem_divisionName = null;
	static String createWalkitem_subclassName = null;
	static String createWalkitem_departmentName = null;

	static String createWalkitem_class = null;
	static String createWalkitem_plan_type = null;
	static String createWalkitem_name = null;
	static String createWalkitem_planLocation = null;
	static String createWalkitem_fillQty = null;
	static String createWalkitem_storeWalkSequence = null;

	/// Get walkitem 
	static String getWalkitem_productId = null;
	static String getWalkitem_standardUnitOfMeasure = null;
	static String getWalkitem_stockUom = null;
	static String getWalkitem_description = null;
	static String getWalkitem_qtyOnHand = null;
	static String getWalkitem_sOHValue = null;
	static String getWalkitem_qtyInTransit = null;
	static String getWalkitem_stockState = null;
	static String getWalkitem_isDeliveryExpectedDateToday = null;
	static String getWalkitem_isReceited = null;
	static String getWalkitem_rangeStatus = null;
	static String getWalkitem_price = null;
	static String getWalkitem_adjustmentPrice = null;
	static String getWalkitem_isLargeAdjustment = null;
	static String getWalkitem_packSize = null;
	static String getWalkitem_variance = null;
	static String getWalkitem_variancePercentage = null;
	static String getWalkitem_partOfCount = null;
	static String getWalkitem_reviewCaptureCount = null;
	static String getWalkitem_actionType = null;
	static String getWalkitem_when = null;
	static String getWalkitem_empId = null;
	static String getWalkitem_username = null;
	static String getWalkitem_qty = null;
	static String getWalkitem_unit = null;	
	static String getWalkitem_type = null;
	static String getWalkitem_pin = null;
	static String getWalkitem_weight = null;
	static String getWalkitem_quantity = null;
	static String getWalkitem_group = null;
	static String getWalkitem_class_ = null;
	static String getWalkitem_division = null;
	static String getWalkitem_subclass = null;
	static String getWalkitem_className = null;
	static String getWalkitem_groupName = null;
	static String getWalkitem_department = null;
	static String getWalkitem_divisionName = null;
	static String getWalkitem_subclassName = null;
	static String getWalkitem_departmentName = null;
	static String getWalkitem_class = null;
	static String getWalkitem_plan_type = null;
	static String getWalkitem_name = null;
	static String getWalkitem_planLocation = null;
	static String getWalkitem_fillQty = null;
	static String getWalkitem_storeWalkSequence = null;

	static String getWalkitem_countType = null;

	/// Create capture
	static String createCapture_captureId = null;
	static String createCapture_captureType = null;
	static String createCapture_captureStatus = null;
	static String createCapture_qty = null;
	static String createCapture_value = null;
	static String createCapture_location = null;
	static String createCapture_isACase = null;
	static String createCapture_when = null;
	static String createCapture_empId = null;
	static String createCapture_username = null;

	//// Get captures
	static String  getCaptures_captureId = null;
	static String  getCaptures_captureType = null;
	static String  getCaptures_captureStatus = null;
	static String  getCaptures_qty = null;
	static String  getCaptures_value = null;
	static String  getCaptures_location = null;
	static String  getCaptures_isACase = null;
	static String  getCaptures_when = null;
	static String  getCaptures_empId = null;
	static String  getCaptures_username = null;

	//// Get all captures 
	static String getAllCaptures_productId = null;
	static String getAllCaptures_description = null;
	static String getAllCaptures_sectionId = null;
	static String getAllCaptures_sectionStatus = null;

	//// Get section
	static String getSection_id = null;
	static String getSection_name = null;
	static String getSection_sortOrder = null;
	static String getSection_status = null;

	static String getStorewalk_countLocation = null;
	static String getStorewalk_countStatus = null;

	public static Map<String,String> storewalkDetails = new HashMap<String,String>(); 

	public static Map<String,String> walkItemResponse = new HashMap<String,String>(); 

	public static List<String> glhWalktypeList = new ArrayList<String>();
	public static List<String> countWalktypeList = new ArrayList<String>();
	private static List<String> marketstreetWalktypeList = new ArrayList<String>();

	static String StorewalkJSONResp = null;
	static String SectionAPIJsonResp = null;
	public static Map<String,String> storewalkStoreResponse = new HashMap<String,String>();
	public static Map<String,String> getGroupAndItemId = new HashMap<String,String>();

	public static Map<String,String> sectionResponse = new HashMap<String,String>(); 

	public static Map<String,String> groupDeptSectionService = new TreeMap<String,String>();

	public static String warehouseGroup = null;

	public static List<String> sectionCaptureTypes = new ArrayList<String>();

	public static String postStorewalkBody = null;

	public static Map<String,String> walkIdAndType = new HashMap<String,String>();

	public static List<String> glhAndMSglhWalkid = new ArrayList<String>();
	public static List<String> glhWalkid = new ArrayList<String>();
	public static List<String> msGlhWalkid = new ArrayList<String>();
	public static List<String> gapsWalkid = new ArrayList<String>();
	public static Map<String,String> walkIdProductId = new HashMap<String,String>();

	public static Map<String,String> productCaptureType = new HashMap<String,String>();
	public static Map<String,String> productCaptureStatus = new HashMap<String,String>();
	public static Map<String,String> productCaptureQty = new HashMap<String,String>();

	public static Map<String,String> countsLocationAndStatus = new TreeMap<String,String>();
	public static Map<String,String> productCountType = new TreeMap<String,String>();
	public static Map<String,String> productActionType = new TreeMap<String,String>();
	public static Map<String,String> productRangeStatus = new TreeMap<String,String>();
	
	public static Map<String,String> countNameAndWalkid = new HashMap<String,String>();
	List<String> itemList = new ArrayList<String>();


	public static String getGeneratedAccessTokenAppLogin() throws Throwable {
//		accessTocken = mDLoginJsonResp.getAccessToken();
		accessTocken = sRespData.get("access_token");
		System.out.println("Access Tocken is " + accessTocken);

		return accessTocken;
	}

	public static Map<String, String> headerBasic() {
		String Header1Key = "Authorization";

		headers.put(Header1Key,"Basic VmdmUFhFWnhqTUR1ZGdKQUF6V1p3MENVb21BdXpKS0I6RXlhdXFJMGx2Tm1SQlJYQQ==");
		System.out.println("Headers and access token  - "+headers);

		return headers;
	}

	public static Map<String, String> headerForGetService() {
		String Header1Key = "Authorization";

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

	public static HttpResponse deleteMethod(URI currentUri,Map<String,String> headerMap) throws ClientProtocolException, IOException
	{

		HttpClient client = cc.build();		
		HttpDelete deleteRequest = new HttpDelete(currentUri);
		String headerKey="";
		String headerValue="";

		Iterator entries = headerMap.entrySet().iterator();
		while (entries.hasNext()) {
			Map.Entry entry = (Map.Entry) entries.next();
			headerKey = (String)entry.getKey();
			headerValue = (String)entry.getValue();
			System.out.println("Key = " + headerKey + ", Value = " + headerValue);
			deleteRequest.addHeader(headerKey, headerValue);
		}

		HttpResponse response = client.execute(deleteRequest);

		return response;
	}

	///////// Login service
	public void requestMadeToGoogle(String sReqData) throws Throwable{
		OpticsFocalStepDef oObj = new OpticsFocalStepDef();
		String sAccessToken = oObj.getAccessToken();
		System.out.println("Access token captured " + sAccessToken);
		String filePath = "/json-files/service/accessToken.txt";
		ApplicationContext applicationContext = new ApplicationContext();
		ApplicationContext.oKeyField.put("grant_type", "grant_type=password&id_token=" + sAccessToken);
		String text = "grant_type=password&id_token=" + sAccessToken;
		RequestBody body =
				RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), text);

		Thread.sleep(1000);
		opticFocalStrategies.jsonGETResponseString = WebServicesUtilities.retryPOSTRequest_Text("https://sit-api.morrisons.com", "/user/v2/token", "apikey", "ZwQGsEN0f65kORZ8EVQlJWA2bGNbHls0", text);
		Object oResp = opticFocalStrategies.jsonGETResponseString;
		Integer responseCode=WebServicesRetry.responseCode;
		if(responseCode != 200 && oRespCodeCtr < 3){
			oRespCodeCtr++;
			requestMadeToGoogle(sReqData);
		}
	}
	public void requestMadeToSmaAppCollegueLogin() throws Throwable{
		CleanAndRotateLogin crLgoin = new CleanAndRotateLogin();
		crLgoin.setUserName(collegueUsername);

		crLgoin.setPassword(colleguePassword);
		crLgoin.setProvider("morrisons");
		String crLoginBody = objectMapper.writeValueAsString(crLgoin);
		System.out.println("Payload body is " + crLoginBody);
		postLoginService(crLoginBody);
		Response = postOperationForLogin();

		Thread.sleep(3000);
	}

	public void requestMadeToSmaAppManagerLogin() throws Throwable{
		CleanAndRotateLogin crLgoin = new CleanAndRotateLogin();
		crLgoin.setUserName(managerUsername);

		crLgoin.setPassword(managerPassword);

		crLgoin.setProvider("morrisons");
		String crLoginBody = objectMapper.writeValueAsString(crLgoin);
		System.out.println("Payload body is " + crLoginBody);
		postLoginService(crLoginBody);
		Response = postOperationForLogin();
		Thread.sleep(3000);
	}

	public static URI postLoginService(String mdLoginBody) throws URISyntaxException {

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

	public static HttpResponse postOperationForLogin() throws ClientProtocolException, IOException, InterruptedException {
		HttpResponse getResponse = null;
		headers.clear();
		headers = getPostHeadersForMdLogin();
		System.out.println("URI is \t" + currentUri + "headers are\t" + headers);
		System.out.println("payload details is 2 = " + mdLogin);
		if (currentUri != null){
			Thread.sleep(3000);
			getResponse = WebServiceClient.postMethodResponse(currentUri, headers, mdLogin);
		}
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

	public void getSmaAppLoginServiceResponse() throws Throwable{
		int responseCode = Response.getStatusLine().getStatusCode();
		int responseCodeE = 200;

		assertEquals(responseCode, responseCodeE, "Issues observed while generating access token");
		mDLoginJsonResp = objectMapper.readValue(Response.getEntity().getContent(), MarkdownLoginVo.class);
		String ProductJSONresult = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mDLoginJsonResp);
		System.out.println("Markdown Login Response:\n" + ProductJSONresult);
		Thread.sleep(500);
	}

	///////////////   Create Walkitem service

	///// Post - Create Storewalk
	public void createStorewalkServiceUrl(String storeID,String type)
			throws URISyntaxException, ClientProtocolException, IOException, InterruptedException {

		CreateStorewalk_PostBody createStorewalk_PostBody = new CreateStorewalk_PostBody();
		createStorewalk_PostBody.setType(type);

		String storewalkServiceBody = objectMapper.writeValueAsString(createStorewalk_PostBody);
		System.out.println("Payload body is " + storewalkServiceBody);

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getCreateStorewalk().getResource();
		resource = resource.replaceAll("\\bstoreId\\b", storeID);

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);
		mdStorewalk = storewalkServiceBody;
		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;

	}

	///// Post - Create Storewalk with response type
	public void createStorewalkWithResponseTypeUrl(String storeID,String type,String responsetype)
			throws URISyntaxException, ClientProtocolException, IOException, InterruptedException {

		CreateStorewalk_PostBody createStorewalk_PostBody = new CreateStorewalk_PostBody();
		createStorewalk_PostBody.setType(type);
		createStorewalk_PostBody.setResponsetype(responsetype);

		String storewalkServiceBody = objectMapper.writeValueAsString(createStorewalk_PostBody);
		System.out.println("Payload body is " + storewalkServiceBody);

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getCreateStorewalk().getResource();
		resource = resource.replaceAll("\\bstoreId\\b", storeID);

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);
		mdStorewalk = storewalkServiceBody;
		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;

	}

	///// Post - Create Storewalk Negative prompt
	public void createStorewalkNegativePrompt(String storeID,String type)
			throws URISyntaxException, ClientProtocolException, IOException, InterruptedException {

		CreateStorewalk_PostBody createStorewalk_PostBody = new CreateStorewalk_PostBody();
		createStorewalk_PostBody.setType(type);
		createStorewalk_PostBody.setReason("NegativeStock");

		String storewalkServiceBody = objectMapper.writeValueAsString(createStorewalk_PostBody);
		System.out.println("Payload body is " + storewalkServiceBody);

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getCreateStorewalk().getResource();
		resource = resource.replaceAll("\\bstoreId\\b", storeID);

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);
		mdStorewalk = storewalkServiceBody;
		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;

	}

	///// Post - Create Storewalk service response
	public static void createStorewalkServicesStatus()throws Throwable{

		System.out.println(Response);
		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("Create storewalk response : " + responseCode);

		if(responseCode==200 || responseCode==201){

			objectMapper.setSerializationInclusion(Include.NON_NULL);
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			createStorewalk_RootJsonResp = objectMapper.readValue(Response.getEntity().getContent(), Storewalk_Root.class);
			String ProductJSONresult1 = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(createStorewalk_RootJsonResp);

			System.out.println("CreateStorewalk Response:\n" + createStorewalk_RootJsonResp);

			createStorewalk_walkId = createStorewalk_RootJsonResp.getWalkId();
			System.out.println("Walk id : " + createStorewalk_walkId);

			createStorewalk_storeNumber = createStorewalk_RootJsonResp.getStoreNumber();
			System.out.println("Store number : " + createStorewalk_storeNumber);

			createStorewalk_walkType = createStorewalk_RootJsonResp.getWalkType();
			System.out.println("Walk type : " + createStorewalk_walkType);

			if(createStorewalk_walkType.equals(ConstantFile.GAPSHIGHSLOWS)){
				glhWalkid.add(createStorewalk_walkId); ///This list is added for GapsHighsLows Summary api 
			}
			if(createStorewalk_walkType.equals(ConstantFile.MARKETSTREETGAPSHIGHSLOWS)){
				msGlhWalkid.add(createStorewalk_walkId); ///This list is added for Marketstreet GapsHighsLows Summary api 
			}

			if(createStorewalk_walkType.equals(ConstantFile.GAPS)){
				gapsWalkid.add(createStorewalk_walkId); ///This list is added for Gaps(PM Gap) Summary api 
			}

			createStorewalk_isCurfewStore = createStorewalk_RootJsonResp.getIsCurfewStore();
			System.out.println("Curfew store : " + createStorewalk_isCurfewStore);

			Storewalk_CreationAudit createStorewalk_CreationAudit = createStorewalk_RootJsonResp.getCreationAudit();

			createStorewalk_when = createStorewalk_CreationAudit.getWhen();
			System.out.println("When : " + createStorewalk_when);

			Storewalk_Who createStorewalk_Who = createStorewalk_CreationAudit.getWho();

			createStorewalk_empId = createStorewalk_Who.getEmpId();
			System.out.println("Emp id : " + createStorewalk_empId);

			createStorewalk_username = createStorewalk_Who.getUsername();
			System.out.println("Username : " + createStorewalk_username);

			//Departments

			try{
				List<Storewalk_Department> createStorewalk_Department = createStorewalk_RootJsonResp.getDepartments();

				for(Storewalk_Department department : createStorewalk_Department){

					createStorewalk_dept_id = department.getId();
					System.out.println("Dept id : " + createStorewalk_dept_id);

					createStorewalk_dept_name = department.getName();
					System.out.println("DeptName : " + createStorewalk_dept_name);

					createStorewalk_dept_sortOrder = department.getSortOrder();
					System.out.println("Dept Sort order : " + createStorewalk_dept_sortOrder);

					List<Storewalk_Group> createStorewalk_Group = department.getGroups();
					for(Storewalk_Group group : createStorewalk_Group){

						createStorewalk_grp_id = group.getId();
						System.out.println("Group id : " + createStorewalk_grp_id);

						createStorewalk_grp_name = group.getName();
						System.out.println("Group name : " + createStorewalk_grp_name);

						createStorewalk_grp_sortOrder = group.getSortOrder();
						System.out.println("Group sort order : " + createStorewalk_grp_sortOrder);

						List<Storewalk_Section> createStorewalk_Section = group.getSections();
						for(Storewalk_Section section : createStorewalk_Section){

							createStorewalk_section_id = section.getId();
							System.out.println("Section id : " + createStorewalk_section_id);

							createStorewalk_section_name = section.getName();
							System.out.println("Section name : " + createStorewalk_section_name);

							createStorewalk_section_sortOrder = section.getSortOrder();
							System.out.println("Section sort order : " + createStorewalk_section_sortOrder);

							List<Storewalk_Item> createStorewalk_Item = section.getItems();
							for(Storewalk_Item item : createStorewalk_Item){

								createStorewalk_productId = item.getProductId();
								System.out.println("Item id : " + createStorewalk_productId);

								createStorewalk_description = item.getDescription();
								System.out.println("Item description : " + createStorewalk_description);

								createStorewalk_qtyOnHand = item.getQtyOnHand();
								System.out.println("Item qty on hand : " + createStorewalk_qtyOnHand);

								createStorewalk_SOHValue = item.getsOHValue();
								System.out.println("Item soh value : " + createStorewalk_SOHValue);

							}
						}
					}
				}
			}
			catch(Exception e){}
		}
	}

	public void getAccessToken(){

	}


	///// Get - Get Storewalk
	public void getStorewalkServiceUrl(String storeID) throws URISyntaxException, InterruptedException, ClientProtocolException, IOException {

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getGetStoreWalkForStore().getResource();
		resource = resource.replaceAll("\\bstoreid\\b", storeID);
		resource = resource.replaceAll("\\bwalkid\\b", createStorewalk_walkId);

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;

		Thread.sleep(500);
	}

	///// Get - Get Storewalk - Negative prompt
	public void getStorewalkForNegativePrompt(String storeID) throws URISyntaxException, InterruptedException, ClientProtocolException, IOException {

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getGetStoreWalkForStore().getResource();
		resource = resource.replaceAll("\\bstoreid\\b", storeID);
		resource = resource.replaceAll("\\bwalkid\\b", glh_walkId);

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;

		Thread.sleep(500);
	}

	///// Get - Get Storewalk with attributes
	public void getStorewalkServiceWithAttributeUrl(String storeID) throws URISyntaxException, InterruptedException, ClientProtocolException, IOException {

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getGetStoreWalkForAttributes().getResource();
		resource = resource.replaceAll("\\bstoreid\\b", storeID);
		resource = resource.replaceAll("\\bwalkid\\b", createStorewalk_walkId);

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;

		Thread.sleep(500);
	}

	///// Get - Get Storewalk with capture type
	public void getStorewalkServiceWithCaptureType(String storeID,String captureType) throws URISyntaxException, InterruptedException, ClientProtocolException, IOException {

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getGetStoreWalkCaptureType().getResource();
		resource = resource.replaceAll("\\bstoreid\\b", storeID);
		resource = resource.replaceAll("\\bwalkid\\b", createStorewalk_walkId);
		resource = resource.replaceAll("\\bcaptureType\\b", captureType);

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;

		Thread.sleep(500);
	}

	

	///// Get - Get Storewalk service response
	public static void getGetStorewalkServicesResponse()throws Throwable{

		System.out.println(Response);
		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("Get storewalk response : " + responseCode);

		int responseCodeE = 200;

		assertEquals(responseCode, responseCodeE, " Storewalk details does not exist. Response code");
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		createStorewalk_RootJsonResp = objectMapper.readValue(Response.getEntity().getContent(), Storewalk_Root.class);
		StorewalkJSONResp = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(createStorewalk_RootJsonResp);

		System.out.println("GetStorewalk Response:\n" + createStorewalk_RootJsonResp);

		getStorewalk_walkId = createStorewalk_RootJsonResp.getWalkId();
		System.out.println("Walk id : " + getStorewalk_walkId);

		getStorewalk_storeNumber = createStorewalk_RootJsonResp.getStoreNumber();
		System.out.println("Store number : " + getStorewalk_storeNumber);

		getStorewalk_walkType = createStorewalk_RootJsonResp.getWalkType();
		System.out.println("Walk type : " + getStorewalk_walkType);

		getStorewalk_isCurfewStore = createStorewalk_RootJsonResp.getIsCurfewStore();
		System.out.println("Curfew store : " + getStorewalk_isCurfewStore);



		Storewalk_CreationAudit GetStorewalk_CreationAudit = createStorewalk_RootJsonResp.getCreationAudit();

		getStorewalk_when = GetStorewalk_CreationAudit.getWhen();
		System.out.println("When : " + getStorewalk_when);

		Storewalk_Who getStorewalk_Who = GetStorewalk_CreationAudit.getWho();

		getStorewalk_empId = getStorewalk_Who.getEmpId();
		System.out.println("Emp id : " + getStorewalk_empId);

		getStorewalk_username = getStorewalk_Who.getUsername();
		System.out.println("Username : " + getStorewalk_username);


		try
		{
			//Departments

			List<Storewalk_Department> getStorewalk_Department = createStorewalk_RootJsonResp.getDepartments();

			for(Storewalk_Department department : getStorewalk_Department){

				getStorewalk_dept_id = department.getId();
				System.out.println("Dept id : " + getStorewalk_dept_id);

				getStorewalk_dept_name = department.getName();
				System.out.println("DeptName : " + getStorewalk_dept_name);

				getStorewalk_dept_sortOrder = department.getSortOrder();
				System.out.println("Dept Sort order : " + getStorewalk_dept_sortOrder);

				List<Storewalk_Group> getStorewalk_Group = department.getGroups();
				for(Storewalk_Group group : getStorewalk_Group){

					getStorewalk_grp_id = group.getId();
					System.out.println("Group id : " + getStorewalk_grp_id);

					getStorewalk_grp_name = group.getName();
					System.out.println("Group name : " + getStorewalk_grp_name);

					getStorewalk_grp_sortOrder = group.getSortOrder();
					System.out.println("Group sort order : " + getStorewalk_grp_sortOrder);

					List<Storewalk_Section> getStorewalk_Section = group.getSections();
					for(Storewalk_Section section : getStorewalk_Section){

						getStorewalk_section_id = section.getId();
						System.out.println("Section id : " + getStorewalk_section_id);

						getStorewalk_section_name = section.getName();
						System.out.println("Section name : " + getStorewalk_section_name);

						getStorewalk_section_sortOrder = section.getSortOrder();
						System.out.println("Section sort order : " + getStorewalk_section_sortOrder);

						List<Storewalk_Item> getStorewalk_Item = section.getItems();
						for(Storewalk_Item item : getStorewalk_Item){

							getStorewalk_productId = item.getProductId();
							System.out.println("Item id : " + getStorewalk_productId);

							getStorewalk_description = item.getDescription();
							System.out.println("Item description : " + getStorewalk_description);

							getStorewalk_qtyOnHand = item.getQtyOnHand();
							System.out.println("Item qty on hand : " + getStorewalk_qtyOnHand);

							getStorewalk_SOHValue = item.getsOHValue();
							System.out.println("Item soh value : " + getStorewalk_SOHValue);

						}
					}
				}
			}
		}
		catch(Exception e){}
	}

	public void verifyCaptureAttributeIsExluded(){
		System.out.println("Storewalk json response : " + StorewalkJSONResp);

		boolean isPresent = StorewalkJSONResp.contains("captureType");

		assertEquals(isPresent, false,"Capture type attribute is present");
	}

	public void verifyCaptureInSectionApi(){
		System.out.println("Section json response : " + SectionAPIJsonResp);

		boolean isPresent = SectionAPIJsonResp.contains("captureType");

		assertEquals(isPresent, false,"Capture type attribute is present");
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


	///// To get storewalk for all store id
	///// Get - Get Storewalkssss
	public void getStorewalksssServiceUrl() throws URISyntaxException, InterruptedException, ClientProtocolException, IOException {

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getGetStoreWalks().getResource();
		resource = resource.replaceAll("\\bcurrentDate/\\b", currentDate);

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		currentUri = uriBuilder.build();
		log.info("currentUri"+currentUri);
		mDAccessTocken = accessTocken;
		Thread.sleep(500);
	}


	///// Get - Get Storewalksss service response
	public  void getGetStorewalksssServicesResponse()throws Throwable{

		System.out.println(Response);
		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("Get storewalkss response : " + responseCode);

		int responseCodeE = 200;

		if(responseCode==200){
			assertEquals(responseCode, responseCodeE, " Storewalk details does not exist. Response code");
			objectMapper.setSerializationInclusion(Include.NON_NULL);
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			getStorewalksss_RootJsonResp = objectMapper.readValue(Response.getEntity().getContent(), GetStorewalksss_Root.class);
			String ProductJSONresult1 = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(getStorewalksss_RootJsonResp);

			System.out.println("GetStorewalkss Response:\n" + getStorewalksss_RootJsonResp);

			List<GetStorewalksss_Storewalk> getStorewalksss_Storewalk = getStorewalksss_RootJsonResp.getStorewalks();

			for(GetStorewalksss_Storewalk storewalk : getStorewalksss_Storewalk)
			{
				getStorewalkss_walkId = storewalk.getWalkId();
				System.out.println("Walk id : " + getStorewalkss_walkId);

				getStorewalkss_storeNumber = storewalk.getStoreNumber();
				System.out.println("Store number : " + getStorewalkss_storeNumber);

				getStorewalkss_walkType = storewalk.getWalkType();
				System.out.println("Walk type : " + getStorewalkss_walkType);

				getStorewalkss_isCurfewStore = storewalk.getIsCurfewStore();
				System.out.println("Curfew store : " + getStorewalkss_isCurfewStore);


				Storewalk_CreationAudit getStorewalkss_CreationAudit = storewalk.getCreationAudit();

				getStorewalkss_when = getStorewalkss_CreationAudit.getWhen();
				System.out.println("When : " + getStorewalkss_when);

				Storewalk_Who getStorewalk_Who = getStorewalkss_CreationAudit.getWho();

				getStorewalkss_empId = getStorewalk_Who.getEmpId();
				System.out.println("Emp id : " + getStorewalkss_empId);

				getStorewalkss_username = getStorewalk_Who.getUsername();
				System.out.println("Username : " + getStorewalkss_username);
				//
				if(getStorewalkss_walkType.contains(ConstantFile.GAPSHIGHSLOWS)||getStorewalkss_walkType.contains(ConstantFile.GAPS)){
					glhWalktypeList.add(getStorewalkss_walkId);
				}
				if(getStorewalkss_walkType.contains(ConstantFile.COUNTS)){
					countWalktypeList.add(getStorewalkss_walkId);
				}
				if (getStorewalkss_walkType.contains(ConstantFile.MARKETSTREETGAPSHIGHSLOWS)){
					marketstreetWalktypeList.add(getStorewalkss_walkId);
				}

			}

			GetStorewalksss_Metadata getStorewalksss_Metadata = getStorewalksss_RootJsonResp.getMetadata();

			getStorewalkss_limit = getStorewalksss_Metadata.getLimit();
			System.out.println("Limit : " + getStorewalkss_limit);

			getStorewalkss_count = getStorewalksss_Metadata.getCount();
			System.out.println("Count : " + getStorewalkss_count);

			getStorewalkss_offset = getStorewalksss_Metadata.getOffset();
			System.out.println("Offset : " + getStorewalkss_offset);
		}
	}




	public static void getStorewalkStoreResponse(String storeLocation)throws Throwable{
		String walkType = null;
		String walkId =null;
		System.out.println(Response);
		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("Get storewalkss response : " + responseCode);

		int responseCodeE = 200;

		assertEquals(responseCode, responseCodeE, " Storewalk details does not exist. Response code");
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		getStorewalksss_RootJsonResp = objectMapper.readValue(Response.getEntity().getContent(), GetStorewalksss_Root.class);
		String ProductJSONresult1 = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(getStorewalksss_RootJsonResp);

		System.out.println("GetStorewalkss Response:\n" + getStorewalksss_RootJsonResp);

		List<GetStorewalksss_Storewalk> getStorewalksss_Storewalk = getStorewalksss_RootJsonResp.getStorewalks();
		String storeID = null;
		for(GetStorewalksss_Storewalk storewalk : getStorewalksss_Storewalk)
		{
			storeID = storewalk.getStoreNumber();
			walkId = storewalk.getWalkId();
			walkType = storewalk.getWalkType();

			createStorewalk_walkId = walkId; //Setting walkid

			storewalkStoreResponse.put(storeID, walkId);
			
			if(storeID.equals(storeLocation) && walkType.equals(ConstantFile.GAPSHIGHSLOWS))
			{
				glh_walkId = walkId;
			}
		}

		if(storewalkStoreResponse.containsKey(storeLocation))
		{
			createStorewalk_walkId = storewalkStoreResponse.get(storeLocation);
		}


	}

	public static void verifyGetStorewalkResponse(String storeLocation)throws Throwable{

		System.out.println(Response);
		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("Get storewalkss response : " + responseCode);

		int responseCodeE = 200;

		assertEquals(responseCode, responseCodeE, " Storewalk details does not exist. Response code");
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		createStorewalk_RootJsonResp = objectMapper.readValue(Response.getEntity().getContent(), Storewalk_Root.class);
		String ProductJSONresult1 = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(createStorewalk_RootJsonResp);

		System.out.println("GetStorewalkss Response:\n" + createStorewalk_RootJsonResp);

		String storeID = createStorewalk_RootJsonResp.getStoreNumber();

		if(storeID.equalsIgnoreCase(storeLocation))
		{

			String walkId = createStorewalk_RootJsonResp.getWalkId();
			storewalkStoreResponse.put("WalkID", walkId);

			createStorewalk_walkId = walkId; //Setting walkid
			String storeNumber = createStorewalk_RootJsonResp.getStoreNumber();
			storewalkStoreResponse.put("StoreNumber", storeNumber);
			String walkType = createStorewalk_RootJsonResp.getWalkType();
			storewalkStoreResponse.put("WalkType", walkType);

			List<Storewalk_Department> departments = createStorewalk_RootJsonResp.getDepartments();
			for(Storewalk_Department department : departments ){

				List<Storewalk_Group> groups = department.getGroups();
				for(Storewalk_Group group : groups ){
					String groupName = group.getName();

					List<Storewalk_Section> sections = group.getSections();
					for(Storewalk_Section section : sections ){
						String sectionName = section.getName();
						List<Storewalk_Item> items = section.getItems();	
						for(Storewalk_Item item : items ){
							String productId = item.getProductId();
							System.out.println("Product id : " + productId);
							storewalkStoreResponse.put("ProductID", productId);
							String description = item.getDescription();
							storewalkStoreResponse.put("Description", description);
							getGroupAndItemId.put(productId, groupName);

							groupDeptSectionService.put(groupName, sectionName);

							walkIdProductId.put(walkType, productId);

						}
					}

				}
			}
		}
	}

	//// After capturing product on UI, verify product id is included in service
	public void verifyProductInStorewalkApi(String productId,String storeLocation,  String walkTypes) throws JsonParseException, JsonMappingException, UnsupportedOperationException, IOException{

		String storeID = null;
		String walkType = null;
		String walkId =null;
		List<String> productIdService = new ArrayList<String>();

		System.out.println(Response);
		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("Get storewalkss response : " + responseCode);

		int responseCodeE = 200;

		assertEquals(responseCode, responseCodeE, " Storewalk details does not exist. Response code");
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		getStorewalksss_RootJsonResp = objectMapper.readValue(Response.getEntity().getContent(), GetStorewalksss_Root.class);
		String ProductJSONresult1 = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(getStorewalksss_RootJsonResp);

		System.out.println("GetStorewalkss Response:\n" + getStorewalksss_RootJsonResp);

		List<GetStorewalksss_Storewalk> storewalkResponse  = getStorewalksss_RootJsonResp.getStorewalks();

		for(GetStorewalksss_Storewalk storewalk : storewalkResponse){

			storeID = storewalk.getStoreNumber();
			walkType = storewalk.getWalkType();

			if(storeID.equalsIgnoreCase(storeLocation)&& walkType.equalsIgnoreCase(walkTypes))
			{
				System.out.println("Product id : " + storeID);
				System.out.println("Walk type : " + walkType);

				walkId = storewalk.getWalkId();
				System.out.println("Walk id : " + walkId);

				List<Storewalk_Department> departments = storewalk.getDepartments();
				for(Storewalk_Department department : departments ){

					List<Storewalk_Group> groups = department.getGroups();
					for(Storewalk_Group group : groups ){
						String groupName = group.getName();

						List<Storewalk_Section> sections = group.getSections();
						for(Storewalk_Section section : sections ){
							getStorewalk_section_name = section.getName();
							System.out.println("Section name : " + getStorewalk_section_name);
							getStorewalk_section_status = section.getStatus();
							System.out.println("Section status : " + getStorewalk_section_status);

							List<Storewalk_Item> items = section.getItems();	
							for(Storewalk_Item item : items ){
								getStorewalk_productId = item.getProductId();
								productIdService.add(getStorewalk_productId);
								System.out.println("Product id : " + getStorewalk_productId);

								if(getStorewalk_productId.equals(productId)){

									try{
										List<GetStorewalk_Capture> captures = item.getCaptures();
										String GrpgetCaptures_qty = "";
										for(GetStorewalk_Capture capture : captures ){

											getCaptures_captureType = capture.getCaptureType();
											System.out.println("Capture type : " + getCaptures_captureType);
											productCaptureType.put(getCaptures_captureType, getStorewalk_productId);

											getCaptures_captureStatus = capture.getCaptureStatus();
											System.out.println("Capture status : " + getCaptures_captureStatus);
											productCaptureStatus.put(getCaptures_captureType, getCaptures_captureStatus);

											getCaptures_qty = capture.getQty();
											GrpgetCaptures_qty = GrpgetCaptures_qty + getCaptures_qty + " " ;
											System.out.println("Capture quantity : " + getCaptures_qty);
											productCaptureQty.put(getCaptures_captureType, GrpgetCaptures_qty);
										}
									}
									catch(Exception e){
										System.out.println(e.getMessage());
									}
								}
							}
						}
					}

				}
			}
		}

		boolean isProductPresent = productIdService.contains(productId);
		assertEquals(isProductPresent, true , "Product id is not present in Storewalk service");

	}

	//Get storewalk service - Verifying product capture details.
	public void verifyProductCaptureDetails(String productId,String captureType,String captureStatus,String captureQty){

		if(productCaptureType.containsKey(captureType) && productCaptureType.containsValue(productId)) {

			String captureStatusService = productCaptureStatus.get(captureType);
			String captureQtyService = productCaptureQty.get(captureType);
			String[] arrcaptureQtyService = captureQtyService.split(" ");

			assertEquals(captureStatusService, captureStatus , "Capture status is mismatched");
			assertTrue(Arrays.asList(arrcaptureQtyService).contains(captureQty) , "Capture quantity is mismatched, expected: " + Arrays.asList(arrcaptureQtyService) + "Actual: " + captureQty);
		}
		else{
			assertEquals(true, false , "Capture type is mismatched");
		}
	}

	//Get storewalk service - Verifying section status
	public static void verifySectionStatus(String sectionStatus)throws Throwable{

		assertEquals(getStorewalk_section_status, sectionStatus , "Section status is mismatched");
	}

	public static void getstorewalkNegativePromptResponse(String storeLocation)throws Throwable{

		System.out.println(Response);
		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("Get storewalkss response : " + responseCode);

		int responseCodeE = 200;

		assertEquals(responseCode, responseCodeE, " Storewalk details does not exist. Response code");
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		createStorewalk_RootJsonResp = objectMapper.readValue(Response.getEntity().getContent(), Storewalk_Root.class);
		String ProductJSONresult1 = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(createStorewalk_RootJsonResp);

		System.out.println("GetStorewalkss Response:\n" + createStorewalk_RootJsonResp);

		String storeID = createStorewalk_RootJsonResp.getStoreNumber();

		if(storeID.equalsIgnoreCase(storeLocation))
		{

			String walkId = createStorewalk_RootJsonResp.getWalkId();
			storewalkStoreResponse.put("WalkID", walkId);

			createStorewalk_walkId = walkId; //Setting walkid
			String storeNumber = createStorewalk_RootJsonResp.getStoreNumber();
			storewalkStoreResponse.put("StoreNumber", storeNumber);
			String walkType = createStorewalk_RootJsonResp.getWalkType();
			storewalkStoreResponse.put("WalkType", walkType);

			List<Storewalk_Department> departments = createStorewalk_RootJsonResp.getDepartments();
			for(Storewalk_Department department : departments ){

				List<Storewalk_Group> groups = department.getGroups();
				for(Storewalk_Group group : groups ){
					String groupName = group.getName();

					List<Storewalk_Section> sections = group.getSections();
					for(Storewalk_Section section : sections ){
						String sectionName = section.getName();
						List<Storewalk_Item> items = section.getItems();	
						for(Storewalk_Item item : items ){
							String reason = item.getReason();
							storewalkStoreResponse.put("Reason", reason);
							break;
						}
						break;
					}
					break;
				}
				break;
			}
		}
	}


	public void verifyNegativestockReason()throws Throwable {
		String serviceResponse = storewalkStoreResponse.get("Reason");

		assertEquals(serviceResponse, "NegativeStock","Negative stock reason is not displayed for negative stock products");
	}

	/////  Get walkId
	public static void getWalkId(String storeId)throws Throwable{
		System.out.println("Store id:\n" + storeId);
		System.out.println(Response);
		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("Get storewalkss response : " + responseCode);

		int responseCodeE = 200;

		if(responseCode==200){
			assertEquals(responseCode, responseCodeE, " Storewalk details does not exist. Response code");
			objectMapper.setSerializationInclusion(Include.NON_NULL);
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			getStorewalksss_RootJsonResp = objectMapper.readValue(Response.getEntity().getContent(), GetStorewalksss_Root.class);
			String ProductJSONresult1 = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(createStorewalk_RootJsonResp);

			System.out.println("GetStorewalkss Response:\n" + getStorewalksss_RootJsonResp);

			List<GetStorewalksss_Storewalk> getStorewalksss_Storewalk = getStorewalksss_RootJsonResp.getStorewalks();

			for(GetStorewalksss_Storewalk storewalk : getStorewalksss_Storewalk)
			{
				getStorewalkss_walkId = storewalk.getWalkId();
				System.out.println("Walk id : " + getStorewalkss_walkId);

				getStorewalkss_storeNumber = storewalk.getStoreNumber();
				System.out.println("Store number : " + getStorewalkss_storeNumber);

				getStorewalkss_walkType = storewalk.getWalkType();
				System.out.println("Walk type : " + getStorewalkss_walkType);

				if(storeId.equalsIgnoreCase(getStorewalkss_storeNumber)){

					if(getStorewalkss_walkType.equalsIgnoreCase(ConstantFile.GAPSHIGHSLOWS)){
						walkIdAndType.put(ConstantFile.GAPSHIGHSLOWS,getStorewalkss_walkId);
					}
					if(getStorewalkss_walkType.equalsIgnoreCase(ConstantFile.GAPS)){
						walkIdAndType.put(ConstantFile.GAPS,getStorewalkss_walkId);
					}
					if (getStorewalkss_walkType.equalsIgnoreCase(ConstantFile.MARKETSTREETGAPSHIGHSLOWS)){
						walkIdAndType.put(ConstantFile.MARKETSTREETGAPSHIGHSLOWS,getStorewalkss_walkId);
					}
				}
			}			
		}
	}


	/////// Delete Storewalk

	public void deleteStorewalkServiceUrl(String storeId) throws URISyntaxException, InterruptedException, ClientProtocolException, IOException {

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getDeleteStorewalk().getResource();
		resource = resource.replaceAll("\\bstoreid\\b", storeId);
		resource = resource.replaceAll("\\bwalkid\\b", getStorewalk_walkId);

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;

		Thread.sleep(500);
	}

	public void deleteGLHStorewalk(String storeId) throws URISyntaxException, InterruptedException, ClientProtocolException, IOException {

		int count = glhWalktypeList.size();

		for(int i=0;i<=count-1;i++)
		{
			String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
			String resource = applicationConfig.getDeleteStorewalk().getResource();
			resource = resource.replaceAll("\\bstoreid\\b", storeId);
			resource = resource.replaceAll("\\bwalkid\\b", glhWalktypeList.get(i));

			URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

			currentUri = uriBuilder.build();
			System.out.println(currentUri);
			mDAccessTocken = accessTocken;

			Response = deleteServicePerformOperation();

			Thread.sleep(500);
		}
	}

	public void verifyDeleteServiceResponseCode() throws IOException {

		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("Delete storewalk response : " + responseCode);

		int responseCodeE = 204;

		assertEquals(responseCode, responseCodeE, "Error in delete storewalk service");
	}

	////// Create Walkitem
	public void createWalkitemServiceUrl(String storeId,String id)
			throws URISyntaxException, ClientProtocolException, IOException, InterruptedException {
		String productId = id;

		CreateWalkitemBody createWalkitem_PostBody = new CreateWalkitemBody();
		createWalkitem_PostBody.setProductId(productId);

		String walkitemServiceBody = objectMapper.writeValueAsString(createWalkitem_PostBody);
		System.out.println("Payload body is " + walkitemServiceBody);

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getCreateWalkitem().getResource();
		resource = resource.replaceAll("\\bstoreId\\b", storeId);
		resource = resource.replaceAll("\\bwalkId\\b", createStorewalk_walkId);

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		mdStorewalk = walkitemServiceBody;
		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;

		Thread.sleep(500);
	}

	public void createWalkitemInvalidPayload(String storeId,String id)
			throws URISyntaxException, ClientProtocolException, IOException, InterruptedException {
		String productId = id;

		CreateWalkitemBody createWalkitem_PostBody = new CreateWalkitemBody();
		createWalkitem_PostBody.setInvalidPayload(productId);

		String walkitemServiceBody = objectMapper.writeValueAsString(createWalkitem_PostBody);
		System.out.println("Payload body is " + walkitemServiceBody);

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getCreateWalkitem().getResource();
		resource = resource.replaceAll("\\bstoreId\\b", storeId);
		resource = resource.replaceAll("\\bwalkId\\b", createStorewalk_walkId);

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		mdStorewalk = walkitemServiceBody;
		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;

		Thread.sleep(500);
	}

	//////Create Walkitem
	public void createWalkitemWithoutPayload(String storeId)
			throws URISyntaxException, ClientProtocolException, IOException, InterruptedException {

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getCreateWalkitem().getResource();
		resource = resource.replaceAll("\\bstoreId\\b", storeId);
		resource = resource.replaceAll("\\bwalkId\\b", createStorewalk_walkId);

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		mdStorewalk = "";
		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;

		Thread.sleep(500);
	}

	//////Create Walkitem with Location
	public void createWalkitemWithLocation(String storeId,String id,String location)
			throws URISyntaxException, ClientProtocolException, IOException, InterruptedException {
		String productId = id;
		CreateWalkitemBody createWalkitem_PostBody = new CreateWalkitemBody();
		createWalkitem_PostBody.setProductId(productId);
		createWalkitem_PostBody.setLocation(location);

		String walkitemServiceBody = objectMapper.writeValueAsString(createWalkitem_PostBody);
		System.out.println("Payload body is " + walkitemServiceBody);

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getCreateWalkitem().getResource();
		resource = resource.replaceAll("\\bstoreId\\b", storeId);
		resource = resource.replaceAll("\\bwalkId\\b", createStorewalk_walkId);

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		mdStorewalk = walkitemServiceBody;
		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;

		Thread.sleep(500);
	}

	//////Mulitple product Create Walkitem for 2 products
	public void createWalkitemFor2ProductsUrl(String storeId,String productId1,String productId2)
			throws URISyntaxException, ClientProtocolException, IOException, InterruptedException {
		String data[] = {""+productId1+"",""+productId2+""};

		CreateWalkitem_PostBody createWalkitem_PostBody = new CreateWalkitem_PostBody();
		createWalkitem_PostBody.setProductId(data);
		createWalkitem_PostBody.setReason(ConstantFile.NEGATIVESTOCK);

		String walkitemServiceBody = objectMapper.writeValueAsString(createWalkitem_PostBody);
		System.out.println("Payload body is " + walkitemServiceBody);

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getCreateWalkitem().getResource();
		resource = resource.replaceAll("\\bstoreId\\b", storeId);
		resource = resource.replaceAll("\\bwalkId\\b", createStorewalk_walkId);

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		mdStorewalk = walkitemServiceBody;
		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;

		Thread.sleep(500);
	}

	//Mulitple product Create Walkitem for 10 products
	public void createWalkitemFor10ProductsUrl(String storeId,String productId1,String productId2,String productId3,String productId4,String productId5,String productId6,String productId7,String productId8,String productId9, String productId10)
			throws URISyntaxException, ClientProtocolException, IOException, InterruptedException {
		String data[] = {""+productId1+ "",""+productId2+ "",""+productId3+"",""+productId4+""};   //,""+productId5+"",""+productId6+"",""+productId7+"",""+productId8+"",""+productId9+"",""+productId10+""};

		CreateWalkitem_PostBody createWalkitem_PostBody = new CreateWalkitem_PostBody();
		createWalkitem_PostBody.setProductId(data);

		String walkitemServiceBody = objectMapper.writeValueAsString(createWalkitem_PostBody);
		System.out.println("Payload body is " + walkitemServiceBody);

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getCreateWalkitem().getResource();
		resource = resource.replaceAll("\\bstoreId\\b", storeId);
		resource = resource.replaceAll("\\bwalkId\\b", createStorewalk_walkId);

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		mdStorewalk = walkitemServiceBody;
		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;

		Thread.sleep(500);
	}

	//Mulitple product Create Walkitem for 11 products
	public void createWalkitemFor11ProductsUrl(String storeId,String productId1,String productId2,String productId3,String productId4,String productId5,String productId6,String productId7,String productId8,String productId9,String productId10,String productId11)
			throws URISyntaxException, ClientProtocolException, IOException, InterruptedException {
		String data[] = {"["+productId1+","+productId2+","+productId3+","+productId4+"]"};    //+","+productId5+","+productId6+","+productId7+","+productId8+","+productId9+","+productId10+","+productId11+"]"};

		CreateWalkitem_PostBody createWalkitem_PostBody = new CreateWalkitem_PostBody();
		createWalkitem_PostBody.setProductId(data);

		String walkitemServiceBody = objectMapper.writeValueAsString(createWalkitem_PostBody);
		System.out.println("Payload body is " + walkitemServiceBody);

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getCreateWalkitem().getResource();
		resource = resource.replaceAll("\\bstoreId\\b", storeId);
		resource = resource.replaceAll("\\bwalkId\\b", createStorewalk_walkId);

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		mdStorewalk = walkitemServiceBody;
		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;

		Thread.sleep(500);
	}

	//// Create walkitem using blank storewalk
	public void createWalkitemWithEmptyStorewalk(String storeId,String id)
			throws URISyntaxException, ClientProtocolException, IOException, InterruptedException {
		String[] productId = {"+id+"};
		CreateWalkitem_PostBody createWalkitem_PostBody = new CreateWalkitem_PostBody();
		createWalkitem_PostBody.setProductId(productId);

		String walkitemServiceBody = objectMapper.writeValueAsString(createWalkitem_PostBody);
		System.out.println("Payload body is " + walkitemServiceBody);

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getCreateWalkitem().getResource();
		resource = resource.replaceAll("\\bstoreId\\b", storeId);
		resource = resource.replaceAll("\\bwalkId\\b", "");

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		mdStorewalk = walkitemServiceBody;
		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;

		Thread.sleep(500);
	}


	//////Create Walkitem service response
	public static void createWalkitemServicesResponse()throws Throwable{

		System.out.println(Response);
		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("Create walkitem response : " + responseCode);

		int responseCodeE = 200;

		//assertEquals(responseCode, responseCodeE, " Storewalk details does not exist. Response code");
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		createWalkitem_RootJsonResp = objectMapper.readValue(Response.getEntity().getContent(), Walkitem_Root.class);
		String ProductJSONresult1 = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(createWalkitem_RootJsonResp);

		System.out.println("Create walkitem Response:\n" + createWalkitem_RootJsonResp);

		createWalkitem_productId = createWalkitem_RootJsonResp.getProductId();
		System.out.println("Product id : " + createWalkitem_productId);
		walkItemResponse.put("Product id", createWalkitem_productId);

		createWalkitem_standardUnitOfMeasure = createWalkitem_RootJsonResp.getStandardUnitOfMeasure();
		System.out.println("Standard unit of measure : " + createWalkitem_standardUnitOfMeasure);
		walkItemResponse.put("Standard unit of measure", createWalkitem_standardUnitOfMeasure);

		createWalkitem_stockUom = createWalkitem_RootJsonResp.getStockUom();
		System.out.println("Stock UOM : " + createWalkitem_stockUom);
		walkItemResponse.put("Stock UOM", createWalkitem_stockUom);

		createWalkitem_description = createWalkitem_RootJsonResp.getDescription();
		System.out.println("Description : " + createWalkitem_description);
		walkItemResponse.put("Description", createWalkitem_description);

		createWalkitem_qtyOnHand = createWalkitem_RootJsonResp.getQtyOnHand();
		System.out.println("Quantity on hand : " + createWalkitem_qtyOnHand);
		walkItemResponse.put("Quantity on hand", createWalkitem_qtyOnHand);

		createWalkitem_sOHValue = createWalkitem_RootJsonResp.getsOHValue();
		System.out.println("SOH value : " + createWalkitem_sOHValue);
		walkItemResponse.put("SOH value", createWalkitem_sOHValue);

		createWalkitem_qtyInTransit = createWalkitem_RootJsonResp.getQtyInTransit();
		System.out.println("Qty in transit : " + createWalkitem_qtyInTransit);
		walkItemResponse.put("Qty in transit", createWalkitem_qtyInTransit);

		createWalkitem_stockState = createWalkitem_RootJsonResp.getStockState();
		System.out.println("Stock store : " + createWalkitem_stockState);
		walkItemResponse.put("Stock store", createWalkitem_stockState);

		createWalkitem_isDeliveryExpectedDateToday = createWalkitem_RootJsonResp.getIsDeliveryExpectedDateToday();
		System.out.println("Is delivery expected date today : " + createWalkitem_isDeliveryExpectedDateToday);
		walkItemResponse.put("Is delivery expected date today", createWalkitem_isDeliveryExpectedDateToday);

		createWalkitem_isReceited = createWalkitem_RootJsonResp.getIsReceited();
		System.out.println("Is receited : " + createWalkitem_isReceited);
		walkItemResponse.put("Is receited", createWalkitem_isReceited);

		createWalkitem_price = createWalkitem_RootJsonResp.getPrice();
		System.out.println("Price : " + createWalkitem_price);
		walkItemResponse.put("Price", createWalkitem_price);

		createWalkitem_adjustmentPrice = createWalkitem_RootJsonResp.getAdjustmentPrice();
		System.out.println("Adjustment price : " + createWalkitem_adjustmentPrice);
		walkItemResponse.put("Adjustment price", createWalkitem_adjustmentPrice);

		createWalkitem_isLargeAdjustment = createWalkitem_RootJsonResp.getIsLargeAdjustment();
		System.out.println("Large adjustment : " + getStorewalkss_walkId);
		walkItemResponse.put("Large adjustment", createWalkitem_packSize);

		createWalkitem_packSize = createWalkitem_RootJsonResp.getPackSize();
		System.out.println("Pack size : " + createWalkitem_packSize);
		walkItemResponse.put("Pack size", createWalkitem_packSize);

		createWalkitem_variance = createWalkitem_RootJsonResp.getVariance();
		System.out.println("Variance : " + createWalkitem_variance);
		walkItemResponse.put("Variance", createWalkitem_variance);

		createWalkitem_variancePercentage = createWalkitem_RootJsonResp.getVariancePercentage();
		System.out.println("Variance percentage : " + createWalkitem_variancePercentage);
		walkItemResponse.put("Variance percentage", createWalkitem_variancePercentage);

		createWalkitem_partOfCount = createWalkitem_RootJsonResp.getPartOfCount();
		System.out.println("Part of count : " + createWalkitem_partOfCount);
		walkItemResponse.put("Part of count", createWalkitem_partOfCount);

		createWalkitem_reviewCaptureCount = createWalkitem_RootJsonResp.getReviewCaptureCount();
		System.out.println("Review capture count : " + createWalkitem_reviewCaptureCount);
		walkItemResponse.put("Review capture count", createWalkitem_reviewCaptureCount);

		List<Storewalk_Plan> createWalkitem_Plan = createWalkitem_RootJsonResp.getPlan();

		for(Storewalk_Plan plan : createWalkitem_Plan)
		{
			createWalkitem_class = plan.getClass1();
			System.out.println("Class attribute : " + createWalkitem_class);
			walkItemResponse.put("Class attribute", createWalkitem_class);

			createWalkitem_plan_type = plan.getType();
			System.out.println("Type in Plan : " + createWalkitem_plan_type);
			walkItemResponse.put("Type in Plan", createWalkitem_plan_type);

			createWalkitem_name = plan.getName();
			System.out.println("Name : " + createWalkitem_name);
			walkItemResponse.put("Plan Name", createWalkitem_name);

			createWalkitem_planLocation = plan.getPlanLocation();
			System.out.println("Plan location : " + createWalkitem_planLocation);
			walkItemResponse.put("Plan location", createWalkitem_planLocation);

			createWalkitem_fillQty = plan.getFillQty();
			System.out.println("Fill qty : " + createWalkitem_fillQty);
			walkItemResponse.put("Fill qty", createWalkitem_fillQty);

			createWalkitem_storeWalkSequence = plan.getStoreWalkSequence();
			System.out.println("Storewalk sequence : " + createWalkitem_storeWalkSequence);
			walkItemResponse.put("Storewalk sequence", createWalkitem_storeWalkSequence);
		}

		Storewalk_CommercialHierarchy createWalkitem_CommercialHierarchy = createWalkitem_RootJsonResp.getCommercialHierarchy();

		createWalkitem_group = createWalkitem_CommercialHierarchy.getGroup();
		System.out.println("Group : " + createWalkitem_group);
		walkItemResponse.put("Group", createWalkitem_group);

		createWalkitem_class_ = createWalkitem_CommercialHierarchy.getClass_();
		System.out.println("Class attribute : " + createWalkitem_class_);
		walkItemResponse.put("Class attribute", createWalkitem_class_);

		createWalkitem_division = createWalkitem_CommercialHierarchy.getDivision();
		System.out.println("Division : " + createWalkitem_division);
		walkItemResponse.put("Division", createWalkitem_division);

		createWalkitem_subclass = createWalkitem_CommercialHierarchy.getSubclass();
		System.out.println("Subclass : " + createWalkitem_subclass);
		walkItemResponse.put("Subclass", createWalkitem_subclass);

		createWalkitem_className = createWalkitem_CommercialHierarchy.getClassName();
		System.out.println("Class name : " + createWalkitem_className);
		walkItemResponse.put("Class name", createWalkitem_className);

		createWalkitem_groupName = createWalkitem_CommercialHierarchy.getGroupName();
		System.out.println("Group name : " + createWalkitem_groupName);
		walkItemResponse.put("Group name", createWalkitem_groupName);

		createWalkitem_department = createWalkitem_CommercialHierarchy.getDepartment();
		System.out.println("Department : " + createWalkitem_department);
		walkItemResponse.put("Department", createWalkitem_department);

		createWalkitem_divisionName = createWalkitem_CommercialHierarchy.getDivisionName();
		System.out.println("Division name : " + createWalkitem_divisionName);
		walkItemResponse.put("Division name", createWalkitem_divisionName);

		createWalkitem_subclassName = createWalkitem_CommercialHierarchy.getSubclassName();
		System.out.println("Subclass name : " + createWalkitem_subclassName);
		walkItemResponse.put("Subclass name", createWalkitem_subclassName);

		createWalkitem_departmentName = createWalkitem_CommercialHierarchy.getDepartmentName();
		System.out.println("Department name : " + createWalkitem_departmentName);
		walkItemResponse.put("Department name", createWalkitem_departmentName);

		Storewalk_Pack createWalkitem_Pack = createWalkitem_RootJsonResp.getPack();

		createWalkitem_pin = createWalkitem_Pack.getPin();
		System.out.println("Pin : " + createWalkitem_pin);
		walkItemResponse.put("Pin", createWalkitem_pin);

		createWalkitem_weight = createWalkitem_Pack.getWeight();
		System.out.println("Weight : " + createWalkitem_weight);
		walkItemResponse.put("Weight", createWalkitem_weight);

		createWalkitem_quantity = createWalkitem_Pack.getQuantity();
		System.out.println("Quantity : " + createWalkitem_quantity);
		walkItemResponse.put("Pack quantity", createWalkitem_quantity);

		Storewalk_CountType createWalkitem_CountType = createWalkitem_RootJsonResp.getCountType();

		createWalkitem_type = createWalkitem_CountType.getType();
		System.out.println("Type : " + createWalkitem_type);
		walkItemResponse.put("Count type", createWalkitem_type);

		Storewalk_CreationAudit createWalkitem_CreationAudit = createWalkitem_RootJsonResp.getCreationAudit();

		createWalkitem_when = createWalkitem_CreationAudit.getWhen();
		System.out.println("When : " + createWalkitem_when);
		walkItemResponse.put("When", createWalkitem_when);

		Storewalk_Who createWalkitem_Who = createWalkitem_CreationAudit.getWho();
		createWalkitem_empId = createWalkitem_Who.getEmpId();
		System.out.println("Emp id : " + createWalkitem_empId);
		walkItemResponse.put("Emp id", createWalkitem_empId);

		createWalkitem_username = createWalkitem_Who.getUsername();
		System.out.println("Username : " + createWalkitem_username);
		walkItemResponse.put("Username", createWalkitem_username);

		Storewalk_Action CreateWalkitem_Action = createWalkitem_RootJsonResp.getAction();
		createWalkitem_actionType = CreateWalkitem_Action.getActionType();
		System.out.println("Action type : " + createWalkitem_actionType);
		walkItemResponse.put("Action type", createWalkitem_actionType);
	}


	public void verifyLocatioAttributeNotPresent(){

		boolean locationAttribute = walkItemResponse.containsKey("Locations");

		assertEquals(locationAttribute,false,"Location attribute is present in Create storewalk service response");
	}
	
	
	public void getWalkIdForGLH(String sType) throws Throwable{
		if(sType.equalsIgnoreCase("GAPSHIGHSLOWS")) {
			createStorewalk_walkId = walkIdAndType.get(ConstantFile.GAPSHIGHSLOWS);
		}
		else if(sType.equalsIgnoreCase("GAPS")){
			createStorewalk_walkId = walkIdAndType.get(ConstantFile.GAPS);
		}
		else{
			createStorewalk_walkId = walkIdAndType.get(ConstantFile.COUNTS);
		}
	}

	///// Get - Get walkitem
	public void getWalkItemServiceUrl(String storeId,String productId) throws URISyntaxException, InterruptedException, ClientProtocolException, IOException {

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getGetWalkitem().getResource();
		resource = resource.replaceAll("\\bstoreid\\b", storeId);
		resource = resource.replaceAll("\\bwalkid\\b", createStorewalk_walkId);
		resource = resource.replaceAll("\\bitemid\\b", productId);

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;

		Thread.sleep(500);
	}

	//// Get walkitem service response
	public static void getWalkitemServicesResponse()throws Throwable{

		System.out.println(Response);
		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("Get walkitem response : " + responseCode);

		int responseCodeE = 200;

		//assertEquals(responseCode, responseCodeE, " Storewalk details does not exist. Response code");
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		getWalkitem_RootJsonResp = objectMapper.readValue(Response.getEntity().getContent(), Walkitem_Root.class);
		String ProductJSONresult1 = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(createWalkitem_RootJsonResp);

		System.out.println("Get walkitem Response:\n" + getWalkitem_RootJsonResp);

		getWalkitem_productId = getWalkitem_RootJsonResp.getProductId();
		System.out.println("Product id : " + getWalkitem_productId);

		getWalkitem_standardUnitOfMeasure = getWalkitem_RootJsonResp.getStandardUnitOfMeasure();
		System.out.println("Standard unit of measure : " + getWalkitem_standardUnitOfMeasure);

		getWalkitem_stockUom = getWalkitem_RootJsonResp.getStockUom();
		System.out.println("Stock UOM : " + getWalkitem_stockUom);

		getWalkitem_description = getWalkitem_RootJsonResp.getDescription();
		System.out.println("Description : " + getWalkitem_description);

		getWalkitem_qtyOnHand = getWalkitem_RootJsonResp.getQtyOnHand();
		System.out.println("Quantity on hand : " + getWalkitem_qtyOnHand);

		getWalkitem_sOHValue = getWalkitem_RootJsonResp.getsOHValue();
		System.out.println("SOH value : " + getWalkitem_sOHValue);

		getWalkitem_qtyInTransit = getWalkitem_RootJsonResp.getQtyInTransit();
		System.out.println("Qty in transit : " + getWalkitem_qtyInTransit);

		getWalkitem_stockState = getWalkitem_RootJsonResp.getStockState();
		System.out.println("Stock store : " + getWalkitem_stockState);

		getWalkitem_isDeliveryExpectedDateToday = getWalkitem_RootJsonResp.getIsDeliveryExpectedDateToday();
		System.out.println("Is delivery expected date today : " + getWalkitem_isDeliveryExpectedDateToday);

		getWalkitem_isReceited = getWalkitem_RootJsonResp.getIsReceited();
		System.out.println("Is receited : " + getWalkitem_isReceited);

		getWalkitem_price = getWalkitem_RootJsonResp.getPrice();
		System.out.println("Price : " + getWalkitem_price);

		getWalkitem_adjustmentPrice = getWalkitem_RootJsonResp.getAdjustmentPrice();
		System.out.println("Adjustment price : " + getWalkitem_adjustmentPrice);

		getWalkitem_isLargeAdjustment = getWalkitem_RootJsonResp.getIsLargeAdjustment();
		System.out.println("Large adjustment : " + getStorewalkss_walkId);

		getWalkitem_packSize = getWalkitem_RootJsonResp.getPackSize();
		System.out.println("Pack size : " + getWalkitem_packSize);

		getWalkitem_variance = getWalkitem_RootJsonResp.getVariance();
		System.out.println("Variance : " + getWalkitem_variance);

		getWalkitem_variancePercentage = getWalkitem_RootJsonResp.getVariancePercentage();
		System.out.println("Variance percentage : " + getWalkitem_variancePercentage);

		getWalkitem_partOfCount = getWalkitem_RootJsonResp.getPartOfCount();
		System.out.println("Part of count : " + getWalkitem_partOfCount);

		getWalkitem_reviewCaptureCount = getWalkitem_RootJsonResp.getReviewCaptureCount();
		System.out.println("Review capture count : " + getWalkitem_reviewCaptureCount);

		List<Storewalk_Plan> getWalkitem_Plan = getWalkitem_RootJsonResp.getPlan();

		for(Storewalk_Plan plan : getWalkitem_Plan)
		{
			getWalkitem_class = plan.getClass1();
			System.out.println("Class attribute : " + getWalkitem_class);

			getWalkitem_plan_type = plan.getType();
			System.out.println("Type in Plan : " + getWalkitem_plan_type);

			getWalkitem_name = plan.getName();
			System.out.println("Name : " + getWalkitem_name);

			getWalkitem_planLocation = plan.getPlanLocation();
			System.out.println("Plan location : " + getWalkitem_planLocation);

			getWalkitem_fillQty = plan.getFillQty();
			System.out.println("Fill qty : " + getWalkitem_fillQty);

			getWalkitem_storeWalkSequence = plan.getStoreWalkSequence();
			System.out.println("Storewalk sequence : " + getWalkitem_storeWalkSequence);
		}

		Storewalk_CommercialHierarchy getWalkitem_CommercialHierarchy = getWalkitem_RootJsonResp.getCommercialHierarchy();

		getWalkitem_group = getWalkitem_CommercialHierarchy.getGroup();
		System.out.println("Group : " + getWalkitem_group);

		getWalkitem_class_ = getWalkitem_CommercialHierarchy.getClass_();
		System.out.println("Class attribute : " + getWalkitem_class_);

		getWalkitem_division = getWalkitem_CommercialHierarchy.getDivision();
		System.out.println("Division : " + getWalkitem_division);

		getWalkitem_subclass = getWalkitem_CommercialHierarchy.getSubclass();
		System.out.println("Subclass : " + getWalkitem_subclass);

		getWalkitem_className = getWalkitem_CommercialHierarchy.getClassName();
		System.out.println("Class name : " + getWalkitem_className);

		getWalkitem_groupName = getWalkitem_CommercialHierarchy.getGroupName();
		System.out.println("Group name : " + getWalkitem_groupName);

		getWalkitem_department = getWalkitem_CommercialHierarchy.getDepartment();
		System.out.println("Department : " + getWalkitem_department);

		getWalkitem_divisionName = getWalkitem_CommercialHierarchy.getDivisionName();
		System.out.println("Division name : " + getWalkitem_divisionName);

		getWalkitem_subclassName = getWalkitem_CommercialHierarchy.getSubclassName();
		System.out.println("Subclass name : " + getWalkitem_subclassName);

		getWalkitem_departmentName = getWalkitem_CommercialHierarchy.getDepartmentName();
		System.out.println("Department name : " + getWalkitem_departmentName);


		Storewalk_Pack getWalkitem_Pack = getWalkitem_RootJsonResp.getPack();

		getWalkitem_pin = getWalkitem_Pack.getPin();
		System.out.println("Pin : " + getWalkitem_pin);

		getWalkitem_weight = getWalkitem_Pack.getWeight();
		System.out.println("Weight : " + getWalkitem_weight);

		getWalkitem_quantity = getWalkitem_Pack.getQuantity();
		System.out.println("Quantity : " + getWalkitem_quantity);

		Storewalk_CountType getWalkitem_CountType = getWalkitem_RootJsonResp.getCountType();

		getWalkitem_type = getWalkitem_CountType.getType();
		System.out.println("Type : " + getWalkitem_type);

		Storewalk_CreationAudit getWalkitem_CreationAudit = getWalkitem_RootJsonResp.getCreationAudit();

		getWalkitem_when = getWalkitem_CreationAudit.getWhen();
		System.out.println("When : " + getWalkitem_when);

		Storewalk_Who getWalkitem_Who = getWalkitem_CreationAudit.getWho();
		getWalkitem_empId = getWalkitem_Who.getEmpId();
		System.out.println("Emp id : " + getWalkitem_empId);

		getWalkitem_username = getWalkitem_Who.getUsername();
		System.out.println("Username : " + getWalkitem_username);

		Storewalk_Action getWalkitem_Action = getWalkitem_RootJsonResp.getAction();
		getWalkitem_actionType = getWalkitem_Action.getActionType();
		System.out.println("Action type : " + getWalkitem_actionType);
	}
//Changes made by Swati to make this method reusable
	public void createWalkitemResponse(int responseCodeE)throws Throwable {

		System.out.println(Response);
		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("Create walkitem response : " + responseCode);

		//int responseCodeE = 201;

		assertEquals(responseCode, responseCodeE, " Walkitem response is not 201");

	}

	public void createWalkitemResponseIs201Or200() throws Throwable {

		System.out.println(Response);
		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("Create walkitem response : " + responseCode);

		boolean responseCodeE = false;
		if(responseCode==200 || responseCode==201){
			responseCodeE = true;
		}

		assertEquals(responseCodeE, true, " Response is mismatched");
	}


	public void createWalkitemResponseIs409()throws Throwable {

		System.out.println(Response);
		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("Create walkitem response : " + responseCode);

		int responseCodeE = 409;

		assertEquals(responseCode, responseCodeE, " Allowed to create walkitem for different walktypes");
	}

	public void verifyAPIResponse400()throws Throwable {

		System.out.println(Response);
		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("Create walkitem response : " + responseCode);

		int responseCodeE = 400;

		assertEquals(responseCode, responseCodeE, " Walkitem response is not 201");

	}

	public void verifyAPIResponse401()throws Throwable {

		System.out.println(Response);
		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("Create walkitem response : " + responseCode);

		int responseCodeE = 401;

		assertEquals(responseCode, responseCodeE, " Walkitem response is not 201");

	}

	public void verifyAPIResponse200()throws Throwable {

		System.out.println(Response);
		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("Create walkitem response : " + responseCode);

		int responseCodeE = 200;

		assertEquals(responseCode, responseCodeE, " Service response is not 200");

	}

	public void verifyAPIResponse200Or201()throws Throwable {

		System.out.println(Response);
		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("Service response : " + responseCode);

		boolean responseCodeE = false;
		if(responseCode==200 || responseCode==201){
			responseCodeE = true;
		}

		assertEquals(responseCodeE, true, "Service Response is mismatched");

	}

	//// Post - Create Capture 
	public void createCaptureServiceUrl(String storeId,String productId,String location,int value,int sectionId,String captureType)
			throws URISyntaxException, ClientProtocolException, IOException, InterruptedException {

		CreateCapture_PostBody createCapture_PostBody = new CreateCapture_PostBody();
		createCapture_PostBody.setLocation(location);
		createCapture_PostBody.setValue(value);
		createCapture_PostBody.setSectionId(sectionId);
		createCapture_PostBody.setCaptureType(captureType);

		String createCaptureServiceBody = objectMapper.writeValueAsString(createCapture_PostBody);
		System.out.println("Payload body is " + createCaptureServiceBody);

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getCreateCapture().getResource();
		resource = resource.replaceAll("\\bstoreid\\b", storeId);
		resource = resource.replaceAll("\\bwalkid\\b", createStorewalk_walkId);
		resource = resource.replaceAll("\\bitemid\\b", productId);

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		mdStorewalk = createCaptureServiceBody;
		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;

		Thread.sleep(500);
	}

	//////Create capture service response
	public static void createCaptureServicesResponse()throws Throwable{

		System.out.println(Response);
		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("Create capture response : " + responseCode);

		boolean isExpected = false;

		if(responseCode==200 || responseCode==201)
		{
			isExpected = true;
		}

		assertEquals(isExpected, true, " Create capture details does not exist. Response code");
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		createCapture_RootJsonResp = objectMapper.readValue(Response.getEntity().getContent(), CreateCapture_Root.class);
		String ProductJSONresult1 = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(createCapture_RootJsonResp);

		System.out.println("Create capture Response:\n" + createCapture_RootJsonResp);

		createCapture_captureId = createCapture_RootJsonResp.getCaptureId();
		System.out.println("Capture id : " + createCapture_captureId);

		createCapture_captureType = createCapture_RootJsonResp.getCaptureType();
		System.out.println("Capture type : " + createCapture_captureType);

		createCapture_captureStatus = createCapture_RootJsonResp.getCaptureStatus();
		System.out.println("Capture status : " + createCapture_captureStatus);

		createCapture_qty = createCapture_RootJsonResp.getQty();
		System.out.println("Qty : " + createCapture_qty);

		createCapture_value = createCapture_RootJsonResp.getValue();
		System.out.println("Value : " + createCapture_value);

		createCapture_location = createCapture_RootJsonResp.getLocation();
		System.out.println("Location : " + createCapture_location);

		createCapture_isACase = createCapture_RootJsonResp.getIsACase();
		System.out.println("Is a case : " + createCapture_isACase);

		Storewalk_CreationAudit createCapture_CreationAudit = createCapture_RootJsonResp.getCreationAudit();
		createCapture_when = createCapture_CreationAudit.getWhen();
		System.out.println("When : " + createCapture_when);

		Storewalk_Who createCapture_Who = createCapture_CreationAudit.getWho();
		createCapture_empId = createCapture_Who.getEmpId();
		System.out.println("Emp id : " + createCapture_empId);
		createCapture_username = createCapture_Who.getUsername();
		System.out.println("Username : " + createCapture_username);
	}

	public void verifyCaptureAsZero()throws Throwable{
		String exepctedQty = "0";
		String expectedValue = "0.00";
		String expected_Location = "Counter";

		assertEquals(createCapture_qty, exepctedQty,"Qty is mismatched");
		assertEquals(createCapture_value, expectedValue,"Value is mismatched");
		assertEquals(createCapture_location, expected_Location,"Location is mismatched");
	}

	public void incompleteCaptureAtBackup()throws Throwable{
		String exepctedLocation = "Backup";
		String expectedCaptureStatus = "Incomplete";

		assertEquals(createCapture_location, exepctedLocation,"Location is mismatched");
		assertEquals(createCapture_captureStatus, expectedCaptureStatus,"Capture status is mismatched");
	}

	public void incompleteCaptureAtCounter()throws Throwable{
		String exepctedLocation = "Counter";
		String expectedCaptureStatus = "Incomplete";

		assertEquals(createCapture_location, exepctedLocation,"Location is mismatched");
		assertEquals(createCapture_captureStatus, expectedCaptureStatus,"Capture status is mismatched");
	}

	public void incompleteCaptureAtOther()throws Throwable{
		String exepctedLocation = "Other";
		String expectedCaptureStatus = "Incomplete";

		assertEquals(createCapture_location, exepctedLocation,"Location is mismatched");
		assertEquals(createCapture_captureStatus, expectedCaptureStatus,"Capture status is mismatched");
	}

	public void verifyAuditInformation()throws Throwable{
		boolean isActual;

		isActual = isPresent(createCapture_when);
		assertEquals(isActual, true,"Audit info When attribute is not present");

		isActual = isPresent(createCapture_empId);
		assertEquals(isActual, true,"Audit info Emp id attribute is not present");

		isActual = isPresent(createCapture_username);
		assertEquals(isActual, true,"Audit info Username attribute is not present");

	}

	public boolean isPresent(String value)throws Throwable{
		boolean isExist = false;

		if(!value.equals(null)){
			isExist = true;
		}
		return isExist;
	}

	///// Get - Get captures
	public void getCapturesServiceUrl(String storeId,String productId) throws URISyntaxException, InterruptedException, ClientProtocolException, IOException {

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getGetCaptures().getResource();
		resource = resource.replaceAll("\\bstoreid\\b", storeId);
		resource = resource.replaceAll("\\bwalkid\\b", createStorewalk_walkId);
		resource = resource.replaceAll("\\bitemid\\b", productId);

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;
		Thread.sleep(500);
	}

	//////Get captures service response
	public static void getCapturesServicesResponse()throws Throwable{

		System.out.println(Response);
		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("Get captures response : " + responseCode);

		int responseCodeE = 200;

		assertEquals(responseCode, responseCodeE, " Get capture details does not exist. Response code");
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		getCaptures_RootJsonResp = objectMapper.readValue(Response.getEntity().getContent(),  GetCaptures_Root.class);
		String ProductJSONresult1 = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(getCaptures_RootJsonResp);

		System.out.println("Get capture Response:\n" +  getCaptures_RootJsonResp);

		List<Storewalk_Capture> getCaptures_Capture = getCaptures_RootJsonResp.getCaptures();

		for(Storewalk_Capture capture : getCaptures_Capture){
			getCaptures_captureId =  capture.getCaptureId();
			System.out.println("Capture id : " +  getCaptures_captureId);

			getCaptures_captureType =  capture.getCaptureType();
			System.out.println("Capture type : " +  getCaptures_captureType);

			getCaptures_captureStatus =  capture.getCaptureStatus();
			System.out.println("Capture status : " +  getCaptures_captureStatus);

			getCaptures_qty =  capture.getQty();
			System.out.println("Qty : " +  getCaptures_qty);

			getCaptures_value =  capture.getValue();
			System.out.println("Value : " +  getCaptures_value);

			getCaptures_location =  capture.getLocation();
			System.out.println("Location : " +  getCaptures_location);

			getCaptures_isACase =  capture.getIsACase();
			System.out.println("Is a case : " +  getCaptures_isACase);

			Storewalk_CreationAudit  getCaptures_CreationAudit =  capture.getCreationAudit();
			getCaptures_when =  getCaptures_CreationAudit.getWhen();
			System.out.println("When : " +  getCaptures_when);

			Storewalk_Who  getCaptures_Who =  getCaptures_CreationAudit.getWho();
			getCaptures_empId =  getCaptures_Who.getEmpId();
			System.out.println("Emp id : " +  getCaptures_empId);
			getCaptures_username =  getCaptures_Who.getUsername();
			System.out.println("Username : " +  getCaptures_username);
		}
	}


	///// Get - Get All captures
	public void getAllCapturesServiceUrl(String storeId) throws URISyntaxException, InterruptedException, ClientProtocolException, IOException {

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getGetallCapture().getResource();
		resource = resource.replaceAll("\\bstoreid\\b", storeId);
		resource = resource.replaceAll("\\bwalkid\\b", createStorewalk_walkId);
		resource = resource.replaceAll("\\buserid\\b", collegueUsername);

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;

		Thread.sleep(500);
	}



	//////Get all captures service response
	public static void getAllCapturesServicesResponse()throws Throwable{

		System.out.println(Response);
		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("Get captures response : " + responseCode);

		int responseCodeE = 200;

		assertEquals(responseCode, responseCodeE, " Get all capture details does not exist. Response code");
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		getAllCaptures_RootJsonResp = objectMapper.readValue(Response.getEntity().getContent(), GetAllCaptures_Root.class);
		String ProductJSONresult1 = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(getCaptures_RootJsonResp);

		System.out.println("Get all capture Response:\n" +  getAllCaptures_RootJsonResp);

		List<GetAllCaptures_Capture> getAllCaptures_Capture = getAllCaptures_RootJsonResp.getCaptures();

		for(GetAllCaptures_Capture capture : getAllCaptures_Capture){
			getAllCaptures_productId =  capture.getProductId();
			System.out.println("Product id : " +  getAllCaptures_productId);

			getAllCaptures_description =  capture.getDescription();
			System.out.println("Description : " +  getAllCaptures_description);

			getAllCaptures_sectionId =  capture.getSectionId();
			System.out.println("Section id : " +  getAllCaptures_sectionId);

			getAllCaptures_sectionStatus =  capture.getSectionStatus();
			System.out.println("Section status : " +  getAllCaptures_sectionStatus);
		}
	}

	///// Get - Get Sections
	public void getSectionsServiceUrl(String storeId) throws URISyntaxException, InterruptedException, ClientProtocolException, IOException {

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getGetSectionApiServices().getResource();
		resource = resource.replaceAll("\\bstoreid\\b", storeId);
		resource = resource.replaceAll("\\bwalkid\\b", getStorewalk_walkId);
		resource = resource.replaceAll("\\bdepartmentId\\b", getStorewalk_dept_id);
		resource = resource.replaceAll("\\bgroupId\\b", getStorewalk_grp_id);
		resource = resource.replaceAll("\\bsectionId\\b", getStorewalk_section_id);

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;
		Thread.sleep(500);
	}

	///// Get - Get Sections capture type
	public void getSectionsServiceWithCaptureType(String storeId,String captureType) throws URISyntaxException, InterruptedException, ClientProtocolException, IOException {

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getGetSectionAttributesApiServices().getResource();
		resource = resource.replaceAll("\\bstoreid\\b", storeId);
		resource = resource.replaceAll("\\bwalkid\\b", getStorewalk_walkId);
		resource = resource.replaceAll("\\bdepartmentId\\b", getStorewalk_dept_id);
		resource = resource.replaceAll("\\bgroupId\\b", getStorewalk_grp_id);
		resource = resource.replaceAll("\\bsectionId\\b", getStorewalk_section_id);
		resource = resource.replaceAll("\\bcaptureType\\b", captureType);

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;

		Thread.sleep(500);
	}

	//////Get sections service response
	public static void getSectionsServicesResponse()throws Throwable{

		System.out.println(Response);
		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("Get captures response : " + responseCode);

		int responseCodeE = 200;

		//assertEquals(responseCode, responseCodeE, " Get section service with captures details does not exist. Response code");
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		getSections_RootJsonResp = objectMapper.readValue(Response.getEntity().getContent(),  GetSections_Root.class);
		String ProductJSONresult1 = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(getSections_RootJsonResp);

		System.out.println("Get section service with captures Response:\n" +  getSections_RootJsonResp);

		getSection_id =  getSections_RootJsonResp.getId();
		System.out.println("Section id : " +  getSection_id);
		verifyIsNotNull(getSection_id);

		getSection_name =  getSections_RootJsonResp.getName();
		System.out.println("Section name : " +  getSection_name);
		verifyIsNotNull(getSection_name);

		getSection_sortOrder =  getSections_RootJsonResp.getSortOrder();
		System.out.println("Section sort order : " +  getSection_sortOrder);
		verifyIsNotNull(getSection_sortOrder);

		getSection_status =  getSections_RootJsonResp.getStatus();
		System.out.println("Section status : " +  getSection_status);
		verifyIsNotNull(getSection_status);

	}

	public static void verifyIsNotNull(String response){
		boolean isNull = false;
		if(response!=null){
			isNull = true;
		}

		assertEquals(isNull, true,"Attribute response is null");
	}



	//////Get sections service response with Captures
	public static void getSectionsServicesResponseWithCaptures()throws Throwable{

		System.out.println(Response);
		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("Get captures response : " + responseCode);

		int responseCodeE = 200;

		//assertEquals(responseCode, responseCodeE, " Get section service with captures details does not exist. Response code");
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		getSections_RootJsonResp = objectMapper.readValue(Response.getEntity().getContent(),  GetSections_Root.class);
		SectionAPIJsonResp = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(getSections_RootJsonResp);

		System.out.println("Get section service with captures Response:\n" +  getSections_RootJsonResp);

		getSection_id =  getSections_RootJsonResp.getId();
		System.out.println("Section id : " +  getSection_id);

		getSection_name =  getSections_RootJsonResp.getName();
		System.out.println("Section name : " +  getSection_name);

		getSection_sortOrder =  getSections_RootJsonResp.getSortOrder();
		System.out.println("Section sort order : " +  getSection_sortOrder);

		getSection_status =  getSections_RootJsonResp.getStatus();
		System.out.println("Section status : " +  getSection_status);

		try{
			List<GetSections_Item> items = getSections_RootJsonResp.getItems();

			for(GetSections_Item item : items){

				List<Storewalk_Capture> captures = item.getCaptures();

				for(Storewalk_Capture capture : captures){

					getCaptures_captureId = capture.getCaptureId();
					System.out.println("Capture id : " +  getCaptures_captureId);

					getCaptures_captureType = capture.getCaptureType();
					System.out.println("Capture type : " +  getCaptures_captureType);

					getCaptures_captureStatus = capture.getCaptureStatus();
					System.out.println("Capture status : " +  getCaptures_captureStatus);

					sectionCaptureTypes.add(getCaptures_captureType);

				}
			}
		}
		catch(Exception e){
		}
	}



	public static Map<String, String> inCorrectHeaderForPostService() {

		String Header1Key = "Authorization";
		headers.put(Header1Key, "Bearer " + accessTocken);
		headers.put("Content-Type", "applicationnn");
		System.out.println(headers);
		return headers;
	}

	public static HttpResponse inCorrectPostServicePerformOperation() throws ClientProtocolException, IOException {
		headers = inCorrectHeaderForPostService();
		System.out.println("URI is \t" + currentUri + "headers are\t" + headers);
		System.out.println("payload details is 2 = " + mdStorewalk);
		if (currentUri != null)
			Response = WebServiceClient.postMethodResponse(currentUri, headers, mdStorewalk);

		else {
			System.out.println("\n URL value is missing.Please send valid URL to perform operation");
		}
		return Response;
	}

	public String getIncorrectAccessTokenAppLogin() throws Throwable {
		accessTocken = mDLoginJsonResp.getAccessToken()+"xxxx";
		System.out.println("Access Tocken is " + accessTocken);

		return accessTocken;
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

		assertEquals(true, isExpected, " Response code for create walkitem service is not as expected");
	}

	public void verifyAPIResponse400Or404() throws Throwable {
		System.out.println(Response);
		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("Create walkitem response : " + responseCode);

		boolean isExpected = false;

		if(responseCode==400 || responseCode==404)
		{
			isExpected = true;
		}

		assertEquals(true, isExpected, " Response code for create walkitem service is not as expected");
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

		assertEquals(true, isExpected, " Response code for create walkitem service is not as expected");
	}

	public void verifyAPIResponse500() throws Throwable {
		System.out.println(Response);
		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("Create walkitem response : " + responseCode);

		boolean isExpected = false;

		if(responseCode==500)
		{
			isExpected = true;
		}

		assertEquals(true, isExpected, " Response code for create walkitem service is not as expected");
	}


	public void createCaptureForNegativePrompt(String storeId,String productId,String location,String value,String sectionId,String captureType)throws Throwable {
		CreateCapture_PostBody createCapture_PostBody = new CreateCapture_PostBody();
		createCapture_PostBody.setLocation(location);
		createCapture_PostBody.setValue(Integer.valueOf(value));
		createCapture_PostBody.setSectionId(Integer.valueOf(sectionId));
		createCapture_PostBody.setCaptureType(captureType);

		String createCaptureServiceBody = objectMapper.writeValueAsString(createCapture_PostBody);
		System.out.println("Payload body is " + createCaptureServiceBody);

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getCreateCapture().getResource();
		resource = resource.replaceAll("\\bstoreid\\b", storeId);
		resource = resource.replaceAll("\\bwalkid\\b", createStorewalk_walkId);
		resource = resource.replaceAll("\\bitemid\\b", productId);

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		mdStorewalk = createCaptureServiceBody;
		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;

		Thread.sleep(500);
	}

	public void deleteCountStorewalk(String storeId) throws URISyntaxException, InterruptedException, ClientProtocolException, IOException {

		int count = countWalktypeList.size();

		for(int i=0;i<=count-1;i++)
		{
			String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
			String resource = applicationConfig.getDeleteStorewalk().getResource();
			resource = resource.replaceAll("\\bstoreid\\b", storeId);
			resource = resource.replaceAll("\\bwalkid\\b", countWalktypeList.get(i));

			URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

			currentUri = uriBuilder.build();
			System.out.println(currentUri);
			mDAccessTocken = accessTocken;

			Response = deleteServicePerformOperation();

			Thread.sleep(500);
		}
	}

	public void deleteMarketStreetStorewalk(String storeId) throws URISyntaxException, InterruptedException, ClientProtocolException, IOException {

		int count = marketstreetWalktypeList.size();

		for(int i=0;i<=count-1;i++)
		{
			String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
			String resource = applicationConfig.getDeleteStorewalk().getResource();
			resource = resource.replaceAll("\\bstoreid\\b", storeId);
			resource = resource.replaceAll("\\bwalkid\\b", marketstreetWalktypeList.get(i));

			URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

			currentUri = uriBuilder.build();
			System.out.println(currentUri);
			mDAccessTocken = accessTocken;

			Response = deleteServicePerformOperation();

			Thread.sleep(500);
		}
	}

	public String getGroupAndProductId(){

		String productId = GlhNegativePromptPO.productMinText;

		warehouseGroup = getGroupAndItemId.get(productId);

		return warehouseGroup;
	}

	public void postStorewalkData(String productId,String location,int qty,String captureType) throws JsonProcessingException{
		List<PostStorewalk_Capture> postStorewalk_Capture = new ArrayList<PostStorewalk_Capture>();

		PostStorewalk_CapturesRoot postStorewalk_CapturesRoot = new PostStorewalk_CapturesRoot();
		PostStorewalk_Capture capture = new PostStorewalk_Capture();
		capture.setProductId(productId);
		capture.setLocation(location);
		capture.setCaptureType(captureType);
		capture.setQty(qty);

		postStorewalk_Capture.add(capture);
		postStorewalk_CapturesRoot.setCaptures(postStorewalk_Capture);

		postStorewalkBody = objectMapper.writeValueAsString(capture);
		System.out.println("Payload body is " + postStorewalkBody);
	}


	/////Post storewalk
	public void postStorewalkServiceUrl(String storeId) throws URISyntaxException, InterruptedException, ClientProtocolException, IOException {

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getPostStorewalk().getResource();
		resource = resource.replaceAll("\\bstoreid\\b", storeId);
		resource = resource.replaceAll("\\bwalkid\\b", createStorewalk_walkId);
		resource = resource.replaceAll("\\buserid\\b", collegueUsername);
		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		mdStorewalk = postStorewalkBody;
		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;

		Thread.sleep(500);
	}
	
	
///// Get - Get walkitem for Count walkid
	public void getWalkItemForCountUrl(String countName,String storeId,String productIds) throws URISyntaxException, InterruptedException, ClientProtocolException, IOException {

		createStorewalk_walkId = countNameAndWalkid.get(countName);
		
		List<String> itemsList = Arrays.asList(productIds.split("\\s*,\\s*"));
		int count = itemsList.size();

		System.out.println("Item list : " + itemsList);

		for(int i = 0;i<=count-1;i++){
			itemList.add(itemsList.get(i));
			System.out.println("Item : " + itemList);
		}
		
		String productId = itemsList.get(0);
		
		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getGetWalkitem().getResource();
		resource = resource.replaceAll("\\bstoreid\\b", storeId);
		resource = resource.replaceAll("\\bwalkid\\b", createStorewalk_walkId);
		resource = resource.replaceAll("\\bitemid\\b", productId);

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;

		Thread.sleep(500);
	}
	
///// Get - Get Storewalk for COUNT storewalk
	public void getStorewalkServiceCount(String countName,String storeID) throws URISyntaxException, InterruptedException, ClientProtocolException, IOException {
		
			createStorewalk_walkId = countNameAndWalkid.get(countName);
			System.out.println("Count name  : " + "and Walk id : " + createStorewalk_walkId);

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getGetStoreWalkForStore().getResource();
		resource = resource.replaceAll("\\bstoreid\\b", storeID);
		resource = resource.replaceAll("\\bwalkid\\b", createStorewalk_walkId);

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;

		Thread.sleep(500);
	}
	
	
///// Get - Get Storewalk (Count name and walk id)
	public static void getCountNameAndWalkID(String storeId,String walkType)throws Throwable{

		System.out.println(Response);
		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("Get storewalkss response : " + responseCode);

		int responseCodeE = 200;

		if(responseCode==200){
			assertEquals(responseCode, responseCodeE, " Storewalk details does not exist. Response code");
			objectMapper.setSerializationInclusion(Include.NON_NULL);
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			getCountsStorewalkJsonResp = objectMapper.readValue(Response.getEntity().getContent(), GetCountsStorewalk.class);
			String ProductJSONresult1 = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(getCountsStorewalkJsonResp);

			System.out.println("Get Count Storewalk Response:\n" + getCountsStorewalkJsonResp);

			List<GetCountsStorewalkRoot> getCountStorewalks = getCountsStorewalkJsonResp.getStorewalks();
			
			for(GetCountsStorewalkRoot getCountStorewalk : getCountStorewalks){
				
				String storeNumber = getCountStorewalk.getStoreNumber();
				String type = getCountStorewalk.getWalkType();
				
				if(storeNumber.equalsIgnoreCase(storeId) && type.equalsIgnoreCase(walkType)){
					String countName = getCountStorewalk.getName();
					String countWalkid = getCountStorewalk.getWalkId();
					
					countNameAndWalkid.put(countName, countWalkid);
				}
			}
		}
	}


	//////Get Count storewalk service response 
	public static void getCountStorewalkServiceResponse(String name,String storeId)throws Throwable{

		System.out.println(Response);
		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("Get Count storewalks service response : " + responseCode);

		int responseCodeE = 200;

		assertEquals(responseCode, responseCodeE, " Get Count storewalks service details does not exist. Response code");
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		getCountsStorewalkRootJsonResp = objectMapper.readValue(Response.getEntity().getContent(),  GetCountsStorewalkRoot.class);
		String getCountsStorewalkRootJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(getCountsStorewalkRootJsonResp);

		System.out.println("Get Count storewalks service Response:\n" +  getCountsStorewalkRootJson);

		getStorewalk_walkId  = getCountsStorewalkRootJsonResp.getWalkId();
		System.out.println("Walk id : " +  getStorewalk_walkId);
		getStorewalk_storeNumber = getCountsStorewalkRootJsonResp.getStoreNumber();
		System.out.println("Store number : " +  getStorewalk_storeNumber);
		getStorewalk_walkType = getCountsStorewalkRootJsonResp.getWalkType();
		System.out.println("Walk type : " +  getStorewalk_walkType);
		getStorewalk_isCurfewStore = getCountsStorewalkRootJsonResp.isCurfewStore();
		System.out.println("Is Curfew store : " +  getStorewalk_isCurfewStore);
		getStorewalk_name = getCountsStorewalkRootJsonResp.getName();
		System.out.println("Name : " +  getStorewalk_name);
		getStorewalk_scheduleReferenece = getCountsStorewalkRootJsonResp.getSchedule_ref();
		System.out.println("Schedule reference : " +  getStorewalk_scheduleReferenece);
		getStorewalk_date = getCountsStorewalkRootJsonResp.getDate();
		System.out.println("Date : " +  getStorewalk_date);
		getStorewalk_startTime = getCountsStorewalkRootJsonResp.getStart_time();
		System.out.println("Start time : " +  getStorewalk_startTime);
		getStorewalk_endTime = getCountsStorewalkRootJsonResp.getEnd_time();
		System.out.println("End time : " +  getStorewalk_endTime);
		getStorewalk_mode = getCountsStorewalkRootJsonResp.getMode();
		System.out.println("Mode : " +  getStorewalk_mode);
		getStorewalk_storewalkStatus = getCountsStorewalkRootJsonResp.getStoreWalkStatus();
		System.out.println("Storewalk status : " +  getStorewalk_storewalkStatus);

		List<GetCountLocationDetails> getCountLocationDetails = getCountsStorewalkRootJsonResp.getLocations();
		for(GetCountLocationDetails getCountLocationDetail : getCountLocationDetails){

			getStorewalk_countLocation = getCountLocationDetail.getCountLocation();
			System.out.println("Count location : " +  getStorewalk_countLocation);
			getStorewalk_countStatus = getCountLocationDetail.getCountStatus();
			System.out.println("Count status : " +  getStorewalk_countStatus);

			countsLocationAndStatus.put(getStorewalk_countLocation, getStorewalk_countStatus);
		}
try{
		List<GetCountsDept> getCountsDepts = getCountsStorewalkRootJsonResp.getDepartments();
		for(GetCountsDept getCountsDept : getCountsDepts){

			getStorewalk_dept_id = getCountsDept.getId();
			System.out.println("Dept id : " + getStorewalk_dept_id);
			getStorewalk_dept_name = getCountsDept.getName();
			System.out.println("DeptName : " + getStorewalk_dept_name);
			getStorewalk_dept_sortOrder = getCountsDept.getSortOrder();
			System.out.println("Dept Sort order : " + getStorewalk_dept_sortOrder);

			List<GetCountsGrp> getCountsGrps = getCountsDept.getGroups();
			for(GetCountsGrp getCountsGrp : getCountsGrps){
				getStorewalk_grp_id = getCountsGrp.getId();
				System.out.println("Group id : " + getStorewalk_grp_id);
				getStorewalk_grp_name = getCountsGrp.getName();
				System.out.println("Group name : " + getStorewalk_grp_name);
				getStorewalk_grp_sortOrder = getCountsGrp.getSortOrder();
				System.out.println("Group sort order : " + getStorewalk_grp_sortOrder);

				List<GetCountsSect> getCountsSects = getCountsGrp.getSections();
				for(GetCountsSect getCountsSect : getCountsSects){
					getStorewalk_section_id = getCountsSect.getId();
					System.out.println("Section id : " + getStorewalk_section_id);
					getStorewalk_section_name = getCountsSect.getName();
					System.out.println("Section name : " + getStorewalk_section_name);
					getStorewalk_section_sortOrder = getCountsSect.getSortOrder();
					System.out.println("Section sort order : " + getStorewalk_section_sortOrder);

					List<GetCountsItems> getCountsItems = getCountsSect.getItems();
					for(GetCountsItems getCountsItem : getCountsItems){

						getWalkitem_productId = getCountsItem.getProductId();
						getWalkitem_standardUnitOfMeasure = getCountsItem.getStandardUnitOfMeasure();
						getWalkitem_stockUom = getCountsItem.getStockUom();
						getWalkitem_qtyOnHand = getCountsItem.getQtyOnHand();
						getWalkitem_sOHValue = getCountsItem.getsOHValue();
						getWalkitem_qtyInTransit = getCountsItem.getQtyInTransit();
						getWalkitem_stockState = getCountsItem.getStockState();
						getWalkitem_price = getCountsItem.getPrice();
						getWalkitem_adjustmentPrice = getCountsItem.getAdjustmentPrice();
						getWalkitem_isLargeAdjustment = getCountsItem.isLargeAdjustment();
						getWalkitem_packSize = getCountsItem.getPackSize();
						getWalkitem_variance = getCountsItem.getVariance();
						getWalkitem_variancePercentage = getCountsItem.getVariancePercentage();
						getWalkitem_reviewCaptureCount = getCountsItem.getReviewCaptureCount();
						getWalkitem_rangeStatus = getCountsItem.getRangeStatus();
						
						productRangeStatus.put(getWalkitem_productId, getWalkitem_rangeStatus);

						Storewalk_CountType countType = getCountsItem.getCountType();
						getWalkitem_countType = countType.getType();
						System.out.println("Count type : " + getWalkitem_countType);
						productCountType.put(getWalkitem_productId, getWalkitem_countType);

						Storewalk_Action actionType = getCountsItem.getAction();
						getWalkitem_actionType = actionType.getActionType();
						System.out.println("Action type: " + getWalkitem_actionType);
						productActionType.put(getWalkitem_productId, getWalkitem_actionType);
					}
				}
			}
		}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	////Verifying Post count body is same as Get count storewalk response.
	public void verifyCountJSonResponseIsSame()throws Throwable{

		String type = CountPostStepDefService.setStorewalkType;
		String name = CountPostStepDefService.setName;
		String startTime = CountPostStepDefService.startTime;
		String endTime = CountPostStepDefService.endTime;
		String date = CountPostStepDefService.date;
		String scheduleRef = CountPostStepDefService.setScheduleRef;
		String mode = CountPostStepDefService.setMode;

		assertEquals(getStorewalk_name,name,"Count storewalk name is mismatched");
		assertEquals(getStorewalk_walkType, type ,"Count walktype is mismatched");
		//assertEquals(getStorewalk_date, date ,"Count create Date is mismatched");
		//assertEquals(getStorewalk_startTime, startTime ,"Count create Start time is mismatched");
		//assertEquals(getStorewalk_endTime, endTime ,"Count create End time is mismatched");
		assertEquals(getStorewalk_scheduleReferenece, scheduleRef ,"Schedule Referenece is mismatched");
		assertEquals(getStorewalk_mode, mode ,"Count mode is mismatched");
	}

	public void verifyStorewalkStatus(String storewalkStatus)throws Throwable{

		assertEquals(getStorewalk_storewalkStatus, storewalkStatus ,"Storewalk status is mismatched");
	}

	public void verifyCountLocationStatus(String location,String locationStatus)throws Throwable{

		String locationStatusService = countsLocationAndStatus.get(location);
		assertEquals(locationStatusService, locationStatus ,"Count location status is mismatched");
	}

	public void verifyProductCountType(String productMins,String countType)throws Throwable{

		List<String> itemsList = Arrays.asList(productMins.split("\\s*,\\s*"));
		int count = itemsList.size();

		System.out.println("Item list : " + itemsList);


			String countTypeService = productCountType.get(itemsList.get(0));
			assertEquals(countTypeService, countType ,"Product count type is mismatched");


	}

	public void verifyProductActionType(String productMins,String actionType)throws Throwable{

		List<String> itemsList = Arrays.asList(productMins.split("\\s*,\\s*"));
		int count = itemsList.size();

		System.out.println("Item list : " + itemsList);


		String actionTypeService = productActionType.get(itemsList.get(0));
		assertEquals(actionTypeService, actionType ,"Product com.morrisons.common.action type is mismatched");
	}

	public void verifyRangeStatus(String productMins,String rangeStatus)throws Throwable{
		List<String> itemsList = Arrays.asList(productMins.split("\\s*,\\s*"));
		int count = itemsList.size();

		System.out.println("Item list : " + itemsList);
			try{
		String rangeStatusService = productRangeStatus.get(itemsList.get(0));
		assertEquals(rangeStatusService, rangeStatus ,"Range status is mismatched");
			}
			catch(Exception e){
				
			}
		}

	public void verifyNotCurfewStore(String curfewStore)throws Throwable{
		
		if(curfewStore.equalsIgnoreCase(getStorewalk_storeNumber)){
		assertEquals(getStorewalk_isCurfewStore, false , curfewStore +" is curfew store");
		}
	}
	
public void verifyCurfewStore(String curfewStore)throws Throwable{
		
		if(curfewStore.equalsIgnoreCase(getStorewalk_storeNumber)){
		assertEquals(getStorewalk_isCurfewStore, true , curfewStore +" is not curfew store");
		}
	}

//walkitem verification
	public void verifyWalkitemServiceAttributes(String UOM, String countType, String actionType ) throws ParseException, InterruptedException, IOException {
	    String getuom = 	getWalkitem_stockUom;
		String oresp = WebServicesUtilities.retryGETRequestWithout(Base_SERVICE_BASE_URL, "/stock/v2/locations/" + ApplicationContext.STORE_ID + "/items", "apikey", "GxpnvAuZJzq0hIZ4ZjnkNWUK51Axj3bY","itemnumber[in]", "[" + getWalkitem_productId + "]" , "Authorization", "Basic R3hwbnZBdVpKenEwaElaNFpqbmtOV1VLNTFBeGozYlk6QVh2T1pmU0RRSmF5ZWhSWg==");
		ApplicationContext applicationContext = new ApplicationContext();
		API_ServiceStepDef oObj = new API_ServiceStepDef(applicationContext);
//		oObj.iGetTheFieldValueForTheField("stockPosition-unitofMeasure");
		ArrayList<String> arrList = new ArrayList<String>();
		arrList = DynamicRequestMethods.MapFields("stockPosition--unitofMeasure");
		ArrayList<String> arrRespdata = DynamicRequestMethods.CaptureResponseData(oresp, arrList);
		UOM = ApplicationContext.oKeyField.get("stockPosition--unitofMeasure");
	   Assert.assertEquals(getuom, UOM,  "UOM mismatched");
	
	String counttypee = getWalkitem_type;
		String jsonResponseString = WebServicesUtilities.retryGETRequestWithHeader(Base_SERVICE_BASE_URL, "/storewalk/v1/configurations", "apikey", "ZwQGsEN0f65kORZ8EVQlJWA2bGNbHls0", "limit", "12000", "Authorization", "Bearer " + StorewalkStepDefService.accessToken);
		if(jsonResponseString.contains(countType)){
			arrList = DynamicRequestMethods.MapFields("itemNumber=" +countType + "--countType");
			ArrayList<String> arrRespdata1 = DynamicRequestMethods.CaptureRespDataBasedOnItemKey(jsonResponseString, arrList);
			countType = ApplicationContext.oKeyField.get("itemNumber=" +countType + "--countType");
//			countType = "cases";
		}
		else{
			countType = "singles";
		}
	Assert.assertEquals(counttypee, countType, "countType mismatched");
	
	boolean soh = getWalkitem_sOHValue.isEmpty();
	Assert.assertEquals(soh, false, "SOH is not present");
	
	String aaction = getWalkitem_actionType;
	Assert.assertEquals(aaction, actionType, "Action mismatched");
			
	
	}

	public void verifygetwalkitePack() {
		boolean getPacksize = getWalkitem_packSize.isEmpty();
		assertEquals(getPacksize, false, "Packsize is not Empty");

	}
	
	public void getwalkitemVerifyplan() {
		
		boolean plann = true;		
		if(!getWalkitem_RootJsonResp.getPlan().isEmpty())
		{
			assertEquals(plann, true, "Mulitiple Plan is not present");
	}
		assertEquals(plann, false, "Mulitiple Plan is not present");
}


	}
