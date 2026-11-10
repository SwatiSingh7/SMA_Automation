package com.morrisons.sma.page_objects.mobile.cleanAndRotate;

import com.morrisons.common.action.Hook;
import com.morrisons.common.helper.CommonHelperMethods;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import static com.morrisons.common.helper.CommonHelperMethods.selectOption;

public class CNRHomepage {

    private static AndroidDriver driveR;
    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;

    private final Logger log = Logger.getLogger(CNRHomepage.class);
    public static String weeklyScheduleStatus = null;

    public CNRHomepage() {
        log.info("Inside : " + CNRHomepage.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    /**
     * Web Elements
     */

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Ambient Clearance Bay Check']")
    public WebElement ambientClearenceBayCheck;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Frozen Clearance Bay Check']")
    public WebElement frozenClearenceBayCheck;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Ambient & Frozen Code Alerts']")
    public WebElement ambientFrozenCAlert;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Weekly Schedules']")
    public WebElement weeklySchedules;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Ambient Clearance Bay Check']//android.widget.TextView[contains(resource-id ,'department_status')]")
    public WebElement ambientClearenceBayCheckStatus;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Frozen Clearance Bay Check']//android.widget.TextView[contains(resource-id ,'department_status')]")
    public WebElement frozenClearenceBayCheckStatus;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Ambient & Frozen Code Alerts']//android.widget.TextView[contains(resource-id ,'department_status')]")
    public WebElement ambientFrozenCAlertStatus;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Weekly Schedules']//android.widget.TextView[contains(resource-id ,'department_status')]")
    public WebElement weeklySchedulesStatus;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Ambient Clearance Bay Check']//android.widget.TextView[contains(resource-id ,'description')]")
    public WebElement ambientClearenceBayCheckMsg;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Frozen Clearance Bay Check']//android.widget.TextView[contains(resource-id ,'description')]")
    public WebElement frozenClearenceBayCheckMsg;


    /**
     * Public Methods
     **/
    public void clickOnCnRHomePageOption(String option) throws Throwable {


        log.info("Clicking on Clean and Rotate Home Page Option : " + option);
        switch (option) {
            case "Ambient Clearance Bay Check":
                selectOption(driveR, ambientClearenceBayCheck, option);
                break;
            case "Frozen Clearance Bay Check":
                selectOption(driveR, frozenClearenceBayCheck, option);
                break;
            case "Ambient & Frozen Code Alerts":
                selectOption(driveR, ambientFrozenCAlert, option);
                break;
            case "Weekly Schedules":
                selectOption(driveR, weeklySchedules, option);
                break;

            default:
                log.error("No Such Menu Option : " + option);
                Assert.fail("No Such Menu Option : " + option);

        }
    }


    // Getting Weekly schedule sub menu status
    public void getWeeklyScheduleSubmenuStatus() throws Throwable {
        try {
            WebElement xpathWeeklySchedule = driveR.findElement(
                    MobileBy.xpath("//android.widget.RelativeLayout[@index='3']/android.widget.TextView[contains(@resource-id,'department_status')]"));

            weeklyScheduleStatus = xpathWeeklySchedule.getText();
            log.info("Weekl scheudle submenu status : " + weeklyScheduleStatus);
        } catch (Exception e) {

            weeklyScheduleStatus = "Not Started";
            log.info("Weekl scheudle submenu status : " + weeklyScheduleStatus);
        }
    }

}











