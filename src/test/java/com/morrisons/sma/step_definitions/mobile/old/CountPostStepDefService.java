package com.morrisons.sma.step_definitions.mobile.old;

import static com.morrisons.common.helper.CommonHelperMethods.clickObject;
import static com.morrisons.common.helper.ElementRetry.clickElement7;
import static org.testng.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.morrisons.common.PageFactory.InitClass;
import com.morrisons.common.helper.CommonHelperMethods;
import org.apache.http.HttpResponse;
import org.apache.http.client.utils.URIBuilder;
import org.openqa.selenium.*;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;

import com.morrisons.common.action.Hook;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import com.morrisons.sma.page_objects.mobile.old.CountPO;
import com.morrisons.sma.page_objects.mobile.old.TimeChangePO;
import com.morrisons.sma.pojo.service.CountPostPOJO.CountPO_DepartmentList;
import com.morrisons.sma.pojo.service.CountPostPOJO.CountPO_PostList;
import com.morrisons.sma.pojo.service.CountPostPOJO.CountPost_PostPayLoad;
import com.morrisons.sma.page_objects.service.CountServiceData;
import com.morrisons.sma.page_objects.service.StorewalkServicePage;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import com.morrisons.common.utility.WebServiceClient;
import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.interactions.Actions;

public class CountPostStepDefService {
	public static HttpResponse Response;
	static ObjectMapper objectMapper = new ObjectMapper();
	CountPost_PostPayLoad postDetails = new CountPost_PostPayLoad();
	ObjectMapper object = new ObjectMapper();
	CountPO implement = new CountPO();
	TimeChangePO implemented = new TimeChangePO();
	public static String generatedWalkid;
	String ProductJSONresult;
	public static String deps;
	public static String productId;
	public static String productId2;
	public static String prdtIdfromEndpoint;
	public static String setName;
	public static String setMode;
	public static String setType;
	public static String descfromApp;
	public static String prdtFromApp;
	public static String reviewIDFromApp;
	public static String storeid;
	public static String postCountBody;
    WebElement oEle;
	List<WebElement> oEle1;
	List <CountPO_DepartmentList> departName = new ArrayList();
	CountPO_DepartmentList departValue = new CountPO_DepartmentList();	
	CountPO_DepartmentList departValue1 = new CountPO_DepartmentList();	
	CountPO_DepartmentList departValue2 = new CountPO_DepartmentList();	
	List<String> itemList = new ArrayList<String>();
	List<Integer> deptList = new ArrayList<Integer>();

	public static String startTime = null;
	public static String endTime = null;
	public static String date = null;
	public static String setScheduleRef = "Count Schedule Reference";
	public static String setStorewalkType = "Counts";

	public static Map<String, String> headers = new HashMap<>();

	public static String accessToken = null;
	public static URI currentUri;

	private static CountPost_PostPayLoad countPost_PostPayLoadJsonResp = new CountPost_PostPayLoad();

	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
	String env = applicationConfig.getWebElementEnviroment().getEnv();
	private AndroidDriver driveR;
	int repeat = 0;

	public CountPostStepDefService() {
		this.driveR = (AndroidDriver) Hook.getDriver();
	}


	@Given("Post count storewalk Item list data is {string}")
	public void setPostCountItemList(String productMins) throws Throwable {

		if(productMins.equalsIgnoreCase("null")){
			itemList = null;
			System.out.println("Item list : " + departName);
		}
		else{

			List<String> itemsList = Arrays.asList(productMins.split("\\s*,\\s*"));
			int count = itemsList.size();

			System.out.println("Item list : " + itemsList);

			for(int i = 0;i<=count-1;i++){
				itemList.add(itemsList.get(i));
				System.out.println("Item : " + itemList);

			}
			productId = itemsList.get(0);
			implement.getMin(productId);
		}

	}

