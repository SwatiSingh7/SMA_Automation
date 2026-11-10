package com.morrisons.sma.page_objects.mobile.stockAdjustment;

import com.morrisons.common.action.Hook;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class StoreToStoreTransferPO_New {
    public static AndroidDriver driveR;
    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    public static String productName = null;

    private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
    String env = applicationConfig.getWebElementEnviroment().getEnv();
    private final Logger log = Logger.getLogger(StoreToStoreTransferPO_New.class);

    public StoreToStoreTransferPO_New() {
        log.info("Inside : " + StoreToStoreTransferPO_New.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    /**
     * Web Elements
     */


    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'storeIdTextView')]")
    public WebElement StoreIdText;


    /**
     * Public Methods
     **/
    public void clickOnStore()
    {
        StoreIdText.click();
    }

}
