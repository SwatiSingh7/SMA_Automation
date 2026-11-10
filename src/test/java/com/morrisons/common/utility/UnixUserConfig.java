package com.morrisons.common.utility;

public class UnixUserConfig {
	
	
	private String unixUnm;
	private String unixPswd;
	
	
	
	public String getUnixUsername() {
		return unixUnm;
	}
	public void setUnixUsername(String unixUsername) {
		this.unixUnm = unixUsername;
	}
	public String getUnixPassword() {
		return unixPswd;
	}
	public void setUnixPassword(String unixPassword) {
		this.unixPswd = unixPassword;
	}
	@Override
	public String toString() {
		return "UnixServerConfig [unixUsername=" + unixUnm + ", unixPassword="
				+ unixPswd + "]";
	}

}
