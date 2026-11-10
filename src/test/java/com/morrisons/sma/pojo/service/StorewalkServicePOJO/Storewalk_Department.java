package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

import java.util.List;

public class Storewalk_Department {

	
	 public String id;
	    public String name;
	    public String sortOrder;
	    public List<Storewalk_Group> groups;
	    
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
		public List<Storewalk_Group> getGroups() {
			return groups;
		}
		public void setGroups(List<Storewalk_Group> groups) {
			this.groups = groups;
		}
		@Override
		public String toString() {
			return "CreateStorewalk_Department [id=" + id + ", name=" + name + ", sortOrder=" + sortOrder + ", groups="
					+ groups + "]";
		}
	    
	    
}
