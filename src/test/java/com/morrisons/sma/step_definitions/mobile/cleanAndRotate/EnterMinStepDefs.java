package com.morrisons.sma.step_definitions.mobile.cleanAndRotate;

import com.google.common.collect.ImmutableMap;
import com.morrisons.sma.page_objects.mobile.cleanAndRotate.EnterMin;
import com.morrisons.sma.page_objects.mobile.mins.EnterMINPO_New;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;

import static com.morrisons.sma.page_objects.mobile.old.StockAdjustmentPO.driveR;

public class EnterMinStepDefs {

    private final Logger log = Logger.getLogger(EnterMinStepDefs.class);
    EnterMin enterMin = new EnterMin();
    private String enterProductMin = null;
    EnterMINPO_New enterMINPO_New = new EnterMINPO_New();

    @Then("I Enter Product Min and click on search")
    public void enterProductMin() throws Throwable {
        enterMINPO_New.clickOnBarCodeIcon();
        enterProductMin = GetDeptAndMin.productMin;
        log.info("Entering Product min : "+enterProductMin);
        enterMin.enterProductMin(enterProductMin);
    }

}
