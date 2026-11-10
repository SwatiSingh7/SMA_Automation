package com.morrisons.sma.page_objects.mobile;

import static com.morrisons.common.helper.CommonHelperMethods.selectOption;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
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

public class CountsPO {

    private static AndroidDriver driveR;
    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
    String env = applicationConfig.getWebElementEnviroment().getEnv();
    private final Logger log = Logger.getLogger(StockAdjustmentPO_New.class);
    public String CountedProductsView = "//android.widget.TextView[@resource-id='ToReplace:id/product_count']~Xpath";
    public String WarehouseLocation = "//android.widget.TextView[@resource-id='ToReplace:id/scheduled_counts_department_name']~Xpath";
    public String Reviewlocation = "//android.widget.TextView[@resource-id='ToReplace:id/review_count_name']~Xpath";
    public String Confirm = "//android.widget.Button[@text='CONFIRM']~Xpath";
    public String Complete = "//android.widget.TextView[@resource-id='ToReplace:id/tv_count_value']~Xpath";
    public String CountedProductsView1 = "//android.widget.TextView[@resource-id='ToReplace:id/product_count']~Xpath";
    public String CountProduct = "//android.widget.TextView[@resource-id='ToReplace:id/scheduled_counts_product_name']~Xpath";
    public String EnterStockQty = "//android.widget.EditText[@resource-id='ToReplace:id/quantityEditText']~Xpath";
    public String EnterAddStockQty = "//android.widget.TextView[@resource-id='ToReplace:id/tv_count_value']~Xpath";
    public String sLocatorName = "//android.widget.TextView[@text='Locator']~Xpath";
    public String reviewStockQty = "//android.widget.TextView[@resource-id='ToReplace:id/locationLabel']~Xpath";
    public CountsPO() {
        log.info("Inside : " + CountsPO.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

//////// WEB ELEMENTS //////////

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Counts']")
    public WebElement countsMenu;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Review']")
    public WebElement reviewMenu;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Counts Summary']")
    public WebElement countsSummaryMenu;

    //@FindBy(how = How.XPATH, using = "//android.widget.LinearLayout//android.widget.TextView[@text='Locator']/following-sibling::android.widget.LinearLayout//android.widget.TextView[@text='Warehouse']")
    @FindBy(how = How.XPATH, using = "//android.widget.LinearLayout[@index='0']")
    public WebElement WarehouseParentLnk;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@content-desc='Enter barcode']")
    public WebElement Enter_barcode;

//    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@resource-id='com.morrisons.instore.ToReplace:id/scheduled_counts_department_name']")
//    public WebElement WarehouseLocation;
//
//    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@resource-id='ToReplace:id/review_count_name']")
//    public WebElement Reviewlocation;

    @FindBy(how = How.XPATH, using = "//android.widget.EditText[@text='Enter Quantity']")
    public WebElement quantity;

//    @FindBy(how = How.XPATH, using = "//android.widget.Button[@text='CONFIRM']")
//    public WebElement Confirm;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Complete Warehouse']")
    public WebElement CompleteBtn;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Complete Fixture']")
    public WebElement CompleteFixtureBtn;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Complete Petrol']")
    public WebElement CompletePetrolBtn;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Complete Off Shelf']")
    public WebElement CompleteOffShelfBtn;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Confirm']")
    public WebElement CompleteConfirmBtn;

//    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@resource-id='ToReplace:id/tv_count_value']")
//    public WebElement Complete;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='REVIEW']")
    public WebElement Review;

//    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@resource-id='ToReplace:id/product_count']")
//    public WebElement CountedProductsView;

//    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@resource-id='ToReplace:id/scheduled_counts_product_name']")
//    public WebElement CountProduct;

    @FindBy(how = How.XPATH, using = "//android.widget.Button[@text='Add To Count']")
    public WebElement AddCount;

    @FindBy(how = How.XPATH, using = "//android.widget.Button[@text='Edit Count']")
    public WebElement EditCount;

//    @FindBy(how = How.XPATH, using = "//android.widget.EditText[@resource-id='ToReplace:id/quantityEditText']")
//    public WebElement EnterStockQty;
//
//    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@resource-id='ToReplace:id/tv_count_value']")
//    public WebElement EnterAddStockQty;

    @FindBy(how = How.XPATH, using = "//android.widget.Button[@text='Add To Count']")
    public WebElement AddToCount;
    ////////Methods //////////
    public WebElement createObj(String sObjName) {
        WebElement oEle;
        switch (sObjName) {
            case "Warehouse":
                oEle = WarehouseParentLnk;
                break;
            case "Enter_barcode":
                oEle = Enter_barcode;
                break;
            default:
                oEle =  null;
                break;
        }
        if(oEle.toString().contains("ToReplace")){
            oEle = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/scheduled_counts_department_name']"));
        }
        return oEle;
    }
    public void clickOnCountsMenu(String countMenu) throws Throwable {
        log.info("Clicking on Counts Page Option : " + countMenu);
        switch (countMenu) {
            case "Counts":
                selectOption(driveR, countsMenu, countMenu);
                break;
            case "Review":
                selectOption(driveR, reviewMenu, countMenu);
                break;
            case "Counts Summary":
                selectOption(driveR, countsSummaryMenu, countMenu);
                break;
            default:
                log.error("No such Menu is present : " + countMenu);
                Assert.fail("No such Menu is present : " + countMenu);
        }
    }
}
