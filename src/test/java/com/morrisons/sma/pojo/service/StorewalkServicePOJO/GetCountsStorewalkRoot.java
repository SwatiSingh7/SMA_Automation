package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

import java.util.List;

public class GetCountsStorewalkRoot {

	 private String walkId;
	    private String storeNumber;
	    private String walkType;
	    private String name;
		    private String schedule_ref;
	    private String date;
	    private String mode;
	    private String storeWalkStatus;
	    private boolean isCurfewStore;
	    private String ingredientsOnly;
	    private String start_time;
	    private String end_time;
	    private List<GetCountLocationDetails> locations;
	    private Storewalk_CreationAudit creationAudit;
	    private List<GetCountsDept> departments;
	    
		public String getWalkId() {
			return walkId;
		}
		public void setWalkId(String walkId) {
			this.walkId = walkId;
		}
		public String getStoreNumber() {
			return storeNumber;
		}
		public void setStoreNumber(String storeNumber) {
			this.storeNumber = storeNumber;
		}
		public String getWalkType() {
			return walkType;
		}
		public void setWalkType(String walkType) {
			this.walkType = walkType;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public String getSchedule_ref() {
			return schedule_ref;
		}
		public void setSchedule_ref(String schedule_ref) {
			this.schedule_ref = schedule_ref;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getMode() {
			return mode;
		}
		public void setMode(String mode) {
			this.mode = mode;
		}
		public String getStoreWalkStatus() {
			return storeWalkStatus;
		}
		public void setStoreWalkStatus(String storeWalkStatus) {
			this.storeWalkStatus = storeWalkStatus;
		}
		public boolean isCurfewStore() {
			return isCurfewStore;
		}
		public void setCurfewStore(boolean isCurfewStore) {
			this.isCurfewStore = isCurfewStore;
		}
		public String getIngredientsOnly() {
			return ingredientsOnly;
		}
		public void setIngredientsOnly(String ingredientsOnly) {
			this.ingredientsOnly = ingredientsOnly;
		}
		public String getStart_time() {
			return start_time;
		}
		public void setStart_time(String start_time) {
			this.start_time = start_time;
		}
		public String getEnd_time() {
			return end_time;
		}
		public void setEnd_time(String end_time) {
			this.end_time = end_time;
		}
		public List<GetCountLocationDetails> getLocations() {
			return locations;
		}
		public void setLocations(List<GetCountLocationDetails> locations) {
			this.locations = locations;
		}
		public Storewalk_CreationAudit getCreationAudit() {
			return creationAudit;
		}
		public void setCreationAudit(Storewalk_CreationAudit creationAudit) {
			this.creationAudit = creationAudit;
		}
		public List<GetCountsDept> getDepartments() {
			return departments;
		}
		public void setDepartments(List<GetCountsDept> departments) {
			this.departments = departments;
		}
		
		@Override
		public String toString() {
			return "GetCountsStorewalkRoot [walkId=" + walkId + ", storeNumber=" + storeNumber + ", walkType="
					+ walkType + ", name=" + name + ", schedule_ref=" + schedule_ref
					+ ", date=" + date + ", mode=" + mode + ", storeWalkStatus=" + storeWalkStatus + ", isCurfewStore="
					+ isCurfewStore + ", ingredientsOnly=" + ingredientsOnly + ", start_time=" + start_time
					+ ", end_time=" + end_time + ", locations=" + locations + ", creationAudit=" + creationAudit
					+ ", departments=" + departments + "]";
		}
	    
	    
	
	    
}
