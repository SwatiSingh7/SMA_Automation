package com.morrisons.sma.pojo.service.PricePrompPOJO;

public class PricePO {

	private String MIN;

    private String locationId;

    private String regularPrice;

    private String sellingUnitOfMeasure;

    private String effectiveDate;
    
    private String sellingUEP;

 
    public String getMIN ()
    {
        return MIN;
    }

    public void setMIN (String MIN)
    {
        this.MIN = MIN;
    }

    public String getLocationId ()
    {
        return locationId;
    }

    public void setLocationId (String locationId)
    {
        this.locationId = locationId;
    }

    public String getRegularPrice ()
    {
        return regularPrice;
    }

    public void setRegularPrice (String regularPrice)
    {
        this.regularPrice = regularPrice;
    }

    public String getSellingUnitOfMeasure ()
    {
        return sellingUnitOfMeasure;
    }

    public void setSellingUnitOfMeasure (String sellingUnitOfMeasure)
    {
        this.sellingUnitOfMeasure = sellingUnitOfMeasure;
    }

    public String getEffectiveDate ()
    {
        return effectiveDate;
    }

    public void setEffectiveDate (String effectiveDate)
    {
        this.effectiveDate = effectiveDate;
    }

       
    
	public String getSellingUEP() {
		return sellingUEP;
	}

	public void setSellingUEP(String sellingUEP) {
		this.sellingUEP = sellingUEP;
	}

	@Override
	public String toString() {
		return "Price [MIN=" + MIN + ", locationId=" + locationId + ", regularPrice=" + regularPrice
				+ ", sellingUnitOfMeasure=" + sellingUnitOfMeasure + ", effectiveDate=" + effectiveDate
				+ ", sellingUEP=" + sellingUEP + "]";
	}

	
   

	
    
}
