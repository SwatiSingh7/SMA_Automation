package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

public class Glh_WalkIdDelivery {
	 private String unit;

	    private String qty;

	    public String getUnit ()
	    {
	        return unit;
	    }

	    public void setUnit (String unit)
	    {
	        this.unit = unit;
	    }

	    public String getQty ()
	    {
	        return qty;
	    }

	    public void setQty (String qty)
	    {
	        this.qty = qty;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [unit = "+unit+", qty = "+qty+"]";
	    }
}
