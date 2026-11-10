package com.morrisons.sma.step_definitions.mobile.old;

import static com.morrisons.sma.step_definitions.service.Product.API_ServiceStepDef.sRespData;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;


import com.morrisons.sma.step_definitions.service.old.RestAssuredSteps;

import org.apache.http.HttpResponse;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.morrisons.sma.page_objects.mobile.old.MarkDownPO;
import com.morrisons.sma.page_objects.mobile.old.StockInformationPO;
import com.morrisons.sma.pojo.service.MarkdownPOJO.MarkdownEventVo;
import com.morrisons.sma.pojo.service.MarkdownPOJO.MarkdownLogin;
import com.morrisons.sma.pojo.service.MarkdownPOJO.MarkdownLoginVo;
import com.morrisons.sma.pojo.service.MarkdownPOJO.MarkdownMax;
import com.morrisons.sma.pojo.service.MarkdownPOJO.MarkdownVO;
import com.morrisons.sma.pojo.service.MarkdownPOJO.UnprintedMarkdownEvent;
import com.morrisons.sma.pojo.service.PricePrompPOJO.MainWalkId;
import com.morrisons.sma.pojo.service.PricePrompPOJO.PrinterPojo;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.Glh_WalkIdMain;
import com.morrisons.sma.page_objects.service.CountServiceData;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import com.morrisons.common.utility.GLHserviceRequest;
import com.morrisons.common.utility.MarkdownServiceData;

public class MarkdownStepDef {
	ObjectMapper objectMapper = new ObjectMapper();
	public static HttpResponse Response;
	public static io.restassured.response.Response restResponse;
	MarkdownLoginVo mDLoginJsonResp = new MarkdownLoginVo();
	RestAssuredSteps loginTocken = new RestAssuredSteps();
	MarkdownVO markdownJsonResp = new MarkdownVO();
	MarkdownVO markdownJsonResp1 = new MarkdownVO();
	MarkdownVO markdownJsonResp2 = new MarkdownVO();
	MarkdownVO markdownJsonResp3 = new MarkdownVO();
	MarkdownMax maxMarkdown = new MarkdownMax();
	MainWalkId walkidGet = new MainWalkId();
	Glh_WalkIdMain getwalkId = new Glh_WalkIdMain();
	static String newWalkID ;
	public static String prdtId;
	
	CountPostStepDefService counts = new CountPostStepDefService();
	
	MarkdownEventVo markdownEventResp = new MarkdownEventVo();
	String accessTocken;
	String accessTockenGLH;
	String markdownBarcodeTest;
	String complete;
	String tokenaccess;
	public static String optiumPriceApp ;
	public static String appQty ;
	public static String noCalPrice;
	public static String restpayload;
	public static Glh_WalkIdMain restresponse;
	public static int restStatus;
	
	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
	String collegueUsername = applicationConfig.getUserCredentials().getCollegueUsername();
	String colleguePassword = applicationConfig.getUserCredentials().getColleguePassword();
	String managerUsername = applicationConfig.getUserCredentials().getManagerUsername();
	String managerPassword = applicationConfig.getUserCredentials().getManagerPassword();


	/*@Given("Request is made to Markdown Login service")
	public void request_is_made_to_Markdown_Login_service() throws Throwable {

	    // Write code here that turns the phrase above into concrete actions
		MarkdownLogin mdLgoin=new MarkdownLogin();
		mdLgoin.setUserName("44445555");
		
		mdLgoin.setPassword("741147");

		mdLgoin.setProvider("morrisons");
		String mdLoginBody = objectMapper.writeValueAsString(mdLgoin);
		System.out.println("Payload body is " + mdLoginBody);
		MarkdownServiceData.postLoginForMarkdown(mdLoginBody);
		Response = MarkdownServiceData.postOperationForMdLogin();
		Thread.sleep(500);
	}*/
	
	@Given("Request is made to Markdown Login service")
	public void request_is_made_to_Markdown_Login_service() throws Throwable {
		MarkdownLogin mdLgoin=new MarkdownLogin();
		mdLgoin.setUserName(collegueUsername);	
		mdLgoin.setPassword(colleguePassword);
		mdLgoin.setProvider("morrisons");
		String mdLoginBody = objectMapper.writeValueAsString(mdLgoin);
		System.out.println("Payload body is " + mdLoginBody);
		MarkdownServiceData.postLoginForMarkdown(mdLoginBody);
		Response = MarkdownServiceData.postOperationForMdLogin();
		Thread.sleep(500);
	}

