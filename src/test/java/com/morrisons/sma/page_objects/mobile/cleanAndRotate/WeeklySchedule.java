package com.morrisons.sma.page_objects.mobile.cleanAndRotate;
import com.morrisons.common.PageFactory.InitClass;
import com.morrisons.common.action.Hook;
import com.morrisons.common.helper.CommonHelperMethods;
import com.morrisons.common.helper.MobileHelper;
import com.morrisons.sma.step_definitions.service.cleanAndRotate.ScheduleStepDef;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static org.testng.Assert.assertEquals;

public class WeeklySchedule {
    private static AndroidDriver driveR;
    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    public static String weekStatusUI = null;
    public static String selectedWeek = null;
    public static String weekNameUI = null;
    public static String firstWeekScheduleStatus = null;
    public static String productName = null;
    public String weeklyScheduleStatus1 = "//android.widget.TextView[@text='Locator']/following::android.widget.TextView[contains(@resource-id,'department_status')]~Xpath";
    private final Logger log = Logger.getLogger(WeeklySchedule.class);

    public WeeklySchedule() {
        log.info("Inside : " + WeeklySchedule.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);

    }

    /**
     * Web Elements
     */

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'department_title')]")
    public List<WebElement> weeklyScheduleList;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'department_text')]")
    public List<WebElement> ItemList;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'department_status')]")
    public List<WebElement> weeklyScheduleStatus;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Products cannot be captured until one week before the start date.']")
    public WebElement alertForFutureWeek;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Currently unavailable']")
    public WebElement alertTitleForFutureWeek;
    @FindBy(how = How.XPATH, using = "//android.widget.Button[@text='OK']")
    public WebElement alertForFutureWeekOkBttn;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'id/department_title')]")
    public WebElement weeklySchedule;


    /**
     * Public Methods
     **/
    public void selectWeeklySchedule() throws InterruptedException {
        for (WebElement product : weeklyScheduleList) {
            String productName = product.getText();
            log.info("Product Name : " + productName);
            Thread.sleep(2000);
            product.click();
            Thread.sleep(2000);
            break;
        }
        //weeklySchedule.click();
    }
    public void selectWeek(String week) throws Throwable {
        try {
            LocalDate currentDate = LocalDate.now();
            Calendar calendar = Calendar.getInstance();
            int weekNumber = calendar.get(Calendar.WEEK_OF_YEAR);
            LocalDate start;
            LocalDate Nextstart = currentDate.plusDays(7);
            LocalDate SecondNextstart = Nextstart.plusDays(7);
            DateTimeFormatter dateFormat;
            String text;
            String dayNumberSuffix;
            switch (week) {
                case "Current Week":
                    start = currentDate;
                    while (start.getDayOfWeek() != DayOfWeek.MONDAY) {
                        start = start.minusDays(1);
                    }
                    dayNumberSuffix = getDayNumberSuffix(start.getDayOfMonth());
                    dateFormat = DateTimeFormatter.ofPattern(" d'" + dayNumberSuffix + "' MMMM yyyy");
                    text = dateFormat.format(start);
                    text = "Week" + text;
                    System.out.println("Start of the Week = " + "Week " + text);
                    for (WebElement weeklySchedule : weeklyScheduleList) {
                        String scheduleName = weeklySchedule.getText();
                        log.info("Weekly schedule  " + scheduleName);
                        if (scheduleName.equalsIgnoreCase(text)) {
                            weeklySchedule.click();
                            break;
                        }
                    }
                    break;
                case "Overdue Week":
                    LocalDate Prevstart = currentDate.minusDays(7);
                    while (Prevstart.getDayOfWeek() != DayOfWeek.MONDAY) {
                        Prevstart = Prevstart.minusDays(1);
                    }
                    dayNumberSuffix = getDayNumberSuffix(Prevstart.getDayOfMonth());
                    dateFormat = DateTimeFormatter.ofPattern(" d'" + dayNumberSuffix + "' MMMM yyyy");
                    text = dateFormat.format(Prevstart);
                    text = "Week" + text;
                    System.out.println("Start of the Week = " + "Week " + text);
                    for (WebElement weeklySchedule : weeklyScheduleList) {
                        String scheduleName = weeklySchedule.getText();
                        log.info("Weekly schedule  " + scheduleName);
                        if (scheduleName.equalsIgnoreCase(text)) {
                            weeklySchedule.click();
                            break;
                        }
                    }
                    break;
                case "Future Week":
                    Nextstart = currentDate.plusDays(7);
                    while (Nextstart.getDayOfWeek() != DayOfWeek.MONDAY) {
                        Nextstart = Nextstart.minusDays(1);
                    }
                    System.out.println("Start of the Week = " + Nextstart);
                    dayNumberSuffix = getDayNumberSuffix(Nextstart.getDayOfMonth());
                    dateFormat = DateTimeFormatter.ofPattern(" d'" + dayNumberSuffix + "' MMMM yyyy");
                    text = dateFormat.format(Nextstart);
                    text = "Week" + text;
                    System.out.println("Start of the Week = " + "Week " + text);
                    for (WebElement weeklySchedule : weeklyScheduleList) {
                        String scheduleName = weeklySchedule.getText();
                        log.info("Weekly schedule  " + scheduleName);
                        if (scheduleName.equalsIgnoreCase(text)) {
                            weeklySchedule.click();
                            break;
                        }
                    }
                    break;
                case "NextToFutureWeek":
                    SecondNextstart = Nextstart.plusDays(7);
                    while (SecondNextstart.getDayOfWeek() != DayOfWeek.MONDAY) {
                        SecondNextstart = SecondNextstart.minusDays(1);
                    }
                    System.out.println("Start of the Week = " + SecondNextstart);
                    dayNumberSuffix = getDayNumberSuffix(SecondNextstart.getDayOfMonth());
                    dateFormat = DateTimeFormatter.ofPattern(" d'" + dayNumberSuffix + "' MMMM yyyy");
                    text = dateFormat.format(SecondNextstart);
                    text = "Week" + text;
                    System.out.println("Start of the Week = " + "Week " + text);
                    for (WebElement weeklySchedule : weeklyScheduleList) {
                        String scheduleName = weeklySchedule.getText();
                        log.info("Weekly schedule  " + scheduleName);
                        if (scheduleName.equalsIgnoreCase(text)) {
                            weeklySchedule.click();
                            break;
                        }
                    }
                    break;
                case "NextToNextFutureWeek":
                    LocalDate Futurestart = SecondNextstart.plusDays(7);
                    while (Futurestart.getDayOfWeek() != DayOfWeek.MONDAY) {
                        Futurestart = Futurestart.minusDays(1);
                    }
                    System.out.println("Start of the Week = " + Futurestart);
                    dayNumberSuffix = getDayNumberSuffix(Futurestart.getDayOfMonth());
                    dateFormat = DateTimeFormatter.ofPattern(" d'" + dayNumberSuffix + "' MMMM yyyy");
                    text = dateFormat.format(Futurestart);
                    text = "Week" + text;
                    System.out.println("Start of the Week = " + "Week " + text);
                    for (WebElement weeklySchedule : weeklyScheduleList) {
                        String scheduleName = weeklySchedule.getText();
                        log.info("Weekly schedule  " + scheduleName);
                        if (scheduleName.equalsIgnoreCase(text)) {
                            weeklySchedule.click();
                            break;
                        }
                    }
                    break;
            }
//        HashMap<String, Integer> scheduleNumber = new HashMap<String, Integer>();
//        scheduleNumber.put("Overdue Week", 5);
//        scheduleNumber.put("Current Week", 4);
//        scheduleNumber.put("Future Week", 3);
//        scheduleNumber.put("NextToFutureWeek", 2);
//        scheduleNumber.put("NextToNextFutureWeek", 1);
//
//        int weekIndex = scheduleNumber.get(week); //// Get Index number
//        log.info("Selecting Weekly schedule" + weekIndex);
//        for (WebElement weeklySchedule : weeklyScheduleList) {
//            String scheduleName = weeklySchedule.getText();
//            log.info("Weekly schedule  " + scheduleName);
//
//        }
//
//        selectedWeek = weeklyScheduleList.get(weeklyScheduleList.size() - weekIndex).getText();
//        log.info("Current week schedule" + selectedWeek);
//        String selectScheduleName = weeklyScheduleList.get(weeklyScheduleList.size() - weekIndex).getText();
//        log.info("Selected Weekly schedule:------------" + selectScheduleName);
//        String selectScheduleName7 = weeklyScheduleList.get(weeklyScheduleList.size() - weekIndex).getText();
//        log.info("Selected Weekly schedule final:------------" + selectScheduleName7);
//        weeklyScheduleList.get(weeklyScheduleList.size() - weekIndex).click();
        }
             catch(StaleElementReferenceException se){
                driveR.navigate().refresh();
                 selectWeek(week);
            }

    }

