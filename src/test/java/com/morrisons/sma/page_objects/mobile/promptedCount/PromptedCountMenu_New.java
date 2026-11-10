package com.morrisons.sma.page_objects.mobile.promptedCount;

import com.morrisons.common.action.Hook;
import com.morrisons.common.helper.MobileHelper;
import com.morrisons.sma.page_objects.mobile.cleanAndRotate.FrozenClearenceBayPage;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import static com.morrisons.common.helper.CommonHelperMethods.selectOption;

public class PromptedCountMenu_New {
    private static AndroidDriver driveR;
    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    private final Logger log = Logger.getLogger(FrozenClearenceBayPage.class);
    public static String actionStatus = null;


    public PromptedCountMenu_New() {
        log.info("Inside : " + PromptedCountMenu_New.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    /**
     * Web Elements
     */

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Market Street']")
    public WebElement marketStreetMenu;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Ambient & Frozen']")
    public WebElement ambientFrozenMenu;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Fresh']")
    public WebElement freshMenu;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Summary']")
    public WebElement summaryMenu;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Services']")
    public WebElement servicesMenu;

    /**
     * Public Methods
     **/
    public void clickOnPromptedCountOption(String option)  {
        log.info("Clicking on Home Page Option : " + option);
        switch (option) {
            case "Services":
                selectOption(driveR, servicesMenu, option);
                break;
            case "Summary":
                selectOption(driveR, summaryMenu, option);
                break;

            case "Ambient & Frozen":
                selectOption(driveR, ambientFrozenMenu, option);
                break;
            case "Fresh":
                selectOption(driveR, freshMenu, option);
                break;
            case "Market Street":
                selectOption(driveR, marketStreetMenu, option);
                break;
            default:
                log.error("No Such Menu Option : " + option);
                Assert.fail("No Such Menu Option : " + option);
        }

    }

    public void scrollDown() throws Throwable {
        log.info("Scrolling down on Stock Information page");
        //driveR.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        MobileHelper.scroll(driveR, 500, 1515, 800, 800);
    }


}
