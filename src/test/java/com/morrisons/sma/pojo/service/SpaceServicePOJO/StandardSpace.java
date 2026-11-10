package com.morrisons.sma.pojo.service.SpaceServicePOJO;

import java.util.List;

public class StandardSpace {

    private String dateFrom;
    private String dateTo;
    private double totalFillQty;
    private double startOfDayQty;
    private double endOfDayQty;
    private List<Location> locations;
    
	public String getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}
	public String getDateTo() {
		return dateTo;
	}
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
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
	public List<Location> getLocations() {
		return locations;
	}
	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}
	@Override
	public String toString() {
		return "StandardSpace [dateFrom=" + dateFrom + ", dateTo=" + dateTo + ", totalFillQty=" + totalFillQty
				+ ", startOfDayQty=" + startOfDayQty + ", endOfDayQty=" + endOfDayQty + ", locations=" + locations
				+ "]";
	}
    
    
    
}
