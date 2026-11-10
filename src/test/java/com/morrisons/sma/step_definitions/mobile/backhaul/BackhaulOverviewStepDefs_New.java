package com.morrisons.sma.step_definitions.mobile.backhaul;

import com.morrisons.sma.page_objects.mobile.backhaul.BackhaulOverviewPO_New;
import com.morrisons.sma.step_definitions.mobile.pallets.BackhaulPalletStepDefs_New;
import io.cucumber.java.en.And;
import org.apache.log4j.Logger;

public class BackhaulOverviewStepDefs_New {

    private final Logger log = Logger.getLogger(BackhaulPalletStepDefs_New.class);
    BackhaulOverviewPO_New backhaulOverviewPONew = new BackhaulOverviewPO_New();

/*
Backhual Overview Screen
 */
    @And("I verify trayquantity {string} and pallet quantity {string}")
    public void iVerifyTrayquantityAndPalletQuantity(String quantity1, String quantity2) {
        backhaulOverviewPONew.verifybackhaulpalletNtrayCount(quantity1,
                quantity2);
    }

    @And("I click confirm backhaul overview")
    public void iClickConfirmBackhaulOverview() throws Throwable {
        backhaulOverviewPONew.confirmBackhaul();
    }

    @And("I verfiy backhaul overview Screen and description {string}")
    public void iVerfiyBackhaulOverviewScreenAndDescription(String message) {
        backhaulOverviewPONew.verifyOverviewScreennMessage(message);
    }


    @And("I verify backhaul status {string}")
    public void iVerifyStatus(String status) throws InterruptedException {
        backhaulOverviewPONew.verifybackhaulstatus(status);
    }

    @And("I verify user able to edit count {string} tray for backhaul and pallet for backhaul quantity {string}")
    public void iVerifyUserAbleToEditCountTrayForBackhaulAndPalletForBackhaulQuantity(String qty1, String qty2) throws Throwable {
        backhaulOverviewPONew.editcountfortray(qty1, qty2);
    }

    @And("I verify user not able edit quantity in backhaul overview screen")
    public void iVerifyUserNotAbleEditQuantity() {
        backhaulOverviewPONew.isbackhaulOverviewEditable();
    }
}
