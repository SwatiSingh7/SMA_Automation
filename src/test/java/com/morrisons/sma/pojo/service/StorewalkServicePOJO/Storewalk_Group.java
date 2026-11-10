package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

import java.util.List;

public class Storewalk_Group {

    public String id;
    public String name;
    public String sortOrder;
    public List<Storewalk_Section> sections;
    
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
	public List<Storewalk_Section> getSections() {
		return sections;
	}
	public void setSections(List<Storewalk_Section> sections) {
		this.sections = sections;
	}
	@Override
	public String toString() {
		return "CreateStorewalk_Group [id=" + id + ", name=" + name + ", sortOrder=" + sortOrder + ", sections="
				+ sections + "]";
	}
    
    
}
