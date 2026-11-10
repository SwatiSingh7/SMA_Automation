package com.morrisons.sma.step_definitions.mobile;

import com.morrisons.sma.page_objects.mobile.HomePagePO_New;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;

public class HomePageStepDefs_New {

    private final Logger log = Logger.getLogger(HomePageStepDefs_New.class);
    HomePagePO_New homePage = new HomePagePO_New();

    @Then("I click on the main menu {string}")
    public void iClickOnTheMainMenu(String mainOption) {
        homePage.clickOnMainMenu(mainOption);
    }

    @And("I click on {string} on Home Page")
    public void iClickOnHomePage(String homePageOption) throws Throwable {
        Thread.sleep(2000);
        homePage.clickOnHomePageOption(homePageOption);
    }

}
