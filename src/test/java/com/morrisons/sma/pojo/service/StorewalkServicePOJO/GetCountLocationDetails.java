package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

public class GetCountLocationDetails {

	 private String countLocation;
	 private String countStatus;
	 
	public String getCountLocation() {
		return countLocation;
	}
	public void setCountLocation(String countLocation) {
		this.countLocation = countLocation;
	}
	public String getCountStatus() {
		return countStatus;
	}
	public void setCountStatus(String countStatus) {
		this.countStatus = countStatus;
	}
	@Override
	public String toString() {
		return "GetCounLocationDetails [countLocation=" + countLocation + ", countStatus=" + countStatus + "]";
	}
	 
	 
	
}
