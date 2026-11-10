package com.morrisons.sma.step_definitions.service.old;

import com.morrisons.sma.page_objects.mobile.old.AWS_S3Upload;
import org.apache.http.HttpResponse;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import com.morrisons.sma.page_objects.service.StorewalkServicePage;


public class StorewalkStepDefService {


	private static final String Null = null;
	StorewalkServicePage storewalkServicePage = new StorewalkServicePage();
	private AndroidDriver driveR;
	public static String iscomplete;
	public static String windows;

	public static String accessToken = null;
	public static HttpResponse Response;

	@When("Request is made to SMA app login service for collegue user")
	public void requestMadeToSmaAppCollegueLogin() throws Throwable {
		storewalkServicePage.requestMadeToSmaAppCollegueLogin();
	}

	@When("Request is made to SMA app login service for manager user")
	public void requestMadeToSmaAppManagerLogin() throws Throwable {
		storewalkServicePage.requestMadeToSmaAppManagerLogin();
	}

	@When("Service should return details for SMA app Login Service")
	public void getSmaAppLoginServiceResponse() throws Throwable {
		storewalkServicePage.getSmaAppLoginServiceResponse();
	}

	@Then("Get the generated Access Tocken for SMA app Login Service")
	public void getGeneratedAccessTokenAppLogin() throws Throwable {
		accessToken = storewalkServicePage.getGeneratedAccessTokenAppLogin();
	}

	@When("Get Operation perform on service request")
	public void getServicePerformOperation() throws Throwable {
		Response = storewalkServicePage.getServicePerformOperation();
		System.out.println(Response);
	}

		@When("Post Operation perform on service request")
	public void postServicePerformOperation() throws Throwable {
		Response = storewalkServicePage.postServicePerformOperation();
		System.out.println(Response);
	}

	@When("Delete Operation perform on service request")
	public void deleteServicePerformOperation() throws Throwable {
		Response = storewalkServicePage.deleteServicePerformOperation();
		System.out.println(Response);
	}

	//// CreateStorewalk
	@When("Post request is made to Create storewalk service for store id {string} and type {string}")
	public void createStorewalkServiceUrl(String storeId, String type) throws Throwable {
		storewalkServicePage.createStorewalkServiceUrl(storeId, type);
	}

	@Then("Verify Create storewalk service response")
	public void createStorewalkServicesStatus() throws Throwable {
		storewalkServicePage.createStorewalkServicesStatus();
	}

	@When("Post request is made to Create storewalk service for store id {string}, type {string} and response type {string}")
	public void createStorewalkServiceUrl(String storeId, String type,String responseType) throws Throwable {
		storewalkServicePage.createStorewalkWithResponseTypeUrl(storeId, type,responseType);
	}

	@When("Post request is made to Create storewalk for negative prompt for store id {string} and type {string}")
	public void createStorewalkNegativePrompt(String storeId, String type) throws Throwable {
		storewalkServicePage.createStorewalkNegativePrompt(storeId, type);
	}


	////GetStorewalk
	@When("Get request is made to Get storewalk service for store id {string}")
	public void getStorewalkServiceUrl(String storeId) throws Throwable {
		storewalkServicePage.getStorewalkServiceUrl(storeId);
	}
	
	@When("Get request is made to Get storewalk service for Negative prompt product and store id {string}")
	public void getStorewalkServiceForNegativePrompt(String storeId) throws Throwable {
		storewalkServicePage.getStorewalkForNegativePrompt(storeId);
	}

	@When("Get request is made to Get storewalk service for store id {string} and attributes")
	public void getStorewalkServiceWithAttributeUrl(String storeId) throws Throwable {
		storewalkServicePage.getStorewalkServiceWithAttributeUrl(storeId);
	}

	@When("Get request is made to Get storewalk service for store id {string} and capture type {string}")
	public void getStorewalkServiceWithCaptureType(String storeId,String captureType) throws Throwable {
		storewalkServicePage.getStorewalkServiceWithCaptureType(storeId,captureType);
	}

	@Then("Verify Get storewalk service response")
	public void getGetStorewalkServicesResponse() throws Throwable {
		storewalkServicePage.getGetStorewalkServicesResponse();
	}
	
	@When("Get request is made to Get Count storewalk response for count name {string} and store id {string}")
	public void getStorewalkServiceCount(String countName,String storeId) throws Throwable {
		storewalkServicePage.getStorewalkServiceCount(countName,storeId);
	}
	
	@When("Get Walkid for Store id {string} and walk type {string}")
	public void getCountNameAndWalkID(String storeId,String walkType) throws Throwable {
		storewalkServicePage.getCountNameAndWalkID(storeId,walkType);
	}
	
