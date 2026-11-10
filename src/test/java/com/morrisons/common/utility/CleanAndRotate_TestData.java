package com.morrisons.common.utility;

import java.util.Arrays;

public class CleanAndRotate_TestData {

	String crispDepartment; 
	String[] crispItems; 
	String nonCrispDepartment;
	String[] nonCrispItems;
	String dairyDepartment;
	String[] dairyItems;
	
	public String getCrispDepartment() {
		return crispDepartment;
	}
	public void setCrispDepartment(String crispDepartment) {
		this.crispDepartment = crispDepartment;
	}
	public String[] getCrispItems() {
		return crispItems;
	}
	public void setCrispItems(String[] crispItems) {
		this.crispItems = crispItems;
	}
	public String getnonCrispDepartment() {
		return nonCrispDepartment;
	}
	public void setnonCrispDepartment(String nonCrispDepartment) {
		this.nonCrispDepartment = nonCrispDepartment;
	}
	public String[] getNonCrispItems() {
		return nonCrispItems;
	}
	public void setNonCrispItems(String[] nonCrispItems) {
		this.nonCrispItems = nonCrispItems;
	}
	public String getdairyDepartment() {
		return dairyDepartment;
	}
	public String[] getdairyItems() {
		return dairyItems;
	}



	@Override
	public String toString() {
		return "CleanAndRotate_TestData [crispDepartment=" + crispDepartment + ", crispItems="
				+ Arrays.toString(crispItems) + ", dairyDepartment=" + dairyDepartment + ", dairyItems=" +
				Arrays.toString(dairyItems) + ",nonCrispDepartment=" + nonCrispDepartment + ", nonCrispItems="
				+ Arrays.toString(nonCrispItems) + "]";
	}
	
	
	
}
	