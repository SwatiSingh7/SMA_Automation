package com.morrisons.sma.pojo.service.MarkdownPOJO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Markdown_GetMarkdownRoot {
	public Markdown_Product product;
	public String isRestrictedDepartment;
	public String firstMarkdownWindow;

	@JsonProperty(required = false)
	public Markdown_UnprintedMarkdownEvent unprintedMarkdownEvent;

	@JsonProperty(required = false)
	public List<Object> printedMarkdownEvents;

	@JsonProperty(required = false)
	public Markdown_MarkdownCap markdownCap;

	@JsonProperty(required = false)
	public List<Markdown_MarkdownPercentage> markdownPercentages;

	@JsonProperty(required = false)
	public Markdown_OptimisedPrice optimisedPrice;

	public String getIsRestrictedDepartment() {
		return isRestrictedDepartment;
	}

	public void setIsRestrictedDepartment(String isRestrictedDepartment) {
		this.isRestrictedDepartment = isRestrictedDepartment;
	}

	public Markdown_OptimisedPrice getOptimisedPrice() {
		return optimisedPrice;
	}

	public void setOptimisedPrice(Markdown_OptimisedPrice optimisedPrice) {
		this.optimisedPrice = optimisedPrice;
	}

	public Markdown_Product getProduct() {
		return product;
	}

	public void setProduct(Markdown_Product product) {
		this.product = product;
	}

	public String isRestrictedDepartment() {
		return isRestrictedDepartment;
	}

	public void setRestrictedDepartment(String isRestrictedDepartment) {
		this.isRestrictedDepartment = isRestrictedDepartment;
	}

	public String getFirstMarkdownWindow() {
		return firstMarkdownWindow;
	}

	public void setFirstMarkdownWindow(String firstMarkdownWindow) {
		this.firstMarkdownWindow = firstMarkdownWindow;
	}

	public Markdown_UnprintedMarkdownEvent getUnprintedMarkdownEvent() {
		return unprintedMarkdownEvent;
	}

	public void setUnprintedMarkdownEvent(Markdown_UnprintedMarkdownEvent unprintedMarkdownEvent) {
		this.unprintedMarkdownEvent = unprintedMarkdownEvent;
	}

	public List<Object> getPrintedMarkdownEvents() {
		return printedMarkdownEvents;
	}

	public void setPrintedMarkdownEvents(List<Object> printedMarkdownEvents) {
		this.printedMarkdownEvents = printedMarkdownEvents;
	}

	public Markdown_MarkdownCap getMarkdownCap() {
		return markdownCap;
	}

	public void setMarkdownCap(Markdown_MarkdownCap markdownCap) {
		this.markdownCap = markdownCap;
	}

	public List<Markdown_MarkdownPercentage> getMarkdownPercentages() {
		return markdownPercentages;
	}

	public void setMarkdownPercentages(List<Markdown_MarkdownPercentage> markdownPercentages) {
		this.markdownPercentages = markdownPercentages;
	}

	@Override
	public String toString() {
		return "Markdown_GetMarkdownRoot [product=" + product + ", isRestrictedDepartment=" + isRestrictedDepartment
				+ ", firstMarkdownWindow=" + firstMarkdownWindow + ", unprintedMarkdownEvent=" + unprintedMarkdownEvent
				+ ", printedMarkdownEvents=" + printedMarkdownEvents + ", markdownCap=" + markdownCap
				+ ", markdownPercentages=" + markdownPercentages + ", optimisedPrice=" + optimisedPrice + "]";
	}

}
