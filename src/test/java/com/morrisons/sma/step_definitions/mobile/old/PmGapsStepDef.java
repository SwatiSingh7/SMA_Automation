package com.morrisons.sma.step_definitions.mobile.old;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import com.morrisons.sma.page_objects.mobile.old.PMGapsPO;
import io.cucumber.java.en.And;

public class PmGapsStepDef {

	PMGapsPO pmGapPageObject = new PMGapsPO();

	@Then("I click on PMGaps")
	public void i_click_on_PMGaps() throws Throwable {
pmGapPageObject.clickpmGaps();

	}

	@Then("I verify Product is marked as GAP")
	public void i_verify_Product_is_marked_as_GAP() throws Throwable {
		
		pmGapPageObject.clickViewList();
		pmGapPageObject.captureTypeGap();
	}

	@And("I verify Product marked as gap in Warehouse")
	public void i_verify_Product_marked_as_gap_in_warehouse() throws Throwable {
		pmGapPageObject.captureTypeGap();
	}

	@Then("I click on hotKey")
	public void i_click_on_hotKey() throws Throwable {
		pmGapPageObject.hotKey();
	}

	@Then("I select StockInformation from the Hotkey Menu")
	public void i_select_StockInformation_from_the_Hotkey_Menu() throws Throwable {
		pmGapPageObject.stockInfoMenu();
	}

	@Then("I verify product is displayed as gap in Warehouse")
	public void i_verify_product_is_displayed_as_gap_in_Warehouse() throws Throwable {
		pmGapPageObject.captureTypeGap();
	}

	@Then("I click on product in warehouse {string}")
	public void i_click_on_product_in_warehouse(String Barcode) throws Throwable {
		pmGapPageObject.clickonProduct(Barcode);
	}

	@Then("I verify Popup is displayed for confirm stock found")
	public void i_verify_Popup_is_displayed_for_confirm_stock_found() throws Throwable {
		pmGapPageObject.confirmStockFoundpopup();
	}

	@And("I click on Confirm option")
	public void i_click_on_Confirm_option() throws Throwable {
		pmGapPageObject.clickConfirm();
	}

	@Then("I verify Stock Found is Displayed")
	public void i_verify_Stock_Found_is_Displayed() throws Throwable {
		pmGapPageObject.captureTypeStockFound();
	}

	@Then("I click on confirm count area button")
	public void i_click_on_confirm_count_area_button() throws Throwable {
		pmGapPageObject.clickconfirmCountAreaButton();
	}

	@Then("I click on confirm count popup")
	public void i_click_on_confirm_count_popup() throws Throwable {
		pmGapPageObject.clickconfirmCountPopup();
	}

	@And("I verify Section complete message is displayed")
	public void i_verify_section_complete_message_is_displayed() throws Throwable {
		pmGapPageObject.sectionCompleteMessageBox();
	}

	@Then("I click OK on the messagebox")
	public void i_click_ok_on_the_messagebox() throws Throwable {
		pmGapPageObject.sectionCompleteMessageBox();
	}

	@Given("I verify {string} is displayed under summary")
	public void i_verify_is_displayed_under_summary(String dep) throws Throwable {
		pmGapPageObject.verifySummaryDepartment(dep);
	}

	@Then("I click on Category {string} in summary")
	public void clickOnCategory(String arg1) throws Throwable {
		pmGapPageObject.clickOnCategory(arg1);
	}
	
	@Then("I verify text {string} is under IC is {string} in summary")
	public void i_verify_text_is_under_IC_is_in_summary(String catgeory,String arg1) throws Throwable {
		pmGapPageObject.textUnderIC(catgeory,arg1);
	}

	@Then("I verify text {string} is under COUNT is {string} in summary")
	public void i_verify_text_is_under_COUNT_is_in_summary(String catgeory,String arg1) throws Throwable {
		pmGapPageObject.textUnderCOUNT(catgeory,arg1);
	}
	
	@Then("I verify text is under Low is {string} in summary")
	public void i_verify_text_is_under_low_is_in_summary(String arg1) throws Throwable {
		pmGapPageObject.textUnderLow(arg1);
	}
	
	@Then("I verify text is under Low is {string} in summary GLH")
	public void i_verify_text_is_under_low_is_in_summary_glh(String arg1) throws Throwable {
		pmGapPageObject.textUndergap(arg1);
	}
	
	@Then("I verify text {string} is under stockfound is {string} in summary")
	public void i_verify_text_is_under_stockfound_is_in_summary(String category ,String arg1) throws Throwable {
		pmGapPageObject.textstockFound(category,arg1);
	}
	
	@Then("I select one of the category from departmet")
	public void i_select_one_of_the_from_departmet() throws Throwable {
		pmGapPageObject.selectCategoryPM();
	}
	
	@Then("I select one of the {string} from the popup")
	public void i_select_one_of_the_from_the_popup(String arg1) throws Throwable {
		pmGapPageObject.planSelection(arg1);
	}
	
	@Then("I verify {string} from the list")
	public void i_verify_from_the_list(String arg1) throws Throwable {
		pmGapPageObject.verifyProductInList(arg1);
	}

	@And("I verify Section completed status is displayed")
	public void sectionCompletedStatus() throws Throwable {
		pmGapPageObject.sectionCompletedStatus();
	}
	
	@Then("I click on COUNT tab in summary screen")
	public void clickOnCountInSummary() throws Throwable {
		pmGapPageObject.clickOnCountInSummary();
	}
}
