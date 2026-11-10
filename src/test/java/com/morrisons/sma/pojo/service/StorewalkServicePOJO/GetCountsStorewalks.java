package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

import java.util.List;

public class GetCountsStorewalks {

	private String walkId;
    private String storeNumber;
    private String walkType;
    private String mode;
    private String name;
    private List<GetCountLocationDetails> locations;
    private String storeWalkStatus;
    private boolean isCurfewStore;
    private List<Storewalk_Department> departments;
    
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
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<GetCountLocationDetails> getLocations() {
		return locations;
	}
	public void setLocations(List<GetCountLocationDetails> locations) {
		this.locations = locations;
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
	public List<Storewalk_Department> getDepartments() {
		return departments;
	}
	public void setDepartments(List<Storewalk_Department> departments) {
		this.departments = departments;
	}
	@Override
	public String toString() {
		return "GetCountsStorewalks [walkId=" + walkId + ", storeNumber=" + storeNumber + ", walkType=" + walkType
				+ ", mode=" + mode + ", name=" + name + ", locations=" + locations + ", storeWalkStatus="
				+ storeWalkStatus + ", isCurfewStore=" + isCurfewStore + ", departments=" + departments + "]";
	}
    
    
    
}
