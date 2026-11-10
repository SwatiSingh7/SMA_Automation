package com.morrisons.sma.step_definitions.service.cleanAndRotate;

import com.google.inject.Inject;
import com.morrisons.common.helper.CommonHelperMethods;
import com.morrisons.common.utility.ApplicationContext;
import com.morrisons.common.utility.WebServicesUtilities;
import com.morrisons.sma.page_objects.mobile.cleanAndRotate.WeeklySchedule;
import com.morrisons.sma.page_objects.service.cleanAndRotate.ScheduleService;
import com.morrisons.sma.pojo.service.cleanAndRotate.getSchedule.ScheduleResponse;
import com.morrisons.sma.step_definitions.service.Login.LoginStepDef;
import com.morrisons.sma.step_definitions.service.old.StorewalkStepDefService;
import io.cucumber.java.en.Given;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class ScheduleStepDef {
    public static final String SCHEDULE_SERVICE_BASE_URL = "https://sit-api.morrisons.com/cleanrotate/v1";
    private final Logger log = Logger.getLogger(ScheduleStepDef.class);
    private ApplicationContext applicationContext;
    LoginStepDef loginStepdef;
    int weekNumberDept;
    public static String startDate, weeklyScheduleStatus;
    String weekNumber = CommonHelperMethods.getWeekoftheyear();
    WeeklySchedule weeklySchedule = new WeeklySchedule();

    @Inject
    public ScheduleStepDef(ApplicationContext applicationContext) throws InterruptedException {
        this.applicationContext = applicationContext;
    }

    @Given("I get the schedule details through API")
    public void iGetScheduleDetails() throws Throwable {
        log.info("Getting Response for " + SCHEDULE_SERVICE_BASE_URL + "/locations/" + ApplicationContext.STORE_ID + "/schedules?");
        String jsonResponseString = WebServicesUtilities.retryGETRequestWithHeader(SCHEDULE_SERVICE_BASE_URL, "/locations/" + ApplicationContext.STORE_ID + "/schedules", "apikey", "ZwQGsEN0f65kORZ8EVQlJWA2bGNbHls0", "WEEKS", weekNumber, "Authorization", "Bearer " + StorewalkStepDefService.accessToken);

        List<ScheduleResponse> scheduleList = new ScheduleService().getScheduleResponse(jsonResponseString);
        log.info("No. Of Scheudles : " + scheduleList.size());
        String weeklyScheduleUI = weeklySchedule.getWeeklyScheduleUI();
        for (int scheduleIndex = 0; scheduleIndex <= scheduleList.size() - 1; scheduleIndex++)
            if (weeklyScheduleUI.equalsIgnoreCase(scheduleList.get(scheduleIndex).getStartDate())) {

                weeklyScheduleStatus = scheduleList.get(scheduleIndex).getStatus();
                log.info("Weekly schedule status : " + weeklyScheduleStatus);

                startDate = scheduleList.get(scheduleIndex).getStartDate();
                log.info("Weekly schedule Start Date : " + startDate);

                weekNumberDept = scheduleList.get(scheduleIndex).getWeekNumber();
                log.info("Week number : " + weekNumberDept);
            }
    }
}
