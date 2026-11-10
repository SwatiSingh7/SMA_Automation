package com.morrisons.sma.page_objects.mobile;

import com.morrisons.common.action.Hook;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static com.morrisons.common.helper.CommonHelperMethods.selectOption;

public class StockInformationPO {


    private static AndroidDriver driveR;
    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;

    private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
    String env = applicationConfig.getWebElementEnviroment().getEnv();
    private final Logger log = Logger.getLogger(StockAdjustmentPO_New.class);


    public StockInformationPO() {
        log.info("Inside : " + StockInformationPO.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    ////////WEB ELEMENTS //////////


    //// Price Section

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Price']")
    public WebElement priceLabel;

    @FindBy(how = How.XPATH, using = "//android.widget.ImageView[contains(@resource-id,'promo_price_info_icon')]")
    public WebElement priceInfoIcon;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'promo_price_value')]")
    public WebElement priceValue;

    ////Stock Section

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Stock']")
    public WebElement stockLabel;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Stock Record']")
    public WebElement stockRecordLabel;

    @FindBy(how = How.XPATH, using = "//android.widget.ImageView[contains(@resource-id,'stock_info_icon')]")
    public WebElement stockInfoIcon;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'stock_on_hand_value')]")
    public WebElement stockOnHandValue;

    ////Last capture Section

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Last Capture (within 3 days)']")
    public WebElement lastCaptureLabel;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Capture Type']")
    public WebElement captureTypeLabel;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'capture_type_text_view')]")
    public WebElement captureType;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Date']")
    public WebElement dateLabel;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'date_text_view')]")
    public WebElement capturDate;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='User']")
    public WebElement userLabel;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'user_text_view')]")
    public WebElement userText;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Counted']")
    public WebElement countedLabel;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'qty_text_view')]")
    public WebElement countedQuantity;

    ////Range Status

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Range Status:']")
    public WebElement rangeStatusLabel;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'status_value')]")
    public WebElement rangeStatus;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Effective:']")
    public WebElement effectiveLabel;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Effective:']//android.widget.TextView[contains(@resource-id,'from_date_value']")
    public WebElement effectiveDate;

    ////Space Section

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Space']")
    public WebElement spaceLabel;

    @FindBy(how = How.XPATH, using = "//android.widget.ImageView[contains(@resource-id,'space_info_icon')]")
    public WebElement spaceInfoIcon;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Planned']")
    public WebElement plannedLabel;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'planned_text_view')]")
    public WebElement plannedText;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Promotion']")
    public WebElement promotionLabel;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'promotion_text_view')]")
    public WebElement promotionText;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Store Stock Build']")
    public WebElement storeStockBuildLabel;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'store_stock_build_text_view')]")
    public WebElement storeStockText;

    ////Deliveries Section

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Deliveries']")
    public WebElement deliveriesLabel;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Last Del Date']")
    public WebElement lastDelDateLabel;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'last_order_text_view')]")
    public WebElement lastOrderText;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Ordered Qty']")
    public WebElement orderedQtyLabel;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'last_qty_text_view')]")
    public WebElement orderedQtyText;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Del Qty']")
    public WebElement delQtyLabel;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'picked_qty_text_view')]")
    public WebElement delQtyText;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Next Del Date']")
    public WebElement nextDelDateLabel;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'next_order_text_view')]")
    public WebElement nextDelDateText;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Next Order Qty']")
    public WebElement nextOrderLabel;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'next_qty_text_view')]")
    public WebElement nextOrderQtyText;


    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='High Fat Sugar Salt']")
    public WebElement HFSSFrameView;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='VIEW']")
    public WebElement HFSSViewButton;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='High Fat Sugar and Salt product']")
    public WebElement HFSSmessage1;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='High Fat Sugar and Salt products are not permitted to be displayed in \"Red Zone\" areas around the store. These can include:']")
    public WebElement HFSSmessage2;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Store Entrance(s)']")
    public WebElement HFSSmessage3;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Checkouts & Kiosk']")
    public WebElement HFSSmessage4;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Other Queuing Areas such as Petrol or \n" +
            "Self Scan']")
    public WebElement HFSSmessage5;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Promotional Ends']")
    public WebElement HFSSmessage6;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Discretional Space']")
    public WebElement HFSSmessage7;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Ranged Ends']")
    public WebElement HFSSmessage8;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Please speak to a Manager for further information.']")
    public WebElement HFSSmessage9;

    ////////Methods //////////

    public void clickOnStockOption(String optionStockInformation) throws Throwable {
        log.info("Clicking on Stock Information Page Option : " + optionStockInformation);
        switch (optionStockInformation) {
            case "Price":
                selectOption(driveR, priceLabel, optionStockInformation);
                break;
            case "Stock":
                selectOption(driveR, stockLabel, optionStockInformation);
                break;
            case "Last Capture (within 3 days)":
                selectOption(driveR, lastCaptureLabel, optionStockInformation);
                break;
            case "Space":
                selectOption(driveR, spaceLabel, optionStockInformation);
                break;
            case "Deliveries":
                selectOption(driveR, deliveriesLabel, optionStockInformation);
                break;
            default:
                log.error("No Such Option : " + optionStockInformation);
                Assert.fail("No Such Option : " + optionStockInformation);
        }
    }

    public void verifyRangeStatus(String expectedRangeStatus) throws Throwable {
        String actualRangeStatus = /*getText(driveR, rangeStatus)*/rangeStatus.getText();
        log.info("Verifying Range Status");
        Assert.assertEquals(actualRangeStatus, expectedRangeStatus);
    }


    public void verifyHFSSFlag() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driveR,30);
        try {
            HFSSFrameView.isDisplayed();
        }catch(StaleElementReferenceException staleElementReferenceException)
        {
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(HFSSFrameView)));
            //wait.until(ExpectedConditions.stalenessOf(HFSSFrameView));
        }
    }

    public void clickHFSSView() throws Throwable {
        HFSSViewButton.click();
    }

    public void verifyHFSSmessage() throws Throwable {
        HFSSmessage1.isDisplayed();
        HFSSmessage2.isDisplayed();
        HFSSmessage3.isDisplayed();
        HFSSmessage4.isDisplayed();
        HFSSmessage5.isDisplayed();
        HFSSmessage6.isDisplayed();
        HFSSmessage7.isDisplayed();
        HFSSmessage8.isDisplayed();
        HFSSmessage9.isDisplayed();
    }



}
