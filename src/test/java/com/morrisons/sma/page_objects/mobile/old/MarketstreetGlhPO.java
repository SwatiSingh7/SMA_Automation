package com.morrisons.sma.page_objects.mobile.old;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import com.morrisons.sma.page_objects.service.GlhNegativePromptServicePO;
import com.morrisons.common.action.Hook;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MarketstreetGlhPO {
	
	private static AndroidDriver driveR;
	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
	String env = applicationConfig.getWebElementEnviroment().getEnv();

	public MarketstreetGlhPO()
	{
	this.driveR = (AndroidDriver) Hook.getDriver();
	
	}

	GlhNegativePromptServicePO glhNegativePromptServicePO = new GlhNegativePromptServicePO();
	private String locations;
	WebElement eMIN;
	private static String department;
	private static String types;
	private static String CountinReview;
	private static String CountinApprove;
	private static String ahigh;
	private static int xcord;
	private static int ycord;
	private static String Barcode;
	private static String Warningmsg;
	private static String MIN;
	private static String Product_Name;
	public static int xadjustmentValue;


	public void clickBackButton() throws InterruptedException {
		Thread.sleep(3000);
		driveR.findElement(By.className("android.widget.ImageButton")).click();
		Thread.sleep(3000);
	}
	public void clickMarketStret() {
		driveR.findElement(By.id(""+env+":id/market_street")).isDisplayed();
		driveR.findElement(By.id(""+env+":id/market_street")).click();
	}

	public void clickMrketStreetGLH() throws InterruptedException {
		Thread.sleep(2000);
		driveR.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Gaps, Lows, Highs')]")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Gaps, Lows, Highs')]")).click();

	}

	public void pleaseSelectLocation() {
		driveR.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Please select location')]")).isDisplayed();
	}

	public void clickCounter() throws InterruptedException {
		driveR.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Counter & Fixture')]")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Counter & Fixture')]")).click();
		Thread.sleep(5000);

	}

	public void clickOther() throws InterruptedException {
		driveR.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Other')]")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Other')]")).click();
		Thread.sleep(5000);

	}
	
	public void clickReview() throws InterruptedException {
		driveR.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Review')]")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Review')]")).click();
		Thread.sleep(5000);

	}
	

	public void confirmPopup() throws InterruptedException {
		Thread.sleep(5000);
		driveR.findElement(By.xpath("//android.widget.Button[contains(@text, 'OK')]")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.Button[contains(@text, 'OK')]")).click();
		
	}

	public void productViewlist() throws InterruptedException {
		Thread.sleep(5000);
		driveR.findElement(By.id(""+env+":id/storewalk_list_item_description")).isDisplayed();

	}

	public void clickViewlist() throws InterruptedException {
		Thread.sleep(5000);
		driveR.findElement(By.id(""+env+":id/singleItemHeader")).isDisplayed();
		driveR.findElement(By.id(""+env+":id/singleItemHeader")).click();

	}

	public void itemlist(String arg1) throws InterruptedException {
		 Barcode = arg1;

		 driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + Barcode + "']")).isDisplayed();
			Thread.sleep(5000);

			}
	public void confirmCountArea() throws InterruptedException {
		Thread.sleep(3000);
		driveR.findElement(By.xpath("//android.widget.Button[contains(@text, 'CONFIRM COUNT AREA')]")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.Button[contains(@text, 'CONFIRM COUNT AREA')]")).click();
		Thread.sleep(3000);
		driveR.findElement(By.xpath("//android.widget.Button[contains(@text, 'CONFIRM')]")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.Button[contains(@text, 'CONFIRM')]")).click();
		Thread.sleep(3000);
		try{
			if(driveR.findElement(By.xpath("//android.widget.Button[contains(@text, 'OK')]")).isDisplayed())
			{Thread.sleep(3000);
			driveR.findElement(By.xpath("//android.widget.Button[contains(@text, 'OK')]")).click(); 
			}
			else
		    	System.out.println("Exit button not found");

		}
		catch(NoSuchElementException e) {
			System.out.println("Manager Approval Not required !!");
		}
		Thread.sleep(5000);

	}
	public void clickExitCounter() throws InterruptedException {
		driveR.findElement(By.xpath("//android.widget.Button[contains(@text, 'EXIT COUNTER & FIXTURE')]")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.Button[contains(@text, 'EXIT COUNTER & FIXTURE')]")).click();
		Thread.sleep(5000);
		try{
		    if(driveR.findElement(By.xpath("//android.widget.TextView[contains(@text, 'EXIT COUNTER & FIXTURE')]")).isDisplayed())
				{driveR.findElement(By.xpath("//android.widget.Button[contains(@text, 'EXIT COUNTER & FIXTURE')]")).click();
		    	System.out.println("Element is present and displayed");
				}
		    else
		    	System.out.println("Exit button not found");
		}catch (NoSuchElementException e) {
		    System.out.println("Element is not present, hence not displayed as well");
		}
	}
	

	public void clickBackup() throws InterruptedException {
		driveR.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Backup')]")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Backup')]")).click();
		Thread.sleep(5000);

	}

	public void enterQuantity(String arg1) throws InterruptedException {
		//driveR.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Enter quantity')]")).click();
		driveR.findElement(By.id(""+env+":id/quantityEditText")).sendKeys(arg1);
		Thread.sleep(5000);

	}

	public void exitOther() throws InterruptedException {
		driveR.findElement(By.xpath("//android.widget.Button[contains(@text, 'EXIT OTHER')]")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.Button[contains(@text, 'EXIT OTHER')]")).click();
		Thread.sleep(5000);

	}

	public void confirmButton() throws InterruptedException {
		driveR.findElement(By.id(""+env+":id/actionButton")).isDisplayed();
		driveR.findElement(By.id(""+env+":id/actionButton")).click();
		Thread.sleep(5000);

	}
	
	public void enterHighQuantity(String qty) throws InterruptedException {

		Thread.sleep(1000);
		driveR.findElement(
				By.xpath("//android.widget.EditText[@resource-id='"+env+":id/quantityEditText']"))
		.sendKeys(qty);
		Thread.sleep(1000);

		driveR.hideKeyboard();

		driveR.findElement(
				By.xpath("//android.widget.FrameLayout[@resource-id='"+env+":id/backup_input_frame_layout']")).click();

		Thread.sleep(1000);
		driveR.findElement(
				By.xpath("//android.widget.EditText[@resource-id='"+env+":id/quantityEditText']"))
		.sendKeys(qty);
		Thread.sleep(1000);
		//new TouchAction(driveR).press(PointOption.point(715, 1278)).release().perform();
		Thread.sleep(1000);
		driveR.hideKeyboard();

		Thread.sleep(3000);

		driveR.findElement(
				By.xpath("//android.widget.Button[@resource-id='"+env+":id/actionButton']")).click();
	}


	
	public void glhwarningmsg() throws InterruptedException {
		try {
	        Warningmsg = driveR.findElement(By.xpath("//android.widget.TextView[@index='0']")).getText();
			assertEquals(Warningmsg, "Scanned using incorrect function", "Scanned Product belongs to GLH");
			Thread.sleep(5000);
		} catch (Exception e){
			String W2Wmsg = driveR.findElement(By.xpath("//android.widget.TextView[@text= 'This product belongs to a different Gaps, Lows and High process. Due to Wall to Wall count activity, this functionality is locked.\n" +
					"\n" +
					"Please speak to a manager.']")).getText();
			System.out.println("Handled for Wall to wall functionality" + W2Wmsg);
		}
	}
	
	public void captureMIN() throws InterruptedException {
		Product_Name =driveR.findElement(By.id(""+env+":id/product_title")).getText();
		
		MIN=driveR.findElement(By.id(""+env+":id/value")).getText();
		System.out.println(MIN);
		System.out.println(Product_Name);
		Thread.sleep(5000);

	}
	
	
	public void capturMINatCounter() throws InterruptedException {
		MIN=driveR.findElement(By.id(""+env+":id/storewalk_list_item_min")).getText();
		Product_Name =driveR.findElement(By.id(""+env+":id/storewalk_list_item_description")).getText();
		System.out.println(MIN);
		System.out.println(Product_Name);
		Thread.sleep(5000);

	}

	public void clickProduct() throws InterruptedException {//com.morrisons.instore.uat:id/storewalk_list_item_min_container
			try {
				driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + Barcode + "']")).click();

			}
			catch(NoSuchElementException e){
		//driveR.findElement(By.xpath("//android.widget.TextView[contains(@text="+Product_Name+" or @text="+MIN+")]")).click();
		driveR.findElement(By.xpath("//android.widget.TextView[contains(@text, "+MIN+")]")).click();
			}
	}
	
	public void captureLocationCoordinates() throws InterruptedException {
	//Point point =	driveR.findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[@index='6']")).getLocation();
		
		//System.out.println(driveR.findElement(By.xpath("//android.widget.TextView[@text ="+MIN+"]")).getText());
		Point point = driveR.findElement(By.xpath("//android.widget.TextView[@text ="+MIN+"]")).getLocation();
		xcord = point.getX();
		System.out.println("Position of the webelement from left side is "+xcord +" pixels");
		ycord = point.getY();
		System.out.println("Position of the webelement from top side is "+ycord +" pixels");
		Thread.sleep(5000);

	}
	
	
	public void clickApprovalTab() throws InterruptedException {
		Thread.sleep(1000);
		driveR.findElement(By.xpath("//android.widget.TextView[@text='APPROVAL' or @text='Approval']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[@text='APPROVAL' or @text='Approval']")).click();

	}
	
	public void clickApproveButton() throws InterruptedException {
		
		driveR.findElement(By.id(""+env+":id/review_approve")).isDisplayed();
		driveR.findElement(By.id(""+env+":id/review_approve")).click();
		driveR.findElement(By.xpath("//android.widget.Button[@text = 'YES']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.Button[@text = 'YES']")).click();

	}
	
	public void verifyApproved() throws InterruptedException {
		//driveR.findElement(By.xpath("//android.widget.TextView[@text = 'APPROVED' or @text = ''Approved]")).isDisplayed();
		driveR.findElement(By.id(""+env+":id/review_approve")).isDisplayed();

	}
	
	
	
