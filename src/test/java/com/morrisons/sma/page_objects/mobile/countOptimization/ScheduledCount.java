package com.morrisons.sma.page_objects.mobile.countOptimization;

import com.morrisons.common.action.Hook;
import com.morrisons.common.helper.CommonHelperMethods;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class ScheduledCount {
    private static AndroidDriver driveR;
    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    private final Logger log = Logger.getLogger(ScheduledCount.class);

    public ScheduledCount() {
        log.info("Inside : " + ScheduledCount.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    /**
     * Web Elements
     */
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='TO DO']")
    public WebElement toDoText;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='REVIEW']")
    public WebElement reviewText;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'tv_count_title')]")
    public WebElement countTitle;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Warehouse']")
    public WebElement warehouseText;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Fixture']")
    public WebElement fixtureText;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Petrol']")
    public WebElement petrolText;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Off Shelf']")
    public WebElement offShelfText;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Counts cannot be started until the specified time.']")
    public WebElement CountStrtalertText;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='The deadline for this count has now passed.']")
    public WebElement CountEndalertText;


    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'review_count_status')]")
    public WebElement reviewCountStatus;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'review_count_name')]")
    public WebElement reviewCountName;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'review_count_list_item_layout')]")
    public WebElement reviewCompleteCountName;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Goodfellas Take Away Pepperoni Pizza 525g']")
    public WebElement productDesc;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='£5,175.00')]")
    public WebElement productAdjValue;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='104196036']")
    public WebElement productreviewMin;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Total Approvals']")
    public WebElement approval;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='APPROVE']")
    public WebElement approveButton;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='VIEW & EDIT']")
    public WebElement reviewEditButton;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Are you sure you want to approve?']")
    public WebElement confirmAlertBox;
    @FindBy(how = How.XPATH, using = "//android.widget.Button[@text='YES']")
    public WebElement confirmAlert;


    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'WH_check')]")
    public WebElement wareHouseCheck;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'fixture_check')]")
    public WebElement fixtureCheck;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'off_shelf_check')]")
    public WebElement offShelfCheck;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'petrol_check')]")
    public WebElement petrolCheck;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'tv_count_title')]")
    public List<WebElement> scheduleCountList;





    /**
     * Public Methods
     */
    public void verifyScheduleCountHeader(String countName) throws Throwable {
        CommonHelperMethods.verifyIfDisplayed(driveR,toDoText );
        CommonHelperMethods.verifyIfDisplayed(driveR,reviewText );

        for (WebElement scheduleCount : scheduleCountList) {
            String scheduleName = scheduleCount.getText();
            log.info("Weekly schedule------------ " + scheduleName);
            if(scheduleName.equalsIgnoreCase(countName)){
                Assert.assertEquals(scheduleName,countName);
                break;

            }

        }
    }

    public void verifyCountLocationVisible() throws Throwable {
        CommonHelperMethods.verifyIfDisplayed(driveR,petrolText );
        CommonHelperMethods.verifyIfDisplayed(driveR,warehouseText );
        CommonHelperMethods.verifyIfDisplayed(driveR,fixtureText);
        CommonHelperMethods.verifyIfDisplayed(driveR,offShelfText);

    }
    public void verifyLocationDisabled() throws Throwable {
        CommonHelperMethods.verifyFieldIsDisabled(offShelfText);
    }
    public void verifyLocationEnabled() throws Throwable {
        CommonHelperMethods.verifyFieldIsDisabled(offShelfText);
    }


    public void  clickOnWarehouse() throws InterruptedException {
        log.info("Clicking on WareHouse");
        Thread.sleep(5000);
        warehouseText.click();
    }
    public void  clickOnFixture() throws InterruptedException {
        log.info("Clicking on Fixture");
        Thread.sleep(5000);
        fixtureText.click();
    }
    public void  clickOnOffshelf() throws InterruptedException {
        log.info("Clicking on Offshelf");
        Thread.sleep(5000);
        offShelfText.click();
    }

    public void  clickOnPetrol() throws InterruptedException {
        log.info("Clicking on Petrol");
        Thread.sleep(5000);
        petrolText.click();
    }


    public void verifyAlert(String alertText) {
        String strtAlert=CountStrtalertText.getText();
        Assert.assertEquals(strtAlert,alertText);

    }

    public void verifyCountElapsedAlert(String alertText) {
        String strtAlert=CountEndalertText.getText();
        Assert.assertEquals(strtAlert,alertText);

    }

    public void countNotDisplayed() throws InterruptedException {
        boolean isAlertPresent = false;
        try {
            WebElement xpathClearanceMessage = driveR
                    .findElement(By.xpath("//android.widget.TextView[contains(@resource-id ,'tv_count_title')]"));
            xpathClearanceMessage.isDisplayed();
        } catch (Exception e) {
            Thread.sleep(3000);
            isAlertPresent = true;
        }

        assertEquals(isAlertPresent, true, "Alert is displayed");


    }

    public void verifyCountStatus(String countName, String status) {
        reviewText.click();
      String reviewCountNameTxt=reviewCountName.getText();
      String reviewCountStatusTxt = reviewCountStatus.getText();
      Assert.assertEquals(reviewCountNameTxt,countName);
        Assert.assertEquals(reviewCountStatusTxt,status);

    }

    public void verifyUncheckedStatus() {
        CommonHelperMethods.verifyFieldIsDisabled(offShelfCheck);
        CommonHelperMethods.verifyFieldIsDisabled(wareHouseCheck);
        CommonHelperMethods.verifyFieldIsDisabled(fixtureCheck);
        CommonHelperMethods.verifyFieldIsDisabled(petrolCheck);
    }

    public void verifyCheckedStatus() {
        offShelfCheck.isEnabled();
        wareHouseCheck.isEnabled();
        fixtureCheck.isEnabled();
        petrolCheck.isEnabled();
    }

    public void verifyCompleteCountDisplayed() {
        reviewCompleteCountName.isDisplayed();
    }

    public void verifyProductDetailsDisplayed(){
//        productAdjValue.isDisplayed();
        productreviewMin.isDisplayed();
        productDesc.isDisplayed();

    }

    public void clickItem() {
        productreviewMin.click();
    }

    public void clickonApproval() {
        approval.click();
        approveButton.click();
    }

    public void clickonApprovalforColuser() {
        approval.click();
        CommonHelperMethods.verifyFieldIsDisabled(approveButton);


    }

    public void clickOnView() {
        reviewEditButton.click();
    }

    public void alertDisplayed() {
        confirmAlertBox.isDisplayed();
        confirmAlert.click();

    }


}



