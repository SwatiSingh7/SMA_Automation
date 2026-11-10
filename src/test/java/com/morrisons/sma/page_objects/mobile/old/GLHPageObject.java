package com.morrisons.sma.page_objects.mobile.old;

import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.morrisons.common.PageFactory.InitClass;
import com.morrisons.common.helper.CommonHelperMethods;
import com.morrisons.common.helper.MobileHelper;
import org.eclipse.jdt.internal.core.Assert;
import org.openqa.selenium.*;

import com.google.common.base.CharMatcher;

import com.morrisons.common.action.Hook;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import org.openqa.selenium.interactions.Actions;

import static org.testng.Assert.*;

public class GLHPageObject {
	private static AndroidDriver driveR;
	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
	String env = applicationConfig.getWebElementEnviroment().getEnv();

	static String env1 = applicationConfig.getWebElementEnviroment().getEnv();
	String storeWalk = "store_walk";

	String types;
	String messageDesc;
	//private String orderdel;
	public static String orderdel;
	private String orderSIandDelSI;
	public static WebDriver driver;
	public static String captureRecord;
	public static String newCalRecord;
	public static String finalCalculatedRecord;
	public static String variance;
	public static int varianceCountPrevious;
	public static int totalQuantity;

	public GLHPageObject() {
		this.driveR = (AndroidDriver) Hook.getDriver();
	}

	public static MobileDriver getDriver() {

		return driveR;

	}

	public void navigatetoGLH() throws InterruptedException {

		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/" + storeWalk + "']"))
		.click();
		Thread.sleep(3000);

	}

	public void navigatetoAMGLH() throws InterruptedException {

		//driveR.findElement(By.id(""+env+":id/text")).click();
		driveR.findElement(By.xpath("//android.widget.TextView[@text='AM Gaps Lows Highs']")).click();

	}

	public void navigateToFixtureScan() throws InterruptedException {

		driveR.findElement(By.xpath("//android.widget.TextView[@text='Fixture Scan' or @text='FIXTURE SCAN']")).click();
		Thread.sleep(3000);

	}

	public void location(String location) throws InterruptedException {

		driveR.findElement(By.xpath("//android.widget.TextView[@text='"+location+"']")).click();
		Thread.sleep(3000);

	}

	public void navigateToOffShelf() throws InterruptedException {

		driveR.findElement(By.xpath("//android.widget.TextView[@text='Off Shelf' or @text='OFF SHELF']")).click();

	}

	public void navigateToPetrol() throws InterruptedException {

		driveR.findElement(By.xpath("//android.widget.TextView[@text='Petrol' or @text='PETROL']")).click();

	}

	public void navigateToWareHouse() throws InterruptedException {

		driveR.findElement(By.xpath("//android.widget.TextView[@text='Warehouse' or @text='WAREHOUSE']")).click();
		Thread.sleep(3000);
	}

	public void navigateToReview() throws InterruptedException {

		driveR.findElement(By.xpath("//android.widget.TextView[@text='Review' or @text='REVIEW']")).click();
		Thread.sleep(3000);
	}

	public void navigateToSummary() throws InterruptedException {

		driveR.findElement(By.xpath("//android.widget.TextView[@text='Summary' or @text='SUMMARY']")).click();
		Thread.sleep(3000);
	}

	public void clickBackButton() throws InterruptedException {
		try {
			Thread.sleep(3000);
			driveR.findElement(By.className("android.widget.ImageButton")).click();
			Thread.sleep(3000);
		}
		catch(StaleElementReferenceException se){
			clickBackButton();
		}
	}

