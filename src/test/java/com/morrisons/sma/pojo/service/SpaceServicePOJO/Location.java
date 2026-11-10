package com.morrisons.sma.pojo.service.SpaceServicePOJO;

public class Location {

	private int planClass;
    private String planType;
    private String planName;
    private String gondola;
    private String aisle;
    private String side;
    private String bayNumber;
    private String shelfNumber;
    private String position;
    private String merchandiseType;
    private int unitsWide;
    private int unitsHigh;
    private int unitsDeep;
    private double fillQty;
    private int facings;
    private String dateFrom;
    private String storeWalkSequence;
    private String planBaySequence;
    private double selBlockwidth;
    private int locationCount;
    

	public int getPlanClass() {
		return planClass;
	}
	public void setPlanClass(int planClass) {
		this.planClass = planClass;
	}
	public String getPlanType() {
		return planType;
	}
	public void setPlanType(String planType) {
		this.planType = planType;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getGondola() {
		return gondola;
	}
	public void setGondola(String gondola) {
		this.gondola = gondola;
	}
	public String getAisle() {
		return aisle;
	}
	public void setAisle(String aisle) {
		this.aisle = aisle;
	}
	public String getSide() {
		return side;
	}
	public void setSide(String side) {
		this.side = side;
	}
	public String getBayNumber() {
		return bayNumber;
	}
	public void setBayNumber(String bayNumber) {
		this.bayNumber = bayNumber;
	}
	public String getShelfNumber() {
		return shelfNumber;
	}
	public void setShelfNumber(String shelfNumber) {
		this.shelfNumber = shelfNumber;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getMerchandiseType() {
		return merchandiseType;
	}
	public void setMerchandiseType(String merchandiseType) {
		this.merchandiseType = merchandiseType;
	}
	public int getUnitsWide() {
		return unitsWide;
	}
	public void setUnitsWide(int unitsWide) {
		this.unitsWide = unitsWide;
	}
	public int getUnitsHigh() {
		return unitsHigh;
	}
	public void setUnitsHigh(int unitsHigh) {
		this.unitsHigh = unitsHigh;
	}
	public int getUnitsDeep() {
		return unitsDeep;
	}
	public void setUnitsDeep(int unitsDeep) {
		this.unitsDeep = unitsDeep;
	}
	public double getFillQty() {
		return fillQty;
	}
	public void setFillQty(double fillQty) {
		this.fillQty = fillQty;
	}
	public int getFacings() {
		return facings;
	}
	public void setFacings(int facings) {
		this.facings = facings;
	}
	public String getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}
	public String getStoreWalkSequence() {
		return storeWalkSequence;
	}
	public void setStoreWalkSequence(String storeWalkSequence) {
		this.storeWalkSequence = storeWalkSequence;
	}
	public String getPlanBaySequence() {
		return planBaySequence;
	}
	public void setPlanBaySequence(String planBaySequence) {
		this.planBaySequence = planBaySequence;
	}
	public double getSelBlockwidth() {
		return selBlockwidth;
	}
	public void setSelBlockwidth(double selBlockwidth) {
		this.selBlockwidth = selBlockwidth;
	}
	public int getLocationCount() {
		return locationCount;
	}
	public void setLocationCount(int locationCount) {
		this.locationCount = locationCount;
	}

	
	@Override
	public String toString() {
		return "Location [planClass=" + planClass + ", planType=" + planType + ", planName=" + planName + ", gondola="
				+ gondola + ", aisle=" + aisle + ", side=" + side + ", bayNumber=" + bayNumber + ", shelfNumber="
				+ shelfNumber + ", position=" + position + ", merchandiseType=" + merchandiseType + ", unitsWide="
				+ unitsWide + ", unitsHigh=" + unitsHigh + ", unitsDeep=" + unitsDeep + ", fillQty=" + fillQty
				+ ", facings=" + facings + ", dateFrom=" + dateFrom + ", storeWalkSequence=" + storeWalkSequence
				+ ", planBaySequence=" + planBaySequence + ", selBlockwidth=" + selBlockwidth + ", locationCount="
				+ locationCount + "]";
	}
	
}
