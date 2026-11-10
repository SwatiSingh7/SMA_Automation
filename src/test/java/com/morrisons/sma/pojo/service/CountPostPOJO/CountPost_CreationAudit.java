package com.morrisons.sma.pojo.service.CountPostPOJO;

public class CountPost_CreationAudit {
	private String when;

    private CountPost_Who who;

    public String getWhen ()
    {
        return when;
    }

    public void setWhen (String when)
    {
        this.when = when;
    }

    public CountPost_Who getWho ()
    {
        return who;
    }

    public void setWho (CountPost_Who who)
    {
        this.who = who;
    }

	@Override
	public String toString() {
		return "CreationAudit [when=" + when + ", who=" + who + "]";
	}

   
}
