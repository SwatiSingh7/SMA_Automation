package com.morrisons.sma.step_definitions.mobile.old;

import com.morrisons.sma.page_objects.mobile.old.CleanAndRotatePO;
import com.morrisons.sma.page_objects.mobile.old.FreshCodeCheckPO;
import com.morrisons.sma.page_objects.mobile.old.MarkDownPO;
import com.morrisons.sma.page_objects.mobile.old.MarketstreetGlhPO;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FreshCodeCheckStepDefUI {
	
	FreshCodeCheckPO freshCodeCheckPO = new FreshCodeCheckPO();
	MarketstreetGlhPO mrktstrt = new MarketstreetGlhPO();
	MarkDownPO markDownPage = new MarkDownPO();
	CleanAndRotatePO cnRpageObjects = new CleanAndRotatePO();
/////// Shrutika

	@Then("I verify {string} status")
	public void i_verify_status(String Submenu) throws Throwable {
		freshCodeCheckPO.verifySubmenuStatus(Submenu);
	}

	@Then("I verify Reduction Bay AM status as {string}")
	public void i_verify_Reduction_Bay_AM_status_as(String status) throws Throwable {
		freshCodeCheckPO.verifyAMStatus(status);
	}

	@Then("I verify Reduction Bay PM status as {string}")
	public void i_verify_Reduction_Bay_PM_status_as(String status) throws Throwable {
		freshCodeCheckPO.verifyPMStatus(status);
	}

	@Then("I click on Button {string}")
	public void i_click_on_Button(String Button) throws Throwable {
		freshCodeCheckPO.iclickonButton(Button);
	}

	@Then("I verify Popup message Not displayed")
	public void i_verify_Pop_message_Not_displayed() throws Throwable {
		freshCodeCheckPO.popupnotDisplayed();
	}

	@Then("I verify {string} page")
	public void i_verify_page(String Screen) throws Throwable {
		freshCodeCheckPO.verifyScreen(Screen);
	}

	@Then("I verify status as {string}")
	public void i_verify_status_as(String Status) throws Throwable {
		freshCodeCheckPO.verifyStatus(Status);
	}

	@Then("I verify Popup message displayed")
	public void i_verify_Pop_message_displayed() throws Throwable {
		freshCodeCheckPO.popupDisplayed();
	}

	@Then("I verify Popup message displayed for PM check")
	public void i_verify_Pop_message_displayed_PM() throws Throwable {
		freshCodeCheckPO.popupPMDisplayed();
	}

	@Then("I click Cancel")
	public void i_click_Cancel() throws Throwable {
		freshCodeCheckPO.clickCancel();
	}

	@Then("I navigate back to {string}")
	public void i_navigate_back_to(String Menu) throws Throwable {
		freshCodeCheckPO.navigatebacktomenu(Menu);
	}

	@Then("I click Continue")
	public void i_click_Continue() throws Throwable {
		freshCodeCheckPO.clickContinue();
	}

	@Then("I verify Screen message displayed")
	public void i_verify_Screen_message_displayed() throws Throwable {
		freshCodeCheckPO.verifyScreenmsg();
	}

	@Then("I click Log Product")
	public void i_click_Log_Product() throws Throwable {
		freshCodeCheckPO.clicklogproduct();
	}

	// @Then("I verify Wastage reason code from popup")
	// public void i_verify_Wastage_reason_code_from_popup() throws Throwable {
	// // Write code here that turns the phrase above into concrete actions
	// throw new PendingException();
	// }

	@Then("I capture product details")
	public void i_capture_product_details() throws Throwable {
		freshCodeCheckPO.getProductDetail();
	}

	@Then("I select {string} and Confirm")
	public void i_select_and_Confirm(String wastagecode) throws Throwable {
		freshCodeCheckPO.clickWastagecode(wastagecode);
	}

	@Then("I verify fields are not editable")
	public void i_verify_fields_are_not_editable() throws Throwable {
		freshCodeCheckPO.verifyfieldnoteditable();
	}

	@Then("I reopen Reduction Bay Check")
	public void i_reopen_Reduction_Bay_Check() throws Throwable {
		freshCodeCheckPO.reopenReductionBay();
		mrktstrt.clickBackButton();
	}

	@Then("I Delete products")
	public void i_Delete_products() throws Throwable {

		freshCodeCheckPO.deleteProduct();
	}

	@Then("I Delete products in critical check")
	public void i_Delete_productsCC() throws Throwable {

		freshCodeCheckPO.deleteProductincriticalcheck();

	}

	// ##############################################################-DaliySchedule-##############

	@Then("I select {string}")
	public void i_select(String productgroup) throws Throwable {
		freshCodeCheckPO.scrollToProductgroup(productgroup);
	}

	@Then("I verify list of nine schedule days")
	public void i_verify_list_of_nine_schedule_days() throws Throwable {
		freshCodeCheckPO.verifyScheduledays();
	}

	@Then("I select current day date")
	public void i_select_current_day_date() throws Throwable {
		freshCodeCheckPO.selectCurrentDay();
	}

	@Then("I verify my product displayed in view list")
	public void i_verify_my_product_displayed_in_view_list() throws Throwable {
		freshCodeCheckPO.verifyProductinviewlist();
	}

	@Then("I select rating and confirm")
	public void i_select_rating_and_confirm() throws Throwable {
		freshCodeCheckPO.setRatinggood();
	}

	@Then("I verify Counts and Rating")
	public void i_verify_Counts_of_Markdown_Wastage_RTF_and_Rotation_Rating() throws Throwable {
		freshCodeCheckPO.verifyCountnRating();
	}

	@Then("I reopen department {string}")
	public void i_reopen_department(String dept) throws Throwable {
		freshCodeCheckPO.reopenTheDepartment(dept);

	}

	@Then("I verify Pop Message for invalide Schedule")
	public void i_verify_Pop_Message_for_invalide_Schedule() throws Throwable {
		freshCodeCheckPO.verifypopmsgforinvalid();
	}

	@Then("I Confirm prompt for Ambient product")
	public void i_Confirm_prompt_for_Ambient_product() throws Throwable {
		freshCodeCheckPO.verifynConfirmAmbientpromt();
	}

	@Then("I verify department screnn remain same")
	public void i_verify_department_screnn_remain_same() throws Throwable {
		freshCodeCheckPO.verifydepartmentscreen();
	}

	@Then("I verify non-ranged product and continue")
	public void i_verify_Pop_message_for_non_ranged_product_and_continue() throws Throwable {
		freshCodeCheckPO.setProductlocation();
	}

	@Then("I verify redirect to Critical check")
	public void i_verify_redirect_to_Critical_check() throws Throwable {
		freshCodeCheckPO.verifyCriticalCheck();
	}

	@Then("I verify and confirm pop up message for promotions")
	public void i_verify_and_confirm_pop_up_message_for_promotions() throws Throwable {
		freshCodeCheckPO.verifyPromotionCompletepopup();
	}

	@Then("I verify promotion status {string}")
	public void i_verify_promotion_status(String status) throws Throwable {
		freshCodeCheckPO.verifyPromotionStatus(status);
	}

	@Then("I verify and confirm pop up message for warehouse")
	public void i_verify_and_confirm_pop_up_message_for_warehouse() throws Throwable {
		freshCodeCheckPO.verifyWarehouseCompletepopup();
	}

	@Then("I verify warehouse status {string}")
	public void i_verify_warehouse_status(String status) throws Throwable {
		freshCodeCheckPO.verifyWarehouseStatus(status);
	}

	// @Then("I Complete code rotate for all the department")
	// public void i_Complete_code_rotate_for_all_the_department() throws
	// Throwable {
	// // Write code here that turns the phrase above into concrete actions
	// throw new PendingException();
	// }

	@Then("I verify Critical checks status {string}")
	public void i_verify_Critical_checks_status(String status) throws Throwable {
		freshCodeCheckPO.verifyCriticalCheckStatus(status);
	}

	///////////////////////////////////////////////////////// Summary Screen
	///////////////////////////////////////////////////////// /////////////////////////////////////////////////////

	@Then("I verify Total wastage, wastage amount in pound is displayed")
	public void i_verify_Total_wastage_wastage_amount_in_pound_is_displayed() throws Throwable {
		freshCodeCheckPO.verifySummaryTotalwastage();
	}

	@Then("I verify Escalations and below text is displayed")
	public void i_verify_Escalations_and_below_text_is_displayed() throws Throwable {
		freshCodeCheckPO.verifyEscalations();

	}

	@Then("I verify department name,wastage qty and amount is displayed")
	public void i_verify_department_name_wastage_qty_and_amount_is_displayed() throws Throwable {
		freshCodeCheckPO.verifynameqtyamount();
	}

	@Then("I click past day date")
	public void i_click_past_day_date() throws Throwable {
		freshCodeCheckPO.clickOverduedate();
	}

	@Then("I click past {string} day date")
	public void i_click_past_daterange_day_date(int date) throws Throwable {
		freshCodeCheckPO.selectCurrentDay1(date);
	}

	@Then("I verify escalations listed with View/Incomplete")
	public void i_verify_escalations_listed_with_View_Incomplete_Add_escalation_scenarions_for_day() throws Throwable {
		freshCodeCheckPO.verifyEscalationlist();
	}

	@Then("I open {string} status escalation")
	public void i_open_status_escalation(String status) throws Throwable {
		freshCodeCheckPO.clickViewstatusescaltion(status);
	}

	@Then("I verify Next steps Page Header")
	public void i_verify_Next_steps_Page_Header() throws Throwable {
		freshCodeCheckPO.verifynextstep();
	}

	@Then("I verify Aisle Information")
	public void i_verify_Aisle_Information() throws Throwable {
		freshCodeCheckPO.verifyAisleinfo();
	}

	@Then("I verify Details of Problem Found")
	public void i_verify_Details_of_Problem_Found() throws Throwable {
		freshCodeCheckPO.verifyProblemfound();
	}

	@Then("I verify prompt for next step")
	public void i_verify_prompt_for_next_step() throws Throwable {
		freshCodeCheckPO.verifypromtcompleteEscalation();
	}

	@Then("I verify and select Investigation details")
	public void i_verify_and_select_Investigation_details() throws Throwable {
		freshCodeCheckPO.verifyInvestigationdetails();
	}

	@Then("I verify and select Next Steps")
	public void i_verify_and_select_Next_Steps() throws Throwable {
		freshCodeCheckPO.verifynextstepdetails();
	}

	@Then("I verify redirection to escalation list")
	public void i_verify_redirection_to_escalation_list() throws Throwable {
		freshCodeCheckPO.verifyredirectedtoEscalationlist();
	}

	@Then("I click edit icon")
	public void i_click_edit_option() throws Throwable {
		freshCodeCheckPO.clickEditicon();
	}

	@Then("I click delete option")
	public void i_click_delete_option() throws Throwable {
		freshCodeCheckPO.clickDeleteicon();
	}

	@Then("I click on product and department level")
	public void i_click_on_product_and_department() throws Throwable {
		freshCodeCheckPO.clickSummaryproductdepartment();
	}

	@Then("I verify product list is displayed")
	public void i_verify_product_list_is_displayed() throws Throwable {
		freshCodeCheckPO.escalationProductList();
		mrktstrt.clickBackButton();
	}

	@Then("I select and verify aisles under Department is displayed")
	public void i_select_and_verify_aisles_under_Department_is_displayed() throws Throwable {
		freshCodeCheckPO.verifyaisleunderdepartment();
	}

	@Then("I click Afternoon Checks tab")
	public void i_click_second_check_tab() throws Throwable {
		freshCodeCheckPO.clickSecondchecktab();
	}

	@Then("I click FM check tab")
	public void i_click_FM_check_tab() throws Throwable {
		freshCodeCheckPO.clickFMchecktab();
	}

	@Then("I verify weekly sign off screen details and checkbox displayed")
	public void i_verify_weekly_sign_off_screen_details_and_checkbox_displayed() throws Throwable {
		freshCodeCheckPO.verifySignoffdetailscreen();
	}

	@Then("I click on product level")
	public void i_click_on_product_level() throws Throwable {
		freshCodeCheckPO.clickSummaryproductlist();
	}

	@Then("I select Details of Problem Found")
	public void i_select_Details_of_Problem_Found() throws Throwable {
		freshCodeCheckPO.selectproblemfound();
	}
	

	/// --------------------------------------------------------------------------------------------------

	///// Rasika

	@Then("I verify Critical Check,Fixture,Promotion and Warehouse are displayed")
	public void verifyMenus() throws Throwable {
		freshCodeCheckPO.verifyMenus();
	}

	@Then("I verify Aisle list is displayed")
	public void verifyAisleListDisplayed() throws Throwable {
		freshCodeCheckPO.verifyAisleListDisplayed();
	}

	@Then("I click on Cuurent date Schedule")
	public void clickOnCurrentSchedule() throws Throwable {
		freshCodeCheckPO.clickOnCurrentSchedule();
	}

	@Then("I click on Overdue date Schedule")
	public void clickOnPreviousOverdueSchedule() throws Throwable {
		freshCodeCheckPO.clickOnPreviousOverdueSchedule();
	}
	
	@Then("I click on Day Schedule")
	public void clickOnDaySchedule() throws Throwable {
		freshCodeCheckPO.clickOnDaySchedule();
	}

	@Then("I verify corresponding departments are displayed")
	public void verifyDeptListIsDisplayed() throws Throwable {
		freshCodeCheckPO.verifyDeptListDisplayed();
	}

	@Then("I enter Product Min {string}")
	public void enterMin(String arg1) throws Throwable {
		freshCodeCheckPO.enterMin(arg1);
	}

	@Then("I verify Next scan date is displayed")
	public void verifyNextScanDate() throws Throwable {
		freshCodeCheckPO.verifyNextScanDate();
	}

	@Then("I click on plus Log product button on Product detail page")
	public void clickOnLogProduct() throws Throwable {
		freshCodeCheckPO.clickOnLogProduct();
	}

	@Then("I click on Complete Code Check button")
	public void clickOnCompleteCodeCheck() throws Throwable {
		freshCodeCheckPO.clickOnCompleteCodeCheck();
	}

	@Then("I select rating option as {string}")
	public void clickOnRatings(String rating) throws Throwable {
		freshCodeCheckPO.clickOnRatings(rating);
	}

	@Then("I click on Reopen Complete Code Check button")
	public void clickOnReopenCodeRotate() throws Throwable {
		freshCodeCheckPO.clickOnReopenCodeRotate();
	}

	@Then("I verify on Reopen Complete Code Check alert")
	public void clickOnReopenCodeRotateAlert() throws Throwable {
		freshCodeCheckPO.clickOnReopenCodeRotateAlert();
	}

	@Then("I click on Yes option on Reopen Complete Code Check alert")
	public void clickOnYesReopenCode() throws Throwable {
		freshCodeCheckPO.clickOnYesReopenCode();
	}

	@Then("I click on No option on Reopen Complete Code Check alert")
	public void clickOnNoReopenCode() throws Throwable {
		freshCodeCheckPO.clickOnNoReopenCode();
	}

	@Then("I verify Complete promotion button is displayed")
	public void verifyCompletePromotion() throws Throwable {
		freshCodeCheckPO.verifyCompletePromotion();
	}

	@Then("I click on Complete promotions button")
	public void clickOnCompletePromotions() throws Throwable {
		freshCodeCheckPO.clickOnCompletePromotions();
	}

	@Then("I verify Cancel and Contiue buttons are present")
	public void verifyCancelContinueButton() throws Throwable {
		freshCodeCheckPO.verifyCancelContinueButton();
	}

	@Then("I click on Reopen promotions button")
	public void clickOnReopenPromotions() throws Throwable {
		freshCodeCheckPO.clickOnReopenPromotions();
	}

	@Then("I verify on Reopen Warehouse alert")
	public void clickOnReopenWarehouseAlert() throws Throwable {
		freshCodeCheckPO.verifyReopenWarehouseAlert();
	}
	
	@Then("I verify on Reopen Promotions alert")
	public void verifyReopenPromotionAlert() throws Throwable {
		freshCodeCheckPO.verifyReopenPromotionAlert();
	}

	@Then("I verify Complete warehouse button is displayed")
	public void verifyCompleteWarehouse() throws Throwable {
		freshCodeCheckPO.verifyCompleteWarehouse();
	}

	@Then("I click on Complete warehouse button")
	public void clickOnCompleteWarehouse() throws Throwable {
		freshCodeCheckPO.clickOnCompleteWarehouse();
	}

	@Then("I click on Reopen warehouse button")
	public void clickOnReopenWarehouse() throws Throwable {
		freshCodeCheckPO.clickOnReopenWarehouse();
	}

	@Then("I verify only One wastage code options are dispayed")
	public void verifyOneWastageCode() throws Throwable {
		freshCodeCheckPO.verifyOneWastageCode();
	}

	@Then("I verify Three wastage code options are dispayed")
	public void verifyThreeWastageCode() throws Throwable {
		freshCodeCheckPO.verifyThreeWastageCode();
	}

	@Then("I verify Complete Code Check button is displayed")
	public void verifyCompleteCodeCheck() throws Throwable {
		freshCodeCheckPO.verifyCompleteCodeCheck();
	}

	@Then("I verify Rotation ratings page is displayed")
	public void verifyRatingsPageDisplayed() throws Throwable {
		freshCodeCheckPO.verifyRatingsPageDisplayed();
	}

	@Then("I verify Department is Completed for product {string}")
	public void verifyCompletedDetails(String productTitle) throws Throwable {
		freshCodeCheckPO.verifyCompletedDetails(productTitle);
	}

	@Then("I complte all the Aisles")
	public void completeAllAisle() throws Throwable {
		freshCodeCheckPO.completeAllAisle();
	}
	
	@Then("I complte the department with Poor rating")
	public void completeWithPoorRating() throws Throwable {
		freshCodeCheckPO.completeWithPoorRating();
	}

	@Then("I verify Reopen Complete Code Check button is displayed")
	public void verifyReopenCodeRotate() throws Throwable {
		freshCodeCheckPO.verifyReopenCodeRotate();
	}

	@Then("I Verify Scanned itemm {string} is visible on view list")
	public void verifyTheMINN(String productMin) throws Throwable {
		freshCodeCheckPO.verifyScannedMin(productMin);
	}

	@Then("I Verify for Scanned itemm {string} action performed as {string} is visible on view list")
	public void verifyScannedItemActionUI(String productMin, String expectedAction) throws Throwable {
		freshCodeCheckPO.verifyScannedItemActionUI(productMin, expectedAction);
	}

	@Then("I Verify Scanned itemm {string} is visible on Critical check page")
	public void verifyTheMINNCriticlCheck(String productMin) throws Throwable {
		freshCodeCheckPO.verifyScannedMin(productMin);
	}

	@Then("I Verify for Scanned itemm {string} action performed as {string} is visible on Critical check page")
	public void verifyActionCriticlCheck(String productMin, String expectedAction) throws Throwable {
		freshCodeCheckPO.verifyActionCriticlCheck(productMin, expectedAction);
	}

	@Then("I verify Not ranged product alert")
	public void verifyProductNotRangedAlert() throws Throwable {
		freshCodeCheckPO.verifyProductNotRangedAlert();
	}

	@Then("Verify product {string} is deleted from Critical check list")
	public void verifyProductIsDeleted(String productMin) throws Throwable {
		freshCodeCheckPO.verifyProductIsDeleted(productMin);
	}
	
	@Then("I verify after scanning Ambient product {string} message is displayed")
	public void verifyAmbientProductMsg(String message) throws Throwable {
		freshCodeCheckPO.verifyAmbientProductMsg(message);
	}
	
	
	@Then("I verify {string} status is {string}")
	public void verifyStatus(String dept,String status) throws Throwable {
		freshCodeCheckPO.verifyStatus(dept,status);
	}
	
	@Then("I get {string} status")
	public void getStatus(String dept) throws Throwable {
		freshCodeCheckPO.getStatus(dept);
	}
	
	@Then("I verify {string} status {string} is displayed on UI")
	public void verifyCheckStatus(String check,String status) throws Throwable {
		freshCodeCheckPO.verifyCheckStatus(check,status);
	}

	@Then("I click on Continue button on Not ranged product alert")
	public void clickOnContinue() throws Throwable {
		freshCodeCheckPO.clickOnContinue();
	}

	@Then("I click on Continue button on alert")
	public void clickOnContinueAlert() throws Throwable {
		freshCodeCheckPO.clickOnContinue();
	}

	@Then("I click on Cancel button on Not ranged product alert")
	public void clickOnCancel() throws Throwable {
		freshCodeCheckPO.clickOnCancel();
	}

	@Then("I verify page is remain on enter product action detail page")
	public void verifyActionDetailPage() throws Throwable {
		freshCodeCheckPO.verifyActionDetailPage();
	}

	@Then("I verify page is navigated to location page")
	public void verifyLocationPage() throws Throwable {
		freshCodeCheckPO.verifyLocationPage();
	}

	@Then("I enter location details and click on continue")
	public void enterLocationDetails() throws Throwable {
		freshCodeCheckPO.enterLocationDetails();
	}

	//////////// FCC phase 2

	@Then("I verify Fresh code chech completion with 7 day titles are displayed")
	public void verifySevenDayTitles() throws Throwable {
		freshCodeCheckPO.verifySevenDayTitles();
	}

	@When("I click on Fresh check code completion")
	public void clickOnFreshCheckCodeCompletion() throws Throwable {
		freshCodeCheckPO.clickOnFreshCheckCodeCompletion();
	}

	@Then("I verify Summary screen is displayed")
	public void verifySummaryScreen() throws Throwable {
		freshCodeCheckPO.verifySummaryScreen();
	}

	@Then("I verify three tabs Checks, Categories and Escalations are displayed")
	public void verifyThreeTabsOnSummary() throws Throwable {
		freshCodeCheckPO.verifyThreeTabsOnSummary();
	}

	@Then("I verify Date schedules are displayed")
	public void verifyDateSchedules() throws Throwable {
		freshCodeCheckPO.verifyDateSchedules();
	}

	@Then("I verify lists of Checks with checkbox are displayed")
	public void verifyListOfChecksWithCheckbox() throws Throwable {
		freshCodeCheckPO.verifyListOfChecksWithCheckbox();
	}

	@Then("I click on Check completion filter symbol")
	public void clickOnCheckCompletionfilter() throws Throwable {
		freshCodeCheckPO.clickOnCheckCompletionfilter();
	}

	@Then("I verify All checks, completed checks and Incomplete checks options are displayed")
	public void verifyAllCheckOptionsDisplayed() throws Throwable {
		freshCodeCheckPO.verifyAllCheckOptionsDisplayed();
	}

	@Then("I click on All checks option from Check completion filter")
	public void clickOnAllChecksOption() throws Throwable {
		freshCodeCheckPO.clickOnAllChecksOption();
	}

	@Then("I verify screen should display all the list of checks completed or Incomplete")
	public void verifyAllChecksList() throws Throwable {
		freshCodeCheckPO.verifyAllChecksList();
	}

	@Then("I click on Completed checks option from Check completion filter")
	public void clickOnCompleteChecks() throws Throwable {
		freshCodeCheckPO.clickOnCompleteChecks();
	}

	@Then("I verify screen should display only the list of checks which are completed")
	public void verifyCompleteChecks() throws Throwable {
		freshCodeCheckPO.verifyCompleteChecks();
	}

	@Then("I click on Incomplete checks option from Check completion filter")
	public void clickOnIncompleteChecks() throws Throwable {
		freshCodeCheckPO.clickOnIncompleteChecks();
	}

	@Then("I verify screen should display only the list of checks which are Incomplete")
	public void verifyIncompleteChecks() throws Throwable {
		freshCodeCheckPO.verifyIncompleteChecks();
	}

	@Then("I verify Out of Code-First Check Waste with top three departments according to wastage qty which belongs to first check along with there qty and wastage amount are displayed")
	public void verifyOutOfCodeFirstCheckDept() throws Throwable {
		freshCodeCheckPO.verifyTopThreeDept();
	}

	@Then("I click on Out of Code-First Check Waste on summary screen")
	public void clickOnOutOfCodeFirstCheck() throws Throwable {
		freshCodeCheckPO.clickOnOutOfCodeFirstCheck();
	}

	@Then("I verify Daily check, Afternoon Check, FM Check and Code Alerts")
	public void verifyCategoryCompletionTabs() throws Throwable {
		freshCodeCheckPO.verifyCategoryCompletionTabs();
	}

	@Then("I verify Category completion with list of departments with quantity and price are displayed")
	public void verifyCategoryCompletionDeptList() throws Throwable {
		freshCodeCheckPO.verifyCategoryCompletionDeptList();
	}

	@Then("I click on Category completion sorting symbol")
	public void clickCategoryCompletionSorting() throws Throwable {
		freshCodeCheckPO.clickCategoryCompletionSorting();
	}

	@Then("I click on Category completion sorting symbol to close the filter")
	public void closeCategoryCompletionSorting() throws Throwable {
		freshCodeCheckPO.clickCategoryCompletionSorting();
	}

	@Then("I verify two sorting orders Lowest to Highest Price and Highest to Lowest Price are displayed")
	public void verifyTwoSortingOrders() throws Throwable {
		freshCodeCheckPO.verifyTwoSortingOrders();
	}

	@Then("I verify in the list of departments the sorting order should be, by default Critical Checks would be first, Promotions would be second and Warehouse would be third")
	public void verifyDeptListSortingOrder() throws Throwable {
		freshCodeCheckPO.verifyDeptListSortingOrder();
	}

	@Then("I verify Product list is displayed")
	public void verifyProductListDisplayed() throws Throwable {
		freshCodeCheckPO.verifyProductListDisplayed();
	}

	@Then("I verify Out of Code-First Check Waste on summary screen is displayed")
	public void verifyOutOfCodeFirstCheckDisplayed() throws Throwable {
		freshCodeCheckPO.verifyOutOfCodeFirstCheckDisplayed();
	}

	@Then("I click on any department")
	public void clickOnAnyDept() throws Throwable {
		freshCodeCheckPO.clickOnAnyDept();
	}

	@Then("I verify list of aisles under respective department with rotation rating details are displayed")
	public void verifyListOfAisles() throws Throwable {
		freshCodeCheckPO.verifyListOfAisles();
	}
	
	@Then("I click on Daily check tab on Category completion table")
	public void clickOnDailyCheckTab() throws Throwable {
		freshCodeCheckPO.clickOnDailyCheckTab();
	}

	@Then("I click on Afternoon check tab on Category completion table")
	public void clickOnAfternoonCheckTab() throws Throwable {
		freshCodeCheckPO.clickOnAfternoonCheckTab();
	}

	@Then("I click on FM check tab on Category completion table")
	public void clickOnFMCheckTab() throws Throwable {
		freshCodeCheckPO.clickOnFMCheckTab();
	}

	@Then("I verify below Out of Code - Daily Checks Waste label, department list is displayed")
	public void verifyLabelBelowOutOfCode() throws Throwable {
		freshCodeCheckPO.verifyLabelBelowOutOfCode();
	}


	@Then("I verify top 3 First Check departments which has maximum quantity actioned as Wastage with wastage quantity and wasted price are displayed")
	public void verifyTopThreeDept() throws Throwable {
		freshCodeCheckPO.verifyTopThreeDept();
	}

	@Then("I click on any department on list")
	public void clickOnAnyDeptList() throws Throwable {
		freshCodeCheckPO.clickOnAnyDeptList();
	}

	@When("I verify {string} is displayed with status as 'Awaiting Sign-Off'")
	public void verifyAwaitingSignOffStatus(String menu) throws Throwable {
		freshCodeCheckPO.verifyAwaitingSignOffStatus(menu);
	}

	@Then("I verify Sign off button is displayed")
	public void verifySignOffBtnDisplayed() throws Throwable {
		freshCodeCheckPO.verifySignOffBtnDisplayed();
	}

	@Then("I click on Sign off button")
	public void clickOnSignOffButton() throws Throwable {
		freshCodeCheckPO.clickOnSignOffButton();
	}
	
	@Then("I verify content on Sign off page")
	public void verifySignOfPageContent() throws Throwable {
		freshCodeCheckPO.verifySignOfPageContent();
	}
	
	@Then("I verify Previous week is Sign off")
	public void verifyPreviousWeekSignOff() throws Throwable {
		freshCodeCheckPO.verifyPreviousWeekSignOff();
	}
	
	@Then("I verify Week status is Sign off")
	public void verifyWeekStatusSignOff() throws Throwable {
		freshCodeCheckPO.verifyWeekStatusSignOff();
	}
	
	@Then("I select all checkboxes on Sign off page")
	public void selectSignOffCheckboxes() throws Throwable {
		freshCodeCheckPO.selectSignOffCheckboxes();
	}

	@Then("I verify summary page header should display previous week date range along with status as 'Awaiting Sign-Off'")
	public void summaryPageHeader() throws Throwable {
		freshCodeCheckPO.summaryPageHeader();
	}

	@Then("I verify Escalations with status as 'View' and message are displayed")
	public void escalationsViewStatusAndMsg() throws Throwable {
		freshCodeCheckPO.escalationsViewStatusAndMsg();
	}
	
	@Then("I click on Escalations Section on summary page")
	public void clickOnEscalationOnSummary() throws Throwable {
		freshCodeCheckPO.clickOnEscalationOnSummary();
	}


	@Then("I verify Total Wastage Amount in £ Pound symbol is displayed")
	public void verifyTotalWastageAmount() throws Throwable {
		freshCodeCheckPO.verifyTotalWastageAmount();
	}

	@Then("I click on Escalations tab")
	public void clickOnEscalationsTab() throws Throwable {
		freshCodeCheckPO.clickOnEscalationsTab();
	}
	
	@Then("I verify Escalations page is displayed")
	public void verifyEscalationsPage() throws Throwable {
		freshCodeCheckPO.verifyEscalationsPage();
	}

	@Then("I verify Escalations list with details is displayed")
	public void verifyEsacalationlistWithDetails() throws Throwable {
		freshCodeCheckPO.verifyEscalationsList();
	}

	@Then("I click on day schdule for Current week")
	public void clickOnCurrentWeekDay() throws Throwable {
		freshCodeCheckPO.clickOnCurrentWeekDay();
	}
	
	@Then("I select day from the Day schedule list")
	public void selectDaySchedule() throws Throwable {
		freshCodeCheckPO.selectDaySchedule();
	}

	@Then("I verify Escalations with status as View/Incomplete status are displayed")
	public void verifyEscalationsList() throws Throwable {
		freshCodeCheckPO.verifyEscalationsList();
	}

	@Then("I select one escalations with Incomplete status")
	public void selectIncompleteEscalations() throws Throwable {
		freshCodeCheckPO.selectIncompleteEscalations();
	}

	@Then("I verify Next steps screen is displayed")
	public void verifyNextStepScreen() throws Throwable {
		freshCodeCheckPO.verifyNextStepScreen();
	}

	@Then("I click on Complete Escalations button")
	public void clickOnCompleteEscalationBtn() throws Throwable {
		freshCodeCheckPO.clickOnCompleteEscalationBtn();
	}

	@Then("I verify Complete next steps alert")
	public void verifyCompleteNextStepAlert() throws Throwable {
		freshCodeCheckPO.verifyCompleteNextStepAlert();
	}

	@Then("I click on Continue button on Complete next steps alert")
	public void clickOnContinueButton() throws Throwable {
		freshCodeCheckPO.clickOnContinueButton();
	}

	@Then("I added comment")
	 public void addComment() throws Throwable {
		freshCodeCheckPO.addTheComment();
	 }
	
	@Then("I edited the comment")
	 public void editComment() throws Throwable {
		freshCodeCheckPO.editTheComment();
	 }

	@When("I click on Save button")
	public void clickOnSaveButton() throws Throwable {
		freshCodeCheckPO.clickOnSaveButton();
	}

	@Then("I verify user is redirected to escalations list screen")
	public void verifyEscalationList() throws Throwable {
		freshCodeCheckPO.verifyEscalationList();
	}

	@Then("I verify respective escalation is at the top with latest edited details")
	public void verifyLatestEditedEscalation() throws Throwable {
		freshCodeCheckPO.verifyLatestEditedEscalation();
	}

	@Then("I click on View for one escalation from list")
	public void clickOnView() throws Throwable {
		freshCodeCheckPO.clickOnView();
	}
	
	@Then("I click on Escalation View button")
	public void clickOnEscalationView() throws Throwable {
		freshCodeCheckPO.clickOnView();
	}
	
	
	@Then("I verify user is not allowed to add or edit completed escalations")
	public void notAllowToEditEscalation() throws Throwable {
		freshCodeCheckPO.notAllowToEditEscalation();
	}

	@Then("I scroll down")
	public void scrollDown() throws Throwable {
		freshCodeCheckPO.scrollDown();
	}

	@Then("I edited comment")
	public void editTheComment() throws Throwable {
		freshCodeCheckPO.editTheComment();
	}

	@Then("I click on day schdule for Previous week")
	public void clickOnPreviousWeekDay() throws Throwable {
		freshCodeCheckPO.clickOnPreviousWeekDay();
	}

	@Then("I click on Categories tab")
	public void clickOnCategoriesTab() throws Throwable {
		freshCodeCheckPO.clickOnCategoriesTab();
	}

	@Then("I click on date")
	public void clickOnDate() throws Throwable {
		freshCodeCheckPO.clickOnDate();
	}

	@Then("I verify screen navigate to the Category Completion Summary screen of First Check")
	public void verifyCategoryCompletionSummary() throws Throwable {
		freshCodeCheckPO.verifyCategoryCompletionSummary();
	}

	@Then("I click on Checks tab")
	public void clickOnChecksTab() throws Throwable {
		freshCodeCheckPO.clickOnChecksTab();
	}

	@Then("I verify all Checks with Completion status checkbox are displayed")
	public void verifyChecksWithCheckbox() throws Throwable {
		freshCodeCheckPO.verifyChecksWithCheckbox();
	}

	@Then("I verify Hotekeys are displayed")
	public void verifyHotekeysDisplayed() throws Throwable {
		freshCodeCheckPO.verifyHotekeysDisplayed();
	}
	
	@Then("I verify scanned product min {string} is displayed")
	public void verifyProductMin(String min) throws Throwable {
		freshCodeCheckPO.verifyProductMin(min);
	}
	
	@Then("I verify previous day header status as {string}")
	public void verifyPreviousDayStatus(String status) throws Throwable {
		freshCodeCheckPO.verifyPreviousDayStatus(status);
	}
	
	@Then("I verify Day tiles with Day, Date and Wastage values are present")
	public void verifyDayTiles() throws Throwable {
		freshCodeCheckPO.verifyDayTiles();
	}
	
	@Then("I click on Day tile")
	public void clickOnDayTiles() throws Throwable {
		freshCodeCheckPO.clickOnDayTiles();
	}
	
	@Then("I click on alert Confirm button")
	public void clickOnConfirmButton() throws Throwable {
		freshCodeCheckPO.clickOnConfirmButton();
	}
	
	@Then("I click on Category completion button")
	public void clickOnCategoryCompletion() throws Throwable {
		freshCodeCheckPO.clickOnCategoryCompletion();
	}
	
	@Then("I complete all escalations on Escalations list")
	public void completeAllEscalations() throws Throwable {
		freshCodeCheckPO.completeAllEscalations();
	}
	
	@Then("I get all enabled dates on Calendar")
	public void getAllEnableDate() throws Throwable {
		freshCodeCheckPO.getAllEnableDate();
	}
	
	@Then("I verify Expiry date for {string} day store is Today's date")
	public void verifyExpiryDateIntra(String storeCategory) throws Throwable {
		freshCodeCheckPO.verifyExpiryDate(storeCategory);
	}
	
	@Then("I verify Expiry dates for {string} day store is Today's and Next day date")
	public void verifyExpiryDateNonIntra(String storeCategory) throws Throwable {
		freshCodeCheckPO.verifyExpiryDate(storeCategory);
	}
	
	@Then("I verify seperation between Short Life departments and Long Life departments are displayed")
	public void shortLongDept() throws Throwable {
		freshCodeCheckPO.shortLongDept();
	}
}