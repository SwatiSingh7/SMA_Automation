package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

public class Glh_CountType {
	private String type;
	private String description;

  
	
	
	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
	public String toString() {
		return "CountType [type=" + type + ", description=" + description + "]";
	}

	
	

   
}
