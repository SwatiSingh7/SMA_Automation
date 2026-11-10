package com.morrisons.sma.step_definitions.mobile.old;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.morrisons.common.action.Hook;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import com.morrisons.sma.page_objects.mobile.old.SalesOrderPO;
import com.morrisons.sma.page_objects.service.SalesOrderServices;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpResponse;

import java.util.ArrayList;
import java.util.List;

public class SalesOrderStepDef {

	
	ObjectMapper objectMapper = new ObjectMapper();
	public static HttpResponse Response;
	public static io.restassured.response.Response restResponse;
	public List<String> DatefromApp = new ArrayList<>();
	public static String weekDate;
	public static String weekStatus;
	
	public static String categoryId = null;

	private static AndroidDriver driveR;

	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();

	SalesOrderServices salesOrderServices = new SalesOrderServices();
	SalesOrderPO salesOrderPageObject = new SalesOrderPO();
	
	public SalesOrderStepDef() {
		this.driveR = (AndroidDriver) Hook.getDriver();
	}

	static String accessTocken;
	String accessTockenGLH;
	String markdownBarcodeTest;
	String complete;
	String tokenaccess;
	String env = applicationConfig.getWebElementEnviroment().getEnv();

	
	@Given("Request is made to SMA SO Collegue Login services")
	public void requestToSMACollegueLoginServices() throws Throwable {
		salesOrderServices.requestMadeToSMACollegueLogin();
	}

	@Given("Request is made to SMA SO Manager Login services")
	public void requestToSMAManagerLoginServices() throws Throwable {
		salesOrderServices.requestMadeToSMAManagerLogin();
	}

	@Given("Service should return details for Login Service for SMA app")
	public void serviceReturnDetailsForLoginService() throws Throwable {
		salesOrderServices.serviceShouldReturnSMALogin();
	}

	@Then("I Get the generated accessTocken for sales order")
	public void getGeneratedAccessToken() throws Throwable {
		accessTocken = salesOrderServices.getGeneratedAccessTokenSO();
	}
	
	@Then("User performs operation on SO service")
	public void userPerformsOperation() throws Throwable {
		Response = salesOrderServices.performOperation();
	}

//////////////////// Get master category details services
	
	@Given("Request is made to get Category departments service is called for location id {string}")
	public void getCategoryDepartmentService(String storeID) throws Throwable {
		salesOrderServices.getCategoryDepartmentSalesOrder(storeID);
	}

	@Then("Service should return response for Get Category departments services")
	public void serviceShouldReturnResponseCateoryDepartments() throws Throwable {
		salesOrderServices.getCategoryDepartmentServices();
	}
	
	@Then("Get category id for the {string} department")
	public void getCategoryID(String deptName) throws Throwable {
		
		categoryId = salesOrderServices.categoriesNameAndId.get(deptName);
		System.out.println("Category id for the department "+deptName+ " is : " +categoryId);
	}
	
	
	
	@And("I Verfiy Categories displayed on UI app and Services matched")
	public void verifyCategoriesOnUIAndServices() throws Throwable {
		salesOrderServices.verifyCategoriesOnUIAndServices();
	}
	
	@And("I Verfiy Product count on UI app and Services matched")
	public void verifyProductCountOnUIAndServices() throws Throwable {
		salesOrderServices.verifyProductCountOnUIAndServices();
	}
	
////////////////// Get forecast order services
	
	@Given("Request is made to Forecast Order service for store id {string}")
	public void requestWithForecastOrderServices(String storeId) throws Throwable {
		salesOrderServices.getForecastOrderSalesOrder(storeId , categoryId, accessTocken);
	}
	
	@Given("Get forecast order service for store id {string} and get Total product count for all categories")
	public void requestWithSalesOrderServices(String storeId) throws Throwable {
		salesOrderServices.getCategoriesProductList(storeId);
	}

	@When("I verify for categories total product count on UI matches with Services")
	public void verifytotalProductCount() throws Throwable {
		salesOrderServices.verifyTotalProductsCountOnUIAndServices();
	}
	
