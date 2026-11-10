package com.morrisons.sma.pojo.service.PricePrompPOJO;

public class PriceDraftDTO {
	
	private String eventId;
    private int storeid;
    private String productid;
    private String pricechangeid;
    private String effectivedate;
    private String source;
    private int id;
    private boolean processed;
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public int getStoreid() {
		return storeid;
	}
	public void setStoreid(int storeid) {
		this.storeid = storeid;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getPricechangeid() {
		return pricechangeid;
	}
	public void setPricechangeid(String pricechangeid) {
		this.pricechangeid = pricechangeid;
	}
	public String getEffectivedate() {
		return effectivedate;
	}
	public void setEffectivedate(String effectivedate) {
		this.effectivedate = effectivedate;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isProcessed() {
		return processed;
	}
	public void setProcessed(boolean processed) {
		this.processed = processed;
	}
	@Override
	public String toString() {
		return "PriceDraftDTO [eventId=" + eventId + ", storeid=" + storeid + ", productid=" + productid
				+ ", pricechangeid=" + pricechangeid + ", effectivedate=" + effectivedate + ", source=" + source
				+ ", id=" + id + ", processed=" + processed + "]";
	}

    
}
