package com.morrisons.sma.page_objects.service;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import com.morrisons.common.utility.MarkdownServiceData;
import com.morrisons.sma.page_objects.mobile.old.CleanAndRotatePO;
import com.morrisons.sma.page_objects.mobile.old.CountPO;
import com.morrisons.sma.page_objects.mobile.old.MarkDownPO;
import com.morrisons.sma.pojo.service.CleanNRotateServicePOJO.*;
import com.morrisons.sma.pojo.service.MarkdownPOJO.MarkdownEventVo;
import com.morrisons.sma.pojo.service.MarkdownPOJO.MarkdownLoginVo;
import com.morrisons.sma.pojo.service.MarkdownPOJO.MarkdownMax;
import com.morrisons.sma.pojo.service.MarkdownPOJO.MarkdownVO;
import com.morrisons.sma.pojo.service.PricePrompPOJO.MainWalkId;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.Glh_WalkIdMain;
import com.morrisons.sma.step_definitions.service.old.RestAssuredSteps;
import io.appium.java_client.android.AndroidDriver;
import org.apache.http.HttpResponse;

import java.net.URI;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.testng.Assert.assertEquals;

//import org.openqa.selenium.WrapsDriver;


public class CnRServiceVerification {
	public static Map<String, String> headers = new HashMap<>();
	static ObjectMapper objectMapper = new ObjectMapper();
	public static HttpResponse Response;
	public static io.restassured.response.Response restResponse;
	public List<String> DatefromApp = new ArrayList<>();
	public static String weekDate;
	public static String weekStatus;
	public static String departmentName;
	public static String departmentStatus;
	public static String departmentNextCheck;
	public static String departmentUpdateByName;
	public static String departmentUpdateOn;
	public static String itemList;
	public static String departmentCheckId;

	MarkdownLoginVo mDLoginJsonResp = new MarkdownLoginVo();
	RestAssuredSteps loginTocken = new RestAssuredSteps();
	MarkdownVO markdownJsonResp = new MarkdownVO();
	public static CnR_SchedulesVo cnRScedulesJsonResp;
	public static CnR_DepartmentVO cnRDepartmentJsonResp;
	public static  CnR_ItemListVo cnRMarkdownItemListJsonResp;
	MarkdownVO markdownJsonResp1 = new MarkdownVO();
	MarkdownVO markdownJsonResp2 = new MarkdownVO();
	MarkdownVO markdownJsonResp3 = new MarkdownVO();
	MarkdownMax maxMarkdown = new MarkdownMax();
	MainWalkId walkidGet = new MainWalkId();
	Glh_WalkIdMain getwalkId = new Glh_WalkIdMain();
	static String newWalkID;
	public static String prdtId;
	public static int itemQuantity;

	CountPO counts = new CountPO();

	public static CnR_Schedules cnRSchedulesJsonResponse;
	CnR_Department cnRDepartmentJsonResponse = new CnR_Department();

	private static AndroidDriver driveR;

	public static CleanAndRotatePO cnRpageObjects;
	MarkDownPO markdown = new MarkDownPO();
	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();

	MarkdownEventVo markdownEventResp = new MarkdownEventVo();
	static String accessTocken;
	String accessTockenGLH;
	String markdownBarcodeTest;
	String complete;
	String tokenaccess;
	String env = applicationConfig.getWebElementEnviroment().getEnv();
	public static String optiumPriceApp;
	public static String appQty;
	public static String noCalPrice;
	public static String restpayload;
	public static Glh_WalkIdMain restresponse;
	public static int restStatus;

	public static Map<String, List<String>> weekScheuleResult = new HashMap<String, List<String>>();
	public static List<String> weekNumberList = new ArrayList<String>();

	public static URI currentUri;
	public static String mDAccessTocken;

