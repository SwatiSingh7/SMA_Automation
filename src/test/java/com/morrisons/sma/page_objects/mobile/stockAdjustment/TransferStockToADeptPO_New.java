package com.morrisons.sma.page_objects.mobile.stockAdjustment;

import com.morrisons.common.action.Hook;
import com.morrisons.common.helper.CommonHelperMethods;
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


public class TransferStockToADeptPO_New {

    public static final String TRANSFER_TO_BAKERY = "Transfer to Bakery";
    public static final String TRANSFER_TO_CAKE_SHOP = "Transfer to Cake Shop";
    public static final String TRANSFER_TO_DELI = "Transfer to Deli";
    public static final String TRANSFER_TO_FISH = "Transfer to Fish";
    public static final String TRANSFER_TO_FRESH_TO_GO = "Transfer to Fresh To Go";
    public static final String TRANSFER_TO_MEAT = "Transfer to Meat";
    public static final String TRANSFER_TO_OVEN_BAKED = "Transfer to Oven Baked";
    public static final String TRANSFER_TO_PIE_SHOP = "Transfer to Pie Shop";
    public static final String TRANSFER_TO_CAFE = "Transfer to Cafe";
    public static final String TRANSFER_TO_STAFF_ROOM = "Transfer to Staff Room";
    public static final String TRANSFER_TO_PHARMACY_TRIAL_ONLY = "Transfer to Pharmacy (TRIAL ONLY)";
    public static final String TRANSFER_TO_MARKET_STREET_EAT_FRESH_TRIAL_ONLY = "Transfer to Market Street Eat Fresh (TRIAL ONLY)";
    public static final String TRANSFER_TO_MARKET_KITCHEN = "Transfer to Market Kitchen";


    public static AndroidDriver driveR;
    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;


    private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
    String env = applicationConfig.getWebElementEnviroment().getEnv();
    private final Logger log = Logger.getLogger(TransferStockToADeptPO_New.class);

