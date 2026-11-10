package com.morrisons.sma.page_objects.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.utils.URIBuilder;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.android.AndroidDriver;
import com.morrisons.sma.pojo.service.MarkdownPOJO.MarkdownLoginVo;
import com.morrisons.sma.pojo.service.StockTranferServicePOJO.StockTransferPOJO;
import com.morrisons.sma.pojo.service.StockTranferServicePOJO.StockTransfer_Item;
import com.morrisons.sma.pojo.service.StockTranferServicePOJO.StockTransfer_Root;
import com.morrisons.sma.pojo.service.StockTranferServicePOJO.StockTransfer_Transfer;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.CloseableHttpClientBuilder;
import com.morrisons.common.utility.ConfigLoader;
import com.morrisons.common.utility.WebServiceClient;
import static org.testng.Assert.assertEquals;

public class StockTransferServicePO {

	public static Map<String, String> headers = new HashMap<>();
	static ObjectMapper objectMapper = new ObjectMapper();
	public static HttpResponse Response;
	public static io.restassured.response.Response restResponse;

	private static AndroidDriver driveR;
	static MarkdownLoginVo mDLoginJsonResp = new MarkdownLoginVo();
	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();

	static String accessTocken;
	String tokenaccess;
	String env = applicationConfig.getWebElementEnviroment().getEnv();
	public static String mDAccessTocken;
	static String mdLogin = null;
	public static URI currentUri;
	private static CloseableHttpClientBuilder cc = new CloseableHttpClientBuilder();

	String collegueUsername = applicationConfig.getUserCredentials().getCollegueUsername();
	String colleguePassword = applicationConfig.getUserCredentials().getColleguePassword();
	String managerUsername = applicationConfig.getUserCredentials().getManagerUsername();
	String managerPassword = applicationConfig.getUserCredentials().getManagerPassword();

	static String stockTransferBody = null;

	static String transferDate1 = null;
	static String fromLocation1 = null;
	static String toLocation1 = null;
	static String internal1 = null;
	static String isBatch1 = null;
	static int containerId1 = 0;
	static String productId1 = null;
	static int qtyTransferred1 = 0;

	static String transferId = null;

	private static StockTransferPOJO stockTransferPOJOJsonResp = new StockTransferPOJO();

	public void setData(String fromLocation, String toLocation, String internal,String isBatch,int containerId, String productId, int qtyTransferred){
		
		fromLocation1 = fromLocation;
		toLocation1 = toLocation;
		internal1 = internal;
		isBatch1 = isBatch;
		containerId1 = containerId;
		productId1 = productId;
		qtyTransferred1  = qtyTransferred;

	}

	///// Post - Stock transfer service
	public void postStockTranferApi()throws URISyntaxException, ClientProtocolException, IOException, InterruptedException {

		List<StockTransfer_Transfer> stockTransfer_TransferList = new ArrayList<StockTransfer_Transfer>();
		List<StockTransfer_Item> stockTransfer_ItemList = new ArrayList<StockTransfer_Item>();
		
Date date=java.util.Calendar.getInstance().getTime();  
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	    String currentDate = formatter.format(date);  
	    System.out.println("Date Format with yyyy-MM-dd : "+currentDate); 
	    
	    String transferDate = currentDate +"T07:30:37Z";

		StockTransfer_Root stockTranferBody = new StockTransfer_Root();
		stockTranferBody.setTransferDate(transferDate);
		stockTranferBody.setFromLocation(fromLocation1);
		stockTranferBody.setToLocation(toLocation1);
		stockTranferBody.setInternal(internal1);
		stockTranferBody.setIsBatch(isBatch1);

		StockTransfer_Transfer stockTransfer_Transfer = new StockTransfer_Transfer();
		stockTransfer_Transfer.setContainerId(containerId1);

		stockTransfer_TransferList.add(stockTransfer_Transfer);
		stockTranferBody.setTransfers(stockTransfer_TransferList);

		StockTransfer_Item stockTransfer_Item = new StockTransfer_Item();
		stockTransfer_Item.setProductId(productId1);
		stockTransfer_Item.setQtyTransferred(qtyTransferred1);

		stockTransfer_ItemList.add(stockTransfer_Item);
		stockTransfer_Transfer.setItems(stockTransfer_ItemList);


		stockTransferBody = objectMapper.writeValueAsString(stockTranferBody);
		System.out.println("Payload body is " + stockTransferBody);

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getPostStockTranfer().getResource();
		String queryParameter = applicationConfig.getPostStockTranfer().getQueryParameter();

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);
		uriBuilder.setCustomQuery(queryParameter);
		currentUri = uriBuilder.build();
		System.out.println(currentUri);

	}

	public static Map<String, String> headerForStockTransfer() {

		headers.put("Content-Type", "application/json");
		headers.put("Authorization", "Basic MXJRbE9BZTFQQVdhV0xIbFNoS2ZoaFVuOHJPREg4QUs6Y2ZVN29WQ3hYWUVIUW1WdQ==");
		headers.put("X-Calling-Application", "storePickStockTransferBatch");
		System.out.println(headers);
		return headers;
	}

	public static HttpResponse postServicePerformOperation() throws ClientProtocolException, IOException {
		headers = headerForStockTransfer();
		System.out.println("URI is \t" + currentUri + "headers are\t" + headers);
		if (currentUri != null)
			Response = WebServiceClient.postMethodResponse(currentUri, headers, stockTransferBody);
		else {
			System.out.println("\n URL value is missing.Please send valid URL to perform operation");
		}
		return Response;
	}

	//////Post Stock transfer service response
	public static void postStockTransferServiceResponse()throws Throwable{

		System.out.println(Response);
		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("Post Stock transfer service response : " + responseCode);

		int responseCodeE = 200;

		assertEquals(responseCode, responseCodeE, " Post Stock transfer service response does not exist. Response code");
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		stockTransferPOJOJsonResp = objectMapper.readValue(Response.getEntity().getContent(),  StockTransferPOJO.class);
		String stockTransferResult = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(stockTransferPOJOJsonResp);

		System.out.println("Post Stock transfer service response:\n" +  stockTransferPOJOJsonResp);

		transferId =  stockTransferPOJOJsonResp.getTransferId();
		System.out.println("Transfer id : " +  transferId);
	}

}
