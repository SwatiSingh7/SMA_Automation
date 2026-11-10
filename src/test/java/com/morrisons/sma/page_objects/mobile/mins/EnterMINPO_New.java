package com.morrisons.sma.page_objects.mobile.mins;

import com.morrisons.common.action.Hook;
import com.morrisons.common.helper.CommonHelperMethods;
import com.morrisons.common.helper.MobileHelper;
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

public class EnterMINPO_New {

    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    private static AndroidDriver driveR;

    private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
    String env = applicationConfig.getWebElementEnviroment().getEnv();
    private final Logger log = Logger.getLogger(EnterMINPO_New.class);

    public EnterMINPO_New() {
        log.info("Inside : " + EnterMINPO_New.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    /**
     * Web Elements
     */

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'action_barcode_entry')]")
    public WebElement barCodeIcon;

    @FindBy(how = How.XPATH, using = "//android.widget.EditText[contains(@resource-id,'action_barcode_entry') or contains(@resource-id,'barcode_entry_edit_text')]")
    public WebElement enterBarCode;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'topBarText')]")
    public WebElement caseScannedHeader;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='109706998']")
    public WebElement barCodeValue;
/** Protected Methods **/

	/*protected String getBrandXpath(String name){
		log.debug(name);
		return "//div[@id='facetFilterOptions']//label[contains(.,'" + name + "')]";
	}*/

    /**
     * Public Methods
     **/

    public void clickOnBarCodeIcon() throws Throwable {
        log.info("Clicking on Enter Barcode Icon");
        //clickElement(driveR, barCodeIcon);
        Thread.sleep(2000);
        barCodeIcon.click();
    }

    public void enterMIMID(String minID) throws Throwable {
        //enterText(enterBarCode,minID);
        enterBarCode.sendKeys(minID);
    }

    public void clickOnMobileSearch() throws Throwable {
        log.info("Clicking on Search");
        Thread.sleep(2000);
        MobileHelper.clickSearch(driveR);
        Thread.sleep(3000);
    }

    public void searchBarcode(String minID) throws Throwable {
        clickOnBarCodeIcon();
        enterMIMID(minID);
        clickOnMobileSearch();
    }
    public void caseScannedHeaderVerification() throws Throwable {
        log.info("Verifying case Scanned header..");
        CommonHelperMethods.verifyIfDisplayed(driveR, caseScannedHeader);
        Thread.sleep(3000);
    }
    public void verifyMinAgainstBarCode(String expectedMin) throws Throwable {
        log.info("Verifying MIN Id against entered Barcode..");
        CommonHelperMethods.verifyIfDisplayed(driveR, barCodeValue, expectedMin);
    }












}
