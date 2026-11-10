package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

public class Storewalk_Who {

	
    public String empId;
    public String username;
    
	@Override
	public String toString() {
		return "CreateCapture_Who [empId=" + empId + ", username=" + username + "]";
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

    
    
}
