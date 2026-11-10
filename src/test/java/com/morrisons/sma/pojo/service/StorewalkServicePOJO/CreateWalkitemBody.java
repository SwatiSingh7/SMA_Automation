package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

public class CreateWalkitemBody {

	private String productId;
	private String location;
	private String invalidPayload;
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
	public String getInvalidPayload() {
		return invalidPayload;
	}
	public void setInvalidPayload(String invalidPayload) {
		this.invalidPayload = invalidPayload;
	}
	@Override
	public String toString() {
		return "CreateWalkitemBody [productId=" + productId + ", location=" + location + ", invalidPayload="
				+ invalidPayload + "]";
	}
	
	
	
	
}
