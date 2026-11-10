package com.morrisons.sma.page_objects.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.android.AndroidDriver;
import com.morrisons.sma.pojo.service.StockMovementPOJO.Containers;
import com.morrisons.sma.pojo.service.StockMovementPOJO.Items;
import com.morrisons.sma.pojo.service.StockMovementPOJO.Orders;
import com.morrisons.sma.pojo.service.StockMovementPOJO.StockMovementRoot;
import com.morrisons.sma.pojo.service.StockMovementPOJO.StockOrders;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import com.morrisons.common.utility.WebServiceClient;
import static org.testng.Assert.assertEquals;

public class StockMovementServicePO {

	public static Map<String, String> headers = new HashMap<>();
	static ObjectMapper objectMapper = new ObjectMapper();
	public static HttpResponse Response;
	public static io.restassured.response.Response restResponse;

	private static AndroidDriver driveR;
	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();

	static String stockMovementPostBody = null;
	String tokenaccess;
	String env = applicationConfig.getWebElementEnviroment().getEnv();
	public static String mDAccessTocken;
	static String mdLogin = null;
	public static URI currentUri;

	static String stockMovement_asnId = null;
	static String stockMovement_trailerId = null;
	static String stockMovement_itemId = null;
	static String stockMovement_packId = null;
	static String stockMovement_lotNumber = null;
	static String stockMovement_receiptedQuantity = null;
	static String stockMovement_receiptedQuantityType = null;
	static String stockMovement_orderId = null;
	static String stockMovement_orderType = null;
	static String stockMovement_orderedDate = null;
	static String stockMovement_sOorderId = null;
	static String stockMovement_containerId = null;
	static String stockMovement_receiptDate = null;
	static String stockMovement_receiptLocationId = null;
	static String stockMovement_shippedFromLocationId = null;

	static String responseBody = null;

	static HashMap<String, String> responseContent = new LinkedHashMap<String, String>();

	public static Map<String, String> stockMovementHeader() {
		String headerKey = applicationConfig.getStockMovementServiceHeader().getKey();
		String headerValue = applicationConfig.getStockMovementServiceHeader().getValue();
		headers.put(headerKey, headerValue);
		headers.put("Content-Type", "application/json");
		System.out.println("Headers Key and value : " + headers);

		return headers;
	}

	public static HttpResponse stockMovementPostOperation() throws ClientProtocolException, IOException {
		headers = stockMovementHeader();
		System.out.println("URI is \t" + currentUri + "headers are\t" + headers);
		System.out.println("payload details is 2 = " + stockMovementPostBody);
		if (currentUri != null) {
			Response = WebServiceClient.postMethodResponse(currentUri, headers, stockMovementPostBody);
			System.out.println("Post stock movement api response : " + Response);
		} else {
			System.out.println("\n URL value is missing.Please send valid URL to perform operation");
		}
		return Response;
	}

	public static void getPostStockMovementResponse() throws ClientProtocolException, IOException {
		HttpEntity entity = Response.getEntity();

		// Read the contents of an entity and return it as a String.
		responseBody = EntityUtils.toString(entity).replace("}", "").replace("{", "").replace("\"", "");
		System.out.println("Response Body........" + responseBody);

		String[] responseText = responseBody.split(",");

		for (String resp : responseText) {
			String responseBodyKey = resp.split(":")[0].trim();
			System.out.println("Response message api Key : " + responseBodyKey);
			String responseBodyValue = resp.split(":")[1].trim();
			System.out.println("Response message api Value : " + responseBodyValue);

			responseContent.put(responseBodyKey, responseBodyValue);
		}
	}

