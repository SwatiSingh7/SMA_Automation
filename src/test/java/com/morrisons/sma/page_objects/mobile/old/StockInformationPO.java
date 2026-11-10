package com.morrisons.sma.page_objects.mobile.old;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import com.morrisons.common.helper.MobileHelper;
import com.morrisons.sma.step_definitions.mobile.old.StockInformationStepDefUI;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.utils.URIBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.morrisons.common.action.Hook;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import com.morrisons.common.utility.WebServiceClient;

public class StockInformationPO {
	private static AndroidDriver driveR;

	private static WebDriver driver;

	public static String prdt;
	public static String beaerer;
	public static String accessID;
	ObjectMapper objectMapper = new ObjectMapper();
	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
	public static URI currentUri;
	public static Map<String, String> headers = new HashMap<>();
	public static String descPr;
	public static String eanPr;
	public static String basePrice;
	public static String unitPirce;
	public static String facings;
	public static String unitHigh;
	public static String unitDeep;
	public static String fillQty;
	public static String lastDelDate;
	public static String orderedQty;
	public static String delQty;
	public static String nextDelDate;
	public static String nextOrderQty;

	public static String lastOrderQty;
	public static String stockPositionQty;
	public static String startingQty;

	String env = applicationConfig.getWebElementEnviroment().getEnv();

	public static String mDAccessTocken = null;
	
	public static String stockValue = null;

	public StockInformationPO() {
		this.driveR = (AndroidDriver) Hook.getDriver();
	}

	public static MobileDriver getDriver() {

		return driveR;

	}