public void updateCountinReview(String Count, String Location) throws InterruptedException {
	locations= Location;
	driveR.findElement(By.xpath("//android.widget.TextView[@text ='"+ locations +"']")).isDisplayed();
	driveR.findElement(By.xpath("//android.widget.TextView[@text ='"+ locations +"']")).click();

	driveR.findElement(By.id(""+env+":id/item_details_quantity_input")).sendKeys(Count);
	Thread.sleep(1000);
	driveR.findElement(
			By.id(""+env+":id/item_details_confirm_quantity")).click();

}
	public void prepackWarning() {
		String msg = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/message']")).getText();
		
		assertEquals(msg, "This product is a pre-pack product and cannot be scanned at this location. Would you like to scan this product in the 'Other' Location?", "Product Scanned in Counter Location");
	}

	public void clickProceed() throws InterruptedException {
		try {
			driveR.findElement(By.xpath("//android.widget.Button[contains(@text, 'PROCEED')]")).isDisplayed();
			driveR.findElement(By.xpath("//android.widget.Button[contains(@text, 'PROCEED')]")).click();
			Thread.sleep(5000);
		} catch (Exception e) {
			driveR.findElement(By.xpath("//android.widget.Button[contains(@text, 'OK')]")).isDisplayed();
			driveR.findElement(By.xpath("//android.widget.Button[contains(@text, 'OK')]")).click();
		}
	}

	public void verifyOtherlocation() {
		driveR.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Other')]")).isDisplayed();	
	}

	public void verifyCount() throws InterruptedException {
		clickProduct();
		Thread.sleep(5000);
try {
		if(driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/storewalk_list_item_quantity']")).isDisplayed())
		{
			
	    	System.out.println("Element is present and displayed"); }
	    else
	        System.out.println("Element is present but not displayed"); 
	}catch (NoSuchElementException e) {
	    System.out.println("Element is not present, hence not displayed as well");
	}


	}

	public void verifyCompletedBackup() throws InterruptedException {
		driveR.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Completed')]")).isDisplayed();	
		Thread.sleep(5000);

	}

	public void icSalesOrder() throws InterruptedException {
		driveR.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Sales Orders')]")).isDisplayed();	
		Thread.sleep(5000);

	}
	 public void icCounterFixture() {
		 driveR.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Counter & Fixture')]")).isDisplayed();
	 }

	public void icOther() {
		driveR.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Other')]")).isDisplayed();

	}

	public void icBackup() {
		driveR.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Backup')]")).isDisplayed();
		
	}

	public void icReview() {
		driveR.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Review')]")).isDisplayed();
		
	}

	public void enterOtherlocationcount(String count) throws InterruptedException {
		driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + Barcode + "']")).click();
		System.out.println("clicked barcode");
		Thread.sleep(1000);
		driveR.findElement(By.id(""+env+":id/item_details_quantity_input")).sendKeys(count);

		Thread.sleep(1000);
		driveR.findElement(
				By.id(""+env+":id/item_details_confirm_quantity")).click();
		
	}
	public void enterBackuplocationcount(String count) throws InterruptedException {
		driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + Barcode + "']")).click();
		System.out.println("clicked barcode");
		Thread.sleep(1000);
		
		try{
			if(driveR.findElement(By.xpath("//android.widget.Button[contains(@text, 'ADD TO COUNT')]")).isDisplayed())
			driveR.findElement(By.xpath("//android.widget.Button[contains(@text, 'ADD TO COUNT')]")).click();
		}
		catch(NoSuchElementException e){
			System.out.println("no such element present");
		}
		driveR.findElement(By.id(""+env+":id/item_details_quantity_input")).sendKeys(count);
		Thread.sleep(1000);
		driveR.findElement(By.id(""+env+":id/item_details_confirm_quantity")).click();
		
	}

	public void enterBackuplocationcountforlow(String count) throws InterruptedException {
		driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + Barcode + "']")).click();
		System.out.println("clicked barcode");
		Thread.sleep(1000);
		driveR.findElement(By.id(""+env+":id/item_details_quantity_input")).sendKeys(count);
		Thread.sleep(1000);
		driveR.findElement(
				By.id(""+env+":id/item_details_confirm_quantity")).click();
				
	}

		
	public void clickStockInformation() throws InterruptedException {
		Thread.sleep(3000);
		driveR.findElement(By.id("" + env + ":id/context_menu")).isDisplayed();
		driveR.findElement(By.id("" + env + ":id/context_menu")).click();
		Thread.sleep(1000);
		 driveR.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Stock Information')]")).isDisplayed();
		 driveR.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Stock Information')]")).click();
			Thread.sleep(5000);

	}
	
	public void verifyCapturetypeinStockInfo(String type) throws InterruptedException {
		String cType =		driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + type + "']")).getText();
		Thread.sleep(5000);
		assertEquals(cType, type, "Capture type mismatch!!");

	}
	
	public void verifylastcaptureCountedquantity(String counted) throws InterruptedException {
		//String cCounted =		driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + counted + "']")).getText();
    	String cCounted =driveR.findElement(By.id("" + env + ":id/qty_text_view")).getText();
		Thread.sleep(3000);
		assertEquals(cCounted, counted, "counted quantity mismatch!!");
		
	}
	
	public void verifyStockInfo3days() {
		driveR.findElement(By.id("" + env + ":id/capture_type_text_view")).isEnabled();
		driveR.findElement(By.id("" + env + ":id/date_text_view")).isEnabled();
		driveR.findElement(By.id("" + env + ":id/user_text_view")).isEnabled();
	}
	
	public void verfiydeleteSectionCompletemsg() throws InterruptedException {

			Thread.sleep(3000);

			TouchAction ts = new TouchAction(driveR);
			ts.press(PointOption.point(520, 412)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
			.moveTo(PointOption.point(32, 412)).release().perform();
			Thread.sleep(7000);

				try{
					Thread.sleep(1000);
			    if(driveR.findElement(By.xpath("//android.widget.ImageView[@resource-id='"+env+":id/delete_button']")).isDisplayed())
			    	{
			    	driveR.findElement(By.xpath("//android.widget.ImageView[@resource-id='"+env+":id/delete_button']")).click();
					Thread.sleep(1000);

			    	String msg =driveR.findElement(By.id("" + env + ":id/message")).getText();
					assertEquals(msg,"This product cannot not be deleted as it's Backup section is completed.", "Product Deleted!!");
			    	System.out.println("Element is present and displayed");
			    	}
			    else
			        System.out.println("Element is present but not displayed"); 
			}catch (NoSuchElementException e) {
			    System.out.println("Element is not present, hence not displayed as well");
			}		Thread.sleep(5000);

	}
		

	
	public void captureCountTypeinCounter(String aType) throws InterruptedException {
		String countType =		driveR.findElement(By.id("" + env + ":id/itemUOM")).getText();
		assertEquals( aType, countType,  "Counttype mismatch!!");
		Thread.sleep(5000);

	}
	public void capturestockUOMinStockinfo(String aUOM) throws InterruptedException {
		//com.morrisons.instore.uat:id/value
		String stockUOM =		driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + aUOM + "']")).getText();
		Thread.sleep(5000);

		assertEquals(stockUOM,aUOM, "Stock UOM  mismatch!!");
	}

	public void verifynoOrangelabelvisible() {		
		try{
		    if(driveR.findElement(By.id("android:id/message")).isDisplayed())
		        System.out.println("Element is present and displayed");
		    else
		        System.out.println("Element is present but not displayed"); 
		}catch (NoSuchElementException e) {
		    System.out.println("Element is not present, hence not displayed as well");
		}
	}


	public void deadlinemsgfirst() throws InterruptedException {
		String msg =driveR.findElement(By.id("android:id/message")).getText();
		assertEquals(msg,"Any Gaps, Lows, Highs completed after 09:45 am will not affect today's order calculation.", "Message MisMatch!!");
		Thread.sleep(5000);

	}

	public void deadlinemsgsecond() throws InterruptedException {
		String msg =driveR.findElement(By.id("android:id/message")).getText();
		assertEquals(msg,"Gaps, Lows, Highs cannot be completed after 11:59 am.", "Message MisMatch!!");
		Thread.sleep(5000);

	}

	public void deadlineendmsgsecond() throws InterruptedException {
		String msg =driveR.findElement(By.id("" + env + ":id/generic_blocking_error_title")).getText();
		assertEquals(msg,"Market Street Submissions Closed", "Message MisMatch!!");	
		String msg1 =driveR.findElement(By.id("" + env + ":id/generic_blocking_error_message")).getText();
		assertEquals(msg1,"You are unable to submit items to Market Street for the remainder of the day. Submissions must be completed prior to the 11:59 am daily cut off.", "Message MisMatch!!");	
		Thread.sleep(5000);

	}
	
	public void verifynotAllowedtoclick() {
	//	driveR.findElement(By.xpath("//android.widget.TextView[contains(@text, 'GAP')]")).click();
		try{
		    if(driveR.findElement(By.xpath("//android.widget.TextView[contains(@text, 'GAP')]")).isDisplayed()) {
		    	driveR.findElement(By.xpath("//android.widget.TextView[contains(@text, 'GAP')]")).click();
		    	System.out.println("Element is present and displayed"); }
		    else
		        System.out.println("Element is present but not displayed"); 
		}catch (NoSuchElementException e) {
		    System.out.println("Element is not present, hence not displayed as well");
		}

	}

	public void lowhigheditable() throws Throwable {
		 driveR.findElement(By.xpath("//android.widget.TextView[contains(@text, 'LOW')]")).isDisplayed();
		 driveR.findElement(By.xpath("//android.widget.TextView[contains(@text, 'LOW')]")).click();
//		 new TouchAction(driveR).press(PointOption.point(715, 1278)).release().perform();
//		 Thread.sleep(3000);
//		 driveR.findElement(By.xpath("//android.widget.Button[@resource-id='"+env+":id/actionButton']")).click();
//		 driveR.findElement(By.xpath("//android.widget.Button[contains(@text, 'EXIT COUNTER & FIXTURE')]")).click();

	}

	public void verifydepartmentdeleteinother(String Department) throws InterruptedException {
		clickOther();
		String msg = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/warehouse_group_info']")).getText(); 
		assertEquals(msg, "There are currently no items to count in the other.", "Data not deleted !");
		clickBackButton();
		Thread.sleep(5000);

	}

	public void verifydepartmentdeleteinBackup(String Department2) throws InterruptedException {
		clickBackup();
		String msg = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/warehouse_group_info']")).getText(); 
		assertEquals(msg, "There are currently no items to count in the backup.", "Data not deleted !");
		clickBackButton();
		Thread.sleep(5000);

	}

	public void verifydepartmentdeleteinReview(String Department3) throws InterruptedException {
		clickReview();
		try {
			if(driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/text_info']")).isDisplayed()) {
		String msg = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/text_info']")).getText(); 
		assertEquals(msg, "There are currently no items to review.", "Data not deleted !");
			}
			else
		{clickBackButton();}
			}
			catch(NoSuchElementException e) {
				clickBackButton();
			}
		Thread.sleep(5000);
		}
	

	public void verifyBackupDelete() throws InterruptedException {
		String msg = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/warehouse_group_info']")).getText(); 
		assertEquals(msg, "There are currently no items to count in the warehouse.", "Data not deleted !");
		Thread.sleep(5000);
		clickBackButton();
	}
	
	public void verifySorting()
	{
	ArrayList<String> obtainedList = new ArrayList<>(); 
	List<WebElement> elementList= driveR.findElements(By.xpath("//android.support.v7.widget.RecyclerView[@resource-id='"+env+":id/groups_section_list']"));
	
	for(WebElement we:elementList){
	   obtainedList.add(we.getText());
	}
	ArrayList<String> sortedList = new ArrayList<>();   
	for(String s:obtainedList){
	sortedList.add(s);
	}
	Collections.sort(sortedList);
	Assert.assertTrue(sortedList.equals(obtainedList));
	}
	
	public void verifyprodcutdetailinReview() {
		 driveR.findElement(By.xpath("//android.widget.TextView[contains(@text, 'MIN:')]")).isDisplayed();
		 driveR.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Adjustment Value :')]")).isDisplayed();
		 driveR.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Stock Record')]")).isDisplayed();
		 driveR.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Counted')]")).isDisplayed();
		 driveR.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Adjustment')]")).isDisplayed();
		 		
	}
	public void verifyConfirmallzero() throws InterruptedException {
		Thread.sleep(3000);

		 driveR.findElement(By.xpath("//android.widget.Button[contains(@text, 'CONFIRM ALL AS ZERO')]")).isDisplayed();
	}
	public void clickConfirmallzero() throws InterruptedException {
		Thread.sleep(3000);

		 driveR.findElement(By.xpath("//android.widget.Button[contains(@text, 'CONFIRM ALL AS ZERO')]")).click();
			Thread.sleep(3000);
		driveR.findElement(By.xpath("//android.widget.Button[contains(@text, 'CONFIRM')]")).click();
	}
	
	public void verifyZeroforproduct() throws InterruptedException {
		Thread.sleep(3000);

		driveR.findElement(By.xpath("//android.widget.TextView[contains(@text, '0')]")).isDisplayed();
	}
	public void exitBackup() throws InterruptedException {
		driveR.findElement(By.xpath("//android.widget.Button[contains(@text, 'EXIT OTHER')]")).click();
		Thread.sleep(5000);

	}
	
	public void isconfirmallzeroPresent() throws InterruptedException {
	try{
		Thread.sleep(5000);

	    if(driveR.findElement(By.xpath("//android.widget.Button[contains(@text, 'CONFIRM ALL AS ZERO')]")).isDisplayed())
	        System.out.println("Element is present and displayed");
	    else
	        System.out.println("Element is present but not displayed"); 
	}catch (NoSuchElementException e) {
	    System.out.println("Element is not present, hence not displayed as well");
	}
	Thread.sleep(1000);

	}
	
	public void verifyDepartment(String type) throws InterruptedException {

		types = type;

		String names = driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + types + "']")).getText();
		System.out.println("List of names = " + names);
		driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + types + "']")).click();
		Thread.sleep(5000);

	}
	
	public void verifySection(String type) throws InterruptedException
	{
		driveR.findElement(By
				.xpath("//android.widget.TextView[@resource-id='"+env+":id/groups_section_header_title']")).isDisplayed();
		Thread.sleep(5000);

	}

	public void verifyDepartmentheaderStatus(String status) {
		String header = driveR.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'header_status') or text()='Completed']")).getText();
	  assertEquals(header, status, "Header Status mismatch!!");
	}
	
	public void verifySectionheaderStatus(String status) {
	try{
		String header =	driveR.findElement(By.id("" + env + ":id/groups_section_status")).getText();
		if(header == "COMPLETED")
		{
			System.out.println("Status is Completed");
		}
		else
			System.out.println("Status with TIMESTAMP ");
	}
	catch(NoSuchElementException e){
		System.out.println("Status with TIMESTAMP ");
	}
	}
	
	public void verifyDeletenotAllowed() throws InterruptedException {
				try{
					//Thread.sleep(3000);
			    if(driveR.findElement(By.xpath("//android.widget.ImageView[@resource-id='"+env+":id/delete_button']")).isDisplayed())	
			    	System.out.println("Element is present and displayed");
			    else
			        System.out.println("Element is present but not displayed"); 
			}catch (NoSuchElementException e) {
			    System.out.println("Element is not present, hence not displayed as well");
			    Thread.sleep(1000);
			}

	}
	

	
	public void verifyScanningnotallowed() throws InterruptedException {
		try{
		    Thread.sleep(3000);

		    if(driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/action_barcode_entry']")).isDisplayed())
		        System.out.println("Element is present and displayed");
		    else
		        System.out.println("Element is present but not displayed"); 
		}catch (NoSuchElementException e) {
		    System.out.println("Element is not present, hence not displayed as well");
		    Thread.sleep(1000);
		}
	}
	public void verifyApprovebuttondisble() {
		try{
		    if(driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/inner_button']")).isEnabled())
		        System.out.println("Element is present and displayed");
		    else
		        System.out.println("Element is present but not displayed"); 
		}catch (NoSuchElementException e) {
		    System.out.println("Element is not present, hence not displayed as well");
		}
	}
	
	public void verifyAdjustmentvalue() {
		try{
		String value=driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/value']")).getText();
		xadjustmentValue = Integer.parseInt(value);

		    if(xadjustmentValue>200)
		        System.out.println("AdjustmentValue is present and displayed");
		    else
		        System.out.println("AdjustmentValue is present but not displayed"); 
		}catch (NoSuchElementException e) {
		    System.out.println("AdjustmentValue is not present, hence not displayed as well");
		}
	}
		public void verifyStockOnHand() throws InterruptedException {
		try{
			Thread.sleep(3000);
		    if(driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/stock_on_hand']")).isDisplayed())
		    	System.out.println(driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/stock_on_hand']")).getText());
		    	//System.out.println("Element is present and displayed");
		    else
		        System.out.println("Element is present but not displayed"); 
		}catch (NoSuchElementException e) {
		    System.out.println("Element is not present, hence not displayed as well");
		}
	}

		public void verifyCountinReview() {
			try{
			    if(driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/counted']")).isDisplayed())
			    { 
			    	CountinReview = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/counted']")).getText();
			    	System.out.print(CountinReview);
			    }
			    else
			        System.out.println("Element is present but not displayed"); 
			}catch (NoSuchElementException e) {
			    System.out.println("Element is not present, hence not displayed as well");
			}
		}
		public void verifyCountinApprovalTab() {
			try{
			    if(driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/counted']")).isDisplayed())
			    { 
			    	CountinApprove = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/counted']")).getText();
			    	assertEquals(CountinReview,CountinApprove, "Count MisMatch");
			    }
			    else
			        System.out.println("Element is present but not displayed"); 
			}catch (NoSuchElementException e) {
			    System.out.println("Element is not present, hence not displayed as well");
			}
		}
		public void verfypositionremainsame() {
			try{
			    if(driveR.findElement(By.xpath("//android.widget.TextView[contains(@text, "+MIN+")]")).isDisplayed())
			    	System.out.println("Element is present and displayed");
			    else
			        System.out.println("Element is present but not displayed"); 
			}catch (NoSuchElementException e) {
			    System.out.println("Element is not present, hence not displayed as well");
			}
		}
		public void verifyApproveinApproveTab() {
		    try{
			    if(driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/review_approve']")).isDisplayed())
			    	System.out.println("Element is enabled and displayed");
			    else
			        System.out.println("Element is enabled but not displayed"); 
			}catch (NoSuchElementException e) {
			    System.out.println("Element is not enabled, hence not displayed as well");
			}
		   // driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/top']")).click();

		}
		public void textUnderhigh(String arg1) {
			
			driveR.findElement(By.xpath("//android.widget.TextView[contains(@text, 'HIGHS')]")).click();
			ahigh = driveR
					.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/text_highs']"))
					.getText();

			System.out.println("high Count:---" + ahigh);

			System.out.println("capture type--" + ahigh);
			String eXpected = arg1;
			System.out.println("Actuall high --" + arg1);

			assertEquals(ahigh, eXpected);			
		}
		
		public void totalSummary(String total) throws InterruptedException {
			driveR.findElement(By.xpath("//android.widget.TextView[contains(@text, 'HIGHS')]")).click();
			Thread.sleep(2000);
	String atotal=		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/footer_third_value']")).getText();


	System.out.println("Total high --" + total);

	assertEquals(total, atotal);	
		}
		
		public void verifyCountVarience() {
			if(driveR.findElement(By.id(""+env+":id/count_variance")).isDisplayed())
			{
		String CountVarience =driveR.findElement(By.id(""+env+":id/count_variance")).getText();
		System.out.println("Count Variance to Stock Record:" + CountVarience);
		}
			else
				System.out.println("Element Not Found !! ");
}
		public void verifyCount1() throws InterruptedException {
			try {
				Thread.sleep(1000);

			if(driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/storewalk_list_item_quantity']")).isDisplayed())
			{
				System.out.println("Element is Displayed");
			}else
				System.out.println("Element not Displayed");
			}
			catch(NoSuchElementException e) {
				System.out.println("Element not displayed");
			}
			Thread.sleep(1000);

			
		}
		
}
	
	
	
	
	
	
	
