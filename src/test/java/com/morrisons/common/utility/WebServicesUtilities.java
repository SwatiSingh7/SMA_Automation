package com.morrisons.common.utility;

import com.morrisons.sma.page_objects.mobile.old.DynamicRequestMethods;
import com.morrisons.sma.step_definitions.service.Product.API_ServiceStepDef;
import com.morrisons.sma.step_definitions.service.old.opticFocalStrategies;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.comparator.CustomComparator;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import static com.morrisons.common.utility.ApplicationContext.applicationConfig;

public class WebServicesUtilities {
    private static final Logger log = Logger.getLogger(WebServicesUtilities.class);
    public static int expecteResponseCode = 200;

    @SuppressWarnings("deprecation")
    public static int getStatusCode(String restURL) throws ClientProtocolException, IOException {
        int statusCode = 0;
		/*HttpUriRequest request = new HttpGet(restURL);
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		statusCode = httpResponse.getStatusLine().getStatusCode();*/
        @SuppressWarnings("deprecation")
        DefaultHttpClient httpClient = new DefaultHttpClient();
        try {
            //Define a HttpGet request; You can choose between HttpPost, HttpDelete or HttpPut also.
            //Choice depends on type of method you will be invoking.
            HttpGet getRequest = new HttpGet(restURL);

            //Set the API media type in http accept header
            getRequest.addHeader("accept", "application/xml");

            //Send the request; It will immediately return the response in HttpResponse object
            HttpResponse response = httpClient.execute(getRequest);

            //verify the valid error code first
            statusCode = response.getStatusLine().getStatusCode();
        } finally {
            //Important: Close the connect
            httpClient.getConnectionManager().shutdown();
        }
        return statusCode;
        //Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(),HttpStatus.SC_OK);
    }

    public static String getContent(String restURL, String element, int itemIndex) throws ClientProtocolException, IOException, SAXException, ParserConfigurationException {
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(restURL);
        NodeList nodelist = doc.getElementsByTagName(element);
        return nodelist.item(0).getTextContent();
        //Assert.assertEquals(expectedValue,nodelist.item(0).getTextContent());
    }

//    public static void getContentJSON(String restURL, String element) throws ClientProtocolException, IOException,  JSONException {
//        HttpUriRequest request = new HttpGet(restURL);
//        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
//        // Convert the response to a String format
//        String result = EntityUtils.toString(httpResponse.getEntity());
//         //Convert the result as a String to a JSON object
//        JSONObject jo = new JSONObject(result);
//        return jo.getString(element);
//        Assert.assertEquals(expectedValue, jo.getString(element));
//
//    }

//    /*
//Can be either of these values :
//Extensible Strict Ordering
//STRICT no yes
//LENIENT yes no
//NON_EXTENSIBLE no no
//STRICT_ORDER yes yesIf extensbility not allowed, then all of the expected values must match in what's being tested, but any additional fields will cause the test to fail. When extensibility is allowed, all values must still match. For example, if you're expecting:{id:1,name:"Carter"}
//Then the following will pass when extensible, and will fail when not:{id:1,name:"Carter",favoriteColor:"blue"}
//If strict ordering is enabled, JSON arrays must be in strict sequence. For example, if you're expecting:{id:1,friends:[{id:2},{id:3}]}
//Then the following will fail strict ordering, but will otherwise pass:{id:1,friends:[{id:3},{id:2}]}
//*/
//    public void jsonCompare(String expectedJSON, String actualJSON, CustomComparator applicationCustomizations) {
//        JSONAssert.assertEquals(expectedJSON, actualJSON, applicationCustomizations);
//    }


    public static String retryGETRequest(String basURL, String endpoint) throws IOException, InterruptedException {
        RequestSpecification request = RestAssured.given().header("Content-Type", "application/json").when();
        Response response = WebServicesRetry.retryGet(basURL + endpoint, request, 200, 5);
        log.info("Successful");
        String jsonResponseString = response.getBody().jsonPath().prettify();
        log.info("Response : " + jsonResponseString);
        return jsonResponseString;
    }

    public static String retryGETRequest(String basURL, String endpoint, String param1, String value1) throws IOException, InterruptedException {
        RequestSpecification request = RestAssured.given().queryParam(param1, value1).header("Content-Type", "application/json").when();
        log.info("request" + request);

        Response response = WebServicesRetry.retryGet(basURL + endpoint, request, 200, 5);
        log.info("Successful");
        String jsonResponseString = response.getBody().jsonPath().prettify();
        log.info("Response : " + jsonResponseString);
        return jsonResponseString;
    }

