package com.morrisons.common.helper;

import com.morrisons.common.action.Hook;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import java.util.Locale;

public class ActionHelper {


    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    private static AndroidDriver driveR;

    private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
    private final Logger log = Logger.getLogger(ActionHelper.class);


    public ActionHelper() {
        log.info("Inside : " + ActionHelper.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    ////// Web Elements

    @FindBy(how = How.CLASS_NAME, using = "android.widget.ImageButton")
    public WebElement backButton;

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

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='SIGN OFF' or @text='Sign Off']")
    public WebElement signoffButton;

    ///// Methods

    public void clickOnButton(String button) throws Throwable {
        log.info("Clicking on Button");
        //clickElement(driveR, backButton);
        Thread.sleep(2000);
        switch (button.toUpperCase(Locale.ROOT)) {
            case "BACK":
                backButton.click();
                break;
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
            case "SIGN OFF":
                signoffButton.click();
                break;
            default:
                log.error("No Such Button : " + button);
                Assert.fail("No Such Button : " + button);
        }
    }
}
