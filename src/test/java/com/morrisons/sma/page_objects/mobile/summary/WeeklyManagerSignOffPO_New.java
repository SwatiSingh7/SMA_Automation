package com.morrisons.sma.page_objects.mobile.summary;

import com.morrisons.common.action.Hook;
import com.morrisons.common.helper.CommonHelperMethods;
import com.morrisons.common.helper.MobileHelper;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class WeeklyManagerSignOffPO_New {
    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    private static AndroidDriver driveR;

    private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
    String env = applicationConfig.getWebElementEnviroment().getEnv();
    private final Logger log = Logger.getLogger(WeeklyManagerSignOffPO_New.class);


    public WeeklyManagerSignOffPO_New() {
        log.info("Inside : " + WeeklyManagerSignOffPO_New.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    /**
     * Web Elements Weekly Manager Sign Off
     */

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Weekly Manager Sign Off']")
    public WebElement weeklyManagerSignOffHeader;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'summary_date')]")
    public WebElement summaryDate;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'summary_status')]")
    public WebElement summaryStatus;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'wastageLabel')]")
    public WebElement wastageLabel;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'unrecordedWastageValue')]")
    public WebElement unrecordedWastageValue;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'wastageItemsLabel')]")
    public WebElement wastageItemsLabel;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'wastageItemsCountValue')]")
    public WebElement wastageItemsCountValue;

    @FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[contains(@resource-id,'wastage_check_completion')]")
    public WebElement wastageCheckCompletion;

    @FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[contains(@resource-id,'wastage_department_completion')]")
    public WebElement wastageDeptCompletion;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='VIEW']")
    public WebElement view;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Date']")
    public WebElement dateLabel;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Completion Status']")
    public WebElement completionStatus;

    @FindBy(how = How.XPATH, using = "//android.support.v7.widget.RecyclerView[contains(@resource-id,'rvDateCompletionStatusList')]")
    public WebElement rvDateCompletionStatusList;

    @FindBy(how = How.XPATH, using = "//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[@index='0']")
    public WebElement firstDayInList;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'signOffButton')]")
    public WebElement signOffButton;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'validation_menu_title')]")
    public WebElement validationMenuTitle;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='COMPLETE']")
    public WebElement validationMenuStatusComplete;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='INCOMPLETE']")
    public WebElement validationMenuStatusIncomplete;

    /**
     * Web Elements Weekly Manager Sign Off  Check Tab--
     */
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='CHECKS']")
    public WebElement checkTab;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'check_fragment_item_list')]")
    public WebElement checkFragmentItemList;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'day_date')]")
    public WebElement dayDate;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='COMPLETE']")
    public WebElement itemStatusComplete;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='INCOMPLETE']")
    public WebElement itemStatusIncomplete;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'completed_time_label')]")
    public WebElement completedTimeLabel;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'completed_time_value')]")
    public WebElement completedTimeValue;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'passed_quantity_label')]")
    public WebElement passedQuantityLabel;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'passed_quantity_value')]")
    public WebElement passedQuantityValue;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'failed_quantity_label')]")
    public WebElement failedQuantityLabel;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'failed_quantity_value')]")
    public WebElement failedQuantityValue;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Unrecorded Waste Value:']")
    public WebElement unrecordedWasteValue;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'unrecorded_values_value')]")
    public WebElement unrecordedValuesValue;

    /**
     * Web Elements Weekly Manager Sign Off  Department Tab--
     */

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='DEPARTMENTS']")
    public WebElement departmentTab;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Pass']")
    public WebElement pass;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Fail']")
    public WebElement fail;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Waste(£)']")
    public WebElement waste;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'no_department_message')]")
    public WebElement noDataDisplayed;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'pass_quantity')]")
    public WebElement passQuantity;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'fail_quantity')]")
    public WebElement failQuantity;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'wasteQty')]")
    public WebElement wasteQty;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@index=3]/parent::android.widget.LinearLayout/android.widget.TextView[contains(@resource-id,'waste_qty')]")
    public List<WebElement> wasteValue;

