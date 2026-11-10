package com.morrisons.sma.step_definitions.mobile.MOCO;
import com.morrisons.common.PageFactory.InitClass;
import com.morrisons.common.action.Hook;
import com.morrisons.common.helper.CommonHelperMethods;
import com.morrisons.common.helper.MOCOHelperMethods;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.InvocationTargetException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.TemporalAccessor;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class MOCO_StepDefs_UI {
    private AndroidDriver driveR;
    int repeat = 0;

    public MOCO_StepDefs_UI() {
        this.driveR = (AndroidDriver) Hook.getDriver();
    }


    @Then("I Verify {string} {string} on page {string}")
    public void iVerifyOnPageManagerOrderPage(String sObjName, String sLocatorName, String sPageName) throws NoSuchFieldException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        WebElement oEle = InitClass.createObject(driveR, sObjName, sLocatorName, "com.morrisons.sma.page_objects.mobile.MOCO." + sPageName);
        CommonHelperMethods.VerifyObject(driveR, oEle, sLocatorName);
    }

    @And("^I Verify following '.*' on page '.*'$")
    public void iVerifyManagerOrdersCustomerOrdersOnPageManagerOrderPage(String sObjName, String ss, DataTable oObj, String sPageName) {
        System.out.println(oObj.asList().size());
    }

    @Then("I click {string} {string} on page {string}")
    public void iClickOnPage(String sObjName, String sLocatorName, String sPageName) throws InterruptedException {
        CommonHelperMethods.ClickObject(driveR, sObjName, sLocatorName, "MOCO." + sPageName);
    }

    @And("I Verify {string} on page {string}")
    public void iVerifyOnPage(String sObjName, String sPageName) throws NoSuchFieldException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        WebElement oEle = InitClass.createObject(driveR, sObjName, "com.morrisons.sma.page_objects.mobile.MOCO." + sPageName);
        CommonHelperMethods.VerifyObject(driveR, oEle);
    }

    @Then("I verify the error message {string} {string} {string} is displayed on page {string}")
    public void iVerifyTheErrorMessageIsDcreateObjectisplayedOnPage(String sObjName, String errorMsgObj, String errorMsg, String sPageName) throws NoSuchFieldException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, InterruptedException {
        try {
            Thread.sleep(2000);
            String errmsg = errorMsg;
            String errorMsg1 = "";
            String[] arrErrorMsg = errorMsg.split("\n");
            if (arrErrorMsg.length > 1) {
                errorMsg = arrErrorMsg[0];
                errorMsg1 = arrErrorMsg[1];
            } else {
                errorMsg = arrErrorMsg[0];
            }
            String xpathbarcodeicon = "//*[contains(@text,'" + errorMsg + "')]";
            WebDriverWait w = new WebDriverWait(driveR, 10);
            w.until(ExpectedConditions
                    .presenceOfElementLocated(By.xpath(xpathbarcodeicon)));
            List<WebElement> oLi = InitClass.createMultipleObjects(driveR, sObjName, errorMsg, "com.morrisons.sma.page_objects.mobile.MOCO." + sPageName);
            List<WebElement> oLi1 = InitClass.createMultipleObjects(driveR, errorMsgObj, errorMsg1, "com.morrisons.sma.page_objects.mobile.MOCO." + sPageName);
            CommonHelperMethods.VerifyErrorMesg(driveR, oLi, oLi1, errmsg);
        }
        catch(Exception rr){
            List<WebElement> oListEle = InitClass.createMultipleObjects(driveR, "oButton", "OK", "com.morrisons.sma.page_objects.mobile.MOCO." + "ManagerOrderPage");
            if(oListEle.size()>0) {
                CommonHelperMethods.ClickObject(driveR, "oButton", "OK", "MOCO." + "ManagerOrderPage");
            }
            throw rr;
        }
    }

    @Then("I Enter {string} in the {string} on page {string}")
    public void iEnterInThe(String sData, String sObj, String sPageName) throws NoSuchFieldException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, InterruptedException {
        WebElement oEle = InitClass.createObject(driveR, sObj, "com.morrisons.sma.page_objects.mobile.MOCO." + sPageName);
        CommonHelperMethods.EnterData(driveR, oEle, sData);
    }

    @Then("I check one step")
    public void iCheckOneStep() throws InterruptedException {
        String ss = "Thursday, 15 August";
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .append(DateTimeFormatter.ofPattern("EEEE" + "," + " d MMMM"))
                // use English Locale to correctly parse month and day of week
                .toFormatter(Locale.ENGLISH);
// parse input
        TemporalAccessor parsed = formatter.parse("Thursday, 15 August");
// get month and day
        MonthDay md = MonthDay.from(parsed);
// get day of week
        DayOfWeek dow = DayOfWeek.from(parsed);
String ssow = dow.toString().substring(0,3);
        ssow = Character.toUpperCase(ssow.charAt(0)) + ssow.substring(1).toLowerCase();
        String sMonth = md.getMonth().toString().substring(0,3);
        sMonth = Character.toUpperCase(sMonth.charAt(0)) + sMonth.substring(1).toLowerCase();
         int sday = MonthDay.from(parsed).getDayOfMonth();
        String Startactualdate1 = (ssow + "," + " " + sday + " " + sMonth + LocalDate.now().getYear());
        System.out.println(Startactualdate1);
        Locale locale = new Locale("en");
        DateTimeFormatter dateFormat1 = (DateTimeFormatter.ofPattern("EEEE" + "," + " " + "d" + " MMMM", locale));
        LocalDate ActlFldVal = LocalDate.parse(ss.trim(),dateFormat1);
        String sWeekName = ActlFldVal.getDayOfWeek().toString();
//        int sday = ActlFldVal.getDayOfMonth();
        String sMonthNm = ActlFldVal.getMonth().toString();
//        String Startactualdate1 = sWeekName + "," + " " + sday + " " + sMonthNm;

//        ss = localDate.toString();
//        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
//        DateTimeFormatter dateFormat1 = (DateTimeFormatter.ofPattern("EEE" + " " + "d" + " MMM" + " yyyy",locale));
//        LocalDate ActlFldVal = LocalDate.parse(ss,formatters);
//        String sWeekName = ActlFldVal.getDayOfWeek().toString();
//        int sday = ActlFldVal.getDayOfMonth();
//        String sMonthNm = ActlFldVal.getMonth().toString();
//        String Startactualdate1 = sWeekName + "," + " " + sday + " " + sMonthNm;
        System.out.println(Startactualdate1);
//        LocalDate ActlFldVal = LocalDate.parse(ss);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String Startactualdate = formatter.format(ActlFldVal);
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

        driveR.findElement(By.xpath("//android.view.View//android.widget.TextView[contains(@text,'Start Date')]/following::android.view.View/android.widget.Image[@index='1']")).click();
//        Thread.sleep(8000);
//        String xpathbarcodeicon = "//android.widget.Button[contains(@text,'Barcode scan image')]";
//        WebDriverWait w = new WebDriverWait(driveR, 10);
//        w.until(ExpectedConditions
//                .presenceOfElementLocated(By.xpath(xpathbarcodeicon)));
//        driveR.findElement(By.xpath(xpathbarcodeicon)).click();
//        for(int i=1;i<oLi.size();i++){
//            oLi.get(i).click();
//        }
//        WebElement oELe = oLi.get(0);
//        act.moveToElement(oELe,1239,126).click().build().perform();
    }

    @And("I click on ionic {string} on page {string}")
    public void iClickOnIonicBarCodeBtnOnPageMOCOManagerOrderPage(String sObj, String sPageName) throws Throwable {
        MOCOHelperMethods.clickObject(sObj, sPageName);
    }

    @Then("I Enter {string} in the {string} on page {string} and search")
    public void iEnterInTheOnPageManagerOrderPageAndSearch(String sData, String sObj, String sPageName) throws Throwable {
        MOCOHelperMethods oMOCOHelpObj = new MOCOHelperMethods();
        oMOCOHelpObj.MOCOenterBarcode(sData, sObj, sPageName);
    }

    @Then("I verify {string} is available to view for {string} for {string} on {string}")
    public void iVerifyManagerOrdersHistoryIsAvailableToViewForForOn(String sDtls, String sObj, String OrderDetails, String sPageName) throws NoSuchFieldException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, InterruptedException {
        MOCOHelperMethods oMOCOHelpObj = new MOCOHelperMethods();
        oMOCOHelpObj.validateOrders(sObj, OrderDetails, sPageName);
    }

    @And("I verify the {string} {string} limit of {string} days on page {string}")
    public void iVerifyTheLimitOfDays(String oObj, String OrderDetails, String NoofDays, String sPageName) throws NoSuchFieldException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        MOCOHelperMethods oMOCOHelpObj = new MOCOHelperMethods();
        oMOCOHelpObj.ValidateDates(oObj, OrderDetails, NoofDays, sPageName);
    }

    @Then("I verify the {string} date range {int} for {string} from current date + {int} on page {string}")
    public void iVerifyTheDateRangeForStartDateOnPageMOCOManagerOrderPage(String rangeObj, int oRangelimit,String sDate,int dRange,String sPageName) throws NoSuchFieldException, ClassNotFoundException, InterruptedException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        MOCOHelperMethods oMOCOHelpObj = new MOCOHelperMethods();
        oMOCOHelpObj.verifyDateRange(rangeObj, oRangelimit,dRange, sPageName);
    }

    @And("I select a date of date range {int}")
    public void iSelectADateOfDateRangeDateRange(int sdateRange) {
        MOCOHelperMethods oMOCOHelpObj = new MOCOHelperMethods();
        oMOCOHelpObj.selectDate(sdateRange);
    }

    @Then("I verify the {string} date range {int} for {string} from current date + {int} is not within limit on page {string}")
    public void iVerifyTheDateRangeForFromCurrentDateDateRangeIsNotWithinLimitOnPageMOCOManagerOrderPage(String rangeObj, int oRangelimit,String sDate,int dRange,String sPageName) throws NoSuchFieldException, ClassNotFoundException, InterruptedException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        MOCOHelperMethods oMOCOHelpObj = new MOCOHelperMethods();
        oMOCOHelpObj.verifyDateRangeNotWithinLimit(rangeObj, oRangelimit,dRange,sPageName);
    }

    @And("I Verify {string} {string} not found on page {string}")
    public void iVerifyNotFoundOnPage(String sObjName, String sLocatorName, String sPageName) throws NoSuchFieldException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        WebElement oEle = InitClass.createObject(driveR, sObjName, sLocatorName, "com.morrisons.sma.page_objects.mobile.MOCO." + sPageName);
        CommonHelperMethods.VerifyObjectNotFound(driveR, oEle);
    }

    @Then("I verify {string} is sorted by {string} in {string} order on page {string}")
    public void iVerifyIsSortedByInOrder(String oObj, String sObjectName, String StringsOrder, String sPageName) throws NoSuchFieldException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, InterruptedException {
        MOCOHelperMethods oMOCOHelpObj = new MOCOHelperMethods();
        oMOCOHelpObj.VerifySort(oObj, sObjectName,StringsOrder, sPageName);
    }

    @Then("I verify {string} is sorted by {string} with second sorting by {string} {string} in {string} order on page {string}")
    public void iVerifyIsSortedByWithSecondSortingByInOrderOnPageManagerOrderPage(String oObj, String sObjectName,String oObj1, String sObjectName1, String StringsOrder, String sPageName) throws NoSuchFieldException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        MOCOHelperMethods oMOCOHelpObj = new MOCOHelperMethods();
        oMOCOHelpObj.VerifySort(oObj, sObjectName,oObj1,sObjectName1,StringsOrder, sPageName);
    }

    @And("I Delete products {string} {string} from the list on page {string}")
    public void iDeleteProductsFromTheListOnPage(String oObj, String sObjectName, String sPageName) throws NoSuchFieldException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, InterruptedException {
        MOCOHelperMethods oMOCOHelpObj = new MOCOHelperMethods();
        oMOCOHelpObj.DeleteItems(oObj, sObjectName,sPageName);
    }

    @Given("I click on Back Button till we get to the {string} page on page {string}")
    public void iClickOnBackButtonTillWeGetToThePageOnPageManagerOrderPage(String sObjectName, String sPageName) {
        MOCOHelperMethods oMOCOHelpObj = new MOCOHelperMethods();
        oMOCOHelpObj.clickBack(sObjectName,sPageName);
    }

    @Then("I Enter the quantity as {string}, {string} and click on {string} {string} button on {string} page")
    public void iEnterTheQuantityAsAndClickOnButtonOnPage(String qty, String StckQty,String sLocatorName,  String sButtonName, String sPageName) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, InterruptedException, NoSuchFieldException {
        WebElement oEle = InitClass.createObject(driveR,StckQty,"sLocatorName","com.morrisons.sma.page_objects.mobile." + sPageName);
        Thread.sleep(1000);
        CommonHelperMethods.EnterData(driveR, oEle,qty);
        //Thread.sleep(7000);
        oEle = InitClass.createObject(driveR,sLocatorName,sButtonName,"com.morrisons.sma.page_objects.mobile." + sPageName);
        //oEle = CommonHelperMethods.createDynamicObj(driveR, oEle,sButtonName);
        Thread.sleep(1000);
        CommonHelperMethods.clickObject(driveR, oEle);
    }

    @Then("I verify success {string} for ionic")
    public void iVerifySuccessForIonic(String sMessage) throws Throwable {
        MOCOHelperMethods oMOCOHelpObj = new MOCOHelperMethods();
        oMOCOHelpObj.VerifyIonicsuccessMsg(sMessage);
    }

    @Then("I verify {string} not is available to view for {string} for {string} on {string}")
    public void iVerifyNotIsAvailableToViewForForOn(String sDtls, String sObj, String OrderDetails, String sPageName) throws NoSuchFieldException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, InterruptedException {
        MOCOHelperMethods oMOCOHelpObj = new MOCOHelperMethods();
        oMOCOHelpObj.validateOrdersNotPresent(sObj, OrderDetails, sPageName);
    }

    @Then("I verify {string} is present on page {string}")
    public void iVerifyIsPresentOnPage(String sObj, String sPageName) throws NoSuchFieldException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        MOCOHelperMethods oMOCOHelpObj = new MOCOHelperMethods();
        oMOCOHelpObj.validateObjectPresent(sObj, sPageName);
    }


    @Then("I verify review order sorted with existing order sorted together and then all other orders")
    public void iVerifyReviewOrderSortedWithExistingOrderSortedTogetherAndThenAllOtherOrders() throws NoSuchFieldException, ClassNotFoundException, InterruptedException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        MOCOHelperMethods oMOCOHelpObj = new MOCOHelperMethods();
        oMOCOHelpObj.ExistingOrderAllOrdrSort();
    }

    @And("I capture the {string}")
    public void iCaptureThe(String sDate) {
        MOCOHelperMethods oMOCOHelpObj = new MOCOHelperMethods();
        oMOCOHelpObj.CaptureDate(sDate);
    }

    @Then("I verify {string} has been edited as date selected")
    public void iVerifyAndAsDateSelected(String sDate) throws NoSuchFieldException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        MOCOHelperMethods oMOCOHelpObj = new MOCOHelperMethods();
        oMOCOHelpObj.VerifyDateSelected(sDate);
    }

    @And("I verify {string} has not been edited as date selected")
    public void iVerifyHasNotBeenEditedAsDateSelected(String sDate) throws NoSuchFieldException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        MOCOHelperMethods oMOCOHelpObj = new MOCOHelperMethods();
        oMOCOHelpObj.VerifyDateNotSelected(sDate);
    }
}
