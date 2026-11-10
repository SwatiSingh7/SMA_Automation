package com.morrisons.common.utility;

public class UrlConfig {

	private String URI;
	private String resource;

	public String getURI() {
		return URI;
	}

	public void setURI(String uRI) {
		URI = uRI;
	}
 
	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	@Override
	public String toString() {
		return "WebServiceConfigTry [URI=" + URI + "]";
	}

}