	@Then("Verify Get count storewalk for count name {string} and store id {string}")
	public void getCountStorewalkServiceResponse(String countName,String storeId) throws Throwable {
		storewalkServicePage.getCountStorewalkServiceResponse(countName,storeId);
	}
	
	@Then("Verify Get count storewalk service response is same as post count storewalk body")
	public void verifyCountJSonResponseIsSame() throws Throwable {
		storewalkServicePage.verifyCountJSonResponseIsSame();
	}
	
	@Then("Verify Storewalk status as {string} is present in Get storewalk service response")
	public void verifyStorewalkStatus(String storewalkStatus) throws Throwable {
		storewalkServicePage.verifyStorewalkStatus(storewalkStatus);
	}
	
	@Then("Verify for {string} Count location status {string} is present in Get storewalk service response")
	public void verifyCountLocationStatus(String location,String locationStatus) throws Throwable {
		storewalkServicePage.verifyCountLocationStatus(location,locationStatus);
	}
	
	@Then("Verify for Product id {string} Count type {string} is present in Get storewalk service response")
	public void verifyProductCountType(String productId,String countType) throws Throwable {
		storewalkServicePage.verifyProductCountType(productId,countType);
	}
	
	@Then("Verify for Product id {string} Action type {string} is present in Get storewalk service response")
	public void verifyProductActionType(String productId,String actionType) throws Throwable {
		storewalkServicePage.verifyProductActionType(productId,actionType);
	}
	
	@Then("Verify for Product id {string} Range Status {string} is present in Get storewalk service response")
	public void verifyRangeStatus(String productId,String rangeStatus) throws Throwable {
		storewalkServicePage.verifyRangeStatus(productId,rangeStatus);
	}
	
	@Then("Verify store id {string} is not Curfew store")
	public void verifyNotCurfewStore(String storeId) throws Throwable {
		storewalkServicePage.verifyNotCurfewStore(storeId);
	}
	
	@Then("Verify store id {string} is Curfew store")
	public void verifyCurfewStore(String storeId) throws Throwable {
		storewalkServicePage.verifyCurfewStore(storeId);
	}

	
	///// Post storewalk

	@Given("Data for Post storewalk service is Product {string}, location {string}, Quantity {string} and capture type {string}")
	public void postStorewalkData(String Product,String location,int quantity,String captureType) throws Throwable {
		storewalkServicePage.postStorewalkData(Product,location,quantity,captureType);
	}
	
	@When("Post request is made to Post storewalk service for store id {string}")
	public void postStorewalkServiceUrl(String storeId) throws Throwable {
		storewalkServicePage.postStorewalkServiceUrl(storeId);
	}


	////GetStorewalksss
	@When("Get request is made to Get storewalks service for current date")
	public void getStorewalksssServiceUrl() throws Throwable {
		storewalkServicePage.getStorewalksssServiceUrl();
	}
	
	@When("Get Walkids from Getstorewalk service Store id {string}")
	public void getWalkId(String storeId) throws Throwable {
		storewalkServicePage.getWalkId(storeId);
	}

	@Then("Verify Get storewalks service response for current date")
	public void getGetStorewalksssServicesResponse() throws Throwable {
		storewalkServicePage.getGetStorewalksssServicesResponse();
	}


	@Then("Verify Get storewalks service response for current date for store id {string}")
	public void getStorewalkStoreResponse(String storeId) throws Throwable {
		storewalkServicePage.getStorewalkStoreResponse(storeId);
	}


	@Then("Verify Get storewalks service response for Negative prompt and store id {string}")
	public void getstorewalkNegativePromptResponse(String storeId) throws Throwable {
		storewalkServicePage.getstorewalkNegativePromptResponse(storeId);
	}

	@Then("Verify Get storewalks service response for store id {string}")
	public void verifyGetStorewalkResponse(String storeId) throws Throwable {
		storewalkServicePage.verifyGetStorewalkResponse(storeId);
	}
	
	@Then("I verify Product id {string} for Store id {string} and Walk type {string} is present in Get storewalk service")
	public void verifyProductInStorewalkApi(String productId, String storeId, String walkType) throws Throwable {
		storewalkServicePage.verifyProductInStorewalkApi(productId,storeId,walkType);
	}
	
