package com.morrisons.sma.step_definitions.mobile.cleanAndRotate;

import com.morrisons.sma.page_objects.mobile.cleanAndRotate.CNRHomepage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CnRHomePageStepDefs {

    CNRHomepage cNRHomepage = new CNRHomepage();


    @And("I click on {string} on Clean and Rotate Page")
    public void clickOnCnRHomePageOption(String cnRSubmenuOption) throws Throwable {
        cNRHomepage.clickOnCnRHomePageOption(cnRSubmenuOption);
    }

    @Then("I Get Weekly Schedules Submenus status")
    public void getWeeklyScheduleSubmenuStatus() throws Throwable {
        cNRHomepage.getWeeklyScheduleSubmenuStatus();
    }
}
