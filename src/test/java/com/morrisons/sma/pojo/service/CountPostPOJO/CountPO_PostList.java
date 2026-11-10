package com.morrisons.sma.pojo.service.CountPostPOJO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;
public class CountPO_PostList {
	

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({
	"type",
	"name",
	"items",
	"departmentList",
	"startTime",
	"endTime",
	"date",
	"scheduleRef",
//	"isIgnoreRange",
//	"valproducts",
//	"ingredientsonly",
	"mode",
	})


	@JsonProperty("type")
	private String type;
	@JsonProperty("name")
	private String name;
	@JsonProperty("items")
	private List<String> items = new ArrayList<String>();
	@JsonProperty("departmentList")
	private List<CountPO_DepartmentList> departmentList  = new ArrayList<>();
//	@JsonProperty("departmentList")
//	private List<String> departmentList  = new ArrayList<String>();
	
	@JsonProperty("startTime")
	private String startTime;
	@JsonProperty("endTime")
	private String endTime;
	@JsonProperty("date")
	private String date;
	@JsonProperty("scheduleRef")
	private String scheduleRef;
//	@JsonProperty("isIgnoreRange")
//	private String isIgnoreRange;
//	@JsonProperty("valproducts")
//	private String valproducts;
//	@JsonProperty("ingredientsonly")
//	private String ingredientsonly;
	@JsonProperty("mode")
	private String mode;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("type")
	public String getType() {
	return type;
	}

	@JsonProperty("type")
	public void setType(String type) {
	this.type = type;
	}

	@JsonProperty("name")
	public String getName() {
	return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
	this.name = name;
	}

	@JsonProperty("items")
	public List<String> getItems() {
	return items;
	}

	@JsonProperty("items")
	public void setItems(List<String> items) {
	this.items = items;
	}

	@JsonProperty("departmentList")
	public List<CountPO_DepartmentList> getDepartmentList() {
	return departmentList;
	}

	@JsonProperty("departmentList")
	public void setDepartmentList(List<CountPO_DepartmentList> departmentList) {
	this.departmentList = departmentList;
	}
	

//	@JsonProperty("departmentList")
//	public List<String> getDepartmentList() {
//	return departmentList;
//	}
//
//	@JsonProperty("departmentList")
//	public void setDepartmentList(List<String> departmentList) {
//	this.departmentList = departmentList;
//	}

	@JsonProperty("startTime")
	public String getStartTime() {
	return startTime;
	}

	@JsonProperty("startTime")
	public void setStartTime(String startTime) {
	this.startTime = startTime;
	}

	@JsonProperty("endTime")
	public String getEndTime() {
	return endTime;
	}

	@JsonProperty("endTime")
	public void setEndTime(String endTime) {
	this.endTime = endTime;
	}

	@JsonProperty("date")
	public String getDate() {
	return date;
	}

	@JsonProperty("date")
	public void setDate(String date) {
	this.date = date;
	}

	@JsonProperty("scheduleRef")
	public String getScheduleRef() {
	return scheduleRef;
	}

	@JsonProperty("scheduleRef")
	public void setScheduleRef(String scheduleRef) {
	this.scheduleRef = scheduleRef;
	}
	
//	@JsonProperty("isIgnoreRange")
//	public String getIgnoreRange() {
//	return isIgnoreRange;
//	}
//
//	@JsonProperty("isIgnoreRange")
//	public void setIgnoreRange(String isIgnoreRange) {
//	this.isIgnoreRange = isIgnoreRange;
//	}
//	
//	@JsonProperty("valproducts")
//	public String getValProducts() {
//	return valproducts;
//	}
//
//	@JsonProperty("valproducts")
//	public void setValProducts(String valproducts) {
//	this.valproducts = valproducts;
//	}
//
//	
//	@JsonProperty("ingredientsonly")
//	public String getIngredientsonly() {
//	return ingredientsonly;
//	}
//
//	@JsonProperty("ingredientsonly")
//	public void setIngredientsonly(String ingredientsonly) {
//	this.ingredientsonly = ingredientsonly;
//	}


	@JsonProperty("mode")
	public String getMode() {
	return mode;
	}

	@JsonProperty("mode")
	public void setMode(String mode) {
	this.mode = mode;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
	}
	
	

//	public String getIsIgnoreRange() {
//		return isIgnoreRange;
//	}
//
//	public void setIsIgnoreRange(String isIgnoreRange) {
//		this.isIgnoreRange = isIgnoreRange;
//	}
//
//	public String getValproducts() {
//		return valproducts;
//	}
//
//	public void setValproducts(String valproducts) {
//		this.valproducts = valproducts;
//	}

//	@Override
//	public String toString() {
//	return new ToStringBuilder(this).append("type", type).append("name", name).append("items", items).append("departmentList", departmentList).append("startTime", startTime).append("endTime", endTime).append("date", date).append("scheduleRef", scheduleRef).append("isIgnoreRange", isIgnoreRange).append("ingredientsonly", ingredientsonly).append("valproducts", valproducts).append("mode", mode).append("additionalProperties", additionalProperties).toString();
//	}

	
	@Override
	public String toString() {
	return new ToStringBuilder(this).append("type", type).append("name", name).append("items", items).append("departmentList", departmentList).append("startTime", startTime).append("endTime", endTime).append("date", date).append("scheduleRef", scheduleRef).append("mode", mode).append("additionalProperties", additionalProperties).toString();
	}
	
	}

