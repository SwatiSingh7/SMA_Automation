package com.morrisons.sma.step_definitions.service.old;

import io.cucumber.java.en.Given;
import org.apache.http.HttpResponse;

import io.cucumber.java.en.Then;
import io.appium.java_client.android.AndroidDriver;
import com.morrisons.sma.page_objects.service.SpaceServicePO;

public class SpaceApiStepDef {
	private AndroidDriver driveR;
	
	String accessToken = null;
	public static HttpResponse Response;
	
	SpaceServicePO spaceServicePO = new SpaceServicePO();
	
	@Then("User performs Get operation for Space service")
	public void serviceReturnDetailsForLoginServices() throws Throwable {
		spaceServicePO.getServicePerformOperation();
	}
	
	@Then("Request is made to Get Space service for Store id {string} and Product {string}")
	public void get_the_generated_accessTocken(String storeID,String productMin) throws Throwable {
		spaceServicePO.getSpaceServiceUrl(storeID, productMin);
	}

	@Then("Get Space service response")
	public void usrPerformsOperation() throws Throwable {
		spaceServicePO.getSpaceServiceResponse();
	}
}
