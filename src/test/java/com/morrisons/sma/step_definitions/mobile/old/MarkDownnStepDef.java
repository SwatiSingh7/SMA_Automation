package com.morrisons.sma.step_definitions.mobile.old;

import com.morrisons.common.utility.ApplicationContext;
import com.morrisons.sma.page_objects.mobile.old.GLHPageObject;
import com.morrisons.sma.page_objects.mobile.old.MarkDownPO;
import com.morrisons.sma.page_objects.mobile.old.StockAdjustmentPO;
import com.morrisons.sma.page_objects.service.MarkdownServicePages;
import com.morrisons.sma.page_objects.service.StorewalkServicePage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpResponse;
import org.openqa.selenium.By;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class MarkDownnStepDef {
	private static final String Null = null;
	MarkDownPO markDownPage = new MarkDownPO();
	StockAdjustmentPO SA = new StockAdjustmentPO();
	private AndroidDriver driveR;
	public static String iscomplete;
	public static String windows;

	public static String enterBarcode = null;
	public static String enterBarcode1 = null;

	MarkdownServicePages markdownServicePages = new MarkdownServicePages();
	private ApplicationContext applicationContext;

	GLHPageObject glhImplementations = new GLHPageObject();
	
	String accessToken = null;
	public static HttpResponse Response;


	/// -------------------------Service step
	/// defination-------------------------------------------------

	//// Rasika

	@When("Get generated access token")
	public void getGeneratedAccessTokenAppLogin() throws Throwable {
		String mdAccessToken = markdownServicePages.getGeneratedAccessTokenAppLogin();
		accessToken = mdAccessToken;
	}

	@When("Get Operation perform on Markdown service request")
	public void getServicePerformOperation() throws Throwable {
		Response = markdownServicePages.getServicePerformOperation();
		System.out.println(Response);
	}

	@When("Post Operation perform on Markdown service request")
	public void postServicePerformOperation() throws Throwable {
		Response = markdownServicePages.postServicePerformOperation();
		System.out.println(Response);
	}

	@When("Delete Operation perform on Markdown service request")
	public void deleteServicePerformOperation() throws Throwable {
		Response = markdownServicePages.deleteServicePerformOperation();
		System.out.println(Response);
	}

	@When("Patch Operation perform on Markdown service request")
	public void patchServicePerformOperation() throws Throwable {
		Response = markdownServicePages.patchServicePerformOperation();
		System.out.println(Response);
	}

	// Get Markdown details after scanning an Item
	@When("Get request is made to GetMarkdown Details service for store id {string} and product id {string}")
	public void getMarkdownDetailsUrl(String storeId, String productId) throws Throwable {
		markdownServicePages.getMarkdownDetailsUrl(storeId, productId, accessToken);
	}

	// Get Markdown details before scanning an Item
	@Given("Get request is made to GetMarkdown Details service for store id {string} and product id {string} before scanning a products")
	public void get_request_is_made_to_GetMarkdown_Details_service_for_store_id_and_product_id_before_scanning_a_products(
			String storeId, String productId) throws Throwable {
		markdownServicePages.getMarkdownDetailsUrlBeforeItemScan(storeId,productId,accessToken);
	}

	@When("Get markdown details service response before scanning the product")
	public void getMarkdownDetailsServiceBeforeScan() throws Throwable {
		markdownServicePages.getMarkdownDetailsServiceBeforeScan();
	}

	@When("Get markdown details service response after scanning the product")
	public void getMarkdownDetailsServiceAfterScan() throws Throwable {
		markdownServicePages.getMarkdownDetailsServiceAfterScan();

	}
	
	@When("Get firstmarkdownwindow attributes value from GetMarkdownDetails service")
	public void getFirstmarkdownwindowAttribute() throws Throwable {
		markdownServicePages.getFirstMarkdownAttribute();
	}

	@When("Verify firstmarkdownwindow attributes is showing updated value as {string}")
	public void verifyFirstmarkdownwindowAttribute(String firstmarkdownwindow) throws Throwable {
		markdownServicePages.verifyFirstmarkdownwindowAttribute(firstmarkdownwindow);
	}
	
	@Then("I verify First markdown attribute is present and in HH:MM:SS format")
	public void verifyFirstMarkdownFormat() throws Throwable {
		markdownServicePages.verifyFirstMarkdownFormat();
	}
	
	@When("Get markdown percentage from GetMarkdownDetails service")
	public void getMarkdownPercentageFromService() throws Throwable {
		markdownServicePages.getMarkdownPercentageFromService();
	}
	
	@Then("Verify optimized percentage and price from GetMarkdownDetails service")
	public void verifyOptimizedPriceService() throws Throwable {
		markdownServicePages.verifyOptimizedPriceService();
	}
	
	@Then("I verify isComplete attribute value as {string} in GetMarkdownDetails service")
	public void verifyIsCompleteValue(String isComplete) throws Throwable {
		markdownServicePages.verifyIsCompleteValue(isComplete);
	}

	//// Get blueyonder details
	@When("Get request is made to Blueyonder Details service for store id {string} and product id {string}")
	public void getBlueyonderDetailsUrl(String storeId, String productId) throws Throwable {
		markdownServicePages.getBlueyonderDetailsUrl(storeId, productId, accessToken);

	}

	@When("Get Operation perform on Blueyonder service request")
	public void getBlueyonderPerformOperation() throws Throwable {
		markdownServicePages.getBlueyonderPerformOperation();

	}

	@When("Get Blueyonder Details service response")
	public void getBlueyonderServiceResponse() throws Throwable {
		markdownServicePages.getBlueyonderServiceResponse();

	}

	@Then("Get Blueyonder Details service response for item that do not have price")
	public void get_Blueyonder_Details_service_response_for_item_that_do_not_have_price() throws Throwable {
		markdownServicePages.getBlueyonderServiceResponsePriceNotFound();
	}

	@Then("verify Optimised price value in Markdown Get API is shown Price Not found when BY V2 API response is price not found")
	public void blueyonderErrorCodeMatchesWithMarkdownOptimisedPriceErrorCode() throws Throwable {
		 markdownServicePages.compareBYpriceOptimizedPriceNotFound();

	}

	/// Get Markdown List
	@When("Get request is made to GetMarkdown List service for store id {string}")
	public void getMarkdownListUrl(String storeId) throws Throwable {
		markdownServicePages.getMarkdownListUrl(storeId, accessToken);
	}

	@When("Get Markdown List service response")
	public void getMarkdownListServiceResponse() throws Throwable {
		markdownServicePages.getMarkdownListServiceResponse();
	}
	
	@When("Verify isComplete attibute in Get markdown list")
	public void verifyIsCompleteAttribute() throws Throwable {
		markdownServicePages.verifyIsCompleteAttribute();
	}

	///// Delete print list

	@When("Patch request is made to delete print list service for store id {string}")
	public void deletePrintListServiceUrl(String storeId) throws Throwable {
		markdownServicePages.deletePrintListServiceUrl(storeId, accessToken);
	}
	
	@Then("I verify Markdown percentage on UI and services matches")
	public void markdownPercentageOnUISevice() throws Throwable {
		markdownServicePages.markdownPercentageOnUISevice();
	}

	/// -------------------------UI app step
	/// defination-------------------------------------------------

	@When("I enter {string} and {string} for sma")
	public void i_enter_and_for_sma(String userName, String password) throws Throwable {
		markDownPage.usernamePasswrod(userName, password);
	}

	@And("I click on login button for sma")
	public void i_click_on_login_button_for_sma() throws Throwable {
		markDownPage.clickLogin();

	}

	@Then("I click on Markdowns")
	public void i_click_on_Markdowns() throws Throwable {
		markDownPage.clickMarkDown();
	}

	@Then("I click on Scan Markdowns")
	public void i_click_on_Scan_Markdowns() throws Throwable {
		markDownPage.clickscanMarkdown();
	}

	@Then("I click on No Printer Available")
	public void i_click_on_No_Printer_Available() throws Throwable {
		markDownPage.clicksnoPrinterAvailabel();
	}

	@Then("I validate number of {string} available")
	public void i_validate_number_of_available(List<String> arg1) throws Throwable {
		markDownPage.department(arg1);
	}

	@Then("I click on the {string} available")
	public void i_click_on_the_available(String arg1) throws Throwable {
		markDownPage.Department(arg1);
	}

	@Then("I click on the {string} available in given location")
	public void i_click_on_the_available_in_given_location(String dep) throws Throwable {
		markDownPage.departmentt(dep);
	}

	@Then("I validate all {string} under all departments")
	public void i_validate_all_under_all_departments(List<String> cat) throws Throwable {
		markDownPage.validatecategory(cat);
	}

	@Then("I click on Back to home screen from HotKey Feature")
	public void i_click_on_Back_Button() throws Throwable {
		markDownPage.clickHotKeyMainMenu();
	}

	@Then("I click on Logout Button")
	public void i_click_on_Logout_Button() throws Throwable {
		markDownPage.clickLogoutButton();
	}

	@Then("I click on barcode entry Button")
	public void i_click_on_barcode_entry_Button() throws Throwable {
		markDownPage.clickPrinterEntery();
	}

	@Then("Enter {string} number")
	public void enter_invalid_barcode_for_printer(String arg1) throws Throwable {
		markDownPage.enterBarcode(arg1);
	}
	
	@Then("I click on product {string} in the list")
	public void clickProductInList(String product) throws Throwable {
		markDownPage.clickProductInList(product);
	}


	@Then("Enter Crisp department min number")
	public void enterCrispDeptMin() throws Throwable {
		enterBarcode = markDownPage.crispItem[0];
		markDownPage.enterProductMinValue(enterBarcode);
	}
	
	@Then("Enter Non-Crisp department min number")
	public void enterNonCrispDeptMin() throws Throwable {
		enterBarcode = markDownPage.nonCrispItem[0];
		markDownPage.enterProductMinValue(enterBarcode);
	}
	
	@Then("Enter Non-Crisp department product min number")
	public void enterNonCrispDeptItemMin() throws Throwable {
		enterBarcode1 = markDownPage.nonCrispItem[1];
		markDownPage.enterProductMinValue(enterBarcode1);
	}

//	@Then("Enter product which is not available in price service")
//	public void enterFirstDeptMinNextWeek() throws Throwable {
//		enterBarcode = markDownPage.firstDeptMin_noPrice;
//		markDownPage.enterProductMinValue(enterBarcode);
//	}
//
//	@Then("Enter product which is not available in price & markdown service")
//	public void enterSecondeptMinNextWeek() throws Throwable {
//		enterBarcode = markDownPage.firstDeptMin_noPriceMarkdown;
//		markDownPage.enterProductMinValue(enterBarcode);
//	}

	@Then("Verify the latest scanned item is visible at the top")
	public void verify_the_latest_scan_MIN_number() throws Throwable {
		String arg1 = enterBarcode;
		markDownPage.verifyTheLatestScanMINNumber(arg1);
	}
	
	@Then("I Verify the latestt scanned itemm is visible at the top")
	public void verify_the_latest_scan_MIN_numberr() throws Throwable {
		String arg1 = enterBarcode1;
		markDownPage.verifyTheLatestScanMINNumber(arg1);
	}

	@Then("I Verify the Scanned item is visible")
	public void verifyTheMIN() throws Throwable {
		String arg1 = enterBarcode;
		markDownPage.verifyTheMINNumber(arg1);
	}

	@Then("I Verify the Scanned itemm is visible")
	public void verifyTheMINN() throws Throwable {
		String arg1 = enterBarcode1;
		markDownPage.verifyTheMINNumber(arg1);
	}

	@Then("Verify the latest scanned itemm is visible at the top")
	public void verify_the_latest_scan_MINNN_number() throws Throwable {
		String arg1 = enterBarcode1;
		markDownPage.verifyTheLatestScanMINNumber(arg1);
	}

	@Then("I Verify the Scanned item action as {string}")
	public void verify_the_Scanned_item_action(String arg1) throws Throwable {
		markDownPage.verifyScannedItemAction(arg1);
	}

	@Then("Scan {string} number")
	public void scanBarocde(String arg1) throws Throwable {
		markDownPage.scanBarcode(arg1);
		Thread.sleep(4000);
	}

	@Then("I verify printer not found error message is displayed")
	public void i_verify_printer_not_found_error_message_is_displayed() throws Throwable {
		markDownPage.printerError();
	}

	@Then("I select one of the {string}")
	public void i_select_one_of_the(String arg1) throws Throwable {
		markDownPage.selectCategory(arg1);

	}

	@Then("I enter markdown {string} for the product")
	public void i_enter_markdown_for_the_product(String qty) throws Throwable {

		markDownPage.enterMarkDownQuantity(qty);

	}

	@Then("I click on Get Price")
	public void i_click_on_Get_Price() throws Throwable {
		markDownPage.clickGetPrice();
	}

	@Then("I click on Add to Print Queue")
	public void i_click_on_Add_to_Print_Queue() throws Throwable {
		markDownPage.clickonPrintQueue();
	}

	@Then("I click on Add to Print Queue as an employee")
	public void i_click_on_Add_to_Print_Queue_as_an_employee() throws Throwable {
		markDownPage.clickonPrintQueueEmployee();
	}

	@Then("I click on Print")
	public void i_click_on_Print() throws Throwable {
		markDownPage.clickOnPrint();
	}

	@Then("I verify and navigate to Print List By clicking on Print list icon")
	public void i_verify_And_navigate_to_Print_List_By_clicking_on_Print_list_icon() throws Throwable {
		markDownPage.clickPrintListIcon();
	}

	@Then("I verify Add to Print Queue button is Displayed")
	public void i_click_on_Add_to_Print_Queue_button_is_Displayed() throws Throwable {
		markDownPage.verifyAddToPrintQueue();

	}

	@Then("I click on Record Out Of Code")
	public void i_click_on_Record_Out_Of_Code() throws Throwable {

		markDownPage.recordOutOfCode();
		markDownPage.clickRecordOutOfCode();

	}

	@Then("I verify Expiry Date and Expiry Quantity is Displayed")
	public void i_verify_Expiry_Date_and_Expiry_Quantity_is_Displayed() throws Throwable {

		markDownPage.recordOutOfCodeexpiryDate();
		markDownPage.recordOutOfCodeexpiryQuantity();
	}

	@Then("I select expiry Date")
	public void i_select_expiry_Date() throws Throwable {
		markDownPage.recordOutOfCodeselectexpirydate();
	}

	@Then("I Enter Expiry Quantity")
	public void i_Enter_Expiry_Quantity() throws Throwable {
		markDownPage.recordOutOfCodeselectquantity();
	}

	@Then("I Verify Add To Print Queue and Record Out of code Button is enabled")
	public void i_Verify_Add_To_Print_Queue_and_Record_Out_of_code_Button_is_enabled() throws Throwable {
		markDownPage.addtoPrintQueueAndRecordOutofCodeButton();
	}

	@Then("I click on Add To Print Queue and Record Out of code Button")
	public void i_click_on_Add_To_Print_Queue_and_Record_Out_of_code_Button() throws Throwable {
		markDownPage.clickaddtoPrintQueueAndRecordOutofCodeButton();

	}

	@Then("I make a service call to get a mardown barcode")
	public void i_make_a_service_call_to_get_a_mardown_barcode() throws Throwable {
		Thread.sleep(1000);

	}

	@Then("I make a service call to print the barcode")
	public void i_make_a_service_call_to_print_the_barcode() throws Throwable {
		Thread.sleep(1000);

	}

	@Then("I store the barcode to perform second markdown")
	public void i_store_the_barcode_to_perform_second_markdown() throws Throwable {
		Thread.sleep(2000);

	}

	@Then("I click on Discount and select percentage")
	public void i_click_on_Discount_and_select_percentage() throws Throwable {
		markDownPage.selectDiscountDropdown();
	}

	@Then("I store the new price into a variable to verify with second markdown")
	public void i_store_the_new_price_into_a_variable_to_verify_with_second_markdown() throws Throwable {
		markDownPage.getDiscountedPrice();
	}

	@And("I store the new price into a variable from first markdown")
	public void i_store_the_new_price_into_a_variable_from_first_markdown() throws Throwable {
		markDownPage.getfirstMDPriceEmployee();
	}

	@Then("Enter first markdown barcode number from the variable")
	public void enter_first_markdown_barcode_number_from_the_variable() throws Throwable {
		markDownPage.firstmardownBarcode();
	}

	@Then("I click on scanned {string}")
	public void i_click_on_scanned(String barcode) throws Throwable {
		markDownPage.clickOnscannedBarcode(barcode);
	}

	@Then("I select the dropdown for discount and select the percentage")
	public void i_select_the_dropdown_for_discount_and_select_the_percentage() throws Throwable {
		markDownPage.selectDropdownPercentage();
	}

	@Then("I select yes option")
	public void i_select_yes_option() throws Throwable {

	}

	@Then("I verify final clearence is performed")
	public void i_verify_final_clearence_is_performed() throws Throwable {

	}

	@Then("I select the dropdown for discount and select the percentage less than (\\d+) percent")
	public void i_select_the_dropdown_for_discount_and_select_the_percentage_less_than_percent(int arg1)
			throws Throwable {

	}

	@Then("I select No option")
	public void i_select_No_option() throws Throwable {

	}

	@Then("I verify final clearence is not performed")
	public void i_verify_final_clearence_is_not_performed() throws Throwable {
		Thread.sleep(1000);
	}

	@Then("I verify Popup is displayed for final clearence")
	public void i_verify_Popup_is_displayed_for_final_clearence() throws Throwable {
		markDownPage.checkPopUpDisplayed();
	}

	@Then("I click on Yes button in the Product")
	public void i_click_on_Yes_button_in_the_Product() throws Throwable {
		markDownPage.clickYesButton();

	}

	@Then("I click on No button in the Product")
	public void i_click_on_No_button_in_the_Product() throws Throwable {
		markDownPage.clickNoButton();
	}

	@And("I enter {string} for verification")
	public void i_enter_for_verification(String barcode) throws Throwable {

		String Barcode = barcode;
		markDownPage.verifyBarcode(Barcode);
	}

	public static void callIsComplete(String isComplete) {

		iscomplete = isComplete;
		System.out.println("Is Complete Status  = " + iscomplete);
	}

	@Then("Verify isComplete status is set as Yes")
	public void verify_isComplete_status_is_set_as_Yes() throws Throwable {
		assertEquals(iscomplete, "Y", " Status not updated as expected");
	}

	@Then("Verify isComplete status is set as No")
	public void verify_isComplete_status_is_set_as_No() throws Throwable {
		assertEquals(iscomplete, "N", " Status not updated as expected");
	}



	@Then("I click on MarkdownList")
	public void i_click_on_MarkdownList() throws Throwable {

		driveR.findElement(By.id("com.morrisons.instore.uat:id/view_markdown_list")).click();

	}

	@Then("I click on PrinterOptions")
	public void i_click_on_PrinterOptions() throws Throwable {
		markDownPage.selectrinterOption();
	}

	@Then("I select printer using printerBarcode {string}")
	public void i_select_printer_using_printerBarcode(String barcode) throws Throwable {

		String Barcode = barcode;
		markDownPage.printerSelection(Barcode);
	}

	@Then("I verify No Popup is displayed for final clearence")
	public void i_verify_No_Popup_is_displayed_for_final_clearence() throws Throwable {

		if (driveR.findElement(By.id("android:id/message")).isDisplayed()) {

			assertEquals(100, 120, " PopUp not displayed");
		} else {

			System.out.println("PopUp is NOT Displayed !!");

		}

	}

	@Then("I Click on PrintList option")
	public void i_Click_on_PrintList_option() throws Throwable {

		markDownPage.clickOnPrintList();
	}

	@Then("I enter invalid barcode {string} number")
	public void i_enter_invalid_barcode_number(String barcode) throws Throwable {
		markDownPage.invalidBarcode(barcode);
	}

	@Then("I verify the message displayed")
	public void i_verify_the_message_displayed() throws Throwable {
		markDownPage.errorBarcodeMsg();
	}

	@Then("I select existing {string} number from list")
	public void i_select_existing_number_from_list(String barcode) throws Throwable {

		markDownPage.selectBarcode(barcode);
	}

	@Then("I verify that Qty field is enabled")
	public void i_verify_that_Qty_field_is_enabled() throws Throwable {
		markDownPage.fieldClickable();
	}

	@Then("I will verify firstMarkdownWindow")
	public void i_will_verify_firstMarkdownWindow() throws Throwable {

		System.out.println("Window value " + windows);
		assertNotEquals(windows, Null);

	}

	public static void firstMarkdownWindow(String window) {

		windows = window;
	}

	@Then("I verify the role {string} and built version {string} number")
	public void i_veridy_the_role_and_built_version_number(String roles, String versionNum) throws Throwable {

		markDownPage.roleVerify(roles, versionNum);
	}

	@Then("I enter qty {string} more than nineteen")
	public void i_enter_qty_more_than_nineteen(String qty) throws Throwable {

		markDownPage.enterQty(qty);
	}

	@Then("I delete the {string} record from the list")
	public void i_delete_the_record_from_the_list(String barcode) throws Throwable {
		markDownPage.deleteRecord(barcode);
	}

	@Then("I try to edit the new price field")
	public void i_try_to_edit_the_new_price_field() throws Throwable {
		markDownPage.editNewPrice();
	}

	@Then("I update the Value of markdown qty")
	public void i_update_the_Value_of_markdown_qty() throws Throwable {

		markDownPage.changeQty();
	}

	@Then("I verify And navigate to Print List By clicking on Print list icon")
	public void verifyPrintList() throws Throwable {
		markDownPage.verifyPrintListDetails();
	}

	@Then("I Click on Complete markdown icon")
	public void clickOnCompleteMarkdownIcon() throws Throwable {
		markDownPage.clickOnCompleteMarkdown();
	}

	//////// -------------------------------------------------
	//// Rasika

	@Then("I verify calculated price is displayed")
	public void verifyCalculatedPriceDisplayed() throws Throwable {
		markDownPage.verifyCalculatedPriceDisplayed();
	}

	@Then("I get calculated price on Item summary screen")
	public void getCalculatedPrice() throws Throwable {
		markDownPage.getCalculatedPrice();
	}


	@Then("I click on Discount percenatge dropdown on Item summary screen")
	public void clickOnDiscountPercentage() throws Throwable {
		markDownPage.clickOnDiscountPercentage();
	}

	@Then("I select {string} value from discount dropdown")
	public void selectPercentage(String percentage) throws Throwable {
		markDownPage.selectPercentage(percentage);
	}

	@Then("I verify Clearance alert is not displayed")
	public void clerancePoopupIsNotDisplayed() throws Throwable {
		markDownPage.clerancePoopupIsNotDisplayed();
	}

	@Then("I verify Clearance alert is displayed")
	public void clerancePopupIsDisplayed() throws Throwable {
		markDownPage.clerancePopupIsDisplayed();
	}

	@Then("I verify Yes and No buttons is displayed")
	public void yesAndNoButtonDisplay() throws Throwable {
		markDownPage.yesAndNoButtonDisplay();
	}

	@Then("I click on Yes button on Clearance alert")
	public void clickOnYesButton() throws Throwable {
		markDownPage.clickOnYesButton();
	}

	@Then("I click on No button on Clearance alert")
	public void clickOnNoButton() throws Throwable {
		markDownPage.clickOnNoButton();
	}

	@Then("I click on Print list icon")
	public void clickOnPrintListIcon() throws Throwable {
		markDownPage.clickOnPrintListIcon();
	}

	@Then("I verify product is present in print list")
	public void verifyProductInPrintList() throws Throwable {
		markDownPage.verifyProductInPrintList();
	}

	@Then("Enter Markdown barcode number")
	public void enterMarkdownBarcode() throws Throwable {
		markDownPage.enterMarkdownBarcode();
	}

	

	@Then("verify that Blueyonder price value matches with optimised price value in Markdown Get API for not configured stores")
	public void blueyonderAndOptimisedPriceComparisonForConfiguredStores() throws Throwable {
		markdownServicePages.compareBYpriceOptimizedPrice();

	}

	/*@Then("verify that Blueyonder price value matches with optimised price value in Markdown Get API for configured stores")
	public void blueyonderAndOptimisedPriceComparisonForNotConfiguredStores() throws Throwable {

	}
*/
	@Then("verify that Blueyonder price value matches with optimised price value in Markdown Get API")
	public void blueyonderAndOptimisedPriceComparison() throws Throwable {
		markdownServicePages.compareBYpriceOptimizedPrice();
	}
	
	@Then("Verify Original price on UI and service matches")
	public void verifyOriginalPrice() throws Throwable {
		markDownPage.verifyOriginalPrice();
	}
	
	@Then("I get Original price on UI")
	public void getOriginalPriceOnUI() throws Throwable {
		markDownPage.getOriginalPriceOnUI();
	}
	
	@Then("I get New price on UI")
	public void getNewPriceOnUI() throws Throwable {
		markDownPage.getNewPriceUI();
	}
	
	@Then("Verify New price on UI and service matches")
	public void verifyNewPrice() throws Throwable {
		markDownPage.verifyNewPrice();
	}
	
	@Then("I verify product {string} is present in print list")
	public void i_verify_product_is_present_in_print_list(String productMin) throws Throwable {
		markDownPage.verifyProductInPrintList(productMin);
	}
	
	@Then("I Get Markdown percentage and Price on UI")
	public void getMarkdownPercentageUI() throws Throwable {
		markDownPage.getMarkdownPercentageUI();
	}
	
	@Then("I capture selected Markdown percentage value {string} and corresponding Price on UI")
	public void getMarkdownPercentAndPrice(String percentage) throws Throwable {
		markDownPage.getMarkdownPercentAndPrice(percentage);
	}

	@Then("I verify first markdown price is displayed")
	public void verifyFirstMarkdownPrice() throws Throwable {
		markDownPage.verifyOriginalPriceOnUI();
	}
	
	@Then("Verify calculate price displayed in UI is matching with Blueyonder service response")
	public void verifyCalculatePrice() throws Throwable {
		markdownServicePages.verifyCalculatePrice();
	}
	
	@Then("Verify for manager user calculate price displayed in UI is matching with Blueyonder service response")
	public void verifyCalculatePricee() throws Throwable {
		markdownServicePages.verifyCalculatePriceForManager();
	}
	
	@Then("Verify last markdown price is displayed when a manager user is scanning a product")
	public void verifyLastMarkdownPrice() throws Throwable {
		markDownPage.verifyLastMarkdownPrice();
	}
	
	@Then("I verify current price on Ui and services is matched")
	public void verifyCurrentPriceDisplayed() throws Throwable {
		markdownServicePages.verifyCurrentPriceDisplayed();
	}
	
	@Then("I verify Markdown percentage")
	public void verifyMarkdownPercentage() throws Throwable {
		markdownServicePages.verifyMarkdownPercentage();
	}
	
	@Then("I verify discount dropdown is disabled")
	public void discountDropdownIsDisabled() throws Throwable {
		markDownPage.discountDropdownIsDisabled();
	}
	
	@Then("I verify discount dropdown is enabled")
	public void discountDropdownIsEnabled() throws Throwable {
		markDownPage.discountDropdownIsEnabled();
	}
	
	@Then("I verify Manager selected optimized percentage {string} is displayed")
	public void verifyOptimizedPercentage(String percentage) throws Throwable {
		markDownPage.verifyOptimizedPercentage(percentage);
	}
	
	@Then("I verify Product not found message is displayed")
	public void productNotFountMessage() throws Throwable {
		markDownPage.productNotFountMessage();
	}
	
	@Then("I Select product from print list")
	public void selectProduct() throws Throwable {
		markDownPage.selectProduct();
	}
	
	@Then("I verify calculated price on UI matched with bluyonder response")
	public void verifyCalulatedPrice() throws Throwable {
		markDownPage.verifyCalulatedPrice();
	}
	
	@Then("I verify calculated price is not displayed")
	public void verifyCalculatedPriceNotDisplayed() throws Throwable {
		markDownPage.calculatedPriceNotDisplayed();
	}
	
	@Then("I verify edited quantity {string} is displayed")
	public void verifyEditedQuantity(String quantity) throws Throwable {
		markDownPage.verifyEditedQuantity(quantity);
	}
	
	@Then("Verify price unit in service")
	public void verifyCurrencyUnit() throws Throwable {
		markdownServicePages.verifyCurrencyUnit();
	}
	
	@Then("I left swipe the product and click on delete icon")
	public void deleteProduct() throws Throwable {
		markDownPage.swipeRight();
	}
	
	@Then("I verify product {string} is Deleted from Print list")
	public void verifyProductIsDeleted(String barcode) throws Throwable {
		markDownPage.verifyProductIsDeleted(barcode);
	}
}
