package com.morrisons.sma.step_definitions.service;

import static org.testng.Assert.assertEquals;

import com.morrisons.sma.step_definitions.mobile.old.CountPostStepDefService;
import org.apache.http.HttpResponse;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.Glh_PostObject;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.Glh_PostResponse;
import com.morrisons.common.utility.GLHserviceRequest;

public class GLHPostDeleteStepDef {

	ObjectMapper objectMapper = new ObjectMapper();
	public static HttpResponse Response;
	Glh_PostResponse glhJsonResponse = new Glh_PostResponse();
	public static String walkId;
	public static String mdLoginBody;
	public static String storeIDs;
	@Given("a Store ID {string} and type {string} is included in GLH  request")
	public void a_Store_ID_and_type_is_included_in_GLH_request(String storeID, String type) throws Throwable {
	
		storeIDs = storeID;
		Glh_PostObject mdLgoin=new Glh_PostObject();
		mdLgoin.setType(type);
		
		
		mdLoginBody = objectMapper.writeValueAsString(mdLgoin);
		System.out.println("Payload body is " + mdLoginBody);
		
	}

	@When("the request is made to the specified Count GLH service")
	public void the_request_is_made_to_the_specified_Count_GLH_service() throws Throwable {
		Thread.sleep(1000);
		GLHserviceRequest.postLoginForGLH(mdLoginBody,storeIDs);
		Response = GLHserviceRequest.postOperationForMdLogin();
		Thread.sleep(500);
		
		int responseCode = Response.getStatusLine().getStatusCode();
		String errorMessage = Response.getStatusLine().getReasonPhrase();
		boolean responseCodeE = false;
		if(responseCode==200 ||responseCode==201)
		{
			responseCodeE = true;
		}
		
		assertEquals(true, responseCodeE, " Product details requested doesn't exist. Response code");
	}

	@Then("The service should return  GLH Service response")
	public void the_service_should_return_GLH_Service_response() throws Throwable {
		Thread.sleep(1000);
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		glhJsonResponse = objectMapper.readValue(Response.getEntity().getContent(), Glh_PostResponse.class);
		
		
//////		String markdownResult = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(glhJsonResponse);
//////		System.out.println("Markdown Response:\n" + markdownResult);
		walkId=	glhJsonResponse.getWalkId();
		CountPostStepDefService.getWalkID(walkId);
	}

	@Then("I verify the json response with GLH Service response")
	public void i_verify_the_json_response_with_GLH_Service_response() throws Throwable {
		Thread.sleep(2000);
	}

	
	
}