//====================================
public void selectScheduleDate(String sdate) throws Throwable {
    try {
        LocalDate currentDate = LocalDate.now();
        Calendar calendar = Calendar.getInstance();
        int weekDayName = calendar.get(Calendar.DAY_OF_WEEK);
        LocalDate start;
        String dayWeekText = currentDate.getDayOfWeek().toString();
        System.out.println("Day of week in text:"+dayWeekText);
        DateTimeFormatter dateFormat;
        String text;
        String dayNumberSuffix;
        boolean sFoundStatus = false;
        switch (sdate) {
            case "Current Date":
                dayNumberSuffix = getDayNumberSuffix(currentDate.getDayOfMonth());
                dateFormat = DateTimeFormatter.ofPattern("EEE d'" + dayNumberSuffix + "' MMMM");
                text = dateFormat.format(currentDate);
                System.out.println("Start of the Week = " + "Week " + text);
                for (WebElement weeklySchedule : weeklyScheduleList) {
                    String scheduleName = weeklySchedule.getText();
                    log.info("Weekly schedule  " + scheduleName);
                    if (scheduleName.equalsIgnoreCase(text)) {
                        sFoundStatus = true;
                        weeklySchedule.click();
                        break;
                    }
                }
                Assert.assertEquals(sFoundStatus,true, "The daily Schedule " + text + " not in the list");
                break;
            case "Previous Date":
                LocalDate previousDate = currentDate.minusDays(1);
                dayNumberSuffix = getDayNumberSuffix(previousDate.getDayOfMonth());
                dayWeekText = previousDate.getDayOfWeek().toString();
                dateFormat = DateTimeFormatter.ofPattern("EEE d'" + dayNumberSuffix + "' MMMM");
                text = dateFormat.format(previousDate);
                System.out.println("Start of the Week = " + "Week " + text);
                for (WebElement weeklySchedule : weeklyScheduleList) {
                    String scheduleName = weeklySchedule.getText();
                    log.info("Weekly schedule  " + scheduleName);
                    if (scheduleName.equalsIgnoreCase(text)) {
                        sFoundStatus = true;
                        weeklySchedule.click();
                        break;
                    }
                }
                Assert.assertEquals(sFoundStatus,true, "The daily Schedule " + text + " not in the list");
                break;
        }
    } catch (StaleElementReferenceException se) {
        driveR.navigate().refresh();
        selectWeek(sdate);
    }

}
    //=================================================
    public String getDayNumberSuffix(int day) {
    if (day >= 11 && day <= 13) {
        return "th";
    }
    switch (day % 10) {
        case 1:
            return "st";
        case 2:
            return "nd";
        case 3:
            return "rd";
        default:
            return "th";
    }
}
//==========================================
    public void verifyScheduleStatus(String scheduleWeek, String weekStatus) throws Throwable { // Below map is declared to get value at Runtime
        HashMap<String, Integer> scheduleNumber = new HashMap<String, Integer>();

        //==================================================================
        LocalDate currentDate = LocalDate.now();
        Calendar calendar = Calendar.getInstance();
        int weekNumber = calendar.get(Calendar.WEEK_OF_YEAR);
        LocalDate start;
        LocalDate Nextstart = currentDate.plusDays(7);
        LocalDate SecondNextstart = Nextstart.plusDays(7);
        DateTimeFormatter dateFormat;
        String text = null;
        String dayNumberSuffix;
        WebElement oEle = null;
        switch (scheduleWeek) {
            case  "Current Week":
                start = currentDate;
                while (start.getDayOfWeek() != DayOfWeek.MONDAY) {
                    start = start.minusDays(1);
                }
                dayNumberSuffix = getDayNumberSuffix(start.getDayOfMonth());
                dateFormat = DateTimeFormatter.ofPattern(" d'" + dayNumberSuffix + "' MMMM yyyy");
                text = dateFormat.format(start);
                text = "Week" + text;
                System.out.println("Start of the Week = " + "Week " + text);
                int i = 0,sts = 0;
                for (WebElement weeklySchedule : weeklyScheduleList) {
                    String scheduleName = weeklySchedule.getText();
                    log.info("Weekly schedule  " + scheduleName);
                    if (scheduleName.equalsIgnoreCase(text)) {
                        try {
                            oEle = InitClass.createObject(driveR, "weeklyScheduleStatus1", text, "com.morrisons.sma.page_objects.mobile." + "cleanAndRotate.WeeklySchedule");
                        }
                        catch(Exception ie){
                            weekStatusUI = "";
                            break;
                        }
                            weekStatusUI = oEle.getText();
                            break;
                    }
                    i++;
                }
                break;
            case  "Overdue Week":
                LocalDate Prevstart = currentDate.minusDays(7);
                while (Prevstart.getDayOfWeek() != DayOfWeek.MONDAY) {
                    Prevstart = Prevstart.minusDays(1);
                }
                dayNumberSuffix = getDayNumberSuffix(Prevstart.getDayOfMonth());
                dateFormat = DateTimeFormatter.ofPattern(" d'" + dayNumberSuffix + "' MMMM yyyy");
                text = dateFormat.format(Prevstart);
                text = "Week" + text;
                System.out.println("Start of the Week = " + "Week " + text);
                for (WebElement weeklySchedule : weeklyScheduleList) {
                    String scheduleName = weeklySchedule.getText();
                    log.info("Weekly schedule  " + scheduleName);
                    if (scheduleName.equalsIgnoreCase(text)) {
                        try {
                            oEle = InitClass.createObject(driveR, "weeklyScheduleStatus1", text, "com.morrisons.sma.page_objects.mobile." + "cleanAndRotate.WeeklySchedule");
                        }
                        catch(Exception ie){
                            weekStatusUI = "";
                            break;
                        }
                        weekStatusUI = oEle.getText();
                        break;
                    }
                }
                break;
            case  "Future Week":
                Nextstart = currentDate.plusDays(7);
                while (Nextstart.getDayOfWeek() != DayOfWeek.MONDAY) {
                    Nextstart = Nextstart.minusDays(1);
                }
                System.out.println("Start of the Week = " + Nextstart);
                dayNumberSuffix = getDayNumberSuffix(Nextstart.getDayOfMonth());
                dateFormat = DateTimeFormatter.ofPattern(" d'" + dayNumberSuffix + "' MMMM yyyy");
                text = dateFormat.format(Nextstart);
                text = "Week" + text;
                System.out.println("Start of the Week = " + "Week " + text);
                for (WebElement weeklySchedule : weeklyScheduleList) {
                    String scheduleName = weeklySchedule.getText();
                    log.info("Weekly schedule  " + scheduleName);
                    if (scheduleName.equalsIgnoreCase(text)) {
                        try {
                            oEle = InitClass.createObject(driveR, "weeklyScheduleStatus1", text, "com.morrisons.sma.page_objects.mobile." + "cleanAndRotate.WeeklySchedule");
                        }
                        catch(Exception ie){
                            weekStatusUI = "";
                            break;
                        }
                        weekStatusUI = oEle.getText();
                        break;
                    }
                }
                break;
            case  "NextToFutureWeek":
                SecondNextstart = Nextstart.plusDays(7);
                while (SecondNextstart.getDayOfWeek() != DayOfWeek.MONDAY) {
                    SecondNextstart = SecondNextstart.minusDays(1);
                }
                System.out.println("Start of the Week = " + SecondNextstart);
                dayNumberSuffix = getDayNumberSuffix(SecondNextstart.getDayOfMonth());
                dateFormat = DateTimeFormatter.ofPattern(" d'" + dayNumberSuffix + "' MMMM yyyy");
                text = dateFormat.format(SecondNextstart);
                text = "Week" + text;
                System.out.println("Start of the Week = " + "Week " + text);
                for (WebElement weeklySchedule : weeklyScheduleList) {
                    String scheduleName = weeklySchedule.getText();
                    log.info("Weekly schedule  " + scheduleName);
                    if (scheduleName.equalsIgnoreCase(text)) {
                        try {
                            oEle = InitClass.createObject(driveR, "weeklyScheduleStatus1", text, "com.morrisons.sma.page_objects.mobile." + "cleanAndRotate.WeeklySchedule");
                        }
                        catch(Exception ie){
                            weekStatusUI = "";
                            break;
                        }
                        weekStatusUI = oEle.getText();
                        break;
                    }
                }
                break;
            case  "NextToNextFutureWeek":
                LocalDate Futurestart = SecondNextstart.plusDays(7);
                while (Futurestart.getDayOfWeek() != DayOfWeek.MONDAY) {
                    Futurestart = Futurestart.minusDays(1);
                }
                System.out.println("Start of the Week = " + Futurestart);
                dayNumberSuffix = getDayNumberSuffix(Futurestart.getDayOfMonth());
                dateFormat = DateTimeFormatter.ofPattern(" d'" + dayNumberSuffix + "' MMMM yyyy");
                text = dateFormat.format(Futurestart);
                text = "Week" + text;
                System.out.println("Start of the Week = " + "Week " + text);
                for (WebElement weeklySchedule : weeklyScheduleList) {
                    String scheduleName = weeklySchedule.getText();
                    log.info("Weekly schedule  " + scheduleName);
                    if (scheduleName.equalsIgnoreCase(text)) {
                        try {
                            oEle = InitClass.createObject(driveR, "weeklyScheduleStatus1", text, "com.morrisons.sma.page_objects.mobile." + "cleanAndRotate.WeeklySchedule");
                        }
                        catch(Exception ie){
                            weekStatusUI = "";
                            break;
                        }
                        weekStatusUI = oEle.getText();
                        break;                    }

                }
                break;
        }
        weekNameUI = text;
        //==================================================================

//        scheduleNumber.put("Overdue Week", 5);
//        scheduleNumber.put("Current Week", 4);
//        scheduleNumber.put("Future Week", 3);
//        scheduleNumber.put("NextToFutureWeek", 2);
//        scheduleNumber.put("NextToNextFutureWeek", 1);
//
//        int totalScheudleList = weeklyScheduleList.size();
//        int weekIndex = scheduleNumber.get(scheduleWeek); //// Get Index number
//
//        int selectWeek = totalScheudleList - weekIndex;
//        /////Getting Schedule Name. For eg.- Week 28th March 2022
//        WebElement xpathsSheduleTitle = driveR.findElement(By.xpath("//android.widget.RelativeLayout[@index='"
//                + selectWeek + "']/android.widget.TextView[contains(@resource-id,'department_title')]"));
//        weekNameUI = xpathsSheduleTitle.getText();
//        log.info("Title of the schedule is :" + weekNameUI);
//
//        try {
//            WebElement xpathScheduleStatus = driveR
//                    .findElement(MobileBy.xpath("//android.widget.RelativeLayout[@index='" + selectWeek
//                            + "']/android.widget.TextView[contains(@resource-id,'department_status')]"));
//
//            ////Getting Schedule status. for eg.- Overdue, In Progress, Not Started (ToStart), Awaiting sign off.
//            //If weekly schedule is not started then 'Blank status' is displayed, so it throws NoSuchElementException exception.Hence added below try catch block.
//
//
//            weekStatusUI = xpathScheduleStatus.getText();
//            log.info(weekStatusUI);
//        } catch (Exception e) {
//            ////If weekly schedule is not started, Assigning value as == "ToStart"
//            weekStatusUI = "ToStart";
//            log.info("Status of the weekly schedule is:" + weekStatusUI);
//        }
//        if(!weekStatus.equalsIgnoreCase("null")) {
            Assert.assertEquals(weekStatusUI, weekStatus, "Week Status is mismatched");

    }

    public void scrollDown() throws Throwable {
        Thread.sleep(3000);
        WebElement oELe = null;
        WebElement oELe1 = null;
        log.info("Scrolling down on Weekly schedule page");
        LocalDate currentDate = LocalDate.now();
        Calendar calendar = Calendar.getInstance();
        int weekNumber = calendar.get(Calendar.WEEK_OF_YEAR);
        LocalDate start;
        LocalDate Nextstart = currentDate.plusDays(7);
        LocalDate SecondNextstart = Nextstart.plusDays(7);
        DateTimeFormatter dateFormat;
        String text;
        String dayNumberSuffix;
        //driveR.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        LocalDate Futurestart = SecondNextstart.plusDays(7);
        while (Futurestart.getDayOfWeek() != DayOfWeek.MONDAY) {
            Futurestart = Futurestart.minusDays(1);
        }
        System.out.println("Start of the Week = " + Futurestart);
        dayNumberSuffix = getDayNumberSuffix(Futurestart.getDayOfMonth());
        dateFormat = DateTimeFormatter.ofPattern(" d'" + dayNumberSuffix + "' MMMM yyyy");
        text = dateFormat.format(Futurestart);
        text = "Week" + text;
        System.out.println("Start of the Week = " + "Week " + text);
        //for (WebElement weeklySchedule : weeklyScheduleList) {
        int i=0;
        try{
        oELe = weeklyScheduleList.get(i);
        System.out.println(weeklyScheduleStatus.size());
       // oELe1 = weeklyScheduleLayout.get(i);
        String scheduleName = oELe.getText();
        while (!scheduleName.equalsIgnoreCase(text)) {
            log.info("Weekly schedule  " + scheduleName);
            oELe = weeklyScheduleList.get(i);
           // oELe1 = weeklyScheduleLayout.get(i);
            scheduleName = oELe.getText();
                MobileHelper.scroll(driveR, 500, 1515, 1000,1000);
                i++;
                try {
                    oELe1 = driveR.findElement(By.cssSelector("[text='" + text + "']"));
                    if (oELe1.isDisplayed()) {  //getText().contains("In Progress")
                        break;
                    }
                }
                catch(Exception e){

                }
//                if(i > oELe.size()){
//                    break;
//                }
            }
        }
        catch(StaleElementReferenceException se){
            driveR.navigate().refresh();
            scrollDown();
        }
    }

    //================================
    public void scrollDownToGivenDate() throws InterruptedException {
        Thread.sleep(3000);
        WebElement oELe = null;
        WebElement oELe1 = null;
        log.info("Scrolling down on Weekly schedule page");
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dateFormat;
        String text;
        String dayNumberSuffix;
        //driveR.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        dayNumberSuffix = getDayNumberSuffix(currentDate.getDayOfMonth());
        dateFormat = DateTimeFormatter.ofPattern("EEE d'" + dayNumberSuffix + "' MMMM");
        text = dateFormat.format(currentDate);
        System.out.println("Start of the Week = " + "Week " + text);
        //for (WebElement weeklySchedule : weeklyScheduleList) {
        int i=0;
        try{
            oELe = weeklyScheduleList.get(i);
            System.out.println(weeklyScheduleList.size());
            // oELe1 = weeklyScheduleLayout.get(i);
            String scheduleName = oELe.getText();
            while (!scheduleName.equalsIgnoreCase(text)) {
                log.info("Weekly schedule  " + scheduleName);
                oELe = weeklyScheduleList.get(i);
                // oELe1 = weeklyScheduleLayout.get(i);
                scheduleName = oELe.getText();
                MobileHelper.scroll(driveR, 500, 1515, 1000,1000);
                i++;
                try {
                    oELe1 = driveR.findElement(By.cssSelector("[text='" + text + "']"));
                    if (oELe1.isDisplayed()) {  //getText().contains("In Progress")
                        break;
                    }
                }
                catch(Exception e){

                }
                if(i > weeklyScheduleStatus.size()){
                    break;
                }
            }
        }
        catch(StaleElementReferenceException se){
            driveR.navigate().refresh();
            scrollDownToGivenDate();
        }
    }
    //===================================
    public void scrollDownToGivenItem(String item) throws InterruptedException {
        Thread.sleep(3000);
        WebElement oELe = null;
        WebElement oELe1 = null;
        log.info("Scrolling down page");
        DateTimeFormatter dateFormat;
        String text;
                //driveR.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        text = item;
        System.out.println("Item " + text);
        //for (WebElement weeklySchedule : weeklyScheduleList) {
        int i=0;
        try{
            oELe = ItemList.get(i);
            System.out.println(ItemList.size());
            // oELe1 = weeklyScheduleLayout.get(i);
            String scheduleName = oELe.getText();
            while (!scheduleName.equalsIgnoreCase(text)) {
                log.info("Weekly schedule  " + scheduleName);
                oELe = ItemList.get(i);
                // oELe1 = weeklyScheduleLayout.get(i);
                scheduleName = oELe.getText();
                MobileHelper.scroll(driveR, 500, 1515, 1000,1000);
                i++;
                try {
                    oELe1 = driveR.findElement(By.cssSelector("[text='" + text + "']"));
                    if (oELe1.isDisplayed()) {  //getText().contains("In Progress")
                        break;
                    }
                }
                catch(Exception e){

                }
                if(i > weeklyScheduleStatus.size()){
                    break;
                }
            }
        }
        catch(StaleElementReferenceException se){
            driveR.navigate().refresh();
            scrollDownToGivenDate();
        }
    }
    //=======================================

    public void verifyAlertAvailability(String alertMessage) throws Throwable {
        log.info("Verifying Alert for next-to-Future week");
        CommonHelperMethods.verifyIfDisplayed(driveR, alertForFutureWeek, alertMessage);
        CommonHelperMethods.verifyIfDisplayed(driveR, alertTitleForFutureWeek);
        alertForFutureWeekOkBttn.click();

    }


    public void verifyWeeklyScheduleIsRemoved() throws Throwable {
        log.info("Verifying week is  displayed" + selectedWeek);

        List<String> weekScheduleList = new ArrayList<String>();

        for (WebElement weeklySchedule : weeklyScheduleList) {

            weekScheduleList.add(weeklySchedule.getText());
        }

        boolean weekDisplayed = weekScheduleList.contains(selectedWeek); // Verifying
        // week
        // is
        // present
        // in
        // week
        // scedules
        // or
        // not

        assertEquals(weekDisplayed, false,
                "After clicking on Sign-Off Code Rotate button, Week is displayed in Week Schedules");
    }

    public void verifyUIStatusWithService() throws Throwable {
        log.info("Verifying Weekly schedule status on UI and Service is same");

        String weeklyScheduleStatusService = ScheduleStepDef.weeklyScheduleStatus;
        log.info("Service weekly status : " + weeklyScheduleStatusService);
        if(weeklyScheduleStatusService.equalsIgnoreCase("ToStart")){
            weeklyScheduleStatusService = "";
        }
        Assert.assertEquals(weekStatusUI, weeklyScheduleStatusService, "Weekly schedule status is mismatched on UI and Service");
    }


    public String getWeeklyScheduleUI() throws ParseException {
        String weekName = WeeklySchedule.weekNameUI.replace("Week", "").replace(" ", "");

        String weekStartDate = weekName.replace("January", "/01/").replace("February", "/02/").replace("March", "/03/")
                .replace("April", "/04/").replace("May", "/05/").replace("June", "/06/").replace("July", "/07/")
                .replace("August", "/08/").replace("September", "/09/").replace("October", "/10/")
                .replace("November", "/11/").replace("December", "/12/").replaceAll("([a-z])", "");

        String weekNameUI = CommonHelperMethods.changeDateFormat(weekStartDate);
        log.info("Weekly schedule name " + weekNameUI);

        return weekNameUI;
    }

    // Getting First Week schedule status
    public void getFirstWeekScheduleStatus() throws Throwable {
        try {
            WebElement xpathFirstWeekSchedule = driveR.findElement(
                    By.xpath("//android.widget.TextView[contains(@resource-id,'department_status')]"));

            firstWeekScheduleStatus = xpathFirstWeekSchedule.getText();
            log.info("First weekly scheudle status : " + firstWeekScheduleStatus);
        } catch (Exception e) {

            firstWeekScheduleStatus = "Not Started";
            log.info("First weekly scheudle status : " + firstWeekScheduleStatus);
        }
    }

    public void verifyStatusIsSame() throws Throwable {
        SoftAssert softAssert = new SoftAssert();
        log.info("***"+firstWeekScheduleStatus);
        log.info("********"+CNRHomepage.weeklyScheduleStatus);
        softAssert.assertEquals(firstWeekScheduleStatus, CNRHomepage.weeklyScheduleStatus,
                "Weekly schedule submenu status is not same as First week status inside week schedule");
    }
}



