package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

public class CreateStorewalk_PostBody {

	private String type;
	private String responsetype;
	private String reason;

    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getResponsetype() {
		return responsetype;
	}

	public void setResponsetype(String responsetype) {
		this.responsetype = responsetype;
	}
	
	

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "CreateStorewalk_PostBody [type=" + type + ", responsetype=" + responsetype + ", reason=" + reason + "]";
	}

	
}
