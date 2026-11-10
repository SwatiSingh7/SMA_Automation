package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.ALWAYS)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class GlhBurst_Departments {


	@JsonProperty
	private String id;
	
	@JsonProperty
	private String name;
	
	@JsonProperty
	private String sortOrder;
	
	@JsonProperty
	private List<GlhBurst_Groups> groups;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	

	public List<GlhBurst_Groups> getGroups() {
		return groups;
	}

	public void setGroups(List<GlhBurst_Groups> groups) {
		this.groups = groups;
	}

	@Override
	public String toString() {
		return "GlhBurst_Departments [id=" + id + ", name=" + name + ", sortOrder=" + sortOrder + ", groups=" + groups
				+ "]";
	}


}
