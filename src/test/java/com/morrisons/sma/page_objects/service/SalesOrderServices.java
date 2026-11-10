package com.morrisons.sma.page_objects.service;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.utils.URIBuilder;
import org.openqa.selenium.WebElement;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.android.AndroidDriver;
import com.morrisons.sma.page_objects.mobile.old.SalesOrderPO;
import com.morrisons.sma.pojo.service.CleanNRotateServicePOJO.CleanAndRotateLogin;
import com.morrisons.sma.pojo.service.MarkdownPOJO.MarkdownLoginVo;
import com.morrisons.sma.pojo.service.SalesOrderServicePOJO.SalesOrder_AmendOrderItem;
import com.morrisons.sma.pojo.service.SalesOrderServicePOJO.SalesOrder_AmendRoot;
import com.morrisons.sma.pojo.service.SalesOrderServicePOJO.SalesOrder_Category;
import com.morrisons.sma.pojo.service.SalesOrderServicePOJO.SalesOrder_CurrentDayOrder;
import com.morrisons.sma.pojo.service.SalesOrderServicePOJO.SalesOrder_ForecastItem;
import com.morrisons.sma.pojo.service.SalesOrderServicePOJO.SalesOrder_ForecastOrder;
import com.morrisons.sma.pojo.service.SalesOrderServicePOJO.SalesOrder_ForecastProductOrder;
import com.morrisons.sma.pojo.service.SalesOrderServicePOJO.SalesOrder_Item;
import com.morrisons.sma.pojo.service.SalesOrderServicePOJO.SalesOrder_Links;
import com.morrisons.sma.pojo.service.SalesOrderServicePOJO.SalesOrder_LocationCategory;
import com.morrisons.sma.pojo.service.SalesOrderServicePOJO.SalesOrder_Metadata;
import com.morrisons.sma.pojo.service.SalesOrderServicePOJO.SalesOrder_PreviousOrder;
import com.morrisons.sma.pojo.service.SalesOrderServicePOJO.SalesOrder_RootCategories;
import com.morrisons.sma.pojo.service.SalesOrderServicePOJO.SalesOrder_RootItem;
import com.morrisons.sma.pojo.service.SalesOrderServicePOJO.SalesOrder_RootProducts;
import com.morrisons.common.action.Hook;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import com.morrisons.common.utility.MarkdownServiceData;
import com.morrisons.common.utility.WebServiceClient;

public class SalesOrderServices {
	public static Map<String, String> headers = new HashMap<>();
	static ObjectMapper objectMapper = new ObjectMapper();
	static ObjectMapper objectMapper1 = new ObjectMapper();
	public static HttpResponse Response;
	public static io.restassured.response.Response restResponse;


	private static AndroidDriver driveR;
	static String accessTocken;
	public static URI currentUri;
	public static String mDAccessTocken;

	String env = applicationConfig.getWebElementEnviroment().getEnv();

	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
	String collegueUsername = applicationConfig.getUserCredentials().getCollegueUsername();
	String colleguePassword = applicationConfig.getUserCredentials().getColleguePassword();
	String managerUsername = applicationConfig.getUserCredentials().getManagerUsername();
	String managerPassword = applicationConfig.getUserCredentials().getManagerPassword();

	MarkdownLoginVo mDLoginJsonResp = new MarkdownLoginVo();


	static List<String> salesOrderCategoryNameService = new ArrayList<String>();
	static List<String> salesOrderCategoryIdService = new ArrayList<String>();

	public static SalesOrderPO salesOrderPO;

	public static SalesOrder_RootCategories salesOrder_RootCategoriesJsonResp;
	public static SalesOrder_RootProducts salesOrder_RootProductsJsonResp;
	public static SalesOrder_RootItem salesOrder_RootItemJsonResp;
	public static SalesOrder_AmendRoot salesOrder_AmendRootJsonResp;

	public static String locationId = null;
	public static List<String> categoryIds;

	public static String itemNumber = null;
	public static String itemDescription = null;
	public static String locationCategoryProductId= null;
	public static String departmentId = null;
	public static String productPin = null;
	public static String itemListType = null;

	public static String dateForecast = null;
	public static String quantityForecast = null;
	public static boolean isAmendedForecast = false;

	public static String limit = null;
	public static String offset = null;
	public static String count = null;
	public static String totalProductCount = null;

	public static String nextLink = null;
	public static String currentLink = null;
	public static String previousLink = null;

	public static HashMap<String,String> categoriesNameAndId = new HashMap<String,String>();
	public static HashMap<String,String> categoryWithProductCount = new HashMap<String,String>();


	public static String categoryId = null;

	public static String locationIdItemDetail;
	public static String categoryIdItemDetail;

	public static String itemNumber_Item = null;
	public static String itemDescription_Item = null;
	public static String locationCategoryProductId_Item = null;
	public static String departmentId_Item = null;
	public static String productPin_Item = null;
	public static String units_Item = null;

	public static String date_item = null;
	public static String originalQuantity_Item = null;
	public static String requestedQuantity_Item = null;
	public static String deliveredQuantity_Item = null;

