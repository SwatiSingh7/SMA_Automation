package com.morrisons.sma.pojo.service.cleanAndRotate.getSchedule;

import lombok.Value;

@Value
public class ScheduleResponse {
    Integer locationId;
    Integer year;
    Integer weekNumber;
    String startDate;
    String status;
    Object category;
    Object setSummaryDate;
    Object setSummaryStatus;
    Object freshCodeDateCheck;
    Object dailyFreshCodeCheckSchedule;
}
