package com.morrisons.sma.step_definitions.mobile.old;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.morrisons.common.action.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.appium.java_client.android.AndroidDriver;
import com.morrisons.sma.page_objects.mobile.old.GLHPageObject;
import com.morrisons.sma.page_objects.service.GlhBurstService;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;

public class GLHBurstStepDef {

	private static AndroidDriver driveR;
	ObjectMapper objectMapper = new ObjectMapper();
	public static HttpResponse Response;
	public static io.restassured.response.Response restResponse;
	public static String captureType;

	public static List<String> walkIds = new ArrayList<String>();

	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();

	static String accessTocken;
	String tokenaccess;
	String env = applicationConfig.getWebElementEnviroment().getEnv();
	static String walkId;

	public GLHBurstStepDef() {
		this.driveR = (AndroidDriver) Hook.getDriver();
	}
	
	GlhBurstService glhBurstService = new GlhBurstService();
	GLHPageObject glhImplementations = new GLHPageObject();
	
	@Given("Request is made to SMA Collegue Login services")
	public void requestWithServicesForColleguelogin() throws Throwable {
		glhBurstService.requestMadeToSMACollegueLogin();
	}

	@Given("Request is made to SMA Manager Login services")
	public void requestWithServicesForManagerlogin() throws Throwable {
		glhBurstService.requestMadeToSMAManagerLogin();
	}

	@Then("Service should return details for Login Service")
	public void serviceReturnDetailsForLoginServices() throws Throwable {
		glhBurstService.serviceShouldReturnSMALogin();
	}

	@Then("Get the generated Access Tocken")
	public void get_the_generated_accessTocken() throws Throwable {
		accessTocken = glhBurstService.getGeneratedAccessTokenForCR();
	}

	@Then("User performs operation")
	public void usrPerformsOperation() throws Throwable {
		Response = glhBurstService.performOperation();
	}

	@Then("Request is made to Get Storewalk services")
	public void requestMadeToStorewalkServices() throws Throwable {
		glhBurstService.getStoreWalkUrl();
	}
	@Then("Get Storewalk service response for store {string}")
	public void getStorewalkServiceDetails(String storeId) throws Throwable {
		walkIds = glhBurstService.getWalkIdServices(storeId);
		System.out.println("Walkid : "+ walkIds);
	}

	@Given("Request is made to Get Storewalk for store {string}")
	public void requestMadeToStorewalkStoreIdServices(String storeId) throws Throwable {
		 walkId = walkIds.get(0);
		glhBurstService.getStoreWalkStoreUrl(storeId,walkId);
	}
	@Then("Get Storewalk storeid service response")
	public void getStorewalkServiceStoreIdDetails() throws Throwable {
		glhBurstService.getWalkIdStoreServices();
	}

	@Then("Request is made to Get Storewalk for storeId {string} with Attributes")
	public void requestMadeToStorewalkStoreIdAttributesServices(String storeId) throws Throwable {
		 walkId = walkIds.get(0);
		 glhBurstService.getStoreWalkAttributesUrl(storeId,walkId);

	}

	@Then("Request is made to Get Storewalk for storeId {string} and Capture type {string}")
	public void requestMadeToStorewalkStoreIdAttributesServices(String storeId,String captureType) throws Throwable {
		glhBurstService.getCaptureTypeUrl(storeId,walkId,captureType);
	}

	@Given("Request is made to Get Storewalk for storeId {string}")
	public void requestMadeToSectionServices(String storeId) throws Throwable {
		glhBurstService.getSectionApiUrl(storeId,walkId);
	}

	@Given("Request is made to Get Section for storeId {string} and Capture type {string}")
	public void requestMadeToSectionAttributesServices(String storeId,String captureType) throws Throwable {
		glhBurstService.getSectionAttributesApiUrl(storeId,walkId,captureType);
	}

	@Then("Get Section service response")
	public void getSectionApiServiceResponse() throws Throwable {
		glhBurstService.getSectionServiceResponse();
	}

	@Then("I verify Section {string} is displayed in Warehouse screen")
	public void iVerifySectionIsDisplayedInWarehouseScreen(String type) throws Throwable {

		captureType = type;
		glhImplementations.verifySectionIsDisplayedInWarehouseScreen(captureType);
	}

	@Then("I verify Section {string} is not displayed in Warehouse screen")
	public void iVerifySectionIsNotDisplayedInWarehouseScreen(String type) throws Throwable {

		captureType = type;
		glhImplementations.verifySectionIsNotDisplayedInWarehouse(captureType);
	}

	@Then("I Click on Section {string}")
	public void iClickOnSection(String type) throws Throwable {
		captureType = type;
		glhImplementations.clickOnSection(captureType);
	}
	
	@Then("I Click on Group section in warehouse")
	public void clickOnGroupSection() throws Throwable {
		glhImplementations.clickOnGroupSection();
	}

	@Then("I Verify Empty product list is displayed")
	public void iVerifyEmptyProductListIsDisplayed() throws Throwable {
		glhImplementations.verifyEmptyProductListIsDisplayed();
	}

