package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "StoreWalkItems"
})

public class Storewalk_GetStorewalkItems {
	
	
	    @JsonProperty("StoreWalkItems")
	    public List<StoreWalkItem> storeWalkItems = null;

		public List<StoreWalkItem> getStoreWalkItems() {
			return storeWalkItems;
		}

		public void setStoreWalkItems(List<StoreWalkItem> storeWalkItems) {
			this.storeWalkItems = storeWalkItems;
		}

		@Override
		public String toString() {
			return "Storewalk_GetStorewalkItems [storeWalkItems=" + storeWalkItems + "]";
		}

	}


