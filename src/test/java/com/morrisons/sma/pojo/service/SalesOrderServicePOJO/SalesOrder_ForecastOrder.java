package com.morrisons.sma.pojo.service.SalesOrderServicePOJO;

public class SalesOrder_ForecastOrder {

	 public String date;
	    public String originalQuantity;
	    public String requestedQuantity;
	    public String deliveredQuantity;
	    public String finalOrderDate;
	    public String maximumOrderIncrease;
	    public String maximumOrderDecrease;
	    
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getOriginalQuantity() {
			return originalQuantity;
		}
		public void setOriginalQuantity(String originalQuantity) {
			this.originalQuantity = originalQuantity;
		}
		public String getRequestedQuantity() {
			return requestedQuantity;
		}
		public void setRequestedQuantity(String requestedQuantity) {
			this.requestedQuantity = requestedQuantity;
		}
		public String getDeliveredQuantity() {
			return deliveredQuantity;
		}
		public void setDeliveredQuantity(String deliveredQuantity) {
			this.deliveredQuantity = deliveredQuantity;
		}
		public String getFinalOrderDate() {
			return finalOrderDate;
		}
		public void setFinalOrderDate(String finalOrderDate) {
			this.finalOrderDate = finalOrderDate;
		}
		public String getMaximumOrderIncrease() {
			return maximumOrderIncrease;
		}
		public void setMaximumOrderIncrease(String maximumOrderIncrease) {
			this.maximumOrderIncrease = maximumOrderIncrease;
		}
		public String getMaximumOrderDecrease() {
			return maximumOrderDecrease;
		}
		public void setMaximumOrderDecrease(String maximumOrderDecrease) {
			this.maximumOrderDecrease = maximumOrderDecrease;
		}
		@Override
		public String toString() {
			return "SalesOrder_ForecastOrder [date=" + date + ", originalQuantity=" + originalQuantity
					+ ", requestedQuantity=" + requestedQuantity + ", deliveredQuantity=" + deliveredQuantity
					+ ", finalOrderDate=" + finalOrderDate + ", maximumOrderIncrease=" + maximumOrderIncrease
					+ ", maximumOrderDecrease=" + maximumOrderDecrease + "]";
		}

	    
}
