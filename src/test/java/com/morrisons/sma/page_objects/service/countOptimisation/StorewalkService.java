package com.morrisons.sma.page_objects.service.countOptimisation;

import com.morrisons.common.utility.ApplicationContext;
import com.morrisons.common.utility.WebServicesUtilities;
import com.morrisons.sma.page_objects.mobile.countOptimization.CountOptimizationHomePage;
import com.morrisons.sma.page_objects.service.StorewalkServicePage;
import com.morrisons.sma.page_objects.service.login_new.LoginService;
import com.morrisons.sma.pojo.service.CountPostPOJO.CountPO_DepartmentList;
import com.morrisons.sma.pojo.service.MarkdownPOJO.MarkdownLoginVo;
import com.morrisons.sma.pojo.service.countOptimization.getStorewalkUAT.Storewalk;
import com.morrisons.sma.step_definitions.service.Login.LoginStepDef;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.morrisons.sma.page_objects.service.GlhSummaryService.accessTocken;

public class StorewalkService {
    private final Logger log = Logger.getLogger(StorewalkService.class);
    public static final String GET_STOREWALKS_SERVICE_BASE_URL = "https://uat-api.morrisons.com/storewalk/v1";
    private ApplicationContext applicationContext = new ApplicationContext();
    String jsonResponseString;
    public static String sName;
    public static String createCountResponse,createCountResponseinRetur;
    LoginStepDef loginStepDef = new LoginStepDef(applicationContext);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date currentDate = new Date();
    CountOptimizationHomePage countOptimizationHomePage = new CountOptimizationHomePage();
    CreateCountService createCountService = new CreateCountService();
    String sinceDate = dateFormat.format(currentDate) + "T00:17:42Z";
    String untilDate = dateFormat.format(currentDate) + "T23:17:42Z";


    public String iGetStoreWalkUAT() throws Throwable {
        String accessToken = StorewalkServicePage.getGeneratedAccessTokenAppLogin();
        log.info("Getting Response for " + GET_STOREWALKS_SERVICE_BASE_URL + "stores/storewalks");

        log.info("loginService.accessToken--------------------------------" + accessToken);
        System.out.println("accessTocken " + accessToken);
        jsonResponseString = WebServicesUtilities.retryGETRequestWithHeader(GET_STOREWALKS_SERVICE_BASE_URL, "/stores/storewalks", "apikey", "ZwQGsEN0f65kORZ8EVQlJWA2bGNbHls0", "since", sinceDate, "until", untilDate, "limit", "100", "offset", "0", "Authorization", "Bearer " + accessToken);
        return jsonResponseString;

    }

    public void getStorewalkResponse(String StoreID) throws IOException, InterruptedException {

        List<Storewalk> walkidList = new StoreWalkServiceResponseDeserialization().getWalkidResponse(jsonResponseString);
        log.info("No. Of walkidList : " + walkidList.size());
        String walkIDtoDelete ;

        for (int walkidIndex = 0; walkidIndex <= walkidList.size() - 1; walkidIndex++) {
            log.info("No. Of Departments name : " + walkidList.get(walkidIndex).walkId);
            log.info("No. Of store name : " + walkidList.get(walkidIndex).storeNumber);

            if (walkidList.get(walkidIndex).storeNumber == Integer.parseInt(StoreID)) {
                log.info("=========================================================================");
                log.info("No. Of walkid : " + walkidList.get(walkidIndex).walkId);
                log.info("No. Of store: " + walkidList.get(walkidIndex).storeNumber);
                walkIDtoDelete=walkidList.get(walkidIndex).walkId;
                log.info("============================================MATCH=============================");
                deleteSotreWalkid(walkIDtoDelete,StoreID);


            }

        }

//        }


    }

    public void deleteSotreWalkid(String walkId, String storeID) throws InterruptedException {
        log.info("Getting Response for " + GET_STOREWALKS_SERVICE_BASE_URL + "stores/storewalks");
        log.info("walkId---------------"+walkId);
        WebServicesUtilities.retryDELETERequest(GET_STOREWALKS_SERVICE_BASE_URL, "/stores/" + storeID + "/storewalks/" + walkId, "apikey", "VgfPXEZxjMDudgJAAzWZw0CUomAuzJKB", "Authorization", "Basic " + "VmdmUFhFWnhqTUR1ZGdKQUF6V1p3MENVb21BdXpKS0I6RXlhdXFJMGx2Tm1SQlJYQQ==");

    }

