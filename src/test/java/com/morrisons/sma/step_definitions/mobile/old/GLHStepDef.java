package com.morrisons.sma.step_definitions.mobile.old;

import com.morrisons.common.PageFactory.InitClass;
import com.morrisons.common.action.Hook;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.morrisons.sma.page_objects.mobile.old.GLHPageObject;

import java.lang.reflect.InvocationTargetException;

public class GLHStepDef {
	public String type;
	GLHPageObject implementaion = new GLHPageObject();
	private AndroidDriver driveR;

	public GLHStepDef() {
		this.driveR = (AndroidDriver) Hook.getDriver();
	}
	@When("I enter {string} and {string} for glh")
	public void i_enter_and_for_glh(String userName, String password) throws Throwable {
		implementaion.usernamePasswrod(userName, password);

	}

	@When("I click on login button for sglh")
	public void i_click_on_login_button_for_sglh() throws Throwable {
		implementaion.clickLogin();
	}

	
	@Then("I click on Gaps,Low,High")
	public void i_click_on_Gaps_Low_High() throws Throwable {
		implementaion.navigatetoGLH();

	}

	@Then("I click on AM Gaps Lows High")
	public void i_click_on_AM_Gaps_Lows_High() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		implementaion.navigatetoAMGLH();
	}

	@Then("I click on Fixture Scan")
	public void i_click_on_Fixture_Scan() throws Throwable {
		implementaion.navigateToFixtureScan();
	}

	@Then("I click on OffShelf")
	public void i_click_on_OffShelf() throws Throwable {
		implementaion.navigateToOffShelf();
	}

	@Then("I click on Petrol")
	public void i_click_on_Petrol() throws Throwable {
		implementaion.navigateToPetrol();
	}

	@Then("I click on WareHouse")
	public void i_click_on_WareHouse() throws Throwable {
		implementaion.navigateToWareHouse();
	}

	@Then("I click on Review")
	public void i_click_on_Review() throws Throwable {
		implementaion.navigateToReview();
	}

	@Then("I click on Summary")
	public void i_click_on_Summary() throws Throwable {
		implementaion.navigateToSummary();
	}

	@And("I click on Back Button")
	public void i_click_on_Back_Button() throws Throwable {
		implementaion.clickBackButton();
	}

	@And("I click on GAP button")
	public void i_click_on_GAP_button() throws Throwable {
		implementaion.clickGapButton();
	}

	@And("I click on High button")
	public void i_click_on_High_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		implementaion.clickHighButton();
	}

	@And("I click on Low button")
	public void i_click_on_Low_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		implementaion.clickLowButton();
	}

	@And("I click on COUNT button")
	public void iClickOnCOUNTButton() throws InterruptedException, NoSuchFieldException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
		implementaion.clickCountButton();
	}

	@And("I verify the {string} in Scan Item")
	public void i_verify_the_in_Scan_Item(String min) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		
		String item = min;
		implementaion.verifyMin(item);
	}

	@And("Verify the popup is displayed with the message")
	public void verify_the_popup_is_displayed_with_the_message() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		implementaion.verifyPopupGap();
	}

	@And("I click on OK")
	public void i_click_on_OK() throws Throwable {
		implementaion.verifyOkGap();
	}

	@And("I will capture the product name from view list")
	public void captureFixtureList() throws Throwable {
		implementaion.captureFixtureList();
	}

	@And("I choose the plan from popup if multiple records present")
	public void i_choose_the_plan_from_popup_if_multiple_records_present() throws Throwable {
		implementaion.selectfromlist();

	}

	
	
	@Then("I verify my min is present in the {string} or not")
	public void i_verify_my_min_is_present_in_the_or_not(String Type) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		
		type = Type;
		implementaion.selectfromWarehouse(type);
	}

	@Then("I verify the if it is GAP HIGH LOW")
	public void i_verify_the_if_it_is_GAP_HIGH_LOW() throws Throwable {
		implementaion.gapIsDisplayed();
	}

	@Then("I verify the if it is GAP")
	public void i_verify_the_if_it_is_GAP() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		implementaion.gapIsDisplayed();
	}

	@Then("I verify the if it is LOW")
	public void i_verify_the_if_it_is_LOW() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		implementaion.lowIsDisplayed();
	}

	@Then("I verify the if it is HIGH")
	public void highIsDisplayed() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		implementaion.highIsDisplayed();
	}

	@Then("I verify the if it is COUNT")
	public void i_verify_the_if_it_is_count() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		implementaion.CountIsDisplayed();
	}
	
	@Then("I verify the if Low is displayed in warehouse")
	public void lowIsDisplayedInWarehouse() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		implementaion.lowIsDisplayedInWarehouse();
	}

	@Then("I verify the if Count is displayed in warehouse")
	public void i_verify_the_if_count_is_displayed_in_warehouse() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		implementaion.countIsDisplayedInWarehouse();
	}

	@Then("I will enter the required quantity and click on confirm")
	public void i_will_enter_the_required_quantity_and_click_on_confirm() throws Throwable {
		implementaion.enterQty();
	}

	@Then("I click on Confirm Area Count")
	public void i_click_on_Confirm_Area_Count() throws Throwable {
		implementaion.confirmCount();
	}

	@Then("I click on Confirm message after verifying it")
	public void i_click_on_Confirm_message_after_verifying_it() throws Throwable {
		implementaion.confirmMessage();

	}

	@Then("I select the {string} and verify the status as Pending")
	public void i_select_the_and_verify_the_status_as_Pending(String Type) throws Throwable {
		
		type = Type;
		implementaion.reviewVerification(type);

	}

	@Then("I verify my min is present in the {string}")
	public void i_verify_my_min_is_present_in_the(String arg1) throws Throwable {
		implementaion.checkreview(arg1);

	}

	//
	// @Then("I select the {string} from the list")
	// public void i_select_the_from_the_list(String arg1) throws Throwable {
	// // Write code here that turns the phrase above into concrete actions
	// throw new PendingException();
	// }
	//
	// }

	@Then("I Enter the Low quantity {string}")
	public void i_Enter_the_Low_qty(String quantity) throws Throwable {
		implementaion.enterQtyCount(quantity);
	}

	@Then("I click on ViewList")
	public void i_click_on_ViewList() throws Throwable {
		implementaion.viewlistclick();
	}

	@Then("I Verify that Barcode matches with the input {string} barcode")
	public void i_Verify_that_Barcode_matches_with_the_input_barcode(String barcode) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		implementaion.verifyBarcodeinWarehouse(barcode);
	}

	@Then("I verify the Item Description")
	public void i_verify_the_Item_Description() throws Throwable {
		implementaion.verifyDescinWarehouse();
	}

	@Then("I verify the variance record {string}")
	public void i_verify_the_variance_record(String quantity) throws Throwable {
		implementaion.verifyVarianceinWarehouse(quantity);
	}

	@Then("I right swipe and delete the object")
	public void i_right_swipe_and_delete_the_object() throws Throwable {
		implementaion.swipeRight();
	}

	@Then("I click on ViewList of GapsLowHigh")
	public void i_click_on_ViewList_of_GapsLowHigh() throws Throwable {
		implementaion.viewGapLowHigh();
	}

	@Then("I verify that record is deleted from WareHouse")
	public void i_verify_that_record_is_deleted_from_WareHouse() throws Throwable {
		implementaion.checkWarehouseDelete();
	}

	@Then("I capture StockRecord Value")
	public void i_capture_StockRecord_Value() throws Throwable {
		implementaion.captureRecord();
	}

	@Then("First Variance calculation")
	public void first_Variance_calculation() throws Throwable {
		implementaion.firstcalculation();
	}
	
	@Then("I enter Qty in Warehouse {string}")
	public void i_enter_Qty_in_Warehouse(String quantity) throws Throwable {
		implementaion.enterQtyWarehousethrows(quantity);
	}

	@Then("I verify the updated variance count {string}")
	public void i_varify_the_updated_variance_count(int quantity) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		implementaion.finalVariance(quantity);
	}

	@Then("I enter quantity {string} for fixture and warehouse")
	public void i_enter_quantity_for_fixture_and_warehouse(String qty) throws Throwable {
		implementaion.enterQtyCount(qty);
	}
	
	@Then("I click on ViewList to verify that two entries are present for MIN {string}")
	public void i_click_on_ViewList_to_verify_that_two_entries_are_present(String minValue) throws Throwable {
		implementaion.verifyList(minValue);
	}

	@Then("I edit the High value count {string} and check variance")
	public void i_edit_the_High_value_and_check_variance(String quantity) throws Throwable {
		implementaion.editHigh(quantity);
	}
	

	@Then("Verify that the same record is present in Offshelf")
	public void verify_that_the_same_record_is_present_in_Offshelf() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		implementaion.verifyoffShore();
	}

	@Then("enter Qty in offshelf")
	public void enter_Qty_in_offshelf() throws Throwable {
		implementaion.addOffshoreQty();
	}
	
	@Then("I select the {string} and verify the status as ReviewReady")
	public void i_select_the_and_verify_the_status_as_ReviewReady(String arg1) throws Throwable {
		implementaion.verifyreview();
	}
	
	@Then("I click on {string} under the department")
	public void i_click_on_under_the_department(String arg1) throws Throwable {
		implementaion.subcategory(arg1);
	}

	@Then("I click on the {string} to update the count")
	public void i_click_on_the_to_update_the_count(String arg1) throws Throwable {
		implementaion.subcategory(arg1);
	}

	@Then("I select {string} to update")
	public void i_select_to_update(String arg1) throws Throwable {
		implementaion.subcategory(arg1);
	}

	@Then("I update the {string}")
	public void i_update_the(String arg1) throws Throwable {
		implementaion.updateCount(arg1);
	}

	@Then("I click on the Confirm Button")
	public void i_click_on_the_Confirm_Button() throws Throwable {
		implementaion.confirm();
	}
	
	@Then("I verify Error message is displayed")
	public void i_verify_Error_message_is_displayed() throws Throwable {
		implementaion.errormessageGLHclosed();
	}
	
	@Then("I click on location {string}")
	public void i_click_on_location(String arg1) throws Throwable {
		implementaion.location(arg1);
	}

	@Then("I store Order Quantity and Delivered Quantity")
	public void i_store_Order_Quantity_and_Delivered_Quantity() throws Throwable {
		implementaion.orderedDelivered();
	}
	
	@Then("I verify Order Quantity and Delivered Quantity from GLH and SI are same")
	public void i_verify_Order_Quantity_and_Delivered_Quantity_from_GLH_and_SI_are_same() throws Throwable {
		implementaion.orderedDeliveredSI();
	}
	
	@Then("I verify {string} message box is displayed")
	public void i_verify_message_box_is_displayed(String arg1) throws Throwable {
		implementaion.exemptedItem(arg1);
	}
	
	@Then("I verfify {string} item is present")
	public void I_verfify_item_is_present(String bar) throws Throwable {
		String item11 = bar;
	    implementaion.verifyList1(item11);
	}

	@And("I scroll up")
	public void i_scroll_up() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		implementaion.scrollUp();
	}
	
	@Then("I Verify Product list is loaded in warehouse location")
	public void iVerifyProductListIsloaded() throws Throwable {
		implementaion.getWarehouseProductList();
	}
	
	
	
	@Then("I Verify Product list is loaded in offshelf location")
	public void iVerifyProductListIsloadedInOffshelf() throws Throwable {
		implementaion.getOffshelfProductList();
	}
	
	@Then("I Select product list, click on product and enter quantity")
	public void iCompleteOffshelf() throws Throwable {
		implementaion.getOffshelfProduct();
	}
	
	@And("I Enter High quantity {string} and click on Confirm button")
	public void iEnterQuantityFixtureLocation(String quantity) throws Throwable {
		implementaion.iEnterQuantityFixtureLocation(quantity);
	}
	
	@Then("I Enter the Low quantity {string} and click on Confirm button")
	public void iEnterLowQuantityFixtureLocation(String quantity) throws Throwable {
		implementaion.enterLowQuantityFixtureLocation(quantity);
	}
	
	@Then("I click on ViewList to verify that three entries are present")
	public void i_click_on_ViewList_to_verify_that_three_entries_are_present() throws Throwable {
		implementaion.enterQuantityInOffshelf();
	}
	@And("I verify the product MIN value {string} from view list")
	public void captureProductMinValue(String minValue) throws Throwable {
		implementaion.captureProductMinValue(minValue);
	}
	@Then("I get the variance count previous value")
	public void verifyVarianceinPreviousValue() throws Throwable {
		implementaion.verifyVarianceinPreviousValue();
	}
	
	@Then("I verify the variance count after adding quantity {string} value")
	public void verifyVarianceinAfterValue(String quantity) throws Throwable {
		implementaion.verifyVarianceinAfterValue(quantity);
	}
	
	@Then("I completed offshelf section for all the department")
	public void completeOffshelfCategories() throws Throwable {
		implementaion.completeOffshelfCategories();
	}
	

	@Then("I completed petrol section for all the department")
	public void completePetrolCategories() throws Throwable {
		implementaion.completePetrolCategories();
	}
	
	@Then("I verify Green label prompt is displayed")
	public void verifyGreenLabel() throws Throwable {
		implementaion.verifyGreenLabel();
	}
	@Then("I verify Orange label prompt is displayed")
	public void verifyOrangeLabel() throws Throwable {
		implementaion.verifyOrangeLabel();
	}

	@And("I click on Back Button till we get to the {string} page")
	public void iClickOnBackButtonTillWeGetToThePage(String sElement) throws InterruptedException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
		implementaion.clickBackButtonTillElementFound(sElement);
	}
}