    public static String retryGETRequest(String basURL, String endpoint, String param1, String value1, String headerParam1, String headerValue1) throws IOException, InterruptedException {
        RequestSpecification request = RestAssured.given().queryParam(param1, value1).header(headerParam1, headerValue1).header("Content-Type", "application/json").when();
        log.info("request" + request);

        Response response = WebServicesRetry.retryGet(basURL + endpoint, request, 200, 5);
        log.info("Successful");
        String jsonResponseString = response.getBody().jsonPath().prettify();
        log.info("Response : " + jsonResponseString);
        return jsonResponseString;
    }

    public static String retryGETRequestWithHeader(String basURL, String endpoint, String param1, String value1, String param2, String value2, String param3, String value3, String headerParam1, String headerValue1) throws IOException, InterruptedException {
        RequestSpecification request = RestAssured.given().queryParam(param1, value1).queryParam(param2, value2).queryParam(param3, value3).header(headerParam1, headerValue1).header("Content-Type", "application/json").when();
        Response response = WebServicesRetry.retryGet(basURL + endpoint, request, 200, 5);
        log.info("Successful");
        String jsonResponseString = response.getBody().jsonPath().prettify();
     //   log.info("Response : " + jsonResponseString);
        return jsonResponseString;
    }

    public static String retryGETRequestWithHeader(String basURL, String endpoint, String param1, String value1, String param2, String value2, String param3, String value3,String param4, String value4,String param5, String value5, String headerParam1, String headerValue1) throws IOException, InterruptedException {
        System.out.println("Base url: " + basURL + endpoint );
        System.out.println("param1: " + param1 + "param2" + param2 + "param3: " + param3 + "param4: " + param4 + "param5: " + param5);
        System.out.println("value1: " + value1 + "value2" + value2 + "value3: " + value3 + "value4: " + value4 + "value5: " + value5);
        System.out.println("headerParam1: " + headerValue1);
        RequestSpecification request = RestAssured.given().queryParam(param1, value1).queryParam(param2, value2).queryParam(param3, value3).queryParam(param4, value4).queryParam(param5, value5).header(headerParam1, headerValue1).header("Content-Type", "application/json").when();
       // System.out.println("RequestSpecification " + request.put("https://uat-api.morrisons.com/stockorder/v1/customers/morrisons/orders?location=8&item=102371339&type=StoreStandard&orders=[last,current,next]&apikey=L7W2294UoOujnJHjkw1Cmlu9AiVMjog6"));
        Response response = WebServicesRetry.retryGet(basURL + endpoint, request, 200, 5);
        String jsonResponseString;
        log.info("Successful");
        try{
            jsonResponseString = response.getBody().jsonPath().prettify();
        }
        catch(Exception e) {
            jsonResponseString = response.getBody().print();
        }
        System.out.println(jsonResponseString);
       // log.info("Response : " + jsonResponseString);
        return jsonResponseString;
    }


    public static String retryGETRequestWithHeader(String basURL, String endpoint, String param1, String value1, String headerParam1, String headerValue1) throws IOException, InterruptedException {
        RequestSpecification request = RestAssured.given().queryParam(param1, value1).header(headerParam1, headerValue1).header("Content-Type", "application/json").when();
        Response response = WebServicesRetry.retryGet(basURL + endpoint, request, 200, 5);
        log.info("Successful");
        String jsonResponseString = response.getBody().jsonPath().prettify();
        log.info("Response : " + jsonResponseString);
        return jsonResponseString;
    }

    public static String retryGETRequestWithHeader(String basURL, String endpoint, String param1, String value1, String param2, String value2, String headerParam1, String headerValue1) throws IOException, InterruptedException {
        RequestSpecification request = RestAssured.given().queryParam(param1, value1).queryParam(param2, value2).header(headerParam1, headerValue1).header("Content-Type", "application/json").when();
        log.info("request" + request);

        Response response = WebServicesRetry.retryGet(basURL + endpoint, request, 200, 5);
        log.info("Successful");
        String jsonResponseString = response.getBody().jsonPath().prettify();
        log.info("Response : " + jsonResponseString);
        return jsonResponseString;
    }

    public static String retryGETRequestWithHeader(String basURL, String endpoint, String param1, String value1, String param2, String value2, String param3, String value3, String param4, String value4, String param5, String value5, String headerParam1, String headerValue1, int expecteResponseCode) throws IOException, InterruptedException, RuntimeException {
        RequestSpecification request = RestAssured.given().queryParam(param1, value1).queryParam(param2, value2).queryParam(param3, value3).queryParam(param4, value4).queryParam(param5, value5).header(headerParam1, headerValue1).when();
        Response response;

        response = WebServicesRetry.retryGet(basURL + endpoint, request, expecteResponseCode, 5);
        log.info("Successful");
        String jsonResponseString = response.getBody().jsonPath().prettify();
        log.info("Response : " + jsonResponseString);
        return jsonResponseString;

    }


