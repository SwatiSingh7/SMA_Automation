package com.morrisons.sma.pojo.service.BasketV2ServicePOJO;;

public class BasketV2_ClientInstruction {


	private String type;
	private int templateId;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getTemplateId() {
		return templateId;
	}
	public void setTemplateId(int templateId) {
		this.templateId = templateId;
	}
	@Override
	public String toString() {
		return "BasketV2_ClientInstruction [type=" + type + ", templateId=" + templateId + "]";
	}



}
