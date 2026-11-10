package com.morrisons.sma.step_definitions.mobile.old;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.morrisons.sma.page_objects.mobile.old.StockInformationPO;
import com.morrisons.sma.pojo.service.DeliveryPOJO.DeliveryPO_Lines;
import com.morrisons.sma.pojo.service.DeliveryPOJO.DeliveryPO_Orders;
import com.morrisons.sma.pojo.service.DeliveryPOJO.DeliveryPO_Orderss;
import com.morrisons.sma.pojo.service.PricePrompPOJO.PricePO_PricePojo;
import com.morrisons.sma.pojo.service.StockInfoServicePOJO.StockInfo_Packs;
import com.morrisons.sma.pojo.service.StockInfoServicePOJO.StockInfo_ProductPojo;
import com.morrisons.sma.pojo.service.StockInfoServicePOJO.StockV2Pojo;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpResponse;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class StockInformationStepDefUI {
	StockInformationPO stockvo = new StockInformationPO();
	public static String prdtID;
	public static String storeID;
	public static HttpResponse Response;
	public static StockInfo_ProductPojo prdtJsonResp;
	public static PricePO_PricePojo priceJson;
	public static DeliveryPO_Orders deliveryJson;
	public static StockV2Pojo stockJson;
	public static String startingPosition = null;
	public static String stockPosition = null;
	public static String orderPosition = null;
	public static String cusDesc;
	public static String eanGtin;
	public static String basePrice;
	public static String unitPrice;
	public static String packQuantity;

	public static String lastDelDatefromApp;
	public static String lastDelDatefromService;
	public static String orderedQtyfromApp;
	public static String orderedQtyfromService;
	public static String delQtyfromApp;
	public static String delQtyfromService;
	public static String nextDelDatefromApp;
	public static String nextDelDatefromService;
	public static String nextOrderQtyfromApp;

	public static String lastOrderQtyfromApp;
	public static String nextOrderQtyfromService;
	public static String lastOrderQtyfromService;
	public static String lastDatefromService;
	public static String nextDatefromService;
	public static String quantityType;

	ObjectMapper objectMapper = new ObjectMapper();
	
	public static String getStockValue = null;

	@Then("I click on stock information")
	public void i_click_on_stock_information() throws Throwable {
		stockvo.stockInfo();
	}

	@Then("verify that all the expected fields are present in Stock Information screen")
	public void verify_that_all_the_expected_fields_are_present_in_Stock_Information_screen() throws Throwable {
		stockvo.verifypage();
	}

	@Given("verify that Price section is visible")
	public void verify_that_Price_section_is_visible() throws Throwable {
		stockvo.priceVerify();
	}

	@Given("verify that Stock section is visible")
	public void verify_that_Stock_section_is_visible() throws Throwable {
		stockvo.stockVerify();
	}

	@Given("verify that LastCapture section is visible")
	public void verify_that_LastCapture_section_is_visible() throws Throwable {
		stockvo.lastCapture();
	}

	@Given("verify that Space section is visible")
	public void verify_that_Space_section_is_visible() throws Throwable {
		stockvo.spaceVerify();
	}

	@Given("verify that Deliveries section is visible")
	public void verify_that_Deliveries_section_is_visible() throws Throwable {
		stockvo.deliveriesVerify();
	}

	@Given("I click on Price section")
	public void i_click_on_Price_section() throws Throwable {
		stockvo.priceClick();
	}

	@Then("I verify the details on the price Page")
	public void i_verify_the_details_on_the_price_Page() throws Throwable {
		stockvo.priceDisplayVerify();
	}

	@Then("I verify that No Promotion details is present")
	public void i_verify_that_No_Promotion_details_is_present() throws Throwable {
		stockvo.noPromotion();
	}

	@Given("ProductId {string} is included in the servce")
	public void productid_is_included_in_the_servce(String arg1) throws Throwable {

		prdtID = arg1;
		stockvo.min(prdtID);
		stockvo.getPrdtDetails(cusDesc, eanGtin);
		stockvo.getPrdtInfo(prdtID);

	}

	@Given("Verify ProductId {string} is included in the service")
	public void productId(String arg1) throws Throwable {

		prdtID = arg1;
		stockvo.min(prdtID);
	}

/*	@Given("Request is made to verify Product Id {string} is included in the service")
	public void getProductDetails(String arg1) throws Throwable {

		List<String> itemsList = Arrays.asList(arg1.split("\\s*,\\s*"));
		int count = itemsList.size();
		
		
		prdtID = itemsList.get(0);
		stockvo.min(prdtID);
		stockvo.getProductInfo(prdtID);

	}*/

	@When("Request is made into Product service")
	public void request_is_made_into_Product_service() throws Throwable {
		Response = stockvo.performGetOperation();
	}

	@Then("Service should return the details of the service")
	public void service_should_return_the_details_of_the_service() throws Throwable {
		int responseCode = Response.getStatusLine().getStatusCode();
		String errorMessage = Response.getStatusLine().getReasonPhrase();
		int responseCodeE = 200;
		System.out.println("PostMan Response Message is - " + errorMessage);
		assertEquals(responseCode, responseCodeE, " Product details requested doesn't exist. Response code");

		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		prdtJsonResp = objectMapper.readValue(Response.getEntity().getContent(), StockInfo_ProductPojo.class);

		System.out.println("Product Get Response:\n" + prdtJsonResp);
		cusDesc = prdtJsonResp.getItemDescription();//////Item description attribute in Product api
		try{
			eanGtin = prdtJsonResp.getGtins().get(0).getId();
		}
		catch(Exception e){System.out.println("gtins is empty in service");}

		try{
		StockInfo_Packs[] packs = prdtJsonResp.getPacks();

		packQuantity = packs[0].getPackQuantity();
		}
		catch(Exception e){System.out.println("Product with No pack");}


		System.out.println("Product Get Description Response:\n" + cusDesc);
		System.out.println("Product Get EAN GTIN Response:\n" + eanGtin);
		Thread.sleep(500);

		stockvo.getPrdtDetails(cusDesc, eanGtin);
		Thread.sleep(2500);
	}

	@Given("Storeid{string} and ProductId {string} is included in the service")
	public void storeid_and_ProductId_is_included_in_the_service(String arg1, String arg2) throws Throwable {
		prdtID = arg2;
		storeID = arg1;
		stockvo.getPriceInfo(storeID, prdtID);
	}

	@Given("ProductId {string} and StoreID {string} is included in the servce")
	public void productid_and_StoreID_is_included_in_the_servce(String arg1, String arg2) throws Throwable {
		prdtID = arg1;
		storeID = arg2;
		stockvo.getDeliveryInfo(prdtID, storeID);
	}

	@When("Request is made into Price service")
	public void request_is_made_into_Price_service() throws Throwable {
		Response = stockvo.performGetPriceOperation();
	}

	@Then("Service should return the details of the Price service")
	public void service_should_return_the_details_of_the_Price_service() throws Throwable {
		int responseCode = Response.getStatusLine().getStatusCode();
		String errorMessage = Response.getStatusLine().getReasonPhrase();
		int responseCodeE = 200;
		System.out.println("PostMan Response Message is - " + errorMessage);
		assertEquals(responseCode, responseCodeE, " Product details requested doesn't exist. Response code");

		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		priceJson = objectMapper.readValue(Response.getEntity().getContent(), PricePO_PricePojo.class);

		System.out.println("Product Get Response:\n" + priceJson);

		basePrice = priceJson.getPrice().getRegularPrice();
		unitPrice = priceJson.getPrice().getSellingUEP();

		stockvo.getPriceDetails(basePrice, unitPrice);
		Thread.sleep(1500);

	}

	@Given("I click on Space section")
	public void i_click_on_Space_section() throws Throwable {
		stockvo.clickSpace();
	}

	@Then("I verify the details on the space Page")
	public void i_verify_the_details_on_the_space_Page() throws Throwable {
		stockvo.clickNextPage();
	}

	@Then("I verify the record from the list")
	public void i_verify_the_record_from_the_list() throws Throwable {
		stockvo.selectFromDropDown();
	}

	@Then("I verify the table values")
	public void i_verify_the_table_values() throws Throwable {
		stockvo.insidePageDetails();
	}

	@When("Request is made into Delivery service")
	public void request_is_made_into_Delivery_service() throws Throwable {
		Response = stockvo.performOperation();
	}

	@Then("Service should return the details of the Delivery service")
	public void service_should_return_the_details_of_the_Delivery_service() throws Throwable {
		int responseCode = Response.getStatusLine().getStatusCode();
		String errorMessage = Response.getStatusLine().getReasonPhrase();
		int responseCodeE = 200;
		System.out.println("PostMan Response Message is - " + errorMessage);
		assertEquals(responseCode, responseCodeE, " Product details requested doesn't exist. Response code");

		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		deliveryJson = objectMapper.readValue(Response.getEntity().getContent(), DeliveryPO_Orders.class);

		System.out.println("Product Get Response:\n" + deliveryJson);
		System.out.println("Customer details = " + deliveryJson.getOrders().get(0).getCustomerId());
		System.out.println("lastDelDatefromService = " + lastDelDatefromService);
		orderedQtyfromService = (deliveryJson.getOrders().get(0).getLines().getStatus().get(0).getOrdered()
				.getQuantity()).toString();
		System.out.println("orderedQtyfromService = " + orderedQtyfromService);
		delQtyfromService = (deliveryJson.getOrders().get(0).getLines().getStatus().get(0).getReceipted().getQuantity())
				.toString();
		System.out.println("delQtyfromService = " + delQtyfromService);

		System.out.println("nextDelDatefromService = " + nextDelDatefromService);


		orderPosition = (deliveryJson.getOrders().get(0).getOrderPosition()).toString();
		System.out.println("orderPosition = " + orderPosition);

		if(orderPosition.equalsIgnoreCase("next")) {
			nextDelDatefromService = deliveryJson.getOrders().get(0).getLines().getDelivery().getDateDeliveryExpected();
			lastDelDatefromService = null;
		}
		else if(orderPosition.equalsIgnoreCase("last")){
			lastDelDatefromService = deliveryJson.getOrders().get(0).getLines().getDelivery().getDateDeliveryExpected();
			nextDelDatefromService = null;
		}
		try {
			if (!lastDelDatefromService.equalsIgnoreCase(null)) {
				Date dates = new SimpleDateFormat("yyyy-MM-dd").parse(lastDelDatefromService);
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				lastDatefromService = formatter.format(dates);
				System.out.println(lastDatefromService);
				lastOrderQtyfromService = (deliveryJson.getOrders().get(0).getLines().getStatus().get(0).getOrdered()
						.getQuantity()).toString();
				System.out.println("lastOrderQtyfromService = " + lastOrderQtyfromService);
			} else {
				lastDatefromService = "N/A";
			}
		}
		catch(NullPointerException ne){
			lastDatefromService = "N/A";
		}
		try{
			if (!nextDelDatefromService.equalsIgnoreCase(null)) {
				Date dates2 = new SimpleDateFormat("yyyy-MM-dd").parse(nextDelDatefromService);
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				nextDatefromService = formatter.format(dates2);
				System.out.println(nextDatefromService);
				nextOrderQtyfromService = (deliveryJson.getOrders().get(0).getLines().getStatus().get(0).getOrdered()
						.getQuantity()).toString();
				System.out.println("nextOrderQtyfromService = " + nextOrderQtyfromService);
			} else {
				nextDatefromService = "N/A";
			}
		}
		catch(NullPointerException nn){
			nextDatefromService = "N/A";
			nextOrderQtyfromService = "0";
		}

		List<DeliveryPO_Orderss> orders = deliveryJson.getOrders();
		for(DeliveryPO_Orderss order : orders){
			DeliveryPO_Lines lines = order.getLines();
			quantityType = lines.getQuantityType();
			break;
		}
	}

	@Given("Then I verify the details with endpoints")
	public void then_I_verify_the_details_with_endpoints() throws Throwable {

		String orderQtyExpected;
		String delQtyExpected;
		String nextOrderQtyExpected,lastOrderQtyExpected;
		int nextOrderQty=0, lastOrderQty = 0;
		int packQty = Integer.parseInt(packQuantity);
		if(quantityType.equals("PACK") || quantityType.equals("Pack")){
			int orderedQty = Integer.parseInt(orderedQtyfromService)*packQty;
			int delQty = Integer.parseInt(delQtyfromService)*packQty;
			if(nextOrderQtyfromService!=null) {
				nextOrderQty = Integer.parseInt(nextOrderQtyfromService) * packQty;
			}
			if(lastDelDatefromService!=null) {
				lastOrderQty = Integer.parseInt(lastOrderQtyfromService) * packQty;
			}

			orderQtyExpected = String.valueOf(orderedQty);
			delQtyExpected = String.valueOf(delQty);
			nextOrderQtyExpected = String.valueOf(nextOrderQty);
			lastOrderQtyExpected = String.valueOf(lastOrderQty);
		}
		else{
			orderQtyExpected = lastDatefromService;
			delQtyExpected = delQtyfromService;
			nextOrderQtyExpected = nextOrderQtyfromService;
			lastOrderQtyExpected = lastOrderQtyfromService;
		}
		assertEquals(lastDelDatefromApp, lastDatefromService, " Last Delivery date does not match");	
		assertEquals(orderedQtyfromApp, orderQtyExpected, "  Orderded Qty does not match");
		assertEquals(delQtyfromApp, delQtyExpected, "Delivered Qty does not match");
		assertEquals(nextDelDatefromApp, nextDatefromService, "Next Delivery date does not match");
		assertEquals(nextOrderQtyfromApp, nextOrderQtyExpected, "Delivered Qty does not match");
		assertEquals(lastOrderQtyfromApp, lastOrderQtyExpected, "Delivered Qty does not match");
	}

	@Then("I scroll Down")
	public void i_scroll_Down() throws Throwable {
		stockvo.scrollDown();
	}

	@Then("I scroll Down to out of code")
	public void i_scroll_Down_to_out_of_code() throws Throwable {
		stockvo.scrollDown1();
	}

	@Then("Then I verify dates and qty")
	public void then_I_verify_dates_and_qty() throws Throwable {
		stockvo.detialsverify();
	}

	public static void getDetails(String lastDelDate, String orderedQty, String delQty, String nextDelDate,
								  String nextOrderQty, String lastOrderQty) throws Throwable {
		lastDelDatefromApp = lastDelDate;
		orderedQtyfromApp = orderedQty;
		delQtyfromApp = delQty;
		nextDelDatefromApp = nextDelDate;
		nextOrderQtyfromApp = nextOrderQty;
		lastOrderQtyfromApp = lastOrderQty;
	}

	@Given("ProductId {string} and StoreID {string} is included in the Stock Service")
	public void productid_and_StoreID_is_included_in_the_Stock_Service(String arg1, String arg2) throws Throwable {
		stockvo.getStockInfo(arg1, arg2);
	}

	@When("Request is made into Stock service")
	public void request_is_made_into_Stock_service() throws Throwable {
		Response = stockvo.performGetStockOperation();
		System.out.println("Stock service response is : " + Response);
	}

	@Then("Service should return the details of the Stock service")
	public void service_should_return_the_details_of_the_Stock_service() throws Throwable {
		int responseCode = Response.getStatusLine().getStatusCode();
		String errorMessage = Response.getStatusLine().getReasonPhrase();
		int responseCodeE = 200;
		System.out.println("PostMan Response Message is - " + errorMessage);
		assertEquals(responseCode, responseCodeE, " Product details requested doesn't exist. Response code");

		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		stockJson = objectMapper.readValue(Response.getEntity().getContent(), StockV2Pojo.class);

		System.out.println("Product Get Response:\n" + stockJson);
		
		//Get quantity details from Stock info api
		startingPosition = stockJson.getStartingPosition().get(0).getQty();
		stockPosition = stockJson.getStockPosition().get(0).getQty();
		System.out.println("startingPosition = " + startingPosition + " stockPosition = " + stockPosition);
		stockvo.dataFromendpoint(startingPosition, stockPosition);

	}


	@Given("I Verify that if No record present the status is displayed as UPDATING")
	public void i_Verify_that_if_No_record_present_the_status_is_displayed_as_UPDATING() throws Throwable {
		stockvo.stockVerifyDetails();
	}

	@Given("I click on Stock record")
	public void i_click_on_Stock_record() throws Throwable {
		stockvo.stockVerifyClick();
	}

	@Given("I verify Stock info page is displayed as expected")
	public void i_verify_Stock_info_page_is_displayed_as_expected() throws Throwable {
		stockvo.stockVerifyDetails();
	}

	@Given("I Verify that  record present with value")
	public void i_Verify_that_record_present_with_value() throws Throwable {
		stockvo.stockVerifyDataDetails();
	}

	@Given("I verify Stock info page is displayed as expected for the records")
	public void i_verify_Stock_info_page_is_displayed_as_expected_for_the_records() throws Throwable {
		Thread.sleep(1000);
	}

	@Then("I verify product onscreen details with the service")
	public void verifyProductUIDetailsWithServices() throws Throwable
	{
		stockvo.verifyUIDetailsWithServices();
	}

	@Then("I verify that Simple Promotion details is present")
	public void verifySimplePromotionDetails() throws Throwable {
		stockvo.verifySimplePromotion();
	}

	@Then("I verify that Complex Promotion details is present")
	public void verifyComplexPromotionDetails() throws Throwable {
		stockvo.verifyComplexPromotion();
	}

	@Then("I verify that More points details is present")
	public void verifyMorePointsDetails() throws Throwable {
		stockvo.verifyMorePoints();
	}


	@And("I verify Last Capture Type is {string}")
	public void verifyLastCaptureType(String captureType) throws Throwable {
		stockvo.verifyLastCapture(captureType);
	}

	@And("I verify Date and User details for Last capture")
	public void verifyDateAndUser() throws Throwable {
		stockvo.verifyDateAndUser();
	}

	@And("I verify Counted column and counted quantity {string} for last capture are present")
	public void verifyCountedColumnDetails(String quantity) throws Throwable {
		stockvo.verifyCountedColumnDetails(quantity);
	}
	
	@And("I get Stock value")
	public void getStockValue() throws Throwable {
		getStockValue = stockvo.getStockValue().trim();
		System.out.println("Stock value on UI : " + getStockValue);
	}

	@Given("Request is made to verify Product Id {string} is included in the service")
	public void requestIsMadeToVerifyProductIdIsIncludedInTheService(String arg1) throws Throwable {

		List<String> itemsList = Arrays.asList(arg1.split("\\s*,\\s*"));
		int count = itemsList.size();


		prdtID = itemsList.get(0);
		stockvo.min(prdtID);
		stockvo.getProductInfo(prdtID);

	}
}
