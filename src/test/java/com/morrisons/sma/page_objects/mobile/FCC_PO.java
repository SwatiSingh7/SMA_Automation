package com.morrisons.sma.page_objects.mobile;

import com.morrisons.common.action.Hook;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import static com.morrisons.common.helper.CommonHelperMethods.selectOption;

public class FCC_PO {

        private static AndroidDriver driveR;
        public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
        private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
        String env = applicationConfig.getWebElementEnviroment().getEnv();
        private final Logger log = Logger.getLogger(StockAdjustmentPO_New.class);
        public String sDeptList = "//android.widget.TextView[@resource-id='ToReplace:id/department_title']~Xpath";

    public FCC_PO() {
        log.info("Inside : " + FCC_PO.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

//////// WEB ELEMENTS //////////

        @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Counts']")
        public WebElement countsMenu;




}
