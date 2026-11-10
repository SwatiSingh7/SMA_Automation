package com.morrisons.sma.page_objects.mobile.countOptimization;

import com.morrisons.common.action.Hook;
import com.morrisons.common.helper.MobileHelper;
import com.morrisons.sma.page_objects.mobile.cleanAndRotate.EnterMin;
import com.morrisons.sma.page_objects.mobile.cleanAndRotate.SelectDepartment;
import com.morrisons.sma.page_objects.mobile.items.EnterQuantityPO_New;
import com.morrisons.sma.page_objects.mobile.mins.EnterMINPO_New;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class OffShelf {
    private static AndroidDriver driveR;
    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    private final Logger log = Logger.getLogger(OffShelf.class);
    String enterProductMin;
    EnterMINPO_New enterMINPO_New = new EnterMINPO_New();
    EnterMin enterMin = new EnterMin();
    EnterQuantityPO_New enterQuantityPONew = new EnterQuantityPO_New();

    public OffShelf() {
        log.info("Inside : " + OffShelf.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    /**
     * Web Elements
     */

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'value')]")
    public List<WebElement> productMinList;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'product_count')]")
    public WebElement viewList;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Complete Off Shelf']")
    public WebElement compltOffshelfBttn;
    @FindBy(how = How.XPATH, using = "//android.widget.EditText[contains(@resource-id ,'quantityEditText')]")
    public WebElement productQty;
    @FindBy(how = How.XPATH, using = "//android.widget.Button[contains(@resource-id ,'confirmButton')]")
    public WebElement confirmQtyBttn;





    /**
     * Public Methods
     */

    public void iGetProductMinOffshelf() {
        log.info("Getting Action status and Quantity on UI");
        for (WebElement product : productMinList) {
            String productMin = product.getText();
            log.info("product list-----------------------------------------------------  ");

            log.info("product list  " + productMin);

        }
    }

    public void iEnterProductMinOffshelf(String prodMin) throws Throwable {
        enterMINPO_New.clickOnBarCodeIcon();
        enterProductMin = prodMin;
        log.info("Entering Product min : "+enterProductMin);
        enterMin.enterProductMin(enterProductMin);
    }
    public void iClickOnViewList(){
        viewList.click();

    }

    public void completeOffshelf() throws Throwable {
        Thread.sleep(5000);
        compltOffshelfBttn.click();
    }

    public void iEnterProductQtyOffshelf(String quantity) throws InterruptedException {
        Thread.sleep(5000);
        productQty.sendKeys(quantity);
        confirmQtyBttn.click();
        MobileHelper.hideKeyBoard(driveR);
    }
}