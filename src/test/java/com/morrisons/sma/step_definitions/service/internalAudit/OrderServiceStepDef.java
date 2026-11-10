package com.morrisons.sma.step_definitions.service.internalAudit;

import com.google.inject.Inject;
import com.morrisons.common.utility.ApplicationContext;
import com.morrisons.common.utility.WebServicesUtilities;
import com.morrisons.sma.page_objects.mobile.GapsLowsHighsPO;
import com.morrisons.sma.page_objects.mobile.gLH.AMGLHMenu;
import com.morrisons.sma.page_objects.mobile.marketStreet.MarketStreetGLHPO_New;
import com.morrisons.sma.page_objects.mobile.marketStreet.MarketStreetPO_New;
import com.morrisons.sma.page_objects.service.internalAudit.OrderService;
import com.morrisons.sma.pojo.service.internalAudit.getOrder.OrderDetails;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class OrderServiceStepDef {
    public static final String ORDER_SERVICE_BASE_URL = "https://sit-api.morrisons.com/stockorder/v1";
    public String ORDER_SERVICE_SECONDARY_URL = "/customers/morrisons/orders";

    public static final Logger log = Logger.getLogger(OrderServiceStepDef.class);
    public final ApplicationContext applicationContext;
    public static final String accessToken = "TDdXMjI5NFVvT3VqbkpIamt3MUNtbHU5QWlWTWpvZzY6cnFDM0lQVTdoUHZ0UzhsZA==";
    static String jsonResponseString;
    static String expectedResponse,actualResponse;
    public static LocalDateTime date = LocalDateTime.now();
    public static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public String apiKeyValue = "L7W2294UoOujnJHjkw1Cmlu9AiVMjog6";
    public String storeTypeValue = "StoreStandard";
    public static String itemDescription = null;
    public static String lastDeliveryDate, nextDeliveryDate, orderPosition;
    public static String itemID;
    public static Double orderQuantity, nxtOrderQuantity;
    public static int orderQty, nxtOrderQty;
    MarketStreetPO_New marketStreetPO = new MarketStreetPO_New();
    MarketStreetGLHPO_New marketStreetGLHPO = new MarketStreetGLHPO_New();
    GapsLowsHighsPO gapsLowsHighsPO = new GapsLowsHighsPO();
    AMGLHMenu amglhMenu = new AMGLHMenu();

    @Inject
    public OrderServiceStepDef(ApplicationContext applicationContext) {

        this.applicationContext = applicationContext;
    }

    @Given("I get the item order status response through API for following {int}{string}")
    public void iGetTheOrderDetails(Integer itemCount, String itemList) throws IOException, InterruptedException {

        log.info("Getting orders status for items" + itemCount);
        getOrderDetailsForItems(itemCount, itemList);
    }


    public void getOrderDetailsForItems(int itemCount, String itemList) throws IOException, InterruptedException {
        int responseCode = 200;

        log.info("Getting all the items :");

        log.info("Getting Response for " + ORDER_SERVICE_BASE_URL + ORDER_SERVICE_SECONDARY_URL + ApplicationContext.STORE_ID);
        if (itemCount>20) {
            responseCode = 400;
        }
        jsonResponseString = WebServicesUtilities.retryGETRequestWithHeader(ORDER_SERVICE_BASE_URL,
                ORDER_SERVICE_SECONDARY_URL,
                "apikey", apiKeyValue,
                "orders", "last,current,next",
                "type", storeTypeValue,
                "itemnumber[in]", "[" + itemList + "]",
                "location", applicationContext.STORE_ID,
                "Authorization", "Basic " + accessToken,
                responseCode);
        applicationContext.applicationDetailsMap.put("ActualInternalAuditResponse", jsonResponseString);
        log.info("Getting value for ActualInternalAuditResponse value :" + applicationContext.applicationDetailsMap.get(("ActualInternalAuditResponse")));


    }


    @Given("I create expected result from {string}")
    public void iCreateExpectedJSON(String filePath) throws ParseException, FileNotFoundException {
        applicationContext.templateMap.put("currentDate", dateTimeFormatter.format(date));
        applicationContext.templateMap.put("currentDateMinus1", dateTimeFormatter.format(date.minusDays(1)));
        applicationContext.templateMap.put("currentDateMinus2", dateTimeFormatter.format(date.minusDays(2)));
        applicationContext.templateMap.put("currentDateMinus3", dateTimeFormatter.format(date.minusDays(3)));
        applicationContext.templateMap.put("currentDateMinus4", dateTimeFormatter.format(date.minusDays(4)));
        applicationContext.templateMap.put("currentDatePlus2", dateTimeFormatter.format(date.plusDays(2)));
        applicationContext.templateMap.put("currentDatePlus1", dateTimeFormatter.format(date.plusDays(1)));
        applicationContext.templateMap.put("currentDatePlus3", dateTimeFormatter.format(date.plusDays(3)));
        applicationContext.templateMap.put("currentDatePlus4", dateTimeFormatter.format(date.plusDays(4)));

        JSONObject jsonObject = new WebServicesUtilities().parseJSON(filePath, applicationContext.templateMap);
        expectedResponse = jsonObject.toString();
        applicationContext.applicationDetailsMap.put("ExpectedInternalAuditResponse", expectedResponse);

    }

    @Then("I Scroll down on Market Street page")
    public void iScrollDownMarketStreetPage() throws Throwable {
        marketStreetPO.scrollDown();
    }

    @Given("I compare expected response with actual response")
    public void iCompareAPIresponseaAndJSONResponse() {
        log.info("**************************************************************************************");
        actualResponse = applicationContext.applicationDetailsMap.get("ActualInternalAuditResponse").toString();
        expectedResponse=applicationContext.applicationDetailsMap.get("ExpectedInternalAuditResponse").toString();
        log.info("Expected Response :" + expectedResponse);
        log.info("Actual Response :" + actualResponse);
        JSONAssert.assertEquals(actualResponse, expectedResponse, JSONCompareMode.LENIENT);


       /* CustomComparator applicationCustomizations = new CustomComparator(JSONCompareMode.LENIENT,
                new Customization("submission.submissionGUID", (o1, o2) -> true),
                new Customization("submission.application.eventDateTime", (o1, o2) -> true),
                new Customization("submission.application.uniqueApplicationNumber", (o1, o2) -> true),
                new Customization("submission.attachment.object", (o1, o2) -> true),
                new Customization("submission.person[id=0].questions", (o1, o2) -> true),
                new Customization("submission.person[id=1].questions", (o1, o2) -> true),
                new Customization("submission.person[id=2].questions", (o1, o2) -> true));

                */


    }

    @Then("I compare expected response from {string}with actual response for more than 20 items")
    public void iCompareErrorResponse(String filePath) throws Throwable {
        JSONObject jsonObject = new WebServicesUtilities().parseJSON(filePath, applicationContext.templateMap);
        expectedResponse = jsonObject.toString();
        applicationContext.applicationDetailsMap.put("ExpectedInternalAuditResponse", expectedResponse);
        JSONAssert.assertEquals(jsonResponseString, expectedResponse, JSONCompareMode.STRICT);


    }


    @Then("I Scroll down on Gaps, Lows, Highs page")
    public void iScrollDownOnGLHPage() throws Throwable {
        gapsLowsHighsPO.scrollDown();
    }

    @Then("I Scroll down on Prompted Count page")
    public void iScrollPromptedCountPage() throws Throwable {
        gapsLowsHighsPO.scrollDown();
    }


    @Then("I click on {string} on Market Street Page")
    public void iClickOnMarketStreetMenu(String option) throws Throwable {
        marketStreetPO.clickOnMarketStreetMenu(option);
    }

    @Then("I click on {string} on Market Street GLH page")
    public void iClickOnMarketStreetGLHMenu(String option) throws Throwable {
        marketStreetGLHPO.clickOnMarketStreetGLHMenu(option);
    }

    @Then("I click on {string} on AMGLH Page")
    public void iClickOnGLHMenu(String option) throws Throwable {
        gapsLowsHighsPO.clickOnGapsLowsHighsMenu(option);
    }

    @Then("I click on {string} on AMGLH menu page")
    public void iClickOnAMGLHMenu(String option) throws Throwable {
        amglhMenu.clickOnAMGlhMenu(option);
    }


    public void iGetOrderDetails(String productMin) {
        String lastValue = "last";
        String nextValue = "current";
        List<OrderDetails> orderList = new OrderService().getItemResponse(jsonResponseString);
        for (int itemIndex = 0; itemIndex <= orderList.size() - 1; itemIndex++) {
            if (orderList.get(itemIndex).getLines().getItemId().equalsIgnoreCase(productMin)) {

                itemID = orderList.get(itemIndex).getLines().getItemId();
                orderPosition = orderList.get(itemIndex).getOrderPosition();
                log.info("orders : " + orderList.get(itemIndex).getCreatedAt());
                log.info("ItemId : " + itemID);
                if (orderPosition.equalsIgnoreCase(lastValue)) {
                    lastDeliveryDate = orderList.get(itemIndex).getLines().getDelivery().getDateDeliveryExpected();
                    orderQuantity = orderList.get(itemIndex).getLines().getStatus().get(0).getOrdered().getQuantity();
                    orderQty = (int) Math.round(orderQuantity);

                    log.info("OrderPosition : " + orderList.get(itemIndex).getOrderPosition());
                    log.info("Expected Delivery Date : " + lastDeliveryDate);
                    log.info("Expected Availability Date : " + orderList.get(itemIndex).getLines().getDelivery().getDateAvailabilityExpected());
                }
                if (orderPosition.equalsIgnoreCase(nextValue)) {
                    nextDeliveryDate = orderList.get(itemIndex).getLines().getDelivery().getDateDeliveryExpected();
                    nxtOrderQuantity = orderList.get(itemIndex).getLines().getStatus().get(0).getOrdered().getQuantity();
                    nxtOrderQty = (int) Math.round(nxtOrderQuantity);
                    log.info("OrderPosition : " + orderPosition);
                    log.info("Next Delivery Date : " + nextDeliveryDate);
                    log.info("Expected Availability Date : " + orderList.get(itemIndex).getLines().getDelivery().getDateAvailabilityExpected());
                }
            }


        }


    }

}












