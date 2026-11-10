package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Glh_PostResponse {

	private String walkId;
	private String storeNumber;
	private String walkType;
	private String isCurfewStore;
	@JsonIgnoreProperties(ignoreUnknown = true)
	private Storewalk_CreationAudit creationAudit;
	 @JsonIgnoreProperties(ignoreUnknown = true)
	 private Glh_Departments[] departments;
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
	public Glh_Departments[] getDepartments() {
		return departments;
	}
	public void setDepartments(Glh_Departments[] departments) {
		this.departments = departments;
	}
	@Override
	public String toString() {
		return "PostResponse [walkId=" + walkId + ", storeNumber=" + storeNumber + ", walkType=" + walkType
				+ ", isCurfewStore=" + isCurfewStore + ", creationAudit=" + creationAudit + ", departments="
				+ Arrays.toString(departments) + "]";
	}
	 
	 
}
