package com.morrisons.sma.step_definitions.mobile.trays;

import org.apache.log4j.Logger;
import com.morrisons.sma.page_objects.mobile.trays.CompleteCheckPO_New;
import io.cucumber.java.en.And;

public class CompleteCheckStepDefs_New {

    private final Logger log = Logger.getLogger(CompleteCheckPO_New.class);
    CompleteCheckPO_New completeCheckPONew = new CompleteCheckPO_New();

    @And("I verify Complete Check {string} on screen")
    public void iVerifyCompleteCheckOnScreen(String message) throws Throwable {
        completeCheckPONew.verifyCompleteCheckMessage(message);
    }

    @And("I click on Complete & Review button on Complete Check screen")
    public void iClickOnCompleteReviewButtonOnCompleteCheckScreen() {
        completeCheckPONew.clickCompleteReviewButton();
    }

    @And("I verify No Waste Generated {string} on screen")
    public void iVerifyNoWasteGeneratedOnScreen(String message) throws Throwable {
        completeCheckPONew.verifyNoWasteMessage(message);
    }

    @And("click on Confirm button on Complete Check screen")
    public void clickOnConfirmButtonOnCompleteCheckScreen() throws Throwable {
        completeCheckPONew.clickConfirmButton();
    }

    @And("I click on Cancel button on Complete Check screen")
    public void iClickOnCancelButtonOnCompleteCheckScreen() {
        completeCheckPONew.clickCancelButton();
    }
}
