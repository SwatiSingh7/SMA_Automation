package com.morrisons.sma.step_definitions.mobile.internalAudit;

import com.morrisons.common.helper.ActionHelper;
import com.morrisons.common.utility.ApplicationContext;
import com.morrisons.sma.page_objects.mobile.promptedCount.*;
import com.morrisons.sma.step_definitions.service.internalAudit.OrderServiceStepDef;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class PromptedCountStepDef {
    public ApplicationContext applicationContext;
    OrderServiceStepDef orderServiceStepDef = new OrderServiceStepDef(applicationContext);
    ActionHelper actionPO = new ActionHelper();
    MarketStreetPromptedCountMenu_New marketStreetPromptedCountMenu = new MarketStreetPromptedCountMenu_New();
    MarketStreetPromptedCountItemDetails_New marketStreetPromptedCountItemDetails = new MarketStreetPromptedCountItemDetails_New();
    AmbientFrozenPromptedCountMenu_New ambientFrozenPromptedCountMenuNew = new AmbientFrozenPromptedCountMenu_New();
    AmbientFrozenItemDetails_New ambientFrozenItemDetailsNew = new AmbientFrozenItemDetails_New();
    FreshPromptedCountMenu_New freshPromptedCountMenu = new FreshPromptedCountMenu_New();
    ServicePromptedCount_New  servicePromptedCount = new ServicePromptedCount_New();
    ServiceScanItemDetails_New serviceScanItemDetails = new ServiceScanItemDetails_New();

    @Then("I click on {string} on Ambient Frozen Page")
    public void iClickAmbientOptionOnPromptedCountPage(String option) throws Throwable {
        ambientFrozenPromptedCountMenuNew.clickOnAmbientPromptedCountOption(option);
    }

    @Then("I verify Last Delivery Date and Next Delivery Date are same on service and UI for Product Min {string}")
    public void iVerifyAmbientFrozenProductDeliveryDate(String productMin) throws Throwable {
        orderServiceStepDef.iGetOrderDetails(productMin);

        ambientFrozenItemDetailsNew.verifyDeliveryDate(productMin);
        actionPO.clickOnButton("Back");
        actionPO.clickOnButton("Back");

    }

    @Then("I click on {string} to get Product details")
    public void iClickOnMarketStreetOption(String option) throws Throwable {
        marketStreetPromptedCountMenu.clickOnPromptedCountMarketStreetOption(option);
    }

    @Then("I verify Last Delivery Date and Next Delivery Date are same on service and UI for Market Street Product Min {string}")
    public void iVerifyMarketStreetProductDeliveryStatus(String productMin) throws Throwable {
        orderServiceStepDef.iGetOrderDetails(productMin);

        marketStreetPromptedCountItemDetails.iVerifyDeliveryDate(productMin);

        actionPO.clickOnButton("Back");
        actionPO.clickOnButton("Back");
    }

    @Then("I verify Last Delivery Date and Next Delivery Date are same on service and UI for Service Product Min {string}")
    public void iVerifyServiceProductDeliveryStatus(String productMin) throws Throwable {
        orderServiceStepDef.iGetOrderDetails(productMin);

        serviceScanItemDetails.verifyDeliveryStatus(productMin);

        actionPO.clickOnButton("Back");
        actionPO.clickOnButton("Back");
    }


    @Then("I click on {string} to get Fresh Product details")
    public void iClickOnFreshMenuOption(String option) throws Throwable {
        freshPromptedCountMenu.clickOnFreshMenuOption(option);
    }

    @Then("I click on {string} to get Service Product details")
    public void iClickOnServiceMenuOption(String option) throws Throwable {
        servicePromptedCount.clickOnServiceMenuOption(option);
    }


    @Then("I verify Last Delivery Date and Next Delivery Date are same on service and UI for Fresh Product Min {string}")
    public void iVerifyFreshProductDeliveryStatus(String productMin) throws Throwable {
        orderServiceStepDef.iGetOrderDetails(productMin);

        marketStreetPromptedCountItemDetails.iVerifyDeliveryDate(productMin);

        actionPO.clickOnButton("Back");
        actionPO.clickOnButton("Back");
    }
}
