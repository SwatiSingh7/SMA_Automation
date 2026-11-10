package com.morrisons.sma.step_definitions.mobile.items;

import org.apache.log4j.Logger;
import com.morrisons.sma.page_objects.mobile.items.AddEditCountPO_New;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;

public class AddEditCountStepDefs_New {

    private final Logger log = Logger.getLogger(AddEditCountStepDefs_New.class);
    AddEditCountPO_New addEditCountPONew = new AddEditCountPO_New();

    @And("I click on Add to Count Button")
    public void iClickOnAddToCountButton() {
        addEditCountPONew.clickAddCountButton();
    }

    @Then("I verify the new count is added with existing count")
    public void iVerifyTheNewCountIsAddedWithExistingCount(List<String> quantity) {
        addEditCountPONew.verifyAddCountButton(quantity.get(0));
    }

    @And("I click on Edit Button")
    public void iClickOnEditButton() {
        addEditCountPONew.clickEditCountButton();
    }

    @Then("I verify the new count is replaced with existing count")
    public void iVerifyTheNewCountIsReplacedWithExistingCount(List<String> quantity) {
        addEditCountPONew.verifyEditButton(quantity.get(0));
    }

    @And("I verify {string} and {string} buttons displayed on screen")
    public void iVerifyAndButtonsDisplayedOnScreen(String addCount, String editCount) throws Throwable {
        addEditCountPONew.verifyButtonsDisplayed(addCount,editCount);
    }
}
