package com.morrisons.sma.pojo.service.PricePrompPOJO;

public class PriceV2VO {

	private String responseMessage;

    private String min;

    private String responseCode;

    private String minimumSellingPrice;

    private String storeId;

    
    public String getResponseMessage ()
    {
        return responseMessage;
    }

    public void setResponseMessage (String responseMessage)
    {
        this.responseMessage = responseMessage;
    }

    public String getMin ()
    {
        return min;
    }

    public void setMin (String min)
    {
        this.min = min;
    }

    public String getResponseCode ()
    {
        return responseCode;
    }

    public void setResponseCode (String responseCode)
    {
        this.responseCode = responseCode;
    }

    public String getMinimumSellingPrice ()
    {
        return minimumSellingPrice;
    }

    public void setMinimumSellingPrice (String minimumSellingPrice)
    {
        this.minimumSellingPrice = minimumSellingPrice;
    }

    public String getStoreId ()
    {
        return storeId;
    }

    public void setStoreId (String storeId)
    {
        this.storeId = storeId;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [responseMessage = "+responseMessage+", min = "+min+", responseCode = "+responseCode+", minimumSellingPrice = "+minimumSellingPrice+", storeId = "+storeId+"]";
    }
	
}
