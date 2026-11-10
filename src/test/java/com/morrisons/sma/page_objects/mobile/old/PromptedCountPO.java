package com.morrisons.sma.page_objects.mobile.old;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.time.Duration;
import java.util.ArrayList;

import java.util.List;

import com.morrisons.common.helper.MobileHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.morrisons.common.action.Hook;
import io.appium.java_client.android.AndroidDriver;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;


public class PromptedCountPO {

	private static AndroidDriver driveR;

	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
	String env = applicationConfig.getWebElementEnviroment().getEnv();

	private static String productMinOnFixture = null;
	private static List<String> productMinOnMerchandising = new ArrayList<String>();
	private static List<String> productMinOnPrintAndPlaceLabel = new ArrayList<String>();


	public PromptedCountPO() {
		this.driveR = (AndroidDriver) Hook.getDriver();
	}


	public void clickOnActionCheckbox(String action) throws Throwable {
		ElementRetry.hardSleep(1500);
		ElementRetry.clickElement(driveR, driveR.findElement(By.xpath("//android.widget.CheckBox[@text= '" + action + "']")));
	}


	public void verifyActionDisplay(String action) {
		boolean isActionDisplay = driveR.findElement(By.xpath("//android.widget.CheckBox[@text= '" + action + "']")).isDisplayed();
		assertEquals(isActionDisplay, true, "Action is not display");

	}
	public void clickBackButton() throws InterruptedException {
		ElementRetry.hardSleep(2500);
		ElementRetry.clickElement(driveR, driveR.findElement(By.className("android.widget.ImageButton")));
	}

