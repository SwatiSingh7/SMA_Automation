package com.morrisons.sma.pojo.service.PricePrompPOJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AdditionalPropertiesDb {
	@JsonIgnoreProperties(ignoreUnknown = true)
	@JsonProperty("isPrimaryBarcode")
	private Boolean isPrimaryBarcode;

	public Boolean getIsPrimaryBarcode() {
		return isPrimaryBarcode;
	}

	public void setIsPrimaryBarcode(Boolean isPrimaryBarcode) {
		this.isPrimaryBarcode = isPrimaryBarcode;
	}

	@Override
	public String toString() {
		if (isPrimaryBarcode == null) {
			return "{}";
		} else
			return "AdditionalProperties {isPrimaryBarcode=" + isPrimaryBarcode + "}";

		// AdditionalPropertiesDb {isPrimaryBarcode=+value+"}"
	}

}
