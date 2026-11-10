package com.morrisons.sma.page_objects.mobile.stockAdjustment;

import com.morrisons.common.action.Hook;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import java.time.Duration;

import static com.morrisons.common.helper.CommonHelperMethods.selectOption;
import static com.morrisons.common.helper.CommonHelperMethods.verifyIfDisplayed;

public class OtherAdjustmentsPO {

    private static AndroidDriver driveR;
    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;

    private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
    String env = applicationConfig.getWebElementEnviroment().getEnv();
    private final Logger log = Logger.getLogger(OtherAdjustmentsPO.class);


    public OtherAdjustmentsPO() {
        log.info("Inside : " + OtherAdjustmentsPO.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    ////////WEB ELEMENT //////////

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Delisted Waste']")
    public WebElement delistedWaste;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Delisted Charity']")
    public WebElement delistedCharity;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='In Store Use']")
    public WebElement inStoreUse;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='In Store Use – Reverse' or @text='In Store Use - Reverse']")
    public WebElement inStoreUseReverse;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Record Insurance Loss']")
    public WebElement recordInsuranceLoss;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Insurance Loss Reverse']")
    public WebElement insuranceLossReverse;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Fridge Breakdown']")
    public WebElement fridgeBreakdown;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Breakdown Reverse']")
    public WebElement breakdownReverse;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Non M Forecourt Transfer']")
    public WebElement nonMForecourtTranfer;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Non M Forecourt Reversal']")
    public WebElement nonMForecourtReversal;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='In-Store Tasting (TRIAL ONLY)']")
    public WebElement inStoreTasting;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='In-Store Tasting Reversal (TRIAL ONLY)']")
    public WebElement inStoreTastingReversal;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Free Fruits for Kids Reversal']")
    public WebElement freeFruitsForKids;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Electrical Return (TRIAL ONLY)']")
    public WebElement electricalReturn;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Electrical Return Reversal (TRIAL ONLY)']")
    public WebElement electricalReturnReversal;

    ///////Methods //////////

    public void clickOnReasonCodes(String reasonCodes) throws Throwable {
        log.info("Clicking on Other Adjustments Page Option : " + reasonCodes);
        switch (reasonCodes) {
            case "Delisted Waste":
                selectOption(driveR, delistedWaste, reasonCodes);
                break;
            case "Delisted Charity":
                selectOption(driveR, delistedCharity, reasonCodes);
                break;
            case "In Store Use":
                selectOption(driveR, inStoreUse, reasonCodes);
                break;
            case "In Store Use - Reverse":
                selectOption(driveR, inStoreUseReverse, reasonCodes);
                break;
            case "Record Insurance Loss":
                selectOption(driveR, recordInsuranceLoss, reasonCodes);
                break;
            case "Insurance Loss Reverse":
                selectOption(driveR, insuranceLossReverse, reasonCodes);
                break;
            case "Fridge Breakdown":
                selectOption(driveR, fridgeBreakdown, reasonCodes);
                break;
            case "Breakdown Reverse":
                selectOption(driveR, breakdownReverse, reasonCodes);
                break;
            case "Non M Forecourt Transfer":
                selectOption(driveR, nonMForecourtTranfer, reasonCodes);
                break;
            case "Non M Forecourt Reversal":
                selectOption(driveR, nonMForecourtReversal, reasonCodes);
                break;
            case "In-Store Tasting (TRIAL ONLY)":
                selectOption(driveR, inStoreTasting, reasonCodes);
                break;
            case "In-Store Tasting Reversal (TRIAL ONLY)":
                selectOption(driveR, inStoreTastingReversal, reasonCodes);
                break;
            case "Free Fruits for Kids Reversal":
                selectOption(driveR, freeFruitsForKids, reasonCodes);
                break;
            case "Electrical Return (TRIAL ONLY)":
                selectOption(driveR, electricalReturn, reasonCodes);
                break;
            case "Electrical Return Reversal (TRIAL ONLY)":
                selectOption(driveR, electricalReturnReversal, reasonCodes);
                break;
            default:
                log.error("No such Reason code present : " + reasonCodes);
                Assert.fail("No such Reason code present : " + reasonCodes);
        }
    }

    public void verifyReasonCode() throws Throwable {
        log.info("Verifying Reason codes on Other Adjustments page");

        verifyIfDisplayed(driveR, delistedWaste, "Delisted Waste");
        verifyIfDisplayed(driveR, delistedCharity, "Delisted Charity");
        verifyIfDisplayed(driveR, inStoreUse, "In Store Use");
        verifyIfDisplayed(driveR, inStoreUseReverse, "In Store Use - Reverse");
        verifyIfDisplayed(driveR, recordInsuranceLoss, "Record Insurance Loss");
        verifyIfDisplayed(driveR, insuranceLossReverse, "Insurance Loss Reverse");
        verifyIfDisplayed(driveR, fridgeBreakdown, "Fridge Breakdown");
        verifyIfDisplayed(driveR, breakdownReverse, "Breakdown Reverse");
        verifyIfDisplayed(driveR, nonMForecourtTranfer, "Non M Forecourt Transfer");
        verifyIfDisplayed(driveR, nonMForecourtReversal, "Non M Forecourt Reversal");
        TouchAction ts = new TouchAction(driveR);
        ts.press(PointOption.point(350, 1515)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(300, 390)).release().perform();

        verifyIfDisplayed(driveR, inStoreTasting, "In-Store Tasting (TRIAL ONLY)");
        verifyIfDisplayed(driveR, inStoreTastingReversal, "In-Store Tasting Reversal (TRIAL ONLY)");
        verifyIfDisplayed(driveR, freeFruitsForKids, "Free Fruits for Kids Reversal");
        verifyIfDisplayed(driveR, electricalReturn, "Electrical Return (TRIAL ONLY)");
        verifyIfDisplayed(driveR, electricalReturnReversal, "Electrical Return Reversal (TRIAL ONLY)");
    }
}