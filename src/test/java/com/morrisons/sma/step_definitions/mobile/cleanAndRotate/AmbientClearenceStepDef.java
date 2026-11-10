package com.morrisons.sma.step_definitions.mobile.cleanAndRotate;


import com.morrisons.sma.page_objects.mobile.cleanAndRotate.AmbientClearancePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class AmbientClearenceStepDef {
    AmbientClearancePage ambientClearencePage = new AmbientClearancePage();

    @Then("I verify Instruction Message on Ambient Clearance Bay Check page")
    public void isMessageDisplayed() throws Throwable {
        ambientClearencePage.verifyPageHeader();
    }
    @And("I click on Confirm Clearance Bay Check button on Ambient Clearance Bay Check page")
    public void iClickOnConfirmBaycheck() throws Throwable {
        ambientClearencePage.clickOnCnfrmbayCheckButton();
    }

}
