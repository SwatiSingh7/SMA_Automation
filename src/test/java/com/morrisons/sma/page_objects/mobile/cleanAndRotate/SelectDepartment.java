package com.morrisons.sma.page_objects.mobile.cleanAndRotate;

import com.morrisons.common.action.Hook;
import com.morrisons.common.helper.CommonHelperMethods;
import com.morrisons.sma.step_definitions.mobile.cleanAndRotate.GetDeptAndMin;
import com.morrisons.sma.step_definitions.service.cleanAndRotate.DepartmentServiceStepDef;
import io.appium.java_client.MobileBy;
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

import java.util.List;


public class SelectDepartment {

    private static AndroidDriver driveR;
    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    private final Logger log = Logger.getLogger(SelectDepartment.class);
    String actulDepartmentStatus = null;

    public SelectDepartment() {
        log.info("Inside : " + SelectDepartment.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    /**
     * Web Elements
     */

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Select a product group']")
    public WebElement productGrpHeader;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'department_title')]")
    public List<WebElement> allDepts;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@resource-id='android:id/message']")
    public WebElement signOffAlertMsg;
    @FindBy(how = How.XPATH, using = "//android.widget.Button[@text='CANCEL']")
    public WebElement signOffCancel;
    @FindBy(how = How.XPATH, using = "//android.widget.Button[@text='CONFIRM']")
    public WebElement signOffConfirm;
    @FindBy(how = How.XPATH, using = "//android.widget.Button[@text='SIGN-OFF CODE ROTATE']")
    public WebElement signOffCodeRotateButton;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Confirm Sign-Off']")
    public WebElement signOffAlertTitle;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'department_title')]")
    public List<WebElement> totalDepartmentList;

    @FindBy(how = How.XPATH, using = "//android.widget.ImageView[contains(@resource-id,'singleItemIcon')]")
    public WebElement viewList;

    @FindBy(how = How.XPATH, using = "//android.widget.Button[contains(@resource-id,'inner_button')]")
    public WebElement completeCodeRotateGrpBtn;

    @FindBy(how = How.XPATH, using = "//android.widget.Button[@text='CONFIRM']")
    public WebElement confirmCodeRotateGrpBtn;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'description')]")
    public WebElement completionMessage;


    public void verifyDeptPage() throws Throwable {
        log.info("Verifying Department page");
        CommonHelperMethods.verifyIfDisplayed(driveR, productGrpHeader);
    }

    public void selectDepartment(String expectedDept) throws Throwable {
        log.info("Selecting department : " + expectedDept);
        log.info("Total departments : " + allDepts.size());
        for (WebElement dept : allDepts) {
            String actualDept = dept.getText();
            log.info("Department name : " + actualDept);
            if (actualDept.equalsIgnoreCase(expectedDept)) {
                dept.click();
                break;
            }
        }
    }

    public void verifyDepartmentStatus(String exepectedStatus) throws Throwable {
        WebElement xpathDepartmentStatus = null;
        String departmentName = GetDeptAndMin.departmentNameUI;

        try {
            xpathDepartmentStatus = driveR.findElement(By.xpath("//android.widget.TextView[@text='"
                    + departmentName + "']/following-sibling::android.widget.TextView[contains(@resource-id,'department_status')]"));

            actulDepartmentStatus = xpathDepartmentStatus.getText();
            log.info("Department status is : " + actulDepartmentStatus);
        } catch (Exception e) {
            actulDepartmentStatus = "ToStart";
            log.info("Department status is : " + actulDepartmentStatus);
        }
        Assert.assertEquals(actulDepartmentStatus, exepectedStatus, "Department status is mismatched");
    }

    public void verifySignoffAlertDisplayed() throws Throwable {
         CommonHelperMethods.verifyIfDisplayed(driveR, signOffAlertMsg);
         String actualMessage = signOffAlertMsg.getText();
         log.info("Sign off message is " + actualMessage);
         Assert.assertEquals(actualMessage,"Please confirm all scheduled checks have been fully completed, fixtures have been cleaned and all products with a relevant expiry date have been actioned.\n\nOnce confirmed this week's check will be archived and cannot be amended","Sign off message is mismatched");
         CommonHelperMethods.verifyIfDisplayed(driveR, signOffCancel);
        CommonHelperMethods.verifyIfDisplayed(driveR, signOffConfirm);

    }


    public void clickOnCompleteCodeRotate() throws Throwable {
        completeCodeRotateGrpBtn.isDisplayed();
        completeCodeRotateGrpBtn.click();
        try {
            confirmCodeRotateGrpBtn.click();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    public void verifySignoffButtonEnabled() throws Throwable {
        String isEnabled = signOffCodeRotateButton.getAttribute("enabled");
        Assert.assertEquals(isEnabled, "true", "Sign-off button is not enabled");
    }

    public void verifySignoffButtonDisabled() throws Throwable {
        String isEnabled = signOffCodeRotateButton.getAttribute("enabled");
        Assert.assertEquals(isEnabled, "false", "Sign-off button is enabled");
    }

    public void clickOnSignoffButton() throws Throwable {
        signOffCodeRotateButton.click();
    }

    public void clickOnConfirmSignoffButton() throws Throwable {
        signOffConfirm.click();
    }

    public void clickOnCancelSignoffButton() throws Throwable {
        signOffCancel.click();
    }


    public void verifyCodeRotateButtonDisplayed() throws Throwable {
        CommonHelperMethods.verifyIfDisplayed(driveR, signOffCodeRotateButton);

    }


    public void completeCodeRotateDepartment() throws Throwable {
        int index;
        Thread.sleep(3000);

        for (index = 0; index < totalDepartmentList.size(); index++) {

            WebElement xpathDepartmentTitle = driveR
                    .findElement(By.xpath("//android.widget.RelativeLayout[@index='" + index
                            + "']/android.widget.TextView[contains(@resource-id,'department_title')]"));

            String deptName = xpathDepartmentTitle.getText();
            log.info(deptName);

            String deptStatus = null;
            try {
                WebElement xpathDepartmentStatus = driveR
                        .findElement(MobileBy.xpath("//android.widget.RelativeLayout[@index='" + index
                                + "']/android.widget.TextView[contains(@resource-id,'department_status')]"));

                deptStatus = xpathDepartmentStatus.getText();
                log.info(deptStatus);
            } catch (Exception e) {

                deptStatus = "Not Started";
                log.info(deptStatus);
            }

            if (deptStatus.equals("Not Started") || deptStatus.equals("In Progress")) {
                xpathDepartmentTitle.click();

                if (deptStatus.equals("In Progress")) {

                    if (isViewListPresent()) {
                        viewList.click();
                        log.info("Click on view list");
                    }
                }

                clickOnCompleteCodeRotate();
            }

            WebElement xpathDepartmentStatus = driveR
                    .findElement(MobileBy.xpath("//android.widget.RelativeLayout[@index='" + index
                            + "']/android.widget.TextView[contains(@resource-id,'department_status')]"));

            deptStatus = xpathDepartmentStatus.getText();

            Assert.assertEquals(deptStatus, "Completed", "Department status is mismatched");
        }
    }

    public boolean isViewListPresent() throws Throwable {
        boolean isViewList = false;
        try {
            WebElement xpathViewList = driveR
                    .findElement(By.xpath("//android.widget.ImageView[contains(@resource-id,'singleItemIcon')]"));
            isViewList = xpathViewList.isDisplayed();
        } catch (NoSuchElementException e) {
        }
        return isViewList;
    }

    public void iVerifyDeptStatus() {
        log.info("Verifying department status is same on UI and service");
        String deptStatusService = DepartmentServiceStepDef.status;

        Assert.assertEquals(actulDepartmentStatus, deptStatusService, "Department status is mismatched on UI and service");
    }

    public void verifyDepartmentCompletionStatus() throws InterruptedException {

        log.info("Verifying Department completion status");
        boolean isMsgDisplayed = completionMessage.isDisplayed();
        Assert.assertEquals(isMsgDisplayed,true,"Completion message is not displayed");

    }


}
