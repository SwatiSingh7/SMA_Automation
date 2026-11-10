package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

import java.util.List;

public class GetCaptures_Root {


	public List<Storewalk_Capture> captures;

	public List<Storewalk_Capture> getCaptures() {
		return captures;
	}

	public void setCaptures(List<Storewalk_Capture> captures) {
		this.captures = captures;
	}

	@Override
	public String toString() {
		return "GetCaptures_Root [captures=" + captures + "]";
	}


}
