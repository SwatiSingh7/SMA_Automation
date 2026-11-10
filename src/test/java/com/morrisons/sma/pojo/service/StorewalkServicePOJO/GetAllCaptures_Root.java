package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

import java.util.List;

public class GetAllCaptures_Root {

	public List<GetAllCaptures_Capture> captures;

	public List<GetAllCaptures_Capture> getCaptures() {
		return captures;
	}

	public void setCaptures(List<GetAllCaptures_Capture> captures) {
		this.captures = captures;
	}

	@Override
	public String toString() {
		return "GetAllCaptures_Root [captures=" + captures + "]";
	}
	
	
}
