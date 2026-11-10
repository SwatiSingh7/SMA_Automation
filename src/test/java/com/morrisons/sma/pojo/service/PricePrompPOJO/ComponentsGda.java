
package com.morrisons.sma.pojo.service.PricePrompPOJO;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.morrisons.sma.pojo.service.ProductServicePOJO.AdditionalProperties;

@JsonInclude(JsonInclude.Include.ALWAYS)
public class ComponentsGda implements Serializable {
	@JsonProperty
	private static final long serialVersionUID = 3167023353064421862L;
	@JsonProperty
	private String name;
	@JsonProperty
	private String value;
	@JsonProperty
	private String percent;
	@JsonProperty
	private AdditionalProperties additionalProperties;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the percent
	 */
	public String getPercent() {
		return percent;
	}

	/**
	 * @param percent
	 *            the percent to set
	 */
	public void setPercent(String percent) {
		this.percent = percent;
	}

	/**
	 * @return the additionalProperties
	 */
	public AdditionalProperties getAdditionalProperties() {
		return additionalProperties;
	}

	/**
	 * @param additionalProperties
	 *            the additionalProperties to set
	 */
	public void setAdditionalProperties(AdditionalProperties additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((additionalProperties == null) ? 0 : additionalProperties.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((percent == null) ? 0 : percent.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComponentsGda other = (ComponentsGda) obj;
		if (additionalProperties == null) {
			if (other.additionalProperties != null)
				return false;
		} else if (!additionalProperties.equals(other.additionalProperties))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (percent == null) {
			if (other.percent != null)
				return false;
		} else if (!percent.equals(other.percent))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ComponentsGda [name=" + name + ", value=" + value + ", percent=" + percent + ", additionalProperties="
				+ additionalProperties + "]";
	}

}
