package com.morrisons.sma.step_definitions.service.Product;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.ecs.AmazonECS;
import com.amazonaws.services.ecs.AmazonECSClientBuilder;
import com.google.inject.Inject;
import com.morrisons.common.helper.FileHelper;
import com.morrisons.common.utility.ApplicationContext;
import com.morrisons.common.utility.WebServicesRetry;
import com.morrisons.common.utility.WebServicesUtilities;

import com.morrisons.sma.page_objects.mobile.old.AWS_S3Upload;
import com.morrisons.sma.page_objects.mobile.old.DynamicRequestMethods;
import com.morrisons.sma.page_objects.service.StorewalkServicePage;
import com.morrisons.sma.page_objects.service.price.PriceService;
import com.morrisons.sma.pojo.service.PriceResponse;
import com.morrisons.sma.step_definitions.service.old.opticFocalStrategies;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.json.JSONObject;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ecs.EcsClient;
import software.amazon.awssdk.services.ecs.model.UpdateServiceRequest;
import software.amazon.awssdk.services.ecs.model.UpdateServiceResponse;

import java.io.*;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static com.morrisons.common.utility.ApplicationContext.applicationConfig;

public class API_ServiceStepDef {

    public static final String PRODUCT_SERVICE_BASE_URL_SIT = "https://sit-api.morrisons.com/product/v1";

    public static final String PRODUCT_SERVICE_BASE_URL_UAT = "https://uat-api.morrisons.com/product/v1";

    public static final String STOCK_ORDER_SERVICE_BASE_URL_SIT = "https://sit-api.morrisons.com/stockorder/v1";

    public static final String STOCK_ORDER_SERVICE_BASE_URL_UAT = "https://uat-api.morrisons.com/stockorder/v1";
    public static final String PRICE_SERVICE_BASE_URL_SIT = "https://sit-api.morrisons.com/price/v2/";
    public static final String PRICE_SERVICE_BASE_URL_UAT = "https://uat-api.morrisons.com/price/v2/";

    public static final String STOCKORDER_SERVICE_BASE_URL_UAT = "https://uat-api.morrisons.com/stockorder/v1/customers/morrisons/orders";

    public static final String STOCKORDER_SERVICE_BASE_URL_SIT = "https://sit-api.morrisons.com/stockorder/v1/customers/morrisons/orders";

    public static final String Base_SERVICE_BASE_URL_UAT = "https://uat-api.morrisons.com";

    public static final String Base_SERVICE_BASE_URL_SIT = "https://sit-api.morrisons.com";
    private static final Logger log = Logger.getLogger(API_ServiceStepDef.class);
    private static String STOCK_ORDER_SERVICE_BASE_URL = null;

    private static String STOCKORDER_SERVICE_BASE_URL = null;

    public static LinkedHashMap<String, String> sRespData = new LinkedHashMap<String, String>();

    public static String  Base_SERVICE_BASE_URL = null;
    private static String PRICE_SERVICE_BASE_URL = null;

    public static String PRODUCT_SERVICE_BASE_URL = null;
    private final ApplicationContext applicationContext;
    public static String accessToken = "QUd5UVpGVUdEMUNwWTAyOGVHR2FGV2FNcmQ0VkJqVmY6Vzl5Z1lmR0FwaWptUTdBbQ==";
    public String itemId = null, min, onDate;
    public static final String priceSource = "RPMPC";
    public static int packQuantity, locationID;
    public static double priceRate;
    String jsonResponseString;
    String jsonGETResponseString;
    public static int productAPIResponseCode;
    WebServicesRetry webServicesRetry = new WebServicesRetry();
    boolean bResponseStatus;

    @Inject
    public API_ServiceStepDef(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        this.jsonGETResponseString = opticFocalStrategies.jsonGETResponseString;
        this.sRespData = sRespData;
    }

