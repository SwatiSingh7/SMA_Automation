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


public class TransferBackFromADeptPO_New {

    public static final String RETURN_FROM_BAKERY = "Return from Bakery";
    public static final String RETURN_FROM_CAKE_SHOP = "Return from Cake Shop";
    public static final String RETURN_FROM_DELI = "Return from Deli";
    public static final String RETURN_FROM_FISH = "Return from Fish";
    public static final String RETURN_FROM_FRESH_TO_GO = "Return from Fresh To Go";
    public static final String RETURN_FROM_MEAT = "Return from Meat";
    public static final String RETURN_FROM_OVEN_BAKED = "Return from Oven Baked";
    public static final String RETURN_FROM_PIE_SHOP = "Return from Pie Shop";
    public static final String RETURN_FROM_CAFE = "Return from Cafe";
    public static final String RETURN_FROM_STAFF_ROOM = "Return from Staff Room";
    public static final String RETURN_FROM_PHARMACY_TRIAL_ONLY = "Return from Pharmacy (TRIAL ONLY)";
    public static final String RETURN_FROM_MARKET_STREET_EAT_FRESH_TRIAL_ONLY = "Return from Market Street Eat Fresh (TRIAL ONLY)";
    public static final String TRANSFER_FROM_MARKET_KITCHEN = "Transfer from Market Kitchen";


    public static AndroidDriver driveR;
    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    public static String productName = null;

    private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
    String env = applicationConfig.getWebElementEnviroment().getEnv();
    private final Logger log = Logger.getLogger(TransferBackFromADeptPO_New.class);

