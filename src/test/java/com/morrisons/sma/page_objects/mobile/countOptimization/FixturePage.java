package com.morrisons.sma.page_objects.mobile.countOptimization;

import com.morrisons.common.action.Hook;
import com.morrisons.common.helper.CommonHelperMethods;
import com.morrisons.common.helper.MobileHelper;
import com.morrisons.sma.page_objects.mobile.cleanAndRotate.EnterMin;
import com.morrisons.sma.page_objects.mobile.mins.EnterMINPO_New;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class FixturePage {
    private static AndroidDriver driveR;
    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    private final Logger log = Logger.getLogger(FixturePage.class);
    String enterProductMin;
    EnterMINPO_New enterMINPO_New = new EnterMINPO_New();
    EnterMin enterMin = new EnterMin();

    public FixturePage() {
        log.info("Inside : " + WareHousePage.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'value')]")
    public List<WebElement> productMinList;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'product_count')]")
    public WebElement viewList;
    @FindBy(how = How.XPATH, using = "//android.widget.Button[@text='Add To Count']")
    public WebElement addCountButton;
    @FindBy(how = How.XPATH, using = "//android.widget.Button[contains(@resource-id,'btn_edit_count')]")
    public WebElement editCountButton;

    @FindBy(how = How.XPATH, using = "//android.widget.ImageView[contains(@resource-id,'delete_button')]")
    public WebElement deleteBttn;


    @FindBy(how = How.XPATH, using = "//android.widget.EditText[contains(@resource-id ,'quantityEditText')]")
    public WebElement productQty;
    @FindBy(how = How.XPATH, using = "//android.widget.Button[contains(@resource-id ,'confirmButton')]")
    public WebElement confirmQtyBttn;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Complete Fixture']")
    public WebElement complteFixtureBttn;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'message')]")
    public WebElement deleteAlert;
    @FindBy(how = How.XPATH, using = "//android.widget.Button[contains(@resource-id ,'button1')]")
    public WebElement confirmBttn;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Aisle:']")
    public WebElement aisleText;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Bay:']")
    public WebElement bayText;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Shelf:']")
    public WebElement shelfText;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Position:']")
    public WebElement petrolText;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='value']")
    public WebElement productDesc;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='AM Scan Count 1 Cross scanning']")
    public WebElement countNameinHeader;


    public void completeFixture() {
        complteFixtureBttn.click();
    }

    public void iGetProductMinsinFixture() {
        log.info("Getting Action status and Quantity on UI");
        for (WebElement product : productMinList) {
            String productMin = product.getText();
            log.info("product list-----------------------------------------------------  ");

            log.info("product list  " + productMin);

        }

    }
    public void iEnterProductQtyinFixture(String quantity) throws Throwable {
        Thread.sleep(5000);
        productQty.sendKeys(quantity);
        confirmQtyBttn.click();
        MobileHelper.hideKeyBoard(driveR);
    }

    public void iClickOnViewList(){
        viewList.click();

    }

    public void verifyUpdateCountisible(){
        CommonHelperMethods.verifyFieldIsDisabled(editCountButton);
        CommonHelperMethods.verifyFieldIsDisabled(addCountButton);

    }
    public void clickOnAddCount(){
    addCountButton.click();
    }

    public void editCount(){
        editCountButton.click();
    }

    public void updateQuantity(String qty){
        productQty.sendKeys(qty);
        confirmQtyBttn.click();
        MobileHelper.hideKeyBoard(driveR);


    }
    public void deleteCapture(){
        deleteBttn.click();

    }
    public void deleteAlertDisplayed(){
        deleteAlert.isDisplayed();
        confirmBttn.click();

    }

    public void iGetProductDetailsinFixture() {
        CommonHelperMethods.verifyIfDisplayed(driveR,aisleText);
        CommonHelperMethods.verifyIfDisplayed(driveR,bayText);
        CommonHelperMethods.verifyIfDisplayed(driveR,productDesc);
        CommonHelperMethods.verifyIfDisplayed(driveR,shelfText);
        CommonHelperMethods.verifyIfDisplayed(driveR,petrolText);

    }

    public void VerifyItemNotDisplayed(String barcode) {

        log.info(barcode);
        for (WebElement product : productMinList) {
            String productMin = product.getText();
            log.info("product list-----------------------------------------------------  ");

            log.info("product list  " + productMin);

            if(productMin.equalsIgnoreCase(barcode)){

                log.info("match");
               Assert.assertEquals(productMin,barcode);
            }

        }
    }

    public void verifyCountName(String countName) {
       String countNameText=countNameinHeader.getText();
        Assert.assertEquals(countNameText,countName);

    }
}
