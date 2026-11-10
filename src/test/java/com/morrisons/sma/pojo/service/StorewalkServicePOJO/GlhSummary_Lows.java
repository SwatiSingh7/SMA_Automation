package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

public class GlhSummary_Lows {

	private int incompleteCounts;
	private int stockFound;
	
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
		return "GlhSummary_Lows [incompleteCounts=" + incompleteCounts + ", stockFound=" + stockFound + "]";
	}
	
	
}
