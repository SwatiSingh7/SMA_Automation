package com.morrisons.sma.pojo.service.product;

import lombok.Value;

@Value
public class AllergenInfoItem{
	String name;
	AdditionalProperties additionalProperties;
	String value;
}