package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

import java.util.List;

public class GetCountsDept {
	
	  private String id;
	  private String name;
	    private String sortOrder;
	    private List<GetCountsGrp> groups;
	    
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
		public List<GetCountsGrp> getGroups() {
			return groups;
		}
		public void setGroups(List<GetCountsGrp> groups) {
			this.groups = groups;
		}
		@Override
		public String toString() {
			return "GetCountsDept [id=" + id + ", name=" + name + ", sortOrder=" + sortOrder + ", groups=" + groups
					+ "]";
		}
	    
	    
	    
}
