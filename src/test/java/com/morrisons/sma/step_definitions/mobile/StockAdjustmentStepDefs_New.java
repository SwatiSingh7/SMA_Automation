package com.morrisons.sma.step_definitions.mobile;

import com.morrisons.sma.page_objects.mobile.StockAdjustmentPO_New;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;

public class StockAdjustmentStepDefs_New {

    private final Logger log = Logger.getLogger(StockAdjustmentStepDefs_New.class);
    StockAdjustmentPO_New stockAdjustmentPONew = new StockAdjustmentPO_New();


    @And("I click on {string} on Stock Adjustment Page")
    public void iClickOnOnStockAdjustmentPage(String stockAdjustmentOption) throws Throwable {
        stockAdjustmentPONew.clickOnStockAdjustmentOption(stockAdjustmentOption);
    }

    @Then("{string} should get displayed on Stock Adjustment Page")
    public void shouldGetDisplayed(String stockAdjustmentOption) throws Throwable {
        stockAdjustmentPONew.verifyOnStockAdjustmentOption(stockAdjustmentOption);
    }


    @Then("{string} should not get displayed on Stock Adjustment Page")
    public void shouldNotGetDisplayedOnStockAdjustmentPage(String stockAdjustmentOption) throws Throwable {
        stockAdjustmentPONew.verifyNotDisplayedOnStockAdjustmentOption(stockAdjustmentOption);
    }
}