	public void verifyOnePromptedItemDisplay() throws Throwable {

		ElementRetry.checkElementExist(driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/header_text']")));
		String headerText = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/header_text']")).getText();
		System.out.println("Header : "+headerText);
		int CountUI = Integer.parseInt(headerText.split("of")[0].replaceAll("[^0-9]", ""));
		System.out.println("Product count : " + CountUI);
		assertEquals(CountUI, 1,"Only one item is not displayed at a time");
	}

	public void verifyEditButton() throws Throwable {
		ElementRetry.checkElementExist(driveR.findElement(By.xpath("//android.widget.Button[@resource-id='" + env + ":id/editBtn']")));
	}
	public void clickOnEditButton() throws Throwable {
		ElementRetry.hardSleep(1000);
		ElementRetry.clickElement(driveR, driveR.findElement(By.xpath("//android.widget.Button[@text='EDIT']")));
	}

	public void enterQtyAndConfirm(String quantity) throws Throwable {
		ElementRetry.hardSleep(1500);
		ElementRetry.enterText(driveR.findElement(By.xpath("//android.widget.EditText[contains(@resource-id,'id/quantityEditText')]")),quantity);
		ElementRetry.clickElement(driveR,driveR.findElement(By.xpath("//android.widget.Button[@text='CONFIRM']")));
	}


	public void editedQtyVerification(String editQty) throws Throwable {
		boolean result = ElementRetry.checkElementExist(driveR.findElement(By.xpath("//android.widget.TextView[@text='" + editQty + "']")));
		if(result){
			System.out.println("Edit quantity " +editQty+" verified on Screen.");
		}else
			System.out.println("Failed to verify edited quantity " +editQty+" on Screen History screen.");
		//String actText = driveR.findElement(By.xpath("//android.widget.TextView[@text='" + editQty + "']")).getText();
		//System.out.println("Actual Quantity is: "+actText);
		//assertEquals(editQty, actText,"Verification quantity mismatched");

	}

	public void productNotFound() throws Throwable {
		try{
			driveR.findElement(By.xpath("//android.widget.ImageView[@resource-id='" + env + ":id/imageView_error_image']")).isDisplayed();
			WebElement xpathProductNotFound = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/generic_blocking_error_title']"));
			System.out.println("UI screen message is:" + xpathProductNotFound);
			xpathProductNotFound.isDisplayed();
			String productNotFoundUI = xpathProductNotFound.getText();
			assertEquals(productNotFoundUI, "Product Not Found","Product Not Found text is mismatched");

			ElementRetry.checkElementExist(driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/generic_blocking_error_message']")));
			ElementRetry.clickElement(driveR,driveR.findElement(By.xpath("//android.widget.Button[@resource-id='" + env + ":id/inner_button']")) );
			ElementRetry.clickElement(driveR,driveR.findElement(By.xpath("//android.widget.CheckBox[@text= 'Print and Place Shelf Edge Label']")));
			ElementRetry.enterText(driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/quantityEditText']")),"8" );
			ElementRetry.clickElement(driveR,driveR.findElement(By.xpath("//android.widget.Button[@resource-id='" + env + ":id/confirmButton']")));
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	public int getTotalCountOfProduct(){
		String headerText = driveR.findElement(By.xpath("//android.widget.RelativeLayout/android.widget.TextView[contains(@text, 'Product ')]")).getText();
		System.out.println("Total Count is : "+headerText);
		String []x = headerText.split("\\)");
		int compltedActionProduct = Integer.parseInt(x[0].split("of")[0].replaceAll("[^0-9]", ""));
		System.out.println("Completed Counts on UI: "+compltedActionProduct);
		int totalProductUI = Integer.parseInt(x[0].split("of")[1].replaceAll("[^0-9]", ""));
		return totalProductUI;
	}

	public int getProductPendingCountFromPrompt(){
		String headerText = driveR.findElement(By.xpath("//android.widget.RelativeLayout/android.widget.TextView[contains(@text, 'Product ')]")).getText();
		System.out.println("Total Count is : "+headerText);
		String []x = headerText.split("\\)");
		int compltedActionProduct = Integer.parseInt(x[0].split("of")[0].replaceAll("[^0-9]", ""));
		System.out.println("Completed Counts on UI: "+compltedActionProduct);
		//int totalProductUI = Integer.parseInt(x[0].split("of")[1].replaceAll("[^0-9]", ""));
		return compltedActionProduct;
	}
	////Complete location - Add quantity and click on confirm for all the Products.
	public void enterQtyAndConfirmAllProducts(String quantity) throws Throwable {
		int pendingActionProduct=0;
		int compltedActionProduct=0;
		int totalProductUI=0;
		try {
			//////Fetching text from UI. For eg. (Product (7 of 29))
			String headerText = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/header_text']")).getText();
			System.out.println("Products Counts on UI " + headerText);
			String[] x = headerText.split("\\)");
			System.out.println("Products Counts on UI " + x);
			compltedActionProduct = Integer.parseInt(x[0].split("of")[0].replaceAll("[^0-9]", ""));
			totalProductUI = Integer.parseInt(x[0].split("of")[1].replaceAll("[^0-9]", ""));

			System.out.println("Complted action product " + compltedActionProduct);

			System.out.println("Total product on UI " + totalProductUI);
			ElementRetry.hardSleep(2000);

			 pendingActionProduct = totalProductUI - compltedActionProduct;


			for (int product = 0; product <= pendingActionProduct; product++) {

				driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/quantityEditText']")).isDisplayed();
				driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/quantityEditText']")).sendKeys(quantity);

				driveR.findElement(By.xpath("//android.widget.Button[@resource-id='" + env + ":id/confirmButton']")).isDisplayed();
				driveR.findElement(By.xpath("//android.widget.Button[@resource-id='" + env + ":id/confirmButton']")).click();
				if(product==pendingActionProduct){
					System.out.println("Inside the if condition:::::");
					pendingActionProduct = totalProductUI- getProductPendingCountFromPrompt();
					product=-1;
				}
			}
		} catch (Exception e) {
			System.out.println(e);

		}
	}

	public void verifyHistoryIcon() throws Throwable {
		ElementRetry.checkElementExist(driveR.findElement(By.xpath("//android.support.v7.widget.ar/android.widget.TextView[@content-desc='Show List']")));
	}

	public void clickOnHistoryIcon() throws Throwable {
		ElementRetry.hardSleep(1500);
		ElementRetry.checkElementExist(driveR.findElement(By.xpath("//android.support.v7.widget.ar/android.widget.TextView[@content-desc='Show List']")));
		ElementRetry.clickElement(driveR,driveR.findElement(By.xpath("//android.support.v7.widget.ar/android.widget.TextView[@content-desc='Show List']")));
	}


	public void unflagWithoutAction(String editQty) throws Throwable {
		ElementRetry.checkAndClickOnElementAfterScroll(driveR,"//android.widget.RelativeLayout/android.widget.ImageView[@index ='0']");
		//ElementRetry.checkElementExist(driveR.findElement(By.xpath("//android.widget.ImageView[@resource-id=':id/flagIcon']")));
		//ElementRetry.clickElement(driveR,driveR.findElement(By.xpath("//android.widget.RelativeLayout/android.widget.ImageView[@index ='0']")));
		ElementRetry.clickElement(driveR, driveR.findElement(By.xpath("//android.widget.Button[@text='EDIT']")));
		ElementRetry.enterText(driveR.findElement(By.id(""+env+":id/quantityEditText")),editQty);
		ElementRetry.clickElement(driveR,driveR.findElement(By.xpath("//android.widget.Button[@text='Confirm' or @text='CONFIRM']")));
		ElementRetry.clickElement(driveR,driveR.findElement(By.id("android:id/button1")));
	}
	public void unflagWithOneAction(String editQty) throws Throwable {
		//ElementRetry.checkElementExist(driveR.findElement(By.xpath("//android.widget.ImageView[@resource-id=':id/flagIcon']")));
		ElementRetry.clickElement(driveR,driveR.findElement(By.xpath("//android.widget.RelativeLayout/android.widget.ImageView[@index ='0']")));
		ElementRetry.clickElement(driveR, driveR.findElement(By.xpath("//android.widget.Button[@text='EDIT']")));
		ElementRetry.clickElement(driveR, driveR.findElement(By.xpath("//android.widget.CheckBox[@text= 'Check Merchandising Plan']")));
		ElementRetry.enterText(driveR.findElement(By.id(""+env+":id/quantityEditText")),editQty);
		ElementRetry.clickElement(driveR,driveR.findElement(By.xpath("//android.widget.Button[@text='Confirm' or @text='CONFIRM']")));
		ElementRetry.clickElement(driveR,driveR.findElement(By.id("android:id/button1")));
	}
	public void verifyActionOnUnFlaggedItem(String editQty) throws Throwable {
		ElementRetry.clickElement(driveR, driveR.findElement(By.xpath("//android.widget.TextView[@text='" + editQty + "']")));
		// Verify Issue label in flag edit screen
		ElementRetry.checkElementExist(driveR.findElement(By.xpath("//android.widget.TextView[@text='Issues']")));
		// Verify Action on flag edit screen
		ElementRetry.checkElementExist(driveR.findElement(By.xpath("//android.widget.TextView[@text='Check Merchandising Plan']")));
		clickBackButton();

	}
	public void verifyFlaggedItemStatusInOtherLocation(String fromLocation, String toLocation) throws Throwable {
		ElementRetry.hardSleep(2000);
		clickBackButton();
		ElementRetry.clickElement(driveR, driveR.findElement(By.xpath("//android.widget.TextView[@text='" + toLocation + "']")));
		clickOnHistoryIcon();
		ElementRetry.checkElementAfterScroll(driveR, "//android.widget.TextView[@text='Flagged at " + fromLocation + "']");
		String status =ElementRetry.getText(driveR, driveR.findElement(By.xpath("//android.widget.TextView[@text='Flagged at " + fromLocation + "']")));
		System.out.println("Flag Status is : "+status);
		clickBackButton();

	}
	public void verifyUnFlaggedItemStatusInOtherLocation(String toLocation) throws Throwable {
		ElementRetry.hardSleep(2000);
		clickBackButton();
		ElementRetry.clickElement(driveR, driveR.findElement(By.xpath("//android.widget.TextView[@text='" + toLocation + "']")));
		clickOnHistoryIcon();
		ElementRetry.checkElementAfterScroll(driveR, "//android.widget.TextView[@index='0' and @text='0']");
		String status =ElementRetry.getText(driveR, driveR.findElement(By.xpath("//android.widget.TextView[@index='0' and @text='0']")));
		System.out.println("Item unflog count is "+status  +" for location "+toLocation);
		ElementRetry.clickElement(driveR, driveR.findElement(By.xpath("//android.widget.TextView[@index='0' and @text='0']")));
		clickOnEditButton();
		enterQtyAndConfirm(qty);
		clickBackButton();

	}
	public void selectFlagItemFromHistory() throws Throwable {
		ElementRetry.clickElement(driveR, driveR.findElement(By.xpath("//android.widget.RelativeLayout/android.widget.ImageView[@index ='0']")));
	}
	public void flageditemedit() throws Throwable {
		//List<WebElement> itemlist = driveR.findElements(By.xpath("//android.support.v7.widget.RecyclerView[@resource-id='" + env + ":id/rvProduct']"));
		//
		//for(int i=1;i<=itemlist.size()-1;i++)
		//{
		//ElementRetry.checkElementExist(driveR.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.morrisons.instore.sit:id/flagIcon' and @index ='0']")));
		ElementRetry.clickElement(driveR, driveR.findElement(By.xpath("//android.widget.RelativeLayout/android.widget.ImageView[@index ='0']")));
		// driveR.findElement(By.xpath("//android.widget.RelativeLayout[@resource-id='" + env + ":id/summary_detail_item']")).click();
		//	ElementRetry.checkElementExist(driveR.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.morrisons.instore.sit:id/flagIcon' and @index ='0']")));
		//	ElementRetry.clickElement(driveR,driveR.findElement(By.xpath("//android.widget.ImageView[@resource-id=':id/flagIcon']")));
		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/editFlagIcon']")).isDisplayed();
		//	ElementRetry.checkElementExist(driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/editBtn']")));
		ElementRetry.clickElement(driveR, driveR.findElement(By.xpath("//android.widget.Button[@text='EDIT']")));
		ElementRetry.clickElement(driveR, driveR.findElement(By.xpath("//android.widget.CheckBox[@text= 'Check Merchandising Plan']")));
		doFlag();

	}
	public void reflagWithMarchandisingAction() throws Throwable {
		ElementRetry.checkElementAfterScroll(driveR, "//android.widget.RelativeLayout/android.widget.ImageView[@index ='0']" );
		ElementRetry.clickElement(driveR, driveR.findElement(By.xpath("//android.widget.RelativeLayout/android.widget.ImageView[@index ='0']")));
		ElementRetry.clickElement(driveR, driveR.findElement(By.xpath("//android.widget.Button[@text='EDIT']")));
		ElementRetry.clickElement(driveR, driveR.findElement(By.xpath("//android.widget.CheckBox[@text= 'Check Merchandising Plan']")));
		doFlag();

	}
	public void verifyActionOnFlaggedItem(String actions) throws Throwable {
		ElementRetry.checkAndClickOnElementAfterScroll(driveR,"//android.widget.RelativeLayout/android.widget.ImageView[@index ='0']");

		//ElementRetry.clickElement(driveR, driveR.findElement(By.xpath("//android.widget.RelativeLayout/android.widget.ImageView[@index ='0']")));
		// Verify Issue label in flag edit screen
		ElementRetry.checkElementExist(driveR.findElement(By.xpath("//android.widget.TextView[@text='Issues']")));
		// Verify Action on flag edit screen
		ElementRetry.checkElementExist(driveR.findElement(By.xpath("//android.widget.TextView[@text='Check Merchandising Plan']")));
		if(actions.equals("All")){
			ElementRetry.checkElementExist(driveR.findElement(By.xpath("//android.widget.TextView[@text='Print and Place Shelf Edge Label']")));
		}
		doFlag();

	}
	public void doFlag() {
		try {
			ElementRetry.clickElement(driveR, driveR.findElement(By.id("" + env + ":id/flagBtn")));
			ElementRetry.clickElement(driveR, driveR.findElement(By.id("" + env + ":id/confirmFlagBtn")));
			ElementRetry.clickElement(driveR, driveR.findElement(By.id("android:id/button1")));
		} catch (Exception e) {
			System.out.println("Failed to flag prompted items. ");
		}
	}
	public void doFlagwith1Action(){
		ElementRetry.clickElement(driveR, driveR.findElement(By.xpath("//android.widget.CheckBox[@text= 'Check Merchandising Plan']")));
		doFlag();
	}
	public void doFlagwithAllaction(){
		ElementRetry.clickElement(driveR, driveR.findElement(By.xpath("//android.widget.CheckBox[@text='Print and Place Shelf Edge Label']")));
		ElementRetry.clickElement(driveR, driveR.findElement(By.xpath("//android.widget.CheckBox[@text= 'Check Merchandising Plan']")));
		ElementRetry.clickElement(driveR, driveR.findElement(By.xpath("//android.widget.TextView[@text='Flag']")));
		ElementRetry.hardSleep(1000);
		ElementRetry.clickElement(driveR, driveR.findElement(By.xpath("//android.widget.Button[@text='NEXT']")));
		ElementRetry.clickElement(driveR, driveR.findElement(By.id("android:id/button1")));
		ElementRetry.hardSleep(2500);
		ElementRetry.clickElement(driveR, driveR.findElement(By.xpath("//android.widget.FrameLayout/android.widget.Button[@text='CONTINUE']")));
	}
	public void confirmBtnForAllproductOnPlaceLabel(){
		int totalProductCount = getTotalCountOfProduct();
		System.out.println("Total product count is : "+totalProductCount);
		int i =1;
		while(i<=totalProductCount) {
			ElementRetry.hardSleep(1000);
			ElementRetry.waitForElementVisible(driveR, driveR.findElement(By.xpath("//android.widget.FrameLayout/android.widget.TextView[@text='Confirm']")));
			ElementRetry.clickElement(driveR, driveR.findElement(By.xpath("//android.widget.FrameLayout/android.widget.TextView[@text='Confirm']")));
			i++;
		}
	}
	public void confirmButton(){
		ElementRetry.waitForElementVisible(driveR,driveR.findElement(By.xpath("//android.widget.FrameLayout/android.widget.TextView[@text='Confirm']")));
		ElementRetry.clickElement(driveR, driveR.findElement(By.xpath("//android.widget.FrameLayout/android.widget.TextView[@text='Confirm']")));
	}


	public void doMultipleFlag() {
		try {
			boolean isFlag = false;
			isFlag = driveR.findElement(By.id("" + env + ":id/flagBtn")).isDisplayed();
			int i = 0;
			do {
				doFlag();
				i++;
				if(i>5){
					break;
				}
			} while (isFlag);
		} catch (Exception e) {
			System.out.println("All item are flagged");
		}


	}
	public void editqty() {
		driveR.findElement(By.id("" + env + ":id/quantityEditText")).clear();
		driveR.findElement(By.id("" + env + ":id/quantityEditText")).sendKeys(qty);
		driveR.findElement(By.id("" + env + ":id/confirmButton")).click();
	}


	public void verifySummaryPage() throws Throwable {
	Thread.sleep(2000);
		driveR.findElement(By.xpath("//android.widget.TextView[@text='Summary']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/context_menu']"));

		driveR.findElement(By.xpath("//android.widget.RelativeLayout[@resource-id='" + env + ":id/approvalCount']")).isDisplayed();

		WebElement xpathTotalApprovalsLabel = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tvApprovalRequiredLabel']"));
		xpathTotalApprovalsLabel.isDisplayed();
		String totalApprovalsLabelUI = xpathTotalApprovalsLabel.getText();
		assertEquals(totalApprovalsLabelUI, "Total Approvals","Total Approvals label is mismatched");

		WebElement xpathApprovalCount = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tvApprovalCount']"));
		xpathApprovalCount.isDisplayed();
		String approvalCount = xpathApprovalCount.getText();
		System.out.println("Approval count : " + approvalCount);

		driveR.findElement(By.xpath("//android.widget.RelativeLayout[@resource-id='" + env + ":id/flagCard']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.ImageView[@resource-id='" + env + ":id/flagIcon']")).isDisplayed();

		WebElement xpathFlaggedLabel = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tvFlaggedLabel']"));
		xpathFlaggedLabel.isDisplayed();
		String flaggedLabelUI = xpathFlaggedLabel.getText();
		assertEquals(flaggedLabelUI, "Flagged:","Flagged label is mismatched");

		WebElement xpathFlaggedCount = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tvFlaggedCount']"));
		xpathFlaggedCount.isDisplayed();
		String flaggedCount = xpathFlaggedCount.getText();
		System.out.println("Flagged count : " + flaggedCount);

		driveR.findElement(By.xpath("//android.widget.RelativeLayout[@resource-id='" + env + ":id/cardActionStatus']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.ImageView[@resource-id='" + env + ":id/reportIcon']")).isDisplayed();

		WebElement xpathActionsCompletedLabel = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tvActionLabel']"));
		xpathActionsCompletedLabel.isDisplayed();
		String actionsCompletedLabelUI = xpathActionsCompletedLabel.getText();
		assertEquals(actionsCompletedLabelUI, "Actions Completed:","Actions Completed label is mismatched");

		WebElement xpathActionsCountStatus = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tvActionCountStatus']"));
		xpathActionsCountStatus.isDisplayed();
		String actionsCount = xpathActionsCountStatus.getText();
		System.out.println("Actions count : " + actionsCount);

		int dept1 = 0;
		/// In prompted count , 4 departments are present. Hence 4 times looping though for loop.
		for(int dept=1;dept<=4;dept++){

			//// Scrolling down to verify all depts.
			if(dept==3 || dept==4){
				scrollDown(300,800,250 ,200);
			}

			dept1=dept-1; ///To add index in xpath

			///Scrolled down for Market street and Services department.
			///dept = 3 (Market street) & dept = 4 (Services)
			///Set index value (Screen change)
			if(dept==3)dept1=0;
			if(dept==4)dept1=1;



			System.out.println("----------------------------"+dept1 );
			//String layoutXpath = "//android.widget.RelativeLayout[@index='"+dept1+"']//android.widget.FrameLayout[@resource-id='" + env + ":id/summary_Card']";
			String layoutXpath ="//android.widget.RelativeLayout[@index='"+ dept1 +"']/android.widget.FrameLayout";

			WebElement xpathDepartment = driveR.findElement(By.xpath(layoutXpath+"//android.widget.TextView[@resource-id='" + env + ":id/tvDepartment']"));
			xpathDepartment.isDisplayed();
			String departmentNameUI = xpathDepartment.getText();
			System.out.println("Department name : " + departmentNameUI);

			WebElement xpathTotalLabel = driveR.findElement(By.xpath(layoutXpath+"//android.widget.TextView[@resource-id='" + env + ":id/tvTotalLabel']"));
			xpathTotalLabel.isDisplayed();
			String totalLabelUI = xpathTotalLabel.getText();
			assertEquals(totalLabelUI, "Total:","Total label is mismatched");

			WebElement xpathTotalCount = driveR.findElement(By.xpath(layoutXpath+"//android.widget.TextView[@resource-id='" + env + ":id/tvTotalCount']"));
			xpathTotalCount.isDisplayed();
			String totalCountUI = xpathTotalCount.getText();
			System.out.println("Total count : " + totalCountUI);

			WebElement xpathCompleteLabel = driveR.findElement(By.xpath(layoutXpath+"//android.widget.TextView[@resource-id='" + env + ":id/tvCompleteLabel']"));
			xpathCompleteLabel.isDisplayed();
			String completeLabelUI = xpathCompleteLabel.getText();
			assertEquals(completeLabelUI, "Complete:","Complete label is mismatched");

			WebElement xpathCompleteCount = driveR.findElement(By.xpath(layoutXpath+"//android.widget.TextView[@resource-id='" + env + ":id/tvCompleteCount']"));
			xpathCompleteCount.isDisplayed();
			String completeCountUI = xpathCompleteCount.getText();
			System.out.println("Complete count : " + completeCountUI);

			WebElement xpathActionCompletedLabel = driveR.findElement(By.xpath(layoutXpath+"//android.widget.TextView[@resource-id='" + env + ":id/tvActionCompletedLabel']"));
			xpathActionCompletedLabel.isDisplayed();
			String actionCompletedLabelUI = xpathActionCompletedLabel.getText();
			assertEquals(actionCompletedLabelUI, "Actions Completed:","Actions Completed label is mismatched");

			WebElement xpathActionCompleted = driveR.findElement(By.xpath(layoutXpath+"//android.widget.TextView[@resource-id='" + env + ":id/tvActionCompletedStatus']"));
			xpathActionCompleted.isDisplayed();
			String actionCompletedCountUI = xpathActionCompleted.getText();
			System.out.println("Action Completed count : " + actionCompletedCountUI);

			WebElement xpathFlaggedDeptLabel = driveR.findElement(By.xpath(layoutXpath+"//android.widget.TextView[@resource-id='" + env + ":id/tvFlaggedLabel' and @index='7']"));
			xpathFlaggedDeptLabel.isDisplayed();
			String flaggedDeptLabelUI = xpathFlaggedDeptLabel.getText();
			assertEquals(flaggedDeptLabelUI, "Flagged:","Flagged label is mismatched");

			WebElement xpathFlaggedDeptCount = driveR.findElement(By.xpath(layoutXpath+"//android.widget.TextView[@resource-id='" + env + ":id/tvFlaggedCount' and @index='8']"));
			xpathFlaggedDeptCount.isDisplayed();
			String flaggedDeptCountUI = xpathFlaggedDeptCount.getText();
			System.out.println("Flagged count : " + flaggedDeptCountUI);

			WebElement xpathApprovalCompletedLabel = driveR.findElement(By.xpath(layoutXpath+"//android.widget.TextView[@resource-id='" + env + ":id/tvApprovalCompletedLabel']"));
			xpathApprovalCompletedLabel.isDisplayed();
			String approvalCompletedLabelUI = xpathApprovalCompletedLabel.getText();
			assertEquals(approvalCompletedLabelUI, "Approvals Completed:","Approvals Completed label is mismatched");

			WebElement xpathApprovalCompletedCount = driveR.findElement(By.xpath(layoutXpath+"//android.widget.TextView[@resource-id='" + env + ":id/tvApprovalCompleted']"));
			xpathApprovalCompletedCount.isDisplayed();
			String approvalCompletedCountUI = xpathApprovalCompletedCount.getText();
			System.out.println("Approval completed count : " + approvalCompletedCountUI);

			driveR.findElement(By.xpath(layoutXpath+"//android.widget.ProgressBar[@resource-id='" + env + ":id/circular_determinative_pb']")).isDisplayed();
			driveR.findElement(By.xpath(layoutXpath+"//android.widget.TextView[@resource-id='" + env + ":id/progress_tv']")).isDisplayed();

			scrollDown(500,650,300,500);
		}

	}

	public void verifyProductList(String action) throws Throwable {

		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tvDepartment']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tvTotalLabel']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tvTotalCount']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tvCompleteLabel']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tvCompleteCount']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tvActionCompletedLabel']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tvActionCompletedStatus']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tvFlaggedLabel' and @index='7']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tvFlaggedCount' and @index='8']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.ProgressBar[@resource-id='" + env + ":id/circular_determinative_pb']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/progress_tv']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tvDepartment']")).isDisplayed();
	}


