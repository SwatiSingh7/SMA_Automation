package com.morrisons.sma.step_definitions.mobile.old;

import org.apache.http.HttpResponse;

import io.cucumber.java.en.Then;
import com.morrisons.sma.page_objects.service.BasketV2ServicePO;


public class BasketV2StepDefService {

	
	BasketV2ServicePO basketV2ServicePO = new BasketV2ServicePO();
	
	public static HttpResponse Response;
	
	@Then("Bakset V2 data is {string},{string},{string},{string},{string},{string},{string},{string},{string} and {string}")
	public void setStockTransferData(String barcode1,int qty1,int deptNo1,String desc1,String dept1,String barcode2,int qty2,int deptNo2,String desc2,String dept2,boolean refundFlag) throws Throwable {
		basketV2ServicePO.setData(barcode1,qty1,deptNo1,desc1,dept1,barcode2,qty2,deptNo2,desc2,dept2,refundFlag);
	}
	
	@Then("Bakset V2 data is {string},{string},{string},{string},{string} and {string}")
	public void setStockTransferData(String barcode1,int qty1,int deptNo1,String desc1,String dept1,boolean refundFlag) throws Throwable {
		basketV2ServicePO.setData(barcode1,qty1,deptNo1,desc1,dept1,refundFlag);
	}

	@Then("Request is made to Bakset V2 api for store id {string}")
	public void postBasketV2Api(int storeId) throws Throwable {
		basketV2ServicePO.postBasketV2Api(storeId);    
	}

	@Then("Post operation perform on Basket V2 api")
	public void basketV2PostPerformOperation() throws Throwable {
		Response = basketV2ServicePO.basketV2PostPerformOperation();  
		System.out.println(Response);
	}
	
	@Then("Verify Post Bakset V2 service response")
	public void postBasketV2ServiceResponse() throws Throwable {
		basketV2ServicePO.postBasketV2ServiceResponse();    
	}
}
