
package com.morrisons.sma.pojo.service.PricePrompPOJO;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.morrisons.sma.pojo.service.ProductServicePOJO.AdditionalProperties;

@JsonInclude(JsonInclude.Include.ALWAYS)
public class ComponentsAllergenInfo implements Serializable {

	private static final long serialVersionUID = -6167019614195307011L;
	@JsonProperty
	private String name;
	@JsonProperty
	private String value;
	@JsonProperty
	private AdditionalProperties additionalProperties;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
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
		return "ComponentsAllergenInfo [name=" + name + ", value=" + value + ", additionalProperties="
				+ additionalProperties + "]";
	}

}
