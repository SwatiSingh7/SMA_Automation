package com.morrisons.sma.page_objects.mobile.old;

import com.morrisons.common.action.Hook;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import com.morrisons.sma.step_definitions.mobile.old.StockInformationStepDefUI;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.text.DecimalFormat;

import static org.testng.Assert.assertEquals;

public class IntegratedSalesPO {


	private static AndroidDriver driveR;
	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
	String env = applicationConfig.getWebElementEnviroment().getEnv();

	StockInformationStepDefUI SI = new StockInformationStepDefUI();

	private static float calculatedQuantity;
	private static String calculatedqtyCasess;
	private static String calculatedqtyKG;
	private static String calculatedqtyKGCases;
	private static String pcktqty;

	private static  String stockRecourdUI=null;
	private static String[] SOH = null;
	private static  String stockrecordGLH = null;
	private  static String stockRecordService= null; 
	
	private  static String stockValueUI = null; 

	public IntegratedSalesPO()
	{
		this.driveR = (AndroidDriver) Hook.getDriver();

	}


	public void getStockrecoredUI() throws InterruptedException {
		Thread.sleep(3000);
		String soh = driveR.findElement(By.id(""+env+":id/stock_on_hand_value")).getText();
		SOH = soh.split("\\s");
		System.out.println(" stock record UI................" +SOH[0]);
	}

	public void verifyStockRecordUIandService() {
		stockRecordService = SI.startingPosition;

		System.out.println("stock record service:" + stockRecordService );
		System.out.println(" stock record UI:" +SOH[0]);

		Assert.assertEquals(SOH[0],stockRecordService, "Stock Record mismatch" );
		System.out.println("Stock record Verified!!!!!");
	}

	public void verifyGlhStockRecordUIandService() throws InterruptedException {
		Thread.sleep(3000);
		stockrecordGLH = driveR.findElement(By.id(""+env+":id/stock_record_value")).getText();
		System.out.println("stock record glh UI	:" + stockrecordGLH);

	}
	public void calculateqtyforKG() {

		float packQty = Integer.parseInt(SI.packQuantity);
		System.out.println("packQty......."+packQty);

		stockRecordService = SI.startingPosition;
		float stockrecord = Integer.parseInt(stockRecordService);
		System.out.println("stockrecord........."+stockrecord);
		float calculatedQuantity = stockrecord*(packQty/5);			//Pack weight= 5

		DecimalFormat df = new DecimalFormat("#.##"); 
		calculatedqtyKG = df.format(calculatedQuantity); 
		System.out.println("calculatedqtyKG...."+calculatedqtyKG);
	}


	public void calculateQuantitycases() {

		float packQty = Integer.parseInt(SI.packQuantity);
		System.out.println("packQty...." +packQty);

		stockRecordService = SI.startingPosition;
		float stockrecord = Integer.parseInt(stockRecordService);
		System.out.println("\nstockrecord......"+stockrecord);

		calculatedQuantity = stockrecord/packQty;

		DecimalFormat df = new DecimalFormat("#.##"); 
		float num = roundinglogic(calculatedQuantity);
		calculatedqtyCasess = df.format(num); 
		System.out.println("calculatedQuantity.........."+calculatedqtyCasess);   

	}

	public float roundinglogic(float arg) {
		//Refer for more clarity https://morrisons.atlassian.net/browse/SMA-26656

		if(calculatedQuantity>=0.01 && calculatedQuantity<=0.25) {
			calculatedQuantity = (int) 0;
		}
		else if(calculatedQuantity>=0.26 && calculatedQuantity<=0.74) {
			calculatedQuantity = (float) 0.5;
		}
		else if(calculatedQuantity>=0.75 && calculatedQuantity<=0.99) {
			calculatedQuantity = (int) 1;
		}

		return calculatedQuantity;

	}
	public void verifyGlhStockRecordUIandCalculatedqty() throws InterruptedException {
		verifyGlhStockRecordUIandService();
		Assert.assertEquals(stockrecordGLH, calculatedqtyCasess, "Stock record mismatch");

	}

	public void verifyStockRecordUIandCalculatedQty() {

		Assert.assertEquals(SOH[0],calculatedqtyCasess, "Stock record mismatch");
	}


	public void verifyStockRecordUIandCalculatedQtyKg() {
		Assert.assertEquals(SOH[0],calculatedqtyKG, "Stock record mismatch");

	}

	public void verifyGlhStockRecordUIandCalculatedqtyKg() throws InterruptedException {
		verifyGlhStockRecordUIandService();
		Assert.assertEquals(stockrecordGLH, calculatedqtyKG, "Stock record mismatch");

	}

	public void calculatekgcases() {
		stockRecordService = SI.startingPosition;
		//Real time stock is 50 and PackWeight is 5
		int stockrecord = Integer.parseInt(stockRecordService);
		int calculatedQuantity = stockrecord/5;				
		calculatedqtyKGCases = String.valueOf(calculatedQuantity);

	}
	
	public void verifyStockRecordUIandCalculatedQtyPCS() {
		Assert.assertEquals(SOH[0],calculatedqtyCasess, "Stock record mismatch");

	}

	public void verifyStockRecordUIandCalculatedQtyKGcases() {
		Assert.assertEquals(SOH[0],calculatedqtyKGCases, "Stock record mismatch");

	}

	public void verifyGlhStockRecordUIandCalculatedqtykgcases() throws InterruptedException {
		verifyGlhStockRecordUIandService();
		Assert.assertEquals(stockrecordGLH, calculatedqtyKGCases, "Stock record mismatch");

	}

	public void stockrecordafterjobrun(String countUI) throws InterruptedException {
		getStockrecoredUI();
		Assert.assertEquals(SOH[0],countUI, "Stock record mismatch");

	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void verifyStockValue(String stockValue){
		stockValueUI = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/stock_on_hand_value']")).getText();
		stockValueUI = stockValueUI.replaceAll("[^0-9]", "");
		System.out.println("Stock value displayed on UI is : " + stockValueUI);

		assertEquals(stockValueUI,stockValue,"Stock value is mismatched");
	}

	public void verifyStockValueUIAndService() throws InterruptedException {

		String startingPosition = SI.startingPosition;
		System.out.println("Starting position in Stock info service : " + startingPosition);
		String stockPosition = SI.stockPosition;
		System.out.println("Stock position in Stock info service : " + stockPosition);

		assertEquals(stockValueUI,stockPosition,"Stock value is mismatched");

	} 

}
