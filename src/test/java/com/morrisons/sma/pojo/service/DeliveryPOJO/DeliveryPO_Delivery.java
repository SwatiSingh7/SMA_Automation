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
"dateAvailabilityExpected",
"dateDeliveryExpected"
})
public class DeliveryPO_Delivery {

@JsonProperty("dateAvailabilityExpected")
private String dateAvailabilityExpected;
@JsonProperty("dateDeliveryExpected")
private String dateDeliveryExpected;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("dateAvailabilityExpected")
public String getDateAvailabilityExpected() {
return dateAvailabilityExpected;
}

@JsonProperty("dateAvailabilityExpected")
public void setDateAvailabilityExpected(String dateAvailabilityExpected) {
this.dateAvailabilityExpected = dateAvailabilityExpected;
}

@JsonProperty("dateDeliveryExpected")
public String getDateDeliveryExpected() {
return dateDeliveryExpected;
}

@JsonProperty("dateDeliveryExpected")
public void setDateDeliveryExpected(String dateDeliveryExpected) {
this.dateDeliveryExpected = dateDeliveryExpected;
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
	return "Delivery [dateAvailabilityExpected=" + dateAvailabilityExpected + ", dateDeliveryExpected="
			+ dateDeliveryExpected + ", additionalProperties=" + additionalProperties + "]";
}



}
