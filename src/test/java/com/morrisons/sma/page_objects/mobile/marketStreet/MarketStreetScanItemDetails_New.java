package com.morrisons.sma.page_objects.mobile.marketStreet;

import com.morrisons.common.action.Hook;
import com.morrisons.common.utility.ApplicationContext;
import com.morrisons.sma.step_definitions.service.ProductServiceStepDefs_New;
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

public class MarketStreetScanItemDetails_New {
    private static AndroidDriver driveR;
    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    public  ApplicationContext applicationContext;

    private final Logger log = Logger.getLogger(MarketStreetScanItemDetails_New.class);
    OrderServiceStepDef orderServiceStepDef =new OrderServiceStepDef(applicationContext);
    ProductServiceStepDefs_New productServiceStepDefs = new ProductServiceStepDefs_New(applicationContext);


    public MarketStreetScanItemDetails_New() {
        log.info("Inside : " + MarketStreetScanItemDetails_New.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'last_value_del_date')]")
    public WebElement lastOrderDate;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'value')]")
    public WebElement productMin;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'ordered_delivered_value')]")
    public WebElement lastOrderDelivrdQuantity;

    public void iVerifyLastOrderAndQuantity() throws ParseException {
        log.info("Verifying last order status and Quantity on UI : ");
        String lastOrderDte= lastOrderDate.getText();
        String lastOrderDelivrdQuantityValue = lastOrderDelivrdQuantity.getText();
        log.info("splitting ordered deliver value from UI :"+lastOrderDelivrdQuantityValue);
        String[] orderedDeliveredQty = lastOrderDelivrdQuantityValue.split("/");
        String orderedQty = orderedDeliveredQty[0];
        String deliveredQty = orderedDeliveredQty[1];
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatter.parse(lastOrderDte);
        log.info("lastOrderDte"+lastOrderDte);

        SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");
        String finalString = newFormat.format(date);

        log.info("getting LastOrder Date from UI: "+ finalString);
        String lastOrderDateFromService = orderServiceStepDef.lastDeliveryDate;

        log.info("serviceDate recieved from API :" + lastOrderDateFromService);
        Assert.assertEquals(finalString, lastOrderDateFromService, "Last order date is mismatched on UI and service");
        String lastOrderQtyFromService= Integer.toString(productServiceStepDefs.packQuantity * orderServiceStepDef.orderQty);

        log.info("lastOrderQtyFromService-------------------------------------"+lastOrderQtyFromService);

       // String orderQtyFromService = Integer.toString(orderServiceStepDef.orderQty);
        lastOrderQtyFromService = lastOrderQtyFromService.replaceAll("\\s","");
        orderedQty=orderedQty.replaceAll("\\s","");

        log.info("lastOrderQtyFromService"+lastOrderQtyFromService);
        log.info("orderedQty--------------------------"+orderedQty);
        Assert.assertEquals(orderedQty, lastOrderQtyFromService, "Last order value is mismatched on UI and service");
    }

}
