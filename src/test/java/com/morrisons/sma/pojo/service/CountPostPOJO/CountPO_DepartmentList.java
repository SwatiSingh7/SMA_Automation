package com.morrisons.sma.pojo.service.CountPostPOJO;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class CountPO_DepartmentList {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({
	"department"
	})	

	@JsonProperty("department")
	private Integer department;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("department")
	public Integer getDepartment() {
	return department;
	}

	@JsonProperty("department")
	public void setDepartment(Integer department) {
	this.department = department;
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
	return new ToStringBuilder(this).append("department", department).append("additionalProperties", additionalProperties).toString();
	}

	}

