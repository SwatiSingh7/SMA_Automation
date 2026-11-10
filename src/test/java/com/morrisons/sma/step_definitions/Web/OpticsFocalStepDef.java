package com.morrisons.sma.step_definitions.Web;
import com.morrisons.common.helper.FileHelper;
import com.morrisons.common.helper.WebApplicationHelper;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ApplicationContext;
import com.morrisons.common.utility.ConfigLoader;
import com.morrisons.common.utility.WebServicesUtilities;
import com.morrisons.sma.page_objects.mobile.cleanAndRotate.WeeklySchedule;
import com.morrisons.sma.page_objects.mobile.old.AWS_S3Upload;
import com.morrisons.sma.page_objects.mobile.old.LoginPagePO;
import com.morrisons.sma.step_definitions.service.Product.API_ServiceStepDef;
import com.morrisons.sma.step_definitions.service.old.opticFocalStrategies;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import javax.validation.constraints.AssertTrue;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

import static com.morrisons.common.helper.ElementRetry.scrollTo;
import static com.morrisons.common.helper.WebApplicationHelper.driver;
import static com.morrisons.sma.step_definitions.service.Product.API_ServiceStepDef.PRODUCT_SERVICE_BASE_URL;

public class OpticsFocalStepDef {
    int iBrCtr =0;
    @BeforeClass
    public void OpticsFocalStepDef() {
        WebApplicationHelper oo = new WebApplicationHelper();
        WebDriver driver = WebApplicationHelper.driver;
    }

