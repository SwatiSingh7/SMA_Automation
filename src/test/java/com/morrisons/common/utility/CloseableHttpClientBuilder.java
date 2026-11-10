package com.morrisons.common.utility;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class CloseableHttpClientBuilder {
	
	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
	
//	private boolean isBehindProxy=Boolean.parseBoolean(applicationConfig.getProxyConfiguration().isBehindProxy);
//	private String proxyHost=applicationConfig.getProxyConfiguration().proxyHost;
//	private int proxyPort =Integer.parseInt(applicationConfig.getProxyConfiguration().proxyPort);
//
//	private String proxyUser=applicationConfig.getProxyConfiguration().proxyUser;
//	private String proxyPassword=applicationConfig.getProxyConfiguration().proxyPass; 
 
	public CloseableHttpClient build() throws ClientProtocolException, IOException {
		
		CloseableHttpClient httpClient;
	
		return httpClient = HttpClients.createDefault();

	
	}
	
	

	
}
