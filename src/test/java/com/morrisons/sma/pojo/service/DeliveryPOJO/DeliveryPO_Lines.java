package com.morrisons.sma.pojo.service.DeliveryPOJO;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"itemLineId",
"itemId",
"quantityUnitId",
"quantityType",
"status",
"delivery"
})
public class DeliveryPO_Lines {

@JsonProperty("itemLineId")
private Integer itemLineId;
@JsonProperty("itemId")
private String itemId;
@JsonProperty("quantityUnitId")
private String quantityUnitId;
@JsonProperty("quantityType")
private String quantityType;
@JsonProperty("status")
private List<DeliveryPO_Status> status = null;
@JsonProperty("delivery")
private DeliveryPO_Delivery delivery;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("itemLineId")
public Integer getItemLineId() {
return itemLineId;
}

@JsonProperty("itemLineId")
public void setItemLineId(Integer itemLineId) {
this.itemLineId = itemLineId;
}

@JsonProperty("itemId")
public String getItemId() {
return itemId;
}

@JsonProperty("itemId")
public void setItemId(String itemId) {
this.itemId = itemId;
}

@JsonProperty("quantityUnitId")
public String getQuantityUnitId() {
return quantityUnitId;
}

@JsonProperty("quantityUnitId")
public void setQuantityUnitId(String quantityUnitId) {
this.quantityUnitId = quantityUnitId;
}

@JsonProperty("quantityType")
public String getQuantityType() {
return quantityType;
}

@JsonProperty("quantityType")
public void setQuantityType(String quantityType) {
this.quantityType = quantityType;
}

@JsonProperty("status")
public List<DeliveryPO_Status> getStatus() {
return status;
}

@JsonProperty("status")
public void setStatus(List<DeliveryPO_Status> status) {
this.status = status;
}

@JsonProperty("delivery")
public DeliveryPO_Delivery getDelivery() {
return delivery;
}

@JsonProperty("delivery")
public void setDelivery(DeliveryPO_Delivery delivery) {
this.delivery = delivery;
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
	return "Lines [itemLineId=" + itemLineId + ", itemId=" + itemId + ", quantityUnitId=" + quantityUnitId
			+ ", quantityType=" + quantityType + ", delivery=" + delivery + ", additionalProperties="
			+ additionalProperties + "]";
}



}