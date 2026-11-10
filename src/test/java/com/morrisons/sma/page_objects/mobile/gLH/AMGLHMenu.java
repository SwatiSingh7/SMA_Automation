package com.morrisons.sma.page_objects.mobile.gLH;

import com.morrisons.common.action.Hook;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import com.morrisons.sma.page_objects.mobile.GapsLowsHighsPO;
import com.morrisons.sma.page_objects.mobile.StockAdjustmentPO_New;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import static com.morrisons.common.helper.CommonHelperMethods.selectOption;

public class AMGLHMenu {
    private static AndroidDriver driveR;
    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;

    private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
    private final Logger log = Logger.getLogger(AMGLHMenu.class);


    public AMGLHMenu() {
        log.info("Inside : " + AMGLHMenu.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    /**
     * Web Elements
     */


    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Fixture Scan']")
    public WebElement fixtureScanMenu;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Petrol']")
    public WebElement petrolMenu;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Warehouse']")
    public WebElement warehouseMenu;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Review']")
    public WebElement reviewMenu;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Off Shelf']")
    public WebElement offShelfMenu;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Summary']")
    public WebElement summaryMenu;


    /**
     * Public Methods
     **/

    public void clickOnAMGlhMenu(String option) throws Throwable {
        log.info("Clicking on Gaps Lows Highs Page Option : " + option);
        switch (option) {
            case "Fixture Scan":
                selectOption(driveR, fixtureScanMenu, option);
                break;
            case "Petrol":
                selectOption(driveR, petrolMenu, option);
                break;
            default:
                log.error("No such Menu is present : " + option);
                Assert.fail("No such Menu is present : " + option);
        }
    }

}
