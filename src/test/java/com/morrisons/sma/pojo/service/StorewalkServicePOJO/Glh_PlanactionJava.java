package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

public class Glh_PlanactionJava {
	private String planLocation;

    private String name;

    private String storeWalkSequence;

    private String type;

    private String commercialClass;

    private String fillQty;

    public String getPlanLocation ()
    {
        return planLocation;
    }

    public void setPlanLocation (String planLocation)
    {
        this.planLocation = planLocation;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getStoreWalkSequence ()
    {
        return storeWalkSequence;
    }

    public void setStoreWalkSequence (String storeWalkSequence)
    {
        this.storeWalkSequence = storeWalkSequence;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

   

    public String getCommercialClass() {
		return commercialClass;
	}

	public void setCommercialClass(String commercialClass) {
		this.commercialClass = commercialClass;
	}

	public String getFillQty ()
    {
        return fillQty;
    }

    public void setFillQty (String fillQty)
    {
        this.fillQty = fillQty;
    }

	@Override
	public String toString() {
		return "Plan [planLocation=" + planLocation + ", name=" + name + ", storeWalkSequence=" + storeWalkSequence
				+ ", type=" + type + ", commercialClass=" + commercialClass + ", fillQty=" + fillQty + "]";
	}

  
}
