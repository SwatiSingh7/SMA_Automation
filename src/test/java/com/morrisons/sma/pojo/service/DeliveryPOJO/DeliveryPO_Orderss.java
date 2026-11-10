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
"orderId",
"orderType",
"customerOrderId",
"customerId",
"statusCurrent",
"shipToLocationId",
"shipFromLocationId",
"lines",
"createdAt",
"orderPosition"
})
public class DeliveryPO_Orderss {

@JsonProperty("orderId")
private String orderId;
@JsonProperty("orderType")
private String orderType;
@JsonProperty("customerOrderId")
private String customerOrderId;
@JsonProperty("customerId")
private String customerId;
@JsonProperty("statusCurrent")
private String statusCurrent;
@JsonProperty("shipToLocationId")
private Integer shipToLocationId;
@JsonProperty("shipFromLocationId")
private String shipFromLocationId;
@JsonProperty("lines")
private DeliveryPO_Lines lines;
@JsonProperty("createdAt")
private String createdAt;
@JsonProperty("orderPosition")
private String orderPosition;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("orderId")
public String getOrderId() {
return orderId;
}

@JsonProperty("orderId")
public void setOrderId(String orderId) {
this.orderId = orderId;
}

@JsonProperty("orderType")
public String getOrderType() {
return orderType;
}

@JsonProperty("orderType")
public void setOrderType(String orderType) {
this.orderType = orderType;
}

@JsonProperty("customerOrderId")
public String getCustomerOrderId() {
return customerOrderId;
}

@JsonProperty("customerOrderId")
public void setCustomerOrderId(String customerOrderId) {
this.customerOrderId = customerOrderId;
}

@JsonProperty("customerId")
public String getCustomerId() {
return customerId;
}

@JsonProperty("customerId")
public void setCustomerId(String customerId) {
this.customerId = customerId;
}

@JsonProperty("statusCurrent")
public String getStatusCurrent() {
return statusCurrent;
}

@JsonProperty("statusCurrent")
public void setStatusCurrent(String statusCurrent) {
this.statusCurrent = statusCurrent;
}

@JsonProperty("shipToLocationId")
public Integer getShipToLocationId() {
return shipToLocationId;
}

@JsonProperty("shipToLocationId")
public void setShipToLocationId(Integer shipToLocationId) {
this.shipToLocationId = shipToLocationId;
}

@JsonProperty("shipFromLocationId")
public String getShipFromLocationId() {
return shipFromLocationId;
}

@JsonProperty("shipFromLocationId")
public void setShipFromLocationId(String shipFromLocationId) {
this.shipFromLocationId = shipFromLocationId;
}

@JsonProperty("lines")
public DeliveryPO_Lines getLines() {
return lines;
}

@JsonProperty("lines")
public void setLines(DeliveryPO_Lines lines) {
this.lines = lines;
}

@JsonProperty("createdAt")
public String getCreatedAt() {
return createdAt;
}

@JsonProperty("createdAt")
public void setCreatedAt(String createdAt) {
this.createdAt = createdAt;
}

@JsonProperty("orderPosition")
public String getOrderPosition() {
return orderPosition;
}

@JsonProperty("orderPosition")
public void setOrderPosition(String orderPosition) {
this.orderPosition = orderPosition;
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
	return "Orderss [orderId=" + orderId + ", orderType=" + orderType + ", customerOrderId=" + customerOrderId
			+ ", customerId=" + customerId + ", statusCurrent=" + statusCurrent + ", shipToLocationId="
			+ shipToLocationId + ", shipFromLocationId=" + shipFromLocationId + ", lines=" + lines + ", createdAt="
			+ createdAt + ", orderPosition=" + orderPosition + ", additionalProperties=" + additionalProperties + "]";
}

}

