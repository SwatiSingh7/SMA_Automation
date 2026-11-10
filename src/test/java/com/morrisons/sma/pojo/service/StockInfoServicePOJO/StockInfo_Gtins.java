package com.morrisons.sma.pojo.service.StockInfoServicePOJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class StockInfo_Gtins {

	@JsonIgnoreProperties(ignoreUnknown=true)
	    private String id;
	@JsonIgnoreProperties(ignoreUnknown=true)
	    private StockInfo_AdditionalProperties additionalProperties;
	@JsonIgnoreProperties(ignoreUnknown=true)
	    private String type;

	    public String getId ()
	    {
	        return id;
	    }

	    public void setId (String id)
	    {
	        this.id = id;
	    }

	    public StockInfo_AdditionalProperties getAdditionalProperties ()
	    {
	        return additionalProperties;
	    }

	    public void setAdditionalProperties (StockInfo_AdditionalProperties additionalProperties)
	    {
	        this.additionalProperties = additionalProperties;
	    }

	    public String getType ()
	    {
	        return type;
	    }

	    public void setType (String type)
	    {
	        this.type = type;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [id = "+id+", additionalProperties = "+additionalProperties+", type = "+type+"]";
	    }
	
}
