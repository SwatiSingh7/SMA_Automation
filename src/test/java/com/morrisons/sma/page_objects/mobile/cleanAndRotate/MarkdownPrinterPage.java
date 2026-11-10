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

public class MarkdownPrinterPage {

    private static AndroidDriver driveR;
    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    private final Logger log = Logger.getLogger(MarkdownPrinterPage.class);


    public MarkdownPrinterPage() {
        log.info("Inside : " + MarkdownPrinterPage.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    /**
     * Web Elements
     */

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'action_barcode_entry')]")
    public WebElement enterPrinterBarcode;

    @FindBy(how = How.XPATH, using = "//android.widget.Button[@text='ADD TO PRINT QUEUE' or @text='Add To Print Queue' or @text='SAVE CHANGES' or @text='Save Changes']")
    public WebElement addToQueue;

    @FindBy(how = How.XPATH, using = "//android.widget.Button[@text ='PRINT' or @text ='Print']")
    public WebElement printButton;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'product_list_expanded_header_count')]")
    public WebElement listHeaderCount;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'markdown_list_item_description')]")
    public WebElement itemDescription;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'markdown_list_item_quantity')]")
    public WebElement itemQuantity;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'markdown_list_item_min')]")
    public WebElement itemMin;

    public void enterPrinterBarcode() throws Throwable {
        log.info("Enter Printer Barcode number");
        enterPrinterBarcode.click();
    }

    public void clickOnAddToQueue() throws Throwable {
        log.info("Clicking on Add to queue/Save changes button");
        addToQueue.click();
    }

    public void clickOnPrintButton() throws Throwable {
        log.info("Clicking on Print button");
        printButton.click();
    }

    public void verifyProducDetails() throws Throwable {
        log.info("Verifying Product details");
        CommonHelperMethods.verifyIfDisplayed(driveR,listHeaderCount);
        CommonHelperMethods.verifyIfDisplayed(driveR,itemDescription);
        CommonHelperMethods.verifyIfDisplayed(driveR,itemQuantity);
        CommonHelperMethods.verifyIfDisplayed(driveR,itemMin);
    }
}
