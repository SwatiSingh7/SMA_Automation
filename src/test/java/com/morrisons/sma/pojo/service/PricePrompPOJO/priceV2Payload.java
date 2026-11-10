package com.morrisons.sma.pojo.service.PricePrompPOJO;

import com.morrisons.sma.pojo.service.ProductServicePOJO.BeersWinesSpirits;
import com.morrisons.sma.pojo.service.ProductServicePOJO.CommercialHierarchy;

public class priceV2Payload {private Store store;

private String priceToBeSet;

private String sellingUnitOfMeasure;

private String itemNumber;

private BeersWinesSpirits beersWinesSpirits;

private CommercialHierarchy commercialHierarchy;

public Store getStore ()
{
    return store;
}

public void setStore (Store store)
{
    this.store = store;
}

public String getPriceToBeSet ()
{
    return priceToBeSet;
}

public void setPriceToBeSet (String priceToBeSet)
{
    this.priceToBeSet = priceToBeSet;
}

public String getSellingUnitOfMeasure ()
{
    return sellingUnitOfMeasure;
}

public void setSellingUnitOfMeasure (String sellingUnitOfMeasure)
{
    this.sellingUnitOfMeasure = sellingUnitOfMeasure;
}

public String getItemNumber ()
{
    return itemNumber;
}

public void setItemNumber (String itemNumber)
{
    this.itemNumber = itemNumber;
}

public BeersWinesSpirits getBeersWinesSpirits ()
{
    return beersWinesSpirits;
}

public void setBeersWinesSpirits (BeersWinesSpirits beersWinesSpirits)
{
    this.beersWinesSpirits = beersWinesSpirits;
}

public CommercialHierarchy getCommercialHierarchy ()
{
    return commercialHierarchy;
}

public void setCommercialHierarchy (CommercialHierarchy commercialHierarchy)
{
    this.commercialHierarchy = commercialHierarchy;
}

@Override
public String toString()
{
    return "ClassPojo [store = "+store+", priceToBeSet = "+priceToBeSet+", sellingUnitOfMeasure = "+sellingUnitOfMeasure+", itemNumber = "+itemNumber+", beersWinesSpirits = "+beersWinesSpirits+", commercialHierarchy = "+commercialHierarchy+"]";
}
}
