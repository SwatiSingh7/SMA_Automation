package com.morrisons.sma.pojo.service.product;

import lombok.Value;

@Value
public class ProductLife{
	String productLifeAtTimeOfManufacture;
	String minimumAcceptableProductLifedays;
	String productExpirationDays;
}