	@Given("Post count storewalk Department list data is {string}")
	public void setPostCountDeptList(String depts) throws Throwable {

		if(depts.equalsIgnoreCase("null")){
			departName = null;
			System.out.println("Department list : " + departName);
		}
		else{
			List<String> deptList = Arrays.asList(depts.split("\\s*,\\s*"));////Splitting the String and storing in the list
			int count = deptList.size();
			System.out.println("Department list : " + deptList);

			List<CountPO_DepartmentList> departmentList = new ArrayList<CountPO_DepartmentList>();

			for(int i = 0;i<=count-1;i++){
				Integer deptNo = Integer.parseInt(deptList.get(i));
				CountPO_DepartmentList department = new CountPO_DepartmentList();
				department.setDepartment(deptNo);
				
				departmentList.add(department);
				
				departName = departmentList;
			}

			System.out.println("Department : " + departName);
	}
}

@Given("The Post request is made to create Count storewalk for window {string}")
public void setTimeWindow(String window) throws Throwable {

	Thread.sleep(2000);

	Date d = new Date();
	DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String currentDate = sdf.format(d);

	System.out.println("Current date : " + currentDate);

	if(window.equalsIgnoreCase("AM")){
		startTime = currentDate + " 06:45:17.328351";
		endTime = currentDate + " 09:40:17.328351";
		date = currentDate + " 06:30:17.328351";
	}
	else{
		if(window.equalsIgnoreCase("PM")){
			startTime = currentDate + " 13:45:17.328351";
			endTime = currentDate + " 23:15:17.328351";
			date = currentDate + " 00:00:00.328351";
		}
	}
}



@Given("The Post Storewalk body to create Count storewalk api for Store id {string},name {string} and mode {string}")
public void postCountRequest(String storeId, String countName, String countMode) throws Throwable {

	setName = countName;
	System.out.println("Post count name : " + setName);
	setMode = countMode;
	implement.reqName(setName);
	//List<String> itemList = Arrays.asList(items.split("\\s*,\\s*"));////Splitting the String and storing in the list
	//int count = itemList.size();
	//=====================================
		/*System.out.println("Department list : " + deptList);

	List<CountPO_DepartmentList> departmentList = new ArrayList<CountPO_DepartmentList>();

	for(int i = 0;i<=count-1;i++){
		Integer deptNo = Integer.parseInt(itemList.get(i));
		CountPO_DepartmentList department = new CountPO_DepartmentList();
		department.setDepartment(deptNo);

		departmentList.add(department);

		departName = departmentList;
	}
	System.out.println("Department : " + departName);*/
	//==================================
	System.out.println("Department list : " + itemList);
	CountPO_PostList countPO_PostList = new CountPO_PostList();
	countPO_PostList.setDate(date);
	countPO_PostList.setStartTime(startTime);
	countPO_PostList.setEndTime(endTime);
	countPO_PostList.setScheduleRef(setScheduleRef);
	countPO_PostList.setType(setStorewalkType);
	countPO_PostList.setName(setName);
	countPO_PostList.setMode(setMode);

	countPO_PostList.setItems(itemList);

	if(setMode.equalsIgnoreCase("list")){
		departName = null;
	}


	countPO_PostList.setDepartmentList(departName);

	postCountBody = object.writeValueAsString(countPO_PostList);
	System.out.println("Payload body is " + postCountBody);

	Thread.sleep(1000);
}


@Given("The Post request is made to create Count storewalk api for Store id {string}")
public static URI postLoginForCount(String storeID) throws URISyntaxException {

	String baseURI = applicationConfig.getCountDetails().getBaseURI();
	String resource = applicationConfig.getCountDetails().getResource();
	String queryparameter = applicationConfig.getCountDetails().getQueryParameter();
	resource = resource.replaceAll("\\bstoreId\\b", storeID);
	URIBuilder uriBuilder = new URIBuilder(baseURI + resource);
	uriBuilder.setCustomQuery(queryparameter);
	currentUri = uriBuilder.build();
	System.out.println("postLoginForCount : " + currentUri);
	return currentUri;
}

@Given("Post operation performed on post strorewalk api to create Count storewalk")
public static HttpResponse postServicePerformOperation() throws Throwable {
	String accessToken = StorewalkServicePage.getGeneratedAccessTokenAppLogin();  ///Getting generated access token

	String Header1Key = "Authorization";
	headers.put(Header1Key, "Bearer " + accessToken);
	headers.put("Content-Type", "application/json");
	System.out.println(headers);

	System.out.println("URI is \t" + currentUri + "headers are\t" + headers);
	System.out.println("payload details is 2 = " + postCountBody);
	if (currentUri != null)
		Response = WebServiceClient.postMethodResponse(currentUri, headers, postCountBody);

	else {
		System.out.println("\n URL value is missing.Please send valid URL to perform operation");
	}
	return Response;
}


@When("the request is made to the specified Count StoreWalk service for Store {string}")
public void the_request_is_made_to_the_specified_Count_StoreWalk_service(String storeID) throws Throwable {


	CountServiceData.postLoginForCount(postCountBody,storeID);
	Response = CountServiceData.postOperationForCount();
	Thread.sleep(500);
	int responseCode = Response.getStatusLine().getStatusCode();
	String errorMessage = Response.getStatusLine().getReasonPhrase();
	if(responseCode==200 || responseCode==201)
	{
		System.out.println("Error Message is - " + errorMessage);
		assertEquals(true, true, " Product details requested doesn't exist. Response code");
	}
	else{
		assertEquals(true, false, " Product details requested doesn't exist. Response code");
	}
	Thread.sleep(1000);

}

@Then("The service should return detailsCount StoreWalk Service")
public void the_service_should_return_detailsCount_StoreWalk_Service() throws Throwable {

	System.out.println(Response);
	int responseCode = Response.getStatusLine().getStatusCode();
	System.out.println("Get Count storewalks service response : " + responseCode);

	if(responseCode==200 || responseCode==201)
	{

		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		countPost_PostPayLoadJsonResp = objectMapper.readValue(Response.getEntity().getContent(),  CountPost_PostPayLoad.class);
		String getCountsStorewalkRootJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(countPost_PostPayLoadJsonResp);

		System.out.println("Post Count storewalks service Response:\n" +  countPost_PostPayLoadJsonResp);
	}
}

@Then("I verify the json response with Count StoreWalk")
public void i_verify_the_json_response_with_Count_StoreWalk() throws Throwable {
	generatedWalkid = countPost_PostPayLoadJsonResp.getWalk_id();

	System.out.println("Walk id = " + generatedWalkid);

	Thread.sleep(500);
}

public static String getWalkID(String WalkId) throws Throwable {
	generatedWalkid = WalkId;
	return generatedWalkid;
}

@Then("I verify that the posted counts are displayed in Warehouse and select the count")
public void i_verify_that_the_posted_counts_are_displayed_in_Warehouse() throws Throwable {
	try{
		implement.warehouseDesc();

		assertEquals(setName, descfromApp, "Product name from endpoint does not match");
		System.out.println("Name Found");

	}catch(Exception e){
		System.out.println(e.getMessage());
	}
	Thread.sleep(1000);
}

