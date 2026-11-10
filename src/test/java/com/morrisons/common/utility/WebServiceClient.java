package com.morrisons.common.utility;

import java.io.BufferedReader;
import java.io.File;
import java.net.URL;
import java.net.URL;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.Iterator;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;

public class WebServiceClient{
	
	private static CloseableHttpClientBuilder cc = new CloseableHttpClientBuilder();
	
	
	
	
	
	public static HttpResponse getMethodResponse(URI endURI,Map<String,String> headerMap) throws ClientProtocolException, IOException
	{
		HttpClient client = cc.build();
		HttpGet getRequest = new HttpGet(endURI);
		String headerKey="";
		String headerValue="";
		
		Iterator entries = headerMap.entrySet().iterator();
		while (entries.hasNext()) {
		    Map.Entry entry = (Map.Entry) entries.next();
		    headerKey = (String)entry.getKey();
		    headerValue = (String)entry.getValue();
		    System.out.println("Key = " + headerKey + ", Value = " + headerValue);
		    getRequest.addHeader(headerKey, headerValue);
		}

		System.out.println("\n\t-----------------Executing request-----------------\n"+"\n" + getRequest.getRequestLine());

		HttpResponse response = client.execute(getRequest);
		return response;
	}
	
	public static HttpResponse postMethodResponse(URI currentUri,Map<String,String> headerMap,String postPayload) throws ClientProtocolException, IOException
	{
		HttpClient client = cc.build();		
		HttpPost postRequest = new HttpPost(currentUri);
		String headerKey="";
		String headerValue="";
				
		Iterator entries = headerMap.entrySet().iterator();
		while (entries.hasNext()) { 
		    Map.Entry entry = (Map.Entry) entries.next();
		    headerKey = (String)entry.getKey();
		    headerValue = (String)entry.getValue();
		    System.out.println("Key = " + headerKey + ", Value = " + headerValue);
		    postRequest.addHeader(headerKey, headerValue);
		    
		}
		postRequest.setEntity(new StringEntity(postPayload));

		HttpResponse response = client.execute(postRequest);
		
		return response;
	}
	
	
	
public static HttpResponse patchMethodResponse(URI currentUri,Map<String,String> headerMap,String filepath) throws ClientProtocolException, IOException
	{
		
		HttpClient client = cc.build();		
		HttpPatch patchRequest = new HttpPatch(currentUri);
		String headerKey="";
		String headerValue="";
				
		Iterator entries = headerMap.entrySet().iterator();
		while (entries.hasNext()) {
		    Map.Entry entry = (Map.Entry) entries.next();
		    headerKey = (String)entry.getKey();
		    headerValue = (String)entry.getValue();
		    System.out.println("Key = " + headerKey + ", Value = " + headerValue);
		    patchRequest.addHeader(headerKey, headerValue);
		}
		
		FileReader fr = new FileReader(filepath);
		BufferedReader rd = new BufferedReader(fr);
		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
			result.append("\n");
		}
		String jFileresponse = result.toString();

		System.out.println("Result: " + "\n" + jFileresponse);

		patchRequest.setEntity(new StringEntity(filepath));

		HttpResponse response = client.execute(patchRequest);
		
