package com.morrisons.sma.step_definitions.mobile.MOCO;

import com.morrisons.common.utility.ApplicationContext;
import com.morrisons.common.utility.WebServicesRetry;
import com.morrisons.common.utility.WebServicesUtilities;
import com.morrisons.sma.step_definitions.service.Product.API_ServiceStepDef;
import com.morrisons.sma.step_definitions.service.old.opticFocalStrategies;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static com.morrisons.common.utility.ApplicationContext.applicationConfig;

public class MOCO_API_Services {
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

    public MOCO_API_Services(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
    static List OrdersList = new ArrayList();
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
        JOB_STATUS_BASE_URL = "https://" + env + "-api.morrisons.com/";
    }

    @Given("I hit the get endpoint to retrieve the {string} for the following {string} and {string} and {string} and {string}")
    public void iHitTheGetEndpointToRetrieveTheForTheFollowingAndAnd(String ServiceName, String EndPoint, String APIKey,String AuthKey,String sParam) throws IOException, InterruptedException {
        EndPoint = EndPoint.replace("{getStoreId}",ApplicationContext.STORE_ID);
        String[] arrParam = sParam.split("=");
        String sParam1 = arrParam[0];
        String sParamVal = arrParam[1];
        opticFocalStrategies.jsonGETResponseString = WebServicesUtilities.retryGETRequestWithHeader(JOB_STATUS_BASE_URL,EndPoint, "apikey", APIKey,sParam1,sParamVal, "Authorization",AuthKey);        
    }