	@Then("I verify Capture details in storewalk for Product id {string} is Capture type {string} Capture status {string} and Capture quantity {string}")
	public void verifyProductCaptureDetails(String productId, String captureType, String captureStatus, String captureQty) throws Throwable {
		storewalkServicePage.verifyProductCaptureDetails(productId,captureType,captureStatus,captureQty);
	}
	
	
	@Then("I verify Section status is {string} in Get storewalk service")
	public void verifySectionStatus(String sectionStatus) throws Throwable {
		storewalkServicePage.verifySectionStatus(sectionStatus);
	}

	@Then("I Get Group name and product id from GetStorewalk Service")
	public void getGroupAndProductId() throws Throwable {
		storewalkServicePage.getGroupAndProductId();
	}



	@Then("I verify GLH create Items with reason as ‘NegativeStock’ in GetStorewalks service response")
	public void verifyNegativeStockStatus() throws Throwable {
		storewalkServicePage.verifyNegativestockReason();
	}
	

	////DeleteStorewalk
	@When("Delete request is made to Delete storewalks for store id {string}")
	public void deleteStorewalkServiceUrl(String storeId) throws Throwable {
		storewalkServicePage.deleteStorewalkServiceUrl(storeId);
	}

	@Then("Verify delete storewalk service response code")
	public void verifyDeleteServiceResponseCode() throws Throwable {
		storewalkServicePage.verifyDeleteServiceResponseCode();
	}

	////CreateWalkitem
	@When("Post request is made to Create walkitem service for store id {string} and product id {string}")
	public void createWalkitemServiceUrl(String storeId,String productId) throws Throwable {
		storewalkServicePage.createWalkitemServiceUrl(storeId, productId);
	}

	@When("Post request is made to Create walkitem service without payload for store id {string}")
	public void createWalkitemWithoutPayload(String storeId) throws Throwable {
		storewalkServicePage.createWalkitemWithoutPayload(storeId);
	}

	@When("Post request is made to Create walkitem service with invalid payload for store id {string} and product id {string}")
	public void createWalkitemInvalidPayload(String storeId,String productId) throws Throwable {
		storewalkServicePage.createWalkitemInvalidPayload(storeId,productId);
	}

	@Then("Verify Create walkitem service response")
	public void createWalkitemServicesResponse() throws Throwable {
		storewalkServicePage.createWalkitemServicesResponse();
	}

	@Then("^Verify Create walkitem service response is \"(.*)\"$")
	public void createWalkitemResponse(int iRespCode) throws Throwable {
		storewalkServicePage.createWalkitemResponse(iRespCode);
	}

	@When("Post request is made to Create walkitem service for store id {string} ,product id {string} and empty storewalk")
	public void createWalkitemWithEmptyStorewalk(String storeId,String productId) throws Throwable {
		storewalkServicePage.createWalkitemWithEmptyStorewalk(storeId, productId);
	}

	@When("Verify service response code is 400")
	public void verifyAPIResponse400() throws Throwable {
		storewalkServicePage.verifyAPIResponse400();
	}

	@When("Verify service response code is 401")
	public void verifyAPIResponse401() throws Throwable {
		storewalkServicePage.verifyAPIResponse401();
	}

	@When("Verify service response code is 400,404")
	public void verifyAPIResponse400Or404() throws Throwable {
		storewalkServicePage.verifyAPIResponse400Or404();
	}

	@When("Verify service response code is 404")
	public void verifyAPIResponse404() throws Throwable {
		storewalkServicePage.verifyAPIResponse404();
	}

	@When("Verify service response code is 200")
	public void verifyAPIResponse200() throws Throwable {
		storewalkServicePage.verifyAPIResponse200();
	}
	
	@When("Verify service response code is 200/201")
	public void verifyAPIResponse200Or201() throws Throwable {
		storewalkServicePage.verifyAPIResponse200Or201();
	}

	@When("Verify service response code is 400,401")
	public void verifyAPIResponse400Or401() throws Throwable {
		storewalkServicePage.verifyAPIResponse400Or401();
	}



	@Then("I verify locations attribute is not present in create walkitem service response")
	public void verifyLocatioAttributeNotPresent() throws Throwable {
		storewalkServicePage.verifyLocatioAttributeNotPresent();
	}

	@Then("Verify same product is not allowed to create walkitem for MarketStreetGapsHighsLows and GapsHighsLows walktype")
	public void createWalkitemResponseIs409() throws Throwable {
		storewalkServicePage.createWalkitemResponseIs409();
	}

	////CreateWalkitem with Location
	@When("Post request is made to Create walkitem service for store id {string} ,product id {string} and location {string}")
	public void createWalkitemServiceUrl(String storeId,String productId,String locationn) throws Throwable {
		storewalkServicePage.createWalkitemWithLocation(storeId, productId,locationn);
	}

