package com.morrisons.sma.page_objects.service.login;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.morrisons.common.helper.WebServiceHelper;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import com.morrisons.sma.pojo.service.login.GetLogin;
import com.morrisons.sma.pojo.service.login.PostLogin;

public class LoginPO {

    public static Map<String, String> headers = new HashMap<>();
    static ObjectMapper objectMapper = new ObjectMapper();
    public static HttpResponse Response;
    public static io.restassured.response.Response restResponse;

    private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
    private final String collegueUsername = applicationConfig.getUserCredentials().getCollegueUsername();
    private final String colleguePassword = applicationConfig.getUserCredentials().getColleguePassword();
    private final String managerUsername = applicationConfig.getUserCredentials().getManagerUsername();
    private final String managerPassword = applicationConfig.getUserCredentials().getManagerPassword();

    private final String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
    private final String resource = applicationConfig.getPostUserLogin().getResource();
    private final String queryparameter = applicationConfig.getPostUserLogin().getQueryParameter();

    public static URI currentUri;
    private final Logger log = Logger.getLogger(LoginPO.class);
    public static String loginBody = null;
    public static HttpResponse httpResponse = null;
    public static String accessTocken = null;

    public static GetLogin getLoginJsonResponse = new GetLogin();

    public void postLoginBody(String user) throws Throwable{
        log.info("Post login request to : " + user +" user");

        String username = null;
        String password = null;

        switch(user){
            case "Collegue":

                username = collegueUsername;
                password = colleguePassword;
                break;

            case "Manager":
                username = managerUsername;
                password = managerPassword;
                break;


            default:
                log.error("No such user : " + user);
                Assert.fail("No Such user : " + user);
        }

        PostLogin postLoginBody = new PostLogin();
        postLoginBody.setUserName(username);
        postLoginBody.setPassword(password);
        postLoginBody.setProvider("morrisons");

        loginBody = objectMapper.writeValueAsString(postLoginBody);
        log.info("Payload body is " + loginBody);
    }


    public void createLoginUrl() throws URISyntaxException {

        currentUri = WebServiceHelper.createURL(baseURI,resource,queryparameter);
    }


    public HttpResponse getResponse() throws ClientProtocolException, IOException {
        headers = WebServiceHelper.contentTypeHeader();

        if (currentUri != null)
            httpResponse = WebServiceHelper.postMethodResponse(currentUri, headers, loginBody);
        else {
            log.error("URL value is missing. Please send valid URL to perform operation");
            Assert.fail("URL value is missing. Please send valid URL to perform operation");
        }
        return httpResponse;
    }

    public void loginUserServiceResponse() throws Throwable {
        getLoginJsonResponse = objectMapper.readValue(httpResponse.getEntity().getContent(), GetLogin.class);
        String loginJsonData = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(getLoginJsonResponse);
        log.info("Get Range Response:\n" + loginJsonData);

        accessTocken = getLoginJsonResponse.getAccessToken();
        log.info("Access Token " + accessTocken);
    }

}
