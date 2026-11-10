package com.morrisons.sma.page_objects.mobile.old;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import com.morrisons.common.action.Hook;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import com.morrisons.sma.page_objects.service.StorewalkServicePage;
import com.morrisons.sma.pojo.service.MarkdownPOJO.MarkdownLoginVo;
import com.morrisons.sma.step_definitions.service.old.RestAssuredSteps;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.KeyEventFlag;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.http.HttpResponse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import java.net.URI;
import java.time.Duration;
import java.util.*;

import static org.testng.Assert.assertEquals;

public class GlhNegativePromptPO {


	public static Map<String, String> headers = new HashMap<>();
	static ObjectMapper objectMapper = new ObjectMapper();
	public static HttpResponse Response;
	public static io.restassured.response.Response restResponse;
	MarkdownLoginVo mDLoginJsonResp = new MarkdownLoginVo();
	RestAssuredSteps loginTocken = new RestAssuredSteps();
	private static AndroidDriver driveR;

	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();

	static String accessTocken;
	String accessTockenGLH;
	String markdownBarcodeTest;
	String complete;
	String tokenaccess;
	String env = applicationConfig.getWebElementEnviroment().getEnv();
	public static URI currentUri;
	public static String mDAccessTocken;

	String collegueUsername = applicationConfig.getUserCredentials().getCollegueUsername();
	String colleguePassword = applicationConfig.getUserCredentials().getColleguePassword();
	String managerUsername = applicationConfig.getUserCredentials().getManagerUsername();
	String managerPassword = applicationConfig.getUserCredentials().getManagerPassword();

	public static ArrayList<String> categoryListOffshelf = new ArrayList<String>();
	public static ArrayList<String> productMinListOffshelf = new ArrayList<String>();

	public static Map<String, ArrayList<String>> offshelfList = new HashMap<String, ArrayList<String>>();
	public static ArrayList<String> categoryListPetrol = new ArrayList<String>();
	public static ArrayList<String> productMinListPetrol = new ArrayList<String>();

	public static ArrayList<String> categoryListWarehouse = new ArrayList<String>();
	public static ArrayList<String> sectionWarehouse = new ArrayList<String>();

	public static String categoryOffshelf = null;
	public static String categoryOffshelfMin = null;
	public static int productCountInOffshelf = 0;

	Map<String,String> groupSectionListUI = new TreeMap<String,String>();

	public static String categoryName =null;
	public static String productMinText =null;
	Map<String,String> deptNameAndStatus = new TreeMap<String,String>();

	public GlhNegativePromptPO() {
		this.driveR = (AndroidDriver) Hook.getDriver();
		// DatefromApp = "2019-10-21";
	}

	public void verifyProductListIsNotDisplayed() throws Throwable{
		boolean isViewListPresent = false;
		Thread.sleep(3000);
		try{
			driveR.findElement(
					By.xpath("//android.widget.LinearLayout[@resource-id='"+env+":id/singleItemHeader']")).isDisplayed();

			isViewListPresent = true;
		}
		catch(Exception e){
			Thread.sleep(3000);
		}
		assertEquals(isViewListPresent, false, "Negative prompt list is displayed in fixture");
		Thread.sleep(3000);
	}

	public void verifyProductListIsDisplayed() throws Throwable{
		Thread.sleep(3000);


	}

	///Verify negative promt product list in offeshelf location
	public void verifyNegativePromptListOffshelf() throws Throwable{
		Thread.sleep(5000);
		boolean promptedListPresent = false;
		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/listHeaderQuantity']")).isDisplayed();


		List<WebElement> xpathPromptedList= driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/header_title']"));

		System.out.println("count : "+xpathPromptedList.size());

		if(xpathPromptedList.size()>=1){
			promptedListPresent = true;
		}
		assertEquals(promptedListPresent, true, "Negative prompted product list is not present in offshelf location");
	}

	///Verify negative promt product list in petrol location
	public void verifyNegativePromptListPetrol() throws Throwable{
		Thread.sleep(3000);
		boolean promptedListPresent = false;

		List<WebElement> xpathPromptedList = driveR.findElements(
				By.xpath("//android.widget.TextView[@resource-id='"+env+":id/header_title']"));

		if(!xpathPromptedList.isEmpty()){
			promptedListPresent = true;
		}
		assertEquals(promptedListPresent, true, "Negative prompted product list is not present in petrol location");
	}