    public void createCount(String storeID, String items, String filePath,String scanMode,String countType) throws InterruptedException, ParseException, IOException {


        applicationContext.templateMap.put("currentDate_strtTime", dateFormat.format(currentDate) + "T06:45:00");
        applicationContext.templateMap.put("currentDate_endTime", dateFormat.format(currentDate) + "T8:45:00");
        applicationContext.templateMap.put("currentDate_strtTime_PM", dateFormat.format(currentDate) + "T12:00:00");
        applicationContext.templateMap.put("currentDate_endTime_PM", dateFormat.format(currentDate) + "T15:00:00");

        applicationContext.templateMap.put("currentDate_strtTime_PM_", dateFormat.format(currentDate) + "T12:05:00");
        applicationContext.templateMap.put("currentDate_endTime_PM_", dateFormat.format(currentDate) + "T12:25:00");

        applicationContext.templateMap.put("currentDate_Time", dateFormat.format(currentDate) + "T00:00:00");
        //applicationContext.templateMap.put("items1", "102370141");
       // applicationContext.templateMap.put("items2", "102370230");

        //=====================================
         if (scanMode.equalsIgnoreCase("List") && countType.equalsIgnoreCase("AM")){
            log.info("Getting Response for " + GET_STOREWALKS_SERVICE_BASE_URL + "stores/storewalks");
            JSONObject jsonObject = new WebServicesUtilities().parseJSON(filePath, applicationContext.templateMap);
            String body = jsonObject.toString();
             sName = (String) jsonObject.get("name");
             System.out.println("Name is " + sName);
            jsonResponseString = WebServicesUtilities.retryPOSTRequest(GET_STOREWALKS_SERVICE_BASE_URL, "/stores/" + storeID + "/storewalks", "apikey", "ZwQGsEN0f65kORZ8EVQlJWA2bGNbHls0", "Authorization", "Bearer " + loginStepDef.accessToken, body);
        }
        if (scanMode.equalsIgnoreCase("Scan") && countType.equalsIgnoreCase("AM")){
            log.info("Getting Response for " + GET_STOREWALKS_SERVICE_BASE_URL + "stores/storewalks");
            JSONObject jsonObject = new WebServicesUtilities().parseJSON(filePath, applicationContext.templateMap);
            String body = jsonObject.toString();
            System.out.println("CreateCount body " + body);
            sName = (String) jsonObject.get("name");
            System.out.println("Name is " + sName);
            jsonResponseString = WebServicesUtilities.retryPOSTRequest(GET_STOREWALKS_SERVICE_BASE_URL, "/stores/" + storeID + "/storewalks", "apikey", "ZwQGsEN0f65kORZ8EVQlJWA2bGNbHls0", "Authorization", "Bearer " + loginStepDef.accessToken, body);
        }

        if (scanMode.equalsIgnoreCase("List") && countType.equalsIgnoreCase("PM")){
            log.info("Getting Response for " + GET_STOREWALKS_SERVICE_BASE_URL + "stores/storewalks");
            JSONObject jsonObject = new WebServicesUtilities().parseJSON(filePath, applicationContext.templateMap);
            String body = jsonObject.toString();
            sName = (String) jsonObject.get("name");
            System.out.println("Name is " + sName);
            jsonResponseString = WebServicesUtilities.retryPOSTRequest(GET_STOREWALKS_SERVICE_BASE_URL, "/stores/" + storeID + "/storewalks", "apikey", "ZwQGsEN0f65kORZ8EVQlJWA2bGNbHls0", "Authorization", "Bearer " + loginStepDef.accessToken, body);
        }
        if (scanMode.equalsIgnoreCase("Scan") && countType.equalsIgnoreCase("PM")){
            log.info("Getting Response for " + GET_STOREWALKS_SERVICE_BASE_URL + "stores/storewalks");
            JSONObject jsonObject = new WebServicesUtilities().parseJSON(filePath, applicationContext.templateMap);
            String body = jsonObject.toString();
            sName = (String) jsonObject.get("name");
            System.out.println("Name is " + sName);
            jsonResponseString = WebServicesUtilities.retryPOSTRequest(GET_STOREWALKS_SERVICE_BASE_URL, "/stores/" + storeID + "/storewalks", "apikey", "ZwQGsEN0f65kORZ8EVQlJWA2bGNbHls0", "Authorization", "Bearer " + loginStepDef.accessToken, body);
        }
          System.out.println("CreateCount Response " + jsonResponseString);
    }


    public void generateCount(String mode, String endpoint,String countType, String storeId, String filePath) throws IOException, ParseException, InterruptedException {
        endpoint = endpoint + "/" + storeId;
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(filePath));

        JSONObject jsonObject = (JSONObject) obj;
        System.out.println(jsonObject);
        String body = jsonObject.toString();
        String jsonResponseString = WebServicesUtilities.retryPOSTRequest(LoginStepDef.LOGIN_SERVICE_BASE_URL_UAT, endpoint, "apikey", "ZwQGsEN0f65kORZ8EVQlJWA2bGNbHls0", body);
    }

    public String getAccessToken(String filePath) throws IOException, InterruptedException, ParseException {
        log.info("Getting Response for " + LoginStepDef.LOGIN_SERVICE_BASE_URL_UAT + "login");
        JSONObject jsonObject = new WebServicesUtilities().parseJSON(filePath, applicationContext.templateMap);
        String body = jsonObject.toString();
        String jsonResponseString = WebServicesUtilities.retryPOSTRequest(LoginStepDef.LOGIN_SERVICE_BASE_URL_UAT, "login", "apikey", "ZwQGsEN0f65kORZ8EVQlJWA2bGNbHls0", body);
        String accessToken = new LoginService().getLoginResponse(jsonResponseString).getAccessToken();
        log.info("ACCESS TOKEN : " + accessToken);
        return accessToken;
    }
}