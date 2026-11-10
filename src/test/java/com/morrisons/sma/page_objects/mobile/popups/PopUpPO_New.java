package com.morrisons.sma.page_objects.mobile.popups;

import com.morrisons.common.action.Hook;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

public class PopUpPO_New {

    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    private static AndroidDriver driveR;

    private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
    String env = applicationConfig.getWebElementEnviroment().getEnv();
    private final Logger log = Logger.getLogger(PopUpPO_New.class);


    public PopUpPO_New() {
        log.info("Inside : " + PopUpPO_New.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    /**
     * Web Elements
     */

    @FindBy(how = How.XPATH, using = "//android.widget.Button[@text='Done' or @text='DONE']")
    public WebElement doneButton;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'message')]")
    public WebElement successMessage;

    @FindBy(how = How.XPATH, using = "//android.widget.Button[@text='CONTINUE' or @text='Continue']")
    public WebElement continueButton;

    @FindBy(how = How.XPATH, using = "//android.widget.Button[@text='CANCEL' or @text='Cancel']")
    public WebElement cancelButton;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'alertTitle')]")
    public WebElement title;

    @FindBy(how = How.XPATH, using = "//android.widget.Button[@text='OK' or @text='Ok']")
    public WebElement okButton;

    @FindBy(how = How.XPATH, using = "//android.widget.Button[@text='YES' or @text='Yes']")
    public WebElement yesButton;

    @FindBy(how = How.XPATH, using = "//android.widget.Button[@text='NO' or @text='No']")
    public WebElement noButton;

    @FindBy(how = How.XPATH, using = "//android.widget.Button[@text='SUBMIT' or @text='Submit']")
    public WebElement submitButton;

    @FindBy(how = How.XPATH, using = "//android.widget.Button[@text='CONFIRM' or @text='Confirm']")
    public WebElement confirmButton;

/** Protected Methods **/

	/*protected String getBrandXpath(String name){
		log.debug(name);
		return "//div[@id='facetFilterOptions']//label[contains(.,'" + name + "')]";
	}*/

    /**
     * Public Methods
     **/

    public void clickOnSubmitButton() throws Throwable {
        log.info("Clicking on Done Button");
        /*clickElement(driveR, doneButton);*/
        doneButton.click();
    }

    public void clickOnContinueButton() throws Throwable {
        log.info("Clicking on Continue Button");
        /*clickElement(driveR, continueButton);*/
        continueButton.click();
    }

    public void clickOnCancelButton() throws Throwable {
        log.info("Clicking on Continue Button");
        //clickElement(driveR, cancelButton);
        cancelButton.click();
    }

    private void ClickOnNoButton() throws Throwable {
        log.info("Clicking on No Button");
        /*clickElement(driveR, noButton);*/
        noButton.click();
    }

    private void ClickOnSubmitButton() throws Throwable {
        log.info("Clicking on Submit Button");
        /*clickElement(driveR, noButton);*/
        submitButton.click();
    }

    public void clickOnYesButton() throws Throwable {
        log.info("Clicking on Yes Button");
        //clickElement(driveR, yesButton);
        yesButton.click();
    }

    public void clickOnNoButton() throws Throwable {
        log.info("Clicking on No Button");
        //clickElement(driveR, noButton);
        noButton.click();
    }

    public void clickOnOkButton() throws Throwable {
        log.info("Clicking on Ok Button");
        //clickElement(driveR, okButton);
        okButton.click();
    }

    public void verifyMessageNClickOnDone(String expectedMessage) throws Throwable {
        verifyMessage(expectedMessage);
        clickOnSubmitButton();
    }

    public void verifyMessageNClickOnContinue(String expectedMessage) throws Throwable {
        verifyMessage(expectedMessage);
        clickOnContinueButton();
    }
    public void verifyMessageonScreen(String expectedMessage) throws Throwable {
        verifyMessage(expectedMessage);
    }

    public void verifyMessageNClickOnCancel(String expectedMessage) throws Throwable {
        verifyMessage(expectedMessage);
        clickOnCancelButton();
    }

    public void verifyMessageNClickOnOk(String expectedMessage) throws Throwable {
        verifyMessage(expectedMessage);
        clickOnOkButton();
    }

    public void verifyMessageNClickOnSubmit(String expectedMessage) throws Throwable {
        verifyMessage(expectedMessage);
        ClickOnSubmitButton();
    }

    public void verifyMessageNClickOnYes(String expectedMessage) throws Throwable {
        verifyMessage(expectedMessage);
        clickOnYesButton();
    }

    public void verifyMessageNClickOnNo(String expectedMessage) throws Throwable {
        verifyMessage(expectedMessage);
        ClickOnNoButton();
    }

    public void verifyMessage(String expectedMessage) throws InterruptedException {
        log.info("Getting Success Message");
        String actualSuccessMessage = /*getText(driveR, successMessage)*/successMessage.getText();
        log.info("Verifying Success Message");
        Assert.assertEquals(actualSuccessMessage, expectedMessage);
    }

    public void verifyFlashMessage(String expectedMessage) throws InterruptedException {
        log.info("Getting Success Message");
        String actualSuccessMessage = driveR.findElement(By.xpath("//android.widget.FrameLayout")).getText();
        log.info("Verifying Success Message");
        Assert.assertTrue(actualSuccessMessage.contains(expectedMessage));
    }
    public void verifytitle(String expectedMessage) throws Throwable {
        log.info("Getting Title");
        String actualTitle = /*getText(driveR, title)*/title.getText();
        log.info("Verifying Title");
        Assert.assertEquals(actualTitle, expectedMessage);
    }

    public void verifyAlertNotDisplayed(String expectedAlertTitle) {
        log.info("Getting Alert title");
        String actualAlertTitle = /*getText(driveR, title)*/title.getText();
        log.info("Verifying Alert title");
        Assert.assertNotEquals(actualAlertTitle, expectedAlertTitle);
    }

    public void verifyMessageNClickOnConfirm(String expectedMessage) throws Throwable {
        verifyMessage(expectedMessage);
        clickOnConfirmButton();
    }

    public void clickOnConfirmButton() throws Throwable {
        log.info("Clicking on Confirm Button");
        confirmButton.click();
    }


    public void CheckAndClickOKBtn() {
        try {
            Thread.sleep(2000);
            if (okButton.isDisplayed()) {
                okButton.click();
            }
        }
        catch(Exception u){

        }
    }
}
