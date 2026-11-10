package com.morrisons.sma.pojo.service.product;

import lombok.Value;

@Value
public class ProductRestrictions{
	String fuelCardRestrictions;
	String allowQuantityMultiplier;
	String refundable;
	String wetStock;
	String operatorAgeCheck;
}