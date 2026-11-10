package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.morrisons.sma.pojo.service.PricePrompPOJO.CreationAudit;

public class StorewalkPoJo {



private String walkId;

private Integer storeNumber;

private String walkType;

private String mode;


private List<Object> locations = null;

private Boolean isCurfewStore;

private CreationAudit creationAudit;

private Map<String, Object> additionalProperties = new HashMap<String, Object>();


public String getWalkId() {
return walkId;
}


public void setWalkId(String walkId) {
this.walkId = walkId;
}


public Integer getStoreNumber() {
return storeNumber;
}


public void setStoreNumber(Integer storeNumber) {
this.storeNumber = storeNumber;
}


public String getWalkType() {
return walkType;
}


public void setWalkType(String walkType) {
this.walkType = walkType;
}


public List<Object> getLocations() {
return locations;
}


public void setLocations(List<Object> locations) {
this.locations = locations;
}


public Boolean getIsCurfewStore() {
return isCurfewStore;
}


public void setIsCurfewStore(Boolean isCurfewStore) {
this.isCurfewStore = isCurfewStore;
}


public CreationAudit getCreationAudit() {
return creationAudit;
}


public void setCreationAudit(CreationAudit creationAudit) {
this.creationAudit = creationAudit;
}


public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}


public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}


@Override
public String toString() {
	return "StorewalkPoJo [walkId=" + walkId + ", storeNumber=" + storeNumber + ", walkType=" + walkType
			+ ", locations=" + locations + ", isCurfewStore=" + isCurfewStore + ", creationAudit=" + creationAudit
			+ ", additionalProperties=" + additionalProperties + "]";
}

}


