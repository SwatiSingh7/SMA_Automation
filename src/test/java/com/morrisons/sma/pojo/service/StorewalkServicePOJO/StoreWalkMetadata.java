package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

import java.util.HashMap;
import java.util.Map;

public class StoreWalkMetadata {
	
	private Integer limit;
	
	private Integer count;
	
	private Integer offset;
	
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();


	public Integer getLimit() {
	return limit;
	}

	
	public void setLimit(Integer limit) {
	this.limit = limit;
	}

	
	public Integer getCount() {
	return count;
	}

	
	public void setCount(Integer count) {
	this.count = count;
	}


	public Integer getOffset() {
	return offset;
	}

	
	public void setOffset(Integer offset) {
	this.offset = offset;
	}

	
	public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
	}

	
	public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
	}


	@Override
	public String toString() {
		return "StoreWalkMetadata [limit=" + limit + ", count=" + count + ", offset=" + offset
				+ ", additionalProperties=" + additionalProperties + "]";
	}
	
	
}
