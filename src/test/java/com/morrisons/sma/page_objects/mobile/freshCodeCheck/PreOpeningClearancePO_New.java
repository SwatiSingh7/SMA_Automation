package com.morrisons.sma.page_objects.mobile.freshCodeCheck;

import com.morrisons.common.action.Hook;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

public class PreOpeningClearancePO_New {

    private static AndroidDriver driveR;
    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;

    private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
    String env = applicationConfig.getWebElementEnviroment().getEnv();
    private final Logger log = Logger.getLogger(PreOpeningClearancePO_New.class);

    public PreOpeningClearancePO_New() {
        log.info("Inside : " + PreOpeningClearancePO_New.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    @FindBy(how = How.XPATH, using = "//android.widget.Spinner[contains(@resource-id,'spinner_Actions')]")
    public WebElement dropdown;

    @FindBy(how = How.XPATH, using = "//android.widget.CheckedTextView[@text='Wastage']")
    public WebElement optWastage;

    @FindBy(how = How.XPATH, using = "//android.widget.CheckedTextView[@text='Markdown']")
    public WebElement optMarkdown;

    @FindBy(how = How.XPATH, using = "//android.widget.EditText[contains(@resource-id,'edt_ExpiryDate')]")
    public WebElement datePicker;

    @FindBy(how = How.XPATH, using = "//android.widget.Button[contains(@resource-id,'button1')]")
    public WebElement OkButton;

    @FindBy(how = How.XPATH, using = "//android.widget.EditText[contains(@resource-id,'markdown_quantity')]")
    public WebElement quantityTextBox;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='LOG PRODUCT']")
    public WebElement logProduct;

    @FindBy(how = How.XPATH, using = "//android.widget.CheckedTextView[@text='Waste - Damaged']")
    public WebElement optWasteDamaged;

    @FindBy(how = How.XPATH, using = "//android.widget.CheckedTextView[@text='Waste - Out of Date']")
    public WebElement optWasteOutOfDate;

    @FindBy(how = How.XPATH, using = "//android.widget.CheckedTextView[@text='Charity - Damaged']")
    public WebElement optCharityDamaged;

    @FindBy(how = How.XPATH, using = "//android.widget.CheckedTextView[@text='Charity - Out of Date']")
    public WebElement optCharityOutOfDate;

    @FindBy(how = How.XPATH, using = "//android.widget.Button[@text='CONFIRM']")
    public WebElement btnConfirm;

    @FindBy(how = How.XPATH, using = "//android.widget.Button[@text='CONFIRM CLEARANCE BAY CHECK']")
    public WebElement confirmClearanceBayCheck;

    @FindBy(how = How.XPATH, using = "//android.widget.Button[@text='CONTINUE']")
    public WebElement btnContinue;

    public void selectActionOption(String option) throws InterruptedException {
        clickDropdown();
        clickOption(option);
    }

    private void clickOption(String option) {
        log.info("Clicking on Action Option : " + option);
        switch (option) {
            case "Markdown":
                selectOption(driveR, optMarkdown, option);
                break;
            case "Wastage":
                selectOption(driveR, optWastage, option);
                break;
            default:
                log.error("No Such Menu Option : " + option);
                Assert.fail("No Such Menu Option : " + option);
        }
    }

    private void clickDropdown() throws InterruptedException {
        log.info("Opening the Dropdown");
        /*clickElement(driveR, dropdown);*/
        Thread.sleep(2000);
        dropdown.click();

    }

    public void selectDate(int addDate) throws InterruptedException {
        clickDatePicker();
        selectDateOption(addDate);
    }

    private void selectDateOption(int addDate) throws InterruptedException {
        boolean otherDevice = true;

        try {
            WebElement xpathDateField = driveR
                    .findElement(By.xpath("//android.widget.EditText[@resource-id='android:id/numberpicker_input']"));
            xpathDateField.isDisplayed();
        } catch (NoSuchElementException e) {
            otherDevice = false; // For CT 60 device, flag value will be false
        }

        LocalDateTime today = LocalDateTime.now(); // Storing current date
        LocalDateTime nextDay = today.plusDays(addDate);// Adding days in
        // current date

        int date = nextDay.getDayOfMonth();
        System.out.println(date);// Getting Date
        Month month = nextDay.getMonth();
        System.out.println(month); // Getting Month
        int year = nextDay.getYear();
        System.out.println(year); // Getting Year

        // To set the Calendar format - If date is less than or equal to 9, then
        // adding '0' before the date.
        String date1 = null;

        if (date <= 9) {
            date1 = "0" + String.valueOf(date);
        } else {
            date1 = String.valueOf(date);
        }

        if (otherDevice) // For CT 50 device Calendar
        {
            System.out.println("CT 50 device");

            List<WebElement> lowerDatePicker = driveR.findElements(By.xpath("//android.widget.Button[@index='2']"));
            List<WebElement> upperDatePicker = driveR.findElements(By.xpath("//android.widget.Button[@index='0']"));

            try {
                while (upperDatePicker.get(2).isDisplayed()) {
                    List<WebElement> calendarList = driveR.findElements(
                            By.xpath("//android.widget.EditText[@resource-id='android:id/numberpicker_input']"));
                    int selectedYear = Integer.parseInt(calendarList.get(2).getText());

                    if (year != selectedYear) {
                        upperDatePicker.get(2).click();
                    } else
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            String expMonth = month.toString().substring(0, 3);
            String expMonth1 = expMonth.charAt(0) + expMonth.substring(1, expMonth.length()).toLowerCase(); // Creating
            // Month
            // in
            // format.
            // eg.
            // Feb

            while (lowerDatePicker.get(1).isDisplayed()) {

                List<WebElement> mmm = driveR.findElements(
                        By.xpath("//android.widget.EditText[@resource-id='android:id/numberpicker_input']"));

                if (!expMonth1.equals(mmm.get(1).getText())) {
                    lowerDatePicker.get(1).click();
                } else
                    break;
            }

            while (lowerDatePicker.get(0).isDisplayed()) {
                List<WebElement> ddd = driveR.findElements(
                        By.xpath("//android.widget.EditText[@resource-id='android:id/numberpicker_input']"));

                if (!date1.equals(ddd.get(0).getText())) {
                    lowerDatePicker.get(0).click();
                } else
                    break;
            }
        } else // For CT 60 device Calendar
        {
            System.out.println("CT 60 device");

            String m = month.toString(); // month is FEBRUARY
            String mnth = m.charAt(0) + m.substring(1, m.length()).toLowerCase(); // Creating
            // Month
            // in
            // format.
            // eg.
            // February

            String selectDate = date1 + " " + mnth + " " + year; // Creating
            // date in
            // format .
            // eg. 01
            // February
            // 2020
            System.out.println("Select date : " + selectDate);

            // If date is not available in current month, clicking on Next
            // button

            for (int arrow = 0; arrow < 2; arrow++) {
                try {
                    Thread.sleep(2000);
                    driveR.findElement(By.xpath("//android.view.View[@content-desc='" + selectDate + "']"))
                            .isDisplayed();
                    break;
                } catch (NoSuchElementException | InterruptedException e) {
                    WebElement xpathNextArrow = driveR
                            .findElement(By.xpath("//android.widget.ImageButton[@resource-id='android:id/next']"));

                    xpathNextArrow.click();
                }
            }
            Thread.sleep(2000);
            driveR.findElement(By.xpath("//android.view.View[@content-desc='" + selectDate + "']")).click(); // Selecting
            // date
        }
        log.info("Clicking on OK button");
        /*clickElement(driveR, OkButton);*/
        OkButton.click();
    }

    private void clickDatePicker() {
        log.info("Opening Calendar");
        /*clickElement(driveR, datePicker);*/
        datePicker.click();
    }

    public void enterQtyLogProduct(String quantity) {
        enterQuantity(quantity);
        clickLogProduct();
    }

    private void clickLogProduct() {
        log.info("Clicking on Log product");
        /*clickElement(driveR, logProduct);*/
        logProduct.click();
    }

    private void enterQuantity(String quantity) {
        log.info("Entering quantity : " + quantity);
        /*enterText(quantityTextBox, quantity);*/
        quantityTextBox.sendKeys(quantity);
    }

    private void selectWastageReason(String wastageReason) {
        log.info("Selecting Wastage Reason : " + wastageReason);
        switch (wastageReason) {
            case "Waste - Damaged":
                selectOption(driveR, optWasteDamaged, wastageReason);
                break;
            case "Waste - Out of Date":
                selectOption(driveR, optWasteOutOfDate, wastageReason);
                break;
            case "Charity - Damaged":
                selectOption(driveR, optCharityDamaged, wastageReason);
                break;
            case "Charity - Out of Date":
                selectOption(driveR, optCharityOutOfDate, wastageReason);
                break;
            default:
                log.error("No Such Menu Option : " + wastageReason);
                Assert.fail("No Such Menu Option : " + wastageReason);
        }
    }

    private void clickConfirm() {
        log.info("Clicking on Confirm");
        /*clickElement(driveR, btnConfirm);*/
        btnConfirm.click();
    }

    public void selectWastageReasonAndConfirm(String wastageReason) {
        selectWastageReason(wastageReason);
        clickConfirm();
    }

    public void clickConfirmAndContinue() {
       log.info("Clicking on Confirm Clearance Bay Check");
        /*clickElement(driveR, confirmClearanceBayCheck);*/
        confirmClearanceBayCheck.click();
        log.info("Clicking on Continue");
        /*clickElement(driveR, btnContinue);*/
        btnContinue.click();
    }
}