	public void setData(String receiptLocationId, String shippedLocationId, String itemNo, String packId,
			String lotNumber, String receiptedQuantity, String receiptedQuantityType, String orderId, String orderType,
			String soOrderId, String containerId, String trailerId) {

		//
		// Date date = new Date();
		// Timestamp timestamp2 = new Timestamp(date.getTime());
		//
		Date date = java.util.Calendar.getInstance().getTime();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = formatter.format(date);

		Timestamp timestamp2 = new Timestamp(date.getTime());

		System.out.println("Date Format with yyyy-MM-dd : " + currentDate);

		Calendar cal = Calendar.getInstance();
		Date date1 = cal.getTime();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		String formattedDate = dateFormat.format(date1);
		System.out.println("Current time of the day using Calendar - 24 hour format: " + formattedDate);

		String orderedDate = currentDate + "T"+formattedDate+"0Z";
		String receiptDate = currentDate + "T"+formattedDate+"Z";

		Random rnd = new Random();
		int number = rnd.nextInt(999999);
		// this will convert any number sequence into 6 character.
		String extraDigits = String.format("%08d", number).trim();
		String currentDate1 = currentDate.replace("-", "").trim();
		String currentTime = formattedDate.replace(":", "");
		String asnId = currentDate1 + currentTime + extraDigits; /// for eg: 2021042715402732000001

		stockMovement_asnId = asnId;
		stockMovement_trailerId = trailerId;
		stockMovement_itemId = itemNo;
		stockMovement_packId = packId;
		stockMovement_lotNumber = lotNumber;
		stockMovement_receiptedQuantity = receiptedQuantity;
		stockMovement_receiptedQuantityType = receiptedQuantityType;
		stockMovement_orderId = orderId;
		stockMovement_orderType = orderType;
		stockMovement_orderedDate = orderedDate;
		stockMovement_sOorderId = soOrderId;
		stockMovement_containerId = containerId;
		stockMovement_receiptDate = receiptDate;
		stockMovement_receiptLocationId = receiptLocationId;
		stockMovement_shippedFromLocationId = shippedLocationId;
	}

	public void setAsnIdData() {

		stockMovement_asnId = "";
	}

	public void setTrailerIdData() {

		stockMovement_trailerId = "";
	}

	public void setItemDetailsData() {

		stockMovement_itemId = "";
		stockMovement_packId = "";
		stockMovement_lotNumber = "";
		stockMovement_receiptedQuantity = "";
		stockMovement_receiptedQuantityType = "";

	}

	public void setOrderDetailsData() {

		stockMovement_orderId = "";
		stockMovement_orderType = "";
		stockMovement_orderedDate = "";
	}

	public void setContainerIdData() {

		stockMovement_containerId = "";
	}

	public void setReceiptData() {

		stockMovement_receiptDate = "";
		stockMovement_receiptLocationId = "";
		stockMovement_shippedFromLocationId = "";
	}

