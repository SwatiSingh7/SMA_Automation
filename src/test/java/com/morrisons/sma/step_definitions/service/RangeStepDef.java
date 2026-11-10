package com.morrisons.sma.step_definitions.service;

import org.apache.http.HttpResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.morrisons.common.helper.WebServiceHelper;
import com.morrisons.sma.page_objects.service.range.RangePO;
import com.morrisons.sma.pojo.service.login.GetLogin;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class RangeStepDef {

    ObjectMapper objectMapper = new ObjectMapper();
    public static HttpResponse httpResponse;
    public static io.restassured.response.Response restResponse;

    RangePO rangePO = new RangePO();
    public static GetLogin getLoginJsonResp;
    public static String accessToken = null;

    @Given("Post request to Range service for Store id {string} and Product id {string}")
    public void postRequestToRange(String storeId,String productId) throws Throwable {
        rangePO.createRangeUrl(storeId,productId);
    }

    @Then("Verify Response code for Range Service")
    public void verifyResponse() throws Throwable {
        httpResponse = rangePO.getResponse();
        WebServiceHelper.verifyStatusCode(httpResponse);
    }

    @Then("Get JSON response for Range service")
    public void verifyResponse1() throws Throwable {
        rangePO.getRangeServiceResponse();
    }

    @Then("Verify Clearance status is {string} in GetRange service")
    public void verifyClearanceStatus(String status) throws Throwable {
        rangePO.verifyClearanceStatus(status);
    }

    @Then("Verify Wastage status is {string} in GetRange service")
    public void verifyWastageStatus(String status) throws Throwable {
        rangePO.verifyWastageStatus(status);
    }

}
