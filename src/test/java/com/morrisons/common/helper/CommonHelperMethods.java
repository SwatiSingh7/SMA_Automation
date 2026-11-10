package com.morrisons.common.helper;

import com.morrisons.common.PageFactory.InitClass;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

import static com.morrisons.common.utility.ApplicationContext.applicationConfig;

//import static com.morrisons.common.helper.clickElement;


public class CommonHelperMethods {
    static String env = applicationConfig.getWebElementEnviroment().getEnv();
    private static final Logger log = Logger.getLogger(CommonHelperMethods.class);
    public static String Currentyear = null;
    public static String weekOftheYear = null;


    public static void selectOption(WebDriver dr, WebElement optionElement, String optionString) {
        verifyIfDisplayed(dr, optionElement, optionString);
        optionElement.click();
    }

    public static void clickObject(AndroidDriver dr, WebElement optionElement) throws InterruptedException {
                com.morrisons.common.helper.ElementRetry.waitForElementVisible(dr, optionElement);
                optionElement.click();
    }

    public static void clickDynamicObject(AndroidDriver dr, WebElement optionElement) throws InterruptedException {
        com.morrisons.common.helper.ElementRetry.waitForElementVisible(dr, optionElement);
            Actions ac = new Actions(dr);
            ac.moveToElement(optionElement).click().build().perform();

    }
    public static WebElement createDynamicObj(AndroidDriver dr,WebElement oEle, String sObjName, String elementName) throws InterruptedException {
        String sClassName = null;
        Thread.sleep(1000);
        try {
            sClassName = oEle.getAttribute("class");
        }
        catch(StaleElementReferenceException se){
            int repeat = 0;
            while(repeat<3) {
                try {
                    sClassName = oEle.getAttribute("class");
                }
                catch(StaleElementReferenceException se1) {
                }
                repeat++;
                }
            }        
        List<WebElement> oListEle = dr.findElements(By.className(sClassName));
        Actions actionObject = new Actions(dr);
        boolean bFound = false;
        for(int i=0;i<oListEle.size();i++){
            List<WebElement> oListTextELe = oListEle.get(i).findElements(By.className("android.widget.TextView"));
            for(int j=0;j<oListTextELe.size();j++) {
                if (oListTextELe.get(j).getText().equalsIgnoreCase(sObjName)) {
                    bFound = true;
                    int k=0;
                    while(!oListTextELe.get(j+k).getText().equalsIgnoreCase(elementName)) {
                        k++;
                    }
                    oEle = oListTextELe.get(j+k);
                    break;
                }
            }
            actionObject = actionObject.sendKeys(Keys.ARROW_DOWN); //ASSIGN the return or you lose this event.
            actionObject.perform();
            if(bFound == true){
                break;
            }
        }
        return oEle;
    }

    public static void EnterData(AndroidDriver dr, WebElement optionElement, String data) throws InterruptedException {
        com.morrisons.common.helper.ElementRetry.waitForElementVisible(dr, optionElement);
        optionElement.sendKeys(data);
    }

    public static void verifyIfDisplayed(WebDriver dr, WebElement element, String expectedValue) {
        log.info("Verifying if displayed : " + expectedValue);
        //String actualText = getText(dr, element);
        String actualText = element.getText();
        log.info("Actual Text : " + actualText);
        Assert.assertEquals(actualText, expectedValue);
    }

    public static void verifyIfNotDisplayed(WebDriver dr, WebElement element, String expectedValue) {
        log.info("Verifying if displayed : " + expectedValue);
        String actualText = null;
        try {
            element.isDisplayed();
            log.info("element.isDisplayed()" + element.isDisplayed());

            Assert.fail(expectedValue + "is displayed");
        } catch (Exception e) {
            log.info("Option not displayed : " + expectedValue);
        }
    }

    public static void verifyIfDisplayed(WebDriver dr, By xpath, String expectedValue) {
        log.info("Xpath : " + xpath);
        String actual = dr.findElement(xpath).getText();
        log.info("Actual Value : " + actual);
        log.info("Expected Value : " + expectedValue);
        Assert.assertEquals(actual, expectedValue);
    }

