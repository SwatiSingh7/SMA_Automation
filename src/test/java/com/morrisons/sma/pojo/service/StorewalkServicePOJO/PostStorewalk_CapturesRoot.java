package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

import java.util.List;

public class PostStorewalk_CapturesRoot {
	public List<PostStorewalk_Capture> captures;

	public List<PostStorewalk_Capture> getCaptures() {
		return captures;
	}

	public void setCaptures(List<PostStorewalk_Capture> captures) {
		this.captures = captures;
	}

	@Override
	public String toString() {
		return "PostStorewalk_CapturesRoot [captures=" + captures + "]";
	}
	
	
}