	public void stockInfo() throws InterruptedException{
		Thread.sleep(1000);
		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id ='"+env+":id/stock_information']")).click();

	}

	public void min(String min) throws InterruptedException{

		prdt = min;
		Thread.sleep(1000);
	}

	public void getPrdtDetails(String desc, String ean) throws InterruptedException{
		if(desc!=null){
			descPr = desc.trim();
		}
		if(ean!=null){
			eanPr = ean.trim();
		}
	}

	public void getPriceDetails(String baseprice, String unitprice) throws InterruptedException{
		System.out.println("baseprice : " + baseprice);

		double price = Double.parseDouble(baseprice);
		//double i = (double) price /100;

		DecimalFormat format = new DecimalFormat("0.00"); 
		String priceee = format.format(price);

		basePrice = "£"+priceee;
		System.out.println("Base price = " + basePrice);
		unitPirce = unitprice;
		System.out.println("unitprice = " + unitPirce);
	}

	public void verifypage() throws InterruptedException{
		Thread.sleep(1000);
		driveR.findElement(By.xpath("//android.widget.TextView[@text ='"+prdt+"']")).isDisplayed();
		System.out.println("Product id displayed = " + prdt);

		String descrUI = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id ='"+env+":id/product_title']")).getText().trim().toUpperCase();
		System.out.println("Product Desc id displayed = " + descrUI);

		String productName = descPr.toUpperCase();

		assertEquals(descrUI, productName,"Product name on UI and service mismatched");

		driveR.findElement(By.xpath("//android.widget.TextView[@text ='"+eanPr+"']")).isDisplayed();
		System.out.println("GTIN id displayed as expected = " + eanPr);
	}	

	public void verifyUIDetailsWithServices()throws InterruptedException{
		Thread.sleep(1000);

		String descrUI = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id ='"+env+":id/product_title']")).getText().trim().toUpperCase();
		System.out.println("Product Desc id displayed = " + descrUI);

		String productName = descPr.toUpperCase();

		assertEquals(descrUI, productName,"Product name on UI and service mismatched");

		String productEan = driveR.findElement(By.xpath("//android.widget.TextView[@text ='"+eanPr+"']")).getText();
		assertEquals(productEan, eanPr, "Product EAN is mismatched");
	}


	public void priceVerify() throws InterruptedException{

		driveR.findElement(By.xpath("//android.widget.TextView[@text ='Price']")).isDisplayed();
		System.out.println("Price is displayed ");

	}



	public void priceDisplayVerify() throws InterruptedException{

		Thread.sleep(1000);
		driveR.findElement(By.xpath("//android.widget.TextView[@text ='"+prdt+"']")).isDisplayed();
		System.out.println("Product id displayed = " + prdt);

		driveR.findElement(By.xpath("//android.widget.TextView[@text ='Price']")).isDisplayed();
		System.out.println("Price is displayed ");
		driveR.findElement(By.xpath("//android.widget.TextView[@text ='Base Price']")).isDisplayed();
		System.out.println("Base Price is displayed ");
		driveR.findElement(By.xpath("//android.widget.TextView[@text ='Unit Price']")).isDisplayed();
		System.out.println("Unit Price is displayed ");

		Thread.sleep(2000);
		String subStringBasePrice = basePrice.substring(0, basePrice.indexOf("."));
	
		
		System.out.println("subsring:   "+subStringBasePrice);
		driveR.findElement(By.xpath("//android.widget.TextView[@text ='"+subStringBasePrice+"' or @text ='"+basePrice+"']")).isDisplayed();
		System.out.println("basePrice displayed = " + subStringBasePrice);
		if(unitPirce!=null){
			System.out.println("unitPirce displayed = " + unitPirce);
			String subStringUnitPrice = null;
			if(unitPirce.contains(".")){
				subStringUnitPrice = unitPirce.substring(0, unitPirce.indexOf("."));
			}
			System.out.println("subsring:   "+subStringUnitPrice);
			//driveR.findElement(By.xpath("//android.widget.TextView[@text ='"+subStringUnitPrice+"' or @text ='"+unitPirce+"' or @resource-id ='"+env+":id/unit_price_text_view]")).isDisplayed();
			driveR.findElement(By.xpath("//android.widget.TextView[@text ='"+subStringUnitPrice+"' or @text ='"+unitPirce+"']")).isDisplayed();
			
		}else{
			System.out.println("Unit Price value is null");
		}
		System.out.println("unitPirce expected = " + unitPirce);

	}

	public void noPromotion() throws InterruptedException{

		driveR.findElement(By.xpath("//android.widget.TextView[@text ='No Promotions']")).isDisplayed();
		System.out.println("Promotion is not displayed ");

	}


	public void priceClick() throws InterruptedException{

		Thread.sleep(4000);
		TouchAction ts = new TouchAction(driveR);
		ts.press(PointOption.point(500, 400)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(500, 850)).release().perform();
		Thread.sleep(1000);	

		driveR.findElement(By.xpath("//android.widget.TextView[@text ='Price' or @text ='PRICE']")).click();

	}

	public void spaceVerify() throws InterruptedException{

		Thread.sleep(4000);
		TouchAction ts = new TouchAction(driveR);
		ts.press(PointOption.point(500, 850)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(500, 500)).release().perform();
		Thread.sleep(1000);	

		driveR.findElement(By.xpath("//android.widget.TextView[@text ='Space']")).isDisplayed();
		System.out.println("Space is displayed ");
		driveR.findElement(By.xpath("//android.widget.TextView[@text ='Planned']")).isDisplayed();
		System.out.println("Planned is displayed ");
		driveR.findElement(By.xpath("//android.widget.TextView[@text ='Promotion']")).isDisplayed();
		System.out.println("Promotion is displayed ");
		driveR.findElement(By.xpath("//android.widget.TextView[@text ='Store Stock Build']")).isDisplayed();
		System.out.println("Store Stock Build is displayed ");

	}

	public void scrollDown()throws InterruptedException{

		Thread.sleep(2000);
		Thread.sleep(2000);
		try {
			TouchAction ts = new TouchAction(driveR);
			ts.press(PointOption.point(350, 1515)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
					.moveTo(PointOption.point(300, 390)).release().perform();
		}
		catch(Exception e){

		}

	}
	public void scrollDown1()throws InterruptedException{

		Thread.sleep(2000);
		TouchAction ts = new TouchAction(driveR);		
		ts.press(PointOption.point(350, 915)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(300, 350)).release().perform();
		Thread.sleep(1000);	

	}

	public void detialsverify() throws Throwable{
		Thread.sleep(1500);
		lastDelDate = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id ='"+env+":id/last_order_text_view']")).getText();
		System.out.println("lastDelDate = " + lastDelDate);
		orderedQty = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id ='"+env+":id/last_qty_text_view']")).getText();
		System.out.println("orderedQty = " + orderedQty);
		delQty = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id ='"+env+":id/picked_qty_text_view']")).getText();
		System.out.println("delQty = " + delQty);
		nextDelDate = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id ='"+env+":id/next_order_text_view']")).getText();
		System.out.println("nextDelDate = " + nextDelDate);
		nextOrderQty = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id ='"+env+":id/next_qty_text_view']")).getText();
		System.out.println("nextOrderQty = " + nextOrderQty);
		lastOrderQty = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id ='"+env+":id/last_qty_text_view']")).getText();
		System.out.println("nextOrderQty = " + nextOrderQty);
		StockInformationStepDefUI.getDetails(lastDelDate, orderedQty, delQty, nextDelDate, nextOrderQty,lastOrderQty);
	}

	public void clickSpace () throws InterruptedException{


		driveR.findElement(By.xpath("//android.widget.TextView[@text ='Space']")).isDisplayed();
		System.out.println("Space is displayed ");
		driveR.findElement(By.xpath("//android.widget.TextView[@text ='Space']")).click();
	}

	public void clickNextPage() throws InterruptedException{
		Thread.sleep(1000);
		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id ='"+env+":id/stock_fill_title']")).isDisplayed();
		facings = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id ='"+env+":id/stock_fill_facings']")).getText();
		unitHigh = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id ='"+env+":id/stock_fill_units_high']")).getText();
		unitDeep = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id ='"+env+":id/stock_fill_units_deep']")).getText();
		fillQty = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id ='"+env+":id/stock_fill_quantity']")).getText();

		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id ='"+env+":id/stock_fill_title']")).click();
	}

	public void insidePageDetails() throws InterruptedException{
		driveR.findElement(By.xpath("//android.widget.TextView[@text ='"+facings+"']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[@text ='"+unitHigh+"']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[@text ='"+unitDeep+"']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[@text ='"+fillQty+"']")).isDisplayed();

	}

	public void selectFromDropDown() throws InterruptedException{

		String mins = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id ='"+env+":id/txtMin']")).getText();
		System.out.println("mims = " + mins);
		System.out.println("prdt = " + prdt);


		//while(!(driveR.findElement(By.xpath("//android.widget.TextView[@text ='"+prdt+"']")).getText().equals(prdt))){
		//while(!(driveR.findElement(By.xpath("//android.widget.TextView[@resource-id ='com.morrisons.instore.uat:id/txtMin']")).getText().matches(prdt))){
		while(!(driveR.findElement(By.xpath("//android.widget.TextView[@resource-id ='"+env+":id/txtMin']")).getText().equals(prdt))){
			String Productt = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id ='"+env+":id/txtMin']")).getText();
			System.out.println("productttt" +Productt);
			Thread.sleep(2000);
			TouchAction ts = new TouchAction(driveR);
			ts.press(PointOption.point(500, 1100)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
			.moveTo(PointOption.point(500, 800)).release().perform();
			Thread.sleep(1000);		
		}	
		driveR.findElement(By.xpath("//android.widget.TextView[@text ='"+prdt+"']")).isDisplayed();
		System.out.println("Product verified !");
	}

	public void stockVerifyDetails() throws InterruptedException{
		Thread.sleep(1000);
		driveR.findElement(By.xpath("//android.widget.TextView[@text ='Updating' or @text ='UPDATING']")).isDisplayed();
		System.out.println("Stock value displayed as Updating ");
	}

	public static void dataFromendpoint (String qty1, String qty2){

		stockPositionQty = qty1+" Single(s)"; 
		System.out.println("stockPositionQty = " + stockPositionQty);
		startingQty = qty2;
	}


	public void stockVerifyDataDetails() throws InterruptedException{

		driveR.findElement(By.xpath("//android.widget.TextView[@text ='"+stockPositionQty+"']")).isDisplayed();
		System.out.println("Stock value displayed as  " + stockPositionQty);
	}

	public void stockVerifyClick() throws InterruptedException{

		driveR.findElement(By.xpath("//android.widget.TextView[@text ='Stock']")).click();

	}

	public void stockVerify() throws InterruptedException{
		driveR.findElement(By.xpath("//android.widget.TextView[@text ='Stock']")).isDisplayed();
		System.out.println("Stock is displayed ");
	}

	public void lastCapture() throws InterruptedException{


		driveR.findElement(By.xpath("//android.widget.TextView[@text ='Last Capture']")).isDisplayed();
		System.out.println("Last Capture (within 3 days) is displayed ");

		driveR.findElement(By.xpath("//android.widget.TextView[@text ='Capture Type']")).isDisplayed();
		System.out.println("Capture Type is displayed ");
		driveR.findElement(By.xpath("//android.widget.TextView[@text ='Date']")).isDisplayed();
		System.out.println("Date is displayed ");
		driveR.findElement(By.xpath("//android.widget.TextView[@text ='User']")).isDisplayed();
		System.out.println("User is displayed ");
	}

	public void deliveriesVerify() throws InterruptedException{

		Thread.sleep(4000); 
		TouchAction ts = new TouchAction(driveR);
//		ts.press(PointOption.point(698,1247));
//		ts.moveTo(PointOption.point(698,500 ));
//		ts.release();
//		ts.perform();
		MobileHelper.scroll(driveR, 500, 1515, 800,800);
		Thread.sleep(1000);


		driveR.findElement(By.xpath("//android.widget.TextView[@text ='Deliveries']")).isDisplayed();
		System.out.println("Deliveries is displayed ");
		driveR.findElement(By.xpath("//android.widget.TextView[@text ='Last Del Date']")).isDisplayed();
		System.out.println("Last Del Date is displayed ");
		driveR.findElement(By.xpath("//android.widget.TextView[@text ='Ordered Qty']")).isDisplayed();
		System.out.println("Ordered Qty is displayed ");
		driveR.findElement(By.xpath("//android.widget.TextView[@text ='Del Qty']")).isDisplayed();
		System.out.println("Del Qty is displayed ");
		driveR.findElement(By.xpath("//android.widget.TextView[@text ='Next Del Date']")).isDisplayed();
		System.out.println("Next Del Date is displayed ");
		driveR.findElement(By.xpath("//android.widget.TextView[@text ='Next Order Qty']")).isDisplayed();
		System.out.println("Next Order  Qty is displayed ");
	}

	public static void getaccessStock(String accessTocken) {
		accessID = accessTocken;
		beaerer = "Bearer "+accessID;
	}

	public void requestProduct() throws InterruptedException{
	}

	public static Map<String, String> getHeaderPrdt() {

		String Header1Key = "Authorization";
		headers.put(Header1Key,"Basic QUd5UVpGVUdEMUNwWTAyOGVHR2FGV2FNcmQ0VkJqVmY6Vzl5Z1lmR0FwaWptUTdBbQ==");

		System.out.println(headers);
		return headers;
	}

	public static Map<String, String> getHeaderPrice() {

		String Header1Key = "Authorization";

		headers.put(Header1Key,"Basic QUd5UVpGVUdEMUNwWTAyOGVHR2FGV2FNcmQ0VkJqVmY6Vzl5Z1lmR0FwaWptUTdBbQ==" );

		System.out.println(headers);
		return headers;
	}

	public static Map<String, String> getHeaderStock() {

		String Header1Key = "Authorization";
		headers.put("Content-Type", "application/json");
		headers.put(Header1Key,"Basic R3hwbnZBdVpKenEwaElaNFpqbmtOV1VLNTFBeGozYlk6QVh2T1pmU0RRSmF5ZWhSWg==" );

		System.out.println(headers);
		return headers;
	}


	public HttpResponse performGetOperation() throws ClientProtocolException, IOException {

		HttpResponse getResponse = null;
		getHeaderPrdt();
		System.out.println("URI is \t" + currentUri + " headers are\t" + headers);
		assertTrue(currentUri != null, "URL value is missing.Please send valid URL to perform GET operation");
		getResponse = WebServiceClient.getMethodResponse(currentUri, headers);
		return getResponse;
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public HttpResponse performOperation() throws ClientProtocolException, IOException {

		HttpResponse getResponse = null;
		String Header1Key = "Authorization";
		headers.put(Header1Key, beaerer);
		System.out.println("URI is \t" + currentUri + " headers are\t" + headers);
		assertTrue(currentUri != null, "URL value is missing.Please send valid URL to perform GET operation");
		getResponse = WebServiceClient.getMethodResponse(currentUri, headers);
		return getResponse;
	}

	public HttpResponse performGetPriceOperation() throws ClientProtocolException, IOException {

		HttpResponse getResponse = null;
		getHeaderPrice();
		System.out.println("URI is \t" + currentUri + " headers are\t" + headers);
		assertTrue(currentUri != null, "URL value is missing.Please send valid URL to perform GET operation");
		getResponse = WebServiceClient.getMethodResponse(currentUri, headers);
		return getResponse;
	}

	public HttpResponse performGetStockOperation() throws ClientProtocolException, IOException {

		HttpResponse getResponse = null;
		headers = getHeaderStock();
		System.out.println("URI is \t" + currentUri + " headers are\t" + headers);
		assertTrue(currentUri != null, "URL value is missing.Please send valid URL to perform GET operation");
		getResponse = WebServiceClient.getMethodResponse(currentUri, headers);
		return getResponse;
	}



	public static URI getPrdtInfo(String min) throws URISyntaxException {

		String baseURI = applicationConfig.getGetProduct().getBaseURI();
		String resource = applicationConfig.getGetProduct().getResource();
		String queryparameter = applicationConfig.getGetProduct().getQueryParameter();
		resource = resource.replaceAll("\\bitemid\\b", min);
		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);
		uriBuilder.setCustomQuery(queryparameter);
		currentUri = uriBuilder.build();
		System.out.println(currentUri);

		return currentUri;

	}

	public static URI getPriceInfo(String Storeid,String min) throws URISyntaxException {

		String baseURI = applicationConfig.getGetPrice().getBaseURI();
		String resource = applicationConfig.getGetPrice().getResource();
		String queryparameter = applicationConfig.getGetPrice().getQueryParameter();
		resource = resource.replaceAll("\\bstoreid\\b", Storeid);
		resource = resource.replaceAll("\\bitemid\\b", min);
		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);
		uriBuilder.setCustomQuery(queryparameter);
		currentUri = uriBuilder.build();
		System.out.println(currentUri);

		return currentUri;

	}


	public static URI getDeliveryInfo(String min,String Storeid) throws URISyntaxException {

		String baseURI = applicationConfig.getGetDelivery().getBaseURI();
		baseURI = baseURI.replaceAll("\\bstoreid\\b", Storeid);
		baseURI = baseURI.replaceAll("\\bitemid\\b", min);
		URIBuilder uriBuilder = new URIBuilder(baseURI);

		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessID;
		return currentUri;

	}

	public static URI getStockInfo(String min,String Storeid) throws URISyntaxException {

		String baseURI = applicationConfig.getStockInfo().getBaseURI();
		baseURI = baseURI.replaceAll("\\bstoreid\\b", Storeid);
		baseURI = baseURI.replaceAll("\\bitemid\\b", min);
		URIBuilder uriBuilder = new URIBuilder(baseURI);

		currentUri = uriBuilder.build();
		System.out.println(currentUri);

		return currentUri;

	}

	public static URI getProductInfo(String min) throws URISyntaxException {

		String baseURI = applicationConfig.getGetProductDetail().getBaseURI();
		String resource = applicationConfig.getGetProductDetail().getResource();
		String queryparameter = applicationConfig.getGetProductDetail().getQueryParameter();
		resource = resource.replaceAll("\\bitemid\\b", min);
		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);
		uriBuilder.setCustomQuery(queryparameter);
		currentUri = uriBuilder.build();
		System.out.println(currentUri);

		return currentUri;

	}

	public void verifySimplePromotion() throws InterruptedException{
		boolean isPromotionType = true;
		boolean isPromotionEndDate = true;
		boolean isPromotionPrice = true;

		try
		{
			WebElement xpathPromotionType = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tv_theme']"));
			isPromotionType = xpathPromotionType.isDisplayed();
			String promotionType = xpathPromotionType.getText();
			assertEquals(isPromotionType, true, "Promotion type is not present");
		}
		catch(Exception e){
			assertEquals(isPromotionType, false, "Promotion type is not displayed");
		}

		try
		{
			WebElement xpathPromotionEndDate = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tv_end_date']"));
			isPromotionEndDate = xpathPromotionEndDate.isDisplayed();
			String promotionEndDate = xpathPromotionEndDate.getText();
			assertEquals(isPromotionEndDate, true, "Promotion end date is not present");
		}
		catch(Exception e){
			assertEquals(isPromotionEndDate, false, "Promotion end date is not displayed");
		}

		try
		{
			WebElement xpathPromotionPrice = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tv_promotional_price']"));
			isPromotionPrice = xpathPromotionPrice.isDisplayed();
			String promotionPrice = xpathPromotionPrice.getText();
			assertEquals(isPromotionPrice, true, "Promotion price is not present");
		}
		catch(Exception e){
			assertEquals(isPromotionEndDate, false, "Promotion price is not displayed");
		}
	}

	public void verifyComplexPromotion() throws InterruptedException{
		boolean isPromotionType = true;
		boolean isPromotionEndDate = true;
		boolean isPromotionPrice = true;

		try
		{
			WebElement xpathPromotionType = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tv_theme']"));
			isPromotionType = xpathPromotionType.isDisplayed();
			String promotionType = xpathPromotionType.getText();
			assertEquals(isPromotionType, true, "Promotion type is not present");
			assertEquals("Complex", promotionType, "Promotion type is mismatched");
		}
		catch(Exception e){
			assertEquals(isPromotionType, false, "Promotion type is not displayed");
		}

		try
		{
			WebElement xpathPromotionEndDate = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tv_end_date']"));
			isPromotionEndDate = xpathPromotionEndDate.isDisplayed();
			String promotionEndDate = xpathPromotionEndDate.getText();
			assertEquals(isPromotionEndDate, true, "Promotion end date is not present");
		}
		catch(Exception e){
			assertEquals(isPromotionEndDate, false, "Promotion end date is not displayed");
		}

		try
		{
			WebElement xpathPromotionPrice = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tv_promotional_price']"));
			isPromotionPrice = xpathPromotionPrice.isDisplayed();
			String promotionPrice = xpathPromotionPrice.getText();
			assertEquals(isPromotionPrice, true, "Promotion price is not present");
		}
		catch(Exception e){
			assertEquals(isPromotionEndDate, false, "Promotion price is not displayed");
		}
	}

	public void verifyMorePoints() throws InterruptedException{
		boolean isPromotionType = true;
		boolean isPromotionEndDate = true;
		boolean isPromotionPrice = true;

		try
		{
			WebElement xpathPromotionType = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tv_theme']"));
			isPromotionType = xpathPromotionType.isDisplayed();
			String promotionType = xpathPromotionType.getText();
			assertEquals(isPromotionType, true, "Promotion type is not present");
			assertEquals("More Points - 50 Points", promotionType, "Promotion type is mismatched");
		}
		catch(Exception e){
			assertEquals(isPromotionType, false, "Promotion type is not displayed");
		}

		try
		{
			WebElement xpathPromotionEndDate = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tv_end_date']"));
			isPromotionEndDate = xpathPromotionEndDate.isDisplayed();
			String promotionEndDate = xpathPromotionEndDate.getText();
			assertEquals(isPromotionEndDate, true, "Promotion end date is not present");
		}
		catch(Exception e){
			assertEquals(isPromotionEndDate, false, "Promotion end date is not displayed");
		}

		try
		{
			WebElement xpathPromotionPrice = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tv_promotional_price']"));
			isPromotionPrice = xpathPromotionPrice.isDisplayed();
			String promotionPrice = xpathPromotionPrice.getText();
			assertEquals(isPromotionPrice, true, "Promotion price is not present");
		}
		catch(Exception e){
			assertEquals(isPromotionEndDate, false, "Promotion price is not displayed");
		}
	}

	public void verifyLastCapture(String captureType) throws Throwable {

		Thread.sleep(5000);
		String stockInfo = driveR
				.findElement(
						By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/capture_type_text_view']"))
				.getText();

		assertEquals(stockInfo, captureType,"Capture type is mismatched");

	}

	public void verifyDateAndUser() throws Throwable {

		Thread.sleep(5000);
		boolean dateColumn = driveR.findElement(
				By.xpath("//android.widget.TextView[@text='Date' or @text ='DATE']")).isDisplayed();

		assertEquals(dateColumn, true,"Date column is not present");

		boolean dateDetails = driveR.findElement(
				By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/date_text_view']")).isDisplayed();

		assertEquals(dateDetails, true,"Date details are not present");

		boolean userColumn = driveR.findElement(
				By.xpath("//android.widget.TextView[@text='User' or @text ='USER']")).isDisplayed();

		assertEquals(userColumn, true,"User column is not present");

		boolean userDetails = driveR.findElement(
				By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/user_text_view']")).isDisplayed();

		assertEquals(userDetails, true,"User details are not present");

	}

	public void verifyCountedColumnDetails(String quantity) throws Throwable {

		Thread.sleep(5000);
		boolean countedColumns = driveR.findElement(
				By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/user_text_view']")).isDisplayed();

		assertEquals(countedColumns, true,"Counted column is not present");

		boolean countedDetails = driveR.findElement(
				By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/qty_text_view']")).isDisplayed();

		assertEquals(countedDetails, true,"Counted Details are not present");

		String countedText = driveR.findElement(
				By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/qty_text_view']")).getText();
        int q = Integer.valueOf(quantity) *2;
		assertEquals(countedText, quantity,"Counted details are mismatched");
	}


	public String getStockValue() throws InterruptedException{
		stockValue = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/stock_on_hand_value']")).getText();
		stockValue = stockValue.replaceAll("[^0-9]", "");
		System.out.println("Stock is displayed : " + stockValue);
		
		return stockValue;
	}
}
