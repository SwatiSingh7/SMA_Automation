package com.morrisons.sma.page_objects.mobile.trays;

import com.morrisons.common.action.Hook;
import com.morrisons.common.helper.CommonHelperMethods;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static com.morrisons.common.helper.CommonHelperMethods.verifyIfDisplayed;
import static com.morrisons.common.helper.ElementRetry.clickElementFromListWithText;

public class TraySelectionPO_New {

    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    private static AndroidDriver driveR;
    public static final String VALIDATION_CHECK_SCREEN_MESSAGE = "Please select a tray to start waste validation. To add more trays press the plus button below.";
    private static final ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
    String env = applicationConfig.getWebElementEnviroment().getEnv();
    private final Logger log = Logger.getLogger(TraySelectionPO_New.class);


    public TraySelectionPO_New() {
        log.info("Inside : " + TraySelectionPO_New.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    /**
     * Web Elements
     */

    @FindBy(how = How.XPATH, using = "//android.widget.Button[contains(@resource-id,'inner_button') or text()='COMPLETE CHECK']")
    public WebElement completeCheckButton;

    @FindBy(how = How.XPATH, using = "//android.widget.ImageButton[contains(@resource-id,'add_tray_fab')]")
    public WebElement addTrayButton;

    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[contains(@resource-id,'toolbar')]/android.widget.ImageButton[@index=0]")
    public WebElement backButton;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'tvTrayName')]")
    public WebElement trayOption;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@index='0']/parent::android.widget.RelativeLayout/android.widget.TextView[contains(@resource-id,'tvTrayStatus')]")
    public WebElement optTrayStatus;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'tvTrayInfo')]")
    public WebElement validationCheckHeaderTextMsg;
    /**
     * Protected Methods
     *
     * @return
     */

    protected void selectTrayXpath(String trayNumber) throws InterruptedException {
//        int trayNo = Integer.parseInt(trayNumber) - 1;
/*        log.info("Selecting Tray : //android.widget.TextView[@index='" + trayNo + "']");
        List<WebElement> listOfTrays = driveR.findElements(By.xpath("//android.widget.TextView[@index='" + trayNo + "']"));
        String expectedTrayText = "Tray/Container " + trayNumber;
        for (WebElement eachTrayElement :
                listOfTrays) {
            if (eachTrayElement.getText().equalsIgnoreCase(expectedTrayText)) {
                eachTrayElement.click();
                break;
            }
        }*/

        String xpathForWebElements = "//android.widget.TextView[@index='0']";
        String expectedTrayText = "Tray/ Container " + trayNumber;

        //waitForElementVisible(driveR,trayOption);
        trayOption.isDisplayed();
        clickElementFromListWithText(driveR, xpathForWebElements, expectedTrayText);
    }

    /**
     * Public Methods
     **/

    public void selectTray(String trayNo) throws InterruptedException {
        log.info("Selecting Tray : " + trayNo);
        selectTrayXpath(trayNo);
    }

    public void verifyNoOfTrays(List<String> trayList) throws InterruptedException {
        log.info("Getting all the Trays");
        String xpathForWebElements = "//android.widget.TextView[@index='0']";
        log.info("Finding all Elements with Xpath : " + xpathForWebElements);
        Thread.sleep(3000);
        List<WebElement> listOfElement = driveR.findElements(By.xpath(xpathForWebElements));
        List<String> actualList = new ArrayList<>();
        for (WebElement eachElement :
                listOfElement) {
            if (!eachElement.getText().isEmpty()) {
                actualList.add(eachElement.getText());
            }
        }
        log.info("Actual Tray List : " + actualList);
        for (String expectedString:
             trayList) {
            log.info(expectedString);
            Assert.assertTrue(actualList.contains(expectedString), "Tray Not Found on UI : " + expectedString);
        }
    }

    public void clickOnAddTrayButton() throws Throwable {
        log.info("Clicking on Add Tray Button");
        //clickElement(driveR, addTrayButton);
        addTrayButton.click();
    }

    public void clickOnCompleteCheckButton() throws Throwable {
        log.info("Clicking on Complete Check Button");
        //clickElement(driveR, completeCheckButton);
        completeCheckButton.click();
    }

    public void clickOnBackButton() throws Throwable {
        log.info("Clicking on Back Button");
        //clickElement(driveR, backButton);
        backButton.click();
    }

    public void verifyStatusOfTray(String trayStatus) throws Throwable {
        log.info("Verifying status of tray");
        verifyIfDisplayed(driveR, optTrayStatus, trayStatus);
    }

    public void verifyMessageOfValidationCheckScreen() {
        CommonHelperMethods.verifyIfDisplayed(driveR, validationCheckHeaderTextMsg, VALIDATION_CHECK_SCREEN_MESSAGE);

    }
    public void verifyAddTrayDisplayedAndStatus(String statusEnableDisable) throws InterruptedException {
        CommonHelperMethods.verifyIfDisplayed(driveR, addTrayButton);
        CommonHelperMethods.verifyButtonStatus(addTrayButton, statusEnableDisable);

    }
}
