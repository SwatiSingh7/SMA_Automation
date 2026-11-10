package com.morrisons.sma.page_objects.mobile;

import static com.morrisons.common.helper.CommonHelperMethods.selectOption;


import com.morrisons.common.helper.MobileHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import com.morrisons.common.action.Hook;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;

import io.appium.java_client.android.AndroidDriver;

public class GapsLowsHighsPO {

    private static AndroidDriver driveR;
    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;

    private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
    private final Logger log = Logger.getLogger(StockAdjustmentPO_New.class);


    public GapsLowsHighsPO() {
        log.info("Inside : " + GapsLowsHighsPO.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    /**
     * Web Elements
     */

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='AM Gaps Lows Highs']")
    public WebElement amGapsLowsHighsMenu;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='PM Gaps']")
    public WebElement pmGapsMenu;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='COUNT' or @text='Count']")
    public WebElement CountsBtn;

    public String sLocatorName = "//android.widget.Button[@text='Locator']~Xpath";
    /**
     * Public Methods
     **/

    public void clickOnGapsLowsHighsMenu(String glhSection) throws Throwable {
        log.info("Clicking on Gaps Lows Highs Page Option : " + glhSection);
        switch (glhSection) {
            case "AM Gaps Lows Highs":
                selectOption(driveR, amGapsLowsHighsMenu, glhSection);
                break;
            case "PM Gaps":
                selectOption(driveR, pmGapsMenu, glhSection);
                break;
            default:
                log.error("No such Menu is present : " + glhSection);
                Assert.fail("No such Menu is present : " + glhSection);
        }
    }


    public void scrollDown() throws Throwable {
        log.info("Scrolling down on Stock Information page");
        //driveR.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        MobileHelper.scroll(driveR, 500, 1515, 800,800);
    }
}