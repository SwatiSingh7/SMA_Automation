package com.morrisons.sma.step_definitions.mobile.old;

import java.util.ArrayList;
import java.util.List;

import com.morrisons.common.action.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.appium.java_client.android.AndroidDriver;
import com.morrisons.sma.page_objects.mobile.old.Markdown_newPO;

public class Markdown_newstepdef {
	
	private static AndroidDriver driveR;
	public static List<String> walkIds = new ArrayList<String>();
	static String walkId;

	public Markdown_newstepdef()
	{		
	this.driveR = (AndroidDriver) Hook.getDriver();
	}
	Markdown_newPO mrkdwn = new Markdown_newPO();
	
	
@Then("I select Expiry Date for record Out of code")
public void i_select_Expiry_Date_for_record_Out_of_code() throws Throwable {
mrkdwn.selectexpirydate();
}

@Then("I Enter Expiry Quantity {string} for record Out of code")
public void i_Enter_Expiry_Quantity_for_record_Out_of_code(String quantity) throws Throwable {
    mrkdwn.selectquantity(quantity);
}
    
    @Then("I click MarkdownList")
	public void i_click_on_MarkdownLists() throws Throwable {
    	mrkdwn.clickmarkdownlist();
	}
    
    @Then("I click yes")
	public void i_select_yes() throws Throwable {
    	mrkdwn.clickyes();
	}
    
    @Then("I verify Scanning option not present in markdown list")
    	public void i_verify_scanning_option() throws Throwable {
    	mrkdwn.verifyScanninginMarkdownlist();
    	    }


@Given("device is in offline mode")
public void device_is_in_offline_mode() throws Throwable {
	mrkdwn.disbleWifinData();
}


@Then("I enable wifi n data for login")
public void i_enable_wifi_n_data_for_login() throws Throwable {
   driveR.toggleWifi();
   driveR.toggleData();
}

@Then("I user not able to login")
public void i_user_not_able_to_login() throws Throwable {
   
}
@Then("I verify error message displayed")
public void i_verify_the_message_displayed() throws Throwable {
	mrkdwn.errorBarcodeMsg();
}


@Then("I see original price")
public void i_see_original_price() throws Throwable {
   mrkdwn.originalPrice();
}

@Then("I see new price")
public void i_see_new_price() throws Throwable {
   mrkdwn.NewPrice();
}

@Then("I select percentage {string} and see calculated value")
public void i_select_percentage_and_see_calculated_value(String percent) throws Throwable {
    mrkdwn.selectpercentage(percent);
}

@Then("I see Warning message")
public void i_see_Warning_message() throws Throwable {
   mrkdwn.warningmsgrestricted();
}

@Then("I click continue")
public void i_click_continue() throws Throwable {
    mrkdwn.clickContinue();
}

@Then("I verify service persist one entry for MIN")
public void i_verify_service_persist_one_entry_for_MIN() throws Throwable {
  mrkdwn.verifyuniqueMIN();
}


@Then("I click on product")
public void i_click_on_product() throws Throwable {
    mrkdwn.clickProduct();
}

@Then("I verify Product Name, MIN, EAN, Original Price, New Price")
public void i_verify_Product_Name_MIN_EAN_Original_Price_New_Price() throws Throwable {
    mrkdwn.verifyitemSummary();
}

@Then("I verfiy error message for Maximum Markdown")
public void i_verfiy_error_message_for_Maximum_Markdown() throws Throwable {
   mrkdwn.verifyMaximummarkdownmsg();
}

@Then("I capture markdown price")
public void i_capture_markdown_price() throws Throwable {
    mrkdwn.capturePrice();
}

@Then("I verify markdown price is same")
public void i_verify_markdown_price_is_same() throws Throwable {
mrkdwn.verifymarkdwnPrice();   
}

@Then("I verify percentage details text is not displayed")
public void i_verify_percentage_details_text_is_not_displayed() throws Throwable {
   mrkdwn.verifypercentdeatailsnotPresent();
}



@Then("I see item Summary")
public void i_see_item_Summary() throws Throwable {
    mrkdwn.verifyitemSummary();
}

//@Then("I verify two records for same Barcode")
//public void i_verify_two_records_for_same_Barcode() throws Throwable {
//   /////
//}

@Then("I see change category option")
public void i_see_change_category_option() throws Throwable {
    mrkdwn.ChangeCategory();
}

@Then("I verify user redirected to Edit Item Screen")
public void i_verify_user_redirected_to_Edit_Item_Screen() throws Throwable {
    mrkdwn.verfiyEditItemScreen(); //check again
}

@Then("I verify user allowed to do save changes")
public void i_verify_user_allowed_to_do_save_changes() throws Throwable {
    mrkdwn.clickSaveChange();
}

@Then("I see Large markdown quantity warning message")
public void i_see_Large_markdown_quantity_warning_message() throws Throwable {
   mrkdwn.largequantitymsg();
}
@Then("I verify number of category completed in Department screen is displayed")
public void i_verify_number_of_category_completed_in_Department_screen_is_displayed() throws Throwable {
    mrkdwn.departmentScreen();
}

@Then("I verify Optimised price parameters")
public void i_verify_Optimised_price_parameters() throws Throwable {
    mrkdwn.VerifyOptimisedPriceParameters();
}
   

@Then("I get percentage list form UI")
public void i_get_percentage_list_form_UI() throws Throwable {
mrkdwn.verifypercentlistupto();
	   }


@Then("I verify percentage dropdown {string} or {string} whichever greater")
public void i_verify_percentage_dropdown_or_whichever_greater(String Maxpercent, int MinPrice) throws Throwable {
   mrkdwn.verifypercentagedropdwninUI(Maxpercent,MinPrice);
}

@Then("I verify GET markdown details API response till {string} or {string} whichever greater")
public void i_verify_GET_markdown_details_API_response_till_or_whichever_greater(String Maxpercent, int MinPrice) throws Throwable {
	   mrkdwn.verifyMaxpercentage(Maxpercent,MinPrice);
}


@Then("I verify GET markdown details API response is (\\d+)")
public void i_verify_GET_markdown_details_API_response_is() throws Throwable {
  mrkdwn.verifyAPIresponse();
}
}