	@Then("I verify {string} counts are displayed in {string} on {string} page")
	public void iVerifyCountsAreDisplayedInReviewlocationOnCountsPOPage(String countName, String sLocation, String sPageName) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, NoSuchFieldException {
		String sActualCountNameCaptured;
		oEle = InitClass.createObject(driveR,sLocation, "com.morrisons.sma.page_objects.mobile." + sPageName);
//		if(oEle.toString().contains("ToReplace")){
//			oEle = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/scheduled_counts_department_name']"));
//		}
		sActualCountNameCaptured = CommonHelperMethods.getText(driveR, oEle);
		assertEquals(countName, sActualCountNameCaptured, "Product name from endpoint does not match");
		System.out.println("Name Found");
	}
	/*@Then("I verify {string} counts are displayed in {string} on {string} page")
	public void iVerifyNameCountsAreDisplayedIn(String countName, String sLocation, String sPageName) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
		String sActualCountNameCaptured;
		oEle = InitClass.createObject(sLocation,"com.morrisons.sma.page_objects.mobile." + sPageName);
		if(oEle.toString().contains("ToReplace")){
			oEle = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/scheduled_counts_department_name']"));
		}
		sActualCountNameCaptured = CommonHelperMethods.getText(driveR, oEle);
		assertEquals(countName, sActualCountNameCaptured, "Product name from endpoint does not match");
		System.out.println("Name Found");
	}*/
@Then("I verify that the posted counts are displayed")
public void verifyPostedCountsAreDisplayed() throws Throwable {
	implement.verifyCountDisplay();
	Thread.sleep(500);
}


@Then("The field should be disabled")
public void the_field_should_be_disabled() throws Throwable {
	implement.reviewDoneClick();
	Thread.sleep(1000);
}

public static void nameFromApp(String name) throws Throwable {
	descfromApp = name;
}

public void getProdtId(String prdtID) throws Throwable {
	prdtIdfromEndpoint = prdtID;

}

@Then("I click on Counts")
public void i_click_on_Counts() throws Throwable {
	implement.countClick();

}

