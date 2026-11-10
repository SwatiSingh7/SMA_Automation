package com.morrisons.sma.page_objects.mobile.pallets;

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

public class BackhaulPalletPO_New {
    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    private static AndroidDriver driveR;

    private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
    String env = applicationConfig.getWebElementEnviroment().getEnv();
    private final Logger log = Logger.getLogger(BackhaulPalletPO_New.class);


    public BackhaulPalletPO_New() {
        log.info("Inside : " + BackhaulPalletPO_New.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    /**
     * Web Elements
     */
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Pallets to be collected']")
    public WebElement palletBackhaul;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'trayCountDescription')]")
    public WebElement trayCountDescription;

    @FindBy(how = How.XPATH, using = "//android.widget.EditText[contains(@resource-id,'editTextPalletCount')]")
    public WebElement enterNoOfPallets;

    @FindBy(how = How.XPATH, using = "//android.widget.Button[contains(@resource-id,'inner_button') or text()='NEXT']")
    public WebElement nextButton;

    public void verifypalletsheader(){
        log.info("Pallets for Backhaul Displayed");
        /*checkElementExist(palletBackhaul);*/
        palletBackhaul.isDisplayed();
    }
    public void verifypalletCountDescription(String expectedMessage){
        log.info("Pallets Count Description");
        String actualMessage= /*getText(driveR,trayCountDescription )*/trayCountDescription.getText();
        log.info("Verifying Pallets Count Description");
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    public void enterNoOfTrays(String noOfPallets) throws Throwable {
        log.info("Entering Number of Trays : " + noOfPallets);
        /*enterText(enterNoOfPallets, noOfPallets);*/
        enterNoOfPallets.sendKeys(noOfPallets);
    }

    public void clickOnNextButton() throws Throwable {
        log.info("Clicking on Next Button : " + nextButton);
        /*clickElement(driveR, nextButton);*/
        nextButton.click();
    }

    public void clickOnMobileGo() throws Throwable {
        log.info("Clicking on Go");
        Thread.sleep(2000);
        MobileHelper.clickCheckButton(driveR);
        Thread.sleep(3000);
    }
    public void verifybackhualScreenMessage(String expectedMessage) throws Throwable {
        verifypalletsheader();  //backhualpalletscreen
        verifypalletCountDescription(expectedMessage);
    }

    public void enterbackhualPalletsNConfirm(String noOfPallets) throws Throwable {
        enterNoOfTrays(noOfPallets);
        clickOnMobileGo();
        clickOnNextButton();
    }
}
