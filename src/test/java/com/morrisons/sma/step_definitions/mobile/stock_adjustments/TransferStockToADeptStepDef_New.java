package com.morrisons.sma.step_definitions.mobile.stock_adjustments;

import com.morrisons.common.helper.MobileHelper;
import com.morrisons.sma.page_objects.mobile.stockAdjustment.TransferStockToADeptPO_New;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import static com.morrisons.sma.page_objects.mobile.stockAdjustment.TransferStockToADeptPO_New.driveR;

public class TransferStockToADeptStepDef_New {

    private final Logger log = Logger.getLogger(TransferStockToADeptStepDef_New.class);
    TransferStockToADeptPO_New transferStockToADeptPONew = new TransferStockToADeptPO_New();


    @Then("I click on {string} on Transfer Stock To A Dept Page")
    public void iClickOnOnTransferStockToADeptPage(String option) {
        MobileHelper.ScrolltoElementWithText(driveR,option);
        transferStockToADeptPONew.clickOnTransferStockToADeptOption(option);
    }

}

