package com.morrisons.sma.page_objects.mobile.MOCO;
import com.morrisons.common.action.Hook;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import com.morrisons.sma.page_objects.mobile.StockAdjustmentPO_New;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import java.util.List;

import static com.morrisons.common.helper.CommonHelperMethods.selectOption;
public class ManagerOrderPage {
    private static AndroidDriver driveR;
    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
    String env = applicationConfig.getWebElementEnviroment().getEnv();
    private final Logger log = Logger.getLogger(StockAdjustmentPO_New.class);
    public String sObjectName = "//android.widget.TextView[normalize-space(@text)='Locator']~Xpath";

    public String oProductDtls = "//android.widget.TextView[contains(@resource-id,'Locator')]~Xpath";
    public String sTabName = "//android.view.View[contains(@text,'Locator')]~Xpath";
    public String ScanScreen = "//android.view.View[@text='Locator']~Xpath";
    public String ScanImage = "//android.widget.Image[@text='scan_instructions-CDN0pgwq']~Xpath";
    public String CameraIcon = "//android.widget.Button[@index='0']~Xpath";
    public String BackBtn = "//android.widget.Button[@index='0']~Xpath";

    public String errorMsg1 = "//android.widget.TextView[@index='1']~Xpath";
    public String errorMsg2 = "//android.widget.TextView[@index='2']~Xpath";

    public String errorMsg = "//android.widget.TextView[@index='0']~Xpath";

    public String Orders = "//android.widget.TextView[contains(@text,'Locator')]~Xpath";

    public String oButton = "//android.widget.Button[@text='Locator']~Xpath";

    public String CREATE_ORDER = "//android.widget.Button[@text='CREATE ORDER']~Xpath";

    public String sLocatorName = "//android.widget.Button[@text='Locator']~Xpath";

    public String ListItem = "//android.widget.RadioButton[contains(@text,'Locator')]~Xpath";

//    public String LstBarCodeEdit = "//android.widget.EditText[@index='0']~Xpath";

    public String Datebtn = "//android.view.View//android.widget.TextView[contains(@text,'Locator')]/following::android.view.View/android.widget.TextView[@index='0']~Xpath";

   //    public String BarCodeBtn = "//android.widget.Button[contains(@text,'Barcode scan image')]~Xpath";
    public ManagerOrderPage() {
        log.info("Inside : " + com.morrisons.sma.page_objects.mobile.MOCO.ManagerOrderPage.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

 @FindBy(how = How.XPATH, using = "//android.widget.Button[contains(@text,'Barcode scan')]")
   public WebElement BarCodeBtn;

   @FindBy(how = How.XPATH, using = "//android.widget.EditText[@index='0']")
   public WebElement BarCodeEdit;

    @FindBy(how = How.XPATH, using = "//android.widget.EditText[@index='0']")
    public List<WebElement> LstBarCodeEdit;

    @FindBy(how = How.XPATH, using = "//android.view.View//android.widget.TextView[contains(@text,'Start Date')]/following::android.view.View/android.widget.Image[@index='1']")
    public WebElement startDateBtn;

    @FindBy(how = How.XPATH, using = "//android.view.View//android.widget.TextView[contains(@text,'End Date')]/following::android.view.View/android.widget.Image[@index='1']")
    public WebElement EndDateBtn;

    @FindBy(how = How.XPATH, using = "//android.view.View//android.widget.TextView[contains(@text,'Instore Date')]/following::android.view.View/android.widget.Image[@index='1']")
    public WebElement InstoreDateBtn;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@text,'MIN:')]")
    public WebElement Orders1;

    @FindBy(how = How.XPATH, using = "//android.widget.EditText[@index='0']")
    public WebElement QuantityEdt;

    @FindBy(how = How.XPATH, using = "//android.widget.Button[@text='Sort by:, Start Date']")
    public WebElement SortByDropDwn;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='All Other Orders']/parent::android.view.View[@index='2']/following-sibling::android.widget.ListView//android.widget.ListView[resource-id='productDetails']")
    public WebElement OrderList;

}
