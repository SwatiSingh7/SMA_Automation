package com.morrisons.sma.page_objects.mobile.countOptimization;

import com.morrisons.common.action.Hook;
import com.morrisons.common.helper.CommonHelperMethods;
import com.morrisons.sma.page_objects.mobile.cleanAndRotate.SelectDepartment;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class StockManagement {
    private static AndroidDriver driveR;
    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    private final Logger log = Logger.getLogger(SelectDepartment.class);

    public StockManagement() {
        log.info("Inside : " + CountOptimizationHomePage.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    /**
     * Web Elements
     */
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Scheduled Counts']")
    public WebElement secheduleCountText;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Gaps, Lows, Highs']")
    public WebElement gapsHighLowText;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Market Street - Gaps, Lows, Highs']")
    public WebElement marketStreetText;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='PM Gaps']")
    public WebElement pmGapsText;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Prompted Counts']")
    public WebElement promptedCountText;


    /**
   * Public Methods
   */
   public void verifyStockManagement() throws Throwable {
       log.info("Verifying Stock Management page");
       CommonHelperMethods.verifyIfDisplayed(driveR,secheduleCountText );
       CommonHelperMethods.verifyIfDisplayed(driveR,gapsHighLowText );
       CommonHelperMethods.verifyIfDisplayed(driveR,marketStreetText);
       CommonHelperMethods.verifyIfDisplayed(driveR,pmGapsText);
       CommonHelperMethods.verifyIfDisplayed(driveR,promptedCountText);
   }
    public void clickOnScheduledCount() throws Throwable {
        log.info("clicking on Schedule Count");
        secheduleCountText.click();
    }

}
