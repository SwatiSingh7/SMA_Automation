package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

public class GlhSummary_Gaps {
	private int positiveStock;
	private int incompleteCounts;
	private int stockFound;
	
	public int getPositiveStock() {
		return positiveStock;
	}
	public void setPositiveStock(int positiveStock) {
		this.positiveStock = positiveStock;
	}
	public int getIncompleteCounts() {
		return incompleteCounts;
	}
	public void setIncompleteCounts(int incompleteCounts) {
		this.incompleteCounts = incompleteCounts;
	}
	public int getStockFound() {
		return stockFound;
	}
	public void setStockFound(int stockFound) {
		this.stockFound = stockFound;
	}
	@Override
	public String toString() {
		return "GlhSummary_Gaps [positiveStock=" + positiveStock + ", incompleteCounts=" + incompleteCounts
				+ ", stockFound=" + stockFound + "]";
	}
	
	
}
