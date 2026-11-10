package com.morrisons.sma.pojo.service.SpaceServicePOJO;

import java.util.List;

public class SpaceServiceRoot {

	private String storeNumber;
    private String min;
    private List<Object> variants;
    private double totalFillQty;
    private double startOfDayQty;
    private double endOfDayQty;
    private String status;
    private StandardSpace standardSpace;
    
    
	 public String getStoreNumber() {
		return storeNumber;
	}
	public void setStoreNumber(String storeNumber) {
		this.storeNumber = storeNumber;
	}
	public String getMin() {
		return min;
	}
	public void setMin(String min) {
		this.min = min;
	}
	public List<Object> getVariants() {
		return variants;
	}
	public void setVariants(List<Object> variants) {
		this.variants = variants;
	}
	public double getTotalFillQty() {
		return totalFillQty;
	}
	public void setTotalFillQty(double totalFillQty) {
		this.totalFillQty = totalFillQty;
	}
	public double getStartOfDayQty() {
		return startOfDayQty;
	}
	public void setStartOfDayQty(double startOfDayQty) {
		this.startOfDayQty = startOfDayQty;
	}
	public double getEndOfDayQty() {
		return endOfDayQty;
	}
	public void setEndOfDayQty(double endOfDayQty) {
		this.endOfDayQty = endOfDayQty;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public StandardSpace getStandardSpace() {
		return standardSpace;
	}
	public void setStandardSpace(StandardSpace standardSpace) {
		this.standardSpace = standardSpace;
	}
	@Override
	public String toString() {
		return "SpaceServiceRoot [storeNumber=" + storeNumber + ", min=" + min + ", variants=" + variants
				+ ", totalFillQty=" + totalFillQty + ", startOfDayQty=" + startOfDayQty + ", endOfDayQty=" + endOfDayQty
				+ ", status=" + status + ", standardSpace=" + standardSpace + "]";
	}

	    
	
}
