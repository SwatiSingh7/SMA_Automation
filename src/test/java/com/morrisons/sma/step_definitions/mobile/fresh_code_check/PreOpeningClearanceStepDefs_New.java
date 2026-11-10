package com.morrisons.sma.step_definitions.mobile.fresh_code_check;

import com.morrisons.sma.page_objects.mobile.freshCodeCheck.PreOpeningClearancePO_New;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;

public class PreOpeningClearanceStepDefs_New {

    private final Logger log = Logger.getLogger(PreOpeningClearanceStepDefs_New.class);
    PreOpeningClearancePO_New preOpeningClearance = new PreOpeningClearancePO_New();

    @And("I select {string} from the dropdown")
    public void iSelectFromTheDropdown(String actionOption) throws InterruptedException {
        preOpeningClearance.selectActionOption(actionOption);
    }

    @And("I select the date {int}")
    public void iSelectTheDate(int date) throws InterruptedException {
        preOpeningClearance.selectDate(date);
    }

    @And("I enter the desired quantity {string} and Log product")
    public void iEnterTheDesiredQuantityAndLogProduct(String quantity) {
        preOpeningClearance.enterQtyLogProduct(quantity);
    }

    @And("I select the {string} and confirm")
    public void iSelectTheAndConfirm(String wastageReason) {
        preOpeningClearance.selectWastageReasonAndConfirm(wastageReason);
    }

    @And("I confirm Clearance Bay Check and continue")
    public void iConfirmClearanceBayCheckAndContinue() {
        preOpeningClearance.clickConfirmAndContinue();
    }
   }
