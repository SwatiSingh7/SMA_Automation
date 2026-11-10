package com.morrisons.sma.step_definitions.mobile.items;

import com.morrisons.sma.page_objects.mobile.items.EnterQuantityPO_New;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import com.morrisons.sma.page_objects.mobile.items.ItemListPO_New;
import io.cucumber.java.en.And;

public class ItemListStepDefs_New {

    private final Logger log = Logger.getLogger(ItemListStepDefs_New.class);
    ItemListPO_New itemListPONew = new ItemListPO_New();

    @And("click on the List View")
    public void clickOnTheListView() throws Throwable {
        itemListPONew.clickOnViewList();
    }

    @And("I enter the desired quantity {string} and click on Done Button")
    public void iEnterTheDesiredQuantityAndClickOnButton(String option) throws Throwable {
        EnterQuantityPO_New enterQuantityPONew=new EnterQuantityPO_New();
        enterQuantityPONew.enterQuantity(option);
        itemListPONew.clickOnDoneButton();
    }

    @Then("I select the product from list")
    public void iSelectTheProductFromList() throws Throwable {
            itemListPONew.clickOnItemList();
    }
}
