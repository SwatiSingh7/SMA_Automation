package com.morrisons.sma.step_definitions.service.old;

import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import com.morrisons.common.utility.MarkdownServiceData;
import com.morrisons.sma.pojo.service.StorewalkServicePOJO.Glh_WalkIdMain;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Header;

import java.net.URI;
import java.util.HashMap;

public class RestAssuredSteps {
	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
	public static URI currentUri;
	public static String mDAccessTocken;
	public static String beaerer;
	public static String accessID;
	public static URI url;
	public static URI glhurl;
	HashMap<String , String> capitals = new HashMap<>(); 


	public void setUp() {
		RestAssured.useRelaxedHTTPSValidation();

	}


	public static void getaccess(String accessTocken) {
		accessID = accessTocken;

	}


	@Given("a Store ID {string} and Product ID {string} is included in Markdown Service request using RestService")
	public void a_Store_ID_and_Product_ID_is_included_in_Markdown_Service_request_using_RestService(String StoreID,
			String min) throws Throwable {

		MarkdownServiceData.getMarkdownRest(StoreID, min, accessID);

		beaerer = "Bearer " + accessID;

		Thread.sleep(1000);  

	}

	public static void getUrl(URI currentUri2) {
		url = currentUri2;
	}

	public static void getUrlGLH(URI currentUri2) {
		glhurl = currentUri2;
	}
	
	@When("the request is made to the specified get Markdown service using RestService")
	public void the_request_is_made_to_the_specified_get_Markdown_service_using_RestService() throws Throwable {

		String code = RestAssured.given().relaxedHTTPSValidation().header(new Header("Authorization", beaerer)).when()
				.get(glhurl)
				// .get((String.format("https://uat-api.morrisons.com/markdown/v2/locations/%s/markdowns/%s?apikey=ZwQGsEN0f65kORZ8EVQlJWA2bGNbHls0",StoreID,min)))
				.getBody().asString();

		System.out.println("Response Body from server " + code);
		
		
		Glh_WalkIdMain getwalkId = RestAssured.given().relaxedHTTPSValidation().header(new Header("Authorization", beaerer)).when()
					.get(glhurl).as(Glh_WalkIdMain.class);
		
		 System.out.println("Pojo details = " + getwalkId.toString());
			
	}

	
}
