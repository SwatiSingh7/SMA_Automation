package com.morrisons.sma.page_objects.mobile.items;

import com.morrisons.common.action.Hook;
import com.morrisons.common.helper.CommonHelperMethods;
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

import static com.morrisons.common.helper.CommonHelperMethods.verifyIfDisplayed;

public class EnterPricePO_New {


        public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
        private static AndroidDriver driveR;

        private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
        String env = applicationConfig.getWebElementEnviroment().getEnv();
        private final Logger log = Logger.getLogger(EnterPricePO_New.class);

    public EnterPricePO_New() {
            log.info("Inside : " + EnterPricePO_New.class);
            this.driveR = (AndroidDriver) Hook.getDriver();
            PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'product_title')]")
    public WebElement productTitle;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='MIN:']")
    public WebElement minField;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='EAN: ']")
    public WebElement eanField;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'view_gtin_value')]")
    public WebElement eanValue;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Item Selling Price']")
    public WebElement priceField;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Enter Quantity']")
    public WebElement quantityField;

    @FindBy(how = How.XPATH, using = "//android.widget.EditText[contains(@resource-id,'et_price')]")
    public WebElement enterPriceTextBox;

    @FindBy(how = How.XPATH, using = "//android.widget.Button[@text='CONFIRM' or @text='Confirm']")
    public WebElement confirmButton;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'count_item_header')]")
    public WebElement title;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'count_item_desc')]")
    public WebElement message;

    @FindBy(how = How.XPATH, using = "//android.widget.EditText[contains(@resource-id,'et_price')]")
    public WebElement autoPrice;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'waste_validation_list_item_description')]")
    public WebElement prodName;



    public void verifyFieldsForKGItems()  {
        log.info("Verifying Product name field is displayed:");
        CommonHelperMethods.verifyIfDisplayed(driveR, productTitle );
        log.info("Verifying MIN field is displayed:");
        CommonHelperMethods.verifyIfDisplayed(driveR, minField );
        log.info("Verifying EAN field is displayed:");
        CommonHelperMethods.verifyIfDisplayed(driveR, eanField );
        log.info("Verifying Item Selling Price field is displayed:");
        CommonHelperMethods.verifyIfDisplayed(driveR, priceField );
    }

    public void verifyFieldsForEAItems() {
        log.info("Verifying Product name field is displayed:");
        CommonHelperMethods.verifyIfDisplayed(driveR, productTitle );
        log.info("Verifying MIN field is displayed:");
        CommonHelperMethods.verifyIfDisplayed(driveR, minField );
        log.info("Verifying EAN field is displayed:");
        CommonHelperMethods.verifyIfDisplayed(driveR, eanField );
        log.info("Verifying Enter Quantity field is displayed:");
        CommonHelperMethods.verifyIfDisplayed(driveR, quantityField );
    }

    public void enterProductPriceNConfirm(String prodPrice) throws Throwable {
        productPrice(prodPrice);
        clickOnConfirmButton();
    }

    public void productPrice(String prodPrice) {
        log.info("Entering Price : " + prodPrice);
        enterPriceTextBox.sendKeys(prodPrice);
    }

    public void clickOnConfirmButton() throws Throwable {
        log.info("Clicking on Confirm Button");
        confirmButton.click();
    }

    public void verifyTitleAndMessage(String msgTitle, String screenMsg) {
        verifyTitle(msgTitle);
        verifyMessage(screenMsg);
    }

    public void verifyTitle(String msgTitle) {
        log.info("Getting Message Title");
        String actualTitle = /*getText(driveR, title)*/title.getText();
        log.info("Verifying Message Title");
        Assert.assertEquals(actualTitle, msgTitle);
    }

    public void verifyMessage(String screenMsg) {
        log.info("Getting Message");
        String actualMessage = /*getText(driveR, successMessage)*/message.getText();
        log.info("Verifying Message");
        Assert.assertEquals(actualMessage, screenMsg);
    }

    public void verifyPricePopulated(String price) {
        log.info("Getting price populated on screen: ");
        String actualPrice = autoPrice.getText();
        log.info("Verifying auto-populated price: ");
        Assert.assertEquals(actualPrice, price);
    }

    public void verifyPriceDisabled() {
        CommonHelperMethods.verifyFieldIsDisabled(autoPrice);
    }

    public void verifyItemDisabled() {
        CommonHelperMethods.verifyFieldIsDisabled(prodName);
    }

    public void verifyButtonStatus(String button, String enableDisable) throws InterruptedException {
        CommonHelperMethods.verifyButtonStatus(confirmButton, enableDisable);
    }
}
