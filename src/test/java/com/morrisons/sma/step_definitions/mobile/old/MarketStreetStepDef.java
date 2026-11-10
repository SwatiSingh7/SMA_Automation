package com.morrisons.sma.step_definitions.mobile.old;

import com.morrisons.common.action.Hook;
import com.morrisons.sma.page_objects.mobile.old.MarketstreetGlhPO;
import com.morrisons.sma.page_objects.service.GlhBurstService;
import com.morrisons.sma.page_objects.service.GlhNegativePromptServicePO;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

public class MarketStreetStepDef {
	
	private static AndroidDriver driveR;
	public static List<String> walkIds = new ArrayList<String>();
	static String walkId;

	public MarketStreetStepDef()
	{		
	this.driveR = (AndroidDriver) Hook.getDriver();
	}

	MarketstreetGlhPO mrktstrt =new MarketstreetGlhPO();
	GlhNegativePromptServicePO glhNegativePromptServicePO = new GlhNegativePromptServicePO();
	GlhBurstService glhBurstService = new GlhBurstService();

	
@Then("I click on Market Street")
public void i_click_on_Market_Street() throws Throwable {
	Thread.sleep(5000);
   mrktstrt.clickMarketStret();
   
}


@Then("I click Market Street Gaps,Highs,Lows")
public void i_click_Market_Street_Gaps_Highs_Lows() throws Throwable {
    mrktstrt.clickMrketStreetGLH();
}

@Then("I see Please Select Location")
public void i_see_Please_Select_Location() throws Throwable {
    mrktstrt.pleaseSelectLocation();
}

@Then("I click Counter & Fixture location")
public void i_click_Counter_location() throws Throwable {
    mrktstrt.clickCounter();
}

@Then("I confirm popup")
public void i_confirm_popup() throws Throwable {
   mrktstrt.confirmPopup();
}

@Then("I click Confirm")
public void i_click_Confirm() throws Throwable {
   mrktstrt.confirmButton();
}

@Then("I see product in View List")
public void i_see_product_in_View_List() throws Throwable {
    mrktstrt.productViewlist();
}

@Then("I click View List")
public void i_click_View_List() throws Throwable {
    mrktstrt.clickViewlist();
}


@Then("I verify {string} in list")
public void i_verify_in_list(String arg1) throws Throwable {
    mrktstrt.itemlist(arg1);
 
}

@And("I click product")
public void i_click_product() throws Throwable {
    mrktstrt.clickProduct();
}


@Then("I click Exit Counter")
public void i_click_Exit_Counter() throws Throwable {
    mrktstrt.clickExitCounter();
}

@Then("I click Other Location")
public void i_click_Other_Location() throws Throwable {
    mrktstrt.clickOther();
}

@Then("I click Backup Location")
public void i_click_Backup_Location() throws Throwable {
    mrktstrt.clickBackup();
}

@Then("I click Review Location")
public void i_click_Review_Location() throws Throwable {
    mrktstrt.clickReview();
}


@Then("I see Sales Orders")
public void i_see_Sales_Orders() throws Throwable {
    mrktstrt.icSalesOrder();
}
@Then("I see Counter & Fixture location")
public void i_see_Counter_Fixture_location() throws Throwable {
	mrktstrt.icCounterFixture();
}



@Then("I see Other location")
public void i_see_Other_location() throws Throwable {
	   mrktstrt.icOther(); 

}

@Then("I see Backup location")
public void i_see_Backup_location() throws Throwable {
	   mrktstrt.icBackup(); 
}

@Then("I see Review location")
public void i_see_Review_location() throws Throwable {
	   mrktstrt.icReview(); 
}


@Then("I verify waring message")
public void i_verify_waring_message() throws Throwable {
    mrktstrt.prepackWarning();
    
}

@When("I click Proceed")
public void i_click_proceed() throws Throwable {
mrktstrt.clickProceed();
}


@Then("I redirect to Other Location")
public void i_redirect_to_other_location() throws Throwable {
mrktstrt.verifyOtherlocation();
}
@And("I verify scanned product count")
public void i_verify_scanned_product_count() throws Throwable {
	mrktstrt.verifyCount();    

}


@Then("I enter {string}")
public void i_Enter(String arg1) throws Throwable {
	mrktstrt.enterQuantity(arg1);    
}

@Then("I click Exit Other")
public void i_click_Exit_Other() throws Throwable {
    mrktstrt.exitOther();
}

@Then("I see warning message for non GLH Marketstreet product")
public void i_see_warning_message_for_GLH_product() throws Throwable {
   mrktstrt.glhwarningmsg();
}


@Then("I capture MIN for product")
public void i_capture_MIN_for_product() throws Throwable {
    mrktstrt.captureMIN();
}


@Then("I capture MIN for product in Counter")
public void i_capture_MIN_for_products() throws Throwable {
    mrktstrt.capturMINatCounter();
}
@Then("I update {string} for {string} location")
public void i_update_for_location(String Count, String Location) throws Throwable {
    mrktstrt.updateCountinReview(Count, Location);
}

@Then("I click and enter {string} for other location")
public void i_click_and_enter_Count_for_other_location(String Count) throws Throwable {
  mrktstrt.enterOtherlocationcount(Count);
}


@Then("I click and enter {string} for backup location")
public void i_click_and_enter_Count_for_backup_location(String Count) throws Throwable {
	  mrktstrt.enterBackuplocationcount(Count);  
}

@Then("I click and enter {string}  for backup location for low")
public void i_click_and_enter_for_backup_location_for_low(String Count) throws Throwable {
	  mrktstrt.enterBackuplocationcountforlow(Count);  

}


@Then("I enter quantity {string} for high")
public void i_enter_quantity_for_high(String arg1) throws Throwable {
	mrktstrt.enterHighQuantity(arg1);
}
@Then("I verify product in Backup location")
public void i_verify_product_in_Backup_location() throws Throwable {
	mrktstrt.verifyBackupDelete();
}


@Then("I verify department {string} is deleted in Other location")
public void i_verify_department_is_deleted_in_Other_location(String Department) throws Throwable {
    mrktstrt.verifydepartmentdeleteinother(Department);
}

@Then("I verify department {string} is deleted in Backup location")
public void i_verify_department_is_deleted_in_Backup_location(String Department) throws Throwable {
    mrktstrt.verifydepartmentdeleteinBackup(Department);

}

@Then("I verify department {string} is deleted in Review location")
public void i_verify_department_is_deleted_in_Review_location(String Department) throws Throwable {
    mrktstrt.verifydepartmentdeleteinReview(Department);

}

@And("I confirm count area")
public void i_confirm_count_area() throws Throwable {
mrktstrt.confirmCountArea();
}


@And("I verify confirmed item display Completed in Backup location")
public void i_verify_confirmed_item_display_completed_in_backup_location() throws Throwable {
mrktstrt.verifyCompletedBackup();
}


@Then("I click Approval Tab")
public void i_click_Approval_Tab() throws Throwable {
    mrktstrt.clickApprovalTab();
}

@Then("I click Approve button")
public void i_click_Approve_button() throws Throwable {
   mrktstrt.clickApproveButton();
}

@Then("I see product is APPROVED")
public void i_see_product_is_APPROVED() throws Throwable {
   mrktstrt.verifyApproved();
}



@Then("I verify Approve button is disabled")
public void i_verify_Approve_button_is_disabled() throws Throwable {
  mrktstrt.verifyApprovebuttondisble();  
}

@Then("I capture location coordinates")
public void i_capture_location_coordinates() throws Throwable {
    mrktstrt.captureLocationCoordinates();
}

@Then("I verify product position remain same")
public void i_verify_product_position_remain_same() throws Throwable {
   mrktstrt.verfypositionremainsame();
}
@Then("I verify {string} is return in response")
public void i_verify_is_return_in_response(String type1 ) throws Throwable {
	glhNegativePromptServicePO.verifywalkType(type1);
}

@Then("I verify walkid is return in response")
public void i_verify_walkid_is_return_in_response() throws Throwable {
	glhNegativePromptServicePO.verifywalkId();
}

@Then("I verify curfew store flag is return in response")
public void i_verify_curfew_store_flag_is_return_in_response() throws Throwable {
	glhNegativePromptServicePO.verifyCurfewflag();
}

@Then("Get Storewalk service response for MS store {string}")
public void getStorewalkServiceDetails(String storeId) throws Throwable {
	walkIds = glhBurstService.getWalkIdServicesMS(storeId);
	System.out.println("Walkid : "+ walkIds);
}

@Given("Request is made to Get all Capture Storewalk services for store {string} and userID {string}")
public void request_is_made_to_get_all_capture_storewalk_services_for_store_something_and_userid_something(String storeId, String userId) throws Throwable {
	glhNegativePromptServicePO.getStoreWalkAllcaptures(storeId,walkId,userId);

}

@Then("Get all Captures storewalk reponse")
public void get_all_Captures_storewalk_reponse() throws Throwable {
	glhNegativePromptServicePO.getStoreWalkAllcapturesStatus();
}

@Then("I Verify API response is 200")
public void verifyApiResponse() throws Throwable {
	glhNegativePromptServicePO.verifyStorewalkItemAPIRepsonse();
}


@Given("Request is made to Get Storewalkitems services for store {string}")
public void request_is_made_to_Get_Storewalkitems_services_for_store(String storeId) throws Throwable {
	glhNegativePromptServicePO.getStoreWalkItems(storeId,walkId);

}

@Then("Get storewalkitems response")
public void get_storewalkitems_response() throws Throwable {
	glhNegativePromptServicePO.getStoreWalkItemsStatus(); 
}

//@Given("Request is made to post Create Capture services for store {string} and Products {string}")
//public void request_is_made_to_post_Create_Capture_services_for_store_and_Products(String storeId, String product) throws Throwable {
//	glhNegativePromptServicePO.createCaptureService(storeId,walkId,product);
//}
//
//@Given("User performs operation for Create Capture Service")
//public void user_performs_operation_for_Create_Capture_Service() throws Throwable {
//   
//}

//@Then("get Create Capture response")
//public void get_Create_Capture_response() throws Throwable {
//    // Write code here that turns the phrase above into concrete actions
//    throw new PendingException();
//}

@Then("I verify no orange out of stock popup is visible")
public void i_verify_no_orange_out_of_stock_popup_is_visible() throws Throwable {
   mrktstrt.verifynoOrangelabelvisible();
}

@Then("I verify Count Type as {string}")
public void i_verify_Count_Type_as(String aType) throws Throwable {
   mrktstrt.captureCountTypeinCounter(aType);
}

@Then("I verify Stock UOM as {string}")
public void i_verify_Stock_UOM_as(String aUOM) throws Throwable {
  mrktstrt.capturestockUOMinStockinfo(aUOM);  
}


@Then("I verfiy Low, High marked product are editable")
public void i_verfiy_Low_High_marked_product_editable() throws Throwable {
   mrktstrt.lowhigheditable();
}


@Then("I verfiy Gap marked product is not editable")
public void i_verfiy_Gap_marked_product_not_allowed_to_mark_Low_or_High() throws Throwable {
    mrktstrt.verifynotAllowedtoclick();
}



@Then("I verify popup msg for Section Completed")
public void i_verify_popup_msg_for_Section_Completed() throws Throwable {
   mrktstrt.verfiydeleteSectionCompletemsg();
}


@Then("I verify last capture within 3 days")
public void i_verify_last_capture_within_days() throws Throwable {
mrktstrt.verifyStockInfo3days();
}

@Then("I click Stock Information in Hotkey")
public void i_click_Stock_Information_in_Hotkey() throws Throwable {
    mrktstrt.clickStockInformation();
}

@Then("I verify Capture Type as {string}")
public void i_verify_Capture_Type_as(String type) throws Throwable {
    mrktstrt.verifyCapturetypeinStockInfo(type);

}

@Then("I verify first warning message is displayed")
public void i_verify_first_warning_message_is_displayed() throws Throwable {
    mrktstrt.deadlinemsgfirst();
}

@Then("I verify second warning  message is displayed")
public void i_verify_second_warning_message_is_displayed() throws Throwable {
    mrktstrt.deadlinemsgsecond();
}

@Then("I verify second slot end time message is displayed")
public void i_verify_second_slot_end_time_message_is_displayed() throws Throwable {
  mrktstrt.deadlineendmsgsecond();
}


@Then("I see MIN, Product description, Adjustment value, Stock record, Counted, Adjustment")
public void i_see_MIN_Product_description_Adjustment_value_Stock_record_Counted_Adjustment() throws Throwable {
   mrktstrt.verifyprodcutdetailinReview();
}



@Then("I verify alphabetic order sorting for list")
public void i_verify_alphabetic_order_sorting_for_list() throws Throwable {
    mrktstrt.verifySorting();
}

@Then("I see Approve label")
public void i_see_Approve_label() throws Throwable {
    mrktstrt.verifyApproveinApproveTab();
}

@Then("I click Confirm all Zero")
public void i_click_Confirm_all_Zero() throws Throwable {
   mrktstrt.clickConfirmallzero();
}

@Then("I verify zero marked products")
public void i_verify_zero_marked_products() throws Throwable {
   mrktstrt.verifyZeroforproduct();
}

@Then("I verify Confirm all zero dissappers")
public void i_verify_Confirm_all_zero_dissappers() throws Throwable {
   mrktstrt.isconfirmallzeroPresent();
}

@Then("I verify Confirm all Zero Button present")
public void i_verify_Confirm_all_Zero_Button_present() throws Throwable {
    mrktstrt.verifyConfirmallzero();
}

@Then("I click Exit Backup")
public void i_click_Exit_Backup() throws Throwable {
    mrktstrt.exitBackup();
}

@Then("I verify {string} department is Displayed")
public void i_verify_department_is_Displayed(String type) throws Throwable {
   mrktstrt.verifyDepartment(type);
}

@Then("I verify {string} section is Displayed")
public void i_verify_section_is_Displayed(String type) throws Throwable {
   mrktstrt.verifySection(type);
}

@Then("I verify department header status as {string}")
public void i_verify_department_header_status_as(String status) throws Throwable {
   mrktstrt.verifyDepartmentheaderStatus(status);
}

@Then("I verify section header status as {string}")
public void i_verify_section_header_status_as(String status) throws Throwable {
  mrktstrt.verifySectionheaderStatus(status);
}
@Then("I verify Delete not allowed in Other")
public void i_verify_Delete_not_allowed_in_Other() throws Throwable {
   mrktstrt.verifyDeletenotAllowed();
}

@Then("I verify Delete not allowed in Backup")
public void i_verify_Delete_not_allowed_in_Backup() throws Throwable {
   mrktstrt.verifyDeletenotAllowed();
}


@Then("I verify Scanning not allowed")
public void i_verify_Scanning_not_allowed() throws Throwable {
	 mrktstrt.verifyScanningnotallowed();
}

@Then("I verify SOH value is being display")
public void i_verify_SOH_value_is_being_display() throws Throwable {
    mrktstrt.verifyStockOnHand();
}


@Then("I Verify count for the scanned items which are ready to review")
public void i_Verify_count_for_the_scanned_items_which_are_ready_to_review() throws Throwable {
    mrktstrt.verifyCountinReview();
}

@Then("I Verify count for the scanned items in Approval Tab")
public void i_Verify_count_for_the_scanned_items_in_Approval_Tab() throws Throwable {
   mrktstrt.verifyCountinApprovalTab();
}

@Then("I verify adjustment value more than (\\d+)pound")
public void i_verify_adjustment_value_more_than_pound() throws Throwable {
    mrktstrt.verifyAdjustmentvalue();
}
@Then("I verify text is under High is {string} in summary GLH")
public void i_verify_text_is_under_high_is_in_summary_glh(String arg1) throws Throwable {
	mrktstrt.textUnderhigh(arg1);
}

@Then("I verify total under high is \\\"([^\\\"]*)\\\"")
public void i_verify_total_under_high_is(String total) throws Throwable {
    mrktstrt.totalSummary(total);
}



@Then("I verfiy {string} count is not changed")
public void i_verfiy_count_is_not_changed(String arg1) throws Throwable {
    mrktstrt.verifyCount1();

}

@Then("I verify no Delist/Derange label is displayed")
public void i_verify_no_Delist_Derange_label_is_displayed() throws Throwable {
	   mrktstrt.verifynoOrangelabelvisible();
}

@Then("I verify no Delist/Derange with effective Date label is displayed")
public void i_verify_no_Delist_Derange_with_effective_Date_label_is_displayed() throws Throwable {
	   mrktstrt.verifynoOrangelabelvisible();
}

@Then("I verify no Delist/Derange label with Delivery date is displayed")
public void i_verify_no_Delist_Derange_label_with_Delivery_date_is_displayed() throws Throwable {
	   mrktstrt.verifynoOrangelabelvisible();

}

@Then("I verify no Delist Derange label with Delivery date as {string} is displayed")
public void i_verify_no_Delist_Derange_label_with_Delivery_date_as_is_displayed(String arg1) throws Throwable {
	   mrktstrt.verifynoOrangelabelvisible();

}

@Then("I verify no Delist Derange label with Delivery date as {string} \\(Less Than System date) is displayed")
public void i_verify_no_Delist_Derange_label_with_Delivery_date_as_Less_Than_System_date_is_displayed(String arg1) throws Throwable {
	   mrktstrt.verifynoOrangelabelvisible();

}



@Then("I verify Count Variance attribute")
public void i_verify_Count_Variance_attribute() throws Throwable {
    mrktstrt.verifyCountVarience();
}

@Then("I verify Counted Quantity {string} same as onshelf")
public void i_verify_Counted_Quantity_same_as_onshelf(String Counted) throws Throwable {
	mrktstrt.verifylastcaptureCountedquantity(Counted);
}

}


