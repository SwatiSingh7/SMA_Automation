package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.ALWAYS)
public class GlhBurst_Sections {
	
	@JsonProperty
	private String id;
	
	@JsonProperty
	private String name;
	
	@JsonProperty
	private String sortOrder;
	
	@JsonProperty
	private String status;

	@JsonProperty
	private List<GlhBurst_Items> items;

	
//	@JsonProperty
//	private String items;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

//	public String getItems() {
//		return items;
//	}
//
//	public void setItems(String items) {
//		this.items = items;
//	}
	
	public List<GlhBurst_Items> getItems() {
		return items;
	}
	public void setItems(List<GlhBurst_Items> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "GlhBurst_Sections [id=" + id + ", name=" + name + ", sortOrder=" + sortOrder + ", status=" + status
				+ " items="+ items +"]";
	}

	
	
}