    @Before
    public void InitializeEnv() {
        String env = applicationConfig.getWebElementEnviroment().getEnv();
//        if (env.equalsIgnoreCase("com.morrisons.instore.uat")) {
//            Base_SERVICE_BASE_URL = Base_SERVICE_BASE_URL_UAT;
//        } else if (env.equalsIgnoreCase("com.morrisons.instore.sit")) {
//            Base_SERVICE_BASE_URL = Base_SERVICE_BASE_URL_SIT;
//        }
        if (env.equalsIgnoreCase("com.morrisons.instore.uat")) {
            PRODUCT_SERVICE_BASE_URL = PRODUCT_SERVICE_BASE_URL_UAT;
        } else if (env.equalsIgnoreCase("com.morrisons.instore.sit")) {
            PRODUCT_SERVICE_BASE_URL = PRODUCT_SERVICE_BASE_URL_SIT;
        }
        if (env.equalsIgnoreCase("com.morrisons.instore.uat")) {
            PRICE_SERVICE_BASE_URL = PRICE_SERVICE_BASE_URL_UAT;
        } else if (env.equalsIgnoreCase("com.morrisons.instore.sit")) {
            PRICE_SERVICE_BASE_URL = PRICE_SERVICE_BASE_URL_SIT;
        }
        if (env.equalsIgnoreCase("com.morrisons.instore.uat")) {
            STOCKORDER_SERVICE_BASE_URL = STOCKORDER_SERVICE_BASE_URL_UAT;
        } else if (env.equalsIgnoreCase("com.morrisons.instore.sit")) {
            STOCKORDER_SERVICE_BASE_URL = STOCKORDER_SERVICE_BASE_URL_SIT;
        }
        if (env.equalsIgnoreCase("com.morrisons.instore.uat")) {
            STOCK_ORDER_SERVICE_BASE_URL = STOCK_ORDER_SERVICE_BASE_URL_UAT;
        } else if (env.equalsIgnoreCase("com.morrisons.instore.sit")) {
            STOCK_ORDER_SERVICE_BASE_URL = STOCK_ORDER_SERVICE_BASE_URL_SIT;
        }
        String[] sEnv = env.split("[.]");
        env = sEnv[sEnv.length-1];
        Base_SERVICE_BASE_URL = "https://" + env + "-api.morrisons.com";
    }

    @Given("I get the product details for the following item {string}")
    public void iGetTheProductDetails(String item) throws IOException, InterruptedException, ParseException {
//        fFileUpdate.readAndUpdateDATFile();
        //String sCurrentDate1 = readCSVFile(item);
//        String sCurrentDate1 = "Space_20230427151248.csv";
//        AWS_S3Upload oAWSObj = new AWS_S3Upload();
//       oAWSObj.S3Uploader(sCurrentDate1);
        log.info("Getting Response for " + PRODUCT_SERVICE_BASE_URL + "/items/");
        log.info("Item" + item);
        jsonGETResponseString = WebServicesUtilities.retryGETRequestWithout(PRODUCT_SERVICE_BASE_URL, "/items/" + item, "apikey", "AGyQZFUGD1CpY028eGGaFWaMrd4VBjVf", "Authorization", "Basic QUd5UVpGVUdEMUNwWTAyOGVHR2FGV2FNcmQ0VkJqVmY6Vzl5Z1lmR0FwaWptUTdBbQ==");

    }

