package com.morrisons.sma.page_objects.mobile.old;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.common.base.CharMatcher;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import com.morrisons.sma.page_objects.service.SalesOrderServices;
import com.morrisons.common.action.Hook;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import java.time.Duration;
import static org.testng.Assert.assertEquals;

public class SalesOrderPO {

	private static AndroidDriver driveR;

	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
	String env = applicationConfig.getWebElementEnviroment().getEnv();

	String colleagueUsername = applicationConfig.getUserCredentials().getCollegueUsername();
	String colleaguePassword = applicationConfig.getUserCredentials().getColleguePassword();
	String managerUsername = applicationConfig.getUserCredentials().getManagerUsername();
	String managerPassword = applicationConfig.getUserCredentials().getManagerPassword();

	public static List<String> departmentNameUI = new ArrayList<String>();

	private static String orginalOrder = null;
	private static String requestedOrder = null;

	public static List<String> categoriesName = new ArrayList<String>();;
	public static List<String> totalProductsCount = new ArrayList<String>();;

	public static HashMap<String,String> categoriesDetails = new HashMap<String, String>();;

	public static String selectedCategoryName = null;
	public static String selectedProductMin = null;

	static HashMap<String, String> categoryNameAndProductCount = new HashMap<String, String>();

	public static String selectedCategoryId = null;

	public static List<String> firstTwentyProducts = new ArrayList<String>();
	public static List<String> nextTwentyProducts = new ArrayList<String>();

	public static List<String> lastWeekOriginalQtyUI = new ArrayList<String>();
	public static List<String> upcomingOriginalQtyUI = new ArrayList<String>();
	public static String todaysQtyUI = null;
	public static String productMinUI = null;
	public static String productDescriptionUI = null;

	public static List<String> productDescriptionList = new ArrayList<String>();

	public SalesOrderPO() {
		this.driveR = (AndroidDriver) Hook.getDriver();
	}

	public void verifySalesOrderMenuDisplayed()throws InterruptedException {

		String xpathSalesOrderMenu = "//android.widget.TextView[@text='Sales Orders']";

		driveR.findElement(By.xpath(xpathSalesOrderMenu)).isDisplayed();

		String menuName = driveR.findElement(By.xpath(xpathSalesOrderMenu)).getText();

		assertEquals(menuName, "Sales Orders","Sales Order menu title is mismatched");
	}

	public void clickOnMarketstreetMenu() throws InterruptedException {

		WebElement xpathMarketSteetMenu = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/market_street']"));

		xpathMarketSteetMenu.isDisplayed();
		xpathMarketSteetMenu.click();
		Thread.sleep(3000);

	}

	public void clickOnSalesOrderMenu() throws InterruptedException {

		WebElement xpathSalesOrderMenu = driveR.findElement(By.xpath("//android.widget.TextView[@text='Sales Orders']"));

		xpathSalesOrderMenu.isDisplayed();
		xpathSalesOrderMenu.click();
		Thread.sleep(3000);

	}

	public void selectADepartment() throws InterruptedException {
		WebElement xpathSelectDepartment = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/txtDepartment']"));

		xpathSelectDepartment.isDisplayed();

		selectedCategoryName = xpathSelectDepartment.getText();
		Thread.sleep(3000);

		xpathSelectDepartment.click();
		Thread.sleep(3000);
	}

