package com.morrisons.sma.pojo.service.BasketV2ServicePOJO;

import java.util.List;

public class BasketV2_QualifyingItems {


	private List<BasketV2_Item> item;

	public List<BasketV2_Item> getItem() {
		return item;
	}

	public void setItem(List<BasketV2_Item> item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "BasketV2_QualifyingItems [item=" + item + "]";
	}


}
