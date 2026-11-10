package com.morrisons.sma.step_definitions.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.morrisons.common.helper.WebServiceHelper;
import org.apache.log4j.Logger;
import com.morrisons.sma.page_objects.service.login.LoginPO;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.http.HttpResponse;

public class LoginStepDef {
    ObjectMapper objectMapper = new ObjectMapper();
    public static HttpResponse httpResponse;
    public static io.restassured.response.Response restResponse;
    private final Logger log = Logger.getLogger(LoginStepDef.class);

    LoginPO loginPO = new LoginPO();
    public static String accessToken = null;

    @Given("Post request to Login service for {string} user")
    public void postRequestToLogin(String user) throws Throwable {
        loginPO.postLoginBody(user);
        loginPO.createLoginUrl();
    }

    @Then("Verify Response code for Login Service")
    public void verifyResponse() throws Throwable {
        httpResponse = loginPO.getResponse();
        WebServiceHelper.verifyStatusCode(httpResponse);
    }

    @Then("Get JSON response for Login service")
    public void verifyResponse1() throws Throwable {
        loginPO.loginUserServiceResponse();
    }
}
