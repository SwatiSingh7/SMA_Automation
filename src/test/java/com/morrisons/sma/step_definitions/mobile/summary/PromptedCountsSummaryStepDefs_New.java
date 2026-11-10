package com.morrisons.sma.step_definitions.mobile.summary;

import com.morrisons.sma.page_objects.mobile.summary.PromptedCountsSummaryPO_New;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;

public class PromptedCountsSummaryStepDefs_New {

    private final Logger log = Logger.getLogger(PromptedCountsSummaryStepDefs_New.class);
    PromptedCountsSummaryPO_New promptedCountsSummaryPONew = new PromptedCountsSummaryPO_New();

    @Then("I verify  Flagged & Actions Completed sections")
    public void iVerifyFlaggedActionsCompletedSections() {
        promptedCountsSummaryPONew.verifySections();
    }

    @And("verify Total Approvals is Disabled")
    public void verifyTotalApprovalsIsDisabled() {
        promptedCountsSummaryPONew.verifyApprovalsState();
    }

    @And("verify {string} department and its details")
    public void verifyDepartmentAndItsDetails(String deptName) {
        promptedCountsSummaryPONew.verifyDeptDetails(deptName);
    }

    @And("I scroll down to {string}")
    public void iScrollDownTo(String scrollToElement) {
        promptedCountsSummaryPONew.scrollTo(scrollToElement);
    }

    @And("click on {string} and verify its details")
    public void clickOnAndVerifyItsDetails(String depName) throws InterruptedException {
        promptedCountsSummaryPONew.clickAndVerifyDept(depName);
    }

    @And("I verify flagged items are {string}")
    public void iVerifyFlaggedItemsAre(String flaggedvalue) {
        promptedCountsSummaryPONew.verifyFlaggedValue(flaggedvalue);
    }

    @And("I verify Actions Completed are {string}")
    public void iVerifyActionsCompletedAre(String actionValue) {
        promptedCountsSummaryPONew.verifyActionValue(actionValue);
    }
}