	public static String date_ForecastOrders = null;
	public static String originalQuantity_ForecastOrders = null;
	public static String requestedQuantity_ForecastOrders = null;
	public static String deliveredQuantity_ForecastOrders = null;
	public static String finalOrderDate_ForecastOrders = null;
	public static String maximumOrderIncrease_ForecastOrders = null;
	public static String maximumOrderDecrease_ForecastOrders = null;

	public static String date_PreviousOrders = null;
	public static String requestedQuantity_PreviousOrders = null;
	public static String deliveredQuantity_PreviousOrders = null;

	public static String amendOrder_locationId = null;
	public static String amendOrder_categoryId = null;
	public static String amendOrder_locationCategoryId = null;

	public static String amendOrder_itemNumber = null;
	public static String amendOrder_itemDescription = null;
	public static String amendOrder_locationCategoryProductIdd = null;
	public static String amendOrder_departmentId = null;
	public static String amendOrder_productPin = null;
	public static String amendOrder_itemListType = null;

	public static List<String> allOrderList = new LinkedList<String>();
	public static List<String> amendOrderList = new LinkedList<String>();
	public static List<String> nonAmendOrderList = new LinkedList<String>();

	public static HashMap<String,String> categoryIdAndListType = new HashMap<String,String>();
	public static Map<String,String> allOrderNameAndDescription = new LinkedHashMap<String,String>();
	public static Map<String,String> amendOrderNameAndDescription = new LinkedHashMap<String,String>();
	public static Map<String,String> nonamendOrderNameAndDescription = new LinkedHashMap<String,String>();
	public static Map<String,String> orderDeptAndDescription = new LinkedHashMap<String,String>();

	public static HashMap<String,HashMap<String,String>> amendIOrderListService = new HashMap<String,HashMap<String,String>>();
	public static HashMap<String,HashMap<String,String>> nonamendableOrderListService = new HashMap<String,HashMap<String,String>>();
	public static HashMap<String,HashMap<String,String>> forecastOrderDetails = new HashMap<String,HashMap<String,String>>();

	public static HashMap<String,HashMap<String,String>> amendOrders = new HashMap<String,HashMap<String,String>>();
	public static HashMap<String,HashMap<String,String>> nonamendOrders = new HashMap<String,HashMap<String,String>>();

	public static List<String> lastWeekOriginalQty = new ArrayList<String>();
	public static List<String> upcomingOriginalQty = new ArrayList<String>();
	public static WebElement todayOriginalQty = null;

	public static String categoryIdWithNoProducts = null;
	public static String categoryNameWithNoProducts = null;

	public SalesOrderServices() {
		this.driveR = (AndroidDriver) Hook.getDriver();
	}

	public void requestMadeToSMACollegueLogin() throws Throwable{
		CleanAndRotateLogin crLgoin = new CleanAndRotateLogin();
		crLgoin.setUserName(collegueUsername);

		crLgoin.setPassword(colleguePassword);

		crLgoin.setProvider("morrisons");
		String crLoginBody = objectMapper.writeValueAsString(crLgoin);
		System.out.println("Payload body is " + crLoginBody);
		MarkdownServiceData.postLoginForMarkdown(crLoginBody);
		Response = MarkdownServiceData.postOperationForMdLogin();

		Thread.sleep(500);
	}

	public void requestMadeToSMAManagerLogin() throws Throwable{
		CleanAndRotateLogin crLgoin = new CleanAndRotateLogin();
		crLgoin.setUserName(managerUsername);

		crLgoin.setPassword(managerPassword);

		crLgoin.setProvider("morrisons");
		String crLoginBody = objectMapper.writeValueAsString(crLgoin);
		System.out.println("Payload body is " + crLoginBody);
		MarkdownServiceData.postLoginForMarkdown(crLoginBody);
		Response = MarkdownServiceData.postOperationForMdLogin();

		Thread.sleep(500);
	}

