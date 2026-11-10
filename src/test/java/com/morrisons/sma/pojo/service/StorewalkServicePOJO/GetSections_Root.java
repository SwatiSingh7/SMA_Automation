package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

import java.util.List;

public class GetSections_Root {

	public String id;
    public String name;
    public String sortOrder;
    public String status;
    public List<GetSections_Item> items;
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
	public List<GetSections_Item> getItems() {
		return items;
	}
	public void setItems(List<GetSections_Item> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "GetSections_Root [id=" + id + ", name=" + name + ", sortOrder=" + sortOrder + ", status=" + status
				+ "]";
	}
 
    
}