	public void promptedItemSortingSequence() throws Throwable {

		//		driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/edt_ExpiryDate']"))
		//				.isDisplayed();
		//		driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/edt_ExpiryDate']")).click();
	}

	public void requestLabelScreen() throws Throwable {
		Thread.sleep(3000);
		ElementRetry.checkElementExist(driveR.findElement(By.xpath("//android.widget.TextView[@text='Request Label']")));
		ElementRetry.checkElementExist(driveR.findElement(By.xpath("//android.widget.Button[@text='CONTINUE']")));

		WebElement xpathItemDescription = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/list_item_description']"));
		xpathItemDescription.isDisplayed();
		String itemDescription = xpathItemDescription.getText();
		System.out.println("Item description on Request label screen : " + itemDescription);

		WebElement xpathMinLabel = driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/itemMinLabelValue']//android.widget.TextView[@resource-id='" + env + ":id/label']"));
		xpathMinLabel.isDisplayed();
		String minLabelUI = xpathMinLabel.getText();
		assertEquals(minLabelUI,"Min:","Min label is mismatched");

		WebElement xpathMin = driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/itemMinLabelValue']//android.widget.TextView[@resource-id='" + env + ":id/value']"));
		xpathMin.isDisplayed();
		String minUI = xpathMin.getText();
		System.out.println("Product Min on Request label screen : " + minUI);

		driveR.findElement(By.xpath("//android.widget.ImageView[@resource-id='" + env + ":id/productImageView']")).isDisplayed();

		WebElement xpathSelectLabelSize = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/selectLabelText']"));
		xpathSelectLabelSize.isDisplayed();
		String selectLabelSizeUI = xpathSelectLabelSize.getText();
		assertEquals(selectLabelSizeUI,"Select Label Size","Select Label Size is mismatched");


		List<WebElement> xpathLablesName = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/price_label_name']"));

		for(WebElement xpathLabel : xpathLablesName){
			String labelUI = xpathLabel.getText();
			System.out.println("Label name on Request label screen : " + labelUI);
		}

	}

	public void verifyLabels() throws Throwable {

		List<WebElement> xpathLabelList = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='"+ env +":id/price_label_name']"));

