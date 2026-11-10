package com.morrisons.sma.step_definitions.mobile;

import com.morrisons.common.helper.FileHelper;
import com.morrisons.sma.page_objects.mobile.old.AWS_S3Upload;
import com.morrisons.sma.page_objects.mobile.old.LoginPagePO;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef {

    LoginPagePO loginPage = new LoginPagePO();

    @When("I enter Username and Password for SMA Collegue user")
    public void iEnterCollegueCredentials() throws Throwable {
        loginPage.enterCollegueCredentials();
    }

    @When("I enter Username and Password for SMA Manager user")
    public void iEnterManagerCredentials() throws Throwable {
        loginPage.enterManagerCredentials();
    }

    @When("I click on login button for SMA")
    public void iClickOnLoginButtonForSma() throws Throwable {
        loginPage.clickOnLogin();
        Thread.sleep(2000);
    }
    @When("I enter Username and Password for Twilight Manager user")
    public void iEnterTwilightManagerCredentials() throws Throwable {
        loginPage.enterTwilightManagerCredentials();
    }



}

