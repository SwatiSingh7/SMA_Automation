package com.morrisons.sma.pojo.service.range;

public class Range {

    private int locationId;
    private String itemNumber;
    private String status;
    private String dateFrom;
    private String dateTo;
    private String source;
    private Clearance clearance;


    public int getLocationId() {
        return locationId;
    }
    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }
    public String getItemNumber() {
        return itemNumber;
    }
    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
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
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public Clearance getClearance() {
        return clearance;
    }
    public void setClearance(Clearance clearance) {
        this.clearance = clearance;
    }


    @Override
    public String toString() {
        return "Range [locationId=" + locationId + ", itemNumber=" + itemNumber + ", status=" + status + ", dateFrom="
                + dateFrom + ", dateTo=" + dateTo + ", source=" + source + ", clearance=" + clearance + "]";
    }



}
