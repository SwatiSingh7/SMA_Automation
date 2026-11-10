package com.morrisons.sma.page_objects.mobile.cleanAndRotate;

import com.morrisons.common.action.Hook;
import com.morrisons.common.helper.CommonHelperMethods;
import com.morrisons.sma.step_definitions.service.cleanAndRotate.ItemServiceStepDef;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

public class DepartmentDetails {
    private static AndroidDriver driveR;
    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    private final Logger log = Logger.getLogger(FrozenClearenceBayPage.class);
    public static String actionStatus = null;
    public static String productMinvalue = null;

    ItemServiceStepDef itemServiceStepDef;

    public DepartmentDetails() {
        log.info("Inside : " + DepartmentDetails.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    /**
     * Web Elements
     */

    @FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[contains(@resource-id ,'product_header')]")
    public WebElement productHeader;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'value')]")
    public WebElement scanDate;
//    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Scan or manually enter barcode to add products expiring before the next check']")
//    public WebElement scanningInstructions;
   @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Expiry:']")
    public WebElement expiryLbl;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Action:']")
    public WebElement actionLbl;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'singleItemTitle')]")
    public WebElement singleItemTitle;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'list_item_quantity_value')]")
    public WebElement actionPerformed;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'list_item_min')]")
    public WebElement productMin;


    /**
     * Public Methods
     **/
    public void verifyTitleAndMsg() throws Throwable {
        log.info("Verifying Titles and messages");
        CommonHelperMethods.verifyIfDisplayed(driveR, productHeader);
       // CommonHelperMethods.verifyIfDisplayed(driveR, scanningInstructions);

    }

    public void iGetActionAndQuantity() {
        log.info("Getting Action status and Quantity on UI");
        actionStatus = actionPerformed.getText();
        actionStatus = actionStatus.replaceAll("\\s", "");
        log.info("Action status on UI : "+actionStatus);
         productMinvalue = productMin.getText();
        productMinvalue = productMinvalue.replaceAll("\\s", "");
        log.info("productMinvalue on UI : "+productMinvalue);

    }

    public void iVerifyActionAndQuantity() {
        log.info("Verifying Action status and Quantity on UI--------------------");
        String actionPerformed = itemServiceStepDef.actionPerformed;
        actionPerformed = actionPerformed.replaceAll("\\s", "");
        log.info("Action status recieved from API :" + itemServiceStepDef.actionPerformed);
        Assert.assertEquals(actionStatus, actionPerformed, "Action status is mismatched on UI and service");
    }
}
