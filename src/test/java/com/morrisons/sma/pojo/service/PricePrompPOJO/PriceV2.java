package com.morrisons.sma.pojo.service.PricePrompPOJO;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.http.HttpResponse;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.morrisons.common.utility.ConfigServiceData;
import com.morrisons.common.utility.PriceServiceData;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.morrisons.sma.pojo.service.ProductServicePOJO.BeersWinesSpirits;
import com.morrisons.sma.pojo.service.ProductServicePOJO.CommercialHierarchy;
import com.morrisons.sma.pojo.service.ProductServicePOJO.Item;

public class PriceV2 {

	String storeNumber;
	ObjectMapper objectMapper = new ObjectMapper();
	PriceServiceData priceServiceData = new PriceServiceData();
	ConfigServiceData configServiceData = new ConfigServiceData();
	static Item productJSOnresponse;
	priceV2Payload pricePayload = new priceV2Payload();
	public HttpResponse Response;
	static PriceV2VO priceV2JsonMap;
	static PriceV2Error PriceV2ErrorJsonMap;
	static List<ConfigSerive> configServiceJsonMap = new ArrayList();
	float value;
	double calculatedMUP;
	int integerMup;
	private SoftAssert softAssert = new SoftAssert();
	StringBuffer errorBuffer = new StringBuffer();

	public static void getProductJsonResponse(Item productJSOnresponseMap) {
		productJSOnresponse = productJSOnresponseMap;
	}

	@Given("a Store ID {string} and Product ID {string} is included in PriceV(\\d+) Service request")
	public void a_Store_ID_and_Product_ID_is_included_in_PriceV_Service_request(String storeId, String min, int arg3)
			throws Throwable {

		String priceValidate = objectMapper.writeValueAsString(pricePayload);

		System.out.println("Payload body is " + priceValidate);
		priceServiceData.postPriceV2service(storeId, min, priceValidate);
		Thread.sleep(500);

	}

	@When("the request is made to the specified PriceV(\\d+) Post service")
	public void the_request_is_made_to_the_specified_PriceV_Post_service(int arg1) throws Throwable {

		Response = priceServiceData.performPostOperation();
		Thread.sleep(500);
	}

	@Then("the service should return details for specified PriceV(\\d+) service")
	public void the_service_should_return_details_for_specified_PriceV_service(int arg1) throws Throwable {

		int responseCode = Response.getStatusLine().getStatusCode();
		String errorMessage = Response.getStatusLine().getReasonPhrase();
		int responseCodeE = 200;

		System.out.println("Error Message is - " + errorMessage);
		assertEquals(responseCode, responseCodeE, " PriceV2 details requested doesn't exist. Response code");

		objectMapper.setSerializationInclusion(Include.NON_NULL);
		priceV2JsonMap = objectMapper.readValue(Response.getEntity().getContent(), PriceV2VO.class);
		String ProductJSONresult = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(priceV2JsonMap);
		System.out.println("PriceV2 Response:\n" + ProductJSONresult);
		Thread.sleep(500);
	}

	@Then("the service should return details for specified PriceV(\\d+) service without new rule")
	public void the_service_should_return_details_for_specified_PriceV_service_without_new_rule(int arg1)
			throws Throwable {

		int responseCode = Response.getStatusLine().getStatusCode();
		String errorMessage = Response.getStatusLine().getReasonPhrase();
		int responseCodeE = 400;
		System.out.println("Error Message is - " + errorMessage);
		assertEquals(responseCode, responseCodeE, " Product details requested doesn't exist. Response code");

		objectMapper.setSerializationInclusion(Include.NON_NULL);
		PriceV2ErrorJsonMap = objectMapper.readValue(Response.getEntity().getContent(), PriceV2Error.class);
		String JSONresult = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(PriceV2ErrorJsonMap);
		System.out.println("PriceV2 Response:\n" + JSONresult);

		if (errorBuffer.length() > 0) {
			throw new AssertionError(errorBuffer.toString());

		}
		Thread.sleep(500);

	}

	@Then("request is madhe to Config service for getting Store information for {string}")
	public void request_is_madhe_to_Config_service_for_getting_Store_information_for(String storeId) throws Throwable {

		configServiceData.getConfigDetails();
		Response = configServiceData.performOperation();

		int responseCode = Response.getStatusLine().getStatusCode();
		String errorMessage = Response.getStatusLine().getReasonPhrase();
		int responseCodeE = 200;
		System.out.println("Error Message is - " + errorMessage);
		assertEquals(responseCode, responseCodeE, " Product details requested doesn't exist. Response code");

		objectMapper.setSerializationInclusion(Include.NON_NULL);

		configServiceJsonMap = objectMapper.readValue(Response.getEntity().getContent(),
				new TypeReference<List<ConfigSerive>>() {
				});
		String configServiceJsonResult = objectMapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(configServiceJsonMap);
		// System.out.println("Config Service Response:\n" +
		// configServiceJsonResult);
		storeNumber = storeId;
		Thread.sleep(500);

	}

