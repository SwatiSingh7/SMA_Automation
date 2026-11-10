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
import org.testng.Assert;

import java.util.List;

import static com.morrisons.common.helper.CommonHelperMethods.selectOption;

public class AmbientFrozenCodeAlert {

    private static AndroidDriver driveR;
    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    private final Logger log = Logger.getLogger(AmbientFrozenCodeAlert.class);
    public static String firstProductMin = null;
    public static String productName = null;

    public AmbientFrozenCodeAlert() {
        log.info("Inside : " + AmbientFrozenCodeAlert.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    /**
     * Web Elements
     */


    @FindBy(how = How.XPATH, using = "//android.widget.Spinner[contains(@resource-id ,'markdown_spinner')]")
    public WebElement alertList;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'product_name')]")
    public List<WebElement> productList;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'product_expiry')]")
    public List<WebElement> productExpiryDateList;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'product_min')]")
    public List<WebElement> productMinList;

    @FindBy(how = How.XPATH, using = "//android.widget.CheckedTextView[@text='All Alerts']")
    public WebElement allAlert;
    @FindBy(how = How.XPATH, using = "//android.widget.CheckedTextView[@text='1st Alerts']")
    public WebElement firstAlert;
    @FindBy(how = How.XPATH, using = "//android.widget.CheckedTextView[@text='Clearance Alerts']")
    public WebElement clearencAlert;


    /**
     * Public Methods
     **/
    public void clickOnProductList() throws Throwable {
        log.info("Clicking on Product list");
        for (WebElement product : productList) {
            productName = product.getText();
            log.info("Product Name : " + productName);
            product.click();
            break;
        }
    }

    public void verifyExpiryDate() throws Throwable {
        log.info("verifying on Product Expiry date");
        for (WebElement date : productExpiryDateList) {
            String productExpiryDate = date.getText();
            log.info("Product expiry details"+productExpiryDate);
            CommonHelperMethods.verifyIfDisplayed(driveR, date);

        }

    }

    public void verifyProductMin() throws Throwable {
        log.info("Verifying on Product Min list");
        try {
            if (productMinList.size() >= 1) {
                for (WebElement min : productMinList) {
                    firstProductMin = productMinList.get(0).getText().replaceAll(" ","").split("MIN:")[1].trim();
                    log.info("Product Min : " + firstProductMin);
                    String productMin = min.getText();
                    log.info("Product Min : " + productMin);
                    CommonHelperMethods.verifyIfDisplayed(driveR, min);
                }
            }
        }
        catch(Exception e){
            log.info("Products are not available");
        }

    }

    public void clickOnAlertList() throws Throwable {
        log.info("DropDown Clicked");
        Thread.sleep(5000);
        alertList.click();
    }

    public void verifyAlertType() throws Throwable {
        log.info("Verifying Alert Type");
        CommonHelperMethods.verifyIfDisplayed(driveR, allAlert);
        CommonHelperMethods.verifyIfDisplayed(driveR, clearencAlert);
        CommonHelperMethods.verifyIfDisplayed(driveR, firstAlert);

    }


    public void clickOnAlertOption(String option) throws Throwable {
        log.info("Clicking on Alert Option : " + option);
        switch (option) {
            case "All Alerts":
                selectOption(driveR, allAlert, option);
                break;
            case "1st Alerts":
                selectOption(driveR, firstAlert, option);
                break;
            case "Clearance Alerts":
                selectOption(driveR, clearencAlert, option);
                break;
            default:
                log.error("No Such Menu Option : " + option);
                Assert.fail("No Such Menu Option : " + option);

        }
    }

}






