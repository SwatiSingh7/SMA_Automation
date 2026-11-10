package com.morrisons.sma.step_definitions.service.old;

import org.apache.http.HttpResponse;

import io.cucumber.java.en.Then;
import com.morrisons.sma.page_objects.service.StockTransferServicePO;

public class StockTransferServiceStepDef {

	StockTransferServicePO stockService = new StockTransferServicePO();
	
	public static HttpResponse Response;
	
	@Then("Stock transfer data is {string},{string},{string},{string},{string},{string} and {string}")
	public void setStockTransferData(String fromLocation, String toLocation, String internal,String isBatch,int containerId, String productId, int qtyTransferre) throws Throwable {
		stockService.setData(fromLocation,toLocation,internal,isBatch,containerId,productId,qtyTransferre);
	}

	@Then("Request is made to Stock transfer api")
	public void postStockTranferApi() throws Throwable {
		stockService.postStockTranferApi();    
	}

	@Then("Post operation perform on Stock transfer api")
	public void postServicePerformOperation() throws Throwable {
		Response = stockService.postServicePerformOperation();  
		System.out.println(Response);
	}
	
	@Then("Verify Post Stock transfer service response")
	public void postStockTransferServiceResponse() throws Throwable {
		stockService.postStockTransferServiceResponse();    
	}
}
