package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

import java.util.List;

public class GetCountsSect {

	
    private String id;
    private String name;
    private String sortOrder;
    private String status;
    private List<GetCountsItems> items;
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
	public List<GetCountsItems> getItems() {
		return items;
	}
	public void setItems(List<GetCountsItems> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "GetCountsSect [id=" + id + ", name=" + name + ", sortOrder=" + sortOrder + ", status=" + status
				+ ", items=" + items + "]";
	}
    
    
    
}
