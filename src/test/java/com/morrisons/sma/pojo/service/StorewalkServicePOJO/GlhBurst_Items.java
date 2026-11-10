package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.ALWAYS)
public class GlhBurst_Items {

	@JsonProperty
	private String productId;

	@JsonProperty
	private String standardUnitOfMeasure;

	@JsonProperty
	private String quantityUnitId;

	@JsonProperty
	private String description;

	@JsonProperty
	private String qtyOnHand;

	@JsonProperty
	private String SOHValue;

	@JsonProperty
	private String qtyInTransit;

	@JsonProperty
	private String stockState;

	@JsonProperty
	private String isDeliveryExpectedDateToday;

	@JsonProperty
	private String isReceited;

	@JsonProperty
	private List<Storewalk_Plan> plan;

	public List<Storewalk_Plan> getPlan() {
		return plan;
	}

	public void setPlan(List<Storewalk_Plan> plan) {
		this.plan = plan;
	}

	@JsonProperty
	private String rangeStatus;

	@JsonProperty
	//private List<GlhBurst_CommercialHierarchy> commercialHierarchy;
    private Storewalk_CommercialHierarchy commercialHierarchy;


	
	public Storewalk_CommercialHierarchy getCommercialHierarchy() {
		return commercialHierarchy;
	}

	public void setCommercialHierarchy(Storewalk_CommercialHierarchy commercialHierarchy) {
		this.commercialHierarchy = commercialHierarchy;
	}

	@JsonProperty
	private Storewalk_Pack pack;

	public Storewalk_Pack getPack() {
		return pack;
	}

	public void setPack(Storewalk_Pack pack) {
		this.pack = pack;
	}

	@JsonProperty
	private Glh_CountType countType;

	public Glh_CountType getCountType() {
		return countType;
	}

	public void setCountType(Glh_CountType countType) {
		this.countType = countType;
	}

	@JsonProperty
	private Glh_Deliverys delivery;

	public Glh_Deliverys getDelivery() {
		return delivery;
	}

	public void setDelivery(Glh_Deliverys delivery) {
		this.delivery = delivery;
	}

	@JsonProperty
	private String packSize;

	@JsonProperty
	private String variance;

	@JsonProperty
	private String variancePercentage;

	@JsonProperty
	private String partOfCount;

	@JsonProperty
	private String reviewCaptureCount;

	@JsonProperty
	private Storewalk_CreationAudit creationAudit;

	public Storewalk_CreationAudit getCreationAudit() {
		return creationAudit;
	}

	public void setCreationAudit(Storewalk_CreationAudit creationAudit) {
		this.creationAudit = creationAudit;
	}

	@JsonProperty
	private Glh_UpdateAudit updateAudit;

	public Glh_UpdateAudit getUpdateAudit() {
		return updateAudit;
	}

	public void setUpdateAudit(Glh_UpdateAudit updateAudit) {
		this.updateAudit = updateAudit;
	}

	@JsonProperty
	private Storewalk_Action action;

	public Storewalk_Action getAction() {
		return action;
	}

	public void setAction(Storewalk_Action action) {
		this.action = action;
	}

	@JsonProperty
	private List<Glh_Captures> captures;


	public List<Glh_Captures> getCaptures() {
		return captures;
	}

	public void setCaptures(List<Glh_Captures> captures) {
		this.captures = captures;
	}

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

	public String getQuantityUnitId() {
		return quantityUnitId;
	}

	public void setQuantityUnitId(String quantityUnitId) {
		this.quantityUnitId = quantityUnitId;
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

	public String getSOHValue() {
		return SOHValue;
	}

	public void setSOHValue(String sOHValue) {
		SOHValue = sOHValue;
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

	

	public String getRangeStatus() {
		return rangeStatus;
	}

	public void setRangeStatus(String rangeStatus) {
		this.rangeStatus = rangeStatus;
	}


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

	public String getReviewCaptureCount() {
		return reviewCaptureCount;
	}

	public void setReviewCaptureCount(String reviewCaptureCount) {
		this.reviewCaptureCount = reviewCaptureCount;
	}


	

	@Override
	public String toString() {
		return "GlhBurst_Items [productId=" + productId + ", standardUnitOfMeasure=" + standardUnitOfMeasure
				+ ", quantityUnitId=" + quantityUnitId + ", description=" + description + ", qtyOnHand=" + qtyOnHand
				+ ", SOHValue=" + SOHValue + ", qtyInTransit=" + qtyInTransit + ", stockState=" + stockState
				+ ", isDeliveryExpectedDateToday=" + isDeliveryExpectedDateToday + ", isReceited=" + isReceited
				+ ", plan=" + plan + ", rangeStatus=" + rangeStatus 
				+ ", pack=" + pack + ", countType=" + countType + ", delivery=" + delivery + ", packSize=" + packSize
				+ ", variance=" + variance + ", variancePercentage=" + variancePercentage + ", partOfCount="
				+ partOfCount + ", reviewCaptureCount=" + reviewCaptureCount + ", creationAudit=" + creationAudit
				+ ", updateAudit=" + updateAudit + ", com.morrisons.common.action=" + action + ", captures=" + captures + ", commercialHierarchy="+ commercialHierarchy +"]";
	}
}
