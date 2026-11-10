package com.morrisons.sma.page_objects.service;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.utils.URIBuilder;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.android.AndroidDriver;
import com.morrisons.sma.pojo.service.BasketV2ServicePOJO.BasketV2_BasketItem;
import com.morrisons.sma.pojo.service.BasketV2ServicePOJO.BasketV2_CalculatedRewards;
import com.morrisons.sma.pojo.service.BasketV2ServicePOJO.BasketV2_ClientInstruction;
import com.morrisons.sma.pojo.service.BasketV2ServicePOJO.BasketV2_Coupon;
import com.morrisons.sma.pojo.service.BasketV2ServicePOJO.BasketV2_Header;
import com.morrisons.sma.pojo.service.BasketV2ServicePOJO.BasketV2_Item;
import com.morrisons.sma.pojo.service.BasketV2ServicePOJO.BasketV2_Items;
import com.morrisons.sma.pojo.service.BasketV2ServicePOJO.BasketV2_QualifyingItems;
import com.morrisons.sma.pojo.service.BasketV2ServicePOJO.BasketV2_Root;
import com.morrisons.sma.pojo.service.BasketV2ServicePOJO.BasketV2_TenderedCoupon;
import com.morrisons.sma.pojo.service.MarkdownPOJO.MarkdownLoginVo;
import com.morrisons.sma.pojo.service.StockTranferServicePOJO.StockTransferPOJO;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.CloseableHttpClientBuilder;
import com.morrisons.common.utility.ConfigLoader;
import com.morrisons.common.utility.WebServiceClient;

public class BasketV2ServicePO {

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

	static String baketV2Body = null;

	static String basketV2_barcode1 = null;
	static int basketV2_qty1 = 0;
	static int basketV2_deptNo1 = 0;
	static String basketV2_desc1 = null;
	static String basketV2_dept1 = null;
	static String basketV2_barcode2 = null;
	static int basketV2_qty2 = 0;
	static int basketV2_deptNo2 = 0;
	static String basketV2_desc2 = null;
	static String basketV2_dept2 = null;
	
	static boolean refundFlag1;

	static String transferId = null;

	private static StockTransferPOJO stockTransferPOJOJsonResp = new StockTransferPOJO();

	public void setData(String barcode1,int qty1,int deptNo1,String desc1,String dept1,String barcode2,int qty2,int deptNo2,String desc2,String dept2,boolean refundFlag){
		basketV2_barcode1 = barcode1;
		basketV2_qty1 = qty1;
		basketV2_deptNo1 = deptNo1;
		basketV2_desc1 = desc1;
		basketV2_dept1 = dept1;
		basketV2_barcode2 = barcode2;
		basketV2_qty2 = qty2;
		basketV2_deptNo2  = deptNo2;
		basketV2_desc2  = desc2;
		basketV2_dept2  = dept2;
		refundFlag1 = refundFlag;
	}
	
	public void setData(String barcode1,int qty1,int deptNo1,String desc1,String dept1,boolean refundFlag){
		basketV2_barcode1 = barcode1;
		basketV2_qty1 = qty1;
		basketV2_deptNo1 = deptNo1;
		basketV2_desc1 = desc1;
		basketV2_dept1 = dept1;
		refundFlag1 = refundFlag;

	}

