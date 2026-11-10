package com.morrisons.sma.pojo.service.PricePrompPOJO;

public class priceMUP {

	private String percentage;
	private String targetDate;
	private String markdownPrice;
	private String quantity;
	private String unitOfMeasure;
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	public String getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(String targetDate) {
		this.targetDate = targetDate;
	}
	public String getMarkdownPrice() {
		return markdownPrice;
	}
	public void setMarkdownPrice(String markdownPrice) {
		this.markdownPrice = markdownPrice;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}
	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}
	@Override
	public String toString() {
		return "priceMUP [percentage=" + percentage + ", targetDate=" + targetDate + ", markdownPrice=" + markdownPrice
				+ ", quantity=" + quantity + ", unitOfMeasure=" + unitOfMeasure + "]";
	}
	
	
}
