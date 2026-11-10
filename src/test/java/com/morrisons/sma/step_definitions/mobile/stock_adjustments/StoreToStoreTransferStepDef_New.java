package com.morrisons.sma.step_definitions.mobile.stock_adjustments;
import com.morrisons.sma.page_objects.mobile.stockAdjustment.StoreToStoreTransferPO_New;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;

public class StoreToStoreTransferStepDef_New {

    private final Logger log = Logger.getLogger(StoreToStoreTransferStepDef_New.class);
    StoreToStoreTransferPO_New storeToStoreTransferPONew=new StoreToStoreTransferPO_New();


    @Then("I select store on Store To Store Transfer page")
    public void iSelectStoreOnStoreToStoreTransferPage() {
        storeToStoreTransferPONew.clickOnStore();
    }
}

