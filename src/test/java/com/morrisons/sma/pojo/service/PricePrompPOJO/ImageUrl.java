
package com.morrisons.sma.pojo.service.PricePrompPOJO;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.morrisons.sma.pojo.service.ProductServicePOJO.AdditionalProperties;

@JsonInclude(JsonInclude.Include.ALWAYS)
public class ImageUrl implements Serializable {

	private static final long serialVersionUID = -5121523686860693633L;
	@JsonProperty
	private String url;
	@JsonProperty
	private String shotType;
	@JsonProperty
	private BigDecimal height;
	@JsonProperty
	private BigDecimal width;
	@JsonProperty
	private AdditionalProperties additionalProperties;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getShotType() {
		return shotType;
	}

	public void setShotType(String shotType) {
		this.shotType = shotType;
	}

	public BigDecimal getHeight() {
		return height;
	}

	public void setHeight(BigDecimal height) {
		this.height = height;
	}

	public BigDecimal getWidth() {
		return width;
	}

	public void setWidth(BigDecimal width) {
		this.width = width;
	}

	public AdditionalProperties getAdditionalProperties() {
		return additionalProperties;
	}

	public void setAdditionalProperties(AdditionalProperties additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ImageUrl [url=" + url + ", shotType=" + shotType + ", height=" + height + ", width=" + width
				+ ", additionalProperties=" + additionalProperties + "]";
	}

}