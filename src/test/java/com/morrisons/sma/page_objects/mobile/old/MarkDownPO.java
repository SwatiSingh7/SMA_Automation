package com.morrisons.sma.page_objects.mobile.old;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import com.morrisons.sma.page_objects.service.MarkdownServicePages;
import com.morrisons.common.action.Hook;
import com.morrisons.sma.step_definitions.mobile.old.MarkdownStepDef;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;

public class MarkDownPO {

	public static String discountedPrice;
	public static String firstMDPriceEmployee = "£0.10";

	public String firstMarkDownBarcode;
	public static String BCode;
	public static String newPrice;
	public static String qtyApp;
	public static String oldPrice;

	MarkdownStepDef markDownBarcode = new MarkdownStepDef();

	private static AndroidDriver driveR;

	// private AndroidDriver<WebElement> driveRList;
	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
	String env = applicationConfig.getWebElementEnviroment().getEnv();
	static String env1 = applicationConfig.getWebElementEnviroment().getEnv();

	String markDown = "markdowns";
	String scanMarkDown = "view_scan_markdown";
	String noPrinterAvailable = "text_no_printer_available";
	String resourceID = "com.morrisons.instore.sit:id/category_name";
	String resourceID1 = "com.morrisons.instore.sit:id/category_list";
	String className = "android.widget.TextView";
	String className1 = "android.support.v7.widget.RecyclerView";


	String colleagueUsername = applicationConfig.getUserCredentials().getCollegueUsername();
	String colleaguePassword = applicationConfig.getUserCredentials().getColleguePassword();
	String managerUsername = applicationConfig.getUserCredentials().getManagerUsername();
	String managerPassword = applicationConfig.getUserCredentials().getManagerPassword();
	
	public static String crispDept = applicationConfig.getCleanAndRotateTestData().getCrispDepartment();
	public static String crispItem[] = applicationConfig.getCleanAndRotateTestData().getCrispItems();
	public static String nonCrispDept = applicationConfig.getCleanAndRotateTestData().getnonCrispDepartment();
	public static String nonCrispItem[] = applicationConfig.getCleanAndRotateTestData().getNonCrispItems();


	public static String originalPriceOnUI = null;
	public static String newPriceOnUI =  null;
	public static String calculatedPriceManager = null;
	public static String lastMarkdownPrice = null;
	public static String calculatedPriceUI =  null;


	public static Map<String,String> percentageListUI = new TreeMap<String,String>();

	public MarkDownPO() {
		this.driveR = (AndroidDriver) Hook.getDriver();
	}

	public static void scanBarcode(String barcode) {

		String packageName = "com.morrions.instore.MockBarcodeReadEvent";
		String command = "adb shell am broadcast -a " + packageName + " -e BARCODE " + barcode;
		try {
			Runtime.getRuntime().exec(command);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}


	public void setFirstMarkdownValue(String markdownValue) {
		this.firstMarkDownBarcode = markdownValue;
	}

	public static void useFirstMarkdownValue(String markdownBarcodeTest) {

		BCode = markdownBarcodeTest;
		System.out.println("New Barcode = " + BCode);
	}

	public void usernamePasswrod(String userName, String password) throws Throwable {


		String xpathUserName = "//android.widget.EditText[@resource-id='" + env + ":id/username']";
		String xpathPwd = "//android.widget.EditText[@resource-id='" + env + ":id/password']";

		driveR.findElement(By.xpath(xpathUserName)).clear();

		driveR.findElement(By.xpath(xpathUserName)).sendKeys(userName);

		driveR.findElement(By.xpath(xpathPwd)).clear();
		driveR.findElement(By.xpath(xpathPwd)).sendKeys(password);

	}

	public void clickLogin() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.Button[@resource-id='" + env + ":id/inner_button']")).click();
		// driveR.findElement(By.xpath("//android.widget.Button[@resource-id='"env":id/inner_button']")).click();
	}

