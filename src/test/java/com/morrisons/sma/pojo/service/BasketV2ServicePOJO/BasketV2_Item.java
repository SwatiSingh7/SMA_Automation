package com.morrisons.sma.pojo.service.BasketV2ServicePOJO;;

public class BasketV2_Item {


	private String barcode;
	private Object linkType;

	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public Object getLinkType() {
		return linkType;
	}
	public void setLinkType(Object linkType) {
		this.linkType = linkType;
	}
	@Override
	public String toString() {
		return "BasketV2_Item [barcode=" + barcode + ", linkType=" + linkType + "]";
	}


}
