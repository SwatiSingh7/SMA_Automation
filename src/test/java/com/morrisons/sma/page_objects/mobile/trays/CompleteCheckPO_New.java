package com.morrisons.sma.page_objects.mobile.trays;

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

public class CompleteCheckPO_New {

    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    private static AndroidDriver driveR;

    private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
    String env = applicationConfig.getWebElementEnviroment().getEnv();
    private final Logger log = Logger.getLogger(CompleteCheckPO_New.class);


    public CompleteCheckPO_New() {
        log.info("Inside : " + CompleteCheckPO_New.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }


    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id, 'tvNoGeneratedWaste')]")
    public WebElement noWasteMessage;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id, 'confirmZeroTraysButton')]")
    public WebElement confirmButton;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id, 'tvCompleteValidationCheckLabel')]")
    public WebElement completeReviewMessage;

    @FindBy(how = How.XPATH, using = "//android.widget.Button[contains(@resource-id, 'inner_button')]")
    public WebElement completeReviewButton;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id, 'cancelButton')]")
    public WebElement cancelButton;

    public void verifyNoWasteMessage(String expectedMessage) throws Throwable {
        log.info("Getting Screen Message");
        String actualScreenMessage = /*getText(driveR, noWasteMessage)*/noWasteMessage.getText();
        log.info("Verifying Screen Message");
        Assert.assertEquals(actualScreenMessage, expectedMessage);
    }

    public void verifyCompleteCheckMessage(String expectedMessage) throws Throwable {
        log.info("Getting Screen Message");
        String actualScreenMessage = /*getText(driveR, completeReviewMessage)*/completeReviewMessage.getText();
        log.info("Verifying Screen Message");
        Assert.assertEquals(actualScreenMessage, expectedMessage);
    }

    public void clickConfirmButton() throws Throwable {
        log.info("Clicking on Confirm button");
        //clickElement(driveR, confirmButton);
        confirmButton.click();
    }

    public void clickCompleteReviewButton() {
        log.info("Clicking on Complete & Review button");
        //clickElement(driveR, completeReviewButton);
        completeReviewButton.click();
    }

    public void clickCancelButton() {
        log.info("Clicking on Cancel button");
        cancelButton.click();
    }
}
