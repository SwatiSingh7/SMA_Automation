
package com.morrisons.sma.pojo.service.PricePrompPOJO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.morrisons.sma.pojo.service.ProductServicePOJO.AdditionalProperties;

@JsonInclude(JsonInclude.Include.ALWAYS)
public class Components implements Serializable {

	@JsonProperty
	private List<String> ingredients = new ArrayList<>();
	@JsonProperty
	private List<String> storage = new ArrayList<>();
	@JsonProperty
	private List<ComponentsGda> gda = new ArrayList<>();
	@JsonProperty
	private String nutritionalHeading;
	@JsonProperty
	private List<ComponentsNutritionalInfo> nutritionalInfo = new ArrayList<>();
	@JsonProperty
	private List<ComponentsAllergenInfo> allergenInfo = new ArrayList<>();
	@JsonProperty
	private AdditionalProperties additionalProperties;

	public List<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}

	public List<String> getStorage() {
		return storage;
	}

	public void setStorage(List<String> storage) {
		this.storage = storage;
	}

	public List<ComponentsGda> getGda() {
		return gda;
	}

	public void setGda(List<ComponentsGda> gda) {
		this.gda = gda;
	}

	public String getNutritionalHeading() {
		return nutritionalHeading;
	}

	public void setNutritionalHeading(String nutritionalHeading) {
		this.nutritionalHeading = nutritionalHeading;
	}

	public List<ComponentsNutritionalInfo> getNutritionalInfo() {
		return nutritionalInfo;
	}

	public void setNutritionalInfo(List<ComponentsNutritionalInfo> nutritionalInfo) {
		this.nutritionalInfo = nutritionalInfo;
	}

	public List<ComponentsAllergenInfo> getAllergenInfo() {
		return allergenInfo;
	}

	public void setAllergenInfo(List<ComponentsAllergenInfo> allergenInfo) {
		this.allergenInfo = allergenInfo;
	}

	public AdditionalProperties getAdditionalProperties() {
		return additionalProperties;
	}

	public void setAdditionalProperties(AdditionalProperties additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	@Override
	public String toString() {
		return "Components [ingredients=" + ingredients + ", storage=" + storage + ", gda=" + gda
				+ ", nutritionalHeading=" + nutritionalHeading + ", nutritionalInfo=" + nutritionalInfo
				+ ", allergenInfo=" + allergenInfo + ", additionalProperties=" + additionalProperties + "]";
	}

}