	@Given("Post request is made to Create walkitem service for store id {string} and multiple product ids {string},{string}")
	public void createWalkitemFor2ProductsUrl(String storeId,String productId1,String productId2) throws Throwable {
		storewalkServicePage.createWalkitemFor2ProductsUrl(storeId, productId1, productId2);
	}

	@Given("Post request is made to Multiple product Create walkitem service for store id {string} and 10 product ids {string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
	public void createWalkitemFor10ProductsUrl(String storeId,String productId1,String productId2,String productId3,String productId4,String productId5,String productId6,String productId7,String productId8,String productId9,String productId10) throws Throwable {
		storewalkServicePage.createWalkitemFor10ProductsUrl(storeId, productId1, productId2,productId3,productId4,productId5,productId6,productId7,productId8,productId9,productId10);
	}

	@Given("Post request is made to Multiple product Create walkitem service for store id {string} and more than product ids {string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
	public void createWalkitemFor11ProductsUrl(String storeId,String productId1,String productId2,String productId3,String productId4,String productId5,String productId6,String productId7,String productId8,String productId9,String productId10,String productId11) throws Throwable {
		storewalkServicePage.createWalkitemFor11ProductsUrl(storeId, productId1, productId2,productId3,productId4,productId5,productId6,productId7,productId8,productId9,productId10,productId11);
	}

	//	@Then("Verify Create walkitem for multiple products service response")
	//	public void createWalkitemMultipleDataResponse() throws Throwable {
	//		storewalkServicePage.createWalkitemMultipleDataResponse();
	//	}

	///GetWalkitem service url
	@Given("Get request is made to Get walkItem service for store id {string} and product id {string}")
	public void getWalkItemServiceUrl(String storeId,String productId) throws Throwable {
		storewalkServicePage.getWalkItemServiceUrl(storeId,productId);
	}
	
	///GetWalkitem service for COUNT walkid url
	@Given("Get request is made to Get walkItem service for count name {string}, store id {string} and product id {string}")
	public void getWalkItemForCountUrl(String countName,String storeId,String productId) throws Throwable {
		storewalkServicePage.getWalkItemForCountUrl(countName,storeId,productId);
	}

	@Then("Verify Get walkitem service response")
	public void getWalkitemServicesResponse() throws Throwable {
		storewalkServicePage.getWalkitemServicesResponse();
	}
	
	@Then("Get the walk id for {string}")
	public void getWalkIdForGLH(String sType) throws Throwable {
		storewalkServicePage.getWalkIdForGLH(sType);
	}
	

	@Then("I Verify Get walkitem UOM {string},Count Type {string}, SOH and Action Type {string}")
	public void i_Verify_Get_walkitem_plan_SOH_and(String uom, String countType, String actionType) throws Throwable {
		storewalkServicePage.verifyWalkitemServiceAttributes(uom, countType, actionType);

	}

	@Then("I verify Get walkitem pack is present or not")
	public void i_verify_Get_walkitem_pack_is_present_or_not() throws Throwable {
		storewalkServicePage.verifygetwalkitePack();
	}


	////CreateCapture
	@When("Post request is made to Create capture service for store id {string}, product id {string}, location {string}, value {string}, section id {string} and capture type {string}")
	public void createCaptureServiceUrl(String storeId,String productId,String location,int value,int sectionId,String captureType) throws Throwable {
		storewalkServicePage.createCaptureServiceUrl(storeId, productId,location,value,sectionId,captureType);
	}

	@Then("Verify Create capture service response")
	public void createCaptureServicesResponse() throws Throwable {
		storewalkServicePage.createCaptureServicesResponse();
	}

	@Then("Verify Captures as zero value for the items")
	public void verifyCaptureAsZero() throws Throwable {
		storewalkServicePage.verifyCaptureAsZero();
	}

	@Then("Verify Capture value and status as 'Incomplete' At Backup location")
	public void incompleteCaptureAtBackup() throws Throwable {
		storewalkServicePage.incompleteCaptureAtBackup();
	}

	@Then("Verify Capture value and status as 'Incomplete' At Counter location")
	public void incompleteCaptureAtCounter() throws Throwable {
		storewalkServicePage.incompleteCaptureAtCounter();
	}

	@Then("Verify Capture value and status as 'Incomplete' At Other location")
	public void incompleteCaptureAtOther() throws Throwable {
		storewalkServicePage.incompleteCaptureAtOther();
	}

	@Then("Verify Capture Audit information is persisted inline with capture")
	public void verifyAuditInformation() throws Throwable {
		storewalkServicePage.verifyAuditInformation();
	}

	///GetCapture
	@When("Get request is made to Get capture service for store id {string} and product id {string}")
	public void getCapturesServiceUrl(String storeId,String productId) throws Throwable {
		storewalkServicePage.getCapturesServiceUrl(storeId,productId);
	}

	@Then("Verify Get capture service response")
	public void getCapturesServicesResponse() throws Throwable {
		storewalkServicePage.getCapturesServicesResponse();
	}

	///GetAllCapture
	@When("Get request is made to Get all capture service for store id {string}")
	public void getAllCapturesServiceUrl(String storeId) throws Throwable {
		storewalkServicePage.getAllCapturesServiceUrl(storeId);
	}

	@Then("Verify Get all capture service response")
	public void getAllCapturesServicesResponse() throws Throwable {
		storewalkServicePage.getAllCapturesServicesResponse();
	}

	///GetSections
	@When("Get request is made to Get section service for store id {string}")
	public void getSectionsServiceUrl(String storeId) throws Throwable {
		storewalkServicePage.getSectionsServiceUrl(storeId);
	}

	@When("Get request is made to Get section service for store id {string} and capture type {string}")
	public void getSectionsServiceWithCaptureType(String storeId,String captureType) throws Throwable {
		storewalkServicePage.getSectionsServiceWithCaptureType(storeId,captureType);
	}

	@Then("Verify Get section service response")
	public void getSectionsServicesResponse() throws Throwable {
		storewalkServicePage.getSectionsServicesResponse();
	}

	@Then("Verify Get section service response with captures")
	public void getSectionsServicesResponseWithCaptures() throws Throwable {
		storewalkServicePage.getSectionsServicesResponseWithCaptures();
	}

	@When("Post Operation perform on service request with Incorrect header")
	public void inCorrectPostServicePerformOperation() throws Throwable {
		Response = storewalkServicePage.inCorrectPostServicePerformOperation();
		System.out.println(Response);
	}

	@When("Get Incorrect access token")
	public void getIncorrectAccessTokenAppLogin() throws Throwable {
		accessToken = storewalkServicePage.getIncorrectAccessTokenAppLogin();
	}
	@And("I verify Capturetype attribute is excluded from the Get Storewalk API response")
	public void verifyCaptureAttributeIsExluded() throws Throwable {
		storewalkServicePage.verifyCaptureAttributeIsExluded();
	}
	
	@And("I verify Capturetype attribute is excluded from the Get Section API response")
	public void verifyCaptureInSectionApi() throws Throwable {
		storewalkServicePage.verifyCaptureInSectionApi();
	}


	@When("Delete request is made to Delete GLH storewalk for store id {string}")
	public void deleteGLHStorewalk(String storeId) throws Throwable {
		storewalkServicePage.deleteGLHStorewalk(storeId);
	}

	@Then("Verify Create walkitem service response is 201/200")
	public void createWalkitemResponseIs201Or200() throws Throwable {
		storewalkServicePage.createWalkitemResponseIs201Or200();
	}

	@When("Verify service response code is 500")
	public void verifyAPIResponse500() throws Throwable {
		storewalkServicePage.verifyAPIResponse500();
	}

//	@When("Get request is made to Get all capture service for store id {string} and walkId {string}")
//	public void getAllCapturesServiceUrl(String storeId) throws Throwable {
//		storewalkServicePage.getAllCapturesServiceUrl(storeId);
//	}


	@Then("Post request is made to Create capture service for store id {string}, product id {string}, location {string}, value {string}, sectionId {string} and capture type {string}")
	public void createCaptureForNegativePrompt(String storeId,String productID,String location,String value,String sectionId,String captureType) throws Throwable {
		storewalkServicePage.createCaptureForNegativePrompt(storeId,productID,location,value,sectionId,captureType);
	}


	@When("Delete request is made to Delete Count storewalk for store id {string}")
	public void deleteCountStorewalk(String storeId) throws Throwable {
		storewalkServicePage.deleteCountStorewalk(storeId);
	}
	
	@When("Delete request is made to Delete MarketStreet storewalk for store id {string}")
	public void deleteMarketStreetStorewalk(String storeId) throws Throwable {
		storewalkServicePage.deleteMarketStreetStorewalk(storeId);
	}


	@Given("request is made to capture access token and post endpoint for user v2 for {string}")
	public void requestIsMadeToCaptureAccessTokenAndPostEndpointForUserVFor(String sReqData) throws Throwable {
		storewalkServicePage.requestMadeToGoogle(sReqData);
	}
}
