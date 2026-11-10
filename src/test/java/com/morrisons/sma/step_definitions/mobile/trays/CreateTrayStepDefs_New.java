package com.morrisons.sma.step_definitions.mobile.trays;

import com.morrisons.sma.page_objects.mobile.trays.CreateTrayPO_New;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;

public class CreateTrayStepDefs_New {

    private final Logger log = Logger.getLogger(CreateTrayStepDefs_New.class);

    CreateTrayPO_New createTrayPONew = new com.morrisons.sma.page_objects.mobile.trays.CreateTrayPO_New();


    @And("I create {string} trays")
    public void iCreate(String noOfTrays) throws Throwable {
        createTrayPONew.enterTraysNConfirm(noOfTrays);
    }

    /*
    Backhaul Tray Screen
     */
    @And("I verify backhaul header and tray count description {string}")
    public void iVerifyBackhaulHeaderAndTrayCountDescription(String message) throws Throwable {
        createTrayPONew.verifybackhualScreenMessage(message);
    }

    @And("I enter tray quantity {string} and confirm the same")
    public void iEnterTrayQuantityAndConfirmTheSame(String quantity) throws Throwable {
        createTrayPONew.enterbackhualTraysNConfirm(quantity);
    }

    @And("I verify header and tray count description {string}")
    public void iVerifyHeaderAndTrayCountDescription(String message) throws Throwable {
        iVerifyBackhaulHeaderAndTrayCountDescription(message);
    }

    @Then("I should get the header saying {string} and description saying {string}")
    public void iShouldGetTheHeaderSayingAndDescriptionSaying(String header, String description) throws Throwable {
        createTrayPONew.verifyHeaderNDescriptionMessage(header, description);
    }

    @And("I verify Empty Tray {string} on screen")
    public void iVerifyEmptyTrayOnScreen(String expectedMessage) throws Throwable {
        createTrayPONew.emptyTrayMessage(expectedMessage);
    }
}
