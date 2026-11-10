package com.morrisons.sma.step_definitions.mobile.items;

import org.apache.log4j.Logger;
import com.morrisons.sma.page_objects.mobile.items.SubmitListPO_New;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;

public class SubmitListStepDefs_New {

    private final Logger log = Logger.getLogger(SubmitListStepDefs_New.class);
    SubmitListPO_New submitListPONew = new SubmitListPO_New();


    @And("I confirm the Submit List")
    public void iConfirmTheSubmitList() throws Throwable {
        submitListPONew.clickOnSubmitList();
    }

    @And("I complete the tray")
    public void iCompleteTheTray() throws Throwable {
        submitListPONew.clickOnCompleteTrayButton();
    }

    @And("I click on {string} from list")
    public void iClickOnFromList(String itemScanned) {
        submitListPONew.clickScannedItem(itemScanned);
    }

    @Then("I verify Product description, Product MIN")
    public void verifyProductdescriptionProductMIN(List<String> prodDescription) throws Throwable {
        submitListPONew.verifyProduct(prodDescription.get(0),
                prodDescription.get(1),
                prodDescription.get(2));
    }

    @And("verify screen with title {string} and message {string} and I click on {string} button")
    public void verifyScreenWithTitleAndIClickOnReviewEditButton(String title, String message, String button) throws Throwable{
        submitListPONew.verifyScreenClickReviewEditButton(title, message, button);
    }

    @And("I verify {string} button displayed on screen")
    public void iVerifyButtonDisplayedOnScreen(String completeTrayBtn) throws Throwable {
        submitListPONew.verifyCompleteTrayDisplayed(completeTrayBtn);
    }

    @And("I verify {string} button is displayed on screen")
    public void iVerifyButtonIsDisplayedOnScreen(String reviewEditBtn) {
        submitListPONew.verifyReviewEditButtonDisplayed(reviewEditBtn);
    }

    @And("I verify {string} button is {string}")
    public void iVerifyButtonIs(String button, String enableDisable) throws InterruptedException {
        submitListPONew.verifyBtnEnabledDisabled(button, enableDisable);
    }

    @Then("I verify PIN description, PIN MIN")
    public void iVerifyPINDescriptionPINMIN(List<String> pinDescription) throws Throwable {
        submitListPONew.verifyPIN(pinDescription.get(0),
                pinDescription.get(1),
                pinDescription.get(2));
    }
}
