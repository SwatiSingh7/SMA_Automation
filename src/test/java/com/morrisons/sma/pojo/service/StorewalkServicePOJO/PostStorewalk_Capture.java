package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

public class PostStorewalk_Capture {
	 public String productId;
	    public String location;
	    public String captureType;
	    public int qty;
		public String getProductId() {
			return productId;
		}
		public void setProductId(String productId) {
			this.productId = productId;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public String getCaptureType() {
			return captureType;
		}
		public void setCaptureType(String captureType) {
			this.captureType = captureType;
		}
		public int getQty() {
			return qty;
		}
		public void setQty(int qty) {
			this.qty = qty;
		}
		@Override
		public String toString() {
			return "PostStorewalk_Capture [productId=" + productId + ", location=" + location + ", captureType="
					+ captureType + ", qty=" + qty + "]";
		}
	    
	    
}