	public static void selectADepartmentByName(String deptName) throws InterruptedException {

		Thread.sleep(3000);
		WebElement xpathSelectDepartment = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+deptName+"']"));

		xpathSelectDepartment.isDisplayed();

		selectedCategoryName = xpathSelectDepartment.getText();
		Thread.sleep(3000);

		xpathSelectDepartment.click();
		Thread.sleep(3000);
	}


	public void verifySalesOrderDepartments()throws InterruptedException {
		String xpathSelectDepartment = "//android.widget.TextView[@resource-id='" + env + ":id/txt_action']";

		driveR.findElement(By.xpath(xpathSelectDepartment)).isDisplayed();

		String selectDepartment = driveR.findElement(By.xpath(xpathSelectDepartment)).getText();

		assertEquals(selectDepartment, "Select a department","Select a department text is mismatched");


		WebElement xpathDepartmentsList  = driveR.findElement(MobileBy.id("" + env + ":id/txtDepartment"));

		xpathDepartmentsList.isDisplayed();
	}

	public void getTotalProductsCountOnUI()throws InterruptedException {

		List<WebElement> xpathCategories = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/txtDepartment']"));
		for(WebElement category : xpathCategories)
		{

			String categoryName = category.getText();
			System.out.println("Category name on UI : " + categoryName);
			categoriesName.add(categoryName);

			
			category.click();

			WebElement xpathTotalProductsCount = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/txt_action']"));
			xpathTotalProductsCount.isDisplayed();

			String countText = xpathTotalProductsCount.getText().replaceAll("[^\\d]", " ").trim(); 
			System.out.println(categoryName + " Category product count on UI : " + countText);
			
			totalProductsCount.add(countText);
			
			categoriesDetails.put(categoryName, countText);

			clickBackButton();
			Thread.sleep(3000);
		}
	}

	public void getSalesOrdersDepartments()throws InterruptedException {

		List<AndroidElement> xpathDepartmentsList  = null;
		xpathDepartmentsList= driveR.findElements(MobileBy.id("" + env + ":id/txtDepartment"));

		for (AndroidElement xpathDepartment : xpathDepartmentsList) {
			departmentNameUI.add(xpathDepartment.getText());
		}

		Thread.sleep(2000);
		TouchAction ts = new TouchAction(driveR);
		ts.press(PointOption.point(450, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(300, 350)).release().perform();
		Thread.sleep(1000);

		List<AndroidElement> xpathDepartmentsListt  = null;
		xpathDepartmentsListt= driveR.findElements(MobileBy.id("" + env + ":id/txtDepartment"));

		for (AndroidElement xpathDepartment : xpathDepartmentsListt) {
			departmentNameUI.add(xpathDepartment.getText());
		}

		int departmentsCount = departmentNameUI.size();

	}


	public void verifyProductsScreenIsDisplayed() throws InterruptedException {
		List<WebElement> xpathProductsList = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/product_name']"));

		boolean productList = xpathProductsList.isEmpty();

		assertEquals(productList, false,"Products list is not displayed");
	}

	public void clickOnDropdownList() throws InterruptedException {

		WebElement xpathDropdown = driveR.findElement(By.xpath("//android.widget.Spinner[@resource-id='" + env + ":id/orders_spinner']"));

		xpathDropdown.isDisplayed();

		xpathDropdown.click();
		Thread.sleep(3000);
	}

	public void selectAmendableOrdersDropdown() throws InterruptedException {
		WebElement xpathAmendableOrdersDropdown = driveR.findElement(By.xpath("//android.widget.CheckedTextView[@text='Amendable Orders']"));

		xpathAmendableOrdersDropdown.isDisplayed();

		xpathAmendableOrdersDropdown.click();
		Thread.sleep(3000);
	}

	public void selectNonAmendableOrdersDropdown() throws InterruptedException {
		WebElement xpathNonAmendableOrdersDropdown = driveR.findElement(By.xpath("//android.widget.CheckedTextView[@text='Non Amendable Orders']"));

		xpathNonAmendableOrdersDropdown.isDisplayed();

		xpathNonAmendableOrdersDropdown.click();
		Thread.sleep(3000);
	}

	public void selectAllProductsDropdown() throws InterruptedException {
		WebElement xpathAllProductsDropdown = driveR.findElement(By.xpath("//android.widget.CheckedTextView[@text='All Orders']"));

		xpathAllProductsDropdown.isDisplayed();

		xpathAllProductsDropdown.click();
		Thread.sleep(3000);
	}

	public void getSelectedProductMin() throws InterruptedException {
		WebElement xpathProduct = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/value']"));

		xpathProduct.isDisplayed();

		selectedProductMin = xpathProduct.getText();
		Thread.sleep(3000);
	}

	public void selectProduct(String product)throws InterruptedException {
		List<WebElement> xpathProductsList = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/product_name']"));

		int i = 0;
		while(i<=10)
		{

			WebElement xpathProduct = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/product_name']"));

			String productName =  xpathProduct.getText();
			if(!productName.equals(product))
			{
				TouchAction ts = new TouchAction(driveR);
				ts.press(PointOption.point(350, 715)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
				.moveTo(PointOption.point(300, 350)).release().perform();
				Thread.sleep(1000);
			}
			else{
				Thread.sleep(1000);
				xpathProduct.click();
				break;
			}
		}
	}

	public void selectWeek() throws InterruptedException {
		WebElement xpathProductsList = driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/ll_upcoming_orders']//android.widget.LinearLayout[@index='6']"));

		xpathProductsList.isDisplayed();
		xpathProductsList.click();
	}

	public void getOriginalAmendOrder() throws InterruptedException {
		List<WebElement> xpathAmendOrderList = driveR.findElements(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1']"));

		for(WebElement amendOrder : xpathAmendOrderList)
		{
			String l = amendOrder.getText();
			if(l.contains("(Original Order)"))
			{
				orginalOrder = amendOrder.getText().replaceAll("\\D+", "");
			}
		}	
		System.out.println("Original order : " + orginalOrder);
	}

	public void selectAmendOrder() throws InterruptedException {
		WebElement xpathAmendOrder = driveR.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @index='0']"));
		requestedOrder = xpathAmendOrder.getText();

		xpathAmendOrder.isDisplayed();
		xpathAmendOrder.click();

		System.out.println("Requested order : " + requestedOrder);
	}

	public void clickOnConfirmButton() throws InterruptedException {
		WebElement xpathConfirmButton = driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']"));

		xpathConfirmButton.isDisplayed();
		xpathConfirmButton.click();
	}

	public void verifyOrderAmendsMessage() throws InterruptedException {
		TouchAction ts = new TouchAction(driveR);
		ts.press(PointOption.point(350, 715)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(300, 350)).release().perform();
		Thread.sleep(1000);
		List<WebElement> xpathAmendOrderList = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tv_description']"));

		String status =  xpathAmendOrderList.get(xpathAmendOrderList.size()-1).getText();	


		String str = status;
		String substr = " | ";
		String s1 = str.substring(0, str.indexOf(substr)).replaceAll("\\D+", "");
		String s2 = str.substring(str.indexOf(substr) + substr.length()).replaceAll("\\D+", "");

		assertEquals(s1, orginalOrder,"Orginal order count is mismatched");
		assertEquals(s2, requestedOrder,"Requested order count is mismatched");
	}

	public void verifyAmendLabel() throws InterruptedException {
		WebElement xpathAmendLabel = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tv_amend_status']"));

		xpathAmendLabel.isDisplayed();

		String amendLabel = xpathAmendLabel.getText();

		assertEquals(amendLabel, "","Amend label is not displayed");
	}

	public void getProductsName() throws InterruptedException {	

		int i = 0;

		while(i<10)
		{
			TouchAction ts = new TouchAction(driveR);
			ts.press(PointOption.point(350, 715)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
			.moveTo(PointOption.point(300, 350)).release().perform();
			Thread.sleep(1000);

			List<WebElement> productList = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/product_name']"));

			for(WebElement product : productList){

				String productName = product.getText();
			}
		}
	}

	public void clickBackButton() throws InterruptedException {
		Thread.sleep(3000);
		driveR.findElement(By.className("android.widget.ImageButton")).click();
		Thread.sleep(3000);
	}

	public void getTotalProductCountForCategories() throws InterruptedException {

		Thread.sleep(3000);
		List<WebElement> categoriesList = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/txtDepartment']"));

		for(WebElement category : categoriesList){

			String categoryName = category.getText();

			Thread.sleep(3000);
			category.click();

			String productCount = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/txt_action']")).getText();

			categoryNameAndProductCount.put(categoryName, productCount);

			Thread.sleep(3000);

			clickBackButton();

		}
	}

	public void verifyDropdowns() throws InterruptedException {
		Thread.sleep(3000);

		String[] dropdownNameList = {"All Orders","Amendable Orders","Non Amendable Orders"};

		List<WebElement> dropdownList = driveR.findElements(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1']"));

		for(int i=0;i<=dropdownList.size()-1;i++)
		{
			WebElement xpathDropdown = driveR.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @index = '"+i+"']"));
			String drodownName = xpathDropdown.getText();

			assertEquals(drodownName, dropdownNameList[i],"Dropdown is not present");
		}
	}

	public void verifyAmendableOrderIsClickable() throws InterruptedException {
		Thread.sleep(3000);

		WebElement xpathAmendableProduct = driveR.findElement(By.xpath("//android.widget.RelativeLayout[@index='0']"));

		String isClickable = xpathAmendableProduct.getAttribute("clickable");

		assertEquals(isClickable, true,"Amendable orders are not clickable");
		Thread.sleep(3000);
	}

	public void selectAmendableProduct() throws InterruptedException {
		Thread.sleep(3000);

		WebElement xpathAmendableProduct = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/product_name']"));

		xpathAmendableProduct.click();

		Thread.sleep(3000);
	}

	public void selectAmendableProductByName(String productName) throws InterruptedException {
		Thread.sleep(3000);

		WebElement xpathAmendableProduct = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+productName+"']"));

		xpathAmendableProduct.click();

		Thread.sleep(3000);
	}

	public void verifyAmendText() throws InterruptedException {
		Thread.sleep(3000);

		String xpathAmendText = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tv_amend_status']")).getText();

		String expectedValue = null;
		if(CharMatcher.javaUpperCase().matchesAllOf(xpathAmendText)){
			expectedValue = "AMEND";
		}
		else{
			expectedValue = "Amend";
		}

		assertEquals(xpathAmendText, expectedValue,"Amend text is not displayed");

		Thread.sleep(3000);
	}

	public void verifyNonAmendableOrderIsNotClickable() throws InterruptedException {
		Thread.sleep(3000);

		WebElement xpathNonAmendableProduct = driveR.findElement(By.xpath("//android.widget.RelativeLayout[@index='0']"));

		String isClickable = xpathNonAmendableProduct.getAttribute("clickable");

		assertEquals(isClickable, false,"Non Amendable orders are not clickable");
		Thread.sleep(3000);
	}

	public void verifyAmendableWeekDay() throws InterruptedException {
		Thread.sleep(3000);

		WebElement xpathNonAmendableProduct = driveR.findElement(By.xpath("//android.widget.RelativeLayout[@index='0']"));

		String isClickable = xpathNonAmendableProduct.getAttribute("clickable");

		assertEquals(isClickable, false,"Non Amendable orders are not clickable");
		Thread.sleep(3000);
	}

	public void verifyProductInformation() throws InterruptedException {
		Thread.sleep(3000);

		WebElement xpathProductTitle = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/product_title']"));
		xpathProductTitle.isDisplayed();

		WebElement xpathProductMin = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/value']"));
		xpathProductMin.isDisplayed();

		WebElement xpathLastWeek = driveR.findElement(By.xpath("//android.widget.TextView[@text='Last Week' or @text='LAST WEEK']"));
		xpathLastWeek.isDisplayed();

		WebElement xpathComingWeek = driveR.findElement(By.xpath("//android.widget.TextView[@text='Coming Week' or @text='COMING WEEK']"));
		xpathComingWeek.isDisplayed();
		Thread.sleep(3000);
	}

	public void verifyProductInfoNotDisplayed() throws InterruptedException {
		Thread.sleep(3000);
		boolean isDisplayed = false;
		try{
			WebElement xpathProductTitle = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/product_title']"));
			xpathProductTitle.isDisplayed();
			isDisplayed = true;
		}
		catch(Exception e){
			Thread.sleep(3000);
		}
		assertEquals(isDisplayed, false,"Product information page is displayed");

	}

	public void verifySearchIconIsDisplayed() throws InterruptedException {
		Thread.sleep(3000);

		WebElement xpathSearchIcon = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/menu_search']"));

		xpathSearchIcon.isDisplayed();

	}

	public void clickOnSearchIcon() throws InterruptedException {
		Thread.sleep(3000);

		WebElement xpathSearchIcon = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/menu_search']"));

		xpathSearchIcon.click();
		Thread.sleep(3000);
	}

	public void verifyProductSearchScreen() throws InterruptedException {
		

		WebElement xpathSearchIcon = driveR.findElement(By.xpath("//android.widget.ImageView[@resource-id='android:id/search_mag_icon']"));
		WebElement xpathSearchProduct = driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='android:id/search_src_text']"));
		WebElement xpathCloseIcon = driveR.findElement(By.xpath("//android.widget.ImageView[@resource-id='android:id/search_close_btn']"));
		WebElement xpathSearchResult = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/product_name']"));

	}
	
	public void enterProductId(String productId) throws InterruptedException {
		Thread.sleep(3000);
		WebElement xpathSearchProduct = driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='android:id/search_src_text']"));
		xpathSearchProduct.sendKeys(productId);
	}
	
	public void enterProductName(String productName) throws InterruptedException {
		Thread.sleep(3000);
		WebElement xpathSearchProduct = driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='android:id/search_src_text']"));
		xpathSearchProduct.sendKeys(productName);
	}
	
	public void verifyProductCount() throws InterruptedException {
		WebElement xpathTotalProductsCount = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/txt_action']"));
		xpathTotalProductsCount.isDisplayed();

	}
	
	public void verifySearchResult() throws InterruptedException {
		WebElement xpathSearchResult = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/product_name']"));
		xpathSearchResult.isDisplayed();

	}

	public void iVerifyAllOrderProductList() throws InterruptedException {
	
		List<WebElement> dropdownList = driveR.findElements(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1']"));
	}

	public void getProductsDetailOnUI() throws InterruptedException {

		List<WebElement> xpathProductsList = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/product_name']"));
		int i = 0;
		if(i<=20)
		{
			for(WebElement productsList : xpathProductsList){	
				System.out.println(productsList.getText());
				firstTwentyProducts.add(productsList.getText());
				System.out.println("Products list from UI : " + firstTwentyProducts);
				Thread.sleep(2000);
				TouchAction ts = new TouchAction(driveR);
				ts.press(PointOption.point(350, 400)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
				.moveTo(PointOption.point(300, 400)).release().perform();

				i++;

			}
		}

	}

	public void verifyProductOnUIService() throws InterruptedException {

		List<String> productOnService = new ArrayList<String>();
		productOnService = SalesOrderServices.allOrderList;

		System.out.println("Products list from service : " + productOnService);

	}

	public void verifyAmendProductOnUIService() throws InterruptedException {

		List<String> productOnService = new ArrayList<String>();
		productOnService = SalesOrderServices.amendOrderList;

		System.out.println("Products list from service : " + productOnService);

	}

	public void verifyNonAmendProductOnUIService() throws InterruptedException {

		List<String> productOnService = new ArrayList<String>();
		productOnService = SalesOrderServices.nonAmendOrderList;

		System.out.println("Products list from service : " + productOnService);

	}

	public void getAmendableProductDetails() throws InterruptedException {

		List<WebElement> lastWeekDetails = driveR.findElements(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/ll_last_week_orders' and @index='2']//android.widget.TextView[@resource-id='" + env + ":id/tv_value']"));

		for(WebElement weekDetail : lastWeekDetails){

			String weekDetailText = weekDetail.getText();

			if(weekDetailText.equals("NA"))
			{
				lastWeekOriginalQtyUI.add("null");

			}
			else{
				lastWeekOriginalQtyUI.add(weekDetailText);
			}
		}


		WebElement todayOriginalQty = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tv_today_value_with_unit']"));
		todaysQtyUI = todayOriginalQty.getText();

		WebElement productMinXpath = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/value']"));
		productMinUI = productMinXpath.getText();

		WebElement productDescriptionXpath = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/product_title']"));
		productDescriptionUI = productDescriptionXpath.getText();



		List<WebElement> upcomingWeekDetails = driveR.findElements(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/ll_upcoming_orders' and @index='7']//android.widget.TextView[@resource-id='" + env + ":id/tv_value']"));

		for(WebElement upcomingWeek : upcomingWeekDetails){

			String upcomingWeekText = upcomingWeek.getText();

			if(upcomingWeekText.equals("NA"))
			{
				upcomingOriginalQtyUI.add("null");

			}
			else{
				lastWeekOriginalQtyUI.add(upcomingWeekText);
			}
		}
	}

	public void selectCategoryWithNoProducts() throws InterruptedException{
		String deptName = null;
		HashMap<String,String> categoriesDetailService =categoriesDetails;
		String categoryId = SalesOrderServices.categoryIdWithNoProducts;

		for (Entry<String, String> entry : categoriesDetailService.entrySet()) {
			if (entry.getValue().equals(categoryId)) {
				deptName = entry.getKey();
				System.out.println(entry.getKey());
			}
		}

		Thread.sleep(3000);
		WebElement xpathSelectDepartment = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+deptName+"']"));

		xpathSelectDepartment.isDisplayed();

		selectedCategoryName = xpathSelectDepartment.getText();
		Thread.sleep(3000);

		xpathSelectDepartment.click();
		Thread.sleep(3000);
	}

	public void verifyEmptyOrderListDisplayed() throws InterruptedException{
		Thread.sleep(3000);

		WebElement xpathEmptyOrderList = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/list_empty_view']"));
		xpathEmptyOrderList.isDisplayed();

		String emptyList = xpathEmptyOrderList.getText();

		assertEquals(emptyList, "No forecast Orders","Product list is not empty");
	}

	public void getProductDescriptionUI() throws InterruptedException{


		for(int i =1;i<=5;i++){
			Thread.sleep(3000);
			List<WebElement> xpathProductsList = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/product_name']"));

			for(WebElement product : xpathProductsList){
				String description = product.getText();

				if(!productDescriptionList.contains(description)){
					System.out.println("Product description UI : " + description);
					productDescriptionList.add(description);}
			}


			TouchAction ts = new TouchAction(driveR);
			ts.press(PointOption.point(350, 1700)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
			.moveTo(PointOption.point(300, 380)).release().perform();

			Thread.sleep(5000);
		}
	}

	public void verifyDeptIdAscendingOrder(){
		boolean isPresent = false;
		boolean isMax = false;
		int departmentIDOrginal = 0;

		Map<String,String> orderDeptDescription = SalesOrderServices.orderDeptAndDescription;

		for (String description: orderDeptDescription.keySet()) {
			System.out.println("Description : " + description);
			System.out.println("Dept id : " + orderDeptDescription.get(description));
			String deptID = orderDeptDescription.get(description);

			int departmentIDNext = Integer.parseInt(deptID);

			System.out.println("Product description services : " + description);
			System.out.println("Product description services : " + deptID);

			if(productDescriptionList.contains(description))
			{
				isPresent = true;
			}
			assertEquals(isPresent, true,"Product is not present in list");

			if(departmentIDOrginal <= departmentIDNext)
			{
				isMax = true;
			}
			assertEquals(isMax, true,"Product is not in Ascending order");

			departmentIDOrginal = departmentIDNext;
		}
	}
}
