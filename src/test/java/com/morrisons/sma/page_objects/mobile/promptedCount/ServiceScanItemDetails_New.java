package com.morrisons.sma.page_objects.mobile.promptedCount;

import com.morrisons.common.action.Hook;
import com.morrisons.common.utility.ApplicationContext;
import com.morrisons.sma.step_definitions.service.internalAudit.OrderServiceStepDef;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServiceScanItemDetails_New {
    private static AndroidDriver driveR;
    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    private final Logger log = Logger.getLogger(ServiceScanItemDetails_New.class);
    public static String actionStatus = null;
    public ApplicationContext applicationContext;

    OrderServiceStepDef orderServiceStepDef = new OrderServiceStepDef(applicationContext);


    public ServiceScanItemDetails_New() {
        log.info("Inside : " + AmbientFrozenItemDetails_New.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    /**
     * Web Elements
     */

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'value')]")
    public WebElement productMinText;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'lastDeliveryDateValue')]")
    public WebElement lastDeliveryDateValue;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'nextDeliveryDateValue')]")
    public WebElement nextDeliveryDateValue;
    @FindBy(how = How.XPATH, using = "//android.widget.EditText[contains(@resource-id ,'quantityEditText')]")
    public WebElement quantityValue;

    /**
     * Public methods
     */
    public void verifyDeliveryStatus(String productMin) throws ParseException {
        log.info("Verifying Produc Min and last order date on UI--------------------");
        String productMinValue = productMinText.getText();
        Assert.assertEquals(productMinValue, productMin, "Product is mismatched");

        String lastDeliveryDate = lastDeliveryDateValue.getText();
        String nextDeliveryDate = nextDeliveryDateValue.getText();

        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatter.parse(lastDeliveryDate);
        log.info("lastOrderDte" + lastDeliveryDate);

        SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");
        String lastDateString = newFormat.format(date);
        log.info("getting LastOrder Date from UI: " + lastDateString);

        String lastOrderDateFromService = orderServiceStepDef.lastDeliveryDate;
        log.info("serviceDate recieved from API :" + lastOrderDateFromService);
        Assert.assertEquals(lastDateString, lastOrderDateFromService, "Last delivery date is mismatched on UI and service");

//        Date nextOrderDate = formatter.parse(nextDeliveryDate);
//        String nextDateString = newFormat.format(nextOrderDate);
//        String nextOrderDateFromService = orderServiceStepDef.nextDeliveryDate;
//        log.info("serviceDate recieved from API :" + nextOrderDateFromService);
//        Assert.assertEquals(nextDateString, nextOrderDateFromService, "Next delivery date is mismatched on UI and service");

    }


}
