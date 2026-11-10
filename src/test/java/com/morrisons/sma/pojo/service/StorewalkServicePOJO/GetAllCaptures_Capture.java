package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

public class GetAllCaptures_Capture {


	public String productId;
	public String description;
	public String sectionId;
	public String sectionStatus;

	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSectionId() {
		return sectionId;
	}
	public void setSectionId(String sectionId) {
		this.sectionId = sectionId;
	}
	public String getSectionStatus() {
		return sectionStatus;
	}
	public void setSectionStatus(String sectionStatus) {
		this.sectionStatus = sectionStatus;
	}
	@Override
	public String toString() {
		return "GetAllCaptures_Capture [productId=" + productId + ", description=" + description + ", sectionId="
				+ sectionId + ", sectionStatus=" + sectionStatus + "]";
	}


}
