package com.morrisons.sma.step_definitions.mobile.items;

import com.morrisons.sma.page_objects.mobile.items.EnterPricePO_New;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import com.morrisons.sma.page_objects.mobile.items.EnterQuantityPO_New;
import io.cucumber.java.en.And;

import java.util.List;

public class EnterPriceStepDefs_New {

    private final Logger log = Logger.getLogger(EnterPriceStepDefs_New.class);
    EnterPricePO_New enterPricePONew = new EnterPricePO_New();

    @And("I verify fields displayed on screen for KG items")
    public void iVerifyFieldsDisplayedOnScreenForKGItems() throws Throwable {
        enterPricePONew.verifyFieldsForKGItems();
    }

    @And("I verify fields displayed on screen for EA items")
    public void iVerifyFieldsDisplayedOnScreenForEAItems() {
        enterPricePONew.verifyFieldsForEAItems();
    }

    @And("I enter the price {string} and I click on confirm button")
    public void iEnterThePriceAndIClickOnConfirmButton(String prodPrice) throws Throwable {
        enterPricePONew.enterProductPriceNConfirm(prodPrice);
    }

    @And("verify screen message with title {string} and message {string} and I click on {string} button")
    public void verifyScreenMessageWithTitleAndMessageAndIClickOnButton(String arg0, String arg1, String arg2) {
    }

    @And("verify screen message with title {string} and message {string}")
    public void verifyScreenMessageWithTitleAndMessage(String msgTitle, String screenMsg) throws Throwable {
        enterPricePONew.verifyTitleAndMessage(msgTitle, screenMsg);
    }

    @And("I verify item selling price {string} is auto-populated")
    public void iVerifyItemSellingPriceIsAutoPopulated(String price) {
        enterPricePONew.verifyPricePopulated(price);
    }

    @And("I verify the auto-populated item selling price is disabled")
    public void iVerifyTheAutoPopulatedItemSellingPriceIsDisabled() {
        enterPricePONew.verifyPriceDisabled();
    }

    @And("I verify the item is disabled")
    public void iVerifyTheItemIsDisabled() {
        enterPricePONew.verifyItemDisabled();
    }

    @And("I verify the {string} button is {string}")
    public void iVerifyTheButtonIs(String button, String enableDisable) throws InterruptedException {
        enterPricePONew.verifyButtonStatus(button, enableDisable);
    }
}
