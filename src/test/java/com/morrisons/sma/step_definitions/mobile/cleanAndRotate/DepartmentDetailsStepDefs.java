package com.morrisons.sma.step_definitions.mobile.cleanAndRotate;

import com.morrisons.sma.page_objects.mobile.cleanAndRotate.DepartmentDetails;
import io.cucumber.java.en.Then;

public class DepartmentDetailsStepDefs {

    DepartmentDetails departmentDetails = new DepartmentDetails();

    @Then("I Verify Department details page")
    public void verifyTitleAndMsg() throws Throwable {
        departmentDetails.verifyTitleAndMsg();
    }
}
