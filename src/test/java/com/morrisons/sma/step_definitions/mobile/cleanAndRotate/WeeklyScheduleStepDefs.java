package com.morrisons.sma.step_definitions.mobile.cleanAndRotate;

import com.morrisons.sma.page_objects.mobile.cleanAndRotate.WeeklySchedule;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;

public class WeeklyScheduleStepDefs {

    WeeklySchedule weeklySchedule = new WeeklySchedule();

    @Then("I Select Weekly schedule for {string}")
    public void selectWeek(String week) throws Throwable {
        weeklySchedule.selectWeek(week);
    }

    @Then("I Verify for {string} schedule status is {string}")
    public void verifyScheduleStatus(String week,String status) throws Throwable {
        weeklySchedule.verifyScheduleStatus(week,status);
    }

    @Then("I Scroll down on Weekly schedule page")
    public void scrollDown() throws Throwable {
        weeklySchedule.scrollDown();
    }
    @Then("I verify Currently unavailable alert with {string} is displayed")
    public void verifyNotAlertAviailabilityStatus(String expectedMessage) throws Throwable {
        weeklySchedule.verifyAlertAvailability(expectedMessage);
    }
    @Then("I Verify Current Week is not displayed in Weekly schedule")
    public void verifyWeekNotDisplayed() throws Throwable {
        weeklySchedule.verifyWeeklyScheduleIsRemoved();
    }

    @And("I verify Weekly Schedule status is same on UI and GetSchedule Service")
    public void verifyUIStatusWithService() throws Throwable {
        weeklySchedule.verifyUIStatusWithService();
    }

    @Then("I Get First Weekly schedule status")
    public void getFirstWeekScheduleStatus() throws Throwable {
        weeklySchedule.getFirstWeekScheduleStatus();
    }

    @And("I Verify Weekly schedule Submenu status is same as First Weekly Schedule status inside week schedule")
    public void verifyStatusIsSame() throws Throwable {
        weeklySchedule.verifyStatusIsSame();
    }

    @And("I Select Weekly schedule")
    public void iSelectWeeklySchedule(List<String> prodDescription) throws Throwable {
        weeklySchedule.selectWeeklySchedule();
    }

    @And("I Select Daily schedule for {string}")
    public void iSelectDailyScheduleFor(String sDate) throws Throwable {
        weeklySchedule.selectScheduleDate(sDate);
    }

    @Then("I Scroll down on Daily schedule page")
    public void iScrollDownOnDailySchedulePage() throws InterruptedException {
        weeklySchedule.scrollDownToGivenDate();
    }
}
