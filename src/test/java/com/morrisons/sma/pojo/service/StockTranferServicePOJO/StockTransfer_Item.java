package com.morrisons.sma.pojo.service.StockTranferServicePOJO;

public class StockTransfer_Item {


	private String productId;
	private int qtyTransferred;
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public int getQtyTransferred() {
		return qtyTransferred;
	}
	public void setQtyTransferred(int qtyTransferred) {
		this.qtyTransferred = qtyTransferred;
	}
	@Override
	public String toString() {
		return "StockTransfer_Item [productId=" + productId + ", qtyTransferred=" + qtyTransferred + "]";
	}




}
