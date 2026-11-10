package com.morrisons.sma.pojo.service.PricePrompPOJO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.facelets.Metadata;

import com.morrisons.sma.pojo.service.StorewalkServicePOJO.StorewalkPoJo;


public class MainWalkId {




private List<StorewalkPoJo> storewalks = null;

private Metadata metadata;

private Map<String, Object> additionalProperties = new HashMap<String, Object>();


public List<StorewalkPoJo> getStorewalks() {
return storewalks;
}


public void setStorewalks(List<StorewalkPoJo> storewalks) {
this.storewalks = storewalks;
}


public Metadata getMetadata() {
return metadata;
}

public void setMetadata(Metadata metadata) {
this.metadata = metadata;
}


public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}


public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}


@Override
public String toString() {
	return "MainWalkId [storewalks=" + storewalks + ", metadata=" + metadata + ", additionalProperties="
			+ additionalProperties + "]";
}



}

