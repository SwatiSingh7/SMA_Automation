package com.morrisons.sma.pojo.service.MarkdownPOJO;

public class Markdown_GetList {

	public Markdown_Product product;
	public String isRestrictedDepartment;
	public Markdown_UnprintedMarkdownEvent unprintedMarkdownEvent;
	
	public Markdown_Product getProduct() {
		return product;
	}
	public void setProduct(Markdown_Product product) {
		this.product = product;
	}
	public String getIsRestrictedDepartment() {
		return isRestrictedDepartment;
	}
	public void setIsRestrictedDepartment(String isRestrictedDepartment) {
		this.isRestrictedDepartment = isRestrictedDepartment;
	}
	public Markdown_UnprintedMarkdownEvent getUnprintedMarkdownEvent() {
		return unprintedMarkdownEvent;
	}
	public void setUnprintedMarkdownEvent(Markdown_UnprintedMarkdownEvent unprintedMarkdownEvent) {
		this.unprintedMarkdownEvent = unprintedMarkdownEvent;
	}
	@Override
	public String toString() {
		return "Markdown_GetList [product=" + product + ", isRestrictedDepartment=" + isRestrictedDepartment
				+ ", unprintedMarkdownEvent=" + unprintedMarkdownEvent + "]";
	}


}
