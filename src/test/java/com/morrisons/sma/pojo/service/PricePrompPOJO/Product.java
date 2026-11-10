package com.morrisons.sma.pojo.service.PricePrompPOJO;

public class Product
{
    private String priceEditable;

    private String maximumSellingPrice;

    private String productDescription;

    private String barcode;

    private String multipleEventsAllowed;

    private String minIdentifier;

    private String minimumSellingPrice;

    private String currentSellingPrice;

    private String productName;

    
    private String isPriceOptimisationApplicable;
    private String departmentId;
    private String categoryId;
    private String sellingUnitOfMeasure;
    
    public String getPriceEditable ()
    {
        return priceEditable;
    }

    public void setPriceEditable (String priceEditable)
    {
        this.priceEditable = priceEditable;
    }

    public String getMaximumSellingPrice ()
    {
        return maximumSellingPrice;
    }

    public void setMaximumSellingPrice (String maximumSellingPrice)
    {
        this.maximumSellingPrice = maximumSellingPrice;
    }

    public String getProductDescription ()
    {
        return productDescription;
    }

    public void setProductDescription (String productDescription)
    {
        this.productDescription = productDescription;
    }

    public String getBarcode ()
    {
        return barcode;
    }

    public void setBarcode (String barcode)
    {
        this.barcode = barcode;
    }

    public String getMultipleEventsAllowed ()
    {
        return multipleEventsAllowed;
    }

    public void setMultipleEventsAllowed (String multipleEventsAllowed)
    {
        this.multipleEventsAllowed = multipleEventsAllowed;
    }

    public String getMinIdentifier ()
    {
        return minIdentifier;
    }

    public void setMinIdentifier (String minIdentifier)
    {
        this.minIdentifier = minIdentifier;
    }

    public String getMinimumSellingPrice ()
    {
        return minimumSellingPrice;
    }

    public void setMinimumSellingPrice (String minimumSellingPrice)
    {
        this.minimumSellingPrice = minimumSellingPrice;
    }

    public String getCurrentSellingPrice ()
    {
        return currentSellingPrice;
    }

    public void setCurrentSellingPrice (String currentSellingPrice)
    {
        this.currentSellingPrice = currentSellingPrice;
    }

    public String getProductName ()
    {
        return productName;
    }

    public void setProductName (String productName)
    {
        this.productName = productName;
    }

    
    
    
    public String getIsPriceOptimisationApplicable() {
		return isPriceOptimisationApplicable;
	}

	public void setIsPriceOptimisationApplicable(String isPriceOptimisationApplicable) {
		this.isPriceOptimisationApplicable = isPriceOptimisationApplicable;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getSellingUnitOfMeasure() {
		return sellingUnitOfMeasure;
	}

	public void setSellingUnitOfMeasure(String sellingUnitOfMeasure) {
		this.sellingUnitOfMeasure = sellingUnitOfMeasure;
	}

	@Override
	public String toString() {
		return "Product [priceEditable=" + priceEditable + ", maximumSellingPrice=" + maximumSellingPrice
				+ ", productDescription=" + productDescription + ", barcode=" + barcode + ", multipleEventsAllowed="
				+ multipleEventsAllowed + ", minIdentifier=" + minIdentifier + ", minimumSellingPrice="
				+ minimumSellingPrice + ", currentSellingPrice=" + currentSellingPrice + ", productName=" + productName
				+ ", isPriceOptimisationApplicable=" + isPriceOptimisationApplicable + ", departmentId=" + departmentId
				+ ", categoryId=" + categoryId + ", sellingUnitOfMeasure=" + sellingUnitOfMeasure + "]";
	}

	
}