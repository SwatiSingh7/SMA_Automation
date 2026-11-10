package com.morrisons.sma.pojo.service.StockAdjustmentServicePojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
public class Item {
	public String total;
	public int locationId;
	public String item;
	public int qty;
	public String reason;
	public Date adjustedAt;
	public String internal;
	public String status;
	public String productStatus;
	public Context context;
	public String user;
	public int reasonCode;
	public String userId;

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getAdjustedAt() {
		return adjustedAt;
	}

	public void setAdjustedAt(Date adjustedAt) {
		this.adjustedAt = adjustedAt;
	}

	public String getInternal() {
		return internal;
	}

	public void setInternal(String internal) {
		this.internal = internal;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(int reasonCode) {
		this.reasonCode = reasonCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Item [total=" + total + ", locationId=" + locationId + ", item=" + item + ", qty=" + qty + ", reason="
				+ reason + ", adjustedAt=" + adjustedAt + ", internal=" + internal + ", status=" + status
				+ ", productStatus=" + productStatus
				+ /* ", context=" + context + */ ",  user=" + user + ", reasonCode=" + reasonCode + ", userId=" + userId
				+ "]";
	}

}
