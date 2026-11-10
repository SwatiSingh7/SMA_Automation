package com.morrisons.sma.step_definitions.service.old;

import org.apache.http.HttpResponse;

import io.cucumber.java.en.Then;
import com.morrisons.sma.page_objects.service.StockMovementServicePO;

public class StockMovementStepDefService {

	StockMovementServicePO stockMovementServicePO = new StockMovementServicePO();
	
	public static HttpResponse Response;
	
	@Then("Stock movement data is ReceiptlocationId {string},ShippedFromLocationId {string},ItemNo {string},PackId {string},lotNumber {string},ReceiptedQty {string},ReceiptedQtyType {string},OrderId {string},OrderType {string},StockOrderID {string},ContainerID {string},TrailerId {string}")
	public void setData(String receiptLocationId,String shippedLocationId,String itemNo, String packId, String lotNumber, String receiptedQuantity, String receiptedQuantityType, String orderId,
			String orderType,String soOrderId,String containerId,String trailerId) throws Throwable {
		stockMovementServicePO.setData(receiptLocationId,shippedLocationId,itemNo,packId,lotNumber,receiptedQuantity,receiptedQuantityType,orderId,orderType,soOrderId,containerId,trailerId);
	}
	
	@Then("Post request is made to Stock movement Api")
	public void postBasketV2Api() throws Throwable {
		stockMovementServicePO.postStockMovement();    
	}

	@Then("Post operation perform on Stock movement Api")
	public void stockMovementPostOperation() throws Throwable {
		Response = stockMovementServicePO.stockMovementPostOperation();  
		System.out.println(Response);
	}
	
	@Then("Verify Post Stock movement service response")
	public void postStockMovementStatus() throws Throwable {
		stockMovementServicePO.postStockMovementStatus();
		Thread.sleep(2000);
	}
	
	@Then("Verify Post Stock movement service is returning 400 Bad Request response")
	public void verifyBadRequestResponse() throws Throwable {
		stockMovementServicePO.verifyBadRequestResponse();    
	}
	
	@Then("AsnId attribute is Empty in Stock movement Api post request body")
	public void setAsnIdData() throws Throwable {
		stockMovementServicePO.setAsnIdData();    
	}
	
	@Then("TrailerId attribute is Empty in Stock movement Api post request body")
	public void setTrailerIdData() throws Throwable {
		stockMovementServicePO.setTrailerIdData();    
	}
	
	@Then("ItemId, PackId, lotNumber, ReceiptedQuantity and ReceiptedQuantityType attributes detail are Empty in Stock movement Api post request body")
	public void setItemDetailsData() throws Throwable {
		stockMovementServicePO.setItemDetailsData();    
	}
	
	@Then("OrderId, OrderType and OrderedDate attributes detail are Empty in Stock movement Api post request body")
	public void setOrderDetailsData() throws Throwable {
		stockMovementServicePO.setOrderDetailsData();    
	}
	
	@Then("ContainerId is Empty in Stock movement Api post request body")
	public void setContainerIdData() throws Throwable {
		stockMovementServicePO.setContainerIdData();    
	}
	
	@Then("ReceiptDate, ReceiptLocationId and ShippedFromLocationId attributes detail are Empty in Stock movement Api post request body")
	public void setReceiptData() throws Throwable {
		stockMovementServicePO.setReceiptData();    
	}
	
	@Then("Get post stock movement response")
	public void getPostStockMovementResponse() throws Throwable {
		stockMovementServicePO.getPostStockMovementResponse();    
	}
	
	@Then("Verify by passing Empty asn id in Post Stock movement api response message returned is {string}")
	public void verifyEmptyAsnIdMessage(String responseMessage) throws Throwable {
		stockMovementServicePO.verifyEmptyAsnIdMessage(responseMessage);    
	}
	
	@Then("Verify by passing Empty Trailer id in Post Stock movement api response message returned is {string}")
	public void verifyEmptyTrailerIdMessage(String responseMessage) throws Throwable {
		stockMovementServicePO.verifyEmptyTrailerIdMessage(responseMessage);    
	}
	
	@Then("Verify by passing Empty Item id in Post Stock movement api response message returned is {string}")
	public void verifyEmptyItemIdMessage(String responseMessage) throws Throwable {
		stockMovementServicePO.verifyEmptyItemIdMessage(responseMessage);    
	}
	
	@Then("Verify by passing Empty Pack id in Post Stock movement api response message returned is {string}")
	public void verifyEmptyPackIdMessage(String responseMessage) throws Throwable {
		stockMovementServicePO.verifyEmptyPackIdMessage(responseMessage);    
	}
	
	@Then("Verify by passing Empty lot Number in Post Stock movement api response message returned is {string}")
	public void verifyEmptyLotNumberMsg(String responseMessage) throws Throwable {
		stockMovementServicePO.verifyEmptyLotNumberMsg(responseMessage);    
	}
	
	@Then("Verify by passing Empty Receipted quantity in Post Stock movement api response message returned is {string}")
	public void verifyEmptyReceptedQtyMsg(String responseMessage) throws Throwable {
		stockMovementServicePO.verifyEmptyReceptedQtyMsg(responseMessage);    
	}
	
	@Then("Verify by passing Empty Receipted quantity type in Post Stock movement api response message returned is {string}")
	public void verifyEmptyReceiptedQtyTypeMsg(String responseMessage) throws Throwable {
		stockMovementServicePO.verifyEmptyReceiptedQtyTypeMsg(responseMessage);    
	}
	
	@Then("Verify by passing Empty Order id in Post Stock movement api response message returned is {string}")
	public void verifyEmptyOrderIdMsg(String responseMessage) throws Throwable {
		stockMovementServicePO.verifyEmptyOrderIdMsg(responseMessage);    
	}
	
	@Then("Verify by passing Empty Order type in Post Stock movement api response message returned is {string}")
	public void verifyEmptyOrderTypeMsg(String responseMessage) throws Throwable {
		stockMovementServicePO.verifyEmptyOrderTypeMsg(responseMessage);    
	}
	
	@Then("Verify by passing Empty Order date in Post Stock movement api response message returned is {string}")
	public void verifyEmptyOrderDateMsg(String responseMessage) throws Throwable {
		stockMovementServicePO.verifyEmptyOrderDateMsg(responseMessage);    
	}
	
	@Then("Verify by passing Empty Container id in Post Stock movement api response message returned is {string}")
	public void verifyEmptyContainerIdMessage(String responseMessage) throws Throwable {
		stockMovementServicePO.verifyEmptyContainerIdMessage(responseMessage);    
	}
	
	@Then("Verify by passing Empty Receipt date in Post Stock movement api response message returned is {string}")
	public void verifyEmptyReceiptDate(String responseMessage) throws Throwable {
		stockMovementServicePO.verifyEmptyReceiptDate(responseMessage);    
	}
	
	@Then("Verify by passing Empty Receipt location in Post Stock movement api response message returned is {string}")
	public void verifyEmptyReceiptLocationMsg(String responseMessage) throws Throwable {
		stockMovementServicePO.verifyEmptyReceiptLocationMsg(responseMessage);    
	}
	
	@Then("Verify by passing Empty Shipped location in Post Stock movement api response message returned is {string}")
	public void verifyEmptyShippedLocationMsg(String responseMessage) throws Throwable {
		stockMovementServicePO.verifyEmptyShippedLocationMsg(responseMessage);    
	}



}
