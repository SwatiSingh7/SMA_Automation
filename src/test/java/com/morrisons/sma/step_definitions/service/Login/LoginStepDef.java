package com.morrisons.sma.step_definitions.service.Login;

import com.google.inject.Inject;
import com.morrisons.common.utility.ApplicationContext;
import com.morrisons.common.utility.WebServicesUtilities;
import com.morrisons.sma.page_objects.service.login_new.LoginService;
import io.cucumber.java.en.Given;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class LoginStepDef {
    public static final String LOGIN_SERVICE_BASE_URL = "https://sit-api.morrisons.com/user/v1/";
    private static final Logger log = Logger.getLogger(LoginStepDef.class);
    private final ApplicationContext applicationContext;
    public static final String LOGIN_SERVICE_BASE_URL_UAT = "https://uat-api.morrisons.com/user/v1/";

    public static String accessToken;

    @Inject
    public LoginStepDef(ApplicationContext applicationContext) {

        this.applicationContext = applicationContext;
    }

    @Given("I get login response through API for {string}")
    public void iGetTheLoginResponse(String filePath) throws IOException, InterruptedException, ParseException {
        log.info("Getting Response for " + LOGIN_SERVICE_BASE_URL + "login");

        JSONObject jsonObject = new WebServicesUtilities().parseJSON(filePath, applicationContext.templateMap);
        String body = jsonObject.toString();
        String jsonResponseString = WebServicesUtilities.retryPOSTRequest(LOGIN_SERVICE_BASE_URL, "login", "apikey", "ZwQGsEN0f65kORZ8EVQlJWA2bGNbHls0", body);
        accessToken = new LoginService().getLoginResponse(jsonResponseString).getAccessToken();
        log.info("ACCESS TOKEN : " + accessToken);
    }

    @Given("I get login response for Count Optimization through API for {string}")
    public void iGetTheLoginResponseforCountOptimization(String filePath) throws IOException, InterruptedException, ParseException {
        log.info("Getting Response for " + LOGIN_SERVICE_BASE_URL_UAT + "login");
        JSONObject jsonObject = new WebServicesUtilities().parseJSON(filePath, applicationContext.templateMap);
        String body = jsonObject.toString();
        System.out.println("body " + body);
        String jsonResponseString = WebServicesUtilities.retryPOSTRequest(LOGIN_SERVICE_BASE_URL_UAT, "login", "apikey", "ZwQGsEN0f65kORZ8EVQlJWA2bGNbHls0", body);
        System.out.println("jsonResponseString = " + jsonResponseString);
        accessToken = new LoginService().getLoginResponse(jsonResponseString).getAccessToken();
        log.info("ACCESS TOKEN : " + accessToken);
    }
}


