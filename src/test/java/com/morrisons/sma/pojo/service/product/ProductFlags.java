package com.morrisons.sma.pojo.service.product;

import lombok.Value;

@Value
public class ProductFlags{
	boolean packInd;
	boolean perishableInd;
	boolean constDimenInd;
	Object packType;
	boolean simplePackInd;
	Object catchWeightUom;
	boolean orderableInd;
	boolean inventoryInd;
	boolean merchandiseInd;
	boolean sellableInd;
}