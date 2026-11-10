package com.morrisons.sma.pojo.service.CountPostPOJO;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"countStatus",
"countLocation"
})
public class CountPost_OffShelfLocation {

@JsonProperty("countStatus")
private String countStatus;
@JsonProperty("countLocation")
private String countLocation;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("countStatus")
public String getCountStatus() {
return countStatus;
}

@JsonProperty("countStatus")
public void setCountStatus(String countStatus) {
this.countStatus = countStatus;
}

@JsonProperty("countLocation")
public String getCountLocation() {
return countLocation;
}

@JsonProperty("countLocation")
public void setCountLocation(String countLocation) {
this.countLocation = countLocation;
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
return new ToStringBuilder(this).append("countStatus", countStatus).append("countLocation", countLocation).append("additionalProperties", additionalProperties).toString();
}

}