	@Then("I click on {string} on page {string}")
	public void i_click_on_Object_on_page(String sObjName, String sPageName) throws Throwable {
		try {
			Thread.sleep(3000);
			oEle = InitClass.createObject(driveR, sObjName, "com.morrisons.sma.page_objects.mobile." + sPageName);
			CommonHelperMethods.clickObject(driveR, oEle);
		} catch (StaleElementReferenceException se) {
			if (repeat < 3) {
				repeat++;
				i_click_on_Object_on_page(sObjName, sPageName);
			}
			else {
				throw se;
			}
		}
			catch (WebDriverException we) {
				if(repeat<3) {
					Thread.sleep(3000);
					repeat++;
					i_click_on_Object_on_page(sObjName, sPageName);
				}
				else {
					throw we;
				}

		}
		repeat = 0;
	}

	@Then("I click on dynamic {string} {string} on page {string}")
	public void iClickOnDynamicCountedProductsViewOnPageCountsPO(String sObjName,String sLocatorName, String sPageName) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, InterruptedException {
		{
			Thread.sleep(5000);
			int repeat = 0;
			try {
				oEle = InitClass.createObject(driveR, sObjName, sLocatorName, "com.morrisons.sma.page_objects.mobile." + sPageName);
				CommonHelperMethods.clickObject(driveR, oEle);
			} catch (NoSuchElementException ne) {
				if (repeat < 7) {

						repeat++;
					driveR.hideKeyboard();
					driveR.hideKeyboard();

					iClickOnDynamicCountedProductsViewOnPageCountsPO(sLocatorName,sObjName, sPageName);
				}
			} catch (NoSuchFieldException e) {
				throw new RuntimeException(e);
			}
		}
	}

	@Then("I click on sasasas dynamic {string} on page {string}")
	public void iClickOnSasasasDynamicCountedProductsViewOnPageCountsPODynamic(String sObjName, String sPageName) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, InterruptedException, NoSuchFieldException {
		oEle = InitClass.createObject(driveR,sObjName, "sLocatorName","com.morrisons.sma.page_objects.mobile." + sPageName);
		CommonHelperMethods.clickObject(driveR, oEle);
	}

