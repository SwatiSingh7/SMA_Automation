package com.morrisons.sma.pojo.service.PricePrompPOJO;

public class StockInputExtract {

	private String RMSExtract;
	private String SMSExtract;
	
	public String getRMSExtract() {
		return RMSExtract;
	}

	public void setRMSExtract(String rMSExtract) {
		RMSExtract = rMSExtract;
	}

	
	
	public String getSMSExtract() {
		return SMSExtract;
	}

	public void setSMSExtract(String sMSExtract) {
		SMSExtract = sMSExtract;
	}

	@Override
	public String toString() {
		return "StockInputExtract [RMSExtract=" + RMSExtract + ", SMSExtract=" + SMSExtract + "]";
	}

	
	
	
}
