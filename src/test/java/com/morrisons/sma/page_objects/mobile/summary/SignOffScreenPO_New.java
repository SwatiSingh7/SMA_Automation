package com.morrisons.sma.page_objects.mobile.summary;

import com.morrisons.common.action.Hook;
import com.morrisons.common.helper.CommonHelperMethods;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SignOffScreenPO_New {
    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    private static AndroidDriver driveR;

    private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
    String env = applicationConfig.getWebElementEnviroment().getEnv();
    private final Logger log = Logger.getLogger(SignOffScreenPO_New.class);


    public SignOffScreenPO_New() {
        log.info("Inside : " + SignOffScreenPO_New.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    /*
     * Web Elements Sign Off screen --
     */

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Sign Off']")
    public WebElement signOff;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'weekNameTV')]")
    public WebElement weekNameTV;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Store Manager weekly sign off']")
    public WebElement storeManagerweeklysignoff;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'SignOffConfirmationDescTV')]")
    public WebElement SignOffConfirmationDescTV;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'reviewWeeklyActivityLabel')]")
    public WebElement reviewWeeklyActivityLabel;

    @FindBy(how = How.XPATH, using = "//android.widget.CheckBox[contains(@resource-id,'reviewWeeklyActivityCheckBox')]")
    public WebElement reviewWeeklyActivityCheckBox;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'spoken_to_department')]")
    public WebElement spoken_to_department;

    @FindBy(how = How.XPATH, using = "//android.widget.CheckBox[contains(@resource-id,'reviewWasteAreasCheckBox')]")
    public WebElement reviewWasteAreasCheckBox;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'reviewWasteAreasLabel')]")
    public WebElement reviewWasteAreasLabel;

    @FindBy(how = How.XPATH, using = "//android.widget.CheckBox[contains(@resource-id,'spokenToDepartmentCheckBox')]")
    public WebElement spokenToDepartmentCheckBox;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'nextStepDocumentedLabel')]")
    public WebElement nextStepDocumentedLabel;

    @FindBy(how = How.XPATH, using = "//android.widget.CheckBox[contains(@resource-id,'nextStepDocumentedCheckBox')]")
    public WebElement nextStepDocumentedCheckBox;

    @FindBy(how = How.XPATH, using = "//android.widget.EditText[contains(@resource-id,'comment_box_txt')]")
    public WebElement comment_box_txt;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'signOffButton')]")
    public WebElement signOffButton;

    public void verifytoreManagerWeeklySignOffAtTop() {
        CommonHelperMethods.verifyIfDisplayed(driveR, signOff);
        CommonHelperMethods.verifyIfDisplayed(driveR, storeManagerweeklysignoff);
    }

    public void verifyDateOfPreviousWeekAtTop() {
        CommonHelperMethods.verifyIfDisplayed(driveR, weekNameTV);

    }

    public void VerifyFourCheckBoxes() {
        CommonHelperMethods.verifyIfDisplayed(driveR, reviewWeeklyActivityCheckBox);
        CommonHelperMethods.verifyIfDisplayed(driveR, reviewWasteAreasCheckBox);
        CommonHelperMethods.verifyIfDisplayed(driveR, spokenToDepartmentCheckBox);
        CommonHelperMethods.verifyIfDisplayed(driveR, nextStepDocumentedCheckBox);
    }

    public void verifyPleaseConfirmThatYouHaveCompleted() {
        CommonHelperMethods.verifyIfDisplayed(driveR, SignOffConfirmationDescTV);
    }

    public void VerifyReviewedTheWeeklyActivityI() {
        CommonHelperMethods.verifyIfDisplayed(driveR, reviewWeeklyActivityLabel);
    }

    public void verifyyReviewedAllInStoreWasteAreas() {
        CommonHelperMethods.verifyIfDisplayed(driveR, reviewWasteAreasLabel);
    }

    public void VerifySpokenToDepartmentsWithHighUnrecordedWaste() {
        CommonHelperMethods.verifyIfDisplayed(driveR, reviewWasteAreasLabel);
    }

    public void VerifyActionsNextStepsDocumented() {
        CommonHelperMethods.verifyIfDisplayed(driveR, nextStepDocumentedLabel);
    }

    public void VerifyAbleToViewTextFieldToWriteComments() {
        CommonHelperMethods.verifyIfDisplayed(driveR, comment_box_txt);
    }

    public void clickcheckbox() {
        reviewWeeklyActivityCheckBox.click();
        reviewWasteAreasCheckBox.click();
        spokenToDepartmentCheckBox.click();
        nextStepDocumentedCheckBox.click();
    }

    public void clicksignoffbutton() {
        signOffButton.click();
    }

}
