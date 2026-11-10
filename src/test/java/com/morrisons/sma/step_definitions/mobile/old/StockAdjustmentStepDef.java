package com.morrisons.sma.step_definitions.mobile.old;

import ch.qos.logback.classic.Logger;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.morrisons.common.PageFactory.InitClass;
import com.morrisons.common.action.Hook;
import com.morrisons.common.helper.MobileHelper;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import com.morrisons.sma.page_objects.mobile.old.CleanAndRotatePO;
import com.morrisons.sma.page_objects.mobile.old.CountPO;
import com.morrisons.sma.page_objects.mobile.old.GLHPageObject;
import com.morrisons.sma.page_objects.mobile.old.StockAdjustmentPO;
import com.morrisons.sma.page_objects.mobile.stockAdjustment.TransferBackFromADeptPO_New;
import com.morrisons.sma.pojo.service.StockAdjustmentServicePojo.GetStockAdjustmentRoot;
import com.morrisons.sma.pojo.service.StockAdjustmentServicePojo.StockAdjustmentServiceData;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpResponse;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class StockAdjustmentStepDef {

	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
	String env = applicationConfig.getWebElementEnviroment().getEnv();
	StockAdjustmentPO SA = new StockAdjustmentPO();
	private AndroidDriver driveR;
	ObjectMapper objectMapper = new ObjectMapper();
	CleanAndRotatePO cnRpageObjects = new CleanAndRotatePO();
	public static int logItemCountUI = 0;
	public static int updatedLogItemCountUI = 0;
	Logger log = null;
	StockAdjustmentServiceData stockAdjData = new StockAdjustmentServiceData();
	int getResponseCode = 200;
	HttpResponse stockAdjResponse;
	public GetStockAdjustmentRoot stockAdjustmentResponseMap;
	public StockAdjustmentStepDef() {
		this.driveR = (AndroidDriver) Hook.getDriver();
	}
	@Then("I click on {string}")
	public void i_click_on(String arg1) throws Throwable {
		System.out.println(arg1);
		SA.menuOption(arg1);

	}

	@Then("I verify reason code {string} on stockAdjustment Page")
	public void i_verify_reason_code_on_stockAdjustment_Page(String arg1) throws Throwable {
		SA.reasonCodeSAPage(arg1);
	}

	@Then("I click on Adjustmentcode {string} on stockAdjustment Page")
	public void i_click_on_Adjustmentcode_on_stockAdjustment_Page(String arg1) throws Throwable {
		SA.clickAdjustmentCode(arg1);
	}

	@Then("I Select store{string} to transfer")
	public void i_Select_store_to_transfer(String arg1) throws Throwable {
		SA.selectStoreId(arg1);
	}

	@Then("I verify the error message{string} is displayed")
	public void i_verify_the_error_message_is_displayed(String arg1) throws Throwable {
		SA.errorMessage(arg1);
	}

	@Then("I verify the store {string} is availabel for transfer")
	public void i_verify_the_store_is_availabel_for_transfer(String arg1) throws Throwable {
		SA.storeIdAvailabel(arg1);
	}

	@Given("I click on the given {string} storeid")
	public void i_click_on_the_given_storeid(String arg1) throws Throwable {
		SA.clickonGivenStore(arg1);
	}

	@Given("I enter {string} for adjustment")
	public void i_enter_for_adjustment(String arg1) throws Throwable {
		SA.quantityEditBox(arg1);
	}

	@Then("I click on confirm button")
	public void i_click_on_confirm_button() throws Throwable {
		SA.confirmButton();
	}

	@Then("I click on listView")
	public void i_click_on_listView() throws Throwable {
		SA.clickListview();
	}

	@Then("I click on Submit Button")
	public void i_click_on_Submit_Button() throws Throwable {
		SA.clickSubmitButton();
	}

	@Then("I confirm Submit List")
	public void i_confirm_Submit_List() throws Throwable {
		SA.clickconfirmSubmit();
	}

	@Given("I click on the reason code {string}")
	public void i_click_on_the_reason_code(String arg1) throws Throwable {
		MobileHelper.ScrolltoElementWithText(StockAdjustmentPO.driveR,arg1);
		SA.reasoncodeClick(arg1);
	}

	@Then("I verify scuccess {string}")
	public void i_verify_scuccess(String arg1) throws Throwable {
		SA.sucessMessage(arg1);
	}

	@Then("I click on cross Button")
	public void i_click_on_cross_Button() throws Throwable {
		SA.clickCrossButton();
	}

	@Then("I verify Stock Adjustment Message{string}")
	public void i_verify_Stock_Adjustment_Message(String arg1) throws Throwable {
		SA.autoSaveMessage(arg1);
	}

	@Then("I verify resume new option is displayed with {string} to continue")
	public void i_verify_resume_new_option_is_displayed_with_to_continue(String arg1) throws Throwable {
		SA.resumeNeweMessage(arg1);
	}

	@Then("I click on option New")
	public void i_click_on_option_New() throws Throwable {
		SA.clickOptionNew();
	}

	@Then("I click on option Resume")
	public void i_click_on_option_Resume() throws Throwable {
		SA.clickOptionResume();
	}

	@Then("I verify the product {string}")
	public void i_verify_the_product(String arg1) throws Throwable {
		SA.verifyProduct(arg1);
	}

	@Given("I verify user is redirected to Stock Adjustment home screen")
	public void i_verify_user_is_redirected_to_Stock_Adjustment_home_screen() throws Throwable {
		SA.StockAdjustmentHomeScreen();
	}

	@Given("I verify, I am on Home Screen")
	public void i_verify_I_am_on_Home_Screen() throws Throwable {
		SA.HomeScreen();
	}

	@Then("I click on done on the messagebox")
	public void i_click_on_done_on_the_messagebox() throws Throwable {
		SA.doneButton();
	}

	@Then("I click on Stock Information")
	public void i_click_on_Stock_Information() throws Throwable {
		SA.stockInformation();
	}

	@Then("I click on stock")
	public void i_click_on_stock() throws Throwable {
		SA.stock();
	}

	@Then("I verify under Today reason code {string} and {string}")
	public void i_verify_under_Today_reason_code_and(String arg1, String arg2) throws Throwable {
		MobileHelper.ScrolltoElementWithText(SA.driveR,arg1);
		SA.verifyReasncodeAndCount(arg1, arg2);
	}

	@Then("I navigate to Alert screen and verify product count and message when alerts are not generated and no items are displayed in the list")
	public void i_navigate_to_Alert_screen_and_verify_product_count_and_message_when_alerts_are_not_generated_and_no_items_are_displayed_in_the_list()
			throws Throwable {
		logItemCountUI = cnRpageObjects.getProductCountOnProductDetail();
		System.out.println("logItemCountUI : " + logItemCountUI);
		assertEquals(logItemCountUI, 0, "There are alerts present for the products on the Code Alerts Page");
	}

	@Then("I navigate to Alert screen and verify product count and message when alerts are generated and items in the list")
	public void i_navigate_to_Alert_screen_and_verify_product_count_and_message_when_alerts_are_generated_and_items_in_the_list()
			throws Throwable {
		logItemCountUI = cnRpageObjects.getProductCountOnProductDetail();

		if (logItemCountUI > 0) {
			System.out.println("logItemCountUI : " + logItemCountUI);

			// log.info("logItemCountUI : " + logItemCountUI);

		} else {
			System.out.println("No alerts present");
		}

	}

	@Then("I select an {string} from the list")
	public void i_select_an_from_the_list(String min) throws Throwable {
		// System.out.println(min);
		cnRpageObjects.selectMin(min);

	}

	@Then("I select {string} from the com.morrisons.common.action drop down")
	public void i_select_from_the_action_drop_down(String action) throws Throwable {

		cnRpageObjects.selectActionOption(action);

	}

	@Then("I select {string} from the action drop down")
	public void i_select_from_the_action_drop_down1(String action) throws Throwable {

		cnRpageObjects.selectActionOption(action);

	}

	@Then("I enter the {string} in the quantity field")
	public void i_enter_the_in_the_quantity_field(String qty) throws Throwable {
		cnRpageObjects.enterQuantity(qty);
	}

	@Then("I click on Log Product button")
	public void clickLogProduct() throws Throwable {

		cnRpageObjects.clickOnLogProductButton();
	}

	@Then("I Verify Select Reason Code template")
	public void i_Verify_Select_Reason_Code_template() throws Throwable {
		cnRpageObjects.verifyReasonCode();
	}

	@Then("I select the {string} from the reason code drop down")
	public void i_select_the_from_the_reason_code_drop_down(String reasonCode) throws Throwable {
		cnRpageObjects.selectReasonCode(reasonCode);
		Thread.sleep(3000);
	}

	@Then("Verify the {string} gets deleted  from the list and count gets decreased")
	public void verify_the_gets_deleted_from_the_list_and_count_gets_decreased(String min) throws Throwable {

		cnRpageObjects.itemExistsOrNot(min);
		// logItemCountUI=2;
		updatedLogItemCountUI = cnRpageObjects.getProductCountOnProductDetail();

		if (updatedLogItemCountUI < logItemCountUI || updatedLogItemCountUI == 0) {
			System.out.println("The item count has decreased");

		}

	}

	@Then("the product should be non deletable from the list")
	public void the_product_should_be_non_deletable_from_the_list() throws Throwable {
		cnRpageObjects.alertSwipeLeftProductNonDeletable();
	}

	@Then("I Verify the department menu banner as {string}")
	public void i_Verify_the_banner_as(String deptStatus) throws Throwable {

		cnRpageObjects.verifyCodeAlertDepartmentBanner(deptStatus);

	}

	@Given("a request is made to Stock Adjustment get service for {string} and product {string}")
	public void a_request_is_made_to_Stock_Adjustment_get_service_for_and_product(String storeId, String productId)
			throws Throwable {
		stockAdjData.getStockAdjustment(storeId, productId);

	}

	@When("the request is made to the specified Stock Adjustment service")
	public void the_request_is_made_to_the_specified_Stock_Adjustment_service() throws Throwable {
		stockAdjResponse = stockAdjData.performGetOperation();
		int stcokAdjResponseCode = stockAdjResponse.getStatusLine().getStatusCode();
		System.out.println("StockAdjustment status: " + stcokAdjResponseCode);
		assertEquals(stcokAdjResponseCode, getResponseCode,
				"Failure in Stock Adjustment Response Response. Response code");

	}

	@Then("the service should return details for specified stock Adjustment service")
	public void the_service_should_return_details_for_specified_stock_Adjustment_service() throws Throwable {

		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		stockAdjustmentResponseMap = objectMapper.readValue(stockAdjResponse.getEntity().getContent(),
				new TypeReference<GetStockAdjustmentRoot>() {
				});

		String stockAdjResponseResult = objectMapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(stockAdjustmentResponseMap);
		System.out.println("Esel Label Detail Response:\n" + stockAdjResponseResult);

	}
	
	@Then("I verify Message {string}")
	public void i_verify_Message(String msg) throws Throwable {
	   SA.verifyWeightproductMessage(msg);
	}

	@Then("I verify KG is Displayed")
	public void i_verify_KG_is_Displayed() throws Throwable {
	   SA.verifyKGDisplayed();
	}
	
	@Then("I click Yes button")
	public void i_click_Yes_button() throws Throwable {
	    SA.clickYes();
	}
	@Then("I complete the schedule for all the departments {string} on page {string}.")
	public void i_complete_the_schedule_for_all_the_departments(String sDeptList, String sPageName) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, InterruptedException, NoSuchFieldException {
		// Write code here that turns the phrase above into concrete actions
			List<WebElement> oEle1 = InitClass.createMultipleObjects(driveR, sDeptList, "sLocatorName", "com.morrisons.sma.page_objects.mobile." + sPageName);
		CountPO implement = new CountPO();
			for(int a=0;a<oEle1.size();a++) {
				oEle1.get(a).click();
				implement.CompeteSchedule(oEle1, sDeptList, sPageName);
				Thread.sleep(3000);
				oEle1 = InitClass.createMultipleObjects(driveR, sDeptList, "sLocatorName", "com.morrisons.sma.page_objects.mobile." + sPageName);

			}
	}
}
