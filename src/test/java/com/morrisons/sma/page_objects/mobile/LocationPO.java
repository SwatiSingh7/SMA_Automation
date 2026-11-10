package com.morrisons.sma.page_objects.mobile;

import static com.morrisons.common.helper.CommonHelperMethods.selectOption;


import org.apache.log4j.Logger;
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

public class LocationPO {

    private static AndroidDriver driveR;
    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;

    private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
    String env = applicationConfig.getWebElementEnviroment().getEnv();
    private final Logger log = Logger.getLogger(StockAdjustmentPO_New.class);


    public LocationPO() {
        log.info("Inside : " + CountsPO.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

////////WEB ELEMENTS //////////

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Fixture Scan']")
    public WebElement fixtureScanMenu;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Off Shelf']")
    public WebElement offShelfMenu;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Petrol']")
    public WebElement petrolMenu;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Warehouse']")
    public WebElement warehouseMenu;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Review']")
    public WebElement reviewMenu;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Summary']")
    public WebElement summaryMenu;


    ////////Methods //////////

    public void clickOnLocation(String location) throws Throwable {
        log.info("Clicking on Location Page Option : " + location);
        switch (location) {
            case "Fixture Scan":
                selectOption(driveR, offShelfMenu, location);
                break;
            case "Off Shelf":
                selectOption(driveR, offShelfMenu, location);
                break;
            case "Petrol":
                selectOption(driveR, petrolMenu, location);
                break;
            case "Warehouse":
                selectOption(driveR, warehouseMenu, location);
                break;
            case "Review":
                selectOption(driveR, reviewMenu, location);
                break;
            case "Summary":
                selectOption(driveR, summaryMenu, location);
                break;
            default:
                log.error("No such Menu is present : " + location);
                Assert.fail("No such Menu is present : " + location);
        }
    }
}
