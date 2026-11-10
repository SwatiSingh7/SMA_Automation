package com.morrisons.sma.step_definitions.mobile.old;

import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;


import com.morrisons.sma.step_definitions.service.old.RestAssuredSteps;

import org.apache.http.HttpResponse;
import org.openqa.selenium.WebElement;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.morrisons.common.action.Hook;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import com.morrisons.sma.page_objects.mobile.old.CleanAndRotatePO;
import com.morrisons.sma.page_objects.mobile.old.MarkDownPO;
import com.morrisons.sma.pojo.service.CleanNRotateServicePOJO.CnR_Department;
import com.morrisons.sma.pojo.service.CleanNRotateServicePOJO.CnR_DepartmentVO;
import com.morrisons.sma.pojo.service.CleanNRotateServicePOJO.CnR_Schedules;
import com.morrisons.sma.pojo.service.CleanNRotateServicePOJO.CnR_SchedulesVo;
import com.morrisons.sma.pojo.service.MarkdownPOJO.MarkdownEventVo;
import com.morrisons.sma.pojo.service.MarkdownPOJO.MarkdownLoginVo;
import com.morrisons.sma.pojo.service.MarkdownPOJO.MarkdownMax;
import com.morrisons.sma.pojo.service.MarkdownPOJO.MarkdownVO;
import com.morrisons.sma.pojo.service.PricePrompPOJO.MainWalkId;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.Glh_WalkIdMain;
//import com.morrisons.sma.smaPageObject.SalesOrderServices;
//import com.morrisons.sma.smaPageObject.SmaSalesOrderPagePO;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import com.morrisons.common.utility.MarkdownServiceData;

import com.morrisons.sma.page_objects.service.CleanAndRotateServiceData;
import com.morrisons.sma.page_objects.service.CountServiceData;

public class CleanNRotateStepDefUI {
	ObjectMapper objectMapper = new ObjectMapper();
	public static HttpResponse Response;
	public static io.restassured.response.Response restResponse;
	public List<String> DatefromApp = new ArrayList<>();
	public static String weekDate;
	public static String weekStatus;
	MarkdownLoginVo mDLoginJsonResp = new MarkdownLoginVo();
	RestAssuredSteps loginTocken = new RestAssuredSteps();
	MarkdownVO markdownJsonResp = new MarkdownVO();
	public static CnR_SchedulesVo cnRScedulesJsonResp;
	public static CnR_DepartmentVO cnRDepartmentJsonResp;

	// MainClassPojo cnRJsonResp = new MainClassPojo();
	MarkdownVO markdownJsonResp1 = new MarkdownVO();
	MarkdownVO markdownJsonResp2 = new MarkdownVO();
	MarkdownVO markdownJsonResp3 = new MarkdownVO();
	MarkdownMax maxMarkdown = new MarkdownMax();
	MainWalkId walkidGet = new MainWalkId();
	Glh_WalkIdMain getwalkId = new Glh_WalkIdMain();
	static String newWalkID;
	public static String prdtId;
	public static int itemQuantity;

	CountServiceData counts = new CountServiceData();

	public static CnR_Schedules cnRSchedulesJsonResponse;
	CnR_Department cnRDepartmentJsonResponse = new CnR_Department();

	private static AndroidDriver driveR;

	CleanAndRotatePO cnRpageObjects = new CleanAndRotatePO();
	MarkDownPO markdown = new MarkDownPO();
	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();

	HashMap<String, String> weekScheuleResult = new HashMap<String, String>();
	HashMap<String, HashMap<String, String>> weekScheuleNumber = new HashMap<String, HashMap<String, String>>();

	Set keys = weekScheuleNumber.keySet();
	public static String deptCheckId;
	public static int selectWeekNumber = 0;

	//	SalesOrderServices salesOrderServices = new SalesOrderServices();
	//	SmaSalesOrderPagePO smaSalesOrderPagePO = new SmaSalesOrderPagePO();
	//	
	
	public CleanNRotateStepDefUI() {
		this.driveR = (AndroidDriver) Hook.getDriver();
	}

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

	public static int viewListCountUI = 0;
	public static int logItemCountUI = 0;
	public static String screenPageName = null;
	
	CleanAndRotateServiceData CleanAndRotateServiceData = new CleanAndRotateServiceData();
	
	public static String crispDept = applicationConfig.getCleanAndRotateTestData().getCrispDepartment();
	public static String crispItem[] = applicationConfig.getCleanAndRotateTestData().getCrispItems();
	public static String nonCrispDept = applicationConfig.getCleanAndRotateTestData().getnonCrispDepartment();
	public static String nonCrispItem[] = applicationConfig.getCleanAndRotateTestData().getNonCrispItems();


	@Given("Request is made to cleanandrotate Collegue Login services")
	public void requestWithServicesForColleguelogin() throws Throwable {
		CleanAndRotateServiceData.requestMadeToCNRCollegueLogin();
	}

	@Given("Request is made to cleanandrotate Manager Login services")
	public void requestWithServicesForManagerlogin() throws Throwable {
		CleanAndRotateServiceData.requestMadeToCNRManagerLogin();
	}

	//	@Given("Request is made to cleanandrotate Login services {string} and {string}")
	//	public void request_is_made_to_cleanandroatate_Login_service(String user, String password) throws Throwable {
	//		CleanAndRotateServiceData.requestMadeToCleanAndRotateLogin(user, password);
	//	}