    public static void verifyIfDisplayed(WebDriver dr, WebElement element) {
        log.info("Verifying if displayed");
        boolean isDisplayed = element.isDisplayed();
        if (isDisplayed) {
            log.info("Element Displayed");
        } else {
            Assert.fail("Element Not Displayed");
        }
    }

    public static void verifyButtonStatus(WebElement button, String status) throws InterruptedException {
        log.info("Verifying button status..");
        Thread.sleep(3000);
        SoftAssert softAssert = new SoftAssert();
        switch (status) {
            case "Enable":
                if (button.isEnabled() == true)
                    log.info("Button is Enabled");
                else
                    softAssert.fail("Button is Disabled");
                break;

            case "Disable":
                if (button.isEnabled() == false)
                    log.info("Button is Disabled");
                else
                    softAssert.fail("Button is Enabled");
                break;
            default:
                Assert.fail("No such button : " + button);
        }
    }

    public static String getWeekoftheyear() throws InterruptedException {
        log.info("Getting Current week number in a year");
        Calendar calendar = Calendar.getInstance(Locale.UK);
        int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
        weekOftheYear = String.valueOf(weekOfYear);
        log.info("Today is " + weekOftheYear + " week of the year");
        return weekOftheYear;
    }

    public static String getYear() throws InterruptedException {
        log.info("Getting current year");
        Currentyear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
        log.info("Current year is " + Currentyear);
        return Currentyear;
    }

    public static String changeDateFormat(String date1) throws ParseException {
        log.info("Changing date format");
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(date1);
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formatedDate = sdf.format(date);
        return formatedDate;
    }

    public static LocalDateTime getCurrentDate() throws InterruptedException {
        log.info("Getting current date");
        LocalDateTime today = LocalDateTime.now();
        log.info("Current date is " + today);
        return today;
    }

    public static List<String> SplitString(String itemIDList) throws InterruptedException {
        log.info("Getting current date");
        List<String> productList = Arrays.asList(itemIDList.split(","));
        log.info("Current date is " + productList);
        return productList;
    }

    public static void verifyFieldIsDisabled(WebElement element) {
        log.info("Checking item is in disabled mode: ");
        if(element.isSelected()==false)
            log.info(element + "Element is not clickable");
        else {
            Assert.fail(element + "Element is clickable");
            log.info(element + "Element is clickable. Condition failed");
        }
    }

    public static String getText(AndroidDriver driveR, WebElement oEle) {
        String sTextCaptured;
        sTextCaptured = oEle.getText();
        return sTextCaptured;
    }

    public static WebElement createDynamicObj(AndroidDriver driveR, WebElement oEle, String sObjName) throws InterruptedException {
        String sStrEle = oEle.toString();  //android.widget.EditText[@resource-id='ToReplace:id/quantityEditText']
        if(sStrEle.contains("ToReplace")){
            String[] arrStrEle = sStrEle.split("[ ]");
            String sLocator,sLocatorVal;
            sLocator = arrStrEle[arrStrEle.length-2];
            sLocatorVal = arrStrEle[arrStrEle.length-1];
            sLocatorVal = sLocatorVal.replaceAll("ToReplace",env);
            sLocatorVal = sLocatorVal.substring(0,sLocatorVal.length()-1);
            System.out.println("sLocator " + sLocator);
            System.out.println("sLocatorVal " + sLocatorVal);
            oEle = driveR.findElement(By.xpath(sLocatorVal));
        }
        else if(sStrEle.contains("Locator")){
            //oEle.toString().replaceAll("Locator",sObjName);
            String[] arrStrEle = sStrEle.split("[ ]");
            String sLocator,sLocatorVal;
            sLocator = arrStrEle[arrStrEle.length-2];
            sLocatorVal = arrStrEle[arrStrEle.length-1];
            sLocatorVal = sLocatorVal.replaceAll("Locator",sObjName);
            sLocatorVal = sLocatorVal.substring(0,sLocatorVal.length()-1);
            System.out.println("sLocator " + sLocator);
            System.out.println("sLocatorVal " + sLocatorVal);
            oEle = driveR.findElement(By.xpath(sLocatorVal));
        }
        com.morrisons.common.helper.ElementRetry.waitForElementVisible(driveR,oEle);
        return oEle;
    }