    private JSONArray SortResponseData(String jsonGETResponseString, String filter1, String filter2) {
        org.json.JSONObject responseJSONObject = new org.json.JSONObject(opticFocalStrategies.jsonGETResponseString);
        String[] arrParam = filter1.split("=");
        String sFilter1= arrParam[0];
        String sFilter1Val = arrParam[1];
        arrParam = filter2.split("=");
        String sFilter2= arrParam[0];
        String sFilter2Val = arrParam[1];
        JSONArray jy = (JSONArray) responseJSONObject.get("orders");
        JSONArray sortedJsonArray = new JSONArray();
        List list = new ArrayList();
        for(int i = 0; i < jy.length(); i++) {
            list.add(jy.getJSONObject(i));
            OrdersList.add(jy.getJSONObject(i));
        }
        System.out.println("Before Sorted JSONArray: " + jy);
        Collections.sort(list, new Comparator() {
            private final String KEY_NAME = sFilter1Val;
            @Override
            public int compare(Object a, Object b) {
                JSONObject oJS1 = (JSONObject) a;
                JSONObject oJS2 = (JSONObject) b;
                Object oObj = oJS1.get(KEY_NAME);
                if(oObj instanceof Integer)
                {
                int str1 = 0;
                int str2 = 0,k;
                String str3 = null;
                String str4 = null;
//                String str1 = new String();
//                String str2 = new String();


                try {
                    str1 = (int) oJS1.get(KEY_NAME);
                    str2 = (int) oJS2.get(KEY_NAME);
                    str3 = (String) oJS1.get("orderId");
                    str4 = (String) oJS2.get("orderId");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (sFilter2Val.equalsIgnoreCase("asc")) {
                    k = Integer.valueOf(str1).compareTo(Integer.valueOf(str2));
                   if(k==0)
                    return str3.compareTo(str4);
                   else
                    return k;
                } else if (sFilter2Val.equalsIgnoreCase("desc")) {
                    k= Integer.valueOf(str2).compareTo(Integer.valueOf(str1));
                    if(k==0)
                     return str4.compareTo(str3);
                    else
                      return k;
                }
            }
                else if(oObj instanceof String){
                    String str1 = new String();
                    String str2 = new String();
//                String str1 = new String();
//                String str2 = new String();
                    try {
                        str1 = (String) oJS1.get(KEY_NAME);
                        str2 = (String) oJS2.get(KEY_NAME);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if(sFilter1Val.toLowerCase().contains("date")){
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSz");
                        LocalDateTime dateTime1 = LocalDateTime.parse(str1,formatter);
                        LocalDateTime dateTime2 = LocalDateTime.parse(str2,formatter);
                        if (sFilter2Val.equalsIgnoreCase("asc")) {
                            return dateTime1.compareTo(dateTime2);
                        } else if (sFilter2Val.equalsIgnoreCase("desc")) {
                            return dateTime2.compareTo(dateTime1);
                        }
                    }
                    else {
                        if (sFilter2Val.equalsIgnoreCase("asc")) {
                            return str1.compareTo(str2);
                        } else if (sFilter2Val.equalsIgnoreCase("desc")) {
                            return str2.compareTo(str1);
                        }
                    }

                }
                return 0;
            }
           });
        for(int i = 0; i < jy.length(); i++) {
            sortedJsonArray.put(list.get(i));
        }
        System.out.println("Sorted JSON Array with Name: " + sortedJsonArray);
        return sortedJsonArray;
    }

    @Then("I Verify the Response Code for the following {string} is {string}")
    public void iVerifyTheResponseCodeForTheFollowingIs(String sService, String respCode) {
        String body = jsonGETResponseString;
        Integer responseCode=webServicesRetry.responseCode;
        log.info("Response body=========="+body);

//        Object obj = new JSONObject(jsonGETResponseString);
//creating an object of JSONObject class and casting the object into JSONObject type
//getting values form the JSONObject and casting that values into corresponding types
        int productAPIResponseCode;
        if(responseCode.toString().equals("201")) {
            productAPIResponseCode=201;
        }
        else {
            productAPIResponseCode = Integer.valueOf(responseCode);
        }
//printing the values
        System.out.println("responseCode: "+productAPIResponseCode);
        Assert.assertEquals(String.valueOf(productAPIResponseCode),respCode);
    }

    @Given("I hit the post endpoint to retrieve the {string} for the following {string} and {string} and {string} and {string} and Request file {string}")
    public void iHitThePostEndpointToRetrieveTheForTheFollowingAndAndAndRequestFile(String ServiceName, String EndPoint, String APIKey,String AuthKey,String sParam, String reqFile) throws ParseException, IOException, InterruptedException {
        String filePath=reqFile;
        String[] arrParam = sParam.split("=");
        String sParam1 = arrParam[0];
        String sParamVal = arrParam[1];
        //applicationContext.templateMap.put("itemNumber",item);
        org.json.simple.JSONObject objectJSON = new WebServicesUtilities().parseJSON(filePath, applicationContext.templateMap);
        String body = objectJSON.toString();
        EndPoint = EndPoint.replace("{getStoreId}",ApplicationContext.STORE_ID);
        opticFocalStrategies.jsonGETResponseString = WebServicesUtilities.retryPOSTRequestWithHeader(JOB_STATUS_BASE_URL,EndPoint, "apikey", APIKey,sParam1,sParamVal, "Authorization",AuthKey, body);
    }

    @And("I verify the response file {string}")
    public void iVerifyTheResponseFile(String RespFile) throws ParseException {
        String body = opticFocalStrategies.jsonGETResponseString;
        Integer responseCode = webServicesRetry.responseCode;
        log.info("Response body==========" + body);
        if (RespFile.equalsIgnoreCase("null")) {
            Assert.assertNull(null);
        } else {
            org.json.simple.JSONObject ExpResponse = new WebServicesUtilities().parseJSON(RespFile, applicationContext.templateMap);

            JSONObject obj = new JSONObject(body);
//creating an object of JSONObject class and casting the object into JSONObject type
//getting values form the JSONObject and casting that values into corresponding types
            Assert.assertEquals(obj.toString(), ExpResponse.toString(), " Response file doesn't match");
        }
    }

    @Given("I hit the get endpoint to retrieve the {string} for the following {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and Request file {string}")
    public void iHitThePostEndpointToRetrieveTheForTheFollowingAndAndAndAndRequestFile(String ServiceName, String EndPoint, String APIKey, String AuthKey, String param1,String param2,String param3,String param4,String param5, String param6,String reqFile) throws ParseException, IOException, InterruptedException {
        String[] arrParam = param1.split("=");
        param1 = arrParam[0];
        String arrParamVal1 = arrParam[1];
        arrParam = param2.split("=");
        param2 = arrParam[0];
        String arrParamVal2 = arrParam[1];
        arrParam = param3.split("=");
        param3 = arrParam[0];
        String arrParamVal3 = arrParam[1];
        arrParam = param4.split("=");
        param4 = arrParam[0];
        String arrParamVal4 = arrParam[1];
        arrParam = param5.split("=");
        if(arrParam[1].contains("runtimedate")){
            LocalDateTime currentDate = LocalDateTime.now();
            LocalDateTime dd;
            String[] sParam = new String[]{};
            String sParamVal;
            if(arrParam[1].contains("-")){
                sParam = arrParam[1].split("-");
                sParamVal = sParam[1];
                arrParam[1] = sParam[0];
                dd = currentDate.minusDays(Long.parseLong(sParamVal));
            }
            else {
                dd = currentDate;
            }
            arrParam[1] = dd.toString();
        }
            param5 = arrParam[0];
            String arrParamVal5 = arrParam[1];

        arrParam = param6.split("=");
        if(arrParam[1].contains("runtimedate")){

            LocalDateTime currentDate = LocalDateTime.now();
            LocalDateTime dd;
            String[] sParam = new String[]{};
            String sParamVal;
            if(arrParam[1].contains("-")){
                sParam = arrParam[1].split("-");
                sParamVal = sParam[1];
                arrParam[1] = sParam[0];
                dd = currentDate.minusDays(Long.parseLong(sParamVal));
            }
            else {
                dd = currentDate;
            }
            arrParam[1] = dd.toString();
        }
        param6 = arrParam[0];
        String arrParamVal6 = arrParam[1];
        EndPoint = EndPoint.replace("{store_code}",ApplicationContext.STORE_ID);
        jsonGETResponseString = WebServicesUtilities.retryGETRequestWithHeader(JOB_STATUS_BASE_URL,EndPoint, "apikey", APIKey,param1,arrParamVal1,param2,arrParamVal2,param3,arrParamVal3,param4,arrParamVal4,param5,arrParamVal5,param6,arrParamVal6,"Authorization",AuthKey);
    }
    public static void getRequestAPI(String serviceName, String EndPoint, String APIKey, String AuthKey, String param1, String param2, String param3) throws InterruptedException {
        String[] arrParam = param1.split("=");
        param1 = arrParam[0];
        String arrParamVal1 = arrParam[1];
        arrParam = param2.split("=");
        param2 = arrParam[0];
        String arrParamVal2 = arrParam[1];
        arrParam = param3.split("=");
        param3 = arrParam[0];
        String arrParamVal3 = arrParam[1];
        //applicationContext.templateMap.put("itemNumber",item);
        EndPoint = EndPoint.replace("{getStoreId}",ApplicationContext.STORE_ID);
        opticFocalStrategies.jsonGETResponseString = WebServicesUtilities.retryGETRequestWithHeader(JOB_STATUS_BASE_URL,EndPoint, "apikey", APIKey,param1,arrParamVal1,param2,arrParamVal2,param3,arrParamVal3,"Authorization",AuthKey);
    }

    public static void getRequestAPI(String serviceName, String EndPoint, String APIKey, String AuthKey, String param1, String param2) throws InterruptedException, IOException {
        String[] arrParam = param1.split("=");
        param1 = arrParam[0];
        String arrParamVal1 = arrParam[1];
        arrParam = param2.split("=");
        param2 = arrParam[0];
        String arrParamVal2 = arrParam[1];
        //applicationContext.templateMap.put("itemNumber",item);
        EndPoint = EndPoint.replace("{getStoreId}",ApplicationContext.STORE_ID);
        opticFocalStrategies.jsonGETResponseString = WebServicesUtilities.retryGETRequestWithHeader(JOB_STATUS_BASE_URL,EndPoint, "apikey", APIKey,param1,arrParamVal1,param2,arrParamVal2,"Authorization",AuthKey);
    }

    public static void getRequestAPIwithFilter(String serviceName, String EndPoint, String APIKey, String sParam, String AuthKey, String filter1, String filter2) throws IOException, InterruptedException, ParseException {
        EndPoint = EndPoint.replace("{getStoreId}",ApplicationContext.STORE_ID);
        String[] arrParam = sParam.split("=");
        String sParam1 = arrParam[0];
        String sParamVal = arrParam[1];
        opticFocalStrategies.jsonGETResponseString = WebServicesUtilities.retryGETRequestWithHeader(JOB_STATUS_BASE_URL,EndPoint, "apikey", APIKey,sParam1,sParamVal, "Authorization",AuthKey);
        ApplicationContext applicationContext = new ApplicationContext();
        MOCO_API_Services oS = new MOCO_API_Services(applicationContext);
        JSONArray OJSO = oS.SortResponseData(opticFocalStrategies.jsonGETResponseString, filter1, filter2);
        JSONParser parser = new JSONParser();
        org.json.simple.JSONObject jsonObj = (org.json.simple.JSONObject) parser.parse(opticFocalStrategies.jsonGETResponseString);
        jsonObj.put("orders",OJSO);
        opticFocalStrategies.jsonGETResponseString = String.valueOf(jsonObj);
    }

    public static void getRequestAPI(String serviceName, String EndPoint, String APIKey, String AuthKey) throws IOException, InterruptedException {
        EndPoint = EndPoint.replace("{getStoreId}",ApplicationContext.STORE_ID);
        if(EndPoint.contains("deleteAllOrdId")) {
            EndPoint = EndPoint.replace("deleteAllOrdId", "");
            Object oJS1 = OrdersList;
            System.out.println(OrdersList.size());
            JSONObject oJS = new JSONObject();
            ArrayList<String> arrLst = new ArrayList<String>();
            for (int j = 0; j < OrdersList.size(); j++) {
                oJS = (JSONObject) OrdersList.get(j);
                arrLst.add(oJS.get("orderId").toString());
            }
            for (int i = 0; i < arrLst.size(); i++) {
                EndPoint = EndPoint +  arrLst.get(i);
                opticFocalStrategies.jsonGETResponseString = WebServicesUtilities.retryDELETERequest(JOB_STATUS_BASE_URL, EndPoint, "apikey", APIKey, "Authorization", AuthKey);
                EndPoint = EndPoint.replace(arrLst.get(i), "");
            }
        }
        else {
            opticFocalStrategies.jsonGETResponseString = WebServicesUtilities.retryDELETERequest(JOB_STATUS_BASE_URL, EndPoint, "apikey", APIKey, "Authorization", AuthKey);
        }
    }

    public void patchRequestAPI(String serviceName, String EndPoint, String APIKey, String AuthKey, String sRequest) throws ParseException, InterruptedException {
        String filePath=sRequest;
        //applicationContext.templateMap.put("itemNumber",item);
        org.json.simple.JSONObject objectJSON = new WebServicesUtilities().parseJSON(filePath, applicationContext.templateMap);
        String body = objectJSON.toString();
        EndPoint = EndPoint.replace("{getStoreId}",ApplicationContext.STORE_ID);
        opticFocalStrategies.jsonGETResponseString = WebServicesUtilities.retryPATCHRequestWithHeader(JOB_STATUS_BASE_URL,EndPoint, "apikey", APIKey,"Authorization",AuthKey,body);
    }
    public void postRequestAPI(String serviceName, String EndPoint, String APIKey, String AuthKey, String Param1,String Param2, String sRequest) throws ParseException, InterruptedException {
        String filePath=sRequest;
        //applicationContext.templateMap.put("itemNumber",item);
        org.json.simple.JSONObject objectJSON = new WebServicesUtilities().parseJSON(filePath, applicationContext.templateMap);
        String body = objectJSON.toString();
        EndPoint = EndPoint.replace("{getStoreId}",ApplicationContext.STORE_ID);
        opticFocalStrategies.jsonGETResponseString = WebServicesUtilities.retryPOSTRequestWithHeader(JOB_STATUS_BASE_URL,EndPoint, "apikey", APIKey,"Authorization",AuthKey,body);
    }

    public void postReqAPIWithDynamicData(String ServiceName, String EndPoint, String APIKey,String AuthKey,String sParam, String reqFile, String sItem) throws ParseException, InterruptedException {
        String filePath=reqFile;
        String[] arrParam = sParam.split("=");
        String sParam1 = arrParam[0];
        String sParamVal = arrParam[1];
        //applicationContext.templateMap.put("itemNumber",item);
        ApplicationContext applicationContext = new ApplicationContext();
        API_ServiceStepDef oObj = new API_ServiceStepDef(applicationContext);
        String body = oObj.createProductBody(sItem, sItem, filePath);
        EndPoint = EndPoint.replace("{getStoreId}",ApplicationContext.STORE_ID);
        opticFocalStrategies.jsonGETResponseString = WebServicesUtilities.retryPOSTRequestWithHeader(JOB_STATUS_BASE_URL,EndPoint, "apikey", APIKey,sParam1,sParamVal, "Authorization",AuthKey, body);
    }

   public void VerifyRespFile(String RespFile, String sItem) throws ParseException {
       String body = opticFocalStrategies.jsonGETResponseString;
       Integer responseCode=webServicesRetry.responseCode;
       log.info("Response body=========="+body);
       ApplicationContext applicationContext = new ApplicationContext();
       API_ServiceStepDef oObj = new API_ServiceStepDef(applicationContext);
       body = oObj.createProductBody(sItem, sItem, RespFile);
       JSONParser parser = new JSONParser();
       org.json.simple.JSONObject ExpResponse = (org.json.simple.JSONObject) parser.parse(body);
       JSONObject obj = new JSONObject(body);
//creating an object of JSONObject class and casting the object into JSONObject type
//getting values form the JSONObject and casting that values into corresponding types
       Assert.assertEquals(obj.toString(),ExpResponse.toString()," Response file doesn't match");
    }

    public void deleteOrders() {
        JSONObject oJS1 = (JSONObject) OrdersList;
        ArrayList<String> arrLst = new ArrayList<String>();
        arrLst.add(oJS1.get("orderId").toString());
    }
}
