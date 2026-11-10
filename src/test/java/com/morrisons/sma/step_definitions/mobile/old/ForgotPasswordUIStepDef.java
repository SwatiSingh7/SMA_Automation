package com.morrisons.sma.step_definitions.mobile.old;

import io.cucumber.java.en.When;
import com.morrisons.sma.page_objects.mobile.old.ForgotPasswordPO;

public class ForgotPasswordUIStepDef {

	ForgotPasswordPO forgotPasswordPage = new ForgotPasswordPO();
	
	@When("I verify Forgot password link is displayed")
	public void verifyForgotPasswordLink() throws Throwable {
		forgotPasswordPage.verifyForgotPasswordLink();
	}
	
	@When("I click on Forgot password link")
	public void clickOnForgotPasswordLink() throws Throwable {
		forgotPasswordPage.clickOnForgotPasswordLink();
	}
	
	@When("I verify Forgot password page")
	public void verifyForgotPasswordPage() throws Throwable {
		forgotPasswordPage.verifyForgotPasswordPage();
	}
	
	@When("I verify Change password link is displayed")
	public void verifyChangePassword() throws Throwable {
		forgotPasswordPage.verifyChangePassword();
	}
	
	@When("I click on Change password link")
	public void clickOnChangePassword() throws Throwable {
		forgotPasswordPage.clickOnChangePassword();
	}
	
	@When("I verify Change password page")
	public void verifyChangePasswordPage() throws Throwable {
		forgotPasswordPage.verifyChangePasswordPage();
	}
	
	@When("I click on Navigation bar icon")
	public void clickOnNavigationBar() throws Throwable {
		forgotPasswordPage.clickOnNavigationBar();
	}
}
