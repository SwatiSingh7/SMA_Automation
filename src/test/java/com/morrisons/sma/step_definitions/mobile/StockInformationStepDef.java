package com.morrisons.sma.step_definitions.mobile;

import com.morrisons.sma.page_objects.mobile.StockInformationPO;
import io.cucumber.java.en.And;
import org.apache.log4j.Logger;

public class StockInformationStepDef {

    private final Logger log = Logger.getLogger(StockAdjustmentStepDefs_New.class);
    StockInformationPO stockInformationPO = new StockInformationPO();


    @And("I Click on {string} option on Stock information screen")
    public void clickOnStockOption(String optionStockInformation) throws Throwable {
        stockInformationPO.clickOnStockOption(optionStockInformation);
    }

    @And("I verify Range status {string} is displayed")
    public void verifyRangeStatus(String rangeStatus) throws Throwable {
        stockInformationPO.verifyRangeStatus(rangeStatus);
    }

    @And("verify HFSS flag is visible")
    public void verifyHFSSFlagIsVisible() throws Throwable {
        stockInformationPO.verifyHFSSFlag();
    }

    @And("Click on HFSS flag view button")
    public void clickOnHFSSFlagViewButton() throws Throwable {
        stockInformationPO.clickHFSSView();
    }

    @And("verify the message on HFSS")
    public void verifyTheMessageOnHFSS() throws Throwable {
        stockInformationPO.verifyHFSSmessage();
    }
}