    public TransferBackFromADeptPO_New() {
        log.info("Inside : " + TransferBackFromADeptPO_New.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }


    /**
     * Web Elements
     */

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Return from Bakery']")
    public WebElement optReturnFromBakery;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Return from Cake Shop']")
    public WebElement optReturnFromCakeShop;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Return from Deli']")
    public WebElement optReturnFromDeli;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Return from Fish']")
    public WebElement optReturnFromFish;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Return from Fresh To Go']")
    public WebElement optReturnFromFreshToGo;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Return from Meat']")
    public WebElement optReturnFromMeat;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Return from Oven Baked']")
    public WebElement optReturnFromOvenBaked;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Return from Pie Shop']")
    public WebElement optReturnFromPieShop;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Return from Cafe']")
    public WebElement optReturnFromCafe;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Return from Staff Room']")
    public WebElement optReturnFromStaffRoom;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Return from Pharmacy (TRIAL ONLY)']")
    public WebElement optReturnFromPharmacyTrialOnly;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Return from Market Street Eat Fresh (TRIAL ONLY)']")
    public WebElement optReturnFromMarketStreetEatFreshTrialOnly;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Transfer from Market Kitchen']")
    public WebElement optTransferFromMarketKitchen;


    /**
     * Public Methods
     **/


    public void clickOnTransferBackFromADeptOptions(String optTransferBackFromADept) {
        log.info("Clicking on Transfer Stock To A Dept Page Option : " + optTransferBackFromADept);
        switch (optTransferBackFromADept) {
            case "Return from Bakery":
                selectOption(driveR, optReturnFromBakery, optTransferBackFromADept);
                break;
            case "Return from Cake Shop":
                selectOption(driveR, optReturnFromCakeShop, optTransferBackFromADept);
                break;
            case "Return from Deli":
                selectOption(driveR, optReturnFromDeli, optTransferBackFromADept);
                break;
            case "Return from Fish":
                selectOption(driveR, optReturnFromFish, optTransferBackFromADept);
                break;
            case "Return from Fresh To Go":
                selectOption(driveR, optReturnFromFreshToGo, optTransferBackFromADept);
                break;
            case "Return from Meat":
                selectOption(driveR, optReturnFromMeat, optTransferBackFromADept);
                break;
            case "Return from Oven Baked":
                selectOption(driveR, optReturnFromOvenBaked, optTransferBackFromADept);
                break;
            case "Return from Pie Shop":
                selectOption(driveR, optReturnFromPieShop, optTransferBackFromADept);
                break;
            case "Return from Cafe":
                selectOption(driveR, optReturnFromCafe, optTransferBackFromADept);
                break;
            case "Return from Staff Room":
                selectOption(driveR, optReturnFromStaffRoom, optTransferBackFromADept);
                break;
            case "Return from Pharmacy (TRIAL ONLY)":
                selectOption(driveR, optReturnFromPharmacyTrialOnly, optTransferBackFromADept);
                break;
            case "Return from Market Street Eat Fresh (TRIAL ONLY)":
                selectOption(driveR, optReturnFromMarketStreetEatFreshTrialOnly, optTransferBackFromADept);
                break;
            case "Transfer from Market Kitchen":
                selectOption(driveR, optTransferFromMarketKitchen, optTransferBackFromADept);
                break;
            default:
                log.error("No Such Menu Option : " + optTransferBackFromADept);
                Assert.fail("No Such Menu Option : " + optTransferBackFromADept);
        }
    }

    public void verifyOnTransferBackFromADeptOption(String optTransferBackFromADept) throws Throwable {
        log.info("Clicking on Transfer Stock To A Dept Page Option : " + optTransferBackFromADept);
        switch (optTransferBackFromADept) {
            case RETURN_FROM_BAKERY:
                CommonHelperMethods.verifyIfDisplayed(driveR, optReturnFromBakery, optTransferBackFromADept);
                break;
            case RETURN_FROM_CAKE_SHOP:
                CommonHelperMethods.verifyIfDisplayed(driveR, optReturnFromCakeShop, optTransferBackFromADept);
                break;
            case RETURN_FROM_DELI:
                CommonHelperMethods.verifyIfDisplayed(driveR, optReturnFromDeli, optTransferBackFromADept);
                break;
            case RETURN_FROM_FISH:
                CommonHelperMethods.verifyIfDisplayed(driveR, optReturnFromFish, optTransferBackFromADept);
                break;
            case RETURN_FROM_FRESH_TO_GO:
                CommonHelperMethods.verifyIfDisplayed(driveR, optReturnFromFreshToGo, optTransferBackFromADept);
                break;
            case RETURN_FROM_MEAT:
                CommonHelperMethods.verifyIfDisplayed(driveR, optReturnFromMeat, optTransferBackFromADept);
                break;
            case RETURN_FROM_OVEN_BAKED:
                CommonHelperMethods.verifyIfDisplayed(driveR, optReturnFromOvenBaked, optTransferBackFromADept);
                break;
            case RETURN_FROM_PIE_SHOP:
                CommonHelperMethods.verifyIfDisplayed(driveR, optReturnFromPieShop, optTransferBackFromADept);
                break;
            case RETURN_FROM_CAFE:
                CommonHelperMethods.verifyIfDisplayed(driveR, optReturnFromCafe, optTransferBackFromADept);
                break;
            case RETURN_FROM_STAFF_ROOM:
                CommonHelperMethods.verifyIfDisplayed(driveR, optReturnFromStaffRoom, optTransferBackFromADept);
                break;
            case RETURN_FROM_PHARMACY_TRIAL_ONLY:
                CommonHelperMethods.verifyIfDisplayed(driveR, optReturnFromPharmacyTrialOnly, optTransferBackFromADept);
                break;
            case RETURN_FROM_MARKET_STREET_EAT_FRESH_TRIAL_ONLY:
                CommonHelperMethods.verifyIfDisplayed(driveR, optReturnFromMarketStreetEatFreshTrialOnly, optTransferBackFromADept);
                break;
            case TRANSFER_FROM_MARKET_KITCHEN:
                CommonHelperMethods.verifyIfDisplayed(driveR, optTransferFromMarketKitchen, optTransferBackFromADept);
                break;

            default:
                log.error("No Such Menu Option : " + optTransferBackFromADept);
                Assert.fail("No Such Menu Option : " + optTransferBackFromADept);
        }
    }
}