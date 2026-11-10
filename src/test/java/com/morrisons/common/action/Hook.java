/**
 * @author Tanaji-Padwal
 * @updatedby Rahul Khetal
 * @date Aug 5, 2019
 * @updateddate Mar 15, 2022
 * @project cucumberframework
 */
package com.morrisons.common.action;


import com.morrisons.common.PageFactory.InitClass;
import com.morrisons.common.helper.CommonHelperMethods;
import com.morrisons.common.helper.MOCOHelperMethods;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import com.morrisons.sma.page_objects.mobile.cleanAndRotate.ActionLog;
import com.morrisons.sma.page_objects.mobile.old.MarkDownPO;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.UnreachableBrowserException;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


public class Hook {

    int iCtr=0;
    private static WebDriver driver;
    private static AndroidDriver driveR;
    private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
    private final Logger log = Logger.getLogger(Hook.class);
    public static boolean sMOCOPagetg;

/*    private static CustomExtentReporter customExtentReporter;*/
    private static boolean isReporterRunning;

    @Before("@web")
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//drivers//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Before("@pwatest")
    public void setUpAppium() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);
        cap.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus");
        //cap.setCapability(MobileCapabilityType.VERSION, "6.0");
        cap.setCapability(MobileCapabilityType.VERSION, "9.0");
        // cap.setCapability(MobileCapabilityType.APP,
        // System.getProperty("user.dir")+"//App//ApiDemos.apk");
        // driver = new AndroidDriver<WebElement>(new
        // URL("http://127.0.0.0:4723/wd/hub"), cap);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @BeforeStep(order = 0)

    public Collection<String> getScenario(Scenario sce){
        System.out.println("Scenario Name " + sce.getSourceTagNames());
        Collection<String> tagnames = sce.getSourceTagNames();
        return tagnames;
    }

    @Before("@sma")
    //@BeforeClass
    public AndroidDriver smaBefore() throws MalformedURLException, InterruptedException {
/*        String projectPath = System.getProperty("user.dir");
        System.out.println("Project path in runner: " + projectPath);
        File htmlReportOutputFile = new File(projectPath + "/Output/Reports/WasteValidation/" + "WasteValidation_Automation_Report_"
                + new SimpleDateFormat("dd-MMM-yyyy_HH-mm").format(new GregorianCalendar().getTime()) + ".html");
        if(!isReporterRunning){
            customExtentReporter = new CustomExtentReporter(htmlReportOutputFile);
            isReporterRunning = true;
        }*/
        /*
        Code for Running Selenium Webportal Scripts on AWS Device Farm.
        */

/*        String myProjectARN = "arn:aws:devicefarm:us-west-2:340606558223:testgrid-project:8323991a-8738-480a-a1c4-4f317c0f85ee";
        DeviceFarmClient client = DeviceFarmClient.builder().region(Region.US_WEST_2).build();
        CreateTestGridUrlRequest request = CreateTestGridUrlRequest.builder()
                .expiresInSeconds(300)
                .projectArn(myProjectARN)
                .build();
        CreateTestGridUrlResponse response = client.createTestGridUrl(request);
        URL testGridUrl = new URL(response.url());
        // You can now pass this URL into RemoteWebDriver.


        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("BROWSER_NAME", "Android");

        capabilities.setCapability("VERSION", "9.0");

        capabilities.setCapability("deviceName", "Pixel2API19");

        capabilities.setCapability("AUTOMATION_NAME", "uiautomator2");

//        capabilities.setCapability("newCommandTimeout", "400");

        capabilities.setCapability("autoGrantPermissions", "true");

        capabilities.setCapability("appPackage", applicationConfig.getWebElementEnviroment().getEnv());
        //capabilities.setCapability("appPackage", "com.morrisons.instore.sit");


        capabilities.setCapability("appActivity", "com.morrisons.instore.modules.login.LoginActivity");

        capabilities.setCapability("platformName", "Android");

         driver = new RemoteWebDriver(testGridUrl, capabilities);*/
try {
    DesiredCapabilities capabilities = new DesiredCapabilities();

    capabilities.setCapability("BROWSER_NAME", "Android");

    capabilities.setCapability("VERSION", "9.0");

    capabilities.setCapability("deviceName", "Pixel2API19");

    capabilities.setCapability("AUTOMATION_NAME", "uiautomator2");

//        capabilities.setCapability("newCommandTimeout", "400");

    capabilities.setCapability("autoGrantPermissions", "true");

    capabilities.setCapability("appPackage", applicationConfig.getWebElementEnviroment().getEnv());
    //capabilities.setCapability("appPackage", "com.morrisons.instore.sit");


    capabilities.setCapability("appActivity", "com.morrisons.instore.modules.login.LoginActivity");

    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability("–session-override", true);
//        capabilities.setCapability ("appPackage", "com.wdiodemoapp");
//        capabilities.setCapability ("appActivity", "com.wdiodemoapp.MainActivity");
    capabilities.setCapability("noReset", false);
    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
    capabilities.setCapability(MobileCapabilityType.ACCEPT_SSL_CERTS, true);
    capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);

    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
catch(WebDriverException we){
    while(iCtr<3) {
        Thread.sleep(10000);
        iCtr++;
        smaBefore();
    }
}
catch(Exception e){

}

        return driveR;
    }


    @Before("@timeChange")
