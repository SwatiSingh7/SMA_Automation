package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Storewalk_GetCaptures {

	 @JsonProperty("captures")
	    private List<Capture> captures = null;
	   
	    @Override
	public String toString() {
		return "Storewalk_GetCaptures [captures=" + captures + "]";
	}

		@JsonProperty("captures")
	    public List<Capture> getCaptures() {
	        return captures;
	    }

	    @JsonProperty("captures")
	    public void setCaptures(List<Capture> captures) {
	        this.captures = captures;
	    }
	    
	  
}
