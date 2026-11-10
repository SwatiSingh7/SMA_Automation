package com.morrisons.sma.page_objects.mobile.old;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.morrisons.common.PageFactory.InitClass;
import org.openqa.selenium.*;

import com.google.common.base.CharMatcher;
import com.google.common.collect.ImmutableMap;

import com.morrisons.common.action.Hook;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import com.morrisons.sma.step_definitions.mobile.old.CountPostStepDefService;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import org.openqa.selenium.interactions.Actions;

public class CountPO {

	private static AndroidDriver driveR;
	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
	String env = applicationConfig.getWebElementEnviroment().getEnv();
	String storeWalk = "store_walk";
	public static String name;
	public static String ids;
	public static String neames;
	public static String valueedit;
	public static String givenID;
	public static String Minids;
	public static String beforeValueText = null;
	public static int beforeValue = 0;
	public static String updatevaue  = null;
	public static String productMin  = null;
	public static String inputQtyText  = null;

	public CountPO() {
		this.driveR = (AndroidDriver) Hook.getDriver();
	}


	public static MobileDriver getDriver() {

		return driveR;

	}

	public void getMin(String min) {
		givenID = min;
	}


	public  void countClick () throws InterruptedException {
		Thread.sleep(10000);
		driveR.findElement(By.xpath("//android.widget.TextView[@text='Counts' or @text='COUNTS']"))
		.click();
		Thread.sleep(1000);

		String time = driveR.getDeviceTime();

		System.out.println("Device time is =" + time);

	}

	public void countOptClick() {
		driveR.findElement(By.xpath("//android.widget.TextView[@text='Counts']/parent::android.widget.LinearLayout/android.widget.TextView[contains(@resource-id,'submenu_option')]"))
				.click();
	}

	public  void countSectionClick () throws InterruptedException {
		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/counts']"))
		.click();
		Thread.sleep(1000);

	}

	public  void WarehouseClick () throws InterruptedException {
		driveR.findElement(By.xpath("//android.widget.TextView[@text='Warehouse' or @text='WAREHOUSE']"))
		.click();
		Thread.sleep(1000);

	}

	public  void fixtureClick () throws InterruptedException {
		driveR.findElement(By.xpath("//android.widget.TextView[@text='Fixture' or @text='FIXTURE']"))
		.click();
		Thread.sleep(1000);

	}

	public  void uncountedClick () throws InterruptedException {
		driveR.findElement(By.xpath("//android.widget.TextView[@text='Uncounted' or @text='UNCOUNTED']"))
		.click();
		Thread.sleep(1000);

	}
	public  void offShelfClick () throws InterruptedException {
		driveR.findElement(By.xpath("//android.widget.TextView[@text='Off Shelf' or @text='OFF SHELF']"))
		.click();
		Thread.sleep(1000);

	}
	public  void petrolClick () throws InterruptedException {
		Thread.sleep(1000);
		driveR.findElement(By.xpath("//android.widget.TextView[@text='Petrol' or @text='PETROL']"))
		.click();
		Thread.sleep(1000);

	}
	public  void reviewClick () throws InterruptedException {
		driveR.findElement(By.xpath("//android.widget.TextView[@text='Review' or @text='REVIEW']"))
		.click();
		Thread.sleep(1000);

	}

	public  void summaryClick () throws InterruptedException {
		driveR.findElement(By.xpath("//android.widget.TextView[@text='Counts Summary' or @text='COUNTS SUMMARY']"))
		.click();
		Thread.sleep(1000);

	}

	public  void wareHouseStatus () throws InterruptedException {
		Thread.sleep(1000);
		String status =	driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tvWarehouseComplete']"))
				.getText();


		System.out.println(status);

		String expectedValue = null;
		if(CharMatcher.javaUpperCase().matchesAllOf(status)){
			expectedValue = "COMPLETE";
		}
		else{
			expectedValue = "Complete";
		}

		assertEquals(status, expectedValue, "Incorrect message displayed");
		Thread.sleep(1000);

	}

	public  void fixtureStatus () throws InterruptedException {
		Thread.sleep(1000);
		String status =	driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tvFixtureComplete']"))
				.getText();



		String expectedValue = null;
		if(CharMatcher.javaUpperCase().matchesAllOf(status)){
			expectedValue = "COMPLETE";
		}
		else{
			expectedValue = "Complete";
		}

		assertEquals(status, expectedValue, "Incorrect message displayed");
		Thread.sleep(1000);

	}

	public void reqName(String names)throws InterruptedException{

		neames = names;


	}