    public static String retryPOSTRequest(String basURL, String endpoint, String param1, String value1, String body) throws IOException, InterruptedException {
        RequestSpecification request = RestAssured.given().header("Content-Type", "application/json").queryParam(param1, value1).when();
        request.body(body);
        Response response = WebServicesRetry.retryPOST(basURL + endpoint, request, 200, 5);
        log.info("Successful");
        String jsonResponseString = response.getBody().jsonPath().prettify();
        log.info("Response : " + jsonResponseString);
        return jsonResponseString;
    }

    public static String retryPOSTRequest_Text(String basURL, String endpoint, String param1, String value1, String body) throws IOException, InterruptedException {
        RequestSpecification request = RestAssured.given().config(RestAssured.config().encoderConfig(EncoderConfig.encoderConfig().encodeContentTypeAs("x-www-form-urlencoded", ContentType.URLENC))).contentType("application/x-www-form-urlencoded; charset=UTF-8").queryParam(param1, value1).when();
        request.body(body);
        Response response = WebServicesRetry.retryPOST(basURL + endpoint, request, 200, 5);
        log.info("Successful");
        String jsonResponseString = response.getBody().jsonPath().prettify();
        log.info("Response : " + jsonResponseString);

        return jsonResponseString;
    }

    public static String retryPOSTRequest1(String basURL, String endpoint, String param1, String value1, String body) throws IOException, InterruptedException {
        RequestSpecification request = RestAssured.given().header("Content-Type", "application/json").queryParam(param1, value1).when();
        request.body(body);
        System.out.println("body in post request " + body);
        Response response = WebServicesRetry.retryPOST1(basURL + endpoint, request, 200, 5);
        log.info("Successful");
        String jsonResponseString = response.getBody().jsonPath().prettify();
        log.info("Response : " + jsonResponseString);
        return jsonResponseString;
    }

    public static String retryPOSTRequest(String basURL, String endpoint, String param1, String value1) throws IOException, InterruptedException {
        RequestSpecification request = RestAssured.given().header("Content-Type", "application/json").when();
        JSONObject requestParams = new JSONObject();
        requestParams.put(param1, value1); // Cast
        request.body(requestParams.toString());
        Response response = WebServicesRetry.retryPOST(basURL + endpoint, request, 201, 5);
        log.info("Successful");
        String jsonResponseString = response.getBody().jsonPath().prettify();
        log.info("Response : " + jsonResponseString);
        return jsonResponseString;
    }

    public static String retryPUTRequest(String basURL, String endpoint, String param1, String value1, String param2, String value2) throws IOException, InterruptedException {
        RequestSpecification request = RestAssured.given().header("Content-Type", "application/json").when();
        JSONObject requestParams = new JSONObject();
        requestParams.put(param1, value1); // Cast
        requestParams.put(param2, value2);
        request.body(requestParams.toString());
        Response response = WebServicesRetry.retryPUT(basURL + endpoint, request, 200, 5);
        log.info("Successful");
        String jsonResponseString = response.getBody().jsonPath().prettify();
        log.info("Response : " + jsonResponseString);
        return jsonResponseString;
    }

    public static String retryDELETERequest(String basURL, String endpoint) throws IOException, InterruptedException {
        RequestSpecification request = RestAssured.given().header("Content-Type", "application/json").when();
        //request.body(request.toString());
        Response response = WebServicesRetry.retryDELETE(basURL + endpoint, request, 204, 5);
        log.info("Successful");
        String jsonResponseString = response.getBody().jsonPath().prettify();
        log.info("Response : " + jsonResponseString);
        return jsonResponseString;
    }

    public static String retryDELETERequest(String basURL, String endpoint, String param1, String value1,String headerParam1, String headerValue1) throws InterruptedException {
        RequestSpecification request = RestAssured.given().queryParam(param1, value1).header(headerParam1, headerValue1).when();
        //request.body(request.toString());
        Response response = WebServicesRetry.retryDELETE(basURL + endpoint, request, 204, 5);
        log.info("Successful------------------------------");
//        String jsonResponseString = response.getBody().jsonPath().prettify();
        String jsonResponseString = response.getBody().toString();

        log.info("Response --------------------------------------- " + jsonResponseString);
        return jsonResponseString;




    }

