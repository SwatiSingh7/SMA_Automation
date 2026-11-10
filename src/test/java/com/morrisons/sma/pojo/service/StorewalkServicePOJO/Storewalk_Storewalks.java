package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Storewalk_Storewalks {

	@JsonProperty
	private List<Storewalk_GetStorewalk> storewalks;

	public List<Storewalk_GetStorewalk> getStorewalks() {
		return storewalks;
	}

	public void setStorewalks(List<Storewalk_GetStorewalk> storewalks) {
		this.storewalks = storewalks;
	}

	@Override
	public String toString() {
		return "Storewalk_Storewalks [storewalks=" + storewalks + "]";
	}	
}
