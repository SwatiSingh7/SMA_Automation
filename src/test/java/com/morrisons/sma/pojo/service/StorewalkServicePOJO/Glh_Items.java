package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Glh_Items
{
    private String packSize;

    private String description;

    private String qtyOnHand;

    private String standardUnitOfMeasure;

    private String stockState;

    private Storewalk_CommercialHierarchy commercialHierarchy;

    private String stockUom;

    private String price;

    private String variancePercentage;

    private Storewalk_Action action;
  
    @JsonProperty("plan")
	private List<Storewalk_Plan> plan = new ArrayList<>();
 

    private Glh_Order order;

    private Glh_Deliverys delivery;

    private String productId;

    @JsonProperty("captures")
   	private List<Glh_Captures> captures = new ArrayList<>();
    


    private String partOfCount;

    private String isLargeAdjustment;

    private String isReceited;

    private String adjustmentPrice;

    private Storewalk_Pack pack;

    @JsonProperty("SOHValue")
    private String SOHValue;

    private String quantityUnitId;

    private String sumOfCapture;

    private String variance;

    private String reviewCaptureCount;

private Glh_UpdateAudit updateAudit;
//
 private Storewalk_CreationAudit creationAudit;

    private String rangeStatus;

    private Glh_CountType countType;

    private String qtyInTransit;

    private String isDeliveryExpectedDateToday;

    public String getPackSize ()
    {
        return packSize;
    }

    public void setPackSize (String packSize)
    {
        this.packSize = packSize;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getQtyOnHand ()
    {
        return qtyOnHand;
    }

    public void setQtyOnHand (String qtyOnHand)
    {
        this.qtyOnHand = qtyOnHand;
    }

    public String getStandardUnitOfMeasure ()
    {
        return standardUnitOfMeasure;
    }

    public void setStandardUnitOfMeasure (String standardUnitOfMeasure)
    {
        this.standardUnitOfMeasure = standardUnitOfMeasure;
    }

    public String getStockState ()
    {
        return stockState;
    }

    public void setStockState (String stockState)
    {
        this.stockState = stockState;
    }

    public Storewalk_CommercialHierarchy getCommercialHierarchy ()
    {
        return commercialHierarchy;
    }

    public void setCommercialHierarchy (Storewalk_CommercialHierarchy commercialHierarchy)
    {
        this.commercialHierarchy = commercialHierarchy;
    }

    public String getStockUom ()
    {
        return stockUom;
    }

    public void setStockUom (String stockUom)
    {
        this.stockUom = stockUom;
    }

    public String getPrice ()
    {
        return price;
    }

    public void setPrice (String price)
    {
        this.price = price;
    }

    public String getVariancePercentage ()
    {
        return variancePercentage;
    }

    public void setVariancePercentage (String variancePercentage)
    {
        this.variancePercentage = variancePercentage;
    }

    public Storewalk_Action getAction ()
    {
        return action;
    }

    public void setAction (Storewalk_Action action)
    {
        this.action = action;
    }

   

    public Glh_Order getOrder ()
    {
        return order;
    }

    public void setOrder (Glh_Order order)
    {
        this.order = order;
    }

    public Glh_Deliverys getDelivery ()
    {
        return delivery;
    }

    public void setDelivery (Glh_Deliverys delivery)
    {
        this.delivery = delivery;
    }

    public String getProductId ()
    {
        return productId;
    }

    public void setProductId (String productId)
    {
        this.productId = productId;
    }

   

    public String getPartOfCount ()
    {
        return partOfCount;
    }

    public void setPartOfCount (String partOfCount)
    {
        this.partOfCount = partOfCount;
    }

    public String getIsLargeAdjustment ()
    {
        return isLargeAdjustment;
    }

    public void setIsLargeAdjustment (String isLargeAdjustment)
    {
        this.isLargeAdjustment = isLargeAdjustment;
    }

    public String getIsReceited ()
    {
        return isReceited;
    }

    public void setIsReceited (String isReceited)
    {
        this.isReceited = isReceited;
    }

    public String getAdjustmentPrice ()
    {
        return adjustmentPrice;
    }

    public void setAdjustmentPrice (String adjustmentPrice)
    {
        this.adjustmentPrice = adjustmentPrice;
    }

    public Storewalk_Pack getPack ()
    {
        return pack;
    }

    public void setPack (Storewalk_Pack pack)
    {
        this.pack = pack;
    }

    public String getSOHValue ()
    {
        return SOHValue;
    }

    public void setSOHValue (String SOHValue)
    {
        this.SOHValue = SOHValue;
    }

    public String getQuantityUnitId ()
    {
        return quantityUnitId;
    }

    public void setQuantityUnitId (String quantityUnitId)
    {
        this.quantityUnitId = quantityUnitId;
    }

    public String getSumOfCapture ()
    {
        return sumOfCapture;
    }

    public void setSumOfCapture (String sumOfCapture)
    {
        this.sumOfCapture = sumOfCapture;
    }

    public String getVariance ()
    {
        return variance;
    }

    public void setVariance (String variance)
    {
        this.variance = variance;
    }

    public String getReviewCaptureCount ()
    {
        return reviewCaptureCount;
    }

    public void setReviewCaptureCount (String reviewCaptureCount)
    {
        this.reviewCaptureCount = reviewCaptureCount;
    }

    public Glh_UpdateAudit getUpdateAudit ()
    {
        return updateAudit;
    }

    public void setUpdateAudit (Glh_UpdateAudit updateAudit)
    {
        this.updateAudit = updateAudit;
    }

    public  Storewalk_CreationAudit getCreationAudit ()
    {
        return creationAudit;
    }

    public void setCreationAudit (Storewalk_CreationAudit creationAudit)
    {
        this.creationAudit = creationAudit;
    }

    public String getRangeStatus ()
    {
        return rangeStatus;
    }

    public void setRangeStatus (String rangeStatus)
    {
        this.rangeStatus = rangeStatus;
    }

    public Glh_CountType getCountType ()
    {
        return countType;
    }

    public void setCountType (Glh_CountType countType)
    {
        this.countType = countType;
    }

    public String getQtyInTransit ()
    {
        return qtyInTransit;
    }

    public void setQtyInTransit (String qtyInTransit)
    {
        this.qtyInTransit = qtyInTransit;
    }

    public String getIsDeliveryExpectedDateToday ()
    {
        return isDeliveryExpectedDateToday;
    }

    public void setIsDeliveryExpectedDateToday (String isDeliveryExpectedDateToday)
    {
        this.isDeliveryExpectedDateToday = isDeliveryExpectedDateToday;
    }

	public List<Storewalk_Plan> getPlan() {
		return plan;
	}

	public void setPlan(List<Storewalk_Plan> plan) {
		this.plan = plan;
	}

	public List<Glh_Captures> getCaptures() {
		return captures;
	}

	public void setCaptures(List<Glh_Captures> captures) {
		this.captures = captures;
	}

	@Override
	public String toString() {
		return "Glh_Items [packSize=" + packSize + ", description=" + description + ", qtyOnHand=" + qtyOnHand
				+ ", standardUnitOfMeasure=" + standardUnitOfMeasure + ", stockState=" + stockState
				+ ", commercialHierarchy=" + commercialHierarchy + ", stockUom=" + stockUom + ", price=" + price
				+ ", variancePercentage=" + variancePercentage + ", com.morrisons.common.action=" + action + ", plan=" + plan + ", order="
				+ order + ", delivery=" + delivery + ", productId=" + productId + ", captures=" + captures
				+ ", partOfCount=" + partOfCount + ", isLargeAdjustment=" + isLargeAdjustment + ", isReceited="
				+ isReceited + ", adjustmentPrice=" + adjustmentPrice + ", pack=" + pack + ", SOHValue=" + SOHValue
				+ ", quantityUnitId=" + quantityUnitId + ", sumOfCapture=" + sumOfCapture + ", variance=" + variance
				+ ", reviewCaptureCount=" + reviewCaptureCount + ", updateAudit=" + updateAudit + ", creationAudit="
				+ creationAudit + ", rangeStatus=" + rangeStatus + ", countType=" + countType + ", qtyInTransit="
				+ qtyInTransit + ", isDeliveryExpectedDateToday=" + isDeliveryExpectedDateToday + "]";
	}

	
	

    
}
