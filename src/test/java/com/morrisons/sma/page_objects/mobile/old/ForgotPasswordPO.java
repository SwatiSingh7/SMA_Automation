package com.morrisons.sma.page_objects.mobile.old;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.android.AndroidDriver;
import com.morrisons.common.action.Hook;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;

public class ForgotPasswordPO {

	private static AndroidDriver driveR;
	public static Map<String, String> headers = new HashMap<>();
	static ObjectMapper objectMapper = new ObjectMapper();
	static ObjectMapper objectMapper1 = new ObjectMapper();
	public static HttpResponse Response;
	public static io.restassured.response.Response restResponse;

	static String accessTocken;
	public static URI currentUri;
	public static String mDAccessTocken;

	String env = applicationConfig.getWebElementEnviroment().getEnv();

	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
	String collegueUsername = applicationConfig.getUserCredentials().getCollegueUsername();
	String colleguePassword = applicationConfig.getUserCredentials().getColleguePassword();
	String managerUsername = applicationConfig.getUserCredentials().getManagerUsername();
	String managerPassword = applicationConfig.getUserCredentials().getManagerPassword();

	public ForgotPasswordPO() {
		this.driveR = (AndroidDriver) Hook.getDriver();
	}
	
	public void clickOnNavigationBar() throws Throwable{
		WebElement xpathNavigationBar = driveR.findElement(By.xpath("//android.widget.ImageButton[@index='0']"));
		xpathNavigationBar.isDisplayed();
		xpathNavigationBar.click();
		Thread.sleep(500);
	}
	
	public void verifyForgotPasswordLink() throws Throwable{
		WebElement xpathForgotPassword = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/forgot_password']"));
		xpathForgotPassword.isDisplayed();

		Thread.sleep(500);
	}
	
	public void clickOnForgotPasswordLink() throws Throwable{
		WebElement xpathForgotPassword = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/forgot_password']"));
		xpathForgotPassword.click();

		Thread.sleep(500);
	}
	
	public void verifyForgotPasswordPage() throws Throwable{
		WebElement xpathForgotPassword = driveR.findElement(By.xpath("//android.widget.TextView[@text='Forgot Password' or @text='FORGOT PASSWORD']"));
	xpathForgotPassword.isDisplayed();
		WebElement xpathEnterUsername = driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='"+env+":id/recover_password_username_input']"));
		xpathEnterUsername.isDisplayed();
		WebElement xpathSubmitButton = driveR.findElement(By.xpath("//android.widget.Button[@text='SUBMIT' or @text='Submit']"));
		xpathSubmitButton.isDisplayed();
	}
	
	public void verifyChangePassword() throws Throwable{
		WebElement xpathChangePassword = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/change_password']"));
		xpathChangePassword.isDisplayed();

		Thread.sleep(500);
	}
	
	public void clickOnChangePassword() throws Throwable{
		WebElement xpathChangePassword = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/change_password']"));
		xpathChangePassword.click();

		Thread.sleep(500);
	}
	
	public void verifyChangePasswordPage() throws Throwable{
		WebElement xpathCurrentPassword = driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='"+env+":id/password_old_input']"));
		xpathCurrentPassword.isDisplayed();
		WebElement xpathNewPassword = driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='"+env+":id/password_new_input']"));
		xpathNewPassword.isDisplayed();
		WebElement xpathConfirmNewPassword = driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='"+env+":id/password_new_confirmation_input']"));
		xpathConfirmNewPassword.isDisplayed();
		
		WebElement xpathSubmitButton = driveR.findElement(By.xpath("//android.widget.Button[@text='CHANGE PASSWORD' or @text='Change Password']"));
		xpathSubmitButton.isDisplayed();
	}
}