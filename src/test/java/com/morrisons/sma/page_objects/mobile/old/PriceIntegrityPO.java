package com.morrisons.sma.page_objects.mobile.old;


import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.PointOption;
import com.morrisons.common.action.Hook;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;

public class PriceIntegrityPO {

	private static AndroidDriver driveR;
	private static LoginPagePO smaLoginPage = new LoginPagePO();


	ObjectMapper objectMapper = new ObjectMapper();
	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
	String env = applicationConfig.getWebElementEnviroment().getEnv();

	String colleagueUsername = applicationConfig.getUserCredentials().getCollegueUsername();
	String colleaguePassword = applicationConfig.getUserCredentials().getColleguePassword();
	String managerUsername = applicationConfig.getUserCredentials().getManagerUsername();
	String managerPassword = applicationConfig.getUserCredentials().getManagerPassword();

	private static String scrollFirstPart = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"";
	private static String scrollSecondPart = "\").instance(0))";

	private static final Logger LOGGER = Logger.getLogger(PriceIntegrityPO.class.getName());

	private static int maxTry = 4;

	public static List<WebElement> mobAisleList=new ArrayList<>();
	public static List<String> tmpMobAisleList=new ArrayList<>();

	int overdueCountBusinessCritical;
	
	
	public PriceIntegrityPO() {
		this.driveR = (AndroidDriver) Hook.getDriver();
	}

	public void enterCollegueCredentials() throws Throwable {
		smaLoginPage.enterCollegueCredentials();
		smaLoginPage.clickOnLogin();
	}


