package com.morrisons.sma.page_objects.mobile.old;

import com.morrisons.common.action.Hook;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import com.morrisons.sma.page_objects.mobile.popups.PopUpPO_New;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static com.morrisons.common.helper.ElementRetry.verifyElement;
import static com.morrisons.sma.page_objects.mobile.old.ElementRetry.*;
import static org.testng.Assert.assertEquals;

public class TwilightManagerPO {

	private static AndroidDriver driveR;
	public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 20;

	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
	String env = applicationConfig.getWebElementEnviroment().getEnv();
	private final Logger log = Logger.getLogger(TwilightManagerPO.class);

	public TwilightManagerPO() {
		log.info("Inside : " + PopUpPO_New.class);
		this.driveR = (AndroidDriver) Hook.getDriver();
		PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
	}

	/**
	 * Web Elements
	 */

	@FindBy(how = How.XPATH, using = "//android.widget.CheckedTextView[@resource-id='android:id/text1']")
	public WebElement locationCheckbox;

	@FindBy(how = How.XPATH, using = "//android.widget.Button[@resource-id='android:id/button1']")
	public WebElement confirmLocation;

	@FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Confirm' or @text='CONFIRM']")
	public WebElement confirmButton;

	@FindBy(how = How.XPATH, using = "//android.widget.Button[@text='YES' or @text='Yes']")
	public WebElement yesButton;

	@FindBy(how = How.XPATH, using = "//android.widget.Button[@text='NO' or @text='No']")
	public WebElement noButton;

	@FindBy(how = How.XPATH, using = "//android.widget.Button[@text='OK' or @text='Ok']")
	public WebElement okButton;

	@FindBy(how = How.XPATH, using = "//android.widget.Button[@text='CONTINUE' or @text='Continue']")
	public WebElement continueButton;

	@FindBy(how = How.XPATH, using = "//android.widget.Button[@text='CANCEL' or @text='Cancel']")
	public WebElement cancelButton;


	@FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'storewalk_list_item_description')]")
	public WebElement itemDescription;

	@FindBy(how = How.XPATH, using = "//android.widget.EditText[contains(@resource-id,'item_details_quantity_input')]")
	public WebElement quantity;

	@FindBy(how = How.XPATH, using = "//android.widget.Button[contains(@resource-id,'item_details_confirm_quantity')]")
	public WebElement confirmQty;

	@FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'stock_on_hand')]")
	public WebElement sohQty;

	@FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'alertTitle')]")
	public WebElement alertTitle;

	@FindBy(how = How.XPATH, using = "//android.widget.TextView[@resource-id='android:id/message']")
	public WebElement alertMessage;

	@FindBy(how = How.XPATH, using = "//android.widget.Button[@text='APPROVE' or @text='Approve']")
	public WebElement approveButton;

	@FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'itemCountCalculation')]")
	public WebElement enterQty;

	@FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Summary & Sign Off']")
	public WebElement summaryAndSignOff;

	@FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'signOffButton')]")
	public WebElement signOffButton;



	public void selectfromlist() throws Throwable {
/*		clickElement(driveR, locationCheckbox);
		clickElement(driveR, confirmLocation);*/
		locationCheckbox.click();
		confirmLocation.click();
	}


