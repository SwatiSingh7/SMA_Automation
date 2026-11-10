package com.morrisons.sma.pojo.service.PricePrompPOJO;

public class PromoDraftDTO {

	private String eventId;
	private int storeid;
	private String productid;
	private String promochangeid;
	private String effectivedate;
	private String source;
	private int id;
	private boolean processed;
	private String createddate;
	private String modifydate;

	public String getPromochangeid() {
		return promochangeid;
	}

	public void setPromochangeid(String promochangeid) {
		this.promochangeid = promochangeid;
	}

	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	public String getModifydate() {
		return modifydate;
	}

	public void setModifydate(String modifydate) {
		this.modifydate = modifydate;
	}

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
		return "PromoDraftDTO [eventId=" + eventId + ", storeid=" + storeid + ", productid=" + productid
				+ ", promochangeid=" + promochangeid + ", effectivedate=" + effectivedate + ", source=" + source
				+ ", id=" + id + ", processed=" + processed + ", createddate=" + createddate + ", modifydate="
				+ modifydate + "]";
	}

}
