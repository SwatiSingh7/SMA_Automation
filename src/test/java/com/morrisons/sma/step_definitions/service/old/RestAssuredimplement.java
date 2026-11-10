package com.morrisons.sma.step_definitions.service.old;

import io.restassured.RestAssured;
import io.restassured.http.Header;

public class RestAssuredimplement {


	public void setUp(){
		RestAssured.useRelaxedHTTPSValidation();
		
	}

	public void testResponseCode(){
		
		int code = RestAssured.given()
				.relaxedHTTPSValidation()	
				.header(new Header("Authorization", "Bearer ZGE1ZGFlMGMtYjI3OC00MTIyLTkyYTctZWZmYjc5OWI3OWVhZmVkMGFmNmItNDYzMC00N2VlLWJkNjctNjBiZmExYTUxZTU1"))
				.when()
				.get("https://uat-api.morrisons.com/markdown/v2/locations/78/markdowns/103853612?apikey=ZwQGsEN0f65kORZ8EVQlJWA2bGNbHls0")
				.getStatusCode();
		
				
		
		
		System.out.println("Response code from server " + code);
	}


	public void testbodyCode(){
		
		String code = RestAssured.given()
				.relaxedHTTPSValidation()	
				.header(new Header("Authorization", "Bearer MGMwNjA2YmItNzVkZi00MDIwLTk1NmMtMWUwMjczOWMyNDk1YTMxYThmYTMtMzc0Ni00ZTVlLTkyYjEtYjA5ZmVjYTljZTQw"))
				.when()
				.get("https://uat-api.morrisons.com/markdown/v2/locations/78/markdowns/103853612?apikey=ZwQGsEN0f65kORZ8EVQlJWA2bGNbHls0")
				.getBody().asString();
		
				
		
		
		System.out.println("Response Body from server " + code);
	}
}

//https://uat-api.morrisons.com/markdown/v2/locations/79/markdowns/103853612?apikey=ZwQGsEN0f65kORZ8EVQlJWA2bGNbHls0
//http://restapi.demoqa.com/authentication/CheckForAuthentication/