	public static Calendar calendar = new GregorianCalendar();
	public static String currentWeekOfYear = String.valueOf(calendar.get(calendar.WEEK_OF_YEAR));
	public static String previousWeekOfYear =  String.valueOf(calendar.get(calendar.WEEK_OF_YEAR)-2);
	public static String nextWeekOfYear =  String.valueOf(calendar.get(calendar.WEEK_OF_YEAR)+ 1);

	public static String token;
	public static String selectWeek;

	public static List<String> departmentListUI = new ArrayList<String>();
	public static List<String> departmentListServices = new ArrayList<String>();
	public static HashMap<String,String> departmentNextCheckList = new HashMap<String,String>();
	public static HashMap<String,String> departmentStatusList = new HashMap<String,String>();
	public static HashMap<String,String> departmentUpdatedByList = new HashMap<String,String>();
	public static HashMap<String,String> departmentUpdatedOnList = new HashMap<String,String>();
	public static HashMap<String,String> departmentCheckIdList = new HashMap<String,String>();
	public static HashMap<String,String> departmentsCheckIDList = new HashMap<String,String>();

	public static String deptName;
	public static String itemNumber;
	public static String actionName;
	public static String actionPerformed;
	public static String expiryDate;
	public static String quantity;
	public static String isDeleted;
	public static String itemDescription;
	public static String actionNameUI;

	public static Map<String, List<String>> hm = new HashMap<String, List<String>>();
	public static List<String> values = new ArrayList<String>();
	public static List<String> values1 = new ArrayList<String>();

	public static String itemCount;
	public static String totalItems;
	public static String totalItemsService;
	
	public static int itemCountServices;
	public static int totalItemsServices;
	
	String collegueUsername = applicationConfig.getUserCredentials().getCollegueUsername();
	String colleguePassword = applicationConfig.getUserCredentials().getColleguePassword();
	String managerUsername = applicationConfig.getUserCredentials().getManagerUsername();
	String managerPassword = applicationConfig.getUserCredentials().getManagerPassword();

	public static void getAccessToken(String accessToken){

		token = accessToken;
	}
	
