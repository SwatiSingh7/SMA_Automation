package com.morrisons.sma.pojo.service.StockAdjustmentServicePojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Context {
	public String barcode;
	public boolean markdown;

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public boolean isMarkdown() {
		return markdown;
	}

	public void setMarkdown(boolean markdown) {
		this.markdown = markdown;
	}

	@Override
	public String toString() {
		return "Context [barcode=" + barcode + ", markdown=" + markdown + "]";
	}

}
