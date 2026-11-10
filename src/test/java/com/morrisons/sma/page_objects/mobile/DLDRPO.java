package com.morrisons.sma.page_objects.mobile;

import com.morrisons.common.action.Hook;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import com.morrisons.sma.page_objects.service.range.RangePO;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import java.text.ParseException;

import static com.morrisons.common.helper.CommonHelperMethods.verifyIfDisplayed;

public class DLDRPO {

    private static AndroidDriver driveR;
    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;

    private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
    String env = applicationConfig.getWebElementEnviroment().getEnv();
    private final Logger log = Logger.getLogger(DLDRPO.class);

    RangePO rangePO = new RangePO();

    public String expectedMessage = null;

    public DLDRPO() {
        log.info("Inside : " + CountsPO.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

//////// WEB ELEMENTS //////////

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@resource-id='android:id/message']")
    public WebElement alertMessage;

    @FindBy(how = How.XPATH, using = "//android.widget.Button[@text='OK' or @text='Ok']")
    public WebElement okButton;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'topBarIcon')]")
    public WebElement topBarIcon;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'topBarText')]")
    public WebElement topBarText;

    // Concatenating Expected message
    public void getMessage(String message) throws ParseException {

        rangePO.getWastageDateRange();
        log.info("wastageFrom : " + RangePO.wastageFromDate);
        log.info("wastageTo : " + RangePO.wastageToDate);

        expectedMessage = message.replaceAll("\\bwastageFrom\\b", RangePO.wastageFromDate).replaceAll("\\bwastageTo\\b", RangePO.wastageToDate);
        log.info("Expected Message : " + expectedMessage);

    }

    public void verifyMessage(String message) throws ParseException {
        getMessage(message);
        String actualSuccessMessage = /*getText(driveR, alertMessage)*/alertMessage.getText();
        log.info("Verifying Message : " + actualSuccessMessage);
        Assert.assertEquals(actualSuccessMessage, expectedMessage);

    }

    public void clickOnOkButton() {
        log.info("Clicking on Ok Button");
        //clickElement(driveR, okButton);
        okButton.click();

    }

    public void verifyMessageNClickOnOk(String message) throws Throwable {
        verifyMessage(message);
        clickOnOkButton();
    }

    public void verifyBlueTagSignAndText() throws Throwable {
        log.info("Verifying Blue tag Icon And text");
        verifyIfDisplayed(driveR, topBarIcon);
        verifyIfDisplayed(driveR, topBarText);
    }

}
