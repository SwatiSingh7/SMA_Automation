package com.morrisons.common.helper;

import com.google.common.collect.ImmutableMap;
import com.morrisons.common.PageFactory.InitClass;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import static com.morrisons.common.helper.CommonHelperMethods.env;


public class MobileHelper {

    private static final Logger log = Logger.getLogger(MobileHelper.class);

    public static void clickSearch(AndroidDriver driver) {
        log.info("Clicking on Mobile Search");
        driver.executeScript("mobile:performEditorAction", ImmutableMap.of("action", "search"));
    }

    public static void clickCheckButton(AndroidDriver driver) {
        log.info("Clicking on Mobile Check");
        driver.executeScript("mobile:performEditorAction", ImmutableMap.of("action", "Go"));
    }

    public static void hideKeyBoard(AndroidDriver driver) {
        log.info("Hiding Mobile Keyboard");
        driver.hideKeyboard();
    }

    public static void scroll(AndroidDriver driver, int xOffsetFrom, int yOffsetFrom, int xOffsetTo, int yOffsetTo) throws InterruptedException {
        Thread.sleep(3000);
try {
    TouchAction ts1 = new TouchAction(driver);
    ts1.press(PointOption.point(xOffsetFrom, yOffsetFrom)).
            waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).
            moveTo(PointOption.point(xOffsetTo, yOffsetTo)).
            release().
            perform();
}
catch(Exception r){

}
    }

    //scroll down to element text
    public static void ScrolltoElementWithText(AndroidDriver driver, String text) {
        driver.findElement(MobileBy
                .AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));"));
    }

    public static void checkSearch(AndroidDriver driveR, WebElement enterMin) throws InterruptedException {

        //====================================
        int c = 0;
        Thread.sleep(7000);
        BarcdEntry: do {
            List<WebElement> oEle1;
            try {
                oEle1 = driveR.findElements(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/action_barcode_entry' or @resource-id='" + env + ":id/barcode_entry_edit_text']"));
                System.out.println("oEle1.size() " + oEle1.size());
                Thread.sleep(3000);
                if (oEle1.size() > 0) {
                    driveR.hideKeyboard();
                    Thread.sleep(2000);
                    oEle1.get(0).sendKeys(Keys.ENTER);
//                    driveR.executeScript("mobile:performEditorAction", ImmutableMap.of("action", "search"));
                    Thread.sleep(6000);
                } else {
                    break;
                }
            } catch (java.util.NoSuchElementException o) {
                break;
            } catch (Exception w) {
                c++;
                if (c < 2) {
                    continue;
                } else {
                    break;
                }

            }
            c++;
            oEle1 = driveR.findElements(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/action_barcode_entry' or @resource-id='" + env + ":id/barcode_entry_edit_text']"));
            Thread.sleep(5000);
        } while (c < 2);        //======================================

    }
}
