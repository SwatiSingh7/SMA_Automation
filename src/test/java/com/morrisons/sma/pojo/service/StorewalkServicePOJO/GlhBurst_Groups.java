package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.ALWAYS)
public class GlhBurst_Groups {

	@JsonProperty
	private String id;

	@JsonProperty
	private String name;

	@JsonProperty
	private String sortOrder;

	@JsonProperty
	private List<GlhBurst_Sections> sections;

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

	public List<GlhBurst_Sections> getSections() {
		return sections;
	}

	public void setSections(List<GlhBurst_Sections> sections) {
		this.sections = sections;
	}

	@Override
	public String toString() {
		return "GlhBurst_Groups [id=" + id + ", name=" + name + ", sortOrder=" + sortOrder + ", sections=" + sections
				+ "]";
	}


}