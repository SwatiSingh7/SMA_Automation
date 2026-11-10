package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.ALWAYS)
public class NegPrompt_StorewalkItemPOJO {
	
	@JsonProperty
	private String walkItemId;
	
	@JsonProperty
	private String productId;
	
	@JsonProperty
	private String standardUnitOfMeasure;
	
	@JsonProperty
	private String quantityUnitId;
	
	@JsonProperty
	private String description;
	
	@JsonProperty
	private String SOHValue;
	
	@JsonProperty
	private String qtyOnHand;
	
	@JsonProperty
	private String qtyInTransit;
	
	@JsonProperty
	private String stockState;
	
	@JsonProperty
	private String isDeliveryExpectedDateToday;
	
	@JsonProperty
	private String isReceited;
	
	@JsonProperty
	private String packSize;
	
	@JsonProperty
	private String rangeStatus;
	
	@JsonProperty
	private String stockUom;
	
	@JsonProperty
	private Glh_Order order;
	
	@JsonProperty
	private Storewalk_Action action;
	
	@JsonProperty
	private String partOfCount;
	
	@JsonProperty
	private Storewalk_CommercialHierarchy commercialHierarchy;
	
	@JsonProperty
	private Storewalk_Pack pack;
	
	@JsonProperty
	private Glh_CountType countType;
	
	@JsonProperty
	private Glh_Deliverys delivery;
	
	@JsonProperty
	private List<Storewalk_Plan> plan;
	
	@JsonProperty
	private Storewalk_CreationAudit creationAudit;

	public String getWalkItemId() {
		return walkItemId;
	}

	public void setWalkItemId(String walkItemId) {
		this.walkItemId = walkItemId;
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

	public String getSOHValue() {
		return SOHValue;
	}

	public void setSOHValue(String sOHValue) {
		SOHValue = sOHValue;
	}

	public String getQtyOnHand() {
		return qtyOnHand;
	}

	public void setQtyOnHand(String qtyOnHand) {
		this.qtyOnHand = qtyOnHand;
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

	public String getPackSize() {
		return packSize;
	}

	public void setPackSize(String packSize) {
		this.packSize = packSize;
	}

	public String getRangeStatus() {
		return rangeStatus;
	}

	public void setRangeStatus(String rangeStatus) {
		this.rangeStatus = rangeStatus;
	}

	public String getStockUom() {
		return stockUom;
	}

	public void setStockUom(String stockUom) {
		this.stockUom = stockUom;
	}

	public Glh_Order getOrder() {
		return order;
	}

	public void setOrder(Glh_Order order) {
		this.order = order;
	}

	public Storewalk_Action getAction() {
		return action;
	}

	public void setAction(Storewalk_Action action) {
		this.action = action;
	}

	public String getPartOfCount() {
		return partOfCount;
	}

	public void setPartOfCount(String partOfCount) {
		this.partOfCount = partOfCount;
	}

	public Storewalk_CommercialHierarchy getCommercialHierarchy() {
		return commercialHierarchy;
	}

	public void setCommercialHierarchy(Storewalk_CommercialHierarchy commercialHierarchy) {
		this.commercialHierarchy = commercialHierarchy;
	}

	public Storewalk_Pack getPack() {
		return pack;
	}

	public void setPack(Storewalk_Pack pack) {
		this.pack = pack;
	}

	public Glh_CountType getCountType() {
		return countType;
	}

	public void setCountType(Glh_CountType countType) {
		this.countType = countType;
	}

	public Glh_Deliverys getDelivery() {
		return delivery;
	}

	public void setDelivery(Glh_Deliverys delivery) {
		this.delivery = delivery;
	}

	public List<Storewalk_Plan> getPlan() {
		return plan;
	}

	public void setPlan(List<Storewalk_Plan> plan) {
		this.plan = plan;
	}

	public Storewalk_CreationAudit getCreationAudit() {
		return creationAudit;
	}

	public void setCreationAudit(Storewalk_CreationAudit creationAudit) {
		this.creationAudit = creationAudit;
	}

	@Override
	public String toString() {
		return "NegPrompt_StorewalkItemPOJO [walkItemId=" + walkItemId + ", productId=" + productId
				+ ", standardUnitOfMeasure=" + standardUnitOfMeasure + ", quantityUnitId=" + quantityUnitId
				+ ", description=" + description + ", SOHValue=" + SOHValue + ", qtyOnHand=" + qtyOnHand
				+ ", qtyInTransit=" + qtyInTransit + ", stockState=" + stockState + ", isDeliveryExpectedDateToday="
				+ isDeliveryExpectedDateToday + ", isReceited=" + isReceited + ", packSize=" + packSize
				+ ", rangeStatus=" + rangeStatus + ", stockUom=" + stockUom + ", order=" + order + ", com.morrisons.common.action=" + action
				+ ", partOfCount=" + partOfCount + ", commercialHierarchy=" + commercialHierarchy + ", pack=" + pack
				+ ", countType=" + countType + ", delivery=" + delivery + ", plan=" + plan + ", creationAudit="
				+ creationAudit + ", getWalkItemId()=" + getWalkItemId() + ", getProductId()=" + getProductId()
				+ ", getStandardUnitOfMeasure()=" + getStandardUnitOfMeasure() + ", getQuantityUnitId()="
				+ getQuantityUnitId() + ", getDescription()=" + getDescription() + ", getSOHValue()=" + getSOHValue()
				+ ", getQtyOnHand()=" + getQtyOnHand() + ", getQtyInTransit()=" + getQtyInTransit()
				+ ", getStockState()=" + getStockState() + ", getIsDeliveryExpectedDateToday()="
				+ getIsDeliveryExpectedDateToday() + ", getIsReceited()=" + getIsReceited() + ", getPackSize()="
				+ getPackSize() + ", getRangeStatus()=" + getRangeStatus() + ", getStockUom()=" + getStockUom()
				+ ", getOrder()=" + getOrder() + ", getAction()=" + getAction() + ", getPartOfCount()="
				+ getPartOfCount() + ", getCommercialHierarchy()=" + getCommercialHierarchy() + ", getPack()="
				+ getPack() + ", getCountType()=" + getCountType() + ", getDelivery()=" + getDelivery() + ", getPlan()="
				+ getPlan() + ", getCreationAudit()=" + getCreationAudit() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
