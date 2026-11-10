package com.morrisons.sma.pojo.service.SalesOrderServicePOJO;

public class SalesOrder_ForecastProductOrder {

    public String date;
    public String quantity;
    public boolean isAmended;
    
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public boolean isAmended() {
		return isAmended;
	}
	public void setAmended(boolean isAmended) {
		this.isAmended = isAmended;
	}
	@Override
	public String toString() {
		return "SalesOrder_ForecastOrder [date=" + date + ", quantity=" + quantity + ", isAmended=" + isAmended + "]";
	}
    
    
}
