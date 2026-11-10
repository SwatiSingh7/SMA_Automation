package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

import java.util.List;

public class GetStorewalksss_Storewalk {

	public String walkId;
    public String storeNumber;
    public String walkType;

    public String isCurfewStore;
    public Storewalk_CreationAudit creationAudit;
    public List<Storewalk_Department> departments;
    
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

	public String getIsCurfewStore() {
		return isCurfewStore;
	}
	public void setIsCurfewStore(String isCurfewStore) {
		this.isCurfewStore = isCurfewStore;
	}
	public Storewalk_CreationAudit getCreationAudit() {
		return creationAudit;
	}
	public void setCreationAudit(Storewalk_CreationAudit creationAudit) {
		this.creationAudit = creationAudit;
	}
	
	
	
	public List<Storewalk_Department> getDepartments() {
		return departments;
	}
	public void setDepartments(List<Storewalk_Department> departments) {
		this.departments = departments;
	}
	@Override
	public String toString() {
		return "GetStorewalksss_Storewalk [walkId=" + walkId + ", storeNumber=" + storeNumber + ", walkType=" + walkType
				+ ", isCurfewStore=" + isCurfewStore + ", creationAudit=" + creationAudit + ", departments="
				+ departments + "]";
	}
    
    
    
}
