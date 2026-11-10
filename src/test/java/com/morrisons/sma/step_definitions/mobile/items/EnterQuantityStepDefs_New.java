package com.morrisons.sma.step_definitions.mobile.items;

import io.cucumber.java.en.Given;
import org.apache.log4j.Logger;
import com.morrisons.sma.page_objects.mobile.items.EnterQuantityPO_New;
import io.cucumber.java.en.And;

public class EnterQuantityStepDefs_New {

    private final Logger log = Logger.getLogger(EnterQuantityStepDefs_New.class);
    EnterQuantityPO_New enterQuantityPONew = new EnterQuantityPO_New();

    @And("I enter the desired quantity {string} and confirm the same")
    public void iEnterTheDesiredQuantityAndConfirmTheSame(String quantity) throws Throwable {
        enterQuantityPONew.enterQuantityNConfirm(quantity);
    }

    @And("I enter the quantity as {string}")
    public void enterQuantity(String quantity) throws Throwable {
        enterQuantityPONew.enterProductQuantity(quantity);
    }

    @And("I enter the quantity {string} and enter package size {string}")
    public void iEnterTheQuantityAndPacksize(String quantity, String packsize) throws Throwable {
        enterQuantityPONew.enterQuantity(quantity);
        enterQuantityPONew.verifyItemMultiplyCount(quantity, packsize);
        enterQuantityPONew.clickOnConfirmButton();
    }

    @And("I enter the quantity as {string} in Quantity textbox")
    public void enterCnRQuantity(String quantity) throws Throwable {
        enterQuantityPONew.enterCnRQuantity(quantity);

    }

    @And("I enter the desired quantity {string}")
    public void iEnterTheDesiredQuantity(String quantity) {
        enterQuantityPONew.enterQtty(quantity);
    }

    @And("I enter the desired quantity {string} on code alert")
    public void iEnterTheDesiredQuantityOnCodeAlert(String quantity) {
        enterQuantityPONew.enterQuantityCodeAlert(quantity);
    }
}

