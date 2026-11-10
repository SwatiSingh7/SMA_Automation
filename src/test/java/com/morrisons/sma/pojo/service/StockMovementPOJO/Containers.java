package com.morrisons.sma.pojo.service.StockMovementPOJO;

import java.util.List;

public class Containers {

	private List<Orders> orders;
	private String containerId;

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public String getContainerId() {
		return containerId;
	}

	public void setContainerId(String containerId) {
		this.containerId = containerId;
	}

	@Override
	public String toString() {
		return "Containers [orders=" + orders + ", containerId=" + containerId + "]";
	}

}
