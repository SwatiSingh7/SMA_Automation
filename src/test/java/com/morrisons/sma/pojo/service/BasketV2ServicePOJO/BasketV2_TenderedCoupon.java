package com.morrisons.sma.pojo.service.BasketV2ServicePOJO;

import java.util.List;

public class BasketV2_TenderedCoupon {

	
	  private List<BasketV2_Coupon> coupon;

	public List<BasketV2_Coupon> getCoupon() {
		return coupon;
	}

	public void setCoupon(List<BasketV2_Coupon> coupon) {
		this.coupon = coupon;
	}

	@Override
	public String toString() {
		return "BasketV2_TenderedCoupon [coupon=" + coupon + "]";
	}
	  
	  
	  
}
