package com.morrisons.common.utility;

public class ProxyConfig {

	public String isBehindProxy;
	public String proxyHost;
	public String proxyPort;
	public String proxyUser;
	public String proxyPass;

	public String getIsBehindProxy() {
		return isBehindProxy;
	}

	public void setIsBehindProxy(String isBehindProxy) {
		this.isBehindProxy = isBehindProxy;
	}

	public String getProxyHost() {
		return proxyHost;
	}

	public void setProxyHost(String proxyHost) {
		this.proxyHost = proxyHost;
	}

	public String getProxyPort() {
		return proxyPort;
	}

	public void setProxyPort(String proxyPort) {
		this.proxyPort = proxyPort;
	}

	public String getProxyUser() {
		return proxyUser;
	}

	public void setProxyUser(String proxyUser) {
		this.proxyUser = proxyUser;
	}

	public String getProxyPass() {
		return proxyPass;
	}

	public void setProxyPass(String proxyPass) {
		this.proxyPass = proxyPass;
	}

	@Override
	public String toString() {
		return "ProxyConfig [isBehindProxy=" + isBehindProxy + ", proxyHost=" + proxyHost + ", proxyPort=" + proxyPort
				+ ", proxyUser=" + proxyUser + ", proxyPass=" + proxyPass + "]";
	}

}