//    @FindAllBy(how = How.XPATH, using = "//android.widget.TextView[@index=3]/parent::android.widget.LinearLayout/android.widget.TextView[contains(@resource-id,'waste_qty')]")
//    public List<WebElement> wasteValue;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'department_total')]")
    public WebElement departmentTotal;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'pass_total')]")
    public WebElement passTotal;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'fail_total')]")
    public WebElement failTotal;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'wastetotal')]")
    public WebElement wasteTotal;


    public void verifyDateRangeAndWeeklyManagerSignOffStatus(String status) {
        log.info("Verifying weekly manager sign off date and status:");
        weeklyManagerSignOffHeader.isDisplayed();
        CommonHelperMethods.verifyIfDisplayed(driveR, summaryDate);
        CommonHelperMethods.verifyIfDisplayed(driveR, summaryStatus, status);
    }

    public void iVerifyUnrecordedWaste() {
        log.info("Verifying Unrecorded Value :");
        CommonHelperMethods.verifyIfDisplayed(driveR, wastageLabel);
        CommonHelperMethods.verifyIfDisplayed(driveR, unrecordedWastageValue);
        log.info("verifying Unrecorded Item :");
        CommonHelperMethods.verifyIfDisplayed(driveR, wastageItemsLabel);
        CommonHelperMethods.verifyIfDisplayed(driveR, wastageItemsCountValue);
    }

    public void verifyWeeklyWastageValidationCompletion() {
        log.info("Verifying Weekly Wastage Validation Completion :");
        CommonHelperMethods.verifyIfDisplayed(driveR, wastageCheckCompletion);
        CommonHelperMethods.verifyIfDisplayed(driveR, view);
    }

    public void verifyWeeklyDepartmentCompletion() {
        log.info("Verifying Weekly Department Completion :");
        CommonHelperMethods.verifyIfDisplayed(driveR, wastageDeptCompletion);
        CommonHelperMethods.verifyIfDisplayed(driveR, view);
    }

    public void verifyListOfDaysWithStatusComplete(String status) {
        log.info("Verifying List Of Days With Status :" + status);
        CommonHelperMethods.verifyIfDisplayed(driveR, dateLabel);
        CommonHelperMethods.verifyIfDisplayed(driveR, completionStatus);
        CommonHelperMethods.verifyIfDisplayed(driveR, rvDateCompletionStatusList);
        CommonHelperMethods.verifyIfDisplayed(driveR, validationMenuTitle);
        MobileHelper.ScrolltoElementWithText(driveR, status);
        CommonHelperMethods.verifyIfDisplayed(driveR, validationMenuStatusComplete, status);
    }

    public void verifyListOfDaysWithStatusIncomplete(String status) {
        log.info("Verifying List Of Days With Status :" + status);
        CommonHelperMethods.verifyIfDisplayed(driveR, dateLabel);
        CommonHelperMethods.verifyIfDisplayed(driveR, completionStatus);
        CommonHelperMethods.verifyIfDisplayed(driveR, rvDateCompletionStatusList);
        CommonHelperMethods.verifyIfDisplayed(driveR, validationMenuTitle);
        MobileHelper.ScrolltoElementWithText(driveR, status);
        CommonHelperMethods.verifyIfDisplayed(driveR, validationMenuStatusIncomplete, status);
    }

    public void verifySignOffButton(String button) {
        log.info("Verifying Sign off button :");
        CommonHelperMethods.verifyIfDisplayed(driveR, signOffButton, button);
    }

    public void clickOnWeeklyWastageValidationCompletion() {
        log.info("Clicking Weekly Wastage Validation Completion :");
        wastageCheckCompletion.click();
    }

    public void clickOnWeeklyDepartmentCompletion() {
        log.info("Clicking Weekly Department Completion :");
        wastageDeptCompletion.click();
    }

    public void verifyTabs(String tab1, String tab2) {
        log.info("Verifying Weekly Wastage Validation Completion tabs :");
        CommonHelperMethods.verifyIfDisplayed(driveR, checkTab, tab1);
        CommonHelperMethods.verifyIfDisplayed(driveR, departmentTab, tab2);
    }

    public void clickOnAnyDay(String tab) {
        log.info("Clicking on any day");
        firstDayInList.click();
        CommonHelperMethods.verifyIfDisplayed(driveR, checkTab, tab);
    }

    public void verifyDetailsIfANoTraysCompleted(String status) throws InterruptedException {
        log.info("Verify details if all trays incomplete");
        MobileHelper.scroll((AndroidDriver) Hook.getDriver(), 50, 500, 50, 1100);
        CommonHelperMethods.verifyIfDisplayed(driveR, itemStatusIncomplete, status);
        CommonHelperMethods.verifyIfDisplayed(driveR, dayDate);
        CommonHelperMethods.verifyIfDisplayed(driveR, completedTimeLabel, "Last Validation:");
        CommonHelperMethods.verifyIfDisplayed(driveR, completedTimeValue, "Not Started");
        CommonHelperMethods.verifyIfDisplayed(driveR, passedQuantityLabel, "Passed Quantity:");
        CommonHelperMethods.verifyIfDisplayed(driveR, passedQuantityValue, "NA");
        CommonHelperMethods.verifyIfDisplayed(driveR, failedQuantityLabel, "Failed Quantity:");
        CommonHelperMethods.verifyIfDisplayed(driveR, failedQuantityValue, "NA");
        CommonHelperMethods.verifyIfDisplayed(driveR, unrecordedWasteValue, "Unrecorded Waste Value:");
        CommonHelperMethods.verifyIfDisplayed(driveR, unrecordedValuesValue, "NA");
    }

    public void verifyDetailsIfAllTraysCompleted(String status) {
        log.info("Verify details if all trays are completed");
        MobileHelper.ScrolltoElementWithText(driveR, status);
        CommonHelperMethods.verifyIfDisplayed(driveR, itemStatusComplete, status);
        CommonHelperMethods.verifyIfDisplayed(driveR, dayDate);
        CommonHelperMethods.verifyIfDisplayed(driveR, completedTimeLabel);
        CommonHelperMethods.verifyIfDisplayed(driveR, completedTimeValue);
        CommonHelperMethods.verifyIfDisplayed(driveR, passedQuantityLabel);
        CommonHelperMethods.verifyIfDisplayed(driveR, passedQuantityValue);
        CommonHelperMethods.verifyIfDisplayed(driveR, failedQuantityLabel);
        CommonHelperMethods.verifyIfDisplayed(driveR, failedQuantityValue);
        CommonHelperMethods.verifyIfDisplayed(driveR, unrecordedWasteValue);
        CommonHelperMethods.verifyIfDisplayed(driveR, unrecordedValuesValue);
    }

    public void clickDeptTab() {
        log.info("Clicking on Departments tab");
        departmentTab.click();
    }

    public void clickCheckTab() {
        log.info("Clicking on Checks tab");
        checkTab.click();
    }

    public void verifyDepartmentTab() {
        log.info("Verifying details on department tab");
        CommonHelperMethods.verifyIfDisplayed(driveR, pass);
        CommonHelperMethods.verifyIfDisplayed(driveR, fail);
        CommonHelperMethods.verifyIfDisplayed(driveR, waste);
        ///if data is no data found in department section:
//       CommonHelperMethods.verifyIfDisplayed(driveR, noDataDisplayed);
        CommonHelperMethods.verifyIfDisplayed(driveR, departmentTotal);
        CommonHelperMethods.verifyIfDisplayed(driveR, passTotal);
        CommonHelperMethods.verifyIfDisplayed(driveR, failTotal);
        CommonHelperMethods.verifyIfDisplayed(driveR, wasteTotal);
        CommonHelperMethods.verifyIfDisplayed(driveR, passQuantity);
        CommonHelperMethods.verifyIfDisplayed(driveR, failQuantity);
        CommonHelperMethods.verifyIfDisplayed(driveR, wasteQty);
    }

    public void verifyWasteInDescOrder() {
        double[] array = new double[wasteValue.size()];
        for(int i = 0; i<wasteValue.size(); i++)
        {
            String text = wasteValue.get(i).getText();
            array[i] = Double.parseDouble(text);
        }
        for(int i=0; i<array.length-1;i++)
        {
            if (array[i] > array[i + 1])
            {
                log.info("Waste values are in descending order");
            }
        }
    }
}