    public static String retryPOSTRequest(String basURL, String endpoint, String param1, String value1,String headerParam1, String headerValue1, String body) throws InterruptedException, IOException {

        log.info("basURL"+basURL);
        log.info("body"+body);
        log.info("headerValue1"+headerValue1);
        log.info("endpoint"+endpoint);
        RequestSpecification request = RestAssured.given().queryParam(param1,value1).header(headerParam1,headerValue1).header("Content-Type", "application/json").when();
        request.body(body);
        Response response = WebServicesRetry.retryPOST(basURL + endpoint, request, 201, 5);
        log.info("request"+response.toString());

        log.info("Successful");
        //String jsonResponseString = response.getBody().jsonPath().prettify();
        String jsonResponseString = response.getBody().asString();
        log.info("Response : " + jsonResponseString);

        return jsonResponseString;

    }

    public static String retryGETRequestWithHeader(String basURL, String endpoint, String param1, String value1, String param2, String value2, String param3, String value3, String param4, String value4, String headerParam1, String headerValue1, int expecteResponseCode) throws InterruptedException {
        RequestSpecification request = RestAssured.given().queryParam(param1, value1).queryParam(param2, value2).queryParam(param3, value3).queryParam(param4, value4).header(headerParam1, headerValue1).when();
        Response response;

        response = WebServicesRetry.retryGet(basURL + endpoint, request, expecteResponseCode, 5);
        log.info("Successful");
        String jsonResponseString = response.getBody().jsonPath().prettify();
        log.info("Response : " + jsonResponseString);
        return jsonResponseString;
    }

    public static String retryGETRequestWithHeader(String basURL, String endpoint, String param1, String value1, String param2, String value2, String param3, String value3, String param4, String value4, String headerParam1, String headerValue1) throws InterruptedException {
        RequestSpecification request = RestAssured.given().queryParam(param1, value1).queryParam(param2, value2).queryParam(param3, value3).queryParam(param4, value4).header(headerParam1, headerValue1).when();
        Response response;

        response = WebServicesRetry.retryGet(basURL + endpoint, request, expecteResponseCode, 5);
        log.info("Successful");
        String jsonResponseString = response.getBody().jsonPath().prettify();
        log.info("Response : " + jsonResponseString);
        return jsonResponseString;
    }

    public static String retryPUTRequestWithout(String basURL, String endpoint, String param1, String value1, String param2, String value2, String param3, String value3, String param4, String value4, String param5, String value5, String headerParam1, String headerValue1) throws InterruptedException {
        {




            log.info("basURL==================================" + basURL+endpoint);
            log.info("param1============================" + value1);
            log.info("headerParam1============================" + headerValue1);
            log.info(value4);


            RequestSpecification request = RestAssured.given().queryParam(param1, value1).queryParam(param2, value2).queryParam(param3, value3).queryParam(param4, value4).header(headerParam1, headerValue1).header("Content-Type", "application/json").when();
            log.info("request" + request);
            Response response = WebServicesRetry.retryPUT(basURL + endpoint, request, 200, 5);
            log.info("Successful");
            String jsonResponseString = response.getBody().toString();
            log.info("Response : " + jsonResponseString);
            return jsonResponseString;


        }
    }

    public static String retryGETRequestWithout(String basURL, String endpoint, String param1, String value1, String param2, String value2, String param3, String value3, String headerParam1, String headerValue1) throws InterruptedException {
        RequestSpecification request = RestAssured.given().queryParam(param1, value1).queryParam(param2, value2).queryParam(param3, value3).header(headerParam1, headerValue1).when();
        Response response;

        response = WebServicesRetry.retryGet(basURL + endpoint, request, expecteResponseCode, 5);
        log.info("Successful");
        String jsonResponseString = response.getBody().jsonPath().prettify();
        log.info("Response : " + jsonResponseString);
        return jsonResponseString;

    }

