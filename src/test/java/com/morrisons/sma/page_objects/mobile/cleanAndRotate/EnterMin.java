package com.morrisons.sma.page_objects.mobile.cleanAndRotate;

import com.morrisons.common.action.Hook;
import com.morrisons.common.helper.MobileHelper;
import com.morrisons.sma.page_objects.mobile.mins.EnterMINPO_New;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class EnterMin {

    private static AndroidDriver driveR;
    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    private final Logger log = Logger.getLogger(EnterMin.class);
    EnterMINPO_New enterMINPO_New = new EnterMINPO_New();
    public EnterMin() {
        log.info("Inside : " + EnterMin.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    /**
     * Web Elements
     */

    @FindBy(how = How.XPATH, using = "//android.widget.EditText[contains(@resource-id,'barcode_entry_edit_text')]")
    public WebElement enterMin;

    public void enterProductMin(String productMin) throws Throwable {
        log.info("Entering the Product min");
        enterMINPO_New.clickOnBarCodeIcon();
        enterMin.sendKeys(productMin);
        MobileHelper.clickSearch(driveR);
        MobileHelper.checkSearch(driveR,enterMin);
    }
}
