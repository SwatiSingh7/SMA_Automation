package com.morrisons.sma.step_definitions.mobile.old;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.morrisons.common.action.Hook;
import com.morrisons.common.helper.FileHelper;
import com.morrisons.sma.page_objects.mobile.old.AWS_S3Upload;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.appium.java_client.android.AndroidDriver;
import com.morrisons.sma.page_objects.mobile.old.GlhNegativePromptPO;
import com.morrisons.sma.page_objects.service.GlhNegativePromptServicePO;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import org.apache.http.HttpResponse;

public class GlhNegativePromptStepDef {
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

	public GlhNegativePromptStepDef() {
		this.driveR = (AndroidDriver) Hook.getDriver();
	}
	
	GlhNegativePromptServicePO glhNegativePromptServicePO = new GlhNegativePromptServicePO();
	GlhNegativePromptPO glhNegativePromptPageObject = new GlhNegativePromptPO();
	
	
	@Given("Request is made to Sma GLh Collegue Login services")
	public void requestWithServicesForColleguelogin() throws Throwable {
		glhNegativePromptServicePO.requestMadeToSMAGLHCollegueLogin();
	}
	
	@Given("Request is made to Sma GLh Manager Login services")
	public void requestWithServicesForManagerlogin() throws Throwable {
		glhNegativePromptServicePO.requestMadeToSMAGLHManagerLogin();
	}
	
	@Then("Service should return details for Sma Glh Login Service")
	public void serviceReturnDetailsForLoginServices() throws Throwable {
		glhNegativePromptServicePO.serviceShouldReturnSMAGlhLogin();
	}
	
	@Then("Get the generated Access Tocken for login")
	public void get_the_generated_accessTocken() throws Throwable {
		accessTocken = glhNegativePromptServicePO.getGeneratedAccessTokenForGLH();
	}

	@Then("User performs operation for Service")
	public void usrPerformsOperation() throws Throwable {
		Response = glhNegativePromptServicePO.performOperation();
	}
	
	@Then("User performs operation for Storewalk Service")
	public void usrPerformsStorewalkOperation() throws Throwable {
		Response = glhNegativePromptServicePO.postOperationStorewalkService();
	}

	@Given("Request is made to post Create Storewalk services for store {string} and Type {string}")
	public void getScheduleForCreateStorewalk(String storeId,String type) throws Throwable {
		glhNegativePromptServicePO.postCreateStorewalkService(storeId,type,accessTocken);
	}

	@Then("Get Create Storewalk service response")
	public void getCreateStorewalkServicesStatus() throws Throwable {
		glhNegativePromptServicePO.getCreateStorewalkServicesStatus();
	}
	
	@Given("Request is made to post Create Storewalk item services for store {string} and Products {string}")
	public void getScheduleForCreateWalkId(String storeId,String products) throws Throwable {
		glhNegativePromptServicePO.postCreateStorewalkItemService(storeId,products,accessTocken);
	}
	
	


	@Then("Get Create Storewalk item service response")
	public void getCreateWalItemServicesStatus() throws Throwable {
		glhNegativePromptServicePO.getCreateWalItemServicesStatus();
	}

	@Then("I Verify API response is 201")
	public void verifyApiResponse() throws Throwable {
		glhNegativePromptServicePO.verifyStorewalkItemAPIRepsonse();
	}
	@Then("I verify products list is not displayed in fixture location")
	public void verifyProductListIsNotDisplayed() throws Throwable {
		glhNegativePromptPageObject.verifyProductListIsNotDisplayed();
	}
	
	@Then("I verify Prompted Negative products are displayed in Offshelf location")
	public void verifyNegativePromptListOffshelf() throws Throwable {
		glhNegativePromptPageObject.verifyNegativePromptListOffshelf();
	}
	
	@Then("I verify products are displayed in Warehouse location")
	public void verifyNegativePromptListWarehouse() throws Throwable {
		glhNegativePromptPageObject.verifyNegativePromptListWarehouse();
	}
	
	@Then("I verify products are displayed in Petrol location")
	public void verifyNegativePromptListPetrol() throws Throwable {
		glhNegativePromptPageObject.verifyNegativePromptListPetrol();
	}
	
	@Then("I get Category name from Petrol location")
	public void getCategoriesFromPetrol() throws Throwable {
		glhNegativePromptPageObject.getCategoriesFromPetrol();
	}
	
	@Then("I get Category name from Offshelf location")
	public void getCategoriesFromOffshelf() throws Throwable {
		glhNegativePromptPageObject.getCategoriesFromOffshelf();
	}
	
	@Then("I get Category name and Min values from Offshelf location")
	public void getOffshelfCategoryAndMin() throws Throwable {
		glhNegativePromptPageObject.getOffshelfCategoryAndMin();
	}
	
	@Then("I get Department name from Warehouse location")
	public void getDepartmentsFromWarehouse() throws Throwable {
		glhNegativePromptPageObject.getDepartmentsFromWarehouse();
	}
	
	@Then("I verify Warehouse Group dept and section on UI and service matches")
	public void verifyWarehouseGrpAndSection() throws Throwable {
		glhNegativePromptPageObject.verifyWarehouseGrpAndSection();
	}
	