    public static void createProduct(String item, String sField) throws ParseException, InterruptedException {

        log.info("productAPIResponseCode" + API_ServiceStepDef.productAPIResponseCode);
        if (API_ServiceStepDef.productAPIResponseCode == 200) {
            String env = applicationConfig.getWebElementEnviroment().getEnv();
            log.info("Getting PUT Response for " + API_ServiceStepDef.PRODUCT_SERVICE_BASE_URL + "/items/");
            String body = opticFocalStrategies.jsonGETResponseString;
            try {
                String filePath = "/json-files/service/" + item + ".json";
                ApplicationContext applicationContext = new ApplicationContext();
                API_ServiceStepDef oAPI_Service = new API_ServiceStepDef(applicationContext);
                body = oAPI_Service.createProductBody(item, item, filePath);;
            }
            catch(Exception w){
                String jsonGETResponseStringg7 = WebServicesUtilities.retryGETRequestWithout("https://dev-api.morrisons.com/product/v1", "/items/" + item, "apikey", "AGyQZFUGD1CpY028eGGaFWaMrd4VBjVf", "Authorization", "Basic QUd5UVpGVUdEMUNwWTAyOGVHR2FGV2FNcmQ0VkJqVmY6Vzl5Z1lmR0FwaWptUTdBbQ==");
                if(jsonGETResponseStringg7.isEmpty() && env.contains("sit")){
                    jsonGETResponseStringg7 = WebServicesUtilities.retryGETRequestWithout("https://uat-api.morrisons.com/product/v1", "/items/" + item, "apikey", "AGyQZFUGD1CpY028eGGaFWaMrd4VBjVf", "Authorization", "Basic QUd5UVpGVUdEMUNwWTAyOGVHR2FGV2FNcmQ0VkJqVmY6Vzl5Z1lmR0FwaWptUTdBbQ==");
                }
                if(jsonGETResponseStringg7.isEmpty() && env.contains("uat")){
                    jsonGETResponseStringg7 = WebServicesUtilities.retryGETRequestWithout("https://sit-api.morrisons.com/product/v1", "/items/" + item, "apikey", "AGyQZFUGD1CpY028eGGaFWaMrd4VBjVf", "Authorization", "Basic QUd5UVpGVUdEMUNwWTAyOGVHR2FGV2FNcmQ0VkJqVmY6Vzl5Z1lmR0FwaWptUTdBbQ==");
                }
                if(jsonGETResponseStringg7.isEmpty()){
                    jsonGETResponseStringg7 = WebServicesUtilities.retryGETRequestWithout("https://pre-api.morrisons.com/product/v1", "/items/" + item, "apikey", "AGyQZFUGD1CpY028eGGaFWaMrd4VBjVf", "Authorization", "Basic QUd5UVpGVUdEMUNwWTAyOGVHR2FGV2FNcmQ0VkJqVmY6Vzl5Z1lmR0FwaWptUTdBbQ==");
                }
                body = jsonGETResponseStringg7;
            }

            ArrayList<String> arrList = new ArrayList<String>();
            arrList = DynamicRequestMethods.MapFields(sField);
            ArrayList<String> arrRespdata = DynamicRequestMethods.CaptureResponseData(body, arrList);
            for (int i = 0; i < arrRespdata.size(); i++) {
                arrList = DynamicRequestMethods.MapFields(arrList.get(0));
                ApplicationContext.oKeyField.put(arrList.get(0), arrRespdata.get(i));
                System.out.println(arrList.get(0) + " Captured at runtime: " + arrRespdata.get(i));
            }
            System.out.println(ApplicationContext.oKeyField.get("itemNumber"));
            String postResponseString = WebServicesUtilities.retryPUTRequestWithoutHeader(API_ServiceStepDef.PRODUCT_SERVICE_BASE_URL, "/items/" + item + "?", "apikey", "AGyQZFUGD1CpY028eGGaFWaMrd4VBjVf", "Authorization", "Basic QUd5UVpGVUdEMUNwWTAyOGVHR2FGV2FNcmQ0VkJqVmY6Vzl5Z1lmR0FwaWptUTdBbQ==", body);
        } else {
            String env = applicationConfig.getWebElementEnviroment().getEnv();
            log.info("Creating item record  from existing JSON for " + item);
            log.info("Getting PUT Response for " + API_ServiceStepDef.PRODUCT_SERVICE_BASE_URL + "/items/");
            String body = opticFocalStrategies.jsonGETResponseString;
            try {
                String filePath = "/json-files/service/" + item + ".json";
                ApplicationContext applicationContext = new ApplicationContext();
                API_ServiceStepDef oAPI_Service = new API_ServiceStepDef(applicationContext);
                body = oAPI_Service.createProductBody(item, "item=" + item, filePath);
            }
            catch(Exception w){
                String jsonGETResponseStringg7 = WebServicesUtilities.retryGETRequestWithout("https://dev-api.morrisons.com/product/v1", "/items/" + item, "apikey", "AGyQZFUGD1CpY028eGGaFWaMrd4VBjVf", "Authorization", "Basic QUd5UVpGVUdEMUNwWTAyOGVHR2FGV2FNcmQ0VkJqVmY6Vzl5Z1lmR0FwaWptUTdBbQ==");
                if(jsonGETResponseStringg7.isEmpty() && env.contains("sit")){
                    jsonGETResponseStringg7 = WebServicesUtilities.retryGETRequestWithout("https://uat-api.morrisons.com/product/v1", "/items/" + item, "apikey", "AGyQZFUGD1CpY028eGGaFWaMrd4VBjVf", "Authorization", "Basic QUd5UVpGVUdEMUNwWTAyOGVHR2FGV2FNcmQ0VkJqVmY6Vzl5Z1lmR0FwaWptUTdBbQ==");
                }
                if(jsonGETResponseStringg7.isEmpty() && env.contains("uat")){
                    jsonGETResponseStringg7 = WebServicesUtilities.retryGETRequestWithout("https://sit-api.morrisons.com/product/v1", "/items/" + item, "apikey", "AGyQZFUGD1CpY028eGGaFWaMrd4VBjVf", "Authorization", "Basic QUd5UVpGVUdEMUNwWTAyOGVHR2FGV2FNcmQ0VkJqVmY6Vzl5Z1lmR0FwaWptUTdBbQ==");
                }
                if(jsonGETResponseStringg7.isEmpty()){
                    jsonGETResponseStringg7 = WebServicesUtilities.retryGETRequestWithout("https://pre-api.morrisons.com/product/v1", "/items/" + item, "apikey", "AGyQZFUGD1CpY028eGGaFWaMrd4VBjVf", "Authorization", "Basic QUd5UVpGVUdEMUNwWTAyOGVHR2FGV2FNcmQ0VkJqVmY6Vzl5Z1lmR0FwaWptUTdBbQ==");
                }
                body = jsonGETResponseStringg7;
            }

            ArrayList<String> arrList = new ArrayList<String>();
            arrList = DynamicRequestMethods.MapFields(sField);
            ArrayList<String> arrRespdata = DynamicRequestMethods.CaptureResponseData(body, arrList);
            for (int i = 0; i < arrRespdata.size(); i++) {
                arrList = DynamicRequestMethods.MapFields(arrList.get(0));
                ApplicationContext.oKeyField.put(arrList.get(0), arrRespdata.get(i));
                System.out.println(arrList.get(0) + " Captured at runtime: " + arrRespdata.get(i));
            }
            String postResponseString = WebServicesUtilities.retryPUTRequestWithoutHeader(API_ServiceStepDef.PRODUCT_SERVICE_BASE_URL, "/items/" + ApplicationContext.oKeyField.get("itemNumber") + "?", "apikey", "AGyQZFUGD1CpY028eGGaFWaMrd4VBjVf", "Authorization", "Basic QUd5UVpGVUdEMUNwWTAyOGVHR2FGV2FNcmQ0VkJqVmY6Vzl5Z1lmR0FwaWptUTdBbQ==", body);
        }
    }

