package com.morrisons.sma.page_objects.mobile.freshCodeCheck;

import com.morrisons.common.action.Hook;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import static com.morrisons.common.helper.CommonHelperMethods.selectOption;

public class FreshCodeCheckPO_New {

    public static AndroidDriver driveR;
    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;

    private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
    String env = applicationConfig.getWebElementEnviroment().getEnv();
    private final Logger log = Logger.getLogger(FreshCodeCheckPO_New.class);

    public FreshCodeCheckPO_New() {
        log.info("Inside : " + FreshCodeCheckPO_New.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Pre-Opening Clearance Bay Checks']")
    public WebElement optPreOpening;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='LOG PRODUCT']")
    public WebElement logProduct;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Code Alerts']")
    public WebElement optCodeAlerts;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Daily Schedule']")
    public WebElement optDailySchedule;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Store Close Clearance Bay Checks']")
    public WebElement optStoreClose;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Manager Summary & Sign Off']")
    public WebElement optManagerSignOff;

    @FindBy(how = How.XPATH, using = "//android.widget.CheckedTextView[@text='Wastage']")
    public WebElement optWastage;

    @FindBy(how = How.XPATH, using = "//android.widget.Spinner[contains(@resource-id,'action_spinner')]")
    public WebElement dropdownCodeAlert;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'id/department_title')]")
    public WebElement product;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Daily Checks']")
    public WebElement dailyCheck;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Fixture']")
    public WebElement optFixture;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Promotions']")
    public WebElement optPromotions;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Warehouse']")
    public WebElement optWarehouse;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Bought In Breads']")
    public WebElement boughtInBreads;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='060 Chilled Desserts']")
    public WebElement chilledDesserts;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='First Check']")
    public WebElement optFirstCheck;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Second Check']")
    public WebElement optSecondCheck;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Fresh Food Manager Check']")
    public WebElement optFreshFoodManagerCheck;

    public void clickOnFccOption(String option) {
        log.info("Clicking on Fresh Code Check Option : " + option);
        switch (option) {
            case "Pre-Opening Clearance Bay Checks":
                selectOption(driveR, optPreOpening, option);
                break;
            case "Code Alerts":
                selectOption(driveR, optCodeAlerts, option);
                break;
            case "Daily Schedule":
                selectOption(driveR, optDailySchedule, option);
                break;
            case "Store Close Clearance Bay Checks":
                selectOption(driveR, optStoreClose, option);
                break;
            case "Manager Summary & Sign Off":
                selectOption(driveR, optManagerSignOff, option);
                break;
            default:
                log.error("No Such Menu Option : " + option);
                Assert.fail("No Such Menu Option : " + option);
        }
    }

    public void clickOnFccDailyCheckOptions(String option) {
        log.info("Clicking on daily Check Option : " + option);
        switch (option) {
            case "Fixture":
                selectOption(driveR, optFixture, option);
                break;
            case "Promotions":
                selectOption(driveR, optPromotions, option);
                break;
            case "Warehouse":
                selectOption(driveR, optWarehouse, option);
                break;
            default:
                log.error("No Such Menu Option : " + option);
                Assert.fail("No Such Menu Option : " + option);

        }
    }

    public void clickOnFccSelectCheckOptions(String option) {
        log.info("Clicking on daily Check Option : " + option);
        switch (option) {
            case "First Check":
                selectOption(driveR, optFirstCheck, option);
                break;
            case "Second Check":
                selectOption(driveR, optSecondCheck, option);
                break;
            case "Fresh Food Manager Check":
                selectOption(driveR, optFreshFoodManagerCheck, option);
                break;
            default:
                log.error("No Such Menu Option : " + option);
                Assert.fail("No Such Menu Option : " + option);

        }
    }
    // for daily schedule
public void productClick(String s){
    product.click();
    //dailyCheck.click();
   }

    private void clickDropdown(){
        log.info("Opening the Dropdown");
        /*clickElement(driveR, dropdown);*/
        dropdownCodeAlert.click();
    }
    private void clickOption(String option) {
        log.info("Clicking on Action Option : " + option);
        switch (option) {
//            case "Markdown":
//                selectOption(driveR, optMarkdown, option);
//                break;
            case "Wastage":
                selectOption(driveR, optWastage, option);
                break;
            default:
                log.error("No Such Menu Option : " + option);
                Assert.fail("No Such Menu Option : " + option);
        }
    }

    public void clickLogProduct() {
        log.info("Clicking on Log product");
        /*clickElement(driveR, logProduct);*/
        logProduct.click();
    }

    public void productGroupClick() {
        //boughtInBreads.click();
        chilledDesserts.click();
    }

    public void selectCodeAlertActionOption(String actionOption) {
        clickDropdown();
        clickOption(actionOption);

    }
}
