package com.morrisons.sma.pojo.service.MarkdownPOJO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Markdown_MarkdownPercentage {
	@JsonProperty(required = false)
	public String percentage;
	@JsonProperty(required = false)
    public String markdownPrice;
	@JsonProperty(required = false)
    public String colleagueApplicable;
	@JsonProperty(required = false)
    public String isDefault;
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	public String getMarkdownPrice() {
		return markdownPrice;
	}
	public void setMarkdownPrice(String markdownPrice) {
		this.markdownPrice = markdownPrice;
	}
	public String getColleagueApplicable() {
		return colleagueApplicable;
	}
	public void setColleagueApplicable(String colleagueApplicable) {
		this.colleagueApplicable = colleagueApplicable;
	}
	public String getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}
	@Override
	public String toString() {
		return "Markdown_MarkdownPercentage [percentage=" + percentage + ", markdownPrice=" + markdownPrice
				+ ", colleagueApplicable=" + colleagueApplicable + ", isDefault=" + isDefault + "]";
	}
    
    
}
