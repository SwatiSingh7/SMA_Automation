package com.morrisons.sma.pojo.service.StockMovementPOJO;

public class StockOrders {
	
	private String orderId;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "StockOrders [orderId=" + orderId + "]";
	}

}
