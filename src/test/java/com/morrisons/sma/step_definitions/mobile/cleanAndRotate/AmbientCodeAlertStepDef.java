package com.morrisons.sma.step_definitions.mobile.cleanAndRotate;

import com.morrisons.sma.page_objects.mobile.cleanAndRotate.AmbientFrozenCodeAlert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class AmbientCodeAlertStepDef{

    AmbientFrozenCodeAlert ambientFrozenCodeAlert = new AmbientFrozenCodeAlert();

    @Then("I click on Alert dropdown")
    public void iClickOnAlertDrpdwn() throws Throwable {
        ambientFrozenCodeAlert.clickOnAlertList();
    }

    @And("I verify Ambient Frozen Code Alert Title type")
    public void iVerifyAlertType() throws Throwable {
        ambientFrozenCodeAlert.verifyAlertType();
    }

    @And("I verify Product Expiry")
    public void iVerifyProdctExpry() throws Throwable {
        ambientFrozenCodeAlert.verifyExpiryDate();
    }

    @And("I verify on Product Min list")
    public void iVerifyProdMin() throws Throwable {
        ambientFrozenCodeAlert.verifyProductMin();
    }

    @And("I select {string} from the Alert dropdown")
    public void iSelectFromTheDropdown(String alertOption) throws Throwable {
        ambientFrozenCodeAlert.clickOnAlertOption(alertOption);
    }


    @And("I select product on Ambient and Frozen code page")
    public void iClickOnProduct() throws Throwable {
        ambientFrozenCodeAlert.clickOnProductList();
    }
}
