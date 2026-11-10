package com.morrisons.sma.pojo.service.CleanNRotateServicePOJO;

import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "departmentId", "departmentConfigId", "departmentCheckId", "departmentName", "nextCheck", "status",
		"createdOn", "createdby","updatedByName","updatedOn" })
public class CnR_Department {

	@JsonProperty("departmentId")
	private String departmentId;

	@JsonProperty("departmentConfigId")
	private BigInteger departmentConfigId;

	@JsonProperty("departmentCheckId")
	private String departmentCheckId;

	@JsonProperty("departmentName")
	private String departmentName;

	@JsonProperty("nextCheck")
	private String nextCheck;

	@JsonProperty("status")
	private String status;
	
	@JsonProperty("updatedByName")
	private String updatedByName;
	
	@JsonProperty("updatedOn")
	private String updatedOn;

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public BigInteger getDepartmentConfigId() {
		return departmentConfigId;
	}

	public void setDepartmentConfigId(BigInteger departmentConfigId) {
		this.departmentConfigId = departmentConfigId;
	}

	public String getDepartmentCheckId() {
		return departmentCheckId;
	}

	public void setDepartmentCheckId(String departmentCheckId) {
		this.departmentCheckId = departmentCheckId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getNextCheck() {
		return nextCheck;
	}

	public void setNextCheck(String nextCheck) {
		this.nextCheck = nextCheck;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	public String getUpdatedByName() {
		return updatedByName;
	}

	public void setUpdatedByName(String updatedByName) {
		this.updatedByName = updatedByName;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentConfigId=" + departmentConfigId
				+ ", departmentCheckId=" + departmentCheckId + ", departmentName=" + departmentName + ", nextCheck="
				+ nextCheck + ", status=" + status + ", updatedByName=" + updatedByName + ", updatedOn=" + updatedOn
				+ "]";
	}

}