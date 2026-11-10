package com.morrisons.sma.pojo.service.SalesOrderServicePOJO;

public class SalesOrder_PreviousOrder {

	public String date;
    public String requestedQuantity;
    public String deliveredQuantity;
    
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
		return "SalesOrder_PreviousOrder [date=" + date + ", requestedQuantity=" + requestedQuantity
				+ ", deliveredQuantity=" + deliveredQuantity + "]";
	}
    
    
}
