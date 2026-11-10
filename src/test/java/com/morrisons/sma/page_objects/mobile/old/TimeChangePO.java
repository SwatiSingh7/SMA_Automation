package com.morrisons.sma.page_objects.mobile.old;

import com.morrisons.common.action.Hook;
import com.morrisons.common.helper.MobileHelper;
import com.morrisons.common.utility.EnterStringValueToTB;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TimeChangePO {
    private static AndroidDriver driveR;
    public static String hours;
    public static String mins;
    public static String meridiem;
    public static String date;
    public static String month;
    public static String year;

    private final Logger log = Logger.getLogger(TimeChangePO.class);

    public TimeChangePO() {
        this.driveR = (AndroidDriver) Hook.getDriver();
    }

    public static MobileDriver getDriver() {

        return driveR;

    }

    public void getDetails(String hrs, String min, String mer, String dt) {
        hours = hrs;
        mins = min;
        meridiem = mer;
        date = dt;
        log.info("hrs = " + hours + "mins =" + mins + "mer =" + meridiem);
    }

    public void getDetailss(String dt, String month, String year) {

        date = dt;
        month = month;
        year = year;
        log.info("date = " + date + "month =" + month + "year" + year);
    }

    public void changedate() throws InterruptedException {

        Thread.sleep(2000);

        driveR.findElement(By.xpath("//android.widget.TextView[@text='Set date' or @text='Date']")).click();

        Thread.sleep(2000);

        boolean device = true;
        try {
            device = driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='android:id/numberpicker_input']")).isDisplayed();
        } catch (Exception e) {
            System.out.println("CT_60");
            device = false;
        }


        if (device) {

            List<String> value = new ArrayList<>();
            List<WebElement> Time = driveR
                    .findElements(By.xpath("//android.widget.EditText[@resource-id='android:id/numberpicker_input']"));

            for (int i = 0; i < Time.size(); i++) {

                value.add(Time.get(i).getText());

            }

            if (driveR.findElement(
                    By.xpath("//android.widget.EditText[@resource-id='android:id/numberpicker_input' and @text='"
                            + value.get(0) + "']"))
                    .isDisplayed()) {

                driveR.findElement(
                        By.xpath("//android.widget.EditText[@resource-id='android:id/numberpicker_input' and @text='"
                                + value.get(0) + "']"))
                        .clear();

                EnterStringValueToTB.enterKeyPadKeys(driveR, date);

            }
            Thread.sleep(3000);
            driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();
        } else {

            getDetailss(date, month, year);

            Thread.sleep(2000);

            driveR.findElement(By.xpath("//android.view.View[@text='" + date + "']")).click();
            Thread.sleep(2000);

            driveR.findElement(By.xpath("//android.widget.Button[@text='OK' or @text='Ok']")).click();

        }

    }

    public void changeTime() throws InterruptedException {
        Thread.sleep(6000);
        boolean device = true;
        try {
            device = driveR.findElement(By.xpath("//android.widget.TextView[@text='WIRELESS & NETWORKS']")).isDisplayed();
        } catch (Exception e) {
            System.out.println("CT_60");
            device = false;
        }

        Thread.sleep(6000);

        if (device) {
            driveR.findElement(By.xpath("//android.widget.TextView[@text='WIRELESS & NETWORKS']")).click();

            Thread.sleep(2000);

/*            TouchAction ts = new TouchAction(driveR);
            ts.press(PointOption.point(50, 1100)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                    .moveTo(PointOption.point(50, 290)).release().perform();
            Thread.sleep(1000);

            TouchAction ts1 = new TouchAction(driveR);
            ts1.press(PointOption.point(50, 1100)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                    .moveTo(PointOption.point(50, 290)).release().perform();
            Thread.sleep(1000);

            TouchAction ts2 = new TouchAction(driveR);
            ts2.press(PointOption.point(50, 1100)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                    .moveTo(PointOption.point(50, 290)).release().perform();
            Thread.sleep(2000);*/

            MobileHelper.scroll((AndroidDriver) Hook.getDriver(), 50, 1100, 50, 290);
            MobileHelper.scroll((AndroidDriver) Hook.getDriver(), 50, 1100, 50, 290);
            MobileHelper.scroll((AndroidDriver) Hook.getDriver(), 50, 1100, 50, 290);


            driveR.findElement(By.xpath("//android.widget.TextView[@text='Date & time']")).click();

            Thread.sleep(2000);

            driveR.findElement(By.xpath("//android.widget.TextView[@text='Set time']")).click();

            Thread.sleep(2000);

            List<String> value = new ArrayList<>();
            List<WebElement> Time = driveR
                    .findElements(By.xpath("//android.widget.EditText[@resource-id='android:id/numberpicker_input']"));

            for (int i = 0; i < Time.size(); i++) {

                value.add(Time.get(i).getText());

            }

            if (driveR.findElement(
                    By.xpath("//android.widget.EditText[@resource-id='android:id/numberpicker_input' and @text='"
                            + value.get(0) + "']"))
                    .isDisplayed()) {

                driveR.findElement(
                        By.xpath("//android.widget.EditText[@resource-id='android:id/numberpicker_input' and @text='"
                                + value.get(0) + "']"))
                        .clear();

                EnterStringValueToTB.enterKeyPadKeys(driveR, hours);

            }

            if (driveR.findElement(
                    By.xpath("//android.widget.EditText[@resource-id='android:id/numberpicker_input' and @text='"
                            + value.get(1) + "']"))
                    .isDisplayed()) {

                driveR.findElement(
                        By.xpath("//android.widget.EditText[@resource-id='android:id/numberpicker_input' and @text='"
                                + value.get(1) + "']"))
                        .clear();

                EnterStringValueToTB.enterKeyPadKeys(driveR, mins);

            }

            Thread.sleep(3000);

            try {
                Boolean getTime = driveR.findElement(By.xpath("//android.widget.Button[@text='" + meridiem + "']"))
                        .isDisplayed();

                if (getTime = true) {
                    driveR.findElement(By.xpath("//android.widget.Button[@text='" + meridiem + "']")).click();

                    Thread.sleep(2000);
                    driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();
                    Thread.sleep(1000);

                } else {

                    driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();
                }

            } catch (Exception e) {
                driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();

            }

        } else {

            System.out.println("ct_60 code lines");

            getDetails(hours, mins, meridiem, date);

            /*TouchAction ts = new TouchAction(driveR);
            ts.press(PointOption.point(50, 1100)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                    .moveTo(PointOption.point(50, 290)).release().perform();
            Thread.sleep(1000);

            TouchAction ts1 = new TouchAction(driveR);
            ts1.press(PointOption.point(50, 1100)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                    .moveTo(PointOption.point(50, 290)).release().perform();
            Thread.sleep(1000);

            TouchAction ts2 = new TouchAction(driveR);
            ts2.press(PointOption.point(50, 1100)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                    .moveTo(PointOption.point(50, 290)).release().perform();
            Thread.sleep(1000);

            TouchAction ts3 = new TouchAction(driveR);
            ts3.press(PointOption.point(50, 1100)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                    .moveTo(PointOption.point(50, 290)).release().perform();
            Thread.sleep(1000);*/

            MobileHelper.scroll((AndroidDriver) Hook.getDriver(), 50, 1100, 50, 290);
            MobileHelper.scroll((AndroidDriver) Hook.getDriver(), 50, 1100, 50, 290);
            MobileHelper.scroll((AndroidDriver) Hook.getDriver(), 50, 1100, 50, 290);
            MobileHelper.scroll((AndroidDriver) Hook.getDriver(), 50, 1100, 50, 290);

            driveR.findElement(By.xpath("//android.widget.TextView[@text='System']")).click();

            Thread.sleep(2000);

            driveR.findElement(By.xpath("//android.widget.TextView[@text='Date & time']")).click();

            Thread.sleep(3000);

            String switchState = driveR.findElement(By.xpath("//android.widget.TextView[@text='Set time automatically']/../parent::android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Switch[@resource-id='android:id/switch_widget']")).getText();
            if (switchState.equalsIgnoreCase("ON")) {
                driveR.findElement(By.xpath("//android.widget.TextView[@text='Set time automatically']/../parent::android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Switch[@resource-id='android:id/switch_widget']")).click();
            } else {
                log.info("Automatic Date Time is Off");
            }

//            try {
//                driveR.findElement(By.xpath("//android.widget.TextView[@text='Use 24-hour format']/../following::android.widget.Switch[@text='OFF' or @text='Off']")).isDisplayed();
//            } catch (Exception e) {
//
//                driveR.findElement(By.xpath("//android.widget.TextView[@text='Use 24-hour format']/../following::android.widget.Switch[@text='ON' or @text='On']")).click();
//
//                System.out.println("24-hour format");
//            }

            Thread.sleep(2000);
            driveR.findElement(By.xpath("//android.widget.TextView[@text='Set time' or @text='Time']")).click();

            Thread.sleep(2000);

            driveR.findElement(By.xpath("//android.widget.ImageButton[@resource-id='android:id/toggle_mode']")).click();

            Thread.sleep(2000);

            driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='android:id/input_hour']")).click();
            driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='android:id/input_hour']")).clear();

            Thread.sleep(2000);
            driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='android:id/input_hour']")).sendKeys(hours);

            Thread.sleep(2000);

            driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='android:id/input_minute']")).click();
            driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='android:id/input_minute']")).clear();
            Thread.sleep(2000);
            driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='android:id/input_minute']")).sendKeys(mins);

            Thread.sleep(2000);

            driveR.findElement(By.xpath("//android.widget.Spinner[@resource-id='android:id/am_pm_spinner']")).click();
            Thread.sleep(2000);

            driveR.findElement(By.xpath("//android.widget.CheckedTextView[@text='" + meridiem.toUpperCase() + "']")).click();

            Thread.sleep(2000);

            driveR.findElement(By.xpath("//android.widget.Button[@text='OK' or @text='Ok']")).click();

        }
    }
}


