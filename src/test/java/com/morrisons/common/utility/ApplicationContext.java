package com.morrisons.common.utility;

import lombok.Value;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Value
public class ApplicationContext {

	public ApplicationContext(){
		updateTemplateMap();
	}

	public Map<String,String> templateMap = new HashMap<>();

	public Map<Object, Object> applicationDetailsMap = new HashMap<>();

	public static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
	public static HashMap<String,String> oKeyField = new LinkedHashMap();
	public static final String STORE_ID = "8";

	private Map<String,String> updateTemplateMap(){

		templateMap.put("managerUserName", ApplicationContext.applicationConfig.getUserCredentials().getManagerUsername());
		templateMap.put("managerPassword", ApplicationContext.applicationConfig.getUserCredentials().getManagerPassword());
		templateMap.put("collegueUserName", ApplicationContext.applicationConfig.getUserCredentials().getCollegueUsername());
		templateMap.put("colleguePassword", ApplicationContext.applicationConfig.getUserCredentials().getColleguePassword());
		return templateMap;
	}

/*	public Map<String, String> getTemplateMap() {
		return templateMap;
	}*/

/*	public void setTemplateMap(Map<String, String> templateMap) {
		this.templateMap = templateMap;
	}*/

//	public Map<Object, Object> getApplicationDetailsMap() {
//		return applicationDetailsMap;
//	}
//
//	public void setApplicationDetailsMap(Map<Object, Object> applicationDetailsMap) {
//		this.applicationDetailsMap = applicationDetailsMap;
//	}


}