package com.morrisons.sma.pojo.service.MarkdownPOJO;

public class Markdown_Blueyonder {

	 private String location_id;
	 private String product_id;
	 private String valid_from;
	 private String current_Price;
	 private String expiration_date;
	 private String markdown_price;
	 private String currency;
	 private String markdown_percentage;
	public String getLocation_id() {
		return location_id;
	}
	public void setLocation_id(String location_id) {
		this.location_id = location_id;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getValid_from() {
		return valid_from;
	}
	public void setValid_from(String valid_from) {
		this.valid_from = valid_from;
	}
	
	public String getMarkdown_price() {
		return markdown_price;
	}
	public void setMarkdown_price(String markdown_price) {
		this.markdown_price = markdown_price;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getCurrent_Price() {
		return current_Price;
	}
	public void setCurrent_Price(String current_Price) {
		this.current_Price = current_Price;
	}
	public String getExpiration_date() {
		return expiration_date;
	}
	public void setExpiration_date(String expiration_date) {
		this.expiration_date = expiration_date;
	}
	public String getMarkdown_percentage() {
		return markdown_percentage;
	}
	public void setMarkdown_percentage(String markdown_percentage) {
		this.markdown_percentage = markdown_percentage;
	}
	@Override
	public String toString() {
		return "Markdown_Blueyonder [location_id=" + location_id + ", product_id=" + product_id + ", valid_from="
				+ valid_from + ", current_Price=" + current_Price + ", expiration_date=" + expiration_date
				+ ", markdown_price=" + markdown_price + ", currency=" + currency + ", markdown_percentage="
				+ markdown_percentage + "]";
	}
	
	 
}