	public void navigatePriceIntergrityMenu() throws Throwable {
		Thread.sleep(5000);
		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/price_integrity']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/price_integrity']")).click();
	}

	public void verifyMenuUnderPriceIntegrity() throws Throwable {
		Assert.assertTrue(isElementPresent(priceIntergrityWorkload()));
		Assert.assertTrue(isElementPresent(priceIntergrityReview()));
		Assert.assertTrue(isElementPresent(priceIntergrityExceptions()));
		Assert.assertTrue(isElementPresent(priceIntergrityRequestlabel()));
		Assert.assertTrue(isElementPresent(priceIntergrityVerification()));
		Assert.assertTrue(isElementPresent(priceIntergrityVerificationHistory()));

	}

	public static boolean isElementPresent(String element) throws Throwable {
		boolean elementPresent = false;
		try {
			int i = driveR.findElements(By.xpath(element)).size();
			if (i > 0) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return elementPresent;
	}

	public static boolean isElementPresent(WebElement element) throws Throwable {
		boolean elementPresent = false;
		if (element.isDisplayed()) {
			return true;
		}
		return elementPresent;
	}


	// Price Integrity Menus
	public WebElement priceIntergrityWorkload() throws Throwable {
		WebElement element = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/button_start_checking']"));
		return element;
	}

	public WebElement priceIntergrityReview() throws Throwable {
		WebElement element = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/button_price_integrity_history_review']"));
		return element;
	}

	public WebElement priceIntergrityExceptions() throws Throwable {
		WebElement element = driveR
				.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/button_price_integrity_history_exceptions_only']"));
		return element;
	}

	public WebElement priceIntergrityRequestlabel() throws Throwable {
		WebElement element = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/button_request_label']"));
		return element;
	}

	public WebElement priceIntergrityVerification() throws Throwable {
		WebElement element = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/button_legal_check']"));
		return element;
	}

	public WebElement priceIntergrityVerificationHistory()throws Throwable {
		WebElement element = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/button_legal_check_history']"));
		return element;
	}

	// Daily Workload Menus
	public WebElement workloadBusinessCritical() throws Throwable {
		WebElement element = driveR.findElement(By.xpath("//android.widget.TextView[@text='Business Critical' or @text='BUSINESS CRITICAL']"));
		return element;
	}

	public WebElement workloadPriceIncreases() throws Throwable {
		Thread.sleep(4000);
		WebElement element = driveR.findElement(By.xpath("//android.widget.TextView[@text='Price Increases' or @text='PRICE INCREASES']"));
		return element;
	}

	public WebElement workloadEndingOffers() throws Throwable {
		Thread.sleep(4000);
		WebElement element = driveR.findElement(By.xpath("//android.widget.TextView[@text='Ending Offers' or @text='ENDING OFFERS']"));
		return element;
	}

	public WebElement workloadPriceDecreases() throws Throwable {
		Thread.sleep(4000);
		WebElement element = driveR.findElement(By.xpath("//android.widget.TextView[@text='Price Decreases' or @text='PRICE DECREASES']"));
		return element;
	}

	public WebElement workloadStartingOffers() throws Throwable {
		Thread.sleep(4000);
		WebElement element = driveR.findElement(By.xpath("//android.widget.TextView[@text='Starting Offers' or @text='STARTING OFFERS']"));
		return element;
	}

	public WebElement workloadStartingMorePoints() throws Throwable {
		Thread.sleep(4000);
		WebElement element = driveR.findElement(By.xpath("//android.widget.TextView[@text='Starting More Points' or @text='STARTING MORE POINTS']"));
		return element;
	}

	public WebElement workloadOverdue()throws Throwable {
		Thread.sleep(4000);
		WebElement element = driveR.findElement(By.xpath("//android.widget.TextView[@text='Overdue' or @text='OVERDUE']"));
		return element;
	}
	//
	//		public WebElement workloadPriceChanges() throws Throwable {
	//			WebElement element = driveR.findElement(By.xpath("//android.widget.TextView[@text='Fixture Scan' or @text='FIXTURE SCAN']"));
	//			return element;
	//		}

	// Counts against sub-menus under Daily Workload
	public WebElement workloadBusinessCriticalCount() throws Throwable {
		WebElement element = driveR.findElement(By.xpath(
				"//android.widget.LinearLayout[@index='0']/android.widget.TextView[contains(@resource-id,'label_group_count')]"));
		return element;
	}

	public WebElement workloadPriceIncreasesCount() throws Throwable {
		WebElement element=driveR.findElement(By.xpath(
				"//android.widget.LinearLayout[@index='1']/android.widget.TextView[contains(@resource-id,'label_group_count')]"));
		return element;
	}

	public WebElement workloadEndingOffersCount() throws Throwable {
		WebElement element=driveR.findElement(By.xpath(
				"//android.widget.LinearLayout[@index='2']/android.widget.TextView[contains(@resource-id,'label_group_count')]"));
		return element;
	}

	public WebElement workloadPriceDecreasesCount() throws Throwable {
		WebElement element=driveR.findElement(By.xpath(
				"//android.widget.LinearLayout[@index='3']/android.widget.TextView[contains(@resource-id,'label_group_count')]"));
		return element;
	}

	public WebElement workloadStartingOffersCount()throws Throwable {
		WebElement element=driveR.findElement(By.xpath(
				"//android.widget.LinearLayout[@index='4']/android.widget.TextView[contains(@resource-id,'label_group_count')]"));
		return element;
	}

	public WebElement workloadStartingMorePointsCount() throws Throwable {
		WebElement element=driveR.findElement(By.xpath(
				"//android.widget.LinearLayout[@index='5']/android.widget.TextView[contains(@resource-id,'label_group_count')]"));
		return element;
	}

	public WebElement workloadOverdueCount() throws Throwable {
		WebElement element= driveR.findElement(By.xpath(
				"//android.widget.LinearLayout[@index='6']/android.widget.TextView[contains(@resource-id,'label_group_count')]"));
		return element;
	}

	public void navigateDailyWorkloadMenu() throws Throwable {

		driveR.findElement(By.id("" + env + ":id/button_start_checking")).click();
	}

	public void navigateBusinessCriticalMenu() throws Throwable {
		Thread.sleep(5000);
		driveR.findElement(By.xpath("//android.widget.TextView[@text='Business Critical' or @text='BUSINESS CRITICAL']")).click();
	}

	public void navigatePriceIncreasesMenu() {

		driveR.findElement(By.xpath(
				"//android.widget.TextView[@text='Price Increases' or @text='PRICE INCREASES']")).click();
	}

	public void navigatePriceDecreasesMenu() throws Throwable {

		driveR.findElement(By.xpath(
				"//android.widget.LinearLayout[@index='3']/android.widget.TextView[contains(@resource-id,'label_group_count')]")).click();
		Thread.sleep(1000);

	}

	public void verifySubmenusUnderDailyWorkload() throws Throwable {
		Assert.assertTrue(isElementPresent(workloadBusinessCritical()));
		Assert.assertTrue(isElementPresent(workloadEndingOffers()));
		Assert.assertTrue(isElementPresent(workloadPriceDecreases()));
		Assert.assertTrue(isElementPresent(workloadStartingOffers()));
		Assert.assertTrue(isElementPresent(workloadStartingMorePoints()));
		Assert.assertTrue(isElementPresent(workloadOverdue()));

		overdueCountBusinessCritical = Integer.parseInt(workloadBusinessCriticalCount().getText());
		System.out.println("Business critical count: " + workloadBusinessCriticalCount().getText());
		System.out.println("Price increases count: " + workloadPriceIncreasesCount().getText());
		System.out.println("Ending offers count: " + workloadEndingOffersCount().getText());
		System.out.println("Price decreases count: " + workloadPriceDecreasesCount().getText());
		System.out.println("Starting offers count: " + workloadStartingOffersCount().getText());
		System.out.println("Starting more points count: " + workloadStartingMorePointsCount().getText());
		System.out.println("Overdue count: " + workloadOverdueCount().getText());
	}
	
	public void verifySubmenusUndeBuisnessCritical() throws Throwable {
		
		Assert.assertTrue(isElementPresent(workloadEndingOffers()));
		Assert.assertTrue(isElementPresent(workloadPriceIncreases()));
		Assert.assertTrue(isElementPresent(workloadPriceDecreases()));
		Assert.assertTrue(isElementPresent(workloadStartingOffers()));
		Assert.assertTrue(isElementPresent(workloadStartingMorePoints()));


		System.out.println("Price increases count: " + workloadPriceIncreasesCount().getText());
		System.out.println("Ending offers count: " + workloadEndingOffersCount().getText());
		System.out.println("Price decreases count: " + workloadPriceDecreasesCount().getText());
		System.out.println("Starting offers count: " + workloadStartingOffersCount().getText());
		System.out.println("Starting more points count: " + workloadStartingMorePointsCount().getText());
	}


	public void clickOnBackButton()throws Throwable {
		Thread.sleep(2000);
		WebElement element = driveR.findElement(By.className("android.widget.ImageButton"));
		element.click();
	}


	// Counts against sub-menus under Business Critical
	public WebElement businessCriticalPriceIncreasesCount() throws Throwable {
		WebElement element =driveR.findElement(By.xpath(
				"//android.widget.LinearLayout[@index='0']/android.widget.TextView[contains(@resource-id,'label_group_count')]"));
		return element;
	}

	public WebElement businessCriticalPriceDecreasesCount() throws Throwable {
		WebElement element =driveR.findElement(By.xpath(
				"//android.widget.LinearLayout[@index='3']/android.widget.TextView[contains(@resource-id,'label_group_count')]"));
		return element;
	}

	public WebElement businessCriticalStartingOffersCount() throws Throwable {
		WebElement element =driveR.findElement(By.xpath(
				"//android.widget.LinearLayout[@index='2']/android.widget.TextView[contains(@resource-id,'label_group_count')]"));
		return element;
	}

	public WebElement businessCriticalEndingOffersCount() throws Throwable {
		WebElement element = driveR.findElement(By.xpath(
				"//android.widget.LinearLayout[@index='1']/android.widget.TextView[contains(@resource-id,'label_group_count')]"));
		return element;
	}

	public WebElement businessCriticalStartingMorePointsCount()throws Throwable {
		WebElement element = driveR.findElement(By.xpath(
				"//android.widget.LinearLayout[@index='5']/android.widget.TextView[contains(@resource-id,'label_group_count')]"));
		return element;
	}

	// Exceptions
	public WebElement workloadGapException()throws Throwable {
		WebElement element = driveR.findElement(By.xpath(
				"//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout/android.widget.CheckBox"));
		return element;
	}

	public  WebElement workloadProductNotFoundException() throws Throwable {
		WebElement element = driveR.findElement(By.xpath(
				"//android.widget.LinearLayout[@index='1']/android.widget.LinearLayout/android.widget.CheckBox"));
		return element;
	}

	public WebElement workloadWrongLabelSizeException() throws Throwable {
		WebElement element = driveR.findElement(By.xpath(
				"//android.widget.LinearLayout[@index='2']/android.widget.LinearLayout/android.widget.CheckBox"));
		return element;
	}

	public WebElement workloadIncorrectPriceException() throws Throwable {
		WebElement element = driveR.findElement(By.xpath(
				"//android.widget.LinearLayout[@index='3']/android.widget.LinearLayout/android.widget.CheckBox"));
		return element;
	}

	public WebElement workloadIncorrectPromotionException() throws Throwable {
		WebElement element =  driveR.findElement(By.xpath(
				"//android.widget.LinearLayout[@index='4']/android.widget.LinearLayout/android.widget.CheckBox"));
		return element;
	}

	public WebElement workloadFlashMarkedException()throws Throwable {
		WebElement element = driveR.findElement(By.xpath(
				"//android.widget.LinearLayout[@index='5']/android.widget.LinearLayout/android.widget.CheckBox"));
		return element;
	}

	public WebElement workloadNotAsAdvertisedException() throws Throwable {
		WebElement element =  driveR.findElement(By.xpath(
				"//android.widget.LinearLayout[@index='6']/android.widget.LinearLayout/android.widget.CheckBox"));
		return element;
	}

	public WebElement workloadIncorrectDescriptionException() throws Throwable {
		WebElement element = driveR.findElement(By.xpath(
				"//android.widget.LinearLayout[@index='7']/android.widget.LinearLayout/android.widget.CheckBox"));
		return element;
	}

	public WebElement workloadIncorrectUnitPriceException() throws Throwable {
		WebElement element =  driveR.findElement(By.xpath(
				"//android.widget.LinearLayout[@index='8']/android.widget.LinearLayout/android.widget.CheckBox"));
		return element;
	}

	public WebElement workloadOtherException() throws Throwable {
		WebElement element = driveR.findElement(By.xpath(
				"//android.widget.LinearLayout[@index='9']/android.widget.LinearLayout/android.widget.CheckBox"));
		return element;
	}

	public WebElement workloadIncorrectCountryOfOriginException()throws Throwable {
		WebElement element =  driveR.findElement(By.xpath(
				"//android.widget.LinearLayout[@index='10']/android.widget.LinearLayout/android.widget.CheckBox"));
		return element;
	}

	public WebElement workloadCompleteCheckButton()throws Throwable {
		WebElement element =driveR.findElement(By.id("com.morrisons.instore.sit:id/inner_button"));
		return element;
	}

	public WebElement workloadEndingOffersSelectTask() throws Throwable {
		WebElement element =driveR.findElement(By.id("com.morrisons.instore.sit:id/group_name"));
		return element;
	}

	public WebElement verificationLocationDetails() throws Throwable {
		WebElement element = driveR.findElement(By.id("com.morrisons.instore.sit:id/location_details"));
		return element;
	}

	public WebElement requestLabelPiLabellingSystemRadioButton() throws Throwable {
		WebElement element = driveR.findElement(By.id("com.morrisons.instore.sit:id/radio_service_toggle_v2"));
		return element;
	}


	//		public void requestLabelEpisysResRadioButton() throws Throwable {
	//			 driveR.findElement(By.id("com.morrisons.instore.sit:id/radio_service_toggle_v1"));
	//			
	//		}
	//
	//		public void requestLabelSearchIcon() throws Throwable {
	//			 driveR.findElement(By.id("com.morrisons.instore.sit:id/action_search_product"));
	//			
	//		}
	//
	//		public void requestLabelSearchTextBox() throws Throwable {
	//			 driveR.findElement(By.id("com.morrisons.instore.sit:id/search_src_text"));
	//			
	//		}
	//
	//		public void requestLabelSearchResult() throws Throwable {
	//			 driveR.findElement(By.id("com.morrisons.instore.sit:id/product_name"));
	//			
	//		}

	public void requestLabelItemDescription() throws Throwable {
		driveR.findElement(By.id("com.morrisons.instore.sit:id/text_product_description"));

	}

	public void requestLabelSelectionBox() throws Throwable {
		driveR.findElement(By.id("com.morrisons.instore.sit:id/edit_text_quantity"));

	}

	//		public void requestLabelContinueButton() throws Throwable {
	//			 driveR.findElement(By.id("com.morrisons.instore.sit:id/inner_button"));
	//			
	//		}
	//
	//		public void requestLabelStack() throws Throwable {
	//			 driveR.findElement(By.id("com.morrisons.instore.sit:id/stack_name"));
	//			
	//		}
	//
	//		public void requestLabelType()throws Throwable {
	//			 driveR.findElement(By.id("com.morrisons.instore.sit:id/check_issue_checkbox"));
	//			
	//		}

	public void requestLabelAdd() throws Throwable {
		driveR.findElement(By.id("com.morrisons.instore.sit:id/label_add_button"));

	}

	public WebElement itemName() throws Throwable {
		WebElement element = driveR.findElement(By.id("com.morrisons.instore.sit:id/product_name"));
		return element;

	}

	public WebElement itemDecriptionDetailsPage() throws Throwable {
		WebElement element = driveR.findElement(By.id("com.morrisons.instore.sit:id/text_product_description"));
		return element;

	}

	public WebElement closeButton() throws Throwable {
		WebElement element = driveR.findElement(By.id("com.morrisons.instore.sit:id/inner_button"));
		return element;
	}



	public void verifyRightExceptionAndStatus(String exceptionName) throws Throwable {

		Thread.sleep(2000);
		Assert.assertTrue(exceptionName.equalsIgnoreCase(verificationExceptionName().getText()));
		Thread.sleep(2000);
		Assert.assertTrue(verificationExceptionStatus().isDisplayed());
		System.out.println("Exception Status: " + verificationExceptionStatus().getText());
	}






	public void txtbxUserName() {
		driveR.findElement(By.id("com.morrisons.instore.sit:id/username"));

	}

	public void txtbxPassword() {
		driveR.findElement(By.id("com.morrisons.instore.sit:id/password"));

	}

	public void loginButton() {
		driveR.findElement(By.id("com.morrisons.instore.sit:id/inner_button"));

	}


	public WebElement itemDescription() {
		WebElement element = driveR.findElement(By.id("com.morrisons.instore.sit:id/description"));
		return element;
	}

	public void scannedItemDescription() {
		driveR.findElement(By.id("com.morrisons.instore.sit:id/text_product_description"));

	}

	// Price Integrity Menus
	public void priceIntergirtyMenu() {
		driveR.findElement(By.id("com.morrisons.instore.sit:id/price_integrity"));

	}

	public void priceIntergirtyWorkload() {
		driveR.findElement(By.id("com.morrisons.instore.sit:id/button_start_checking"));

	}

	public void priceIntergirtyReview() {
		driveR.findElement(By.id("com.morrisons.instore.sit:id/button_price_integrity_history_review"));

	}

	public void priceIntergirtyExceptions() {
		driveR
		.findElement(By.id("com.morrisons.instore.sit:id/button_price_integrity_history_exceptions_only"));

	}

	public void priceIntergirtyRequestLabel() {
		driveR.findElement(By.id("com.morrisons.instore.sit:id/button_request_label"));

	}

	public void priceIntergirtyVerification() {
		driveR.findElement(By.id("com.morrisons.instore.sit:id/button_legal_check"));

	}

	public void priceIntergirtyVerificationHistory() {
		driveR.findElement(By.id("com.morrisons.instore.sit:id/button_legal_check_history"));

	}

	// Back button
	public void upNavigationbutton() {

		driveR.findElement(By.className("android.widget.ImageButton"));

	}


	// Product Selector
	public WebElement productListSelector() {
		WebElement element = driveR.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.morrisons.instore.sit:id/label_group_name') and @text='Product List']"));
		return element;
	}


	// Missing label
//	@SuppressWarnings("rawtypes")
//	public void missingLabel() {
//		((io.appium.java_client.FindsByAndroidUIAutomator) driveR)
//		.findElementByAndroidUIAutomator("new UiSelector().text(\"Missing Label\")");
//
//	}

	// Product not found
	public WebElement productNotFound() {
		WebElement element = driveR.findElement(By.xpath(
				"//android.widget.TextView[contains(@resource-id, 'com.morrisons.instore.sit:id/alertTitle') and @text='Product Not Found']"));
		return element;	
	}

	// Select Label system
	public WebElement labelSystem() {
		WebElement element = driveR.findElement(By.id("com.morrisons.instore.sit:id/service_version_name"));
		return element;	
	}

	// Total task
	public WebElement totalTask() {
		WebElement element = driveR.findElement(By.id("com.morrisons.instore.sit:id/label_total"));
		return element;
	}

	// Alert - accept
	public WebElement acceptAlert() {
		WebElement element = driveR.findElement(By.id("android:id/button1"));
		return element;
	}

	// Daily Workload Menus
	public void dailyWorkloadBusinessCritical() {
		driveR.findElement(By.xpath("//android.widget.TextView[@text='Business Critical']"));

	}

	public void dailyWorkloadPriceIncreases() {
		driveR.findElement(By.xpath("//android.widget.TextView[@text='Price Increases']"));

	}

	public void dailyWorkloadEndingOffers() {
		driveR.findElement(By.xpath("//android.widget.TextView[@text='Ending Offers']"));
	}

	public void dailyWorkloadPriceDecreases() {
		driveR.findElement(By.xpath("//android.widget.TextView[@text='Price Decreases']"));

	}

	public void dailyWorkloadStartingOffers() {
		driveR.findElement(By.xpath("//android.widget.TextView[@text='Starting Offers']"));

	}

	public void dailyWorkloadStartingMorePoints() {
		driveR.findElement(By.xpath("//android.widget.TextView[@text='Starting More Points']"));

	}

	public void dailyWorkloadOverdue() {
		driveR.findElement(By.xpath("//android.widget.TextView[@text='Overdue']"));

	}

	public void overduePriceChanges() {
		driveR.findElement(By.xpath("//android.widget.TextView[@text='Price Changes']"));

	}

	// Counts against sub-menus under Daily Workload
	public void dailyWorkloadBusinessCriticalCount() {

		driveR.findElement(By.xpath(
				"//android.widget.LinearLayout[@index='0']/android.widget.TextView[contains(@resource-id,'label_group_count')]"));

	}

	public void dailyWorkloadPriceIncreasesCount() {
		driveR.findElement(By.xpath(
				"//android.widget.LinearLayout[@index='1']/android.widget.TextView[contains(@resource-id,'label_group_count')]"));

	}

	public void dailyWorkloadEndingOffersCount() {
		driveR.findElement(By.xpath(
				"//android.widget.LinearLayout[@index='2']/android.widget.TextView[contains(@resource-id,'label_group_count')]"));

	}

	public void dailyWorkloadPriceDecreasesCount() {
		driveR.findElement(By.xpath(
				"//android.widget.LinearLayout[@index='3']/android.widget.TextView[contains(@resource-id,'label_group_count')]"));

	}

	public void dailyWorkloadStartingOffersCount() {
		driveR.findElement(By.xpath(
				"//android.widget.LinearLayout[@index='4']/android.widget.TextView[contains(@resource-id,'label_group_count')]"));

	}

	public void dailyWorkloadStartingMorePointsCount() {
		driveR.findElement(By.xpath(
				"//android.widget.LinearLayout[@index='5']/android.widget.TextView[contains(@resource-id,'label_group_count')]"));

	}

	public void dailyWorkloadOverdueCount() {
		driveR.findElement(By.xpath(
				"//android.widget.LinearLayout[@index='6']/android.widget.TextView[contains(@resource-id,'label_group_count')]"));

	}


	
	//// OverDue label exisits
	public void overDueLabelExists() {

		driveR.findElement(By.id("com.morrisons.instore.sit:id/overdue_label"));

	}

	// ScrollView exists
	public void verifyScrollView() {
		driveR.findElement(By.xpath("//android.widget.ScrollView"));

	}

	// Select location
	//		public void selectLocation() {
	//
	//			 driveR.findElement(By.id("com.morrisons.instore.sit:id/location_checkbox"));
	//			
	//		}


	//
	//		@SuppressWarnings("rawtypes")
	//		public void myWorkTab() {
	//			 ((FindsByAndroidUIAutomator) driveR)
	//					.findElementByAndroidUIAutomator("new UiSelector().text(\"My Work\")");
	//			
	//		}
	//
	//		@SuppressWarnings("rawtypes")
	//		public void myStoreTab() {
	//			 ((FindsByAndroidUIAutomator) driveR)
	//					.findElementByAndroidUIAutomator("new UiSelector().text(\"My Store\")");
	//			
	//		}
	//
	public WebElement filterIcon() {
		WebElement element = driveR.findElement(By.id("com.morrisons.instore.sit:id/action_filter"));
		return element;
	}
	//
	//		public void verificationExpandExceptionPanel() {
	//			 driveR.findElement(By.id("com.morrisons.instore.sit:id/expand_panel_arrow"));
	//			
	//		}
	//
	//		public void verificationEditTextBox() {
	//			 driveR.findElement(By.id("com.morrisons.instore.sit:id/edit_text_price_check"));
	//			
	//		}
	//
	//		public void verificationExceptionCheckBox() {
	//			 driveR.findElement(By.id("com.morrisons.instore.sit:id/check_issue_checkbox"));
	//			
	//		}
	//
	public WebElement verificationProductName() {
		WebElement element = driveR.findElement(By.id("com.morrisons.instore.sit:id/text_product_name"));
		return element;
	}
	//
	public WebElement verificationExceptionName() {
		WebElement element = driveR.findElement(By.id("com.morrisons.instore.sit:id/exception_name"));
		return element;
	}
	//
	//		public void verificationExceptionStatus() {
	//			 driveR.findElement(By.id("com.morrisons.instore.sit:id/exception_status_indicator"));
	//			
	//		}

	public WebElement verificationOperatorErrorException() {
		WebElement element =  driveR.findElement(By.xpath(
				"//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout/android.widget.CheckBox"));
		return element;
	}

	public WebElement verificationIncorrectPromotionException() {
		WebElement element = driveR.findElement(By.xpath(
				"//android.widget.LinearLayout[@index='1']/android.widget.LinearLayout/android.widget.CheckBox"));
		return element;
	}

	public WebElement verificationFlashMarkedException() {
		WebElement element = driveR.findElement(By.xpath(
				"//android.widget.LinearLayout[@index='2']/android.widget.LinearLayout/android.widget.CheckBox"));
		return element;
	}

	public WebElement verification4PointCheckErrorException() {
		WebElement element = driveR.findElement(By.xpath(
				"//android.widget.LinearLayout[@index='3']/android.widget.LinearLayout/android.widget.CheckBox"));
		return element;
	}

	public WebElement verificationMissingLabelException() {
		WebElement element = driveR.findElement(By.xpath(
				"//android.widget.LinearLayout[@index='4']/android.widget.LinearLayout/android.widget.CheckBox"));
		return element;
	}

	public WebElement verificationGapException() {
		WebElement element =driveR.findElement(By.xpath(
				"//android.widget.LinearLayout[@index='4']/android.widget.LinearLayout/android.widget.CheckBox"));
		return element;
	}

	public WebElement verificationIncorrectUnitPriceException() {
		WebElement element = driveR.findElement(By.xpath(
				"//android.widget.LinearLayout[@index='5']/android.widget.LinearLayout/android.widget.CheckBox"));
		return element;
	}

	public WebElement verificationVariantException() {
		WebElement element = driveR.findElement(By.xpath(
				"//android.widget.LinearLayout[@index='6']/android.widget.LinearLayout/android.widget.CheckBox"));
		return element;
	}

	public WebElement verificationOtherException() {
		WebElement element = driveR.findElement(By.xpath(
				"//android.widget.LinearLayout[@index='7']/android.widget.LinearLayout/android.widget.CheckBox"));
		return element;	
	}

	public WebElement verificationIncorrectCountryOfOriginException() {
		WebElement element = driveR.findElement(By.xpath(
				"//android.widget.TextView[contains(@resource-id,'com.morrisons.instore.sit:id/check_issue_name') and @text='Incorrect Country of Origin']"));
		return element;
	}

	public void verificationDescription() {
		driveR.findElement(By.id("com.morrisons.instore.sit:id/comment_text_input_edit"));

	}

	public void verificationInnerButton() {
		WebElement element =driveR.findElement(By.id("com.morrisons.instore.sit:id/inner_button"));

	}

	public void currentPageTitle() throws InterruptedException {
		Thread.sleep(5000);
		String title =  driveR.getTitle();
	}




	public void taskPresentforAllCriteria(String itemDescription) {
		int cnt = 0;
		for (int i = 0; i <= maxTry; i++) {
			try {
				/*
				 * PriceIntegrityMobileApp.aisleSelector().click()
				 * Thread.sleep(5000); if
				 * (scrollAndCheckItemPresentInList(
				 * itemDescription)) { System.out.println("Item: " + itemDescription +
				 * " found."); break; } else {
				 * 
				 * PriceIntegrityMobileApp.pressBackButton();
				 * Thread.sleep(3000);
				 */

				productListSelector().click();
				Thread.sleep(3000);

				if (scrollAndCheckItemPresentInList(itemDescription)) {
					System.out.println("Item: " + itemDescription + " found.");
					break;
				}

				// }

			} catch (Exception e) {
				cnt++;
				if (maxTry == cnt) {
					Assert.fail("Item: " + itemDescription + " not found.");
				}
				swipeUp();
			}

		}

	}

	public void taskPresentforBusinessCriticals(String itemDescription) {
		int cnt = 0;
		for (int i = 0; i <= maxTry; i++) {
			try {

				if (scrollAndCheckItemPresentInList(itemDescription)) {
					System.out.println("Item: " + itemDescription + " found.");
					break;
				}

			} catch (Exception e) {
				cnt++;
				if (maxTry == cnt) {
					Assert.fail("Item: " + itemDescription + " not found.");
				}
				swipeUp();
			}

		}

	}

	public void navigateStartingOffersMenu() {

		driveR.findElement(By.xpath(
				"//android.widget.LinearLayout[@index='4']/android.widget.TextView[contains(@resource-id,'label_group_count')]")).click();
	}

	public void navigateEndingOffersMenu() {

		driveR.findElement(By.xpath("//android.widget.TextView[@text='Ending Offers' or @text='ENDING OFFERS']")).click();
	}

	public void navigateStartingMorePointsMenu() {

		driveR.findElement(By.xpath("//android.widget.TextView[@text='Starting More Points']")).click();
	}

	//@SuppressWarnings("rawtypes")
	public boolean scrollAndCheckItemPresentInList(String description) {

		boolean isPresent = false;
		isPresent = ((FindsByAndroidUIAutomator) driveR)
				.findElementByAndroidUIAutomator(scrollFirstPart + description + scrollSecondPart) != null;

		return isPresent;
	}

	//@SuppressWarnings("rawtypes")
	public void findAndClickOnItem(String optionToClick) {

		((FindsByAndroidUIAutomator) driveR)
		.findElementByAndroidUIAutomator(scrollFirstPart + optionToClick + scrollSecondPart).click();
	}

	//@SuppressWarnings("rawtypes")
	public void findAndClickOnItems(List<String> optionsToClick) {

		String flashMarked = driveR.findElement(By.xpath(
				"//android.widget.LinearLayout[@index='2']/android.widget.LinearLayout/android.widget.CheckBox")).getText();
		optionsToClick.add(flashMarked);

		for (String optionToClick : optionsToClick) {

			((FindsByAndroidUIAutomator) driveR)
			.findElementByAndroidUIAutomator(scrollFirstPart + optionToClick + scrollSecondPart).click();
		}
	}

	public void scanBarcode(String barcode) {
//Old method
				String packageName = "com.morrions.instore.MockBarcodeReadEvent";
				String command = "adb shell am broadcast -a " + packageName + " -e BARCODE " + barcode;
				try {
					Runtime.getRuntime().exec(command);
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}

	}

	public void selectLocation() {

		try {
			if (driveR.findElement(By.xpath("//android.widget.ScrollView")).isDisplayed()) {
				getAisleNames();
				driveR.findElement(By.id("" + env + ":id/location_checkbox")).click();
			}
		} catch (Exception e) {

			System.out.println("No location to select");

		}

	}

	public void getAisleNames() throws InterruptedException {
		Thread.sleep(2000);
		mobAisleList= driveR.findElements(By.id("" + env + ":id/location_details"));
		Thread.sleep(2000);
		for (WebElement e : mobAisleList) {
			tmpMobAisleList.add(e.getText());
		}
	} 

	// Overdue label presence
	public WebElement overdueWorkloadIsPresent() {
		WebElement element = driveR.findElement(By.id("" + env + ":id/overdue_label"));
		return element;
	}

	// Up-navigation button
	public WebElement upNavigationButton() {
		WebElement element = driveR.findElement(By.className("android.widget.ImageButton"));
		return element;
	}

	public void swipeLeft() throws InterruptedException {
		TouchAction ts = new TouchAction(driveR);
		ts.press(PointOption.point(520, 412)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
				.moveTo(PointOption.point(32, 412)).release().perform();
		Thread.sleep(4000);
	}

	public void swipeRight() {
		int startX = 100;
		int startY = 1050;
		int endX = 500;
		int endY = 1050;

		AndroidTouchAction touchAction = new AndroidTouchAction((PerformsTouchActions) driveR);
		touchAction.press(PointOption.point(startX, startY)).waitAction().moveTo(PointOption.point(endX, endY))
		.release().perform();
	}

	public void swipeUp() {
		int startX = 350;
		int startY = 1050;
		int endX = 350;
		int endY = 350;

		AndroidTouchAction touchAction = new AndroidTouchAction((PerformsTouchActions) driveR);
		touchAction.press(PointOption.point(startX, startY)).waitAction().moveTo(PointOption.point(endX, endY))
		.release().perform();
	}

	public WebElement myWorkTab() {
		WebElement element = driveR.findElement(By.xpath("//android.widget.TextView[@text='MY WORK' or @text='My Work']"));
		return element;
	}

	public WebElement myStoreTab() {
		WebElement element =  driveR.findElement(By.xpath("//android.widget.TextView[@text='MY STORE' or @text='My Store']"));
		return element;
	}

	// Filter
	public WebElement clickFilterIcon() throws InterruptedException {
		Thread.sleep(2000);
	
		WebElement element = driveR.findElement(By.id("" + env + ":id/action_filter"));
		return element;
	}

	//		// Undo - Ending offer
	public WebElement optionUndo() {
		WebElement element =  driveR.findElement(By.id("" + env + ":id/snackbar_action"));
		return element;
	}

	// Exception raised text - Ending offer
	public WebElement textExceptionRaised() {
		WebElement element =  driveR.findElement(By.id("" + env + ":id/snackbar_text"));
		return element;
	}

	// Aisle selector
	public WebElement aisleSelector() {
		WebElement element = driveR.findElement(By.id("" + env + ":id/label_group_name"));
		return element;
	}
	//
	//		// ProductList selector
	//		public void productListSelector() {
	//			return driveR.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'" + env + ":id/label_group_name') and @text='Product List']"));
	//		}
	//
	//		// Correct item icon
	public WebElement correctItemIcon() {
		WebElement element =  driveR.findElement(By.id("" + env + ":id/success_check_mark"));
		return element;
	}

	// Exception icon
	public WebElement exceptionIcon() {
		WebElement element =  driveR.findElement(By.id("" + env + ":id/issue_status_indicator"));
		return element;
	}

	// Request Label
	public WebElement requestLabelPiLabellingRadioButton() {
		WebElement element = driveR.findElement(By.id("" + env + ":id/radio_service_toggle_v2"));
		return element;
	}

	public WebElement requestLabelEpisysResRadioButton() {
		WebElement element =  driveR.findElement(By.id("" + env + ":id/radio_service_toggle_v1"));
		return element;
	}

	public WebElement requestLabelSearchIcon() {
		WebElement element =  driveR.findElement(By.id("" + env + ":id/action_search_product"));
		return element;
	}

	public WebElement requestLabelSearchTextBox() {
		WebElement element =  driveR.findElement(By.id("" + env + ":id/search_src_text"));
		return element;
	}

	public WebElement requestLabelSearchResult() {
		WebElement element =  driveR.findElement(By.id("" + env + ":id/product_name"));
		return element;
	}

	public WebElement requestLabelItemDecriptionOnScanPage() {
		WebElement element = driveR.findElement(By.id("" + env + ":id/text_product_description"));
		return element;
	}

	public WebElement requestLabelSelectNoOfLabels() {
		WebElement element =  driveR.findElement(By.id("" + env + ":id/edit_text_quantity"));
		return element;
	}

	public WebElement requestLabelContinueButton() {
		WebElement element =  driveR.findElement(By.id("" + env + ":id/inner_button"));
		return element;
	}

	public WebElement requestLabelStack() {
		WebElement element = driveR.findElement(By.id("" + env + ":id/stack_name"));
		return element;
	}

	public WebElement requestLabelType() {
		WebElement element =  driveR.findElement(By.id("" + env + ":id/check_issue_checkbox"));
		return element;
	}

	public WebElement requestLabelAddQuantity() {
		WebElement element = driveR.findElement(By.id("" + env + ":id/label_add_button"));
		return element;
	}

	// Verification
	public WebElement verificationExpandExceptionPanel() {
		WebElement element = driveR.findElement(By.id("" + env + ":id/expand_panel_arrow"));
		return element;
	}

	public WebElement verificationEditTextBox() {
		WebElement element = driveR.findElement(By.id("" + env + ":id/edit_text_price_check"));
		return element;
	}

	public void verificationExceptionCheckBox() {
		driveR.findElement(By.id("" + env + ":id/check_issue_checkbox"));
	}

	public WebElement verificationVerifyButton() {
		WebElement element = driveR.findElement(By.id("" + env + ":id/inner_button"));
		return element;
	}



	public WebElement verificationCloseButton() {
		WebElement element = driveR.findElement(By.id("" + env + ":id/inner_button"));
		return element;
	}

	public WebElement verificationSubmitButton() {
		WebElement element = driveR.findElement(By.id("" + env + ":id/inner_button"));

		return element;
	}

	public WebElement verificationSaveButton() {
		WebElement element =  driveR.findElement(By.id("" + env + ":id/inner_button"));
		return element;
	}

	public WebElement verificationExceptionDescription() {
		WebElement element = driveR.findElement(By.id("" + env + ":id/comment_text_input_edit"));
		return element;
	}

	public WebElement verificationExceptionStatus() {
		WebElement element = driveR.findElement(By.id("" + env + ":id/exception_status_indicator"));
		return element;
	}

	public void selectExceptionCheckBoxInVerification(String exceptionName) {

		switch (exceptionName) {

		case "Operator Error":
			verificationOperatorErrorException().click();
			break;
		case "Incorrect Promotion":
			verificationIncorrectPromotionException().click();
			break;
		case "Flash Marked":
			verificationFlashMarkedException().click();
			break;
		case "4 Point Check Error":

			verification4PointCheckErrorException().click();
			break;
		case "Missing Label":
			verificationMissingLabelException().click();
			break;

		case "Gap":
			verificationGapException().click();
			break;
		case "Incorrect Unit Price":
			verificationIncorrectUnitPriceException().click();
			break;
		case "Variant":
			verificationVariantException().click();
			break;
		case "Other":
			verificationOtherException().click();
			break;

		default:
			break;
		}
	}

	public void checkExceptionCheckBoxInVerification(String exceptionName) {

		switch (exceptionName) {

		case "Operator Error":
			verificationOperatorErrorException().isDisplayed();
			break;
		case "Incorrect Promotion":
			verificationIncorrectPromotionException().isDisplayed();
			break;
		case "Flash Marked":
			verificationFlashMarkedException().isDisplayed();
			break;
		case "4 Point Check Error":

			verification4PointCheckErrorException().isDisplayed();
			break;
		case "Missing Label":
			verificationMissingLabelException().isDisplayed();
			break;

		case "Gap":
			verificationGapException().isDisplayed();
			break;
		case "Incorrect Unit Price":
			verificationIncorrectUnitPriceException().isDisplayed();
			break;
		case "Variant":
			verificationVariantException().isDisplayed();
			break;
		case "Other":
			verificationOtherException().isDisplayed();
			break;
		case "Incorrect Country of Origin":
			verificationIncorrectCountryOfOriginException().isDisplayed();
			break;
		default:
			break;
		}
	}

	public void selectExceptionCheckBoxInWorkload(String exceptionName) throws Throwable {

		switch (exceptionName) {

		case "Gap":
			workloadGapException().click();
			break;
		case "Product Not Found":
			workloadProductNotFoundException().click();
			break;
		case "Wrong Label Size":
			workloadWrongLabelSizeException().click();
			break;
		case "Incorrect Price":
			workloadIncorrectPriceException().click();
			break;
		case "Incorrect Promotion":
			workloadIncorrectPromotionException().click();
			break;
		case "Flash Marked":
			workloadFlashMarkedException().click();
			break;
		case "Not As Advertised":
			workloadNotAsAdvertisedException().click();
			break;
		case "Incorrect Description":
			workloadIncorrectDescriptionException().click();
			break;
		case "Incorrect Unit Price":
			workloadIncorrectUnitPriceException().click();
			break;
		case "Other":
			workloadOtherException().click();
			break;
		case "Incorrect Country of Origin":
			workloadIncorrectCountryOfOriginException().click();
			break;
		default:
			break;
		}
	}

	public void checkExceptionCheckBoxInWorkload(String exceptionName) throws Throwable {

		switch (exceptionName) {

		case "Gap":
			workloadGapException().isDisplayed();
			break;
		case "Product Not Found":
			workloadProductNotFoundException().isDisplayed();
			break;
		case "Wrong Label Size":
			workloadWrongLabelSizeException().isDisplayed();
			break;
		case "Incorrect Price":
			workloadIncorrectPriceException().isDisplayed();
			break;
		case "Incorrect Promotion":
			workloadIncorrectPromotionException().isDisplayed();
			break;
		case "Flash Marked":
			workloadFlashMarkedException().isDisplayed();
			break;
		case "Not As Advertised":
			workloadNotAsAdvertisedException().isDisplayed();
			break;
		case "Incorrect Description":
			workloadIncorrectDescriptionException().isDisplayed();
			break;
		case "Incorrect Unit Price":
			workloadIncorrectUnitPriceException().isDisplayed();
			break;
		case "Other":
			workloadOtherException().isDisplayed();
			break;

		case "Incorrect Country of Origin":
			workloadIncorrectCountryOfOriginException().isDisplayed();
			break;
		default:
			break;
		}

	}


	public boolean isItemPresent() {
		boolean itemPresent = false;
		try {

			int i = driveR.findElements(By.id("" + env + ":id/product_name")).size();
			if (i > 0) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return itemPresent;
	}

	public boolean isItemDescriptionDisplayed() {

		boolean itmDescription = false;
		try {
			int i = driveR.findElements(By.id("" + env + ":id/description")).size();
			if (i > 0) {
				return true;
			}

		} catch (Exception e) {
			return false;
		}
		return itmDescription;
	}

	public void selectMultipleOptions() {

		String xpathInit = "//android.widget.LinearLayout[@index=";
		String xpathEnd = "]/android.widget.LinearLayout/android.widget.CheckBox";
		for (int i = 1; i < 3; i++) {

			driveR.findElement(By.xpath(xpathInit + i + xpathEnd)).click();
		}
	}
}
