package com.morrisons.sma.step_definitions.mobile.popups;

import io.cucumber.java.en.And;
import org.apache.log4j.Logger;
import com.morrisons.sma.page_objects.mobile.popups.PopUpPO_New;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.Locale;

public class PopUpStepDefs_New {

    private final Logger log = Logger.getLogger(PopUpStepDefs_New.class);
    PopUpPO_New popUpPONew = new PopUpPO_New();

    @Then("Verify {string} alert is displayed")
    public void verifyAlertName(String expectedAlertName) throws Throwable {
        popUpPONew.verifytitle(expectedAlertName);
    }

    @Then("Verify {string} alert is not displayed")
    public void verifyAlertNotDisplayed(String exepctedAlertName) throws Throwable {
        popUpPONew.verifyAlertNotDisplayed(exepctedAlertName);
    }

    @Then("I should get a Message saying {string} and should be able to click the {string} Button")
    public void iShouldGetAMessageSayingAndShouldBeAbleToClickTheContinueButton(String message, String button) throws Throwable {
        PopUpPO_New oPopUp = new PopUpPO_New();
        switch (button.toUpperCase(Locale.ROOT)) {
            case "DONE":
                popUpPONew.verifyMessageNClickOnDone(message);
                break;
            case "CANCEL":
                popUpPONew.verifyMessageNClickOnCancel(message);
                break;
            case "CONTINUE":
                popUpPONew.verifyMessageNClickOnContinue(message);
                break;
            case "OK":
                popUpPONew.verifyMessageNClickOnOk(message);
                break;
            case "YES":
                popUpPONew.verifyMessageNClickOnYes(message);
//                popUpPONew.CheckAndClickOKBtn();
                break;
            case "NO":
                popUpPONew.verifyMessageNClickOnNo(message);
                break;
            case "SUBMIT":
                popUpPONew.verifyMessageNClickOnSubmit(message);
                break;
            case "CONFIRM":
                popUpPONew.verifyMessageNClickOnConfirm(message);
                break;
            default:
                log.error("No Such Button : " + button);
                Assert.fail("No Such Button : " + button);
        }
        Thread.sleep(3000);
    }

    @Then("I should get a pop up title saying {string}")
    public void ishouldGetATitleSaying(String title) throws Throwable {
        popUpPONew.verifytitle(title);
    }


    @Then("I should be able to click the {string} Button")
    public void iShouldBeAbleToClickTheButton(String btnConfirm) throws Throwable {
        try {
            popUpPONew.clickOnConfirmButton();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }


    @Then("I should get a Message saying {string}")
    public void iShouldGetAMessageSaying(String message) throws InterruptedException {
        popUpPONew.verifyFlashMessage(message);
    }
}