    public static String retryPOSTRequest(String basURL, String endpoint, String param1, String value1,String param2, String value2,String param3, String value3,String param4, String value4,String param5, String value5,String param6, String value6,String param7, String value7,String headerParam1, String headerValue1, String body) throws InterruptedException {
        log.info("basURL"+basURL);
        log.info("body"+body);
        log.info("headerValue1"+headerValue1);
        log.info("endpoint"+endpoint);
        RequestSpecification request = RestAssured.given().queryParam(param1,value1).queryParam(param2,value2).queryParam(param3,value3).queryParam(param4,value4).queryParam(param5,value5).queryParam(param6,value6).queryParam(param7,value7).header(headerParam1,headerValue1).header("Content-Type", "application/json").when();
        request.body(body);
        Response response = WebServicesRetry.retryPOST(basURL + endpoint, request, 201, 5);
        log.info("request"+response.toString());

        log.info("Successful");
        //String jsonResponseString = response.getBody().jsonPath().prettify();
        String jsonResponseString = response.getBody().asString();
        log.info("Response : " + jsonResponseString);

        return jsonResponseString;

    }

    public static String retryPOSTRequestWithHeader(String basURL, String endpoint, String param1, String value1,String param2, String value2,String headerParam1, String headerValue1, String body) throws InterruptedException {
        log.info("basURL"+basURL);
        log.info("body"+body);
        log.info("headerValue1"+headerValue1);
        log.info("endpoint"+endpoint);
        RequestSpecification request = RestAssured.given().queryParam(param1,value1).queryParam(param2,value2).header(headerParam1,headerValue1).header("Content-Type", "application/json").when();
        request.body(body);
        Response response = WebServicesRetry.retryPOST(basURL + endpoint, request, 201, 5);
        log.info("request"+response.toString());
        String p = response.getClass().getName();
        log.info("Successful");
        //String jsonResponseString = response.getBody().jsonPath().prettify();
        String jsonResponseString = response.getBody().asString();
        log.info("Response : " + jsonResponseString);

        return jsonResponseString;

    }

