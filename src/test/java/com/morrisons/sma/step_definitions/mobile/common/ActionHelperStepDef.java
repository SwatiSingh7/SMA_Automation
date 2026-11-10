package com.morrisons.sma.step_definitions.mobile.common;


import com.morrisons.common.action.Hook;
import com.morrisons.common.helper.ActionHelper;
import com.morrisons.common.helper.MobileHelper;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import org.apache.log4j.Logger;

public class ActionHelperStepDef {

    private final Logger log = Logger.getLogger(ActionHelperStepDef.class);
    ActionHelper actionPO = new ActionHelper();

    @And("I click on {string} button")
    public void iClickOnButton(String button) throws Throwable {
        log.info("Clicking on button : " + button);
        actionPO.clickOnButton(button);
    }

    @And("I Scroll from {int} {int} to {int} {int}")
    public void iScrollFromTo(int xOffsetFrom, int yOffsetFrom, int xOffsetTo, int yOffsetTo) throws InterruptedException {
        MobileHelper.scroll((AndroidDriver) Hook.getDriver(), xOffsetFrom,  yOffsetFrom,  xOffsetTo,  yOffsetTo);
    }
}
