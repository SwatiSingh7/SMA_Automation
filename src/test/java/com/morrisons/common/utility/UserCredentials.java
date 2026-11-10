package com.morrisons.common.utility;

public class UserCredentials {
	
	private String collegueUsername;
	private String colleguePassword;
	private String managerUsername;
	private String managerPassword;
	private String twilightManagerUsername;
	private String twilightManagerPassword;
	
	public String getCollegueUsername() {
		return collegueUsername;
	}
	public void setCollegueUsername(String collegueUsername) {
		this.collegueUsername = collegueUsername;
	}
	public String getColleguePassword() {
		return colleguePassword;
	}
	public void setColleguePassword(String colleguePassword) {
		this.colleguePassword = colleguePassword;
	}
	public String getManagerUsername() {
		return managerUsername;
	}
	public void setManagerUsername(String managerUsername) {
		this.managerUsername = managerUsername;
	}
	public String getManagerPassword() {
		return managerPassword;
	}
	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}

	public String getTwilightManagerUsername() {
		return twilightManagerUsername;
	}
	public void setTwilightManagerUsername(String twilightManagerUsername) {
		this.twilightManagerUsername = twilightManagerUsername;
	}
	public String getTwilightManagerPassword() {
		return twilightManagerPassword;
	}
	public void setTwilightManagerPassword(String twilightManagerPassword) {
		this.twilightManagerPassword = twilightManagerPassword;
	}
	@Override
	public String toString() {
		return "UserCredentials [collegueUsername=" + collegueUsername + ", colleguePassword=" + colleguePassword
				+ ", managerUsername=" + managerUsername + ", managerPassword=" + managerPassword
				+ ", twilightManagerUsername=" + twilightManagerUsername + ", twilightManagerPassword="
				+ twilightManagerPassword + "]";
	}

}
