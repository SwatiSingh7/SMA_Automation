package com.morrisons.sma.page_objects.service.range;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.morrisons.common.helper.WebServiceHelper;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import com.morrisons.common.utility.WebServiceClient;
import com.morrisons.sma.pojo.service.range.Clearance;
import com.morrisons.sma.pojo.service.range.Range;
import com.morrisons.sma.pojo.service.range.RangeRoot;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RangePO {

    static ObjectMapper objectMapper = new ObjectMapper();
    public static HttpResponse Response;
    public static io.restassured.response.Response restResponse;

    public static RangeRoot getRangeJsonResponse = new RangeRoot();
    private static final Logger log = Logger.getLogger(RangePO.class);
    private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();

    private static final String baseURI = applicationConfig.getWebElementEnviroment().getBaseURI();
    private static final String resource = applicationConfig.getGetRange().getResource();

    public static URI currentUri;
    public static Map<String, String> headers = new HashMap<>();
    public static HttpResponse httpResponse = null;


    public static String wastageFrom = null;
    public static String wastageTo= null;

    public static String wastageFromDate = null;
    public static String wastageToDate= null;
    public static String clearanceStatus = null;
    public static String wastage = null;
    public String uriResource = null;

    public void setResource(){
        uriResource = resource;
        log.error("uriResource : " + uriResource);
    }

    public void createRangeUrl(String storeId, String productId) throws URISyntaxException {
        setResource();
        uriResource = uriResource.replaceAll("\\bstoreId\\b", storeId);
        uriResource = uriResource.replaceAll("\\bproductId\\b", productId);
        log.error("Generated resource : " + uriResource);
        String queryparameter = applicationConfig.getLoginServiceMarkdown().getQueryParameter();
        currentUri = WebServiceHelper.createURL(baseURI,uriResource,queryparameter);
        log.error("Generated URI : " + currentUri);
    }


    public HttpResponse getResponse() throws ClientProtocolException, IOException {
        headers = WebServiceHelper.contentTypeHeader();
        headers = WebServiceHelper.authorizationHeader();

        if (currentUri != null)
            httpResponse = WebServiceClient.getMethodResponse(currentUri, headers);
        else {
            log.error("URL value is missing. Please send valid URL to perform operation");
            Assert.fail("URL value is missing. Please send valid URL to perform operation");
        }
        return httpResponse;
    }



    public static void getRangeServiceResponse() throws Throwable {
        getRangeJsonResponse = null;
        getRangeJsonResponse = objectMapper.readValue(httpResponse.getEntity().getContent(), RangeRoot.class);
        String ProductJSONresult = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(getRangeJsonResponse);
        log.info("Get Range Response:\n" + ProductJSONresult);

        List<Range> rangeList = getRangeJsonResponse.getRange();
        for (Range range : rangeList) {
            int locationId = range.getLocationId();
            log.info("Location ID : " + locationId);
            String itemNumber = range.getItemNumber();
            log.info("Item number : " + itemNumber);
            String status = range.getStatus();
            log.info("Status : " + status);
            String dateFrom = range.getDateFrom();
            log.info("Date from : " + dateFrom);
            String dateTo = range.getDateTo();
            log.info("Date to : " + dateTo);
            String source = range.getSource();
            log.info("Source : " + source);

            try {
                Clearance clearanceResponce = range.getClearance();
                clearanceStatus = clearanceResponce.getStatus();
                log.info("Clearance status : " + clearanceStatus);
                String clearanceDateFrom = clearanceResponce.getDateFrom();
                log.info("Clearance Date from : " + clearanceDateFrom);
                String clearanceDateTo = clearanceResponce.getDateTo();
                log.info("Clearance Date to : " + clearanceDateTo);
                wastage = clearanceResponce.getWastage();
                log.info("Wastage : " + wastage);
                wastageFrom = clearanceResponce.getWastageFrom();
                log.info("Wastage From : " + wastageFrom);
                wastageTo = clearanceResponce.getWastageTo();
                log.info("Wastage To : " + wastageTo);
            }
            catch(Exception e){

            }
        }
    }

    public String changeDateFormat(String date) throws ParseException {
        Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(date);

        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String date2 = formatter.format(date1);
        log.info("Date in ddMMyyyy format : " + date2);
        return date2;
    }

    public void getWastageDateRange() throws ParseException {
        wastageFromDate =  changeDateFormat(wastageFrom);
        log.info("Wastage From in ddMMyyyy format : " + wastageFromDate);
        wastageToDate = changeDateFormat(wastageTo);
        log.info("Wastage To in ddMMyyyy format : " + wastageTo);
    }

    public void verifyClearanceStatus(String status) {
        log.info("Verifying Clearance Status");
        Assert.assertEquals(clearanceStatus, status);
    }

    public void verifyWastageStatus(String status) {
        log.info("Verifying Wastage Status");
        Assert.assertEquals(wastage, status);
    }
}