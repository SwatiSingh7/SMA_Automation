package com.morrisons.common.utility;

public class CnR_ActionConfig extends ActionConfiguration{

	public boolean isCnR_Functionality;
	public boolean isCnR_2_3;
	public boolean isCnR_CrispScenario;
	public boolean isCnR_SignOffScenario;
	public boolean isCnR_WeeklyAlert;
	
	public boolean isCnR_Functionality() {
		return isCnR_Functionality;
	}
	public void setCnR_Functionality(boolean isCnR_Functionality) {
		this.isCnR_Functionality = isCnR_Functionality;
	}
	public boolean isCnR_2_3() {
		return isCnR_2_3;
	}
	public void setCnR_2_3(boolean isCnR_2_3) {
		this.isCnR_2_3 = isCnR_2_3;
	}
	public boolean isCnR_CrispScenario() {
		return isCnR_CrispScenario;
	}
	public void setCnR_CrispScenario(boolean isCnR_CrispScenario) {
		this.isCnR_CrispScenario = isCnR_CrispScenario;
	}
	public boolean isCnR_SignOffScenario() {
		return isCnR_SignOffScenario;
	}
	public void setCnR_SignOffScenario(boolean isCnR_SignOffScenario) {
		this.isCnR_SignOffScenario = isCnR_SignOffScenario;
	}
	public boolean isCnR_WeeklyAlert() {
		return isCnR_WeeklyAlert;
	}
	public void setCnR_WeeklyAlert(boolean isCnR_WeeklyAlert) {
		this.isCnR_WeeklyAlert = isCnR_WeeklyAlert;
	}
	@Override
	public String toString() {
		return "ActionConfig_Subclass [isCnR_Functionality=" + isCnR_Functionality + ", isCnR_2_3=" + isCnR_2_3
				+ ", isCnR_CrispScenario=" + isCnR_CrispScenario + ", isCnR_SignOffScenario=" + isCnR_SignOffScenario
				+ ", isCnR_WeeklyAlert=" + isCnR_WeeklyAlert + "]";
	}
	
	
	
	
	
	
}
