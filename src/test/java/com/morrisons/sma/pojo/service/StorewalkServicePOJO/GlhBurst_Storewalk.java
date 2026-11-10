package com.morrisons.sma.pojo.service.StorewalkServicePOJO;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;



//@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GlhBurst_Storewalk {

	@JsonProperty
	private String walkId;

	@JsonProperty
	private String storeNumber;
	
	@JsonProperty
	private String walkType;

	@JsonProperty
	private String isCurfewStore;
	
	@JsonProperty
	private List<Storewalk_Locations> locations;
	
	@JsonProperty
	private Storewalk_CreationAudit creationAudit;
	
	@JsonProperty
	private List<Storewalk_Department> departments;
	
	@JsonProperty
	private List<Storewalk_Group> groups;
	
	@JsonProperty
	private List<Storewalk_Section> sections;
	
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

	public List<Storewalk_Locations> getLocations() {
		return locations;
	}

	public void setLocations(List<Storewalk_Locations> locations) {
		this.locations = locations;
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
	
	public List<Storewalk_Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Storewalk_Group> groups) {
		this.groups = groups;
	}

	public List<Storewalk_Section> getSections() {
		return sections;
	}

	public void setSections(List<Storewalk_Section> sections) {
		this.sections = sections;
	}

	@Override
	public String toString() {
		return "GlhBurst_Storewalk [walkId=" + walkId + ", storeNumber=" + storeNumber + ", walkType=" + walkType
				+ ", isCurfewStore=" + isCurfewStore + ", locations=" + locations + ", creationAudit=" + creationAudit
				+ ", departments=" + departments + ", groups=" + groups + ", sections=" + sections + "]";
	}

	


}