	@Then("get Data from product service and config service")
	public void get_Data_from_product_service_and_config_service() {

		System.out.println("getSellingUnitOfMeasure is " + productJSOnresponse.getSellingUnitOfMeasure());
		System.out.println("Item no is " + productJSOnresponse.getItemNumber());
		// PriveV2CommonFunctions.setPriceV2BodyData(configServiceJsonMap,productJSOnresponse,storeNumber);

		Store store = new Store();
		for (ConfigSerive configSerive : configServiceJsonMap) {

			if (configSerive.getStoreId().equals(storeNumber)) {
				store.setStoreId(configSerive.getStoreId());
				store.setStoreName(configSerive.getStoreName());
				store.setStoreType(configSerive.getStoreType());
				store.setCountryCode(configSerive.getCountryCode());
				pricePayload.setStore(store);
				break;
			}
		}
		try {
			pricePayload.setItemNumber(productJSOnresponse.getItemNumber());
			pricePayload.setSellingUnitOfMeasure(productJSOnresponse.getSellingUnitOfMeasure());
			pricePayload.setPriceToBeSet("2");
			CommercialHierarchy ch = new CommercialHierarchy();
			ch.setDivision(String.valueOf(productJSOnresponse.getCommercialHierarchy().getDivision()));
			ch.setDivisionName(productJSOnresponse.getCommercialHierarchy().getDivisionName());
			ch.setGroup(productJSOnresponse.getCommercialHierarchy().getGroup());
			ch.setGroupName(productJSOnresponse.getCommercialHierarchy().getGroupName());
			//ch.setDepartment(String.valueOf(productJSOnresponse.getCommercialHierarchy().getDepartmentNumber()));
			ch.setDepartmentName(productJSOnresponse.getCommercialHierarchy().getDepartmentName());
			ch.setClass_(productJSOnresponse.getCommercialHierarchy().getClass_());
			ch.setClassName(productJSOnresponse.getCommercialHierarchy().getClassName());
			ch.setSubclass(String.valueOf(productJSOnresponse.getCommercialHierarchy().getSubclass()));
			ch.setSubclassName(productJSOnresponse.getCommercialHierarchy().getSubclassName());
			pricePayload.setCommercialHierarchy(ch);

			BeersWinesSpirits bws = new BeersWinesSpirits();
			if (productJSOnresponse.getBeersWinesSpirits() != null) {

				bws.setStrengthNumberAndWord(productJSOnresponse.getBeersWinesSpirits().getStrengthNumberAndWord());
				bws.setAlcoholByVolume(productJSOnresponse.getBeersWinesSpirits().getAlcoholByVolume());
				bws.setTastingNotes(productJSOnresponse.getBeersWinesSpirits().getTastingNotes());
				bws.setAdditionalTastingNote(productJSOnresponse.getBeersWinesSpirits().getAdditionalTastingNote());
				bws.setVolumeInLitres(productJSOnresponse.getBeersWinesSpirits().getVolumeInLitres().toString());
				pricePayload.setBeersWinesSpirits(bws);
			} else {
				pricePayload.setBeersWinesSpirits(null);
			}
			Thread.sleep(500);
		} catch (Exception e) {
			System.out.println("Exception cought - " + e);

		}

	}

	@Then("check whether the Store belongs to Scottland region and product belongs to BWS category")
	public void check_whether_the_Store_belongs_to_Scottland_region_and_product_belongs_to_BWS_category()
			throws Throwable {

		int deptFlag = 0;
		for (ConfigSerive configSerive : configServiceJsonMap) {

			if (configSerive.getStoreId().equals(storeNumber)) {
				assertEquals(configSerive.getCountryCode(), "S", "Store Doesnot belongs to Scottland region");
			}
		}
		if (productJSOnresponse.getCommercialHierarchy().getDepartmentNumber() == "1"
				|| productJSOnresponse.getCommercialHierarchy().getDepartmentNumber() == "216"
				|| productJSOnresponse.getCommercialHierarchy().getDepartmentNumber() == "217"
				|| productJSOnresponse.getCommercialHierarchy().getDepartmentNumber() == "222"
				|| productJSOnresponse.getCommercialHierarchy().getDepartmentNumber() == "223"
				|| productJSOnresponse.getCommercialHierarchy().getDepartmentNumber() == "224"
				|| productJSOnresponse.getCommercialHierarchy().getDepartmentNumber() == "225") {
			deptFlag = 1;
		}
		Thread.sleep(500);
		assertEquals(deptFlag, 1, "product NOT belongs to BWS category");

	}

