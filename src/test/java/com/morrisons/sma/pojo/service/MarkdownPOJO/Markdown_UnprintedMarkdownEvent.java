package com.morrisons.sma.pojo.service.MarkdownPOJO;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Markdown_UnprintedMarkdownEvent {
	@JsonProperty(required = false)
	 public String id;
	@JsonProperty(required = false)
	    public String markedDownPrice;
	@JsonProperty(required = false)
	    public String percentageMarkdown;
	@JsonProperty(required = false)
	    public String markdownCreatedDate;
	@JsonProperty(required = false)
	    public String quantity;
	@JsonProperty(required = false)
	    public String markdownBarcode;
	@JsonProperty(required = false)
	    public Markdown_OptimisedPrice optimisedPrice;
	@JsonProperty(required = false)
	    public String isComplete;
	@JsonProperty(required = false)
	    public String isOptimisedPriceUsed;
	@JsonProperty(required = false)
	    public String optimisedPriceApplicable;
	@JsonProperty(required = false)
	    public String byRecommendedPrice;
	@JsonProperty(required = false)
	    public String markdownSequence;
	    
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getMarkedDownPrice() {
			return markedDownPrice;
		}
		public void setMarkedDownPrice(String markedDownPrice) {
			this.markedDownPrice = markedDownPrice;
		}
		public String getPercentageMarkdown() {
			return percentageMarkdown;
		}
		public void setPercentageMarkdown(String percentageMarkdown) {
			this.percentageMarkdown = percentageMarkdown;
		}
		public String getMarkdownCreatedDate() {
			return markdownCreatedDate;
		}
		public void setMarkdownCreatedDate(String markdownCreatedDate) {
			this.markdownCreatedDate = markdownCreatedDate;
		}
		public String getQuantity() {
			return quantity;
		}
		public void setQuantity(String quantity) {
			this.quantity = quantity;
		}
		public String getMarkdownBarcode() {
			return markdownBarcode;
		}
		public void setMarkdownBarcode(String markdownBarcode) {
			this.markdownBarcode = markdownBarcode;
		}
		public Markdown_OptimisedPrice getOptimisedPrice() {
			return optimisedPrice;
		}
		public void setOptimisedPrice(Markdown_OptimisedPrice optimisedPrice) {
			this.optimisedPrice = optimisedPrice;
		}
		public String getIsComplete() {
			return isComplete;
		}
		public void setIsComplete(String isComplete) {
			this.isComplete = isComplete;
		}
		public String getIsOptimisedPriceUsed() {
			return isOptimisedPriceUsed;
		}
		public void setIsOptimisedPriceUsed(String isOptimisedPriceUsed) {
			this.isOptimisedPriceUsed = isOptimisedPriceUsed;
		}
		public String getOptimisedPriceApplicable() {
			return optimisedPriceApplicable;
		}
		public void setOptimisedPriceApplicable(String optimisedPriceApplicable) {
			this.optimisedPriceApplicable = optimisedPriceApplicable;
		}
		public String getByRecommendedPrice() {
			return byRecommendedPrice;
		}
		public void setByRecommendedPrice(String byRecommendedPrice) {
			this.byRecommendedPrice = byRecommendedPrice;
		}
		public String getMarkdownSequence() {
			return markdownSequence;
		}
		public void setMarkdownSequence(String markdownSequence) {
			this.markdownSequence = markdownSequence;
		}
		@Override
		public String toString() {
			return "Markdown_UnprintedMarkdownEvent [id=" + id + ", markedDownPrice=" + markedDownPrice
					+ ", percentageMarkdown=" + percentageMarkdown + ", markdownCreatedDate=" + markdownCreatedDate
					+ ", quantity=" + quantity + ", markdownBarcode=" + markdownBarcode + ", optimisedPrice="
					+ optimisedPrice + ", isComplete=" + isComplete + ", isOptimisedPriceUsed=" + isOptimisedPriceUsed
					+ ", optimisedPriceApplicable=" + optimisedPriceApplicable + ", byRecommendedPrice="
					+ byRecommendedPrice + ", markdownSequence=" + markdownSequence + "]";
		}
	    
	    
}
