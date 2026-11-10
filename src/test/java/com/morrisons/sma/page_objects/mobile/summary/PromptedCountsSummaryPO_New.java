package com.morrisons.sma.page_objects.mobile.summary;

import com.morrisons.common.action.Hook;
import com.morrisons.common.helper.CommonHelperMethods;
import com.morrisons.common.helper.ElementRetry;
import com.morrisons.common.helper.MobileHelper;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.Arrays;
import java.util.List;

import static com.morrisons.common.helper.CommonHelperMethods.*;
import static org.testng.Assert.assertEquals;

public class PromptedCountsSummaryPO_New {

    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    private static AndroidDriver driveR;

    private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
    String env = applicationConfig.getWebElementEnviroment().getEnv();
    private final Logger log = Logger.getLogger(PromptedCountsSummaryPO_New.class);


    public PromptedCountsSummaryPO_New() {
        log.info("Inside : " + PromptedCountsSummaryPO_New.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Flagged:']")
    public WebElement flagedLabel;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Actions Completed:']")
    public WebElement actionsCompletedLabel;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'tvFlaggedCount')]")
    public WebElement flaggedValue;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'tvActionCountStatus')]")
    public WebElement actionsCompletedValue;

    @FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[contains(@resource-id,'approvalCount')]")
    public WebElement totalApprovals;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'tvDepartment')]/../android.widget.TextView[@index='1']")
    public WebElement deptName;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Total:']/../android.widget.TextView[@index='1']")
    public WebElement deptTotalLabel;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Complete:']/../android.widget.TextView[@index='3']")
    public WebElement deptCompleteLabel;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Actions Completed:']/../android.widget.TextView[@index='5']")
    public WebElement deptActionsCompletedLabel;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Flagged:']/../android.widget.TextView[@index='7']")
    public WebElement deptFlaggedLabel;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Approvals Completed:']/../android.widget.TextView[contains(@resource-id,'tvApprovalCompletedLabel')]")
    public WebElement deptApprovalsCompletedLabel;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@index=0]/parent::android.widget.RelativeLayout/android.widget.TextView[contains(@resource-id,'tvProductDescription')]")
    public List<WebElement> prodDescription;


    public void verifySections() {
        log.info("Verifying both sections are displayed :");
        verifyIfDisplayed(driveR, flagedLabel);
        verifyIfDisplayed(driveR, actionsCompletedLabel);
        verifyIfDisplayed(driveR, flaggedValue);
        verifyIfDisplayed(driveR, actionsCompletedValue);
    }

    public void verifyApprovalsState() {
        verifyFieldIsDisabled(totalApprovals);
    }

    public void verifyDeptDetails(String deptName) {
        By depXpath = By.xpath("//android.widget.TextView[@text='" + deptName + "']");
        log.info("Verifying Department name: ");
        verifyIfDisplayed(driveR, depXpath, deptName);
        log.info("Verifying Department Total label: ");
        verifyIfDisplayed(driveR, deptTotalLabel);
        log.info("Verifying Department Complete label: ");
        verifyIfDisplayed(driveR, deptCompleteLabel);
        log.info("Verifying Department Actions Completed label: ");
        verifyIfDisplayed(driveR, deptActionsCompletedLabel);
        log.info("Verifying Department Flagged label: ");
        verifyIfDisplayed(driveR, deptFlaggedLabel);
        log.info("Verifying Department Approvals Completed label: ");
        verifyIfDisplayed(driveR, deptApprovalsCompletedLabel);
    }

    public void scrollTo(String scrollToElement) {
        MobileHelper.ScrolltoElementWithText(driveR, scrollToElement);
    }

    public void clickAndVerifyDept(String depName) throws InterruptedException {
        WebElement depXpath = driveR.findElement(By.xpath("//android.widget.TextView[@text='" + depName + "']"));
        ElementRetry.clickElement(driveR, depXpath);
        Thread.sleep(1000);
        verifyIfDisplayed(driveR, deptTotalLabel);
        verifyIfDisplayed(driveR, deptCompleteLabel);
        verifyIfDisplayed(driveR, deptApprovalsCompletedLabel);
        log.info("Verifying both sections are displayed :");
        verifyIfDisplayed(driveR, flagedLabel);
        verifyIfDisplayed(driveR, actionsCompletedLabel);
        MobileHelper.scroll(driveR, 200, 800, 200, 250);

        for(int i = 0; i<prodDescription.size(); i++)
        {
            String name = prodDescription.get(i).getText();
            log.info("Products are: " + name);
        }
    }

    public void verifyFlaggedValue(String flaggedvalue) {
        String flaggedValueTxt = flaggedValue.getText();
        assertEquals(flaggedValueTxt, flaggedvalue, "Value matched");
    }

    public void verifyActionValue(String actionValue) {
        String actionValueTxt = actionsCompletedValue.getText();
        assertEquals(actionValueTxt, actionValue, "Value matched");
    }
}