	@When("I Get Forecast orders response from service for store id {string}")
	public void getForecastOrdersFromService(String storeId) throws Throwable {
		salesOrderServices.getForecastOrderResponse(storeId,categoryId);
	}
	
	@When("I Get Amended orders from service")
	public void getAmendOrdersFromService() throws Throwable {
		salesOrderServices.getAmendOrdersFromService();
	}
	
////////////////////////  Get item details services
	
	@When("Request is made to Get Order Item details services for item {string}")
	public void getSalesOrderItemDetails(String storeId) throws Throwable {
		salesOrderServices.getItemDetailsService(storeId,categoryId, accessTocken);
	}
	
	@Given("Request is made to Item details for store id {string} and category id {string} and item {string} services")
	public void requestWithSalesOrderServices(String storeId, String categoryId, String item) throws Throwable {
		salesOrderServices.getSalesOrderItemDetails(storeId , categoryId, item, accessTocken);
	}
	
	@When("Get Item details Response from services")
	public void getItemDetailsServices() throws Throwable {
		salesOrderServices.getItemDetailsServices();
	}
	
	/////////////////////// Get Amend order
	
	@When("Request is made to Get Amend orders for store id {string} and category id {string}")
	public void getAmendOrder(String storeId, String categoryId) throws Throwable {
		salesOrderServices.getAmendOrder(storeId, categoryId,accessTocken);
	}
	
	@When("Request is made to Get Amend orders for store id {string} and dept name {string}")
	public void getAmendOrderss(String storeId,String deptName) throws Throwable {
		String categoryId = salesOrderServices.categoriesNameAndId.get(deptName);
		System.out.println(categoryId);
		salesOrderServices.getAmendOrder(storeId, categoryId,accessTocken);
	}
	
	@When("Get Amend Order service response")
	public void getAmendOrderServiceResponse() throws Throwable {
		salesOrderServices.getAmendOrderServiceResponse();
	}
	
	@When("I Verify Previous link response from service")
	public void verifyPreviousLinkInService() throws Throwable {
		salesOrderServices.verifyPreviousLinkInService();
	}
	
	@When("I Verify Next link response from service")
	public void verifyNextLinkInService() throws Throwable {
		salesOrderServices.verifyNextLinkInService();
	}
	
	@When("I Verify Offset and Count attribute response from service")
	public void verifyCountAndOffsetValue() throws Throwable {
		salesOrderServices.verifyCountAndOffsetValue();
	}
	
//	@Then("I scroll down to get the latest schdule")
//	public void i_scroll_down_to_get_the_latest_schdule() throws Throwable {
//		Thread.sleep(2000);
//		TouchAction ts = new TouchAction(driveR);
//		ts.press(PointOption.point(350, 915)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
//				.moveTo(PointOption.point(300, 350)).release().perform();
//		Thread.sleep(1000);
//	}
	

	@When("I verify Amendable product week details displayed on UI matches with services")
	public void verifyAmendedWeekDetails() throws Throwable {
		salesOrderServices.verifyAmendedWeekDetails();
	}
	

	@When("I Get Product details on UI")
	public void iGetFirstTwentyProductsOnUI() throws Throwable {
		salesOrderPageObject.getProductsDetailOnUI();
	}
	
	@When("I Verify Product on UI and Service matches")
	public void verifyProductsOnUIAndServices() throws Throwable {
		salesOrderPageObject.verifyProductOnUIService();
	}
	
	@When("I Verify Amend Product on UI and Service matches")
	public void verifyAmendProductOnUIService() throws Throwable {
		salesOrderPageObject.verifyAmendProductOnUIService();
	}
	