	@Then("I click on dynamic {string} for {string} for product {string} on page {string}")
	public void iClickOnDynamicWarehouseLnkForProductOnPageCountsPO(String sObjName,String elementName, String sObjLocator,String sPageName) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, InterruptedException {
		int repeat = 0;
		try {
			oEle = InitClass.createObject(driveR, sObjName, "sLocatorName", "com.morrisons.sma.page_objects.mobile." + sPageName);
			oEle = CommonHelperMethods.createDynamicObj(driveR, oEle, sObjLocator, elementName);
			oEle.click();
		} catch (StaleElementReferenceException | NoSuchFieldException se) {
			if (repeat < 7) {
				repeat++;
				iClickOnDynamicWarehouseLnkForProductOnPageCountsPO(sObjName, elementName, sObjLocator, sPageName);
			}
		}
	}
	@Then("I click on Counts Option")
	public void i_click_on_Counts_Option() throws Throwable {
		implement.countOptClick();

	}

@Then("I click on Counts Sections")
public void i_click_on_Counts_Sections() throws Throwable {
	implement.countSectionClick();

}



@Then("I click on WareHouse Sections")
public void i_click_on_WareHouse_Sections() throws Throwable {
	implement.WarehouseClick();

}

@Then("I click on Fixtures Sections")
public void i_click_on_Fixtures_Sections() throws Throwable {
	implement.fixtureClick();

}

@Then("I click on Uncounted Sections")
public void i_click_on_Uncounted_Sections() throws Throwable {
	implement.uncountedClick();
}

@Then("I click on OffShelf Sections")
public void i_click_on_OffShelf_Sections() throws Throwable {
	implement.offShelfClick();
}

@Then("I click on Petrol Sections")
public void i_click_on_Petrol_Sections() throws Throwable {
	implement.petrolClick();

}

@Then("I click on ReviewCount")
public void i_click_on_ReviewCount() throws Throwable {
	implement.reviewClick();

}

@Then("I click on Counts Summary")
public void i_click_on_Counts_Summary() throws Throwable {
	implement.summaryClick();

}

@Then("I verify the fields in Counts Summary")
public void i_verify_the_fields_in_Counts_Summary() throws Throwable {
	implement.chexkBoxNames();

}

@Then("I verify the json response with mobile response")
public void i_verify_the_json_response_with_mobile_response() throws Throwable {
	System.out.println("productId = " + productId);
	System.out.println("prdtIdfromEndpoint = " + prdtIdfromEndpoint);
	assertEquals(productId, prdtIdfromEndpoint, "Product id from endpoint does not match");

}

@Then("I wait for Database update")
public void i_wait_for_Database_update() throws Throwable {
	Thread.sleep(30000);
}

@Then("verify Min details")
public void verify_Min_details() throws Throwable {
	try{
		boolean isProductPresent = false;
		isProductPresent = implement.warehouseId();
		//String productMin = implement.givenID;
		String productMin = productId;
		//			if(isProductPresent){
		//
		//				assertEquals(productId, prdtFromApp, "Product name from endpoint does not match");
		//				System.out.println("Id Matched");
		//			}

		if(!isProductPresent){
			Thread.sleep(3000);

			driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/action_barcode_entry']")).click();

			Thread.sleep(3000);

			driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/action_barcode_entry' or @resource-id='" + env + ":id/barcode_entry_edit_text']"))
			.sendKeys(productMin);


			Thread.sleep(5000);

			driveR.executeScript("mobile:performEditorAction", ImmutableMap.of("com/morrisons/common/action","search"));

		}
	}catch(NoSuchElementException e){
		System.out.println(e.getMessage());
	}
	catch(Exception e){
		System.out.println(e.getMessage());
	}


}

@Then("I select the product and click on confirm button")
public void selectProductAndConfirm() throws Throwable {
	implement.reviewDetails();

	System.out.println("Id Matched");

	Thread.sleep(1000);

}

@Then("I Confirm the Review")
public void i_Confirm_the_Review() throws Throwable {
	implement.reviewConfirm();
}

public static void reviewIdFrmApp(String id) throws InterruptedException {
	reviewIDFromApp = id;
}

public static String getPrdtFrmApp(String id) throws Throwable {
	prdtFromApp = id;

	return prdtFromApp;
}

@Then("I will enter qty {string}")
public void i_will_enter_qty(String qty) throws Throwable {
	try{
		implement.editCount(qty);
	}
	catch(Exception e){
		System.out.println(e.getMessage());
	}

}

@Then("I will enter qty {string} and click on Confirm button")
public void editCountAnConfirm(String qty) throws Throwable {
	try{
		implement.editCountAnConfirm(qty);
	}
	catch(Exception e){
		System.out.println(e.getMessage());
	}

}

@Then("Enter quantity as {string} and click on Confirm button")
public void addCountAndConfirm(String qty) throws Throwable {
	
		implement.editCountAnConfirm(qty);
	}

	//Created By Swati Sinha
@Then("I Enter the quantity as {string}, {string} and click on {string} button on {string} page")
	public void iEnterTheQuantityAsAndClickOnButtonOnPage(String qty, String StckQty, String sButtonName, String sPageName) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, InterruptedException, NoSuchFieldException {
	oEle = InitClass.createObject(driveR,StckQty,"sLocatorName","com.morrisons.sma.page_objects.mobile." + sPageName);
	Thread.sleep(1000);
	CommonHelperMethods.EnterData(driveR, oEle,qty);
	//Thread.sleep(7000);
	oEle = InitClass.createObject(driveR,sButtonName,"sLocatorName","com.morrisons.sma.page_objects.mobile." + sPageName);
	//oEle = CommonHelperMethods.createDynamicObj(driveR, oEle,sButtonName);
	Thread.sleep(1000);
	CommonHelperMethods.clickObject(driveR, oEle);
}

@Then("I verify that case message is displayed as expected")
public void i_verify_that_case_message_is_displayed_as_expected() throws Throwable {
	implement.checkMessage();
}

@Then("verify that qty has been updated")
public void verify_that_qty_has_been_updated() throws Throwable {
	try{
		implement.verifyCount();
	}catch(NoSuchElementException e){
		System.out.println(e.getMessage());
	}
	catch(Exception e){
		System.out.println(e.getMessage());
	}

}

@Then("I get the product quantity")
public void getQuantity() throws Throwable {
	try{
		implement.verifyCount();
	}catch(NoSuchElementException e){
		System.out.println(e.getMessage());
	}
	catch(Exception e){
		System.out.println(e.getMessage());
	}

}


@Then("I verify quantity {string} displayed on UI is as expected")
public void verifyUpdatedCount(String qty) throws Throwable {
	implement.verifyUpdatedCount(qty);
}

@Then("I will confirm Counts")
public void i_will_confirm_Counts() throws Throwable {
	implement.confirmCount();
}

@Then("I will confirm Complete count")
public void i_will_confirm_Complete_count() throws Throwable {
	implement.completeCount();
}

@Then("Verify status for {string} has changed to Complete")
public void verify_status_has_changed_to_Complete(String name) throws Throwable {
	implement.statusComplete(name);
	Thread.sleep(1000);
}

@Then("Verify count status for {string} has changed to Complete")
public void verifyCountStatus(String name) throws Throwable {
	implement.verifyCountStatus(name);
	Thread.sleep(1000);
}

