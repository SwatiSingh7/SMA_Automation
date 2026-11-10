package com.morrisons.sma.step_definitions.mobile.stock_adjustments;

import com.morrisons.sma.page_objects.mobile.stockAdjustment.OtherAdjustmentsPO;

import org.apache.log4j.Logger;

import io.cucumber.java.en.And;

public class OtherAdjustmentsStepDef {


    private final Logger log = Logger.getLogger(OtherAdjustmentsStepDef.class);

    OtherAdjustmentsPO otherAdjustmentsPO = new OtherAdjustmentsPO();


    @And("I click on {string} on Other adjustment Page")
    public void clickOnReasonCode(String reasonCode) throws Throwable {
        otherAdjustmentsPO.clickOnReasonCodes(reasonCode);
    }

    @And("I verify Reason codes are displayed on Other adjustment Page")
    public void verifyReasonCode() throws Throwable {
        otherAdjustmentsPO.verifyReasonCode();
    }

}
