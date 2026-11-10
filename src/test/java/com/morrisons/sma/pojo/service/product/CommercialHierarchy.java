package com.morrisons.sma.pojo.service.product;

import lombok.Value;

@Value
public class CommercialHierarchy{
	int division;
	String departmentName;
	String groupName;
	String divisionName;
	int _class;
	int subclass;
	String className;
	String subclassName;
	AdditionalProperties additionalProperties;
	int department;
	int group;
}