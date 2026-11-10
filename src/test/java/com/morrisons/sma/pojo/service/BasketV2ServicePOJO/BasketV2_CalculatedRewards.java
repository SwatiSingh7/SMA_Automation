package com.morrisons.sma.pojo.service.BasketV2ServicePOJO;

import java.util.List;

public class BasketV2_CalculatedRewards {


	private List<Object> calculatedReward;

	public List<Object> getCalculatedReward() {
		return calculatedReward;
	}

	public void setCalculatedReward(List<Object> calculatedReward) {
		this.calculatedReward = calculatedReward;
	}

	@Override
	public String toString() {
		return "BasketV2_CalculatedRewards [calculatedReward=" + calculatedReward + "]";
	}


}