	@Given("Request is made to Markdown Login service with user role Manager")
	public void request_is_made_to_Markdown_Login_service_with_user_role_Manager() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		MarkdownLogin mdLgoin = new MarkdownLogin();
		mdLgoin.setUserName(managerUsername);
		mdLgoin.setPassword(managerPassword);
		mdLgoin.setProvider("morrisons");
		String mdLoginBody = objectMapper.writeValueAsString(mdLgoin);
		System.out.println("Payload body is " + mdLoginBody);
		MarkdownServiceData.postLoginForMarkdown(mdLoginBody);
		Response = MarkdownServiceData.postOperationForMdLogin();
		
	}
	
 @Given("Request is made to Markdown Login service with user role colleague")
	public void request_is_made_to_Markdown_Login_service_with_user_role_colleague() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		MarkdownLogin mdLgoin = new MarkdownLogin();
		mdLgoin.setUserName(collegueUsername);
		mdLgoin.setPassword(colleguePassword);
		mdLgoin.setProvider("morrisons");
		String mdLoginBody = objectMapper.writeValueAsString(mdLgoin);
		System.out.println("Payload body is " + mdLoginBody);
		MarkdownServiceData.postLoginForMarkdown(mdLoginBody);
		Response = MarkdownServiceData.postOperationForMdLogin();
		
	}

	@When("the request is made to the specified Markdown Post service")
	public void the_request_is_made_to_the_specified_Markdown_Post_service(String storeId,String min,String payloadParam) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		PrinterPojo printer = new PrinterPojo();
