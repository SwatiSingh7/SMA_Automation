package com.morrisons.sma.step_definitions.mobile.stock_adjustments;

import com.morrisons.sma.page_objects.mobile.popups.PopUpPO_New;
import com.morrisons.sma.page_objects.mobile.stockAdjustment.ActionWastePO_New;
import io.cucumber.java.en.And;
import org.apache.log4j.Logger;

public class ActionWasteStepDefs_New {

    private final Logger log = Logger.getLogger(ActionWasteStepDefs_New.class);
    ActionWastePO_New actionWastePONew = new ActionWastePO_New();


    @And("I click on {string} on Action Waste Page")
    public void iClickOnOnActionWastePage(String actionWaste) throws Throwable {
        actionWastePONew.clickOnActionWasteOption(actionWaste);
    }


    @And("I click on Ok button if Ok Popup is present")
    public void iClickOnOkButtonIfOkPopupIsPresent() {
        PopUpPO_New popUpPONew = new PopUpPO_New();
        popUpPONew.CheckAndClickOKBtn();
    }
}
