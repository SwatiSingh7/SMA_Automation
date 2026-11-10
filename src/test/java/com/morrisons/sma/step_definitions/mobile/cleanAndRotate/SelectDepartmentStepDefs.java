package com.morrisons.sma.step_definitions.mobile.cleanAndRotate;

import com.morrisons.sma.page_objects.mobile.cleanAndRotate.DepartmentDetails;
import com.morrisons.sma.page_objects.mobile.cleanAndRotate.SelectDepartment;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class SelectDepartmentStepDefs {

    SelectDepartment selectDepartmentPO = new SelectDepartment();
    DepartmentDetails departmentDetails = new DepartmentDetails();
    private String deptName = null;

    @Then("I Verify Department page")
    public void verifyPage() throws Throwable {
        selectDepartmentPO.verifyDeptPage();
    }

    @Then("I Select Department")
    public void selectDepartment() throws Throwable {
        deptName = GetDeptAndMin.departmentNameUI;
        selectDepartmentPO.selectDepartment(deptName);
    }

    @Then("I Verify Department status is {string}")
    public void verifyDepartmentStatus(String status) throws Throwable {
        selectDepartmentPO.verifyDepartmentStatus(status);
    }

    @Then("I complete code rotate for the departments")
    public void completeCodeRotate() throws Throwable {
        selectDepartmentPO.completeCodeRotateDepartment();
    }

    @Then("I get action and quantity on UI")
    public void getActionAndQuantity() throws Throwable {
        departmentDetails.iGetActionAndQuantity();
    }

    @Then("I Verify Sign off Code Rotate button is getting displayed")
    public void iVerifySignoffcodeRotaeButtondisplayed() throws Throwable {
        selectDepartmentPO.verifyCodeRotateButtonDisplayed();
    }

    @Then("I verify Confirm Sign off Alert is displayed")
    public void iVerifySignoffAlertdisplayed() throws Throwable {
        selectDepartmentPO.verifySignoffAlertDisplayed();
    }

    @Then("I verify Sign off code rotate button is enabled")
    public void iVerifySignoffCodeRotateisEnabled() throws Throwable {
        selectDepartmentPO.verifySignoffButtonEnabled();
    }

    @Then("I verify Sign off code rotate button is not enabled")
    public void verifySignoffButtonNotEnabled() throws Throwable {
        selectDepartmentPO.verifySignoffButtonDisabled();
    }

    @Then("I verify Action and quantity on UI and service is same")
    public void iVerifyActionAndQuantity() throws Throwable {
        departmentDetails.iVerifyActionAndQuantity();
    }


    @Then("I click on Confirm button on Confirm Sign off Alert")
    public void iClickonConfirmButton() throws Throwable {
        selectDepartmentPO.clickOnConfirmSignoffButton();
    }

    @Then("I click on Cancel button on Confirm Sign off Alert")
    public void iClickonCancelButton() throws Throwable {
        selectDepartmentPO.clickOnCancelSignoffButton();
    }

    @Then("I click on Sign-Off Code Rotate button on week page")
    public void iClickOnSignoffButton() throws Throwable {
        selectDepartmentPO.clickOnSignoffButton();
    }

    @Given("I verify Department status is same on UI and API")
    public void iVerifyDeptStatus() throws Throwable {
        selectDepartmentPO.iVerifyDeptStatus();

    }

    @Then("I Verify Department Completion Message")
    public void verifyDepartmentCompletionStatus() throws Throwable {
        selectDepartmentPO.verifyDepartmentCompletionStatus();
    }

    @And("I Select {string}")
    public void iSelect(String deptName) throws Throwable {
        selectDepartmentPO.selectDepartment(deptName);
    }
}