    public static String retryPOSTRequest(String basURL, String endpoint, String param1, String value1, String param2, String value2, String param3, String value3, String param4, String value4, String param5, String value5, String param6, String value6, String headerParam1, String headerValue1, String body) throws InterruptedException {
        log.info("basURL"+basURL);
        log.info("headerValue1"+headerValue1);
        log.info("endpoint"+endpoint);
        RequestSpecification request = RestAssured.given().queryParam(param1,value1).queryParam(param2,value2).queryParam(param3,value3).queryParam(param4,value4).queryParam(param5,value5).queryParam(param6,value6).header(headerParam1,headerValue1).header("Content-Type", "application/json").when();
        request.body(body);
        Response response = WebServicesRetry.retryPOST(basURL + endpoint, request, 201, 5);
        log.info("request"+response.toString());
        log.info("Successful");
        //String jsonResponseString = response.getBody().jsonPath().prettify();
        String jsonResponseString = response.getBody().asString();
        log.info("Response : " + jsonResponseString);

        return jsonResponseString;

    }

    public static String retryPOSTRequest(String basURL, String endpoint, String param1, String value1, String param2, String value2, String param3, String value3,String param4, String value4,String headerParam1, String headerValue1, String body) throws InterruptedException {
        log.info("basURL"+basURL);
        log.info("headerValue1"+headerValue1);
        log.info("endpoint"+endpoint);
        RequestSpecification request = RestAssured.given().queryParam(param1,value1).queryParam(param2,value2).queryParam(param3,value3).queryParam(param4,value4).header(headerParam1,headerValue1).header("Content-Type", "application/json").when();
        request.body(body);
        Response response = WebServicesRetry.retryPOST(basURL + endpoint, request, 201, 5);
        log.info("request"+response.toString());
        log.info("Successful");
        //String jsonResponseString = response.getBody().jsonPath().prettify();
        String jsonResponseString = response.getBody().asString();
        log.info("Response : " + jsonResponseString);

        return jsonResponseString;
    }

    public static String retryPOSTRequest(String basURL, String endpoint, String param1, String value1, String param2, String value2, String param3, String value3, String headerParam1, String headerValue1, String body) throws InterruptedException {
        log.info("basURL"+basURL);
        log.info("headerValue1"+headerValue1);
        log.info("endpoint"+endpoint);
        RequestSpecification request = RestAssured.given().queryParam(param1,value1).queryParam(param2,value2).queryParam(param3,value3).header(headerParam1,headerValue1).header("Content-Type", "application/json").when();
        request.body(body);
        Response response = WebServicesRetry.retryPOST(basURL + endpoint, request, 201, 5);
        log.info("request"+response.toString());
        log.info("Successful");
        //String jsonResponseString = response.getBody().jsonPath().prettify();
        String jsonResponseString = response.getBody().asString();
        log.info("Response : " + jsonResponseString);

        return jsonResponseString;
    }

    public static String retryPATCHRequestWithHeader(String basURL, String endpoint, String param1, String value1, String headerParam1, String headerValue1, String body) throws InterruptedException {
        log.info("basURL"+basURL);
        log.info("headerValue1"+headerValue1);
        log.info("endpoint"+endpoint);
        RequestSpecification request = RestAssured.given().queryParam(param1,value1).header(headerParam1,headerValue1).header("Content-Type", "application/json").when();
        request.body(body);
        Response response = WebServicesRetry.retryPATCH(basURL + endpoint, request, 201, 5);
        log.info("request"+response.toString());
        log.info("Successful");
        //String jsonResponseString = response.getBody().jsonPath().prettify();
        String jsonResponseString = response.getBody().asString();
        log.info("Response : " + jsonResponseString);

        return jsonResponseString;
    }

    public static String retryPOSTRequestWithHeader(String basURL, String endpoint, String param1, String value1, String headerParam1, String headerValue1, String body) throws InterruptedException {
        log.info("basURL"+basURL);
        log.info("headerValue1"+headerValue1);
        log.info("endpoint"+endpoint);
        RequestSpecification request = RestAssured.given().queryParam(param1,value1).header(headerParam1,headerValue1).header("Content-Type", "application/json").when();
        request.body(body);
        Response response = WebServicesRetry.retryPOST(basURL + endpoint, request, 201, 5);
        log.info("request"+response.toString());
        log.info("Successful");
        //String jsonResponseString = response.getBody().jsonPath().prettify();
        String jsonResponseString = response.getBody().asString();
        log.info("Response : " + jsonResponseString);

        return jsonResponseString;
    }

