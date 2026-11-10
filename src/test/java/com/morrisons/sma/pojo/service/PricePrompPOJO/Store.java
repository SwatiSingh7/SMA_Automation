package com.morrisons.sma.pojo.service.PricePrompPOJO;

public class Store
{
    private String storeName;

    private String countryCode;

    private String storeType;

    private String storeId;

    public String getStoreName ()
    {
        return storeName;
    }

    public void setStoreName (String storeName)
    {
        this.storeName = storeName;
    }

    public String getCountryCode ()
    {
        return countryCode;
    }

    public void setCountryCode (String countryCode)
    {
        this.countryCode = countryCode;
    }

    public String getStoreType ()
    {
        return storeType;
    }

    public void setStoreType (String storeType)
    {
        this.storeType = storeType;
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
        return "ClassPojo [storeName = "+storeName+", countryCode = "+countryCode+", storeType = "+storeType+", storeId = "+storeId+"]";
    }
}