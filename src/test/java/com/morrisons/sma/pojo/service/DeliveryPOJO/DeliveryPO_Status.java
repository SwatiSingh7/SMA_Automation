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
"ordered",
"receipted"
})
public class DeliveryPO_Status {

@JsonProperty("ordered")
private DeliveryPO_Ordered ordered;
@JsonProperty("receipted")
private DeliveryPO_Receipted receipted;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("ordered")
public DeliveryPO_Ordered getOrdered() {
return ordered;
}

@JsonProperty("ordered")
public void setOrdered(DeliveryPO_Ordered ordered) {
this.ordered = ordered;
}

@JsonProperty("receipted")
public DeliveryPO_Receipted getReceipted() {
return receipted;
}

@JsonProperty("receipted")
public void setReceipted(DeliveryPO_Receipted receipted) {
this.receipted = receipted;
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
	return "Status [ordered=" + ordered + ", receipted=" + receipted + ", additionalProperties=" + additionalProperties
			+ "]";
}


}