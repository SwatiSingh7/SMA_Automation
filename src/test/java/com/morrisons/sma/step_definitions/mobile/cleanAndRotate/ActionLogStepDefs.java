package com.morrisons.sma.step_definitions.mobile.cleanAndRotate;

import com.morrisons.sma.page_objects.mobile.cleanAndRotate.ActionLog;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ActionLogStepDefs {

    ActionLog actionLog = new ActionLog();


    @Then("I click on Log Product button on Action log page")
    public void iClickOnOnActionWastePage() throws Throwable {
        actionLog.clickOnLogProductButton();
    }

    @Then("I click on View list")
    public void clickOnViewList() throws Throwable {
        actionLog.clickOnViewList();
    }

    @Then("I Verify product is logged with {string} action")
    public void verifyLoggedProductDetail(String expectedAction) throws Throwable {
        actionLog.verifyLoggedProductDetail(expectedAction);
    }

    @And("I select {string} Action on Action log page")
    public void clickOnActionOption(String actionOption) throws Throwable {
        actionLog.clickOnActionSpinner();
        actionLog.clickOnActionOption(actionOption);
    }

    @And("I select {string} Action on Wastage Reason alert and click on Confirm")
    public void clickOnWastageOption(String wastageOption) throws Throwable {
        actionLog.clickOnWastageOption(wastageOption);
        actionLog.clickOnConfirmButton();
    }

    @Then("I Verify Wastage reason Alert Title and Message")
    public void verifyWastageReasonAlert() throws Throwable {
        actionLog.verifyWastageReasonAlert();
    }

    @Then("I Select Current Date in Calendar")
    public void selectCurrentDate() throws Throwable {
        actionLog.selectCurrentDate();
    }

    @Then("I Select Current Date plus {int} date in Calendar")
    public void selectDate(int addDays) throws Throwable {
        actionLog.selectDate(addDays);
    }
    @Then("I verify 1st Markdown alert popup with {string} is displayed")
    public void isMarkdownAlertDisplayed(String expectedMessage) throws Throwable {
        actionLog.isAlertDisplayed(expectedMessage);
    }
    @Then("I verify {string} Action on Wastage Reason alert")
    public void isOptionDisplayedonWastagePopup(String actionOption) throws Throwable {
        actionLog.verifyWastageReasonPopUp(actionOption);
    }

    @Then("I verify 1st Markdown alert popup is not displayed")
    public void isMarkdownAlerNotDisplayed() throws Throwable {
        actionLog.alertNotDisplayed();
    }

    @Then("I verify Clearance Markdown alert popup with {string} is displayed")
    public void isClearanceAlertDisplayed(String expectedMessage) throws Throwable {
        actionLog.isAlertDisplayed(expectedMessage);
    }

    @Then("I Verify the latest scanned Product Min is visible at the top")
    public void verifyLatestScanMin() throws Throwable {
        actionLog.verifyLatestScanMin();
    }

    @Then("I Swipe left on View list screen")
    public void swipeLeft() throws Throwable {
        actionLog.swipeLeft();
    }
    @Then("I Verify Delete button is {string}")
    public void verifyDeleteButtonStatus(String buttonStatus) throws Throwable {
        actionLog.verifyDeleteButtonStatus(buttonStatus);
    }
    @Then("I Click On Delete button")
    public void clickOnDeleteButton() throws Throwable {
        actionLog.clickOnDeleteButton();
    }
    @Then("I Click on Complete Code Rotate Group button")
    public void clickOnCompleteCodeRotate() throws Throwable {
        actionLog.clickOnCompleteCodeRotate();;
    }
    @Then("I Click on Reopen code rotate group button")
    public void clickOnReopenCodeRotate() throws Throwable {
        actionLog.clickOnReopenCodeRotate();
    }

    @Then("I select {string} Action on Code Alert")
    public void iSelectActionOnCodeAlert(String actionOption) throws Throwable {
        actionLog.clickOnActionSpinner_CodeAlert();
        actionLog.clickOnActionOption(actionOption);
    }

}
