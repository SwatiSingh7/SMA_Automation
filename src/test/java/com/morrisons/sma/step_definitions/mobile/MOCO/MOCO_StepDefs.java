package com.morrisons.sma.step_definitions.mobile.MOCO;

import com.morrisons.common.utility.ApplicationContext;
import com.morrisons.sma.page_objects.mobile.old.LoginPagePO;
import com.morrisons.sma.step_definitions.service.old.opticFocalStrategies;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class MOCO_StepDefs {
//    MOCO_StepDefs MOCO_PO = new MOCO_StepDefs();

    @And("I verify Product Details on {string} page")
    public void iVerifyProductDetailsOnPage(String sPrdDetails) {
    }

    @Then("I verify {string} screen is displayed")
    public void iVerifyReviewOrderScreenIsDisplayed(String sScreen) {
        MOCO_PO.VerfLabelScreenDisplay();
    }

    @Then("I verify {string} screen is not displayed")
    public void iVerifyCreateOrderScreenIsNotDisplayed(String sScreen) {
        MOCO_PO.VerfLabelScreenNotDisplay(sScreen);
    }

    @Given("I hit the get endpoint to retrieve the {string} for the following {string} and {string} and {string} and {string} and {string} and {string}")
    public void iHitTheGetEndpointToRetrieveTheForTheFollowingAndAndAndAndAndAndAndAnd(String ServiceName, String EndPoint, String APIKey, String AuthKey, String param1,String param2,String param3) throws InterruptedException {
        MOCO_API_Services.getRequestAPI(ServiceName, EndPoint, APIKey, AuthKey, param1,param2,param3);
    }

    @Given("I hit the get endpoint to retrieve the {string} for the following {string} and {string} and {string} and {string} with filetr {string} and {string}")
    public void iHitTheGetEndpointToRetrieveTheForTheFollowingAndAndAndWithFiletrAnd(String ServiceName, String EndPoint, String APIKey, String AuthKey,String sParam, String Filter1, String Filter2) throws IOException, InterruptedException, ParseException {
        MOCO_API_Services.getRequestAPIwithFilter(ServiceName, EndPoint, APIKey, sParam,AuthKey, Filter1,Filter2);
    }

    @Given("I hit the get endpoint to retrieve the {string} for the following {string} and {string} and {string} and {string} and {string}")
    public void iHitTheGetEndpointToRetrieveTheForTheFollowingAndAndAndAnd(String ServiceName, String EndPoint, String APIKey, String AuthKey, String param1,String param2) throws InterruptedException, IOException {
        MOCO_API_Services.getRequestAPI(ServiceName, EndPoint, APIKey, AuthKey, param1,param2);
    }

    @Given("I hit the get endpoint to retrieve the {string} for the following {string} and {string} and {string}")
    public void iHitTheGetEndpointToRetrieveTheForTheFollowingAndAnd(String ServiceName, String EndPoint, String APIKey, String AuthKey) throws IOException, InterruptedException {
        MOCO_API_Services.getRequestAPI(ServiceName, EndPoint, APIKey, AuthKey);
    }

    @Given("I hit the patch endpoint to retrieve the {string} for the following {string} and {string} and {string} and Request file {string}")
    public void iHitThePatchEndpointToRetrieveTheForTheFollowingAndAndAndRequestFile(String ServiceName, String EndPoint, String APIKey, String AuthKey, String sRequest) throws ParseException, InterruptedException {
        ApplicationContext applicationContext = new ApplicationContext();
        MOCO_API_Services oAPIServ = new MOCO_API_Services(applicationContext);
        oAPIServ.patchRequestAPI(ServiceName, EndPoint, APIKey, AuthKey,sRequest);
    }

    @Given("I hit the post endpoint to retrieve the {string} for the following {string} and {string} and {string} and {string} and {string} and Request file {string}")
    public void iHitThePostEndpointToRetrieveTheForTheFollowingAndAndAndAndAndRequestFile(String ServiceName, String EndPoint, String APIKey, String AuthKey, String Param1, String Param2,String sRequest ) throws ParseException, InterruptedException {
        ApplicationContext applicationContext = new ApplicationContext();
        MOCO_API_Services oAPIServ = new MOCO_API_Services(applicationContext);
        oAPIServ.postRequestAPI(ServiceName, EndPoint, APIKey, AuthKey,Param1,Param2,sRequest);
    }

    @Given("I hit the post endpoint to retrieve the {string} for the following {string} and {string} and {string} and {string} and Request file {string} for item {string}")
    public void iHitThePostEndpointToRetrieveTheForTheFollowingAndAndAndAndRequestFileForItem(String ServiceName, String EndPoint, String APIKey,String AuthKey,String sParam, String reqFile, String sItem) throws ParseException, InterruptedException {
        ApplicationContext applicationContext = new ApplicationContext();
        MOCO_API_Services oAPIServ = new MOCO_API_Services(applicationContext);
        oAPIServ.postReqAPIWithDynamicData(ServiceName, EndPoint, APIKey, AuthKey,sParam,reqFile,sItem);
    }

    @And("I verify the response file {string} for item {string}")
    public void iVerifyTheResponseFileForItem(String RespFile, String sItem) throws ParseException {
        ApplicationContext applicationContext = new ApplicationContext();
        MOCO_API_Services oAPIServ = new MOCO_API_Services(applicationContext);
        oAPIServ.VerifyRespFile(RespFile, sItem);
    }

    @And("I delete all Orders")
    public void iDeleteAllOrders() {
        ApplicationContext applicationContext = new ApplicationContext();
        MOCO_API_Services oAPIServ = new MOCO_API_Services(applicationContext);
        oAPIServ.deleteOrders();
    }
}
