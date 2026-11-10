package com.morrisons.sma.page_objects.mobile.messagescreens;

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

public class MessageScreenPO_New {

    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    private static AndroidDriver driveR;

    private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
    String env = applicationConfig.getWebElementEnviroment().getEnv();
    private final Logger log = Logger.getLogger(MessageScreenPO_New.class);


    public MessageScreenPO_New() {
        log.info("Inside : " + MessageScreenPO_New.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    /**
     * Web Elements
     */

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'generic_blocking_error_title')]")
    public WebElement genericTitle;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'generic_blocking_error_message')]")
    public WebElement genericMessage;

    @FindBy(how = How.XPATH, using = "//android.widget.Button[contains(@resource-id,'inner_button') or text()='CLOSE']")
    public WebElement closeButton;

/** Protected Methods **/

	/*protected String getBrandXpath(String name){
		log.debug(name);
		return "//div[@id='facetFilterOptions']//label[contains(.,'" + name + "')]";
	}*/

    /**
     * Public Methods
     **/

    public void verifyTitle(String expectedMessage) {
        log.info("Verifying Message Title");
        String actualMessage = /*getText(driveR, genericTitle)*/ genericTitle.getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    public void verifyMessage(String expectedMessage) {
        log.info("Verifying Message");
        String actualMessage = /*getText(driveR, genericMessage)*/genericMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    public void clickOnCloseButton() throws Throwable {
        log.info("Clicking on Close Button");
        /*clickElement(driveR, closeButton)*/closeButton.click();
    }

    public void verifyTitleNMessage(String title, String message) throws Throwable {
        verifyTitle(title);
        verifyMessage(message);
        clickOnCloseButton();
    }


}