/*

	public void clickOnButton(String button) throws Throwable {
		switch (button.toUpperCase(Locale.ROOT)) {
		case "CONFIRM":
			//clickElement(driveR, confirmButton);
			confirmButton.click();
			break;
		case "YES":
			//clickElement(driveR, yesButton);
			yesButton.click();
			break;
		case "NO":
			//clickElement(driveR, noButton);
			noButton.click();
			break;
		case "OK":
			//clickElement(driveR, okButton);
			okButton.click();
			break;
		case "CONTINUE":
			//clickElement(driveR, continueButton);
			continueButton.click();
			break;
		default:
			log.error("No Such Button : " + button);
			Assert.fail("No Such Button : " + button);
		}
	}
*/


	public void completeTheLocation(String qty) throws InterruptedException{
		String categoryText = "//android.widget.TextView[contains(@resource-id,'header_title')]";
		List<WebElement> allCategories = getListWebElement(driveR, categoryText, "Product category");

		List<String> categoriesList = new ArrayList<String>();
		for(WebElement category : allCategories){
			String categoryName = category.getText();
			categoriesList.add(categoryName);
		}

		for(String categoryy : categoriesList){
			String categoryXpath = "//android.widget.TextView[@text='"+categoryy+"']";

			WebElement xpathCategory = getWebElement(driveR, categoryXpath, "Product category");
			//clickElement(driveR,xpathCategory);
			xpathCategory.click();

			try{
/*				clickElement(driveR,itemDescription);
				clickElement(driveR,quantity);*/
				itemDescription.click();
				quantity.click();

/*				enterText(quantity,qty);
				clickElement(driveR,confirmQty);*/
				quantity.sendKeys(qty);
				confirmQty.click();
			}
			catch(Exception e){
				System.out.println("Product is not available");
			}

			categoryXpath = "//android.widget.TextView[@text='"+categoryy+"']";

			xpathCategory = getWebElement(driveR, categoryXpath, "Product category");
			//waitForElementVisible(driveR, xpathCategory);
			xpathCategory.isDisplayed();
			//clickElement(driveR,xpathCategory);
			xpathCategory.click();
		}
	}


	public void verifyAlertTitle(String expectedMessage) throws Throwable {
		log.info("Getting Alert Title");
		String actualSuccessMessage = /*getText(driveR, alertTitle)*/alertTitle.getText();
		log.info("Verifying Alert Title");
		Assert.assertEquals(actualSuccessMessage, expectedMessage);
	}

	public void verifyAlertMessage(String expectedMessage) throws Throwable {
		log.info("Getting Alert message");
		String actualSuccessMessage = /*getText(driveR, alertMessage)*/alertMessage.getText();
		log.info("Verifying Alert message");
		Assert.assertEquals(actualSuccessMessage, expectedMessage);
	}


	public void verifyApprovalRequiredAlert(String alertMessage) throws Throwable{
		verifyAlertTitle("Approval Required");
		verifyAlertMessage(alertMessage);
	}

	public void clickOnProduct() {
		WebElement xpathProduct = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/product_title' or @resource-id='" + env + ":id/product_name']"));
		xpathProduct.isDisplayed();
		xpathProduct.click();
	}

	public void verifyConfirmAlert() throws Throwable{
		verifyAlertTitle("Please Confirm");
		verifyAlertMessage("Are you sure you want to approve?");

		verifyElement(driveR, yesButton);
		verifyElement(driveR, noButton);
	}

	public void verifyPromptedConfirmAlert() throws Throwable{
		verifyAlertTitle("Approve Item");
		verifyAlertMessage("Are you sure you want to approve the adjustment for this item?");

		verifyElement(driveR, continueButton);
		verifyElement(driveR, cancelButton);

	}


	public void clickOnApproveButton() {

		verifyElement(driveR, approveButton);
		//clickElement(driveR,approveButton);
		approveButton.click();

	}

	public void verifyApproveButton(String attributeName) {
		try{

			verifyElement(driveR, approveButton);
			String isEnabled =  /*getAttribute(driveR, approveButton, "Enabled")*/approveButton.getAttribute("Enabled");

			if(attributeName.equalsIgnoreCase("Enabled")){
				assertEquals(isEnabled, "true","Approve button is not enabled");	  
			}
			else if(attributeName.equalsIgnoreCase("Disabled")){			   
				assertEquals(isEnabled, "false","Approve button is not disabled");	
			}
			else{
				System.out.println("Stauts is mismatched");
			}

		}catch (Exception e) {
			log.info("Error occured while fetching attribute value : " + e.getMessage());
		}
	}



	public void enterQty(String qty) throws InterruptedException {

		verifyElement(driveR, enterQty);
		enterText(enterQty, qty);

		driveR.hideKeyboard();

	}

	public void accessRestrictedAlert(String alertMessage) throws Throwable{

		verifyAlertTitle("Access Restricted");
		verifyAlertMessage(alertMessage);

	}

	public void verifySummaryAndSignOff() throws Throwable {

		verifyElement(driveR, summaryAndSignOff);
	}

	public void verifySignOffButton() throws Throwable {

		verifyElement(driveR, signOffButton);
		String isEnabled = getAttribute(driveR, signOffButton, "Enabled");


		assertEquals(isEnabled, "true", "Sign off button is disabled");

	}
}