    public static WebElement createDynamicObj7(WebDriver driveR, WebElement oEle, String ss, String sObjName) {
        String[] arrObjName = ss.split("[~]");
        String sStrEle = arrObjName[0];
        if(sStrEle.contains("ToReplace")){
            sStrEle = sStrEle.replace("ToReplace",env);
        }
        if(sStrEle.contains("Locator")){
            sStrEle = sStrEle.replace("Locator",sObjName);
        }
        WebElement oELe;
        oELe =driveR.findElement(By.xpath(sStrEle));
        return oELe;
    }
    //===============================================================
    public static WebElement createDynamicObj7(WebDriver driveR, WebElement oEle, String ss) {
        String[] arrObjName = ss.split("[~]");
        String sStrEle = arrObjName[0];
        if(sStrEle.contains("ToReplace")){
            sStrEle = sStrEle.replace("ToReplace",env);
        }
        WebElement oELe;
        WebDriverWait w = new WebDriverWait(driveR, 10);
        w.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(sStrEle)));
        oELe =driveR.findElement(By.xpath(sStrEle));
        return oELe;
    }
    //==================================================================

    public static List<WebElement> createDynamicListObj7(WebDriver driveR, String ss, String sObjName) {
        String[] arrObjName = ss.split("[~]");
        String sStrEle = arrObjName[0];
        if(sStrEle.contains("ToReplace")){
            sStrEle = sStrEle.replace("ToReplace",env);
        }
        if(sStrEle.contains("Locator")){
            sStrEle = sStrEle.replace("Locator",sObjName);
        }
        List<WebElement> oELe;
        oELe =driveR.findElements(By.xpath(sStrEle));
        return oELe;
    }

    //====================================================
    public static List<WebElement> createDynamicListObj7(WebDriver driveR, String ss) {
        String[] arrObjName = ss.split("[~]");
        String sStrEle = arrObjName[0];
        if(sStrEle.contains("ToReplace")){
            sStrEle = sStrEle.replace("ToReplace",env);
        }
        List<WebElement> oELe;
        oELe =driveR.findElements(By.xpath(sStrEle));
        return oELe;
    }
    //====================================================

    public static List<WebElement> createDynamicListObj(WebDriver dr, WebElement oEle, String sObjName) {
        String sLocator = oEle.toString();
        System.out.println(sLocator);
        String[] arrLocator = sLocator.split("->");
        String sLocatorDetails,sLocatorVal = null;
        if(arrLocator.length>1) {
            sLocatorDetails = arrLocator[1];
        }
        else{
            sLocatorDetails = sLocator;
        }
        String[] arrLocatorDetails = sLocatorDetails.split("xpath");
        if(arrLocatorDetails.length>1) {
           sLocatorVal = arrLocatorDetails[2];
           sLocatorVal = sLocatorVal.substring(2,sLocatorVal.length()-1);
        }
        else{
            sLocatorVal = arrLocatorDetails[arrLocatorDetails.length-1];
        }
        if(sLocatorVal.contains("Locator")){
            sLocatorVal = sLocatorVal.replace("Locator",sObjName);
        }
        List<WebElement> oEle1 = dr.findElements(By.xpath(sLocatorVal.trim()));
        return oEle1;
    }

    public static WebElement createDynamicObj(WebDriver dr, WebElement oEle, String sObjName) {
        String sLocator = oEle.toString();
        System.out.println(sLocator);
        String[] arrLocator = sLocator.split("->");
        String sLocatorDetails,sLocatorVal = null;
        if(arrLocator.length>1) {
            sLocatorDetails = arrLocator[1];
        }
        else{
            sLocatorDetails = sLocator;
        }
        String[] arrLocatorDetails = sLocatorDetails.split("xpath");
        if(arrLocatorDetails.length>1) {
            sLocatorVal = arrLocatorDetails[1];
            sLocatorVal = sLocatorVal.substring(2,sLocatorVal.length()-1);
        }
        else{
            sLocatorVal = arrLocatorDetails[arrLocatorDetails.length-1];
        }
        if(sLocatorVal.contains("Locator")){
            sLocatorVal = sLocatorVal.replace("Locator",sObjName);
        }
        WebElement oEle1 = dr.findElement(By.xpath(sLocatorVal.trim()));
        return oEle1;
    }
    public static void VerifyObject(WebDriver dr, WebElement oEle, String sLocatorName) {
        Assert.assertEquals(oEle.isDisplayed(),true,sLocatorName + " Element does not exist in the app");
    }

    public static void ClickObject(AndroidDriver driveR, String sObjName, String sLocatorName, String sPageName) throws InterruptedException {
           Thread.sleep(5000);
            int repeat = 0;
            boolean boolSts = true;
            clickObj: while (boolSts == true) {
                try {
                    WebElement oEle = InitClass.createObject(driveR, sObjName, sLocatorName, "com.morrisons.sma.page_objects.mobile." + sPageName);
                    CommonHelperMethods.clickObject(driveR, oEle);
                } catch (NoSuchElementException ne) {
                    if (repeat < 2) {
                        repeat++;
                        driveR.hideKeyboard();
                        driveR.hideKeyboard();
                        continue clickObj;
                    }
                    else{
                        Assert.fail(ne.getMessage());
                        boolSts = false;
                        break clickObj;
                    }
                } catch (NoSuchFieldException | ClassNotFoundException | InstantiationException |
                         IllegalAccessException |
                         NoSuchMethodException | InvocationTargetException e) {
                        boolSts = false;
                        throw new RuntimeException(e);
                }
                boolSts = false;
                break clickObj;
            }
        }

    public static void VerifyObject(AndroidDriver driveR, WebElement oEle) {
        Assert.assertEquals(oEle.isDisplayed(),true,oEle + " Element does not exist in the app");
    }

    public static void VerifyErrorMesg(AndroidDriver driveR, List<WebElement> oLi, List<WebElement> oLi1, String errorMsg) throws InterruptedException, NoSuchFieldException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        String sMsg = null,sMsg1 = null,expMsg = "",expMsg1 = "";
        boolean found = false;
        Thread.sleep(2000);
        try {
            for (int i = 0; i < oLi.size(); i++) {
                sMsg = oLi.get(i).getText();
                if (!sMsg.isEmpty() && sMsg.matches(".*[a-zA-Z].*") && !expMsg.contains(sMsg)) {
                    expMsg = expMsg + sMsg + "\n";
                }
            }
            for (int j = 0; j < oLi1.size(); j++) {
                sMsg1 = oLi1.get(j).getText();
                if (!sMsg1.isEmpty() && sMsg1.matches(".*[a-zA-Z].*") && !expMsg1.contains(sMsg1)) {
                    expMsg1 = expMsg1 + sMsg1 + "\n";
                }
            }
            System.out.println(expMsg1.substring(0,expMsg1.length()-1));
            expMsg1 = expMsg1.substring(0,expMsg1.length()-1);
            Assert.assertEquals(expMsg + expMsg1, errorMsg, "Error message did not match expected " + errorMsg + "actual " + expMsg + expMsg1);
        }
        catch(Exception r){
            List<WebElement> oListEle = InitClass.createMultipleObjects(driveR, "oButton", "OK", "com.morrisons.sma.page_objects.mobile.MOCO." + "ManagerOrderPage");
            if(oListEle.size()>0) {
                CommonHelperMethods.ClickObject(driveR, "oButton", "OK", "MOCO." + "ManagerOrderPage");
                throw r;
            }
        }
    }

    public static void VerifyObjectNotFound(AndroidDriver driveR, WebElement oEle) {
        Assert.assertEquals(oEle.isDisplayed(),false,oEle + " Element exist in the app");
    }
}