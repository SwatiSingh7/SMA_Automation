package com.morrisons.sma.pojo.service.SalesOrderServicePOJO;

public class SalesOrder_CurrentDayOrder {

	 public String date;
	    public String originalQuantity;
	    public String requestedQuantity;
	    public String deliveredQuantity;
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
		@Override
		public String toString() {
			return "SalesOrder_CurrentDayOrder [date=" + date + ", originalQuantity=" + originalQuantity
					+ ", requestedQuantity=" + requestedQuantity + ", deliveredQuantity=" + deliveredQuantity + "]";
		}
	    
	    
}
