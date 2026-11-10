package com.morrisons.common.utility;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WebServicesRetry {
    public static Logger log = LoggerFactory.getLogger(WebServicesRetry.class);
    public static Integer responseCode =null;
    public static Response retryGet(String uri, RequestSpecification request, int expected, int retries) throws InterruptedException {
        Response testResponse = null;
        for (int x = 1; x < retries + 1; x++) {
            log.info("Get responce for url" + uri + request + "." + x);
            testResponse = request.get(uri).then().extract().response();
            responseCode=testResponse.getStatusCode();
            if (testResponse.getStatusCode() == expected) {
                return testResponse;
            }
            Thread.sleep(2000);
            if (x == retries) {
                //Assert.fail("Failed to get a proper response.");
            }
        }
        return testResponse;
    }

    public static Response retryPOST(String uri, RequestSpecification request, int expected, int retries) throws InterruptedException {
        Response testResponse = null;
        for (int x = 1; x < retries + 1; x++) {
            log.info("POST responce for url" + uri + request + "." + x);
            testResponse = request.post(uri).then().extract().response();
            responseCode=testResponse.getStatusCode();
            if (testResponse.getStatusCode() == expected || testResponse.getStatusCode() == 200 ) {
                return testResponse;
            }
            Thread.sleep(2000);
            if (x == retries) {
               // Assert.fail("Failed to get a proper response.");
            }
        }
        return testResponse;
    }

    public static Response retryPATCH(String uri, RequestSpecification request, int expected, int retries) throws InterruptedException {
        Response testResponse = null;
        for (int x = 1; x < retries + 1; x++) {
            log.info("POST responce for url" + uri + request + "." + x);
            testResponse = request.patch(uri).then().extract().response();
            responseCode=testResponse.getStatusCode();
            if (testResponse.getStatusCode() == expected || testResponse.getStatusCode() == 200 ) {
                return testResponse;
            }
            Thread.sleep(2000);
            if (x == retries) {
                // Assert.fail("Failed to get a proper response.");
            }
        }
        return testResponse;
    }

    public static Response retryPOST1(String uri, RequestSpecification request, int expected, int retries) throws InterruptedException {
        Response testResponse = null;
        for (int x = 1; x < retries + 1; x++) {
            log.info("POST responce for url" + uri + request + "." + x);
            testResponse = request.post(uri).then().extract().response();
            if (testResponse.getStatusCode() == expected) {
                return testResponse;
            }
            Thread.sleep(2000);
            if (x == retries) {
                Assert.fail("Failed to get a proper response.");
            }
        }
        return testResponse;
    }

    public static Response retryPUT(String uri, RequestSpecification request, int expected, int retries) throws InterruptedException {
        Response testResponse = null;
        for (int x = 1; x < retries + 1; x++) {
            log.info("PUT responce for url" + uri + request + "." + x);
            testResponse = request.put(uri + "/1").then().extract().response();
            if (testResponse.getStatusCode() == expected) {
                return testResponse;
            }
            Thread.sleep(2000);
            if (x == retries) {
               // Assert.fail("Failed to get a proper response.");
            }
        }
        return testResponse;
    }

    public static Response retryDELETE(String uri, RequestSpecification request, int expected, int retries) throws InterruptedException {
        Response testResponse = null;
        for (int x = 1; x < retries + 1; x++) {
            log.info("DELETE response for url" + uri + request + "." + x);
            testResponse = request.delete(uri).then().extract().response();
            responseCode=testResponse.getStatusCode();
            if (testResponse.getStatusCode() == expected) {
                return testResponse;
            }
            Thread.sleep(2000);
            if (x == retries) {
                Assert.fail("Failed to get a proper response.");
            }
        }
        return testResponse;
    }
    public static Response retryGetwith(String uri, RequestSpecification request, int expectedCode,int expectedCode2, int retries) throws InterruptedException {
        Response testResponse = null;
        for (int x = 1; x < retries + 1; x++) {
            log.info("Get responce for url" + uri + request + "." + x);
            testResponse = request.get(uri).then().extract().response();
            if (testResponse.getStatusCode() == expectedCode||testResponse.getStatusCode() == expectedCode2) {
                responseCode=testResponse.getStatusCode();
                return testResponse;
            }
            Thread.sleep(2000);
            if (x == retries) {
               // Assert.fail("Failed to get a proper response.");
            }
        }
        return testResponse;
    }

}
