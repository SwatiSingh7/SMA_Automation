package com.morrisons.sma.step_definitions.mobile.stock_information;

import com.morrisons.sma.page_objects.mobile.stockInformation.ProductAdjustmentHistoryPO;

import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;

import com.morrisons.sma.step_definitions.mobile.StockAdjustmentStepDefs_New;

import io.cucumber.java.en.And;

public class ProductAdjustmentHistorySetpDef {

    private final Logger log = Logger.getLogger(StockAdjustmentStepDefs_New.class);
    ProductAdjustmentHistoryPO productAdjustmentHistoryPO = new ProductAdjustmentHistoryPO();


    @And("I verify Stock status {string} and Adjustment quantity {string} on Product adjustment history screen")
    public void verifyStockStausAndCount(String exepctedStockStatus, String exepctedAdjustmentCount) throws Throwable {
        productAdjustmentHistoryPO.verifyProductHistory(exepctedStockStatus, exepctedAdjustmentCount);
    }
}
