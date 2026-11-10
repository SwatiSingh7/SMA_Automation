package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

public class Glh_Delivery {
	 private String dateAvailabilityExpected;

	    private String dateDeliveryExpected;

	    public String getDateAvailabilityExpected ()
	    {
	        return dateAvailabilityExpected;
	    }

	    public void setDateAvailabilityExpected (String dateAvailabilityExpected)
	    {
	        this.dateAvailabilityExpected = dateAvailabilityExpected;
	    }

	    public String getDateDeliveryExpected ()
	    {
	        return dateDeliveryExpected;
	    }

	    public void setDateDeliveryExpected (String dateDeliveryExpected)
	    {
	        this.dateDeliveryExpected = dateDeliveryExpected;
	    }

		@Override
		public String toString() {
			return "Delivery [dateAvailabilityExpected=" + dateAvailabilityExpected + ", dateDeliveryExpected="
					+ dateDeliveryExpected + "]";
		}

	    
}
