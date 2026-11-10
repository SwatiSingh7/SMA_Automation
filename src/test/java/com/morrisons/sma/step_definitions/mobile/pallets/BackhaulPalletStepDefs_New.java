package com.morrisons.sma.step_definitions.mobile.pallets;

import org.apache.log4j.Logger;
import com.morrisons.sma.page_objects.mobile.pallets.BackhaulPalletPO_New;
import io.cucumber.java.en.And;

public class BackhaulPalletStepDefs_New {
    private final Logger log = Logger.getLogger(BackhaulPalletStepDefs_New.class);
    BackhaulPalletPO_New backhaulPalletPONew = new BackhaulPalletPO_New();
/*
Backhual Pallet Screen
 */
    @And("I verify backhaul header and Pallet count description {string}")
    public void iVerifyBackhaulHeaderAndPalletCountDescription(String message) throws Throwable {
        backhaulPalletPONew.verifybackhualScreenMessage(message);
    }

    @And("I enter pallet quantity {string} and confirm the same")
    public void iEnterPalletQuantityAndConfirmTheSame(String quantity) throws Throwable {
        backhaulPalletPONew.enterbackhualPalletsNConfirm(quantity);
    }
}