    @Given("the Focal UI where I validate the data {string} inserted is updated into focal system")
    public void theFocalUIWhereIValidateTheDataInsertedIsUpdatedIntoFocalSystem(String item) throws InterruptedException, IOException {
        WebApplicationHelper oo = new WebApplicationHelper();
        driver.manage().window().maximize();
        //driver.manage().deleteAllCookies();
        ArrayList arrData = new ArrayList();
        FileHelper oFH = new FileHelper();
        arrData = oFH.getInputData();
//        LinkedHashMap ParentarrData = new LinkedHashMap();
//        LinkedHashMap arrData = new LinkedHashMap();
//        AWS_S3Upload oAWSUpld = new AWS_S3Upload();
//        ParentarrData = oAWSUpld.getProductData();
//        Set ParentKeyset = ParentarrData.keySet();
//        Iterator iParentIte = ParentKeyset.iterator();
        driver.get("https://action.staging.focal.dev/tasks/all");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder = 'Username / E-mail']")).sendKeys("user10");
        driver.findElement(By.xpath("//button[@type = 'submit']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id = 'login-form-password']")).sendKeys("Password2!");
        driver.findElement(By.xpath("//span[contains(.,'Sign In')]")).click();
        Thread.sleep(3000);
        SoftAssert softAssert = new SoftAssert();
        int l = arrData.size();
        if (l > 7) {
            l = 7;
        } else {
            l = arrData.size();
        }
        for (int i = 0; i < l; i++) {
            try {
//                String itemNo = iParentIte.next().toString();
//                arrData = (LinkedHashMap) ParentarrData.get(itemNo);
//                Set Keyset = arrData.keySet();
//                Iterator ite = Keyset.iterator();
                driver.findElement(By.xpath("//span[contains(.,'Count')]")).click();
                Thread.sleep(3000);
                driver.findElement(By.xpath("//input[@placeholder = 'Enter Barcode']")).click();
                driver.findElement(By.xpath("//input[@placeholder = 'Enter Barcode']")).clear();
                driver.findElement(By.xpath("//input[@placeholder = 'Enter Barcode']")).sendKeys(arrData.get(i).toString());
                driver.findElement(By.xpath("//*[@data-testid = 'ArrowForwardIcon']")).click();
                Thread.sleep(30000);
                String sqty = driver.findElement(By.xpath("//div[@class = 'css-1qpcxa9']/p")).getText();
//                if (sqty.equalsIgnoreCase("20.0")) {
                System.out.println("Item " + arrData.get(i).toString() + " updated with quantity " + sqty);
                Reporter.log("Item " + arrData.get(i).toString() + " updated with quantity " + sqty);
                softAssert.assertEquals("20.0",sqty,"Quantity didn't get updated");
//                }
            } catch (Exception e) {
                System.out.println(e);
                File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                File screenshotName = new File ("D:\\Screenshots\\"+System.currentTimeMillis()+"_"+".png");
                FileUtils.copyFile(scrFile, screenshotName);
                softAssert.fail("Error loading for item :" + arrData.get(i).toString() + e.toString());
                Reporter.log("<br><img src='"+screenshotName.getAbsolutePath()+"' height='300' width='300'/><br>");
                Reporter.log("Error loading for item :" + arrData.get(i).toString() + e.toString());
            }
        }
        softAssert.assertAll();
        driver.close();
        driver.quit();
    }

    @Then("I verify the {string} fields in the output file")
    public void iVerifyTheFieldsInTheOutputFile(String Fields) {
        String[] arrFields = Fields.split(",");
        ArrayList arrFieldsData = new ArrayList();
        AWS_S3Upload oAWSUpld = new AWS_S3Upload();
        arrFieldsData = oAWSUpld.getFieldData();
        for (int i = 0; i < arrFields.length - 1; i++) {
            if (Fields.contains(arrFieldsData.get(i).toString())) {
                Assert.assertTrue(Fields.contains(arrFieldsData.get(i).toString()));
            }
        }
    }

    @Given("the Focal UI where I validate the data got updated in the focal system")
    public void theFocalUIWhereIValidateTheDataGotUpdatedInTheFocalSystem() throws InterruptedException, IOException {
        {
            WebApplicationHelper oo = new WebApplicationHelper();
            driver.manage().window().maximize();
            //driver.manage().deleteAllCookies();
            LinkedHashMap ParentarrData = new LinkedHashMap();
            LinkedHashMap arrData = new LinkedHashMap();
            AWS_S3Upload oAWSUpld = new AWS_S3Upload();
            ParentarrData = oAWSUpld.getProductData();
            Set ParentKeyset = ParentarrData.keySet();
            Iterator iParentIte = ParentKeyset.iterator();
            driver.get("https://action.staging.focal.dev/tasks/all");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@placeholder = 'Username / E-mail']")).sendKeys("user10");
            driver.findElement(By.xpath("//button[@type = 'submit']")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//input[@id = 'login-form-password']")).sendKeys("Password2!");
            driver.findElement(By.xpath("//span[contains(.,'Sign In')]")).click();
            Thread.sleep(3000);
            SoftAssert softAssert = new SoftAssert();
            int l = ParentarrData.size();
            if (l > 7) {
                l = 7;
            } else {
                l = ParentarrData.size();
            }
            for (int i = 0; i < ParentarrData.size(); i++) {
                try {
                    String itemNo = iParentIte.next().toString();
                    arrData = (LinkedHashMap) ParentarrData.get(itemNo);
                    Set Keyset = arrData.keySet();
                    Iterator ite = Keyset.iterator();
                    driver.findElement(By.xpath("//span[contains(.,'Count')]")).click();
                    Thread.sleep(3000);
                    driver.findElement(By.xpath("//input[@placeholder = 'Enter Barcode']")).sendKeys(arrData.get(i + "|itemNumber").toString());
                    driver.findElement(By.xpath("//*[@data-testid = 'ArrowForwardIcon']")).click();
                    Thread.sleep(30000);
                    List<WebElement> oLi = driver.findElements(By.xpath("//div[@class = 'css-u4p24i']/p[2]"));
                    String sqty = driver.findElement(By.xpath("//div[@class = 'css-1qpcxa9']/p")).getText();
                    String sPckSize = oLi.get(0).getText();  //driver.findElement(By.xpath("//p[contains(.,'Stock Record level')]/following-sibling::p")).getText();
                    String sCasePckUPC = oLi.get(1).getText();  //driver.findElement(By.xpath("//p[contains(.,'Case pack barcode')]/following-sibling::p")).getText();
                    String sProductUPC = driver.findElement(By.xpath("//div[@class='css-h54kii']/p[1]")).getText();
                    String sReportDate = driver.findElement(By.xpath("//p[contains(.,'Range Since')]/following-sibling::p")).getText();
                    String sItemDesc = driver.findElement(By.xpath("//div[@class='css-h54kii']/p[2]")).getText();
//                if (sqty.equalsIgnoreCase("20.0")) {
                    System.out.println("Item updated with quantity " + sqty);
                    System.out.println("Item updated with PackSize " + sPckSize + " Value from output csv file " + arrData.get(i + "|casePack").toString());
                    System.out.println("Item updated with Product UPC " + sProductUPC + "  Value from output csv file " + arrData.get(i + "|productUpc").toString());
                    System.out.println("Item updated with Report Date " + sReportDate + "  Value from output csv file " + arrData.get(i + "|reportDate").toString());
                    System.out.println("Item updated with Item Description " + sItemDesc + "  Value from output csv file " + arrData.get(i + "|itemDescription").toString());
                    System.out.println("Item updated with Case Pack UPC " + sCasePckUPC + "  Value from output csv file " + arrData.get(i + "|caseUpc").toString());
                    String[] arrsPckSize = sPckSize.split(" ");
                    sPckSize = arrsPckSize[0];
                    softAssert.assertEquals(sProductUPC, arrData.get(i + "|productUpc").toString(), "Product UPC is not updated successfully for item " + itemNo);
                    softAssert.assertEquals(sCasePckUPC, arrData.get(i + "|caseUpc").toString(), "Case Pack UPC is not updated successfully for item " + itemNo);
                    softAssert.assertEquals(Double.valueOf(arrData.get(i + "|casePack").toString()), Double.valueOf(sPckSize), "Pack Size is not updated successfully for item " + itemNo + " Expected " + Double.valueOf(sPckSize) + " but found " + Double.valueOf(arrData.get(i + "|casePack").toString()));
                    softAssert.assertEquals(arrData.get(i + "|itemDescription").toString(), sItemDesc, "Item Deccription is not updated successfully for item " + itemNo);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.US);
                    String dd = arrData.get(i+"|reportDate").toString();
                    //convert String to LocalDate
                    LocalDate localDate = LocalDate.parse(dd, formatter);
                    //========================================
                    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMMM" + " d" + ", yyyy");
                    String dd1 = dateFormat.format(localDate);
                    softAssert.assertEquals(dd1.trim().equals(sReportDate.trim()), "Report Date is not updated successfully for item : " + itemNo + " Expected: " + dd1 + " Actual " +  sReportDate);
//                }
                } catch (Exception e) {
                    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                    File screenshotName = new File ("D:\\Screenshots\\"+System.currentTimeMillis()+"_"+".png");
                    FileUtils.copyFile(scrFile, screenshotName);
                    FileOutputStream screenshotStream = new FileOutputStream(screenshotName);
                    screenshotStream.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
//                    screenshotStream.close();
//                    Reporter.log(" <a href='"+screenshotName.getAbsolutePath()+"'> <img src='"+ screenshotName.getAbsolutePath()+"' height='200' width='200'/> </a>  ");
                    Reporter.log("<a href='"+ screenshotStream + "<br><img src='"+screenshotStream+"' height='300' width='300'/><br>");
                    softAssert.fail(e.getStackTrace().toString());
                    softAssert.fail(e.getMessage());
                    System.out.println(e);
                }
            }
            softAssert.assertAll();
            driver.close();
            driver.quit();
        }
    }

    @Then("I validate the data in the input file gets inserted in the outfile generated")
    public void iValidateTheDataInTheInputFileGetsInsertedInTheOutfileGenerated() {
        FileHelper.ValidateDataInputOutput();
    }

    @Given("the Focal UI where I create gaps for the items inserted under adapters")
    public void theFocalUIWhereICreateGapsForTheItemsInsertedUnderAdapters() throws InterruptedException {
        WebApplicationHelper oo = new WebApplicationHelper();
        driver.manage().window().maximize();
        driver.get("https://action.staging.focal.dev/tasks/all");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder = 'Username / E-mail']")).sendKeys("user10");
        driver.findElement(By.xpath("//button[@type = 'submit']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id = 'login-form-password']")).sendKeys("Password2!");
        driver.findElement(By.xpath("//span[contains(.,'Sign In')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[contains(.,'Reverse')]")).click();
        Thread.sleep(3000);
        WebElement oPage = driver.findElement(By.tagName("body"));
        oPage.sendKeys(Keys.CONTROL);
        oPage.sendKeys("108453538");
        //=====================================
        Thread.sleep(1000);
        String string = "108453538";
        //============================
        ArrayList arrData = new ArrayList();
        FileHelper oFH = new FileHelper();
        arrData = oFH.getInputData();
        int l = arrData.size();
        if (l > 7) {
            l = 7;
        } else {
            l = arrData.size();
        }
        for (int i = 0; i < l; i++) {
            //===================================
            StringSelection stringSelection = new StringSelection(arrData.get(i).toString());
            Toolkit.getDefaultToolkit().getSystemClipboard()
                    .setContents(stringSelection, null);
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.chord(Keys.LEFT_CONTROL, "v")).build().perform();
            oPage.sendKeys(Keys.CONTROL);
            oPage.sendKeys("V");
            oPage.click();
            Thread.sleep(2000);
            try {
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_CONTROL);

            } catch (AWTException e) {
                e.printStackTrace();
            }
            driver.findElement(By.xpath("//button[@data-testid='not-work-button']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[contains(.,'No Stock')]")).click();
        }
        //======================================
    }
    public String getAccessToken() throws InterruptedException {
        WebDriver dr = null;
        String sToken = null;
        int ictr = 0, ictr1 = 0;
        try {
            WebApplicationHelper oo = new WebApplicationHelper();
            dr = driver;
            dr.manage().window().maximize();
            dr.get("https://sma-singlesignon.sit.testapps.mymorri.com/");
            Thread.sleep(5000);
            dr.switchTo().frame(0);
            dr.findElement(By.xpath("//span[contains(.,'Sign in with Google')]")).click();
            Thread.sleep(3000);
        }
        catch(NoSuchElementException ne){
            Thread.sleep(3000);
            getAccessToken();
        }
        dr.switchTo().defaultContent();
        Thread.sleep(3000);
        String sWinHndl = dr.getWindowHandle();
        Set<String> ol = dr.getWindowHandles();
        String childHndl = null;
        Iterator ite = ol.iterator();
        for (int j = 0; j < ol.size(); j++) {
            childHndl = ite.next().toString();
        }
        dr.switchTo().window(childHndl);
        ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
        String managerUsername = applicationConfig.getUserCredentials().getManagerUsername();
        String managerPassword = applicationConfig.getUserCredentials().getManagerPassword();
//		dr.findElement(By.xpath("//span[contains(.,'Use another account')]")).click();
        dr.findElement(By.xpath("//input[@type = 'email']")).sendKeys(managerUsername);
        dr.findElement(By.xpath("//span[contains(.,'Next')]")).click();
        Thread.sleep(3000);
        boolean iPasswrdSts = true;
        PP: while(iPasswrdSts == true) {
            try {
                dr.findElement(By.xpath("//input[@type = 'password']")).sendKeys(managerPassword);
                dr.findElement(By.xpath("//span[contains(.,'Next')]")).click();
                Thread.sleep(5000);
            } catch (NoSuchElementException ee) {
                while (iBrCtr < 3) {
                    iBrCtr++;
                    dr.close();
                    dr.quit();
                    getAccessToken();
                }
                iBrCtr = 0;
            } catch (ElementNotInteractableException ee) {
                while (iBrCtr < 3) {
                    Thread.sleep(2000);
                    iBrCtr++;
                    System.out.println(ee + " " +  iBrCtr);
                    dr.navigate().refresh();
                    WebElement oELe = dr.findElement(By.xpath("//span[contains(.,'Next')]"));
                    scrollTo(dr, oELe);
                    Thread.sleep(2000);
                    continue PP;
                }
                iBrCtr = 0;
            } catch (Exception ee) {
                while (iBrCtr < 3) {
                    iBrCtr++;
                    System.out.println(ee + " " +  iBrCtr);
                    continue PP;
                }
                iBrCtr = 0;
            }
            iPasswrdSts = false;
            break PP;
        }
        Thread.sleep(3000);
        boolean totpinSts = true;
       aa:
       while(totpinSts == true) {
           try {
               if (dr.findElement(By.xpath("//input[@name = 'totpPin']")).isDisplayed()) {
                   LoginPagePO oLoginPage = new LoginPagePO();
                   sToken = oLoginPage.returnTokenKeyManager();
                   dr.findElement(By.xpath("//input[@name = 'totpPin']")).sendKeys(sToken);
                   dr.findElement(By.xpath("//span[contains(.,'Next')]")).click();
                   Thread.sleep(2000);
                   ol = dr.getWindowHandles();
                   System.out.println("Number of Windows " + ol.size());
                   if(ol.size() > 1){
                       Thread.sleep(7000);
                   }
               }
           }
        catch (NoSuchElementException ee) {
            while(ictr < 3) {
                ictr++;
                continue aa;
            }
            ictr = 0;
        }
           catch (ElementNotInteractableException ee) {
               while (ictr1 < 3) {
                   ictr1++;
                   WebElement oELe = dr.findElement(By.xpath("//span[contains(.,'Next')]"));
                   scrollTo(dr, oELe);
                   continue aa;
               }
               ictr1 = 0;
           }
           catch (Exception ee) {
               while (ictr1 < 3) {
                   ictr1++;
                   continue aa;
               }
               ictr1 = 0;
           }
           totpinSts = false;
           break aa;
       }
            dr.switchTo().window(sWinHndl);
            Thread.sleep(10000);
//        String scriptToExecute = "var performance = window.performance || window.mozPerformance || window.msPerformance || window.webkitPerformance || {}; var network = performance.getEntries() || {}; return network;";
//        String netData = ((JavascriptExecutor)dr).executeScript(scriptToExecute).toString();
//        System.out.println(netData);
//        Thread.sleep(3000);
            Iterator CookieItr = dr.manage().getCookies().iterator();
            String sCookieDetails = CookieItr.next().toString();
            if (!sCookieDetails.contains("access_token")) {
                dr.navigate().refresh();
                Thread.sleep(2000);
                CookieItr = dr.manage().getCookies().iterator();
                sCookieDetails = CookieItr.next().toString();
            }
            System.out.println("Cookies details captured " + sCookieDetails);
            String[] arrCookieDetails = sCookieDetails.split(";");
            String sAccessToken = arrCookieDetails[0];
            String[] arrAT = sAccessToken.split("=");
            dr.close();
            dr.quit();
        return arrAT[1];
    }

    @Given("the Focal UI where I validate the data inserted is updated into focal system for Stock Order Adapter")
    public void theFocalUIWhereIValidateTheDataInsertedIsUpdatedIntoFocalSystemForStockOrderAdapter() throws InterruptedException, IOException {
        {
            WebApplicationHelper oo = new WebApplicationHelper();
            driver.manage().window().maximize();
            //driver.manage().deleteAllCookies();
            LinkedHashMap ParentarrData = new LinkedHashMap();
            LinkedHashMap arrData = new LinkedHashMap();
            AWS_S3Upload oAWSUpld = new AWS_S3Upload();
            ParentarrData = oAWSUpld.getProductData();
            Set ParentKeyset = ParentarrData.keySet();
            Iterator iParentIte = ParentKeyset.iterator();
            driver.get("https://action.staging.focal.dev/tasks/all");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@placeholder = 'Username / E-mail']")).sendKeys("user10");
            driver.findElement(By.xpath("//button[@type = 'submit']")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//input[@id = 'login-form-password']")).sendKeys("Password2!");
            driver.findElement(By.xpath("//span[contains(.,'Sign In')]")).click();
            Thread.sleep(3000);
            int l = ParentarrData.size();
            if (l > 7) {
                l = 7;
            } else {
                l = ParentarrData.size();
            }
            SoftAssert softAssert = new SoftAssert();
            for (int i = 0; i < ParentarrData.size(); i++) {
                try {
                    String itemNo = iParentIte.next().toString();
                    arrData = (LinkedHashMap) ParentarrData.get(itemNo);
                    Set Keyset = arrData.keySet();
                    Iterator ite = Keyset.iterator();
                    driver.findElement(By.xpath("//span[contains(.,'Count')]")).click();
                    Thread.sleep(3000);
                    driver.findElement(By.xpath("//input[@placeholder = 'Enter Barcode']")).click();
                    driver.findElement(By.xpath("//input[@placeholder = 'Enter Barcode']")).clear();
                    driver.findElement(By.xpath("//input[@placeholder = 'Enter Barcode']")).sendKeys(arrData.get(i + "|itemNumber").toString());
                    driver.findElement(By.xpath("//*[@data-testid = 'ArrowForwardIcon']")).click();
                    Thread.sleep(30000);
                    String sqty = driver.findElement(By.xpath("//div[@class = 'css-1qpcxa9']/p")).getText();
//                if (sqty.equalsIgnoreCase("20.0")) {
                    System.out.println("Item " + arrData.get(i + "|itemNumber").toString() + " updated with quantity " + sqty);
//                    softAssert.assertEquals("20.0",sqty,"Quantity didn't get updated properly");
                    String sReportDate = driver.findElement(By.xpath("//span[contains(.,'Last received: ')]/strong")).getText();
                    String[] arrReportDate = sReportDate.split(" @");
                    sReportDate = arrReportDate[0];
//                    Date date = new SimpleDateFormat("MMMM dd, YYYY").parse(sReportDate);
//                    DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//                    String formatedDate = sdf.format(date);
                    WeeklySchedule ws = new WeeklySchedule();
                    //========================================
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.US);
                    String dd = arrData.get(i+"|lastReceivedDate").toString();
                    //convert String to LocalDate
                    LocalDate localDate = LocalDate.parse(dd, formatter);
                    //========================================
                    String dayNumberSuffix = ws.getDayNumberSuffix(localDate.getDayOfMonth());
                    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMMM" + " d'" + dayNumberSuffix + "', yyyy");
                    String dd1 = dateFormat.format(localDate);
                    softAssert.assertEquals(dd1.trim().equals(sReportDate.trim()), "Report Date is not updated successfully for item : " + itemNo + " Expected: " + dd1 + " Actual " +  sReportDate);
                    opticFocalStrategies.jsonGETResponseString = WebServicesUtilities.retryGETRequestWithout(PRODUCT_SERVICE_BASE_URL, "/items/" + arrData.get(i + "|itemNumber").toString(), "apikey", "AGyQZFUGD1CpY028eGGaFWaMrd4VBjVf", "Authorization", "Basic QUd5UVpGVUdEMUNwWTAyOGVHR2FGV2FNcmQ0VkJqVmY6Vzl5Z1lmR0FwaWptUTdBbQ==");
                    ApplicationContext applicationContext = new ApplicationContext();
                    API_ServiceStepDef oObj = new API_ServiceStepDef(applicationContext);
                    oObj.iGetTheFieldValueForTheField("packQuantity");
                    String sPackNo = ApplicationContext.oKeyField.get("packQuantity");
                    String FocalPackNo = null;
                    try {
                        FocalPackNo = driver.findElement(By.xpath("//p[contains(.,'Stock Record level')]/following-sibling::p")).getText();
                    }
                    catch(Exception ee){
                        FocalPackNo = driver.findElement(By.xpath("//p[contains(.,'Case pack size')]/following-sibling::p")).getText();
                    }
                    softAssert.assertEquals(sPackNo.equals(FocalPackNo), "Pack size is not updated successfully for item:" + itemNo + " Expected: " + sPackNo + " Actual:" + FocalPackNo);
//                }
                }
                catch(NullPointerException ne){

                }
                catch (Exception e) {
                    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                    File screenshotName = new File ("D:\\Screenshots\\"+System.currentTimeMillis()+"_"+".png");
                    FileUtils.copyFile(scrFile, screenshotName);
                    FileOutputStream screenshotStream = new FileOutputStream(screenshotName);
                    screenshotStream.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
//                    screenshotStream.close();
                    Reporter.log(" <a href='"+screenshotName.getAbsolutePath()+"'> <img src='"+ screenshotName.getAbsolutePath()+"' height='200' width='200'/> </a>  ");
//                    Reporter.log("<a href='"+ screenshotStream + "<br><img src='"+screenshotStream+"' height='300' width='300'/><br>");
                    StackTraceElement[] Exp = e.getStackTrace();
                    Reporter.log(Arrays.stream(Exp).sorted().toString());
//                    softAssert.fail(Arrays.stream(Exp).sorted().toString());
                    softAssert.fail(e.getStackTrace().toString());
                    softAssert.fail(e.getMessage());
                }
            }
            softAssert.assertAll();
            driver.close();
            driver.quit();
        }
    }
}
