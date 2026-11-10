package com.morrisons.sma.page_objects.mobile;

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


public class StockAdjustmentPO_New {

    public static final String ACTION_WASTE = "Action Waste";
    public static final String WASTE_VALIDATION = "Waste Validation";
    public static final String TRANSFER_STOCK_TO_A_DEPT = "Transfer Stock To A Dept";
    public static final String TRANSFER_BACK_FROM_A_DEPT = "Transfer Back From A Dept";
    public static final String OTHER_ADJUSTMENTS = "Other Adjustments";
    public static final String STORE_TO_STORE_TRANSFER = "Store To Store Transfer";
    private static AndroidDriver driveR;
    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;

    private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
    String env = applicationConfig.getWebElementEnviroment().getEnv();
    private final Logger log = Logger.getLogger(StockAdjustmentPO_New.class);


    public StockAdjustmentPO_New() {
        log.info("Inside : " + StockAdjustmentPO_New.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    /**
     * Web Elements
     */

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Action Waste']")
    public WebElement optActionWaste;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Wastage']")
    public WebElement optWastage;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Waste Validation']")
    public WebElement optWasteValidation;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Transfer Stock To A Dept']")
    public WebElement optTransferStockToADept;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Transfer Back From A Dept']")
    public WebElement optTransferBackFromADept;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Other Adjustments']")
    public WebElement optOtherAdjustments;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Store To Store Transfer']")
    public WebElement optStoreToStoreTransfer;


/** Protected Methods **/

	/*protected String getBrandXpath(String name){
		log.debug(name);
		return "//div[@id='facetFilterOptions']//label[contains(.,'" + name + "')]";
	}*/

    /**
     * Public Methods
     **/
    public void clickOnStockAdjustmentOption(String optStockAdjustments) {
        log.info("Clicking on Stock Adjustment Page Option : " + optStockAdjustments);
        switch (optStockAdjustments) {
            case "Wastage":
                selectOption(driveR, optWastage, optStockAdjustments);
                break;
            case "Action Waste":
                selectOption(driveR, optActionWaste, optStockAdjustments);
                break;
            case "Waste Validation":
                selectOption(driveR, optWasteValidation, optStockAdjustments);
                break;
            case "Transfer Stock To A Dept":
                selectOption(driveR, optTransferStockToADept, optStockAdjustments);
                break;
            case "Transfer Back From A Dept":
                selectOption(driveR, optTransferBackFromADept, optStockAdjustments);
                break;
            case "Other Adjustments":
                selectOption(driveR, optOtherAdjustments, optStockAdjustments);
                break;
            case "Store To Store Transfer":
                selectOption(driveR, optStoreToStoreTransfer, optStockAdjustments);
                break;
            default:
                log.error("No Such Menu Option : " + optStockAdjustments);
                Assert.fail("No Such Menu Option : " + optStockAdjustments);
        }
    }


    public void verifyOnStockAdjustmentOption(String optStockAdjustments) throws Throwable {
        log.info("Clicking on Stock Adjustment Page Option : " + optStockAdjustments);
        switch (optStockAdjustments) {
            case ACTION_WASTE:
                CommonHelperMethods.verifyIfDisplayed(driveR, optActionWaste, optStockAdjustments);
                break;
            case WASTE_VALIDATION:
                CommonHelperMethods.verifyIfDisplayed(driveR, optWasteValidation, optStockAdjustments);
                break;
            case TRANSFER_STOCK_TO_A_DEPT:
                CommonHelperMethods.verifyIfDisplayed(driveR, optTransferStockToADept, optStockAdjustments);
                break;
            case TRANSFER_BACK_FROM_A_DEPT:
                CommonHelperMethods.verifyIfDisplayed(driveR, optTransferBackFromADept, optStockAdjustments);
                break;
            case OTHER_ADJUSTMENTS:
                CommonHelperMethods.verifyIfDisplayed(driveR, optOtherAdjustments, optStockAdjustments);
                break;
            case STORE_TO_STORE_TRANSFER:
                CommonHelperMethods.verifyIfDisplayed(driveR, optStoreToStoreTransfer, optStockAdjustments);
                break;
            default:
                log.error("No Such Menu Option : " + optStockAdjustments);
                Assert.fail("No Such Menu Option : " + optStockAdjustments);
        }
    }

    public void verifyNotDisplayedOnStockAdjustmentOption(String optStockAdjustments) throws Throwable {
        log.info("Verifying  : " + optStockAdjustments);
        switch (optStockAdjustments) {
            case ACTION_WASTE:
                CommonHelperMethods.verifyIfNotDisplayed(driveR, optActionWaste, optStockAdjustments);
                break;
            case WASTE_VALIDATION:
                CommonHelperMethods.verifyIfNotDisplayed(driveR, optWasteValidation, optStockAdjustments);
                break;
            case TRANSFER_STOCK_TO_A_DEPT:
                CommonHelperMethods.verifyIfNotDisplayed(driveR, optTransferStockToADept, optStockAdjustments);
                break;
            case TRANSFER_BACK_FROM_A_DEPT:
                CommonHelperMethods.verifyIfNotDisplayed(driveR, optTransferBackFromADept, optStockAdjustments);
                break;
            case OTHER_ADJUSTMENTS:
                CommonHelperMethods.verifyIfNotDisplayed(driveR, optOtherAdjustments, optStockAdjustments);
                break;
            case STORE_TO_STORE_TRANSFER:
                CommonHelperMethods.verifyIfNotDisplayed(driveR, optStoreToStoreTransfer, optStockAdjustments);
                break;
            default:
                log.error("No Such Menu Option : " + optStockAdjustments);
                Assert.fail("No Such Menu Option : " + optStockAdjustments);
        }
    }

}