	@Then("I Verify Complete section button is displayed")
	public void completeSectionButtonIsDisplayed() throws Throwable {
		glhImplementations.verifyCompleteSectionButtonIsDisplayed();
	}

	@Then("I Click on View list in fixture location")
	public void iClickOnViewList() throws Throwable {
		glhImplementations.clickOnViewList();
	}


	@Then("I Delete products from fixture")
	public void iDeleteProductFromFixture() throws Throwable {
		glhImplementations.deleteProductFromFixture();
	}

	@Then("I Verify Gap and Low products are displayed in warehouse list")
	public void verifyGapAndLowProducts() throws Throwable {
		glhImplementations.verifyGapAndLowProducts();
	}

	@Then("I Verify Low products are displayed in warehouse list")
	public void verifyLowProductsAreDisplayed() throws Throwable {
		glhImplementations.verifyLowProductsAreDisplayed();
	}

	@Then("I Verify Gap products are displayed in warehouse list")
	public void verifyGapProductsAreDisplayed() throws Throwable {
		glhImplementations.verifyGapProductsAreDisplayed();
	}

	@Then("I verify storewalk response")
	public void verifyStorewalkResponse() throws Throwable {
		glhBurstService.verifyStorewalkResponse();
	}

	@Then("I verify storewalk response for capture type")
	public void verifyStorewalkResponseCaptureType() throws Throwable {
		glhBurstService.verifyStorewalkResponseCaptureType();
	}

	@Then("I verify section api response")
	public void verifySectionApiResponse() throws Throwable {
		glhBurstService.verifySectionResponse();
	}

	@Then("I verify section api response for capture type")
	public void verifySectionApiResponseCaptureType() throws Throwable {
		glhBurstService.verifySectionResponseCaptureType();
	}

	@Given("Request is made to delete Glh walkid for store id {string}")
	public void and_walkid_of_particular_count(String storeId) throws Throwable {

		glhBurstService.deleteCount(storeId,walkIds);


	}

	//	@When("Request is made to Delete the service")
	//	public void request_is_made_to_Delete_service() throws Throwable {
	//		Response = glhBurstService.deleteOperationCounts();
	//		Thread.sleep(1000);
	//		}
	//
	//	@Then("I Delete the count walkid")
	//	public void i_Delete_count() throws Throwable {
	//		System.out.println(Response);
	//
	//	}


	@Then("I verify Product is present in list")
	public void verifyProductInWarehouse() throws Throwable {

		glhImplementations.verifyProductInWarehouse();
	}
	
	@Then("I verify Product capture type as LOW in warehouse")
	public void lowIsDisplayedInWarehouse() throws Throwable {

		glhImplementations.lowIsDisplayedInWarehouse();
	}
	
	@Then("I verify Product capture type as GAP in warehouse")
	public void gapIsDisplayedInWarehouse() throws Throwable {

		glhImplementations.gapIsDisplayedInWarehouse();
	}
	
	@Then("I verify Product capture type as GAP and LOW in warehouse")
	public void gaplowIsDisplayedInWarehouse() throws Throwable {

		glhImplementations.gaplowIsDisplayedInWarehouse();
	}
	 

	@Then("I Click on Complete section button")
	public void ClickOnCompleteSectionButton() throws Throwable {
		glhImplementations.ClickOnCompleteSectionButton();
	}
	
	@Then("I Verify Confirm counts popup is displayed for Category name {string}")
	public void verifyConfirmCountPopup(String categoryName) throws Throwable {
		glhImplementations.verifyConfirmCountPopup(categoryName);
	}
	
	@Then("I Click on Confirm button on popup")
	public void clickOnConfirmButton() throws Throwable {
		glhImplementations.clickOnConfirmButton();
	}
	
	@Then("I Verify status as Completed")
	public void verifyCompletedStatus() throws Throwable {
		glhImplementations.verifyCompletedStatus();
	}
	
	@Then("I Verify Section count as 0 of 0")
	public void verifySectionCount() throws Throwable {
		glhImplementations.verifySectionCount();
	}
	
	@Then("I Delete Gap and Low products from fixture")
	public void iDeleteGapAndLowProductFromFixture() throws Throwable {
		glhImplementations.iDeleteGapAndLowProductFromFixture();
	}
	
	@Then("I Click on group section and Verify Empty product list and Complete section button is displayed")
	public void clickOnGroupAndVerifyIsEmpty() throws Throwable {
		glhImplementations.clickOnGroupAndVerifyIsEmpty();
	}
	
	@Then("I Click on on Review Approval tab")
	public void clickOnReviewApproval() throws Throwable {
		glhImplementations.clickOnReviewApproval();
	}

	@Then("I Verify product is present for Manager approval")
	public void verifyProductInApproval() throws Throwable {
		glhImplementations.verifyProductInApproval();
	}

	@Then("I Click on group section")
	public void iClickOnGroupSection() throws InterruptedException {
		glhImplementations.clickOnGroup();
	}
}
