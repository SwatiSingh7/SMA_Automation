package com.morrisons.sma.step_definitions.mobile.cleanAndRotate;

import com.morrisons.common.action.Hook;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import java.util.HashMap;

public class GetDeptAndMin {

    private static AndroidDriver driveR;
    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 30;

    private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
    String env = applicationConfig.getWebElementEnviroment().getEnv();
    private final Logger log = Logger.getLogger(GetDeptAndMin.class);
    public static String crispDept = applicationConfig.getCleanAndRotateTestData().getCrispDepartment();
    public static String crispItem[] = applicationConfig.getCleanAndRotateTestData().getCrispItems();
    public static String nonCrispDept = applicationConfig.getCleanAndRotateTestData().getnonCrispDepartment();
    public static String nonCrispItem[] = applicationConfig.getCleanAndRotateTestData().getNonCrispItems();

    public static String productMin = null;
    public static String departmentNameUI = null;

    public GetDeptAndMin() {
        log.info("Inside : " + GetDeptAndMin.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    ///Getting Department name from yaml file
    @And("I Get Department Name for {string} type dept")
    public void getDepartmentName(String dept) throws Throwable {
        log.info("Getting Product Min");
        switch (dept){
            case "Crisp":
                departmentNameUI = crispDept;
                break;
            case "Non-Crisp":
                departmentNameUI = nonCrispDept;
                break;
            default:
                log.error("No Such Department : " + dept);
                Assert.fail("No such Department");
        }

    }


    ///Getting Product Min from yaml file
    @And("I Get {string} Product Min for {string} department")
    public void getProductMin(String minNo,String dept) throws Throwable {
        log.info("Getting Product Min");

        HashMap<String, Integer> allMin = new HashMap<String, Integer>();
        allMin.put("First", 0);
        allMin.put("Second", 1);
        allMin.put("Third", 2);

        int minIndex = allMin.get(minNo);

        switch (dept){
            case "Crisp":
                productMin = crispItem[minIndex];
                break;
            case "Non-Crisp":
                productMin = nonCrispItem[minIndex];
                break;
            default:
                log.error("No Such Department : " + dept);
                Assert.fail("Product Min is not available");
        }
    }

}
