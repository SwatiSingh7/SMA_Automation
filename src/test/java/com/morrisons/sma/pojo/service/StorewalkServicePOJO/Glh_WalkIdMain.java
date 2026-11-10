package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Glh_WalkIdMain {

	@JsonProperty("StoreWalkItems")
	private List<Glh_StoreWalkItems> storeWalkItems = new ArrayList<>();
	
	public List<Glh_StoreWalkItems> getStoreWalkItems() {
		return storeWalkItems;
	}

	public void setStoreWalkItems(List<Glh_StoreWalkItems> storeWalkItems) {
		this.storeWalkItems = storeWalkItems;
	}
	@Override
	public String toString() {
		return "WalkIdMain [storeWalkItems=" + storeWalkItems + "]";
	}

}
