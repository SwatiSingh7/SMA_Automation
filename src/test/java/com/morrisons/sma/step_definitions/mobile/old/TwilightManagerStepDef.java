package com.morrisons.sma.step_definitions.mobile.old;

import org.apache.http.HttpResponse;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import com.morrisons.sma.page_objects.mobile.old.TwilightManagerPO;

public class TwilightManagerStepDef {

	TwilightManagerPO twilightManagerPO = new TwilightManagerPO();
	
	public static HttpResponse Response;
	
	@Then("Select plan from alert")
	public void selectfromlist() throws Throwable {
		twilightManagerPO.selectfromlist();
	}
	
/*	@Then("I click on {string} button")
	public void clickOnButton(String button) throws Throwable {
		twilightManagerPO.clickOnButton(button);
	}*/
	
	
	@And("I completed section for all the department")
	public void completeTheLocation() throws Throwable {
		String qty = "800";
		twilightManagerPO.completeTheLocation(qty);
	}
	
	@And("I verify Approval required alert is displayed with message as {string}")
	public void verifyApprovalRequiredAlert(String alertName) throws Throwable {
		twilightManagerPO.verifyApprovalRequiredAlert(alertName);
	}
	
	@And("I click on Product in Approval tab")
	public void clickOnProduct() throws Throwable {
		twilightManagerPO.clickOnProduct();
	}
	
	@And("I verify Confirm alert is displayed")
	public void verifyConfirmAlert() throws Throwable {
		twilightManagerPO.verifyConfirmAlert();
	}
	
	@And("I click on Approve button")
	public void clickOnApproveButton() throws Throwable {
		twilightManagerPO.clickOnApproveButton();
	
	}
	
	@And("I verify Approve item alert is displayed")
	public void verifyPromptedConfirmAlert() throws Throwable {
		twilightManagerPO.verifyPromptedConfirmAlert();
	}
	
	@Then("I verify Summary & sign off screen is displayed")
	public void verifySummaryAndSignOff() throws Throwable {
		twilightManagerPO.verifySummaryAndSignOff();
	}
	
	@Then("I verify Access Restricted alert is displayed with message as {string}")
	public void accessRestrictedAlert(String message) throws Throwable {
		twilightManagerPO.accessRestrictedAlert(message);
	}
	
	@Then("I verify Sign off button is displayed and enabled")
	public void verifySignOffButton() throws Throwable {
		twilightManagerPO.verifySignOffButton();
	}
	
	@Then("I verify Approve button is {string}")
	public void verifyApproveButton(String btnStatus) throws Throwable {
		twilightManagerPO.verifyApproveButton(btnStatus);
	}
	

}