	///// Post - Stock Movement Service
	public static URI postStockMovement()
			throws URISyntaxException, ClientProtocolException, IOException, InterruptedException {

		StockMovementRoot stockMovementRoot = new StockMovementRoot();

		// Items POJO
		List<Items> items = new ArrayList<Items>();
		Items item = new Items();
		item.setItemId(stockMovement_itemId);
		item.setPackId(stockMovement_packId);
		item.setLotNumber(stockMovement_lotNumber);
		item.setReceiptedQuantity(stockMovement_receiptedQuantity);
		item.setReceiptedQuantityType(stockMovement_receiptedQuantityType);

		items.add(item);

		// Stock order POJO
		List<StockOrders> stockOrders = new ArrayList<StockOrders>();
		StockOrders stockOrder = new StockOrders();
		stockOrder.setOrderId(stockMovement_sOorderId);

		stockOrders.add(stockOrder);

		// Orders POJO
		List<Orders> orders = new ArrayList<Orders>();
		Orders order = new Orders();
		order.setItems(items);
		order.setOrderId(stockMovement_orderId);
		order.setOrderType(stockMovement_orderType);
		order.setOrderedDate(stockMovement_orderedDate);
		order.setStockOrders(stockOrders);

		orders.add(order);

		// Container POJO
		List<Containers> containers = new ArrayList<Containers>();
		Containers container = new Containers();
		container.setContainerId(stockMovement_containerId);
		containers.add(container);

		container.setOrders(orders);

		stockMovementRoot.setAsnId(stockMovement_asnId);
		stockMovementRoot.setTrailerId(stockMovement_trailerId);
		stockMovementRoot.setContainers(containers);
		stockMovementRoot.setReceiptDate(stockMovement_receiptDate);
		stockMovementRoot.setReceiptLocationId(stockMovement_receiptLocationId);
		stockMovementRoot.setShippedFromLocationId(stockMovement_shippedFromLocationId);

		String stockMovementServiceBody = objectMapper.writeValueAsString(stockMovementRoot);
		System.out.println("Payload body is " + stockMovementServiceBody);

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getPostStockMovement().getResource();
		String queryParameter = applicationConfig.getPostStockMovement().getQueryParameter();

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource + queryParameter);
		uriBuilder.setCustomQuery(queryParameter);
		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		stockMovementPostBody = stockMovementServiceBody;
		return currentUri;
	}

	///// Post Stock Movement service response
	public static void postStockMovementStatus() throws Throwable {

		int expectedResponse = 200;
		System.out.println(Response);
		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("Post Stock Movement service status : " + responseCode);

		assertEquals(responseCode, expectedResponse,
				"Stock movement Post request failed with Status code : " + responseCode);

	}

	///// Post Stock Movement service Bad Request Response
	public static void verifyBadRequestResponse() throws Throwable {

		int expectedResponse = 400;
		System.out.println(Response);
		int responseCode = Response.getStatusLine().getStatusCode();
		System.out.println("Post Stock Movement service status : " + responseCode);

		assertEquals(responseCode, expectedResponse,
				"Stock movement Post request failed with Status code : " + responseCode);

	}

	public static void verifyEmptyAsnIdMessage(String responseMessage) throws Throwable {

		String asnIdStatus = responseContent.get("asnId");

		assertEquals(asnIdStatus, responseMessage, "Incorrect message is returned for empty asn Id");

	}

	public static void verifyEmptyTrailerIdMessage(String responseMessage) throws Throwable {

		String trailerIdStatus = responseContent.get("trailerId");

		assertEquals(trailerIdStatus, responseMessage, "Incorrect message is returned for empty Trailer Id");

	}

	public static void verifyEmptyItemIdMessage(String responseMessage) throws Throwable {

		String itemIdStatus = responseContent.get("containers[0].orders[0].items[0].itemId");

		assertEquals(itemIdStatus, responseMessage, "Incorrect message is returned for empty Item id");

	}

	public static void verifyEmptyPackIdMessage(String responseMessage) throws Throwable {

		String packIdStatus = responseContent.get("containers[0].orders[0].items[0].packId");

		assertEquals(packIdStatus, responseMessage, "Incorrect message is returned for empty Pack id");
	}

	public static void verifyEmptyLotNumberMsg(String responseMessage) throws Throwable {

		String lotNumberStatus = responseContent.get("containers[0].orders[0].items[0].lotNumber");

		assertEquals(lotNumberStatus, responseMessage, "Incorrect message is returned for empty lot number");

	}

	public static void verifyEmptyReceptedQtyMsg(String responseMessage) throws Throwable {

		String receiptedQtyStatus = responseContent.get("containers[0].orders[0].items[0].receiptedQuantity");

		assertEquals(receiptedQtyStatus, responseMessage, "Incorrect message is returned for empty Receipted quantity");

	}

	public static void verifyEmptyReceiptedQtyTypeMsg(String responseMessage) throws Throwable {

		String receiptedQtyTypeStatus = responseContent.get("containers[0].orders[0].items[0].receiptedQuantityType");

		assertEquals(receiptedQtyTypeStatus, responseMessage,
				"Incorrect message is returned for empty Receipted quantity type");

	}

	public static void verifyEmptyOrderIdMsg(String responseMessage) throws Throwable {

		String orderIdStatus = responseContent.get("containers[0].orders[0].orderId");

		assertEquals(orderIdStatus, responseMessage, "Incorrect message is returned for empty Order id");

	}

	public static void verifyEmptyOrderTypeMsg(String responseMessage) throws Throwable {

		String orderTypeStatus = responseContent.get("containers[0].orders[0].orderType");

		assertEquals(orderTypeStatus, responseMessage, "Incorrect message is returned for empty Order type");

	}

	public static void verifyEmptyOrderDateMsg(String responseMessage) throws Throwable {

		String orderDateStatus = responseContent.get("containers[0].orders[0].orderedDate");

		assertEquals(orderDateStatus, responseMessage, "Incorrect message is returned for empty Order date");

	}

	public static void verifyEmptyContainerIdMessage(String responseMessage) throws Throwable {

		String orderIdStatus = responseContent.get("containers[0].containerId");

		assertEquals(orderIdStatus, responseMessage, "Incorrect message is returned for empty Container Id");

	}

	public static void verifyEmptyReceiptDate(String responseMessage) throws Throwable {

		String receiptDateStatus = responseContent.get("receiptDate");

		assertEquals(receiptDateStatus, responseMessage, "Incorrect message is returned for empty Receipt date");

	}

	public static void verifyEmptyReceiptLocationMsg(String responseMessage) throws Throwable {

		String receiptLocationStatus = responseContent.get("receiptLocationId");

		assertEquals(receiptLocationStatus, responseMessage,
				"Incorrect message is returned for empty Receipt location id");

	}

	public static void verifyEmptyShippedLocationMsg(String responseMessage) throws Throwable {

		String shippedLocationStatus = responseContent.get("shippedFromLocationId");

		assertEquals(shippedLocationStatus, responseMessage,
				"Incorrect message is returned for empty Shipped from location id");

	}

}
