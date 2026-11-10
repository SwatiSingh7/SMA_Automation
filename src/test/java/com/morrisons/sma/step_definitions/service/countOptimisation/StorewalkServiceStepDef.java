package com.morrisons.sma.step_definitions.service.countOptimisation;

import com.morrisons.sma.page_objects.mobile.countOptimization.CountOptimizationHomePage;
import com.morrisons.sma.page_objects.mobile.countOptimization.StockManagement;
import com.morrisons.sma.page_objects.service.countOptimisation.StorewalkService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class StorewalkServiceStepDef {

    StorewalkService storewalkService = new StorewalkService();
    StockManagement stockManagement = new StockManagement();
    CountOptimizationHomePage countOptimizationHomePage=new CountOptimizationHomePage();

    @Given("I get storewalks through Get storewalks service for current date")
    public void getStorewalksUAT() throws Throwable {
        storewalkService.iGetStoreWalkUAT();
        //System.out.println(Response);
    }

    @Then("I get list of Walkids for{string}and Delete Count storewalkids for store id")
    public void getwalkID(String storeId) throws Throwable {
        storewalkService.getStorewalkResponse(storeId);
    }

    @Then("I create {string} {string} {string} for {string}for {string}")
    public void bcreatewalkID(String storeId, String items, String filePath,String mode,String countType) throws Throwable {
        storewalkService.createCount(mode,items,countType,storeId, filePath);
    }
    @Then("I click on TO DO Tab and verify no count {string} displayed")

    public void verifyNoCount(){


    }


    @Then("I click on {string} and verify all the menus present on Stock Management Application Page")
        public void verifySceduleCountScreen (String option) throws Throwable {
        countOptimizationHomePage.clickOnCOHomePageOption(option);

        stockManagement.verifyStockManagement();
        }
    @Then("I verify all details on Homepage")
    public void verifyHomeScreen() throws Throwable {
        countOptimizationHomePage.verifyCountOptimizationHomePage();
    }
    @Then("I Post {string} {string} {string} for {string}for {string}")
    public void iPostForFor(String mode, String endpoint, String countType, String storeId, String filePath) throws IOException, ParseException, InterruptedException {
       // String ac = getAccessToken("");
        storewalkService.generateCount(mode,endpoint,countType,storeId, filePath);
    }
    }

