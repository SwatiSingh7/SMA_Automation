package com.morrisons.sma.pojo.service.CleanNRotateServicePOJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class CnR_Schedules
{
	@JsonIgnoreProperties(ignoreUnknown=true)
	private Integer locationId;
	@JsonIgnoreProperties(ignoreUnknown=true)
	private Integer year;
	@JsonIgnoreProperties(ignoreUnknown=true)
	private String weekNumber;
	@JsonIgnoreProperties(ignoreUnknown=true)
	private String startDate;
	@JsonIgnoreProperties(ignoreUnknown=true)
	private String status;
	public Integer getLocationId() {
		return locationId;
	}
	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public String getWeekNumber() {
		return weekNumber;
	}
	public void setWeekNumber(String weekNumber) {
		this.weekNumber = weekNumber;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Schedules [locationId=" + locationId + ", year=" + year + ", weekNumber=" + weekNumber + ", startDate="
				+ startDate + ", status=" + status + "]";
	}   
}