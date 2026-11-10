package com.morrisons.sma.page_objects.mobile.cleanAndRotate;

import com.morrisons.common.action.Hook;
import com.morrisons.common.helper.CommonHelperMethods;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class CnRMarkdownAction {

    private static AndroidDriver driveR;
    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    private final Logger log = Logger.getLogger(CnRMarkdownAction.class);

    public CnRMarkdownAction() {
        log.info("Inside : " + DepartmentDetails.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    /**
     * Web Elements
     */

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'noPrinterAvailable')]")
    public WebElement noPrinterAvailable;

    @FindBy(how = How.XPATH, using = "//android.widget.Button[@text='ADD TO PRINT QUEUE' or @text='Add To Print Queue' or @text='SAVE CHANGES' or @text='Save Changes']")
    public WebElement addToPrintQueue;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Item Summary']")
    public WebElement itemSummary;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Edit Item']")
    public WebElement editSummaryPage;


    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'product_title')]")
    public WebElement productTitle;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'value')]")
    public WebElement minValue;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'original_price_label')]")
    public WebElement originalPriceLabel;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'original_price')]")
    public WebElement originalPrice;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'discount_label')]")
    public WebElement discountLabel;

    @FindBy(how = How.XPATH, using = "//android.widget.Spinner[contains(@resource-id,'markdown_percentage_spinner')]")
    public WebElement discountDropdown;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'new_price_title')]")
    public WebElement newPriceTitle;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'new_price_label')]")
    public WebElement newPriceLabel;

    @FindBy(how = How.XPATH, using = "//android.widget.EditText[contains(@resource-id,'markdown_price_editable')]")
    public WebElement newPriceEdit;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'markdown_quantity_label')]")
    public WebElement markdownQuantityLabel;


    @FindBy(how = How.XPATH, using = "//android.widget.EditText[contains(@resource-id,'markdown_quantity')]")
    public WebElement markdownQuantity;

    @FindBy(how = How.XPATH, using = "//android.widget.EditText[contains(@resource-id,'markdown_price_fixed')]")
    public WebElement newPrice;



    ///// Methods

    public void clickOnNoPrinterAvailable()throws Throwable {
        log.info("Clicking on No printer available");
        noPrinterAvailable.click();
    }

    public void clickOnAddToPrintQueue()throws Throwable {
        log.info("Clicking on ADD TO PRINT QUEUE");
        addToPrintQueue.click();
    }

    public String VerifyItemDetailsInSummary() throws Throwable {
        log.info("Verifying Item details in Summary page");
        boolean summaryPage = true;
        String pageName = null;

        try {
            pageName = itemSummary.getText();
        } catch (Exception e) {
            summaryPage = false;
            pageName = editSummaryPage.getText();
        }
        if (summaryPage) {
            CommonHelperMethods.verifyIfDisplayed(driveR,productTitle);
            CommonHelperMethods.verifyIfDisplayed(driveR,minValue);
            CommonHelperMethods.verifyIfDisplayed(driveR,originalPriceLabel);
            CommonHelperMethods.verifyIfDisplayed(driveR,originalPrice);
            CommonHelperMethods.verifyIfDisplayed(driveR,discountLabel);
            CommonHelperMethods.verifyIfDisplayed(driveR,discountDropdown);
            CommonHelperMethods.verifyIfDisplayed(driveR,newPriceLabel);
            CommonHelperMethods.verifyIfDisplayed(driveR,newPriceEdit);
            CommonHelperMethods.verifyIfDisplayed(driveR,markdownQuantityLabel);
            CommonHelperMethods.verifyIfDisplayed(driveR,markdownQuantity);
        }

        else {
            CommonHelperMethods.verifyIfDisplayed(driveR,productTitle);
            CommonHelperMethods.verifyIfDisplayed(driveR,minValue);
            CommonHelperMethods.verifyIfDisplayed(driveR,originalPriceLabel);
            CommonHelperMethods.verifyIfDisplayed(driveR,originalPrice);
            CommonHelperMethods.verifyIfDisplayed(driveR,newPriceTitle);
            CommonHelperMethods.verifyIfDisplayed(driveR,newPrice);
            CommonHelperMethods.verifyIfDisplayed(driveR,markdownQuantityLabel);
            CommonHelperMethods.verifyIfDisplayed(driveR,markdownQuantity);
        }
        return pageName;
    }

}
