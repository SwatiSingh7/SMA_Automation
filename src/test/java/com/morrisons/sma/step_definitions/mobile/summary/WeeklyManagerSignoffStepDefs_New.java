package com.morrisons.sma.step_definitions.mobile.summary;

import com.morrisons.sma.page_objects.mobile.summary.WeeklyManagerSignOffPO_New;
import io.cucumber.java.en.And;
import org.apache.log4j.Logger;

public class WeeklyManagerSignoffStepDefs_New {

    private final Logger log = Logger.getLogger(WeeklyManagerSignoffStepDefs_New.class);
    WeeklyManagerSignOffPO_New WeeklyManagerSignOffPONew = new WeeklyManagerSignOffPO_New();

    @And("I verify date range and Weekly Manager Sign Off status {string}")
    public void iVerifyDateRangeAndWeeklyManagerSignOffStatus(String status) {
        WeeklyManagerSignOffPONew.verifyDateRangeAndWeeklyManagerSignOffStatus(status);
    }

    @And("I verify unrecorded waste as Weekly Manager")
    public void iVerifyUnrecordedWasteAsWeeklyManager() {
        WeeklyManagerSignOffPONew.iVerifyUnrecordedWaste();
    }

    @And("I verify Weekly Wastage Validation Completion is displayed")
    public void iVerifyWeeklyWastageValidationCompletionIsDisplayed() {
        WeeklyManagerSignOffPONew.verifyWeeklyWastageValidationCompletion();
    }

    @And("I verify Weekly Weekly Department Completion is displayed")
    public void iVerifyWeeklyWeeklyDepartmentCompletionIsDisplayed() {
        WeeklyManagerSignOffPONew.verifyWeeklyDepartmentCompletion();
    }

    @And("I verify list of days with the status {string}")
    public void iVerifyListOfDaysWithStatusComplete(String status) {
        WeeklyManagerSignOffPONew.verifyListOfDaysWithStatusComplete(status);
    }

    @And("I verify list of days with status {string}")
    public void iVerifyListOfDaysWithStatusIncomplete(String status) {
        WeeklyManagerSignOffPONew.verifyListOfDaysWithStatusIncomplete(status);
    }

    @And("I click on any day system should redirect to {string} tab")
    public void iClickOnAnyDaySystemShouldRedirectToTab(String tab) {
        WeeklyManagerSignOffPONew.clickOnAnyDay(tab);
    }

    @And("I verify {string} button is displayed")
    public void iVerifyButtonIsDisplayed(String button) {
        WeeklyManagerSignOffPONew.verifySignOffButton(button);
    }

    @And("I click on Weekly Wastage Validation Completion view")
    public void iClickOnWeeklyWastageValidationCompletionView() {
        WeeklyManagerSignOffPONew.clickOnWeeklyWastageValidationCompletion();
    }

    @And("I click on Weekly Department Completion view")
    public void iClickOnWeeklyDepartmentCompletionView() {
        WeeklyManagerSignOffPONew.clickOnWeeklyDepartmentCompletion();
    }

    @And("I view two tabs {string} and {string}")
    public void iViewTwoTabsAnd(String tab1, String tab2) {
        WeeklyManagerSignOffPONew.verifyTabs(tab1, tab2);
    }

    @And("I verify item check details for a day if all trays are completed with {string} status")
    public void iVerifyItemCheckDetailsForADayIfAllTraysAreCompletedWithStatus(String status) {
        WeeklyManagerSignOffPONew.verifyDetailsIfAllTraysCompleted(status);
    }

    @And("I verify item check details for a day if no trays are completed with {string} status")
    public void iVerifyItemCheckDetailsForADayIfNoTraysAreCompletedWithStatus(String status) throws InterruptedException {
        WeeklyManagerSignOffPONew.verifyDetailsIfANoTraysCompleted(status);
    }

    @And("I click Departments tab")
    public void iClickDepartmentTab() {
        WeeklyManagerSignOffPONew.clickDeptTab();
    }

    @And("I click Checks tab")
    public void iClickChecksTab() {
        WeeklyManagerSignOffPONew.clickCheckTab();
    }

    @And("I verify Department,Pass,Fail,Waste column")
    public void iVerifyDepartmentPassFailWasteColumn() {
        WeeklyManagerSignOffPONew.verifyDepartmentTab();
    }

    @And("I verify Department Waste column is in descending order")
    public void iVerifyDepartmentWasteColumnIsInDescendingOrder() {
        WeeklyManagerSignOffPONew.verifyWasteInDescOrder();
    }
}