//    @BeforeClass
    public AndroidDriver smaBeforeTime() throws MalformedURLException {
        /*
        Code for Running Selenium Webportal Scripts on AWS Device Farm.
        */

        /*String myProjectARN = "arn:aws:devicefarm:us-west-2:340606558223:testgrid-project:8323991a-8738-480a-a1c4-4f317c0f85ee";
        BasicAWSCredentials awsCreds = new BasicAWSCredentials("access_key_id", "secret_key_id");
        DeviceFarmClient client = DeviceFarmClient.builder().region(Region.US_WEST_2).build();
//        DeviceFarmClient client = DeviceFarmClient.builder().region(Region.US_WEST_2).build();
        CreateTestGridUrlRequest request = CreateTestGridUrlRequest.builder()
                .expiresInSeconds(300)
                .projectArn(myProjectARN)
                .build();
        CreateTestGridUrlResponse response = client.createTestGridUrl(request);
        URL testGridUrl = new URL(response.url());
        // You can now pass this URL into RemoteWebDriver.


        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("BROWSER_NAME", "Android");

        capabilities.setCapability("VERSION", "9.0");

        capabilities.setCapability("deviceName", "Pixel2API19");

        capabilities.setCapability("AUTOMATION_NAME", "uiautomator2");

//        capabilities.setCapability("newCommandTimeout", "400");

        capabilities.setCapability("appPackage", "com.android.settings");

        capabilities.setCapability("appActivity", "com.android.settings.Settings");

        capabilities.setCapability("platformName", "Android");

        driver = new RemoteWebDriver(testGridUrl, capabilities);*/
        int iCtr = 0;
        boolean sSts = true;
        LaunchApp: while(sSts == true) {
            try {
                iCtr++;
                DesiredCapabilities capabilities = new DesiredCapabilities();

                capabilities.setCapability("BROWSER_NAME", "Android");

                capabilities.setCapability("VERSION", "9.0");

                capabilities.setCapability("deviceName", "Pixel2API19");

                capabilities.setCapability("AUTOMATION_NAME", "uiautomator2");

//        capabilities.setCapability("newCommandTimeout", "400");

                capabilities.setCapability("appPackage", "com.android.settings");

                capabilities.setCapability("appActivity", "com.android.settings.Settings");

                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("–session-override", true);
//        capabilities.setCapability ("appPackage", "com.wdiodemoapp");
//        capabilities.setCapability ("appActivity", "com.wdiodemoapp.MainActivity");
                capabilities.setCapability("noReset", false);
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
                capabilities.setCapability(MobileCapabilityType.ACCEPT_SSL_CERTS, true);
                capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);

                driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                sSts = false;
                break LaunchApp;
            } catch (WebDriverException we) {
                if(iCtr<3) {
                    continue LaunchApp;
                }
                else{
                    sSts = false;
                    break LaunchApp;
                }
            }
        }
                return driveR;
    }

    @After(order = 0)