	@When("I Verify Non Amend Product on UI and Service matches")
	public void verifyNonAmendProductOnUIService() throws Throwable {
		salesOrderPageObject.verifyNonAmendProductOnUIService();
	}
	
//	@Given("Request is made to SMA Collegue Login services")
//	public void requestToSMACollegueLoginServices() throws Throwable {
//		salesOrderServices.requestMadeToSMACollegueLogin();
//	}
//
//	@Given("Request is made to SMA Manager Login services")
//	public void requestToSMAManagerLoginServices() throws Throwable {
//		salesOrderServices.requestMadeToSMAManagerLogin();
//	}
//
//	@Given("Service should return details for Login Service for SMA")
//	public void serviceReturnDetailsForLoginService() throws Throwable {
//		salesOrderServices.serviceShouldReturnSMALogin();
//	}
//
//	@Then("Get the generated accessTocken for CR")
//	public void getGeneratedAccessToken() throws Throwable {
//		accessTocken = salesOrderServices.getGeneratedAccessTokenForCR();
//	}
//
//	@Given("Get Category departments service is called for location id {string}")
//	public void getCategoryDepartmentService(String storeID) throws Throwable {
//		System.out.println("AccessTocken-----------" + accessTocken);
//		salesOrderServices.getCategoryDepartmentSalesOrder(storeID,accessTocken);
//	}
//

//
//	@Then("Service should return response of Category departments services")
//	public void serviceShouldReturnResponseCateoryDepartments() throws Throwable {
//		salesOrderServices.getCategoryDepartmentServices();
//	}
	




	@Then("I Verify Sales Order menu is Displayed")
	public void verifySalesOrderMenuDisplayed() throws Throwable {
		salesOrderPageObject.verifySalesOrderMenuDisplayed();
	}
	
	@When("I Click on Marketstreet menu")
	public void iClickOnMarketstreetMenu() throws Throwable {
		salesOrderPageObject.clickOnMarketstreetMenu();
	}

	@When("I Click on Sales Order menu")
	public void iClickOnSalesOrderMenu() throws Throwable {
		salesOrderPageObject.clickOnSalesOrderMenu();
	}	

	@When("I Verify Departments under Sales order menu are displayed")
	public void iVerifySalesOrderDepartments() throws Throwable {
		salesOrderPageObject.verifySalesOrderDepartments();
	}

	@When("I Verify dropdown values - All orders, Amendable Orders and Non-amendable Orders are present")
	public void verifyDropdowns() throws Throwable {
		salesOrderPageObject.verifyDropdowns();
	}
	
	@When("I Get Sales Order Departments")
	public void getSalesOrderDepartments() throws Throwable {
		salesOrderPageObject.getSalesOrdersDepartments();
	}
	
	@Then("I Get Total Products count on UI")
	public void getTotalProductsCountOnUI() throws Throwable {
		salesOrderPageObject.getTotalProductsCountOnUI();
	}
	
	@Then("I click on departments and verify respective department page is displayed")
	public void verifyDepartmentPageIsDisplayed() throws Throwable {
		salesOrderPageObject.getTotalProductsCountOnUI();
	}
	
	@When("I Select a Department from department list")
	public void iSelectADepartment() throws Throwable {
		salesOrderPageObject.selectADepartment();
	}
	
	@When("I Select a Department {string} from department screen")
	public void selectADepartmentByName(String deptName) throws Throwable {
		salesOrderPageObject.selectADepartmentByName(deptName);
	}
	
	@When("I Select a Department with no products")
	public void selectCategoryWithNoProducts() throws Throwable {
		salesOrderPageObject.selectCategoryWithNoProducts();
	}
	
	@When("I Get category id for selected category department")
	public void iGetCategoryId() throws Throwable {
		salesOrderServices.iGetCategoryId();
	}
	
	@When("I Verify Product list is displayed")
	public void verifyProductListIsDisplayed() throws Throwable {
		salesOrderPageObject.verifyProductsScreenIsDisplayed();
	}
	
	@And("I Scroll till end of the page and verify page is loading completely")
	public void scrollTillEndAndVerifyPage() throws Throwable {
		salesOrderPageObject.verifyProductsScreenIsDisplayed();
	}
	

