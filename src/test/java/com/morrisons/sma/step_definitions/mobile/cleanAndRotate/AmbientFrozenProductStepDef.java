package com.morrisons.sma.step_definitions.mobile.cleanAndRotate;

import com.morrisons.sma.page_objects.mobile.cleanAndRotate.AmbientFrozenProductAction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class AmbientFrozenProductStepDef {
    AmbientFrozenProductAction productAction = new AmbientFrozenProductAction();

    @Then("I verify Product Details on Date Code alert page")
    public void iVerifyProductInfo() throws Throwable {
        productAction.verifyProductDetails();
    }
    @And("I enter the desired quantity {string} for product")
    public void iEnterTheDesiredQuantity(String quantity) throws Throwable {
        productAction.enterItemQuantity(quantity);
    }
    @And("I click on Action Spinner and select {string} Action")
    public void iClickOnActionSpinner(String actionOption) throws Throwable {
        productAction.iClickOnSpinner(actionOption);

    }
    @And("I verify Quantity check message is displayed")
    public void iVerifyAlert() throws Throwable {
        productAction.iVerifyAlert();

    }
    @And("I click on cancel on Alert")
    public void clickOnCancel() throws Throwable{
        productAction.clickOnCnclButton();
    }

    @And("I verify Quantity input box is disabled")
    public void iVerifyQtyinputDisabled(){
        productAction.verifyQtyboxDisabled();
    }

    @And("I select the desired action {string} for product")
    public void iEnterTheNxtAction(String option) throws Throwable {
        productAction.clickOnActionOption(option);
    }
    @Then("I confirm the alert")
    public void iConfirmAlert() throws Throwable {
        productAction.clickOnConfrmButton();
    }

    @And("I Click on Add next action button on Ambient frozen page")
    public void iClickNxtActionBtn() throws Throwable {
        productAction.nextAcionClick();
    }
    @And("I verify Quantity check message is not displayed")
    public void iVerifyAlertNotDisplayed() throws Throwable{
        productAction.iVerifyAlertNotDisplayed();
    }

    @Then("I verify reason code and Title on Wastage popup")
    public void iVerifyWastagePopup() throws Throwable {
        productAction.wastageReasonCodePopupvalidation();
    }

    @And("I select the desired reason code {string} for product")
    public void iClickReasonCode(String option) throws Throwable {
        productAction.selectReasonCodeOption(option);
        productAction.clickOnConfrmButton();
    }

    @And("I confirm Reason Code and continue")
    public void iConfirmReasonCodeAndContinue() throws Throwable {
        productAction.clickOnConfrmButton();
    }

    @And("I cancel and continue")
    public void iCancelAndContinue() throws Throwable {
        productAction.clickOnCnclButton();
    }
    @And("I cancel the Quantity check message alert box")
    public void iCancelAlert() throws Throwable {
        productAction.clickOnCnclButton();
    }

}