	@Then("I select Category and complete Petrol location")
	public void completePetrolLocation() throws Throwable {
		glhNegativePromptPageObject.completePetrolLocation();
	}
	
	@Then("I select Category and complete Offshelf location")
	public void completeOffshelfLocation() throws Throwable {
		glhNegativePromptPageObject.completeOffshelfLocation();
	}
	
	@Then("I select Department and complete Warehouse location")
	public void verifyProductListIsDisplayed() throws Throwable {
		glhNegativePromptPageObject.verifyProductListIsDisplayed();
	}
	
	@Then("I verify department section status is Offshelf pending")
	public void verifyOffshelfPendingStatus() throws Throwable {
		glhNegativePromptPageObject.verifyOffshelfPendingStatus();
	}
	
	@Then("I Enter barcode number in fixture scan")
	public void enterBarcodeNumber() throws Throwable {
		glhNegativePromptPageObject.enterBarcodeNumber();
	}
	
	
	@Then("I Select the category in offshelf")
	public void selectCategoryInOffshelf() throws Throwable {
		glhNegativePromptPageObject.selectCategoryInOffshelf();
	}
	
	
	@Then("I Select the section in warehouse")
	public void selectCategoryInWarehouse() throws Throwable {
		glhNegativePromptPageObject.selectCategoryInWarehouse();
	}
	
	@Then("I Select the Group section in warehouse")
	public void clickOnGroup() throws Throwable {
		glhNegativePromptPageObject.clickOnGroupName();
	}
	
	@Then("I Select the section in warehouse and verify empty list")
	public void sectionWithEmptyList() throws Throwable {
		glhNegativePromptPageObject.sectionWithEmptyList();
	}
	
	@Then("I verify Scan product in fixture is removed from offshelf location")
	public void verifyMinIsRemovedInOffshelf() throws Throwable {
		glhNegativePromptPageObject.verifyMinIsRemovedInOffshelf();
	}
	
	@Then("Verify Error message in Create walkitem service response")
	public void verufyErrorMessage() throws Throwable {
		glhNegativePromptPageObject.selectCategoryInOffshelf();
	}
	
	@Then("I select section in offshelf location")
	public void selectSectionInOffshelf() throws Throwable {
		glhNegativePromptPageObject.selectSectionInOffshelf();
	}
	
	@Then("I enter quantity as {string} in offshelf location")
	public void addQuantityInOffshelf(String quantity) throws Throwable {
		glhNegativePromptPageObject.addQuantityInOffshelf(quantity);
	}
	
	@Then("I verify {string} quantity set for prompted negative counts at offshelf location")
	public void verifyZeroQuantity(String quantity) throws Throwable {
		glhNegativePromptPageObject.verifyZeroQuantity(quantity);
	}
	
	@Then("I left swipe the product description")
	public void leftSwipeTheDescription() throws Throwable {
		glhNegativePromptPageObject.leftSwipeTheDescription();
	}
	
	@Then("I verify product is not able to delete from Offshelf Location")
	public void verifyProductIsNotDeleted() throws Throwable {
		glhNegativePromptPageObject.verifyProductIsNotDeleted();
	}
	
	@Then("I Complete the section")
	public void completeTheSection() throws Throwable {
		glhNegativePromptPageObject.completeTheSection();
	}
	
	@Then("I Complete the warehouse section")
	public void completedWarehouse() throws Throwable {
		glhNegativePromptPageObject.completedWarehouse();
	}
	
	@Then("I verify status as Completed")
	public void verifySectionIscompleted() throws Throwable {
		glhNegativePromptPageObject.verifySectionIscompleted();
	}
	
	@Then("I verify Product captured through Api is displayed on UI in Counter & Fixture location")
	public void verifyOrangeLabel() throws Throwable {
		glhNegativePromptPageObject.verifyProductAtCounter();
	}
	
	@Then("I verify Category is displayed at Other location")
	public void verifyProductAtOther() throws Throwable {
		glhNegativePromptPageObject.verifyProductIsPresent();
	}
	
	@Then("I verify Category is displayed at Backup location")
	public void verifyProductAtBackup() throws Throwable {
		glhNegativePromptPageObject.verifyProductIsPresent();
	}
	@Then("I verify Category is displayed at Review location")
	public void verifyProductAtreview() throws Throwable {
		glhNegativePromptPageObject.verifyProductIsPresent();
	}

    @Given("I create SOH for the Negative Prompt {string} {string} {string} {string}")
    public void iCreateSOHForTheNegativePrompt(String bucketName, String keyName, String filePath, String fileName) throws IOException {
		String sCurrentDate1;
		if(fileName.contains("getRunTime")){
			FileHelper fFileUpdate = new FileHelper();
			sCurrentDate1 = fFileUpdate.readAndUpdateDATFileNegativePrompt(fileName);
		}
		else {
			sCurrentDate1 = fileName;
		}
		AWS_S3Upload oAWSObj = new AWS_S3Upload();
		oAWSObj.S3UploaderNP(bucketName, keyName, filePath, sCurrentDate1);
    }
}
