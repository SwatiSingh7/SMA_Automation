package com.morrisons.sma.page_objects.mobile.old;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertEquals;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.google.common.base.CharMatcher;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import com.morrisons.common.action.Hook;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;

public class FreshCodeCheckPO {

	private static AndroidDriver driveR;
	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
	String env = applicationConfig.getWebElementEnviroment().getEnv();
	private String criticalCheckStatus;
	private static String warehouseStatus;
	private static String promotionStatus;
	private static String alertStatus;

	private static String ActionPerformed;
	private static String ExpiryDate;
	private static String Quantity;
	private static String statuss;

	private static String screenn;

	private static String menuu;

	private static String sectionn;

	private static String MIN;
	private static String ProdctName;

	private static List<String> ProductDetail = new ArrayList<String>();
	private static List<String> viewlisProductDetail = new ArrayList<String>();
	private static List<String> escalationListUI = new ArrayList<String>();
	
	private static String locationStatusUI = null;

	private static List<String> dateList = new ArrayList<String>();
	
	public FreshCodeCheckPO() {
		this.driveR = (AndroidDriver) Hook.getDriver();

	}

	///// Shrutika

	public void verifySubmenuStatus(String Submenu)
	{
		try {
			if (Submenu == "Code Alerts") {
				WebElement Status = driveR.findElement(
						By.xpath("//android.widget.RelativeLayout[@index='1']/android.widget.TextView[@resource-id='"
								+ env + ":id/department_status']"));
				alertStatus = Status.getText();
				Assert.assertEquals("Completed", alertStatus, "Status Mismatched");
			}

			else if (Submenu == "Pre-Opening Clearance Bay Checks") {
				WebElement Status = driveR.findElement(
						By.xpath("//android.widget.RelativeLayout[@index='0']/android.widget.TextView[@resource-id='"
								+ env + ":id/department_status']"));
				alertStatus = Status.getText();
				Assert.assertEquals("Not Checked", alertStatus, "Status Mismatched");
			} else if (Submenu == "Store Close Clearance Bay Checks") {
				WebElement Status = driveR.findElement(
						By.xpath("//android.widget.RelativeLayout[@index='3']/android.widget.TextView[@resource-id='"
								+ env + ":id/department_status']"));
				alertStatus = Status.getText();
				Assert.assertEquals("Not Checked", alertStatus, "Status Mismatched");
			}

			else if (Submenu == "Daily Schedule") {
				WebElement Status = driveR.findElement(
						By.xpath("//android.widget.RelativeLayout[@index='2']/android.widget.TextView[@resource-id='"
								+ env + ":id/department_status']"));
				alertStatus = Status.getText();
				Assert.assertEquals("", alertStatus, "Status Mismatched");
			} else if (Submenu == "Manager Summary & Sign Off") {
				WebElement Status = driveR.findElement(
						By.xpath("//android.widget.RelativeLayout[@index='4']/android.widget.TextView[@resource-id='"
								+ env + ":id/department_status']"));
				alertStatus = Status.getText();
				Assert.assertEquals("Awaiting Sign-Off", alertStatus, "Status Mismatched");
			} 
		} catch (Exception e) {
			System.err.println("Status not found");
		}
	}

	public void verifyAMStatus(String status) {
		boolean amStatus = driveR.findElement(By.xpath("//android.widget.RelativeLayout[@index='0']/android.widget.TextView[@text='" + status + "']")).isDisplayed();
		Assert.assertEquals(true, amStatus, "Status is not displayed");
	}
	public void verifyPMStatus(String status) {
		boolean pmStatus = driveR.findElement(By.xpath("//android.widget.RelativeLayout[@index='3']/android.widget.TextView[@text='" + status + "']")).isDisplayed();
		Assert.assertEquals(true, pmStatus, "Status is not displayed");

	}

	public void iclickonButton(String button) throws InterruptedException {
		Thread.sleep(1000);
		try {
			driveR.findElement(By.id("" + env + ":id/singleItemTitle")).click();
		} catch (Exception e) {

		}

		driveR.findElement(By.xpath("//android.widget.Button[@text='" + button + "']")).click();
		Thread.sleep(1000);

	}

	public void popupnotDisplayed() {
		WebElement ePopuptitle = driveR.findElement(By.id("" + env + ":id/alertTitle"));

		Assert.assertEquals(false, ePopuptitle.isDisplayed(), "Popup is displayed");
	}

