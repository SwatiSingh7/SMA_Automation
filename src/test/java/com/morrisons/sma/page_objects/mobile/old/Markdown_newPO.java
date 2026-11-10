package com.morrisons.sma.page_objects.mobile.old;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import com.morrisons.sma.page_objects.service.MarkdownServicePages;
import com.morrisons.common.action.Hook;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;

public class Markdown_newPO {
	private static AndroidDriver driveR;
	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
	String env = applicationConfig.getWebElementEnviroment().getEnv();
	private String newprice;
	private String percentnewprice;
	private String Errormsg;
	private String FixedPrice;
	private String Pricemarkdown;
	private String originalprice1;
	private static String firstpercent;
	public static List<String> percentageList = new ArrayList<String>();

	private static String originalprice;

	public Markdown_newPO()
	{
	this.driveR = (AndroidDriver) Hook.getDriver();
	
	}
	
	public void selectexpirydate() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/outofcode_date']")).click();
		driveR.findElement(By.xpath("//android.widget.Button[@text='ok' or @text='OK']")).click();
		Thread.sleep(3000);
	}

	public void selectquantity(String quantity) throws Throwable {

		driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/outofcode_quantity']")).sendKeys(quantity);
		Thread.sleep(3000);
	}
	
	public void notableeditNewPrice() {
		try{
		    if(driveR.findElement(By.id(""+env+":id/markdown_price_fixed")).isDisplayed())
		        System.out.println("Element is present and editable");
		    else
		        System.out.println("Element is present but not editable"); 
		}catch (NoSuchElementException e) {
		    System.out.println("Element is not present, hence not Editable as well");
		}
	}

	public void clickmarkdownlist() {
		driveR.findElement(By.xpath("//android.widget.TextView[@text='Markdowns List']")).click();
	}

	public void clickyes() {
		try{
		    if(driveR.findElement(By.xpath("//android.widget.Button[@text='YES']")).isDisplayed())
		    {
		        System.out.println("Element is present");
			driveR.findElement(By.xpath("//android.widget.Button[@text='YES']")).click();
		    }
		    else
		        System.out.println("Element is present but not clickable"); 
		}catch (NoSuchElementException e) {
		    System.out.println("Element is not present, hence not clickable as well");
		}
	}

	public void verifyScanninginMarkdownlist() throws InterruptedException {
		try{
		    if(driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/action_barcode_entry']")).isDisplayed())
		    { Thread.sleep(3000);
		        System.out.println("Element is present");
		    }
		    else
		        System.out.println("Element is present but not clickable"); 
		}catch (NoSuchElementException e) {
		    System.out.println("Element is not present, hence not clickable as well");
		}
	}
	
	public void disbleWifinData() throws InterruptedException 
	{		
			driveR.toggleWifi();
			driveR.toggleData();
	}

	

	public void errorBarcodeMsg() {
		try {
			Thread.sleep(2000);
			driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']")).isDisplayed();

		} catch (InterruptedException e) {
			String messag = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']"))
					.getText();
			e.printStackTrace();
		}
		
	}
	
	public void originalPrice() {
	    driveR.findElement(By.id(""+env+":id/original_price")).isDisplayed();
	    originalprice =driveR.findElement(By.id(""+env+":id/original_price")).getText();
	    System.out.println(originalprice);
	}

	public void NewPrice() {
	    driveR.findElement(By.id(""+env+":id/markdown_price_editable")).isDisplayed();
	    newprice =driveR.findElement(By.id(""+env+":id/markdown_price_editable")).getText();
	    System.out.println(newprice);
	}
	
	public void selectpercentage(String percent) throws InterruptedException {
	    driveR.findElement(By.id(""+env+":id/markdown_percentage_spinner")).click();
	    Thread.sleep(2000);
		driveR.findElement(By.xpath("//android.widget.CheckedTextView[@text='" + percent +'%'+"']")).click();
		Thread.sleep(2000);
		percentnewprice =driveR.findElement(By.id(""+env+":id/markdown_price_editable")).getText();
	    System.out.println(percentnewprice);
		
	}

public void warningmsgrestricted() {
	
	driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']")).isDisplayed();
	String msg1 =	driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']")).getText();
	System.out.println(msg1);	
	}
	
public void clickContinue() throws InterruptedException {
			    driveR.findElement(By.xpath("//android.widget.Button[@text='CONTINUE' or @text='OK' ]")).click();
			    Thread.sleep(3000);
}

public void verifyuniqueMIN() {
//		String markdownMIN = MarkdownServicePages.minIdentifier;
//		System.out.println("Min indentifier : " + markdownMIN);

}	

public void clickProduct() throws InterruptedException {
    driveR.findElement(By.id(""+env+":id/markdown_scan_list_item")).click();
    Thread.sleep(3000);
}

public void verifyitemSummary() throws InterruptedException {
	Thread.sleep(3000);
driveR.findElement(By.id(""+env+":id/product_title")).isDisplayed();
driveR.findElement(By.id(""+env+":id/value")).isDisplayed();
driveR.findElement(By.id(""+env+":id/original_price")).isDisplayed();
driveR.findElement(By.id(""+env+":id/markdown_price_fixed")).isDisplayed();
driveR.findElement(By.xpath("//android.widget.TextView[@index='4']")).isDisplayed();

}

public void verifypercentdeatailsnotPresent() {
	try{
	    if(driveR.findElement(By.id(""+env+":id/markdown_percentage")).isDisplayed())
	        System.out.println("Element is present");
	    else
	        System.out.println("Element is  not present"); 
	}catch (NoSuchElementException e) {
	    System.out.println("Element is not present, hence not displayed as well");
	}
}
 public void capturePrice() throws InterruptedException {
	 originalPrice();
 }

 public void verifyMaximummarkdownmsg()
 {
	 try{
		    if(driveR.findElement(By.id(""+env+":id/message")).isDisplayed()) {
		    	Errormsg = driveR.findElement(By.id(""+env+":id/message")).getText();
		    	assertEquals(Errormsg,"This product can not be reduced any further.", "Message MisMatch!!");
		    }
		    else
		        System.out.println("Element is  not present"); 
		}catch (NoSuchElementException e) {
		    System.out.println("Element is not present, hence not displayed as well");
		}
	}

public void verifymarkdwnPrice() {
    originalprice1 =driveR.findElement(By.id(""+env+":id/original_price")).getText();

	assertEquals(originalprice,originalprice1);
	
}


public void ChangeCategory() throws InterruptedException {
	try{
	    if(driveR.findElement(By.id(""+env+"android:id/button1")).isDisplayed())
	    { Thread.sleep(3000);
	    driveR.findElement(By.id(""+env+"android:id/button1")).click();
	    }
	    else
	        System.out.println("change category not displayed"); 
	}catch (NoSuchElementException e) {
	    System.out.println("change category is not present, hence not clickable as well");
	}
}
	 
public void verfiyEditItemScreen() throws InterruptedException {
    driveR.findElement(By.xpath("//android.widget.TextView[@text='Edit Item' ]")).isDisplayed();
    Thread.sleep(3000);
}
 public void clickSaveChange() throws InterruptedException {
	    driveR.findElement(By.xpath("//android.widget.TextView[@text='SAVE CHANGES' ]")).isDisplayed();
	    Thread.sleep(3000);
	    driveR.findElement(By.xpath("//android.widget.TextView[@text='SAVE CHANGES' ]")).click();

 }

public void largequantitymsg() throws InterruptedException {
	try{
	    if(driveR.findElement(By.id(""+env+":id/message")).isDisplayed())
	    { 
		    driveR.findElement(By.xpath("//android.widget.TextView[@text='CONFIRM' ]")).click();
	    	Thread.sleep(3000);   
	    }
	    else
	        System.out.println("Warning not displayed"); 
	}catch (NoSuchElementException e) {
	    System.out.println("Waring is not present, hence not displayed as well");
	}	
}

public void departmentScreen() throws InterruptedException {
	////com.morrisons.instore.sit:id/completed_departments_label
	driveR.findElement(By.id(""+env+":id/completed_departments_label")).isDisplayed();
	Thread.sleep(3000);
}

public void VerifyOptimisedPriceParameters() {
	String optimisedPricePercent1 = MarkdownServicePages.optimisedPricePercentage;
    String markdownPrice1 = Float.toString(MarkdownServicePages.optimisedPriceMarkdownPrice);
    NewPrice();
	assertEquals(newprice,markdownPrice1);
    String optimisedPriceQuantity1 = MarkdownServicePages.optimisedPriceQuantity;
    String unitOfMeasure1 = MarkdownServicePages.unitOfMeasure;
    
}

public void verifyMaxpercentage(String maxpercentDB, int lowerpricelimitDB){
	String maxServicepercent = MarkdownServicePages.markdownPercentageee;
	System.out.println("max percentage in Service : " + maxServicepercent);
	System.out.println("min price limit set in DB : " + lowerpricelimitDB);

	try {
		if (maxServicepercent.contentEquals(maxpercentDB)) {
			// assertEquals(maxpercent,max1,"Markdown percentage and price is not present");
			String min1Priceservice = MarkdownServicePages.markdownPrice;
			double price = Integer.parseInt(min1Priceservice);
			double i = (double) price / 100;
			System.out.println("price from service : " + i);
			if (lowerpricelimitDB > i) {
				System.out.println("Markdown Price is above lower limit");
			} else
				System.out.println("MArkdown Price is below set limit");
		}
	} catch (NoSuchElementException e) {
		System.out.println("Check DB limit for percenatage");
	}
}


public List<String> getPercentageList() throws Throwable {
    
	driveR.findElement(By.id(""+env+":id/markdown_percentage_spinner")).click();
	Thread.sleep(3000);
	percentageList.clear();
	int i=0;
	while(i<2)
	{
		List<WebElement> xpercentageList = driveR.findElements(By.xpath("//android.widget.CheckedTextView"));
		System.out.println("Percentagelist size : " + percentageList.size());
		
			for(WebElement xlist : xpercentageList){
				String percentName = xlist.getText();

				if(!percentName.equals("Calculated") && !percentageList.contains(percentName)){
					System.out.println("percentage : " + percentName);
					percentageList.add(percentName);
				}
			}
			i++;
			Thread.sleep(2000);
			TouchAction ts = new TouchAction(driveR);
			ts.press(PointOption.point(59,1668)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
			.moveTo(PointOption.point(59,1038)).release().perform();
			Thread.sleep(2000);	
	
	}
	return percentageList;
}

public void verifypercentlistupto() throws Throwable {
	int i = 0;
	System.out.println(percentageList.size());
	getPercentageList();
 firstpercent = percentageList.get(i);
	System.out.println(firstpercent);
	String Secondpercentage = percentageList.get(i+1);
	System.out.println("Second  :" );
	System.out.println(Secondpercentage);

}

public void verifypercentagedropdwninUI(String maxpercent, int minPrice) {

	assertEquals(firstpercent,maxpercent,"Percetagelist is mismatch in UI");
}

public void verifyAPIresponse() {
	//Response
	System.out.println(MarkdownServicePages.Response);
	int responseCode = MarkdownServicePages.Response.getStatusLine().getStatusCode();
	System.out.println("GET response : " + responseCode);

	boolean isExpected = false;

	if(responseCode==404)
	{
		isExpected = true;
	}
	assertEquals(true, isExpected, " Response code for service is not as expected");
}
}










	


