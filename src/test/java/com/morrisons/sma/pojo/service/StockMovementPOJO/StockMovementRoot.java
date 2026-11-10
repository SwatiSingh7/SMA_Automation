package com.morrisons.sma.pojo.service.StockMovementPOJO;

import java.util.List;

public class StockMovementRoot {
	private String asnId;
	private String trailerId;
	private List<Containers> containers;
	private String receiptDate;
	private String receiptLocationId;
	private String shippedFromLocationId;

	public String getAsnId() {
		return asnId;
	}

	public void setAsnId(String asnId) {
		this.asnId = asnId;
	}

	public String getTrailerId() {
		return trailerId;
	}

	public void setTrailerId(String trailerId) {
		this.trailerId = trailerId;
	}

	public List<Containers> getContainers() {
		return containers;
	}

	public void setContainers(List<Containers> containers) {
		this.containers = containers;
	}

	public String getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(String receiptDate) {
		this.receiptDate = receiptDate;
	}

	public String getReceiptLocationId() {
		return receiptLocationId;
	}

	public void setReceiptLocationId(String receiptLocationId) {
		this.receiptLocationId = receiptLocationId;
	}

	public String getShippedFromLocationId() {
		return shippedFromLocationId;
	}

	public void setShippedFromLocationId(String shippedFromLocationId) {
		this.shippedFromLocationId = shippedFromLocationId;
	}

	@Override
	public String toString() {
		return "StockMovementRoot [asnId=" + asnId + ", trailerId=" + trailerId + ", containers=" + containers
				+ ", receiptDate=" + receiptDate + ", receiptLocationId=" + receiptLocationId
				+ ", shippedFromLocationId=" + shippedFromLocationId + "]";
	}

}
