package com.morrisons.sma.pojo.service.SalesOrderServicePOJO;

import java.util.List;

public class SalesOrder_RootCategories {

	public List<SalesOrder_Category> category;
	public List<SalesOrder_LocationCategory> locationCategories;
	
	public List<SalesOrder_Category> getCategory() {
		return category;
	}
	public void setCategory(List<SalesOrder_Category> category) {
		this.category = category;
	}
	public List<SalesOrder_LocationCategory> getLocationCategories() {
		return locationCategories;
	}
	public void setLocationCategories(List<SalesOrder_LocationCategory> locationCategories) {
		this.locationCategories = locationCategories;
	}
	@Override
	public String toString() {
		return "SalesOrder_RootCategories [category=" + category + ", locationCategories=" + locationCategories
				+ "]";
	}


}
