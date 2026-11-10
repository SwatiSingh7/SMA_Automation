package com.morrisons.sma.page_objects.mobile.items;

import com.morrisons.common.action.Hook;
import com.morrisons.common.helper.ActionHelper;
import com.morrisons.common.helper.CommonHelperMethods;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import static com.morrisons.common.helper.CommonHelperMethods.verifyIfDisplayed;


public class SubmitListPO_New {

    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    private static AndroidDriver driveR;

    private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
    String env = applicationConfig.getWebElementEnviroment().getEnv();
    private static final Logger log = Logger.getLogger(SubmitListPO_New.class);


    public SubmitListPO_New() {
        log.info("Inside : " + SubmitListPO_New.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    /**
     * Web Elements
     */

    @FindBy(how = How.XPATH, using = "//android.widget.Button[@text='SUBMIT' or @text='Submit']")
    public WebElement submitButton;

    @FindBy(how = How.XPATH, using = "//android.widget.Button[contains(@resource-id,'inner_button') or text()='COMPLETE TRAY']")
    public WebElement completeTrayButton;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'waste_validation_list_item_description')]")
    public WebElement scannedItem;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Review & Edit' or @text='REVIEW & EDIT']")
    public WebElement reviewEditButton;

    @FindBy(how = How.XPATH, using ="//android.widget.TextView[@text='To review the checks done for this waste tray please select the button below.\n" +
            "\n" +
            "To complete the validation of this tray please press Complete Tray']")
    public WebElement screenMessage;

    @FindBy(how = How.XPATH, using ="//android.widget.TextView[contains(@resource-id,'threshold_complete_message')]")
    public WebElement screenTitle;

    @FindBy(how = How.XPATH, using = "//android.widget.Button[contains(@resource-id,'inner_button') or text()='COMPLETE CHECK']")
    public WebElement completeCheckButton;


/** Protected Methods **/

	/*protected String getBrandXpath(String name){
		log.debug(name);
		return "//div[@id='facetFilterOptions']//label[contains(.,'" + name + "')]";
	}*/

    /**
     * Public Methods
     **/


    public void clickOnSubmitButton() throws Throwable {
        //clickElement(driveR, submitButton);
        Thread.sleep(3000);
        submitButton.click();
    }

    public void clickOnCompleteTrayButton() throws Throwable {
        log.info("Clicking on Complete Tray Button");
        //clickElement(driveR, completeTrayButton);
        completeTrayButton.click();
    }

    public void clickOnSubmitList() throws Throwable {
        log.info("Clicking on Submit Button");
        clickOnSubmitButton();
        //clickElement(driveR, submitButton);
    }

    public void clickScannedItem(String itemScanned) {
        log.info("Clicking on Item : " + scannedItem);
        //clickElement(driveR, scannedItem);
        scannedItem.click();
    }

    public void verifyProduct(String itemDetails, String itemQuantity, String itemMIN) throws Throwable {
        verifyProdName(itemMIN, itemDetails);
        verifyProductQuantity(itemMIN, itemQuantity);
        verifyProductMIN(itemMIN);
    }

    private void verifyProductMIN(String itemMIN) {
        By minXpath = By.xpath("//android.widget.TextView[@text='" + itemMIN + "']");
        verifyIfDisplayed(driveR, minXpath, itemMIN);
    }

    private void verifyProductQuantity(String itemMIN, String itemQuantity) {
        By quantityXpath = By.xpath("//android.widget.TextView[@text='" + itemMIN + "']/../../parent::android.widget.LinearLayout/android.widget.TextView[@index='1']");
        verifyIfDisplayed(driveR, quantityXpath, itemQuantity);
    }

    private void verifyProdName(String itemMIN, String itemDetails) {
        By descriptionXpath = By.xpath("//android.widget.TextView[@text='" + itemMIN + "']/../parent::android.widget.LinearLayout/android.widget.TextView[@index='0']");
        verifyIfDisplayed(driveR, descriptionXpath, itemDetails);
    }

    private void clickReviewEditButton() throws Throwable {
        log.info("Clicking on Review & Edit Button");
        //clickElement(driveR, reviewEditButton);
        reviewEditButton.click();
    }

    public void verifyScreenClickReviewEditButton(String title, String expectedMessage, String button) throws Throwable {
        verifyScreenTitle(title);
        verifyMessage(expectedMessage);
        clickReviewEditButton();
    }

    public void verifyCompleteTrayDisplayed(String completeTrayBtn) throws Throwable {
        verifyButton(completeTrayBtn);
    }

    public void verifyReviewEditButtonDisplayed(String reviewEditBtn) {
        verifyButtonDisplayed(reviewEditBtn);
    }

    private void verifyMessage(String expectedMessage) throws Throwable {
        log.info("Getting Screen Message");
        String actualScreenMessage = /*getText(driveR, screenMessage)*/screenMessage.getText();
        log.info("Verifying Screen Message");
        Assert.assertEquals(actualScreenMessage, expectedMessage);
    }

    private void verifyScreenTitle(String title) {
        log.info("Getting Screen Title");
        String actualScreenTitle = /*getText(driveR, screenMessage)*/screenTitle.getText();
        log.info("Verifying Screen Title");
        Assert.assertEquals(actualScreenTitle, title);
    }

    private void verifyButton(String completeTrayBtn) throws Throwable {
        log.info("Getting Button Displayed");
        String actualButton = /*getText(driveR, completeTrayButton)*/completeTrayButton.getText();
        log.info("Verifying Complete Tray button is displayed");
        Assert.assertEquals(actualButton, completeTrayBtn);
    }

    private void verifyButtonDisplayed(String reviewEditBtn) {
        log.info("Getting Button Displayed");
        String actualButton = /*getText(driveR, reviewEditButton)*/reviewEditButton.getText();
        log.info("Verifying Review & Edit button is displayed");
        Assert.assertEquals(actualButton, reviewEditBtn);
    }

    public void verifyBtnEnabledDisabled(String button, String enableDisable) throws InterruptedException {
        CommonHelperMethods.verifyButtonStatus(completeCheckButton, enableDisable);
    }

    public void verifyPIN(String itemDetails, String itemQuantity, String itemMIN) throws Throwable {
        verifyPINName(itemMIN, itemDetails);
        verifyPINQuantity(itemMIN, itemQuantity);
        verifyPINMIN(itemMIN);
    }

    private void verifyPINMIN(String itemMIN) {
        By minXpath = By.xpath("//android.widget.TextView[@text='" + itemMIN + "']");
        verifyIfDisplayed(driveR, minXpath, itemMIN);
    }

    private void verifyPINQuantity(String itemMIN, String itemQuantity) {
        By quantityXpath = By.xpath("//android.widget.TextView[@text='" + itemMIN + "']/../../parent::android.widget.LinearLayout/android.widget.TextView[@index='2']");
        verifyIfDisplayed(driveR, quantityXpath, itemQuantity);
    }

    private void verifyPINName(String itemMIN, String itemDetails) {
        By descriptionXpath = By.xpath("//android.widget.TextView[@text='" + itemMIN + "']/../parent::android.widget.LinearLayout/android.widget.TextView[@index='0']");
        verifyIfDisplayed(driveR, descriptionXpath, itemDetails);
    }
}

