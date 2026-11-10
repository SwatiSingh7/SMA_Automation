package com.morrisons.sma.pojo.service.StockInfoServicePOJO;

import java.util.List;


public class StockV2Pojo {

	 private String item;

	    private String locationId;

	    private List<StartingPosition> startingPosition = null;
	    private List<StockPosition> stockPosition = null;
		 
	

	    public String getItem ()
	    {
	        return item;
	    }

	    public void setItem (String item)
	    {
	        this.item = item;
	    }

	    public String getLocationId ()
	    {
	        return locationId;
	    }

	    public void setLocationId (String locationId)
	    {
	        this.locationId = locationId;
	    }

	  
		public List<StartingPosition> getStartingPosition() {
			return startingPosition;
		}

		public void setStartingPosition(List<StartingPosition> startingPosition) {
			this.startingPosition = startingPosition;
		}
	

		public List<StockPosition> getStockPosition() {
			return stockPosition;
		}

		public void setStockPosition(List<StockPosition> stockPosition) {
			this.stockPosition = stockPosition;
		}

		@Override
		public String toString() {
			return "StockV2Pojo [item=" + item + ", locationId=" + locationId + ", startingPosition=" + startingPosition
					+ ", stockPosition=" + stockPosition + "]";
		}

		

		
}
