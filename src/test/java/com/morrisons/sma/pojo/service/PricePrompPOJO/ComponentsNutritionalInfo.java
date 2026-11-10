
package com.morrisons.sma.pojo.service.PricePrompPOJO;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.morrisons.sma.pojo.service.ProductServicePOJO.AdditionalProperties;

@JsonInclude(JsonInclude.Include.ALWAYS)
public class ComponentsNutritionalInfo implements Serializable {
	@JsonProperty
	private static final long serialVersionUID = 7245929662245375903L;
	@JsonProperty
	private String name;
	@JsonProperty
	private String perComp;
	@JsonProperty
	private String perServing;
	@JsonProperty
	private AdditionalProperties additionalProperties;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPerComp() {
		return perComp;
	}

	public void setPerComp(String perComp) {
		this.perComp = perComp;
	}

	public String getPerServing() {
		return perServing;
	}

	public void setPerServing(String perServing) {
		this.perServing = perServing;
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
		return "ComponentsNutritionalInfo [name=" + name + ", perComp=" + perComp + ", perServing=" + perServing
				+ ", additionalProperties=" + additionalProperties + "]";
	}

}
