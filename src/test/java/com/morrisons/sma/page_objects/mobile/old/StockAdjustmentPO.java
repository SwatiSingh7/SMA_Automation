package com.morrisons.sma.page_objects.mobile.old;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import com.morrisons.common.PageFactory.InitClass;
import com.morrisons.sma.page_objects.mobile.CountsPO;
import com.morrisons.sma.page_objects.mobile.mins.EnterMINPO_New;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import com.morrisons.common.action.Hook;

import java.util.List;

public class StockAdjustmentPO {
	int ctr = 0;
	public static AndroidDriver driveR;

	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
	String env = applicationConfig.getWebElementEnviroment().getEnv();

	public StockAdjustmentPO() {
		this.driveR = (AndroidDriver) Hook.getDriver();
	}

	public void menuOption(String options) throws Throwable {
		try {

			//ElementRetry.clickElement(driveR, driveR.findElement(By.xpath("//android.widget.TextView[@text='" + options + "']")));
			driveR.findElement(By.xpath("//android.widget.TextView[@text='" + options + "']")).click();
			ElementRetry.hardSleep(1000);
		}
		catch(NoSuchSessionException ns){
			if(ctr < 3) {
				ctr++;
				CountsPO oc = new CountsPO();
//			LoginPagePO loginPage = new LoginPagePO();
//			loginPage.enterCollegueCredentials();
				Thread.sleep(3000);
				menuOption(options);
			}
		}
		catch (Exception e) {
			//driveR.findElement(By.xpath("//android.widget.TextView[@text='" + options + "']")).click();
			ElementRetry.clickElement(driveR, driveR.findElement(By.xpath("//android.widget.TextView[@text='" + options + "']")));
		}
	}

	public void reasonCodeSAPage(String code) throws Throwable {

		String reasoncode = driveR.findElement(By.xpath("//android.widget.TextView[@text='" + code + "']")).getText();
		System.out.println("reason code on menu ----" + reasoncode);
		String expected = code;
		System.out.println("Expected--" + expected);
		assertEquals(reasoncode, expected);

	}

	public void clickAdjustmentCode(String code) throws Throwable {

		driveR.findElement(By.xpath("//android.widget.TextView[@text='" + code + "']")).click();

	}

	public void selectStoreId(String storeNumber) throws Throwable {

		driveR.findElement(By.xpath("//android.widget.EditText[@text='Enter Store Number']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.EditText[@text='Enter Store Number']")).sendKeys(storeNumber);

		Thread.sleep(3000);
		// driveR.findElement(By.xpath("//android.widget.ImageButton[@resource-id='"
		// + env + ":id/camera_scan_fab']")).click();

//		driveR.executeScript("mobile:performEditorAction", ImmutableMap.of("com/morrisons/common/action", "search"));
		driveR.executeScript("mobile:performEditorAction", ImmutableMap.of("action", "search"));
		// new TouchAction((AppiumDriver) driveR).press(PointOption.point(715,
		// 1278)).release().perform();
//		EnterMINPO_New enterMINPONew=new EnterMINPO_New();
//		enterMINPONew.clickOnMobileSearch();

	}

	public void errorMessage(String message) throws Throwable {

		// driveR.findElement(By.xpath("//android.widget.TextView[@text='"+message+"']")).isDisplayed();
		String errorMsg = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']"))
				.getText();
		Assert.assertEquals(errorMsg, message, "Error Message did not matched");

	}

	public void storeIdAvailabel(String storeIds) throws Throwable {

		String storeavailabel = driveR
				.findElement(By.xpath("//android.widget.TextView[@text='Store Number " + storeIds + "']")).getText();
		System.out.println("--------------" + storeavailabel);
		driveR.findElement(By.xpath("//android.widget.TextView[@text='Store Number " + storeIds + "']")).isDisplayed();

	}

	public void clickonGivenStore(String storeIds) throws Throwable {

		// String storeavailabel =
		// driveR.findElement(By.xpath("//android.widget.TextView[@text='Store
		// Number "+storeIds+"']")).getText();
		// System.out.println("--------------"+storeavailabel);
		driveR.findElement(By.xpath("//android.widget.TextView[@text='Store Number " + storeIds + "']")).click();

	}

	public void quantityEditBox(String quantity) throws Throwable {
		WebElement optionElement;
		try {
			optionElement = driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/quantityEditText']"));
		} catch (NoSuchElementException ne) {
			optionElement = InitClass.createObject(driveR,"EnterStockQty","com.morrisons.sma.page_objects.mobile.CountsPO");
			com.morrisons.common.helper.ElementRetry.waitForElementVisible(driveR, optionElement);
		}
		driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/quantityEditText']"))
				.sendKeys(quantity);

	}