	@And("I get product description from product list on UI")
	public void getProductDescriptionUI() throws Throwable {
		salesOrderPageObject.getProductDescriptionUI();
	}
	
	@When("I Click on Dropdown list")
	public void iClickOnDropdownList() throws Throwable {
		salesOrderPageObject.clickOnDropdownList();
	}	
	
	@When("I Select a Amendable Orders Dropdown")
	public void iSelectAmendableOrdersDropdown() throws Throwable {
		salesOrderPageObject.selectAmendableOrdersDropdown();
	}
	
	@When("I Verify Amendable Orders Product list is displayed")
	public void verifyAmendableProductListIsDisplayed() throws Throwable {
		salesOrderPageObject.verifyProductsScreenIsDisplayed();
	}
	
	@When("I Select a Amendable order Product")
	public void selectAmendableProduct() throws Throwable {
		salesOrderPageObject.selectAmendableProduct();
	}
	
	@When("I Select a Amendable order Product by name")
	public void selectAmendableProductByName() throws Throwable {
		String productName = SalesOrderServices.amendOrderList.get(0);
		System.out.println(productName);
		salesOrderPageObject.selectAmendableProductByName(productName);
	}
	
	
	@When("I Get Amendable product details and week details on UI")
	public void getAmendableProductDetails() throws Throwable {
		salesOrderPageObject.getAmendableProductDetails();
	}
	
	@When("I Get product min value")
	public void getSelectedProductMin() throws Throwable {
		salesOrderPageObject.getSelectedProductMin();
	}
	
	@When("I verify Amemdable order product is clickable")
	public void verifyAmendableOrderIsClickable() throws Throwable {
		salesOrderPageObject.verifyProductInformation();
	}
	
	@When("I verify for Amendable products Amend text is displayed")
	public void verifyAmendText() throws Throwable {
		salesOrderPageObject.verifyAmendText();
	}
	
	@When("I Select a Non-Amendable Orders Dropdown")
	public void iSelectNonAmendableOrdersDropdown() throws Throwable {
		salesOrderPageObject.selectNonAmendableOrdersDropdown();
	}
	
	@When("I Verify Non-Amendable Orders Product list is displayed")
	public void verifyNonAmendableProductListIsDisplayed() throws Throwable {
		salesOrderPageObject.verifyProductsScreenIsDisplayed();
	}
	
	@When("I verify Non-Amemdable order product is not clickable")
	public void verifyNonAmendableOrderIsNotClickable() throws Throwable {
		salesOrderPageObject.verifyProductsScreenIsDisplayed();
	}
		
	@When("I Select a Week")
	public void iSelectWeek() throws Throwable {
		salesOrderPageObject.selectWeek();
	}
	
	@When("I verify a coming week day list is displayed")
	public void verifyAmendableWeekDay() throws Throwable {
		salesOrderPageObject.verifyAmendableWeekDay();
	}

	
	@When("I Select a amendable day")
	public void selectAmendableDay() throws Throwable {
		//salesOrderPageObject.selectAmendableDay();
	}
	
	@When("I Verify popup is displayed")
	public void verifyPopupIsDisplayed() throws Throwable {
		//salesOrderPageObject.verifyPopupIsDisplayed();
	}
	
	@When("I Get Orginal amend order")
	public void igetOriginalAmendOrder() throws Throwable {
		salesOrderPageObject.getOriginalAmendOrder();
	}
	
	@When("I Select amend order value from popup")
	public void iSelectAmendOrder()throws Throwable {
		salesOrderPageObject.selectAmendOrder();
	}
	

	@When("I Click on confirm button")
	public void iClickOnConfirmButton()throws Throwable {
		salesOrderPageObject.clickOnConfirmButton();
	}
	
	@When("I Verify Order amendable message")
	public void iVerifyOrderAmendsMessage() throws Throwable {
		salesOrderPageObject.verifyOrderAmendsMessage();
	}
	
