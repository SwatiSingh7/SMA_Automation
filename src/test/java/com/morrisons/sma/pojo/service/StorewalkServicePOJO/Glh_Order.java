package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

public class Glh_Order {
	 private Glh_Ordered ordered;

	    private Glh_Delivery delivery;

	    private Glh_Receipted receipted;

	  
	  

	    public Glh_Ordered getOrdered() {
			return ordered;
		}




		public void setOrdered(Glh_Ordered ordered) {
			this.ordered = ordered;
		}




		public Glh_Delivery getDelivery() {
			return delivery;
		}




		public void setDelivery(Glh_Delivery delivery) {
			this.delivery = delivery;
		}




		public Glh_Receipted getReceipted() {
			return receipted;
		}




		public void setReceipted(Glh_Receipted receipted) {
			this.receipted = receipted;
		}




		@Override
		public String toString() {
			return "Order [ordered=" + ordered + ", delivery=" + delivery + ", receipted=" + receipted + "]";
		}




	



}