	public void confirmButton() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.Button[@text='CONFIRM' or @text='Confirm']")).click();

	}

	public void doneButton() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.Button[@text='Done' or @text='DONE']")).click();

	}

	public void stockInformation() throws Throwable {

		driveR.findElement(
				By.xpath("//android.widget.TextView[@text='Stock Information' or @text='STOCK INFORMATION']")).click();

	}

	public void stock() throws Throwable {
		Thread.sleep(3000);
		driveR.findElement(By.xpath("//android.widget.TextView[@text='Stock' or @text='STOCK']")).click();
	}

	public void clickListview() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='" + env + ":id/singleItemHeader']"))
				.click();

	}

	public void clickSubmitButton() throws Throwable {
		driveR.findElement(By.xpath("//android.widget.Button[@text='SUBMIT' or @text='Submit']")).click();
	}

	public void clickconfirmSubmit() throws Throwable {
		try {
			driveR.findElement(By.xpath("//android.widget.Button[@text='Submit' or @text='SUBMIT']")).click();
		} catch (Exception e) {
			Thread.sleep(3000);
			driveR.findElement(By.xpath("//android.widget.Button[@text='Submit' or @text='SUBMIT']")).click();
		}
	}

	public void reasoncodeClick(String reasonc) throws Throwable {
		driveR.findElement(By.xpath("//android.widget.TextView[@text='" + reasonc + "']")).click();
	}

	public void sucessMessage(String message) throws Throwable {
		WebElement toastView = driveR.findElement(By.xpath("//android.widget.Toast[1]"));

		String sucessmess = toastView.getAttribute("text");
		System.out.println("Toast message: "+sucessmess);
//		String sucessmess = driveR.findElement(By.xpath("//android.widget.TextView[@text='" + message.trim() + "']"))
//				.getText();
		Thread.sleep(1000);
		System.out.println("SuccessMsg: "+sucessmess);
		Assert.assertEquals(sucessmess, message);
	}

	public void clickCrossButton() throws Throwable {
		driveR.findElement(By.className("android.widget.ImageButton")).click();
	}

	public void autoSaveMessage(String message) throws Throwable {

		String sucessmess = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']"))
				.getText();
		System.out.println(sucessmess);
		assertEquals(sucessmess, message);

		driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();

	}

	public void resumeNeweMessage(String messagee) throws Throwable {

		String sucessmess = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']"))
				.getText();
		System.out.println(sucessmess);
		assertEquals(sucessmess, messagee);

	}

	public void clickOptionNew() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.Button[@text='NEW' or @text='New']")).click();

	}

	public void clickOptionResume() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.Button[@text='RESUME' or @text='Resume']")).click();
	}

	public void verifyProduct(String product) throws Throwable {

		String productscreenv = driveR
				.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/value']")).getText();
		System.out.println(productscreenv);
		assertEquals(productscreenv, product);

	}

	public void StockAdjustmentHomeScreen() throws Throwable {
		Thread.sleep(1000);

		String sahomescreen = driveR
				.findElement(
						By.xpath("//android.widget.TextView[@text='Stock Adjustments' or @text='STOCK ADUJSTMENTS']"))
				.getText();
		Thread.sleep(1000);
		String expected = "Stock Adjustments";
		assertEquals(sahomescreen, expected);

	}

	public void HomeScreen() throws Throwable {

//		String smahomescreen = driveR
//				.findElement(By.xpath("//android.widget.TextView[@text='Select one of the options below']")).getText();
		List<WebElement> eListEle = driveR.findElements(By.xpath("//android.widget.LinearLayout"));
		String smahomescreen = eListEle.get(6).findElement(By.xpath("//android.widget.TextView")).getText();
		String expected = "Stock Management Applications";
		assertEquals(smahomescreen, expected);

	}

	public void verifyReasncodeAndCount(String reasoncode, String quantity) throws Throwable {

		String reasoncodee = driveR
				.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tv_stock_status']"))
				.getText();
		System.out.println("reason code found --------" + reasoncodee);
		String expected = reasoncode;
		assertEquals(reasoncodee, expected);

		String quantityy = driveR
				.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/tv_adjustment_count']"))
				.getText();
		System.out.println("quantity expected --------" + quantityy);
		String expectedd = quantity + " Single(s)";
		assertEquals(quantityy, expectedd);

	}
	
	//Wastage
	public void clickYes() {
		driveR.findElement(By.xpath("//android.widget.Button[@text='YES' or @text='Yes']")).click();

	}
	
	public void verifyKGDisplayed() {
		driveR.findElement(By.xpath("//android.widget.TextView[@text='KG' or @text='Kg']")).isDisplayed();
	}

	public void verifyWeightproductMessage(String msg) {
		String weightprodutMsg = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']"))
				.getText();
		Assert.assertEquals(weightprodutMsg, msg, "Message did not matched");

	}
}
