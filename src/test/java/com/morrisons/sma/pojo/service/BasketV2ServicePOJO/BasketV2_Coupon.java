package com.morrisons.sma.pojo.service.BasketV2ServicePOJO;;

public class BasketV2_Coupon {


	private BasketV2_QualifyingItems qualifyingItems;
	private String number;
	private String rewardType;
	private Object pointsType;
	private double rewardAmount;

	public BasketV2_QualifyingItems getQualifyingItems() {
		return qualifyingItems;
	}
	public void setQualifyingItems(BasketV2_QualifyingItems qualifyingItems) {
		this.qualifyingItems = qualifyingItems;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getRewardType() {
		return rewardType;
	}
	public void setRewardType(String rewardType) {
		this.rewardType = rewardType;
	}
	public Object getPointsType() {
		return pointsType;
	}
	public void setPointsType(Object pointsType) {
		this.pointsType = pointsType;
	}
	public double getRewardAmount() {
		return rewardAmount;
	}
	public void setRewardAmount(double rewardAmount) {
		this.rewardAmount = rewardAmount;
	}
	@Override
	public String toString() {
		return "BasketV2_Coupon [qualifyingItems=" + qualifyingItems + ", number=" + number + ", rewardType="
				+ rewardType + ", pointsType=" + pointsType + ", rewardAmount=" + rewardAmount + "]";
	}


}
