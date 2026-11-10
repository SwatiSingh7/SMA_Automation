package com.morrisons.sma.step_definitions.mobile.mins;

import com.morrisons.common.helper.ActionHelper;
import com.morrisons.common.helper.CommonHelperMethods;
import com.morrisons.common.utility.ApplicationContext;
import com.morrisons.sma.page_objects.mobile.gLH.AMScanItem;
import com.morrisons.sma.page_objects.mobile.marketStreet.MarketStreetPO_New;
import com.morrisons.sma.page_objects.mobile.marketStreet.MarketStreetScanItemDetails_New;
import com.morrisons.sma.page_objects.mobile.mins.EnterMINPO_New;
import com.morrisons.sma.page_objects.mobile.stockInformation.ProductDetailsPO;
import com.morrisons.sma.step_definitions.service.ProductServiceStepDefs_New;
import com.morrisons.sma.step_definitions.service.internalAudit.OrderServiceStepDef;
import io.cucumber.java.en.And;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class EnterMINStepDefs_New {

    private final Logger log = Logger.getLogger(EnterMINStepDefs_New.class);
    public ApplicationContext applicationContext;
    EnterMINPO_New enterMINPONew = new EnterMINPO_New();
    ProductDetailsPO productDetailsPO = new ProductDetailsPO();
    OrderServiceStepDef orderServiceStepDef = new OrderServiceStepDef(applicationContext);
    ActionHelper actionPO = new ActionHelper();
    MarketStreetPO_New marketStreetPO = new MarketStreetPO_New();
    MarketStreetScanItemDetails_New marketStreetScanItemDetails = new MarketStreetScanItemDetails_New();
    AMScanItem amScanItem = new AMScanItem();
    ProductServiceStepDefs_New productServiceStepDefs_new = new ProductServiceStepDefs_New(applicationContext);

    @And("I search for {string}")
    public void iSearchFor(String minID) throws Throwable {
        enterMINPONew.searchBarcode(minID);
    }

    @And("^verify the case scanned header$")
    public void verifyTheCaseScannedHeader() throws Throwable {
        enterMINPONew.caseScannedHeaderVerification();
    }

    @And("^I verify the min \"([^\"]*)\" against entered BarCode$")
    public void iVerifyTheMinAgainstEnteredBarCode(String expectedMin) throws Throwable {
        enterMINPONew.verifyMinAgainstBarCode(expectedMin);
    }

    @And("I search for items {string} and verify that Delivery status is same on UI and Service")
    public void iSearchForItems(String itemIDList) throws Throwable {
        List<String> productList = CommonHelperMethods.SplitString(itemIDList);
        for (String product : productList) {
            enterMINPONew.searchBarcode(product);
            orderServiceStepDef.iGetOrderDetails(product);
            productDetailsPO.scrollDown();
            productDetailsPO.iVerifyLastOrderDate();
            productServiceStepDefs_new.iGetTheSingleProductDetails(product);
            productDetailsPO.iVerifyLastOrderQuantity();
            productDetailsPO.iVerifyNextOrderDate();
            productDetailsPO.iVerifyNextOrderQuantity();


        }
        actionPO.clickOnButton("Back");
        actionPO.clickOnButton("Back");

    }

    @And("I search for items {string} and verify that Next Delivery status is same on UI and Service")
    public void iVerify(String itemIDList) throws Throwable {
        List<String> productList = CommonHelperMethods.SplitString(itemIDList);
        for (String product : productList) {
            enterMINPONew.searchBarcode(product);
            productDetailsPO.scrollDown();
            productDetailsPO.iVerifyNextOrderDate();
            productServiceStepDefs_new.iGetTheSingleProductDetails(product);
            productDetailsPO.iVerifyLastOrderQuantity();

        }
        actionPO.clickOnButton("Back");
        actionPO.clickOnButton("Back");

    }


    @And("I search for items {string} and verify that Last Delivery status is same on service and Market Street UI")
    public void iSearchForMarketStreetItems(String itemIDList) throws Throwable {
        List<String> productList = CommonHelperMethods.SplitString(itemIDList);
        for (String product : productList) {

            enterMINPONew.searchBarcode(product);
            orderServiceStepDef.iGetOrderDetails(product);
            productServiceStepDefs_new.iGetTheSingleProductDetails(product);

            marketStreetScanItemDetails.iVerifyLastOrderAndQuantity();

            actionPO.clickOnButton("Back");
        }
        actionPO.clickOnButton("Back");
        actionPO.clickOnButton("Back");

        actionPO.clickOnButton("Back");

    }

    @And("I search for items {string} and verify that Last Delivery status is same on service and AM GLH UI")
    public void iSearchForItemsOnAMGLH(String itemIDList) throws Throwable {
        List<String> productList = CommonHelperMethods.SplitString(itemIDList);

        for (String product : productList) {
            enterMINPONew.searchBarcode(product);
            log.info("minID------------" + product);
            orderServiceStepDef.iGetOrderDetails(product);
            productServiceStepDefs_new.iGetTheSingleProductDetails(product);

            amScanItem.iVerifyAMLastOrderAndQuantity();
            actionPO.clickOnButton("Back");
        }
        actionPO.clickOnButton("Back");
        actionPO.clickOnButton("Back");
        actionPO.clickOnButton("Back");

    }


}
