package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

import java.util.HashMap;
import java.util.Map;

public class StoreWalkinnerPojo {



private String empId;

private String username;

private Map<String, Object> additionalProperties = new HashMap<String, Object>();


public String getEmpId() {
return empId;
}


public void setEmpId(String empId) {
this.empId = empId;
}


public String getUsername() {
return username;
}


public void setUsername(String username) {
this.username = username;
}


public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}


public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}


@Override
public String toString() {
	return "StoreWalkinnerPojo [empId=" + empId + ", username=" + username + ", additionalProperties="
			+ additionalProperties + "]";
}


}
