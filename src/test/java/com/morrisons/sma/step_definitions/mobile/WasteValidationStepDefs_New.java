package com.morrisons.sma.step_definitions.mobile;


import com.google.inject.Inject;
import com.morrisons.common.utility.ApplicationContext;
import com.morrisons.sma.page_objects.mobile.WasteValidationPO_New;
import com.morrisons.sma.page_objects.mobile.messagescreens.MessageScreenPO_New;
import com.morrisons.sma.page_objects.mobile.popups.PopUpPO_New;
import com.morrisons.sma.page_objects.mobile.wastevalidation.ReviewPO_New;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;

public class WasteValidationStepDefs_New {

    private final Logger log = Logger.getLogger(WasteValidationStepDefs_New.class);
    WasteValidationPO_New wasteValidationPONew = new WasteValidationPO_New();
    MessageScreenPO_New messageScreenPONew = new MessageScreenPO_New();
    ReviewPO_New reviewPONew = new ReviewPO_New();

    PopUpPO_New popup = new PopUpPO_New();

    private final ApplicationContext applicationContext;

    @Inject
    public WasteValidationStepDefs_New(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }


    @And("I click on {string} on Waste Validation Page")
    public void iClickOnOnWasteValidationPage(String validationCheckOption) throws Throwable {
        wasteValidationPONew.clickOnWasteValidationPage(validationCheckOption);
    }

    @Then("{string} should get displayed on Waste Validation Page")
    public void shouldGetDisplayed(String stockAdjustmentOption) throws Throwable {
        wasteValidationPONew.verifyOnWasteValidationPage(stockAdjustmentOption);
    }

    @Then("I should get a title saying {string} and a message saying {string}")
    public void iShouldGetATileSayingAndAMessageSaying(String title, String message) throws Throwable {
        messageScreenPONew.verifyTitleNMessage(title, message);
    }

    @And("verify the Validation Check Status is {string}")
    public void verifyTheValidationCheckStatusIs(String status) {
        wasteValidationPONew.verifyValidationCheckStatus(status);
    }

    @And("I Verify the status of review option")
    public void iVerifyTheReviewStatus() throws Throwable {
        reviewPONew.veirfyReviewEnabled();
 /*       boolean result = true;
        log.info("Verifying the status of review option ");
        result = checkElementExist(reviewPONew.optReviewStatus);
        if (result) {
            log.info("Review option status is verified as 'Review Ready'");
        } else {
            Assert.fail("Review option status verification failed.");
        }*/
    }

    @Then("I click on the Continue Button")
    public void iOnClickTheContinueButton() throws Throwable {
        popup.clickOnContinueButton();
    }

    @And("verify the Review Status is {string}")
    public void verifyTheReviewStatusIs(String status) {
        wasteValidationPONew.verifyReviewStatus(status);
    }

    @And("I check the results in another Step Def File")
    public void iCheckTheResultsInAnotherStepDefFile() {
        log.info("Database result details : " + applicationContext.applicationDetailsMap.get("Single Row Multiple Column Data List"));

    }
/*
Weekly manager StepDef--
 */
    @And("I verify Weekly Manager Sign Off status {string}")
    public void iVerifyWeeklyManagerSignOffStatus(String status) {
        wasteValidationPONew.verifyweeklymanagerCheckStatus(status);
    }

    @And("I verify {string} is {string} and the next page option is {string}")
    public void iVerifyReviewIsInDisabledMode(String submenu, String statusOfSubMenu, String nextPageOpt) throws Throwable {
        wasteValidationPONew.verifyEnabledDisabled(submenu, statusOfSubMenu, nextPageOpt);
    }
}
