package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Storewalk_CommercialHierarchy {

	public String group;
	public String class_;
	public String division;
	public String subclass;
	public String className;
	public String groupName;
	public String department;
	public String divisionName;
	public String subclassName;
	public String departmentName;
	
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getClass_() {
		return class_;
	}
	public void setClass_(String class_) {
		this.class_ = class_;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getSubclass() {
		return subclass;
	}
	public void setSubclass(String subclass) {
		this.subclass = subclass;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDivisionName() {
		return divisionName;
	}
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}
	public String getSubclassName() {
		return subclassName;
	}
	public void setSubclassName(String subclassName) {
		this.subclassName = subclassName;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
@Override
	public String toString() {
		return "CreateWalkitem_CommercialHierarchy [group=" + group + ", class_=" + class_ + ", division=" + division
				+ ", subclass=" + subclass + ", className=" + className + ", groupName=" + groupName + ", department="
				+ department + ", divisionName=" + divisionName + ", subclassName=" + subclassName + ", departmentName="
				+ departmentName + "]";
	}



}
