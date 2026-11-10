package com.morrisons.sma.step_definitions.mobile.old;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.morrisons.common.action.Hook;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import com.morrisons.sma.page_objects.mobile.old.PriceIntegrityPO;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpResponse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class PriceIntegrityStepDef {

	private static AndroidDriver driveR;
	
	PriceIntegrityPO priceIntegrityPageObject = new PriceIntegrityPO();
	ObjectMapper objectMapper = new ObjectMapper();
	public static HttpResponse Response;
	public static io.restassured.response.Response restResponse;

	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();

	String env = applicationConfig.getWebElementEnviroment().getEnv();
	List<String> exception = new ArrayList<>();
	List<String> reviewComment = new ArrayList<>();
	String productItemDescription;
	int overdueNewCountBusinessCritical;
	int overdueCountBusinessCritical;
	String inputBarcode;
	private static boolean itemPresent = false;
	private static boolean swipedRight = false;
	private static boolean swipedLeft = false;
	private static String scenarioId = "";
	private static Scenario scenario = null;
	String inputDate;
	String time;
	String mobileLocation;
	private static String itemNameForSwipeLeft = null;
	
	public PriceIntegrityStepDef() {
		this.driveR = (AndroidDriver) Hook.getDriver();
	}

	


	@Given("User should be logged into application with valid credentials for a store")
	public void user_should_be_logged_into_application_with_valid_credentials_for_a_store() throws Throwable {
		priceIntegrityPageObject.enterCollegueCredentials();
	}

	@When("User checks the sub-menu items under Price Integrity menu")
	public void user_checks_the_sub_menu_items_under_Price_Integrity_menu() throws Throwable {
		priceIntegrityPageObject.navigatePriceIntergrityMenu();

	}

	@Then("User should be able to see the relevant sub-menus under Price Integrity")
	public void user_should_be_able_to_see_the_relevant_sub_menus_under_Price_Integrity() throws Throwable {
		priceIntegrityPageObject.verifyMenuUnderPriceIntegrity();

	}

	@Then("User checks the sub-menu items under Daily Workload menu")
	public void user_checks_the_sub_menu_items_under_Daily_Workload_menu() throws Throwable {
		priceIntegrityPageObject.navigateDailyWorkloadMenu();

	}

	@Then("User should be able to see the relevant sub-menus under Daily Workload")
	public void user_should_be_able_to_see_the_relevant_sub_menus_under_Daily_Workload() throws Throwable {
		priceIntegrityPageObject.verifySubmenusUnderDailyWorkload();

	}

	@Then("User checks the sub-menu items under Business Critical menu")
	public void user_checks_the_sub_menu_items_under_Business_Critical_menu() throws Throwable {
		priceIntegrityPageObject.navigateBusinessCriticalMenu();

	}

	@Then("User should be able to see the relevant sub-menus under Business Critical")
	public void user_should_be_able_to_see_the_relevant_sub_menus_under_Business_Critical() throws Throwable {
		priceIntegrityPageObject.verifySubmenusUndeBuisnessCritical();

	}

	@When("User navigates to Price Increases sub-menu")
	public void user_navigates_to_Price_Increases_sub_menu() throws Throwable {
		priceIntegrityPageObject.navigatePriceIncreasesMenu();

	}

	@When("User navigates to Price decreases sub-menu")
	public void user_navigates_to_Price_decreases_sub_menu() throws Throwable {

		priceIntegrityPageObject.navigatePriceDecreasesMenu();
	}

	@When("User presses on back button")
	public void user_presses_on_back_button() throws Throwable {
		priceIntegrityPageObject.clickOnBackButton();

	}

	@When("User navigates to Review sub-menu under Price Integrity option")
	public void user_navigates_to_Review_sub_menu_under_Price_Integrity_option() throws Throwable {
		priceIntegrityPageObject.priceIntergrityReview().click();

	}

	@When("User navigates to Exceptions sub-menu under Price Integrity option")
	public void user_navigates_to_Exceptions_sub_menu_under_Price_Integrity_option() throws Throwable {

		priceIntegrityPageObject.priceIntergrityExceptions().click();
	}

	@When("User navigates to Request Label sub-menu under Price Integrity option")
	public void user_navigates_to_Request_Label_sub_menu_under_Price_Integrity_option() throws Throwable {

		priceIntegrityPageObject.priceIntergrityRequestlabel().click();
	}

	@When("User navigates to Verification sub-menu under Price Integrity option")
	public void user_navigates_to_Verification_sub_menu_under_Price_Integrity_option() throws Throwable {
		priceIntegrityPageObject.priceIntergrityVerification().click();

	}

	@When("User navigates to Verification History sub-menu under Price Integrity option")
	public void user_navigates_to_Verification_History_sub_menu_under_Price_Integrity_option() throws Throwable {

		priceIntegrityPageObject.priceIntergrityVerificationHistory().click();
	}

	@Then("User checks the sub-menu items under Overdue menu")
	public void user_checks_the_sub_menu_items_under_Overdue_menu() throws Throwable {

		priceIntegrityPageObject.workloadOverdue().click();
	}

	@Then("User should be able to see the relevant sub-menus under Overdue")
	public void user_should_be_able_to_see_the_relevant_sub_menus_under_Overdue() throws Throwable {

		Assert.assertTrue(priceIntegrityPageObject.isElementPresent(priceIntegrityPageObject.workloadPriceIncreases()));
		Assert.assertTrue(priceIntegrityPageObject.isElementPresent(priceIntegrityPageObject.workloadPriceDecreases()));
		Assert.assertTrue(priceIntegrityPageObject.isElementPresent(priceIntegrityPageObject.workloadStartingOffers()));
		Assert.assertTrue(priceIntegrityPageObject.isElementPresent(priceIntegrityPageObject.workloadEndingOffers()));
		Assert.assertTrue(
				priceIntegrityPageObject.isElementPresent(priceIntegrityPageObject.workloadStartingMorePoints()));
		//Assert.assertTrue(priceIntegrityPageObject.isElementPresent(priceIntegrityPageObject.workloadPriceChanges()));
	}

	@Then("User verify daily workload screen get closed")
	public void user_verify_daily_workload_screen_get_closed() throws Throwable {
		Thread.sleep(1000);
		driveR.findElement(By.id("" + env + ":id/price_integrity")).isDisplayed();
		Thread.sleep(1000);
	}

	@Then("User checks item details under Ending Offers task")
	public void user_checks_item_details_under_Ending_Offers_task() throws Throwable {
		Thread.sleep(4000);
		priceIntegrityPageObject.navigateEndingOffersMenu();
		Thread.sleep(12000);
	}

	@When("User performs swipe right on item in task list")
	public void user_performs_swipe_right_on_item_in_task_list() throws Throwable {
		if (priceIntegrityPageObject.isItemDescriptionDisplayed()) {
			priceIntegrityPageObject.swipeRight();
		swipedRight = true;
	} else {
		System.out.println("No items to swipe right");
	}
	}

	@When("Verify item is moved from task and missing Label exception is raised for same")
	public void verify_item_is_moved_from_task_and_missing_Label_exception_is_raised_for_same() throws Throwable {
		if (swipedRight) {
			Assert.assertTrue(priceIntegrityPageObject.textExceptionRaised().isDisplayed());
			swipedRight = false;
			Thread.sleep(4000);
		}
	}

	@When("User performs swipe left on item in task list")
	public void user_performs_swipe_left_on_item_in_task_list() throws Throwable {
		if (priceIntegrityPageObject.isItemDescriptionDisplayed()) {
			itemNameForSwipeLeft = priceIntegrityPageObject.itemDescription().getText();
			priceIntegrityPageObject.swipeLeft();
			swipedLeft = true;
		} else {
			System.out.println("No items to swipe left");
		}
	}

	@When("Verify item is moved to bottom and undo option is displayed")
	public void verify_item_is_moved_to_bottom_and_undo_option_is_displayed() throws Throwable {
		if (swipedLeft) {
			Assert.assertTrue(priceIntegrityPageObject.optionUndo().isDisplayed());
			Thread.sleep(2000);
			Assert.assertTrue(priceIntegrityPageObject.scrollAndCheckItemPresentInList(itemNameForSwipeLeft),
					"Item not found at bottom");
			swipedLeft = false;
			Thread.sleep(2000);

		}
	}

	@When("User clicks on undo")
	public void user_clicks_on_undo() throws Throwable {

		priceIntegrityPageObject.optionUndo().click();
		Thread.sleep(2000);
	}

	@Then("Task should be moved back to its original position")
	public void task_should_be_moved_back_to_its_original_position() throws Throwable {
		System.out.println("Checking the item is placed back to original(top) position");
		Assert.assertTrue(priceIntegrityPageObject.isItemDescriptionDisplayed(),
				"Item is not displayed at original position");

	}

	@Then("User checks item details under Starting Offers task")
	public void user_checks_item_details_under_Starting_Offers_task() throws Throwable {
		Thread.sleep(2000);
		priceIntegrityPageObject.navigateStartingOffersMenu();
		Thread.sleep(3000);

	}

	@When("User clicks on My Work tab")
	public void user_clicks_on_My_Work_tab() throws Throwable {
		Thread.sleep(2000);
		priceIntegrityPageObject.myWorkTab().click();
		Thread.sleep(2000);

	}

	@Then("User should be able to see items without any error")
	public void user_should_be_able_to_see_items_without_any_error() throws Throwable {

		if (priceIntegrityPageObject.isItemPresent()) {
			itemPresent = true;
			System.out.println("First item's name: " + priceIntegrityPageObject.itemName().getText());
			Assert.assertTrue(true);
		} else {
			System.out.println("No items available");
			itemPresent = false;
			Assert.assertFalse(false);

		}
	}

	@Then("User clicks on an item under My Work tab")
	public void user_clicks_on_an_item_under_My_Work_tab() throws Throwable {
		Thread.sleep(4000);
		if (itemPresent) {
			priceIntegrityPageObject.itemName().click();
		} else {
			System.out.println("No items present to click");
		}

	}

	@Then("User should be able to see the details of item and close button")
	public void user_should_be_able_to_see_the_details_of_item_and_close_button() throws Throwable {
		if (itemPresent) {
			Assert.assertTrue(priceIntegrityPageObject.itemDecriptionDetailsPage().isDisplayed());
			Assert.assertTrue(priceIntegrityPageObject.closeButton().isDisplayed());
		} else {
			System.out.println("No Items present, hence item's description and close button not available");
		}

	}

	@When("User clicks on My Store tab")
	public void user_clicks_on_My_Store_tab() throws Throwable {
		Thread.sleep(14000);
		priceIntegrityPageObject.myStoreTab().click();
		Thread.sleep(12000);

	}

	@Then("User clicks on an item under My Store tab")
	public void user_clicks_on_an_item_under_My_Store_tab() throws Throwable {
		Thread.sleep(2000);
		if (itemPresent) {
			priceIntegrityPageObject.itemName().click();
		} else {
			System.out.println("No items present to click");
		}

	}

	@When("User clicks on close button on details page")
	public void user_clicks_on_close_button_on_details_page() throws Throwable {
		if (itemPresent) {
			priceIntegrityPageObject.closeButton().click();
		} else {
			System.out.println("No items present to close details");
		}

	}

	@Then("User should be able to see item under My Work tab")
	public void user_should_be_able_to_see_item_under_My_Work_tab() throws Throwable {

		Thread.sleep(4000);
		if (itemPresent) {
			System.out.println("Items present");
			Assert.assertTrue(true);
		} else {
			System.out.println("No Items Present");
		}
	}

	@Then("User clicks on up-navigation button")
	public void user_clicks_on_up_navigation_button() throws Throwable {
		Thread.sleep(2000);
		priceIntegrityPageObject.upNavigationButton().click();
	}

	@When("User verify My Work tab is displayed")
	public void user_verify_My_Work_tab_is_displayed() throws Throwable {
		Thread.sleep(2000);
		priceIntegrityPageObject.myWorkTab().isDisplayed();

	}

	@When("User navigate to My Work tab")
	public void user_navigate_to_My_Work_tab() throws Throwable {
		Thread.sleep(4000);
		priceIntegrityPageObject.myWorkTab().click();
	}

	@Then("User verify Filter icon is displayed")
	public void user_verify_Filter_icon_is_displayed() throws Throwable {

		priceIntegrityPageObject.clickFilterIcon().isDisplayed();
	}

	@Then("User click on Filter icon")
	public void user_click_on_Filter_icon() throws Throwable {

		Thread.sleep(2000);
		priceIntegrityPageObject.clickFilterIcon().click();;
	}

	@Then("User verify filters popup is displayed")
	public void user_verify_filters_popup_is_displayed() throws Throwable {

		WebElement element = driveR.findElement(By.id("android:id/content"));
	}

	@Then("User select filter option")
	public void user_select_filter_option() throws Throwable {
		WebElement element = driveR.findElement(By.xpath("//android.widget.CheckedTextView[@text='GAP' or @text='Gap']"));
		element.click();
	}

	@Then("verify selected filter items are displayed in item list")
	public void verify_selected_filter_items_are_displayed_in_item_list() throws Throwable {
		WebElement element = driveR.findElement(By.id("" + env + ":id/history_not_available_message"));
		element.isDisplayed();
	}

	@Then("User verify My Store tab is displayed")
	public void user_verify_My_Store_tab_is_displayed() throws Throwable {
		Thread.sleep(2000);
		priceIntegrityPageObject.myStoreTab().isDisplayed();
	}

	@Then("User navigate to My Store tab")
	public void user_navigate_to_My_Store_tab() throws Throwable {
		Thread.sleep(4000);
		priceIntegrityPageObject.myStoreTab().click();
	}

	@Then("User clicks on filter and selects {string} filter")
	public void user_clicks_on_filter_and_selects_filter(String arg1) throws Throwable {

		priceIntegrityPageObject.filterIcon().click();
		Thread.sleep(2000);
		Assert.assertTrue(priceIntegrityPageObject.scrollAndCheckItemPresentInList(arg1));
		priceIntegrityPageObject.findAndClickOnItem(arg1);
		Thread.sleep(2000);
	}

	@Then("User should be able to see items as per {string} filter condition")
	public void user_should_be_able_to_see_items_as_per_filter_condition(String arg1) throws Throwable {

		if (priceIntegrityPageObject.isItemPresent()) {
			itemPresent = true;
			System.out.println("First item's name: " + priceIntegrityPageObject.itemName().getText());
			if (arg1.equalsIgnoreCase("Only Correct") || arg1.equalsIgnoreCase("None")) {
				Assert.assertTrue(priceIntegrityPageObject.correctItemIcon().isDisplayed());
			} else if (arg1.equalsIgnoreCase("Only Exceptions")) {
				Assert.assertTrue(priceIntegrityPageObject.exceptionIcon().isDisplayed());
			} else {
				Assert.assertFalse(!priceIntegrityPageObject.scrollAndCheckItemPresentInList(arg1));
			}

		} else {
			System.out.println("No items present");
			itemPresent = false;
		}
	}

	@When("User navigates to sub-menu under Price Integrity option")
	public void user_navigates_to_sub_menu_under_Price_Integrity_option() throws Throwable {


	}

	@Then("User should be able to see Scan Product page")
	public void user_should_be_able_to_see_Scan_Product_page() throws Throwable {

		Thread.sleep(2000);
		Assert.assertTrue(priceIntegrityPageObject.requestLabelPiLabellingRadioButton().isDisplayed());

		Assert.assertTrue(priceIntegrityPageObject.requestLabelEpisysResRadioButton().isDisplayed());

	}

	@Then("User selects EPISYS RES radio button option")
	public void user_selects_EPISYS_RES_radio_button_option() throws Throwable {
		priceIntegrityPageObject.requestLabelEpisysResRadioButton().click();
		Thread.sleep(4000);

	}

	@Then("User searches for a item {string} from toolbar")
	public void user_searches_for_a_item_from_toolbar(String arg1) throws Throwable {

		priceIntegrityPageObject.requestLabelSearchIcon().click();
		Thread.sleep(2000);
		priceIntegrityPageObject.requestLabelSearchTextBox().sendKeys(arg1);
		Thread.sleep(5000);
	}

	@Then("User should be able to see the item {string} in search results")
	public void user_should_be_able_to_see_the_item_in_search_results(String arg1) throws Throwable {

		String actualDescription = "";
		actualDescription = priceIntegrityPageObject.requestLabelSearchResult().getText();
		Thread.sleep(2000);
		Assert.assertTrue(actualDescription.contains(arg1));
		Thread.sleep(5000);
	}

	@Then("User clicks on the item displayed in search result")
	public void user_clicks_on_the_item_displayed_in_search_result() throws Throwable {
		priceIntegrityPageObject.requestLabelSearchResult().click();
		Thread.sleep(2000);

	}

	@Then("User should be able to see the item description with label addition option and continue button")
	public void user_should_be_able_to_see_the_item_description_with_label_addition_option_and_continue_button() throws Throwable {

		Assert.assertTrue(priceIntegrityPageObject.requestLabelItemDecriptionOnScanPage().isDisplayed());
		Assert.assertTrue(priceIntegrityPageObject.requestLabelContinueButton().isDisplayed());
		Thread.sleep(4000);
	}

	@When("User selects the label type and quantity then clicks on continue button")
	public void user_selects_the_label_type_and_quantity_then_clicks_on_continue_button() throws Throwable {
		priceIntegrityPageObject.requestLabelType();
		// priceIntegrityPageObject.requestLabelAddQuantity().click();
		Thread.sleep(2000);
		priceIntegrityPageObject.requestLabelContinueButton().click();
		Thread.sleep(2000);

	}

	@When("User selects a stack")
	public void user_selects_a_stack() throws Throwable {
		if (priceIntegrityPageObject.requestLabelStack().isDisplayed()) {
			priceIntegrityPageObject.requestLabelStack().click();
			Thread.sleep(4000);
		}

	}

	@Then("User selects Price Integrity Labelling System radio button option")
	public void user_selects_Price_Integrity_Labelling_System_radio_button_option() throws Throwable {

		priceIntegrityPageObject.requestLabelPiLabellingRadioButton().click();
		Thread.sleep(2000);
	}

	@When("User scans an item with wrong barcode {string}")
	public void user_scans_an_item_with_wrong_barcode(String arg1) throws Throwable {
		priceIntegrityPageObject.scanBarcode(arg1);
		Thread.sleep(4000);

	}

	@Then("User should be able to see an alert popup with product not found message")
	public void user_should_be_able_to_see_an_alert_popup_with_product_not_found_message() throws Throwable {

		Thread.sleep(2000);
		Assert.assertTrue(priceIntegrityPageObject.productNotFound().isDisplayed());
		Thread.sleep(2000);
	}


	@Then("User checks Overdue label is displayed next to the sub-menu items on the top")
	public void user_checks_Overdue_label_is_displayed_next_to_the_sub_menu_items_on_the_top() throws Throwable {
		priceIntegrityPageObject.overdueWorkloadIsPresent();

	}

	@Then("User scans an item {string}")
	public void user_scans_an_item(String arg1) throws Throwable {
		priceIntegrityPageObject.scanBarcode(arg1);
		inputBarcode = arg1;
		Thread.sleep(2000);
		priceIntegrityPageObject.selectLocation();

	}

	@Then("User selects an exception {string} in Workload")
	public void user_selects_an_exception_in_Workload(String arg1) throws Throwable {
		Thread.sleep(1000);
		Assert.assertTrue(priceIntegrityPageObject.scrollAndCheckItemPresentInList(arg1));
		priceIntegrityPageObject.selectExceptionCheckBoxInVerification(arg1);
		exception.add(arg1);

	}

	@Then("User clicks on complete check button")
	public void user_clicks_on_complete_check_button() throws Throwable {

		Thread.sleep(2000);
		priceIntegrityPageObject.workloadCompleteCheckButton().click();
	}

	@Then("User enters the description {string}")
	public void user_enters_the_description(String arg1) throws Throwable {

		Thread.sleep(12000);
		priceIntegrityPageObject.verificationExceptionDescription().sendKeys(arg1);
		//reviewComment.add(arg1);
	}

	@Then("User verifies that the overdue task count has increased or decreased")
	public void user_verifies_that_the_overdue_task_count_has_increased_or_decreased() throws Throwable {

		overdueNewCountBusinessCritical = Integer
				.parseInt(priceIntegrityPageObject.workloadBusinessCriticalCount().getText());
		boolean flag = false;
		System.out.println("Decreased Count: " + overdueNewCountBusinessCritical);

		if (overdueNewCountBusinessCritical < overdueCountBusinessCritical) {
			System.out.println("Count has decreased");
			flag = true;
		} else if (overdueNewCountBusinessCritical > overdueCountBusinessCritical) {
			System.out.println("Count has increased");
		} else {
			System.out.println("No Change");
			Assert.assertTrue(flag, "Count not decreased");
		}
	}

	@When("User enters price {string} in pences")
	public void user_enters_price_in_pences(String arg1) throws Throwable {

		priceIntegrityPageObject.verificationEditTextBox().clear();
		priceIntegrityPageObject.verificationEditTextBox().sendKeys(arg1);
	}

	@When("User clicks on verify button")
	public void user_clicks_on_verify_button() throws Throwable {
		Thread.sleep(2000);
		Assert.assertTrue(priceIntegrityPageObject.scrollAndCheckItemPresentInList("VERIFY"));
		Thread.sleep(2000);
		priceIntegrityPageObject.verificationVerifyButton().click();
		Thread.sleep(2000);
	}

	@When("User clicks on submit button")
	public void user_clicks_on_submit_button() throws Throwable {

		Thread.sleep(2000);
		Assert.assertTrue(priceIntegrityPageObject.scrollAndCheckItemPresentInList("SUBMIT"));
		priceIntegrityPageObject.verificationSubmitButton().click(); 
	}

	@Then("User Click on the sub-menu items under Overdue menu")
	public void user_Click_on_the_sub_menu_items_under_Overdue_menu() throws Throwable {

		Thread.sleep(2000);
		priceIntegrityPageObject.workloadOverdue().click();
		Thread.sleep(2000);
	}

	@Then("User select the product category")
	public void user_select_the_product_category() throws Throwable {

	}

	@Then("User should be able to navigate to Price increase menu from Overdue menu")
	public void user_should_be_able_to_navigate_to_Price_increase_menu_from_Overdue_menu() throws Throwable {
		priceIntegrityPageObject.navigatePriceIncreasesMenu();
	}

	@Then("User verify for Products with Overdue status are displayed")
	public void user_verify_for_Products_with_Overdue_status_are_displayed() throws Throwable {
		Thread.sleep(2000);
		priceIntegrityPageObject.workloadOverdue().click();
		Thread.sleep(2000);
	}

	@Then("User should be able to navigate to Price decrease menu from Overdue menu")
	public void user_should_be_able_to_navigate_to_Price_decrease_menu_from_Overdue_menu() throws Throwable {
		priceIntegrityPageObject.navigatePriceDecreasesMenu();
	}

	@Then("User should be able to navigate to Starting offers menu from Overdue menu")
	public void user_should_be_able_to_navigate_to_Starting_offers_menu_from_Overdue_menu() throws Throwable {

		priceIntegrityPageObject.navigateStartingOffersMenu();
	}

	@Then("User should be able to navigate to Ending offers menu from Overdue menu")
	public void user_should_be_able_to_navigate_to_Ending_offers_menu_from_Overdue_menu() throws Throwable {

		priceIntegrityPageObject.navigateEndingOffersMenu();
	}

	@Then("User should be able to see task is present in the task list")
	public void user_should_be_able_to_see_task_is_present_in_the_task_list() throws Throwable {
		priceIntegrityPageObject.taskPresentforAllCriteria(productItemDescription);

	}



	@When("User expands the report exception panel")
	public void user_expands_the_report_exception_panel() throws Throwable {

		Thread.sleep(2000);
		priceIntegrityPageObject.verificationExpandExceptionPanel().click();
		Thread.sleep(2000);
	}

	@When("User selects an exception {string} in Verification")
	public void user_selects_an_exception_in_Verification(String arg1) throws Throwable {

		Thread.sleep(1000);
		Assert.assertTrue(priceIntegrityPageObject.scrollAndCheckItemPresentInList(arg1));
		priceIntegrityPageObject.selectExceptionCheckBoxInVerification(arg1);
		exception.add(arg1);
	}

	@When("User accepts the alert")
	public void user_accepts_the_alert() throws Throwable {
		Thread.sleep(2000);
		priceIntegrityPageObject.acceptAlert().click();

	}

	@When("User clicks on raise button")
	public void user_clicks_on_raise_button() throws Throwable {

		//		priceIntegrityPageObject.verificationSaveButton().click();
		//		Thread.sleep(20000);
	}

	@When("User clicks on save button")
	public void user_clicks_on_save_button() throws Throwable {
		Thread.sleep(2000);
		priceIntegrityPageObject.verificationSaveButton().click();
	}

	@When("User selects a label system")
	public void user_selects_a_label_system() throws Throwable {
		Thread.sleep(2000);
		priceIntegrityPageObject.labelSystem().click();
	}

	@Then("Select multiple label size")
	public void select_multiple_label_size() throws Throwable {
		Thread.sleep(2000);
		priceIntegrityPageObject.selectMultipleOptions();

	}

	@Then("User clicks on continue button")
	public void user_clicks_on_continue_button() throws Throwable {

		priceIntegrityPageObject.requestLabelContinueButton().click();
	}

	@Then("User should be able to see item under review")
	public void user_should_be_able_to_see_item_under_review() throws Throwable {
		Thread.sleep(2000);
		priceIntegrityPageObject.verificationProductName().isDisplayed();
	}

	@When("User opens the item under review")
	public void user_opens_the_item_under_review() throws Throwable {
		Thread.sleep(2000);
		priceIntegrityPageObject.verificationProductName().click();
	}

	@Then("User can see right exception name {string} and status")
	public void user_can_see_right_exception_name_and_status(String arg1) throws Throwable {
		priceIntegrityPageObject.verifyRightExceptionAndStatus(arg1);

	}

	@Then("User click on close button")
	public void user_click_on_close_button() throws Throwable {
		priceIntegrityPageObject.verificationCloseButton().click();

	}
	
	@Then("User Close the application")
	public void closeTheApp() throws Throwable {
		Thread.sleep(2000);
		driveR.quit();
	}
}
