package com.morrisons.sma.pojo.service.StockTranferServicePOJO;

import java.util.List;

public class StockTransfer_Root {

	private String transferDate;
	private String fromLocation;
	private String toLocation;
	private String internal;
	private String isBatch;
	private List<StockTransfer_Transfer> transfers;
	
	public String getTransferDate() {
		return transferDate;
	}
	public void setTransferDate(String transferDate) {
		this.transferDate = transferDate;
	}
	public String getFromLocation() {
		return fromLocation;
	}
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}
	public String getToLocation() {
		return toLocation;
	}
	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}
	public String getInternal() {
		return internal;
	}
	public void setInternal(String internal) {
		this.internal = internal;
	}
	public String getIsBatch() {
		return isBatch;
	}
	public void setIsBatch(String isBatch) {
		this.isBatch = isBatch;
	}
	public List<StockTransfer_Transfer> getTransfers() {
		return transfers;
	}
	public void setTransfers(List<StockTransfer_Transfer> transfers) {
		this.transfers = transfers;
	}
	@Override
	public String toString() {
		return "StockTransfer_Root [transferDate=" + transferDate + ", fromLocation=" + fromLocation + ", toLocation="
				+ toLocation + ", internal=" + internal + ", isBatch=" + isBatch + ", transfers=" + transfers + "]";
	}
	
	
	
}
