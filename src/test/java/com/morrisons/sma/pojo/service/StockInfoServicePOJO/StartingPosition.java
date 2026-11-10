package com.morrisons.sma.pojo.service.StockInfoServicePOJO;

public class StartingPosition
{
    private String lastUpdated;

    private String unitofMeasure;

    private String qty;

    private String type;

    public String getLastUpdated ()
    {
        return lastUpdated;
    }

    public void setLastUpdated (String lastUpdated)
    {
        this.lastUpdated = lastUpdated;
    }

    public String getUnitofMeasure ()
    {
        return unitofMeasure;
    }

    public void setUnitofMeasure (String unitofMeasure)
    {
        this.unitofMeasure = unitofMeasure;
    }

    public String getQty ()
    {
        return qty;
    }

    public void setQty (String qty)
    {
        this.qty = qty;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

	@Override
	public String toString() {
		return "StartingPosition [lastUpdated=" + lastUpdated + ", unitofMeasure=" + unitofMeasure + ", qty=" + qty
				+ ", type=" + type + "]";
	}

   
}
			
	