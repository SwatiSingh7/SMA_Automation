package com.morrisons.sma.pojo.service.product;

import lombok.Value;

@Value
public class ImageUrlItem{
	String shotType;
	int width;
	AdditionalProperties additionalProperties;
	String url;
	int height;
}