	public void verifyScreen(String screen) throws InterruptedException {
		Thread.sleep(5000);
		boolean scrn = driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + screen + "']")).isDisplayed();

		Assert.assertEquals(true, scrn, "Screen is not displayed");
	}

	public void verifyStatus(String status) throws Throwable {
		Thread.sleep(3000);
		scrollUp();
		WebElement eStatus = driveR.findElement(By.xpath("//android.widget.TextView[@text='" + status + "']"));
		System.out.println(eStatus.getText());
		Assert.assertEquals(true, eStatus.isDisplayed(), "Status is not displayed");
	}

	public void popupDisplayed() throws InterruptedException {
		Thread.sleep(3000);

		boolean ePopuptitle = driveR.findElement(By.id("" + env + ":id/alertTitle")).isDisplayed();

		Assert.assertEquals(true, ePopuptitle, "Popup is not Displayed");
		String ePopupMsg = driveR.findElement(By.id("android:id/message")).getText();
		Assert.assertEquals("The correct time to complete this check has passed. It is important to check this fixture before the store opens to prevent out of date products being on sale. Please click continue to complete this check."
				,ePopupMsg, "Incorrect Msg is displayed");
	}

	public void popupPMDisplayed() {
		boolean ePopuptitle = driveR.findElement(By.id("" + env + ":id/alertTitle")).isDisplayed();

		Assert.assertEquals(true, ePopuptitle, "Popup is not Displayed");
		String ePopupMsg = driveR.findElement(By.id("android:id/message")).getText();
		Assert.assertEquals("The correct time to complete this check has passed. It is important to check this fixture once the store has closed to prevent out of date products being on sale. Please click continue to complete this check."
				,ePopupMsg, "Incorrect Msg is displayed");
	}

	public void clickCancel() {
		WebElement eCancel = driveR.findElement(By.xpath("//android.widget.Button[contains(@text, 'CANCEL')]"));

		eCancel.click();
	}

	public void navigatebacktomenu(String menu) {
		menu = menuu;
		WebElement eMenu = driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + menuu + "']"));

		Assert.assertEquals(true, eMenu.isDisplayed(), "Redirected to wrong menu");
	}

	public void clickContinue() throws InterruptedException {

		try {
			WebElement eContinue = driveR.findElement(By.xpath("//android.widget.Button[@text ='CONTINUE' or @text= 'YES']"));
			eContinue.click();

		} catch (Exception e) {
			WebElement eContinu = driveR.findElement(By.xpath("//android.widget.TextView[@text ='CONTINUE' or @text= 'YES']"));
			eContinu.click();
		}
		Thread.sleep(3000);
	}

	public void verifyScreenmsg() {
	String eScreenmsg = driveR.findElement(By.id("" + env + ":id/scanText")).getText();
		Assert.assertEquals("Please ensure any out of date products have been removed from sale and actioned as waste from the following areas:",
			eScreenmsg, "Incorrect Msg is displayed");

	}

	public void actionDropdown() {
		WebElement eActionDropdown = driveR.findElement(By.id("" + env + ":id/spinner_Actions"));
		WebElement eMarkdown = driveR.findElement(By.xpath("//android.widget.CheckedTextView[@index='0']"));
		WebElement eWastage = driveR.findElement(By.xpath("//android.widget.CheckedTextView[@index='1']"));

		eActionDropdown.click();
		Assert.assertEquals("Markdown", eMarkdown.getText(), "Markdown is not present in dropdown");
		Assert.assertEquals("Wastage", eWastage.getText(), "Wastage is not present in dropdown");

	}

	public void selectSection(String section) {
		section = sectionn;
		WebElement eSelectSection = driveR
				.findElement(By.xpath("//android.widget.TextView[@text= '" + sectionn + "']"));

		eSelectSection.click();
	}

	///////////////	

	public void verifyScheduledays() throws InterruptedException {

		Thread.sleep(5000);
		List<AndroidElement> eDays = driveR.findElements(By.id("" + env + ":id/department_title"));

		Thread.sleep(3000);
		int numberofDays = eDays.size();
		System.out.println("numberofDays " + numberofDays);


		for (AndroidElement a : eDays) {
			String abc = a.getText();
			System.err.println("Day:: " + abc);
		}
		Assert.assertEquals(5, numberofDays, "Schedule displayed is less than 5 days");

		eDays.clear();
		Thread.sleep(2000);


	}

	public void selectCurrentDay() throws InterruptedException {

		Thread.sleep(3000);
		List<AndroidElement> profile = driveR.findElements(
				MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_title']"));

		Thread.sleep(2000);

		for (AndroidElement a : profile) {

			String abc = a.getText();
			System.err.println("List is as follows  " + abc);

		}
		String firstElementInlist = profile.get(profile.size() - 1).getText();
		System.out.println("First Element in List:------------" + firstElementInlist);
		profile.get(profile.size() - 2 ).click();
		System.out.println("clicked current day");

	}
	//To click past date 
	public void selectCurrentDay1(int date) throws InterruptedException {

		Thread.sleep(3000);
		List<AndroidElement> profile = driveR.findElements(
				MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_title']"));

		Thread.sleep(2000);

		for (AndroidElement a : profile) {

			String abc = a.getText();
			System.err.println("List is as follows  " + abc);

		}
		profile.get(profile.size() - date ).click();

	}





	public void setRatinggood() throws InterruptedException {
		Thread.sleep(3000);

		//		 driveR.findElement(By.id("" + env + ":id/rating_option_row")).click();
		//			Thread.sleep(3000);
		//		 driveR.findElement(By.id("" + env + ":id/complete_button")).click();

		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/rating_options_text' and @text = 'Poor']"))
		.click();

		try{
			driveR.findElement(By.xpath("//android.widget.Button[@text='Confirm' or @text='CONFIRM']")).click();
			driveR.findElement(By.id("android:id/button1")).click();

		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
		public void scrollToProductgroup(String Prodctgroup) 
		{
	        driveR.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector())" +
	                ".scrollIntoView(new UiSelector().text(\"" + Prodctgroup + "\"));")).isDisplayed();
	        driveR.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector())" +
	                ".scrollIntoView(new UiSelector().text(\"" + Prodctgroup + "\"));")).click();
	}

		public void reopenTheDepartment(String dept) throws InterruptedException {
			scrollToProductgroup(dept);
			WebElement reopenCodeRotateGroup = driveR
					.findElement(By.xpath("//android.widget.Button[@text='RE-OPEN CODE ROTATE GROUP']"));
			Thread.sleep(1000);
			reopenCodeRotateGroup.click();

			driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();

		}

	public void verifyProductinviewlist() throws InterruptedException {

		List<String> productMin = new ArrayList<String>();
		Thread.sleep(3000);
		driveR.findElement(By.id("" + env + ":id/singleItemTitle")).click();
		System.out.println("view list opened");
		try {
			List<WebElement> lisMIN = driveR.findElements(By.id("" + env + ":id/list_item_min"));
			for (WebElement min : lisMIN) {
				min.isDisplayed();
				productMin.add(min.getText());
			}
			boolean isMinPresent = productMin.contains(MIN);
			// assertEquals(isMinPresent, true,"Product min is not present in view list");
			verifyProductdetail();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	public void verifyCountnRating() throws InterruptedException {

		try {
			WebElement descriptionline =	 driveR.findElement(By.id("" + env + ":id/description_line1"));
			WebElement actionValue =	 driveR.findElement(By.id("" + env + ":id/value"));
			WebElement rotationRating =	 driveR.findElement(By.id("" + env + ":id/rotation_rating_value"));

			boolean isdescriptionline = descriptionline.isDisplayed();
			Assert.assertEquals(true, isdescriptionline,"Description not found");

			boolean isactionValue = actionValue.isDisplayed();
			Assert.assertEquals(true, isactionValue,"Actionvalue not found");

			boolean isrotationRating = rotationRating.isDisplayed();
			Assert.assertEquals(true,isrotationRating,"Rotation rating not found");
		} catch (Exception e) {
			Thread.sleep(3000);
		}
	}



	public void verifypopmsgforinvalid() throws InterruptedException {

		WebElement popmsg = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']"));
		popmsg.isDisplayed();
		String msg = popmsg.getText();
		Assert.assertEquals(msg,"Please enter a valid date for this product, In line with the scheduled check.", "message is mismatched");		
	}

	public void verifynConfirmAmbientpromt() {
		WebElement popmsg = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']"));
		popmsg.isDisplayed();
		String msg = popmsg.getText().trim();
		System.out.println(msg);

		//Assert.assertEquals("This product is not part of Fresh Foods.\r\n" + 
		//		"\r\n" + 
		//		" Please com.morrisons.common.action separately.",    msg,"Message is Incorrect");
		driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();
	}



	public void verifydepartmentscreen() {
		WebElement departmentitle =	driveR.findElement(By.className("android.widget.TextView"));

		boolean isdeptilte= departmentitle.isDisplayed();
		Assert.assertEquals(isdeptilte, true, "department screen not displayed");

	}



	public void verifyNonRangedProduct() throws InterruptedException {
		WebElement nonRangepoptitle =	driveR.findElement(By.id("" + env + ":id/alertTitle"));
		String nonrangetile= nonRangepoptitle.getText();
		Assert.assertEquals("Product Not Ranged", nonrangetile, "Product Not Ranged pop up not found");
		WebElement popmsg = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']"));
		popmsg.isDisplayed();
		String msg = popmsg.getText();
		Assert.assertEquals(msg,"This product is not ranged to your store. Please enter the products locations and continue with your check.", "message is mismatched");
		Thread.sleep(3000);
		driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();

		setProductlocation();

	}

	public void setProductlocation() throws InterruptedException {
		WebElement aisle_number =	driveR.findElement(By.id("" + env + ":id/aisle_number"));
		WebElement bay_number =	driveR.findElement(By.id("" + env + ":id/bay_number"));
		WebElement shelf_number =	driveR.findElement(By.id("" + env + ":id/shelf_number"));
		WebElement position =	driveR.findElement(By.id("" + env + ":id/position"));

		aisle_number.sendKeys("10");
		bay_number.sendKeys("10");
		shelf_number.sendKeys("10");
		position.sendKeys("10");

		Thread.sleep(3000);
		driveR.findElement(By.id("" + env + ":id/nextActionButton")).click();

	}



	public void verifyCriticalCheck() throws InterruptedException {
		Thread.sleep(3000);
		boolean isCriticalcheck = driveR.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Critical Checks')]")).isDisplayed();
		Assert.assertEquals(isCriticalcheck, true, "Critical Check not displayed");

	}
	public List<String> getProductDetail() {
		MIN = driveR.findElement(By.id("" + env + ":id/product_title")).getText();
		ProdctName= driveR.findElement(By.id("" + env + ":id/value")).getText();
		//ActionPerformed = driveR.findElement(By.id("" + env + ":id/text1")).getText();
		//ExpiryDate = driveR.findElement(By.id("" + env + ":id/edt_ExpiryDate")).getText();
		//Quantity = driveR.findElement(By.id("" + env + ":id/markdown_quantity")).getText();

		System.out.println("min: " + MIN);
		System.out.println("title: " + ProdctName);
		return ProductDetail;

	}
	public List<String> getProductfromviewlist() {
		MIN = driveR.findElement(By.id("" + env + ":id/list_item_min")).getText();
		ProdctName= driveR.findElement(By.id("" + env + ":id/updated_list_item_description")).getText();
		//ActionPerformed = driveR.findElement(By.id("" + env + ":id/list_item_quantity_value")).getText().replaceAll("\\d", "").trim();
		//ExpiryDate = driveR.findElement(By.id("" + env + ":id/list_item_expiry_date")).getText();
		System.out.println("min: " + MIN);
		System.out.println("title: " + ProdctName);
		return viewlisProductDetail;
	}

	public void verifyProductdetail() {
		boolean details= viewlisProductDetail.equals(ProductDetail);

		Assert.assertEquals(details, true, "details mismatchdisplayed");

	}

	public void verifyPromotionCompletepopup() throws InterruptedException
	{
		WebElement poptitle =	driveR.findElement(By.id("" + env + ":id/alertTitle"));
		String title= poptitle.getText();
		Assert.assertEquals("Confirm Promotions", title, "Confirm Promotions pop up not found");
		WebElement popmsg = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']"));
		popmsg.isDisplayed();
		String msg = popmsg.getText();
		Assert.assertEquals(msg,"Please confirm that you have checked all promotional areas and there are no out of date products on sale.", "message is mismatched");
		Thread.sleep(3000);
		driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();
	}

	public void verifyPromotionStatus(String status) throws InterruptedException
	{	Thread.sleep(3000);
	WebElement proStatus =	driveR.findElement(By.xpath("//android.widget.RelativeLayout[@index='2']/android.widget.TextView[@resource-id='" + env + ":id/department_status']"));
	promotionStatus= proStatus.getText();
	Assert.assertEquals(status, promotionStatus,"Status Mismatched");
	}

	public void verifyWarehouseCompletepopup() throws InterruptedException
	{
		WebElement poptitle =	driveR.findElement(By.id("" + env + ":id/alertTitle"));
		String title= poptitle.getText();
		Assert.assertEquals("Confirm Warehouse", title, "Confirm Warehouse pop up not found");
		WebElement popmsg = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']"));
		popmsg.isDisplayed();
		String msg = popmsg.getText();
		Assert.assertEquals(msg,"Please confirm that you have checked all appropriate products in the warehouse and any required actions have been completed.", "message is mismatched");
		Thread.sleep(3000);
		driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();
	}


	public void verifyWarehouseStatus(String status)
	{
		WebElement whStatus =	driveR.findElement(By.xpath("//android.widget.RelativeLayout[@index='3']/android.widget.TextView[@resource-id='" + env + ":id/department_status']"));
		warehouseStatus= whStatus.getText();
		Assert.assertEquals(status, warehouseStatus,"Status Mismatched");
	}

	public void verifyCriticalCheckStatus(String status) throws InterruptedException {
		Thread.sleep(3000);
		WebElement ccStatus =	driveR.findElement(By.xpath("//android.widget.RelativeLayout[@index='0']/android.widget.TextView[@resource-id='" + env + ":id/department_status']"));
		criticalCheckStatus= ccStatus.getText();
		Assert.assertEquals(status, criticalCheckStatus,"Status Mismatched");
	}

	public void clickWastagecode(String wastagecode) throws InterruptedException {
		driveR.findElement(By.xpath("//android.widget.CheckedTextView[@text='"+ wastagecode +"']")).click();
		Thread.sleep(3000);
		driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();

	}

	public void verifyfieldnoteditable() {
		boolean isedited = driveR.findElement(By.id("" + env + ":id/top")).isSelected();
		Assert.assertEquals(false, isedited,"Field is editale");

	}

	public void reopenReductionBay() throws Throwable {

		try{
			WebElement reopenCodeRotateGroup = driveR.findElement(By.xpath("//android.widget.Button[@text='RE-OPEN CLEARANCE BAY CHECK']"));
			Thread.sleep(3000);
			reopenCodeRotateGroup.click();

			driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();

		}
		catch(Exception e){
		}
		Thread.sleep(3000);
	}

	public void deleteProduct()throws InterruptedException {

		List<WebElement> xpathProductList  = driveR.findElements(By
				.xpath("//android.support.v7.widget.RecyclerView[@resource-id='"+env+":id/storewalk_list']"));

		for(WebElement product : xpathProductList){

			TouchAction ts = new TouchAction(driveR);
			ts.press(PointOption.point(520, 412)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
			.moveTo(PointOption.point(32, 412)).release().perform();
			Thread.sleep(7000);

			driveR.findElement(By.xpath("//android.widget.ImageView[@resource-id='" + env + ":id/delete_button']"))
			.click();
			Thread.sleep(3000);
		}

	}

	public void deleteProductincriticalcheck()throws InterruptedException {

		List<WebElement> xpathProductList  = driveR.findElements(By
				.xpath("//android.support.v7.widget.RecyclerView[@resource-id='"+env+":id/critical_list']"));
		System.out.println("Deleting Product");
		for(WebElement product : xpathProductList){

			TouchAction ts = new TouchAction(driveR);
			ts.press(PointOption.point(520, 412)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
			.moveTo(PointOption.point(32, 412)).release().perform();
			Thread.sleep(7000);

			driveR.findElement(By.xpath("//android.widget.ImageView[@resource-id='" + env + ":id/delete_button']"))
			.click();
			Thread.sleep(3000);
		}

	}


	public void clicklogproduct() throws InterruptedException {
		driveR.findElement(By.xpath("//android.widget.TextView[contains(@text, 'LOG PRODUCT')]")).click();
		Thread.sleep(3000);
		try{
			driveR.findElement(By.xpath("//android.widget.Button[@text ='CONTINUE']")).click();	
		}
		catch(Exception e){}
	}


	////////////////////////////////////////////////////////////////////////Summary//////////////////////////////////////////////////////
	///////////////////////////// Shrutika

	public void verifySummaryTotalwastage() {
		boolean wastaegelabel = driveR.findElement(By.id("" + env + ":id/wastageLabel")).isDisplayed();
		Assert.assertEquals(true, wastaegelabel);
		boolean wastageValue = driveR.findElement(By.id("" + env + ":id/wastageValue")).isDisplayed();
		Assert.assertEquals(true, wastageValue);
		boolean wastaegeqty = driveR.findElement(By.id("" + env + ":id/wastageQuantityLabel")).isDisplayed();
		Assert.assertEquals(true, wastaegeqty);
		boolean wastageqtyValue = driveR.findElement(By.id("" + env + ":id/wastageQuantityValue")).isDisplayed();
		Assert.assertEquals(true, wastageqtyValue);
	}

	public void verifyEscalations() {
		boolean escalationLabel = driveR.findElement(By.id("" + env + ":id/escalationLabel")).isDisplayed();
		Assert.assertEquals(true, escalationLabel);

		boolean escalationView = driveR.findElement(By.id("" + env + ":id/escalationView")).isDisplayed();
		Assert.assertEquals(true, escalationView);

		boolean escalationDescription = driveR.findElement(By.id("" + env + ":id/escalationDescription")).isDisplayed();
		Assert.assertEquals(true, escalationDescription);
	}

	public void verifynameqtyamount() {
		boolean name = driveR.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Name')]")).isDisplayed();
		Assert.assertEquals(true, name);

		boolean Qty = driveR.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Qty')]")).isDisplayed();
		Assert.assertEquals(true, Qty);

		boolean £ = driveR.findElement(By.xpath("//android.widget.TextView[contains(@text, '£')]")).isDisplayed();
		Assert.assertEquals(true, £);

		boolean wastageList = driveR.findElement(By.id("" + env + ":id/wastageList")).isDisplayed();
		Assert.assertEquals(true, wastageList);
	}

	public void clickOverduedate() {

		driveR.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Overdue')]")).click();

	}

	public void clickSummaryproductdepartment() throws InterruptedException {
		try {
			driveR.findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout")).click();
		} catch (Exception e) {		
			Thread.sleep(1000);
		}
		driveR.findElement(By.id("" + env + ":id/allProductCheckbox")).click();
		Thread.sleep(1000);
		driveR.findElement(By.id("" + env + ":id/continueBtn")).isDisplayed();
		driveR.findElement(By.id("" + env + ":id/continueBtn")).click();

	}

	public void clickSummaryproductlist() throws InterruptedException {

		try {
			driveR.findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout")).click();
			driveR.findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[@index='0']")).isDisplayed();
			driveR.findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[@index='0']")).click();

		} catch (Exception e) {	
			Thread.sleep(1000);
			driveR.findElement(By.id("" + env + ":id/allProductCheckbox")).click();
		}
		driveR.findElement(By.id("" + env + ":id/continueBtn")).isDisplayed();

		driveR.findElement(By.id("" + env + ":id/continueBtn")).click();

	}

	public void verifyEscalationlist() {
		boolean isPresent = false;


		List<WebElement> escalationlist = driveR.findElements(By.xpath("//android.support.v7.widget.RecyclerView[@resource-id='" + env + ":id/escalationList']"));

		for(WebElement elist : escalationlist){
			String elistUI = elist.getText().trim();
			System.out.println(" escalation deatails: " + elistUI);

			escalationListUI.add(elistUI);
		}

		if(escalationListUI.contains("INCOMPLETE")){
			isPresent = true;
		}
		else if(escalationListUI.contains("VIEW")){
			isPresent = true;

			assertEquals(isPresent, true,"Escaltion list not contains any incomplete/view status");	
		}

	}

	public void clickViewstatusescaltion(String status) throws InterruptedException {

		driveR.findElement(By.xpath("//android.widget.TextView[@text='" + status + "']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[@text='" + status + "']")).click();

	}

	public void verifynextstep() {
		driveR.findElement(By.xpath("//android.widget.TextView[@text='Next Steps']")).isDisplayed();
		driveR.findElement(By.id("" + env + ":id/txt_action")).isDisplayed();
		driveR.findElement(By.id("" + env + ":id/txtHeading")).isDisplayed();
		driveR.findElement(By.id("" + env + ":id/check_name")).isDisplayed();

	}

	public void verifyAisleinfo() {
		try {
			driveR.findElement(By.id("" + env + ":id/aisle_name")).isDisplayed();
			driveR.findElement(By.id("" + env + ":id/aisle_name")).click();
			driveR.findElement(By.id("" + env + ":id/selected_aisle_value")).isDisplayed();
			driveR.findElement(By.id("" + env + ":id/department_name")).isDisplayed();
			driveR.findElement(By.id("" + env + ":id/department_rating")).isDisplayed();
			driveR.findElement(By.id("" + env + ":id/department_desc")).isDisplayed();
			driveR.findElement(By.id("" + env + ":id/selected_products_count")).isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyProblemfound() {
		driveR.findElement(By.id("" + env + ":id/txtProbLbl")).isDisplayed();
		driveR.findElement(By.id("" + env + ":id/txtIssueVal")).isDisplayed();

		driveR.findElement(By.id("" + env + ":id/investigation_Heading")).isDisplayed();

		driveR.findElement(By.id("" + env + ":id/txtInvestigationValue")).isDisplayed();


	}

	public void verifypromtcompleteEscalation() {
		//Complete Next Steps

		driveR.findElement(By.xpath("//android.widget.TextView[@text='Complete Next Steps']")).isDisplayed();
		driveR.findElement(By.id("android:id/message")).isDisplayed();
		driveR.findElement(By.id("android:id/button1")).isDisplayed();
		driveR.findElement(By.id("android:id/button1")).click();


	}

	public void verifyInvestigationdetails() throws Throwable {
		driveR.findElement(By.id("" + env + ":id/investigation_title")).isDisplayed();
		driveR.findElement(By.id("" + env + ":id/investigation_spinner_title")).isDisplayed();
		driveR.findElement(By.id("" + env + ":id/investigation_action_spinner")).isDisplayed();
		driveR.findElement(By.id("" + env + ":id/investigation_action_spinner")).click();
		scrollDown();
		List<WebElement> elemnet = driveR.findElements(By.xpath("//android.widget.RelativeLayout"));
		elemnet.get(elemnet.size()-2).click();
		Thread.sleep(5000);
			elemnet.get(elemnet.size() - 1).click();
		//driveR.findElement(By.id("" + env + ":id/btn_AddInvestigation")).click();
//		Actions builder = new Actions(driveR);   
//		builder.moveToElement(elemnet.get(elemnet.size() - 1), 876,1724).click().build().perform();
			
	          TouchAction touchAction = new TouchAction(driveR);
	          touchAction.tap(PointOption.point(876,1724))
	                     .perform();
	}

	public void verifynextstepdetails() throws Throwable {
		scrollDown();
		driveR.findElement(By.id("" + env + ":id/next_action_question")).isDisplayed();
		scrollDown();
		driveR.findElement(By.id("" + env + ":id/next_action_checkbox")).click();
		driveR.findElement(By.id("" + env + ":id/comment")).sendKeys("Test");
		driveR.findElement(By.id("" + env + ":id/btn_AddNextSteps")).isDisplayed();
		driveR.findElement(By.id("" + env + ":id/btn_AddNextSteps")).click();
		Thread.sleep(1000);
	}

	public void verifyredirectedtoEscalationlist() {
		boolean Summary=  driveR.findElement(By.xpath("//android.widget.TextView[@text='Summary & Sign Off']")).isDisplayed();
		Assert.assertEquals(true, Summary);
		try {
			boolean escalationList= driveR.findElement(By.id("" + env + ":id/escalationList")).isDisplayed();
			Assert.assertEquals(true, escalationList);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void clickEditicon() throws InterruptedException {
		driveR.findElement(By.id("" + env + ":id/imgEdit")).isDisplayed();

		driveR.findElement(By.id("" + env + ":id/imgEdit")).click();
	}
	public void selectproblemfound() throws InterruptedException {
		driveR.findElement(By.id("" + env + ":id/issues_action_spinner")).isDisplayed();
		driveR.findElement(By.id("" + env + ":id/issues_action_spinner")).click();
		Thread.sleep(1000);
		//driveR.findElement(By.id("" + env + ":id/spinner_checkbox")).click();

		driveR.findElement(By.xpath("//android.widget.CheckBox")).click();
		TouchAction ts = new TouchAction(driveR);
		ts.press(PointOption.point(922, 1654)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(922, 928)).release().perform();


		List<WebElement> elemnet = driveR.findElements(By.xpath("//android.widget.RelativeLayout"));
		int sizee = elemnet.size();
		System.out.println("number of elemnets :" + sizee);
		elemnet.get(sizee-1).click();

		//driveR.findElement(By.id("" + env + ":id/btn_AddIssue")).click();

        TouchAction touchAction = new TouchAction(driveR);
        touchAction.tap(PointOption.point(876,1724))
                   .perform();
	}

	public void clickDeleteicon() {
		driveR.findElement(By.id("" + env + ":id/imgDelete")).isDisplayed();
		driveR.findElement(By.id("" + env + ":id/imgDelete")).click();
		driveR.findElement(By.id("" + env + ":id/alertTitle")).isDisplayed();
		driveR.findElement(By.id("android:id/button1")).click();

		//android:id/button1

	}

	public void escalationProductList() {

		try {
			driveR.findElement(By.id("" + env + ":id/escalationProductList")).isDisplayed();
			driveR.findElement(By.id("" + env + ":id/txt_label")).isDisplayed();
		} catch (Exception e) {
		}

	}
	public void verifyaisleunderdepartment() {
		driveR.findElement(
				By.xpath("//android.widget.ExpandableListView/android.widget.LinearLayout[@index='3']")).isDisplayed();
		driveR.findElement(
				By.xpath("//android.widget.ExpandableListView/android.widget.LinearLayout[@index='3']")).click();
		driveR.findElement(By.xpath("//android.widget.LinearLayout/android.widget.TextView[contains(@text, 'Aisle')]")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.LinearLayout/android.widget.TextView[contains(@text, 'N/A')]")).isDisplayed();


	}

	public void clickSecondchecktab() {
		driveR.findElement(By.xpath("//android.widget.TextView[@text='Afternoon']")).click();

	}

	public void clickFMchecktab() {
		driveR.findElement(By.xpath("//android.widget.TextView[@text='FM Check']")).click();
	}

	public void verifySignoffdetailscreen() {
		driveR.findElement(By.id("" + env + ":id/weekNameTV")).isDisplayed();		
		driveR.findElement(By.xpath("//android.widget.TextView[@text='Store Manager weekly sign off']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[@text='Please confirm that you have completed the following before signing off:']")).isDisplayed();

		driveR.findElement(By.xpath("//android.widget.TextView[@text='Reviewed the weekly activity']")).isDisplayed();
		driveR.findElement(By.id("" + env + ":id/reviewWeeklyActivityCheckBox")).isDisplayed();		

		driveR.findElement(By.xpath("//android.widget.TextView[@text='All escalations have been reviewed']")).isDisplayed();
		driveR.findElement(By.id("" + env + ":id/escalationReviewCheckBox")).isDisplayed();		

		driveR.findElement(By.xpath("//android.widget.TextView[@text='Next steps have been documented']")).isDisplayed();
		driveR.findElement(By.id("" + env + ":id/nextStepDocumentedCheckBox")).isDisplayed();		

		driveR.findElement(By.xpath("//android.widget.TextView[@text='Weekly Store Manager Code Check completed and recorded in Store Managers Logbook']")).isDisplayed();
		driveR.findElement(By.id("" + env + ":id/weeklyStoreManagerCodeCheckCheckBox")).isDisplayed();		

		driveR.findElement(By.xpath("//android.widget.TextView[@text='SIGN OFF']")).isDisplayed();


	}


	////--------------------------------------------------------------------------------------------------------------------

	///Rasika

	public static void verifyMenus(){

		driveR.findElement(By.xpath("//android.widget.TextView[@text='Critical Checks' or @text='CRITICAL CHECKS']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[@text='Fixture' or @text='FIXTURE']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[@text='Promotions' or @text='PROMOTIONS']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[@text='Warehouse' or @text='WAREHOUSE']")).isDisplayed();
	}

	public void verifyAisleListDisplayed() throws Throwable {

		Thread.sleep(3000);
		List<AndroidElement> profile = driveR.findElements(
				MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_title']"));

		for (AndroidElement a : profile) {

			String aisleText = a.getText();
			System.out.println("Aisle text  " + aisleText);

		}	
	}

	public void verifyDeptListDisplayed() throws Throwable {

		Thread.sleep(3000);
		List<AndroidElement> profile = driveR.findElements(
				MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_title']"));

		for (AndroidElement a : profile) {

			String deptText = a.getText();
			System.out.println("Department text  " + deptText);

		}		
	}

	public void clickOnCurrentSchedule()  throws Throwable {
		Date date = new Date();

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dd = calendar.get(Calendar.DAY_OF_MONTH);
		String dateText = String.valueOf(dd);

		System.out.println("Date text : " + dateText);

		Thread.sleep(5000);
		List<AndroidElement> profile = driveR.findElements(
				MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_title']"));

		for (AndroidElement a : profile) {

			String dateUI = a.getText();
			System.out.println("Date from UI : " + dateUI);

			if(dateUI.contains(dateText)){
				a.click();
				Thread.sleep(3000);

				break;
			}
		}
	}

	//////////// Overdue/Previous schedule
	public void clickOnPreviousOverdueSchedule()  throws Throwable {
		Date date = new Date();

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dd = calendar.get(Calendar.DAY_OF_MONTH) - 1;
		String dateText = String.valueOf(dd);

		System.out.println("Date text : " + dateText);

		Thread.sleep(5000);
		List<AndroidElement> profile = driveR.findElements(
				MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_title']"));

		for (AndroidElement a : profile) {

			String dateUI = a.getText();
			System.out.println("Date from UI : " + dateUI);

			if(dateUI.contains(dateText)){
				a.click();
				Thread.sleep(3000);

				break;
			}
		}
	}
	
	public void clickOnDaySchedule()  throws Throwable {

		Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        System.out.println("Date " + c.getTime());
        Date dateee = c.getTime();
       SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

        String date1 = format1.format(dateee); 
    String dayNumber = date1.split("-")[2];
        System.out.println("Date " + dayNumber);
        
		Thread.sleep(5000);
		List<AndroidElement> profile = driveR.findElements(
				MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_title']"));

		for (AndroidElement a : profile) {

			String dateUI = a.getText();
			System.out.println("Date from UI : " + dateUI);

			if(dateUI.contains(dayNumber)){
				a.click();
				Thread.sleep(3000);

				break;
			}
		}
	}

	public void enterMin(String productMin) throws Throwable {
		Thread.sleep(3000);

		driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/action_barcode_entry' or @resource-id='" + env + ":id/barcode_entry_edit_text']"))
		.sendKeys(productMin);
		Thread.sleep(3000);

		driveR.executeScript("mobile:performEditorAction", ImmutableMap.of("com/morrisons/common/action","search"));

		Thread.sleep(5000);
	}


	public void verifyNextScanDate() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/checkDate']")).isDisplayed();

		String nextScanDate = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/checkDate']")).getText();
		System.out.println("Next scan date : " + nextScanDate);
	}

	public void clickOnLogProduct() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/btn_AddExpiringProduct']")).isDisplayed();

		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/btn_AddExpiringProduct']")).click();
		Thread.sleep(3000);
	}

	public void clickOnCompleteCodeCheck() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.Button[@text='Complete Code Check' or @text='COMPLETE CODE CHECK']")).isDisplayed();

		driveR.findElement(By.xpath("//android.widget.Button[@text='Complete Code Check' or @text='COMPLETE CODE CHECK']")).click();

	}

	public void verifyRatingsPageDisplayed() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.ImageView[@resource-id='" + env + ":id/fresh_check_rotate']"))
		.isDisplayed();

		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/rotation_title']"))
		.isDisplayed();

		String title = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/rotation_title']"))
				.getText();

		assertEquals(title, "Please rate how well this section was rotated", "Rotation page title is mismatched");

	}

	public void clickOnRatings(String ratingOption) throws Throwable {

		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/rating_options_text' and @text = '"+ratingOption+"']"))
		.isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/rating_options_text' and @text = '"+ratingOption+"']"))
		.click();

		try{
			driveR.findElement(By.xpath("//android.widget.Button[@text='Confirm' or @text='CONFIRM']")).isDisplayed();

			driveR.findElement(By.xpath("//android.widget.Button[@text='Confirm' or @text='CONFIRM']")).click();	
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void clickOnConfirmButton() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.Button[@text='Confirm' or @text='CONFIRM']")).isDisplayed();

		driveR.findElement(By.xpath("//android.widget.Button[@text='Confirm' or @text='CONFIRM']")).click();	

	}

	public void clickOnCategoryCompletion() throws Throwable {

		try{
			driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/completeEscalationBtn']")).isDisplayed();

			driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/completeEscalationBtn']")).click();	

			System.out.println("Click on Category completion button");
		}
		catch(Exception e){System.out.println(e.getMessage());}

	}

	public void verifyCompletedDetails(String productTitle) throws Throwable {
		Thread.sleep(3000);
		driveR.findElement(By.xpath("//android.widget.TextView[@text='"+productTitle+"']")).isDisplayed();

		driveR.findElement(By.xpath("//android.widget.TextView[@text='"+productTitle+"']/following::android.widget.TextView[@resource-id='" + env + ":id/description_line1']"))
		.isDisplayed();
		String completedStatus = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+productTitle+"']/following::android.widget.TextView[@resource-id='" + env + ":id/description_line1']")).getText();


		driveR.findElement(By.xpath("//android.widget.TextView[@text='"+productTitle+"']/following::android.widget.TextView[@resource-id='" + env + ":id/department_status']"))
		.isDisplayed();
		String departmentStatus = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+productTitle+"']/following::android.widget.TextView[@resource-id='" + env + ":id/department_status']")).getText();

		assertEquals(departmentStatus, "Completed", "Department Status is mismatched");

		driveR.findElement(By.xpath("//android.widget.TextView[@text='"+productTitle+"']/following::android.widget.TextView[@resource-id='" + env + ":id/rotation_rating_value']"))
		.isDisplayed();
		String rotationRatingValue = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+productTitle+"']/following::android.widget.TextView[@resource-id='" + env + ":id/rotation_rating_value']")).getText();

	}


	public void clickOnReopenCodeRotate() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.Button[@text='Re-Open Code Rotate Group' or @text='RE-OPEN CODE ROTATE GROUP']")).isDisplayed();

		driveR.findElement(By.xpath("//android.widget.Button[@text='Re-Open Code Rotate Group' or @text='RE-OPEN CODE ROTATE GROUP']")).click();

	}

	public void clickOnReopenCodeRotateAlert() throws Throwable
	{
		WebElement reopenDepartmentAlert = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/alertTitle']"));
		reopenDepartmentAlert.isDisplayed();

		String alertTitle = reopenDepartmentAlert.getText().trim();
		assertEquals(alertTitle, "Reopen Department","Reopen department alert title is mismatched");

		WebElement reopenDepartmentAlertText = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']"));
		reopenDepartmentAlertText.isDisplayed();

		String alertText = reopenDepartmentAlertText.getText().trim();
		assertEquals(alertText, "Are you sure you want to open the completed check for this department?","Reopen department alert text is mismatched");
		Thread.sleep(3000);

		String expectedValue = null;
		String yesButtonText = driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']"))
				.getText().trim();
		Thread.sleep(3000);
		System.out.println("Captured name = " + yesButtonText);

		if(CharMatcher.javaUpperCase().matchesAllOf(yesButtonText)){
			expectedValue = "YES";
		}
		else{
			expectedValue = "Yes";
		}
		assertEquals(yesButtonText, expectedValue,"Yes button text is mismatched");
		Thread.sleep(3000);

		String expectedValue1 = null;
		String noButtonText = driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button2']"))
				.getText().trim();
		Thread.sleep(3000);
		System.out.println("Captured name = " + yesButtonText);

		if(CharMatcher.javaUpperCase().matchesAllOf(yesButtonText)){
			expectedValue1 = "NO";
		}
		else{
			expectedValue1 = "No";
		}
		assertEquals(noButtonText, expectedValue1,"No button text is mismatched");
		Thread.sleep(3000);
	}

	public void clickOnNoReopenCode() throws Throwable
	{
		WebElement xpathNoButton = driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button2']"));
		xpathNoButton.isDisplayed();
		xpathNoButton.click();
	}

	public void clickOnYesReopenCode() throws Throwable
	{
		Thread.sleep(3000);
		WebElement xpathYesButton = driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']"));
		xpathYesButton.isDisplayed();
		xpathYesButton.click();
	}

	public boolean verifyReopenCodeRotate() throws Throwable {

		return driveR.findElement(By.xpath("//android.widget.Button[@text='Re-Open Code Rotate Group' or @text='RE-OPEN CODE ROTATE GROUP']")).isDisplayed();

	}



	public void verifyCompletePromotion() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.Button[@text='Complete Promotions' or @text='COMPLETE PROMOTIONS']")).isDisplayed();
	}

	public void clickOnCompletePromotions() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.Button[@text='Complete Promotions' or @text='COMPLETE PROMOTIONS']")).isDisplayed();

		driveR.findElement(By.xpath("//android.widget.Button[@text='Complete Promotions' or @text='COMPLETE PROMOTIONS']")).click();

	}

	public void clickOnReopenPromotions() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.Button[@text='Re-Open Promotions' or @text='RE-OPEN PROMOTIONS']")).isDisplayed();

		driveR.findElement(By.xpath("//android.widget.Button[@text='Re-Open Promotions' or @text='RE-OPEN PROMOTIONS']")).click();

	}

	public void verifyCompleteWarehouse() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.Button[@text='Complete Warehouse' or @text='COMPLETE WAREHOUSE']")).isDisplayed();
	}

	public void clickOnCompleteWarehouse() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.Button[@text='Complete Warehouse' or @text='COMPLETE WAREHOUSE']")).isDisplayed();

		driveR.findElement(By.xpath("//android.widget.Button[@text='Complete Warehouse' or @text='COMPLETE WAREHOUSE']")).click();

		driveR.findElement(By.xpath("//android.widget.Button[@text='Continue' or @text='CONTINUE']")).isDisplayed();

		driveR.findElement(By.xpath("//android.widget.Button[@text='Continue' or @text='CONTINUE']")).click();


	}

	public void clickOnReopenWarehouse() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.Button[@text='Re-Open Warehouse' or @text='RE-OPEN WAREHOUSE']")).isDisplayed();

		driveR.findElement(By.xpath("//android.widget.Button[@text='Re-Open Warehouse' or @text='RE-OPEN WAREHOUSE']")).click();

	}

	public void verifyOneWastageCode() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.CheckedTextView[@text='Charity - Out of Date']")).isDisplayed();

		driveR.findElement(By.xpath("//android.widget.CheckedTextView[@text='Waste - Out of Date']")).isDisplayed();

	}

	public void verifyThreeWastageCode() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.CheckedTextView[@text='Charity - Out of Date']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.CheckedTextView[@text='Waste - Out of Date']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.CheckedTextView[@text='Waste - Damaged']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.CheckedTextView[@text='Charity - Damaged']")).isDisplayed();
	}

	public boolean verifyCompleteCodeCheck() throws Throwable {

		return driveR.findElement(By.xpath("//android.widget.Button[@text='Complete Code Check' or @text='COMPLETE CODE CHECK']")).isDisplayed();

	}

	public void completeAllAisle() throws Throwable {

		if(locationStatusUI.equalsIgnoreCase("Not Checked")||locationStatusUI.equalsIgnoreCase("In Progress"))
		{
			List<String> aisleList = new ArrayList<String>();
			List<String> deptList = new ArrayList<String>();
			String aisleStatus = null;
			String deptStatus = null;

			List<AndroidElement> xpathAisles = driveR.findElements(MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_title']"));

			for (AndroidElement xpathAisle : xpathAisles) {

				String aisleText = xpathAisle.getText();
				aisleList.add(aisleText);
			}

			for (String aisle : aisleList) {
				System.out.println("Aisle text  " + aisle);

				scrollThePage(aisle); ////If aisle is not displayed on screen , Then scroll the page.

				try{
					aisleStatus = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+aisle+"']//following-sibling::android.widget.TextView[@resource-id='" + env + ":id/department_status']")).getText();
				}
				catch(Exception e){
					aisleStatus = "Not Checked";
				}
				if(aisleStatus.equalsIgnoreCase("Not Checked")||aisleStatus.equalsIgnoreCase("In Progress")){
					Thread.sleep(3000);

					driveR.findElement(By.xpath("//android.widget.TextView[@text='"+aisle+"']")).click();
					Thread.sleep(3000);

					List<AndroidElement> xpathDepts = driveR.findElements(MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_title']"));

					for (AndroidElement xpathDept : xpathDepts) {

						String deptText = xpathDept.getText();
						deptList.add(deptText);
					}

					for (String dept : deptList) {
						System.out.println("Dept text  " + dept);

						scrollThePage(dept); ////If dept is not displayed on screen , Then scroll the page.

						try{
							deptStatus = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+dept+"']//following-sibling::android.widget.TextView[@resource-id='" + env + ":id/department_status']")).getText();
						}
						catch(Exception e){
							deptStatus = "Not Checked";
						}

						if(deptStatus.equalsIgnoreCase("Not Checked")||deptStatus.equalsIgnoreCase("In Progress")){
							Thread.sleep(3000);

							driveR.findElement(By.xpath("//android.widget.TextView[@text='"+dept+"']")).click();
							clickOnViewList();
							if(verifyCompleteCodeCheck()){

								clickOnCompleteCodeCheck();

								clickOnRatings("Good");
							}

							Thread.sleep(3000);
							driveR.findElement(By.className("android.widget.ImageButton")).click();
							System.out.println("Click on back button");

							driveR.findElement(By.xpath("//android.widget.TextView[@text='"+aisle+"']")).click();
						}
					}
					Thread.sleep(3000);
					driveR.findElement(By.className("android.widget.ImageButton")).click();
					System.out.println("Click on back button");

				}	
				deptList.clear();
			}
		}
	}

	public void completeWithPoorRating() throws Throwable {

		
		boolean poorRotation = false;
		
		if(locationStatusUI.equalsIgnoreCase("Not Checked")||locationStatusUI.equalsIgnoreCase("In Progress"))
		{
			List<String> aisleList = new ArrayList<String>();
			List<String> deptList = new ArrayList<String>();
			String aisleStatus = null;
			String deptStatus = null;

			List<AndroidElement> xpathAisles = driveR.findElements(MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_title']"));

			for (AndroidElement xpathAisle : xpathAisles) {

				String aisleText = xpathAisle.getText();
				aisleList.add(aisleText);
			}

			for (String aisle : aisleList) {
				System.out.println("Aisle text  " + aisle);

				scrollThePage(aisle); ////If aisle is not displayed on screen , Then scroll the page.

				try{
					aisleStatus = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+aisle+"']//following-sibling::android.widget.TextView[@resource-id='" + env + ":id/department_status']")).getText();
				}
				catch(Exception e){
					aisleStatus = "Not Checked";
				}
				if(aisleStatus.equalsIgnoreCase("Not Checked")||aisleStatus.equalsIgnoreCase("In Progress")){
					Thread.sleep(3000);

					driveR.findElement(By.xpath("//android.widget.TextView[@text='"+aisle+"']")).click();
					Thread.sleep(3000);

					List<AndroidElement> xpathDepts = driveR.findElements(MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_title']"));

					for (AndroidElement xpathDept : xpathDepts) {

						String deptText = xpathDept.getText();
						deptList.add(deptText);
					}

					for (String dept : deptList) {
						System.out.println("Dept text  " + dept);

						scrollThePage(dept); ////If dept is not displayed on screen , Then scroll the page.

						try{
							deptStatus = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+dept+"']//following-sibling::android.widget.TextView[@resource-id='" + env + ":id/department_status']")).getText();
						}
						catch(Exception e){
							deptStatus = "Not Checked";
						}

						if(deptStatus.equalsIgnoreCase("Not Checked")||deptStatus.equalsIgnoreCase("In Progress")){
							Thread.sleep(3000);

							driveR.findElement(By.xpath("//android.widget.TextView[@text='"+dept+"']")).click();
							clickOnViewList();
							if(verifyCompleteCodeCheck()){

								clickOnCompleteCodeCheck();

								clickOnRatings("Poor");
								
								driveR.findElement(By.xpath("//android.widget.Button[@text='Confirm' or @text='CONFIRM']")).click();	
								
								poorRotation = true;
							}

							Thread.sleep(3000);
							driveR.findElement(By.className("android.widget.ImageButton")).click();
							System.out.println("Click on back button");

							driveR.findElement(By.xpath("//android.widget.TextView[@text='"+aisle+"']")).click();
						}
						if(poorRotation)
						break;
					}
					Thread.sleep(3000);
					driveR.findElement(By.className("android.widget.ImageButton")).click();
					System.out.println("Click on back button");

				}	
				deptList.clear();
				if(poorRotation)
					break;
			}
		}
	}
	
	public void clickOnViewList() throws Throwable {
		try{
			WebElement xpathViewList = driveR.findElement(By.xpath("//android.widget.ImageView[@resource-id='" + env + ":id/singleItemIcon']"));
			xpathViewList.isDisplayed();
			xpathViewList.click();
			System.out.println("Click on view list");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	public void scrollThePage(String name) throws Throwable {
		boolean isAisleDisplayed = false;
		try{
			isAisleDisplayed = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+name+"']")).isDisplayed();
		}
		catch(Exception e){
			isAisleDisplayed = false;
		}

		if(!isAisleDisplayed){
			Thread.sleep(2000);
			TouchAction ts = new TouchAction(driveR);
			ts.press(PointOption.point(350, 1515)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
			.moveTo(PointOption.point(300, 390)).release().perform();
		}
	}

	public void reopenFirstAisle() throws Throwable {


		List<AndroidElement> xpathAisles = driveR.findElements(
				MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_title']"));

		for (AndroidElement xpathAisle : xpathAisles) {

			String aisleText = xpathAisle.getText();
			System.out.println("Aisle text  " + aisleText);

			xpathAisle.click();
			Thread.sleep(3000);

			List<AndroidElement> xpathDepts = driveR.findElements(
					MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_title']"));

			for (AndroidElement xpathDept : xpathDepts) {

				String deptText = xpathDept.getText();
				System.out.println("Dept text  " + deptText);

				xpathDept.click();
				Thread.sleep(3000);

				if(verifyReopenCodeRotate()){
					clickOnReopenCodeRotate();

					clickOnRatings("Good");
				}
				break;
			}
		}	
	}

	public void verifyScannedMin(String productMin) throws Throwable {
		boolean minDisplayed = false;
		Thread.sleep(3000);
		List<WebElement> xpathMINNumbers = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/list_item_min']"));

		for(WebElement xpathMin : xpathMINNumbers){

			String actualMINNumber = xpathMin.getText().trim();
			System.out.println(actualMINNumber);

			if(actualMINNumber.equals(productMin)){
				minDisplayed = true;
				break;
			}
		}
		assertEquals(minDisplayed, true, "MIN value is mismatched");
	}


	public void verifyScannedItemActionUI(String productMin, String expectedAction) throws Throwable {
		System.out.println("Min number : " + productMin);
		System.out.println("Min com.morrisons.common.action : " + expectedAction);

		boolean action = false;

		List<WebElement> xpathMINNumbers = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/list_item_min']"));

		int totalEntries = xpathMINNumbers.size();

		for(int i = 0; i<= totalEntries-1;i++)
		{

			String xpathMINNumber = driveR.findElement(By.xpath("//android.widget.FrameLayout[@index='"+i+"']//android.widget.TextView[@resource-id='" + env + ":id/list_item_min']")).getText().trim();

			System.out.println("Min number UI : " + xpathMINNumber);
			WebElement xpathMINAction = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/list_item_quantity_value']"));
			String actualAction = xpathMINAction.getText().replaceAll("\\d", "").trim();
			System.out.println("Min Action UI : " + actualAction);

			if(xpathMINNumber.equals(productMin) && actualAction.equals(expectedAction)){
				System.out.println("Matched....");
				action = true;
				break;
			}
		}

		assertEquals(action, true,"Scanned item com.morrisons.common.action is mismatched");

	}



	public void verifyActionCriticlCheck(String productMin, String expectedAction) throws Throwable {
		System.out.println("Min number : " + productMin);
		System.out.println("Min com.morrisons.common.action : " + expectedAction);

		boolean action = false;

		List<WebElement> xpathMINNumbers = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/list_item_min']"));

		int totalEntries = xpathMINNumbers.size();

		for(int i = 0; i<= totalEntries-1;i++)
		{

			String xpathMINNumber = driveR.findElement(By.xpath("//android.widget.FrameLayout[@index='"+i+"']//android.widget.TextView[@resource-id='" + env + ":id/list_item_min']")).getText().trim();

			System.out.println("Min number UI : " + xpathMINNumber);
			WebElement xpathMINAction = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/list_item_action_value']"));
			String actualAction = xpathMINAction.getText().replaceAll("\\d", "").trim();
			System.out.println("Min Action UI : " + actualAction);

			if(xpathMINNumber.equals(productMin) && actualAction.equals(expectedAction)){
				System.out.println("Matched....");
				action = true;
				break;
			}
		}

		assertEquals(action, true,"Scanned item com.morrisons.common.action is mismatched");

	}

	public void verifyProductNotRangedAlert() throws Throwable {
		driveR.findElement(By.xpath("//android.widget.TextView[@text='Product Not Ranged' or @text='PRODUCT NOT RANGED']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.Button[@text='Cancel' or @text='CANCEL']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.Button[@text='Continue' or @text='CONTINUE']")).isDisplayed();
	}


	public void verifyProductIsDeleted(String productMin) throws Throwable {
		System.out.println("Min number : " + productMin);

		boolean isPresent = false;
		List<String> productMinList = new ArrayList<String>();

		List<WebElement> xpathMINNumbers = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/list_item_min']"));

		for(WebElement xpathMin : xpathMINNumbers){
			String minUI = xpathMin.getText().trim();
			System.out.println("Min number UI : " + minUI);

			productMinList.add(minUI);
		}

		if(!productMinList.contains(productMin)){
			isPresent = true;
		}

		assertEquals(isPresent, true,"Product is not deleted");
	}

	public void verifyReopenWarehouseAlert() throws Throwable
	{
		WebElement reopenDepartmentAlert = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/alertTitle']"));
		reopenDepartmentAlert.isDisplayed();

		String alertTitle = reopenDepartmentAlert.getText().trim();
		assertEquals(alertTitle, "Reopen Warehouse","Reopen Warehouse alert title is mismatched");

		WebElement reopenDepartmentAlertText = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']"));
		reopenDepartmentAlertText.isDisplayed();

		String alertText = reopenDepartmentAlertText.getText().trim();
		assertEquals(alertText, "Are you sure you want to open the completed check for this location?","Reopen Warehouse alert text is mismatched");
		Thread.sleep(3000);

		String expectedValue = null;
		String yesButtonText = driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']"))
				.getText().trim();
		Thread.sleep(3000);
		System.out.println("Captured name = " + yesButtonText);

		if(CharMatcher.javaUpperCase().matchesAllOf(yesButtonText)){
			expectedValue = "YES";
		}
		else{
			expectedValue = "Yes";
		}
		assertEquals(yesButtonText, expectedValue,"Yes button text is mismatched");
		Thread.sleep(3000);

		String expectedValue1 = null;
		String noButtonText = driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button2']"))
				.getText().trim();
		Thread.sleep(3000);
		System.out.println("Captured name = " + yesButtonText);

		if(CharMatcher.javaUpperCase().matchesAllOf(noButtonText)){
			expectedValue1 = "NO";
		}
		else{
			expectedValue1 = "No";
		}
		assertEquals(noButtonText, expectedValue1,"No button text is mismatched");
		Thread.sleep(3000);
	}
	
	public void verifyReopenPromotionAlert() throws Throwable
	{
		WebElement reopenDepartmentAlert = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/alertTitle']"));
		reopenDepartmentAlert.isDisplayed();

		String alertTitle = reopenDepartmentAlert.getText().trim();
		assertEquals(alertTitle, "Reopen Promotions","Reopen Promotions alert title is mismatched");

		WebElement reopenDepartmentAlertText = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']"));
		reopenDepartmentAlertText.isDisplayed();

		String alertText = reopenDepartmentAlertText.getText().trim();
		assertEquals(alertText, "Are you sure you want to open the completed check for this location?","Reopen Promotions alert text is mismatched");
		Thread.sleep(3000);

		String expectedValue = null;
		String yesButtonText = driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']"))
				.getText().trim();
		Thread.sleep(3000);
		System.out.println("Captured name = " + yesButtonText);

		if(CharMatcher.javaUpperCase().matchesAllOf(yesButtonText)){
			expectedValue = "YES";
		}
		else{
			expectedValue = "Yes";
		}
		assertEquals(yesButtonText, expectedValue,"Yes button text is mismatched");
		Thread.sleep(3000);

		String expectedValue1 = null;
		String noButtonText = driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button2']"))
				.getText().trim();
		Thread.sleep(3000);
		System.out.println("Captured name = " + yesButtonText);

		if(CharMatcher.javaUpperCase().matchesAllOf(yesButtonText)){
			expectedValue1 = "NO";
		}
		else{
			expectedValue1 = "No";
		}
		assertEquals(noButtonText, expectedValue1,"No button text is mismatched");
		Thread.sleep(3000);
	}

	public void verifyCancelContinueButton(){
		driveR.findElement(By.xpath("//android.widget.Button[@text='Cancel' or @text='CANCEL']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.Button[@text='Continue' or @text='CONTINUE']")).isDisplayed();
	}

	public void clickOnCancel() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.Button[@text='Cancel' or @text='CANCEL']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.Button[@text='Cancel' or @text='CANCEL']")).click();

	}

	public void clickOnContinue() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.Button[@text='Continue' or @text='CONTINUE']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.Button[@text='Continue' or @text='CONTINUE']")).click();


	}
	
	public void verifyStatus(String dept,String status) throws Throwable {
		boolean statusUI = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+dept+"']//following::android.widget.TextView[@text='"+status+"']")).isDisplayed();
		assertEquals(statusUI, true,"Department status is mismatched");
	}

	public void getStatus(String dept) throws Throwable {
		try{
			driveR.findElement(By.xpath("//android.widget.TextView[@text='"+dept+"']//following-sibling::android.widget.TextView[@resource-id='" + env + ":id/department_status']")).isDisplayed();
			locationStatusUI = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+dept+"']//following-sibling::android.widget.TextView[@resource-id='" + env + ":id/department_status']")).getText();
			System.out.println(dept + " location status is : " + locationStatusUI);
		}
		catch(Exception e){
			locationStatusUI = "Not Checked";
		}
	}

	public void verifyCheckStatus(String check,String status) throws Throwable {
		assertEquals(locationStatusUI, status, check + " status is mismatched");
	}

	public void verifyActionDetailPage() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/cr_title']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/select_action_text']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/Action_label']")).isDisplayed();

	}

	public void verifyLocationPage() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/store_locations']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/sub_title']")).isDisplayed();


	}

	public void enterLocationDetails() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/store_locations']")).isDisplayed();

		driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/aisle_number']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/aisle_number']")).sendKeys("2");
		driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/bay_number']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/bay_number']")).sendKeys("2");
		driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/shelf_number']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/shelf_number']")).sendKeys("2");
		driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/position']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/position']")).sendKeys("2");

		Thread.sleep(3000);
		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/nextActionButton']")).click();


	}

	////////////FCC phase 2
	///////////////////////////// Rasika

	public void verifySevenDayTitles() throws Throwable {


		WebElement xpathDateList  = driveR.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@resource-id='" + env + ":id/dateList']"));
		xpathDateList.isDisplayed();


		List<WebElement> xpathDateeList  = driveR.findElements(By.xpath("//android.support.v7.widget.RecyclerView[@resource-id='" + env + ":id/dateList']//android.widget.TextView[@resource-id='" + env + ":id/day']"));

		getDateListDetails(xpathDateeList);

		TouchAction ts = new TouchAction(driveR);
		ts.press(PointOption.point(520, 412)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(32, 412)).release().perform();
		Thread.sleep(7000);

		List<WebElement> xpathDateeList1  = driveR.findElements(By.xpath("//android.support.v7.widget.RecyclerView[@resource-id='" + env + ":id/dateList']//android.widget.TextView[@resource-id='" + env + ":id/day']"));

		getDateListDetails(xpathDateeList1);
	}

	public void getDateListDetails(List<WebElement> xpathList) throws Throwable {
		for(int i = 0; i<= xpathList.size()-1;i++)
		{
			WebElement xpathDay  = driveR.findElement(By.xpath("//android.widget.FrameLayout[@index = '"+i+"']//android.widget.TextView[@resource-id='" + env + ":id/day']"));
			xpathDay.isDisplayed();
			System.out.println("Day = " + xpathDay.getText());

			WebElement xpathDate  = driveR.findElement(By.xpath("//android.widget.FrameLayout[@index = '"+i+"']//android.widget.TextView[@resource-id='" + env + ":id/date']"));
			xpathDate.isDisplayed();
			System.out.println("Date = " + xpathDate.getText());

			WebElement xpathWastageValue  = driveR.findElement(By.xpath("//android.widget.FrameLayout[@index = '"+i+"']//android.widget.TextView[@resource-id='" + env + ":id/wastageValue']"));
			xpathWastageValue.isDisplayed();
			System.out.println("Wastage Value = " + xpathWastageValue.getText());

		}
	}

	public void clickOnFreshCheckCodeCompletion() throws Throwable {
		WebElement xpathFreshCheckCodeCompletion  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/departmentsLabel']"));
		xpathFreshCheckCodeCompletion.isDisplayed();
		xpathFreshCheckCodeCompletion.click();
	}

	public void verifySummaryScreen() throws Throwable {
		Thread.sleep(3000);
		WebElement xpathSummaryScreen = driveR.findElement(By.xpath("//android.widget.TextView[@text='Summary' or @text='SUMMARY' or @text='Summary & Sign Off']"));
		xpathSummaryScreen.isDisplayed();
	}

	public void verifyThreeTabsOnSummary() throws Throwable {
		WebElement xpathChecksTab = driveR.findElement(By.xpath("//android.widget.TextView[@text='CHECKS' or @text='Checks']"));
		xpathChecksTab.isDisplayed();

		WebElement xpathCategoriesTab = driveR.findElement(By.xpath("//android.widget.TextView[@text='CATEGORIES' or @text='Categories']"));
		xpathCategoriesTab.isDisplayed();

		WebElement xpathEscalationTab = driveR.findElement(By.xpath("//android.widget.TextView[@text='ESCALATIONS' or @text='Escalations']"));
		xpathEscalationTab.isDisplayed();
	}

	public void verifyDateSchedules() throws Throwable {
		WebElement xpathDateSchedules  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/check_days_txt']"));
		xpathDateSchedules.isDisplayed();
	}

	public void verifyListOfChecksWithCheckbox() throws Throwable {
		WebElement xpathCheckHeader  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/check_header']"));
		xpathCheckHeader.isDisplayed();

		WebElement xpathCompletionHeader  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/completion_header']"));
		xpathCompletionHeader.isDisplayed();

		List<WebElement> xpathCheckCompletion  = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/check_completion_txt']"));

		for(WebElement xpathCheck : xpathCheckCompletion){
			String checkText = xpathCheck.getText();
			System.out.println("Completion check : " + checkText);
		}

		List<WebElement> xpathCompletionCheckbox  = driveR.findElements(By.xpath("//android.widget.ImageView[@resource-id='" + env + ":id/completion_statusIV']"));

		for(WebElement xpathCheckbox : xpathCompletionCheckbox){
			xpathCheckbox.isDisplayed();
		}
	}

	public void clickOnCheckCompletionfilter() throws Throwable {
		WebElement xpathCheckCompletionfilter  = driveR.findElement(By.xpath("//android.widget.ImageView[@resource-id='" + env + ":id/imgFilter']"));
		xpathCheckCompletionfilter.isDisplayed();
		xpathCheckCompletionfilter.click();
	}

	public void verifyAllCheckOptionsDisplayed() throws Throwable {
		WebElement xpathAllChecks  = driveR.findElement(By.xpath("//android.widget.RelativeLayout[@index='0']//android.widget.TextView[@resource-id='" + env + ":id/text']"));
		xpathAllChecks.isDisplayed();
		String allCheckText = xpathAllChecks.getText();
		assertEquals(allCheckText,"All Checks","All checks detail mismatched");

		WebElement xpathCompleteChecks  = driveR.findElement(By.xpath("//android.widget.RelativeLayout[@index='1']//android.widget.TextView[@resource-id='" + env + ":id/text']"));
		xpathCompleteChecks.isDisplayed();
		String completeChecksText = xpathCompleteChecks.getText();
		assertEquals(completeChecksText,"Completed Checks","Complete checks detail mismatched");

		WebElement xpathIncompleteChecks  = driveR.findElement(By.xpath("//android.widget.RelativeLayout[@index='2']//android.widget.TextView[@resource-id='" + env + ":id/text']"));
		xpathIncompleteChecks.isDisplayed();
		String incompleteChecksText = xpathIncompleteChecks.getText();
		assertEquals(incompleteChecksText,"Incomplete Checks","Incomplete checks detail mismatched");
	}

	public void clickOnAllChecksOption() throws Throwable {
		WebElement xpathAllChecks  = driveR.findElement(By.xpath("//android.widget.TextView[@text='All Checks' or @text='ALL CHECKS']"));
		xpathAllChecks.isDisplayed();
		xpathAllChecks.click();
	}

	public void verifyAllChecksList() throws Throwable {
		List<WebElement> xpathCheckCompletion  = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/check_completion_txt']"));

		for(WebElement xpathCheck : xpathCheckCompletion){
			String checkText = xpathCheck.getText();
			System.out.println("Completion check : " + checkText);
		}

		List<WebElement> xpathCompletionCheckbox  = driveR.findElements(By.xpath("//android.widget.ImageView[@resource-id='" + env + ":id/completion_statusIV']"));

		for(WebElement xpathCheckbox : xpathCompletionCheckbox){
			xpathCheckbox.isDisplayed();
		}
	}

	public void clickOnCompleteChecks() throws Throwable {
		WebElement xpathCompleteChecks  = driveR.findElement(By.xpath("//android.widget.TextView[@text='Completed Checks' or @text='COMPLETED CHECKS']"));
		xpathCompleteChecks.isDisplayed();
		xpathCompleteChecks.click();
	}

	public void verifyCompleteChecks() throws Throwable {
		List<WebElement> xpathCheckCompletion  = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/check_completion_txt']"));

		for(WebElement xpathCheck : xpathCheckCompletion){
			String checkText = xpathCheck.getText();
			System.out.println("Completion check : " + checkText);
		}

		List<WebElement> xpathCompletionCheckbox  = driveR.findElements(By.xpath("//android.widget.ImageView[@resource-id='" + env + ":id/completion_statusIV']"));

		for(WebElement xpathCheckbox : xpathCompletionCheckbox){
			xpathCheckbox.isDisplayed();
		}
	}

	public void clickOnIncompleteChecks() throws Throwable {
		WebElement xpathIncompleteChecks   = driveR.findElement(By.xpath("//android.widget.TextView[@text='Incomplete Checks' or @text='INCOMPLETED CHECKS']"));
		xpathIncompleteChecks.isDisplayed();
		xpathIncompleteChecks.click();
	}

	public void verifyIncompleteChecks() throws Throwable {
		List<WebElement> xpathCheckCompletion  = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/check_completion_txt']"));

		for(WebElement xpathCheck : xpathCheckCompletion){
			String checkText = xpathCheck.getText();
			System.out.println("Completion check : " + checkText);
		}

		List<WebElement> xpathCompletionCheckbox  = driveR.findElements(By.xpath("//android.widget.ImageView[@resource-id='" + env + ":id/completion_statusIV']"));

		for(WebElement xpathCheckbox : xpathCompletionCheckbox){
			xpathCheckbox.isDisplayed();
		}
	}



	public void clickOnOutOfCodeFirstCheck() throws Throwable {
		WebElement xpathOutOfCodeFirstCheck  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/checksLabel']"));
		xpathOutOfCodeFirstCheck.isDisplayed();
		xpathOutOfCodeFirstCheck.click();
	}

	public void verifyCategoryCompletionTabs() throws Throwable {
		WebElement xpathFirstChecksTab  = driveR.findElement(By.xpath("//android.widget.TextView[@text='Daily' or @text='DAILY']"));
		xpathFirstChecksTab.isDisplayed();

		WebElement xpathSecondChecksTab  = driveR.findElement(By.xpath("//android.widget.TextView[@text='Afternoon' or @text='AFTERNOON']"));
		xpathSecondChecksTab.isDisplayed();

		WebElement xpathFMChecksTab  = driveR.findElement(By.xpath("//android.widget.TextView[@text='FM Check' or @text='FM CHECK']"));
		xpathFMChecksTab.isDisplayed();

		WebElement xpathCodeAlertsTab  = driveR.findElement(By.xpath("//android.widget.TextView[@text='Code Alerts' or @text='CODE ALERTS']"));
		xpathCodeAlertsTab.isDisplayed();

	}

	public void verifyCategoryCompletionDeptList() throws Throwable {
		WebElement xpathDeptList  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_header']"));
		xpathDeptList.isDisplayed();

		WebElement xpathDeptQty  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_quantity']"));
		xpathDeptQty.isDisplayed();

		WebElement xpathDeptAmount  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_amount']"));
		xpathDeptAmount.isDisplayed();
	}

	public void clickCategoryCompletionSorting() throws Throwable {
		WebElement xpathSortingSymbol  = driveR.findElement(By.xpath("//android.widget.ImageView[@resource-id='" + env + ":id/imgFilter']"));
		xpathSortingSymbol.isDisplayed();
		xpathSortingSymbol.click();
	}

	public void verifyTwoSortingOrders() throws Throwable {
		WebElement xpathLowestToHighest  = driveR.findElement(By.xpath("//android.widget.TextView[@text='Lowest to Highest £' or @text='LOWEST TO HIGHEST £']"));
		xpathLowestToHighest.isDisplayed();

		WebElement xpathHighestToLowest  = driveR.findElement(By.xpath("//android.widget.TextView[@text='Highest to Lowest £' or @text='HIGHEST TO LOWEST £']"));
		xpathHighestToLowest.isDisplayed();
	}

	public void verifyDeptListSortingOrder() throws Throwable {
		List<WebElement> xpathDeptList  = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_header']"));

		String dept1 = xpathDeptList.get(1).getText();
		assertEquals(dept1,"Critical Checks","Critical Checks is not at first position in list");

		String dept2 = xpathDeptList.get(2).getText();
		assertEquals(dept2,"Promotions","Promotions is not at second position in list");

		String dept3 = xpathDeptList.get(3).getText();
		assertEquals(dept3,"Warehouse","Warehouse is not at third position in list");
	}

	public void verifyProductListDisplayed() throws Throwable {

		try{
			List<WebElement> xpathProductList  = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/updated_list_item_description' or @resource-id='" + env + ":id/list_item_description']"));

			System.out.println("Product list size : " + xpathProductList.size());
			boolean listcount = xpathProductList.size()>0;
		}catch(Exception e){
			driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/no_data_found_text']"));
		}
	}

	public void verifyOutOfCodeFirstCheckDisplayed() throws Throwable {
		WebElement xpathOutOfCodeFirstCheck  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/checksLabel']"));
		xpathOutOfCodeFirstCheck.isDisplayed();

		String label = xpathOutOfCodeFirstCheck.getText();
		assertEquals(label,"Out of Code - Daily Checks (Waste)","'Out of Code - Daily Checks (Waste)' label is mismatched");
	}

	public void clickOnAnyDept() throws Throwable {
		List<WebElement> xpathDeptList  = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_header']"));
		xpathDeptList.get(4).click();
	}

	public void verifyListOfAisles() throws Throwable {
		boolean isAislePresent = false;


		List<WebElement> xpathDeptList  = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_header']"));
		List<String> aisleList = new ArrayList<String>();

		for(WebElement xpathDept : xpathDeptList){
			aisleList.add(xpathDept.getText());
		}

		for(String aisleName : aisleList){

			if(aisleName.startsWith("Aisle")){
				isAislePresent = true;
				break;
			}
		}

		assertEquals(isAislePresent,true,"Aisle list is not present");

	}

	public void clickOnDailyCheckTab() throws Throwable {
		WebElement xpathDailyCheck  = driveR.findElement(By.xpath("//android.widget.TextView[@text='Daily' or @text='DAILY']"));
		xpathDailyCheck.isDisplayed();
		xpathDailyCheck.click();
	}


	public void clickOnAfternoonCheckTab() throws Throwable {
		WebElement xpathSecondCheck  = driveR.findElement(By.xpath("//android.widget.TextView[@text='Afternoon' or @text='AFTERNOON']"));
		xpathSecondCheck.isDisplayed();
		xpathSecondCheck.click();
	}

	public void clickOnFMCheckTab() throws Throwable {
		WebElement xpathFMCheckTab  = driveR.findElement(By.xpath("//android.widget.TextView[@text='FM Check' or @text='FM CHECK']"));
		xpathFMCheckTab.isDisplayed();
		xpathFMCheckTab.click();
	}

	public void verifyLabelBelowOutOfCode() throws Throwable {
		WebElement xpathOutOfCodeLabel  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/checksLabel']"));
		xpathOutOfCodeLabel.isDisplayed();

		String label = xpathOutOfCodeLabel.getText();
		assertEquals(label,"Out of Code - Daily Checks (Waste)","'Out of Code - Daily Checks (Waste)' label is mismatched");
	}

	public void verifyTopThreeDept() throws Throwable {
		WebElement xpathHeader  = driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/wastage_header']"));
		xpathHeader.isDisplayed();

		List<WebElement> xpathDeptList  = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/departmentName']"));
		int deptCount  = xpathDeptList.size();
		System.out.println("deptCount : " + deptCount);
		assertEquals(deptCount,3,"Department count is mismatched");

		List<WebElement> xpathWastageQty  = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/wastageQty']"));
		int wastageQtyList  = xpathWastageQty.size();
		System.out.println("wastageQtyList : " + wastageQtyList);

		assertEquals(wastageQtyList,3,"Wastage qty count is mismatched");

		List<WebElement> xpathWastagePounds  = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/wastagePounds']"));
		int wastagePoundsList  = xpathWastagePounds.size();
		System.out.println("wastagePoundsList : " + wastagePoundsList);

		assertEquals(wastagePoundsList,3,"Wastage pounds is mismatched");

	}

	public void clickOnAnyDeptList() throws Throwable {
		List<WebElement> xpathDeptList  = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/departmentName']"));

		xpathDeptList.get(0).click(); // Clicking on First department from list
	}

	public void verifyAwaitingSignOffStatus(String menu) throws Throwable {
		WebElement xpathAwaitingSignOffStatus  = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+menu+"']/following::android.widget.TextView[@resource-id='" + env + ":id/department_status']"));
		xpathAwaitingSignOffStatus.isDisplayed();

		String deptStatus = xpathAwaitingSignOffStatus.getText();
		assertEquals(deptStatus,"Awaiting Sign-Off","Department status is mismatched");
	}

	public void verifySignOffBtnDisplayed() throws Throwable {
		WebElement xpathSignOffButton  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/signOffButton']"));
		xpathSignOffButton.isDisplayed();
	}

	public void clickOnSignOffButton() throws Throwable {
		WebElement xpathSignOffButton  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/signOffButton']"));
		xpathSignOffButton.isDisplayed();
		xpathSignOffButton.click();
	}

	public void verifySignOfPageContent() throws Throwable {
		WebElement xpathSignOffPageHeader  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/signOffDescLabel']"));
		xpathSignOffPageHeader.isDisplayed();


		WebElement xpathSignOffPageContent  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/SignOffConfirmationDescTV']"));
		xpathSignOffPageContent.isDisplayed();

		WebElement xpathReviewWeeklyAlert  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/reviewWeeklyActivityLabel']"));
		xpathReviewWeeklyAlert.isDisplayed();
		WebElement xpathReviewWeeklyAlertCheckbox  = driveR.findElement(By.xpath("//android.widget.CheckBox[@resource-id='" + env + ":id/reviewWeeklyActivityCheckBox']"));
		xpathReviewWeeklyAlertCheckbox.isDisplayed();

		WebElement xpathEscalationReviewed  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/escalationReviewLabel']"));
		xpathEscalationReviewed.isDisplayed();
		WebElement xpathEscalationReviewedCheckbox  = driveR.findElement(By.xpath("//android.widget.CheckBox[@resource-id='" + env + ":id/escalationReviewCheckBox']"));
		xpathEscalationReviewedCheckbox.isDisplayed();

		WebElement xpathNextStepDocumented  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/nextStepDocumentedLabel']"));
		xpathNextStepDocumented.isDisplayed();
		WebElement xpathNextStepDocumentedCheckbox  = driveR.findElement(By.xpath("//android.widget.CheckBox[@resource-id='" + env + ":id/nextStepDocumentedCheckBox']"));
		xpathNextStepDocumentedCheckbox.isDisplayed();

		WebElement xpathWeeklyStoreMangaerCompleted  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/weeklyStoreManagerCodeCheckLabel']"));
		xpathWeeklyStoreMangaerCompleted.isDisplayed();
		WebElement xpathWeeklyStoreMangaerCheckbox  = driveR.findElement(By.xpath("//android.widget.CheckBox[@resource-id='" + env + ":id/weeklyStoreManagerCodeCheckCheckBox']"));
		xpathWeeklyStoreMangaerCheckbox.isDisplayed();

	}

	public void selectSignOffCheckboxes() throws Throwable {

		WebElement xpathReviewWeeklyAlertCheckbox  = driveR.findElement(By.xpath("//android.widget.CheckBox[@resource-id='" + env + ":id/reviewWeeklyActivityCheckBox']"));
		xpathReviewWeeklyAlertCheckbox.isDisplayed();
		xpathReviewWeeklyAlertCheckbox.click();

		WebElement xpathEscalationReviewedCheckbox  = driveR.findElement(By.xpath("//android.widget.CheckBox[@resource-id='" + env + ":id/escalationReviewCheckBox']"));
		xpathEscalationReviewedCheckbox.isDisplayed();
		xpathEscalationReviewedCheckbox.click();

		WebElement xpathNextStepDocumentedCheckbox  = driveR.findElement(By.xpath("//android.widget.CheckBox[@resource-id='" + env + ":id/nextStepDocumentedCheckBox']"));
		xpathNextStepDocumentedCheckbox.isDisplayed();
		xpathNextStepDocumentedCheckbox.click();

		WebElement xpathWeeklyStoreMangaerCheckbox  = driveR.findElement(By.xpath("//android.widget.CheckBox[@resource-id='" + env + ":id/weeklyStoreManagerCodeCheckCheckBox']"));
		xpathWeeklyStoreMangaerCheckbox.isDisplayed();
		xpathWeeklyStoreMangaerCheckbox.click();
	}

	public void verifyPreviousWeekSignOff() throws Throwable {
		WebElement xpathPreviousWeekSignOff  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/summary_status']"));
		xpathPreviousWeekSignOff.isDisplayed();

		String previousWeek = xpathPreviousWeekSignOff.getText();
		assertEquals(previousWeek,"Signed Off","Previous week status is mismatched");
	}

	public void verifyWeekStatusSignOff() throws Throwable {
		WebElement xpathWeekStatusSignOff  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/summary_status']"));
		xpathWeekStatusSignOff.isDisplayed();

		String weekStatus = xpathWeekStatusSignOff.getText();
		assertEquals(weekStatus,"Signed Off","Week status is mismatched");
	}

	public void summaryPageHeader() throws Throwable {
		WebElement xpathDateRange  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/summary_date']"));
		xpathDateRange.isDisplayed();

		WebElement xpathAwaitingSignOfStatus  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/summary_status']"));
		xpathAwaitingSignOfStatus.isDisplayed();
	}

	public void escalationsViewStatusAndMsg() throws Throwable {
		WebElement xpathEscalationsLabel  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/escalationLabel']"));
		xpathEscalationsLabel.isDisplayed();
		String escalationLabel = xpathEscalationsLabel.getText();
		assertEquals(escalationLabel,"Escalations","Escalation label is mismatched");

		WebElement xpathEscalationDescription  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/escalationDescription']"));
		xpathEscalationDescription.isDisplayed();

		WebElement xpathEscalationView  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/escalationView']"));
		xpathEscalationView.isDisplayed();
	}

	public void clickOnEscalationOnSummary() throws Throwable {
		WebElement xpathEscalationView  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/escalationView']"));
		xpathEscalationView.isDisplayed();
	}


	public void verifyTotalWastageAmount() throws Throwable {
		WebElement xpathWastageLabel  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/wastageLabel']"));
		xpathWastageLabel.isDisplayed();
		WebElement xpathWastageValue  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/wastageValue']"));
		xpathWastageValue.isDisplayed();
	}

	public void clickOnEscalationsTab() throws Throwable {
		WebElement xpathEscalationsTab  = driveR.findElement(By.xpath("//android.widget.TextView[@text='ESCALATIONS' or @text='Escalations']"));
		xpathEscalationsTab.isDisplayed();
		xpathEscalationsTab.click();
	}
	
	public void verifyEscalationsPage() throws Throwable {
		Thread.sleep(3000);
		WebElement xpathEscalationsTab  = driveR.findElement(By.xpath("//android.widget.TextView[@text='ESCALATIONS' or @text='Escalations']"));
		xpathEscalationsTab.isDisplayed();
	}

	public void clickOnCurrentWeekDay() throws Throwable {


		TouchAction ts = new TouchAction(driveR);
		ts.press(PointOption.point(520, 412)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(32, 412)).release().perform();
		Thread.sleep(7000);

		List<WebElement> xpathDates  = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/check_days_txt']"));
		xpathDates.get(0).click(); //Clicking on First date schedule);
	}

	public void selectDaySchedule() throws Throwable {

		TouchAction ts = new TouchAction(driveR);
		ts.press(PointOption.point(520, 412)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(32, 412)).release().perform();
		Thread.sleep(7000);

		List<WebElement> xpathDates  = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/check_days_txt']"));
		int index = xpathDates.size()-1;
		
		////On screen day schedule is present in horizontal list. Hence, clicking two times.
		xpathDates.get(index).click(); //Clicking on day schedule);
		
		xpathDates  = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/check_days_txt']"));
		index = xpathDates.size()-1;
		xpathDates.get(index).click(); 
	}

	public void verifyEscalationsList() throws Throwable {
		boolean isEscalationList = false;
		boolean isNoEscalation = false;

		try{
			isEscalationList = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/escalation_status']")).isDisplayed();
		}catch(Exception e){}

		try{
			isNoEscalation = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tvNoEscalationsView']")).isDisplayed();
		}catch(Exception e){}

		if(isEscalationList){
			List<WebElement> xpathEscalationStatus  = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/escalation_status']"));
			boolean isPresent = true;
			for(WebElement xpathStatus : xpathEscalationStatus){

				String statusText = xpathStatus.getText();

				if(statusText.equals("VIEW")||statusText.equals("INCOMPLETE")){
					isPresent= true;
				}
				else{
					isPresent = false;
				}
				assertEquals(isPresent,true,"Escalation status with View/Incomplete status is not available");
			}
		}
		else if(isNoEscalation){
			String noEscalationText = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tvNoEscalationsView']")).getText();
			assertEquals(noEscalationText,"There are no escalations logged for selected date.","No escalation text is mismatched");
		}

		else{
			assertEquals(true,false); ////// If above two conditions are not satisfied. Then, mark is as failed.
		}

	}
	
	

	public void selectIncompleteEscalations() throws Throwable {
		WebElement xpathIncompleteEscalations  = driveR.findElement(By.xpath("//android.widget.TextView[@text='INCOMPLETE' or @text='Incomplete']"));
		xpathIncompleteEscalations.isDisplayed();
		xpathIncompleteEscalations.click();
	}

	public void verifyNextStepScreen() throws Throwable {
		WebElement xpathNextstepsHeader  = driveR.findElement(By.xpath("//android.widget.TextView[@text='Next Steps']"));
		xpathNextstepsHeader.isDisplayed();
		WebElement xpathDetailsOfEscalation  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/txt_action']"));
		xpathDetailsOfEscalation.isDisplayed();
		WebElement xpathNextSteps  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/txtHeading']"));
		xpathNextSteps.isDisplayed();
		WebElement xpathCheckName  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/check_name']"));
		xpathCheckName.isDisplayed();
		WebElement xpathAisleName  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/aisle_name']"));
		xpathAisleName.isDisplayed();
		WebElement xpathDetailOfProblem  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/txtProbLbl']"));
		xpathDetailOfProblem.isDisplayed();
		WebElement xpathInvestigationHeading  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/investigation_Heading']"));
		xpathInvestigationHeading.isDisplayed();
	}

	public void clickOnCompleteEscalationBtn() throws Throwable {
		WebElement xpathCompleteEscalationBtn  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/completeEscalationBtn']"));
		xpathCompleteEscalationBtn.isDisplayed();
		xpathCompleteEscalationBtn.click();
	}

	/////Verify Complete Next Steps alert title, message and continue button
	public void verifyCompleteNextStepAlert() throws Throwable {
		WebElement xpathAlertTitle  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/alertTitle']"));
		xpathAlertTitle.isDisplayed();
		String title  = xpathAlertTitle.getText();

		assertEquals(title,"Complete Next Steps","Complete next step alert title is mismatched");

		WebElement xpathAlertTitleMessage  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']"));
		xpathAlertTitleMessage.isDisplayed();
		String message  = xpathAlertTitleMessage.getText();

		assertEquals(title,"Please complete the next steps required for this escalation.","Complete next step alert title message is mismatched");

		WebElement xpathContinueButton  = driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']"));
		xpathContinueButton.isDisplayed();
	}

	public void clickOnContinueButton() throws Throwable {
		WebElement xpathContinueButton  = driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']"));
		xpathContinueButton.isDisplayed();
		xpathContinueButton.click();
	}

	//	public void addComment() throws Throwable {
	//		WebElement xpathChecksTab  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/check_completion_txt']"));
	//		xpathChecksTab.isDisplayed();
	//		xpathChecksTab.click();
	//	}

	public void clickOnSaveButton() throws Throwable {
		WebElement xpathSaveButton  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/save_escalation_button']"));
		xpathSaveButton.isDisplayed();
		xpathSaveButton.click();
	}

	public void verifyEscalationList() throws Throwable {
		boolean isListNotEmpty = false;
		WebElement xpathEscalationsScreen  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/escalation_txt']"));
		xpathEscalationsScreen.isDisplayed();

		List<WebElement> xpathEscalationList  = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/escalation_department']"));

		try{
			isListNotEmpty = !xpathEscalationList.isEmpty();
			assertEquals(isListNotEmpty,true,"Escalation list is empty");
		}
		catch(Exception e){
			isListNotEmpty = false;
		}
	}

	public void verifyLatestEditedEscalation() throws Throwable {
		WebElement xpathDepartment  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/escalation_department']"));
		xpathDepartment.isDisplayed();
		WebElement xpathTitle  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/escalation_title']"));
		xpathTitle.isDisplayed();
		WebElement xpathDescription  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/addedby_description']"));
		xpathDescription.isDisplayed();

	}

	public void clickOnView() throws Throwable {
		WebElement xpathView  = driveR.findElement(By.xpath("//android.widget.TextView[@text='VIEW' or @text='View']"));
		xpathView.isDisplayed();
		xpathView.click();
	}

	public void scrollDown() throws Throwable {
		Thread.sleep(2000);
		TouchAction ts = new TouchAction(driveR);
		ts.press(PointOption.point(350, 1515)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(300, 390)).release().perform();
	}

	public void addTheComment() throws Throwable {
		WebElement xpathCommentSection  = driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/sm_editTextComment']"));
		xpathCommentSection.isDisplayed();
		xpathCommentSection.sendKeys("TestComment");
	}
	
	public void editTheComment() throws Throwable {
		WebElement xpathEditIcon  = driveR.findElement(By.xpath("//android.widget.ImageView[@resource-id='" + env + ":id/sm_imgEditComment']"));
		xpathEditIcon.isDisplayed();
		xpathEditIcon.click();
		WebElement xpathCommentSection  = driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/sm_editTextComment']"));
		xpathCommentSection.isDisplayed();
		xpathCommentSection.sendKeys("TestComment-Edit");
	}
	
	public void notAllowToEditEscalation() throws Throwable {
		
		boolean isDisabled = true;
		
		WebElement xpathCommentSection  = driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/editTextComment']"));
		xpathCommentSection.isDisplayed();
		
		try{
		isDisabled = !xpathCommentSection.isEnabled();
		}
		catch(Exception e){
			isDisabled = false;
		}
		assertEquals(isDisabled,true, "User is allow to edit the escalations");
	}

	public void clickOnPreviousWeekDay() throws Throwable {
		List<WebElement> xpathDates  = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/check_days_txt']"));
		xpathDates.get(0).click(); //Clicking on First date schedule
	}

	public void clickOnCategoriesTab() throws Throwable {
		WebElement xpathCategoriesTab  = driveR.findElement(By.xpath("//android.widget.TextView[@text='CATEGORIES' or @text='Categories']"));
		xpathCategoriesTab.isDisplayed();
		xpathCategoriesTab.click();
	}

	public void clickOnDate() throws Throwable {
		List<WebElement> xpathDates  = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/check_days_txt']"));
		xpathDates.get(1).click(); //Clicking on Second date schedule
	}

	public void verifyCategoryCompletionSummary() throws Throwable {
		boolean isCategoryCompletionSummary = false;
		try{
			isCategoryCompletionSummary = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/check_completion_txt']")).isDisplayed();
		}
		catch(Exception e){
			isCategoryCompletionSummary = false;
		}
		assertEquals(isCategoryCompletionSummary,true, "Screen is not navigated to Category completion summary screen");
	}

	public void clickOnChecksTab() throws Throwable {

		WebElement xpathChecksTab  = driveR.findElement(By.xpath("//android.widget.TextView[@text='CHECKS' or @text='Checks']"));
		xpathChecksTab.isDisplayed();
		xpathChecksTab.click();
	}

	public void verifyChecksWithCheckbox() throws Throwable {

		List<WebElement> xpathAllchecks = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/check_completion_txt']"));

		for(WebElement xpathchecks : xpathAllchecks){
			String checksTitle  = xpathchecks.getText();

			WebElement xpathcheckbox  = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+checksTitle+"']//following::android.widget.ImageView[@resource-id='" + env + ":id/completion_statusIV']"));

			boolean isCheckboxPresent = false;
			try{
				isCheckboxPresent = xpathcheckbox.isDisplayed();
			}
			catch(Exception e){
				isCheckboxPresent = false;
			}

			assertEquals(isCheckboxPresent,true, "Checkbox is not present for "+checksTitle+" check");

		}

	}

	public void verifyHotekeysDisplayed() throws Throwable {
		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/context_menu']")).isDisplayed();
	}
	
	public void verifyProductMin(String min) throws Throwable {
		boolean isMinPresent = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+min+"']")).isDisplayed();
		assertEquals(isMinPresent,true, "Product min is not displayed");
	}

	public void verifyPreviousDayStatus(String status) throws Throwable {
		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/summary_status']")).isDisplayed();
		String statusUI = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/summary_status']")).getText();
		assertEquals(statusUI,status, "Previous day header status is mismatched...");
	}
	
	public void verifyDayTiles() throws Throwable {
		WebElement xpathDay  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/day']"));
		xpathDay.isDisplayed();
		WebElement xpathDate  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/date']"));
		xpathDate.isDisplayed();
		WebElement xpathWastageValue  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/wastageValue']"));
		xpathWastageValue.isDisplayed();

	}
	
	public void clickOnDayTiles() throws Throwable {
		WebElement xpathDay  = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/day']"));
		xpathDay.isDisplayed();
		xpathDay.click();
	}
	
	public void verifyAmbientProductMsg(String message) {
		String messageUI =	driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']")).getText().replaceAll("(?m)^[ \t]*\r?\n", "");




		//		String s1 = messageUI.split(".")[0];
		//		String s2 = messageUI.split(".")[1];
		//		String alertMsg = s1+s2;
		//		boolean ambientProductMsg = alertMsg.equalsIgnoreCase(message);
		//		assertEquals(ambientProductMsg, true, "Alert message is mismtached");

	}
	
	public void clickOnContinueBtn() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/alertTitle']")).isDisplayed();

		String alertTitle = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/alertTitle']")).getText();	
		assertEquals(alertTitle, "Complete Next Steps", "Alert title is mismtached");

		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']")).isDisplayed();
		String alertMessage = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']")).getText();	
		assertEquals(alertMessage, "Please complete the next steps required for this escalation.", "Alert message is mismtached");

		driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();
		System.out.println("Click on Continue button");	
	}

	public void selectproblemfoundEscalatn() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.Spinner[@resource-id='" + env + ":id/investigation_action_spinner']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.Spinner[@resource-id='" + env + ":id/investigation_action_spinner']")).click();
		Thread.sleep(1000);

		driveR.findElement(By.xpath("//android.widget.CheckBox[@resource-id='" + env + ":id/spinner_checkbox']")).click();


		TouchAction touchAction = new TouchAction(driveR).press(PointOption.point(100,300)).release().perform();
		Thread.sleep(3000);

	}

	public void addNextStepDetail() throws Throwable {
		scrollDown();

		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/next_action_title']")).isDisplayed();
		scrollDown();
		driveR.findElement(By.xpath("//android.widget.CheckBox[@resource-id='" + env + ":id/next_action_checkbox']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.CheckBox[@resource-id='" + env + ":id/next_action_checkbox']")).click();

		scrollDown();
		driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/comment']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/comment']")).sendKeys("TEST");

		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/btn_AddNextSteps']")).click();
	}

	public void completeAllEscalations() throws Throwable{
		List<WebElement> xpathEscalationsList = new ArrayList<WebElement>();


		xpathEscalationsList  = driveR.findElements(By.xpath("//android.widget.TextView[@text='INCOMPLETE']"));

		if(xpathEscalationsList==null){
			scrollDown();
			xpathEscalationsList  = driveR.findElements(By.xpath("//android.widget.TextView[@text='INCOMPLETE']"));
		}

		if(xpathEscalationsList!=null){
			for(WebElement xpathEscalation : xpathEscalationsList){
				xpathEscalation.click();

				clickOnCategoryCompletion();

				clickOnContinueBtn();

				selectproblemfoundEscalatn();

				addNextStepDetail();

				if(xpathEscalationsList==null){
					scrollDown();
					xpathEscalationsList  = driveR.findElements(By.xpath("//android.widget.TextView[@text='INCOMPLETE']"));
				}
			}
		}
	}

	public void getAllEnableDate() throws Throwable{

		for(int date = 1;date<=31;date++){

			if(driveR.findElement(By.xpath("//android.view.View[@text='"+date+"']")).isDisplayed()){

				boolean isDateEnabled = driveR.findElement(By.xpath("//android.view.View[@text='"+date+"']")).isEnabled();

				if(isDateEnabled){
					assertEquals(isDateEnabled, true, "Date is disabled on Calendar");
					String dateText = String.valueOf(date);
					dateList.add(dateText);
				}
			}
		}
	}

	public void verifyExpiryDate(String storeCategory) throws Throwable{
		LocalDateTime today = LocalDateTime.now(); // Storing current date

		if(storeCategory.equalsIgnoreCase("Intra")){

			int date = today.getDayOfMonth();
			System.out.println(date);// Getting Current Date

			boolean isCurrentDate = dateList.contains(date);
			assertEquals(isCurrentDate, true, "Current Date is disabled on Calendar");
		}
		else{
			if(storeCategory.equalsIgnoreCase("Non Intra")){

				int date = today.getDayOfMonth();
				System.out.println(date);// Getting Current Date

				boolean isCurrentDate = dateList.contains(date);
				assertEquals(isCurrentDate, true, "Current Date is disabled on Calendar");

				LocalDateTime nextDay = today.plusDays(1);
				int nextDate = nextDay.getDayOfMonth();
				System.out.println(nextDate);// Getting Next day Date

				boolean isNextDate = dateList.contains(nextDate);
				assertEquals(isNextDate, true, "Next day Date is disabled on Calendar");
			}
		}
	}

	public void shortLongDept() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.TextView[@text='Short life checks']")).isDisplayed();

		try{
			driveR.findElement(By.xpath("//android.widget.TextView[@text='Long life checks']")).isDisplayed();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void scrollUp() throws Throwable {
		Thread.sleep(2000);
		TouchAction ts = new TouchAction(driveR);
		ts.press(PointOption.point(300, 390)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(350, 1515)).release().perform();
	}
}