	@Then("check whether the Store belongs to BWS Catagory or not")
	public void check_whether_the_Store_belongs_to_BWS_Catagory_or_not() throws Throwable {

		int deptFlag = 0;

		if (productJSOnresponse.getCommercialHierarchy().getDepartmentNumber() == "1"
				|| productJSOnresponse.getCommercialHierarchy().getDepartmentNumber() == "216"
				|| productJSOnresponse.getCommercialHierarchy().getDepartmentNumber() == "217"
				|| productJSOnresponse.getCommercialHierarchy().getDepartmentNumber() == "222"
				|| productJSOnresponse.getCommercialHierarchy().getDepartmentNumber() == "223"
				|| productJSOnresponse.getCommercialHierarchy().getDepartmentNumber() == "224") {
			deptFlag = 1;
		}
		try {
			Assert.assertEquals(deptFlag, 0, "Store Doesnot belongs BWS Catagory");
		} catch (AssertionError e) {
			System.out.println("Exception - " + e);
			errorBuffer.append(e.getMessage());
		}
		Thread.sleep(500);

	}

	@Then("check whether the Store belongs to Scottland region or not")
	public void check_whether_the_Store_belongs_to_Scottland_region_or_not() throws InterruptedException {
		for (ConfigSerive configSerive : configServiceJsonMap) {

			if (configSerive.getStoreId().equals(storeNumber)) {
				System.out.println("conutry code is - " + configSerive.getCountryCode());
				assertNotEquals(configSerive.getCountryCode(), "S", "Store Doesnot belongs to Scottland region");

			}
		}
		Thread.sleep(500);

	}

	@Then("the service should return details for specified PriceV(\\d+) service without new rule for non Scotteland region")
	public void the_service_should_return_details_for_specified_PriceV_service_without_new_rule_for_non_Scotteland_region(
			int arg1) throws Throwable {

		int responseCode = Response.getStatusLine().getStatusCode();
		String errorMessage = Response.getStatusLine().getReasonPhrase();
		int responseCodeE = 412;
		System.out.println("Error Message is - " + errorMessage);
		assertEquals(responseCode, responseCodeE, " Product details requested doesn't exist. Response code");

		objectMapper.setSerializationInclusion(Include.NON_NULL);
		priceV2JsonMap = objectMapper.readValue(Response.getEntity().getContent(), PriceV2VO.class);
		String ProductJSONresult = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(priceV2JsonMap);
		System.out.println("PriceV2 Response:\n" + ProductJSONresult);
		assertEquals(priceV2JsonMap.getMinimumSellingPrice(), "0", "MSP Rule apllied");
		assertEquals(priceV2JsonMap.getResponseMessage(),
				"The Store Id specified does not belong to the Scotland zone.", "Response Message mismatches");
		Thread.sleep(500);
	}

	@Then("Execute minimum price rule and calculate Minimum selling price")
	public void execute_minimum_price_rule_and_calculate_Minimum_selling_price() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		assertNotNull(productJSOnresponse.getBeersWinesSpirits().getVolumeInLitres(), "Volume in Liters in null");
		assertNotNull(productJSOnresponse.getBeersWinesSpirits().getAlcoholByVolume(), "Alcohol by Volume in null");

		/*
		 * value=((productJSOnresponse.getBeersWinesSpirits().getVolumeInLitres(
		 * ).floatValue()*
		 * Float.valueOf(productJSOnresponse.getBeersWinesSpirits().
		 * getAlcoholByVolume())));
		 */
		value =
				// ((productJSOnresponse.getBeersWinesSpirits().getVolumeInLitres().floatValue()