	///// Post - Basket V2 service
	public void postBasketV2Api(int storeNo)throws URISyntaxException, ClientProtocolException, IOException, InterruptedException {
		
		Date date=java.util.Calendar.getInstance().getTime();  
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	    String currentDate = formatter.format(date);  
	    System.out.println("Date Format with yyyy-MM-dd : "+currentDate); 
	    
	    String checkOutDate = currentDate +"T09:09:46.000Z";
	    
	    
	    Random rnd = new Random();
	    int number = rnd.nextInt(999999);

	    // this will convert any number sequence into 6 character.
	    String no = String.format("%06d", number);
	    long num=Long.parseLong(no);  

		BasketV2_Root basketV2_RootBody = new BasketV2_Root();
		basketV2_RootBody.setDepartmentSales(null);

		BasketV2_Header basketV2_Header = new BasketV2_Header();
		basketV2_Header.setOrganisation("FTO");
		basketV2_Header.setTransactionId(num);
		basketV2_Header.setBasketTotal(8.03);
		basketV2_Header.setCashier("100");
		basketV2_Header.setCheckoutDate(checkOutDate);
		basketV2_Header.setCardNumber(null);
		basketV2_Header.setAccountId("1021550203");
		basketV2_Header.setCountry("GBR");
		basketV2_Header.setCountryDescription("Great Britain");
		basketV2_Header.setCurrency("GBP");
		basketV2_Header.setTraining(false);
		basketV2_Header.setOutputProhibited(false);
		basketV2_Header.setReceiptNumber(num);
		basketV2_Header.setStoreId(storeNo);
		basketV2_Header.setStoreName(null);
		basketV2_Header.setTillNumber(25);
		basketV2_Header.setRefundFlag(refundFlag1);
		
		basketV2_RootBody.setHeader(basketV2_Header);
		
		
		BasketV2_BasketItem basketV2_BasketItem = new BasketV2_BasketItem();
		BasketV2_Items basketV2_Items = new BasketV2_Items();
		
		List<BasketV2_BasketItem> items = new ArrayList<BasketV2_BasketItem>();
		
		basketV2_BasketItem.setBarcode(basketV2_barcode1);
		basketV2_BasketItem.setBarcodeQuantity(1);
		basketV2_BasketItem.setDepartment(basketV2_deptNo1);
		basketV2_BasketItem.setPriceChangeType(null);
		basketV2_BasketItem.setQuantity(basketV2_qty1);
		basketV2_BasketItem.setQuantityType(null);
		basketV2_BasketItem.setStorePrice(1);
		basketV2_BasketItem.setUnitPrice(1);
		basketV2_BasketItem.setDescription(basketV2_desc1);
		basketV2_BasketItem.setDepartmentName(basketV2_dept1);

		items.add(basketV2_BasketItem);
		
		basketV2_Items.setBasketItem(items);
		
		basketV2_RootBody.setItems(basketV2_Items);
		
		BasketV2_TenderedCoupon basketV2_TenderedCoupon = new BasketV2_TenderedCoupon();
		BasketV2_Coupon basketV2_Coupon = new BasketV2_Coupon();
		BasketV2_QualifyingItems basketV2_QualifyingItems = new BasketV2_QualifyingItems();
		BasketV2_Item  basketV2_Item = new BasketV2_Item();
		
		List<BasketV2_Item> item = new ArrayList<BasketV2_Item>();
		
		basketV2_Item.setBarcode(basketV2_barcode1);
		basketV2_Item.setLinkType(null);
		
		item.add(basketV2_Item);
		
		basketV2_QualifyingItems.setItem(item);
		
		
		basketV2_Coupon.setNumber("400191494");
		basketV2_Coupon.setRewardType("COMLEXPROMOTION");
		basketV2_Coupon.setPointsType(null);
		basketV2_Coupon.setRewardAmount(0.15);
		

		List<BasketV2_Coupon> coupon = new ArrayList<BasketV2_Coupon>();
		coupon.add(basketV2_Coupon);
		
		basketV2_TenderedCoupon.setCoupon(coupon);
		

		
		basketV2_RootBody.setTriggeredPromotions(null);
	//	basketV2_RootBody.setTriggeredConflicts(triggeredConflicts);
		
		BasketV2_CalculatedRewards basketV2_CalculatedRewards = new BasketV2_CalculatedRewards();
		List<BasketV2_CalculatedRewards> calculatedRewards = new ArrayList<BasketV2_CalculatedRewards>();
		
		calculatedRewards.add(basketV2_CalculatedRewards);
		
	//	basketV2_RootBody.setErrorResponse( );
		
		
		
		BasketV2_ClientInstruction basketV2_ClientInstruction = new BasketV2_ClientInstruction();
		List<BasketV2_ClientInstruction> clientInstruction = new ArrayList<BasketV2_ClientInstruction>();
		basketV2_ClientInstruction.setType("LoyaltyTemplate");
		basketV2_ClientInstruction.setTemplateId(2);
		clientInstruction.add(basketV2_ClientInstruction);
		basketV2_RootBody.setClientInstruction(clientInstruction);
	
		baketV2Body = objectMapper.writeValueAsString(basketV2_RootBody);
		System.out.println("Payload body is " + baketV2Body);

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getPostBasketV2().getResource();
		String queryParameter = applicationConfig.getPostBasketV2().getQueryParameter();

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);
		uriBuilder.setCustomQuery(queryParameter);
		currentUri = uriBuilder.build();
		System.out.println(currentUri);

	}

	public static Map<String, String> headerForBasketV2() {

		headers.put("Content-Type", "application/json");
		headers.put("Authorization", "Basic cVFyOHpzVFJYdDJBeFVyZDUydlRvZHRReDdoTkFIWTU6VEg0VTZBTWc0c2NLMGV2Rw==");
		System.out.println(headers);
		return headers;
	}

	public static HttpResponse basketV2PostPerformOperation() throws ClientProtocolException, IOException {
		headers = headerForBasketV2();
		System.out.println("URI is \t" + currentUri + "headers are\t" + headers);
		if (currentUri != null)
			Response = WebServiceClient.postMethodResponse(currentUri, headers, baketV2Body);
		else {
			System.out.println("\n URL value is missing.Please send valid URL to perform operation");
		}
		return Response;
	}

	//////Post BasketV2 service response
	public static void postBasketV2ServiceResponse()throws Throwable{

		System.out.println(Response);
		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("Post Stock transfer service response : " + responseCode);

		int responseCodeE = 200;

		assertEquals(responseCode, responseCodeE, " Post Stock transfer service response does not exist. Response code");
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

//		stockTransferPOJOJsonResp = objectMapper.readValue(Response.getEntity().getContent(),  StockTransferPOJO.class);
//		String stockTransferResult = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(stockTransferPOJOJsonResp);
//
//		System.out.println("Post Stock transfer service response:\n" +  stockTransferPOJOJsonResp);
//
//		transferId =  stockTransferPOJOJsonResp.getTransferId();
//		System.out.println("Transfer id : " +  transferId);
	}
}
