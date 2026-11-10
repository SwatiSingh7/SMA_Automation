package com.morrisons.sma.page_objects.mobile.cleanAndRotate;

import com.morrisons.common.action.Hook;
import com.morrisons.common.helper.CommonHelperMethods;
import com.morrisons.common.helper.MobileHelper;
import com.morrisons.sma.step_definitions.mobile.cleanAndRotate.GetDeptAndMin;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static com.morrisons.common.helper.CommonHelperMethods.selectOption;

public class ActionLog {
    private static AndroidDriver driveR;
    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    private final Logger log = Logger.getLogger(ActionLog.class);

    public ActionLog() {
        log.info("Inside : " + ActionLog.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    /**
     * Web Elements
     */

    @FindBy(how = How.XPATH, using = "//android.widget.Spinner[contains(@resource-id ,'spinner_Actions')]")
    public WebElement actionSpinner;
    @FindBy(how = How.XPATH, using = "//android.widget.Spinner[contains(@resource-id ,'id/action_spinner')]")
    public WebElement actionSpinner_CodeAlert;
    @FindBy(how = How.XPATH, using = "//android.widget.Button[contains(@resource-id ,'btn_AddExpiringProduct')]")
    public WebElement logBttn;
    @FindBy(how = How.XPATH, using = "//android.widget.CheckedTextView[@text='Rotate To Front']")
    public WebElement rotateToFront;
    @FindBy(how = How.XPATH, using = "//android.widget.CheckedTextView[@text='Markdown']")
    public WebElement markdownOptn;
    @FindBy(how = How.XPATH, using = "//android.widget.CheckedTextView[@text='Wastage']")
    public WebElement wastageOptn;

    @FindBy(how = How.XPATH, using = "//android.widget.CheckedTextView[@text='Waste - Damaged']")
    public WebElement wastageDamaged;

    @FindBy(how = How.XPATH, using = "//android.widget.CheckedTextView[@text='Waste - Out of Date']")
    public WebElement wasteOutOfDate;

    @FindBy(how = How.XPATH, using = "//android.widget.CheckedTextView[@text='Charity - Damaged']")
    public WebElement charityDamaged;

    @FindBy(how = How.XPATH, using = "//android.widget.CheckedTextView[@text='Charity - Out of Date']")
    public WebElement charityOutOfDate;

    @FindBy(how = How.XPATH, using = "//android.widget.Button[@text='CONFIRM' or @text='Confirm']")
    public WebElement confirmButton;

    @FindBy(how = How.XPATH, using = "//android.widget.Button[@text='CANCEL' or @text='Cancel']")
    public WebElement cancelButton;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Wastage Reason']")
    public WebElement wastageReasonAlertTitle;

    @FindBy(how = How.XPATH, using = "//android.widget.ImageView[contains(@resource-id,'singleItemIcon')]")
    public WebElement viewList;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'list_item_min')]")
    public WebElement loggedMin;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'list_item_quantity_value')]")
    public WebElement loggedItemQuantity;

    @FindBy(how = How.XPATH, using = "//android.widget.EditText[contains(@resource-id,'edt_ExpiryDate')]")
    public WebElement calendarIcon;

    @FindBy(how = How.XPATH, using = "//android.widget.Button[@text='Done' or @text='OK']")
    public WebElement calendarConfirmBtn;

    @FindBy(how = How.XPATH, using = "//android.widget.EditText[@resource-id='android:id/numberpicker_input']")
    public WebElement calendarDate;

    @FindBy(how = How.XPATH, using = "//android.widget.EditText[@resource-id='android:id/numberpicker_input']")
    public List<WebElement> calendarAllDate;

    @FindBy(how = How.XPATH, using = "//android.widget.Button[@index='2']")
    public List<WebElement> lowerDatePicker;

    @FindBy(how = How.XPATH, using = "//android.widget.Button[@index='0']")
    public List<WebElement> upperDatePicker;

    @FindBy(how = How.XPATH, using = "//android.widget.ImageButton[@resource-id='android:id/next']")
    public WebElement calendarNextArrow;

    @FindBy(how = How.XPATH, using = "//android.widget.ImageButton[@resource-id='android:id/prev']")
    public WebElement calendarPrevArrow;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'android:id/message')]")
    public WebElement productLogAlert;
    @FindBy(how = How.XPATH, using = "//android.widget.Button[@text='OK']")
    public WebElement alertOkbutton;

    @FindBy(how = How.XPATH, using = "//android.widget.ImageView[contains(@resource-id,'delete_button_disabled')]")
    public WebElement deleteProductDisabled;
    @FindBy(how = How.XPATH, using = "//android.widget.ImageView[contains(@resource-id,'delete_button')]")
    public WebElement deleteProductButton;
    @FindBy(how = How.XPATH, using = "//android.widget.Button[@text='COMPLETE CODE ROTATE GROUP' or @text='Complete Code Rotate Group']")
    public WebElement completedCodeRotateBtn;
    @FindBy(how = How.XPATH, using = "//android.widget.Button[@text='RE-OPEN CODE ROTATE GROUP']")
    public WebElement reopenCodeRotateBtn;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Wastage is removed from stock on hand, once confirmed it will not be editable from the list.']")
    public WebElement wastageAlertMsg;


    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'list_item_min')]")
    public List<WebElement> allLoggedMin;

    /**
     * Public Methods
     **/
    public void clickOnLogProductButton() throws Throwable {
        log.info("Clicking on LOG PRODUCT");
        logBttn.click();

    }

    public void clickOnActionSpinner() throws Throwable {
        log.info("Clicking on Action spinner");
        actionSpinner.click();
    }

    public void clickOnActionSpinner_CodeAlert() throws Throwable {
        log.info("Clicking on Action spinner");
        actionSpinner_CodeAlert.click();
    }

    public void clickOnActionOption(String option) throws Throwable {

        log.info("Clicking on Action Option : " + option);
        switch (option) {
            case "Rotate To Front":
                selectOption(driveR, rotateToFront, option);
                break;
            case "Markdown":
                selectOption(driveR, markdownOptn, option);
                break;
            case "Wastage":
                selectOption(driveR, wastageOptn, option);
                break;
            default:
                log.error("No Such Menu Option : " + option);
                Assert.fail("No Such Menu Option : " + option);

        }

    }

    public void clickOnWastageOption(String option) throws Throwable {

        log.info("Clicking on Wastage Option : " + option);
        switch (option) {
            case "Waste - Damaged":
                selectOption(driveR, wastageDamaged, option);
                break;
            case "Waste - Out of Date":
                selectOption(driveR, wasteOutOfDate, option);
                break;
            case "Charity - Damaged":
                selectOption(driveR, charityDamaged, option);
                break;
            case "Charity - Out of Date":
                selectOption(driveR, charityOutOfDate, option);
                break;
            default:
                log.error("No Such Wastage Option : " + option);
                Assert.fail("No Such Wastage Option : " + option);

        }
    }

    public void clickOnConfirmButton() throws Throwable {
        log.info("Clicking on Confirm button");
        confirmButton.click();
    }

    public void verifyWastageReasonAlert() throws Throwable {
        log.info("Verifying Wastage reason code alert");
        CommonHelperMethods.verifyIfDisplayed(driveR, wastageReasonAlertTitle);
        CommonHelperMethods.verifyIfDisplayed(driveR, wastageAlertMsg);
        CommonHelperMethods.verifyIfDisplayed(driveR, confirmButton);
        CommonHelperMethods.verifyIfDisplayed(driveR, cancelButton);
    }

    public void verifyWastageReasonPopUp(String action) throws Throwable {
        log.info("Verifying Wastage reason code alert");
        CommonHelperMethods.verifyIfDisplayed(driveR, wasteOutOfDate);
        CommonHelperMethods.verifyIfDisplayed(driveR, charityOutOfDate);
    }

    public void clickOnViewList() throws Throwable {
        log.info("Clicking on View list");
        viewList.click();
    }

    public void verifyLoggedProductDetail(String expectedAction) throws Throwable {
        log.info("Verifying details on View list - Logged Product Min and Action");
        String actualAction = loggedItemQuantity.getText().replaceAll("\\d", "").trim();
        log.info("Actual action : " + actualAction);
        log.info("Expected action : " + expectedAction);
        Assert.assertEquals(actualAction, expectedAction, "Product logged message is mismatched");

        String expectedMin = GetDeptAndMin.productMin;
        String actualMin = loggedMin.getText().trim();
        Assert.assertEquals(actualMin, expectedMin, "Product logged Min is mismatched");

    }

    public void verifyLatestScanMin() throws Throwable {
        log.info("Verifying latest scan Product Min is visible at the top on View list screen");
        String expectedMin = GetDeptAndMin.productMin;
        String actualMin = allLoggedMin.get(0).getText().trim();
        Assert.assertEquals(actualMin, expectedMin, "Product logged Min is mismatched");
    }

    public void selectCurrentDate() throws Throwable {
        log.info("Selecting current date");
        calendarIcon.click();
        calendarConfirmBtn.click();
    }

    public void isAlertDisplayed(String expectedMessage) throws Throwable {
        log.info("Verifying alert is displayed");
        CommonHelperMethods.verifyIfDisplayed(driveR, productLogAlert, expectedMessage);
        alertOkbutton.click();
    }

    public void alertNotDisplayed() throws Throwable {
        log.info("Verifying alert is not displayed");
        CommonHelperMethods.verifyIfNotDisplayed(driveR, productLogAlert, "Product log Alert");
    }


    // Adding given days in current date and selecting the date
    public void selectDate(int addDays) throws Throwable {
        log.info("Selecting current date");
        calendarIcon.click(); //Clicking on Calendar Icon

        ///CT-50(Android version =4.4) and CT-60(Android version =9 or 10)
        //CT-50 and CT-60 devices have different Calendar UI. To handle Calendar in both the devices below code lines are added.
        boolean ct50_Device = true;

        try {
            calendarDate.isDisplayed();
        } catch (Exception e) {
            ct50_Device = false; // For CT 60 device, flag value will be false
        }

        LocalDateTime today = CommonHelperMethods.getCurrentDate(); // Storing current date
        LocalDateTime nextDay = today.plusDays(addDays);// Adding days in current date

        int date = nextDay.getDayOfMonth();
        log.info("Date " + date);// Getting Date
        Month month = nextDay.getMonth();
        log.info("Month " + month); // Getting Month
        int year = nextDay.getYear();
        log.info("Year " + year); // Getting Year

        // To set the Calendar format - If date is less than or equal to 9, then
        // adding '0' before the date.
        String date1 = null;
        if (date <= 9) {
            date1 = "0" + String.valueOf(date);
        } else {
            date1 = String.valueOf(date);
        }

        if (ct50_Device) // For CT 50 device Calendar
        {
            log.info("CT 50 device");
            try {
                while (upperDatePicker.get(2).isDisplayed()) {
                    int selectedYear = Integer.parseInt(calendarAllDate.get(2).getText());
                    if (year != selectedYear) {
                        upperDatePicker.get(2).click();
                    } else
                        break;
                }
            } catch (Exception e) {
                log.info(e.getMessage());
            }

            String expMonth = month.toString().substring(0, 3);
            //Creating Month in format. eg. Feb
            String expMonth1 = expMonth.charAt(0) + expMonth.substring(1, expMonth.length()).toLowerCase();

            while (lowerDatePicker.get(1).isDisplayed()) {
                if (!expMonth1.equals(calendarAllDate.get(1).getText())) {
                    lowerDatePicker.get(1).click();
                } else
                    break;
            }

            while (lowerDatePicker.get(0).isDisplayed()) {
                if (!date1.equals(calendarAllDate.get(0).getText())) {
                    lowerDatePicker.get(0).click();
                } else
                    break;
            }
        } else // For CT 60 device Calendar
        {
            log.info("CT 60 device");

            String m = month.toString(); // month is FEBRUARY
            //Creating Month in format. eg. February
            String mnth = m.charAt(0) + m.substring(1, m.length()).toLowerCase();

            //Creating Month in format. eg. 01 February 2022
            String selectDate = date1 + " " + mnth + " " + year;
            log.info("Select date : " + selectDate);

            // If date is not available in current month, clicking on Next arrow button

            for (int arrow = 0; arrow < 2; arrow++) {
                try {
                    Thread.sleep(2000);
                    driveR.findElement(By.xpath("//android.view.View[@content-desc='" + selectDate + "']"))
                            .isDisplayed();
                    break;
                } catch (Exception e) {
                    if(addDays<0) {
                        calendarPrevArrow.click();
                    }
                    else{
                        calendarNextArrow.click();
                    }
                }
            }
            Thread.sleep(2000);
            //Selecting Date from calendar
            driveR.findElement(By.xpath("//android.view.View[@content-desc='" + selectDate + "']")).click();
        }
        calendarConfirmBtn.click();
    }

    public void swipeLeft() throws Throwable {
        log.info("Swipe left on View list screen");
        MobileHelper.scroll(driveR, 884, 863, 0, 468);
    }

    public void verifyDeleteButtonStatus(String buttonStatus) throws Throwable {
        log.info("Verifying Delete Button is " + buttonStatus);
        switch (buttonStatus) {
            case "Enabled":
                String isEnabled = deleteProductButton.getAttribute("enabled");
                Assert.assertEquals(isEnabled, "true", "Button is not enabled");
                break;
            case "Disabled":
                String isClickable = deleteProductDisabled.getAttribute("clickable");
                Assert.assertEquals(isClickable, "false", "Button is clickable");
        }
    }

    public void clickOnDeleteButton() throws Throwable {
        log.info("Clicking on Delete button");
        deleteProductButton.click();
    }

    public void clickOnCompleteCodeRotate() throws Throwable {
        log.info("Clicking on Complete code Rotate button");
        CommonHelperMethods.verifyIfDisplayed(driveR, completedCodeRotateBtn);
        completedCodeRotateBtn.click();
        try {
            log.info("Clicking on Confirm button on Additional location popup");
            confirmButton.click();
        } catch (Exception e) {
            log.info("Additional location popup is not displayed for Scanned product");
        }
    }

    public void clickOnReopenCodeRotate() throws Throwable {
        log.info("Clicking on Reopen code Rotate button");
        CommonHelperMethods.verifyIfDisplayed(driveR, reopenCodeRotateBtn);
        reopenCodeRotateBtn.click();
    }
}
