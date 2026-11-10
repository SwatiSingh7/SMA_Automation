package com.morrisons.sma.pojo.service.MarkdownPOJO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Markdown_Price {
	@JsonProperty(required = false)
	public String percentage;
	@JsonProperty(required = false)
    public String targetDate;
	@JsonProperty(required = false)
    public String markdownPrice;
	@JsonProperty(required = false)
    public String quantity;
	@JsonProperty(required = false)
    public String unitOfMeasure;
    
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
		return "Markdown_Price [percentage=" + percentage + ", targetDate=" + targetDate + ", markdownPrice="
				+ markdownPrice + ", quantity=" + quantity + ", unitOfMeasure=" + unitOfMeasure + "]";
	}
    
    
}
