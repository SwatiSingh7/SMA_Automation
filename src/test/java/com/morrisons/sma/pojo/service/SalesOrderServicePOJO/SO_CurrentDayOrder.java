package com.morrisons.sma.pojo.service.SalesOrderServicePOJO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.ALWAYS)

public class SO_CurrentDayOrder {
	
	@JsonProperty
	private String date;
	
	@JsonProperty
	private String requestedQuantity;
	
	@JsonProperty
	private String deliveredQuantity;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getRequestedQuantity() {
		return requestedQuantity;
	}

	public void setRequestedQuantity(String requestedQuantity) {
		this.requestedQuantity = requestedQuantity;
	}

	public String getDeliveredQuantity() {
		return deliveredQuantity;
	}

	public void setDeliveredQuantity(String deliveredQuantity) {
		this.deliveredQuantity = deliveredQuantity;
	}

	@Override
	public String toString() {
		return "SO_CurrentDayOrder [date=" + date + ", requestedQuantity=" + requestedQuantity + ", deliveredQuantity="
				+ deliveredQuantity + "]";
	}
	
	

}
