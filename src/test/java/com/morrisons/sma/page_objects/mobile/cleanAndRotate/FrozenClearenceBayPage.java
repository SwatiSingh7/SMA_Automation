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

public class FrozenClearenceBayPage {

    private static AndroidDriver driveR;
    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    private final Logger log = Logger.getLogger(FrozenClearenceBayPage.class);

    public FrozenClearenceBayPage() {
        log.info("Inside : " + FrozenClearenceBayPage.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    /**
     * Web Elements
     */

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Frozen Clearance Bay']")
    public WebElement frozenClearencepgHeader;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Frozen Clearance Bay Check']")
    public WebElement frozenClearanceBayCheckTitle;
    @FindBy(how = How.XPATH, using = "//android.widget.Button[@text='CONFIRM CLEARANCE BAY CHECK']")
    public WebElement frozenConfirmBaycheckButton;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Please confirm you have checked the frozen clearance bay and removed any products that are past their code date.']")
    public WebElement instructionMessage;

    /**
     * Public Methods
     **/
    public void clickOnConfirmBayCheck() throws Throwable {
        log.info("Clicking on CONFIRM CLEARANCE BAY CHECK button");
        frozenConfirmBaycheckButton.click();

    }

    public void verifyPageHeader() throws Throwable {
        log.info("Verifying Frozen Clearance Bay Check Page Header");
        CommonHelperMethods.verifyIfDisplayed(driveR, frozenClearencepgHeader);
        CommonHelperMethods.verifyIfDisplayed(driveR, frozenClearanceBayCheckTitle);
        CommonHelperMethods.verifyIfDisplayed(driveR, instructionMessage);
    }


}
