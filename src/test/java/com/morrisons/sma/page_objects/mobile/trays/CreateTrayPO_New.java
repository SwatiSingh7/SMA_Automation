package com.morrisons.sma.page_objects.mobile.trays;

import com.morrisons.common.action.Hook;
import com.morrisons.common.helper.MobileHelper;
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

public class CreateTrayPO_New {

    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    private static AndroidDriver driveR;

    private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
    String env = applicationConfig.getWebElementEnviroment().getEnv();
    private final Logger log = Logger.getLogger(CreateTrayPO_New.class);


    public CreateTrayPO_New() {
        log.info("Inside : " + CreateTrayPO_New.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    /**
     * Web Elements
     */

    @FindBy(how = How.XPATH, using = "//android.widget.EditText[contains(@resource-id,'editTextTrayCount')]")
    public WebElement enterNoOfTrays;

    @FindBy(how = How.XPATH, using = "//android.widget.Button[contains(@resource-id,'inner_button') or text()='CONFIRM']")
    public WebElement confirmButton;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'traysHeader') or contains(@resource-id,'TraysHeader')]")
    public WebElement trayHeader;

    // Backhaul
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Trays for Backhaul']")
    public WebElement trayBackhaul;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'trayCountDescription') or contains(@resource-id,'TrayCountDescription')]")
    public WebElement trayCountDescription;

    @FindBy(how = How.XPATH, using = "//android.widget.Button[contains(@resource-id,'inner_button') or text()='NEXT']")
    public WebElement nextButton;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'tv_Empty_TrayInfo')]")
    public WebElement emptyTrayMsg;

/** Protected Methods **/

	/*protected String getBrandXpath(String name){
		log.debug(name);
		return "//div[@id='facetFilterOptions']//label[contains(.,'" + name + "')]";
	}*/

    /**
     * Public Methods
     **/
    public void verifytrayheader() {
        log.info("Trays for Backhaul Displayed");
        //checkElementExist(trayBackhaul);
        trayBackhaul.isDisplayed();
    }

    public void verifytrayCountDescription(String expectedMessage) {
        log.info("Trays Count Description");
        String actualMessage = /*getText(driveR, trayCountDescription)*/trayCountDescription.getText();
        log.info("Verifying tray Count Description");
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    public void verifytrayHeader(String expectedMessage) {
        log.info("Getting Tray Header");
        String actualMessage = /*getText(driveR, trayHeader)*/trayHeader.getText();
        log.info("Verifying Tray Header");
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    public void clickOnNextButton() throws Throwable {
        log.info("Clicking on Next Button");
        /*clickElement(driveR, nextButton)*/;
        nextButton.click();
    }

    public void enterNoOfTrays(String noOfTrays) throws Throwable {
        log.info("Entering Number of Trays : " + noOfTrays);
        //enterText(enterNoOfTrays, noOfTrays);
        enterNoOfTrays.sendKeys(noOfTrays);
    }

    public void clickOnConfirmButton() throws Throwable {
        log.info("Clicking on Enter Barcode Icon");
        //clickElement(driveR, confirmButton);
        confirmButton.click();
    }

    public void clickOnMobileGo() throws Throwable {
        log.info("Clicking on Go");
        Thread.sleep(2000);
        MobileHelper.clickCheckButton(driveR);
        Thread.sleep(3000);
    }

    public void enterTraysNConfirm(String minID) throws Throwable {
        enterNoOfTrays(minID);
        clickOnMobileGo();
        clickOnConfirmButton();
    }

    public void verifybackhualScreenMessage(String expectedMessage) throws Throwable {
        verifytrayheader();  //trayscreen
        verifytrayCountDescription(expectedMessage);
    }

    public void verifyHeaderNDescriptionMessage(String header, String description) throws Throwable {
        verifytrayHeader(header);
        verifytrayCountDescription(description);
    }

    public void enterbackhualTraysNConfirm(String noOfTrays) throws Throwable {
        enterNoOfTrays(noOfTrays);
        clickOnMobileGo();
        clickOnNextButton();
    }

    public void emptyTrayMessage(String expectedMessage) {
        log.info("Getting Screen Message");
        String actualScreenMessage = /*getText(driveR, emptyTrayMsg)*/emptyTrayMsg.getText();
        log.info("Verifying Empty Tray Message");
        Assert.assertEquals(actualScreenMessage, expectedMessage);
    }
}
