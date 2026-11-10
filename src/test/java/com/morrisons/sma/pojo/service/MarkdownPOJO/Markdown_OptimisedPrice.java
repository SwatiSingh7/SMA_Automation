package com.morrisons.sma.pojo.service.MarkdownPOJO;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Markdown_OptimisedPrice {
	@JsonProperty(required = false)
	public Markdown_Price price;
	@JsonProperty(required = false)
	public Markdown_Error error;

	public Markdown_Price getPrice() {
		return price;
	}

	public Markdown_Error getError() {
		return error;
	}

	public void setError(Markdown_Error error) {
		this.error = error;
	}

	public void setPrice(Markdown_Price price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Markdown_OptimisedPrice [price=" + price + "]";
	}
	
	
}
