package com.morrisons.sma.pojo.service.StockMovementPOJO;

public class Items {
	private String itemId;
	private String packId;
	private String lotNumber;
	private String receiptedQuantity;
	private String receiptedQuantityType;

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getPackId() {
		return packId;
	}

	public void setPackId(String packId) {
		this.packId = packId;
	}

	public String getLotNumber() {
		return lotNumber;
	}

	public void setLotNumber(String lotNumber) {
		this.lotNumber = lotNumber;
	}

	public String getReceiptedQuantity() {
		return receiptedQuantity;
	}

	public void setReceiptedQuantity(String receiptedQuantity) {
		this.receiptedQuantity = receiptedQuantity;
	}

	public String getReceiptedQuantityType() {
		return receiptedQuantityType;
	}

	public void setReceiptedQuantityType(String receiptedQuantityType) {
		this.receiptedQuantityType = receiptedQuantityType;
	}

	@Override
	public String toString() {
		return "Items [itemId=" + itemId + ", packId=" + packId + ", lotNumber=" + lotNumber + ", receiptedQuantity="
				+ receiptedQuantity + ", receiptedQuantityType=" + receiptedQuantityType + "]";
	}

}
