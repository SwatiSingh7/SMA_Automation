package com.morrisons.sma.page_objects.mobile;

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

import static com.morrisons.common.helper.CommonHelperMethods.selectOption;

public class HomePagePO_New {

    private static AndroidDriver driveR;
    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;

    private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
    String env = applicationConfig.getWebElementEnviroment().getEnv();
    private final Logger log = Logger.getLogger(HomePagePO_New.class);
    String sObjectName;
    public String LocationLink = "//android.widget.TextView[@resource-id='ToReplace:id/submenu_option']~Xpath";
    public HomePagePO_New(String sObjectName1) {
        this.sObjectName = sObjectName1;
    }

    public HomePagePO_New() {
        log.info("Inside : " + HomePagePO_New.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    /**
     * Web Elements
     */

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Counts']")
    public WebElement optCounts;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Stock Management Applications']")
    public WebElement stockMngmtText;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Scheduled Counts']")
    public WebElement ScheduledCounts;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Prompted Counts']")
    public WebElement promptedCounts;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[normalize-space(@text)='Stock Adjustments']")
    public WebElement optStockAdjustments;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[normalize-space(@text)='Stock Information']")
    public WebElement optStockInformation;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Shop Floor - Gap Scan']")
    public WebElement optGapsLowsHighs;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Fresh Code Check']")
    public WebElement optFreshCodeCheck;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Ambient Clean & Rotate']")
    public WebElement optCleanandRotate;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Markdowns']")
    public WebElement optMarkdowns;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Yellow Screens Menu']")
    public WebElement optYellowScreensMenu;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Price Integrity']")
    public WebElement optPriceIntegrity;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Market Street']")
    public WebElement optMarketStreet;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Stock Management Applications']")
    public WebElement optStockMgmtApp;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[normalize-space(@text)='Code Checking']")
    public WebElement optCodeChecking;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Fixture']")
    public WebElement Fixtures;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Off Shelf']")
    public WebElement OffShelf;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Petrol']")
    public WebElement Petrol;

    /** Protected Methods **/

	/*protected String getBrandXpath(String name){
		log.debug(name);
		return "//div[@id='facetFilterOptions']//label[contains(.,'" + name + "')]";
	}*/

    /**
     * Public Methods
     **/

public WebElement createObj(String sObjName) {
    WebElement oEle;
    switch (sObjName) {
        case "Stock Management Applications":
            oEle = stockMngmtText;
        break;
        case "Scheduled Counts":
            oEle = ScheduledCounts;
            break;
        default:
            oEle =  null;
        break;
    }
    return oEle;
}
    public void clickOnMainMenu(String mainOption) {
        log.info("Clicking on Main Menu : " + mainOption);
        switch (mainOption) {
            case "Stock Management Applications":
                selectOption(driveR, optStockMgmtApp, mainOption);
                break;
            case "Code Checking":
                mainOption = "Code\nChecking";
                selectOption(driveR, optCodeChecking, mainOption);
                break;
            default:
                log.error("No Such Menu Option : " + mainOption);
                Assert.fail("No Such Menu Option : " + mainOption);
        }
    }


    public void clickOnHomePageOption(String option) throws Throwable {
        log.info("Clicking on Home Page Option : " + option);
        switch (option) {
            case "Counts":
                selectOption(driveR, optCounts, option);
                break;
            case "Prompted Counts":
                selectOption(driveR, promptedCounts, option);
                break;
            case "Stock Adjustments":
                option = "Stock\nAdjustments";
                selectOption(driveR, optStockAdjustments, option);
                break;
            case "Stock Information":
                option = "Stock\nInformation";
                selectOption(driveR, optStockInformation, option);
                break;
            case "Gaps, Lows, Highs":
                selectOption(driveR, optGapsLowsHighs, option);
                break;
            case "Fresh Code Check":
                selectOption(driveR, optFreshCodeCheck, option);
                break;
            case "Clean and Rotate":
                selectOption(driveR, optCleanandRotate, option);
                break;
            case "Markdowns":
                selectOption(driveR, optMarkdowns, option);
                break;
            case "Yellow Screens Menu":
                selectOption(driveR, optYellowScreensMenu, option);
                break;
            case "Price Integrity":
                selectOption(driveR, optPriceIntegrity, option);
                break;
            case "Market Street":
                selectOption(driveR, optMarketStreet, option);
                break;
            default:
                log.error("No Such Menu Option : " + option);
                Assert.fail("No Such Menu Option : " + option);
        }
    }
}
