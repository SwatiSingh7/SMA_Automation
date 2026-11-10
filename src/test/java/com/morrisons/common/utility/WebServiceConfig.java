package com.morrisons.common.utility;

public class WebServiceConfig {

	private String baseURI;
	private String resource;
	private String queryParameter;
	private String onDateQueryParameter;
	private String historyResource;
	private String historyQueryParameter;
	private String changeQueryParameter;
	private String historyResourceForBFF;
	private String historyForBFFQueryParameter;
	private String priceNewResource;
	private String priceNewOndateQueryParameter;
	private String priceNewWithoutOndateQueryParameter;
	private String priceEventResource;
	private String priceEventQueryParameter;

	public String getBaseURI() {
		return baseURI;
	}

	public void setBaseURI(String baseURI) {
		this.baseURI = baseURI;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public String getQueryParameter() {
		return queryParameter;
	}

	public void setQueryParameter(String queryParameter) {
		this.queryParameter = queryParameter;
	}

	public String getOnDateQueryParameter() {
		return onDateQueryParameter;
	}

	public void setOnDateQueryParameter(String onDateQueryParameter) {
		this.onDateQueryParameter = onDateQueryParameter;
	}

	public String getHistoryResource() {
		return historyResource;
	}

	public void setHistoryResource(String historyResource) {
		this.historyResource = historyResource;
	}

	public String getHistoryQueryParameter() {
		return historyQueryParameter;
	}

	public void setHistoryQueryParameter(String historyQueryParameter) {
		this.historyQueryParameter = historyQueryParameter;
	}

	public String getChangeQueryParameter() {
		return changeQueryParameter;
	}

	public void setChangeQueryParameter(String changeQueryParameter) {
		this.changeQueryParameter = changeQueryParameter;
	}

	public String getHistoryResourceForBFF() {
		return historyResourceForBFF;
	}

	public void setHistoryResourceForBFF(String historyResourceForBFF) {
		this.historyResourceForBFF = historyResourceForBFF;
	}

	public String getHistoryForBFFQueryParameter() {
		return historyForBFFQueryParameter;
	}

	public void setHistoryForBFFQueryParameter(String historyForBFFQueryParameter) {
		this.historyForBFFQueryParameter = historyForBFFQueryParameter;
	}

	public String getPriceNewResource() {
		return priceNewResource;
	}

	public void setPriceNewResource(String priceNewResource) {
		this.priceNewResource = priceNewResource;
	}

	public String getPriceNewOndateQueryParameter() {
		return priceNewOndateQueryParameter;
	}

	public void setPriceNewOndateQueryParameter(String priceNewOndateQueryParameter) {
		this.priceNewOndateQueryParameter = priceNewOndateQueryParameter;
	}

	public String getPriceNewWithoutOndateQueryParameter() {
		return priceNewWithoutOndateQueryParameter;
	}

	public void setPriceNewWithoutOndateQueryParameter(String priceNewWithoutOndateQueryParameter) {
		this.priceNewWithoutOndateQueryParameter = priceNewWithoutOndateQueryParameter;
	}

	public String getPriceEventResource() {
		return priceEventResource;
	}

	public void setPriceEventResource(String priceEventResource) {
		this.priceEventResource = priceEventResource;
	}

	public String getPriceEventQueryParameter() {
		return priceEventQueryParameter;
	}

	public void setPriceEventQueryParameter(String priceEventQueryParameter) {
		this.priceEventQueryParameter = priceEventQueryParameter;
	}

	@Override
	public String toString() {
		return "WebServiceConfig [baseURI=" + baseURI + ", resource=" + resource + ", queryParameter=" + queryParameter
				+ ", onDateQueryParameter=" + onDateQueryParameter + ", historyResource=" + historyResource
				+ ", historyQueryParameter=" + historyQueryParameter + ", changeQueryParameter=" + changeQueryParameter
				+ ", historyResourceForBFF=" + historyResourceForBFF + ", historyForBFFQueryParameter="
				+ historyForBFFQueryParameter + ", priceNewResource=" + priceNewResource
				+ ", priceNewOndateQueryParameter=" + priceNewOndateQueryParameter
				+ ", priceNewWithoutOndateQueryParameter=" + priceNewWithoutOndateQueryParameter
				+ ", priceEventResource=" + priceEventResource + ", priceEventQueryParameter="
				+ priceEventQueryParameter + "]";
	}

}