	///Verify negative promt product list in warehouse location
	public void verifyNegativePromptListWarehouse() throws Throwable{
		Thread.sleep(3000);
		boolean promptedListPresent = false;

		List<WebElement> xpathPromptedList = driveR.findElements(
				By.xpath("//android.widget.TextView[@resource-id='"+env+":id/header_title']"));

		if(!xpathPromptedList.isEmpty()){
			promptedListPresent = true;
		}
		assertEquals(promptedListPresent, true, "Negative prompted product list is not present in warehouse location");
	}

	///Get categories in petrol location
	public void getCategoriesFromPetrol() throws Throwable{

		Thread.sleep(3000);
		boolean promptedListPresent = false;
		String categoryName =null;
		String productMinText =null;


		List<WebElement> xpathPromptedList = driveR.findElements(
				By.xpath("//android.widget.TextView[@resource-id='"+env+":id/header_title']"));

		for(WebElement promptedList : xpathPromptedList){
			Thread.sleep(3000);
			categoryName = promptedList.getText();
			categoryListPetrol.add(categoryName);
		}

		for(String category : categoryListPetrol){
			driveR.findElement(By.xpath("//android.widget.TextView[@text='"+category+"']")).click();
			Thread.sleep(3000);

			List<WebElement> xpathProductMin = driveR.findElements(
					By.xpath("//android.widget.TextView[@resource-id='"+env+":id/storewalk_list_item_min']"));

			for(WebElement productMin : xpathProductMin){
				Thread.sleep(3000);
				productMinText = productMin.getText();
				productMinListPetrol.add(productMinText);

				//driveR.findElement(By.xpath("//android.widget.TextView[@text='"+category+"']")).click();
				Thread.sleep(2000);
			}
		}

	}

	///Get categories in offshelf location
	public void getCategoriesFromOffshelf() throws Throwable{
		Thread.sleep(3000);
		boolean promptedListPresent = false;
		String categoryName =null;
		String productMinText =null;


		List<WebElement> xpathPromptedList = driveR.findElements(
				By.xpath("//android.widget.TextView[@resource-id='"+env+":id/header_title']"));

		for(WebElement promptedList : xpathPromptedList){
			Thread.sleep(3000);
			categoryName = promptedList.getText();
			categoryListOffshelf.add(categoryName);
		}

		for(String category : categoryListOffshelf){
			driveR.findElement(By.xpath("//android.widget.TextView[@text='"+category+"']")).click();
			Thread.sleep(3000);

			List<WebElement> xpathProductMin = driveR.findElements(
					By.xpath("//android.widget.TextView[@resource-id='"+env+":id/storewalk_list_item_min']"));

			for(WebElement productMin : xpathProductMin){
				Thread.sleep(3000);
				productMinText = productMin.getText();
				productMinListOffshelf.add(productMinText);
				offshelfList.put(categoryName, productMinListOffshelf);

				System.out.println(offshelfList);
			}

			driveR.findElement(By.xpath("//android.widget.TextView[@text='"+category+"']")).click();
			Thread.sleep(3000);
		}
	}

	///Get categories in offshelf location
	public void getOffshelfCategoryAndMin() throws Throwable{
		List<WebElement> xpathPromptedList = driveR.findElements(
				By.xpath("//android.widget.TextView[@resource-id='"+env+":id/header_title']"));

		categoryName = xpathPromptedList.get(0).getText();

		driveR.findElement(By.xpath("//android.widget.TextView[@text='"+categoryName+"']")).click();
		Thread.sleep(3000);

		List<WebElement> xpathProductMin = driveR.findElements(
				By.xpath("//android.widget.TextView[@resource-id='"+env+":id/storewalk_list_item_min']"));

		productMinText = xpathProductMin.get(0).getText();
	}

	///Get departments in Warehouse location
	public void getDepartmentsFromWarehouse() throws Throwable{
		Thread.sleep(3000);
		boolean promptedListPresent = false;
		String categoryName =null;
		String sectionText =null;


		List<WebElement> xpathPromptedList = driveR.findElements(
				By.xpath("//android.widget.TextView[@resource-id='"+env+":id/header_title']"));

		for(WebElement promptedList : xpathPromptedList){
			categoryName = promptedList.getText();
			categoryListWarehouse.add(categoryName);

			for(String category : categoryListWarehouse){
				driveR.findElement(By.xpath("//android.widget.TextView[@text='"+category+"']")).click();;
				Thread.sleep(3000);

				List<WebElement> xpathSection = driveR.findElements(
						By.xpath("//android.widget.TextView[@resource-id='"+env+":id/groups_section_header_title']"));

				for(WebElement section : xpathSection){
					Thread.sleep(3000);
					sectionText = section.getText();
					sectionWarehouse.add(sectionText);
					Thread.sleep(3000);

					groupSectionListUI.put(categoryName, sectionText); //Warehouse - Group department and Section
				}
				driveR.findElement(By.xpath("//android.widget.TextView[@text='"+category+"']")).click();;
			}
		}
	}

