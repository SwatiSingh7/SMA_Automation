package com.morrisons.sma.step_definitions.mobile.stock_adjustments;

import com.morrisons.common.helper.MobileHelper;
import com.morrisons.sma.page_objects.mobile.stockAdjustment.TransferBackFromADeptPO_New;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;

public class TransferBackFromADeptStepDef_New {

    private final Logger log = Logger.getLogger(TransferBackFromADeptStepDef_New.class);
    TransferBackFromADeptPO_New transferBackFromADeptPONew=new TransferBackFromADeptPO_New();


    @Then("I click on {string} on Transfer Back From A Dept Page")
    public void iClickOnOnTransferBackFromADeptPage(String option) {
        MobileHelper.ScrolltoElementWithText(TransferBackFromADeptPO_New.driveR,option);
        transferBackFromADeptPONew.clickOnTransferBackFromADeptOptions(option);
    }

}
