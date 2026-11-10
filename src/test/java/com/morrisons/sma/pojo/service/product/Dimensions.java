package com.morrisons.sma.pojo.service.product;

import lombok.Value;

@Value
public class Dimensions{
	double length;
	double width;
	double weight;
	AdditionalProperties additionalProperties;
	double height;
}