	public void clickBackButton() throws InterruptedException {
		Thread.sleep(3000);
		driveR.findElement(By.className("android.widget.ImageButton")).click();
		Thread.sleep(3000);
	}

	///Complete petrol location
	public void completePetrolLocation() throws InterruptedException{
		Thread.sleep(3000);
		List<String> productNameList = new ArrayList<String>();

		List<WebElement> allCategories = driveR
				.findElements(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/header_title']"));

		for(WebElement category : allCategories){
			Thread.sleep(3000);

			category.click();

			try{
				List<WebElement> allProducts = driveR
						.findElements(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/storewalk_list_item_description']"));


				for(WebElement product : allProducts){
					Thread.sleep(3000);
					String productName = product.getText();
					System.out.println("Product name : " + productName);

					productNameList.add(productName);
				}

				for(String product : productNameList)
				{
					/////Select product
					driveR.findElement(By.xpath("//android.widget.TextView[@text='"+product+"']")).click();


					Thread.sleep(3000);
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
			}
			catch(Exception e){
				System.out.println("No entry in Petrol");
			}

			Thread.sleep(1000);
			category.click();
		}
	}


	///Complete offshelf location
	public void completeOffshelfLocation() throws InterruptedException{
		Thread.sleep(3000);
		List<String> productNameList = new ArrayList<String>();

		List<WebElement> allCategories = driveR
				.findElements(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/header_title']"));

		for(WebElement category : allCategories){
			Thread.sleep(3000);

			category.click();

			try{
				List<WebElement> allProducts = driveR
						.findElements(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/storewalk_list_item_description']"));


				for(WebElement product : allProducts){
					Thread.sleep(3000);
					String productName = product.getText();
					System.out.println("Product name : " + productName);

					productNameList.add(productName);
				}

				for(String product : productNameList)
				{
					/////Select product
					driveR.findElement(By.xpath("//android.widget.TextView[@text='"+product+"']")).click();


					Thread.sleep(3000);
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
			}
			catch(Exception e){
				System.out.println("No entry in Offshelf");
			}

			Thread.sleep(1000);
			category.click();
		}
	}


	///Complete warehouse location
	public void completeWarehouseLocation() throws InterruptedException{
		Thread.sleep(3000);
		List<String> sectionNameList = new ArrayList<String>();

		List<WebElement> allCategories = driveR
				.findElements(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/header_title']"));

		for(WebElement category : allCategories){
			Thread.sleep(3000);

			category.click();

			try{
				List<WebElement> allProducts = driveR
						.findElements(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/groups_section_header_title']"));


				for(WebElement product : allProducts){
					Thread.sleep(3000);
					String sectionName = product.getText();
					System.out.println("Section name : " + sectionName);

					sectionNameList.add(sectionName);
				}

				for(String section : sectionNameList)
				{
					/////Select product
					driveR.findElement(By.xpath("//android.widget.TextView[@text='"+section+"']")).click();
					Thread.sleep(1000);
					driveR.findElement(By
							.xpath("//android.widget.TextView[@resource-id='"+env+":id/storewalk_list_item_description']"))
					.click();
					Thread.sleep(1000);

					Thread.sleep(3000);
					driveR.findElement(By
							.xpath("//android.widget.EditText[@resource-id='"+env+":id/item_details_quantity_input']"))
					.click();

					Thread.sleep(1000);
					driveR.findElement(By
							.xpath("//android.widget.EditText[@resource-id='"+env+":id/item_details_quantity_input']"))
					.sendKeys("0");;

					Thread.sleep(1000);
					driveR.findElement(By
							.xpath("//android.widget.Button[@resource-id='"+env+":id/item_details_confirm_quantity']"))
					.click();

					Thread.sleep(1000);
					String qty = driveR.findElement(By
							.xpath("//android.widget.TextView[@resource-id='"+env+":id/stock_on_hand']"))
							.getText();
					///assertEquals(qty, "2", " Qty name does not match !");
					Thread.sleep(1000);


					///// Confirm count

					driveR.findElement(
							By.xpath("//android.widget.Button[@resource-id='"+env+":id/inner_button']")).click();
					Thread.sleep(1000);

					driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();
					Thread.sleep(4000);
				}
			}
			catch(Exception e){
				System.out.println("No entry in Warehouse");
			}

			Thread.sleep(1000);
			category.click();
		}
	}

	public void verifyOffshelfPendingStatus() throws InterruptedException{

		Thread.sleep(3000);
		List<String> sectionNameList = new ArrayList<String>();
		List<String> categoryNameList = new ArrayList<String>();

		List<WebElement> allCategories = driveR
				.findElements(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/header_title']"));

		for(WebElement category : allCategories){
			Thread.sleep(3000);
			categoryNameList.add(category.getText());
		}


		for(String categoryName : categoryNameList){
			driveR.findElement(By.xpath("//android.widget.TextView[@text='"+categoryName+"']")).click();
			Thread.sleep(3000);

			try{
				List<WebElement> allProducts = driveR
						.findElements(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/groups_section_header_title']"));

				for(WebElement product : allProducts){
					Thread.sleep(3000);
					String sectionName = product.getText();
					System.out.println("Section name : " + sectionName);

					sectionNameList.add(sectionName);
				}

				for(String section : sectionNameList)
				{
					String sectionStatus = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/groups_section_status']")).getText();
					System.out.println(sectionStatus);
					Thread.sleep(3000);
					boolean isSectionStatus = false;
					if(sectionStatus.equals("OFF SHELF PENDING")||sectionStatus.equals("Off Shelf Pending")){

						isSectionStatus = true;
						assertEquals(isSectionStatus, true,"Offshelf pending status is not displayed");
						Thread.sleep(3000);
					}

					deptNameAndStatus.put(categoryName, sectionStatus); //Group category name in Warehouse and status

				}
				driveR.findElement(By.xpath("//android.widget.TextView[@text='"+categoryName+"']")).click();
			}
			catch(Exception e){System.out.println(e.getMessage());
			}
		}
	}

	public void enterBarcodeNumber() throws Throwable {
//		driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/action_barcode_entry' or @resource-id='" + env + ":id/barcode_entry_edit_text']"))
//		.sendKeys(productMinText);
//
//		Thread.sleep(5000);
//
//		driveR.executeScript("mobile:performEditorAction", ImmutableMap.of("com/morrisons/common/action","search"));
//
//		Thread.sleep(5000);

		//===========================
		{

			try{
				driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/action_barcode_entry' or @resource-id='" + env + ":id/barcode_entry_edit_text']"))
						.sendKeys(productMinText);


				Thread.sleep(5000);

				driveR.executeScript("mobile:performEditorAction", ImmutableMap.of("com/morrisons/common/action","search"));

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
				try {
					driveR.executeScript("mobile:performEditorAction", ImmutableMap.of("action", "search"));
					Thread.sleep(2000);
					do {
						try {
							if (driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/action_barcode_entry' or @resource-id='" + env + ":id/barcode_entry_edit_text']")).isDisplayed()) {
								driveR.executeScript("mobile:performEditorAction", ImmutableMap.of("action", "search"));
								Thread.sleep(2000);
							} else {
								break;
							}
						} catch (NoSuchElementException o) {
							break;
						} catch (Exception w) {

						}
						ctr++;
					} while (ctr < 3);
				}
				catch(Exception ee){
					((AndroidDriver) driveR).pressKey(new KeyEvent(AndroidKey.ENTER)
									.withFlag(KeyEventFlag.SOFT_KEYBOARD)
									.withFlag(KeyEventFlag.KEEP_TOUCH_MODE)
							.withFlag(KeyEventFlag.EDITOR_ACTION));
				}
			}
			catch(Exception q){

			}
		}
		//============================
	}


	public void selectCategoryInOffshelf()throws Throwable {

		try{
			System.out.println("Category for scan min in fixtutre location : " + categoryOffshelf);

			driveR.findElement(By.xpath("//android.widget.TextView[@text='"+categoryOffshelf+"']")).click();
			Thread.sleep(3000);
		}
		catch(Exception e){
			System.out.println(e.getMessage());	
		}
	}

	public void selectCategoryInWarehouse()throws Throwable {
		Map<String, String> categoryInWarehouse = StorewalkServicePage.getGroupAndItemId;
		String categoryWarehouse = categoryInWarehouse.get(categoryOffshelfMin);

		try{
			System.out.println("Category for scan min in fixtutre location : " + categoryWarehouse);

			driveR.findElement(By.xpath("//android.widget.TextView[@text='"+categoryWarehouse+"']")).click();
			Thread.sleep(3000);


			driveR.findElement(By
					.xpath("//android.widget.TextView[@resource-id='"+env+":id/groups_section_header_title']"))
			.click();


			Thread.sleep(2000);
		}
		catch(Exception e){
			System.out.println(e.getMessage());	
		}
	}

	public void sectionWithEmptyList()throws Throwable {

		verifyOffshelfPendingStatus();

		int size = deptNameAndStatus.size();

		for(int i = 0;i<=size-1;i++){

			for (Map.Entry<String, String> entry : deptNameAndStatus.entrySet()) {
				String category = entry.getKey();
				String status = entry.getValue();
				System.out.println("Category: " + category + ", Status: " + status);

				if(!status.equals("OFF SHELF PENDING")||!status.equals("Off Shelf Pending")){
					driveR.findElement(By.xpath("//android.widget.TextView[@text='"+category+"']")).click();

					driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/groups_section_header_title']")).click();

					WebElement xpathProductCount  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/listHeaderQuantity']"));

					String productCount = xpathProductCount.getText().replaceAll("[^0-9]", "");

					assertEquals(productCount, "0","Empty product list is not displayed");

					break;
				}
			}
		}
	}

	public void verifyMinIsRemovedInOffshelf()throws Throwable {
		boolean isMinPresent = true;
		boolean isCategoryPresent = true;
		List<String> products = new ArrayList<String>();
		String category = null;
		
		List<WebElement> xpathPromptedList = driveR.findElements(
				By.xpath("//android.widget.TextView[@resource-id='"+env+":id/header_title']"));

		for(WebElement promptedList : xpathPromptedList){
			category = promptedList.getText();
			categoryListOffshelf.add(category);
		}

		try{

			isCategoryPresent = categoryListOffshelf.contains(categoryName);

			if(isCategoryPresent){

				driveR.findElement(By.xpath("//android.widget.TextView[@text='"+categoryName+"']")).click();
				Thread.sleep(3000);

				List<WebElement> xpathProductMin = driveR.findElements(
						By.xpath("//android.widget.TextView[@resource-id='"+env+":id/storewalk_list_item_min']"));

				for(WebElement productMin : xpathProductMin){
					products.add(productMin.getText());
				}

				isMinPresent =  products.contains(productMinText);
				assertEquals(isMinPresent, false,"Product min is not removed");
			}
			assertEquals(isCategoryPresent, false,"Product min is not removed"); //If only one Min in category,Product category should be removed
		}
		catch(Exception e){

		}
	}

	public void selectSectionInOffshelf()throws Throwable {

		try{
			driveR.findElement(
					By.xpath("//android.widget.TextView[@resource-id='"+env+":id/header_title']"))
			.click();

			String offShelfText = driveR
					.findElement(By
							.xpath("//android.widget.TextView[@resource-id='"+env+":id/storewalk_list_item_description']"))
					.getText();

			Thread.sleep(1000);
			System.out.println("expected product name = " + offShelfText);

			Thread.sleep(3000);
		}

		catch(Exception e){
			System.out.println("Records are not present in Offshore");
		}
	}

	public void addQuantityInOffshelf(String quantity) throws InterruptedException {
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
			.sendKeys(quantity);

			Thread.sleep(1000);
			driveR.findElement(By
					.xpath("//android.widget.Button[@resource-id='"+env+":id/item_details_confirm_quantity']"))
			.click();
		}
		catch(Exception e){
			System.out.println("No entry in Offshelf");
		}
	}

	public void verifyZeroQuantity(String quantity)throws InterruptedException {

		Thread.sleep(1000);
		String qty = driveR.findElement(By
				.xpath("//android.widget.TextView[@resource-id='"+env+":id/stock_on_hand']"))
				.getText();
		assertEquals(qty, quantity, "Zero quantity is not set at offshelf location");
		Thread.sleep(1000);
	}

	public void leftSwipeTheDescription()throws InterruptedException {


		Thread.sleep(3000);

		TouchAction ts = new TouchAction(driveR);
		ts.press(PointOption.point(520, 412)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(32, 412)).release().perform();
		Thread.sleep(7000);

	}

	public void verifyProductIsNotDeleted()throws InterruptedException {

		try{
			driveR.findElement(
					By.xpath("//android.widget.ImageView[@resource-id='"+env+":id/delete_button']"));
			Thread.sleep(7000);
		}
		catch(Exception e){
			e.getMessage();
		}
	}

	public void completeTheSection() throws InterruptedException{
		Thread.sleep(3000);
		List<String> categoryList = new ArrayList<String>();
		
		List<WebElement> allCategories = driveR
				.findElements(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/header_title']"));

		for(WebElement category : allCategories){
			Thread.sleep(3000);

			categoryList.add(category.getText());
		}
		
		for(String categoryName : categoryList)
		{
			driveR.findElement(By.xpath("//android.widget.TextView[@text='"+categoryName+"']")).click();


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
				System.out.println("No entry in section");

				Thread.sleep(3000);
				driveR.findElement(By.className("android.widget.ImageButton")).click();
				Thread.sleep(3000);
			}

			Thread.sleep(1000);
			driveR.findElement(By.xpath("//android.widget.TextView[@text='"+categoryName+"']")).click();
		}
	}

	public void verifySectionIscompleted() throws InterruptedException{
		Thread.sleep(3000);
		List<WebElement> allCategoriesStatus = driveR
				.findElements(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/header_status']"));

		for(WebElement status : allCategoriesStatus){
			Thread.sleep(3000);

			String actualStatus = status.getText();

			assertEquals(actualStatus, "Completed","Section is not completed");
		}
	}

	public void completedWarehouse()throws InterruptedException{
		Thread.sleep(3000);
		List<String> categoryList = new ArrayList<String>();
		List<String> productList = new ArrayList<String>();
		
		List<WebElement> allCategories = driveR
				.findElements(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/header_title']"));

		for(WebElement category : allCategories){
			Thread.sleep(3000);

			categoryList.add(category.getText());
		}
		
		for(String categoryName : categoryList)
		{
			driveR.findElement(By.xpath("//android.widget.TextView[@text='"+categoryName+"']")).click();


			try{
				List<WebElement> allSections = driveR.findElements(By
						.xpath("//android.widget.TextView[@resource-id='"+env+":id/groups_section_header_title']"));

				for(WebElement section : allSections){
					Thread.sleep(3000);

					section.click();
					
					List<WebElement> allProducts = driveR.findElements(By
							.xpath("//android.widget.TextView[@resource-id='"+env+":id/storewalk_list_item_description']"));
					
					for(WebElement products : allProducts){
						Thread.sleep(3000);

						productList.add(products.getText());
						
					}
					
					for(String productText : productList)
					{
						
						driveR.findElement(By.xpath("//android.widget.TextView[@text='"+productText+"']")).click();
						
					Thread.sleep(1000);
					driveR.findElement(By
							.xpath("//android.widget.EditText[@resource-id='"+env+":id/item_details_quantity_input']"))
					.sendKeys("2");;

					Thread.sleep(1000);
					driveR.findElement(By
							.xpath("//android.widget.Button[@resource-id='"+env+":id/item_details_confirm_quantity']"))
					.click();
			
					
					}

					Thread.sleep(1000);
					driveR.findElement(
							By.xpath("//android.widget.Button[@resource-id='"+env+":id/inner_button']")).click();

					Thread.sleep(3000);
					driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();
					Thread.sleep(1000);
		
				}
			}
			catch(Exception e){
				System.out.println("No entry in section");

				Thread.sleep(3000);
				driveR.findElement(By.className("android.widget.ImageButton")).click();
				Thread.sleep(3000);
			}

			Thread.sleep(1000);
			driveR.findElement(By.xpath("//android.widget.TextView[@text='"+categoryName+"']")).click();
		}
	}

	public void verifyWarehouseGrpAndSection(){
		boolean isTrue = false;

		isTrue = StorewalkServicePage.groupDeptSectionService.equals(groupSectionListUI);

		assertEquals(isTrue, true, "Group dept and section on UI and service is mismatched");
	}


	public void clickOnGroupName()throws Throwable {

		String groupName = StorewalkServicePage.warehouseGroup;

		driveR.findElement(By.xpath("//android.widget.TextView[@text='"+groupName+"']")).click();
		Thread.sleep(3000);

		driveR.findElement(By
				.xpath("//android.widget.TextView[@resource-id='"+env+":id/groups_section_header_title']"))
		.click();
		Thread.sleep(2000);
	}
	
	public void verifyProductIsPresent() throws Throwable{
		
		WebElement xpathPromptedList= driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/header_title']"));
		xpathPromptedList.isDisplayed();
		
	}
	
  public void verifyProductAtCounter() throws Throwable{
		
		WebElement xpathPromptedList=  driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/storewalk_list_item_description']"));
		xpathPromptedList.isDisplayed();
		
	}
}
