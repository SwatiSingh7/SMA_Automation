package com.morrisons.sma.pojo.service.BasketV2ServicePOJO;

public class BasketV2_BasketItem {

	private String barcode;
	private int barcodeQuantity;
	private int department;
	private Object priceChangeType;
	private int quantity;
	private Object quantityType;
	private double storePrice;
	private double unitPrice;
	private String description;
	private String departmentName;

	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public int getBarcodeQuantity() {
		return barcodeQuantity;
	}
	public void setBarcodeQuantity(int barcodeQuantity) {
		this.barcodeQuantity = barcodeQuantity;
	}
	public int getDepartment() {
		return department;
	}
	public void setDepartment(int department) {
		this.department = department;
	}
	public Object getPriceChangeType() {
		return priceChangeType;
	}
	public void setPriceChangeType(Object priceChangeType) {
		this.priceChangeType = priceChangeType;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Object getQuantityType() {
		return quantityType;
	}
	public void setQuantityType(Object quantityType) {
		this.quantityType = quantityType;
	}
	public double getStorePrice() {
		return storePrice;
	}
	public void setStorePrice(double storePrice) {
		this.storePrice = storePrice;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	@Override
	public String toString() {
		return "BasketV2_BasketItem [barcode=" + barcode + ", barcodeQuantity=" + barcodeQuantity + ", department="
				+ department + ", priceChangeType=" + priceChangeType + ", quantity=" + quantity + ", quantityType="
				+ quantityType + ", storePrice=" + storePrice + ", unitPrice=" + unitPrice + ", description="
				+ description + ", departmentName=" + departmentName + "]";
	}


}
