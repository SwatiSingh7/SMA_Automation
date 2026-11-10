package com.morrisons.sma.pojo.service.MarkdownPOJO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Markdown_Error {
	
	@JsonProperty(required = false)
	public int code;
	@JsonProperty(required = false)
    public String reason;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	@Override
	public String toString() {
		return "Markdown_Error [code=" + code + ", reason=" + reason + "]";
	}
	
	

}
