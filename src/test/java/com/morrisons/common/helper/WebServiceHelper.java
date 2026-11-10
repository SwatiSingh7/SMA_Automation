package com.morrisons.common.helper;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.morrisons.common.utility.CloseableHttpClientBuilder;
import com.morrisons.sma.page_objects.service.login.LoginPO;
import org.testng.Assert;

public class WebServiceHelper{

    private static CloseableHttpClientBuilder cc = new CloseableHttpClientBuilder();
    public static Map<String, String> headers = new HashMap<>();
    public static URI currentUri;
    private final static Logger log = Logger.getLogger(WebServiceHelper.class);
    public static ObjectMapper objectMapper = new ObjectMapper();
    public static HttpResponse httpResponse = null;
    public static Object object1 = null;
    public static HttpGet getRequest = null;
    public static HttpPost postRequest = null;
    public static HttpPatch patchRequest = null;
    public static HttpPut putRequest = null;
    public static HttpDelete deleteRequest = null;


    private static void generateHeader(String requestType,URI uri,Map<String,String> headerMap) throws IOException {
        String headerKey="";
        String headerValue="";

        Iterator entries = headerMap.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();
            headerKey = (String) entry.getKey();
            headerValue = (String) entry.getValue();
            log.info("Key = " + headerKey + ", Value = " + headerValue);

            switch (requestType) {
                case "GET":
                    getRequest = new HttpGet(uri);
                    getRequest.addHeader(headerKey, headerValue);
                    break;
                case "POST":
                    postRequest = new HttpPost(uri);
                    postRequest.addHeader(headerKey, headerValue);
                    break;
                case "PATCH":
                    patchRequest = new HttpPatch(uri);
                    patchRequest.addHeader(headerKey, headerValue);
                    break;
                case "PUT":
                    putRequest = new HttpPut(uri);
                    putRequest.addHeader(headerKey, headerValue);
                    break;
                case "DELETE":
                    deleteRequest = new HttpDelete(uri);
                    deleteRequest.addHeader(headerKey, headerValue);
                    break;
                default:
                    log.error("No such Request Type : " + requestType);
                    Assert.fail("No such Request type : " + requestType);
            }
        }
    }


    public static HttpResponse getMethodResponse(URI uri,Map<String,String> headerMap) throws ClientProtocolException, IOException   {
        HttpClient client = cc.build();
        generateHeader("GET",uri,headerMap);
        log.info("\n\t-----------------Executing request-----------------\n"+"\n" + getRequest.getRequestLine());
        HttpResponse response = client.execute(getRequest);
        return response;
    }

    public static HttpResponse postMethodResponse(URI uri,Map<String,String> headerMap,String postPayload) throws ClientProtocolException, IOException {
        HttpClient client = cc.build();
        generateHeader("POST",uri,headerMap);
        postRequest.setEntity(new StringEntity(postPayload));
        log.info("\n\t-----------------Executing request-----------------\n"+"\n" + postRequest.getRequestLine());

        HttpResponse response = client.execute(postRequest);
        return response;
    }
    public static HttpResponse patchMethod(URI uri,Map<String,String> headerMap,String patchPayload) throws ClientProtocolException, IOException  {
        HttpClient client = cc.build();
        generateHeader("PATCH",uri,headerMap);
        log.info("\n\t-----------------Executing request-----------------\n"+"\n" + patchRequest.getRequestLine());

        patchRequest.setEntity(new StringEntity(patchPayload));
        HttpResponse response = client.execute(patchRequest);

        return response;
    }

    public static HttpResponse putMethodResponse(URI uri,Map<String,String> headerMap,String putPayload) throws ClientProtocolException, IOException    {
        HttpClient client = cc.build();
        generateHeader("PUT",uri,headerMap);
        putRequest.setEntity(new StringEntity(putPayload));
        log.info("\n\t-----------------Executing request-----------------\n"+"\n" + putRequest.getRequestLine());

        HttpResponse response = client.execute(putRequest);

        return response;

    }
    public static HttpResponse deleteMethod(URI uri,Map<String,String> headerMap) throws ClientProtocolException, IOException
    {
        HttpClient client = cc.build();
        generateHeader("DELETE",uri,headerMap);
        log.info("\n\t-----------------Executing request-----------------\n"+"\n" + deleteRequest.getRequestLine());
        HttpResponse response = client.execute(deleteRequest);

        return response;
    }

    //Set Header "Content-Type"
    public static Map<String, String> contentTypeHeader() {

        headers.put("Content-Type", "application/json");
        System.out.println(headers);
        return headers;
    }

    //Set Header "Authorization"
    public static Map<String, String> authorizationHeader() {
        String accessToken = LoginPO.accessTocken;

        headers.put("Authorization", "Bearer " + accessToken);
        log.info("Authorization header : " + headers);
        return headers;
    }

    ///To create API Url
    public static URI createURL(String baseURI, String resource, String queryParameter) throws URISyntaxException {

        URIBuilder uriBuilder = new URIBuilder(baseURI + resource);
        uriBuilder.setCustomQuery(queryParameter);
        currentUri = uriBuilder.build(); ///Creating URL
        log.info("Service Url : " + currentUri);

        return currentUri;
    }

    //To verify Status code
    public static void verifyStatusCode(HttpResponse response) throws Throwable{
        httpResponse = response;
        int apiStatusCode = response.getStatusLine().getStatusCode();
        int expectedStatusCode = 200;

        assertEquals(apiStatusCode, expectedStatusCode, "Status code mismatched");
    }
}