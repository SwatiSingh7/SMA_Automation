package com.morrisons.sma.page_objects.mobile;

import com.morrisons.common.action.Hook;
import com.morrisons.common.helper.ActionHelper;
import com.morrisons.common.helper.CommonHelperMethods;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import com.morrisons.sma.page_objects.mobile.popups.PopUpPO_New;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import static com.morrisons.common.helper.CommonHelperMethods.selectOption;
import static com.morrisons.common.helper.CommonHelperMethods.verifyIfDisplayed;

public class WasteValidationPO_New {

    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    private static AndroidDriver driveR;

    private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
    String env = applicationConfig.getWebElementEnviroment().getEnv();
    private static final Logger log = Logger.getLogger(WasteValidationPO_New.class);
    public String sLocatorName = "//android.widget.TextView[@text='Tray/ Container Locator']~Xpath";

    public WasteValidationPO_New() {
        log.info("Inside : " + WasteValidationPO_New.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    /**
     * Web Elements
     */

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Validation Checks']")
    public WebElement optValidationChecks;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Backhaul']")
    public WebElement optBackhaul;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Weekly Manager Sign Off']")
    public WebElement optWeeklyManagerSignOff;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Review']")
    public WebElement optReview;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Validation Checks']/parent::android.widget.RelativeLayout/android.widget.TextView[contains(@resource-id,'validation_menu_status')]")
    public WebElement optValidationChecksStatus;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Validation Checks']")
    public WebElement ValidationChecksStatus;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Backhaul']/parent::android.widget.RelativeLayout/android.widget.TextView[contains(@resource-id,'validation_menu_status')]")
    public WebElement optBackhaulStatus;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Weekly Manager Sign Off']/parent::android.widget.RelativeLayout/android.widget.TextView[contains(@resource-id,'validation_menu_status')]")
    public WebElement optWeeklyManagerSignOffStatus;

    @FindBy(how = How.XPATH, using = "//android.widget.Button[@text='COMPLETE CHECK']")
    public WebElement completeCheckBtn;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Review']/parent::android.widget.RelativeLayout/android.widget.TextView[contains(@resource-id,'review_header_status')]")
    public WebElement optReviewStatus;


/** Protected Methods **/

	/*protected String getBrandXpath(String name){
		log.debug(name);
		return "//div[@id='facetFilterOptions']//label[contains(.,'" + name + "')]";
	}*/

    /**
     * Public Methods
     **/
    public void clickOnWasteValidationPage(String optActionWaste) throws Throwable {
        log.info("Clicking on Action Waste Page Option : " + optActionWaste);
        switch (optActionWaste) {
            case "Review":
                selectOption(driveR, optReview, optActionWaste);
                break;
            case "Validation Checks":
                PopUpPO_New popUpPONew = new PopUpPO_New();
                popUpPONew.CheckAndClickOKBtn();
                selectOption(driveR, optValidationChecks, optActionWaste);
                break;
            case "Backhaul":
                selectOption(driveR, optBackhaul, optActionWaste);
                break;
            case "Weekly Manager Sign Off":
                selectOption(driveR, optWeeklyManagerSignOff, optActionWaste);
                break;
            default:
                log.error("No Such Menu Option : " + optActionWaste);
                Assert.fail("No Such Menu Option : " + optActionWaste);
        }
    }

    public void verifyOnWasteValidationPage(String optActionWaste) throws Throwable {
        log.info("Clicking on Action Waste Page Option : " + optActionWaste);
        switch (optActionWaste) {
            case "Review":
                CommonHelperMethods.verifyIfDisplayed(driveR, optReview, optActionWaste);
                break;
            case "Validation Checks":
                CommonHelperMethods.verifyIfDisplayed(driveR, optValidationChecks, optActionWaste);
                break;
            case "Backhaul":
                CommonHelperMethods.verifyIfDisplayed(driveR, optBackhaul, optActionWaste);
                break;
            case "Weekly Manager Sign Off":
                CommonHelperMethods.verifyIfDisplayed(driveR, optWeeklyManagerSignOff, optActionWaste);
                break;
            default:
                log.error("No Such Menu Option : " + optActionWaste);
                Assert.fail("No Such Menu Option : " + optActionWaste);
        }
    }

    public void verifyValidationCheckStatus(String value) {
        verifyIfDisplayed(driveR, optValidationChecksStatus, value);
    }

    public void clickOnCompleteCheckbutton(){
        log.info("Clicking on Complete Check button");
        //clickElement(driveR, completeCheckBtn );
        completeCheckBtn.click();
    }

    public void verifyReviewStatus(String value) {
        verifyIfDisplayed(driveR, optReviewStatus, value);
    }

    public void verifyweeklymanagerCheckStatus(String value) {
        verifyIfDisplayed(driveR, optWeeklyManagerSignOffStatus, value);
    }

    public void verifyEnabledDisabled(String submenu, String statusOfSubMenu, String nextPageOpt ) throws Throwable {
        log.info("Checking status of : " + submenu);
        switch (submenu) {
            case "Review":
                verifySubMenuStatus(driveR, optReview, statusOfSubMenu, nextPageOpt);
                break;
            case "Validation Checks":
                verifySubMenuStatus(driveR, optValidationChecks, statusOfSubMenu, nextPageOpt);
                break;
            case "Backhaul":
                verifySubMenuStatus(driveR, optBackhaul, statusOfSubMenu, nextPageOpt);
                break;
            case "Weekly Manager Sign Off":
                verifySubMenuStatus(driveR, optWeeklyManagerSignOff, statusOfSubMenu, nextPageOpt);
                break;
            default:
                log.error("No Such Menu Option : " + submenu);
                Assert.fail("No Such Menu Option : " + submenu);
        }
    }

    public static void verifySubMenuStatus(WebDriver dr, WebElement element, String statusOfSubMenu, String nextPageOpt) {
//buttonStatus - Enable/ Disable
        boolean isDisplayed = false;
        String xpathText = "//android.widget.TextView[@text='%s']";

        log.info("Verifying Submenu status..");
        switch (statusOfSubMenu) {
            case "Enable":
                try {
                    element.click();
                    isDisplayed  = dr.findElement(By.xpath(String.format(xpathText, nextPageOpt))).isDisplayed();
                    new ActionHelper().clickOnButton("BACK");
                } catch (Throwable e) {
                    log.info("Status is Disabled. Verification Failed");
                    Assert.fail("Element is Disabled");
                }
                break;
            case "Disable":
                try {
                    element.click();
                    isDisplayed  = dr.findElement(By.xpath(String.format(xpathText, nextPageOpt))).isDisplayed();
                    Assert.fail("Element is Enabled");
                } catch (Exception e) {
                    log.info("Status is Disabled. Verification Passed");
                }
                break;
            default:
                Assert.fail("No such option : " + statusOfSubMenu);
        }
    }
}















