package com.morrisons.sma.pojo.service.CodecheckServicePOJO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Codecheck_DeptAlertConstraint {

	@JsonProperty("deptId")
	private List<String> deptId;
	
	@JsonProperty("alertId")
	private List<String> alertId;

	public List<String> getDeptId() {
		return deptId;
	}

	public void setDeptId(List<String> deptId) {
		this.deptId = deptId;
	}

	public List<String> getAlertId() {
		return alertId;
	}

	public void setAlertId(List<String> alertId) {
		this.alertId = alertId;
	}

	@Override
	public String toString() {
		return "Codecheck_DeptAlertConstraint [deptId=" + deptId + ", alertId=" + alertId + "]";
	}

	
	
	
//	@JsonProperty("deptId")
//	private String deptId;
//	
//	@JsonProperty("alertId")
//	private String alertId;
//
//	public String getDeptId() {
//		return deptId;
//	}
//
//	public void setDeptId(String deptId) {
//		this.deptId = deptId;
//	}
//
//	public String getAlertId() {
//		return alertId;
//	}
//
//	public void setAlertId(String alertId) {
//		this.alertId = alertId;
//	}
//	
//
//	@Override
//	public String toString() {
//		return "Codecheck_DeptAlertConstraint [deptId=" + deptId + ", alertId=" + alertId + "]";
//	}

}
