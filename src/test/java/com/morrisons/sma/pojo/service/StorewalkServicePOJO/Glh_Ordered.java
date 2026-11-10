package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Glh_Ordered {
	 @JsonProperty("date")
	private String date;
	 @JsonProperty("quantity")
	 private String quantity;
	 @JsonProperty("quantityType")
	 private String quantityType	;
	 @JsonProperty("quantityUnit")
	 private String quantityUnit;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getQuantityType() {
		return quantityType;
	}
	public void setQuantityType(String quantityType) {
		this.quantityType = quantityType;
	}
	public String getQuantityUnit() {
		return quantityUnit;
	}
	public void setQuantityUnit(String quantityUnit) {
		this.quantityUnit = quantityUnit;
	}
	@Override
	public String toString() {
		return "Ordered [date=" + date + ", quantity=" + quantity + ", quantityType=" + quantityType + ", quantityUnit="
				+ quantityUnit + "]";
	}
	
	
}
