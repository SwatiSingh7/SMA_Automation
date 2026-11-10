package com.morrisons.sma.page_objects.mobile.cleanAndRotate;

import com.morrisons.common.action.Hook;
import com.morrisons.common.helper.CommonHelperMethods;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class AmbientClearancePage {
    private static AndroidDriver driveR;
    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    private final Logger log = Logger.getLogger(AmbientClearancePage.class);

    public AmbientClearancePage() {
        log.info("Inside : " + AmbientClearancePage.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    /**
     * Web Elements
     */

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Ambient Clearance Bay']")
    public WebElement ambientClearenceHeader;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Ambient Clearance Bay Check']")
    public WebElement ambientClearanceBayChecksubHdng;
    @FindBy(how = How.XPATH, using = "//android.widget.Button[@text='CONFIRM CLEARANCE BAY CHECK']")
    public WebElement confirmBaycheckButton;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Please confirm you have checked the ambient clearance bay and removed any products that are past their code date.']")
    public WebElement ambientClearenceIstruction;

    /**
     * Public Methods
     **/
    public void clickOnCnfrmbayCheckButton() throws Throwable {
        log.info("Clicking on CONFIRM CLEARANCE BAY CHECK button");
        confirmBaycheckButton.click();
    }

    public void verifyPageHeader() throws Throwable {
        log.info("Verifying Ambient Clearance Bay Check Header and Description");
        CommonHelperMethods.verifyIfDisplayed(driveR, ambientClearenceHeader);
        CommonHelperMethods.verifyIfDisplayed(driveR, ambientClearanceBayChecksubHdng);
        CommonHelperMethods.verifyIfDisplayed(driveR, ambientClearenceIstruction);
    }



}







