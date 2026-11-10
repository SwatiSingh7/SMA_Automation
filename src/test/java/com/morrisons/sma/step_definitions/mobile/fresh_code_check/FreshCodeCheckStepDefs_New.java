package com.morrisons.sma.step_definitions.mobile.fresh_code_check;

import com.morrisons.sma.page_objects.mobile.freshCodeCheck.FreshCodeCheckPO_New;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import java.util.List;


public class FreshCodeCheckStepDefs_New {

    private final Logger log = Logger.getLogger(FreshCodeCheckStepDefs_New.class);
    FreshCodeCheckPO_New freshCodeCheckPONew = new FreshCodeCheckPO_New();


    @Then("I click on {string} on Fresh Code Check Page")
    public void iClickOnOnFreshCodeCheckPage(String fccOption) {
        freshCodeCheckPONew.clickOnFccOption(fccOption);
    }

    @And("I click on Log Product")
    public void iClickOnLogProduct() {
        freshCodeCheckPONew.clickLogProduct();
    }

    @Then("I click on product on Fresh Code Check Page and click on daily checks")
    public void iClickOnProductOnFreshCodeCheckPage(List<String> prodDescription) throws InterruptedException {
        Thread.sleep(2000);
        freshCodeCheckPONew.productClick(prodDescription.get(0));
        Thread.sleep(2000);
    }

    @Then("I click on {string} on daily checks Page")
    public void iClickOnOnDailyChecksPage(String dailyCheckOption) {
        freshCodeCheckPONew.clickOnFccDailyCheckOptions(dailyCheckOption);
    }

    @And("I click on Bought In Breads")
    public void iClickOnBoughtInBreads() {
        freshCodeCheckPONew.productGroupClick();
    }

    @And("I select {string} from the dropdown on code alert")
    public void iSelectFromTheDropdownOnCodeAlert(String actionOption) {
        freshCodeCheckPONew.selectCodeAlertActionOption(actionOption);
    }

    @Then("I click on {string} on select check page")
    public void iClickOnOnSelectCheckPage(String selectCheckOption) {
        freshCodeCheckPONew.clickOnFccSelectCheckOptions(selectCheckOption);
    }
}

