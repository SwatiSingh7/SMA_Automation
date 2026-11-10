package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

public class Storewalk_CreationAudit {

    public String when;
    public Storewalk_Who who;
    
	public String getWhen() {
		return when;
	}
	public void setWhen(String when) {
		this.when = when;
	}
	public Storewalk_Who getWho() {
		return who;
	}
	public void setWho(Storewalk_Who who) {
		this.who = who;
	}
	@Override
	public String toString() {
		return "CreateCapture_CreationAudit [when=" + when + ", who=" + who + "]";
	}

    
    
}
