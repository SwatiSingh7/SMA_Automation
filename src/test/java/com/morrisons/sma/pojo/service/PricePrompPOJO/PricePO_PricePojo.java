package com.morrisons.sma.pojo.service.PricePrompPOJO;

public class PricePO_PricePojo {

	 private PricePO price;

	    public PricePO getPrice ()
	    {
	        return price;
	    }

	    public void setPrice (PricePO price)
	    {
	        this.price = price;
	    }

		@Override
		public String toString() {
			return "PricePojo [price=" + price + "]";
		}

		
	    
	    

}
