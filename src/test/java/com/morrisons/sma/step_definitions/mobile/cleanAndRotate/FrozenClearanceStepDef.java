package com.morrisons.sma.step_definitions.mobile.cleanAndRotate;

import com.morrisons.sma.page_objects.mobile.cleanAndRotate.FrozenClearenceBayPage;
import io.cucumber.java.en.And;

public class FrozenClearanceStepDef {
    FrozenClearenceBayPage frozenClearenceBayPage = new FrozenClearenceBayPage();
    @And("I click on Confirm Clearance Bay Check button on Frozen Clearance Bay Check Page")
    public void iClickOnConfirmFrozenBaycheckButton() throws Throwable {
        frozenClearenceBayPage.clickOnConfirmBayCheck();
    }
    @And("I verify Instruction Message on Frozen Clearance Bay Check Page")
    public void iVerifyInstructionMsg() throws Throwable {
        frozenClearenceBayPage.verifyPageHeader();
    }
}
