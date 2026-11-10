package com.morrisons.sma.pojo.service.SalesOrderServicePOJO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.ALWAYS)
public class SalesOrder_AmendOrderItem {

	@JsonProperty
	private String itemNumber;

	@JsonProperty
	private String itemDescription;

	@JsonProperty
	private String locationCategoryProductId;

	@JsonProperty
	private String departmentId;

	@JsonProperty
	private String productPin;

	@JsonProperty
	private String itemListType;

	private List<SalesOrder_ForecastOrder> forecastOrders;
	 
	 
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

	public List<SalesOrder_ForecastOrder> getForecastOrders() {
		return forecastOrders;
	}

	public void setForecastOrders(List<SalesOrder_ForecastOrder> forecastOrders) {
		this.forecastOrders = forecastOrders;
	}

	@Override
	public String toString() {
		return "SalesOrder_AmendOrderItem [itemNumber=" + itemNumber + ", itemDescription=" + itemDescription
				+ ", locationCategoryProductId=" + locationCategoryProductId + ", departmentId=" + departmentId
				+ ", productPin=" + productPin + ", itemListType=" + itemListType + ", forecastOrders=" + forecastOrders
				+ "]";
	}



	


}
