package com.morrisons.common.utility;

public class UnixServerConfig {

	public String unixHost;
	public String unixUsername;
	public String unixPassword;
	
	public String getUnixHost() {
		return unixHost;
	}
	public void setUnixHost(String unixHost) {
		this.unixHost = unixHost;
	}
	public String getUnixUsername() {
		return unixUsername;
	}
	public void setUnixUsername(String unixUsername) {
		this.unixUsername = unixUsername;
	}
	public String getUnixPassword() {
		return unixPassword;
	}
	public void setUnixPassword(String unixPassword) {
		this.unixPassword = unixPassword;
	}
	@Override
	public String toString() {
		return "UnixServerConfig [unixHost=" + unixHost + ", unixUsername=" + unixUsername + ", unixPassword="
				+ unixPassword + "]";
	}
	
	
}
