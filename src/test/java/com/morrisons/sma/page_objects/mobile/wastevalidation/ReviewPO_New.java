package com.morrisons.sma.page_objects.mobile.wastevalidation;

import com.morrisons.common.action.Hook;
import com.morrisons.common.helper.CommonHelperMethods;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import static com.morrisons.common.helper.CommonHelperMethods.verifyIfDisplayed;

public class ReviewPO_New {

    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    public static final String WASTE_RECORD = "Waste Record";
    public static final String VALIDATED = "Validated";
    public static final String DIFFERENCE = "Difference";
    public static final String REVIEW_SCREEN_MESSAGE = "Products marked as 'Fail' will be automatically recorded as \"Unrecorded Waste\"";
    private static AndroidDriver driveR;

    private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
    String env = applicationConfig.getWebElementEnviroment().getEnv();
    private final Logger log = Logger.getLogger(ReviewPO_New.class);

    public ReviewPO_New() {
        log.info("Inside : " + ReviewPO_New.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    /**
     * Web Elements
     */

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='REVIEW READY']")
    public WebElement optReviewStatus;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'waste_review_date')]")
    public WebElement reviewHeaderDate;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'waste_message_txt')]")
    public WebElement reviewScreenMessage;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='All']")
    public WebElement allTab;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Pass']")
    public WebElement passTab;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Fail']")
    public WebElement failTab;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'no_trays_validated_message')]")
    public WebElement screenMessage;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Backhaul']")
    public WebElement optBackhaul;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Review']")
    public WebElement optReview;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Validation Checks']")
    public WebElement optValidationChecks;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Weekly Manager Sign Off']")
    public WebElement optWeeklyManagerSignOff;

   /** Protected Methods **/

	/*protected String getBrandXpath(String name){
		log.debug(name);
		return "//div[@id='facetFilterOptions']//label[contains(.,'" + name + "')]";
	}*/

    /**
     * Public Methods
     **/

    public void veirfyHeaderDate(String headerDate) throws Throwable {
        log.info("Verifying Review is enabled");
        CommonHelperMethods.verifyIfDisplayed(driveR, reviewHeaderDate, headerDate);
    }

    public void veirfyReviewEnabled() throws Throwable {
        log.info("Verifying Review is enabled");
        CommonHelperMethods.verifyIfDisplayed(driveR, optReviewStatus);
    }

    public void clickOnAllTab() throws Throwable {
        log.info("Clicking on All Tab");
        //clickElement(driveR, allTab);
        allTab.click();
    }

    public void clickOnPassTab() throws Throwable {
        log.info("Clicking on Pass Tab");
        //clickElement(driveR, passTab);
        passTab.click();
    }

    public void clickOnFailTab() throws Throwable {
        log.info("Clicking on Fail Tab");
        //clickElement(driveR, failTab);
        failTab.click();
    }

    public void clickOnTab(String tab) throws Throwable {
        log.info("Clicking on Tab : " + tab);
        switch (tab) {
            case "All":
                clickOnAllTab();
                break;
            case "Pass":
                clickOnPassTab();
                break;
            case "Fail":
                clickOnFailTab();
                break;
            default:
                log.error("No Such Menu Option : " + tab);
                Assert.fail("No Such Menu Option : " + tab);
        }
    }

    public void verifyTab(String tab) throws Throwable {
        log.info("Verifying Tab : " + tab);
        switch (tab) {
            case "All":
                CommonHelperMethods.verifyIfDisplayed(driveR, allTab);
                break;
            case "Pass":
                CommonHelperMethods.verifyIfDisplayed(driveR, passTab);
                break;
            case "Fail":
                CommonHelperMethods.verifyIfDisplayed(driveR, failTab);
                break;
            default:
                log.error(tab + " tab not enabled.");
                Assert.fail(tab + " tab not enabled.");
        }
    }

    public void clickOnTabAndverifyIfDisplayed(String tab,
                                    String itemDetails,
                                    String status,
                                    String minDetails,
                                    String wasteRecorded,
                                    String wasteValidated,
                                    String wasteDifference) throws Throwable {
        clickOnTab(tab);
        verifyWaste(itemDetails, status, minDetails, wasteRecorded, wasteValidated, wasteDifference);
    }

    public void verifyWaste(String itemDetails,
                            String status,
                            String minDetails,
                            String wasteRecorded,
                            String wasteValidated,
                            String wasteDifference) throws Throwable {
        verifyItemDetails(minDetails, itemDetails);
        verifyStatus(minDetails, status);
        verifyMIN(minDetails);
        verifyWasteRecordedText(minDetails);
        verifyValidatedText(minDetails);
        verifyDifferenceText(minDetails);
        verifyWasteRecordedValue(minDetails, wasteRecorded);
        verifyValidatedValue(minDetails, wasteValidated);
        verifyDifferenceValue(minDetails, wasteDifference);
    }

    private void verifyMIN(String minDetails) {
        By minXpath = By.xpath("//android.widget.TextView[@text='" + minDetails + "']");
        verifyIfDisplayed(driveR, minXpath, minDetails);
    }

    private void verifyItemDetails(String minDetails, String itemDetails) {
        By xpath = By.xpath("//android.widget.TextView[@text='" + minDetails + "']/../parent::android.widget.RelativeLayout/android.widget.TextView[@index='0']");
        verifyIfDisplayed(driveR, xpath, itemDetails);
    }

    private void verifyStatus(String minDetails, String status) {
        By xpath = By.xpath("//android.widget.TextView[@text='" + minDetails + "']/../parent::android.widget.RelativeLayout/android.widget.TextView[@index='1']");
        verifyIfDisplayed(driveR, xpath, status);
    }

    private void verifyWasteRecordedText(String minDetails) {
        By xpath = By.xpath("//android.widget.TextView[@text='" + minDetails + "']/../parent::android.widget.RelativeLayout//android.widget.TableLayout[@index='3']//android.widget.TextView[@index='0']");
        verifyIfDisplayed(driveR, xpath, WASTE_RECORD);
    }

    private void verifyValidatedText(String minDetails) {
        By xpath = By.xpath("//android.widget.TextView[@text='" + minDetails + "']/../parent::android.widget.RelativeLayout//android.widget.TableLayout[@index='3']//android.widget.TextView[@index='2']");
        verifyIfDisplayed(driveR, xpath, VALIDATED);
    }

    private void verifyDifferenceText(String minDetails) {
        By xpath = By.xpath("//android.widget.TextView[@text='" + minDetails + "']/../parent::android.widget.RelativeLayout//android.widget.TableLayout[@index='3']//android.widget.TextView[@index='4']");
        verifyIfDisplayed(driveR, xpath, DIFFERENCE);
    }

    private void verifyWasteRecordedValue(String minDetails, String value) {
        By xpath = By.xpath("//android.widget.TextView[@text='" + minDetails + "']/../parent::android.widget.RelativeLayout//android.widget.TableLayout[@index='4']//android.widget.TextView[@index='0']");
        verifyIfDisplayed(driveR, xpath, value);
    }

    private void verifyValidatedValue(String minDetails, String value) {
        By xpath = By.xpath("//android.widget.TextView[@text='" + minDetails + "']/../parent::android.widget.RelativeLayout//android.widget.TableLayout[@index='4']//android.widget.TextView[@index='2']");
        verifyIfDisplayed(driveR, xpath, value);
    }

    private void verifyDifferenceValue(String minDetails, String value) {
        By xpath = By.xpath("//android.widget.TextView[@text='" + minDetails + "']/../parent::android.widget.RelativeLayout//android.widget.TableLayout[@index='4']//android.widget.TextView[@index='4']");
        verifyIfDisplayed(driveR, xpath, value);
    }


    public void verifyWaseteReverseMIN(String minDetails) {
        boolean flag = false;
        String xpath = "//android.widget.TextView[@text='" + minDetails + "']";
        try {
            WebElement ele = driveR.findElement(By.xpath(xpath));
            Assert.fail(minDetails + " is present in UI, Waste reverse scenario has Failed.");
        } catch (Exception e) {
            log.info("Given Waste Reverse min " + minDetails + " is not present in UI, Waste reverse scenario has PASSED.");
        }

    }

    public void verifyMessageOfReviewScreen() {
       CommonHelperMethods.verifyIfDisplayed(driveR, reviewScreenMessage, REVIEW_SCREEN_MESSAGE);
    }
//    public String getCurrentDateExpected(){
//
//        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("EEEE d MMM");
//        String date = DATE_FORMAT.format(new Date());
//        String currentDate = date;
//        String[] a = currentDate.split(" ");
//        String weekDay =(a[0]);
//        String dd;
//        int day =0;
//        day = Integer.parseInt(a[1]);
//        if(day>20){
//
//          dd = (a[1]+"st");
//        }else {
//            dd = (a[1]+"th");
//        }
//        String mon= (a[2]);
//        String expected = (weekDay.concat(" "+dd).concat(" "+mon));
//        System.out.println("Expected Date: "+expected);
//        return expected;
//
//    }


    public void clickTabVerifyReviewScreenMessage(String tab, String expectedMessage) throws Throwable {
        clickOnTab(tab);
        verifyMessage(expectedMessage);
    }

    private void verifyMessage(String expectedMessage) throws Throwable {
        log.info("Getting Screen Message");
        String actualScreenMessage = /*getText(driveR, screenMessage)*/screenMessage.getText();
        log.info("Verifying Screen Message");
        Assert.assertEquals(actualScreenMessage, expectedMessage);
    }
}