	@Then("service should return details for Login Service")
	public void service_should_return_details_for_Login_Service() throws Throwable {

		int responseCode = Response.getStatusLine().getStatusCode();
		String errorMessage = Response.getStatusLine().getReasonPhrase();
		int responseCodeE = 201;

		System.out.println("PostMan Response Message is - " + errorMessage);
		assertEquals(responseCode, responseCodeE, " Product details requested doesn't exist. Response code");
		mDLoginJsonResp = objectMapper.readValue(Response.getEntity().getContent(), MarkdownLoginVo.class);
		String ProductJSONresult = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mDLoginJsonResp);
		System.out.println("Markdown Login Response:\n" + ProductJSONresult);
		Thread.sleep(500);
	}

	@Then("service should return details for Login Service clean and rotate")
	public void service_should_return_details_for_Login_Serviceclean_and_rotate() throws Throwable {
		CleanAndRotateServiceData.serviceShouldReturnCleanAndRotateLogin();
	}

	@Then("Get the generated accessTocken for CR")
	public void get_the_generated_accessTocken() throws Throwable {
		accessTocken = CleanAndRotateServiceData.getGeneratedAccessTokenForCR();
	}

	@Then("getSchedule service is called for location id {string} and {string}")
	public void getschedule_service_is_called_for_location_id(String storeID, String weekNumber) throws Throwable {

		System.out.println("AccessTocken-----------" + accessTocken);
		MarkdownServiceData.getScheduleCR(storeID, accessTocken, weekNumber, accessTocken);
	}

	@Given("getSchedule service is called for location id {string} and week {string}")
	public void getschedule_service_is_called_for_location_id_and_week(String storeID, String week) throws Throwable {

		System.out.println("AccessTocken-----------" + accessTocken);
		CleanAndRotateServiceData.getScheduleCRForCurrentWeek(storeID, week, accessTocken);
	}

	@Then("getDepartments service is called for location id {string} for year {string} and week {string}")
	public void getdepartments_service_is_called_for_location_id(String storeID, String yeaR, String weeK)
			throws Throwable {

		System.out.println("AccessTocken-----------" + accessTocken);
		MarkdownServiceData.getDepartments(storeID, yeaR, weeK, accessTocken);

	}



	@Then("user performs operation")
	public void user_performs_operation() throws Throwable {
		CleanAndRotateServiceData.performCnRGetOperation();
	}

	@Then("Service should return response of getSchedule servicee")
	public void service_should_return_response_of_getSchedule_servicee() throws Throwable {
		CleanAndRotateServiceData.getScheduleResponse();
	}

	@Then("Service should return response of getSchedule service")
	public void service_should_return_response_of_getSchedule_service() throws Throwable {
		CleanAndRotateServiceData.getScheduleServiceResponse();
	}

	@Then("Service should return response of getDepartments service")
	public void service_should_return_response_of_getDepartments_service() throws Throwable {
		CleanAndRotateServiceData.getDepartmentServiceResponse();
	}

	@Then("Service should return response of Departments completion service")
	public void service_should_return_response_of_Departments_completion_service() throws Throwable {
		CleanAndRotateServiceData.getDepartmentCompletionServicesStatus();
	}

	@Then("I click on clean and rotate from menu")
	public void i_click_on_clean_and_rotate_from_menu() throws Throwable {
		cnRpageObjects.clickcleanAndRotate();
	}

	@Then("Get Departments service is called for location id {string} for year {string} and week {string}")
	public void getdepartments_service_is_called_for_location_id_and_week(String storeID, String yeaR, String weeK)
			throws Throwable {

		System.out.println("AccessTocken-----------" + accessTocken);
		CleanAndRotateServiceData.getDepartments(storeID, yeaR, weeK, accessTocken);

	}

	@Then("Get Crisp department for location id {string} and week is {string}")
	public void getCrispDept(String storeID,String week)
			throws Throwable {

		System.out.println("AccessTocken-----------" + accessTocken);
		selectWeekNumber = CleanAndRotateServiceData.getCrispDepartments(storeID, week, accessTocken);
		System.out.println("selectWeekNumber-----------" + selectWeekNumber);
	}
	@Then("I Select Overdue week schedule in a list")
	public void selectOverdueWeekSchedule() throws Throwable {
		Thread.sleep(3000);
		List<AndroidElement> profile = driveR.findElements(
				MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_title']"));

		Thread.sleep(2000);

		for (AndroidElement a : profile) {

			String abc = a.getText();
			System.err.println("List is as follows  " + abc);

		}
		String firstElementInlist = profile.get(profile.size() - selectWeekNumber).getText();
		System.out.println("First Element in List:------------" + firstElementInlist);
		profile.get(profile.size() - selectWeekNumber).click();
	}

	@Then("I Select Current week schedule in a list")
	public void selectCurrentWeekSchedule() throws Throwable {
		Thread.sleep(3000);
		List<AndroidElement> profile = driveR.findElements(
				MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_title']"));

		Thread.sleep(2000);

		for (AndroidElement a : profile) {

			String abc = a.getText();
			System.err.println("List is as follows  " + abc);

		}
		String firstElementInlist = profile.get(profile.size() - selectWeekNumber).getText();
		System.out.println("First Element in List:------------" + firstElementInlist);
		profile.get(profile.size() - selectWeekNumber).click();
	}

	//	@And("I click on crisp dept from department list")
	//	public void iSelectCrispDept() throws Throwable {
	//		
	//		String deptName = CleanAndRotateServiceData.departmentName;
	//		Thread.sleep(3000);
	//		WebElement xpathDept = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+deptName+"']"));
	//
	//		System.out.println("Crisp department :------------" + deptName);
	//		xpathDept.click();
	//	}
	//	
	@Then("I click on product barcode entry Button")
	public void i_click_on_barcode_entry_Button() throws Throwable {
		String deptName = CleanAndRotateServiceData.departmentName;
		cnRpageObjects.reopenTheDepartment(deptName);
		markdown.clickPrinterEntery();
	}

	@And("I Enter Crisp department item min")
	public void enterCrispDeptMin() throws Throwable {
		String deptName = CleanAndRotateServiceData.departmentName;
		System.out.println("deptName--------" + deptName);
		String itemMin = CleanAndRotateServiceData.crispDepts.get(deptName);
		System.out.println("itemMin" + itemMin);

		markdown.enterProductMinValue(itemMin);
	}


	@Then("I take all the schedule date in list")
	public void i_take_all_the_schedule_date_in_list() throws Throwable {
		////cnRpageObjects.datesInList();

		Thread.sleep(5000);
		List<AndroidElement> profile = driveR.findElements(
				MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_title']"));

		for (AndroidElement a : profile) {
			System.out.println("Date from UI : " + a.getText());
			String abc = a.getText().replace("Week ", "").replace("th ", "-").replace("st ", "-").replace("nd ", "-")
					.replace("rd ", "-");
			System.out.println(abc);
			String abc1 = abc.replace("January ", "1-").replace("February ", "2-").replace("March ", "3-")
					.replace("April ", "4-").replace("May ", "5-").replace("June ", "6-").replace("July ", "7-")
					.replace("Augu-", "8-").replace("September ", "9-").replace("October ", "10-")
					.replace("November ", "11-").replace("December ", "12-");
			System.out.println(abc1);
			System.out.println("Date is " + abc1);
			DateFormat sourceFormat = new SimpleDateFormat("dd-MM-yyyy");
			DateFormat sourceFormat1 = new SimpleDateFormat("yyyy-MM-dd");

			Date date = sourceFormat.parse(abc1);
			DatefromApp.add(sourceFormat1.format(date));
		}

		System.out.println("Formatted date is: " + DatefromApp);

	}

	@Then("I click on Weekly Schedules")
	public void i_click_on_Weekly_Schedules() throws Throwable {
		cnRpageObjects.clickWeeklySchedules();
	}

	@Then("I take all the schedule in a list")
	public void i_take_all_the_schedule_in_a_list() throws Throwable {
		Thread.sleep(3000);
		List<AndroidElement> profile = driveR.findElements(
				MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_title']"));

		for (AndroidElement a : profile) {

			String abc = a.getText();
			System.err.println("List is as follows  " + abc);

		}
		String firstElementInlist = profile.get(profile.size() - 4).getText();
		System.out.println("First Element in List:------------" + firstElementInlist);
		profile.get(profile.size() - 4).click();
	}

	@Then("I scroll down to get the latest schdule")
	public void i_scroll_down_to_get_the_latest_schdule() throws Throwable {
		Thread.sleep(2000);
		TouchAction ts = new TouchAction(driveR);
		ts.press(PointOption.point(350, 1515)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(300, 390)).release().perform();

	}
	
	@Then("I scroll down on the page")
	public void scrollThePagee() throws Throwable {
		Thread.sleep(2000);
		TouchAction ts = new TouchAction(driveR);
		ts.press(PointOption.point(350, 1515)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(300, 390)).release().perform();

	}


	@Then("I click on date picker and select expiry date")
	public void i_click_on_date_picker_and_select_expiry_date() throws Throwable {
		cnRpageObjects.clickDatePicker();
	}

	@And("I Enter Scan item {string} quantity")
	public void i_enter_item_quantity(String quantity) throws Throwable {
		cnRpageObjects.enterItemQuantity(quantity);
	}

	@Then("I click on Done Button")
	public void i_click_on_Done_Button() throws Throwable {
		cnRpageObjects.clickDoneDatePicker();
	}

	@Then("I click on Log Product Button")
	public void i_click_on_Log_Product_Button() throws Throwable {
		cnRpageObjects.buttonLogProduct();
	}

	@Then("I Verify Clearance Markdown error message is displayed")
	public void i_Verify_Clearance_Markdown_error_message_is_displayed() throws Throwable {
		cnRpageObjects.clearanceMarkdownMessage();
	}

	@Given("I send the date {string} and month {string} and year {string} where date {string} and month {string} and year {string}")
	public void i_send_the_date_and_month_and_year_where_date_and_month_and_year(String date, String month, String year,
			String datee, String monthh, String yearr) throws Throwable {
		cnRpageObjects.changeDate(date, month, year, datee, monthh, yearr);
	}


	@Given("I click on spinner to select one of the action {string}")
	public void i_click_on_spinner_to_select_one_of_the_action(String arg1) throws Throwable {
		cnRpageObjects.clickSpinner();
		cnRpageObjects.selectOneOption(arg1);
	}

	@Then("I click on Add to Print Queuee")
	public void i_click_on_Add_to_Print_Queuee() throws Throwable {
		markdown.clickonPrintQueueEmployee();
	}

	@Then("I click on back button")
	public void i_click_on_back_button() throws Throwable {
		markdown.clickOnBackButton();
	}



	@Then("I verify View list of expiring products is Displayed")
	public void i_verify_View_list_of_expiring_products_is_Displayed() throws Throwable {
		markdown.verifyViewListOfExpiringProducts();
	}

	@Then("I click on View list of expiring products")
	public void i_click_on_View_list_of_expiring_products() throws Throwable {
		markdown.clickOnViewList();
	}

	@Then("Verify Select Reason Code template")
	public void verify_Select_Reason_Code_template() throws Throwable {
		cnRpageObjects.verifyReasonCode(); 
	}

	@Then("I click on alert to select one of the option {string}")
	public void i_click_on_alert_to_select_one_of_the_option(String arg1) throws Throwable {
		cnRpageObjects.selectReasonCode(arg1);
	}

	@And("I click on Confirm button")
	public void i_click_on_Confirm_button() throws Throwable {
		cnRpageObjects.clickOnConfirmButton();
	}

	@Then("I Select the Overdue week schedule in a list")
	public void select_the_previos_schedule_in_a_list() throws Throwable {
		Thread.sleep(3000);
		List<AndroidElement> profile = driveR.findElements(
				MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_title']"));

		for (AndroidElement a : profile) {

			String abc = a.getText();
			System.err.println("List is as follows  " + abc);

		}
		String firstElementInlist = profile.get(profile.size() - 5).getText();
		System.out.println("First Element in List:------------" + firstElementInlist);
		profile.get(profile.size() - 5).click();
	}

	@Then("I Select the Current week schedule in a list")
	public void select_the_schedule_in_a_list() throws Throwable {
		Thread.sleep(3000);
		List<AndroidElement> profile = driveR.findElements(
				MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_title']"));

		Thread.sleep(2000);

		for (AndroidElement a : profile) {

			String abc = a.getText();
			System.err.println("List is as follows  " + abc);

		}
		String firstElementInlist = profile.get(profile.size() - 4).getText();
		System.out.println("First Element in List:------------" + firstElementInlist);
		profile.get(profile.size() - 4).click();
	}

	@Then("I Select the next Week schedule in a list")
	public void select_the_next_week_schedule_in_a_list() throws Throwable {
		Thread.sleep(3000);
		List<AndroidElement> profile = driveR.findElements(
				MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_title']"));

		Thread.sleep(2000);

		for (AndroidElement a : profile) {

			String abc = a.getText();
			System.err.println("List is as follows  " + abc);

		}
		String firstElementInlist = profile.get(profile.size() - 3).getText();
		System.out.println("First Element in List:------------" + firstElementInlist);
		profile.get(profile.size() - 3).click();
	}

	@Then("I Select the schedule in a list {string}")
	public void select_the_schedule_in_a_list(int arg1) throws Throwable {
		Thread.sleep(3000);
		List<AndroidElement> profile = driveR.findElements(
				MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_title']"));

		for (AndroidElement a : profile) {

			String abc = a.getText();
			System.err.println("List is as follows  " + abc);

		}
		String firstElementInlist = profile.get(profile.size() - arg1).getText();
		System.out.println("First Element in List:------------" + firstElementInlist);
		profile.get(profile.size() - arg1).click();
	}

	@Then("Select the schedule")
	public void select_the_schedule() throws Throwable {
		Thread.sleep(3000);
		List<AndroidElement> profile = driveR.findElements(
				MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_title']"));

		for (AndroidElement a : profile) {

			String abc = a.getText();
			System.err.println("List is as follows  " + abc);

		}
		String firstElementInlist = profile.get(profile.size() - 3).getText();
		System.out.println("First Element in List:------------" + firstElementInlist);
		profile.get(profile.size() - 3).click();
	}

	@Then("I Select the Overdue week schedule")
	public void select_the_Overdue_week_schedule() throws Throwable {
		Thread.sleep(3000);
		List<AndroidElement> profile = driveR.findElements(
				MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_title']"));

		for (AndroidElement a : profile) {

			String abc = a.getText();
			System.err.println("List is as follows  " + abc);

		}
		String firstElementInlist = profile.get(profile.size() - 5).getText();
		System.out.println("First Element in List:------------" + firstElementInlist);
		profile.get(profile.size() - 5).click();
	}

	@Then("I click on Complete Code Rotate Group button")
	public void i_click_on_complete_Code_Rotate_Group_button() throws Throwable {
		cnRpageObjects.clickOnCompleteCodeRotate();
	}

	@Then("I Verify Complete Code Rotate Group button is Displayed")
	public void verify_complete_Code_Rotate_Group_button() throws Throwable {
		cnRpageObjects.verifyCompleteCodeRotateDisplayed();

	}

	@Then("I Verify the {string} department banner as {string}")
	// arg1 - weekly schedule/ Department, arg2 - 'status', arg3 - index ,
	// verifyStatus = true(Not started), false(In progress, completed)
	public void verify_the_department_banner(String arg3, String arg2) throws Throwable {
		cnRpageObjects.verifyDepartmentStatus(arg3, arg2);
	}
	
	@Then("I Verify the department banner as {string}")
	public void verifyDeptBanner(String arg1) throws Throwable {
		cnRpageObjects.verifyDepartmentBanner(arg1);
	}

	@Then("I Get department name for {string} department")
	public void i_Get_department_name(String arg) throws Throwable {
		cnRpageObjects.getDepartmentName(arg);
	}
	
	@Then("I Get the Crisp Department name")
	public void iGetCrispDepartmentName() throws Throwable {
		cnRpageObjects.iGetCrispDepartmentName();
	}
	
	@Then("I Get the Non-Crisp Department name")
	public void iGetNonCrispDepartmentName() throws Throwable {
		cnRpageObjects.iGetNonCrispDepartmentName();
	}

	@Then("I verify the status {string} of the Weekly Schedule {string}")
	public void i_verify_the_status_of_the_Weekly_Schedule(String arg2, int arg3) throws Throwable {
		cnRpageObjects.verifyWeekelyScheduleStatus(arg2, arg3);
	}

	@And("I click on the department {string} in the weekly schedule")
	public void i_click_on_the_department_in_the_weekly_schedule(int arg1) throws Throwable {
		Thread.sleep(3000);
		List<AndroidElement> profile = driveR.findElements(
				MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_title']"));

		String secondDepartment = profile.get(arg1).getText();
		System.out.println("Second Element in List:------------" + secondDepartment);
		profile.get(arg1).click();
	}

	@And("I click on the first department in the weekly schedule")
	public void i_click_on_the_first_department() throws Throwable {
		Thread.sleep(3000);
		List<AndroidElement> profile = driveR.findElements(
				MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_title']"));

		String firstDepartment = profile.get(0).getText();
		System.out.println("First Element in List:------------" + firstDepartment);
		profile.get(0).click();
	}

	@And("I click on the second department in the weekly schedule")
	public void i_click_on_the_second_department() throws Throwable {
		Thread.sleep(3000);
		List<AndroidElement> profile = driveR.findElements(
				MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_title']"));

		String secondDepartment = profile.get(1).getText();
		System.out.println("Second Element in List:------------" + secondDepartment);
		profile.get(1).click();
	}

	@And("I click on the Crisp department in the weekly schedule")
	public void clickOnCrispDept() throws Throwable {
		Thread.sleep(3000);
		List<String> deptsName = new ArrayList<String>();

		List<AndroidElement> allDepts = driveR.findElements(
				MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_title']"));

		for(AndroidElement dept:allDepts){
			String name = dept.getText();
			System.out.println("Dept name : " + name);

			if(name.equalsIgnoreCase(crispDept)){
				dept.click();
				break;
			}
		}
		Thread.sleep(3000);
	}

	@And("I click on the Non-Crisp department in the weekly schedule")
	public void clickOnNonCrispDept() throws Throwable {
		Thread.sleep(3000);
		
		List<AndroidElement> allDepts = driveR.findElements(
				MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_title']"));

		for(AndroidElement dept:allDepts){
			String name = dept.getText();
			System.out.println("Dept name : " + name);

			if(name.equalsIgnoreCase(nonCrispDept)){
				dept.click();
				break;
			}
		}
		Thread.sleep(3000);
	}

	@And("Verify Reopen code rotate group button is displayed")
	public void verify_Reopen_code_rotate_group_button_is_displayed() throws Throwable {
		cnRpageObjects.verifyReopenCodeRotateGroup();

	}

	@Then("Click on Reopen code rotate group button")
	public void click_on_Reopen_code_rotate_group_button() throws Throwable {
		cnRpageObjects.clickOnReopenCodeRotateGroup();

	}

	@Then("Verify {string} Alert")
	public void verify_Reopen_Department_Alert(String arg1) throws Throwable {
		cnRpageObjects.verifyReopenDepartmentAlert(arg1);

	}

	@Then("Click on No button on Reopen code rotate group button")
	public void click_on_No_Button_on_Reopen_code_rotate_group_button() throws Throwable {
		cnRpageObjects.clickOnNoReopenDepartment();
	}

	@Then("Click on Yes button on Reopen code rotate group button")
	public void click_on_Yes_Button_on_Reopen_code_rotate_group_button() throws Throwable {
		cnRpageObjects.clickOnYesReopenDepartment();
	}

	@Then("Get Product count on View list of expiring products")
	public void get_Product_count_on_View_list_of_expiring_products() throws Throwable {
		viewListCountUI = cnRpageObjects.getProductCountOnViewList();
	}

	@Then("Verify Product count on View list of expiring products is Increased")
	public void verify_Product_count_on_View_list_of_expiring_products_Increased() throws Throwable {
		cnRpageObjects.verifyIncreaseCountOnViewList();
	}

	@Then("Verify Product count on View list of expiring products is Decreased")
	public void verify_Product_count_on_View_list_of_expiring_products_Decreased() throws Throwable {
		cnRpageObjects.verifyDecreaseCountOnViewList();
	}

	@Then("Get Product count on product details")
	public void get_Product_count_on_product_details() throws Throwable {
		logItemCountUI = cnRpageObjects.getProductCountOnProductDetail();
		System.out.println("logItemCountUI : " + logItemCountUI);
	}

	@Then("Verify Product count on product details is Increased")
	public void verify_Product_count_on_product_details_Increased() throws Throwable {
		cnRpageObjects.verifyIncreaseCountOnProductDetails();
	}

	@Then("Verify Product count on product details is Decreased")
	public void verify_Product_count_on_product_details_Decreased() throws Throwable {
		cnRpageObjects.verifyDecreaseCountOnProductDetails();
	}

	@And("I Right swipe")
	public void i_right_swipe() throws Throwable {
		cnRpageObjects.rightSwipe();
	}

	@Then("Verify product is not able to delete")
	public void verify_product_is_not_able_to_delete() throws Throwable {
		cnRpageObjects.productIsNotAbleToDelete();
	}

	@Then("I Complete code rotate for all the departments")
	public void complete_code_rotate_for_all_the_departments() throws Throwable {
		cnRpageObjects.completeCodeRotateDepartment();
	}

	@Then("I Verify Sign off Code Rotate button is displayed")
	public void sign_Off_Code_Rotate_button_is_displayed() throws Throwable {
		cnRpageObjects.verifySignOffCodeRotateButton();
	}

	@Then("I Click on Main Menu")
	public void click_on_Main_Menu() throws Throwable {
		cnRpageObjects.clickOnMainMenu();
	}

	@Then("I Verify Main menu box title")
	public void verify_Main_Menu_box() throws Throwable {
		cnRpageObjects.verifyMainMenuBox();
	}

	@Then("I verify Select a product group text is displayed")
	public void verify_Select_A_Product_Group() throws Throwable {
		cnRpageObjects.verifySelectAProductGroup();
	}

	@Then("I select next {int} th date")
	public void i_select_date(int days) throws Throwable {
		cnRpageObjects.selectDate(days);
	}

	@And("I click on Calendar")
	public void i_click_on_Calendar() throws Throwable {
		cnRpageObjects.clickDatePicker();
	}

	@And("I Verify 1st markdown popup message as {string}")
	public void verifyFirstMarkdownPopup(String args1) throws Throwable {
		cnRpageObjects.verifyClearanePopupMessage(args1);
	}
	
	@And("I verify 1st Markdown alert pop-up is not displayed")
	public void firstMarkdownPopupNotDisplayed() throws Throwable {
		cnRpageObjects.firstMarkdownPopupNotDisplayed();
	}

	@And("I Verify Clearance popup message as {string}")
	public void i_Verify_Clearance_popup_message(String args1) throws Throwable {
		cnRpageObjects.verifyClearanePopupMessage(args1);
	}

	@And("I Verify Clearance popup message is not displayed")
	public void clearancePopupNotDisplayed() throws Throwable {
		cnRpageObjects.firstMarkdownPopupNotDisplayed();
	}

	@Then("I Click on Ok button on Clearance Alert")
	public void i_Click_On_Ok_Button() throws Throwable {
		cnRpageObjects.iClickOnOkButton();
	}

	@Then("I Click on Ok button on 1st Alert")
	public void clickOnFirstAlertOnButton() throws Throwable {
		cnRpageObjects.iClickOnOkButton();
	}

	@Then("I verify Sign off code rotate button is Enabled")
	public void verify_Sign_Off_Code_Rotate_Is_Enabled() throws Throwable {
		cnRpageObjects.verifySignOffCodeRotateIsEnabled();
	}

	@Then("I verify Sign off code rotate button is Disabled")
	public void verify_Sign_Off_Code_Rotate_Is_Disabled() throws Throwable {
		cnRpageObjects.verifySignOffCodeRotateIsDisabled();
	}

	@Then("I Click on Sign-Off Code Rotate button")
	public void i_Click_on_Sign_Off_Code_Rotate_button() throws Throwable {
		cnRpageObjects.clickOnSignOffCodeRotateButton();
	}

	@And("I Verify Confirm Sign-Off Alert")
	public void i_Verify_Confirm_Sign_off_Alert() throws Throwable {
		cnRpageObjects.verifyConfirmSignOffAlert();
	}

	@Then("I Click on Cancel button on Sign-Off Code Rotate button")
	public void i_Click_On_Cancel_Button_On_Sign_Off_Code_Roate_Button() throws Throwable {
		cnRpageObjects.clickOnCancelSignOffButton();
	}

	@Then("I Verify Sign-Off Code Rotate button is displayed")
	public void i_Verify_Sign_Off_Code_Roate_Button_is_displayed() throws Throwable {
		cnRpageObjects.verifySignOffRotateButtonIsDisplayed();
	}

	@Then("I Click on Confirm button on Sign-Off Code Rotate button")
	public void i_Click_On_Confirm_Button_On_Sign_Off_Code_Roate_Button() throws Throwable {
		cnRpageObjects.clickOnConfirmSignOffButton();
	}

	@Then("I Verify Sign-Off Code Rotate button is not Clickable")
	public void i_Verify_Sign_Off_Code_Rotate_Button_Is_Not_Clickable() throws Throwable {
		cnRpageObjects.verifySignOffCodeRotateIsNotClickable();
	}

	@And("Verify Week is not displayed")
	public void verify_Week_is_not_displayed() throws Throwable {
		cnRpageObjects.verifyWeekIsNotDisplayed();
	}

	@And("Get Week Schedule text")
	public void get_Week_Schedule_Text() throws Throwable {
		cnRpageObjects.getWeekScheduleText();
	}

	@And("I Swipe left")
	public void i_Swipe_Left() throws Throwable {
		cnRpageObjects.swipeLeft();
	}

	@And("I verify Delete icon is Enabled")
	public void i_Verify_Delete_Icon_Is_Enabled() throws Throwable {
		cnRpageObjects.verifyDeleteIconIsEnabled();
	}

	@And("I verify Delete icon is Disabled")
	public void i_Verify_Delete_Icon_Is_Disabled() throws Throwable {
		cnRpageObjects.verifyDeleteIconIsDisabled();
	}

	@And("I Delete the product")
	public void i_Delete_The_Product() throws Throwable {
		cnRpageObjects.deleteTheProduct();
	}

	@Then("I get Scan date code for the Item")
	public void i_get_Scan_date_code() throws Throwable {
		cnRpageObjects.getScanDateCode();
	}

	@Then("I get Maximum date entry in the caledar")
	public void i_get_Maximum_date_entry_in_the_calendar() throws Throwable {
		cnRpageObjects.getMaximumDateEntryInTheCalendar();
	}

	@Then("I compare Scan date code is equal to Maximum date entry in the calendar")
	public void i_compare_scan_date_code_is_equal_to_maximum_date_entry_in_calendar() throws Throwable {
		cnRpageObjects.compareScanDateWithMaxDateInCalendar();
	}

	@Then("I Verify Weekly Schedules submenus is displayed")
	public void verify_Weekly_Schedules_Submenus_Status_is_Displayed() throws Throwable {
		cnRpageObjects.verifyWeeklySchedulesSubmenu();
	}

	@Then("I Get Weekly Schedules submenus status")
	public void get_Weekly_Schedules_Submenus_Status() throws Throwable {
		cnRpageObjects.getWeeklyScheduleSubmenuStatus();
	}

	@Then("I Verify Weekly Schedules list is displayed")
	public void verify_Weekly_Schedules_list_is_displayed() throws Throwable {
		cnRpageObjects.verifyWeeklySchedulesList();
	}

	@Then("I Get First week schedule status")
	public void i_Get_First_Week_Schedule_Status() throws Throwable {
		cnRpageObjects.getFirstWeekScheduleStatus();
	}

	@And("I Verify Weekly schedule submenu status is same as First week status inside week schedule")
	public void verify_status_is_same() throws Throwable {
		cnRpageObjects.verifyStatusIsSame();
	}

	@Then("I Verify the Department completion status")
	public void verify_Department_Completion_Status() throws Throwable {
		cnRpageObjects.verifyDepartmentCompletionStatus();
	}

	@Then("I Get the Department completion status for the department {string} from UI")
	public void i_get_department_completion_status(String departmentNumber) throws Throwable {
		cnRpageObjects.getDepartmentCompletionStatusUI(departmentNumber);
	}
	
	@Then("I Get the Department completion status for the department from UI")
	public void getDeptStatus() throws Throwable {
		cnRpageObjects.getDeptStatus();
	}

	@Then("I Get the Scanned item quantity for First item")
	public void i_Get_Scanned_Item_Quantity_For_First_Item() throws Throwable {
		cnRpageObjects.getQuantityForFirstItem();
	}

	// @Then("I Get the Scanned item quantity for Second item")
	// public void i_Get_Scanned_Item_Quantity_For_Second_Item(boolean arg1)
	// throws Throwable {
	// cnRpageObjects.getQuantityForSecondItem(arg1);bb
	// }

	@Then("I Verify Scanned item quantity is merged on Scanned item list screen")
	public void i_Verify_Scanned_item_quantity_is_merged() throws Throwable {
		cnRpageObjects.verifyMergeQuantity();
	}

	@Then("I Verify Scanned item quantity is unmerged on Scanned item list screen")
	public void i_Verify_Scanned_item_quantity_is_unmerged() throws Throwable {
		cnRpageObjects.verifyUnMergeQuantity();
	}

	@Given("Enter the item quantity {int}")
	public void i_enter_the_quantity(int quantity) throws Throwable {

		itemQuantity = quantity;
		cnRpageObjects.getDetails(quantity);
	}

	@Then("I Verify Currently unavailable alert")
	public void i_verify_currently_unavailable_alert() throws Throwable {
		cnRpageObjects.verifyCurrentlyUnavailbleAlert();
	}

	@Then("I Click on OK button on Currently unavailable alert")
	public void i_click_on_ok_button_on_alert() throws Throwable {
		cnRpageObjects.clickOnOkButtonOnAlert();
	}

	@Then("I Navigate to Main menu")
	public void i_navigate_to_main_menu() throws Throwable {

		WebElement xpathMainMenuIcon = driveR
				.findElement(MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/context_menu']"));

		xpathMainMenuIcon.click();

		WebElement xpathMainMenu = driveR.findElement(MobileBy.xpath("//android.widget.LinearLayout[@index='0']"));

		xpathMainMenu.click();
	}

	@And("Verify that the Weekly schedule name and status displayed on App and Services matches")
	public void verify_the_week_name_and_status() throws Throwable {
		CleanAndRotateServiceData.verifyUIWeekNameAndStatusWithServices();
	}

	@And("Verify that the Department {string} Name and Status displayed on App and Services matches")
	public void verify_the_Department_Name_and_Status(String arg1) throws Throwable {
		CleanAndRotateServiceData.verifyUIDepartmentNameStatusWithServices(arg1);
	}
	
	@And("Verify that the Department Name and Status displayed on App and Services matches")
	public void verifyStatusAndName() throws Throwable {
		CleanAndRotateServiceData.verifyStatusAndName();
	}

	@And("Verify that the Department Next check is displayed on App and Services matches")
	public void verify_the_Department_Next_check() throws Throwable {
		CleanAndRotateServiceData.verifyUIDepartmentNextCheckWithServices();
	}

	@Then("Verify that the Department Completion status is displayed on App and Services matches")
	public void verify_department_completion_status() throws Throwable {
		CleanAndRotateServiceData.verifyDepartmentCompletionServicesStatus();
	}

	@Then("I Get the Department check id")
	public void get_the_department_check_id() throws Throwable {

		deptCheckId = CleanAndRotateServiceData.getDepartmentCheckId();

	}

	@Given("Request is made to get the list of Markdown items for store {string} and department {string}")
	public void request_is_made_to_get_the_list_of_Markdown_items_for_store_and_department(String storeID,String deptId)
			throws Throwable {
		CleanAndRotateServiceData.getMarkdownItemList(storeID,accessTocken,deptId);
	}

	@Given("Request is made to get the list of items for store {string} and department")
	public void request_is_made_to_get_the_list_of_items_for_store_and_department(String storeID)
			throws Throwable {

		System.out.println("Department id : " + deptCheckId);
		CleanAndRotateServiceData.getItemList(storeID,accessTocken,deptCheckId);
	}

	@Then("Service should return response for the items")
	public void service_should_return_response_for_the_items() throws Throwable {
		CleanAndRotateServiceData.getMarkdownItemListResponse();
	}

	@Then("Service should return response for the items count")
	public void service_should_return_response_for_the_items_count() throws Throwable {
		CleanAndRotateServiceData.getItemListCount();
	}

	@Then("I get Item details on UI")
	public void i_get_item_details_on_UI() throws Throwable {
		cnRpageObjects.getItemDetailsUI();
	}

	@Then("I verify Item details displayed on App and Services matches")
	public void i_verify_Item_details_displayed_on_App_and_Services_matches() throws Throwable {
		CleanAndRotateServiceData.verifyItemDetailServices();
	}

	@Then("I Verify Item count is displayed on App and Services matches")
	public void i_Verify_Item_count_is_displayed_on_app_and_Services_matches() throws Throwable {
		CleanAndRotateServiceData.verifyItemCountUIWithServices(logItemCountUI);
	}


	@Then("I Get action performed Name as {string}")
	public void i_Get_action_performed_Name_as_actionName(String actionName) throws Throwable {

		System.out.println("Action Name -----------" + actionName);
		CleanAndRotateServiceData.getActionPerformedName(actionName);
	}

	@Then("I Verify Product Not Found popup")
	public void i_Verify_Product_Not_Found_popup() throws Throwable {
		cnRpageObjects.verifyProductNotFountPopup();
	}

	@Then("I Verify Please contact tech support popup")
	public void i_Verify_Please_contact_tech_support_popup() throws Throwable {
		cnRpageObjects.verifyContactTechSupportPopup();
	}

	@And("I Verify Product details on Item summary page")
	public void i_Verify_Product_Details_on_Item_summary_page() throws Throwable {
		screenPageName = cnRpageObjects.VerifyItemDetailsInSummary();
	}

	@And("I Verify Product details on Edit Item summary page")
	public void i_Verify_Product_Details_on_Edit_Item_summary_page() throws Throwable {
		screenPageName = cnRpageObjects.VerifyItemDetailsInSummary();
	}

	@And("I Verify Product details on Print List page")
	public void i_Verify_Product_Details_on_Print_List_page() throws Throwable {
		cnRpageObjects.VerifyItemDetailsOnPrintList();
	}

	@And("I Verify Scan item quantity is Merged")
	public void i_Verify_Scan_item_quantity_is_Merged() throws Throwable {
		cnRpageObjects.VerifyItemQuantityIsMerged();
	}

	@And("I Verify Scan item quantity is Unmerged")
	public void i_Verify_Scan_item_quantity_is_Unmerged() throws Throwable {
		cnRpageObjects.VerifyItemQuantityIsUnMerged();
	}

	@Then("I Select Markdown discount percentage")
	public void iSelectDiscountPercentage() throws Throwable {
		cnRpageObjects.SelectDiscountPercentage();
	}

	@Then("I Verify the Markdown Scanned item is visible")
	public void verifyTheMarkdownScannedItem() throws Throwable {
		Thread.sleep(4000);
		String arg1 = MarkDownnStepDef.enterBarcode1;
		cnRpageObjects.getItemCountOnPrintList(screenPageName);
		cnRpageObjects.clickOnBackButton(screenPageName);
		markdown.verifyTheMINNumber(arg1);
	}

	@Then("I Verify Large Markdown Quantity popup")
	public void verifyLargeMarkdonQuantityPopup() throws Throwable {
		cnRpageObjects.verifyLargeMarkdwonQuantity();
	}

	@Then("I Click on Cancel button on Large Markdown Quantity popup")
	public void clickOnCancelButtonOnPopup() throws Throwable {
		cnRpageObjects.clickOnAlertCancelButton();
	}

	@Then("I Click on Confirm button on Large Markdown Quantity popup")
	public void clickOnConfirmButtonOnPopup() throws Throwable {
		cnRpageObjects.clickOnAlertConfirmButton();
	}

	@Then("I Verify No Printer Available screen is display")
	public void iVerifyNoPrintAvailableScreenDisplay() throws Throwable {

		WebElement xpathNoPrintAvailable = driveR.findElement(
				MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/text_no_printer_available']"));

		xpathNoPrintAvailable.isDisplayed();
	}

	@Then("I Verify Item Summary screen is display")
	public void iVerifyItemSummaryScreenDisplay() throws Throwable {	
		cnRpageObjects.VerifyItemDetailsInSummary();
	}

	@Then("I Enter Printer {string} number")
	public void iEnterPrinterBarcode(String arg1) throws Throwable {
		cnRpageObjects.enterPrinterBarcode(arg1);
	}

	@Then("I Click on Print button")
	public void iClickOnPrintButton() throws Throwable {
		cnRpageObjects.clickOnPrintButton();
	}

	@Then("I Verify Next check date displayed on UI is match with Services")
	public void verifyNextCheckDate() throws Throwable {
		CleanAndRotateServiceData.verifyUINextCheckDateWithServices();
	}
	@Then("I Verify Ambient and Frozen code alerts submenu is displayed")
	public void verifyAmbientAndFrozenSubmenuIsDisplayed() throws Throwable {
		cnRpageObjects.verifyAmbientAndFrozenSubmenu();
	}
	@Then("I Click on Ambient and Frozen code alerts submenu")
	public void clickOnAmbientAndFrozenSubmenu() throws Throwable {
		cnRpageObjects.clickAmbientAndFrozenSubmenu();
	}
	@Then("I select product")
	public void iSelectProduct() throws Throwable {
		cnRpageObjects.iSelectTheProduct();
	}
	@Then("I Enter quantity")
	public void iEnterQuantity() throws Throwable {
		cnRpageObjects.iEnterTheQuantity();
	}
	@Then("I Click on Add next action button")
	public void clickOnAddNextActionButton() throws Throwable {
		cnRpageObjects.clickOnAddNextActionbutton();
	}

	@Then("I Verify reason code on Wastage popup")
	public void verifyWastageReasonCode() throws Throwable {
		cnRpageObjects.verifyWastageReasonCode();
	}

	@Then("I Verify Wastage message on wastage popup")
	public void verifyWastageMessage() throws Throwable {
		cnRpageObjects.verifyWastagePopupMessage();
	}

	@Then("I Verify Confirm and Cancel buttons on wastage popup")
	public void verifyConfirmAndCancelButtons() throws Throwable {
		cnRpageObjects.verifyConfirmAndCancelButtons();
	}

	@Then("I Click on Alert dropdown")
	public void clickOnAlertDropdown() throws Throwable {
		cnRpageObjects.clickOnAlertDropdown();
	}

	@Then("I Select All alerts dropdown value")
	public void clickOnAllAlertDropdown() throws Throwable {
		cnRpageObjects.clickOnAllAlertDropdown();
	}

	@Then("I Select 1st Alert dropdown value")
	public void clickOnFirstAlertDropdown() throws Throwable {
		cnRpageObjects.clickOnFirstAlertDropdown();
	}

	@Then("I Select Clearance Alert dropdown value")
	public void clickOnClearanceAlertDropdown() throws Throwable {
		cnRpageObjects.clickOnClearanceAlertDropdown();
	}

	@Then("I Verify Expiring alert grouped at the top followed by clearance alerts")
	public void verifyClearanceAlertSorting() throws Throwable {
		cnRpageObjects.verifyClearanceAlertSorting();
	}

	@Then("I Verify First alert to display first alert in storewalkorder")
	public void verifyFirstAlertSorting() throws Throwable {
		cnRpageObjects.verifyFirstAlertSorting();
	}

	@Then("I Verify Expiring alert grouped at top followed by clearance alerts and first alerts")
	public void verifyAllAlertSorting() throws Throwable {
		cnRpageObjects.verifyClearanceAlertSorting();
	}

	@Then("I Verify All Products, 1st alert and Clearance alert dropdown values are present")
	public void verifyDropdowns() throws Throwable {
		cnRpageObjects.verifyAlertsValuesInDropdown();
	}

	@Then("I verify department and location information is not displayed")
	public void verifyDepartmentInforNotDisplayed() throws Throwable {
		cnRpageObjects.verifyDepartmentInforNotDisplayed();
	}

	@Then("I Click on Frozen Clearance bay menu")
	public void clickOnFrozenClearance() throws Throwable {
		cnRpageObjects.clickOnFrozenClearance();
	}

	@Then("I Verify Frozen Clearance bay check text is displayed")
	public void verifyOnFrozenClearanceCheckText() throws Throwable {
		cnRpageObjects.verifyFrozenClearanceBayText();
	}

	@Then("I Verify Confirm Clearance Bay check button is displayed")
	public void verifyConfirmClearanceBayCheckButton() throws Throwable {
		cnRpageObjects.verifyConfirmClearanceBayCheckButton();
	}

	@Then("I Click on Ambient Clearance Bay menu")
	public void clickOnAmbientClearance() throws Throwable {
		cnRpageObjects.clickOnAmbientClearance();
	}

	@Then("I Verify Ambient Clearance Bay check text is displayed")
	public void verifyAmbientClearanceCheckText() throws Throwable {
		cnRpageObjects.verifyAmbientClearanceBayText();
	}

	@Then("And I Verify Wastage message on wastage popup")
	public void verifyWastagePopup() throws Throwable {
		cnRpageObjects.verifyWastagePopupMessage();
	}


	@When("I click on Markdown menu")
	public void iClickOnMarkdownMenu() throws Throwable {
		cnRpageObjects.clickOnMarkdownMenu();
	}

	@When("I click on hotkeys")
	public void iClickOnHotkeys() throws Throwable {
		cnRpageObjects.clickOnHotkeys();
	}

	@When("I verify Markdown option is not available in hotekeys")
	public void iVerifyMarkdownOptionNotAvailable() throws Throwable {
		cnRpageObjects.verifyMarkdownOptionNotAvailable();
	}

	@When("I Verify Stock adjustment option is available in hotkeys")
	public void iVerifyStockAdjustmentOptionAvailable() throws Throwable {
		cnRpageObjects.verifyStockAdjustmentOptionAvailable();
	}

	@When("I click on stock adjustment option from hotkeys")
	public void iClickOnStockAdjustmentFromHotkeys() throws Throwable {
		cnRpageObjects.clickOnStockAdjustmentFromHotkeys();
	}

	@When("I verify Stock adjustment main page is displayed")
	public void iVerifyStockAdjustmentPageDisplayed() throws Throwable {
		cnRpageObjects.verifyStockAdjustmentPageDisplayed();
	}

	@When("I Verify Stock information option is available in hotkeys")
	public void iVerifyStockInformationOptionAvailable() throws Throwable {
		cnRpageObjects.iVerifyStockInformationOptionAvailable();
	}

	@When("I click on stock information option from hotkeys")
	public void iClickOnStockInformationFromHotkeys() throws Throwable {
		cnRpageObjects.iClickOnStockInformationFromHotkeys();
	}

	@When("I verify Stock information main page is displayed")
	public void iVerifyStockInformationPageDisplayed() throws Throwable {
		cnRpageObjects.verifyStockInformationPageDisplayed();
	}

	@When("I click on Back button")
	public void iClickOnBackButton() throws Throwable {
		cnRpageObjects.clickOnBackButton();
	}

	@When("I Verify Stock adjustment option is not available in hotkeys")
	public void iVerifyStockAdjustmentOptionNotAvailable() throws Throwable {
		cnRpageObjects.verifyStockAdjustmentOptionNotAvailable();
	}

	@Then("I Click on Stock adjustment menu")
	public void iClickOnStockAdjustmentMenu() throws Throwable {
		cnRpageObjects.clickOnStockAdjustmentMenu();
	}

	@When("I click on Counts from menu")
	public void iClickOnCountMenu() throws Throwable {
		cnRpageObjects.clickOnCountMenu();
	}

	@When("I click on GLH from menu")
	public void iClickOnGLHMenu() throws Throwable {
		cnRpageObjects.clickOnGLHMenu();
	}

	@When("I Verify Shelf edge label to stack option is available in hotkeys")
	public void iVerifyShelfEdgeLabelToStackOption() throws Throwable {
		cnRpageObjects.verifyShelfEdgeLabelToStackOption();
	}

	@When("I click on Shelf edge label to stack option from hotkeys")
	public void iClickShelfEdgeLabelToStackOption() throws Throwable {
		cnRpageObjects.clickShelfEdgeLabelToStackOption();
	}

	@When("I verify Shelf edge label to stack main page is displayed")
	public void iVerifyShelfEdgeLabelToStackPageDisplayed() throws Throwable {
		cnRpageObjects.verifyShelfEdgeLabelToStackPage();
	}


	@When("I Verify Markdown option is available in hotkeys")
	public void iVerifyMarkdownOptionAvailable() throws Throwable {
		cnRpageObjects.verifyMarkdownOptionAvailable();
	}

	@When("I click on Scan markdown submenus from Markdown menu")
	public void iClickScanMarkdownSubmenus() throws Throwable {
		cnRpageObjects.clickScanMarkdownSubmenus();
	}

	@When("I click on Markdowns list submenus from Markdown menu")
	public void iClickMardownsList() throws Throwable {
		cnRpageObjects.clickMardownsList();
	}

	@When("I click on Markdown option from hotkeys")
	public void iClickOnMarkdownOption() throws Throwable {
		cnRpageObjects.iClickOnMarkdownOption();
	}

	@When("I verify Markdown main page is displayed")
	public void iVerifyMarkdownMainPage() throws Throwable {
		cnRpageObjects.iVerifyMarkdownMainPage();
	}

	@When("I click on Wastage submenus from Markdown menu")
	public void iClickOnWastageSubmenus() throws Throwable {
		cnRpageObjects.iClickOnWastageSubmenus();
	}

	@When("I click on Transfer stock to A dept submenus from Markdown menu")
	public void iClickOnTransferStockToADept() throws Throwable {
		cnRpageObjects.iClickOnTransferStockToADept();
	}

	@When("I click on Transfer back from A dept submenus from Markdown menu")
	public void iClickOnTransferBAckFromADept() throws Throwable {
		cnRpageObjects.iClickOnTransferBAckFromADept();
	}

	@When("I click on Other adjustments submenus from Markdown menu")
	public void iClickOnOtherAdjustments() throws Throwable {
		cnRpageObjects.iClickOnOtherAdjustments();
	}

	@When("I click on Store to store transfer submenus from Markdown menu")
	public void iClickOnStoreToStoreTransfer() throws Throwable {
		cnRpageObjects.iClickOnStoreToStoreTransfer();
	}


	@When("I click on Sales orders from menu")
	public void iClickOnSalesOrderFromMenu() throws Throwable {
		Thread.sleep(3000);
		cnRpageObjects.iClickOnSalesOrderMenu();
	}


	@When("I click on Shelf edge label to stack from menu")
	public void iClickOnShelfEdgeLabelToStack() throws Throwable {
		cnRpageObjects.clickOnShelfEdgeLabelToStack();
	}


	@When("I click on Yellow screens Menu from menu")
	public void iClickOnYellowScreensMenu() throws Throwable {
		cnRpageObjects.iClickOnYellowScreens();
	}

	@When("I click on Stock information Menu from menu")
	public void iClickOnStockInformationMenu() throws Throwable {
		cnRpageObjects.clickOnStockInformationMenu();
	}

	@When("I click on GLH screen Menu from menu")
	public void iClickOnGLHScreenMenu() throws Throwable {
		cnRpageObjects.clickOnGLHScreenMenu();
	}

	@When("I click on Stock adjustment Menu from menu")
	public void iClickOnStockAdjustment() throws Throwable {
		cnRpageObjects.clickOnStockAdjustmentMenu();
	}

	@When("I click on Markdown Menu from menu")
	public void iClickOnMarkdown() throws Throwable {
		cnRpageObjects.clickOnMarkdownMenu();
	}

	@When("I click on Clean and Rotate Menu from menu")
	public void iClickOnCleanAndRotateMenu() throws Throwable {
		cnRpageObjects.clickOnCleanAndRotateMenu();
	}
	@When("I verify Clearence bay and Alert is displayed")
	public void iVerifyCleararnceBayAndAlert() throws Throwable {
		cnRpageObjects.verifyCleararnceBayAndAlert();
	}

	@When("I click on Clearence bay and Alert screen Menu from Clean and rotate menu")
	public void iClickCleararnceBayAndAlert() throws Throwable {
		cnRpageObjects.clickCleararnceBayAndAlert();
	} 


	@When("I click on Cross icon")
	public void clickOnCrossIcon() throws Throwable {
		cnRpageObjects.clickOnCrossIcon();
	}


	@When("I verify Weekly schedule,Department & Item scan is displayed")
	public void iVerifyWeeklyScheduleDepartment() throws Throwable {
		cnRpageObjects.verifyWeeklyScheduleDepartment();
	}

	@When("I click on Weekly schedule,Department & Item scan Menu from Clean and rotate menu")
	public void iClickWeeklyScheduleDepartment() throws Throwable {
		cnRpageObjects.clickWeeklyScheduleDepartment();
	}

	@When("I verify Action/Log product screen is displayed")
	public void iVerifyActionLogProduct() throws Throwable {
		cnRpageObjects.verifyActionLogProduct();
	}

	@When("I click on Action/Log product Menu from Clean and rotate menu")
	public void iClickOnActionLogProduct() throws Throwable {
		cnRpageObjects.clickOnActionLogProduct();
	}

	@Given("Request is made to cleanandrotate Login services {string} and {string}")
	public void request_is_made_to_cleanandrotate_Login_services_and(String arg1, String arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	//	@Then("I Verify the department banner {string} as {string}")
	//	public void i_Verify_the_department_banner_as(String arg1, String arg2) throws Throwable {
	//	    cnRpageObjects.verifyDeptBanner();
	//	}


	@Then("I Add Price")
	public void i_Add_Price() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		//throw new PendingException();

	}



	@Then("Request is made to get Alert list Service")
	public void getAlertListUrl() throws Throwable {
		CleanAndRotateServiceData.getAlertListCodecheck(accessTocken);
	}

	@Then("Get Alert list Service response")
	public void getAlertListServiceResponse() throws Throwable {

		CleanAndRotateServiceData.getAlertListServiceResponse();
	}

	@Then("I Click on Main Menu from hotkeys")
	public void clickOnMainMenuFromHotkeys() throws Throwable {
		cnRpageObjects.clickOnMainMenuFromHotkeys();
	}

	@Then("I Re-open the Complete departments")
	public void reopenTheDept() throws Throwable {
		cnRpageObjects.reopenTheDept();
	}

	@Then("I verify weekly shcedule status as Not started")
	public void verifyStatusAsNotStarted() throws Throwable {
		cnRpageObjects.verifyStatusAsNotStarted();
	}

	@Then("Verify Select Reason Code as Waste Out of date")
	public void verifyReasonCode1() throws Throwable {
		cnRpageObjects.verifyReasonCode1(); 
	}

	@Then("Verify Select Reason Code as Waste Damaged Fruit & Veg Quality or Condition, Waste Out of date ,Waste Charity")
	public void verifyReasonCode2() throws Throwable {
		cnRpageObjects.verifyReasonCode2(); 
	}


	@When("I verify Main menu screen is displayed")
	public void verifyMainMenuScreen() throws Throwable {
		cnRpageObjects.verifyMainMenuScreen();
	}

	@When("I click on Shelf Edge menu")
	public void clickOnShelfEdge() throws Throwable {
		cnRpageObjects.clickOnShelfEdge();
	}

	@When("I verify user is navigated to Request Label screen")
	public void navigateToRequestLabel() throws Throwable {
		cnRpageObjects.navigateToRequestLabel();
	}

	@When("I verify Target Replenishment and Shelf Edge Label to Stack modules are removed from SMA App Home Screen")
	public void verifyEdgeshelfIsRemoved() throws Throwable {
		cnRpageObjects.verifyEdgeshelfIsRemoved();
	}

	@When("I verify for Not Started week all department status is Not Started.")
	public void verifyAllWeekAsNotStarted() throws Throwable {
		//cnRpageObjects.verifyAllWeekAsNotStarted();
	}

	@When("I verify 1st alert is created for the product {string}")
	public void verifyFirstAlertCreated(String productMin) throws Throwable {
		cnRpageObjects.verifyAlertIsCreated(productMin);
	}
	
	@When("I verify Clearance alert is created for the product {string}")
	public void verifyCleararncealertCreated(String productMin) throws Throwable {
		cnRpageObjects.verifyAlertIsCreated(productMin);
	}
	
	@When("I verify Expiry alert is created for the product {string}")
	public void verifyExpiryalertCreated(String productMin) throws Throwable {
		cnRpageObjects.verifyAlertIsCreated(productMin);
	}
	
	@When("I verify Clearance alert is not deleted for the product {string}")
	public void clearanceAlertNotDeleted() throws Throwable {
		cnRpageObjects.deleteAlert();
	}
	
	@When("I verify 1st alert is not deleted for the product {string}")
	public void firstAlertNotDeleted() throws Throwable {
		cnRpageObjects.deleteAlert();
	}

	@Then("I click on action spinner")
	public void clickSpinner() throws Throwable {

		cnRpageObjects.clickSpinner();
	}
	
	@Then("I verify {string} action displayed on action spinner")
	public void verifyActionOnSpinner(String action) throws Throwable {

		cnRpageObjects.verifyActionOnSpinner(action);
	}
	
	@Then("I verify date on Calendar")
	public void verifyDatesOnCalendar() throws Throwable {

		cnRpageObjects.clickSpinner();
	}
	
	@Then("Verify Wastage reason code {string} is displayed")
	public void verifyWastageReasonCode(String wastageCode) throws Throwable {
		cnRpageObjects.verifyWastageReasonCode(wastageCode); 
	}

	@Then("Verify Wastage reason code {string} is not displayed")
	public void wastageReasonCodeNotDisplay(String wastageCode) throws Throwable {
		cnRpageObjects.wastageReasonCodeNotDisplay(wastageCode); 
	}
	
	@Then("Verify {string} as default action is displayed")
	public void verifyDefaultActionDisplay(String action) throws Throwable {
		cnRpageObjects.verifyDefaultAction(action); 
	}
	
	@Then("Verify {string} action is displayed")
	public void verifyActionDisplay(String action) throws Throwable {
		cnRpageObjects.verifyWastageReasonCode(action); 
	}

	@Then("Verify {string} action is not displayed")
	public void verifyActionNotDisplay(String action) throws Throwable {
		cnRpageObjects.wastageReasonCodeNotDisplay(action); 
	}

}
