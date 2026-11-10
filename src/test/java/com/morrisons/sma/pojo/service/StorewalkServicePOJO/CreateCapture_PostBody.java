package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

public class CreateCapture_PostBody {

	String location;
	int value;
	int sectionId;
	String captureType;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getSectionId() {
		return sectionId;
	}
	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}
	public String getCaptureType() {
		return captureType;
	}
	public void setCaptureType(String captureType) {
		this.captureType = captureType;
	}
	@Override
	public String toString() {
		return "CreateCapture_PostBody [location=" + location + ", value=" + value + ", sectionId=" + sectionId
				+ ", captureType=" + captureType + "]";
	}
	
	
}
