package com.morrisons.sma.pojo.service.SalesOrderServicePOJO;

import java.util.List;

public class SalesOrder_RootProducts {

	public String locationId;
    public String categoryId;
    public String locationCategoryId;
    public List<SalesOrder_ForecastItem> items;
    public SalesOrder_Metadata metadata;
    
    
    
	public String getLocationId() {
		return locationId;
	}



	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}



	public String getCategoryId() {
		return categoryId;
	}



	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}



	public String getLocationCategoryId() {
		return locationCategoryId;
	}



	public void setLocationCategoryId(String locationCategoryId) {
		this.locationCategoryId = locationCategoryId;
	}



	public List<SalesOrder_ForecastItem> getItems() {
		return items;
	}



	public void setItems(List<SalesOrder_ForecastItem> items) {
		this.items = items;
	}



	public SalesOrder_Metadata getMetadata() {
		return metadata;
	}



	public void setMetadata(SalesOrder_Metadata metadata) {
		this.metadata = metadata;
	}



	@Override
	public String toString() {
		return "SalesOrder_RootProducts [locationId=" + locationId + ", categoryId=" + categoryId
				+ ", locationCategoryId=" + locationCategoryId + ", items=" + items + ", metadata=" + metadata + "]";
	}
    
    
    
}
