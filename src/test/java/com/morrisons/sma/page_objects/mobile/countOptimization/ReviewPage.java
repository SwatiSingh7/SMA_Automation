package com.morrisons.sma.page_objects.mobile.countOptimization;

import com.morrisons.common.action.Hook;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class ReviewPage {
    private static AndroidDriver driveR;
    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    private final Logger log = Logger.getLogger(ScheduledCount.class);

    public ReviewPage() {
        log.info("Inside : " + ScheduledCount.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    /**
     * Web Elements
     */


    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='TO DO']")
    public WebElement toDoText;

    @FindBy(how = How.XPATH, using = "//android.widget.Button[@text='CONFIRM']")
    public WebElement confirmButton;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Fixture']")
    public WebElement fixtureText;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Petrol']")
    public WebElement petrolText;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='0 of 0']")
    public WebElement approvalCount;


    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'review_count_status')]")
    public WebElement reviewCountStatus;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'review_count_name')]")
    public WebElement reviewCountName;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'review_count_list_item_layout')]")
    public WebElement reviewCompleteCountName;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'scheduled_counts_product_name')]")
    public WebElement productDesc;

    @FindBy(how = How.XPATH, using = "//android.widget.EditText[contains(@resource-id ,'quantityEditText')]")
    public WebElement quantityEditText;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'locationText')]")
    public List<WebElement> productCaptureLocationList;




    public void approvalPending() {
        productDesc.isDisplayed();
    }

    public void approvalNotPending() throws InterruptedException {
        approvalCount.isDisplayed();

    }

    public void editCapture() {
       // productCaptureinWareHouse.click();

        for (WebElement product : productCaptureLocationList) {
            String productMin = product.getText();
            log.info("product list-----------------------------------------------------  ");

            log.info("product location list  " + productMin);
            if(product.getText().equalsIgnoreCase("Fixture")){
                product.click();
                quantityEditText.sendKeys("90");
                confirmButton.click();
            }

        }

        log.info("inside");


    }

    public void itemClick() {
        productDesc.click();
    }
}
