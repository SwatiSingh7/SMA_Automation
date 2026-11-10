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
"orders"
})
public class DeliveryPO_Orders {

@JsonProperty("orders")
private List<DeliveryPO_Orderss> orders = null;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("orders")
public List<DeliveryPO_Orderss> getOrders() {
return orders;
}

@JsonProperty("orders")
public void setOrders(List<DeliveryPO_Orderss> orders) {
this.orders = orders;
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
	return "Orders [orders=" + orders + ", additionalProperties=" + additionalProperties + "]";
}


}