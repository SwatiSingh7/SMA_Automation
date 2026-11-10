package com.morrisons.sma.step_definitions.service.old;

import com.morrisons.common.helper.FileHelper;
import com.morrisons.common.utility.ApplicationContext;
import com.morrisons.common.utility.WebServicesRetry;
import com.morrisons.common.utility.WebServicesUtilities;

import com.morrisons.sma.page_objects.mobile.old.AWS_S3Upload;
import com.morrisons.sma.page_objects.service.StorewalkServicePage;
import com.morrisons.sma.step_definitions.service.Product.API_ServiceStepDef;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//import static com.morrisons.common.helper.ElementRetry.log;
import static com.morrisons.common.utility.ApplicationContext.applicationConfig;
import static com.morrisons.sma.step_definitions.mobile.old.CountPostStepDefService.postCountBody;
import static com.morrisons.sma.step_definitions.service.Product.API_ServiceStepDef.Base_SERVICE_BASE_URL;

public class opticFocalStrategies {
    private static final Logger log = Logger.getLogger(opticFocalStrategies.class);
    public static Map<String, String> headers = new HashMap<>();
    private static String JOB_STATUS_BASE_URL = null;
    WebServicesRetry webServicesRetry=new WebServicesRetry();
    private final ApplicationContext applicationContext;
    String jsonResponseString;
    public static String jsonGETResponseString;
    public static String STOCK_ORDER_BASE_URL = null;
    public static final String STOCK_ORDER_BASE_URL_UAT = "https://uat.api.morrisons.com";

    public static final String STOCK_ORDER_BASE_URL_SIT = "https://sit.api.morrisons.com";

