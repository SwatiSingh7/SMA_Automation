package com.morrisons.sma.pojo.service.SalesOrderServicePOJO;

import java.util.List;

public class SalesOrder_Item {

	public String itemNumber;
    public String itemDescription;
    public String locationCategoryProductId;
    public String departmentId;
    public String productPin;
    public String units;
    public SalesOrder_CurrentDayOrder currentDayOrder;
    public List<SalesOrder_ForecastOrder> forecastOrders;
    public List<SalesOrder_PreviousOrder> previousOrders;
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
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
	public SalesOrder_CurrentDayOrder getCurrentDayOrder() {
		return currentDayOrder;
	}
	public void setCurrentDayOrder(SalesOrder_CurrentDayOrder currentDayOrder) {
		this.currentDayOrder = currentDayOrder;
	}
	public List<SalesOrder_ForecastOrder> getForecastOrders() {
		return forecastOrders;
	}
	public void setForecastOrders(List<SalesOrder_ForecastOrder> forecastOrders) {
		this.forecastOrders = forecastOrders;
	}
	public List<SalesOrder_PreviousOrder> getPreviousOrders() {
		return previousOrders;
	}
	public void setPreviousOrders(List<SalesOrder_PreviousOrder> previousOrders) {
		this.previousOrders = previousOrders;
	}
	@Override
	public String toString() {
		return "SalesOrder_Item [itemNumber=" + itemNumber + ", itemDescription=" + itemDescription
				+ ", locationCategoryProductId=" + locationCategoryProductId + ", departmentId=" + departmentId
				+ ", productPin=" + productPin + ", units=" + units + ", currentDayOrder=" + currentDayOrder
				+ ", forecastOrders=" + forecastOrders + ", previousOrders=" + previousOrders + "]";
	}
    
    
    
}
