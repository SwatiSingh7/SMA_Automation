package com.morrisons.sma.page_objects.mobile.items;

import com.morrisons.common.action.Hook;
import com.morrisons.common.helper.CommonHelperMethods;
import com.morrisons.common.helper.MobileHelper;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class EnterQuantityPO_New {

    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    private static AndroidDriver driveR;

    private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
    String env = applicationConfig.getWebElementEnviroment().getEnv();
    private final Logger log = Logger.getLogger(EnterQuantityPO_New.class);


    public EnterQuantityPO_New() {
        log.info("Inside : " + EnterQuantityPO_New.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    /**
     * Web Elements
     */

    @FindBy(how = How.XPATH, using = "//android.widget.EditText[contains(@resource-id,'quantityEditText')]")
    public WebElement enterQuantityTextBox;

    @FindBy(how = How.XPATH, using = "//android.widget.EditText[contains(@resource-id,'markdown_quantity')]")
    public WebElement markdownQty;

//    @FindBy(how = How.XPATH, using = "//android.widget.EditText[@text='Enter Quantity'] and //android.widget.EditText[contains(@resource-id,'quantityEditText')]")
//    public WebElement enterQuantityTextBox;

    @FindBy(how = How.XPATH, using = "//android.widget.Button[@text='CONFIRM' or @text='Confirm']")
    public WebElement confirmButton;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'itemCountCalculation')]")
    public WebElement itemCountHeader;

    @FindBy(how = How.XPATH, using = "//android.widget.EditText[contains(@resource-id,'markdown_quantity')]")
    public WebElement quantityTextBox;

    @FindBy(how = How.XPATH, using = "//android.widget.EditText[contains(@resource-id,'edt_remain_qty')]")
    public WebElement quantityTextBoxCodeAlert;

    /** Protected Methods **/
  /*protected String getBrandXpath(String name){
		log.debug(name);
		return "//div[@id='facetFilterOptions']//label[contains(.,'" + name + "')]";
	}*/


    /**
     * Public Methods
     **/

    public void clickOnConfirmButton() throws Throwable {
        log.info("Clicking on Confirm Button");
        Thread.sleep(3000);
        //clickElement(driveR, confirmButton);
        confirmButton.click();
    }

    public void enterQuantity(String quantity) throws Throwable {
        log.info("Entering Quantity : " + quantity);
        Thread.sleep(3000);
        //enterText(enterQuantityTextBox,quantity);
        enterQuantityTextBox.sendKeys(quantity);
    }

    public void enterQuantityNConfirm(String quantity) throws Throwable {
        enterQuantity(quantity);
        clickOnConfirmButton();
        //HandleWarningPopup();
    }

    private void HandleWarningPopup() throws InterruptedException {
        try {
            WebElement oEle = driveR.findElement(By.xpath("//android.widget.CheckBox[@text = 'I Confirm']"));
            if (oEle.isDisplayed() && oEle.isEnabled()) {
                oEle.click();
                Thread.sleep(1000);
                driveR.findElement(By.xpath("//android.widget.Button[@text = 'YES']")).click();
                Thread.sleep(1000);
            }
        }
        catch(NoSuchElementException ne){

        }
    }

    public void enterProductQuantity(String quantity) throws Throwable {
        enterQuantity(quantity);
        MobileHelper.hideKeyBoard(driveR);
    }

    public void enterQty(String quantity) throws Throwable {
        log.info("Entering Quantity : " + quantity);
        Thread.sleep(3000);
        markdownQty.clear();
        markdownQty.sendKeys(quantity);
    }

    public void enterCnRQuantity(String quantity) throws Throwable {
        enterQty(quantity);
        MobileHelper.hideKeyBoard(driveR);
    }

    public void verifyItemMultiplyCount(String qty, String packSize) {
        log.info("Verifying item Count");
        String actual = itemCountHeader.getText();
        int cal = Integer.parseInt(qty) * Integer.parseInt(packSize); //36
        String expected = "x " + packSize + " = " + cal;
        System.out.println("Expected :" + expected.trim());
        System.out.println("Actual  : " + actual);
        CommonHelperMethods.verifyIfDisplayed(driveR, itemCountHeader, expected);
    }

    public void enterQtty(String quantity) {
        log.info("Entering quantity : " + quantity);
        quantityTextBox.sendKeys(quantity);
        MobileHelper.hideKeyBoard(driveR);
    }

    public void enterQuantityCodeAlert(String quantity) {
        log.info("Entering quantity : " + quantity);
        quantityTextBoxCodeAlert.sendKeys(quantity);
        MobileHelper.hideKeyBoard(driveR);
    }

}