	@Then("I Verify count status for {string} has changed to {string} on {string} page")
	public void iVerifyCountStatusForHasChangedToCompleteOnCountsPOPage(String sName,String sCompleteStatus, String sPageName) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, NoSuchFieldException {
		String sActualStatusCaptured;
		oEle = InitClass.createObject(driveR,sCompleteStatus,"sLocatorName","com.morrisons.sma.page_objects.mobile." + sPageName);
//		if(oEle.toString().contains("ToReplace")){
//			oEle = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tv_count_value']"));
//		}
		sActualStatusCaptured = CommonHelperMethods.getText(driveR, oEle);
		assertEquals("Counts to Complete : 1", sActualStatusCaptured, "Product status from endpoint does not match, expected" + sCompleteStatus + " actual " + sActualStatusCaptured);
		System.out.println("Name Found");
	}
@Then("I check review status updated")
public void i_check_review_status_updated() throws Throwable {
	implement.reviewStatusComplete();
}

@Then("I verify that Warehouse has updated its status")
public void i_verify_that_Warehouse_has_updated_its_status() throws Throwable {
	implement.wareHouseStatus();
}

@Then("I verify that Fixture has updated its status")
public void i_verify_that_Fixture_has_updated_its_status() throws Throwable {
	implement.fixtureStatus();
}

@Then("I will choose the plan from popup and enter qty")
public void i_will_choose_the_plan_from_popup_and_enter_qty() throws Throwable {
	implement.selectfromCountlist();
}

@Then("I select type from the Popup")
public void i_select_type_from_the_Popup() throws Throwable {
	implement.selectfromCountlistPM();
}

@Then("I Select the completed Count")
public void selectCompletedCount() throws Throwable {
	implement.selectCompletedCount();
}

@Then("I Click on Yes button on Reopen alert")
public void selectYesButton() throws Throwable {
	implement.selectYesButton();
}

@Then("I will Edit the quantity {string}")
public void will_verify_Edit_count_field(String qty) throws Throwable {
	implement.editCheck(qty);
}

@Then("I will Add the quantity {string}")
public void will_verify_Add_count_field(String qty) throws Throwable {
	implement.addCheck(qty);
}

@Then("I verify {string} quantity is updated")
public void verifyQtyIsUpdated(String action) throws Throwable {
	implement.verifyQtyIsUpdated(action);
}