				(Float.parseFloat(productJSOnresponse.getBeersWinesSpirits().getVolumeInLitres())
						* Float.valueOf(productJSOnresponse.getBeersWinesSpirits().getAlcoholByVolume()));
		calculatedMUP = (value * 0.5 * 100);
		integerMup = (int) (calculatedMUP);
		System.out.println("Integer value is = " + integerMup);
		System.out.println("Calculated Minimum price is - " + calculatedMUP);
		Thread.sleep(500);

	}

	@Then("minimumSellingPrice from PriceV(\\d+) service should be equal to calculated Minimum selling price")
	public void minimumsellingprice_from_PriceV_service_should_be_equal_to_calculated_Minimum_selling_price(int arg1)
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		assertEquals((float) integerMup, Float.parseFloat(priceV2JsonMap.getMinimumSellingPrice()),
				"minimumSellingPrice and calculated Minimum selling price mismatches");
		Thread.sleep(500);
	}

	@Then("ABV value should be integer")
	public void abv_value_should_be_integer() throws Throwable {

		String abv = productJSOnresponse.getBeersWinesSpirits().getAlcoholByVolume();
		int abvFlag = 0;
		if (Pattern.matches("[a-zA-Z]+", abv) == false) {
			abvFlag = 1;
		}
		Thread.sleep(500);
		assertEquals(abvFlag, 1, "ABV value is Not Integer");

	}

	@Then("volumeInLitres value should be integer")
	public void volumeinlitres_value_should_be_integer() throws Throwable {

		assertNotNull(productJSOnresponse.getBeersWinesSpirits().getVolumeInLitres(), "Volume in Liters in null");

		String vil = productJSOnresponse.getBeersWinesSpirits().getVolumeInLitres().toString();

		int abvFlag = 0;
		if (Pattern.matches("[a-zA-Z]+", vil) == false) {
			abvFlag = 1;
		}
		Thread.sleep(500);
		assertEquals(abvFlag, 1, "volumeInLitres value is Not Integer");

	}

	@Then("check ABV value is zero or not")
	public void check_ABV_value_is_zero_or_not() throws Throwable {

		BeersWinesSpirits bws = new BeersWinesSpirits();
		if (productJSOnresponse.getBeersWinesSpirits() != null) {

			bws.setStrengthNumberAndWord(productJSOnresponse.getBeersWinesSpirits().getStrengthNumberAndWord());
			bws.setAlcoholByVolume("0");
			bws.setTastingNotes(productJSOnresponse.getBeersWinesSpirits().getTastingNotes());
			bws.setAdditionalTastingNote(productJSOnresponse.getBeersWinesSpirits().getAdditionalTastingNote());
			bws.setVolumeInLitres(productJSOnresponse.getBeersWinesSpirits().getVolumeInLitres());
			pricePayload.setBeersWinesSpirits(bws);
		} else {
			pricePayload.setBeersWinesSpirits(null);
		}
	}

	@Then("the service should return (\\d+) bad request with error message {string}")
	public void the_service_should_return_bad_request_with_error_message(int arg1, String errorMsg) throws Throwable {

		int responseCode = Response.getStatusLine().getStatusCode();
		String errorMessage = Response.getStatusLine().getReasonPhrase();
		int responseCodeE = 400;
		System.out.println("Error Message is - " + errorMessage);
		assertEquals(responseCode, responseCodeE, " Product details requested doesn't exist. Response code");

		objectMapper.setSerializationInclusion(Include.NON_NULL);
		PriceV2ErrorJsonMap = objectMapper.readValue(Response.getEntity().getContent(), PriceV2Error.class);
		String JSONresult = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(PriceV2ErrorJsonMap);
		System.out.println("PriceV2 Response:\n" + JSONresult);
		assertEquals(PriceV2ErrorJsonMap.getErrorMessage(), errorMsg);
		Thread.sleep(500);

	}

	@Then("check VolumeInLiters value is zero or not")
	public void check_VolumeInLiters_value_is_zero_or_not() throws Throwable {

		BeersWinesSpirits bws = new BeersWinesSpirits();
		if (productJSOnresponse.getBeersWinesSpirits() != null) {

			bws.setStrengthNumberAndWord(productJSOnresponse.getBeersWinesSpirits().getStrengthNumberAndWord());
			bws.setAlcoholByVolume(productJSOnresponse.getBeersWinesSpirits().getAlcoholByVolume());
			bws.setTastingNotes(productJSOnresponse.getBeersWinesSpirits().getTastingNotes());
			bws.setAdditionalTastingNote(productJSOnresponse.getBeersWinesSpirits().getAdditionalTastingNote());
			bws.setVolumeInLitres("0");
			pricePayload.setBeersWinesSpirits(bws);
		} else {
			pricePayload.setBeersWinesSpirits(null);
		}
	}

	@Then("check ABV value is null or not")
	public void check_ABV_value_is_null_or_not() throws Throwable {

		BeersWinesSpirits bws = new BeersWinesSpirits();
		if (productJSOnresponse.getBeersWinesSpirits() != null) {

			bws.setStrengthNumberAndWord(productJSOnresponse.getBeersWinesSpirits().getStrengthNumberAndWord());
			bws.setAlcoholByVolume(null);
			bws.setTastingNotes(productJSOnresponse.getBeersWinesSpirits().getTastingNotes());
			bws.setAdditionalTastingNote(productJSOnresponse.getBeersWinesSpirits().getAdditionalTastingNote());
			bws.setVolumeInLitres("0");
			pricePayload.setBeersWinesSpirits(bws);
		} else {
			pricePayload.setBeersWinesSpirits(null);
		}
	}

	@Then("price should be equal to current price")
	public void price_should_be_equal_to_current_price() throws Throwable {

	}

}
