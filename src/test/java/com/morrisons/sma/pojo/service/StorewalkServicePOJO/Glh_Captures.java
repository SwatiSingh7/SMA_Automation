package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

public class Glh_Captures
{
    private String captureType;

    private String qty;

    private String isACase;

    private Glh_UpdateAudit updateAudit;

    private String captureId;

    private String location;

   // private Glh_CreationAudit creationAudit;

    private String captureStatus;

    private String value;

    private Storewalk_Plan plan;

    public String getCaptureType ()
    {
        return captureType;
    }

    public void setCaptureType (String captureType)
    {
        this.captureType = captureType;
    }

    public String getQty ()
    {
        return qty;
    }

    public void setQty (String qty)
    {
        this.qty = qty;
    }

    public String getIsACase ()
    {
        return isACase;
    }

    public void setIsACase (String isACase)
    {
        this.isACase = isACase;
    }

    public Glh_UpdateAudit getUpdateAudit ()
    {
        return updateAudit;
    }

    public void setUpdateAudit (Glh_UpdateAudit updateAudit)
    {
        this.updateAudit = updateAudit;
    }

    public String getCaptureId ()
    {
        return captureId;
    }

    public void setCaptureId (String captureId)
    {
        this.captureId = captureId;
    }

    public String getLocation ()
    {
        return location;
    }

    public void setLocation (String location)
    {
        this.location = location;
    }

//    public Glh_CreationAudit getCreationAudit ()
//    {
//        return creationAudit;
//    }
//
//    public void setCreationAudit (Glh_CreationAudit creationAudit)
//    {
//        this.creationAudit = creationAudit;
//    }

    public String getCaptureStatus ()
    {
        return captureStatus;
    }

    public void setCaptureStatus (String captureStatus)
    {
        this.captureStatus = captureStatus;
    }

    public String getValue ()
    {
        return value;
    }

    public void setValue (String value)
    {
        this.value = value;
    }

    public Storewalk_Plan getPlan ()
    {
        return plan;
    }

    public void setPlan (Storewalk_Plan plan)
    {
        this.plan = plan;
    }

	@Override
	public String toString() {
		return "Glh_Captures [captureType=" + captureType + ", qty=" + qty + ", isACase=" + isACase + ", updateAudit="
				+ updateAudit + ", captureId=" + captureId + ", location=" + location + ", captureStatus="
				+ captureStatus + ", value=" + value + ", plan=" + plan + "]";
	}

    
}