	public void requestMadeToCNRCollegueLogin() throws Throwable{
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
	
	public void requestMadeToCNRManagerLogin() throws Throwable{
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

	public void requestMadeToCleanAndRotateLogin(String user, String password) throws Throwable{
		CleanAndRotateLogin crLgoin = new CleanAndRotateLogin();
		crLgoin.setUserName(user);

		crLgoin.setPassword(password);

		crLgoin.setProvider("morrisons");
		String crLoginBody = objectMapper.writeValueAsString(crLgoin);
		System.out.println("Payload body is " + crLoginBody);
		MarkdownServiceData.postLoginForMarkdown(crLoginBody);
		Response = MarkdownServiceData.postOperationForMdLogin();

		Thread.sleep(500);
	}

	public void serviceShouldReturnCleanAndRotateLogin() throws Throwable{
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

	public String getGeneratedAccessTokenForCR()throws Throwable{
		accessTocken = mDLoginJsonResp.getAccessToken();
		System.out.println("Access Tocken is " + accessTocken);
		return accessTocken;
	}
	public static void performCnRGetOperation() throws Throwable{
		Response = CleanAndRotateServiceData.performOperation();
	}
	
	public static void getScheduleResponse() throws Throwable {
		int responseCode = Response.getStatusLine().getStatusCode();
		String errorMessage = Response.getStatusLine().getReasonPhrase();
		int responseCodeE = 200;
		System.out.println("Error Message is - " + errorMessage);

		assertEquals(responseCode, responseCodeE, " Schedule details does not exist. Response code");
	}

	public static void getScheduleServiceResponse() throws Throwable{

		int responseCode = Response.getStatusLine().getStatusCode();
		int responseCodeE = 200;

		assertEquals(responseCode, responseCodeE, " Schedule details does not exist. Response code");

		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		cnRScedulesJsonResp = objectMapper.readValue(Response.getEntity().getContent(), CnR_SchedulesVo.class);
		String ProductJSONresult1 = objectMapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(cnRScedulesJsonResp);
		System.out.println("Markdown Login Response:\n" + ProductJSONresult1);

		System.out.println("cnR Response:\n" + cnRScedulesJsonResp);
		List<CnR_Schedules> allScheduledWeeks = cnRScedulesJsonResp.getSchedules();
		for (CnR_Schedules datefromService : allScheduledWeeks) {

			if(datefromService.getWeekNumber().equals(selectWeek))
			{
				weekDate = datefromService.getStartDate();
				System.out.println("Date from Service---" + datefromService.getStartDate());

				weekStatus = datefromService.getStatus();
				System.out.println("Status from Service---" + datefromService.getStatus());
			}
			System.out.println("Status from Service---" + datefromService.getWeekNumber());
		}
	}

	public static void verifyUIWeekNameAndStatusWithServices() throws ParseException{

		String weekname = cnRpageObjects.weekNameUI.replace("Week", "").replace(" ", "");
		String weekstatusUI = cnRpageObjects.weekStatusUI;

		String weekStartDate= weekname.replace("January", "/01/").replace("February", "/02/").replace("March", "/03/")
				.replace("April", "/04/").replace("May", "/05/").replace("June", "/06/").replace("July", "/07/")
				.replace("August", "/08/").replace("September", "/09/").replace("October", "/10/")
				.replace("November", "/11/").replace("December", "/12/").replaceAll("([a-z])", "");

		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(weekStartDate);
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String weekNameUI = sdf.format(date);
		System.out.println(weekNameUI);

		assertEquals(weekNameUI, weekDate,"Week Name is mismatched on UI and Services");
		assertEquals(weekstatusUI, weekStatus,"Week Status is mismatched on UI and Services");
	}


	public static void getDepartmentServiceResponse() throws Throwable {
		int responseCode = Response.getStatusLine().getStatusCode();
		int responseCodeE = 200;

		assertEquals(responseCode, responseCodeE, " department details does not exist. Response code");
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		cnRDepartmentJsonResp = objectMapper.readValue(Response.getEntity().getContent(), CnR_DepartmentVO.class);
		String ProductJSONresult1 = objectMapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(cnRDepartmentJsonResp);
		System.out.println("cnR Response:\n" + cnRDepartmentJsonResp);

		List<CnR_Department> allDepartments = cnRDepartmentJsonResp.getDepartments();
		for (CnR_Department departments : allDepartments) {

			departmentListServices.add(departments.getDepartmentName());

			departmentName = departments.getDepartmentName();
			System.out.println("Department Name from Service---" + departmentName);

			departmentStatus = departments.getStatus();
			System.out.println("Department Status from Service---" + departmentStatus);

			departmentStatusList.put(departmentName, departmentStatus);

			departmentCheckId = departments.getDepartmentCheckId();
			System.out.println("Department Check id from Service---" + departmentCheckId);

			departmentsCheckIDList.put(departmentName,departmentCheckId);
		}

		for (CnR_Department departments : allDepartments) {

			departmentName = departments.getDepartmentName();
			System.out.println("Department Name from Service---" + departmentName);

			departmentNextCheck = departments.getNextCheck();
			System.out.println("Next Check from Service---" + departmentNextCheck);

			departmentNextCheckList.put(departmentName, departmentNextCheck);
		}
	}

	public static void verifyUIDepartmentNameStatusWithServices(String arg1)throws Throwable {

		int index= Integer.parseInt(arg1);

		String departmentNameUI = cnRpageObjects.departmentNameUI;
		String departmentStatusUI = cnRpageObjects.departmentStatusUI;

		departmentListUI.equals(departmentListServices);

		String deptStatus = departmentStatusList.get(departmentNameUI);
		String deptName = departmentListServices.get(index);

		assertEquals(departmentNameUI, deptName,"Department Name is mismatched on UI and Services");
		assertEquals(departmentStatusUI, deptStatus,"Department Status is mismatched on UI and Services");
	}

	public static void verifyUIDepartmentNextCheckWithServices()throws Throwable {
		String departmentNextCheck = cnRpageObjects.departmentNextCheckUI;

		String departmentStartDate= departmentNextCheck.replace("January", "/01/").replace("February", "/02/").replace("March", "/03/")
				.replace("April", "/04/").replace("May", "/05/").replace("June", "/06/").replace("July", "/07/")
				.replace("August", "/08/").replace("September", "/09/").replace("October", "/10/")
				.replace("November", "/11/").replace("December", "/12/").replaceAll("([a-z])", "");

		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(departmentNextCheck);
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String departmentNextCheckUI = sdf.format(date);
		System.out.println(departmentNextCheckUI);

		assertEquals(departmentNextCheckUI, departmentNextCheck,"Department Next Check is mismatched on UI and Services");
	}


	public static void getDepartmentCompletionServicesStatus()throws Throwable{

		int responseCode = Response.getStatusLine().getStatusCode();
		int responseCodeE = 200;

		assertEquals(responseCode, responseCodeE, " department details does not exist. Response code");
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		cnRDepartmentJsonResp = objectMapper.readValue(Response.getEntity().getContent(), CnR_DepartmentVO.class);
		String ProductJSONresult1 = objectMapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(cnRDepartmentJsonResp);
		System.out.println("cnR Response:\n" + cnRDepartmentJsonResp);

		List<CnR_Department> allDepartments = cnRDepartmentJsonResp.getDepartments();
		for (CnR_Department departments : allDepartments) {

			departmentListServices.add(departments.getDepartmentName());

			departmentName = departments.getDepartmentName();
			System.out.println("Department Name from Service---" + departmentName);

			departmentUpdateByName = departments.getUpdatedByName();
			System.out.println("Department Updated by name from Service---" + departmentUpdateByName);

			departmentUpdateOn = departments.getUpdatedOn();
			System.out.println("Department update on date from Service---" + departmentUpdateOn);

			departmentCheckId = departments.getDepartmentCheckId();
			System.out.println("Department Check id from Service---" + departmentCheckId);

			departmentUpdatedByList.put(departmentName, departmentUpdateByName);
			departmentUpdatedOnList.put(departmentName, departmentUpdateOn);
			departmentCheckIdList.put(departmentName,departmentCheckId);
		}
	}

	public static void verifyDepartmentCompletionServicesStatus()throws Throwable {
		String updatedByName = cnRpageObjects.departmentUpdatedByNameUI;
		String updatedOn = cnRpageObjects.departmentUpdatedOnUI.trim();
		String departmentTitle = cnRpageObjects.departmentTitleUI;

		String departmentUpdatedByServices = departmentUpdatedByList.get(departmentTitle);
		String departmentUpdatedOnServices =  departmentUpdatedOnList.get(departmentTitle).split("T")[0];

		DateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat sourceFormat1 = new SimpleDateFormat("dd/MM/yyyy");

		Date date = sourceFormat1.parse(updatedOn);

		String updatedOnUI  =sourceFormat.format(date);

		assertEquals(updatedByName, departmentUpdatedByServices,"Department Updated by is mismatched on UI and Services");
		assertEquals(updatedOnUI, departmentUpdatedOnServices,"Department Updated On is mismatched on UI and Services");
	}

	public static String getDepartmentCheckId()throws Throwable {
		String deptCheckId = null;
		String departmentNameUI = cnRpageObjects.departmentNameUI;		
		deptCheckId = departmentsCheckIDList.get(departmentNameUI);

		return deptCheckId; 
	}

	public static void getMarkdownItemListResponse() throws Throwable{

		int responseCode = Response.getStatusLine().getStatusCode();
		int responseCodeE = 200;

		assertEquals(responseCode, responseCodeE, " Schedule details does not exist. Response code");

		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		cnRMarkdownItemListJsonResp = objectMapper.readValue(Response.getEntity().getContent(), CnR_ItemListVo.class);
		String ProductJSONresult1 = objectMapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(cnRMarkdownItemListJsonResp);
		System.out.println("Markdown Login Response:\n" + ProductJSONresult1);

		System.out.println("cnR Response:\n" + cnRMarkdownItemListJsonResp);

		List<CnR_DepartmentProductCheck> allDepartments = cnRMarkdownItemListJsonResp.getItemList();
		for (CnR_DepartmentProductCheck departments : allDepartments) {		

			deptName = departments.getDepartmentName().trim();			
			itemNumber = departments.getProductMin().trim();		
			actionName = departments.getActionName().trim();		
			actionPerformed = departments.getActionPerformed().trim();		
			expiryDate = departments.getExpiryDate().trim();		
			quantity = departments.getQuantity().trim();	
			isDeleted = departments.getIsDeleted().trim();	
			itemDescription = departments.getProductName().trim();	

			values.add(itemNumber);
			values.add(itemDescription);
			values.add(expiryDate);
			values.add(quantity);
			values.add(actionName);
			values.add(actionPerformed);
			values.add(isDeleted);

			hm.put(deptName, values);						
		}
	}

	public static void getItemListCount() throws Throwable{

		int responseCode = Response.getStatusLine().getStatusCode();
		int responseCodeE = 200;

		assertEquals(responseCode, responseCodeE, " Schedule details does not exist. Response code");

		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		cnRMarkdownItemListJsonResp = objectMapper.readValue(Response.getEntity().getContent(), CnR_ItemListVo.class);
		String ProductJSONresult1 = objectMapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(cnRMarkdownItemListJsonResp);
		System.out.println("Markdown Login Response:\n" + ProductJSONresult1);

		System.out.println("cnR Response:\n" + cnRMarkdownItemListJsonResp);

		itemCountServices = cnRMarkdownItemListJsonResp.getMetadata().getCount();
		System.out.println("Item count is : "+itemCount);
		totalItemsServices = cnRMarkdownItemListJsonResp.getMetadata().getTotal();
		System.out.println("Total Item count is : "+totalItems);
	}

	public static void getItemsCount(String itemCount)throws Throwable{

		totalItemsService = itemCount;
	}

	public static void verifyItemCountUIWithServices(int itemCountUI)throws Throwable{

		int itemsOnUI = Integer.parseInt(totalItems);
		assertEquals(itemCountUI, itemCountServices,"Total items count is mismatched");
	}
	
	public static void getActionPerformedName(String actionName)throws Throwable{

		actionNameUI = actionName;
	}

	public static void verifyItemDetailServices() throws Throwable{

		String deptName = cnRpageObjects.deptNameUI;	    

		values1 = hm.get(deptName);		

		String itemNumberUI = cnRpageObjects.itemNumberUI.trim();
		String itemDescriptionUI = cnRpageObjects.itemDescriptionUI.trim();
		String expiryDateUI = cnRpageObjects.expiryDateUI.trim();

		DateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat sourceFormat1 = new SimpleDateFormat("dd/MM/yyyy");

		Date date = sourceFormat1.parse(expiryDateUI);

		String expiryDate  =sourceFormat.format(date);

		String actionPerformedUI = cnRpageObjects.actionPerformedUI.trim();

		assertEquals(itemNumberUI, values1.get(0),"Item min number is mismatched on UI and services");
		assertEquals(itemDescriptionUI, values1.get(1),"Item description is mismatched on UI and services");
		assertEquals(actionPerformedUI, values1.get(5),"Action performed is mismatched on UI and services");
		assertEquals(expiryDate, values1.get(2),"Expiry date is mismatched on UI and services");
		assertEquals(actionNameUI, values1.get(4),"Action is mismatched on UI and services");
		}
	
	
}