	@And("I click on the Back Button")
	public void i_click_on_Back_Button()throws InterruptedException {
		salesOrderPageObject.clickBackButton();
	}
	
	@When("I Select the All Orders Dropdown")
	public void selectAllOrdersDropdown() throws Throwable {
		salesOrderPageObject.selectAllProductsDropdown();
	}
	
	@When("I verify the Order list is displayed with both Amendable and Non Amendable products")
	public void iVerifyAllOrderProductList() throws Throwable {
		//salesOrderPageObject.iVerifyAllOrderProductListt();
	}
//	
//	@When("I Select a Department {string} which has no products")
//	public void selectDeptWithNoProducts() throws Throwable {
//		salesOrderPageObject.selectDeptWithNoProducts();
//	}
//	
	@When("I verify Empty order lists is displayed")
	public void verifyEmptyOrderListDisplayed() throws Throwable {
		salesOrderPageObject.verifyEmptyOrderListDisplayed();
	}
	
	@When("I verify product information screen is displayed")
	public void verifyProductInformation() throws Throwable {
		salesOrderPageObject.verifyProductInformation();
	}
	
	@When("I verify product information screen is not displayed")
	public void verifyProductInformationNotDisplayed() throws Throwable {
		salesOrderPageObject.verifyProductInfoNotDisplayed();
	}
	
	@When("I verify Amendable day Today + 4 is clickable")
	public void verifyNextFourthDayIsClickable() throws Throwable {
	//	salesOrderPageObject.verifyNextFourthDayIsClickable();
	}
	
	@When("I verify Amendable day Today + 5 is clickable")
	public void verifyNextFifthDayIsClickable() throws Throwable {
		//salesOrderPageObject.verifyNextFifthDayIsClickable();
	}
	
	@When("I verify Amendable day Today + 6 is clickable")
	public void verifyNextSixthDayIsClickable() throws Throwable {
		//salesOrderPageObject.verifyNextSixthDayIsClickable();
	}
	
	@When("I verify Amendable day Today + 7 is clickable")
	public void verifyNextSeventhDayIsClickable() throws Throwable {
		//salesOrderPageObject.verifyNextSeventhDayIsClickable();
	}
//	
//	@When("I verify amendable days are correctly displayed when all 4 days Today+4, Today+5, Today+6, Today+7 are amendable")
//	public void verifyAmendableDaysCorrectlyDisplayed() throws Throwable {
//		salesOrderPageObject.verifyAmendableDaysCorrectlyDisplayed();
//	}
//	
	@When("I verify Search icon is displayed")
	public void verifySearchIconIsDisplayed() throws Throwable {
		salesOrderPageObject.verifySearchIconIsDisplayed();
	}
	
	@When("I click on Search icon")
	public void clickOnSearchIcon() throws Throwable {
		salesOrderPageObject.clickOnSearchIcon();
	}
	
	@When("I verify product search screen is displayed")
	public void verifyProductSearchScreen() throws Throwable {
		salesOrderPageObject.verifyProductSearchScreen();
	}
	
	@When("I enter product id {string} in search box")
	public void enterProductId(String productId) throws Throwable {
		salesOrderPageObject.enterProductId(productId);
	}
	
	@When("I enter product name {string} in search box")
	public void enterProductName(String productName) throws Throwable {
		salesOrderPageObject.enterProductName(productName);
	}
	
	@When("I verify search result")
	public void verifySearchResult() throws Throwable {
		salesOrderPageObject.verifySearchResult();
	}
	
	@When("I verify product count is displayed")
	public void verifyProductCount() throws Throwable {
		salesOrderPageObject.verifyProductCount();
	}
	

	
	@When("I select the department and get total product count")
	public void getTotalProductCount() throws Throwable {
		salesOrderPageObject.getTotalProductCountForCategories();
	}
	
	@When("Verify that the order list is sorted in ascending order of department id")
	public void verifyDeptIdAscendingOrder() throws Throwable {
		salesOrderPageObject.verifyDeptIdAscendingOrder();
	}
	
}