//    @AfterClass
    public void tearDown(Scenario ss) throws InterruptedException {
        try {
            Collection<String> sTagNames = getScenario(ss);
            String sTag = sTagNames.iterator().next();
            System.out.println("Main tag " + sTag);
            System.out.println("All tags " + sTagNames.stream().collect(Collectors.toList()).contains("@uuasuccessMgrCreateOrdr"));
            System.out.println("MOCO_RMSIntegration tags " + sTag.contains("MOCO_RMSIntegration"));
            List<String> lTagList = sTagNames.stream().collect(Collectors.toList());
            if(sTag.contains("UI_MOCOdemo") || lTagList.contains("@Review_MOCO_UI") || lTagList.contains("@MOCO_CreateManagerOrderScn") || lTagList.contains("@CustmrReview_MOCO_UI") || lTagList.contains("@MOCO_CreateCustomerOrderScn") || lTagList.contains("@uuasuccessMgrCreateOrdr")) {
            try {
                driveR = (AndroidDriver) getDriver();
                List<WebElement> oListEle = InitClass.createMultipleObjects(driveR, "oButton", "OK' or @text='Ok", "com.morrisons.sma.page_objects.mobile.MOCO." + "ManagerOrderPage");
                if(oListEle.size()>0) {
                    oListEle.get(0).click();
                }
                List<WebElement> oListEle1 = driveR.findElements(By.xpath("//android.widget.Button[@text='CANCEL' or @text='Cancel']"));
                if(oListEle1.size()>0) {
                    oListEle1.get(0).click();
                }
            }
            catch(Exception r){
                System.out.println(r);
            }

            MOCOHelperMethods oMOCOHelpObj = new MOCOHelperMethods();
            oMOCOHelpObj.clickBack("Shop Floor - Gap Scan","ManagerOrderPage");
            }

            MarkDownPO markDownPage = new MarkDownPO();
            markDownPage.selectHotKey();

            driveR.closeApp();
            driveR.quit();
            driver.quit();
        }
        catch (UnreachableBrowserException e) {
            if (e.getCause() instanceof NoSuchSessionException) {
                System.out.println("Session not found");
                }
        }
        catch (Exception e) {
            if (e.getCause() instanceof NoSuchSessionException) {
                System.out.println("Session not found");
            }
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @AfterStep
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
/*            try {
                log.info("Capturing Screen Shot");
				String screenshotName = scenario.getName().replaceAll(" ", "_");
				Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);

				File destinationPath = new File(System.getProperty("user.dir") + "/Output/Reports/screenshots/" + screenshotName + ".png");

                ImageIO.write(screenshot.getImage(), "PNG", destinationPath);

                //Copy taken screenshot from source location to destination location
                //Files.copy(sourcePath, destinationPath);
                Reporter.addScreenCaptureFromPath(destinationPath.toString());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }*/
            log.info("Capturing Screenshot...");
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            //This takes a screenshot from the driver at save it to the specified location
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
/*
                //Building up the destination path for the screenshot to save
                //Also make sure to create a folder 'screenshots' with in the cucumber-report folder
                String path = createDirectory() + "\\";
                String file = path + screenshotName + "_" + new SimpleDateFormat("ddMMyyyy_HHmmss").format(Calendar.getInstance().getTime()) +".png";

                File destinationPath = new File(file);
                log.info("Screenshot captured at : " + file);
                //Copy taken screenshot from source location to destination location
                Files.copy(sourcePath, destinationPath);*/
            log.info("Adding screenshot to report...");
            //This attach the specified screenshot to the test
            scenario.attach(sourcePath, "image/png", "image");
            //Reporter.addScreenCaptureFromPath(destinationPath.toString());
        }
    }

    private String createDirectory()
    {
        File dir = new File(System.getProperty("user.dir")+ "/Output/Reports/screenshots/" + new SimpleDateFormat("ddMMyyyy").format(Calendar.getInstance().getTime()));

        if(dir.exists())
        {
            log.info("A folder with name '"+new SimpleDateFormat("ddMMyyyy").format(Calendar.getInstance().getTime())+"' already exist");
        }
        else
        {
            dir.mkdir();
        }
        return dir.getPath();
    }
}
