package com.morrisons.sma.pojo.service.PricePrompPOJO;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.morrisons.sma.pojo.service.StorewalkServicePOJO.StoreWalkinnerPojo;

public class CreationAudit {


private String when;

private StoreWalkinnerPojo who;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();


public String getWhen() {
return when;
}


public void setWhen(String when) {
this.when = when;
}


public StoreWalkinnerPojo getWho() {
return who;
}


public void setWho(StoreWalkinnerPojo who) {
this.who = who;
}


public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}


public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}


@Override
public String toString() {
	return "CreationAudit [when=" + when + ", who=" + who + ", additionalProperties=" + additionalProperties + "]";
}


}