	@And("I verify {string} dynamic {string} quantity for item {string} is on page {string}")
	public void iVerifyDynamicQuantityIsOnPageCountsPO(String action,String qty, String MinNo,String sPageName) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, InterruptedException {
		implement.verifyQtyIsUpdated7(action,MinNo,qty);
	}
	@And("I verify dynamic {string} dynamic {string} quantity for item {string} for category {string} is on page {string}")
	public void iVerifyDynamicDynamicQuantityForItemIsOnPageCountsPO(String action,String qty, String MinNo,String sCategory,String sPageName) {
		implement.verifyReviewQtyIsUpdated7(action,MinNo,qty,sCategory);
	}

@Then("I select the product {string}")
public void selectTheProduct(String product) throws Throwable {
	implement.selectTheProduct(product);
}

@Then("I verify ADD to Count and EDIT Count buttons are displayed")
public void verifyAddEditCount() throws Throwable {
	implement.verifyAddEditCount();
}

@Then("I select the required record")
public void i_select_the_required_record() throws Throwable {
	implement.selectOffshelfNme();
}

@Then("I select the Product")
public void i_select_the_Product() throws Throwable {
	implement.selectProduct();
}


@Then("I complete OffShelf")
public void i_complete_OffShelf() throws Throwable {
	implement.offshelfConfirm();
}

@Then("I complete Petrol")
public void completePetrol() throws Throwable {
	implement.offshelfConfirm();
}

@Then("Verify {string} alert is displayed for counts")
public void verifyConfirmCounts(String alert) throws Throwable {
	implement.verifyConfirmCounts(alert);
}

@Then("I click on Confirm button on Confirm counts alert")
public void clickOnConfirmButton() throws Throwable {
	implement.clickOnConfirmButton();
}

@Then("I verify if checkbox are checked")
public void i_verify_if_checkbox_are_checked() throws Throwable {
	implement.chexkBoxcheck();
}

@Then("I click on the product and I should get the Start time message")
public void i_click_on_the_product_and_I_should_get_the_Start_time_message() throws Throwable {
	implement.notStartTime();
}

@Then("I click on the product and I should get the End time message")
public void i_click_on_the_product_and_I_should_get_the_End_time_message() throws Throwable {
	implement.endStartTime();
}

@Then("I should receive message for check Uncounted")
public void i_should_receive_message_for_check_Uncounted() throws Throwable {
	implement.confirmUncount();
}

@Then("I enter qty in uncounted")
public void i_enter_qty_in_uncounted() throws Throwable {
	implement.enterUnCount();
}

@Then("I verify that Uncounted section is also marked complete")
public void i_verify_that_Uncounted_section_is_also_marked_complete() throws Throwable {
	implement.uncountComplete();
}


@Then("I click on the Item present")
public void i_click_on_the_Item_present() throws Throwable {
	implement.selectDesc();
}

@Then("I should get the message as expected")
public void i_should_get_the_message_as_expected() throws Throwable {
	implement.dispMsg();
}

@Then("I reopen the Complete name {string} and verify the message")
public void i_reopen_the_Complete_name_and_verify_the_message(String arg1) throws Throwable {
	implement.reOpenMsg();
}

@Then("I Complete the shelf count")
public void i_Complete_the_shelf_count() throws Throwable {
	implement.shelfCount();
}


@Then("I Select the product")
public void selectTheProduct() throws Throwable {
	implement.selectTheProduct();
}


@Then("I Click on Add To Count buttton")
public void clickOnAddToCount() throws Throwable {
	implement.clickOnAddToCount();
}


@Then("I Click on Edit count button")
public void clickOnEditCount() throws Throwable {
	implement.clickOnEditCount();
}

@And("I click on the product and enter quantity {string} and click on confirm button")
public void selectProductAndConfirmCount(String quantity) throws Throwable {
	implement.selectProductAndConfirmCount(quantity);
}

@Then("I select the product from Count")
public void selectProductFromCount() throws Throwable {
	implement.selectProductFromCount();
}

@Then("I select the Capture count location")
public void selectCaptureCount() throws Throwable {
	implement.selectCaptureCount();
}

@Then("I verify count quantity {string} is updated in Review section")
public void verifyQuantityIsUpdated(String quantity) throws Throwable {
	implement.verifyQuantityIsUpdated(quantity);
}

@Then("I verify {string} alert is displayed")
public void verifyReopenAlert(String alertName) throws Throwable {
	implement.verifyReopenAlert(alertName);
}

@Then("I verify Reopen counts alert message {string} is displayed")
public void verifyReopenAlertMessage(String message) throws Throwable {
	implement.verifyReopenAlertMessage(message);
}

@Then("I verify Reopen counts alert with Yes and No options are displayed")
public void verifyReopenAlertOptions() throws Throwable {
	implement.verifyReopenAlertOptions();
}

@Then("I Click on No option on Reopen counts alert")
public void clickOnNoOption() throws Throwable {
	implement.clickOnNoOption();
}

@Then("I click on product from product list")
public void selectProductFromList() throws Throwable {
	implement.selectProductFromList();
}

@Then("I click on Product category")
public void clickOnCategoryHeader() throws Throwable {
	implement.clickOnCategoryHeader();
}

@Then("I get product quantity displayed on UI")
public void getItemQuantity() throws Throwable {
	implement.getQuantity();
}

