package com.morrisons.sma.page_objects.mobile;

import com.morrisons.common.action.Hook;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import static com.morrisons.common.helper.CommonHelperMethods.selectOption;

public class BaseClass {

        private static AndroidDriver driveR;
        public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
        private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
        String env = applicationConfig.getWebElementEnviroment().getEnv();
        private final Logger log = Logger.getLogger(StockAdjustmentPO_New.class);
        public String sLocatorName = "//android.widget.TextView[normalize-space(@text)='Locator']~Xpath";
        public BaseClass() {
            log.info("Inside : " + com.morrisons.sma.page_objects.mobile.CountsPO.class);
            this.driveR = (AndroidDriver) Hook.getDriver();
            PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
        }

//////// WEB ELEMENTS //////////

        @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Counts']")
        public WebElement countsMenu;
        @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'context_menu')]")
        public WebElement hotKeyOption;
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
}