	public void clickBackButtonTillElementFound(String sElement) throws InterruptedException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
		boolean sStatus = false;
		while(!sStatus) {
			try {
				WebElement oEle = InitClass.createObject(driveR, "sLocatorName", sElement, "com.morrisons.sma.page_objects.mobile.CountsPO");
				if (oEle.isDisplayed() && oEle.isEnabled()) {
					sStatus = true;
				}
			} catch (Exception e) {
				driveR.findElement(By.className("android.widget.ImageButton")).click();
			}
		}
	}

	public void clickGapButton() throws InterruptedException {
try {
	driveR.findElement(By
					.xpath("//android.widget.Button[@resource-id='" + env + ":id/addAsGapButton' or @resource-id='" + env + ":id/verticalAddAsGapButton']"))
			.click();
	Thread.sleep(5000);
}
catch(Exception e){
	driveR.navigate().refresh();
	clickGapButton();
}
	}

	public void clickHighButton() throws InterruptedException {

		Thread.sleep(5000);
		driveR.findElement(By
				.xpath("//android.widget.Button[@resource-id='"+env+":id/addAsHighButton' or @resource-id='"+env+":id/verticalAddAsHighButton']"))
		.click();

	}

	public void clickLowButton() throws InterruptedException {
		Thread.sleep(5000);
		driveR.findElement(By.xpath("//android.widget.Button[@resource-id='"+env+":id/addAsLowButton' or @resource-id='"+env+":id/verticalAddAsLowButton']"))
		.click();

	}

	public void clickCountButton() throws InterruptedException, NoSuchFieldException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
		Thread.sleep(5000);
		try {
			driveR.findElement(By.xpath("//android.widget.Button[@text='COUNT']"))
					.click();
		}
		catch(WebDriverException we){
			Thread.sleep(2000);
			driveR.findElement(By.xpath("//android.widget.Button[@text='COUNT']"))
					.click();
		}


	}

	public void verifyMin(String item) throws InterruptedException {
		// String items =
		// driveR.findElement(By.xpath("//android.widget.TextView[@text='MIN:']//following::input")).getText();
		List<AndroidElement> profile = driveR.findElements(
				MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/value']"));

		String items = profile.get(1).getText();

		// String items = driveR.findElement(By.xpath("//span[contains(text(),'
		// Status')]//parent::div//following-sibling::div//mat-form-field"));
		Thread.sleep(3000);
		System.out.println("Item from screen " + items);
		assertEquals(items, item, " Product details does not match!!");

	}

	public void usernamePasswrod(String userName, String password) throws Throwable {
		String xpathUserName = "//android.widget.LinearLayout[@index='1']/android.widget.FrameLayout/android.widget.EditText";
		String xpathPwd = "//android.widget.LinearLayout[@index='0']/android.widget.FrameLayout/android.widget.EditText";

		driveR.findElement(By.xpath(xpathUserName)).clear();
		driveR.findElement(By.xpath(xpathUserName)).sendKeys(userName);

		driveR.findElement(By.xpath(xpathPwd)).clear();
		driveR.findElement(By.xpath(xpathPwd)).sendKeys(password);

		Thread.sleep(3000);

	}

	public void clickLogin() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.Button[@resource-id='" + env + ":id/inner_button']")).click();

	}

	public void verifyPopupGap() throws InterruptedException {
		try{

			driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']")).isDisplayed();

			Thread.sleep(5000);
			String message = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']"))
					.getText();
			Thread.sleep(2000);
			assertEquals(message, "Please place an orange out of stock label until the product is back in stock",
					" Message details does not match!!");


		}
		catch (Exception e) {
			Thread.sleep(3000);
		}
	}

	public void verifyOkGap() throws InterruptedException {
		Thread.sleep(7000);
		try{
			MobileElement element = (MobileElement) driveR.findElementByXPath("//android.widget.Button[@resource-id='android:id/button1']");


			driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();
			Thread.sleep(2000);
		}
		catch(Exception e){
			Thread.sleep(3000);
		}

	}

	public void captureFixtureList() throws InterruptedException {

		try{
			Thread.sleep(3000);

			messageDesc = driveR
					.findElement(By
							.xpath("//android.widget.TextView[@resource-id='"+env+":id/storewalk_list_item_description']"))
					.getText();
			System.out.println("Captured name = " + messageDesc);
		}
		catch(Exception e){}
	}

	public void captureProductMinValue(String minValue) throws InterruptedException {

		try{
			Thread.sleep(5000);

			String minText = driveR
					.findElement(By
							.xpath("//android.widget.TextView[@resource-id='"+env+":id/storewalk_list_item_min']"))
					.getText();

			Thread.sleep(2000);
			assertEquals(minText, minValue ,"Product min value is mismatched");
		}
		catch(Exception e){}

	}

	public void selectfromlist() throws Throwable {
		try {


			WebElement element = driveR.findElementByXPath("//android.widget.CheckedTextView[@resource-id='android:id/text1']");

			Boolean getPrice = driveR
					.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1']"))
					.isDisplayed();
			Thread.sleep(5000);

			if (getPrice = true) {
				driveR.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1']"))
				.click();
				driveR.hideKeyboard();
				Thread.sleep(3000);
				driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();
				Thread.sleep(3000);

			} else {

				driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']")).click();
			}
		}
		catch (Exception e) {
			Thread.sleep(3000);
		}
	}

	public void selectfromWarehouse(String type) throws InterruptedException {
		types = type;
		int iCtn = 0,cnt;
		String sItem = null;
		boolean bSts = true;
		qq: while(bSts == true) {
			try {
				iCtn++;
				cnt = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/header_title']")).size();
				List<WebElement> oli = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/header_title']"));
				sItem = oli.get(cnt-1).getText();
				String names = driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + types + "']")).getText();
				System.out.println("List of names = " + names);
				driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + types + "']")).click();
				Thread.sleep(2000);
				driveR.findElement(By
								.xpath("//android.widget.TextView[@resource-id='" + env + ":id/groups_section_header_title']"))
						.click();
				bSts = false;
				break qq;
			} catch (NoSuchElementException e) {
				MobileHelper.scroll(driveR, 500, 1515, 1000, 1000);
				Thread.sleep(2000);
				int cnt1 = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/header_title']")).size();
				List<WebElement> oli1 = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/header_title']"));
				String sItem1 = oli1.get(cnt1-1).getText();
				if(sItem.equalsIgnoreCase(sItem1)){
					bSts = false;
					break qq;
				}
				continue qq;
			}
		}
	}

	public void checkWareHouse(String type) throws InterruptedException {
		types = type;

		String names = driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + types + "']")).getText();
		System.out.println("List of names = " + names);
		driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + types + "']")).click();
		Thread.sleep(2000);
		driveR.findElement(By
				.xpath("//android.widget.TextView[@resource-id='"+env+":id/groups_section_header_title']"))
		.isDisplayed();

	}

	public void gapIsDisplayed() throws InterruptedException {

		Thread.sleep(6000);

		String expectedValue = null;
		String names = driveR
				.findElement(By
						.xpath("//android.widget.TextView[@resource-id='"+env+":id/storewalk_list_item_type']"))
				.getText();
		Thread.sleep(3000);
		System.out.println("Captured name = " + names);

		if(CharMatcher.javaUpperCase().matchesAllOf(names)){
			expectedValue = "GAP";
		}
		else{
			expectedValue = "Gap";
		}
		assertEquals(names, expectedValue ," Message details does not match!!");
		Thread.sleep(3000);

	}

	public void lowIsDisplayed() throws InterruptedException {
		Thread.sleep(3000);

		String names = driveR
				.findElement(By
						.xpath("//android.widget.TextView[@resource-id='"+env+":id/storewalk_list_item_type']"))
				.getText();
		Thread.sleep(3000);
		System.out.println("Captured name = " + names);

		System.out.println("Captured name = " + names);
		String expectedValue = null;

		if(CharMatcher.javaUpperCase().matchesAllOf(names)){
			expectedValue = "LOW";
		}
		else{
			expectedValue = "Low";
		}

		assertEquals(names, expectedValue, " Message details does not match!!");

	}

	public void highIsDisplayed() throws InterruptedException {

		String names = driveR
				.findElement(By
						.xpath("//android.widget.TextView[@resource-id='"+env+":id/storewalk_list_item_type']"))
				.getText();
		Thread.sleep(4000);
		System.out.println("Captured name = " + names);

		String expectedValue = null;
		if(CharMatcher.javaUpperCase().matchesAllOf(names)){
			expectedValue = "HIGH";
		}
		else{
			expectedValue = "High";
		}

		assertEquals(names, expectedValue, " High status is mismatched");
		Thread.sleep(1000);
	}

	public void CountIsDisplayed() throws InterruptedException {

		String names = driveR
				.findElement(By
						.xpath("//android.widget.TextView[@resource-id='"+env+":id/storewalk_list_item_type']"))
				.getText();
		Thread.sleep(4000);
		System.out.println("Captured name = " + names);

		String expectedValue = null;
		if(CharMatcher.javaUpperCase().matchesAllOf(names)){
			expectedValue = "COUNT";
		}
		else{
			expectedValue = "Count";
		}

		assertEquals(names, expectedValue, " High status is mismatched");
		Thread.sleep(1000);
	}

	public void lowIsDisplayedInWarehouse() throws InterruptedException {
		Thread.sleep(3000);

		String names = driveR
				.findElement(By
						.xpath("//android.widget.TextView[@resource-id='"+env+":id/txt_capture_type']"))
				.getText();
		Thread.sleep(3000);
		System.out.println("Captured name = " + names);

		System.out.println("Captured name = " + names);
		String expectedValue = null;

		if(CharMatcher.javaUpperCase().matchesAllOf(names)){
			expectedValue = "LOW";
		}
		else{
			expectedValue = "Low";
		}

		assertEquals(names, expectedValue, " Message details does not match!!");

	}

	public void countIsDisplayedInWarehouse() throws InterruptedException {
		Thread.sleep(3000);

		String names = driveR
				.findElement(By
						.xpath("//android.widget.TextView[@resource-id='"+env+":id/txt_capture_type']"))
				.getText();
		Thread.sleep(3000);
		System.out.println("Captured name = " + names);

		System.out.println("Captured name = " + names);
		String expectedValue = null;

		if(CharMatcher.javaUpperCase().matchesAllOf(names)){
			expectedValue = "COUNT";
		}
		else{
			expectedValue = "Count";
		}

		assertEquals(names, expectedValue, " Message details does not match!!");

	}

	public void gapIsDisplayedInWarehouse() throws InterruptedException {
		Thread.sleep(3000);

		String names = driveR
				.findElement(By
						.xpath("//android.widget.TextView[@resource-id='"+env+":id/txt_capture_type']"))
				.getText();
		Thread.sleep(3000);
		System.out.println("Captured name = " + names);

		System.out.println("Captured name = " + names);
		String expectedValue = null;

		if(CharMatcher.javaUpperCase().matchesAllOf(names)){
			expectedValue = "GAP";
		}
		else{
			expectedValue = "Gap";
		}

		assertEquals(names, expectedValue, " Message details does not match!!");

	}

	public void gaplowIsDisplayedInWarehouse() throws InterruptedException {
		boolean isGAPLOW = false;
		List<String> captureTypeText = new ArrayList<String>();

		Thread.sleep(3000);

		List<WebElement> captureTypeList = driveR
				.findElements(By
						.xpath("//android.widget.TextView[@resource-id='"+env+":id/txt_capture_type']"));

		for(WebElement captureType : captureTypeList)
		{
			captureTypeText.add(captureType.getText());


			if(captureTypeText.contains("GAP")||captureTypeText.contains("Gap")||captureTypeText.contains("LOW")||captureTypeText.contains("Low"))
			{
				isGAPLOW = true;
			}
			else{
				if(captureTypeText.contains("HIGH")||captureTypeText.contains("High")){
					isGAPLOW = false;
				}
			}
		}
		assertEquals(isGAPLOW, true, " High capture product is displayed in warehouse");
	}

	public void enterQty() throws InterruptedException {

		driveR.findElement(By
				.xpath("//android.widget.TextView[@resource-id='"+env+":id/storewalk_list_item_description']"))
		.click();
		Thread.sleep(1000);
		driveR.findElement(
				By.xpath("//android.widget.EditText[@resource-id='"+env+":id/item_details_quantity_input']")).click();
		Thread.sleep(1000);
		driveR.findElement(
				By.xpath("//android.widget.EditText[@resource-id='"+env+":id/item_details_quantity_input']"))
		.sendKeys("5");
		Thread.sleep(1000);
		driveR.findElement(By
				.xpath("//android.widget.Button[@resource-id='"+env+":id/item_details_confirm_quantity']"))
		.click();


	}

	public void confirmCount() throws InterruptedException {
		driveR.findElement(
				By.xpath("//android.widget.Button[@resource-id='"+env+":id/inner_button']")).click();

	}

	public void confirmMessage() throws InterruptedException {
		driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();

	}

	public void reviewVerification(String type) throws InterruptedException {

		types = type;
		driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + types + "']")).click();
		Thread.sleep(3000);
		String status = driveR.findElement(By.xpath("//android.widget.TextView[@text='Pending' or @text='PENDING']")).getText();
		Thread.sleep(1000);
		assertEquals(status, "Pending", " Message details does not match!!");

	}

	public void checkreview(String type) throws InterruptedException {

		types = type;
		driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + types + "']")).isDisplayed();
		Thread.sleep(1000);
		System.out.println("Type is displayed");




		// driveR.findElement(By.xpath("//android.widget.TextView[@resiurce-id='com.morrisons.instore.uat:id/groups_section_header_title']")).click();
		// Thread.sleep(1000);

		// String status =
		// driveR.findElement(By.xpath("//android.widget.TextView[@text='OFF
		// SHELF PENDING']")).getText();
		// Thread.sleep(1000);
		// assertEquals(status, "OFF SHELF PENDING", " Message details does not
		// match!!");
		Thread.sleep(3000);

	}

	public void enterQtyLow(String quantity) throws Throwable {
		//		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/itemUOM']"))
		//		.click();
		//		Thread.sleep(1000);
		//		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/itemUOM']"))
		//		.sendKeys(quantity);
		//		Thread.sleep(2000);


		driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='"+env+":id/quantityEditText']"))
		.click();
		Thread.sleep(5000);
		driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='"+env+":id/quantityEditText']"))
		.sendKeys(quantity);
		Thread.sleep(5000);

		driveR.findElement(
				By.xpath("//android.widget.Button[@resource-id='"+env+":id/actionButton']")).click();
		Thread.sleep(3000);

		try{

			driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/alertTitle']"))
			.isDisplayed();
			Thread.sleep(3000);

			driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']"))
			.click();
			Thread.sleep(3000);
		}
		catch(Exception e){}
	}

	public void enterQtyCount(String quantity) throws Throwable {
		//		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/itemUOM']"))
		//		.click();
		//		Thread.sleep(1000);
		//		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/itemUOM']"))
		//		.sendKeys(quantity);
		//		Thread.sleep(2000);


		driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='"+env+":id/quantityEditText']"))
				.click();
		Thread.sleep(5000);
		driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='"+env+":id/quantityEditText']"))
				.sendKeys(quantity);
		Thread.sleep(5000);

		driveR.findElement(
				By.xpath("//android.widget.Button[@resource-id='"+env+":id/actionButton']")).click();
		Thread.sleep(3000);

		try{

			driveR.findElement(By.xpath("//android.widget.TextView[@text='Excess']"))
					.click();
			Thread.sleep(3000);
			driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='"+env+":id/quantityEditText']"))
					.click();
			Thread.sleep(5000);
			driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='"+env+":id/quantityEditText']"))
					.sendKeys(quantity);
			driveR.findElement(By.xpath("//android.widget.Button[@resource-id='"+env+":id/actionButton']"))
					.click();
			Thread.sleep(3000);
		}
		catch(NoSuchElementException ne){
			System.out.println(ne);
			driveR.hideKeyboard();
			driveR.findElement(By.xpath("//android.widget.TextView[@text='Excess']"))
					.click();
			Thread.sleep(3000);
			driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='"+env+":id/quantityEditText']"))
					.click();
			Thread.sleep(5000);
			driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='"+env+":id/quantityEditText']"))
					.sendKeys(quantity);
			driveR.findElement(By.xpath("//android.widget.Button[@resource-id='"+env+":id/actionButton']"))
					.click();
			Thread.sleep(3000);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	public void viewlistclick() throws InterruptedException {
		driveR.findElement(
				By.xpath("//android.widget.LinearLayout[@resource-id='"+env+":id/singleItemHeader']"))
		.click();

	}

	public void verifyBarcodeinWarehouse(String barcode) throws InterruptedException {
		String barcodeId = driveR
				.findElement(By
						.xpath("//android.widget.TextView[@resource-id='"+env+":id/storewalk_list_item_min']"))
				.getText();
		Thread.sleep(2000);
		assertEquals(barcodeId, barcode, " Message details does not match!!");

	}

	public void verifyDescinWarehouse() throws InterruptedException {
		String DescIdText = driveR
				.findElement(By
						.xpath("//android.widget.TextView[@resource-id='"+env+":id/storewalk_list_item_description']"))
				.getText();
		Thread.sleep(2000);
		assertEquals(messageDesc, DescIdText, " Message details does not match!!");


	}

	public void verifyVarianceinWarehouse(String quantity) throws InterruptedException {
		String varianceCountPreviousText =  driveR
				.findElement(By
						.xpath("//android.widget.TextView[@resource-id='"+env+":id/count_variance']"))
				.getText();

		varianceCountPrevious = Integer.parseInt(varianceCountPreviousText);
		Thread.sleep(2000);
		System.out.println("Variance count = " + varianceCountPrevious);
		assertEquals("+" + varianceCountPrevious, "+" + quantity, " First variance cal does not match !");
	}

	public void swipeRight() throws InterruptedException {


		TouchAction ts = new TouchAction(driveR);
		ts.press(PointOption.point(520, 237)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(32, 269)).release().perform();
		Thread.sleep(3000);

		driveR.findElement(
				By.xpath("//android.widget.ImageView[@resource-id='"+env+":id/delete_button']"))
		.click();

	}

	public static boolean isItemDescriptionDisplayed() throws Throwable {

		boolean itmDescription = false;
		try {
			int i = getDriver().findElements(By.id(""+env1+":id/singleItemHeader")).size();
			if (i > 0) {
				return true;
			}

		} catch (Exception e) {
			return false;
		}
		return itmDescription;


	}

	public static void logout() throws Throwable {
		try {
			// To be written code in case of iOS
			System.out.println("Signing out");
		} catch (Exception e) {

		}
	}

	public void rightswipeDelete() throws InterruptedException {

	}

	public void viewGapLowHigh() throws InterruptedException {
		driveR.findElement(
				By.xpath("//android.widget.LinearLayout[@resource-id='"+env+":id/singleItemHeader']"))
		.click();

	}

	public void checkWarehouseDelete() throws InterruptedException {
		String msg = driveR
				.findElement(By
						.xpath("//android.widget.TextView[@resource-id='"+env+":id/warehouse_group_info']"))
				.getText();

		assertEquals(msg, "There are currently no items to count in the warehouse.", "Data not deleted !");
	}

	public void captureRecord() throws InterruptedException {
		Thread.sleep(2000);
		captureRecord = driveR
				.findElement(By
						.xpath("//android.widget.TextView[@resource-id='"+env+":id/stock_record_value']"))
				.getText();

		System.out.println("Captured Value is = " + captureRecord);



	}

	public void firstcalculation() throws InterruptedException {
		Thread.sleep(2000);
		try{
			int calRecord = Integer.valueOf(captureRecord) - 5;
			System.out.println("captured record = " + captureRecord);

			System.out.println("Variance after fixture scan = " + calRecord);
			newCalRecord = String.valueOf(calRecord);
			System.out.println("Variance after fixture scan Int  = " + newCalRecord);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	public void enterQtyWarehousethrows(String quantity) throws InterruptedException {
		Thread.sleep(3000);
		String lowValue = driveR
				.findElement(By
						.xpath("//android.widget.TextView[@resource-id='"+env+":id/warehouse_count']"))
				.getText();
		System.out.println("Low valus is = " + lowValue);
		assertEquals(lowValue, "(0)", "Incorrect value displayed !");

		Thread.sleep(2000);
		driveR.findElement(By
				.xpath("//android.widget.TextView[@resource-id='"+env+":id/storewalk_list_item_description']"))
		.click();

		Thread.sleep(1000);
		driveR.findElement(By
				.xpath("//android.widget.EditText[@resource-id='"+env+":id/item_details_quantity_input']"))
		.click();

		Thread.sleep(1000);

		driveR.findElement(By
				.xpath("//android.widget.EditText[@resource-id='"+env+":id/item_details_quantity_input']"))
		.sendKeys(quantity);

		Thread.sleep(1000);
		driveR.findElement(By
				.xpath("//android.widget.Button[@resource-id='"+env+":id/item_details_confirm_quantity']"))
		.click();

		Thread.sleep(1000);
	}

	public void finalVariance(int quantity) throws InterruptedException {
		Thread.sleep(1000);
		String finalCal = driveR
				.findElement(By
						.xpath("//android.widget.TextView[@resource-id='"+env+":id/count_variance']"))
				.getText();

		Thread.sleep(1000);
		int finalCalRecord = varianceCountPrevious + quantity;
		System.out.println("Variance after warehouse scan = " + finalCalRecord);
		finalCalculatedRecord = String.valueOf(finalCalRecord);
		System.out.println("Variance after warehoue scan Int  = " + finalCalculatedRecord);

		assertEquals(finalCal, "+" + finalCalculatedRecord, "Variance not calculated as expected !");

		String newlowValue = driveR
				.findElement(By
						.xpath("//android.widget.TextView[@resource-id='"+env+":id/warehouse_count']"))
				.getText();
		int newLowCount = Integer.parseInt(newlowValue);
		assertEquals(newLowCount, quantity, "Incorrect value displayed !");

		System.out.println("Variance Calculated sucessfully !");

	}

	public void enterHighQty(String qty) throws InterruptedException {

		Thread.sleep(1000);
		driveR.findElement(
				By.xpath("//android.widget.EditText[@resource-id='"+env+":id/quantityEditText']"))
		.sendKeys(qty);
		Thread.sleep(1000);

		driveR.hideKeyboard();

		//		driveR.executeScript("mobile:keyevent", "keycode:61");
		//	
		//		new TouchAction((AppiumDriver) driveR).press(PointOption.point(715, 1278)).release().perform();


		driveR.findElement(
				By.xpath("//android.widget.FrameLayout[@resource-id='"+env+":id/backup_input_frame_layout']")).click();

		Thread.sleep(1000);
		driveR.findElement(
				By.xpath("//android.widget.EditText[@resource-id='"+env+":id/quantityEditText']"))
		.sendKeys(qty);
		Thread.sleep(1000);
		//new TouchAction((AppiumDriver) driveR).press(PointOption.point(715, 1278)).release().perform();
		//Thread.sleep(1000);
		driveR.hideKeyboard();

		Thread.sleep(3000);

		driveR.findElement(
				By.xpath("//android.widget.Button[@resource-id='"+env+":id/actionButton']")).click();
	}

	public void verifyList(String minValue) throws InterruptedException {
		Thread.sleep(4000);

		List<String> productMinss = new ArrayList<String>();
		List<String> captureTypess = new ArrayList<String>();
		String expectedValue = null;

		driveR.findElement(By
				.xpath("//android.widget.TextView[@resource-id='"+env+":id/singleItemTitle']"))
		.click();

		Thread.sleep(4000);

		List<WebElement> productMinsList = driveR.findElements(By
				.xpath("//android.widget.TextView[@resource-id='"+env+":id/storewalk_list_item_min']"));


		for(WebElement productMins : productMinsList){
			String minText = productMins.getText();
			System.out.println("MIN value : " + minText);
			productMinss.add(minText);
		}

		List<WebElement> productCapturetypeList = driveR.findElements(By
				.xpath("//android.widget.TextView[@resource-id='"+env+":id/storewalk_list_item_type']"));


		for(WebElement productCapturetype : productCapturetypeList){
			captureTypess.add(productCapturetype.getText());

			if(CharMatcher.javaUpperCase().matchesAllOf(productCapturetype.getText())){
				expectedValue = "HIGH";
			}
			else{
				expectedValue = "High";
			}
		}

		if(productMinss.contains(minValue)){

			int minValueCount =	Collections.frequency(productMinss, minValue);
			assertEquals(minValueCount, 2,"Exepcted high entries are not present in list");
		}

		if(captureTypess.contains(expectedValue)){

			int minCaptureType =	Collections.frequency(captureTypess, expectedValue);
			assertEquals(minCaptureType, 2,"Exepcted high capture type entries are not present in list");
		}
	}
	public void editHigh(String quantity) throws InterruptedException {
		Thread.sleep(1000);
		driveR.findElement(By
				.xpath("//android.widget.TextView[@resource-id='"+env+":id/storewalk_list_item_min']"))
		.click();

		Thread.sleep(1000);
		driveR.findElement(By.xpath("//android.widget.Button[@text='EDIT COUNT']")).click();

		Thread.sleep(1000);
		driveR.findElement(
				By.xpath("//android.widget.TextView[@resource-id='"+env+":id/itemCountCalculation']"))
		.clear();

		Thread.sleep(1000);
		driveR.findElement(
				By.xpath("//android.widget.TextView[@resource-id='"+env+":id/itemCountCalculation']"))
		.sendKeys(quantity);

		Thread.sleep(1000);
		driveR.findElement(By
				.xpath("//android.widget.Button[@resource-id='"+env+":id/item_details_confirm_quantity']"))
		.click();

		Thread.sleep(1000);
		String newVariance = driveR
				.findElement(By
						.xpath("//android.widget.TextView[@resource-id='"+env+":id/count_variance']"))
				.getText();

		System.out.println("new variance value after edit is = " + newVariance);

		int editedQuantity = Integer.parseInt(quantity);
		int finalVar = totalQuantity + editedQuantity;
		String valofCAL = String.valueOf(finalVar);

		assertEquals(newVariance, valofCAL, "Data not as expected!!");
		Thread.sleep(1000);
		System.out.println("Variance after edit has been verified");

	}

	public void enterQuantityInOffshelf() throws InterruptedException {
		Thread.sleep(1000);

		driveR.findElement(By
				.xpath("//android.widget.TextView[@resource-id='"+env+":id/storewalk_list_item_description']"))
		.click();

		Thread.sleep(1000);
		new TouchAction((AppiumDriver) driveR).press(PointOption.point(50, 300)).release().perform();
		Thread.sleep(1000);

		String highValue = driveR.findElement(By.xpath("//android.widget.TextView[@text='Enter Quantity - Low']"))
				.getText();

		assertEquals(highValue, "Enter Quantity - Low", "Data not as expected!!");
		Thread.sleep(1000);

		driveR.findElement(
				By.xpath("//android.widget.EditText[@resource-id='"+env+":id/quantityEditText']"))
		.clear();
		Thread.sleep(1000);
		driveR.findElement(
				By.xpath("//android.widget.EditText[@resource-id='"+env+":id/quantityEditText']"))
		.sendKeys("6");
		Thread.sleep(1000);
		driveR.findElement(
				By.xpath("//android.widget.Button[@resource-id='"+env+":id/actionButton']")).click();

	}

	public void verifyoffShore() throws InterruptedException {

		try{
			driveR.findElement(
					By.xpath("//android.widget.TextView[@resource-id='"+env+":id/header_title']"))
			.click();

			String offShelfText = driveR
					.findElement(By
							.xpath("//android.widget.TextView[@resource-id='"+env+":id/storewalk_list_item_description']"))
					.getText();

			Thread.sleep(1000);
			System.out.println("expected product name = " + messageDesc);
			assertEquals(offShelfText, messageDesc, " Product name does not match !");

			Thread.sleep(3000);
		}

		catch(Exception e){
			System.out.println("Records are not present in Offshore");
		}

	}

	public void addOffshoreQty() throws InterruptedException {
		try{
			driveR.findElement(By
					.xpath("//android.widget.TextView[@resource-id='"+env+":id/storewalk_list_item_description']"))
			.click();

			Thread.sleep(1000);
			driveR.findElement(By
					.xpath("//android.widget.EditText[@resource-id='"+env+":id/item_details_quantity_input']"))
			.click();

			Thread.sleep(1000);
			driveR.findElement(By
					.xpath("//android.widget.EditText[@resource-id='"+env+":id/item_details_quantity_input']"))
			.sendKeys("2");;

			Thread.sleep(1000);
			driveR.findElement(By
					.xpath("//android.widget.Button[@resource-id='"+env+":id/item_details_confirm_quantity']"))
			.click();

			Thread.sleep(1000);
			String qty = driveR.findElement(By
					.xpath("//android.widget.TextView[@resource-id='"+env+":id/stock_on_hand']"))
					.getText();
			assertEquals(qty, "2", " Qty name does not match !");
			Thread.sleep(1000);
		}
		catch(Exception e){
			System.out.println("No entry in Offshelf");
		}

	}

	public void verifyreview() throws InterruptedException {
		Thread.sleep(1000);	
		driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + types + "']")).click();
		Thread.sleep(1000);

		String status = driveR.findElement(
				By.xpath("//android.widget.TextView[@resource-id='"+env+":id/groups_section_status']")).getText();
		Thread.sleep(1000);
		System.out.println("Status displayed =" + status );
		assertEquals(status, "REVIEW READY", " Message does not match !");

		Thread.sleep(3000);
	}

	public void subcategory(String sub) throws InterruptedException {
		Thread.sleep(3000);
		driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + sub + "']")).click();
		Thread.sleep(2000);

	}

	public void updateCount(String quantity) throws InterruptedException {
		////driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/itemCountCalculation'] or //android.widget.EditText[@resource-id='"+env+":id/item_details_quantity_input']")).click();
		driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='"+env+":id/item_details_quantity_input']")).sendKeys(quantity);
		Thread.sleep(3000);

	}

	public void confirm() throws InterruptedException {
		driveR.findElement(By.xpath("//android.widget.Button[@text='Confirm' or @text='CONFIRM']")).click();
		Thread.sleep(100);
	}

	public void errormessageGLHclosed() throws InterruptedException {
		Boolean errormessage = driveR.findElement(By.xpath("//android.widget.TextView[@text='Gap Scans are now closed']")).isDisplayed();
		System.out.println("error message displayed" +errormessage);
		Boolean	expected = true;
		assertEquals(errormessage, expected);	
		Thread.sleep(1000);
	}

	public void orderedDelivered() throws InterruptedException {
		orderdel = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/ordered_delivered_value']")).getText();
		System.out.println("Order quantity and deleviery Quantity " +orderdel);


		//	//		System.out.println("error message displayed" +errormessage);
		//	//	Boolean	expected = true;
		//	//		assertEquals(errormessage, expected);		
	}

	public void orderedDeliveredSI() throws InterruptedException {
		Thread.sleep(15000);

		TouchAction ts = new TouchAction(driveR);
		ts.press(PointOption.point(22, 914)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(22, 290)).release().perform();
		Thread.sleep(1000);	

		String orderSI = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/last_qty_text_view']")).getText();
		System.out.println("Order quantity and deleviery Quantity SIIII " +orderSI);

		String orderdelSI = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/picked_qty_text_view']")).getText();
		System.out.println("Order quantity and deleviery Quantity SIIII" +orderdelSI);

		String orderSIandDelSI = (orderSI +" / "+orderdelSI);
		System.out.println(orderSIandDelSI);


		assertEquals(orderdel, orderSIandDelSI);


	}

	public void exemptedItem(String message) throws InterruptedException {

		String exemptedItemm = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/alertTitle']")).getText();
		System.out.println("exemptedItemm------- " +exemptedItemm);



		assertEquals(exemptedItemm, message);

		Thread.sleep(3000);
	}

	public void verifyList1(String bar) throws InterruptedException {
		String itemsss = driveR.findElement(By
				.xpath("//android.widget.TextView[@resource-id='"+env+":id/storewalk_list_item_min']")).getText();

		Thread.sleep(3000);
		System.out.println("Item from screen " + itemsss);
		assertEquals(bar, itemsss, " Product details does not match!!");

		Thread.sleep(3000);
	}

	public void scrollUp() throws InterruptedException{


		TouchAction ts = new TouchAction(driveR);		
		ts.press(PointOption.point(100, 130)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(100,140)).release().perform();
		Thread.sleep(1000);	
	}

	public void iEnterQuantityFixtureLocation(String quantity) throws InterruptedException{

		WebElement xpathQuantityTextfield  = driveR.findElement(By
				.xpath("//android.widget.EditText[@resource-id='"+env+":id/quantityEditText']"));

		Thread.sleep(5000);

		//xpathQuantityTextfield.click();
		xpathQuantityTextfield.sendKeys(quantity);

		//		WebElement xpathTab  = driveR.findElement(By
		//				.xpath("//android.widget.TextView[@resource-id='"+env+":id/storewalk_list_item_min']"));
		//
		Thread.sleep(3000);

		driveR.hideKeyboard();
		Thread.sleep(5000);

		//		Actions com.morrisons.common.action = new Actions(driveR);
		//		com.morrisons.common.action.sendKeys(Keys.TAB);

		driveR.findElement(By.xpath("//android.widget.TextView[@text='Tab' or @text='TAB']")).click();

		Thread.sleep(5000);

		xpathQuantityTextfield.click();
		xpathQuantityTextfield.sendKeys(quantity);
		Thread.sleep(3000);
		WebElement xpathConfirmButton  = driveR.findElement(By
				.xpath("//android.widget.Button[@resource-id='"+env+":id/actionButton']"));

		Thread.sleep(5000);

		xpathConfirmButton.click();

	}

	//		public void selectfromWarehouse(String type) throws InterruptedException {
	//	
	//			types = type;
	//	
	//			String names = driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + types + "']")).getText();
	//	
	//			System.out.println("List of names = " + names);
	//			driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + types + "']")).click();
	//			Thread.sleep(2000);
	//			driveR.findElement(By
	//					.xpath("//android.widget.TextView[@resource-id='"+env+":id/groups_section_header_title']"))
	//			.click();
	//			Thread.sleep(3000);
	//	
	//		}

	public void getWarehouseProductList()throws InterruptedException {
		Thread.sleep(3000);
		//		List<String> listNames = new ArrayList<String>();
		//
		//		List<WebElement> xpathList = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/header_title']"));

		//		//		for(WebElement xpathLi : xpathList){
		//		//
		//		//			listNames.add(xpathLi.getText());
		//		//		}
		//		//
		//		//		for(String listType : listNames)
		//		//		{
		//		//
		//		//			StopWatch st1 = new StopWatch();
		//		//			st1.start();	
		//		//
		//		//			String names = driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + listType + "']")).getText();
		//		//
		//		//			//driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + listType + "']")).click();
		//		//
		//
		//		//			Thread.sleep(2000);
		//		//			driveR.findElement(By
		//		//					.xpath("//android.widget.TextView[@resource-id='"+env+":id/groups_section_header_title']"))
		//		//			.click();
		//		//			Thread.sleep(3000);
		//		//
		//		//		}
	}

	public void getOffshelfProductList()throws InterruptedException {

		List<String> listNames = new ArrayList<String>();

		List<WebElement> xpathList = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/header_title']"));

		for(WebElement xpathLi : xpathList){

			listNames.add(xpathLi.getText());
		}
	}

	public void getOffshelfProduct()throws InterruptedException {

		List<String> productDescriptions = new ArrayList<String>();
		List<String> productItemMins = new ArrayList<String>();
		List<String> listNames = new ArrayList<String>();

		List<WebElement> xpathList = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/header_title']"));

		for(WebElement xpathLi : xpathList){

			listNames.add(xpathLi.getText());
		}

		for(String listType : listNames)
		{

			System.out.println("Offshelf product : " + listType);

			driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + listType + "']")).click();
			//Thread.sleep(2000);


			List<WebElement> xpathProductDescriptionList = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/storewalk_list_item_description']"));


			for(WebElement xpathProductDescription : xpathProductDescriptionList)
			{

				productDescriptions.add(xpathProductDescription.getText());
			}

			List<WebElement> xpathItemMinList = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/storewalk_list_item_min']"));

			for(WebElement xpathItemMin : xpathItemMinList){

				productItemMins.add(xpathItemMin.getText());
			}

			int i = 1;
			for(String productDescription : productDescriptions)
			{
				System.out.println("Offshelf product number "+i+" description : " + productDescription);
				System.out.println("Offshelf product number "+i+" min number : " + productItemMins.get(i-1));

				//driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + productDescription + "']")).click();
				//Thread.sleep(2000);

				//	enterQuantityInOffshelf();


				clickBackButton();
				navigateToOffShelf();

				driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + listType + "']")).click();
			}
			clickBackButton();
			navigateToOffShelf();
		}

	}

	public void verifySectionIsDisplayedInWarehouseScreen(String type)throws InterruptedException {

		types = type;

		String names = driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + types + "']")).getText();

		System.out.println("List of names = " + names);


	}

	public void verifySectionIsNotDisplayedInWarehouse(String type)throws InterruptedException {
		assertNotNull(driveR.findElement(By.xpath("//android.widget.TextView[@text= 'There are currently no items to count in the warehouse.']")).isDisplayed(),type + " is displayed in Warehouse screen");
	}



	public void clickOnSection(String type)throws InterruptedException {
		types = type;

		driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + types + "']")).click();

		Thread.sleep(2000);

	}

	public void clickOnGroupSection()throws InterruptedException {

		Thread.sleep(2000);

		driveR.findElement(By
				.xpath("//android.widget.TextView[@resource-id='"+env+":id/groups_section_header_title']"))
		.click();
	}

	public void verifyEmptyProductListIsDisplayed()throws InterruptedException {

		WebElement xpathProductCount  = driveR.findElement(By
				.xpath("//android.widget.TextView[@resource-id='"+env+":id/listHeaderQuantity']"));

		String productCount = xpathProductCount.getText().replaceAll("[^0-9]", "");

		assertEquals(productCount, "0","Empty product list is not displayed");


	}

	public void verifyCompleteSectionButtonIsDisplayed()throws InterruptedException {

		WebElement xpathConfirmCountButton  = driveR.findElement(By
				.xpath("//android.widget.Button[@text='CONFIRM COUNT AREA' or @text='Confirm Count Area']"));

		xpathConfirmCountButton.isDisplayed();


	}

	public void deleteProductFromFixture()throws InterruptedException {

		List<WebElement> xpathProductList  = driveR.findElements(By
				.xpath("//android.widget.TextView[@resource-id='"+env+":id/storewalk_list_item_description']"));

		for(WebElement product : xpathProductList){

			Thread.sleep(3000);

			TouchAction ts = new TouchAction(driveR);
			ts.press(PointOption.point(520, 412)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
			.moveTo(PointOption.point(32, 412)).release().perform();
			Thread.sleep(7000);

			driveR.findElement(
					By.xpath("//android.widget.ImageView[@resource-id='"+env+":id/delete_button']"))
			.click();

		}

	}

	public void clickOnViewList() throws InterruptedException {
		Thread.sleep(1000);

		driveR.findElement(By
				.xpath("//android.widget.TextView[@resource-id='"+env+":id/storewalk_list_item_description']"))
		.click();


	}

	public void enterLowQuantityFixtureLocation(String quantity) throws InterruptedException {

		///////		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/itemUOM' or @resource-id='"+env+":id/itemCountCalculation']"))
		///////	///////			.click();
		///////			Thread.sleep(5000);
		///////		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/itemUOM' or @resource-id='"+env+":id/itemCountCalculation']"))
		///////			.sendKeys(quantity);

		driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='"+env+":id/quantityEditText']"))
		.click();
		Thread.sleep(5000);
		driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='"+env+":id/quantityEditText']"))
		.sendKeys(quantity);
		Thread.sleep(5000);
		driveR.findElement(
				By.xpath("//android.widget.Button[@resource-id='"+env+":id/actionButton']")).click();
		Thread.sleep(3000);
	}

	public void verifyGapAndLowProducts() throws InterruptedException {
		Thread.sleep(2000);
		String expectedValue = null;

		List<WebElement> captureTypes = driveR
				.findElements(By
						.xpath("//android.widget.TextView[@resource-id='"+env+":id/txt_capture_type']"));

		for(WebElement captureType : captureTypes)
		{
			String captureTypeText = captureType.getText();

			Thread.sleep(3000);
			System.out.println("Captured name = " + captureTypeText);

			if(captureTypeText.equals("GAP") || captureTypeText.equals("Gap"))
			{
				if(CharMatcher.javaUpperCase().matchesAllOf(captureTypeText)){
					expectedValue = "GAP";
				}
				else{
					expectedValue = "Gap";
				}
				assertEquals(captureTypeText, expectedValue ," Message details does not match!!");
				Thread.sleep(3000);
			}
			else if(captureTypeText.equals("LOW") || captureTypeText.equals("Low"))
			{
				if(CharMatcher.javaUpperCase().matchesAllOf(captureTypeText)){
					expectedValue = "LOW";
				}
				else{
					expectedValue = "Low";
				}
				assertEquals(captureTypeText, expectedValue ," Message details does not match!!");
				Thread.sleep(3000);
			}
			else
			{
				assertEquals(false, true ,"High values are present in warehouse product list");
			}

		}
	}


	public void verifyLowProductsAreDisplayed() throws InterruptedException {
		Thread.sleep(2000);
		String expectedValue = null;

		List<WebElement> captureTypes = driveR
				.findElements(By
						.xpath("//android.widget.TextView[@resource-id='"+env+":id/txt_capture_type']"));

		for(WebElement captureType : captureTypes)
		{
			String captureTypeText = captureType.getText();

			Thread.sleep(3000);
			System.out.println("Captured name = " + captureTypeText);

			if(captureTypeText.equals("LOW") || captureTypeText.equals("Low"))
			{
				if(CharMatcher.javaUpperCase().matchesAllOf(captureTypeText)){
					expectedValue = "LOW";
				}
				else{
					expectedValue = "Low";
				}
				assertEquals(captureTypeText, expectedValue ," Message details does not match!!");
				Thread.sleep(3000);
			}
			else
			{
				assertEquals(false, true ,"High values are present in warehouse product list");
			}

		}


	}

	public void verifyGapProductsAreDisplayed() throws InterruptedException {

		String expectedValue = null;

		List<WebElement> captureTypes = driveR
				.findElements(By
						.xpath("//android.widget.TextView[@resource-id='"+env+":id/txt_capture_type']"));

		for(WebElement captureType : captureTypes)
		{
			String captureTypeText = captureType.getText();

			Thread.sleep(3000);
			System.out.println("Captured name = " + captureTypeText);

			if(captureTypeText.equals("GAP") || captureTypeText.equals("Gap"))
			{
				if(CharMatcher.javaUpperCase().matchesAllOf(captureTypeText)){
					expectedValue = "GAP";
				}
				else{
					expectedValue = "Gap";
				}
				assertEquals(captureTypeText, expectedValue ," Message details does not match!!");
				Thread.sleep(3000);
			}
			else
			{
				assertEquals(false, true ,"High values are present in warehouse product list");
			}

		}
	}

	public void verifyVarianceinPreviousValue() throws InterruptedException {
		String varianceCountPreviousText =  driveR
				.findElement(By
						.xpath("//android.widget.TextView[@resource-id='"+env+":id/count_variance']"))
				.getText();

		varianceCountPrevious = Integer.parseInt(varianceCountPreviousText);
		Thread.sleep(2000);
		System.out.println("Variance count = " + varianceCountPrevious);
	}

	public void verifyVarianceinAfterValue(String quantity) throws InterruptedException {
		String varianceCountPreviousText =  driveR
				.findElement(By
						.xpath("//android.widget.TextView[@resource-id='"+env+":id/count_variance']"))
				.getText();

		int varianceCountAfterValue = Integer.parseInt(varianceCountPreviousText);
		Thread.sleep(2000);
		System.out.println("Variance count = " + varianceCountAfterValue);

		int addQuantity = Integer.parseInt(quantity);
		int calculateValue = addQuantity + varianceCountPrevious;

		assertEquals("+" + varianceCountAfterValue, "+" + calculateValue, " First variance cal does not match !");
	}

	public void ClickOnCompleteSectionButton()throws InterruptedException {

		WebElement xpathConfirmCountButton  = driveR.findElement(By
				.xpath("//android.widget.Button[@text='CONFIRM COUNT AREA' or @text='Confirm Count Area']"));

		xpathConfirmCountButton.click();
		Thread.sleep(4000);
	}

	public void verifyConfirmCountPopup(String categoryName)throws InterruptedException {

		WebElement xpathAlertTitle  = driveR.findElement(By
				.xpath("//android.widget.TextView[@resource-id='"+env+":id/alertTitle']"));

		String titleName = xpathAlertTitle.getText();
		assertEquals(titleName, "Confirm Counts","Alert title text is not displayed");

		WebElement xpathAlertMessage  = driveR.findElement(By
				.xpath("//android.widget.TextView[@resource-id='android:id/message']"));
		String alertMessage = xpathAlertMessage.getText();
		assertEquals(alertMessage, "Are you sure you have completed your checks for "+categoryName+"?","Alert text is not displayed");

		WebElement xpathCancelButton  = driveR.findElement(By
				.xpath("//android.widget.Button[@text='CANCEL' or @text='Cancel']"));
		xpathCancelButton.isDisplayed();

		WebElement xpathConfirmButton  = driveR.findElement(By
				.xpath("//android.widget.Button[@text='CONFIRM' or @text='Confirm']"));
		xpathConfirmButton.isDisplayed();

		Thread.sleep(4000);
	}

	public void clickOnConfirmButton()throws InterruptedException {

		WebElement xpathConfirmButton  = driveR.findElement(By
				.xpath("//android.widget.Button[@text='CONFIRM' or @text='Confirm']"));
		xpathConfirmButton.isDisplayed();
		Thread.sleep(4000);
		xpathConfirmButton.click();
		Thread.sleep(4000);
	}



	public void verifyCompletedStatus()throws InterruptedException {

		WebElement xpathCompletedStatus  = driveR.findElement(By
				.xpath("//android.widget.TextView[@resource-id='"+env+":id/groups_section_status']"));

		String completedStatus =xpathCompletedStatus.getText();

		boolean isCompleted = false;
		if(completedStatus.contains("COMPLETED")){

			isCompleted = true;
		}
		assertEquals(isCompleted, true,"Completed status is not displayed");

		Thread.sleep(4000);
	}

	public void verifyProductInWarehouse()throws InterruptedException {

		WebElement xpathProduct  = driveR.findElement(By
				.xpath("//android.widget.TextView[@resource-id='"+env+":id/storewalk_list_item_description']"));

		String completedStatus =xpathProduct.getText();

	}

	public void verifySectionCount()throws InterruptedException {
		Thread.sleep(4000);
		WebElement xpathZeroOfZeroStatus  = driveR.findElement(By
				.xpath("//android.widget.TextView[@resource-id='"+env+":id/groups_section_status']"));

		String zeroOfZeroStatus =xpathZeroOfZeroStatus.getText();

		assertEquals(zeroOfZeroStatus, "0 of 0","0 of 0 status is not displayed");
		Thread.sleep(3000);
	}

	public void iDeleteGapAndLowProductFromFixture()throws InterruptedException {

		List<WebElement> xpathProductList  = driveR.findElements(By
				.xpath("//android.widget.TextView[@resource-id='"+env+":id/storewalk_list_item_description']"));

		List<WebElement> xpathProductListType  = driveR.findElements(By
				.xpath("//android.widget.TextView[@resource-id='"+env+":id/storewalk_list_item_type']"));

		//for(WebElement product : xpathProductList){
		for(int i = 0;i<=xpathProductList.size()-1;i++)
		{
			Thread.sleep(3000);

			String listType = xpathProductListType.get(i).getText();

			if(!(listType.contains("HIGH")||listType.contains("High")))
			{

				TouchAction ts = new TouchAction(driveR);
				ts.press(PointOption.point(520, 412)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
				.moveTo(PointOption.point(32, 412)).release().perform();
				Thread.sleep(7000);

				driveR.findElement(
						By.xpath("//android.widget.ImageView[@resource-id='"+env+":id/delete_button']"))
				.click();
			}
			else{
				break;
			}
		}

	}

	public void completeOffshelfCategories() throws InterruptedException{
		Thread.sleep(3000);
		List<WebElement> allCategories = driveR
				.findElements(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/header_title']"));

		List<String> categoriesList = new ArrayList<String>();
		for(WebElement category : allCategories){
			String categoryName = category.getText();
			categoriesList.add(categoryName);
		}

		for(String categoryy : categoriesList){
			driveR.findElement(By
					.xpath("//android.widget.TextView[@text='"+categoryy+"']"))
			.click();
			Thread.sleep(3000);

			try{
				driveR.findElement(By
						.xpath("//android.widget.TextView[@resource-id='"+env+":id/storewalk_list_item_description']"))
				.click();

				Thread.sleep(1000);
				driveR.findElement(By
						.xpath("//android.widget.EditText[@resource-id='"+env+":id/item_details_quantity_input']"))
				.click();

				Thread.sleep(1000);
				driveR.findElement(By
						.xpath("//android.widget.EditText[@resource-id='"+env+":id/item_details_quantity_input']"))
				.sendKeys("2");;

				Thread.sleep(1000);
				driveR.findElement(By
						.xpath("//android.widget.Button[@resource-id='"+env+":id/item_details_confirm_quantity']"))
				.click();

				Thread.sleep(1000);
				String qty = driveR.findElement(By
						.xpath("//android.widget.TextView[@resource-id='"+env+":id/stock_on_hand']"))
						.getText();
				/////assertEquals(qty, "2", " Qty name does not match !");
				Thread.sleep(1000);
			}
			catch(Exception e){
				System.out.println("No entry in Offshelf");
			}

			Thread.sleep(2000);
			driveR.findElement(By
					.xpath("//android.widget.TextView[@text='"+categoryy+"']"))
			.click();
		}
	}

	public void completePetrolCategories() throws InterruptedException{
		Thread.sleep(3000);
		List<WebElement> allCategories = driveR
				.findElements(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/header_title']"));


		List<String> categoriesList = new ArrayList<String>();
		for(WebElement category : allCategories){
			String categoryName = category.getText();
			categoriesList.add(categoryName);
		}

		for(String categoryy : categoriesList){
			driveR.findElement(By
					.xpath("//android.widget.TextView[@text='"+categoryy+"']"))
			.click();
			Thread.sleep(3000);
			try{
				driveR.findElement(By
						.xpath("//android.widget.TextView[@resource-id='"+env+":id/storewalk_list_item_description']"))
				.click();

				Thread.sleep(1000);
				driveR.findElement(By
						.xpath("//android.widget.EditText[@resource-id='"+env+":id/item_details_quantity_input']"))
				.click();

				Thread.sleep(1000);
				driveR.findElement(By
						.xpath("//android.widget.EditText[@resource-id='"+env+":id/item_details_quantity_input']"))
				.sendKeys("2");;

				Thread.sleep(1000);
				driveR.findElement(By
						.xpath("//android.widget.Button[@resource-id='"+env+":id/item_details_confirm_quantity']"))
				.click();

				Thread.sleep(1000);
				String qty = driveR.findElement(By
						.xpath("//android.widget.TextView[@resource-id='"+env+":id/stock_on_hand']"))
						.getText();
				///////assertEquals(qty, "2", " Qty name does not match !");
				Thread.sleep(1000);
			}
			catch(Exception e){
				System.out.println("No entry in Petrol");
			}

			Thread.sleep(1000);
			driveR.findElement(By
					.xpath("//android.widget.TextView[@text='"+categoryy+"']"))
			.click();
		}
	}

	public void verifyGreenLabel() throws InterruptedException{
		String greenLabelText = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/snackbar_text']")).getText();
		Thread.sleep(3000);
		assertEquals(greenLabelText, "Please place a Green out of stock ticket.","Green label text is mismatched");

		WebElement xpathOkButton = driveR.findElement(By.xpath("//android.widget.Button[@resource-id='"+env+":id/snackbar_action']"));
		xpathOkButton.isDisplayed();
	}

	public void verifyOrangeLabel() throws InterruptedException{
		String orangeLabelText = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/snackbar_text']")).getText();
		Thread.sleep(3000);
		assertEquals(orangeLabelText, "Please place an Orange out of stock ticket.","Orange label text is mismatched");
		WebElement xpathOkButton = driveR.findElement(By.xpath("//android.widget.Button[@resource-id='"+env+":id/snackbar_action']"));
		xpathOkButton.isDisplayed();
	}

	public void clickOnGroupAndVerifyIsEmpty()throws InterruptedException {

		List<WebElement> xpathGroupList = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/groups_section_header_title']"));
		List<String> groupName = new ArrayList<String>();
		for(WebElement group : xpathGroupList){
			groupName.add(group.getText());

		}

		for(String groupSection : groupName){
			Thread.sleep(2000);
			driveR.findElement(By.xpath("//android.widget.TextView[@text='"+groupSection+"']")).click();
			Thread.sleep(2000);
			
			verifyEmptyProductListIsDisplayed();
			verifyCompleteSectionButtonIsDisplayed();
			
			driveR.findElement(By.className("android.widget.ImageButton")).click();
			Thread.sleep(3000);

		}
	}

	public void clickOnGroup()throws InterruptedException {

		List<WebElement> xpathGroupList = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/groups_section_header_title']"));
		List<String> groupName = new ArrayList<String>();
		for(WebElement group : xpathGroupList){
			groupName.add(group.getText());

		}

		for(String groupSection : groupName){
			Thread.sleep(2000);
			driveR.findElement(By.xpath("//android.widget.TextView[@text='"+groupSection+"']")).click();
			Thread.sleep(2000);

			verifyEmptyProductListIsDisplayed();
			verifyCompleteSectionButtonIsDisplayed();

		}
	}
	
	public void clickOnReviewApproval()throws InterruptedException {
		Thread.sleep(2000);
		driveR.findElement(By.xpath("//android.widget.TextView[@text='APPROVAL' or @text='Approval']")).click();
	}
	
	public void verifyProductInApproval()throws InterruptedException {
		Thread.sleep(2000);
		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/header_title']")).isDisplayed();
	}
}

