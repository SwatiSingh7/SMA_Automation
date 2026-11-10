package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

import java.util.Arrays;

public class CreateWalkitem_PostBody {

	private String[] productId;
	private String reason;
	private String location;
	private String[] invalidPayload;
	public String[] getProductId() {
		return productId;
	}
	public void setProductId(String[] productId) {
		this.productId = productId;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
	public String[] getInvalidPayload() {
		return invalidPayload;
	}
	public void setInvalidPayload(String[] invalidPayload) {
		this.invalidPayload = invalidPayload;
	}
	@Override
	public String toString() {
		return "CreateWalkitem_PostBody [productId=" + Arrays.toString(productId) + ", reason=" + reason + ", location="
				+ location + ", invalidPayload=" + Arrays.toString(invalidPayload) + "]";
	}

	
}