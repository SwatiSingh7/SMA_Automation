package com.morrisons.sma.pojo.service.product;

import lombok.Value;

@Value
public class NutritionalInfoItem{
	String perComp;
	String name;
	AdditionalProperties additionalProperties;
	Object perServing;
}