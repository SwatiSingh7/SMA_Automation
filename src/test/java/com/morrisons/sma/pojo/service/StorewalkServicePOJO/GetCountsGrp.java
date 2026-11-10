package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

import java.util.List;

public class GetCountsGrp {

    private String id;
    private String name;
    private String sortOrder;
    private List<GetCountsSect> sections;
    
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
	public List<GetCountsSect> getSections() {
		return sections;
	}
	public void setSections(List<GetCountsSect> sections) {
		this.sections = sections;
	}
	@Override
	public String toString() {
		return "GetCountsGrp [id=" + id + ", name=" + name + ", sortOrder=" + sortOrder + ", sections=" + sections
				+ "]";
	}
    
	
    
	
}
