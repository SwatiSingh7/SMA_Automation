package com.morrisons.sma.pojo.service.product;

import lombok.Value;

@Value
public class PacksItem{
	int packQuantity;
	AdditionalProperties additionalProperties;
	String packNumber;
}