package com.morrisons.sma.step_definitions.mobile.trays;

import org.apache.log4j.Logger;
import com.morrisons.sma.page_objects.mobile.trays.TraySelectionPO_New;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.io.FileNotFoundException;
import java.util.List;

public class TraySelectionStepDefs_New {

    private final Logger log = Logger.getLogger(TraySelectionStepDefs_New.class);
    TraySelectionPO_New traySelectionPONew = new TraySelectionPO_New();

    public TraySelectionStepDefs_New() throws FileNotFoundException {
    }


    @And("I select tray {string}")
    public void iSelectTray(String selectTray) throws Throwable {
        traySelectionPONew.selectTray(selectTray);
    }

    @And("I add a new tray by clicking on Add Button")
    public void iAddANewTrayByClickingOnAddButton() throws Throwable {
        traySelectionPONew.clickOnAddTrayButton();
    }

    @And("I verify that following trays are created")
    public void iVerifyThatThereAreTraysCreated(List<String> trayList) throws InterruptedException {
        traySelectionPONew.verifyNoOfTrays(trayList);
    }

    @Then("verify status of tray {string}")
    public void verifyStatusOfTray(String trayStatus) throws Throwable {
        traySelectionPONew.verifyStatusOfTray(trayStatus);
    }

    @And("I click on Complete Check button")
    public void iClickOnCompleteCheckButton() throws Throwable {
        traySelectionPONew.clickOnCompleteCheckButton();
    }


    @And("^I verify validation check screen message$")
    public void iVerifyValidationCheckScreenMessage() {
        traySelectionPONew.verifyMessageOfValidationCheckScreen();
    }
    @And("I verify Add New Tray button is displayed and {string}")
    public void iVerifyAddNewTrayButtonIsDisplayedAnd(String statusEnableDisable) throws InterruptedException {
        traySelectionPONew.verifyAddTrayDisplayedAndStatus(statusEnableDisable);

    }
}