    public static String retryGETRequestWithHeader(String basURL, String endpoint, String param1, String value1, String param2, String value2, String param3, String value3, String param4, String value4, String param5, String value5, String param6, String value6, String param7, String value7,  String headerParam1, String headerValue1) throws IOException, InterruptedException, RuntimeException {
        RequestSpecification request = RestAssured.given().queryParam(param1, value1).queryParam(param2, value2).queryParam(param3, value3).queryParam(param4, value4).queryParam(param5, value5).queryParam(param6, value6).queryParam(param7, value7).header(headerParam1, headerValue1).when();
        Response response;

        response = WebServicesRetry.retryGet(basURL + endpoint, request, expecteResponseCode, 5);
        log.info("Successful");
        String jsonResponseString = response.getBody().jsonPath().prettify();
        log.info("Response : " + jsonResponseString);
        return jsonResponseString;
    }

    public JSONObject parseJSON(String filePath, Map<String, String> templateMap) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject jsonFile;
        jsonFile = (JSONObject) parser.parse(TemplateProcessor.processTemplate()
                .fromResource(filePath)
                .withValues(templateMap)
                .result());
        return jsonFile;
    }

    /*
Can be either of these values :
            Extensible       Strict Ordering
STRICT          no                   yes
LENIENT         yes                  no
NON_EXTENSIBLE  no                   no
STRICT_ORDER    yes                 yes
If extensbility not allowed, then all of the expected values must match in what's being tested, but any additional fields will cause the test to fail.
When extensibility is allowed, all values must still match. For example, if you're expecting:{id:1,name:"Carter"}
Then the following will pass when extensible, and will fail when not:{id:1,name:"Carter",favoriteColor:"blue"}
If strict ordering is enabled, JSON arrays must be in strict sequence.
For example, if you're expecting:{id:1,friends:[{id:2},{id:3}]}
Then the following will fail strict ordering, but will otherwise pass:{id:1,friends:[{id:3},{id:2}]}
*/
    public void jsonCompare(String expectedJSON, String actualJSON, CustomComparator applicationCustomizations) {
        JSONAssert.assertEquals(expectedJSON, actualJSON, applicationCustomizations);
    }

    public static String retryPUTRequestWithoutHeader(String basURL, String endpoint, String param1, String value1, String headerParam1, String headerValue1, String body) throws InterruptedException {

        log.info("basURL==================================" + basURL+endpoint);
        log.info("body++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + body);
        log.info("param1============================" + value1);
        log.info("headerParam1============================" + headerValue1);

        RequestSpecification request = RestAssured.given().queryParam(param1, value1).header(headerParam1, headerValue1).header("Content-Type", "application/json").when();
        log.info("request" + request);
        request.body(body);
        Response response = WebServicesRetry.retryPUT(basURL + endpoint, request, 200, 5);
        log.info("Successful");
        String jsonResponseString = response.getBody().toString();
        log.info("Response : " + jsonResponseString);
        return jsonResponseString;

    }
    public static String retryGETRequestWithout(String basURL, String endpoint, String param1, String value1, String headerParam1, String headerValue1) throws InterruptedException {

        RequestSpecification request = RestAssured.given().queryParam(param1, value1).header(headerParam1, headerValue1).header("Content-Type", "application/json").when();

        Response response = WebServicesRetry.retryGetwith(basURL + endpoint, request, 200,404,5);
        log.info("Successful");
        String jsonResponseString = response.getBody().jsonPath().prettify();
        log.info("Response : " + jsonResponseString);
        return jsonResponseString;

    }

    public static String retryGETRequestWithout(String basURL, String endpoint, String param1, String value1,String param2, String value2, String headerParam1, String headerValue1) throws InterruptedException {

        RequestSpecification request = RestAssured.given().queryParam(param1, value1).queryParam(param2, value2).header(headerParam1, headerValue1).header("Content-Type", "application/json").when();

        Response response = WebServicesRetry.retryGetwith(basURL + endpoint, request, 200,404,5);
        log.info("Successful");
        String jsonResponseString = response.getBody().jsonPath().prettify();
        log.info("Response : " + jsonResponseString);
        return jsonResponseString;

    }

    public static String retryPUTRequestWithout(String basURL, String endpoint, String param1, String value1, String param2, double value2, String param3, String value3, String param4, String value4,String headerParam1, String headerValue1) throws InterruptedException {




        log.info("basURL==================================" + basURL+endpoint);
        log.info("param1============================" + value1);
        log.info("headerParam1============================" + headerValue1);
        log.info(value4);


        RequestSpecification request = RestAssured.given().queryParam(param1, value1).queryParam(param2, value2).queryParam(param3, value3).queryParam(param4, value4).header(headerParam1, headerValue1).header("Content-Type", "application/json").when();
        log.info("request" + request);
        Response response = WebServicesRetry.retryPUT(basURL + endpoint, request, 200, 5);
        log.info("Successful");
        String jsonResponseString = response.getBody().toString();
        log.info("Response : " + jsonResponseString);
        return jsonResponseString;


    }

}
