package com.morrisons.common.utility;

public class WebElementEnv {
	private String env;
	private String baseURI;
	
	public String getEnv() {
		return env;
	}

	public void setEnv(String env) {
		this.env = env;
	}

	public String getBaseURI() {
		return baseURI;
	}

	public void setBaseURI(String baseURI) {
		this.baseURI = baseURI;
	}

	@Override
	public String toString() {
		return "WebElementEnv [env=" + env + ", baseURI=" + baseURI + "]";
	}
}
