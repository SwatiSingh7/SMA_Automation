package com.morrisons.sma.pojo.service.MarkdownPOJO;

import com.morrisons.sma.pojo.service.PricePrompPOJO.OptimisedPrice;

public class UnprintedMarkdownEvent
{
    private String id;

    private String categoryId;

    private String markedDownPrice;

    private String percentageMarkdown;

    private String markdownCreatedDate;

    private String quantity;

    private String departmentId;

    private String markdownBarcode;
    private String isComplete;
    private String isOptimisedPriceUsed;
    private String optimisedPriceApplicable;
    private String byRecommendedPrice;
    private String markdownSequence;
    private OptimisedPrice optimisedPrice;
    private String priceOverrideUsed;
    private String priceOverrideReason;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getCategoryId ()
    {
        return categoryId;
    }

    public void setCategoryId (String categoryId)
    {
        this.categoryId = categoryId;
    }

    public String getMarkedDownPrice ()
    {
        return markedDownPrice;
    }

    public void setMarkedDownPrice (String markedDownPrice)
    {
        this.markedDownPrice = markedDownPrice;
    }

    public String getPercentageMarkdown ()
    {
        return percentageMarkdown;
    }

    public void setPercentageMarkdown (String percentageMarkdown)
    {
        this.percentageMarkdown = percentageMarkdown;
    }

    public String getMarkdownCreatedDate ()
    {
        return markdownCreatedDate;
    }

    public void setMarkdownCreatedDate (String markdownCreatedDate)
    {
        this.markdownCreatedDate = markdownCreatedDate;
    }

    public String getQuantity ()
    {
        return quantity;
    }

    public void setQuantity (String quantity)
    {
        this.quantity = quantity;
    }

    public String getDepartmentId ()
    {
        return departmentId;
    }

    public void setDepartmentId (String departmentId)
    {
        this.departmentId = departmentId;
    }

    public String getMarkdownBarcode ()
    {
        return markdownBarcode;
    }

    public void setMarkdownBarcode (String markdownBarcode)
    {
        this.markdownBarcode = markdownBarcode;
    }

    
    
    
    
    public String getIsComplete() {
		return isComplete;
	}

	public void setIsComplete(String isComplete) {
		this.isComplete = isComplete;
	}

	public String getIsOptimisedPriceUsed() {
		return isOptimisedPriceUsed;
	}

	public void setIsOptimisedPriceUsed(String isOptimisedPriceUsed) {
		this.isOptimisedPriceUsed = isOptimisedPriceUsed;
	}

	public String getOptimisedPriceApplicable() {
		return optimisedPriceApplicable;
	}

	public void setOptimisedPriceApplicable(String optimisedPriceApplicable) {
		this.optimisedPriceApplicable = optimisedPriceApplicable;
	}

	public String getByRecommendedPrice() {
		return byRecommendedPrice;
	}

	public void setByRecommendedPrice(String byRecommendedPrice) {
		this.byRecommendedPrice = byRecommendedPrice;
	}

	public String getMarkdownSequence() {
		return markdownSequence;
	}

	public void setMarkdownSequence(String markdownSequence) {
		this.markdownSequence = markdownSequence;
	}

	public OptimisedPrice getOptimisedPrice() {
		return optimisedPrice;
	}

	public void setOptimisedPrice(OptimisedPrice optimisedPrice) {
		this.optimisedPrice = optimisedPrice;
	}
	
	public String getPriceOverrideUsed() {
		return priceOverrideUsed;
	}

	public void setPriceOverrideUsed(String priceOverrideUsed) {
		this.priceOverrideUsed = priceOverrideUsed;
	}

	
	public String getPriceOverrideReason() {
		return priceOverrideReason;
	}

	public void setPriceOverrideReason(String priceOverrideReason) {
		this.priceOverrideReason = priceOverrideReason;
	}

	@Override
	public String toString() {
		return "UnprintedMarkdownEvent [id=" + id + ", categoryId=" + categoryId + ", markedDownPrice="
				+ markedDownPrice + ", percentageMarkdown=" + percentageMarkdown + ", markdownCreatedDate="
				+ markdownCreatedDate + ", quantity=" + quantity + ", departmentId=" + departmentId
				+ ", markdownBarcode=" + markdownBarcode + ", isComplete=" + isComplete + ", isOptimisedPriceUsed="
				+ isOptimisedPriceUsed + ", optimisedPriceApplicable=" + optimisedPriceApplicable
				+ ", byRecommendedPrice=" + byRecommendedPrice + ", markdownSequence=" + markdownSequence
				+ ", optimisedPrice=" + optimisedPrice + ", priceOverrideUsed=" + priceOverrideUsed
				+ ", priceOverrideReason=" + priceOverrideReason + "]";
	}


	
	
}