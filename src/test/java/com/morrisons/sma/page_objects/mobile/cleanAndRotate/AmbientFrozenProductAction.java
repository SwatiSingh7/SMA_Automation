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


import static com.morrisons.common.helper.CommonHelperMethods.selectOption;

public class AmbientFrozenProductAction {

    private static AndroidDriver driveR;
    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 30;
    private final Logger log = Logger.getLogger(AmbientFrozenProductAction.class);
    String firstProductMin =null;

    public AmbientFrozenProductAction() {
        log.info("Inside : " + AmbientFrozenProductAction.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    /**
     * Web Elements
     */


    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'product_title')]")
    public WebElement productTitle;
    @FindBy(how = How.XPATH, using = "//android.widget.LinearLayout[contains(@resource-id,'product_min')]//android.widget.TextView[contains(@resource-id ,'value')]")
    public WebElement productMin;
    @FindBy(how = How.XPATH, using = "//android.widget.EditText[contains(@resource-id ,'edt_remain_qty')]")
    public WebElement quantityCount;

    @FindBy(how = How.XPATH, using = "//android.widget.CheckedTextView[@index='0']")
    public WebElement spinner;
    @FindBy(how = How.XPATH, using = "//android.widget.CheckedTextView[@text='Wastage']")
    public WebElement wastageAction;
    @FindBy(how = How.XPATH, using = "//android.widget.CheckedTextView[@text='No further action – Stock sold']")
    public WebElement noAction;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Wastage Reason']")
    public WebElement wastagePopupTitle;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Wastage is removed from stock on hand, once confirmed it will not be editable from the list.']")
    public WebElement wastagePopupmsg;
    @FindBy(how = How.XPATH, using = "//android.widget.CheckedTextView[@text='Waste - Out of Date']")
    public WebElement wastageCheck;
    @FindBy(how = How.XPATH, using = "//android.widget.CheckedTextView[@text='Charity - Out of Date']")
    public WebElement charityCheck;
    @FindBy(how = How.XPATH, using = "//android.widget.Button[@text='CANCEL']")
    public WebElement cancelBtn;
    @FindBy(how = How.XPATH, using = "//android.widget.Button[@text='CONFIRM']")
    public WebElement confrmBtn;
    @FindBy(how = How.XPATH, using = "//android.widget.Button[@text='ADD NEXT ACTION']")
    public WebElement nextActionButton;
    @FindBy(how = How.XPATH, using = "//android.widget.Spinner[contains(@resource-id ,'action_spinner')]")
    public WebElement actionSpinner;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Quantity Check']")
    public WebElement qtyAlertTitle;
    @FindBy(how = How.XPATH, using = "//android.widget.EditText[contains(@resource-id ,'edt_remain_qty')]")
    public WebElement qtyInput;

    /**
     * Public Methods
     **/

    public void verifyProductDetails() throws Throwable {
        log.info("Verifying Product details on Date code alerts page");
        CommonHelperMethods.verifyIfDisplayed(driveR, productTitle);
        String actualTitle = productTitle.getText();
        Assert.assertEquals(actualTitle,AmbientFrozenCodeAlert.productName, "Product title is mismatched");
        CommonHelperMethods.verifyIfDisplayed(driveR, productMin);
        firstProductMin = String.valueOf(AmbientFrozenCodeAlert.firstProductMin).replaceAll("(^\\h*)|(\\h*$)","");
        String actualProductMin = productMin.getText().replaceAll(" ","");
        Assert.assertEquals(actualProductMin,firstProductMin,"Product Min is mismatched");


    }

    public void enterItemQuantity(String qty) throws Throwable {
        quantityCount.clear();
        quantityCount.sendKeys(qty);
        driveR.hideKeyboard();
    }

    public void nextAcionClick() throws Throwable {
        nextActionButton.click();
    }

//    public void enterAction() throws Throwable {
//        spinner.click();
//        actionList.click();
//    }

    public void clickOnActionOption(String option) throws Throwable {
//        enterAction();
        log.info("Clicking on action Option : " + option);
        switch (option) {
            case "Wastage":
                selectOption(driveR, wastageAction, option);
                break;
            case "No further action – Stock sold":
                selectOption(driveR, noAction, option);
                break;
            default:
                log.error("No Such Menu Option : " + option);
                Assert.fail("No Such Menu Option : " + option);

        }

    }

    public void wastageReasonCodePopupvalidation() throws Throwable {
        log.info("Verifying WastageAlert");
        CommonHelperMethods.verifyIfDisplayed(driveR, wastagePopupTitle);
        CommonHelperMethods.verifyIfDisplayed(driveR, wastagePopupmsg);
        CommonHelperMethods.verifyIfDisplayed(driveR, charityCheck);
        CommonHelperMethods.verifyIfDisplayed(driveR, confrmBtn);
        CommonHelperMethods.verifyIfDisplayed(driveR, cancelBtn);
        CommonHelperMethods.verifyIfDisplayed(driveR, wastageCheck);
    }


    public void selectReasonCodeOption(String option) throws Throwable {
        log.info("Selecting reason code : " + option);
        switch (option) {
            case "Waste - Out of Date":
                selectOption(driveR, wastageCheck, option);
                break;
            case "Charity - Out of Date":
                selectOption(driveR, charityCheck, option);
                break;
            default:
                log.error("No Such Menu Option : " + option);
                Assert.fail("No Such Menu Option : " + option);

        }

    }

    public void clickOnConfrmButton() throws Throwable {
        log.info("Clicking on CONFIRM button");
        confrmBtn.click();

    }

    public void clickOnCnclButton() throws Throwable {
        log.info("Clicking on CONFIRM button");
        cancelBtn.click();

    }

    public void iClickOnSpinner(String actionOption) throws Throwable {
        actionSpinner.click();
        clickOnActionOption(actionOption);
    }

    public void iVerifyAlert() throws Throwable {
        qtyAlertTitle.isDisplayed();
       // clickOnCnclButton();
    }

    public void iVerifyAlertNotDisplayed() {
        CommonHelperMethods.verifyIfNotDisplayed(driveR,qtyAlertTitle,"Quantity Check");

    }

    public void verifyQtyboxDisabled() {
        CommonHelperMethods.verifyFieldIsDisabled(qtyInput);
    }
}







