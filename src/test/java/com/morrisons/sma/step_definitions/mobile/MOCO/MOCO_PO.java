package com.morrisons.sma.step_definitions.mobile.MOCO;

import com.morrisons.common.action.Hook;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class MOCO_PO {
    private static AndroidDriver driveR;
    public MOCO_PO() {
        this.driveR = (AndroidDriver) Hook.getDriver();
    }
    public static void VerfLabelScreenDisplay() {
        driveR.findElement(By.xpath("//android.widget.TextView[@text='Place Labels']")).isDisplayed();
    }

    public static void VerfLabelScreenNotDisplay(String sScreen) {
       boolean sDisplSts =  driveR.findElement(By.xpath("//android.widget.TextView[@text='Place Labels']")).isDisplayed();
        Assert.assertFalse(sDisplSts);
    }
}
