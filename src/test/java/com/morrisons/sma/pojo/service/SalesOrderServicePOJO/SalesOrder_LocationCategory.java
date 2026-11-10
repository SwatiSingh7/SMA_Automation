package com.morrisons.sma.pojo.service.SalesOrderServicePOJO;

import java.util.List;

public class SalesOrder_LocationCategory {

	public String locationId;
	public List<String> categoryIds;

	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public List<String> getCategoryIds() {
		return categoryIds;
	}
	public void setCategoryIds(List<String> categoryIds) {
		this.categoryIds = categoryIds;
	}
	@Override
	public String toString() {
		return "SalesOrder_LocationCategory [locationId=" + locationId + ", categoryIds=" + categoryIds + "]";
	}


}
