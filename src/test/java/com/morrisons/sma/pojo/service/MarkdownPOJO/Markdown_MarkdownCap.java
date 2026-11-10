package com.morrisons.sma.pojo.service.MarkdownPOJO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Markdown_MarkdownCap {
	@JsonProperty(required = false)
	 public String percentageCap;

	public String getPercentageCap() {
		return percentageCap;
	}

	public void setPercentageCap(String percentageCap) {
		this.percentageCap = percentageCap;
	}

	@Override
	public String toString() {
		return "Markdown_MarkdownCap [percentageCap=" + percentageCap + "]";
	}
	 
	 
}