	public void clickMarkDown() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/" + markDown + "']"))
		.click();
	}

	public void clickscanMarkdown() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/" + scanMarkDown + "']"))
		.click();
	}

	public void clicksnoPrinterAvailabel() throws Throwable {

		driveR.findElement(
				By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/" + noPrinterAvailable + "']"))
		.click();
		
		Thread.sleep(3000);
	}

	public void department(List<String> dep) throws Throwable {
		for (String dept : dep) {
			System.out.println("check dep: " + dept);
		}
		boolean isPresent = false;
		for (String dept : dep) {

			isPresent = driveR.findElement(By.xpath("//android.widget.TextView[@text='" + dept + "']")).isDisplayed();

		}

	}

	public void departmentt(String dep) throws Throwable {
		//		for (String dept : dep) {
		//			System.out.println("check dep: " + dept);
		//		}
		//		boolean isPresent = false;
		//		for (String dept : dep) {
		//
		//			isPresent = driveR.findElement(By.xpath("//android.widget.TextView[contains(@text, '"+dep+"')]")).isDisplayed();
		//			
		//		}
		// Thread.sleep(300);
		// driveR.findElement(By.xpath("//android.widget.TextView[contains(text(),
		// '"+dep+"')]")).isDisplayed();
		// driveR.findElement(By.xpath("//android.widget.TextView[contains(text(),
		// '"+dep+"')]")).click();

	}

	public void validatecategory(List<String> cate) throws Throwable {

		for (String category : cate) {
			System.out.println("check catagory: " + category);
		}
		boolean isPresent = false;
		for (String category : cate) {

			isPresent = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+category+"']")).isDisplayed();

		}

	}

	public void Department(String dep) throws Throwable {
		{

			System.out.println("department In ----" + dep);
			Thread.sleep(6000);
			driveR.findElement(By.xpath("//android.widget.TextView[contains(@text,'" + dep + "')]")).click();

		}

	}

	/*
	 * public void catagory(List<String> catagory) throws Throwable { for(String
	 * catagoryy:catagory) { System.out.println("check catagory: "+catagory); }
	 * boolean isPresent = false; for(String catagoryy:catagory) {
	 * 
	 * 
	 * isPresent = driveR.findElement( By.
	 * xpath("//android.widget.TextView[@resource-id='\"+env+\":id/category_name' and @text='\"+catagory+\"']"
	 * )).isDisplayed();
	 * 
	 * }
	 * 
	 * }
	 */

	public void clickHotKeyMainMenu() throws Throwable {

		/*
		 * driveR.findElement(
		 * By.xpath("//android.widget.TextView[@resource-id='"+env+":id/"+
		 * noPrinterAvailable+"']")).click();
		 */

		System.out.println("I am in Hot Key Menu");

		try {

			Boolean hotKey = driveR
					.findElement(By.xpath(
							"//android.widget.TextView[@resource-id='" + env + ":id/context_menu']"))
					.isDisplayed();

			if (hotKey = true) {

				driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/context_menu']"))
				.click();
				driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/title']")).click();

			} else {
				pause();
				driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/context_menu']"))
				.click();
				driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/title']")).click();
			}

		} catch (Exception e) {
			driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/title']")).click();

		}

		/*
		 * driveR.findElement(By.xpath(
		 * "//android.widget.TextView[@resource-id='com.morrisons.instore.uat:id/context_menu']"
		 * )).isDisplayed(); driveR.findElement(By.xpath(
		 * "//android.widget.TextView[@resource-id='com.morrisons.instore.uat:id/context_menu']"
		 * )).click(); driveR.findElement(By.xpath(
		 * "//android.widget.TextView[@resource-id='" + env +
		 * ":id/context_menu']")).click(); //driveR.findElement(By.xpath(
		 * "//android.widget.TextView[@resource-id='" + env + ":id/title']")).click();
		 * driveR.findElement(By.
		 * xpath("//android.widget.TextView[@text='Main Menu']")). click();
		 */

	}

	public void clickLogoutButton() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Open drawer']")).click();
		driveR.findElement(By.xpath("//android.widget.Button[@text='LOG OUT' or @text='Log Out']")).click();
		driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();

	}

	public void clickPrinterEntery() throws Throwable {

		Thread.sleep(3000);
		WebElement oEle = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/action_barcode_entry']"));
		com.morrisons.common.helper.ElementRetry.waitForElementVisible(driveR,oEle);
		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/action_barcode_entry']"))
		.click();

	}

	public void enterBarcode(String barcode) throws Throwable {

     try{
		driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/action_barcode_entry' or @resource-id='" + env + ":id/barcode_entry_edit_text']"))
		.sendKeys(barcode);


		Thread.sleep(2000);

		driveR.executeScript("mobile:performEditorAction", ImmutableMap.of("action","search"));

		Thread.sleep(3000);

		//====================================
		 int c=0;
		 do{
		 try {
			 if (driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/action_barcode_entry' or @resource-id='" + env + ":id/barcode_entry_edit_text']")).isDisplayed()) {
				 driveR.executeScript("mobile:performEditorAction", ImmutableMap.of("action", "search"));
				 Thread.sleep(2000);
			 }
			 else {
				 break;
			 }
		 }
		 catch(NoSuchElementException o){
			 break;
		 }
		 catch(Exception w){

		 }
		 c++;
	 }while(c<3);
		 //======================================


		//				driveR.findElement(By.xpath("//android.widget.ImageButton[@resource-id='" + env + ":id/camera_scan_fab']")).click();
		//		
		//		
		//				new TouchAction((AppiumDriver) driveR).press(PointOption.point(715, 1278)).release().perform();
		//
		 //				Thread.sleep(3000);

	 } catch (WebDriverException r) {
		 int ctr=0;
		 driveR.executeScript("mobile:performEditorAction", ImmutableMap.of("action", "search"));
		 Thread.sleep(2000);
		 do{
			 try {
				 if (driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/action_barcode_entry' or @resource-id='" + env + ":id/barcode_entry_edit_text']")).isDisplayed()) {
					 driveR.executeScript("mobile:performEditorAction", ImmutableMap.of("action", "search"));
					 Thread.sleep(2000);
				 } else {
					 break;
				 }
			 }
			 catch(NoSuchElementException o){
				 break;
			 }
			 catch(Exception w){

				 }
			 ctr++;
		 }while(ctr<3);
	 }
	 catch(Exception q){

	 }
	}

	public void enterBarcodeNumber(String barcode) throws Throwable {

		Thread.sleep(3000);

		driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/action_barcode_entry' or @resource-id='" + env + ":id/barcode_entry_edit_text']"))
		.sendKeys(barcode);

		Thread.sleep(3000);
	}

	public void enterProductMinValue(String barcode) throws Throwable {

		Thread.sleep(3000);

		driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/action_barcode_entry' or @resource-id='" + env + ":id/barcode_entry_edit_text']"))
		.sendKeys(barcode);
		Thread.sleep(3000);

		driveR.executeScript("mobile:performEditorAction", ImmutableMap.of("com/morrisons/common/action","search"));

		Thread.sleep(5000);
	}

	public void verifyTheLatestScanMINNumber(String args1) throws Throwable {
		Thread.sleep(3000);

		List<AndroidElement> xpathMINNumber = driveR.findElements(
				MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/list_item_min']"));

		if(xpathMINNumber.get(0).isDisplayed())
		{
			String actualMINNumber = xpathMINNumber.get(0).getText().trim();
			System.out.println(actualMINNumber);

			assertEquals(actualMINNumber, args1, "Latest scanned item is not visible at the top");
		}
	}


	public void verifyScannedItemAction(String expectedAction) throws Throwable {
		WebElement xpathActionText = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/list_item_quantity_value']"));

		String atualAction = xpathActionText.getText().replaceAll("\\d", "").trim();

		assertEquals(atualAction, expectedAction,"Scanned item com.morrisons.common.action is mismatched");
	}



	public void enterPriceEmbeddedBarcode(String barcode) throws Throwable {

		barcode = barcode.substring(0,barcode.length()-4) + "2000";

		Thread.sleep(3000);
		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/action_barcode_entry']"))
		.sendKeys(barcode);

		new TouchAction((AppiumDriver) driveR).press(PointOption.point(715, 1278)).release().perform();
	}	

	public void printerError() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/alertTitle']"))
		.isDisplayed();
		driveR.findElement(By.xpath("//android.widget.Button[@text='OK' or @text='Ok']")).click();

	}

	public void selectCategory(String arg1) throws Throwable {
		Thread.sleep(3000);
		driveR.findElement(By.xpath("//android.widget.TextView[@text='" + arg1 + "']")).click();

		/*
		 * Boolean sectionInProgress = driveR.findElement(By.xpath(
		 * "//android.widget.TextView[@text='This section is in progress. Are you sure you want to continue?']"
		 * )) .isDisplayed();
		 * 
		 * if (sectionInProgress = true) {
		 * driveR.findElement(By.xpath("//android.widget.Button[@text='Yes']")).
		 * click(); } else{ System.out.println("do nothing"); }
		 */

		try

		{

			Boolean sectionInProgress = driveR.findElement(By.xpath(
					"//android.widget.TextView[@text='This section is in progress. Are you sure you want to continue?']"))
					.isDisplayed();

			if (sectionInProgress = true) {
				driveR.findElement(By.xpath("//android.widget.Button[@text='Yes' or @text='YES']")).click();
			} else {
				System.out.println("do nothing");
			}

		} catch (Exception e) {

			System.out.println("do nothing");

		}
		Thread.sleep(4000);
	}

	public void enterMarkDownQuantity(String qty) throws Throwable {

		WebElement xpathQuantity =  driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/markdown_quantity']"));
		xpathQuantity.isDisplayed();
		xpathQuantity.clear();
		xpathQuantity.sendKeys(qty);
		try{
		driveR.hideKeyboard();
		}
		catch(Exception e){}

		/*
		 * Boolean value1 = driveR .findElement(By.xpath(
		 * "//android.widget.TextView[@text='Are you sure you wish to mark down " + qty
		 * + " products?']")) .isDisplayed(); System.out.println("---------------------"
		 * + value1);
		 * 
		 * if (value1 = true) {
		 * 
		 * driveR.findElement(By.xpath( "//android.widget.Button[@text='Confirm']")).
		 * click();
		 * 
		 * } else {
		 * 
		 * 
		 * driveR.hideKeyboard();
		 * 
		 * }
		 */

		//		try
		//
		//		{
		//
		//			Boolean value2 = driveR.findElement(By.xpath(
		//					"//android.widget.TextView[@text='Are you sure you wish to mark down " + qty + " products?']"))
		//					.isDisplayed();
		//
		//			if (value2 = true) {
		//
		//				driveR.findElement(By.xpath("//android.widget.Button[@text='Confirm' or @text='CONFIRM']")).click();
		//
		//			} else {
		//
		//				driveR.hideKeyboard();
		//
		//			}
		//
		//		} catch (Exception e) {
		//
		//			driveR.hideKeyboard();
		//
		//		}

	}

	public void clickGetPrice() throws Throwable {

		/*
		 * driveR.findElement(By. xpath("//android.widget.Button[@text='GET PRICE']")).
		 * isDisplayed(); driveR.findElement(By.
		 * xpath("//android.widget.Button[@text='GET PRICE']")). click();*/
		try{
		driveR.hideKeyboard();
		} catch (Exception e) {}
		
		try{
			driveR.findElement(By.xpath("//android.widget.Button[@text='CONFIRM' or @text='Confirm']")).click();
			} catch (Exception e) {}



		try {
			Boolean getPrice = driveR.findElement(By.xpath("//android.widget.Button[@text='GET PRICE' or @text='Get Price']")).isDisplayed();

			if (getPrice = true) {
				driveR.findElement(By.xpath("//android.widget.Button[@text='GET PRICE' or @text='Get Price']")).click();
				driveR.hideKeyboard();
			} else {
				driveR.findElement(By.xpath("//android.widget.Button[@text='SAVE CHANGES' or @text='Save Changes']")).click();
			}

		} catch (Exception e) {
			//driveR.findElement(By.xpath("//android.widget.Button[@text='SAVE CHANGES' or @text='Save Changes']")).click();
		}

	}

	public void clickonPrintQueue() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.Button[@text='ADD TO PRINT QUEUE' or @text='Add To Print Queue']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.Button[@text='ADD TO PRINT QUEUE' or @text='Add To Print Queue']")).click();

	}

	public void verifyAddToPrintQueue() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.Button[@text='ADD TO PRINT QUEUE' or @text='Add To Print Queue']")).isDisplayed();

	}

	public void clickonPrintQueueEmployee() throws Throwable {

		
		Thread.sleep(3000);
		driveR.findElement(By.xpath("//android.widget.Button[@text='ADD TO PRINT QUEUE' or @text='Add To Print Queue' or @text='SAVE CHANGES' or @text='Save Changes']")).click();
		

	}

	public void clickPrintListIcon() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/action_print']"))
		.isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/action_print']")).click();
	}

	public void verifyBarcode(String qty) {
		WebElement elements = driveR.findElement(By.id("" + env + ":id/markdown_list_item_min"));
		System.out.println("MIN list = " + elements.getText());
		String Qty = qty;
		assertEquals(Qty, elements.getText(), " Product details requested doesn't exist. Response code");
	}

	public void pause() throws Throwable {
		driveR.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public void recordOutOfCode() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/ooc_add_button_enable']"))
		.isDisplayed();

	}

	public void clickRecordOutOfCode() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/ooc_add_button_enable']"))
		.click();

		Dimension size = driveR.manage().window().getSize();
		int starty = (int) (size.height * 0.80);
		int endy = (int) (size.height * 0.20);
		int startx = size.width / 2;
		//		driveR.swipe(startx, starty, startx, endy, 3000);

	}

	public void recordOutOfCodeexpiryDate() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.TextView[@text='Expiry Date' or @text='EXPIRY DATE']")).isDisplayed();

	}

	public void recordOutOfCodeexpiryQuantity() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.TextView[@text='Expiry Quantity' or @text='EXPIRY QUANTITY']")).isDisplayed();

	}

	public void recordOutOfCodeselectexpirydate() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/outofcode_date']"))
		.isDisplayed();
		driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/outofcode_date']")).click();

		driveR.findElement(By.xpath("//android.widget.Button[@text='Done' or @text='DONE']")).isDisplayed();

		driveR.findElement(By.xpath("//android.widget.Button[@text='Done' or @text='DONE']")).click();

	}

	public void recordOutOfCodeselectquantity() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/outofcode_quantity']"))
		.isDisplayed();
		driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/outofcode_quantity']"))
		.sendKeys("2");

	}

	public void addtoPrintQueueAndRecordOutofCodeButton() throws Throwable {

		/*
		 * driveR.findElement(By.
		 * xpath("//android.widget.Button[@text='ADD TO PRINT QUEUE AND RECORD OUT OF CODE']"
		 * )) .isDisplayed(); driveR.findElement(By.
		 * xpath("//android.widget.Button[@text='ADD TO PRINT QUEUE AND RECORD OUT OF CODE']"
		 * )).isEnabled();
		 */

		driveR.findElement(By.xpath("//android.widget.Button[@resource-id='" + env + ":id/inner_button']"))
		.isDisplayed();

		driveR.findElement(By.xpath("//android.widget.Button[@resource-id='" + env + ":id/inner_button']")).isEnabled();

	}

	public void clickaddtoPrintQueueAndRecordOutofCodeButton() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.Button[@resource-id='" + env + ":id/inner_button']"))
		.isDisplayed();
		driveR.findElement(By.xpath("//android.widget.Button[@resource-id='" + env + ":id/inner_button']")).click();

	}

	// public void selectDiscountDropdown(String visibleText) throws Throwable {
	public void selectDiscountDropdown() throws Throwable {
		driveR.findElement(By.xpath("//android.widget.TextView[@text='Calculated' or @text='CALCULATED']")).isDisplayed();
		/*
		 * driveR.findElement(By.xpath(
		 * "//android.widget.TextView[@text='Calculated']")) .click();
		 */

		// System.out.println();
		// driveR.findElementByAndroidUIAutomator("new UiScrollable(new
		// UiSelector().scrollable(true).instance(0)).scrollIntoView(new
		// UiSelector().textContains(\""+visibleText+"\").instance(0))").click();

	}

	public void clickOnscannedBarcode(String barcode) throws Throwable {
		driveR.findElement(By.xpath("//android.widget.TextView[@text='" + barcode + "']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[@text='" + barcode + "']")).click();

	}

	public void getDiscountedPrice() throws Throwable {
		discountedPrice = driveR
				.findElement(
						By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/markdown_price_editable']"))
				.getText();
		System.out.println("value of discounted price is ------------" + discountedPrice);

	}

	public void getfirstMDPriceEmployee() throws Throwable {
		pause();
		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/markdown_price_fixed']"))
		.isDisplayed();
		firstMDPriceEmployee = driveR
				.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/markdown_price_fixed']"))
				.getText();
		System.out.println("value of First MD Price ------------" + firstMDPriceEmployee);

	}

	public void clickOnPrint() throws Throwable {
		driveR.findElement(By.xpath("//android.widget.Button[@resource-id='" + env + ":id/inner_button']")).click();

	}

	public void firstmardownBarcode() throws Throwable {
		System.out.println("---IN FirstMarkdown Barcode Entery Method");
		System.out.println("---IN FirstMarkdown Barcode Entery Method" + BCode);

		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/action_barcode_entry']"))
		.sendKeys(BCode);
		new TouchAction((AppiumDriver) driveR).press(PointOption.point(715, 1278)).release().perform();
	}

	public void compareFirstAndSecondMarkdown() throws Throwable {

		/*
		 * String secondmarkDownPrice = driveR .findElement(
		 * By.xpath("//android.widget.EditText[@resource-id='" + env +
		 * ":id/markdown_price_editable']")) .getText();
		 */

		String econdmarkDownPrice = "$3.6";
		// String discountedPrice = "$2.6";

		Float FM = Float.valueOf(firstMDPriceEmployee.replace("£", ""));
		Float SM = Float.valueOf(discountedPrice.replace("£", ""));

		System.out.println("Second Markdown :::: " + SM);
		System.out.println("First Markdown  :::  " + FM);

		assertTrue("First MarkDown (" + FM + ") should be greater than SecondMarkdwon (" + SM + ")", FM > SM);

	}

	/*
	 * public void scrollTo() { driveR.
	 * findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"95%\").instance(0))"
	 * ); }
	 */

	public void checkPopUpDisplayed() throws InterruptedException {

		driveR.findElement(By.id("android:id/message")).click();
		Thread.sleep(2000);

		if (driveR.findElement(By.id("android:id/message")).isDisplayed()) {

			System.out.println("PopUp is Displayed !!");
		} else {
			assertEquals(100, 120, " PopUp not displayed");

		}

	}

	public void clickYesButton() throws InterruptedException {
		driveR.findElement(By.id("android:id/button1")).click();

		Thread.sleep(2000);

	}

	public void clickNoButton() throws InterruptedException {
		driveR.findElement(By.id("android:id/button2")).click();

		Thread.sleep(2000);

	}

	public void selectHotKey() throws InterruptedException {
		driveR.findElement(By.id("" + env + ":id/context_menu")).click();
		Thread.sleep(5000);
		// com.morrisons.instore.uat:id/context_menu
		driveR.findElement(By.id("" + env + ":id/title")).click();
		Thread.sleep(2000);
		driveR.findElement(By.className("android.widget.ImageButton")).click();
		Thread.sleep(2000);
		driveR.findElement(By.id(""+env+":id/inner_button")).click();
		Thread.sleep(2000);
		driveR.findElement(By.id("android:id/button1")).click();
		Thread.sleep(2000);
		driveR.closeApp();
		driveR.quit();

	}

	public void selectrinterOption() throws InterruptedException {

		driveR.findElement(By.id(""+env+":id/action_change_printer")).click();
		Thread.sleep(5000);
	}

	public void printerSelection(String Barcode) throws InterruptedException {

		driveR.findElement(By.id(""+env+":id/action_barcode_entry")).click();
		Thread.sleep(2000);
		driveR.findElement(By.id(""+env+":id/barcode_entry_edit_text")).click();
		Thread.sleep(2000);
		driveR.findElement(By.id(""+env+":id/barcode_entry_edit_text")).sendKeys(Barcode);
		Thread.sleep(2000);
		new TouchAction((AppiumDriver) driveR).press(PointOption.point(715, 1278)).release().perform();
	}

	public void clickOnPrintList() throws InterruptedException {
		Thread.sleep(2000);
		driveR.findElement(
				By.xpath("//android.widget.TextView[@resource-id='"+env+":id/action_print']"))
		.click();
		Thread.sleep(2000);
		driveR.findElement(
				By.xpath("//android.widget.TextView[@resource-id='"+env+":id/action_barcode_entry']"))
		.click();
		Thread.sleep(2000);

	}

	public void invalidBarcode(String barcode) throws InterruptedException {
		Thread.sleep(2000);
		driveR.findElement(By.xpath(
				"//android.widget.EditText[@resource-id='"+env+":id/barcode_entry_edit_text']"))
		.click();
		Thread.sleep(2000);
		driveR.findElement(By.xpath(
				"//android.widget.EditText[@resource-id='"+env+":id/barcode_entry_edit_text']"))
		.sendKeys(barcode);
		;
		Thread.sleep(2000);
		new TouchAction((AppiumDriver) driveR).press(PointOption.point(715, 1278)).release().perform();
	}

	public void errorBarcodeMsg() throws InterruptedException {
		Thread.sleep(2000);
		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']")).isDisplayed();
		Thread.sleep(2000);
		String message = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']"))
				.getText();
		Thread.sleep(2000);
		assertEquals(message, "Make sure you are scanning a valid product barcode and try again",
				"Incorrect Msg Displayed!!");
		Thread.sleep(2000);
		driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();
		Thread.sleep(2000);
	}

	public void selectBarcode(String barcode) throws InterruptedException {
		Thread.sleep(2000);
		driveR.findElement(By.xpath("//android.widget.TextView[@text=' + barcode + ']")).click();
		Thread.sleep(2000);

	}

	public void fieldClickable() throws InterruptedException {
		Thread.sleep(2000);
		Boolean status = driveR
				.findElement(By.xpath(
						"//android.widget.EditText[@resource-id='"+env+":id/markdown_quantity']"))
				.isEnabled();
		Thread.sleep(2000);
		System.out.println(status);
		// assertEquals(status, "true");
		Boolean statusprice = driveR
				.findElement(By.xpath(
						"//android.widget.TextView[@resource-id='"+env+":id/markdown_price_fixed']"))
				.isEnabled();
		Thread.sleep(2000);
		System.out.println(statusprice);
	}

	public void roleVerify(String roles, String versionNum) throws InterruptedException {
		Thread.sleep(5000);
		driveR.findElement(By.className("android.widget.ImageButton")).click();
		Thread.sleep(2000);
		String role = driveR
				.findElement(
						By.xpath("//android.widget.TextView[@resource-id='"+env+":id/accountName']"))
				.getText();
		assertEquals(role, roles, "Role mismatched!!");
		Thread.sleep(2000);
		String version = driveR
				.findElement(
						By.xpath("//android.widget.TextView[@resource-id='"+env+":id/versionName']"))
				.getText();
		assertEquals(version, versionNum, "Version mismatched!!");
		Thread.sleep(2000);
		System.out.println("Role and Version verified");
		Thread.sleep(3000);
		driveR.findElement(By.className("android.widget.ImageButton")).click();
		Thread.sleep(3000);
	}

	public void enterQty(String qty) throws InterruptedException {
		String appqty = qty;
		Thread.sleep(4000);
		driveR.findElement(
				By.xpath("//android.widget.EditText[@resource-id='"+env+":id/markdown_quantity']"))
		.click();
		Thread.sleep(2000);
		driveR.findElement(
				By.xpath("//android.widget.EditText[@resource-id='"+env+":id/markdown_quantity']"))
		.sendKeys(qty);
		Thread.sleep(2000);
		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']")).isDisplayed();
		String message = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']"))
				.getText();
		assertEquals(message, "Are you sure you wish to mark down " + qty + " products?", "Version mismatched!!");
		System.out.println("Popup alert message = " + message);
		Thread.sleep(2000);
		driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();
		Thread.sleep(2000);

	}

	public static void prdtDetails() throws InterruptedException {

		Thread.sleep(3000);
		driveR.findElement(By.xpath(
				"//android.widget.TextView[@resource-id='"+env1+":id/markdown_list_item_description']"))
		.click();
		Thread.sleep(2000);
		newPrice = driveR
				.findElement(By.xpath(
						"//android.widget.TextView[@resource-id='"+env1+":id/markdown_price_fixed']"))
				.getText();
		Thread.sleep(2000);
		qtyApp = driveR
				.findElement(By.xpath(
						"//android.widget.EditText[@resource-id='"+env1+":id/markdown_quantity']"))
				.getText();

		MarkdownStepDef.getPrdtdetails(newPrice, qtyApp);

		Thread.sleep(2000);
		driveR.findElement(By.className("android.widget.ImageButton")).click();
		Thread.sleep(2000);

	}

	public void changeQty() throws InterruptedException {
		Thread.sleep(3000);
		driveR.findElement(By.xpath(
				"//android.widget.TextView[@resource-id='"+env+":id/markdown_list_item_description']"))
		.click();
		Thread.sleep(2000);

		driveR.findElement(
				By.xpath("//android.widget.EditText[@resource-id='"+env+":id/markdown_quantity']"))
		.click();
		Thread.sleep(2000);
		driveR.findElement(
				By.xpath("//android.widget.EditText[@resource-id='"+env+":id/markdown_quantity']"))
		.clear();
		Thread.sleep(2000);
		driveR.findElement(
				By.xpath("//android.widget.EditText[@resource-id='"+env+":id/markdown_quantity']"))
		.sendKeys("16");
		Thread.sleep(2000);

		driveR.findElement(
				By.xpath("//android.widget.Button[@resource-id='"+env+":id/inner_button']")).click();
		Thread.sleep(2000);

	}

	public void deleteRecord(String barcode) throws InterruptedException {

		driveR.findElement(
				By.xpath("//android.widget.TextView[@resource-id='"+env+":id/action_edit']")).click();
		Thread.sleep(3000);
		driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + barcode + "']")).click();
		Thread.sleep(2000);
		driveR.findElement(By
				.xpath("//android.widget.TextView[@resource-id='"+env+":id/action_change_printer']"))
		.click();
		Thread.sleep(2000);
		driveR.findElement(By.xpath(
				"//android.widget.ImageView[@resource-id='"+env+":id/action_mode_close_button']"))
		.click();

	}

	public void verifyPrintListDetails() throws InterruptedException {
		WebElement xpathItemDescription = driveR.findElement(By.xpath(
				"//android.widget.TextView[@resource-id='"+env+":id/markdown_list_item_description']"));

		xpathItemDescription.isDisplayed();

		WebElement xpathItemMin = driveR.findElement(By.xpath(
				"//android.widget.TextView[@resource-id='"+env+":id/markdown_list_item_min']"));

		xpathItemMin.isDisplayed();

		WebElement xpathItemQuantity = driveR.findElement(By.xpath(
				"//android.widget.TextView[@resource-id='"+env+":id/markdown_list_item_quantity']"));

		xpathItemQuantity.isDisplayed();

	}

	public void clickOnCompleteMarkdown() throws InterruptedException {

		WebElement xpathCompleteMarkdown = driveR.findElement(By.xpath(
				"//android.widget.TextView[@text='Complete markdown for Bakery']"));

		xpathCompleteMarkdown.isDisplayed();

		xpathCompleteMarkdown.click();
	}

	public void editNewPrice() throws InterruptedException {

		Thread.sleep(2000);
		WebElement a = driveR.findElement(By.xpath(
				"//android.widget.EditText[@resource-id='"+env+":id/markdown_price_editable']"));
		boolean checkField = a.isSelected();

		assertEquals(checkField, false, "Field is editable !!");
		//			if (a.isSelected()==false){
		//				System.out.println("The field is not editable");
		//			}else{
		//				
		//			}

	}

	public void selectDropdownPercentage() throws Throwable {
		// driveR.findElement(By.xpath("//android.widget.TextView[@text='Calculated']")).isDisplayed();
		// driveR.findElement(By.xpath("//android.widget.TextView[@text='Calculated']")).click();

		// com.morrisons.instore.uat:id/markdown_percentage_container
		// android.widget.FrameLayout

		// com.morrisons.instore.uat:id/markdown_percentage_spinner
		// android.widget.Spinner

		Thread.sleep(2000);
		oldPrice = driveR.findElement(By.xpath(
				"//android.widget.EditText[@resource-id='"+env+":id/markdown_price_editable']"))
				.getText();
		MarkdownStepDef.getOldPrice(oldPrice);
		Thread.sleep(3000);
		driveR.findElement(By.className("android.widget.Spinner")).click();
		Thread.sleep(5000);

		//		
		// driveR.findElement(By.className("android.widget.CheckedTextView")).click();
		//		By.xpath("//div[.//a[text()='SELENIUM']]/ancestor::div[@class='rt-grid-2 rt-omega']/following-sibling::div"));
		// parent::div//following-sibling::div//mat-form-field"));

		// driveR.findElement(
		// By.xpath("//android.widget.Spinner[@resource-id='" + env
		// + ":id/markdown_percentage_spinner']")) .click();
		// Thread.sleep(10000);
		// By.xpath("//span[contains(text(),'
		// Status')]//parent::div//following-sibling::div//mat-form-field"));
		//
		// WebElement start = driveR.findElement(By.
		// xpath("//*[contains(@class,
		// 'android.widget.CheckedTextView')][contains(text(),'85%')]"
		// )); Point point = start.getLocation(); int startX = point.x; int endX
		// =
		// point.x;
		////
		// int startY = (int) ((driveR.manage().window().getSize().getWidth()) *
		// 0.80);
		// int endY = (int) ((driveR.manage().window().getSize().getWidth()) *
		// 0.20);
		//
		// TouchAction actions = new TouchAction(driveR); actions.press(startX,
		// startY).moveTo(endX,
		// endY).release().perform();
		////
		// List<WebElement> SpinnerList =
		// driveR.findElements(By.xpath("//android.widget.CheckedTextView"));
		// for
		// (WebElement e : SpinnerList) {
		//
		// System.out.println("spinner details: " + e.getText());
		//
		// } Thread.sleep(2000); SpinnerList.get(4).click();

		//
		// ((FindsByAndroidUIAutomator)
		// driveR).findElementByAndroidUIAutomator("new
		// UiSelector().text(\"85%\")").click();
		//
		////
		// //
		// driveR.findElement(By.className("android.widget.CheckedTextView")).click();
		// // MobileElement topCharts =
		// //
		// ((AndroidDriver<MobileElement>)driveR).findElementByAndroidUIAutomator("new
		// // UiSelector().text(\"80%\")");
		////
		//// //System.out.println("Element's Resource ID - " +
		// topCharts.getAttribute("resourceId"));
		//// topCharts.click();
		// /*
		// * WebDriverWait wait = new WebDriverWait(driveR, 20000);
		// * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		// * "//android.widget.TextView[@text='85%']")));
		// */
		//
		//// List<MobileElement> listView =
		// driveR.findElements(By.className("android.widget.CheckedTextView"));
		////
		//// /*
		//// * for (MobileElement e : listView) { System.out.println("List of
		// Ele: " +
		//// * e.getText()); System.out.println("List of eeeee: " +
		// e.getText());
		//// *
		//// *
		//// * if (e.getText().matches("85%")); e.click(); }
		//// */
		////
		//// for(int i=0; i<=listView.size(); i++) {
		//// if (i==3) {
		//// driveR.findElement(By.xpath("//*[contains(@class,
		// 'android.widget.CheckedTextView')][contains(text(),'85%')]")).click();
		//// }
		//// }

	}


	public void clickOnBackButton() throws Throwable {
		Thread.sleep(3000);
		WebElement xpathBackButton = driveR.findElement(By.className("android.widget.ImageButton"));
		xpathBackButton.isDisplayed();
		xpathBackButton.click();
		System.out.println("Click on back button");
	}

	public void verifyTheMINNumber(String args1) throws Throwable {
		Thread.sleep(3000);
		WebElement xpathMINNumber = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/list_item_min']"));

		if(xpathMINNumber.isDisplayed())
		{
			String actualMINNumber = xpathMINNumber.getText().trim();
			System.out.println(actualMINNumber);

			assertEquals(actualMINNumber, args1, "MIN value is mismatched");
		}
	}



	public void verifyViewListOfExpiringProducts() throws Throwable {

		WebElement xpathViewList = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/singleItemTitle']"));
		xpathViewList.isDisplayed();
		String viewList = xpathViewList.getText().replaceAll("[\\d|\\)|\\(]", "").trim();

		assertEquals(viewList, "View list of expiring products","View list of expiring products is not displayed");
	}

	public void clickOnViewList() throws Throwable {

		try{
			WebElement xpathViewList = driveR.findElement(By.xpath("//android.widget.ImageView[@resource-id='" + env + ":id/singleItemIcon']"));
			xpathViewList.isDisplayed();
			xpathViewList.click();
			System.out.println("Click on view list");
	}
	catch(Exception e){
		System.out.println("No view list - No products added");
	}
		}





	/////////
	///Rasika 

	public void verifyCalculatedPriceDisplayed() throws Throwable {
		WebElement xpathCalculatedText = driveR.findElement(By.xpath("//android.widget.TextView[@text='Calculated' or @text='CALCULATED']"));
		xpathCalculatedText.isDisplayed();

		WebElement xpathCalculatedPrice = driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/markdown_price_editable']"));
		xpathCalculatedPrice.isDisplayed();

	}

	public void getCalculatedPrice() throws Throwable {
		WebElement xpathCalculatedPrice = driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/markdown_price_editable']"));
		xpathCalculatedPrice.isDisplayed();

		calculatedPriceUI = xpathCalculatedPrice.getText();
		System.out.println("calculatedPriceUI" + calculatedPriceUI);

	}

	public void clickOnDiscountPercentage() throws InterruptedException{
		WebElement xpathDiscountPercentage = driveR.findElement(By.xpath("//android.widget.Spinner[@resource-id='" + env + ":id/markdown_percentage_spinner']"));
		xpathDiscountPercentage.isDisplayed();

		xpathDiscountPercentage.click();
		Thread.sleep(3000);
	}


	public void selectPercentage(String percentage) throws Throwable {
		Thread.sleep(3000);
		WebElement xpathSelectPercentage = driveR.findElement(By.xpath("//android.widget.CheckedTextView[@text='"+percentage+"']"));
		xpathSelectPercentage.isDisplayed();

		xpathSelectPercentage.click();
		Thread.sleep(5000);
	}

	public void clerancePoopupIsNotDisplayed() throws InterruptedException {
		boolean isPopupDisplay = false;
		try{

			WebElement xpathAlert = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']"));
			isPopupDisplay = xpathAlert.isDisplayed();
			Thread.sleep(3000);
		}catch(Exception e){
			Thread.sleep(5000);
			isPopupDisplay = true;
			System.out.println("popup is displayed");
		}
		assertEquals(isPopupDisplay, true,"Clearance popup is not displayed");
	}

	public void clerancePopupIsDisplayed() throws InterruptedException {
		boolean isPopupDisplay = false;
		try{
			WebElement xpathAlert = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']"));
			isPopupDisplay = xpathAlert.isDisplayed();

			String alertText = xpathAlert.getText();

			assertEquals(alertText,"Is this markdown to clear the product today?","Alert text is mismatched");
			Thread.sleep(5000);
		}catch(NoSuchElementException e){

		}
		assertEquals(isPopupDisplay, true,"Clearance alert popup is not displayed");
	}

	public void clickOnYesButton() throws InterruptedException {

		WebElement yesButton = driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']"));
		yesButton.isDisplayed();
		yesButton.click();
		Thread.sleep(3000);
	}

	public void clickOnNoButton() throws InterruptedException {
		WebElement noButton = driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button2']"));
		noButton.isDisplayed();
		noButton.click();
		Thread.sleep(3000);
	}

	public void yesAndNoButtonDisplay() throws InterruptedException {
		WebElement yesButton = driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']"));
		yesButton.isDisplayed();

		WebElement noButton = driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button2']"));
		noButton.isDisplayed();
	}

	public void clickOnPrintListIcon() throws InterruptedException {
		Thread.sleep(3000);
		WebElement xpathPrintListIcon = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/action_print']"));
		xpathPrintListIcon.isDisplayed();
		xpathPrintListIcon.click();
		Thread.sleep(3000);
	}

	public void verifyProductInPrintList() throws InterruptedException {

		List<String> productDescription = new ArrayList<String>();
		List<String> productMin = new ArrayList<String>();

		String productDescriptionService = MarkdownServicePages.productDescription;
		String productMinService = MarkdownServicePages.minIdentifier;

		List<WebElement> xpathProductList = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/markdown_list_item_description']"));
		for(WebElement xpathProduct : xpathProductList){
			xpathProduct.isDisplayed();
			productDescription.add(xpathProduct.getText());
		}

		boolean isDescriptionPresent = productDescription.contains(productDescriptionService);
		assertEquals(isDescriptionPresent, true,"Product description is not present in Print list");

		WebElement xpathProductQty = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/markdown_list_item_quantity']"));
		boolean isQtyPresent = xpathProductQty.isDisplayed();
		assertEquals(isQtyPresent, true,"Product qty is not present in Print list");

		List<WebElement> xpathProductMin = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/markdown_list_item_description']"));
		for(WebElement xpathMin : xpathProductMin){
			xpathMin.isDisplayed();
			productMin.add(xpathMin.getText());
		}

		boolean isMinPresent = productMin.contains(productMinService);
		assertEquals(isMinPresent, true,"Product min is not present in Print list");
	}

	public void enterMarkdownBarcode() throws InterruptedException {
		String markdownEventBarcode = MarkdownServicePages.markdownBarcode;

		Thread.sleep(3000);

		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/action_barcode_entry']"))
		.sendKeys(markdownEventBarcode);

		Thread.sleep(5000);

		driveR.executeScript("mobile:performEditorAction", ImmutableMap.of("com/morrisons/common/action","search"));

		Thread.sleep(5000);

	}

	public void getOriginalPriceOnUI() throws InterruptedException {
		WebElement xpathPrice = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/original_price']"));

		originalPriceOnUI = xpathPrice.getText();
	}

	public void verifyOriginalPriceOnUI() throws InterruptedException {
		WebElement xpathPrice = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/original_price']"));

		boolean isPresent = xpathPrice.isDisplayed();
		assertEquals(isPresent, true,"First markdown price is not displayed");
	}

	public void getNewPriceUI() throws InterruptedException {
		WebElement xpathPrice = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/markdown_price_fixed']"));

		newPriceOnUI = xpathPrice.getText();
	}

	public void clickOnMarkdownListButton() throws InterruptedException {
		WebElement xpathMarkdownList = driveR.findElement(By.xpath("//android.widget.Button[@text='MARKDOWN LIST' or @text='Markdown List']"));
		xpathMarkdownList.click();
		Thread.sleep(3000);
	}

	///Verifying Original price displayed on UI matches with Markdown details Service response
	public void verifyOriginalPrice() throws InterruptedException {
		String originalPriceService = MarkdownServicePages.currentSellingPrice;

		double price = Integer.parseInt(originalPriceService);
		double i = (double) price /100;

		DecimalFormat format = new DecimalFormat("0.00"); 
		originalPriceService = format.format(i);

		String originalPriceUI = originalPriceOnUI.substring(1);

		assertEquals(originalPriceUI, originalPriceService,"Original price displayed on UI and services mismatched");
	}

	///Verifying New price displayed on UI matches with Markdown details Service response
	public void verifyNewPrice() throws InterruptedException {
		String newPriceService = MarkdownServicePages.markdownPrice;

		double price = Integer.parseInt(newPriceService);
		double i = (double) price /100;

		DecimalFormat format = new DecimalFormat("0.00"); 
		newPriceService = format.format(i);

		String newPriceUI = newPriceOnUI.substring(1);

		assertEquals(newPriceUI, newPriceService,"New price displayed on UI and services mismatched");
	}

	public void verifyProductInPrintList(String barcode) throws InterruptedException {
		Thread.sleep(3000);

		List<String> productDescriptionn = new ArrayList<String>();
		List<String> productMin = new ArrayList<String>();


		WebElement xpathProduct = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/markdown_list_item_description']"));
		xpathProduct.isDisplayed();

		WebElement xpathProductQty = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/markdown_list_item_quantity']"));
		boolean isQtyPresent = xpathProductQty.isDisplayed();
		assertEquals(isQtyPresent, true,"Product qty is not present in Print list");

		List<WebElement> xpathProductMin = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/markdown_list_item_min']"));
		for(WebElement xpathMin : xpathProductMin){
			xpathMin.isDisplayed();
			productMin.add(xpathMin.getText());
		}

		boolean isMinPresent = productMin.contains(barcode);
		assertEquals(isMinPresent, true,"Product min is not present in Print list");
	}

	public void getMarkdownPercentageUI() throws InterruptedException{

		String[] percentageList = {"60","55","50","45","40"};
		try{

		for(int i = 0;i<=5;i++)
		{

			String percentage = percentageList[i]+"%";

			WebElement xpathDiscountPercentage = driveR.findElement(By.xpath("//android.widget.Spinner[@resource-id='" + env + ":id/markdown_percentage_spinner']"));
			xpathDiscountPercentage.isDisplayed();

			xpathDiscountPercentage.click();

			Thread.sleep(3000);
			WebElement xpathSelectPercentage = driveR.findElement(By.xpath("//android.widget.CheckedTextView[@text='"+percentage+"']"));
			xpathSelectPercentage.isDisplayed();
			xpathSelectPercentage.click();
			Thread.sleep(3000);

			WebElement xpathPrice = driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/markdown_price_editable']"));
			String price = xpathPrice.getText().substring(1);

			Thread.sleep(3000);

			percentageListUI.put(percentageList[i], price);
		}
		}
		catch(Exception e){}
	}

	public void getMarkdownPercentAndPrice(String percentage) throws InterruptedException{

		String percentagee = percentage.substring(0,percentage.length() - 1);
		System.out.println("percentagee : " + percentagee);

		WebElement xpathPrice = driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/markdown_price_editable']"));
		String price = xpathPrice.getText().substring(1);

		Thread.sleep(3000);

		percentageListUI.put(percentagee, price);

	}

	public void verifyLastMarkdownPrice() throws InterruptedException{

		Thread.sleep(3000);
		assertEquals(newPriceOnUI, calculatedPriceUI,"Markdown price is mismatched");
	}

	public void discountDropdownIsDisabled() throws InterruptedException{
		boolean isDropdownIsDisabled = false;
		try{
			WebElement xpathDiscountPercentage = driveR.findElement(By.xpath("//android.widget.Spinner[@resource-id='" + env + ":id/markdown_percentage_spinner']"));
			xpathDiscountPercentage.isDisplayed();
			Thread.sleep(5000);
		}
		catch(Exception e){
			isDropdownIsDisabled = true;
			Thread.sleep(5000);
			System.out.println(e.getMessage());
		}
		assertEquals(isDropdownIsDisabled, true,"Disocunt dropdown is not disabled");
	}

	public void discountDropdownIsEnabled() throws InterruptedException{
		boolean isDropdownIsDisabled = false;
		try{
			WebElement xpathDiscountPercentage = driveR.findElement(By.xpath("//android.widget.Spinner[@resource-id='" + env + ":id/markdown_percentage_spinner']"));
			xpathDiscountPercentage.isDisplayed();
			isDropdownIsDisabled = true;
			Thread.sleep(5000);
		}
		catch(Exception e){

			Thread.sleep(5000);
			System.out.println(e.getMessage());
		}
		assertEquals(isDropdownIsDisabled, true,"Disocunt dropdown is not enabled");
	}

	public void verifyOptimizedPercentage(String percentage) throws InterruptedException {
		Thread.sleep(3000);
		WebElement xpathOptimizedPercentage = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+percentage+"']"));
		xpathOptimizedPercentage.isDisplayed();
	
	}

	public void productNotFountMessage() throws InterruptedException {
		WebElement xpathAlertTitle = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/alertTitle']"));
		xpathAlertTitle.isDisplayed();
		Thread.sleep(3000);

		String alertTitle = xpathAlertTitle.getText();

		assertEquals(alertTitle, "Product not found","Product not found title mismatched");

		WebElement xpathAlertMessage = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']"));
		xpathAlertMessage.isDisplayed();
		Thread.sleep(3000);

		String alertTitleMessage = xpathAlertMessage.getText();

		assertEquals(alertTitleMessage, "Make sure you are scanning a valid product barcode and try again","Product not found alert is mismatched");

	}

	public void selectProduct() throws InterruptedException {
		WebElement xpathProduct = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/markdown_list_item_description']"));
		xpathProduct.isDisplayed();
		xpathProduct.click();
		Thread.sleep(3000);
	}

	public void verifyCalulatedPrice() throws InterruptedException {
		String expectedPrice = MarkdownServicePages.blueyonder_Price;

		assertEquals(calculatedPriceUI, expectedPrice, "Calculate dprice on Ui and services mismatched");
	}

	public void calculatedPriceNotDisplayed() throws Throwable {
		boolean calculateText = true;
		boolean markdownPrice = true;

		try{
			calculateText = driveR.findElement(By.xpath("//android.widget.TextView[@text='Calculated' or @text='CALCULATED']")).isDisplayed();
		}
		catch(Exception e){
			assertEquals(calculateText, false,"Calculate text is displayed");
		}

		try{
			markdownPrice = driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/markdown_price_editable']")).isDisplayed();
		}
		catch(Exception e){
			assertEquals(markdownPrice, false,"Markdown price is displayed");
		}
	}


	public void verifyEditedQuantity(String expectedQuantity) throws Throwable {

		String quantity = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/markdown_list_item_quantity']")).getText();
		assertEquals(quantity, expectedQuantity,"Edited quantity is mismatched");
	}

	public void verifyProductIsDeleted(String barcode) throws Throwable {
		List<WebElement> xpathProductMin = null;
		List<String> productMinList = new ArrayList<String>();
		int isListPresent = 0;

		try{
			xpathProductMin = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/markdown_list_item_min']"));
			isListPresent = xpathProductMin.size();
		}catch(Exception e){}

		if(isListPresent > 1){
			for(WebElement xpathMin : xpathProductMin){
				xpathMin.isDisplayed();
				productMinList.add(xpathMin.getText());
			}

			boolean isMinPresent = productMinList.contains(barcode);
			assertEquals(isMinPresent, false,"Item is not deleted from print list");
		}
		else{
			boolean isDeleted = driveR.findElement(By.xpath("//android.widget.TextView[@text='There are no items in your print list']")).isDisplayed();
			assertEquals(isDeleted, true,"Item is not deleted from print list");
		}
	}

	public void swipeRight() throws InterruptedException {

		TouchAction ts = new TouchAction(driveR);
		ts.press(PointOption.point(1090, 444)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(700, 444)).release().perform();
		Thread.sleep(3000);

		driveR.findElement(
				By.xpath("//android.widget.ImageView[@resource-id='"+env+":id/delete_button']"))
		.click();

	}
	public void clickProductInList(String exepctedProduct) throws InterruptedException {
		
		
		List<String> productList = new ArrayList<String>();
		boolean scroll = true;

		for(int i=0;i<=5;i++){
			List<WebElement> xpathProductList = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/storewalk_list_item_min']"));
			for(WebElement xpathProduct : xpathProductList){
				String productItem = xpathProduct.getText();

				if(productItem.equalsIgnoreCase(exepctedProduct)){
					driveR.findElement(By.xpath("//android.widget.TextView[@text='"+exepctedProduct+"']")).click();
					Thread.sleep(2000);
					scroll = false;
					System.out.println("Break");
					break;


				}
				
			}
			if(scroll){
				Thread.sleep(2000);
				TouchAction ts = new TouchAction(driveR);
				ts.press(PointOption.point(350, 1515)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
				.moveTo(PointOption.point(300, 390)).release().perform();

				System.out.println("Loop ..........");
			}
			else{
				break;
			}
		}
		assertEquals(scroll, false,"Item not found");
	}
}