		return response;

	}
	
	
	
	public static HttpResponse patchMethod(String currentUri,Map<String,String> headerMap,String patchPayload) throws ClientProtocolException, IOException
	{
		
	HttpClient client = cc.build();		
		HttpPatch patchRequest = new HttpPatch(currentUri);
		String headerKey="";
		String headerValue="";
				
		Iterator entries = headerMap.entrySet().iterator();
		while (entries.hasNext()) {
		    Map.Entry entry = (Map.Entry) entries.next();
		    headerKey = (String)entry.getKey();
		    headerValue = (String)entry.getValue();
		    System.out.println("Key = " + headerKey + ", Value = " + headerValue);
		    patchRequest.addHeader(headerKey, headerValue);
		}
		
	
		patchRequest.setEntity(new StringEntity(patchPayload));
		HttpResponse response = client.execute(patchRequest);
		
		return response;
		}
	
	public static HttpResponse sendPATCH(String endpoint, Map<String, String> headerMap,String patchPayload) throws IOException {
		HttpClient client = cc.build();		
		    HttpPatch httpPatch = new HttpPatch(endpoint);
		    Iterator entries = headerMap.entrySet().iterator();
			String headerKey="";
			String headerValue="";
			while (entries.hasNext()) {
			    Map.Entry entry = (Map.Entry) entries.next();
			    headerKey = (String)entry.getKey();
			    headerValue = (String)entry.getValue();
			    System.out.println("Key = " + headerKey + ", Value = " + headerValue);
			    httpPatch.setHeader(headerKey, headerValue);
			}
//		    if (null != content) {
//		        HttpEntity httpEntity = new ByteArrayEntity(content.getBytes("UTF-8"));
//		        httpPatch.setHeader("Content-Type", "application/json");
//		        httpPatch.setEntity(httpEntity);
//		    }
		    httpPatch.setEntity(new StringEntity(patchPayload));
			
		    HttpResponse httpResponse = client.execute(httpPatch);
		    return httpResponse;
	}
	
	
	public static HttpResponse putMethodResponse(URI currentUri,Map<String,String> headerMap,String putPayload) throws ClientProtocolException, IOException
	{
		
		HttpClient client = cc.build();		
		HttpPut putRequest = new HttpPut(currentUri);
		String headerKey="";
		String headerValue="";
				
		Iterator entries = headerMap.entrySet().iterator();
		while (entries.hasNext()) {
		    Map.Entry entry = (Map.Entry) entries.next();
		    headerKey = (String)entry.getKey();
		    headerValue = (String)entry.getValue();
		    System.out.println("Key = " + headerKey + ", Value = " + headerValue);
		    putRequest.addHeader(headerKey, headerValue);
		}

		putRequest.setEntity(new StringEntity(putPayload));

		HttpResponse response = client.execute(putRequest);
		
		return response;

	}
	
	public static HttpResponse deleteMethodResponse(URI currentUri,Map<String,String> headerMap,File filepath) throws ClientProtocolException, IOException
	{
		
		HttpClient client = cc.build();		
		HttpDelete deleteRequest = new HttpDelete(currentUri);
		String headerKey="";
		String headerValue="";
				
		Iterator entries = headerMap.entrySet().iterator();
		while (entries.hasNext()) {
		    Map.Entry entry = (Map.Entry) entries.next();
		    headerKey = (String)entry.getKey();
		    headerValue = (String)entry.getValue();
		    System.out.println("Key = " + headerKey + ", Value = " + headerValue);
		    deleteRequest.addHeader(headerKey, headerValue);
		}
		
		FileReader fr = new FileReader(filepath);
		BufferedReader rd = new BufferedReader(fr);
		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
			result.append("\n");
		}
		String jFileresponse = result.toString();

		System.out.println("Result: " + "\n" + jFileresponse);

		//deleteRequest.setEntity(new StringEntity(jFileresponse));

		HttpResponse response = client.execute(deleteRequest);
		
		return response;
	}
	
	public static HttpResponse deleteMethod(URI currentUri,Map<String,String> headerMap) throws ClientProtocolException, IOException
	{
		
		HttpClient client = cc.build();		
		HttpDelete deleteRequest = new HttpDelete(currentUri);
		String headerKey="";
		String headerValue="";
				
		Iterator entries = headerMap.entrySet().iterator();
		while (entries.hasNext()) {
		    Map.Entry entry = (Map.Entry) entries.next();
		    headerKey = (String)entry.getKey();
		    headerValue = (String)entry.getValue();
		    System.out.println("Key = " + headerKey + ", Value = " + headerValue);
		    deleteRequest.addHeader(headerKey, headerValue);
		}
		
		HttpResponse response = client.execute(deleteRequest);
		
		return response;
	}
}