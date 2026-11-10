package com.morrisons.sma.pojo.service.range;

public class Clearance {

    private String status;
    private String dateFrom;
    private String dateTo;
    private String wastage;
    private String wastageFrom;
    private String wastageTo;

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
    public String getWastage() {
        return wastage;
    }
    public void setWastage(String wastage) {
        this.wastage = wastage;
    }
    public String getWastageFrom() {
        return wastageFrom;
    }
    public void setWastageFrom(String wastageFrom) {
        this.wastageFrom = wastageFrom;
    }
    public String getWastageTo() {
        return wastageTo;
    }
    public void setWastageTo(String wastageTo) {
        this.wastageTo = wastageTo;
    }

    @Override
    public String toString() {
        return "Clearance [status=" + status + ", dateFrom=" + dateFrom + ", dateTo=" + dateTo + ", wastage="
                + wastage + ", wastageFrom=" + wastageFrom + ", wastageTo=" + wastageTo + "]";
    }

}
