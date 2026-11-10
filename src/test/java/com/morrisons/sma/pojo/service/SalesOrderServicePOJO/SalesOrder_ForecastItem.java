package com.morrisons.sma.pojo.service.SalesOrderServicePOJO;

import java.util.List;

public class SalesOrder_ForecastItem {

    public String itemNumber;
    public String itemDescription;
    public String locationCategoryProductId;
    public String departmentId;
    public String productPin;
    public String itemListType;
    public List<SalesOrder_ForecastProductOrder> forecastOrders;
    
	public String getItemNumber() {
		return itemNumber;
	}
	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public String getLocationCategoryProductId() {
		return locationCategoryProductId;
	}
	public void setLocationCategoryProductId(String locationCategoryProductId) {
		this.locationCategoryProductId = locationCategoryProductId;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getProductPin() {
		return productPin;
	}
	public void setProductPin(String productPin) {
		this.productPin = productPin;
	}
	public String getItemListType() {
		return itemListType;
	}
	public void setItemListType(String itemListType) {
		this.itemListType = itemListType;
	}
	public List<SalesOrder_ForecastProductOrder> getForecastOrders() {
		return forecastOrders;
	}
	public void setForecastOrders(List<SalesOrder_ForecastProductOrder> forecastOrders) {
		this.forecastOrders = forecastOrders;
	}
	@Override
	public String toString() {
		return "SalesOrder_Item [itemNumber=" + itemNumber + ", itemDescription=" + itemDescription
				+ ", locationCategoryProductId=" + locationCategoryProductId + ", departmentId=" + departmentId
				+ ", productPin=" + productPin + ", itemListType=" + itemListType + ", forecastOrders=" + forecastOrders
				+ "]";
	}
    
    
}
