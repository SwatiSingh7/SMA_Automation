package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Storewalk_Plan {

	@JsonProperty("class")
	private String class1;
	public String type;
	public String name;
	public String planLocation;
	public String fillQty;
	public String storeWalkSequence;
	
	public String getClass1() {
		return class1;
	}
	public void setClass1(String class1) {
		this.class1 = class1;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlanLocation() {
		return planLocation;
	}
	public void setPlanLocation(String planLocation) {
		this.planLocation = planLocation;
	}
	public String getFillQty() {
		return fillQty;
	}
	public void setFillQty(String fillQty) {
		this.fillQty = fillQty;
	}
	public String getStoreWalkSequence() {
		return storeWalkSequence;
	}
	public void setStoreWalkSequence(String storeWalkSequence) {
		this.storeWalkSequence = storeWalkSequence;
	}
	@Override
	public String toString() {
		return "CreateWalkitem_Plan [class1=" + class1 + ", type=" + type + ", name=" + name + ", planLocation="
				+ planLocation + ", fillQty=" + fillQty + ", storeWalkSequence=" + storeWalkSequence + "]";
	}


}
