package com.morrisons.sma.page_objects.mobile.countOptimization;

import com.morrisons.common.action.Hook;
import com.morrisons.common.helper.CommonHelperMethods;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import java.util.List;

import static com.morrisons.common.helper.CommonHelperMethods.selectOption;

public class CountOptimizationHomePage {
    private static AndroidDriver driveR;
    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    private final Logger log = Logger.getLogger(CountOptimizationHomePage.class);

    public CountOptimizationHomePage() {
        log.info("Inside : " + CountOptimizationHomePage.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    /**
     * Web Elements
     */

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Stock Management Applications']")
    public WebElement stockMngmtText;
   @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Intelligent Replenishment']")
    public WebElement intelligentReplenishmentText;
   @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Stock Adjustments']")
    public WebElement stockAdjustmentText;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Stock Information']")
    public WebElement stockInformationText;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Code Checking']")
    public WebElement codeCheckingText;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Price Integrity']")
    public WebElement priceIntegrityText;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'toolbar_title')]")
    public WebElement toolBarText;


    /**
     * Public Methods
     */

    public void verifyCountOptimizationHomePage() throws Throwable {
        log.info("Verifying Home page");
//       CommonHelperMethods.verifyIfDisplayed(driveR, intelligentReplenishmentText);
        CommonHelperMethods.verifyIfDisplayed(driveR, stockMngmtText);
        CommonHelperMethods.verifyIfDisplayed(driveR, stockAdjustmentText);
        CommonHelperMethods.verifyIfDisplayed(driveR, codeCheckingText);
        CommonHelperMethods.verifyIfDisplayed(driveR, priceIntegrityText);
        CommonHelperMethods.verifyIfDisplayed(driveR, stockInformationText);
        CommonHelperMethods.verifyIfDisplayed(driveR, toolBarText);
    }

    public void clickOnCOHomePageOption(String option) throws Throwable {

        log.info("Clicking on Count Optimization Home Page Option : " + option);
        switch (option) {
            case "Stock Management Applications":
                selectOption(driveR, stockMngmtText, option);
                break;
            case "Intelligent Replenishment":
              selectOption(driveR, intelligentReplenishmentText, option);
                break;
            case "Stock Adjustments":
                selectOption(driveR, stockAdjustmentText, option);
                break;
            case "Stock Information":
                selectOption(driveR, stockInformationText, option);
                break;
            case "Code Checking":
                selectOption(driveR, codeCheckingText, option);
                break;
            case "Price Integrity":
                selectOption(driveR, priceIntegrityText, option);
                break;

            default:
                log.error("No Such Menu Option : " + option);
                Assert.fail("No Such Menu Option : " + option);

        }


    }
}