    public opticFocalStrategies(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Before
    public void InitializeEnv() {
        String env = applicationConfig.getWebElementEnviroment().getEnv();
        if (env.equalsIgnoreCase("com.morrisons.instore.uat")) {
            STOCK_ORDER_BASE_URL = STOCK_ORDER_BASE_URL_UAT;
        } else if (env.equalsIgnoreCase("com.morrisons.instore.sit")) {
            STOCK_ORDER_BASE_URL = STOCK_ORDER_BASE_URL_SIT;
        }
        String[] sEnv = env.split("[.]");
        env = sEnv[sEnv.length-1];
        JOB_STATUS_BASE_URL = "https://" + env + "-api.morrisons.com";
    }
    @Given("I create a Job for stockorder {string}")
    public void iCreateAJobForStockorder(String arg0) throws Throwable {
        String accessToken = StorewalkServicePage.getGeneratedAccessTokenAppLogin();  ///Getting generated access token

        String Header1Key = "Authorization";
        headers.put(Header1Key, "Bearer " + accessToken);
        headers.put("Content-Type", "application/json");
        System.out.println(headers);

        System.out.println("headers are\t" + headers);
       // System.out.println("payload details is 2 = " + postCountBody);
        String filePath="/json-files/service/Optics/StoreOrders.json";
        //applicationContext.templateMap.put("itemNumber",item);
        org.json.simple.JSONObject objectJSON = new WebServicesUtilities().parseJSON(filePath, applicationContext.templateMap);
         String body = objectJSON.toString();
        String postResponseString = WebServicesUtilities.retryPOSTRequest(STOCK_ORDER_BASE_URL, "/stockorder/v1/jobs?location=" + ApplicationContext.STORE_ID, "apikey", "ZwQGsEN0f65kORZ8EVQlJWA2bGNbHls0", "Authorization","Bearer " + accessToken, body);
    }

    @Then("I Verify the Response Code for the following {string} is 200")
    public void iVerifyTheJobIdForTheFollowing(String arg0) {
        String body = jsonGETResponseString;
        int productAPIResponseCode;
        Integer responseCode=webServicesRetry.responseCode;
        log.info("Response body=========="+body);
        try {
            JSONObject obj = new JSONObject(jsonGETResponseString);
            productAPIResponseCode = obj.getInt("httpResponseCode");
        }
        catch(JSONException js){
            productAPIResponseCode=responseCode;
        }
//creating an object of JSONObject class and casting the object into JSONObject type
//getting values form the JSONObject and casting that values into corresponding types

//printing the values
        System.out.println("responseCode: "+productAPIResponseCode);
        Assert.assertEquals(productAPIResponseCode,200);
    }

    @Given("I hit the get end point")
    public void iHitTheGetEndPoint() throws Throwable {
        log.info("Getting Response for " + JOB_STATUS_BASE_URL + "/items/");
        String accessToken = StorewalkServicePage.getGeneratedAccessTokenAppLogin();  ///Getting generated access token

        String Header1Key = "Authorization";
        headers.put(Header1Key, "Bearer " + accessToken);
        headers.put("Content-Type", "application/json");
        System.out.println(headers);

        System.out.println("headers are\t" + headers);
        System.out.println("payload details is 2 = " + postCountBody);
        jsonGETResponseString = WebServicesUtilities.retryGETRequestWithout(JOB_STATUS_BASE_URL, "/stockorder/v1/jobs/23764/status?" , "apikey", "AGyQZFUGD1CpY028eGGaFWaMrd4VBjVf", "Authorization", "Bearer " + accessToken);
    }

    @Then("I Verify the response is successful")
    public void iVerifyTheResponseIsSuccessful() {
        String body = jsonGETResponseString;
        Integer responseCode=webServicesRetry.responseCode;
        log.info("Response body=========="+body);

        JSONObject obj = new JSONObject(jsonGETResponseString);
//creating an object of JSONObject class and casting the object into JSONObject type
//getting values form the JSONObject and casting that values into corresponding types
        int productAPIResponseCode;
        if(responseCode.toString().equals("404")) {
            productAPIResponseCode = obj.getInt("httpResponseCode");
        }
        else {
            productAPIResponseCode=200;
        }
//printing the values
        System.out.println("responseCode: "+productAPIResponseCode);
    }

    @Given("I get the job status for the following {string} and {string} and {string}")
    public void iGetTheSpaceDetailsForTheFollowingAnd(String arg0, String arg1, String param) throws Throwable {

        String[] arrParam = param.split("=");
        String param1, paramVal;
        param = arrParam[0];
        paramVal = arrParam[1];
        String endpoint = "/stock/v2/jobs/" + API_ServiceStepDef.sRespData.get("jobId") + "/status";
        jsonGETResponseString = WebServicesUtilities.retryGETRequestWithHeader(JOB_STATUS_BASE_URL,  endpoint,"apikey", "1rQlOAe1PAWaWLHlShKfhhUn8rODH8AK",param,paramVal,"Authorization", "Basic MXJRbE9BZTFQQVdhV0xIbFNoS2ZoaFVuOHJPREg4QUs6Y2ZVN29WQ3hYWUVIUW1WdQ==");
    }

    @And("I Verify the file is generated in  allocated S{int} bucket")
    public void iVerifyTheFileIsGeneratedInAllocatedSBucket(int arg0) throws IOException, InterruptedException {
        //API_ServiceStepDef oObj = new API_ServiceStepDef(applicationContext);
        FileHelper fFileUpdate = new FileHelper();
        String sCurrentDate1 = fFileUpdate.readAndUpdateDATFile();
        ApplicationContext.oKeyField.put("file", sCurrentDate1);
        AWS_S3Upload oAWSObj = new AWS_S3Upload();
        oAWSObj.getS3Uploader(sCurrentDate1);

    }

    @Given("I Verify the file naming convention generated in S{int} bucket")
    public void iVerifyTheFileNamingConventionGeneratedInSBucket(int arg0) throws IOException {
        FileHelper fFileUpdate = new FileHelper();
        String sCurrentDate1 = fFileUpdate.readAndUpdateDATFile();
        ApplicationContext.oKeyField.put("file", sCurrentDate1);
        AWS_S3Upload oAWSObj = new AWS_S3Upload();
        oAWSObj.getS3Uploader(sCurrentDate1);
    }

    @Given("I get the job status for the following Focal {string} and {string}")
    public void iGetTheJobStatusForTheFollowingFocalAndAnd(String EndPoint, String arg1) throws IOException, InterruptedException {
        EndPoint = EndPoint.replace("{store_code}",ApplicationContext.STORE_ID);
        jsonGETResponseString = WebServicesUtilities.retryGETRequestWithHeader("",EndPoint,"apikey", "da569557-0f3d-45ad-9737-f16d4e2190df","Authorization", "Bearer 7M6Yk5tO3mq1UUTVJ7Wo8zGdctvUo6ZPHlcH2zBItG1yWKoznlKGSxPV9QqZtb2vngESr9wHeaXp11243BeSEWLtiz0YWgCQH8rrOyCgWnw8mDvs");
    }

    @Given("I post the job status for the following Focal {string} and {string}")
    public void iPostTheJobStatusForTheFollowingFocalAnd(String EndPoint, String arg1) throws ParseException, IOException, InterruptedException {
        String filePath="/json-files/service/Optics/focalResp.json";
        //applicationContext.templateMap.put("itemNumber",item);
        org.json.simple.JSONObject objectJSON = new WebServicesUtilities().parseJSON(filePath, applicationContext.templateMap);
        String body = objectJSON.toString();
        EndPoint = EndPoint.replace("{store_code}",ApplicationContext.STORE_ID);
        jsonGETResponseString = WebServicesUtilities.retryPOSTRequest("",EndPoint, "apikey", "da569557-0f3d-45ad-9737-f16d4e2190df", "Authorization","Bearer 7M6Yk5tO3mq1UUTVJ7Wo8zGdctvUo6ZPHlcH2zBItG1yWKoznlKGSxPV9QqZtb2vngESr9wHeaXp11243BeSEWLtiz0YWgCQH8rrOyCgWnw8mDvs", body);
    }

    @Given("I hit the post api for the following {string} and {string} and {string} based on Response code for data {string}")
    public void iHitThePostApiForTheFollowingAndAndBasedOnResponseCodeForData(String EndPoint, String sapikey, String arg2, String sReqData) throws IOException, InterruptedException, ParseException {
       //            String body = jsonGETResponseString;
        String filePath = "/json-files/service/Space.json";
        API_ServiceStepDef oAPIServ = new API_ServiceStepDef(applicationContext);
        String body = oAPIServ.createProductBody("", sReqData, filePath);
        Thread.sleep(1000);
        jsonGETResponseString = WebServicesUtilities.retryPOSTRequest(Base_SERVICE_BASE_URL,EndPoint, "apikey", sapikey, "Authorization","Basic a1dRNmd5ck9HUDBOQTJmUkFmdkpUSFZhY2ZiOUM5NUc6eExyOGhRRGt0Z2hwUFdjQQ==", body);
    }
}