	public void serviceShouldReturnSMALogin() throws Throwable{
		int responseCode = Response.getStatusLine().getStatusCode();
		String errorMessage = Response.getStatusLine().getReasonPhrase();
		int responseCodeE = 200;

		System.out.println("PostMan Response Message is - " + errorMessage);
		assertEquals(responseCode, responseCodeE, "Issues observed while generating access token");
		mDLoginJsonResp = objectMapper.readValue(Response.getEntity().getContent(), MarkdownLoginVo.class);
		String ProductJSONresult = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mDLoginJsonResp);
		System.out.println("Markdown Login Response:\n" + ProductJSONresult);
		Thread.sleep(500);
	}

	public String getGeneratedAccessTokenSO() throws Throwable {
		accessTocken = mDLoginJsonResp.getAccessToken();
		System.out.println("Access Tocken is " + accessTocken);

		return accessTocken;
	}

	public static URI getCategoryDepartmentSalesOrder(String storeId)throws URISyntaxException {

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getGetCategoryDepartments().getResource();
		resource = resource.replaceAll("\\bstoreid\\b", storeId);

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;
		return currentUri;
	}

	public static URI getForecastOrderSalesOrder(String storeId,String categoryId,String accessTocken)throws URISyntaxException {

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getGetForecastOrders().getResource();
		resource = resource.replaceAll("\\bstoreid\\b", storeId);
		resource = resource.replaceAll("\\bcategoryId\\b", categoryId);

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;
		return currentUri;
	}

	//Get category id from services by using category name 
	public void iGetCategoryId() throws InterruptedException {

		String categoryName = salesOrderPO.selectedCategoryName;
		categoryId = categoriesNameAndId.get(categoryName);

	}


	/////////////  Get item details - Method one
	public static URI getSalesOrderItemDetails(String storeId,String categoryId,String itemMinValue,String accessTocken)throws URISyntaxException {

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getGetSOItemDetails().getResource();
		resource = resource.replaceAll("\\bstoreid\\b", storeId);
		resource = resource.replaceAll("\\bcategoryId\\b", categoryId);
		resource = resource.replaceAll("\\bitemMinValue\\b", itemMinValue);

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;
		return currentUri;
	}

	/////////////  Get item details - Method two
	public static URI getItemDetailsService(String storeId,String categoryId,String accessTocken)throws URISyntaxException {

		// Get selected products min value
		String itemMinValue = salesOrderPO.selectedProductMin;

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getGetSOItemDetails().getResource();
		resource = resource.replaceAll("\\bstoreid\\b", storeId);
		resource = resource.replaceAll("\\bcategoryId\\b", categoryId);
		resource = resource.replaceAll("\\bitemMinValue\\b", itemMinValue);

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;
		return currentUri;
	}


	/////////////////// Get Amend order

	public static URI getAmendOrder(String storeId,String categoryId,String accessTocken)throws URISyntaxException {

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getGetAmendOrders().getResource();
		resource = resource.replaceAll("\\bstoreid\\b", storeId);
		resource = resource.replaceAll("\\bcategoryId\\b", categoryId);

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;
		return currentUri;
	}

	public static Map<String, String> getHeadersForApp() {
		String Header1Key = "Authorization";

		headers.put(Header1Key, "Bearer " + mDAccessTocken);
		System.out.println("Headers for markdown are - " + headers);
		return headers;
	}

	public static HttpResponse performOperation() throws ClientProtocolException, IOException {
		getHeadersForApp();
		System.out.println("URI is \t" + currentUri + "headers are\t" + headers);
		if (currentUri != null)
			Response = WebServiceClient.getMethodResponse(currentUri, headers);
		else {
			System.out.println("\n URL value is missing.Please send valid URL to perform operation");
		}
		return Response;
	}

	public static void getCategoryDepartmentServices() throws Throwable {
		int responseCode = Response.getStatusLine().getStatusCode();
		String errorMessage = Response.getStatusLine().getReasonPhrase();
		int responseCodeE = 200;
		System.out.println("Error Message is - " + errorMessage);

		////assertEquals(responseCode, responseCodeE, " Category department details does not exist. Response code");

		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		salesOrder_RootCategoriesJsonResp = objectMapper.readValue(Response.getEntity().getContent(), SalesOrder_RootCategories.class);
		String ProductJSONresult1 = objectMapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(salesOrder_RootCategoriesJsonResp);
		System.out.println("Sales order:\n" + ProductJSONresult1);

		System.out.println("Sales order:\n" + salesOrder_RootCategoriesJsonResp);

		List<SalesOrder_Category> allCategories = salesOrder_RootCategoriesJsonResp.getCategory();
		for (SalesOrder_Category category : allCategories) {

			String categoryNameText = category.getCategoryName();
			System.out.println("Get category service response Category name : " + categoryNameText);
			salesOrderCategoryNameService.add(categoryNameText);

			String categoryIdText = category.getCategoryId();
			System.out.println("Get category service response Category id : " + categoryIdText);
			salesOrderCategoryIdService.add(categoryIdText);

			categoriesNameAndId.put(categoryNameText, categoryIdText);
		}

		List<SalesOrder_LocationCategory> allLocationCategories = salesOrder_RootCategoriesJsonResp.getLocationCategories();

		for (SalesOrder_LocationCategory allLocationCategory : allLocationCategories) {

			locationId = allLocationCategory.getLocationId();
			System.out.println("Get category service response Location id : " + locationId);

			List<String> categoryIds = allLocationCategory.getCategoryIds();

		}
	}

	//	public static void verifyUICategoryWithServices() throws Throwable {
	//
	//		Set<String> departmentUI = salesOrderPO.departmentNameUI;
	//
	//		List<String> departmentNameUI = new ArrayList<String>();
	//
	//		for(String s : departmentUI){
	//			departmentNameUI.add(s);
	//		}
	//
	//		int departmentCountUI = departmentNameUI.size();
	//		int departmentCountServices = salesOrderCategoryNameService.size();
	//
	//		if(departmentCountUI == departmentCountServices)
	//		{
	//			//departmentNameUI.containsAll(salesOrderDeptNameService);
	//			assertEquals(departmentNameUI.containsAll(salesOrderCategoryNameService),"Departments list is mismatched on UI and Services");		
	//		}
	//		else
	//		{
	//			assertEquals(departmentCountUI, departmentCountServices,"Departments count is mismatched on UI and Services");		
	//		}
	//	}



	public static void getCategoriesProductList(String storeId) throws Throwable {

		//Looping through category id's

		for(String categoryId : salesOrderCategoryIdService)
		{
			amendOrderNameAndDescription.clear();
			nonamendOrderNameAndDescription.clear();

			System.out.println("Category id : " +categoryId);

			String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
			String resource = applicationConfig.getGetForecastOrders().getResource();
			resource = resource.replaceAll("\\bstoreid\\b", storeId);
			resource = resource.replaceAll("\\bcategoryId\\b", categoryId);

			URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

			currentUri = uriBuilder.build();
			System.out.println(currentUri);
			mDAccessTocken = accessTocken;

			getHeadersForApp();
			System.out.println("URI is \t" + currentUri + "headers are\t" + headers);
			if (currentUri != null)
				Response = WebServiceClient.getMethodResponse(currentUri, headers);
			else {
				System.out.println("\n URL value is missing.Please send valid URL to perform operation");
			}


			int responseCode = Response.getStatusLine().getStatusCode();
			String errorMessage = Response.getStatusLine().getReasonPhrase();
			int responseCodeE = 200;
			System.out.println("Error Message is - " + errorMessage);

			if(responseCode==200)
			{
				assertEquals(responseCode, responseCodeE, " Category department details does not exist. Response code");

				objectMapper.setSerializationInclusion(Include.NON_NULL);
				objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				salesOrder_RootProductsJsonResp = objectMapper.readValue(Response.getEntity().getContent(), SalesOrder_RootProducts.class);
				String ProductJSONresult1 = objectMapper.writerWithDefaultPrettyPrinter()
						.writeValueAsString(salesOrder_RootProductsJsonResp);

				System.out.println("Sales order:\n" + ProductJSONresult1);

				System.out.println("Sales order:\n" + salesOrder_RootProductsJsonResp);

				String locationIdForecast = salesOrder_RootProductsJsonResp.getLocationId();
				System.out.println("Get category service response Location id : " + locationIdForecast);

				String categoryIdForecast = salesOrder_RootProductsJsonResp.getCategoryId();
				System.out.println("Get category service response Category id : " + categoryIdForecast);

				String locationCategoryIdForecast = salesOrder_RootProductsJsonResp.getLocationCategoryId();
				System.out.println("Get category service response Location category id : " + locationCategoryIdForecast);

				List<SalesOrder_ForecastItem> allItems = salesOrder_RootProductsJsonResp.getItems();

				for (SalesOrder_ForecastItem item : allItems) {
					itemNumber = item.getItemNumber();
					System.out.println("Get category service response Item number : " + itemNumber);

					itemDescription = item.getItemDescription();
					System.out.println("Get category service response Item description : " + itemDescription);

					locationCategoryProductId = item.getLocationCategoryProductId();
					System.out.println("Get category service response Location category id : " + locationCategoryProductId);

					departmentId = item.getDepartmentId();
					System.out.println("Get category service response Department id : " + departmentId);

					productPin = item.getProductPin();
					System.out.println("Get category service response Product pin : " + productPin);

					itemListType = item.getItemListType();
					System.out.println("Get category service response Item list type : " + itemListType);



					if(itemListType.equals("AO")){
						amendOrderNameAndDescription.put(itemDescription, itemNumber);
					}
					else{
						if(itemListType.equals("NA")){
							nonamendOrderNameAndDescription.put(itemDescription, itemNumber);
						}
					}


					List<SalesOrder_ForecastProductOrder> forecastOrders = item.getForecastOrders();

					for (SalesOrder_ForecastProductOrder forecastOrder : forecastOrders) {

						dateForecast = forecastOrder.getDate();
						System.out.println("Get category service response forecast date : " + dateForecast);

						quantityForecast = forecastOrder.getQuantity();
						System.out.println("Get category service response forecast quantity : " + quantityForecast);

						isAmendedForecast = forecastOrder.isAmended();
						System.out.println("Get category service response forecast is Amended : " + isAmendedForecast);
					}
					HashMap<String,String> orderDateQuantity = new HashMap<String,String>();
					orderDateQuantity.put(dateForecast, quantityForecast);
					forecastOrderDetails.put(itemNumber, orderDateQuantity);
					orderDateQuantity = null;
				}


				SalesOrder_Metadata metadata = salesOrder_RootProductsJsonResp.getMetadata();

				limit = metadata.getLimit();
				offset = metadata.getOffset();
				count = metadata.getCount();
				totalProductCount = metadata.getTotal();

				categoryWithProductCount.put(categoryId,totalProductCount);

				SalesOrder_Links links = metadata.getLinks();

				nextLink = links.getNext();
				System.out.println("Get category service response forecast Next link : " + nextLink);

				currentLink = links.getCurrent();
				System.out.println("Get category service response forecast Current link : " + currentLink);

				previousLink = links.getPrevious();
				System.out.println("Get category service response forecast Previous link : " + previousLink);
			}
			//			amendIOrderListService.putIfAbsent(categoryId, amendOrderNameAndDescription);
			//			nonamendableOrderListService.putIfAbsent(categoryId, nonamendOrderNameAndDescription);
			//
			//			amendOrderCopyData();

			else{
				categoryIdWithNoProducts = categoryId;

				categoryWithProductCount.put(categoryId,"0");
			}
		}
	}

	//Get all order details for specific department
	public static void getForecastOrderResponse(String storeId,String categoryId) throws Throwable {

		System.out.println("Category id : " +categoryId);

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = applicationConfig.getGetForecastOrders().getResource();
		resource = resource.replaceAll("\\bstoreid\\b", storeId);
		resource = resource.replaceAll("\\bcategoryId\\b", categoryId);

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;

		getHeadersForApp();
		System.out.println("URI is \t" + currentUri + "headers are\t" + headers);
		if (currentUri != null)
			Response = WebServiceClient.getMethodResponse(currentUri, headers);
		else {
			System.out.println("\n URL value is missing.Please send valid URL to perform operation");
		}

		int responseCode = Response.getStatusLine().getStatusCode();
		String errorMessage = Response.getStatusLine().getReasonPhrase();
		int responseCodeE = 200;
		System.out.println("Error Message is - " + errorMessage);

		if(responseCode==200)
		{
			assertEquals(responseCode, responseCodeE, " Category department details does not exist. Response code");

			objectMapper.setSerializationInclusion(Include.NON_NULL);
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			salesOrder_RootProductsJsonResp = objectMapper.readValue(Response.getEntity().getContent(), SalesOrder_RootProducts.class);
			String ProductJSONresult1 = objectMapper.writerWithDefaultPrettyPrinter()
					.writeValueAsString(salesOrder_RootProductsJsonResp);

			System.out.println("Sales order:\n" + ProductJSONresult1);

			System.out.println("Sales order:\n" + salesOrder_RootProductsJsonResp);

			String locationIdForecast = salesOrder_RootProductsJsonResp.getLocationId();
			System.out.println("Get category service response Location id : " + locationIdForecast);

			String categoryIdForecast = salesOrder_RootProductsJsonResp.getCategoryId();
			System.out.println("Get category service response Category id : " + categoryIdForecast);

			String locationCategoryIdForecast = salesOrder_RootProductsJsonResp.getLocationCategoryId();
			System.out.println("Get category service response Location category id : " + locationCategoryIdForecast);

			List<SalesOrder_ForecastItem> allItems = salesOrder_RootProductsJsonResp.getItems();

			for (SalesOrder_ForecastItem item : allItems) {
				itemNumber = item.getItemNumber();
				System.out.println("Get category service response Item number : " + itemNumber);

				itemDescription = item.getItemDescription();
				System.out.println("Get category service response Item description : " + itemDescription);

				locationCategoryProductId = item.getLocationCategoryProductId();
				System.out.println("Get category service response Location category id : " + locationCategoryProductId);

				departmentId = item.getDepartmentId();
				System.out.println("Get category service response Department id : " + departmentId);

				productPin = item.getProductPin();
				System.out.println("Get category service response Product pin : " + productPin);

				itemListType = item.getItemListType();
				System.out.println("Get category service response Item list type : " + itemListType);

				allOrderList.add(itemDescription);
				allOrderNameAndDescription.put(itemDescription, itemNumber);

				orderDeptAndDescription.put(itemDescription, departmentId);

				if(itemListType.equals("AO")){
					amendOrderList.add(itemDescription);
					amendOrderNameAndDescription.put(itemDescription, itemNumber);
				}
				else{
					if(itemListType.equals("NA")){
						nonAmendOrderList.add(itemDescription);
						nonamendOrderNameAndDescription.put(itemDescription, itemNumber);
					}
				}

				List<SalesOrder_ForecastProductOrder> forecastOrders = item.getForecastOrders();

				for (SalesOrder_ForecastProductOrder forecastOrder : forecastOrders) {

					dateForecast = forecastOrder.getDate();
					System.out.println("Get category service response forecast date : " + dateForecast);

					quantityForecast = forecastOrder.getQuantity();
					System.out.println("Get category service response forecast quantity : " + quantityForecast);

					isAmendedForecast = forecastOrder.isAmended();
					System.out.println("Get category service response forecast is Amended : " + isAmendedForecast);
				}
				HashMap<String,String> orderDateQuantity = new HashMap<String,String>();
				orderDateQuantity.put(dateForecast, quantityForecast);
				forecastOrderDetails.put(itemNumber, orderDateQuantity);
				orderDateQuantity = null;
			}


			SalesOrder_Metadata metadata = salesOrder_RootProductsJsonResp.getMetadata();

			limit = metadata.getLimit();
			offset = metadata.getOffset();
			count = metadata.getCount();
			totalProductCount = metadata.getTotal();

			SalesOrder_Links links = metadata.getLinks();

			nextLink = links.getNext();
			System.out.println("Get category service response forecast Next link : " + nextLink);

			currentLink = links.getCurrent();
			System.out.println("Get category service response forecast Current link : " + currentLink);

			previousLink = links.getPrevious();
			System.out.println("Get category service response forecast Previous link : " + previousLink);


		}
	}



	public static void amendOrderCopyData() throws Throwable {
		amendOrders = amendIOrderListService;

		nonamendOrders = amendIOrderListService;

		///	amendOrders.
	}

	public static void getAmendOrdersFromService() throws Throwable {

		for(String categoryId : salesOrderCategoryIdService)
		{

			HashMap<String,String> amendOrderList = amendIOrderListService.get(categoryId);
			System.out.println(amendOrderList);
		}	
	}


	public static void verifyTotalProductsCountOnUIAndServices() throws Throwable {

		List<String> categoriesName = salesOrderPO.categoriesName;
		List<String> totalProductCountUI = salesOrderPO.totalProductsCount;

		int categoriesCountUI = categoriesName.size();
		int categoriesCountService = salesOrderCategoryNameService.size();

		assertEquals(categoriesCountUI, categoriesCountService , "Categories count on UI and Service mismatched");

		HashMap<String,String> categoriesDetailsUI = salesOrderPO.categoriesDetails;
		HashMap<String,String> categoriesDetailsServices = null;

		for (int i = 0; i < categoriesName.size(); i++) {
			categoriesDetailsServices.put(categoriesName.get(i), totalProductCountUI.get(i));
		}

		boolean isCompare = categoriesDetailsUI.equals(categoriesDetailsServices);

		assertEquals(isCompare, true , "Total product count is Mismatched");
	}

	public static void verifyProductCountOnUIAndServices() throws Throwable {

		HashMap<String,String> categoryProductCountService = SalesOrderServices.categoryWithProductCount;///category id with count
		HashMap<String,String> categoryNameAndID = categoriesNameAndId; ////// Category name and id
		HashMap<String,String> categoryDetails  = new HashMap<String,String>();

		int size = categoryProductCountService.size();

		for(int i = 0;i<=size -1;i++){
			String id = categoryProductCountService.keySet().toArray()[i].toString();
			System.out.println("key : " + id);
			String count = categoryProductCountService.get(id);
			System.out.println("Value : " + count);

			String key = null;
			if(categoryNameAndID.containsValue(id)){
				for (Entry<String, String> entry : categoryNameAndID.entrySet()) {
					if (entry.getValue().equals(id)) {
						key = entry.getKey();
						categoryDetails.put(key, count);
					}
				}

			}
		}

		HashMap<String,String> categoryProductCountUI = SalesOrderPO.categoriesDetails;

		boolean isCompare = categoryProductCountUI.equals(categoryDetails);

		assertEquals(isCompare, true , "Product count on UI and services Mismatched");

	}

	public static void verifyCategoriesOnUIAndServices() throws Throwable {
		List<String> categoryService = new ArrayList<String>();
		
		List<String> categoryUI = SalesOrderPO.departmentNameUI;
		
		HashMap<String,String> categoryNameAndID = categoriesNameAndId; ////// Category name and id
		for (Entry<String, String> entry : categoryNameAndID.entrySet()) {
			String categoryNameService = entry.getKey();

			categoryService.add(categoryNameService);
		}

		boolean isCompare = categoryUI.equals(categoryService);

		assertEquals(isCompare, true , "Categories on UI and services Mismatched");

	}

	public static void getItemDetailsServices() throws Throwable {
		int responseCode = Response.getStatusLine().getStatusCode();
		String errorMessage = Response.getStatusLine().getReasonPhrase();
		int responseCodeE = 200;
		System.out.println("Error Message is - " + errorMessage);

		assertEquals(responseCode, responseCodeE, " Item details does not exist. Response code");

		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		salesOrder_RootItemJsonResp = objectMapper.readValue(Response.getEntity().getContent(), SalesOrder_RootItem.class);
		String ProductJSONresult1 = objectMapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(salesOrder_RootItemJsonResp);
		System.out.println("Sales order item details :\n" + ProductJSONresult1);

		System.out.println("Sales order item details:\n" + salesOrder_RootItemJsonResp);

		locationIdItemDetail = salesOrder_RootItemJsonResp.getLocationId();
		categoryIdItemDetail = salesOrder_RootItemJsonResp.getCategoryId();

		//Item Details
		List<SalesOrder_Item> itemDetails = salesOrder_RootItemJsonResp.getItems();
		for (SalesOrder_Item itemDetail : itemDetails) {

			itemNumber_Item = itemDetail.getItemNumber();
			System.out.println("Get item details service response for Item detail : " + itemNumber_Item);

			itemDescription_Item = itemDetail.getItemDescription();
			System.out.println("Get item details service response for Item description : " + itemDescription_Item);

			locationCategoryProductId_Item = itemDetail.getLocationCategoryProductId();
			System.out.println("Get item details service response for Location category product id : " + locationCategoryProductId_Item);

			departmentId_Item = itemDetail.getDepartmentId();
			System.out.println("Get item details service response Department for id : " + departmentId_Item);

			productPin_Item = itemDetail.getProductPin();
			System.out.println("Get item details service response Product for pin : " + productPin_Item);

			units_Item = itemDetail.getUnits();
			System.out.println("Get item details service response for Units : " + units_Item);

			SalesOrder_CurrentDayOrder currentDayOrderDetail = itemDetail.getCurrentDayOrder();

			date_item = currentDayOrderDetail.getDate();
			System.out.println("Get item details service response for Date : " + date_item);

			originalQuantity_Item = currentDayOrderDetail.getOriginalQuantity();
			System.out.println("Get item details service response for Original quantity : " + originalQuantity_Item);

			requestedQuantity_Item = currentDayOrderDetail.getRequestedQuantity();
			System.out.println("Get item details service response for Requested quantity : " + requestedQuantity_Item);

			deliveredQuantity_Item = currentDayOrderDetail.getDeliveredQuantity();
			System.out.println("Get item details service response for Delivered quantity : " + deliveredQuantity_Item);


			//Forecast order details
			List<SalesOrder_ForecastOrder> forecastOrderDetails = itemDetail.getForecastOrders();
			for (SalesOrder_ForecastOrder forecastOrderDetail : forecastOrderDetails) {

				date_ForecastOrders = forecastOrderDetail.getDate();
				System.out.println("Get item details service response for Forecast order Date : " + date_ForecastOrders);

				originalQuantity_ForecastOrders = forecastOrderDetail.getOriginalQuantity();
				System.out.println("Get item details service response for Original quantity : " + originalQuantity_ForecastOrders);

				upcomingOriginalQty.add(originalQuantity_ForecastOrders);

				requestedQuantity_ForecastOrders = forecastOrderDetail.getRequestedQuantity();
				System.out.println("Get item details service response for Requested quantity : " + requestedQuantity_ForecastOrders);

				deliveredQuantity_ForecastOrders = forecastOrderDetail.getDeliveredQuantity();
				System.out.println("Get item details service response for Delivered quantity : " + deliveredQuantity_ForecastOrders);

				finalOrderDate_ForecastOrders = forecastOrderDetail.getFinalOrderDate();
				System.out.println("Get item details service response for Final order date : " + finalOrderDate_ForecastOrders);

				maximumOrderIncrease_ForecastOrders = forecastOrderDetail.getMaximumOrderIncrease();
				System.out.println("Get item details service response for Maximum order increase : " + maximumOrderIncrease_ForecastOrders);

				maximumOrderDecrease_ForecastOrders = forecastOrderDetail.getMaximumOrderDecrease();
				System.out.println("Get item details service response for Maximum order decrease : " + maximumOrderDecrease_ForecastOrders);
			}

			//Previous order details
			List<SalesOrder_PreviousOrder> previousOrderDetails = itemDetail.getPreviousOrders();
			for (SalesOrder_PreviousOrder previousOrderDetail : previousOrderDetails) {

				date_PreviousOrders = previousOrderDetail.getDate();
				System.out.println("Get item details service response for Date : " + date_PreviousOrders);

				requestedQuantity_PreviousOrders = previousOrderDetail.getRequestedQuantity();
				System.out.println("Get item details service response for Requested quantity : " + requestedQuantity_PreviousOrders);

				deliveredQuantity_PreviousOrders = previousOrderDetail.getDeliveredQuantity();
				System.out.println("Get item details service response for Delivered quantity : " + deliveredQuantity_PreviousOrders);

				lastWeekOriginalQty.add(requestedQuantity_PreviousOrders);

			}
		}
	}

	public void getAmendOrderServiceResponse()throws Throwable {
		int responseCode = Response.getStatusLine().getStatusCode();
		String errorMessage = Response.getStatusLine().getReasonPhrase();
		int responseCodeE = 200;
		System.out.println("Error Message is - " + errorMessage);

		assertEquals(responseCode, responseCodeE, " Item details does not exist. Response code");

		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		salesOrder_AmendRootJsonResp = objectMapper.readValue(Response.getEntity().getContent(), SalesOrder_AmendRoot.class);
		String ProductJSONresult1 = objectMapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(salesOrder_AmendRootJsonResp);
		System.out.println("Amend order item details :\n" + ProductJSONresult1);

		System.out.println("Amend order item details:\n" + salesOrder_AmendRootJsonResp);

		amendOrder_locationId = salesOrder_AmendRootJsonResp.getLocationId();
		System.out.println("Amend order Location id : " + amendOrder_locationId);

		amendOrder_categoryId = salesOrder_AmendRootJsonResp.getCategoryId();
		System.out.println("Amend order Category id : " + amendOrder_categoryId);

		amendOrder_locationCategoryId = salesOrder_AmendRootJsonResp.getLocationCategoryId();
		System.out.println("Amend order Location category id : " + amendOrder_locationCategoryId);

		List<SalesOrder_AmendOrderItem> amendItems = salesOrder_AmendRootJsonResp.getItems();

		for(SalesOrder_AmendOrderItem items : amendItems){

			amendOrder_itemNumber = items.getItemNumber();
			System.out.println("Amend order Item number : " + amendOrder_itemNumber);

			amendOrder_itemDescription = items.getItemDescription();
			System.out.println("Amend order Item description : " + amendOrder_itemDescription);

			amendOrderList.add(amendOrder_itemDescription);

			amendOrder_locationCategoryProductIdd = items.getLocationCategoryProductId();
			System.out.println("Amend Location category category id : " + amendOrder_locationCategoryProductIdd);

			amendOrder_departmentId = items.getDepartmentId();
			System.out.println("Amend order Department id : " + amendOrder_departmentId);

			amendOrder_productPin = items.getProductPin();
			System.out.println("Amend order Product pin : " + amendOrder_productPin);

			amendOrder_itemListType = items.getItemListType();
			System.out.println("Amend order Item list type : " + amendOrder_itemListType);

			//			List<SalesOrder_ForecastOrder> forecastOrders =  items.getForecastOrders();
			//
			//		amendOrder_itemListType = items.getItemListType();
			//		System.out.println("Amend order Item list type : " + amendOrder_itemListType);
			//
			//		amendOrder_itemListType = items.getItemListType();
			//		System.out.println("Amend order Item list type : " + amendOrder_itemListType);
			//
			//		amendOrder_itemListType = items.getItemListType();
			//		System.out.println("Amend order Item list type : " + amendOrder_itemListType);
		}
	}

	public void verifyNextLinkInService() throws URISyntaxException, ClientProtocolException, IOException{

		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = nextLink;

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;

		getHeadersForApp();
		System.out.println("URI is \t" + currentUri + "headers are\t" + headers);
		if (currentUri != null)
			Response = WebServiceClient.getMethodResponse(currentUri, headers);
		else {
			System.out.println("\n URL value is missing.Please send valid URL to perform operation");
		}


		int responseCode = Response.getStatusLine().getStatusCode();
		String errorMessage = Response.getStatusLine().getReasonPhrase();
		int responseCodeE = 200;
		System.out.println("Error Message is - " + errorMessage);

		if(responseCode==200)
		{
			assertEquals(responseCode, responseCodeE, " Category department details does not exist. Response code");

			objectMapper.setSerializationInclusion(Include.NON_NULL);
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			salesOrder_RootProductsJsonResp = objectMapper.readValue(Response.getEntity().getContent(), SalesOrder_RootProducts.class);
			String ProductJSONresult1 = objectMapper.writerWithDefaultPrettyPrinter()
					.writeValueAsString(salesOrder_RootProductsJsonResp);

			System.out.println("Sales order:\n" + ProductJSONresult1);

			System.out.println("Sales order:\n" + salesOrder_RootProductsJsonResp);

			String locationIdForecast = salesOrder_RootProductsJsonResp.getLocationId();
			System.out.println("Get category service response Location id : " + locationIdForecast);

			String categoryIdForecast = salesOrder_RootProductsJsonResp.getCategoryId();
			System.out.println("Get category service response Category id : " + categoryIdForecast);

			String locationCategoryIdForecast = salesOrder_RootProductsJsonResp.getLocationCategoryId();
			System.out.println("Get category service response Location category id : " + locationCategoryIdForecast);
		}
	}

	public void verifyPreviousLinkInService() throws JsonParseException, JsonMappingException, UnsupportedOperationException, IOException, URISyntaxException{
		String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
		String resource = previousLink;

		URIBuilder uriBuilder = new URIBuilder(baseURI + resource);

		currentUri = uriBuilder.build();
		System.out.println(currentUri);
		mDAccessTocken = accessTocken;

		getHeadersForApp();
		System.out.println("URI is \t" + currentUri + "headers are\t" + headers);
		if (currentUri != null)
			Response = WebServiceClient.getMethodResponse(currentUri, headers);
		else {
			System.out.println("\n URL value is missing.Please send valid URL to perform operation");
		}


		int responseCode = Response.getStatusLine().getStatusCode();
		String errorMessage = Response.getStatusLine().getReasonPhrase();
		int responseCodeE = 200;
		System.out.println("Error Message is - " + errorMessage);

		if(responseCode==200)
		{
			assertEquals(responseCode, responseCodeE, " Category department details does not exist. Response code");

			objectMapper.setSerializationInclusion(Include.NON_NULL);
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			salesOrder_RootProductsJsonResp = objectMapper.readValue(Response.getEntity().getContent(), SalesOrder_RootProducts.class);
			String ProductJSONresult1 = objectMapper.writerWithDefaultPrettyPrinter()
					.writeValueAsString(salesOrder_RootProductsJsonResp);

			System.out.println("Sales order:\n" + ProductJSONresult1);

			System.out.println("Sales order:\n" + salesOrder_RootProductsJsonResp);

			String locationIdForecast = salesOrder_RootProductsJsonResp.getLocationId();
			System.out.println("Get category service response Location id : " + locationIdForecast);

			String categoryIdForecast = salesOrder_RootProductsJsonResp.getCategoryId();
			System.out.println("Get category service response Category id : " + categoryIdForecast);

			String locationCategoryIdForecast = salesOrder_RootProductsJsonResp.getLocationCategoryId();
			System.out.println("Get category service response Location category id : " + locationCategoryIdForecast);
		}	
	}

	public void verifyCountAndOffsetValue(){
		String exepctedValue = "20";

		assertEquals(offset, exepctedValue,"Offset attribute value in api response is not as exepcted");
		assertEquals(count, exepctedValue,"Count attribute value in api response is not as exepcted");
	}

	public void verifyAmendedWeekDetails(){

		List<String> upcomingWeek = SalesOrderPO.upcomingOriginalQtyUI;

		List<String> lastWeek = SalesOrderPO.lastWeekOriginalQtyUI;

		String originalQtyService = SalesOrderPO.todaysQtyUI;
		if(originalQtyService.equals("NA")){
			originalQtyService = null;
		}

		assertEquals(originalQuantity_Item, originalQtyService, "Todays qty is mismatched in UI and Services");

		String productMin = SalesOrderPO.productMinUI;
		assertEquals(itemNumber_Item, productMin, "Product Min is mismatched in UI and Services");

		String productDescription = SalesOrderPO.productDescriptionUI;
		assertEquals(itemDescription_Item, productDescription, "Product Description is mismatched in UI and Services");

		upcomingOriginalQty.equals(upcomingWeek);

		lastWeekOriginalQty.equals(lastWeek);

	}
}

