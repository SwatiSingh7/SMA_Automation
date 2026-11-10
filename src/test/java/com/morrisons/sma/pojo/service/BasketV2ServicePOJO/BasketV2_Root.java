package com.morrisons.sma.pojo.service.BasketV2ServicePOJO;

import java.util.List;

public class BasketV2_Root {


	private Object departmentSales;
	private BasketV2_Header header;
	private BasketV2_Items items;
	private List<BasketV2_TenderedCoupon> tenderedCoupons;
	private Object triggeredPromotions;
	private List<Object> triggeredConflicts;
	private BasketV2_CalculatedRewards calculatedRewards;
	private List<Object> errorResponse;
	private List<BasketV2_ClientInstruction> clientInstruction;

	public Object getDepartmentSales() {
		return departmentSales;
	}
	public void setDepartmentSales(Object departmentSales) {
		this.departmentSales = departmentSales;
	}
	public BasketV2_Header getHeader() {
		return header;
	}
	public void setHeader(BasketV2_Header header) {
		this.header = header;
	}
	public BasketV2_Items getItems() {
		return items;
	}
	public void setItems(BasketV2_Items items) {
		this.items = items;
	}
	public List<BasketV2_TenderedCoupon> getTenderedCoupons() {
		return tenderedCoupons;
	}
	public void setTenderedCoupons(List<BasketV2_TenderedCoupon> tenderedCoupons) {
		this.tenderedCoupons = tenderedCoupons;
	}
	public Object getTriggeredPromotions() {
		return triggeredPromotions;
	}
	public void setTriggeredPromotions(Object triggeredPromotions) {
		this.triggeredPromotions = triggeredPromotions;
	}
	public List<Object> getTriggeredConflicts() {
		return triggeredConflicts;
	}
	public void setTriggeredConflicts(List<Object> triggeredConflicts) {
		this.triggeredConflicts = triggeredConflicts;
	}
	public BasketV2_CalculatedRewards getCalculatedRewards() {
		return calculatedRewards;
	}
	public void setCalculatedRewards(BasketV2_CalculatedRewards calculatedRewards) {
		this.calculatedRewards = calculatedRewards;
	}
	public List<Object> getErrorResponse() {
		return errorResponse;
	}
	public void setErrorResponse(List<Object> errorResponse) {
		this.errorResponse = errorResponse;
	}
	public List<BasketV2_ClientInstruction> getClientInstruction() {
		return clientInstruction;
	}
	public void setClientInstruction(List<BasketV2_ClientInstruction> clientInstruction) {
		this.clientInstruction = clientInstruction;
	}
	@Override
	public String toString() {
		return "BasketV2_Root [departmentSales=" + departmentSales + ", header=" + header + ", items=" + items
				+ ", tenderedCoupons=" + tenderedCoupons + ", triggeredPromotions=" + triggeredPromotions
				+ ", triggeredConflicts=" + triggeredConflicts + ", calculatedRewards=" + calculatedRewards
				+ ", errorResponse=" + errorResponse + ", clientInstruction=" + clientInstruction + "]";
	}


}