		for(WebElement xpathLabel : xpathLabelList){

			String labelName = xpathLabel.getText();
			System.out.println("Label name : " + labelName);

			selectLabelSize(labelName);
		}
	}

	public void selectLabelSize(String labelName)  throws Throwable {

		WebElement xpathLabelCheckbox = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+labelName+"']/following::android.widget.CheckBox[@resource-id='" + env + ":id/label_checkbox']"));
		xpathLabelCheckbox.isDisplayed();
		String isChecked = xpathLabelCheckbox.getAttribute("checked");

		if(isChecked.equalsIgnoreCase("false")){
			xpathLabelCheckbox.click();
		}

		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/selectLabelText']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/noOfLabelsText']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.ImageView[@resource-id='" + env + ":id/label_remove_button']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.ImageView[@resource-id='" + env + ":id/label_add_button']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/edit_text_quantity']")).isDisplayed();

		xpathLabelCheckbox.click();
	}

	public void verifyLabel(String labelName)  throws Throwable {

		List<WebElement> xpathLabelList = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='"+ env +":id/price_label_name']"));
		List<String> labelNameList = new ArrayList<String>();

		for(WebElement xpathLabel : xpathLabelList){

			String labelNameUI = xpathLabel.getText();
			System.out.println("Label name on UI : " + labelNameUI);
			System.out.println("Expected Label name : " + labelName);

			labelNameList.add(labelNameUI);

			if(labelNameUI.equalsIgnoreCase(labelName)){

				ElementRetry.clickElement(driveR, driveR.findElement(By.xpath("//android.widget.TextView[@text='"+labelName+"']/following::android.widget.CheckBox[@resource-id='"+ env +":id/label_checkbox']")));
				break;
			}
			else{
				assertEquals(labelNameUI,labelName,"Failed: Label name is mismatched");
			}
		}
	}

	///Select label checkbox if it is not checked
	public void selectLabel()  throws Throwable {
		WebElement xpathSelectLabel = driveR.findElement(By.xpath("//android.widget.CheckBox[@resource-id='"+ env +":id/label_checkbox']"));
		xpathSelectLabel.isDisplayed();

		if(xpathSelectLabel.getAttribute("checked").equalsIgnoreCase("false")){
		xpathSelectLabel.click();
		}
	}

	public void verifyLablesArePresent(String label1,String label2,String label3){
		try{
			List<String> exepctedLabelName = new ArrayList<String>();
			exepctedLabelName.add(label1);
			exepctedLabelName.add(label2);
			exepctedLabelName.add(label3);

			for(String labelName : exepctedLabelName){
				System.out.println("Expected label name : " + labelName);

				WebElement xpathLabelCheckbox = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+labelName+"']/following::android.widget.CheckBox[@resource-id='" + env + ":id/label_checkbox']"));
				xpathLabelCheckbox.isDisplayed();
				String isChecked = xpathLabelCheckbox.getAttribute("checked");

				if(isChecked.equalsIgnoreCase("true")){
					xpathLabelCheckbox.click();
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void verifyItemListCount() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/header_text']")).isDisplayed();
	}

	public void verifyHistoryScreen() throws Throwable {

		Thread.sleep(3000);
		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/context_menu']")).isDisplayed();
		List<WebElement> xpathAllProducts = new ArrayList<WebElement>();

		boolean isProductPresent = true;

		try{
			xpathAllProducts = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tvProductDescription']"));
			isProductPresent = !xpathAllProducts.isEmpty();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}

		try{

			if(isProductPresent){
				for(int index=0;index<=xpathAllProducts.size()-1;index++)
				{
					String summaryDetailXpath = "//android.widget.RelativeLayout[@resource-id='" + env + ":id/summary_detail_item' and @index = '"+index+"']";

					WebElement xpathProductDescription = driveR.findElement(By.xpath(summaryDetailXpath + "//android.widget.TextView[@resource-id='" + env + ":id/tvProductDescription']"));
					xpathProductDescription.isDisplayed();
					System.out.println("Product description on History screen : " + xpathProductDescription.getText());

					driveR.findElement(By.xpath(summaryDetailXpath + "//android.widget.TextView[@text='MIN:']")).isDisplayed();

					WebElement xpathProductMin = driveR.findElement(By.xpath(summaryDetailXpath + "//android.widget.TextView[@resource-id='" + env + ":id/value']"));
					System.out.println("Product Min on History screen : " + xpathProductMin.getText());

					WebElement xpathItemCount = driveR.findElement(By.xpath(summaryDetailXpath + "//android.widget.TextView[@resource-id='" + env + ":id/tvItemCount']"));
					System.out.println("Item count on History screen : " + xpathItemCount.getText());

					String aisleLayoutXpath = summaryDetailXpath + "//android.widget.LinearLayout[@resource-id='" + env + ":id/planLayout']//android.widget.LinearLayout[@resource-id='" + env + ":id/aisle']";

					WebElement xpathAisleLabel = driveR.findElement(By.xpath(aisleLayoutXpath+"//android.widget.TextView[@resource-id='" + env + ":id/label']"));
					xpathAisleLabel.isDisplayed();
					String aisleLabelText = xpathAisleLabel.getText();
					System.out.println("Aisle lable text : " + aisleLabelText);
					assertEquals(aisleLabelText,"Aisle:","Aisle lable is mismatched");

					WebElement xpathAisleCount = driveR.findElement(By.xpath(aisleLayoutXpath+"//android.widget.TextView[@resource-id='" + env + ":id/value']"));
					xpathAisleCount.isDisplayed();
					String aisleCountText = xpathAisleCount.getText();
					System.out.println("Aisle lable count : " + aisleCountText);

					String bayLayoutXpath = summaryDetailXpath + "//android.widget.LinearLayout[@resource-id='" + env + ":id/planLayout']//android.widget.LinearLayout[@resource-id='" + env + ":id/bay']";

					WebElement xpathBayLabel = driveR.findElement(By.xpath(bayLayoutXpath+"//android.widget.TextView[@resource-id='" + env + ":id/label']"));
					xpathBayLabel.isDisplayed();
					String bayLabelText = xpathBayLabel.getText();
					System.out.println("Bay lable text : " + bayLabelText);
					assertEquals(bayLabelText,"Bay:","Bay lable is mismatched");

					WebElement xpathBayCount = driveR.findElement(By.xpath(bayLayoutXpath+"//android.widget.TextView[@resource-id='" + env + ":id/value']"));
					xpathBayCount.isDisplayed();
					String bayCountText = xpathBayCount.getText();
					System.out.println("Bay lable count : " + bayCountText);

					String shelfLayoutXpath = summaryDetailXpath + "//android.widget.LinearLayout[@resource-id='" + env + ":id/planLayout']//android.widget.LinearLayout[@resource-id='" + env + ":id/shelf']";

					WebElement xpathShelfLabel = driveR.findElement(By.xpath(shelfLayoutXpath+"//android.widget.TextView[@resource-id='" + env + ":id/label']"));
					xpathShelfLabel.isDisplayed();
					String shelfLabelText = xpathShelfLabel.getText();
					System.out.println("Shelf lable text : " + shelfLabelText);
					assertEquals(shelfLabelText,"Shelf:","Shelf lable is mismatched");

					WebElement xpathShelfCount = driveR.findElement(By.xpath(shelfLayoutXpath+"//android.widget.TextView[@resource-id='" + env + ":id/value']"));
					xpathShelfCount.isDisplayed();
					String shelfCountText = xpathShelfCount.getText();
					System.out.println("Shelf lable count : " + shelfCountText);

					String positionLayoutXpath = summaryDetailXpath + "//android.widget.LinearLayout[@resource-id='" + env + ":id/position']";

					WebElement xpathPositionLabel = driveR.findElement(By.xpath(positionLayoutXpath+"//android.widget.TextView[@resource-id='" + env + ":id/label']"));
					xpathPositionLabel.isDisplayed();
					String positionLabelText = xpathPositionLabel.getText();
					System.out.println("Position lable text : " + shelfLabelText);
					assertEquals(positionLabelText,"Position:","Position lable is mismatched");

					WebElement xpathPositionCount = driveR.findElement(By.xpath(positionLayoutXpath+"//android.widget.TextView[@resource-id='" + env + ":id/value']"));
					xpathPositionCount.isDisplayed();
					String positionCountText = xpathPositionCount.getText();
					System.out.println("Position lable count : " + positionCountText);
				}
			}
			else{
				WebElement xpathNoElementPresent = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/list_empty_view']"));
				xpathNoElementPresent.isDisplayed();
				String noElementPresentText = xpathNoElementPresent.getText();
				System.out.println("Text : " + noElementPresentText);
				assertEquals(noElementPresentText,"No Items Available","No Items Available text is mismatched");
			}
		}
		catch(Exception e){
			e.printStackTrace();

		}
	}



	public void actionAndNextScreenDisplay() throws Throwable {
		Thread.sleep(3000);
		driveR.findElement(By.xpath("//android.widget.TextView[@text='Actions & Next Steps']")).isDisplayed();

		driveR.findElement(By.xpath("//android.widget.ImageView[@resource-id='" + env + ":id/action_image']")).isDisplayed();

		WebElement xpathActionHeading = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/action_heading']"));
		xpathActionHeading.isDisplayed();
		String actionHeadingUI = xpathActionHeading.getText();
		assertEquals(actionHeadingUI, "Actions & Next Steps" ,"Action heading is mismatched");


		WebElement xpathNextStepInfo = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/action_next_step_info_message']"));
		xpathNextStepInfo.isDisplayed();
		//		String nextStepInfoUI = xpathNextStepInfo.getText();
		//		assertEquals(nextStepInfoUI, "Whilst completing the Ambient & Frozen counts, issues were identified."+ "\n" + "Please perform the respective next steps for the actions below.","Action heading is mismatched");

		driveR.findElement(By.xpath("//android.widget.RelativeLayout[@resource-id='" + env + ":id/merchandising']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.RelativeLayout[@resource-id='" + env + ":id/printplacelabel']")).isDisplayed();

		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tv_merchandising_qty']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tv_print_queue_qty']")).isDisplayed();

		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/merchandBtn']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/printBtn']")).isDisplayed();

		driveR.findElement(By.xpath("//android.widget.ImageView[@resource-id='" + env + ":id/image_1']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.ImageView[@resource-id='" + env + ":id/image_2']")).isDisplayed();
	}

	public void verifyMerchandisingAction() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.RelativeLayout[@resource-id='" + env + ":id/merchandising']")).isDisplayed();
	}

	public void verifyPrintAndPlaceLabelsAction() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.RelativeLayout[@resource-id='" + env + ":id/printplacelabel']")).isDisplayed();
	}

	public void merchandisingActionWithZeroCount() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tv_merchandising_qty']")).isDisplayed();
		String actualMerchandisingCount = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tv_merchandising_qty']")).getText();

		assertEquals(actualMerchandisingCount, "0","Merchandising com.morrisons.common.action count is not Zero");
	}

	public void printAndPlaceLabelsWithZeroCount() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tv_print_queue_qty']")).isDisplayed();
		String actualPrintAndPlaceCount = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tv_print_queue_qty']")).getText();

		assertEquals(actualPrintAndPlaceCount, "0","Print And Place com.morrisons.common.action count is not Zero");
	}

	public void clickOnMerchandising() throws Throwable {
		ElementRetry.checkElementExist(driveR.findElement(By.xpath("//android.widget.RelativeLayout[@resource-id='" + env + ":id/merchandising']")));
		ElementRetry.clickElement(driveR, driveR.findElement(By.xpath("//android.widget.RelativeLayout[@resource-id='" + env + ":id/merchandising']")));
	//	driveR.findElement(By.xpath("//android.widget.RelativeLayout[@resource-id='" + env + ":id/merchandising']")).click();
	}

	public void clickOnPrintAndPlaceLabels() throws Throwable {
		ElementRetry.checkElementExist(driveR.findElement(By.xpath("//android.widget.TextView[@text='Print & Place Labels']")));
		ElementRetry.clickElement(driveR, driveR.findElement(By.xpath("//android.widget.TextView[@text='Print & Place Labels']")));

	}

	public void printAndPlaceLabelScreenDisplay() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.TextView[@text='Place Labels']")).isDisplayed();
	}

	public void detailsOnPrintAndPlaceLabel() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/top']//android.widget.ImageView")).isDisplayed(); //Printer image

		WebElement xpathPrintAndPlaceLabel = driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/top']//android.widget.TextView[@index='1']"));
		xpathPrintAndPlaceLabel.isDisplayed();
		String printAndPlaceLabel = xpathPrintAndPlaceLabel.getText();
		assertEquals(printAndPlaceLabel,"Print & Place Shelf Edge Labels","Print & Place Shelf Edge Labels text is mismatched");

		WebElement xpathInfo = driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/top']//android.widget.TextView[@index='3']"));
		xpathInfo.isDisplayed();
		String infoText = xpathInfo.getText();
		assertEquals(infoText,"Please print all shelf edge labels at the printer and place them at the correct product location.","Info on Print and place label is mismatched");

		WebElement xpathInfo1 =  driveR.findElement(By.xpath("//android.widget.LinearLayout[@index='2']//android.widget.TextView"));
		xpathInfo1.isDisplayed();
		String info1Text = xpathInfo1.getText();
		assertEquals(info1Text,"Follow the location to place the missing shelf edge label","Info on Print and place label is mismatched");

		WebElement xpathPlaceLabelsButton = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/place_label_btn']"));
		String placeLabelBtnName = xpathPlaceLabelsButton.getText();
		assertEquals(placeLabelBtnName,"PLACE LABELS","PLACE LABELS button name is mismatched");

	}

	public void detailsOnPlaceLabel() throws Throwable {

		WebElement xpathProductCount = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/product_count_header']"));
		xpathProductCount.isDisplayed();
		String productCountUI = xpathProductCount.getText().split("of")[1].replace(")", "").replace(" ", "");
		int totalProduct = Integer.parseInt(productCountUI);

		for(int i=0;i<=totalProduct-1;i++){

			WebElement xpathProductImage = driveR.findElement(By.xpath("//android.widget.ImageView[@resource-id='" + env + ":id/productImageView']"));
			xpathProductImage.isDisplayed();

			WebElement xpathProductDescription = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/list_item_description']"));
			String productDescrition = xpathProductDescription.getText();
			System.out.println("Product Description on Merchandising screen : " + productDescrition);

			WebElement xpathProductMinLabel = driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/itemMinLabelValue']//android.widget.TextView[@resource-id='" + env + ":id/label']"));
			String productMinLabelUI = xpathProductMinLabel.getText();
			System.out.println("Product Min label on Merchandising screen : " + productMinLabelUI);
			WebElement xpathProductMin = driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/itemMinLabelValue']//android.widget.TextView[@resource-id='" + env + ":id/value']"));
			String productMinUI = xpathProductMin.getText();
			productMinOnMerchandising.add(productMinUI); //// Add product min to the list
			System.out.println("Product Min on Merchandising screen : " + productMinUI);

			WebElement xpathAisleLabel = driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/aisleLabelValueView']//android.widget.TextView[@resource-id='" + env + ":id/label']"));
			String aisleLabelUI = xpathAisleLabel.getText();
			System.out.println("Aisle Label on Merchandising screen : " + aisleLabelUI);
			WebElement xpathAisleCount = driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/aisleLabelValueView']//android.widget.TextView[@resource-id='" + env + ":id/value']"));
			String aisleCountUI = xpathAisleCount.getText();
			System.out.println("Aisle count on Merchandising screen : " + aisleCountUI);

			WebElement xpathBayLabel = driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/bayLabelValueView']//android.widget.TextView[@resource-id='" + env + ":id/label']"));
			String bayLabelUI = xpathBayLabel.getText();
			System.out.println("Bay Label on Merchandising screen : " + bayLabelUI);
			WebElement xpathBayCount = driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/bayLabelValueView']//android.widget.TextView[@resource-id='" + env + ":id/value']"));
			String bayCountUI = xpathBayCount.getText();
			System.out.println("Bay count on Merchandising screen : " + bayCountUI);

			WebElement xpathShelfLabel = driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/shelfLabelValueView']//android.widget.TextView[@resource-id='" + env + ":id/label']"));
			String shelfLabelUI = xpathShelfLabel.getText();
			System.out.println("Shelf label on Merchandising screen : " + shelfLabelUI);
			WebElement xpathShelfCount = driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/shelfLabelValueView']//android.widget.TextView[@resource-id='" + env + ":id/value']"));
			String shelfCountUI = xpathShelfCount.getText();
			System.out.println("Shelf count on Merchandising screen : " + shelfCountUI);

			WebElement xpathPositionLabel = driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/positionLabelValueView']//android.widget.TextView[@resource-id='" + env + ":id/label']"));
			String positionLabelUI = xpathPositionLabel.getText();
			System.out.println("Position label on Merchandising screen : " + positionLabelUI);
			WebElement xpathPositionCount = driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/positionLabelValueView']//android.widget.TextView[@resource-id='" + env + ":id/value']"));
			String positionCountUI = xpathPositionCount.getText();
			System.out.println("Position count on Merchandising screen : " + positionCountUI);

			WebElement xpathConfirmButton = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/place_label_confirm_btn']"));
			xpathConfirmButton.isDisplayed();
		//	xpathConfirmButton.click();

		}

	}


	public void clickOnPlaceLabels() throws Throwable {

		WebElement xpathPlaceLabelsButton = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/place_label_btn']"));
		xpathPlaceLabelsButton.isDisplayed();
		xpathPlaceLabelsButton.click();
	}

	public void deadlineReminderName(String alertName) throws Throwable {

		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/alertTitle']")).isDisplayed();
		String alertNameUI = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/alertTitle']")).getText();

		assertEquals(alertNameUI, alertName,"Deadline reminder alert name is mismatched");
	}

	public void deadlineReminderMessage(String alertMessage) throws Throwable {

		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']")).isDisplayed();
		String alertMessageUI = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']")).getText();

		assertEquals(alertMessageUI, alertMessage,"Deadline reminder alert message is mismatched");
	}

	public void messageTitle(String messageTitle) throws Throwable {

		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/generic_blocking_error_title']")).isDisplayed();
		String messageTitleUI = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/generic_blocking_error_title']")).getText();

		assertEquals(messageTitleUI, messageTitle,"Prompted counts submissions closed message title is mismatched");
	}

	public void messageText(String messageText) throws Throwable {

		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/generic_blocking_error_message']")).isDisplayed();
		String messageTextUI = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/generic_blocking_error_message']")).getText();

		assertEquals(messageTextUI, messageText,"Prompted counts submissions closed message text is mismatched");
	}

	public void verifyMessageIsDisplayed(String message) throws Throwable {

		ElementRetry.checkElementExist(driveR.findElement(By.xpath("//android.widget.TextView[@text='"+message+"']")));
	}

	public void selectProductOnHistoryScreen(String quantity) throws Throwable {
	//	ElementRetry.clickElement(driveR, driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tvItemCount']")));
		ElementRetry.checkAndClickOnElementAfterScroll(driveR,"//android.widget.TextView[@text='" + quantity + "']");
		//ElementRetry.clickElement(driveR, driveR.findElement(By.xpath("//android.widget.TextView[@text='" + quantity + "']")));
	}

	public void clickOnContinueButton() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.Button[@resource-id='" + env + ":id/printLabelContinueBtn']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.Button[@resource-id='" + env + ":id/printLabelContinueBtn']")).click();
		ElementRetry.hardSleep(2000);
	}

	public void verifyDetailsOnFixtureScreen() throws Throwable {

		////Header details
		//driveR.findElement(By.xpath("//android.widget.TextView[@text='Fixture']")).isDisplayed();
		ElementRetry.hardSleep(2000);
		ElementRetry.checkElementExist(driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/action_product_history']")));
		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/context_menu']")).isDisplayed();
		driveR.findElement(By.className("android.widget.ImageButton")).isDisplayed();

		WebElement xpathHeader = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/header_text']"));
		String headerTextUI = xpathHeader.getText();
		System.out.println("Header text : " + headerTextUI);

		//Product description
		WebElement xpathProductDescription = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/list_item_description']"));
		String productDescriptionUI = xpathProductDescription.getText();
		System.out.println("Product description on screen : " + productDescriptionUI);


		driveR.findElement(By.xpath("//android.widget.ImageView[@resource-id='" + env + ":id/productImageView']")).isDisplayed();

		//// Product details
		driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/itemMinLabelValue']")).isDisplayed();

		WebElement xpathProductMinLabel = driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/itemMinLabelValue']//android.widget.TextView[@resource-id='" + env + ":id/label']"));
		String productMinLabelUI = xpathProductMinLabel.getText();
		System.out.println("Product Min label on screen : " + productMinLabelUI);
		WebElement xpathProductMin = driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/itemMinLabelValue']//android.widget.TextView[@resource-id='" + env + ":id/value']"));
		String productMinUI = xpathProductMin.getText().trim();

		productMinOnFixture = productMinUI;
		System.out.println("Product Min on screen : " + productMinUI);

		/////Location details

		driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/locationLayout']")).isDisplayed();

		WebElement xpathAisleLabel = driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/aisleLabelValueView']//android.widget.TextView[@resource-id='" + env + ":id/label']"));
		String aisleLabelUI = xpathAisleLabel.getText();
		System.out.println("Aisle Label on screen : " + aisleLabelUI);
		WebElement xpathAisleCount = driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/aisleLabelValueView']//android.widget.TextView[@resource-id='" + env + ":id/value']"));
		String aisleCountUI = xpathAisleCount.getText();
		System.out.println("Aisle count on screen : " + aisleCountUI);

		WebElement xpathBayLabel = driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/bayLabelValueView']//android.widget.TextView[@resource-id='" + env + ":id/label']"));
		String bayLabelUI = xpathBayLabel.getText();
		System.out.println("Bay Label on screen : " + bayLabelUI);
		WebElement xpathBayCount = driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/bayLabelValueView']//android.widget.TextView[@resource-id='" + env + ":id/value']"));
		String bayCountUI = xpathBayCount.getText();
		System.out.println("Bay count on screen : " + bayCountUI);

		WebElement xpathShelfLabel = driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/shelfLabelValueView']//android.widget.TextView[@resource-id='" + env + ":id/label']"));
		String shelfLabelUI = xpathShelfLabel.getText();
		System.out.println("Shelf label on screen : " + shelfLabelUI);
		WebElement xpathShelfCount = driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/shelfLabelValueView']//android.widget.TextView[@resource-id='" + env + ":id/value']"));
		String shelfCountUI = xpathShelfCount.getText();
		System.out.println("Shelf count on screen : " + shelfCountUI);


		WebElement xpathPositionLabel = driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/positionLabelValueView']//android.widget.TextView[@resource-id='" + env + ":id/label']"));
		String positionLabelUI = xpathPositionLabel.getText();
		System.out.println("Position label on screen : " + positionLabelUI);
		WebElement xpathPositionCount = driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/positionLabelValueView']//android.widget.TextView[@resource-id='" + env + ":id/value']"));
		String positionCountUI = xpathPositionCount.getText();
		System.out.println("Position count on screen : " + positionCountUI);

		//////Item stock details and action layout

		driveR.findElement(By.xpath("//android.widget.TextView[@text='Stock Record:']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[@text='Last Delivery Date:']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[@text='Next Delivery Date:']")).isDisplayed();

		WebElement xpathStockRecordValue = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/stockRecordValue']"));
		xpathStockRecordValue.isDisplayed();
		String stockRecordValue = xpathStockRecordValue.getText();
		System.out.println("Stock record value on screen : " + stockRecordValue);

		WebElement xpathLastDeliveryDateValue = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/lastDeliveryDateValue']"));
		xpathLastDeliveryDateValue.isDisplayed();
		String lastDeliveryDateValue = xpathLastDeliveryDateValue.getText();
		System.out.println("Last Delivery date value on screen : " + lastDeliveryDateValue);

		WebElement xpathNextDeliveryDateValue = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/nextDeliveryDateValue']"));
		xpathNextDeliveryDateValue.isDisplayed();
		String nextDeliveryDateValue = xpathNextDeliveryDateValue.getText();
		System.out.println("Next delivery date value on screen : " + nextDeliveryDateValue);


		driveR.findElement(By.xpath("//android.widget.CheckBox[@text='Print and Place Shelf Edge Label']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.CheckBox[@text='Check Merchandising Plan']")).isDisplayed();

		//// Item action layout

		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/itemUOM']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/quantityEditText']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.Button[@resource-id='" + env + ":id/confirmButton']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/flagBtn']")).isDisplayed();

	}

	public void verifyDetailsOnMerchandising() throws Throwable {
		ElementRetry.hardSleep(1500);
		driveR.findElement(By.xpath("//android.widget.ImageView[@resource-id='" + env + ":id/merchandising_image']")).isDisplayed();

		WebElement xpathTitle = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/merchandising_title']"));
		xpathTitle.isDisplayed();
		String titleUI = xpathTitle.getText();
		assertEquals(titleUI,"Merchandising","Merchandising title is mismatched");

		WebElement xpathAction = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/action1']"));
		xpathAction.isDisplayed();
		String actionUI = xpathAction.getText();
		assertEquals(actionUI,"Please print the merchandising plans below from Galleria and implement as soon as possible.","Action text is mismatched");

		////Product list details
		WebElement xpathProductLabel = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/product_items_label']"));
		xpathProductLabel.isDisplayed();
		String productLabelUI = xpathProductLabel.getText().trim();
		assertEquals(productLabelUI,"Product(s):","Product label text is mismatched");

		driveR.findElement(By.xpath("//android.widget.RelativeLayout[@resource-id='" + env + ":id/product_list']")).isDisplayed();

		List<WebElement> xpathProductList = driveR.findElements(By.xpath("//android.widget.RelativeLayout[@resource-id='" + env + ":id/summary_detail_item']"));
		int productListCount = xpathProductList.size();
		System.out.println("Products in list on Merchandising screen: " + productListCount);
		WebElement xpathProductCount = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/product_items']"));
		xpathProductCount.isDisplayed();
		int productCountUI = Integer.parseInt(xpathProductCount.getText().trim());
		System.out.println("Product count on Merchandising screen : " + productListCount);

		////Location details
		for(int product = 1;product<=xpathProductList.size();product++){

			WebElement xpathProductDescription = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tvProductDescription']"));
			String productDescrition = xpathProductDescription.getText();
			System.out.println("Product Description on Merchandising screen : " + productDescrition);

			WebElement xpathProductMinLabel = driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/minLabelValue']//android.widget.TextView[@resource-id='" + env + ":id/label']"));
			String productMinLabelUI = xpathProductMinLabel.getText();
			System.out.println("Product Min label on Merchandising screen : " + productMinLabelUI);
			WebElement xpathProductMin = driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/minLabelValue']//android.widget.TextView[@resource-id='" + env + ":id/value']"));
			String productMinUI = xpathProductMin.getText();
			productMinOnMerchandising.add(productMinUI); //// Add product min to the list
			System.out.println("Product Min on Merchandising screen : " + productMinUI);

			WebElement xpathAisleLabel = driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/aisle']//android.widget.TextView[@resource-id='" + env + ":id/label']"));
			String aisleLabelUI = xpathAisleLabel.getText();
			System.out.println("Aisle Label on Merchandising screen : " + aisleLabelUI);
			WebElement xpathAisleCount = driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/aisle']//android.widget.TextView[@resource-id='" + env + ":id/value']"));
			String aisleCountUI = xpathAisleCount.getText();
			System.out.println("Aisle count on Merchandising screen : " + aisleCountUI);

			WebElement xpathBayLabel = driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/bay']//android.widget.TextView[@resource-id='" + env + ":id/label']"));
			String bayLabelUI = xpathBayLabel.getText();
			System.out.println("Bay Label on Merchandising screen : " + bayLabelUI);
			WebElement xpathBayCount = driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/bay']//android.widget.TextView[@resource-id='" + env + ":id/value']"));
			String bayCountUI = xpathBayCount.getText();
			System.out.println("Bay count on Merchandising screen : " + bayCountUI);

			WebElement xpathShelfLabel = driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/shelf']//android.widget.TextView[@resource-id='" + env + ":id/label']"));
			String shelfLabelUI = xpathShelfLabel.getText();
			System.out.println("Shelf label on Merchandising screen : " + shelfLabelUI);
			WebElement xpathShelfCount = driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/shelf']//android.widget.TextView[@resource-id='" + env + ":id/value']"));
			String shelfCountUI = xpathShelfCount.getText();
			System.out.println("Shelf count on Merchandising screen : " + shelfCountUI);

			WebElement xpathPositionLabel = driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/position']//android.widget.TextView[@resource-id='" + env + ":id/label']"));
			String positionLabelUI = xpathPositionLabel.getText();
			System.out.println("Position label on Merchandising screen : " + positionLabelUI);
			WebElement xpathPositionCount = driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/position']//android.widget.TextView[@resource-id='" + env + ":id/value']"));
			String positionCountUI = xpathPositionCount.getText();
			System.out.println("Position count on Merchandising screen : " + positionCountUI);

		}

		WebElement xpathConfirmButton = driveR.findElement(By.xpath("//android.widget.Button[@resource-id='" + env + ":id/btn_confirm']"));
		xpathConfirmButton.isDisplayed();
	}


	public void verifyProductsOnMerchandising() throws Throwable {
		boolean isProductPresent = false;
		System.out.println("Merchandising product list : " + productMinOnMerchandising);
		System.out.println("Fixture product min : " + productMinOnFixture);

		if(productMinOnMerchandising.contains(productMinOnFixture)){
			isProductPresent = true;
		}
		assertEquals(isProductPresent,true,"Product is not present");
	}

	public void verifyReviewAndEditButton() throws Throwable {

		ElementRetry.checkElementExist(driveR.findElement(By.xpath("//android.widget.TextView[@text='To review and edit the count and check history for the current location select the button below.']")));
		ElementRetry.checkElementExist(driveR.findElement(By.className("android.widget.ImageView"))); //Edit button image
		ElementRetry.checkElementExist( driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/review_and_edit']")));
		ElementRetry.checkElementExist(driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/continueBtn']")));
	}

	public void clickOnReviewAndEdit() throws Throwable {

		WebElement xpathReviewAndEditButton = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/review_and_edit']"));
		xpathReviewAndEditButton.isDisplayed();
		xpathReviewAndEditButton.click();

	}

	public void verifyDetailsOnWarehouseScreen() throws Throwable {

		Thread.sleep(3000);

		////Header details
		driveR.findElement(By.xpath("//android.widget.TextView[@text='Warehouse']")).isDisplayed();

		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/action_product_history']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/context_menu']")).isDisplayed();
		driveR.findElement(By.className("android.widget.ImageButton")).isDisplayed();

		WebElement xpathHeader = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/header_text']"));
		String headerTextUI = xpathHeader.getText();
		System.out.println("Header text : " + headerTextUI);

		//Product description
		WebElement xpathProductDescription = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/list_item_description']"));
		String productDescriptionUI = xpathProductDescription.getText();
		System.out.println("Product description on Warehouse screen : " + productDescriptionUI);


		driveR.findElement(By.xpath("//android.widget.ImageView[@resource-id='" + env + ":id/productImageView']")).isDisplayed();

		//// Product details
		driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/itemMinLabelValue']")).isDisplayed();

		WebElement xpathProductMinLabel = driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/itemMinLabelValue']//android.widget.TextView[@resource-id='" + env + ":id/label']"));
		String productMinLabelUI = xpathProductMinLabel.getText();
		System.out.println("Product Min label on Warehouse screen : " + productMinLabelUI);
		WebElement xpathProductMin = driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/itemMinLabelValue']//android.widget.TextView[@resource-id='" + env + ":id/value']"));
		String productMinUI = xpathProductMin.getText().trim();

		productMinOnFixture = productMinUI;
		System.out.println("Product Min on Warehouse screen : " + productMinUI);

		//////Item stock details and action layout

		driveR.findElement(By.xpath("//android.widget.TextView[@text='Stock Record:']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[@text='Last Delivery Date:']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[@text='Next Delivery Date:']")).isDisplayed();

		WebElement xpathStockRecordValue = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/stockRecordValue']"));
		xpathStockRecordValue.isDisplayed();
		String stockRecordValue = xpathStockRecordValue.getText();
		System.out.println("Stock record value on Fixture screen : " + stockRecordValue);

		WebElement xpathLastDeliveryDateValue = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/lastDeliveryDateValue']"));
		xpathLastDeliveryDateValue.isDisplayed();
		String lastDeliveryDateValue = xpathLastDeliveryDateValue.getText();
		System.out.println("Last Delivery date value on Fixture screen : " + lastDeliveryDateValue);

		WebElement xpathNextDeliveryDateValue = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/nextDeliveryDateValue']"));
		xpathNextDeliveryDateValue.isDisplayed();
		String nextDeliveryDateValue = xpathNextDeliveryDateValue.getText();
		System.out.println("Next delivery date value on Fixture screen : " + nextDeliveryDateValue);

		//// Item action layout

		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/itemUOM']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/quantityEditText']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.Button[@resource-id='" + env + ":id/confirmButton']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/flagBtn']")).isDisplayed();

	}


	///Shrutika#################################################################################

		public void verifyPromptDisplayed(String location) throws InterruptedException
		{
			Thread.sleep(2000);
			boolean islocation = driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + location + "']")).isDisplayed();
			Assert.assertEquals(true, islocation, "Location is not displayed");
			promptedScreen();

		}

		public void promptedScreen() {
			driveR.findElement(By.id("" + env + ":id/header_text")).isDisplayed();
			driveR.findElement(By.id("" + env + ":id/action_product_history")).isDisplayed();
			driveR.findElement(By.id("" + env + ":id/context_menu")).isDisplayed();
			driveR.findElement(By.id("" + env + ":id/header_text")).isDisplayed();

			driveR.findElement(By.id("" + env + ":id/list_item_description")).isDisplayed();
			driveR.findElement(By.id("" + env + ":id/label")).isDisplayed();
			try {
				driveR.findElement(By.xpath("//android.widget.TextView[@text='Aisle:']")).isDisplayed();
				driveR.findElement(By.xpath("//android.widget.TextView[@text='Bay:']")).isDisplayed();
				driveR.findElement(By.xpath("//android.widget.TextView[@text='Shelf:']")).isDisplayed();
				driveR.findElement(By.xpath("//android.widget.TextView[@text='Position:']")).isDisplayed();
			} catch (Exception e) {
			}
			driveR.findElement(By.xpath("//android.widget.TextView[@text='Stock Record:']")).isDisplayed();
			driveR.findElement(By.xpath("//android.widget.TextView[@text='Last Delivery Date:']")).isDisplayed();
			driveR.findElement(By.xpath("//android.widget.TextView[@text='Next Delivery Date:']")).isDisplayed();
			driveR.findElement(By.xpath("//android.widget.TextView[@text='Stock Record:']")).isDisplayed();
			driveR.findElement(By.xpath("//android.widget.TextView[@text='Stock Record:']")).isDisplayed();

			driveR.findElement(By.id("" + env + ":id/stockRecordValue")).isDisplayed();
			driveR.findElement(By.id("" + env + ":id/lastDeliveryDateValue")).isDisplayed();
			driveR.findElement(By.id("" + env + ":id/nextDeliveryDateValue")).isDisplayed();
			try {
				driveR.findElement(By.xpath("//android.widget.CheckBox[@text='Print and Place Shelf Edge Label']")).isDisplayed();
				driveR.findElement(By.xpath("//android.widget.CheckBox[@text='Check Merchandising Plan']")).isDisplayed();
			} catch (Exception e) {
			}

			driveR.findElement(By.id("" + env + ":id/itemUOM")).isDisplayed();
			driveR.findElement(By.id("" + env + ":id/quantityEditText")).isDisplayed();
			driveR.findElement(By.id("" + env + ":id/confirmButton")).isDisplayed();
			driveR.findElement(By.id("" + env + ":id/flagBtn")).isDisplayed();

		}

		public void verifymessage(String message, String location) {
			boolean ismessage = driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + message + "']")).isDisplayed();
			Assert.assertEquals(true, ismessage, "Message is not displayed");

		}

		public void iclickButton(String button) {
			WebElement Button = driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + button + "']"));
			boolean isbutton= Button.isDisplayed();
			Assert.assertEquals(true, isbutton, "Button is not displayed");
			Button.click();
		}


			public void CompleteAllprompteditems() {
			try {
				boolean isedit =false;
				isedit = driveR.findElement(By.id("" + env + ":id/quantityEditText")).isDisplayed();
				do {
					editqty();
				} while (isedit);
			} catch (Exception e) {
				System.out.println("All item are Completed");
			}

			}

		public void            verifyEditAllowedinReviewEdit(String qty, String location) {
			driveR.findElement(By.id("" + env + ":id/summary_detail_item")).isDisplayed();
			driveR.findElement(By.id("" + env + ":id/summary_detail_item")).click();
			driveR.findElement(By.id("" + env + ":id/editBtn")).click();
			driveR.findElement(By.id("" + env + ":id/quantityEditText")).clear();
			driveR.findElement(By.id("" + env + ":id/quantityEditText")).sendKeys(qty);
			 driveR.findElement(By.id("" + env + ":id/confirmButton")).click();
			//for flagged item
			 try {
					driveR.findElement(By.xpath("//android.widget.TextView[@text= 'CONTINUE']")).click();
				} catch (Exception e) {

				}

		}




		public void departmentlistforApproval() throws InterruptedException {
			Thread.sleep(2000);
			driveR.findElement(By.id("" + env + ":id/approvalCount")).isDisplayed();
			System.out.println("Total Approvals : " +driveR.findElement(By.id("" + env + ":id/approvalCount")).getTagName());

			List<WebElement> departmentlist = driveR.findElements(By.xpath("//android.widget.RelativeLayout/android.widget.TextView[@index='0']"));
			List<WebElement> approvalCount = driveR.findElements(By.xpath("//android.widget.RelativeLayout/android.widget.TextView[@index='1']"));
			for(int i=0;i<=departmentlist.size()-1;i++)
			{
				System.out.println("Departments for Total Approvals : "+departmentlist.get(i).getText() + " and Pending Approvals is: "+approvalCount.get(i).getText());
			//	driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_title']")).isDisplayed();
			//	driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_status']")).isDisplayed();
			}
		}


		public void itemlistforapproval() {
			List<WebElement> itemlist = driveR.findElements(By.xpath("//android.support.v7.widget.RecyclerView[@resource-id='" + env + ":id/rvMenu_List_']"));
			System.out.println("Total itmes for approvals: "+itemlist.size());
			for(int i=0;i<=itemlist.size()-1;i++)
			{
				driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/item_approval_status']")).isDisplayed();
					driveR.findElement(By.xpath("//android.widget.TextView[@text='Adjustment Value :']")).isDisplayed();
					String adjustmentvalue =driveR.findElement(By.id("" + env + ":id/value")).getText();
					int advalue= Integer.parseInt(adjustmentvalue);
					System.out.println("Adjustment Value: "+advalue);

			}
		}


		public void approveitemlist() {
				String productCounts = driveR.findElement(By.xpath("//android.widget.RelativeLayout/android.widget.TextView[contains(@text, 'Product')]")).getText();
				int count = Integer.parseInt(productCounts.split("of")[0].replaceAll("[^0-9]", ""));
				System.out.println("Total product avaialble for approval :" +count);

				ElementRetry.clickElement(driveR,driveR.findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[@index='0']/android.widget.RelativeLayout/android.widget.TextView[@text='APPROVE']")));
				//driveR.findElement(By.xpath("//android.support.v7.widget.RecyclerView")).click();
				// driveR.findElement(By.id("//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[@index='0']/android.widget.RelativeLayout/android.widget.TextView[@text='APPROVE']")).click();
				 driveR.findElement(By.id("android:id/button1")).click();

		}


		public void edititembeforeapproval(String location) {

			ElementRetry.clickElement(driveR, driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + location + "']")));
			ElementRetry.clickElement(driveR, driveR.findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[@index='0']/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[@text='Counted']")));
			ElementRetry.clickElement(driveR, driveR.findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[@index='0']")));

			ElementRetry.hardSleep(1500);
			WebElement textbox = driveR.findElement(By.xpath("//android.widget.EditText"));
			textbox.click();
			textbox.clear();
			textbox.sendKeys(qty);
			driveR.findElement(By.xpath("//android.widget.Button")).click();


		}



		public void approveitemdisplayed() {
			try {
				driveR.findElement(MobileBy.AndroidUIAutomator(
						"new UiScrollable(new UiSelector())" + ".scrollIntoView(new UiSelector().text(\"APPROVED \"));"))
						.isDisplayed();
			} catch (Exception e) {
			}
			driveR.findElement(By.xpath("//android.widget.TextView[@text= 'APPROVED']")).isDisplayed();

		}

			public void verifyPreviouslocation(String location) {
			driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + location + "']")).isDisplayed();

			}

			private String qty="9";
			private String location ="Fixture";
			public void unflageditemedit() {
				verifyEditAllowedinReviewEdit(qty,location);
			}



			public void selectactioncheckbox() {
				driveR.findElement(By.xpath("//android.widget.CheckBox[@text= 'Print and Place Shelf Edge Label']")).click();
				driveR.findElement(By.xpath("//android.widget.CheckBox[@text= 'Check Merchandising Plan']")).click();
				driveR.findElement(By.xpath("//android.widget.Button[@resource-id='" + env + ":id/printLabelContinueBtn']")).click();

			}


			public void verifyusercannotremoveaction() {
					driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/summary_detail_item']")).isDisplayed();
					driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/summary_detail_item']")).click();
						try {
						driveR.findElement(By.xpath("//android.widget.CheckBox[@text='Print and Place Shelf Edge Label']"))
								.click();
						driveR.findElement(By.xpath("//android.widget.CheckBox[@text='Check Merchandising Plan']"))
								.click();
					} catch (Exception e) {
					}
					driveR.findElement(By.xpath("//android.widget.TextView[@text= 'CONFIRM']")).click();
					driveR.findElement(By.xpath("//android.widget.TextView[@text= 'CONTINUE']")).click();
					driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/summary_detail_item']")).click();
					driveR.findElement(By.xpath("//android.widget.CheckBox[@text= 'Issues']")).isDisplayed();

			}


			public void verifyheaderText(String header) {
						driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + header + "']")).isDisplayed();


			}


			public void verifyEditedCount(String header, String qtyUpdated) {
				String qtyUI = driveR.findElement(By.xpath("//android.widget.RelativeLayout[@index='0']//android.widget.TextView[@resource-id='" + env + ":id/tvItemCount']")).getText();
				System.out.println(qtyUI);
				Assert.assertEquals(qtyUI, qtyUpdated, "Quantity Mismatched !!!");

			}


			public void selectitem() {
				driveR.findElement(By.xpath("//android.widget.RelativeLayout[@index='0']")).isDisplayed();
				driveR.findElement(By.xpath("//android.widget.RelativeLayout[@index='0']")).click();

			}


			public void verifyiteminviewmode() throws InterruptedException {
				Thread.sleep(2000);
				selectitem();
				boolean isApprove =	driveR.findElement(By.xpath("//android.widget.Button[@text= 'APPROVE']")).isEnabled();
				Assert.assertEquals(isApprove, false, "Approve button is enabled before 9.45AM");
			}


			public void selectSummaryCard(String department) {
				driveR.findElement(By.xpath("//android.widget.RelativeLayout[@index='1']//android.widget.FrameLayout[@resource-id='" + env + ":id/summary_Card']")).click();

			}


			public void verifytotalcount() throws InterruptedException {
				Thread.sleep(2000);
				driveR.findElement(By.id("" + env + ":id/tvDepartment")).isDisplayed();
				driveR.findElement(By.id("" + env + ":id/tvTotalLabel")).isDisplayed();
				driveR.findElement(By.id("" + env + ":id/tvTotalCount")).isDisplayed();
				driveR.findElement(By.id("" + env + ":id/tvCompleteLabel")).isDisplayed();
				driveR.findElement(By.id("" + env + ":id/tvApprovalCompletedLabel")).isDisplayed();
				driveR.findElement(By.id("" + env + ":id/tvApprovalCompletedCount")).isDisplayed();
				driveR.findElement(By.id("" + env + ":id/circular_determinative_pb")).isDisplayed();
				driveR.findElement(By.id("" + env + ":id/progress_tv")).isDisplayed();
				driveR.findElement(By.id("" + env + ":id/tvFlaggedLabel")).isDisplayed();
				driveR.findElement(By.id("" + env + ":id/tvFlaggedCount")).isDisplayed();
				driveR.findElement(By.id("" + env + ":id/tvActionLabel")).isDisplayed();
				driveR.findElement(By.id("" + env + ":id/tvActionCountStatus")).isDisplayed();
				driveR.findElement(By.id("" + env + ":id/tvProductCount")).isDisplayed();

			}


			public void verifyProductlistdescription() throws InterruptedException {
				Thread.sleep(2000);
			driveR.findElement(By.xpath("//android.widget.RelativeLayout[@resource-id='"+ env + ":id/summary_detail_item']")).isDisplayed(); //first item in list

				driveR.findElement(By.id("" + env + ":id/tvProductDescription")).isDisplayed();
				driveR.findElement(By.id("" + env + ":id/tvItemCount")).isDisplayed();
				driveR.findElement(By.id("" + env + ":id/label")).isDisplayed();  //MIN
				driveR.findElement(By.id("" + env + ":id/value")).isDisplayed();
				driveR.findElement(By.id("" + env + ":id/adjustmentValue")).isDisplayed();
				driveR.findElement(By.xpath("//android.widget.TextView[@text= 'Adjustment:']")).isDisplayed();
			}


			public int verifyadjustmentcount() throws InterruptedException {
				Thread.sleep(2000);
				driveR.findElement(By.xpath("//android.widget.RelativeLayout[@resource-id='"+ env + ":id/summary_detail_item']")).click();

				String stockrecordUI = driveR.findElement(By.id("" + env + ":id/stock_on_hand")).getText(); //stock record UI
				int stockrecord = Integer.parseInt(stockrecordUI);

				String countedUI = driveR.findElement(By.id("" + env + ":id/tvCountedValue")).getText(); //counted record UI
				int counted = Integer.parseInt(countedUI);

				String AdjustmentValueUI = driveR.findElement(By.id("" + env + ":id/tvAdjustmentValue")).getText(); //Adjustment record UI
				int expectedAdjustmentValue = Integer.parseInt(AdjustmentValueUI);
				int actualAdvalue = counted-stockrecord;
				System.out.println("Actual adjustment value...."+actualAdvalue);
				Assert.assertEquals(actualAdvalue, expectedAdjustmentValue, "Adjustmentcount mismatched");
				return actualAdvalue;

			}


			public void verifyAdjustmentvalueondeartmentlevel() {
				 driveR.findElement(By.id("" + env + ":id/viewCapture")).click();
				 driveR.findElement(By.id("" + env + ":id/quantityEditText")).clear();
				 driveR.findElement(By.id("" + env + ":id/quantityEditText")).sendKeys("900");
				 driveR.findElement(By.id("" + env + ":id/confirmButton")).click();

				String AdjustmentValueUI = driveR.findElement(By.id("" + env + ":id/tvAdjustmentValue")).getText(); //Adjustment record UI
				driveR.findElement(By.className("android.widget.ImageButton")).click();  //Click Back
				String AdjustmentValuemainUI = driveR.findElement(By.xpath("//android.widget.RelativeLayout[@resource-id='"+ env + ":id/summary_detail_item']//android.widget.TextView[@resource-id='"+ env + ":id/adjustmentValue']")).getText();

			System.out.println("AdjustmentValueUI...."+AdjustmentValueUI+ "AdjustmentValuemainUI..."+AdjustmentValuemainUI );
			Assert.assertEquals(AdjustmentValueUI, AdjustmentValuemainUI);

			}


	public void departmentStatus(String dept, String status){
		String index=null;
		String StatusXpath=null;
		switch(dept){
			case "Ambient & Frozen":
				index="0";
				break;
			case  "Fresh":
				index="1";
				break;
			case  "Market Street":
				index="2";
				break;
			case "Services":
				index="3";
				break;
		}
		if(status.equalsIgnoreCase("Default")){
			StatusXpath="//android.widget.RelativeLayout[@index='" + index + "']/android.widget.TextView[contains(@text,'')]";
			ElementRetry.waitForElementVisible(driveR, driveR.findElement(By.xpath(StatusXpath)));
			System.out.println("Department status is : "+status);
		}
		else if(status.equalsIgnoreCase("IN PROGRESS")){
			StatusXpath="//android.widget.RelativeLayout[@index='" + index + "']/android.widget.TextView[contains(@text,'IN PROGRESS')]";
			ElementRetry.waitForElementVisible(driveR, driveR.findElement(By.xpath(StatusXpath)));
			System.out.println("Department status is : "+status);
		}
		else if(status.equalsIgnoreCase("ACTION")){
			StatusXpath="//android.widget.RelativeLayout[@index='" + index + "']/android.widget.TextView[contains(@text,' ACTION')]";
			ElementRetry.waitForElementVisible(driveR, driveR.findElement(By.xpath(StatusXpath)));
			System.out.println("Department status is : "+status);
		}
		else if(status.equalsIgnoreCase("COMPLETE")){
			StatusXpath="//android.widget.RelativeLayout[@index='" + index + "']/android.widget.TextView[contains(@text,'COMPLETE')]";
			ElementRetry.waitForElementVisible(driveR, driveR.findElement(By.xpath(StatusXpath)));
			System.out.println("Department status is : "+status);
		}
		else{
			Assert.assertFalse(true,dept+ " : Department name or "+status +" : status not found");
		}
	}

	public void verifyDepartmentWithStatus(String department, String status) {
		ElementRetry.hardSleep(1500);
		boolean isDepartment = ElementRetry.waitForElementVisible(driveR, driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + department + "']")));
		assertEquals(isDepartment, true, department + "Department is not present...");
		if(status !=null) {
			departmentStatus(department, status);
		}
	}

	public void menuOption(String options) throws Throwable {
		try {
			ElementRetry.waitForElementVisible(driveR, driveR.findElement(By.xpath("//android.widget.TextView[@text='" + options + "']")));
			ElementRetry.clickElement(driveR, driveR.findElement(By.xpath("//android.widget.TextView[@text='" + options + "']")));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifySubMenuWithStatus(String subMenu, String status) {
		ElementRetry.hardSleep(1500);
		boolean isDepartment = ElementRetry.waitForElementVisible(driveR, driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + subMenu + "']")));
		assertEquals(isDepartment, true, subMenu + "Department is not present...");
		if(status !=null) {
			subMenuStatus(subMenu, status);
		}
	}

	public void subMenuStatus(String submenu, String status) {

		String index=null;
		String statusXpath=null;

		switch(submenu) {
			case "Fixture":
				index = "0";
				break;
			case "Off Shelf":
				index = "1";
				break;
			case "Petrol":
				index = "2";
				break;
			case "Warehouse":
				index = "3";
				break;
			case "Actions & Next Steps":
				index = "4";
				break;

		}
			if(status.equalsIgnoreCase("0") || status.equalsIgnoreCase("1")){
				statusXpath = "//android.widget.RelativeLayout[@index='" + index + "']/android.widget.TextView[contains(@text, '" + status + " OF ')]" ;
				ElementRetry.waitForElementVisible(driveR, driveR.findElement(By.xpath(statusXpath)));
				System.out.println("Department status is : "+status);
			}
			else if(status.equalsIgnoreCase("COMPLETE")){
				statusXpath="//android.widget.RelativeLayout[@index='" + index + "']/android.widget.TextView[contains(@text,'COMPLETE')]";
				ElementRetry.waitForElementVisible(driveR, driveR.findElement(By.xpath(statusXpath)));
				System.out.println("Department status is : "+status);
			}
			else if(status.equalsIgnoreCase("ACTION")){
				statusXpath="//android.widget.RelativeLayout[@index='" + index + "']/android.widget.TextView[contains(@text,' ACTION')]";
				ElementRetry.waitForElementVisible(driveR, driveR.findElement(By.xpath(statusXpath)));
				System.out.println("Department status is : "+status);
			}
			else if(status.equalsIgnoreCase("Default")){
				statusXpath="//android.widget.RelativeLayout[@index='" + index + "']/android.widget.TextView[contains(@text,'')]";
				ElementRetry.waitForElementVisible(driveR, driveR.findElement(By.xpath(statusXpath)));
				System.out.println("Department status is : "+status);
			}
			else{
				Assert.assertFalse(true,submenu+ " : Location name or "+status +" : status not found");
			}
		}

	public void actionStatusOnActionAndNextSteps(String actionName, String status) {
		String xpath = null;
		String actualStatus=null;
		if(actionName.equalsIgnoreCase("Merchandising")){
			xpath = "//android.widget.RelativeLayout[contains(@resource-id,'id/merchandising')]/android.widget.TextView[@index='2']" ;
			actualStatus=driveR.findElement(By.xpath(xpath)).getText();
			assertEquals(actualStatus, status,  status +" is mismathed, actual status is : "+actualStatus);
		}
		if(actionName.equalsIgnoreCase("Print & Place Labels")){
			xpath = "//android.widget.RelativeLayout[contains(@resource-id,'id/printplacelabel')]/android.widget.TextView[@index='2']" ;
			actualStatus=driveR.findElement(By.xpath(xpath)).getText();
			assertEquals(actualStatus, status,  status +" is mismathed, actual status is : "+actualStatus);
		}

	}

	public void actionStatusOnEditScreen(String actionName, String status) {
		boolean result = false;
		String statusXpath=null;
		ElementRetry.hardSleep(2000);
		statusXpath = "//android.widget.LinearLayout/android.widget.CheckBox[contains(@text,'" + actionName + "')]";
		result = driveR.findElement(By.xpath(statusXpath)).isEnabled();
		if(status.equalsIgnoreCase("Disable")){
			assertNotEquals(result, status, actionName +" :Status is Enabled.. Failed.");
		}
		else if(status.equalsIgnoreCase("Enable")){
			assertEquals(result, status, actionName +" :Status is Enabled.. Failed.");
		}

	}

	public void scrollDown(int xOffsetFrom, int yOffsetFrom, int xOffsetTo , int yOffsetTo) throws Throwable {
		System.out.println("Scrolling down");
		//driveR.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		Thread.sleep(2000);
		TouchAction ts = new TouchAction(driveR);
		ts.press(PointOption.point(xOffsetFrom, yOffsetFrom)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
				.moveTo(PointOption.point(xOffsetTo, yOffsetTo)).release().perform();
	}
	int updatedQuantity;
	public void EditToExistingPromptedItem(String qty) throws Throwable {

		ElementRetry.clickElement(driveR, driveR.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'id/tvItemCount')]")));
		List<WebElement> selectToEditAll = driveR.findElements(By.xpath("//android.widget.RelativeLayout[contains(@resource-id,'id/viewCapture')]"));
		System.out.println("Element count is : "+selectToEditAll.size());
		//selectToEdit.click();
		for(int i = 0; i<selectToEditAll.size(); i++)
		{
			String xpath =	"//android.widget.RelativeLayout[@index='"+ i +"']/android.widget.RelativeLayout[contains(@resource-id,'id/viewCapture')]";
			System.out.println("i value is : "+i);
			ElementRetry.hardSleep(2000);
			//String name = selectToEditAll.get(i).getText();
			//log.info("Products are: " + name);
			ElementRetry.clickElement(driveR, driveR.findElement(By.xpath(xpath)));
			System.out.println("Element count is : "+selectToEditAll.size());
			//selectToEditAll.get(i).click();
			enterQtyAndConfirm(qty);
			System.out.println("Element qty is : "+qty);

		}
		int j=selectToEditAll.size();
		updatedQuantity=j*Integer.parseInt(qty);
	}

	public void verifyUpdatedQuantity() {
		int quantity= Integer.parseInt(driveR.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'id/tvItemCount')]")).getText());
		assertEquals(quantity,updatedQuantity);
	}





}
