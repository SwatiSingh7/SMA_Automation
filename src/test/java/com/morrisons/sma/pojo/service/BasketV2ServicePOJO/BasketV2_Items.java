package com.morrisons.sma.pojo.service.BasketV2ServicePOJO;

import java.util.List;

public class BasketV2_Items {


	private List<BasketV2_BasketItem> basketItem;

	public List<BasketV2_BasketItem> getBasketItem() {
		return basketItem;
	}

	public void setBasketItem(List<BasketV2_BasketItem> basketItem) {
		this.basketItem = basketItem;
	}

	@Override
	public String toString() {
		return "BasketV2_Items [basketItem=" + basketItem + "]";
	}


}