    public TransferStockToADeptPO_New() {
        log.info("Inside : " + TransferStockToADeptPO_New.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }


    /**
     * Web Elements
     */

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Transfer to Bakery']")
    public WebElement optTransferToBakery;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Transfer to Cake Shop']")
    public WebElement optTransferToCakeShop;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Transfer to Deli']")
    public WebElement optTransferToDeli;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Transfer to Fish']")
    public WebElement optTransferToFish;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Transfer to Fresh To Go']")
    public WebElement optTransferToFreshToGo;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Transfer to Meat']")
    public WebElement optTransferToMeat;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Transfer to Oven Baked']")
    public WebElement optTransferToOvenBaked;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Transfer to Pie Shop']")
    public WebElement optTransferToPieShop;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Transfer to Cafe']")
    public WebElement optTransferToCafe;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Transfer to Staff Room']")
    public WebElement optTransferToStaffRoom;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Transfer to Pharmacy (TRIAL ONLY)']")
    public WebElement optTransferToPharmacyTrialOnly;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Transfer to Market Street Eat Fresh (TRIAL ONLY)']")
    public WebElement optTransferToMarketStreetEatFreshTrialOnly;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Transfer to Market Kitchen']")
    public WebElement optTransferToMarketKitchen;

    /**
     * Public Methods
     **/

    public void clickOnTransferStockToADeptOption(String optTransferStockToADept) {
        log.info("Clicking on Transfer Stock To A Dept Page Option : " + optTransferStockToADept);
        switch (optTransferStockToADept) {
            case "Transfer to Bakery":
                selectOption(driveR, optTransferToBakery, optTransferStockToADept);
                break;
            case "Transfer to Cake Shop":
                selectOption(driveR, optTransferToCakeShop, optTransferStockToADept);
                break;
            case "Transfer to Deli":
                selectOption(driveR, optTransferToDeli, optTransferStockToADept);
                break;
            case "Transfer to Fish":
                selectOption(driveR, optTransferToFish, optTransferStockToADept);
                break;
            case "Transfer to Fresh To Go":
                selectOption(driveR, optTransferToFreshToGo, optTransferStockToADept);
                break;
            case "Transfer to Meat":
                selectOption(driveR, optTransferToMeat, optTransferStockToADept);
                break;
            case "Transfer to Oven Baked":
                selectOption(driveR, optTransferToOvenBaked, optTransferStockToADept);
                break;
            case "Transfer to Pie Shop":
                selectOption(driveR, optTransferToPieShop, optTransferStockToADept);
                break;
            case "Transfer to Cafe":
                selectOption(driveR, optTransferToCafe, optTransferStockToADept);
                break;
            case "Transfer to Staff Room":
                selectOption(driveR, optTransferToStaffRoom, optTransferStockToADept);
                break;
            case "Transfer to Pharmacy (TRIAL ONLY)":
                selectOption(driveR, optTransferToPharmacyTrialOnly, optTransferStockToADept);
                break;
            case "Transfer to Market Street Eat Fresh (TRIAL ONLY)":
                selectOption(driveR, optTransferToMarketStreetEatFreshTrialOnly, optTransferStockToADept);
                break;
            case "Transfer to Market Kitchen":
                selectOption(driveR, optTransferToMarketKitchen, optTransferStockToADept);
                break;
            default:
                log.error("No Such Menu Option : " + optTransferStockToADept);
                Assert.fail("No Such Menu Option : " + optTransferStockToADept);
        }
    }

    public void verifyOnTransferStockToADeptOption(String optTransferStockToADept) throws Throwable {
        log.info("Clicking on Transfer Stock To A Dept Page Option : " + optTransferStockToADept);
        switch (optTransferStockToADept) {
            case TRANSFER_TO_BAKERY:
                CommonHelperMethods.verifyIfDisplayed(driveR, optTransferToBakery, optTransferStockToADept);
                break;
            case TRANSFER_TO_CAKE_SHOP:
                CommonHelperMethods.verifyIfDisplayed(driveR, optTransferToCakeShop, optTransferStockToADept);
                break;
            case TRANSFER_TO_DELI:
                CommonHelperMethods.verifyIfDisplayed(driveR, optTransferToDeli, optTransferStockToADept);
                break;
            case TRANSFER_TO_FISH:
                CommonHelperMethods.verifyIfDisplayed(driveR, optTransferToFish, optTransferStockToADept);
                break;
            case TRANSFER_TO_FRESH_TO_GO:
                CommonHelperMethods.verifyIfDisplayed(driveR, optTransferToFreshToGo, optTransferStockToADept);
                break;
            case TRANSFER_TO_MEAT:
                CommonHelperMethods.verifyIfDisplayed(driveR, optTransferToMeat, optTransferStockToADept);
                break;
            case TRANSFER_TO_OVEN_BAKED:
                CommonHelperMethods.verifyIfDisplayed(driveR, optTransferToOvenBaked, optTransferStockToADept);
                break;
            case TRANSFER_TO_PIE_SHOP:
                CommonHelperMethods.verifyIfDisplayed(driveR, optTransferToPieShop, optTransferStockToADept);
                break;
            case TRANSFER_TO_CAFE:
                CommonHelperMethods.verifyIfDisplayed(driveR, optTransferToCafe, optTransferStockToADept);
                break;
            case TRANSFER_TO_STAFF_ROOM:
                CommonHelperMethods.verifyIfDisplayed(driveR, optTransferToStaffRoom, optTransferStockToADept);
                break;
            case TRANSFER_TO_PHARMACY_TRIAL_ONLY:
                CommonHelperMethods.verifyIfDisplayed(driveR, optTransferToPharmacyTrialOnly, optTransferStockToADept);
                break;
            case TRANSFER_TO_MARKET_STREET_EAT_FRESH_TRIAL_ONLY:
                CommonHelperMethods.verifyIfDisplayed(driveR, optTransferToMarketStreetEatFreshTrialOnly, optTransferStockToADept);
                break;
            case TRANSFER_TO_MARKET_KITCHEN:
                CommonHelperMethods.verifyIfDisplayed(driveR, optTransferToMarketKitchen, optTransferStockToADept);
                break;

            default:
                log.error("No Such Menu Option : " + optTransferStockToADept);
                Assert.fail("No Such Menu Option : " + optTransferStockToADept);
        }
    }
}