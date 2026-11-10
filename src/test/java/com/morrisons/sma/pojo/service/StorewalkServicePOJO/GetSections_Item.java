package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetSections_Item {

	public String productId;
    public String standardUnitOfMeasure;
    public String description;
    public String qtyOnHand;
    @JsonProperty("SOHValue") 
    public String sOHValue;
    public String qtyStringransit;
    public String stockState;
    public String isDeliveryExpectedDateToday;
    public String isReceited;
    public List<Storewalk_Plan> plan;
    public String rangeStatus;
    public Storewalk_CommercialHierarchy commercialHierarchy;
    public String price;
    public String adjustmentPrice;
    public String isLargeAdjustment;
    public Storewalk_Pack pack;
    public Storewalk_CountType countType;
    //public GetSections_Order order;
    public Storewalk_CreationAudit creationAudit;
    public GetSections_UpdateAudit updateAudit;
    public Storewalk_Action action;
    public List<Storewalk_Capture> captures;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getStandardUnitOfMeasure() {
		return standardUnitOfMeasure;
	}
	public void setStandardUnitOfMeasure(String standardUnitOfMeasure) {
		this.standardUnitOfMeasure = standardUnitOfMeasure;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getQtyOnHand() {
		return qtyOnHand;
	}
	public void setQtyOnHand(String qtyOnHand) {
		this.qtyOnHand = qtyOnHand;
	}
	public String getsOHValue() {
		return sOHValue;
	}
	public void setsOHValue(String sOHValue) {
		this.sOHValue = sOHValue;
	}
	public String getQtyStringransit() {
		return qtyStringransit;
	}
	public void setQtyStringransit(String qtyStringransit) {
		this.qtyStringransit = qtyStringransit;
	}
	public String getStockState() {
		return stockState;
	}
	public void setStockState(String stockState) {
		this.stockState = stockState;
	}
	public String getIsDeliveryExpectedDateToday() {
		return isDeliveryExpectedDateToday;
	}
	public void setIsDeliveryExpectedDateToday(String isDeliveryExpectedDateToday) {
		this.isDeliveryExpectedDateToday = isDeliveryExpectedDateToday;
	}
	public String getIsReceited() {
		return isReceited;
	}
	public void setIsReceited(String isReceited) {
		this.isReceited = isReceited;
	}
	public List<Storewalk_Plan> getPlan() {
		return plan;
	}
	public void setPlan(List<Storewalk_Plan> plan) {
		this.plan = plan;
	}
	public String getRangeStatus() {
		return rangeStatus;
	}
	public void setRangeStatus(String rangeStatus) {
		this.rangeStatus = rangeStatus;
	}
	public Storewalk_CommercialHierarchy getCommercialHierarchy() {
		return commercialHierarchy;
	}
	public void setCommercialHierarchy(Storewalk_CommercialHierarchy commercialHierarchy) {
		this.commercialHierarchy = commercialHierarchy;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getAdjustmentPrice() {
		return adjustmentPrice;
	}
	public void setAdjustmentPrice(String adjustmentPrice) {
		this.adjustmentPrice = adjustmentPrice;
	}
	public String getIsLargeAdjustment() {
		return isLargeAdjustment;
	}
	public void setIsLargeAdjustment(String isLargeAdjustment) {
		this.isLargeAdjustment = isLargeAdjustment;
	}
	public Storewalk_Pack getPack() {
		return pack;
	}
	public void setPack(Storewalk_Pack pack) {
		this.pack = pack;
	}
	public Storewalk_CountType getCountType() {
		return countType;
	}
	public void setCountType(Storewalk_CountType countType) {
		this.countType = countType;
	}
//	public GetSections_Order getOrder() {
//		return order;
//	}
//	public void setOrder(GetSections_Order order) {
//		this.order = order;
//	}
	public Storewalk_CreationAudit getCreationAudit() {
		return creationAudit;
	}
	public void setCreationAudit(Storewalk_CreationAudit creationAudit) {
		this.creationAudit = creationAudit;
	}
	public GetSections_UpdateAudit getUpdateAudit() {
		return updateAudit;
	}
	public void setUpdateAudit(GetSections_UpdateAudit updateAudit) {
		this.updateAudit = updateAudit;
	}
	public Storewalk_Action getAction() {
		return action;
	}
	public void setAction(Storewalk_Action action) {
		this.action = action;
	}
	public List<Storewalk_Capture> getCaptures() {
		return captures;
	}
	public void setCaptures(List<Storewalk_Capture> captures) {
		this.captures = captures;
	}
	@Override
	public String toString() {
		return "GetSections_Item [productId=" + productId + ", standardUnitOfMeasure=" + standardUnitOfMeasure
				+ ", description=" + description + ", qtyOnHand=" + qtyOnHand + ", sOHValue=" + sOHValue
				+ ", qtyStringransit=" + qtyStringransit + ", stockState=" + stockState
				+ ", isDeliveryExpectedDateToday=" + isDeliveryExpectedDateToday + ", isReceited=" + isReceited
				+ ", plan=" + plan + ", rangeStatus=" + rangeStatus + ", commercialHierarchy=" + commercialHierarchy
				+ ", price=" + price + ", adjustmentPrice=" + adjustmentPrice + ", isLargeAdjustment="
				+ isLargeAdjustment + ", pack=" + pack + ", countType=" + countType + ", creationAudit=" + creationAudit
				+ ", updateAudit=" + updateAudit + ", com.morrisons.common.action=" + action + ", captures=" + captures + "]";
	}
    
    
    
}
