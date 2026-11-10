package com.morrisons.sma.pojo.service.CodecheckServicePOJO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Codecheck_MarkdownAlertRule {
	
	@JsonProperty("alertId")
	private List<String> alertId;
	
	@JsonProperty("alertName")
	private List<String> alertName;
	
	@JsonProperty("alertDayMaxBeforeExpiry")
	private List<String> alertDayMaxBeforeExpiry;
	
	@JsonProperty("alertDayMinBeforeExpiry")
	private List<String> alertDayMinBeforeExpiry;

	public List<String> getAlertId() {
		return alertId;
	}

	public void setAlertId(List<String> alertId) {
		this.alertId = alertId;
	}

	public List<String> getAlertName() {
		return alertName;
	}

	public void setAlertName(List<String> alertName) {
		this.alertName = alertName;
	}

	public List<String> getAlertDayMaxBeforeExpiry() {
		return alertDayMaxBeforeExpiry;
	}

	public void setAlertDayMaxBeforeExpiry(List<String> alertDayMaxBeforeExpiry) {
		this.alertDayMaxBeforeExpiry = alertDayMaxBeforeExpiry;
	}

	public List<String> getAlertDayMinBeforeExpiry() {
		return alertDayMinBeforeExpiry;
	}

	public void setAlertDayMinBeforeExpiry(List<String> alertDayMinBeforeExpiry) {
		this.alertDayMinBeforeExpiry = alertDayMinBeforeExpiry;
	}

	@Override
	public String toString() {
		return "Codecheck_MarkdownAlertRule [alertId=" + alertId + ", alertName=" + alertName
				+ ", alertDayMaxBeforeExpiry=" + alertDayMaxBeforeExpiry + ", alertDayMinBeforeExpiry="
				+ alertDayMinBeforeExpiry + "]";
	}
	
	
	
//	@JsonProperty("alertId")
//	private String alertId;
//	
//	@JsonProperty("alertName")
//	private String alertName;
//	
//	@JsonProperty("alertDayMaxBeforeExpiry")
//	private String alertDayMaxBeforeExpiry;
//	
//	@JsonProperty("alertDayMinBeforeExpiry")
//	private String alertDayMinBeforeExpiry;
//
//	public String getAlertId() {
//		return alertId;
//	}
//
//	public void setAlertId(String alertId) {
//		this.alertId = alertId;
//	}
//
//	public String getAlertName() {
//		return alertName;
//	}
//
//	public void setAlertName(String alertName) {
//		this.alertName = alertName;
//	}
//
//	public String getAlertDayMaxBeforeExpiry() {
//		return alertDayMaxBeforeExpiry;
//	}
//
//	public void setAlertDayMaxBeforeExpiry(String alertDayMaxBeforeExpiry) {
//		this.alertDayMaxBeforeExpiry = alertDayMaxBeforeExpiry;
//	}
//
//	public String getAlertDayMinBeforeExpiry() {
//		return alertDayMinBeforeExpiry;
//	}
//
//	public void setAlertDayMinBeforeExpiry(String alertDayMinBeforeExpiry) {
//		this.alertDayMinBeforeExpiry = alertDayMinBeforeExpiry;
//	}
//
//	@Override
//	public String toString() {
//		return "Codecheck_MarkdownAlertRule [alertId=" + alertId + ", alertName=" + alertName
//				+ ", alertDayMaxBeforeExpiry=" + alertDayMaxBeforeExpiry + ", alertDayMinBeforeExpiry="
//				+ alertDayMinBeforeExpiry + "]";
//	}
//	
	
}
