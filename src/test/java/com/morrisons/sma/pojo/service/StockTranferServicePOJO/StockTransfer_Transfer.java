package com.morrisons.sma.pojo.service.StockTranferServicePOJO;

import java.util.List;

public class StockTransfer_Transfer {

	private int containerId;
	private List<StockTransfer_Item> items;

	public int getContainerId() {
		return containerId;
	}
	public void setContainerId(int containerId) {
		this.containerId = containerId;
	}
	public List<StockTransfer_Item> getItems() {
		return items;
	}
	public void setItems(List<StockTransfer_Item> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "StockTransfer_Transfer [containerId=" + containerId + ", items=" + items + "]";
	}
}
