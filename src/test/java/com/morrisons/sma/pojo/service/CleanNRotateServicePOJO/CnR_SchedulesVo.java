package com.morrisons.sma.pojo.service.CleanNRotateServicePOJO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CnR_SchedulesVo {
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	@JsonProperty("schedules")
	private List<CnR_Schedules> schedules;

	
	public List<CnR_Schedules> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<CnR_Schedules> schedules) {
		this.schedules = schedules;
	}

	@Override
	public String toString() {
		return "MainClassPojo [schedules=" + schedules + "]";
	}

}
