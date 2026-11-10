package com.morrisons.sma.pojo.service.StockMovementPOJO;

import java.util.List;

public class Orders {

	private List<Items> items;
	private String orderId;
	private String orderType;
	private String orderedDate;
	private List<StockOrders> stockOrders;

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(String orderedDate) {
		this.orderedDate = orderedDate;
	}

	public List<StockOrders> getStockOrders() {
		return stockOrders;
	}

	public void setStockOrders(List<StockOrders> stockOrders) {
		this.stockOrders = stockOrders;
	}

	@Override
	public String toString() {
		return "Orders [items=" + items + ", orderId=" + orderId + ", orderType=" + orderType + ", orderedDate="
				+ orderedDate + ", stockOrders=" + stockOrders + "]";
	}

}
