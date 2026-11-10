package com.morrisons.sma.pojo.service.SalesOrderServicePOJO;

import java.util.List;

public class SalesOrder_RootItem {

	public String locationId;
    public String categoryId;
    public List<SalesOrder_Item> items;
    
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
	public List<SalesOrder_Item> getItems() {
		return items;
	}
	public void setItems(List<SalesOrder_Item> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "SalesOrder_RootItem [locationId=" + locationId + ", categoryId=" + categoryId + ", items=" + items
				+ "]";
	}
    
    
	    
}
