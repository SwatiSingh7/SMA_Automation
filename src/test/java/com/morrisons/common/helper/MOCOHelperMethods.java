package com.morrisons.common.helper;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.google.common.collect.ImmutableMap;
import com.morrisons.common.PageFactory.InitClass;
import com.morrisons.common.action.Hook;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.lang.reflect.InvocationTargetException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.TemporalAccessor;
import java.util.*;
import java.util.NoSuchElementException;

import io.cucumber.java.Scenario;
import org.testng.asserts.SoftAssert;

import javax.validation.constraints.AssertTrue;

public class MOCOHelperMethods {

    private static AndroidDriver driveR = null;
    public String dDateSelected;
    static int repeat = 0;

    static String sDateSelected;
    HashMap<String, HashMap> oProdDetails = new HashMap<String, HashMap>();
    static HashMap<String, String> oDateDetails = new HashMap<String, String>();
    public MOCOHelperMethods() {
        this.driveR = (AndroidDriver) Hook.getDriver();
    }

    public static void clickObject(String sObjName, String sPageName) throws Throwable {
        Thread.sleep(8000);
        String xpathbarcodeicon = "//android.widget.Button[contains(@text,'Barcode scan image')]";
        WebDriverWait w = new WebDriverWait(driveR, 10);
        w.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(xpathbarcodeicon)));
        driveR.findElement(By.xpath(xpathbarcodeicon)).click();
    }

    public void MOCOenterBarcode(String sdata, String barcode, String sPageName) throws Throwable {
        WebElement oEle = null;
        try {
            Thread.sleep(3000);
            oEle = InitClass.createObject(driveR, barcode, "com.morrisons.sma.page_objects.mobile.MOCO." + sPageName);
            com.morrisons.common.helper.ElementRetry.waitForElementVisible(driveR, oEle);
            oEle.sendKeys(sdata);

            Thread.sleep(3000);

            driveR.executeScript("mobile:performEditorAction", ImmutableMap.of("action", "search"));

            Thread.sleep(3000);
            //====================================
            int c = 0;
           BarcdEntry: do {
                try {
                    List<WebElement> oEle1 = InitClass.createMultipleObjects(driveR, "LstBarCodeEdit", "com.morrisons.sma.page_objects.mobile.MOCO." + sPageName);
                    System.out.println("oEle1.size() " + oEle1.size());
                    if (oEle1.size()>0) {
                        driveR.hideKeyboard();
                        Thread.sleep(2000);
                        driveR.executeScript("mobile:performEditorAction", ImmutableMap.of("action", "search"));
                        Thread.sleep(2000);
//                        Actions action = new Actions(driveR);
//                        action.sendKeys(Keys.ENTER).build().perform();
//                        Thread.sleep(2000);
                    } else {
                        break;
                    }
                } catch (java.util.NoSuchElementException o) {
                    break;
                } catch (Exception w) {
                    c++;
                    if(c<2){
                        continue;
                    }

                }
                c++;
            } while (c < 2);
            //======================================
        } catch (WebDriverException r) {
            int ctr = 0;
            driveR.executeScript("mobile:performEditorAction", ImmutableMap.of("action", "search"));
            Thread.sleep(2000);
            do {
                try {
                    if (oEle.isDisplayed()) {
                        driveR.executeScript("mobile:performEditorAction", ImmutableMap.of("action", "search"));
                        Thread.sleep(2000);
                    } else {
                        break;
                    }
                } catch (NoSuchElementException o) {
                    break;
                } catch (Exception w) {

                }
                ctr++;
            } while (ctr < 3);
        } catch (Exception q) {

        }
    }

    public void validateOrders(String sObj, String OrderDetails, String sPageName) throws NoSuchFieldException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, InterruptedException {
        Thread.sleep(3000);
        String[] arrOrderDetails = OrderDetails.split(",");
        for (int i = 0; i < arrOrderDetails.length; i++) {
            String sField = arrOrderDetails[i];
            String sFieldVal = null,sActualDt = "no";
            if(sField.contains(":")){
                String[] arrField = sField.split(":");
                sField = arrField[0];
                sFieldVal = arrField[1];
                if(sFieldVal.equalsIgnoreCase("runtimedate")){
                    sFieldVal = oDateDetails.get(sField);
                    sActualDt = "runtimedate";
                }
            }
            Scenario scenario = null;
            SoftAssert softAssert = new SoftAssert();
            List<WebElement> oEle = InitClass.createMultipleObjects(driveR, sObj, sField, "com.morrisons.sma.page_objects.mobile.MOCO." + sPageName);
            softAssert.assertTrue(oEle.size() > 0, "Field does not exists " + sField);
            element: for (int j = 0; j < oEle.size(); j++) {
                try{
                System.out.println("Field " + sField + " with value " + oEle.get(j).getText());
                if(sActualDt.equalsIgnoreCase("runtimedate")) {
                    sActualDt = oEle.get(j).getText();
                    String[] arrActualDt = sActualDt.split(":");
                    sActualDt = arrActualDt[1];
                    //======================
                    DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                            .parseCaseInsensitive()
                            .append(DateTimeFormatter.ofPattern("EEEE" + "," + " d MMMM"))
                            // use English Locale to correctly parse month and day of week
                            .toFormatter(Locale.ENGLISH);
                    TemporalAccessor parsed = formatter.parse(sFieldVal.trim());
                    MonthDay md = MonthDay.from(parsed);
                    DayOfWeek dow = DayOfWeek.from(parsed);
                    int sday = MonthDay.from(parsed).getDayOfMonth();
                    String ssow = dow.toString().substring(0,3);
                    ssow = Character.toUpperCase(ssow.charAt(0)) + ssow.substring(1).toLowerCase();
                    String sMonth = md.getMonth().toString().substring(0,3);
                    sMonth = Character.toUpperCase(sMonth.charAt(0)) + sMonth.substring(1).toLowerCase();
                    sFieldVal = ssow + " " + sday + " " + sMonth + " " + LocalDate.now().getYear();
                    System.out.println(sFieldVal);
                }
                    //=============================
//               scenario.log("Field " + sField + " with value " + oEle.get(j).getText());
                ExtentCucumberAdapter.addTestStepLog("Field " + sField + " with value " + oEle.get(j).getText());
                if (arrOrderDetails[i].contains(":")) {
                    List<WebElement> oEle1 = InitClass.createMultipleObjects(driveR, sObj, sField + ": " + sFieldVal, "com.morrisons.sma.page_objects.mobile.MOCO." + sPageName);
                    if(oEle1.size()>0) {
                        for (int k = 0; k < oEle1.size(); k++) {
                            System.out.println(oEle1.get(k).getText());
                            softAssert.assertEquals(oEle1.get(k).getText().contains(sFieldVal), true, " String : " + sFieldVal + " is not in the field " + oEle1.get(j).getText());
                            break element;
                        }
                    }
                    else{
                        softAssert.fail("Field with value " + sField + ": " + sFieldVal + " does not exist in the screen");
                    }
                }
            }
            catch(StaleElementReferenceException s){
                oEle = InitClass.createMultipleObjects(driveR, sObj, sField, "com.morrisons.sma.page_objects.mobile.MOCO." + sPageName);
                continue element;
            }
            }
        }
    }

    public void validateOrdersNotPresent(String sObj, String OrderDetails, String sPageName) throws NoSuchFieldException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, InterruptedException {
           Thread.sleep(3000);
            String[] arrOrderDetails = OrderDetails.split(",");
            for (int i = 0; i < arrOrderDetails.length; i++) {
                String sField = arrOrderDetails[i];
                String sFieldVal = null;
                if(sField.contains(":")){
                    String[] arrField = sField.split(":");
                    sField = arrField[0];
                    sFieldVal = arrField[1];
                }
                Scenario scenario = null;
                SoftAssert softAssert = new SoftAssert();
                List<WebElement> oEle = InitClass.createMultipleObjects(driveR, sObj, sField + ": " + sFieldVal, "com.morrisons.sma.page_objects.mobile.MOCO." + sPageName);
                softAssert.assertEquals(oEle.size() == 0, true, " String : " + sFieldVal + " is there in the review screen " + oEle.get(0).getText());
            }
    }

    public void ValidateDates(String oObj, String sDate, String NoofDays, String sPageName) throws NoSuchFieldException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        List<WebElement> oEle = InitClass.createMultipleObjects(driveR, oObj, sDate + ":", "com.morrisons.sma.page_objects.mobile.MOCO." + sPageName);
        Assert.assertTrue(oEle.size() > 0, "Field does not exists " + sDate);
        for (int j = 0; j < oEle.size(); j++) {
            System.out.println("Field " + sDate + " with value " + oEle.get(j).getText());
            LocalDate sActualDate = LocalDate.parse(oEle.get(j).getText());
            LocalDate currentDate = LocalDate.now();
            LocalDate sExpDate = currentDate.plusDays(Integer.valueOf(NoofDays));
            Assert.assertEquals(sExpDate, sActualDate, "Date " + sDate + " Doesn't match");
//               scenario.log("Field " + sField + " with value " + oEle.get(j).getText());
            ExtentCucumberAdapter.addTestStepLog("Field " + sDate + " with value " + oEle.get(j).getText());
        }
    }

    public void verifyDateRange(String rangeObj, int oRange, int dRange, String sPageName) throws NoSuchFieldException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, InterruptedException {
        try {
            LocalDate currentDate = LocalDate.now().plusDays(dRange);
            int dayNumberSuffix = currentDate.getDayOfMonth();
            String dayName = currentDate.getDayOfWeek().toString();
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("EEEE" + "," + " " + dayNumberSuffix + " MMMM");
            String dd = dateFormat.format(currentDate);
            System.out.println("Date " + dd);
            LocalDate sExpDate = currentDate.plusDays(Integer.valueOf(oRange));
            int dayNumberSuffix1 = sExpDate.getDayOfMonth();
            DateTimeFormatter dateFormat1 = DateTimeFormatter.ofPattern("EEEE" + "," + " " + dayNumberSuffix1 + " MMMM");
//        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(" d'" + "," +  dayNumberSuffix1 + "' MMMM");
            String dd1 = dateFormat1.format(sExpDate);
            String sFocusSts = null,sMonthFocusst;
            System.out.println("Date " + dd1);
            boolean boolSts = true;
            int cnt = 0;
            DateSelect:
            while (boolSts == true) {
                try {
                    Thread.sleep(2000);
                    sFocusSts = driveR.findElement(By.xpath("//android.widget.Button[contains(@text,'" + dd1 + "')]")).getAttribute("focusable");
                    System.out.println(sFocusSts);
                    boolSts = false;
                } catch (Exception e) {
                    if (cnt > 5) {
                        break;
                    }
                    sMonthFocusst = driveR.findElement(By.xpath("//android.widget.Button[contains(@text,'Next month')]")).getAttribute("enabled");
                    if(sMonthFocusst.equalsIgnoreCase("true")) {
                    driveR.findElement(By.xpath("//android.widget.Button[contains(@text,'Next month')]")).click();
                    }
                    else if(sMonthFocusst.equalsIgnoreCase("false")){
                        break;
                    }
                }
                cnt++;
            }
            Assert.assertEquals(sFocusSts, "true", sExpDate + " not is within limit");
        }
        catch(Exception rr){
            List<WebElement> oListEle = InitClass.createMultipleObjects(driveR, "oButton", "DONE", "com.morrisons.sma.page_objects.mobile.MOCO." + "ManagerOrderPage");
            if(oListEle.size()>0) {
                CommonHelperMethods.ClickObject(driveR, "oButton", "DONE", "MOCO." + "ManagerOrderPage");
            }
            throw rr;
        }
    }

    public void selectDate(int oRange) {
        LocalDate currentDate = LocalDate.now();
        int dayNumberSuffix = currentDate.getDayOfMonth();
        String dayName = currentDate.getDayOfWeek().toString();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("EEEE" + "," + " " + dayNumberSuffix + " MMMM");
        String dd = dateFormat.format(currentDate);
        System.out.println("Date " + dd);
        LocalDate sExpDate = currentDate.plusDays(Integer.valueOf(oRange));
        int dayNumberSuffix1 = sExpDate.getDayOfMonth();
        DateTimeFormatter dateFormat1 = DateTimeFormatter.ofPattern("EEEE" + "," + " " + dayNumberSuffix1 + " MMMM");
//        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(" d'" + "," +  dayNumberSuffix1 + "' MMMM");
        String dd1 = dateFormat1.format(sExpDate);
        dDateSelected = dd1;
        String sFocusSts = null, sMonthFocusst;
        System.out.println("Date " + dd1);
        dDateSelected = dd1;
        sDateSelected = dd1;
        boolean boolSts = true;
        int cnt = 0;
        DateSelect:
        while (boolSts == true) {
            try {
                driveR.findElement(By.xpath("//android.widget.Button[contains(@text,'" + dd1 + "')]")).click();
                sFocusSts = driveR.findElement(By.xpath("//android.widget.Button[contains(@text,'" + dd1 + "')]")).getAttribute("focusable");
                System.out.println(sFocusSts);
                boolSts = false;
            } catch (Exception e) {
                if (cnt > 5) {
                    break;
                }
                sMonthFocusst = driveR.findElement(By.xpath("//android.widget.Button[contains(@text,'Next month')]")).getAttribute("enabled");
                if(sMonthFocusst.equalsIgnoreCase("true")) {
                    driveR.findElement(By.xpath("//android.widget.Button[contains(@text,'Next month')]")).click();
                }
                else if(sMonthFocusst.equalsIgnoreCase("false")){
                    break;
                }
            }
            cnt++;
        }
    }

    public void verifyDateRangeNotWithinLimit(String rangeObj, int oRange, int dRange, String sPageName) throws NoSuchFieldException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, InterruptedException {
        {
            try {
                LocalDate currentDate = LocalDate.now().plusDays(dRange);
                int dayNumberSuffix = currentDate.getDayOfMonth();
                String dayName = currentDate.getDayOfWeek().toString();
                DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("EEEE" + "," + " " + dayNumberSuffix + " MMMM");
                String dd = dateFormat.format(currentDate);
                System.out.println("Date " + dd);
                LocalDate sExpDate = currentDate.plusDays(oRange + dRange);
                int dayNumberSuffix1 = sExpDate.getDayOfMonth();
                DateTimeFormatter dateFormat1 = DateTimeFormatter.ofPattern("EEEE" + "," + " " + dayNumberSuffix1 + " MMMM");
//        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(" d'" + "," +  dayNumberSuffix1 + "' MMMM");
                String dd1 = dateFormat1.format(sExpDate);
                String sFocusSts = null,sMonthFocusst;
                System.out.println("Date " + dd1);
                boolean boolSts = true;
                int cnt = 0;
                DateSelect:
                while (boolSts == true) {
                    try {
                        Thread.sleep(2000);
                        sFocusSts = driveR.findElement(By.xpath("//android.widget.Button[contains(@text,'" + dd1 + "')]")).getAttribute("focusable");
                        System.out.println(sFocusSts);
                        boolSts = false;
                    } catch (Exception e) {
                        if (cnt > 5) {
                            break;
                        }
                        sMonthFocusst = driveR.findElement(By.xpath("//android.widget.Button[contains(@text,'Next month')]")).getAttribute("enabled");
                        if(sMonthFocusst.equalsIgnoreCase("true")) {
                            driveR.findElement(By.xpath("//android.widget.Button[contains(@text,'Next month')]")).click();
                        }
                        else if(sMonthFocusst.equalsIgnoreCase("false")){
                            break;
                        }
                        continue DateSelect;
                    }
                    cnt++;
                }
                Assert.assertEquals(sFocusSts, "false", sExpDate + " is within limit");
            }
            catch(Exception rr){
                List<WebElement> oListEle = InitClass.createMultipleObjects(driveR, "oButton", "CANCEL", "com.morrisons.sma.page_objects.mobile.MOCO." + "ManagerOrderPage");
                if(oListEle.size()>0) {
                    CommonHelperMethods.ClickObject(driveR, "oButton", "CANCEL", "MOCO." + "ManagerOrderPage");
                }
                throw rr;
            }
        }
    }

    public void VerifySort(String oObj, String sObjectName, String StringsOrder, String sPageName) throws NoSuchFieldException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, InterruptedException {
        Thread.sleep(2000);
        List<WebElement> oLi = InitClass.createMultipleObjects(driveR, oObj, sObjectName, "com.morrisons.sma.page_objects.mobile.MOCO." + sPageName);
        ArrayList<Object> arrActualList = new ArrayList<Object>();
        for (int i = 0; i < oLi.size(); i++) {
            String ss = oLi.get(i).getText();
            String[] arrField1 = ss.split(":");
            arrActualList.add(arrField1[1].trim());
        }
        SortData oSD;
        try {
            Locale locale = new Locale("en");
            DateTimeFormatter dateFormat1 = (DateTimeFormatter.ofPattern("EEE" + " " + "d" + " MMM" + " yyyy",locale));
//            TemporalAccessor parsedDate = dateFormat1.parse(oLi.get(0).getText());
//            Format detectedFormat = dateFormat1.toFormat();
//            System.out.println("Detected format for " + oLi.get(0).getText() + ": " + detectedFormat);
            oSD = new SortDataDate();
            oSD.doSort(arrActualList,StringsOrder);
        } catch (Exception e) {
            System.out.println("Failed to detect format for " + oLi.get(0).getText());
            try {
                Integer.parseInt(arrActualList.get(0).toString());
                oSD = new SortDataInt();
                oSD.doSort(arrActualList, StringsOrder);
            } catch (Exception y) {
                oSD = new SortDataString();
                oSD.doSort(arrActualList, StringsOrder);
            }
        }
//        ArrayList<String> sortedList = new ArrayList<String>();
//        for (String s : arrActualList) {
//            sortedList.add(s);
//        }
//        if (StringsOrder.equalsIgnoreCase("acsending")) {
//            Collections.sort(sortedList);
//        }
//        junit.framework.Assert.assertTrue(sortedList.equals(arrActualList));
    }

    public void VerifySort(String oObj, String sObjectName, String oObj1, String sObjectName1, String StringsOrder, String sPageName) throws NoSuchFieldException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        List<WebElement> oLi = InitClass.createMultipleObjects(driveR, oObj, sObjectName, "com.morrisons.sma.page_objects.mobile.MOCO." + sPageName);
        List<WebElement> oLi1 = InitClass.createMultipleObjects(driveR, oObj1, sObjectName1, "com.morrisons.sma.page_objects.mobile.MOCO." + sPageName);
        ArrayList<String> arrActualList = new ArrayList<String>();
        for (int i = 0; i < oLi.size(); i++) {
            String ss = oLi.get(i).getText();
            String[] arrField1 = ss.split(":");
            arrActualList.add(arrField1[1] + "|" + oLi1.get(i).getText());
        }
        ArrayList<String> sortedList = new ArrayList<String>();
        ArrayList<String> sortedList1 = new ArrayList<String>();
        for(String s:arrActualList){
            sortedList.add(s);
        }
        Collections.sort(sortedList, new Comparator() {
            private final String KEY_NAME = sObjectName;
            @Override
            public int compare(Object a, Object b) {
                int k;
                String aStr = a.toString();
                String bStr = b.toString();
                int iSecondField = aStr.lastIndexOf('|');
                int iSecondField1 = bStr.lastIndexOf('|');
                aStr = aStr.substring(0,iSecondField);
                bStr = bStr.substring(0,iSecondField1);
//                int dayNumberSuffix = currentDate.getDayOfMonth();

                Locale locale = new Locale("en");
                DateTimeFormatter dateFormat1 = (DateTimeFormatter.ofPattern("EEE" + " " + "d" + " MMM" + " yyyy",locale));
                LocalDate localDate = LocalDate.parse(aStr.trim(),dateFormat1);
                LocalDate localDate1 = LocalDate.parse(bStr.trim(),dateFormat1);
//                aStr = dateFormat1.format(localDate);
//                bStr = dateFormat1.format(localDate1);
                if (StringsOrder.equalsIgnoreCase("asc")) {
                    k = localDate.compareTo(localDate1);
                    if(k==0)
                        return aStr.substring(iSecondField).compareTo(bStr.substring(iSecondField1));
                    else
                        return k;
                } else if (StringsOrder.equalsIgnoreCase("desc")) {
                    k= localDate1.compareTo(localDate);
                    if(k==0)
                        return bStr.substring(iSecondField1).compareTo(aStr.substring(iSecondField));
                    else
                        return k;
                }
                return 0;
            }
        });
        for(int i = 0; i < sortedList.size(); i++) {
            sortedList1.add(sortedList.get(i));
        }
        System.out.println(arrActualList + "| " + sortedList1);
        ExtentCucumberAdapter.addTestStepLog("Expected list  " + sortedList1.toString() + " Actual List  " + arrActualList.toString());
        junit.framework.Assert.assertTrue(sortedList1.equals(arrActualList));
    }

    public void DeleteItems(String oObj, String sObjectName, String sPageName) throws NoSuchFieldException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, InterruptedException {
        List<WebElement> oLi = InitClass.createMultipleObjects(driveR, oObj, sObjectName, "com.morrisons.sma.page_objects.mobile.MOCO." + sPageName);
        for(WebElement product : oLi){

            Thread.sleep(3000);
            TouchAction ts = new TouchAction(driveR);
            int x;
            int y;
           Actions act = new Actions(driveR);
           act.moveToElement(product,product.getLocation().x+50, product.getLocation().y).clickAndHold().moveByOffset(0,200).release().perform();
           Thread.sleep(1000);
            ts.press(PointOption.point(product.getLocation().x, product.getLocation().y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                    .moveTo(PointOption.point(0, product.getLocation().y)).release().perform();
            Thread.sleep(7000);
            List<WebElement> oLi1 = driveR.findElements(
                    By.xpath("//android.widget.Button[@index='0']"));
            oLi1.get(3)
                    .click();

        }
    }

    public void clickBack(String sObjectName, String sPageName) {
        boolean sStatus = false;
        int ctr=0;
        while(!sStatus && ctr<3) {
            ctr++;
            try {
                WebElement oEle = InitClass.createObject(driveR, "sLocatorName", sObjectName, "com.morrisons.sma.page_objects.mobile.CountsPO");
                if (oEle.isDisplayed() && oEle.isEnabled()) {
                    sStatus = true;
                }
            } catch (Exception e) {
                List<WebElement> oLi = driveR.findElements(By.xpath("//android.widget.Button[@index='0']"));
                    oLi.get(0).click();
            }
        }
    }

    public void VerifyIonicsuccessMsg(String message) throws Throwable {
        Set<String> contexts = driveR.getContextHandles();
        driveR.getContext();
        for (String context : contexts) {
            System.out.println(contexts);
            if (!context.equals("NATIVE_APP")) {
                System.out.println(contexts.toArray()[1]);
//                driveR.context((String) contexts.toArray()[1]);
                break;
            }
        }
        driveR.context("WEBVIEW_com.morrisons.instore.ionic.sit");
        System.out.println("execute context switch successfully!!!  "
                + contexts.toArray()[1]);
        Thread.sleep(1000);
        WebDriverWait waitForToast = new WebDriverWait(driveR,25);
        waitForToast.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ion-toast")));
        MobileElement toastView = (MobileElement) driveR.findElement((By.cssSelector("ion-toast")));
//        WebElement toastView = driveR.findElement(By.xpath("//ion-toast"));

        String sucessmess = toastView.getAttribute("text");
        System.out.println("Toast message: "+sucessmess);
//		String sucessmess = driveR.findElement(By.xpath("//android.widget.TextView[@text='" + message.trim() + "']"))
//				.getText();
        Thread.sleep(1000);
        System.out.println("SuccessMsg: "+sucessmess);
        Assert.assertEquals(sucessmess, message);
    }

    public void validateObjectPresent(String sObj, String sPageName) throws NoSuchFieldException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        WebElement oEle = InitClass.createObject(driveR, sObj, "com.morrisons.sma.page_objects.mobile.MOCO." + sPageName);
        Assert.assertEquals(oEle.isDisplayed(),"true","Object doesn't exist in the page");
    }

    public void ExistingOrderAllOrdrSort() throws NoSuchFieldException, ClassNotFoundException, InterruptedException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        int iExtCtr=0,iAllOrd = 0;
        List<WebElement> oOrders = driveR.findElements(By.xpath("//android.view.View[@index='0']"));
          List<WebElement> oOrdExist = driveR.findElement(By.xpath("//android.view.View[@index='0']")).findElements(By.xpath("//android.widget.TextView[@text='Existing Order(s)']"));
            if (oOrdExist.size() > 0) {
                Assert.assertTrue(oOrdExist.size() > 0, "Existing Order(s) exists");
            }
        List<WebElement> oProdListExist = driveR.findElements(By.xpath("//android.view.View[@index='0']//android.widget.ListView[@resource-id='productDetails']"));
            System.out.println(oProdListExist.size());
        List<WebElement> oProdListExist1 = oProdListExist.get(0).findElements(By.xpath("//android.widget.TextView[@resource-id='productName']"));

            ArrayList arrProdListExist = new ArrayList();
            for(int a=0;a<oProdListExist1.size();a++){
                arrProdListExist.add(oProdListExist1.get(a).getText());
            }
            SortData oSD = new SortDataString();
            oSD.doSort(arrProdListExist, "asc");
            List<WebElement> oOrdAll = driveR.findElement(By.xpath("//android.view.View[@index='0']")).findElements(By.xpath("//android.widget.TextView[@text='All Other Orders']"));
            if(oOrdAll.size()>0){
                Assert.assertTrue(oOrdAll.size() > 0, "All other Order exists");
            }
        List<WebElement> oProdListAll = driveR.findElements(By.xpath("//android.view.View[@index='0']//android.widget.ListView[@resource-id='productDetails']"));
        System.out.println(oProdListAll.size());
        if(oProdListExist.size()>1) {
            List<WebElement> oProdListAll1 = oProdListExist.get(1).findElements(By.xpath("//android.widget.TextView[@resource-id='productName']"));

            ArrayList arrProdListAll = new ArrayList();
            for (int a = 0; a < oProdListAll1.size(); a++) {
                arrProdListAll.add(oProdListAll1.get(a).getText());
            }
            oSD = new SortDataString();
            oSD.doSort(arrProdListAll, "asc");
            ;
        }
        else{
            ExtentCucumberAdapter.addTestStepLog("All Other Orders List is empty");
        }
    }

    public void CaptureDate(String sDate) {
        oDateDetails.put(sDate,sDateSelected);
    }

    public void VerifyDateSelected(String sDate) throws NoSuchFieldException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        String sExpFieldVal1 = oDateDetails.get(sDate);
        WebElement oEle1 = InitClass.createObject(driveR, "sDatebtn", sDate, "com.morrisons.sma.page_objects.mobile.MOCO." + "ManagerOrderPage");
        System.out.println(oEle1.getText());
        String ss1 = oEle1.getText();
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
        LocalDate ActlFldVal1 = LocalDate.parse(ss1,formatters);
        String sWeekName1 = ActlFldVal1.getDayOfWeek().toString();
        int sday1 = ActlFldVal1.getDayOfMonth();
        String sMonthNm1 = ActlFldVal1.getMonth().toString();
        String Endactualdate1 = sWeekName1 + "," + " " + sday1 + " " + sMonthNm1;
        Assert.assertEquals(sExpFieldVal1.toUpperCase(),Endactualdate1.toUpperCase()," Date has been changed  for " + sDate + " Expected " +  sExpFieldVal1.toUpperCase() + " Actual " + Endactualdate1.toUpperCase());
    }

    public void VerifyDateNotSelected(String sDate) throws NoSuchFieldException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        String sExpFieldVal = oDateDetails.get(sDate);
        WebElement oEle = InitClass.createObject(driveR, "sDatebtn", sDate, "com.morrisons.sma.page_objects.mobile.MOCO." + "ManagerOrderPage");
        System.out.println(oEle.getText());
        String ss = oEle.getText();
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
        LocalDate ActlFldVal = LocalDate.parse(ss,formatters);
        String sWeekName = ActlFldVal.getDayOfWeek().toString();
        int sday = ActlFldVal.getDayOfMonth();
        String sMonthNm = ActlFldVal.getMonth().toString();
        String Startactualdate = sWeekName + "," + " " + sday + " " + sMonthNm;
        Assert.assertNotEquals(sExpFieldVal.toUpperCase(),Startactualdate.toUpperCase()," Date has not been changed for " + sDate + " Expected " +  sExpFieldVal.toUpperCase() + " Actual " + Startactualdate.toUpperCase());
    }
}
