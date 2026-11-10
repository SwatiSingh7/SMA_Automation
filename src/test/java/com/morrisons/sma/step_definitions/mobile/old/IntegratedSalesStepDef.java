package com.morrisons.sma.step_definitions.mobile.old;

import static org.testng.Assert.assertEquals;

import io.cucumber.java.en.Then;
import com.morrisons.sma.page_objects.mobile.old.IntegratedSalesPO;
import io.cucumber.java.en.And;

public class IntegratedSalesStepDef {

	IntegratedSalesPO integratedSales = new IntegratedSalesPO();
	
	static String oldValue = null;
	static String newValue = null;

	@Then("I Capture Stock record UI")
	public void i_Capture_Stock_record_UI() throws Throwable {
		integratedSales.getStockrecoredUI();
	}

	@Then("I verify Stock record UI with Real time stock quantity")
	public void i_verify_Stock_record_UI_with_Real_time_stock_quantity() throws Throwable {
		integratedSales.verifyStockRecordUIandService();
	}

	@Then("I verify GLH stock record value same as Real time stock quantity")
	public void i_verify_GLH_stock_record_value_same_as_Real_time_stock_quantity() throws Throwable {
		integratedSales.verifyGlhStockRecordUIandService();
	}

	@Then("I calculate Stock quantity")
	public void i_calculate_Stock_quantity() throws Throwable {
		integratedSales.calculateQuantitycases();    
	}

	@Then("I verify Stock record UI displayed as calculated value")
	public void i_verify_Stock_record_UI_displayed_as_calculated_value() throws Throwable {
		integratedSales.verifyStockRecordUIandCalculatedQty();
	}
	@Then("I verify Stock record UI displayed as calculated value KGcases")
	public void i_verify_Stock_record_UI_displayed_as_calculated_valuekgcases() throws Throwable {
		integratedSales.verifyStockRecordUIandCalculatedQtyKGcases();
	}
	@Then("I verify Stock record UI displayed as calculated value for PCS")
	public void i_verify_Stock_record_UI_displayed_as_calculated_valuePCS() throws Throwable {
		integratedSales.verifyStockRecordUIandCalculatedQtyPCS();
	}
	@Then("I verify GLH Stock record value same as calculated value")
	public void i_verify_GLH_Stock_record_value_same_as_calculated_value() throws Throwable {
		integratedSales.verifyGlhStockRecordUIandCalculatedqty();
	}
	
	@Then("I verify GLH Stock record value same as calculated value KGcases")
	public void i_verify_GLH_Stock_record_value_same_as_calculated_valueKGcases() throws Throwable {
		integratedSales.verifyGlhStockRecordUIandCalculatedqtykgcases();
	}

	@Then("I calculate Stock quantity for kg")
	public void i_calculate_Stock_quantity_for_kg() throws Throwable {
		integratedSales.calculateqtyforKG();
	}


	@Then("I verify Stock record UI displayed as calculated value for kg")
	public void i_verify_Stock_record_UI_displayed_as_calculated_value_for_kg() throws Throwable {
		integratedSales.verifyStockRecordUIandCalculatedQtyKg();
	}

	@Then("I verify GLH Stock record value same as calculated value for kg")
	public void i_verify_GLH_Stock_record_value_same_as_calculated_value_for_kg() throws Throwable {
		integratedSales.verifyGlhStockRecordUIandCalculatedqtyKg();

	}

	@Then("I calculate Stock quantity for kgcases")
	public void i_calculate_Stock_quantity_for_kgcases() throws Throwable {
	   integratedSales.calculatekgcases();
	}
	

	@Then("I verify Stock record override by {string}")
	public void i_verify_Stock_record_override_by(String count) throws Throwable {
	   integratedSales.stockrecordafterjobrun(count);
	}
	
	@And("I verify initial Stock value is {string}")
	public void verifyStockInitialValue(String stockValue) throws Throwable {
		integratedSales.verifyStockValue(stockValue);
	}
	
	@And("I verify updated Stock value is {string}")
	public void verifyStockUpdatedValue(String stockValue) throws Throwable {
		integratedSales.verifyStockValue(stockValue);
	}
	
	@And("I verify Stock value on UI and Stock info service is matched")
	public void verifyStockValueUIAndService() throws Throwable {
		integratedSales.verifyStockValueUIAndService();
	}



}
