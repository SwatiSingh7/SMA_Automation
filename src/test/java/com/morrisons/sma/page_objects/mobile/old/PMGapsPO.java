package com.morrisons.sma.page_objects.mobile.old;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import com.morrisons.sma.step_definitions.mobile.old.MarkdownStepDef;
import com.morrisons.common.action.Hook;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;

import java.util.List;

public class PMGapsPO {

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
	
	String pmGaps = "PM Gaps";
	String outOfStock = "Please place an orange out of stock label until the product is back in stock";

	public PMGapsPO() {
		this.driveR = (AndroidDriver) Hook.getDriver();
	}

	public void clickpmGaps() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.TextView[@text='" + pmGaps + "']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[@text='" + pmGaps + "']")).click();

	}

	public void orangeOutOFStock() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.TextView[@text='" + outOfStock + "']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[@text='" + pmGaps + "']")).click();

		try

		{

			Boolean sectionInProgress = driveR.findElement(By.xpath(
					"//android.widget.TextView[@text='This section is in progress. Are you sure you want to continue?']"))
					.isDisplayed();

			if (sectionInProgress = true) {
				driveR.findElement(By.xpath("//android.widget.Button[@text='Yes' @text='YES']")).click();
			} else {
				System.out.println("do nothing");
			}

		} catch (Exception e) {

			System.out.println("do nothing");

		}

	}

	public void clickViewList() throws Throwable {

		try{
		Boolean orangrOutOfStock = driveR.findElement(By.xpath(
				"//android.widget.TextView[@text='Please place an orange out of stock label until the product is back in stock']"))
				.isDisplayed();
		

		if (orangrOutOfStock = true) {
			driveR.findElement(By.xpath("//android.widget.Button[@text='OK' or @text='Ok']")).click();

		}
		}
		catch(Exception e){}

		driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/singleItemHeader']"))
				.isDisplayed();
		driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/singleItemHeader']"))
				.click();
	}

	public void captureTypeGap() throws Throwable {
		Thread.sleep(5000);
		Boolean captureTypeGapp = driveR.findElement(By.xpath("//android.widget.TextView[@text='Gap' or @text='GAP']")).isDisplayed();

		System.out.println("capture type" + captureTypeGapp);
		Boolean eXpected = true;
		System.out.println("expectedddd" + eXpected);

		assertEquals(captureTypeGapp, eXpected);
	}

	public void clickonProduct(String Barcode) throws Throwable {

		driveR.findElement(By.xpath("//android.widget.TextView[@text='" + Barcode + "']")).click();

	}

	public void hotKey() throws Throwable {

		Boolean hotKey = driveR.findElement(By.id(env+":id/context_menu")).isDisplayed();

		Boolean eXpected = true;

		assertEquals(hotKey, eXpected);

		driveR.findElement(By.id(env+":id/context_menu")).click();
		Thread.sleep(5000);
		// com.morrisons.instore.uat:id/context_menu
		// driveR.findElement(By.id("com.morrisons.instore.uat:id/title")).click();
		Thread.sleep(2000);
	}

	public void stockInfoMenu() throws Throwable {

		Boolean stockInfo = driveR.findElement(By.xpath("//android.widget.TextView[@text='Stock Information' or @text='STOCK INFORMATION']"))
				.isDisplayed();

		Boolean eXpected = true;

		assertEquals(stockInfo, eXpected);

		driveR.findElement(By.xpath("//android.widget.TextView[@text='Stock Information' or @text='STOCK INFORMATION']")).click();
		Thread.sleep(5000);

	}



	public void confirmStockFoundpopup() throws Throwable {

		// driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env
		// + ":id/capture_type_text_view']"));

		String confirmStockFoundpopup = driveR
				.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/alertTitle']")).getText();

		String eXpected = "Confirm Stock Found";

		assertEquals(confirmStockFoundpopup, eXpected);

	}

	public void clickConfirm() throws Throwable {

//		Boolean confirmLink = driveR.findElement(By.xpath("//android.widget.Button[@text='Confirm']"))
//				.isDisplayed();
//		
//		Boolean eXpected = true;
//		
//		assertEquals(confirmLink, eXpected);

		driveR.findElement(By.xpath("//android.widget.Button[@text='Confirm' or @text='CONFIRM']")).click();
		Thread.sleep(5000);

	}

	public void captureTypeStockFound() throws Throwable {

		Boolean StockFound = driveR.findElement(By.xpath("//android.widget.TextView[@text='Stock found' or @text='STOCK FOUND']"))
				.isDisplayed();

		System.out.println("capture type" + StockFound);
		Boolean eXpected = true;
		System.out.println("expectedddd" + eXpected);

		assertEquals(StockFound, eXpected);
	}

	public void clickconfirmCountPopup() throws Throwable {

		Boolean confirmCountPopup = driveR.findElement(By.xpath("//android.widget.Button[@text='Confirm' or @text='CONFIRM']"))
				.isDisplayed();

		System.out.println("capture type" + confirmCountPopup);
		Boolean eXpected = true;
		System.out.println("expectedddd" + eXpected);

		assertEquals(confirmCountPopup, eXpected);

		driveR.findElement(By.xpath("//android.widget.Button[@text='Confirm' or @text='CONFIRM']")).click();
	}

	public void clickconfirmCountAreaButton() throws Throwable {

		Boolean clickconfirmCountAreaButton = driveR
				.findElement(By.xpath("//android.widget.Button[@text='CONFIRM COUNT AREA']")).isDisplayed();

		System.out.println("capture type" + clickconfirmCountAreaButton);
		Boolean eXpected = true;
		System.out.println("expectedddd" + eXpected);

		assertEquals(clickconfirmCountAreaButton, eXpected);

		driveR.findElement(By.xpath("//android.widget.Button[@text='CONFIRM COUNT AREA']")).click();
	}

	public void sectionCompleteMessageBox() throws Throwable {
		Thread.sleep(4000);
		Boolean SectionComplete = driveR.findElement(By.xpath("//android.widget.TextView[@text='Section Complete']")).isDisplayed();

//		System.out.println("capture type" + SectionComplete);
//		Boolean eXpected = true;
//		System.out.println("expected " + eXpected);
//
//		assertEquals(SectionComplete, eXpected);

		Thread.sleep(3000);

		driveR.findElement(By.xpath("//android.widget.Button[@text='OK' or @text='Ok']")).click();
		Thread.sleep(3000);
	}
	
	public void sectionCompletedStatus() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/groups_section_status']")).isDisplayed();
		Thread.sleep(3000);
	
	}

	public void okclick() throws Throwable {

		Boolean okclick = driveR.findElement(By.xpath("//android.widget.Button[@text='OK' or @text='Ok']")).isDisplayed();

		System.out.println("capture type" + okclick);
		Boolean eXpected = true;
		System.out.println("expected " + eXpected);

		assertEquals(okclick, eXpected);

		driveR.findElement(By.xpath("//android.widget.Button[@text='OK' or @text='CONFIRM']")).click();

	}

	public void verifySummaryDepartment(String dep) throws Throwable {

		String department = driveR.findElement(By.xpath("//android.widget.TextView[@text='" + dep + "']")).getText();

		System.out.println("department name:---" + department);

		System.out.println("capture type" + department);
		String eXpected = dep;
		System.out.println("expected " + dep);

		assertEquals(department, eXpected);

	}

	public void clickOnCategory(String categoryName) throws Throwable {
		driveR.findElement(By.xpath("//android.widget.TextView[@text='"+categoryName+"']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[@text='"+categoryName+"']/following::android.widget.TextView[@resource-id='" + env + ":id/text_incomplete']")).click();

	}

	public void textUnderIC(String categoryName,String incomplete) throws Throwable {
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
		String eXpected = incomplete;
		System.out.println("Actuall IC --" + incomplete);
		assertTrue(Integer.valueOf(ic)>0);
//		assertEquals(ic, eXpected);

	}
	//----------------------------------------------------
	public void textUnderCOUNT(String categoryName,String incomplete) throws Throwable {
		String ic = null;
		List<WebElement> oDept = driveR.findElements(By.xpath("//android.widget.LinearLayout"));
		for(int i=0;i<oDept.size();i++){
			try {
				if (oDept.get(i).findElements(By.xpath("//android.widget.TextView")).get(0).getText().equalsIgnoreCase(categoryName)) {
					ic = oDept.get(i).findElements(By.xpath("//android.widget.TextView")).get(1).getText();
					break;
				}
			}
			catch(Exception e){}
		}
		//String ic =driveR.findElement(By.xpath("//parent::android.widget.TextView[@text='"+categoryName+"']/following-sibling::android.widget.TextView[@resource-id='" + env + ":id/text_incomplete']")).getText();
		//String ic =driveR.findElement(By.xpath("//android.widget.TextView[@text='"+categoryName+"']|/android.widget.TextView[@index='2']")).getText();


		System.out.println("IC Count:---" + ic);

		System.out.println("capture type--" + ic);
		String eXpected = incomplete;
		System.out.println("Actuall IC --" + incomplete);

		assertEquals(ic, eXpected);

	}
	//------------------------------------------------------
	
	public void clickOnCountInSummary() throws InterruptedException{
		WebElement lowTab = driveR
				.findElement(By.xpath("//android.widget.TextView[@text='COUNT' or @text='Count']"));
		
		lowTab.click();
		
		Thread.sleep(3000);
				
	}
	
	public void textUnderLow(String incomplete) throws Throwable {

		String low = driveR
				.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/footer_second_value']"))
				.getText();

		System.out.println("low Count:---" + low);

		System.out.println("capture type--" + low);
		String eXpected = incomplete;
		System.out.println("Actuall low --" + incomplete);

		assertEquals(low, eXpected);

	}
	
	public void textUndergap(String incomplete) throws Throwable {

		String low = driveR
				.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/text_gaps']"))
				.getText();

		System.out.println("Gaps Count:---" + low);

		System.out.println("Gaps type--" + low);
		String eXpected = incomplete;
		System.out.println("Actuall Gaps --" + incomplete);

		assertEquals(low, eXpected);

	}
	

	
	public void textstockFound(String category,String stockfound) throws Throwable {

		String StockFound = driveR
				.findElement(By.xpath("//android.widget.TextView[@text='"+category+"']/following::android.widget.TextView[@resource-id='" + env + ":id/text_stock']"))
				.getText();

		System.out.println("low Count:---" + StockFound);

		System.out.println("capture type--" + stockfound);
		String eXpected = stockfound;
		System.out.println("Actuall low --" + StockFound);

		assertEquals(StockFound, eXpected);

	}
	
	
	public void selectCategoryPM() throws Throwable {

		//driveR.findElement(By.xpath("//android.widget.TextView[@text='" + arg1 + "']")).click();

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

			Boolean sectionInProgress = driveR
					.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/groups_section_header_title']")).isDisplayed();

			if (sectionInProgress = true) {
				driveR
				.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/groups_section_header_title']")).click();
			} else {
				System.out.println("do nothing");
			}

		} catch (Exception e) {

			System.out.println("do nothing");

		}

	}
	
	public void planSelection(String planname) throws Throwable {
		
		System.out.println(planname);

		try

		{

			Boolean plannamee = driveR.findElement(By.xpath("//android.widget.CheckedTextView[@text='"+planname+"']"))
					.isDisplayed();

			if (plannamee = true) {
				driveR.findElement(By.xpath("//android.widget.CheckedTextView[@text='"+planname+"']")).click();
			} else {
				System.out.println("do nothing");
			}

		} catch (Exception e) {

			driveR.findElement(By.xpath("//android.widget.CheckedTextView[@text='"+planname+"']")).click();

		}
		
//		driveR.findElement(By.xpath("//android.widget.Button[@text='OK']")).click();
		
		System.out.println("1st try catch executed.......");
		
		

		try

		{

			Boolean okPopup = driveR.findElement(By.xpath("//android.widget.Button[@text='OK' or @text='Ok']"))
					.isDisplayed();

			if (okPopup = true) {
				driveR.findElement(By.xpath("//android.widget.Button[@text='OK' or @text='Ok']")).click();
			} else {
				System.out.println("do nothing");
			}

		} catch (Exception e) {

			driveR.findElement(By.xpath("//android.widget.Button[@text='OK' or @text='Ok']")).click();

		}
		
		
		Boolean orangrOutOfStock = driveR.findElement(By.xpath(
				"//android.widget.TextView[@text='Please place an orange out of stock label until the product is back in stock']"))
				.isDisplayed();

		if (orangrOutOfStock = true) {
			driveR.findElement(By.xpath("//android.widget.Button[@text='OK' or @text='Ok']")).click();

		}
		
		
		
		

	}
	
	public void verifyProductInList(String product) throws Throwable {

		String productMin = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+product+"']"))
				.getText();

		System.out.println("low Count:---" + product);

		System.out.println("capture type--" + product);
		String eXpected = product;
		System.out.println("Actuall low --" + eXpected);

		assertEquals(productMin, eXpected);

	}

}