    @Then("I create new {string} based on Response code and {string}")
    public void iCreateTheProduct(String item, String sField) throws IOException, InterruptedException, ParseException {
        log.info("productAPIResponseCode" + productAPIResponseCode);
        if (productAPIResponseCode == 200) {
            log.info("Getting PUT Response for " + PRODUCT_SERVICE_BASE_URL + "/items/");
            String body = jsonGETResponseString;
//            String filePath = "/json-files/service/" + item + ".json";
//            String body1 = createProductBody(item, "itemNumber=" + item, filePath);
            ArrayList<String> arrList = new ArrayList<String>();
            arrList = DynamicRequestMethods.MapFields(sField);
            ArrayList<String> arrRespdata = DynamicRequestMethods.CaptureResponseData(body, arrList);
            for (int i = 0; i < arrRespdata.size(); i++) {
                arrList = DynamicRequestMethods.MapFields(arrList.get(0));
                ApplicationContext.oKeyField.put(arrList.get(0), arrRespdata.get(i));
                System.out.println(arrList.get(0) + " Captured at runtime: " + arrRespdata.get(i));
            }
            String postResponseString = WebServicesUtilities.retryPUTRequestWithoutHeader(PRODUCT_SERVICE_BASE_URL, "/items/" + item + "?", "apikey", "AGyQZFUGD1CpY028eGGaFWaMrd4VBjVf", "Authorization", "Basic QUd5UVpGVUdEMUNwWTAyOGVHR2FGV2FNcmQ0VkJqVmY6Vzl5Z1lmR0FwaWptUTdBbQ==", body);
        } else {
            String env = applicationConfig.getWebElementEnviroment().getEnv();
            log.info("Creating item record  from existing JSON for " + item);
            log.info("Getting PUT Response for " + PRODUCT_SERVICE_BASE_URL + "/items/");
            String body = jsonGETResponseString;
            try {
                String filePath = "/json-files/service/" + item + ".json";
                body = createProductBody(item, "item=" + item, filePath);
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
            String postResponseString = WebServicesUtilities.retryPUTRequestWithoutHeader(PRODUCT_SERVICE_BASE_URL, "/items/" + item + "?", "apikey", "AGyQZFUGD1CpY028eGGaFWaMrd4VBjVf", "Authorization", "Basic QUd5UVpGVUdEMUNwWTAyOGVHR2FGV2FNcmQ0VkJqVmY6Vzl5Z1lmR0FwaWptUTdBbQ==", body);
        }
    }

    public String createProductBody(String item, String sReqData, String filePath) throws ParseException {
        String productBody;
        applicationContext.templateMap.put("itemNumber", item);
        //org.json.simple.JSONObject objectJSON
        Object oObj= new WebServicesUtilities().parseJSON(filePath, applicationContext.templateMap);
        if (sReqData.contains("=")) {
            oObj = DynamicRequestMethods.UpdateRequestbody(sReqData, oObj);
            //objectJSON = DynamicRequestMethods.createDynamicRequest(sReqData, objectJSON);
        }
        productBody = oObj.toString();
        return productBody;
    }

    @Then("I verify the Response Code for the item {string}")
    public void iVerifyTheResponse(String item) {
        String body = jsonGETResponseString;
        Integer responseCode = webServicesRetry.responseCode;
        log.info("Response body==========" + body);

        JSONObject obj = new JSONObject(jsonGETResponseString);
//creating an object of JSONObject class and casting the object into JSONObject type
//getting values form the JSONObject and casting that values into corresponding types
        if (responseCode.toString().equals("200")) {
            productAPIResponseCode = 200;
        } else {
            productAPIResponseCode = obj.getInt("httpResponseCode");
        }
//printing the values
        System.out.println("responseCode: " + productAPIResponseCode);
    }

    @Then("I delete the item {string}")
    public void iDeleteTheProduct(String itemId) throws InterruptedException {

        log.info("Getting Response for " + PRODUCT_SERVICE_BASE_URL + "/items/");
        log.info("Item" + itemId);
//        try{
//            if(jsonGETResponseString.equalsIgnoreCase("")){
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        jsonResponseString = WebServicesUtilities.retryDELETERequest(PRODUCT_SERVICE_BASE_URL, "/items/" + itemId, "apikey", "AGyQZFUGD1CpY028eGGaFWaMrd4VBjVf", "Authorization", "Basic QUd5UVpGVUdEMUNwWTAyOGVHR2FGV2FNcmQ0VkJqVmY6Vzl5Z1lmR0FwaWptUTdBbQ==");

    }

    @Given("I get the product price for following item {string}")
    public void iGetTheProductPrice(String itemId) throws InterruptedException {
        log.info("Getting Response for " + PRICE_SERVICE_BASE_URL + "/items/");
        jsonResponseString = WebServicesUtilities.retryGETRequestWithout(PRICE_SERVICE_BASE_URL, "locations/" + ApplicationContext.STORE_ID + "/items/" + itemId, "apikey", "AGyQZFUGD1CpY028eGGaFWaMrd4VBjVf", "Authorization", "Basic QUd5UVpGVUdEMUNwWTAyOGVHR2FGV2FNcmQ0VkJqVmY6Vzl5Z1lmR0FwaWptUTdBbQ==");

        JSONObject responseJSONObject = new JSONObject(jsonResponseString);
        boolean priceResponse = responseJSONObject.keySet().toString().contains("httpResponseCode");
        if (priceResponse == true) {
            log.info("Getting Response for " + PRICE_SERVICE_BASE_URL + "/items/");
            jsonResponseString = WebServicesUtilities.retryPUTRequestWithout(PRICE_SERVICE_BASE_URL, "locations/" + ApplicationContext.STORE_ID + "/items/" + itemId + "?", "apikey", "AGyQZFUGD1CpY028eGGaFWaMrd4VBjVf", "price", priceRate, "ondate", onDate, "source", priceSource, "Authorization", "Basic QUd5UVpGVUdEMUNwWTAyOGVHR2FGV2FNcmQ0VkJqVmY6Vzl5Z1lmR0FwaWptUTdBbQ==");
            System.out.println(jsonResponseString);
//            JSONObject responseJSONObject1 = new JSONObject(jsonResponseString);
//            Iterator iTeKeyset = responseJSONObject1.keySet().iterator();
//        while (iTeKeyset.hasNext()) {
//            String sKey = iTeKeyset.next().toString();
//            System.out.println(sKey);
//            System.out.println(responseJSONObject.get(sKey));
//        }
        } else {
            PriceResponse pricetList = new PriceService().getPriceResponse(jsonResponseString);

            locationID = pricetList.getLocationId();
            onDate = pricetList.getEffectiveDate();
            priceRate = pricetList.getRegularPrice();
        }

    }

    @Given("I update price for following {string}")

    public void iUpdateTheProductPrice(String itemId) throws InterruptedException {
        log.info("Getting Response for " + PRICE_SERVICE_BASE_URL + "/items/");
        jsonResponseString = WebServicesUtilities.retryPUTRequestWithout(PRICE_SERVICE_BASE_URL, "locations/" + ApplicationContext.STORE_ID + "/items/" + itemId + "?", "apikey", "AGyQZFUGD1CpY028eGGaFWaMrd4VBjVf", "price", priceRate, "ondate", onDate, "source", priceSource, "Authorization", "Basic QUd5UVpGVUdEMUNwWTAyOGVHR2FGV2FNcmQ0VkJqVmY6Vzl5Z1lmR0FwaWptUTdBbQ==");

    }


    @Then("I get the Stock Order details for the following {string}")
    public void iGetTheStockOrderDetailsForTheFollowing(String item) throws InterruptedException, IOException {
        log.info("Getting Response for " + STOCKORDER_SERVICE_BASE_URL + "items/");
        log.info("Item" + item);
        jsonGETResponseString = WebServicesUtilities.retryGETRequestWithHeader(STOCKORDER_SERVICE_BASE_URL, "", "location", ApplicationContext.STORE_ID, "item", item, "type", "StoreStandard", "orders", "last,current,next", "apikey", "L7W2294UoOujnJHjkw1Cmlu9AiVMjog6", "Authorization", "Basic TDdXMjI5NFVvT3VqbkpIamt3MUNtbHU5QWlWTWpvZzY6cnFDM0lQVTdoUHZ0UzhsZA==");
//        JSONObject responseJSONObject = new JSONObject(jsonResponseString);
        //boolean StockResponse = responseJSONObject.keySet().toString().contains("httpResponseCode");
    }

    @Then("I create Stock Order for the {string} based on Response code for data {string}")
    public void iCreateStockOrderForTheBasedOnResponseCode(String item, String sReqData) throws InterruptedException, ParseException, IOException {
        {
            log.info("productAPIResponseCode" + productAPIResponseCode);
            if (productAPIResponseCode == 200) {
                log.info("Getting PUT Response for " + PRODUCT_SERVICE_BASE_URL + "/items/");
                // String body = jsonGETResponseString;
                String filePath = "/json-files/service/StockOrder.json";
                String body = createProductBody(item, sReqData, filePath);
                String postResponseString = WebServicesUtilities.retryPOSTRequest(STOCK_ORDER_SERVICE_BASE_URL, "/stockmovementevents", "apikey", "kWQ6gyrOGP0NA2fRAfvJTHVacfb9C95G", "Authorization", "Basic a1dRNmd5ck9HUDBOQTJmUkFmdkpUSFZhY2ZiOUM5NUc6eExyOGhRRGt0Z2hwUFdjQQ==", body);
            } else {
                log.info("Creating item record  from existing JSON for " + item);
                log.info("Getting PUT Response for " + PRODUCT_SERVICE_BASE_URL + "/items/");
//            String body = jsonGETResponseString;
                String filePath = "/json-files/service/StockOrder.json";
                String body = createProductBody(item, sReqData, filePath);
                String postResponseString = WebServicesUtilities.retryPOSTRequest(STOCK_ORDER_SERVICE_BASE_URL, "/stockmovementevents", "apikey", "kWQ6gyrOGP0NA2fRAfvJTHVacfb9C95G", "Authorization", "Basic a1dRNmd5ck9HUDBOQTJmUkFmdkpUSFZhY2ZiOUM5NUc6eExyOGhRRGt0Z2hwUFdjQQ==", body);
            }
        }
    }

    @Given("I get the Space details for the following {string}")
    public void iGetTheSpaceDetailsForTheFollowing(String item) throws IOException, InterruptedException {
        log.info("Getting Response for " + STOCKORDER_SERVICE_BASE_URL + "items/");
        log.info("Item" + item);
        jsonGETResponseString = WebServicesUtilities.retryGETRequestWithHeader(Base_SERVICE_BASE_URL, "/space/v1/locations/" + ApplicationContext.STORE_ID + "/items", "apikey", "L7W2294UoOujnJHjkw1Cmlu9AiVMjog6", "itemnumber[in]", "[" + item + "]", "Authorization", "Basic TDdXMjI5NFVvT3VqbkpIamt3MUNtbHU5QWlWTWpvZzY6cnFDM0lQVTdoUHZ0UzhsZA==");
    }

    @Then("I create Space for the {string} based on Response code for data {string}")
    public void iCreateSpaceForTheBasedOnResponseCodeForData(String item, String sReqData) throws IOException, InterruptedException, ParseException {
        log.info("productAPIResponseCode" + productAPIResponseCode);
        if (productAPIResponseCode == 200) {
            log.info("Getting PUT Response for " + PRODUCT_SERVICE_BASE_URL + "/items/");
            String body = jsonGETResponseString;
            // String postResponseString = WebServicesUtilities.retryPOSTRequest(Base_SERVICE_BASE_URL, "/space/v1/jobs", "apikey", "L7W2294UoOujnJHjkw1Cmlu9AiVMjog6", "Authorization", "Basic TDdXMjI5NFVvT3VqbkpIamt3MUNtbHU5QWlWTWpvZzY6cnFDM0lQVTdoUHZ0UzhsZA==", body);
        } else {
            log.info("Creating item record  from existing JSON for " + item);
            log.info("Getting PUT Response for " + PRODUCT_SERVICE_BASE_URL + "/items/");
//            String body = jsonGETResponseString;
            String sCurrentDate1 = readCSVFile(item);
            ApplicationContext.oKeyField.put("file", sCurrentDate1);
            AWS_S3Upload oAWSObj = new AWS_S3Upload();
            oAWSObj.S3Uploader(sCurrentDate1);
            String filePath = "/json-files/service/Space.json";
            String body = createProductBody(item, sReqData, filePath);
            Thread.sleep(7000);
            String postResponseString = WebServicesUtilities.retryPOSTRequest(Base_SERVICE_BASE_URL, "/space/v1/jobs", "apikey", "L7W2294UoOujnJHjkw1Cmlu9AiVMjog6", "Authorization", "Basic TDdXMjI5NFVvT3VqbkpIamt3MUNtbHU5QWlWTWpvZzY6cnFDM0lQVTdoUHZ0UzhsZA==", body);
            //Wait for 30 secs.To check if the file is moved to processed archive. run the get api to get response status as 200
        }
    }

    private String readCSVFile(String item) throws IOException, InterruptedException {
        Scanner sc = new Scanner(new File(System.getProperty("user.dir") + "//src//test//resources//TestData//Input//Space_20230427164000.csv"));
        CSVReader reader = null;
        CSVWriter writer = null;
        String[] nextLine = new String[0];
        ArrayList<String> nextLine1 = new ArrayList<String>();
        long min = 10000000000000000l;
        long max = 999999999999999999l;
        double dmin = 1000;
        double dmax = 9999;
        DecimalFormat df = new DecimalFormat("#.000000");
        double w = (Math.random() * (dmax - dmin + 1) + dmin);
        w = Double.parseDouble(df.format(w));
        LocalDate currentDate = LocalDate.now().minusMonths(1);
        LocalDate dd = currentDate.minusDays(10);
        LocalDateTime currentDate1 = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        currentDate1 = currentDate1.truncatedTo(ChronoUnit.SECONDS);
        String sCurrentDate = String.valueOf(currentDate).replaceAll("-", "");
        String sdd = String.valueOf(dd).replaceAll("-", "");
        String sCurrentDate1 = String.valueOf(currentDate1).replaceAll("-", "");
        sCurrentDate1 = String.valueOf(currentDate1).replaceAll("[-,:,.,T]", "");
        long StrWalkId;
        try {
//parsing a CSV file into CSVReader class constructor
            reader = new CSVReader(new FileReader(System.getProperty("user.dir") + "//src//test//resources//TestData//Input//Space_20230427164000.csv"));
            //reads one line at a time
            int ctr = 0;
            while ((nextLine = reader.readNext()) != null) {
                for (String token : nextLine) {
                    System.out.println(token);
                    String[] arrToken = token.split("[//|]");
                    int d = arrToken.length - 2;
                    String StoreId = arrToken[0];
                    String str = arrToken[1];
                    String str1 = arrToken[12];
                    String sDate = arrToken[6];
                    String sDate1 = arrToken[7];
                    String sApprvDate = arrToken[d];
                    System.out.println(str);
                    token = token.replace(StoreId, "INSERT~" + ApplicationContext.STORE_ID);
                    token = token.replace(str, item);
                    StrWalkId = (long) (Math.random() * (max - min + 1) + min);
                    token = token.replace(str1, String.valueOf(StrWalkId));
                    token = token.replaceAll(sDate, sCurrentDate);
                    token = token.replaceAll(sApprvDate, sdd);
                    token = token.replaceAll(sDate1, "40001231");
                    System.out.println(token);
                    try {
                        nextLine1.add(token);
                    } catch (ArrayIndexOutOfBoundsException arre) {

                    }
                }
                System.out.print("\n");
                ctr++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        sCurrentDate1 = "Space_" + sCurrentDate1 + ".csv";
        File file = new File(System.getProperty("user.dir") + "//src//test//resources//TestData//Output//"  + sCurrentDate1);
        file.createNewFile();
        Thread.sleep(3000);
        writer = new CSVWriter(new FileWriter(System.getProperty("user.dir") + "//src//test//resources//TestData//Output//" + sCurrentDate1), ',', CSVWriter.NO_QUOTE_CHARACTER);
        //String[] ss = new String[nextLine1.size()];
        String[] ss = new String[1];
        for (int ctr = 0; ctr < nextLine1.size(); ctr++) {
            ss[0] = nextLine1.get(ctr);
            ss[0] = ss[0].replaceAll("\"", "");
            ss[0] = ss[0].replaceAll(",", "");
            writer.writeNext(ss);
            //writer.writeNext(new String[]{"\n"});
        }
        //writer = new CSVWriter(new FileWriter("C://Users//Swati1500583//Downloads//Space_20210721031055.csv"));
        // writer.writeAll(Collections.singleton(ss));

        writer.close();
        return sCurrentDate1;
    }

    //========================================
    public String readCSVFile1(String item) throws IOException, InterruptedException {

        return item;
    }
    //===========================================

    @Then("I create SOH for the Items based on Response code {string} {string} {string} {string}")
    public void iCreateSOHForTheBasedOnResponseCode(String bucketName, String keyName, String filePath, String fileName) throws IOException {
        FileHelper fFileUpdate = new FileHelper();
        String sCurrentDate1 = fFileUpdate.readAndUpdateDATFile();
        AWS_S3Upload oAWSObj = new AWS_S3Upload();
        oAWSObj.S3UploaderForSOH(sCurrentDate1);
    }

    @And("I get the product details for following item {string}")
    public void iGetTheProductDetailsForFollowingItem(String item) throws InterruptedException {
        LocalTime currentTime = LocalTime.now();
        int Hour = currentTime.getHour();
        int min = currentTime.getMinute();
        int sec = currentTime.getSecond();
        int mili = currentTime.getNano();
        DateFormat formatter = new SimpleDateFormat("hh:mm:ss.SSS Z");
        String time = formatter.format(new Date());
        System.out.println(time);
        LocalDate currentDate = LocalDate.now();
        LocalDateTime currentDate1 = LocalDateTime.now().minusHours(Hour).minusMinutes(min).minusSeconds(sec).minusNanos(mili);
        LocalDateTime currentDate2 = LocalDateTime.now();
        System.out.println(currentDate1);
        String sDate = String.valueOf(currentDate1 + "Z");
        String sDate2 = String.valueOf(currentDate2 + "Z");
        jsonGETResponseString = WebServicesUtilities.retryGETRequestWithout(Base_SERVICE_BASE_URL, "/stock/v2/locations/" + ApplicationContext.STORE_ID + "/items/" + item + "/adjustments", "apikey", "1rQlOAe1PAWaWLHlShKfhhUn8rODH8AK", "since", sDate, "until", sDate2, "Authorization", "Basic MXJRbE9BZTFQQVdhV0xIbFNoS2ZoaFVuOHJPREg4QUs6Y2ZVN29WQ3hYWUVIUW1WdQ==");
    }

    @Then("I report the response status for the item {string}")
    public void iReportTheResponseStatus(String item) {
        if (productAPIResponseCode == 200) {
            log.info("Response Status 200 And " + item + " was submitted successfully");
            Assert.assertEquals(productAPIResponseCode, 200);
        } else {
            log.info("Response Status is not 200 " + item + " didn't get submitted , status code is " + productAPIResponseCode);
            Assert.assertEquals(productAPIResponseCode, 200);
        }
    }

    @And("I verify the response fields {string}")
    public void iVerifyTheResponseFields(String responseDetails) throws ParseException {
        String[] arrResp = responseDetails.split("~");
        API_ServiceStepDef oAPI = new API_ServiceStepDef(applicationContext);
        ArrayList RespDetails = new ArrayList();
        LinkedHashMap<String, String> oExpectedResp = new LinkedHashMap<String, String>();
        for (int i = 0; i < arrResp.length; i++) {
            String[] arrRespDetails = arrResp[i].split(":");
            RespDetails.add(arrRespDetails[0]);
            oExpectedResp.put(arrRespDetails[0], arrRespDetails[1]);
        }
        //if(responseDetails.contains("=")) {
        //String objectJSON = String.valueOf(new WebServicesUtilities().parseJSON(oAPI.jsonGETResponseString, applicationContext.templateMap));
        LinkedHashMap<String, String> oActualResp = DynamicRequestMethods.getResponseData(oAPI.jsonGETResponseString, RespDetails);
        //objectJSON = DynamicRequestMethods.createDynamicRequest(sReqData, objectJSON);
        DynamicRequestMethods.ValidateRespose(oExpectedResp, oActualResp);
    }

    @Given("I get output file for {string} {string} {string} {string}")
    public void iGetOutputFileFor(String bucketName, String keyName, String filePath, String fileName) throws InterruptedException, IOException {
//        String sFileName = getSROutputFileName(fileName);
        String sFileName = sRespData.get("file");
        ApplicationContext.oKeyField.put("file", sFileName);
        AWS_S3Upload oAWSObj = new AWS_S3Upload();
        oAWSObj.S3getOutPutFile(bucketName, keyName, filePath, sFileName);
    }

    private String getSROutputFileName(String fileName) {
        //=====================================================
        API_ServiceStepDef oAPI = new API_ServiceStepDef(applicationContext);
        LocalDate currentDate = LocalDate.now();
        LocalTime currentDateTime = LocalTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME.withLocale(Locale.UK);
        currentDateTime = currentDateTime.truncatedTo(ChronoUnit.SECONDS);
        String sCurrentDate = String.valueOf(currentDate) + "_" + String.valueOf(currentDateTime);
        sCurrentDate = sCurrentDate.replaceAll("-", "");
        String sCurrentDate1 = sCurrentDate.replaceAll("[-,:,.,T]", "");
        //=====================================================
        String sFileName = "StockRecord_" + ApplicationContext.STORE_ID + "_" + sRespData.get("jobId") + "_" + sCurrentDate1;  //318_24063_20230929_071655
        return sFileName;
    }

    @Given("I create input file for {string} {string} {string} {string}")
    public void iCreateStockVGapstoresFor(String bucketName, String keyName, String filePath, String fileName) throws IOException {
        //String sFileName = getSROutputFileName(fileName);
        String sFileName = null;
        if(fileName.contains("getRunTime")){
            FileHelper fFileUpdate = new FileHelper();
            sFileName = fFileUpdate.readAndUpdateDATFileBY(fileName);
        }
        else {
            sFileName = fileName;
        }
        ApplicationContext.oKeyField.put("file", sFileName);
        AWS_S3Upload oAWSObj = new AWS_S3Upload();
        oAWSObj.S3uploadInputFile(bucketName, keyName, filePath, sFileName);
    }

    @And("I get the field value for the field {string}")
    public void iGetTheFieldValueForTheField(String responseFields) throws ParseException {
        String[] arrResp = responseFields.split(",");
        System.out.println(jsonGETResponseString);
        if(jsonGETResponseString == null) {
            API_ServiceStepDef oAPI = new API_ServiceStepDef(applicationContext);
            jsonGETResponseString = oAPI.jsonGETResponseString;
        }
        ArrayList RespDetails = new ArrayList();
        LinkedHashMap<String, String> oExpectedResp = new LinkedHashMap<String, String>();
        for (int i = 0; i < arrResp.length; i++) {
            String[] arrRespDetails = arrResp[i].split(":");
            RespDetails.add(arrResp[i]);
        }
        //if(responseDetails.contains("=")) {
        //String objectJSON = String.valueOf(new WebServicesUtilities().parseJSON(oAPI.jsonGETResponseString, applicationContext.templateMap));
        LinkedHashMap<String, String> oActualResp = DynamicRequestMethods.getResponseData(jsonGETResponseString, RespDetails);
        sRespData.putAll(oActualResp);
        Iterator ii = this.sRespData.keySet().iterator();
        String sKey, sItem;
        while(ii.hasNext()) {
            sKey = ii.next().toString();
            sItem = sRespData.get(sKey);
            ApplicationContext.oKeyField.put(sKey, sItem);
        }
    }

    @Given("I get defined output file for {string} {string} {string} {string}")
    public void iGetDefinedOutputFileFor(String bucketName, String keyName, String filePath, String fileName) throws InterruptedException, IOException {
        String sFileName = fileName;
        ApplicationContext.oKeyField.put("file", sFileName);
        AWS_S3Upload oAWSObj = new AWS_S3Upload();
        oAWSObj.S3getOutPutFile(bucketName, keyName, filePath, sFileName);
    }

    @Then("I create new {string} based on Response code and {string} for the given barcode")
    public void iCreateNewBasedOnResponseCodeAndForTheGivenBarcode(String item, String sField) throws ParseException, InterruptedException {
        WebServicesUtilities.createProduct(item,sField);
    }
}