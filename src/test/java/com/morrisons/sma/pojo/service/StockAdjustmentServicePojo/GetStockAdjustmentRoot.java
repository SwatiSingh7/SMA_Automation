package com.morrisons.sma.pojo.service.StockAdjustmentServicePojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@JsonPropertyOrder("someSingleValuedField")

public class GetStockAdjustmentRoot {
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	public List<Message> messages;
	public Metadata metadata;

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}

	@Override
	public String toString() {
		return "GetStockAdjustmentRoot [messages=" + messages + ", metadata=" + metadata + "]";
	}

}
