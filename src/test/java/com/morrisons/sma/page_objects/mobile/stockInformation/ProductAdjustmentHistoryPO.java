package com.morrisons.sma.page_objects.mobile.stockInformation;

import com.morrisons.common.action.Hook;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import com.morrisons.sma.page_objects.mobile.items.SubmitListPO_New;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

public class ProductAdjustmentHistoryPO {

    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    private static AndroidDriver driveR;

    private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
    String env = applicationConfig.getWebElementEnviroment().getEnv();
    private final Logger log = Logger.getLogger(ProductAdjustmentHistoryPO.class);


    public ProductAdjustmentHistoryPO() {
        log.info("Inside : " + SubmitListPO_New.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    ////Web Elements

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Stock' or @text='Stock']")
    public WebElement stockLabel;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Stock Record' or @text='Stock Record']")
    public WebElement stockRecordLabel;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'tv_stock_on_hand_value')]")
    public WebElement stockOnHandValue;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'tv_day')]")
    public WebElement dayText;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'tvTime')]")
    public WebElement timeText;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'tv_stock_status')]")
    public WebElement stockStatus;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'tv_employee_name')]")
    public WebElement employeeName;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'tv_adjustment_count')]")
    public WebElement adjustmentCount;


    ////Methods

    public void getDayText() throws Throwable {
        //waitForElementVisible(driveR,dayText);
        dayText.isDisplayed();
        String actualDayText = /*getText(driveR, dayText)*/dayText.getText();
        log.info("Get Text");
        Assert.assertEquals(actualDayText, "Today");
    }

    public void getStockStatus(String expectedStockStatus) throws Throwable {
    	log.info("Verify Stock status is displayed");
    	boolean isDisplay =  driveR.findElement(By.xpath("//android.widget.TextView[contains(@text ="+expectedStockStatus+")]")).isDisplayed();
         Assert.assertEquals(isDisplay, true,"Stock status is not displayed");
    }

    public void getAdjustmentCount(String expectedCount) throws Throwable {
    	log.info("Verify Adjustment count is displayed");
      boolean isDisplay =  driveR.findElement(By.xpath("//android.widget.TextView[contains(@text ="+expectedCount+")]")).isDisplayed();
        Assert.assertEquals(isDisplay, true,"Adjustment count is not displayed");
    }

    public void verifyProductHistory(String expectedStockStatus,String expectedCount)  throws Throwable {
        getDayText();
        getStockStatus(expectedStockStatus);
        getAdjustmentCount(expectedCount);
    }

}