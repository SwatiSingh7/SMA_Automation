package com.morrisons.sma.page_objects.mobile.stockInformation;


import com.morrisons.common.helper.MobileHelper;
import com.morrisons.sma.step_definitions.service.ProductServiceStepDefs_New;
import com.morrisons.sma.step_definitions.service.internalAudit.OrderServiceStepDef;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.morrisons.common.action.Hook;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import com.morrisons.sma.page_objects.mobile.items.SubmitListPO_New;

import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class ProductDetailsPO {

    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    private static AndroidDriver driveR;

    private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
    private final Logger log = Logger.getLogger(ProductDetailsPO.class);
    OrderServiceStepDef orderServiceStepDef;
    ProductServiceStepDefs_New productServiceStepDefs ;
    static String lastOrderDte,nxtOrderDateText;
    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");


    public ProductDetailsPO() {
        log.info("Inside : " + SubmitListPO_New.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);

    }

    ////Web Elements

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'product_title')]")
    public WebElement productTitle;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Case:']")
    public WebElement caseLabel;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Case:']//android.widget.TextView[contains(@resource-id,'value']")
    public WebElement caseValue;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='UoM:']")
    public WebElement uomLabel;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='UoM:']//android.widget.TextView[contains(@resource-id,'value']")
    public WebElement uomValue;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='MIN:']")
    public WebElement minLabel;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='MIN:']//android.widget.TextView[contains(@resource-id,'value']")
    public WebElement minValue;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='EAN:']")
    public WebElement eanLabel;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='EAN:']//android.widget.TextView[contains(@resource-id,'value']")
    public WebElement eanValue;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'last_order_text_view')]")
    public WebElement lastOrderDate;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'last_qty_text_view')]")
    public WebElement lastOrderQuantity;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'next_order_text_view')]")
    public WebElement nxtOrderDate;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'next_qty_text_view')]")
    public WebElement nxtOrderQty;



    ////Methods

    public void iVerifyLastOrderDate() throws ParseException {
        log.info("Verifying last order date and Quantity on UI : ");
        lastOrderDte = lastOrderDate.getText();
        Date date = formatter.parse(lastOrderDte);
        SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");
        String finalString = newFormat.format(date);
        log.info("Getting LastOrder Date from UI: " + finalString);
        String lastOrderDateFromService = orderServiceStepDef.lastDeliveryDate;
        log.info("Getting last order date recieved from API :" + lastOrderDateFromService);
        Assert.assertEquals(finalString, lastOrderDateFromService, "Last delivery date is mismatched on UI and service");
    }

    public void iVerifyNextOrderDate() throws ParseException {
        log.info("Verifying next order status and Quantity on UI : ");
        nxtOrderDateText = nxtOrderDate.getText();
        Date date = formatter.parse(nxtOrderDateText);
        log.info("NextOrder Date : " + nxtOrderDateText);
        SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");
        String nextDateString = newFormat.format(date);
        log.info("getting Next Order Date from UI: " + nextDateString);
        String nextOrderDateFromService = orderServiceStepDef.nextDeliveryDate;
        log.info("Next order date recieved from API :" + nextOrderDateFromService);
        Assert.assertEquals(nextDateString, nextOrderDateFromService, "Next delivery date is mismatched on UI and service");
    }


    public void iVerifyLastOrderQuantity() {
        log.info("Verifying last order Quantity on UI and Service : ");
        int lastOrderQty = Integer.parseInt(lastOrderQuantity.getText());
        log.info("Getting LastOrder quantity from UI: " + lastOrderQty);
        int lastOrderQtyFromService = (productServiceStepDefs.packQuantity * orderServiceStepDef.orderQty);
        log.info("Getting LastOrder quantity from API :" + lastOrderQtyFromService);
        Assert.assertEquals(lastOrderQty, lastOrderQtyFromService, "Last order quantity is mismatched on UI and service");

    }

    public void iVerifyNextOrderQuantity() {
        log.info("Verifying Next order Quantity on UI and Service : ");
        int nextOrderQty = Integer.parseInt(nxtOrderQty.getText());
        log.info("getting LastOrder quantity from UI: " + nextOrderQty);
        int nextOrderQtyFromService = (productServiceStepDefs.packQuantity * orderServiceStepDef.nxtOrderQty);
        log.info(" getting LastOrder quantity from API :" + nextOrderQtyFromService);
        Assert.assertEquals(nextOrderQty, nextOrderQtyFromService, "Next order quantity is mismatched on UI and service");

    }


    public void scrollDown() throws Throwable {
        log.info("Scrolling down on Stock Information page");
        Thread.sleep(20);
        MobileHelper.scroll(driveR, 500, 1515, 500, 500);

    }


}