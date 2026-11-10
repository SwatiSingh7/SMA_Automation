package com.morrisons.sma.pojo.service.DeliveryPOJO;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"quantity",
"quantityType",
"date"
})
public class DeliveryPO_Receipted {

@JsonProperty("quantity")
private Integer quantity;
@JsonProperty("quantityType")
private String quantityType;
@JsonProperty("date")
private String date;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("quantity")
public Integer getQuantity() {
return quantity;
}

@JsonProperty("quantity")
public void setQuantity(Integer quantity) {
this.quantity = quantity;
}

@JsonProperty("quantityType")
public String getQuantityType() {
return quantityType;
}

@JsonProperty("quantityType")
public void setQuantityType(String quantityType) {
this.quantityType = quantityType;
}

@JsonProperty("date")
public String getDate() {
return date;
}

@JsonProperty("date")
public void setDate(String date) {
this.date = date;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

@Override
public String toString() {
	return "Receipted [quantity=" + quantity + ", quantityType=" + quantityType + ", date=" + date
			+ ", additionalProperties=" + additionalProperties + "]";
}



}