	@And("I get dynamic product quantity {string} displayed on UI page {string}")
	public void iGetDynamicProductQuantityEnterStockQtyDisplayedOnUIPageCountsPO(String sObjName,String sPageName) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, NoSuchFieldException {
		oEle1 = InitClass.createMultipleObjects(driveR,sObjName,"sLocatorName","com.morrisons.sma.page_objects.mobile." + sPageName);
//		String sLocator = oEle.toString();
//		String[] arrLocator = sLocator.split("->");
//		String sLocatorDetails = arrLocator[1];
//		String[] arrLocatorDetails = sLocatorDetails.split("[ ]");
//		String sLocatorVal = arrLocatorDetails[2];
//		sLocatorVal = sLocatorVal.substring(0,sLocatorVal.length()-1);
//		List<WebElement> oEle1 = driveR.findElements(By.xpath(sLocatorVal));
		implement.getQuantity(oEle1);
	}

@Then("I get product SOH quantity displayed on UI")
public void getSOHQuantity() throws Throwable {
	implement.getSOHQuantity();
}

@Then("Select product, enter quantity {string} and click on confirm button")
public void completeCountSection(String quantity) throws Throwable {
	implement.completeCountSection(quantity);
}

@Then("I verify Day spinner option is displayed")
public void verifyDaySpinnerDisplayed() throws Throwable {
	implement.verifyDaySpinnerDisplayed();
}

@Then("I click on Day spinner")
public void clickOnDaySpinner() throws Throwable {
	implement.clickOnDaySpinner();
}

@Then("I verify Day spinner with three optins are displayed - Today, Yesterday and date Day before yesterday")
public void verifyDaySpinnerOptions() throws Throwable {
	implement.verifyDaySpinnerOptions();
}
	@Then("Confirm button {string} is clicked on page {string}")
	public void confirmButtonConfirmIsClickedOnPageCountsPO() {
	driveR.findElement(By.xpath("//android.widget.Button[@resource-id='com.morrisons.instore.uat:id/confirmButton']")).click();
	driveR.findElement(By.xpath("//android.widget.Button[@resource-id='com.morrisons.instore.uat:id/confirmButton']")).sendKeys(Keys.ENTER);
	}

	@Given("The Post Storewalk body to create Count storewalk api for Store id {string},name {string} and Items {string} and mode {string}")
	public void thePostStorewalkBodyToCreateCountStorewalkApiForStoreIdNameAndAndMode(String storeId, String countName, String Items, String countMode) throws InterruptedException, JsonProcessingException {
		{

			setName = countName;
			System.out.println("Post count name : " + setName);
			setMode = countMode;
			implement.reqName(setName);
			//List<String> itemList = Arrays.asList(items.split("\\s*,\\s*"));////Splitting the String and storing in the list
			//int count = itemList.size();
			//=====================================
		/*System.out.println("Department list : " + deptList);

	List<CountPO_DepartmentList> departmentList = new ArrayList<CountPO_DepartmentList>();

	for(int i = 0;i<=count-1;i++){
		Integer deptNo = Integer.parseInt(itemList.get(i));
		CountPO_DepartmentList department = new CountPO_DepartmentList();
		department.setDepartment(deptNo);

		departmentList.add(department);

		departName = departmentList;
	}
	System.out.println("Department : " + departName);*/
			//==================================
			System.out.println("Department list : " + itemList);
			CountPO_PostList countPO_PostList = new CountPO_PostList();
			countPO_PostList.setDate(date);
			countPO_PostList.setStartTime(startTime);
			countPO_PostList.setEndTime(endTime);
			countPO_PostList.setScheduleRef(setScheduleRef);
			countPO_PostList.setType(setStorewalkType);
			countPO_PostList.setName(setName);
			countPO_PostList.setMode(setMode);

			countPO_PostList.setItems(Collections.singletonList(Items));

			if(setMode.equalsIgnoreCase("list")){
				departName = null;
			}


			countPO_PostList.setDepartmentList(departName);

			postCountBody = object.writeValueAsString(countPO_PostList);
			System.out.println("Payload body is " + postCountBody);

			Thread.sleep(1000);
		}
	}

}