//		printer.setMarkdownEventIds("0");
		printer.setPrinterId("XXQPJ172200016");
		String printerBody = objectMapper.writeValueAsString(printer);
		System.out.println("Payload body is " + printerBody);
		//MarkdownServiceData.postMarkdownPrint(printerBody);
		Response = MarkdownServiceData.performPostOperationForMarkdownPrint();
	
	}

	@When("the  post request is made to the specified get Markdown service for specific {string} and {string}")
	public void the_post_request_is_made_to_the_specified_get_Markdown_service_for_specific_and(String user,String storeId) throws Throwable {
	   // Write code here that turns the phrase above into concrete actions
	// Write code here that turns the phrase above into concrete actions

	String storeid = storeId;
	String userid = user;
	MarkdownServiceData.postMarkdownPrint(userid,storeid);
	Response = MarkdownServiceData.performPostOperationForMarkdownPrint();
	Thread.sleep(500);

	}

	@Then("the service should return details for specified Markdown service")
	public void the_service_should_return_details_for_specified_Markdown_service() throws Throwable {
	int responseCode = Response.getStatusLine().getStatusCode();
	String errorMessage = Response.getStatusLine().getReasonPhrase();
	int responseCodeE = 201;

	System.out.println("PostMan Response Message is - " + errorMessage);
	assertEquals(responseCode, responseCodeE, " Product details requested doesn't exist. Response code");
	mDLoginJsonResp = objectMapper.readValue(Response.getEntity().getContent(), MarkdownLoginVo.class);
	String ProductJSONresult = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mDLoginJsonResp);
	System.out.println("Markdown Login Response:\n" + ProductJSONresult);
	Thread.sleep(500);
	}


	@Then("The service should return details for Login Service")
	public void the_service_should_return_details_for_Login_Service() throws Throwable {
		// Write code here that turns the phrase above into concrete actions


		int responseCode = Response.getStatusLine().getStatusCode();
		String errorMessage = Response.getStatusLine().getReasonPhrase();
		int responseCodeE = 200;
		System.out.println("Error Message is - " + errorMessage);
		assertEquals(responseCode, responseCodeE, " Product details requested doesn't exist. Response code");

		objectMapper.setSerializationInclusion(Include.NON_NULL);
		mDLoginJsonResp = objectMapper.readValue(Response.getEntity().getContent(), MarkdownLoginVo.class);
		String ProductJSONresult = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mDLoginJsonResp);
		System.out.println("Markdown Login Response:\n" + ProductJSONresult);
		Thread.sleep(500);
	}

	@Then("Get the generated accessTocken")
	public void get_the_generated_accessTocken() throws Throwable {
//		accessTocken = mDLoginJsonResp.getAccessToken();
		accessTocken = sRespData.get("access_token");
		System.out.println("Access Tocken is " + accessTocken);
		RestAssuredSteps.getaccess(accessTocken);
		CountServiceData.getAccessToken(accessTocken);
		GLHserviceRequest.getAccessTokenGLH(accessTocken);
		StockInformationPO.getaccessStock(accessTocken);
		Thread.sleep(500);
	}

	@Given("a Store ID {string} and Product ID {string} is included in Markdown Service request")
	public void a_Store_ID_and_Product_ID_is_included_in_Markdown_Service_request(String storeId, String min)
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		MarkdownServiceData.getMarkdown(storeId, min, accessTocken);
		Thread.sleep(500);
		
	}
	
	public static void generateWalkId(String walkID)throws Throwable {
		newWalkID = walkID;
		System.out.println("Walk id from Post " + newWalkID);
	}
	
	@Given("a Store ID {string} and StoreWalk ID {string} is included in GLH Service request")
	public void a_Store_ID_and_StoreWalk_ID_is_included_in_GLH_Service_request(String storeId, String walkid) throws Throwable {
	    
		MarkdownServiceData.getWalkIdDetails(storeId, newWalkID, accessTocken);
	}

	@When("the request is made to the specified get GLH storewalk service")
	public void the_request_is_made_to_the_specified_get_GLH_storewalk_service() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		restResponse = MarkdownServiceData.getWalkId();
	}

	@Then("The service should return details for Get GLH storewalk Service")
	public void the_service_should_return_details_for_Get_GLH_storewalk_Service() throws Throwable {
		int responseCodeE = 200;
		
		System.out.println("json response = " + restpayload + "Response is = " + restStatus );
		assertEquals(restStatus, responseCodeE, " GLH details requested doesn't exist. Response code");
		
		ArrayList<String> walkid=new ArrayList<String>();
		  walkid = restResponse.path("StoreWalkItems.walkid");
		 System.out.println("Walk id is new  = " + walkid );
		 		
		 prdtId = restresponse.getStoreWalkItems().get(0).getItems().get(0).getProductId();
			System.out.println("Product ID  = " + prdtId);
			counts.getProdtId(prdtId);
	}

	
	public static void getrestPayload(String code , int response  ){
		restpayload = code;
		restStatus = response;
	
	}
	
	public static void getrestresponse(Glh_WalkIdMain getWalkId2 , int response){
		restresponse = getWalkId2;
		restStatus = response;
	}
	
	@Given("a Store ID {string} and Product ID {string} is included in GLH Service request")
	public void a_Store_ID_and_Product_ID_is_included_in_GLH_Service_request(String storeId, String min) throws Throwable {
	    
	MarkdownServiceData.getWalkId(storeId, min, accessTocken);
	}

	@When("the request is made to the specified get Markdown service")
	public void the_request_is_made_to_the_specified_get_Markdown_service() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Response = MarkdownServiceData.performOperationMarkdown();
	}

	@When("the request is made to the specified get GLH service")
	public void the_request_is_made_to_the_specified_get_GLH_service() throws Throwable {
		MarkdownServiceData.restcall();
	}
	
	public static void getWalkidPayload (String body , int response){
		restpayload = body;
		restStatus = response;
	
	}
	
	
	
	@Then("The service should return details for Get GLH Service")
	public void the_service_should_return_details_for_Get_GLH_Service() throws Throwable {
		
		int responseCodeE = 200;
		System.out.println("json response = " + restpayload + "Response is = " + restStatus );
		assertEquals(restStatus, responseCodeE, " GLH details requested doesn't exist. Response code");
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		walkidGet = objectMapper.readValue(restpayload, MainWalkId.class);
		String walkIdResult = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(walkidGet);
		System.out.println("WalkID  Response:\n" + walkIdResult);
		
	}

	
	
	@Then("The service should return details for Get Markdown Service")
	public void the_service_should_return_details_for_Get_Markdown_Service() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		int responseCode = Response.getStatusLine().getStatusCode();
		String errorMessage = Response.getStatusLine().getReasonPhrase();
		int responseCodeE = 200;
		System.out.println("Error Message is - " + errorMessage);
		assertEquals(responseCode, responseCodeE, " MArkdown details requested doesn't exist. Response code");
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		
		markdownJsonResp = objectMapper.readValue(Response.getEntity().getContent(), MarkdownVO.class);
		
		
		String markdownResult = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(markdownJsonResp);
		System.out.println("Markdown Response:\n" + markdownResult);
		String firstMarkdownWindow = markdownJsonResp.getFirstMarkdownWindow();
		MarkDownnStepDef.firstMarkdownWindow(firstMarkdownWindow);
		
	}


	
	@Then("verify for unprinted details")
	public void verify_for_unprinted_details() throws Throwable {
	    
		int responseCode = Response.getStatusLine().getStatusCode();
		String errorMessage = Response.getStatusLine().getReasonPhrase();
		int responseCodeE = 200;
		System.out.println("Error Message is - " + errorMessage);
		assertEquals(responseCode, responseCodeE, " MArkdown details requested doesn't exist. Response code");
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		
		markdownJsonResp = objectMapper.readValue(Response.getEntity().getContent(), MarkdownVO.class);
		String markdownResult = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(markdownJsonResp);
		System.out.println("Markdown Response:\n" + markdownResult);
		
		System.out.println("Unprinted MarkDown Barcode = " + markdownJsonResp.getUnprintedMarkdownEvent().getMarkdownBarcode());
		
		markdownBarcodeTest = markdownJsonResp.getUnprintedMarkdownEvent().getMarkdownBarcode();
		MarkDownPO.useFirstMarkdownValue(markdownBarcodeTest);
		complete = markdownJsonResp.getUnprintedMarkdownEvent().getIsComplete();
		MarkDownnStepDef.callIsComplete(complete);
		Thread.sleep(500);
		Integer ID = Integer.parseInt(markdownJsonResp.getUnprintedMarkdownEvent().getId());
		System.out.println("ID received is = " + ID);
		MarkdownServiceData.markDownEventID(ID);
		Thread.sleep(500);
	}
	
	
	 @Then("I verify details in unprintedList")
	 public void i_verify_details_in_unprintedList() throws Throwable {
	    String markedDownPrice = markdownJsonResp.getUnprintedMarkdownEvent().getMarkedDownPrice();	   
	    String markdownCreatedDate = markdownJsonResp.getUnprintedMarkdownEvent().getMarkdownCreatedDate();
	    String quantity = markdownJsonResp.getUnprintedMarkdownEvent().getQuantity();
	    String optimisedPrice = markdownJsonResp.getUnprintedMarkdownEvent().getOptimisedPrice().getPrice().getMarkdownPrice();
	    String optimisedqty = markdownJsonResp.getUnprintedMarkdownEvent().getOptimisedPrice().getPrice().getQuantity();
	    String isOptimisedPriceUsed = markdownJsonResp.getUnprintedMarkdownEvent().getIsOptimisedPriceUsed();
	    String optimisedPriceApplicable = markdownJsonResp.getUnprintedMarkdownEvent().getOptimisedPriceApplicable();
	    String newmarkedDownPrice = "£0."+markedDownPrice;
	    String newoptimisedPrice = "£0."+optimisedPrice; 
	    
	    System.out.println("newmarkedDownPrice = " + newmarkedDownPrice);
	    assertEquals(newmarkedDownPrice, optiumPriceApp, "Qptimum Price Mismatch!!");
	    assertEquals(quantity, appQty, " Qptimum Qty Mismatch!!");
	    assertEquals(newoptimisedPrice, noCalPrice, " Qptimum Price Mismatch!!");
	    assertEquals(optimisedqty, appQty, " Qptimum Qty Mismatch!!");
	    assertEquals(isOptimisedPriceUsed, "Y", " Data mismatched!!");
	    assertEquals(optimisedPriceApplicable, "Y", " Data mismatched!!");
	    System.out.println("Assertions completed!");
		 
	   
	 }
	 
	 
	 
	 @Then("I verify that value has been updated as expected")
	 public void i_verify_that_value_has_been_updated_as_expected() throws Throwable {
		 
		 assertEquals("16", markdownJsonResp.getUnprintedMarkdownEvent().getQuantity(), " Qptimum Qty Mismatch!!");
		 System.out.println("New price updated !!");
	 }
	 
	 
	 @Then("I verify UnPrintedList for priceoverride")
	 public void i_verify_UnPrintedList_for_priceoverride() throws Throwable {
		 String markedDownPrice = markdownJsonResp.getUnprintedMarkdownEvent().getMarkedDownPrice();	   
		    String markdownCreatedDate = markdownJsonResp.getUnprintedMarkdownEvent().getMarkdownCreatedDate();
		    String quantity = markdownJsonResp.getUnprintedMarkdownEvent().getQuantity();
		    String optimisedPrice = markdownJsonResp.getUnprintedMarkdownEvent().getOptimisedPrice().getPrice().getMarkdownPrice();
		    String optimisedqty = markdownJsonResp.getUnprintedMarkdownEvent().getOptimisedPrice().getPrice().getQuantity();
		    String isOptimisedPriceUsed = markdownJsonResp.getUnprintedMarkdownEvent().getIsOptimisedPriceUsed();
		    String optimisedPriceApplicable = markdownJsonResp.getUnprintedMarkdownEvent().getOptimisedPriceApplicable();
		    String newmarkedDownPrice = "£0."+markedDownPrice;
		    String newoptimisedPrice = "£0."+optimisedPrice; 
		    String priceOverrideUsed =  markdownJsonResp.getUnprintedMarkdownEvent().getPriceOverrideUsed();
		    String priceOverrideReason = markdownJsonResp.getUnprintedMarkdownEvent().getPriceOverrideReason();
		    
		    
		    
		    System.out.println("newmarkedDownPrice = " + newmarkedDownPrice);
		    assertEquals(newmarkedDownPrice, optiumPriceApp, "Qptimum Price Mismatch!!");
		    assertEquals(quantity, appQty, " Qptimum Qty Mismatch!!");
		    assertEquals(newoptimisedPrice, noCalPrice, " Qptimum Price Mismatch!!");
		    assertEquals(optimisedqty, appQty, " Qptimum Qty Mismatch!!");
		    assertEquals(isOptimisedPriceUsed, "N", " Data mismatched!!");
		    assertEquals(optimisedPriceApplicable, "Y", " Data mismatched!!");
		    assertEquals(priceOverrideUsed, "Y", " Data mismatched!!");
		    assertEquals(priceOverrideReason, "Manager Override", " Data mismatched!!");
		    
		    System.out.println("Assertions completed!");
		 
	 }
	 
	 @Then("Verify that unprintedlist gets deleted from the service")
	 public void verify_that_unprintedlist_gets_deleted_from_the_service() throws Throwable {
	     
		 UnprintedMarkdownEvent  printedList = markdownJsonResp.getUnprintedMarkdownEvent();
		 System.out.println("Printed list is empty " + printedList);
		assertEquals(printedList, null, "UnprintedMarkdownEvent is displayed when data deleted !");
 }

	
	 @Then("I verify the productDetails {string} in printList")
	 public void i_erify_the_productDetails_in_printList(String arg1) throws Throwable {
		 MarkDownPO.prdtDetails();
	 }
	
	 public static void getPrdtdetails (String price, String qty){
		 
		  optiumPriceApp = price;
		  appQty = qty;
	 }
	  public static void getOldPrice (String oldprice){
		  
		  noCalPrice = oldprice;
		  
	  }
	 
	@Then("The service should return details for First Markdown")
	public void the_service_should_return_details_for_First_Markdown() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		int responseCode = Response.getStatusLine().getStatusCode();
		String errorMessage = Response.getStatusLine().getReasonPhrase();
		int responseCodeE = 200;
		System.out.println("Error Message is - " + errorMessage);
		assertEquals(responseCode, responseCodeE, " Product details requested doesn't exist. Response code");
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		markdownJsonResp1 = objectMapper.readValue(Response.getEntity().getContent(), MarkdownVO.class);
		String firstMarkdownResult = objectMapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(markdownJsonResp1);
		System.out.println("First Markdown Response:\n" + firstMarkdownResult);
	}


	@Given("a Store ID {string} and name {string} and items {string} and {string} is included in Count StoreWalk request- List")
	public void aStoreIDAndNameAndItemsAndIsIncludedInCountStoreWalkRequestList(String StoreID, String Name, String Items, String Mode) {
	}
}
