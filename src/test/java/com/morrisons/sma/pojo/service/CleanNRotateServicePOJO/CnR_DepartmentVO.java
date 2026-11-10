package com.morrisons.sma.pojo.service.CleanNRotateServicePOJO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "locationId", "year", "weekNo", "departments" })
public class CnR_DepartmentVO {

	@JsonProperty("locationId")
	private String storeId;

	@JsonProperty("year")
	private String year;

	@JsonProperty("weekNo")
	private String weekNo;

	@JsonProperty("departments")
	private List<CnR_Department> departments;

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getWeekNo() {
		return weekNo;
	}

	public void setWeekNo(String weekNo) {
		this.weekNo = weekNo;
	}

	public List<CnR_Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<CnR_Department> departments) {
		this.departments = departments;
	}

	@Override
	public String toString() {
		return "DepartmentVO [storeId=" + storeId + ", year=" + year + ", weekNo=" + weekNo + ", departments="
				+ departments + "]";
	}
	
	

}