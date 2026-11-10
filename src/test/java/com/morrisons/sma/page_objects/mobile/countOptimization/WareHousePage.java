package com.morrisons.sma.page_objects.mobile.countOptimization;

import com.morrisons.common.action.Hook;
import com.morrisons.common.helper.CommonHelperMethods;
import com.morrisons.common.helper.MobileHelper;
import com.morrisons.sma.page_objects.mobile.cleanAndRotate.EnterMin;
import com.morrisons.sma.page_objects.mobile.cleanAndRotate.SelectDepartment;
import com.morrisons.sma.page_objects.mobile.items.EnterQuantityPO_New;
import com.morrisons.sma.page_objects.mobile.mins.EnterMINPO_New;
import com.morrisons.sma.step_definitions.mobile.cleanAndRotate.GetDeptAndMin;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class WareHousePage {
    private static AndroidDriver driveR;
    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    private final Logger log = Logger.getLogger(SelectDepartment.class);
    String enterProductMin;
    EnterMINPO_New enterMINPO_New = new EnterMINPO_New();
    EnterMin enterMin = new EnterMin();
    EnterQuantityPO_New enterQuantityPONew=new EnterQuantityPO_New();


    public WareHousePage() {
        log.info("Inside : " + WareHousePage.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'value')]")
    public List<WebElement> productMinList;
    @FindBy(how = How.XPATH, using = "//android.widget.EditText[contains(@resource-id ,'quantityEditText')]")
    public WebElement productQty;
    @FindBy(how = How.XPATH, using = "//android.widget.Button[contains(@resource-id ,'confirmButton')]")
    public WebElement confirmQtyBttn;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Complete Warehouse']")
    public WebElement complteWareHouseBttn;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'product_count')]")
    public WebElement viewList;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Reopen Location']")
    public WebElement reopenButton;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Are you sure you want to reopen this count location?']")
    public WebElement reopenAlert;
    @FindBy(how = How.XPATH, using = "//android.widget.Button[@text='CONFIRM']")
    public WebElement reopenConfirm;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'list_item_description')]")
    public WebElement productDesc;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='MIN:']")
    public WebElement productMIN;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='EAN:']")
    public WebElement productEAN;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Case Size:']")
    public WebElement productCase;




    public void iGetProductMins() throws InterruptedException {
        Thread.sleep(5000);
        log.info("Getting Action status and Quantity on UI");
        for (WebElement product : productMinList) {
            String productMin = product.getText();
            log.info("product list-----------------------------------------------------  ");

            log.info("product list  " + productMin);

        }

    }
//    public void iEnterProductMin(String prodMin) throws Throwable {
//        enterMINPO_New.clickOnBarCodeIcon();
//        enterProductMin = prodMin;
//        log.info("Entering Product min : "+enterProductMin);
//        enterMin.enterProductMin(enterProductMin);
//    }

    public void iEnterProductQty(String quantity) throws Throwable {
        Thread.sleep(5000);
        productQty.sendKeys(quantity);
        confirmQtyBttn.click();
        MobileHelper.hideKeyBoard(driveR);
    }
    public void completeWareHouse() throws Throwable {
        Thread.sleep(5000);
        complteWareHouseBttn.click();
    }
    public void clickOnViewList() throws Throwable {
        log.info("Clicking on View list");
        viewList.click();
    }

    public void verifyReopenLocation() {
        reopenButton.isDisplayed();
        reopenButton.click();
    }

    public void verifyReopenLocationAlert() {
        reopenAlert.isDisplayed();
        reopenConfirm.click();
    }

    public void verifyItemDetails() {
        CommonHelperMethods.verifyIfDisplayed(driveR,productCase);
        CommonHelperMethods.verifyIfDisplayed(driveR,productDesc);
        CommonHelperMethods.verifyIfDisplayed(driveR,productMIN);
        CommonHelperMethods.verifyIfDisplayed(driveR,productEAN);

    }
}
