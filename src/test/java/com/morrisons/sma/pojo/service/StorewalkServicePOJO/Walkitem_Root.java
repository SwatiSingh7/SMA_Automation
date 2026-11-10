package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Walkitem_Root {

	public String productId;
    public String standardUnitOfMeasure;
    public String stockUom;
    public String description;
    public String qtyOnHand;
    @JsonProperty("SOHValue") 
    public String sOHValue;
    public String qtyInTransit;
    public String stockState;
    public String isDeliveryExpectedDateToday;
    public String isReceited;
    public List<Storewalk_Plan> plan;
    public Storewalk_CommercialHierarchy commercialHierarchy;
    public String price;
    public String adjustmentPrice;
    public String isLargeAdjustment;
    public String packSize;
    public String variance;
    public String variancePercentage;
    public String partOfCount;
    public Storewalk_Pack pack;
    public Storewalk_CountType countType;
    public String reviewCaptureCount;
    public Storewalk_CreationAudit creationAudit;
    public Storewalk_Action action;
    
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
	public String getStockUom() {
		return stockUom;
	}
	public void setStockUom(String stockUom) {
		this.stockUom = stockUom;
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
	public String getQtyInTransit() {
		return qtyInTransit;
	}
	public void setQtyInTransit(String qtyInTransit) {
		this.qtyInTransit = qtyInTransit;
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
//	public CreateWalkitem_Order getOrder() {
//		return order;
//	}
//	public void setOrder(CreateWalkitem_Order order) {
//		this.order = order;
//	}
	public String getPackSize() {
		return packSize;
	}
	public void setPackSize(String packSize) {
		this.packSize = packSize;
	}
	public String getVariance() {
		return variance;
	}
	public void setVariance(String variance) {
		this.variance = variance;
	}
	public String getVariancePercentage() {
		return variancePercentage;
	}
	public void setVariancePercentage(String variancePercentage) {
		this.variancePercentage = variancePercentage;
	}
	public String getPartOfCount() {
		return partOfCount;
	}
	public void setPartOfCount(String partOfCount) {
		this.partOfCount = partOfCount;
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
	public String getReviewCaptureCount() {
		return reviewCaptureCount;
	}
	public void setReviewCaptureCount(String reviewCaptureCount) {
		this.reviewCaptureCount = reviewCaptureCount;
	}
	public Storewalk_CreationAudit getCreationAudit() {
		return creationAudit;
	}
	public void setCreationAudit(Storewalk_CreationAudit creationAudit) {
		this.creationAudit = creationAudit;
	}
	public Storewalk_Action getAction() {
		return action;
	}
	public void setAction(Storewalk_Action action) {
		this.action = action;
	}
	@Override
	public String toString() {
		return "CreateWalkitem_Root [productId=" + productId + ", standardUnitOfMeasure=" + standardUnitOfMeasure
				+ ", stockUom=" + stockUom + ", description=" + description + ", qtyOnHand=" + qtyOnHand + ", sOHValue="
				+ sOHValue + ", qtyInTransit=" + qtyInTransit + ", stockState=" + stockState
				+ ", isDeliveryExpectedDateToday=" + isDeliveryExpectedDateToday + ", isReceited=" + isReceited
				+ ", plan=" + plan + ", commercialHierarchy=" + commercialHierarchy + ", price=" + price
				+ ", adjustmentPrice=" + adjustmentPrice + ", isLargeAdjustment=" + isLargeAdjustment + ", packSize="
				+ packSize + ", variance=" + variance + ", variancePercentage=" + variancePercentage + ", partOfCount="
				+ partOfCount + ", pack=" + pack + ", countType=" + countType + ", reviewCaptureCount="
				+ reviewCaptureCount + ", creationAudit=" + creationAudit + ", com.morrisons.common.action=" + action + "]";
	}
    
    
    
}
