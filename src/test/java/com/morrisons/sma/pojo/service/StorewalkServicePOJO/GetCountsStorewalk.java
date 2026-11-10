package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

import java.util.List;

public class GetCountsStorewalk {

	
	private List<GetCountsStorewalkRoot> storewalks;

	public List<GetCountsStorewalkRoot> getStorewalks() {
		return storewalks;
	}

	public void setStorewalks(List<GetCountsStorewalkRoot> storewalks) {
		this.storewalks = storewalks;
	}

	@Override
	public String toString() {
		return "GetCountsStorewalk [storewalks=" + storewalks + "]";
	}
	
	
}