	public  void warehouseDesc () throws Throwable {
try{
	WebElement oEle = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+neames+"']"));
	com.morrisons.common.helper.ElementRetry.waitForElementVisible(driveR,oEle);
	name = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+neames+"']"))
				.getText();
	//name = StorewalkService.sName;
		System.out.println("Name = " + name);
		Thread.sleep(3000);
		//CountPostStepDefService.nameFromApp(name);
	    verifyCountDisplay();
		driveR.findElement(By.xpath("//android.widget.TextView[@text='"+neames+"']")).click();
}
catch(Exception e){
	System.out.println(e.getMessage());
}
		try{
			 driveR.findElement(By.xpath("//android.widget.TextView[@text='Yes' or @text='YES']")).click();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	public  void verifyCountDisplay () throws Throwable {

		name = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+neames+"']"))
				.getText();
		System.out.println("Name = " + name);
		Thread.sleep(1000);
		CountPostStepDefService.nameFromApp(name);
	}

	public  void reviewDoneClick () throws InterruptedException {


		WebElement clickable = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+neames+"']"));
		String click = clickable.getAttribute("clickable");
		System.out.println("Greyout check  =" +click);
		assertEquals(click, "false", "Field is editable!");
	}



	public  boolean warehouseId () throws Throwable {
		boolean isProductPresent = false;
		try{
			ids = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+givenID+"']"))
					.getText();
			isProductPresent = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+givenID+"']"))
					.isDisplayed();
			System.out.println("ids = " + ids);
			Thread.sleep(1000);
			CountPostStepDefService.getPrdtFrmApp(ids);
			driveR.findElement(By.xpath("//android.widget.TextView[@text='"+givenID+"']")).click();
			Thread.sleep(4000);
		}
		catch(NoSuchElementException e){
			System.out.println(e.getMessage());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}


		return isProductPresent;
	}


	public void reviewDetails () throws InterruptedException {

		List<String> productMin = new ArrayList<String>();

		List<WebElement> xpathProductList =  driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/value']"));
		for(WebElement xpathProduct : xpathProductList){
			String productMinText = xpathProduct.getText();
			productMin.add(productMinText);

			System.out.println("Product min : " + productMinText);
		}

		for(String product : productMin){

			Minids = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+product+"']")).getText();
			driveR.findElement(By.xpath("//android.widget.TextView[@text='"+product+"']")).isDisplayed();

			System.out.println("ids = " + Minids);
			Thread.sleep(1000);
			CountPostStepDefService.reviewIdFrmApp(Minids);
			driveR.findElement(By.xpath("//android.widget.TextView[@text='"+product+"']")).click();
			Thread.sleep(1000);


			reviewConfirm();
		}
	}

	public void reviewConfirm () throws InterruptedException {
		Thread.sleep(3000);
		driveR.findElement(By.xpath("//android.widget.Button[@resource-id='" + env + ":id/confirmAllBtn']")).click();


	}


	public void checkMessage () throws InterruptedException {

		WebElement xpathCaseText = driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/packs']//android.widget.TextView[@resource-id='" + env + ":id/label']"));
		xpathCaseText.isDisplayed();

		Thread.sleep(1000);
		WebElement xpathCaseQty = driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/packs']//android.widget.TextView[@resource-id='" + env + ":id/value']"));
		xpathCaseQty.isDisplayed();
	}

	public  void editCount (String quantity) throws InterruptedException {

		try{
			driveR.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1']")).click();
			Thread.sleep(2000);
			driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();
		}
		catch(Exception e){System.out.println();}

		try
		{
			driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/item_details_quantity_input']")).click();
			Thread.sleep(2000);
			driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/item_details_quantity_input']")).sendKeys(quantity);
			Thread.sleep(2000);
			driveR.findElement(By.xpath("//android.widget.Button[@resource-id='" + env + ":id/item_details_confirm_quantity']")).click();
		}
		catch(Exception e){
			System.out.println("edit quantity textfield is not available");
		}
	}

	public  void editCountAnConfirm (String quantity) throws InterruptedException {

		try
		{
			driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/item_details_quantity_input']")).click();
			Thread.sleep(2000);
			driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/item_details_quantity_input']")).sendKeys(quantity);
			Thread.sleep(2000);
			driveR.findElement(By.xpath("//android.widget.Button[@resource-id='" + env + ":id/item_details_confirm_quantity']")).click();
			Thread.sleep(2000);
		}
		catch(Exception e){
			System.out.println("edit quantity textfield is not available");
		}

		try{
			driveR.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1']")).click();
			Thread.sleep(2000);
			driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();
			Thread.sleep(2000);
		}
		catch(Exception e){System.out.println();}


	}

	public  void verifyCount () throws InterruptedException {
		String item = CountPostStepDefService.productId;
		try{

			Thread.sleep(5000);

			driveR.findElement(
					By.xpath("//android.widget.LinearLayout[@resource-id='"+env+":id/singleItemHeader']"))
			.click();
		}catch(NoSuchElementException e){
			System.out.println(e.getMessage());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}


		updatevaue = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+item+"']//android.widget.TextView[@resource-id='" + env + ":id/warehouse_count']")).getText();

		System.out.println("Count  Matched");

	}

	public  void verifyUpdatedCount (String qty) throws InterruptedException {
		assertEquals(updatevaue, qty, "Count does not match");

	}

	public  void confirmCount () throws InterruptedException {

		try{

			Thread.sleep(5000);

			driveR.findElement(
					By.xpath("//android.widget.LinearLayout[@resource-id='"+env+":id/singleItemHeader']"))
			.click();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}

		driveR.findElement(By.xpath("//android.widget.Button[@text='CONFIRM COUNT AREA' or @text='Confirm Count Area' or @text='COMPLETE THIS COUNT' or @text='Complete This Count']")).click();
		Thread.sleep(1000);
		driveR.findElement(By.xpath("//android.widget.Button[@text='Confirm' or @text='CONFIRM']")).click();
		Thread.sleep(3000);

	}

	public  void completeCount () throws InterruptedException {
		driveR.findElement(By.xpath("//android.widget.Button[@text='COMPLETE THIS COUNT' or @text='Complete This Count']")).click();
		Thread.sleep(1000);
		driveR.findElement(By.xpath("//android.widget.Button[@text='Confirm' or @text='CONFIRM']")).click();


	}

	public  void enterUnCount () throws InterruptedException {

		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/storewalk_list_item_description']")).click();
		Thread.sleep(1000);

	}

	public  void uncountComplete () throws InterruptedException {

		String text = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tvUncountedComplete']")).getText();
		Thread.sleep(1000);

		String expectedValue = null;
		if(CharMatcher.javaUpperCase().matchesAllOf(text)){
			expectedValue = "COMPLETE";
		}
		else{
			expectedValue = "Complete";
		}

		assertEquals(text, expectedValue, "Count does not match");
	}

	public  void confirmUncount () throws InterruptedException {

		String text = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']")).getText();
		assertEquals(text, "You have completed Warehouse and Fixture for this count, now please check your Uncounted products. These are the products where stock record is not 0.", "Message does not match");
		System.out.println("Complete message displayed");
		Thread.sleep(1000);
		driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();

	}

	public void selectfromCountlist() throws Throwable {
		try {
			Boolean getPrice = driveR
					.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1']"))
					.isDisplayed();

			if (getPrice = true) {
				driveR.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1']"))
				.click();

				Thread.sleep(3000);
				driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();
				Thread.sleep(3000);

			} else {

				driveR.findElement(By.xpath("//android.widget.Button[@resource-id='" + env + ":id/inner_button']")).isDisplayed();
			}

		} catch (Exception e) {
			driveR.findElement(By.xpath("//android.widget.Button[@resource-id='" + env + ":id/inner_button']")).isDisplayed();

		}

	}


	public void selectfromCountlistPM() throws Throwable {
		try {
			Boolean getPrice = driveR
					.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1']"))
					.isDisplayed();

			if (getPrice = true) {
				driveR.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1']"))
				.click();

				Thread.sleep(3000);
				driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();
				Thread.sleep(3000);

			} else {

				driveR.findElement(By.xpath("//android.widget.RelativeLayout[@resource-id='" + env + ":id/singleItemHeader']")).isDisplayed();
			}

		} catch (Exception e) {
			driveR.findElement(By.xpath("//android.widget.RelativeLayout[@resource-id='" + env + ":id/singleItemHeader']")).isDisplayed();

		}

	}


	public  void selectCompletedCount () throws InterruptedException {

		driveR.findElement(By.xpath("//android.widget.TextView[@text='"+neames+"']")).click();
		Thread.sleep(1000);
	}

	public  void selectYesButton () throws InterruptedException {
		driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();
		Thread.sleep(1000);

	}

	public void selectOffshelfNme() throws InterruptedException {

		driveR.findElement(By.xpath("//android.widget.TextView[@text='"+neames+"']")).click();
		Thread.sleep(1000);


	}

	public void selectProduct() throws Throwable {

		try
		{
			driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/header_title']")).click();
			Thread.sleep(1000);

			driveR.findElement(By.xpath("//android.widget.TextView[@text='"+givenID+"']")).click();
			Thread.sleep(1000);
		}
		catch(Exception e){
			System.out.println("Product not available");
		}

	}

	public void offshelfConfirm() throws InterruptedException {

		Thread.sleep(1000);
		driveR.findElement(By.xpath("//android.widget.Button[@resource-id='" + env + ":id/inner_button']")).click();
	}

	public void verifyConfirmCounts(String alert) throws InterruptedException {

		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/alertTitle']")).isDisplayed();
		String alertName = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/alertTitle']")).getText();
		assertEquals(alertName, alert, "Alert name is mismatched");

		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button2']")).isDisplayed();
	}

	public void clickOnConfirmButton() throws InterruptedException {

		driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();
	}

	public void getSOHQuantity() throws InterruptedException {

		beforeValueText = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/stock_on_hand']")).getText();
		beforeValue = Integer.parseInt(beforeValueText);
	}

	public void getQuantity() throws InterruptedException {
		try{
			driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='"+env+":id/singleItemHeader']")).click();

		}catch(Exception e){
			System.out.println(e.getMessage());
		}

		WebElement xpathProductList = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/storewalk_list_item_min']"));
		productMin = xpathProductList.getText();
		Thread.sleep(2000);
		beforeValueText = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+productMin+"']//following::android.widget.TextView[@resource-id='" + env + ":id/warehouse_count']")).getText();
		beforeValue = Integer.parseInt(beforeValueText);
	}


	public void verifyAddEditCount() throws InterruptedException {
		driveR.findElement(By.xpath("//android.widget.Button[@text='EDIT COUNT' or @text='Edit Count']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.Button[@text='ADD TO COUNT' or @text='Add To Count']")).isDisplayed();
	}


	public  void editCheck (String qty) throws Throwable {
		int addQuantity = 2;
		int quantity = Integer.parseInt(qty) + addQuantity;

		inputQtyText = String.valueOf(quantity);

		driveR.findElement(By.xpath("//android.widget.Button[@text='EDIT COUNT' or @text='Edit Count']")).isDisplayed();
		Thread.sleep(1000);
		driveR.findElement(By.xpath("//android.widget.Button[@text='EDIT COUNT' or @text='Edit Count']")).click();
		Thread.sleep(1000);
		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/itemCountCalculation']")).click();

		Thread.sleep(1000);
		driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/item_details_quantity_input']")).clear();
		Thread.sleep(1000);
		driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/item_details_quantity_input']")).sendKeys(inputQtyText);
		Thread.sleep(1000);
		driveR.findElement(By.xpath("//android.widget.Button[@resource-id='" + env + ":id/item_details_confirm_quantity']")).click();
		Thread.sleep(1000);

		selectfromCountlist(); ///Select location from popup

		System.out.println("Before value : " + beforeValue);

	}

	public  void addCheck (String qty) throws Throwable {
		inputQtyText = qty;

		int inputQty = Integer.parseInt(inputQtyText);

		driveR.findElement(By.xpath("//android.widget.Button[@text='ADD TO COUNT' or @text='Add To Count']")).click();
		Thread.sleep(1000);
		driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/item_details_quantity_input']")).click();
		driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/item_details_quantity_input']")).clear();
		Thread.sleep(1000);
		driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/item_details_quantity_input']")).sendKeys(inputQtyText);
		Thread.sleep(1000);
		driveR.findElement(By.xpath("//android.widget.Button[@resource-id='" + env + ":id/item_details_confirm_quantity']")).click();
		Thread.sleep(1000);

		selectfromCountlist(); ///Select location from popup

		System.out.println("Before value : " + beforeValue);
	}

	public  void verifyQtyIsUpdated(String action) throws Throwable {

		int inputQty = Integer.parseInt(inputQtyText);

		////String afterValueText = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+productMin+"']//following::android.widget.TextView[@resource-id='" + env + ":id/warehouse_count'] or //android.widget.TextView[@resource-id='" + env + ":id/stock_on_hand']")).getText();

		String afterValueText = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/warehouse_count' or @resource-id='" + env + ":id/stock_on_hand']")).getText();
		int afterValue = Integer.parseInt(afterValueText);
		System.out.println("After value : " + afterValue);
		int totalValue = 0;

		if(action.equalsIgnoreCase("Add")){
			totalValue = beforeValue + inputQty;
		}
		else{
			if(action.equalsIgnoreCase("Edit")){
				totalValue = beforeValue + 2;
			}
		}

		String totalValueText = String.valueOf(totalValue);
		System.out.println("Total value : " + totalValue);

		assertEquals(totalValueText, afterValueText, "Qty not updated!");
	}

	public  void statusComplete (String name) throws InterruptedException {


		List<WebElement> countStorwalks = driveR.findElements(By.xpath("//android.widget.RelativeLayout[@resource-id='" + env + ":id/llParent']"));

		for(int i = 0;i<=countStorwalks.size()-1;i++)
		{
			String  storewalkName = driveR.findElement(By.xpath("//android.widget.RelativeLayout[@resource-id='" + env + ":id/llParent' and @index='"+i+"']//android.widget.TextView")).getText();

			if(storewalkName.equalsIgnoreCase(name))
			{
				String  status;
				try{
					status = driveR.findElement(By.xpath("//android.widget.RelativeLayout[@resource-id='" + env + ":id/llParent' and @index='"+i+"']//android.widget.LinearLayout//android.widget.TextView[@resource-id='" + env + ":id/tvComplete']")).getText();

				}
				catch(Exception e){
					status = "Not Completed";
				}
				String expectedValue = null;
				if(CharMatcher.javaUpperCase().matchesAllOf(status)){
					expectedValue = "COMPLETE";
				}
				else{
					expectedValue = "Complete";
				}
				assertEquals(status, expectedValue, "Message does not match");
				System.out.println("Complete message displayed");
				Thread.sleep(1000);
			}
		}
	}

	public  void verifyCountStatus (String name) throws InterruptedException {
		String status = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+name+"']//following::android.widget.TextView[@resource-id='" + env + ":id/tvComplete']")).getText();
		String expectedValue = null;
		if(CharMatcher.javaUpperCase().matchesAllOf(status)){
			expectedValue = "COMPLETE";
		}
		else{
			expectedValue = "Complete";
		}

		assertEquals(status, expectedValue, "Message does not match");
		System.out.println("Complete message displayed");
		Thread.sleep(1000);
	}


	public  void notStartTime () throws InterruptedException {

		System.out.println("Product selected = " + neames);
		driveR.findElement(By.xpath("//android.widget.TextView[@text='"+neames+"']")).click();

		Thread.sleep(1000);
		String text = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']")).getText();
		assertEquals(text, "Count cannot be started yet.", "Message does not match");
		System.out.println("Complete message displayed");
		Thread.sleep(1000);
		driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();
	}

	public  void endStartTime () throws InterruptedException {

		driveR.findElement(By.xpath("//android.widget.TextView[@text='"+neames+"']")).click();

		Thread.sleep(1000);
		String text = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']")).getText();
		assertEquals(text, "The deadline for this count has now passed.", "Message does not match");
		System.out.println("Complete message displayed");
		Thread.sleep(1000);
		driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();
	}


	public  void reviewStatusComplete () throws InterruptedException {

		String text = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/reviewComplete']")).getText();

		String expectedValue = null;
		if(CharMatcher.javaUpperCase().matchesAllOf(text)){
			expectedValue = "COMPLETE";
		}
		else{
			expectedValue = "Complete";
		}

		assertEquals(text, expectedValue, "Message does not match");
		System.out.println("Completed message displayed");
		Thread.sleep(1000);

	}

	public  void chexkBoxNames () throws InterruptedException {
		String Wh = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/WH_check']"))
				.getText();
		Thread.sleep(1000);
		assertEquals(Wh, "Warehouse", "WareHouse not present");

		String fixture = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/fixture_check']"))
				.getText();
		Thread.sleep(1000);

		System.out.println(fixture);
		assertEquals(fixture, "Fixture", "Fixture not present");

		String offshelf = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/off_shelf_check']"))
				.getText();
		Thread.sleep(1000);

		System.out.println(offshelf);

		assertEquals(offshelf, "Offshelf", "Offshelf not present");

		String petrol = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/petrol_check']"))
				.getText();
		Thread.sleep(1000);

		assertEquals(petrol, "Petrol", "Petrol not present");

//		String UN = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/count_uncounted_location']"))
//				.getText();
//		assertEquals(UN, "UN", "Petrol not present");
		System.out.println("Assertions Completed !");
	}

	public  void chexkBoxcheck () throws InterruptedException {
		WebElement Wh = driveR.findElement(By.xpath("//android.widget.CheckBox[@resource-id='" + env + ":id/WH_check']"));
		String whStatus = Wh.getAttribute("checked");
		System.out.println("Warehouse status = " + whStatus);
		assertEquals(whStatus, "true", "Warehouse not checked");
		Thread.sleep(1000);


		WebElement  fixture = driveR.findElement(By.xpath("//android.widget.CheckBox[@resource-id='" + env + ":id/fixture_check']"));
		String  fixStatus =	fixture.getAttribute("checked");
		Thread.sleep(1000);
		System.out.println("fixture status " + fixStatus);
		assertEquals(fixStatus, "true", "fixture not checked");
		Thread.sleep(1000);


		WebElement offshelf = driveR.findElement(By.xpath("//android.widget.CheckBox[@resource-id='" + env + ":id/offshelf_check']"));
		Thread.sleep(1000);
		String  offshelfStatus =	offshelf.getAttribute("checked");
		System.out.println("offshelf status = " + offshelfStatus);
		assertEquals(offshelfStatus, "true", "offshelf not checked");
		Thread.sleep(1000);


		WebElement petrol = driveR.findElement(By.xpath("//android.widget.CheckBox[@resource-id='" + env + ":id/petrol_check']"));
		String  petrolStatus =	petrol.getAttribute("checked");
		Thread.sleep(1000);
		System.out.println("petrol status = " + petrolStatus);
		assertEquals(petrolStatus, "true", "petrolStatus not checked");
		Thread.sleep(1000);


		WebElement UN = driveR.findElement(By.xpath("//android.widget.CheckBox[@resource-id='" + env + ":id/uncounted_check']"));
		String  UNStatus =	UN.getAttribute("checked");
		Thread.sleep(1000);
		System.out.println("UN status = " + UNStatus);
		assertEquals(UNStatus, "true", "petrolStatus not checked");
		Thread.sleep(1000);
		System.out.println("Assertions Completed !");
	}

	public void selectDesc() throws InterruptedException {

		System.out.println("Item selected = " + neames);
		driveR.findElement(By.xpath("//android.widget.TextView[@text='"+neames+"']")).click();
		Thread.sleep(1000);


	}

	public void dispMsg() throws InterruptedException {

		driveR.findElement(By.xpath("//android.widget.TextView[@text='Count Pending' or @text='COUNT PENDING']")).isDisplayed();
		Thread.sleep(1000);
		String pendingMsg = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']")).getText();
		assertEquals(pendingMsg, "Please be aware that Warehouse, Fixture and Uncounted must be complete before starting this location", "Incorrect message displayed");
		Thread.sleep(1000);
		driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();
	}

	public void reOpenMsg() throws InterruptedException {

		////		driveR.findElement(By.xpath("//android.widget.TextView[@text='Complete' or @text='COMPLETE']")).isDisplayed();
		////		Thread.sleep(1000);
		////		driveR.findElement(By.xpath("//android.widget.TextView[@text='"+neames+"']")).click();

		String pendingMsg = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/alertTitle']")).getText();
		assertEquals(pendingMsg, "Confirm Reopen Counts", "Incorrect message displayed");
		Thread.sleep(1000);
		String pendingMsg1 = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']")).getText();
		assertEquals(pendingMsg1, "Are you sure you want to reopen this count location?", "Incorrect message displayed");
		Thread.sleep(1000);
		driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();
		Thread.sleep(2000);
	}

	public void shelfCount() throws InterruptedException {

		driveR.findElement(By.xpath("//android.widget.Button[@resource-id='" + env + ":id/inner_button']")).click();
		Thread.sleep(1000);
		driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();
		Thread.sleep(1000);


	}

	public void selectTheProduct() throws InterruptedException {

		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/storewalk_list_item_description']")).click();
		Thread.sleep(1000);
	}

	public void clickOnAddToCount() throws InterruptedException {

		driveR.findElement(By.xpath("//android.widget.Button[@text='ADD TO COUNT' or @text='Add To Count']")).click();
		Thread.sleep(1000);
	}

	public void clickOnEditCount() throws InterruptedException {
		Thread.sleep(1000);
		driveR.findElement(By.xpath("//android.widget.Button[@text='EDIT COUNT' or @text='Edit Count']")).click();

	}

	public void selectProductAndConfirmCount(String qty) throws Throwable {
		List<String> productDescriptions = new ArrayList<String>();
		boolean isPresent = true;
		List<WebElement> productList = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/storewalk_list_item_description']"));

		for(WebElement productName : productList){
			String name = productName.getText();
			productDescriptions.add(name);
		}



		for(String product : productDescriptions){

			driveR.findElement(By.xpath("//android.widget.TextView[@text='"+product+"']")).click();

			try{
				WebElement xpathEditButton = driveR.findElement(By.xpath("//android.widget.Button[@text='EDIT COUNT' or @text='Edit Count']"));
				WebElement xpathAddButton = driveR.findElement(By.xpath("//android.widget.Button[@text='ADD TO COUNT' or @text='Add To Count']"));

				if(xpathEditButton.isDisplayed()||xpathAddButton.isDisplayed()){
					Thread.sleep(3000);
					isPresent = false;

					Thread.sleep(3000);
					driveR.findElement(By.className("android.widget.ImageButton")).click();
					Thread.sleep(3000);
				}
			}catch(NoSuchElementException e){
				System.out.println(e.getMessage());
			}

			if(isPresent){
				Thread.sleep(3000);
				editCount(qty);
				selectfromCountlist();
				verifyCount();
			}
		}

		Thread.sleep(2000);
	}

	public void verifyProducts()  throws Throwable {
		getQuantity();
	}

	public void selectTheProduct(String productMin)  throws Throwable {



		try{
			driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='"+env+":id/singleItemHeader']")).click();

		}catch(NoSuchElementException e){
			System.out.println(e.getMessage());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}

		verifyProducts();
		try{
			driveR.findElement(By.xpath("//android.widget.TextView[@text='"+productMin+"']")).isDisplayed();
			driveR.findElement(By.xpath("//android.widget.TextView[@text='"+productMin+"']")).click();
		}catch(NoSuchElementException e){
			System.out.println(e.getMessage());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}

	}


	public void selectProductFromCount() throws Throwable {
		Thread.sleep(3000);
		try{
			Minids = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+givenID+"']")).getText();
			driveR.findElement(By.xpath("//android.widget.TextView[@text='"+givenID+"']")).isDisplayed();

			System.out.println("ids = " + Minids);
			Thread.sleep(1000);
			CountPostStepDefService.reviewIdFrmApp(Minids);
			driveR.findElement(By.xpath("//android.widget.TextView[@text='"+givenID+"']")).click();
			Thread.sleep(1000);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	public void selectCaptureCount() throws Throwable {
		WebElement xpathCaptureCount = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/capture_count_label']"));
		xpathCaptureCount.isDisplayed();
		xpathCaptureCount.click();
		Thread.sleep(1000);

	}

	public void verifyQuantityIsUpdated(String quantity) throws Throwable {
		Thread.sleep(3000);
		WebElement xpathCaptureCount = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/capture_count_count']"));
		xpathCaptureCount.isDisplayed();

		String updatedQuantity = xpathCaptureCount.getText();
		System.out.println("Updated quantity : " + updatedQuantity);
		System.out.println("Expected quantity : " + quantity);

		assertEquals(updatedQuantity, quantity,"Quantity is not updated in Review section");
	}

	public void verifyReopenAlert(String title) throws Throwable {
		WebElement xpathReopenAlert = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/alertTitle']"));
		xpathReopenAlert.isDisplayed();
		String titleName = xpathReopenAlert.getText();
		assertEquals(title, titleName,"Reopen alert title is mismatched");
		Thread.sleep(1000);

	}

	public void verifyReopenAlertMessage(String message) throws Throwable {
		WebElement xpathReopenAlert = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']"));
		xpathReopenAlert.isDisplayed();
		String messageText = xpathReopenAlert.getText();
		assertEquals(message, messageText,"Reopen alert message is mismatched");
		Thread.sleep(1000);

	}

	public void verifyReopenAlertOptions() throws Throwable {
		WebElement xpathNoOption = driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button2']"));
		xpathNoOption.isDisplayed();

		WebElement xpathYesOption = driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']"));
		xpathYesOption.isDisplayed();
	}

	public void clickOnNoOption() throws Throwable {
		WebElement xpathNoOption = driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button2']"));
		xpathNoOption.isDisplayed();
		xpathNoOption.click();
	}

	////// Select first product from list
	public void selectProductFromList()  throws Throwable {

		WebElement xpathProduct = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/storewalk_list_item_min']"));
		xpathProduct.click();

	}

	public void clickOnCategoryHeader()  throws Throwable {

			 driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/header_title']")).isDisplayed();
			 driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/header_title']")).click();
	}

	public void completeCountSection(String quantity) throws InterruptedException{
		boolean productListPresent = false;
		try{
			productListPresent = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/header_title']")).isDisplayed();
		}
		catch(Exception e){System.out.println(e.getMessage());}

		if(productListPresent){
			List<String> categoryList = new ArrayList<String>();
			List<String> productList = new ArrayList<String>();

			List<WebElement> allCategories = driveR
					.findElements(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/header_title']"));

			for(WebElement category : allCategories){

				categoryList.add(category.getText());
			}

			for(String categoryName : categoryList)
			{
				String categoryStatus = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+categoryName+"']//following::android.widget.TextView[@resource-id='"+env+":id/header_status']")).getText();

				if(!categoryStatus.equalsIgnoreCase("Completed")){

					driveR.findElement(By.xpath("//android.widget.TextView[@text='"+categoryName+"']")).click();

					List<WebElement> allProducts = driveR
							.findElements(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/storewalk_list_item_min']"));

					for(WebElement product : allProducts){
						productList.add(product.getText());
					}

					for(String productMin : productList){
						driveR.findElement(By.xpath("//android.widget.TextView[@text='"+productMin+"']")).click();
						editCountAnConfirm(quantity);
					}
					driveR.findElement(By.xpath("//android.widget.TextView[@text='"+categoryName+"']")).click();
					productList.clear();
				}
			}
		}
		else{


			Thread.sleep(3000);

			driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/action_barcode_entry']"))
			.click();

			boolean isProductFound = false;
			driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/action_barcode_entry' or @resource-id='" + env + ":id/barcode_entry_edit_text']"))
			.sendKeys(givenID);


			driveR.executeScript("mobile:performEditorAction", ImmutableMap.of("com/morrisons/common/action","search"));

			Thread.sleep(3000);

			editCount(quantity);
		}

	}

	public void verifyDaySpinnerDisplayed()  throws Throwable {

		WebElement xpathDaySpinner = driveR.findElement(By.xpath("//android.widget.Spinner[@resource-id='"+env+":id/day_spinner']"));
		xpathDaySpinner.isDisplayed();

	}

	public void clickOnDaySpinner()  throws Throwable {

		WebElement xpathDaySpinner = driveR.findElement(By.xpath("//android.widget.Spinner[@resource-id='"+env+":id/day_spinner']"));
		xpathDaySpinner.click();

	}

	public void verifyDaySpinnerOptions()  throws Throwable {

		List<WebElement> xpathDaySpinnerOptions = driveR.findElements(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1']"));

		String dayOption1 = xpathDaySpinnerOptions.get(0).getText();
		assertEquals(dayOption1, "Today","Day 1 spinner option is mismatched");

		String dayOption2 = xpathDaySpinnerOptions.get(1).getText();
		assertEquals(dayOption2, "Yesterday","Day 2 spinner option is mismatched");

		Date date = new Date();

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dd = calendar.get(Calendar.DAY_OF_MONTH) - 2;
		String dateText = null;
		if(dd>0 && dd<=9){
			dateText = "0"+String.valueOf(dd);
		}
		else{
			dateText = String.valueOf(dd);
		}
		int mm = calendar.get(Calendar.MONTH) +  1;
		String monthText = null;
		if(mm>0 && mm<=9){
			monthText = "0"+String.valueOf(mm);
		}
		else{
			monthText = String.valueOf(mm);
		}
		String expectedDate = dateText+"/"+monthText;
		System.out.println("Datee : " + expectedDate);

		String dayOption3 = xpathDaySpinnerOptions.get(2).getText();
		assertEquals(dayOption3, expectedDate,"Day 3 spinner option is mismatched");

		xpathDaySpinnerOptions.get(0).click();
	}

	public void getQuantity(List<WebElement> oEle) {
		Actions actionObject = new Actions(driveR);
		if(oEle.size() > 0) {
			for (int i = 0; i < oEle.size(); i++) {
				beforeValueText = oEle.get(i).getText();
				beforeValue = beforeValue + Integer.parseInt(beforeValueText);
				if(i>=oEle.size()-3 && oEle.size()-3 > 0){
					actionObject = actionObject.sendKeys(Keys.ARROW_DOWN); //ASSIGN the return or you lose this event.
					actionObject.perform();
				}
			}
		}
		else{
				beforeValue = 0;
			}
	}

	public void verifyQtyIsUpdated7(String action, String MinNo, String inputQty) throws InterruptedException {
		String afterValueText = null;
		Thread.sleep(3000);
		//List<WebElement> oChildEle = driveR.findElement(By.tagName("android.widget.RelativeLayout")).findElements(By.tagName("android.widget.TextView"));
		List<WebElement> oEle = driveR.findElements(By.className("android.widget.RelativeLayout"));
		boolean sFound = false;
		try {
		for(int i=0;i<oEle.size();i++){
			List<WebElement> oChildEle = oEle.get(i).findElements(By.className("android.widget.TextView"));
			System.out.println("oChildEle size ......." + oChildEle.size());
				for(int j=0;j<oChildEle.size();j++) {
					String sQty = oChildEle.get(j).getText();
					System.out.println(sQty);
					if(sQty.contains(MinNo)) {
						afterValueText = oChildEle.get(j+1).getText();
						int k=j+1;
						while(!afterValueText.contains("Qty")){
							afterValueText = oChildEle.get(k).getText();
							k++;
						}
						System.out.println("afterValueText ......." + afterValueText);
						sFound = true;
						break;
					}
					}
				if(sFound == true){
					break;
				}
				}

		//--------------------------

			String[] arrAfterValue = new String[0];
			System.out.println("afterValueText " + afterValueText);
			arrAfterValue = afterValueText.split("[ ]");

			int afterValue = Integer.parseInt(arrAfterValue[arrAfterValue.length - 1]);
			System.out.println("After value : " + afterValue);
			int totalValue = 0;

			if (action.equalsIgnoreCase("Add")) {
				totalValue = beforeValue + Integer.parseInt(inputQty);
			} else {
				if (action.equalsIgnoreCase("Edit")) {
					totalValue = beforeValue + 2;
				}
			}

			String totalValueText = String.valueOf(totalValue);
			System.out.println("Total value : " + totalValue);

			assertEquals(String.valueOf(afterValue), totalValueText, "Qty not updated!");
		}
		catch(IndexOutOfBoundsException ie){

		}
		//------------------------------


	}

	//----------------------------------------------------
	public void verifyReviewQtyIsUpdated7(String action, String minNo, String qty, String categoryName) {

		{
			String ic = null;
			List<WebElement> oDept = driveR.findElements(By.xpath("//android.widget.LinearLayout"));
			for(int i=0;i<oDept.size();i++){
				try {
					if (oDept.get(i).findElements(By.xpath("//android.widget.TextView")).get(0).getText().equalsIgnoreCase(categoryName)) {
						ic = oDept.get(i).findElements(By.xpath("//android.widget.TextView")).get(3).getText();
						break;
					}
				}
				catch(Exception e){}
			}
			//String ic =driveR.findElement(By.xpath("//parent::android.widget.TextView[@text='"+categoryName+"']/following-sibling::android.widget.TextView[@resource-id='" + env + ":id/text_incomplete']")).getText();
			//String ic =driveR.findElement(By.xpath("//android.widget.TextView[@text='"+categoryName+"']|/android.widget.TextView[@index='2']")).getText();


			System.out.println("IC Count:---" + ic);

			System.out.println("capture type--" + ic);
			String eXpected = String.valueOf(qty);
			System.out.println("Actuall IC --" + qty);

			assertEquals(ic, eXpected);

		}
	}
		public void CompeteSchedule(List<WebElement> oEle1, String sDeptList, String sPageName) throws InterruptedException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, NoSuchFieldException {
				List<WebElement> oEle2 = InitClass.createMultipleObjects(driveR, sDeptList, "sLocatorName", "com.morrisons.sma.page_objects.mobile." + sPageName);
				for(int j=0;j<oEle2.size();j++) {
					oEle2.get(j).click();
					GLHPageObject implementaion = new GLHPageObject();
					implementaion.clickBackButton();
					oEle2 = InitClass.createMultipleObjects(driveR, sDeptList, "sLocatorName", "com.morrisons.sma.page_objects.mobile." + sPageName);
				}
				GLHPageObject implementaion = new GLHPageObject();
				implementaion.clickBackButton();

		}

	private void CompeteSchedule(List<WebElement> oEle2, int i) throws InterruptedException {
		int repeat = 0;
		try {
		oEle2.get(i).click();
		GLHPageObject implementaion = new GLHPageObject();
		implementaion.clickBackButton();
		} catch (StaleElementReferenceException se) {
			if(repeat<7) {
				repeat++;
				CompeteSchedule(oEle2, i);
			}
		}
	}

}
