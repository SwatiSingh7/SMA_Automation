package com.morrisons.sma.page_objects.mobile.marketStreet;

import com.morrisons.common.action.Hook;
import com.morrisons.common.helper.MobileHelper;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import static com.morrisons.common.helper.CommonHelperMethods.selectOption;

public class MarketStreetGLHPO_New {
    private static AndroidDriver driveR;
    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    private final Logger log = Logger.getLogger(MarketStreetGLHPO_New.class);

    public MarketStreetGLHPO_New() {
        log.info("Inside : " + MarketStreetGLHPO_New.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Counter & Fixture']")
    public WebElement counterFixerMenu;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Other']")
    public WebElement otherMenu;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Review']")
    public WebElement reviewMenu;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Backup']")
    public WebElement backUpMenu;


    public void clickOnMarketStreetGLHMenu(String glhSection) throws Throwable {
        log.info("Clicking on Market Street Gaps Low Highs Page Option : " + glhSection);
        switch (glhSection) {
            case "Counter & Fixture":
                selectOption(driveR, counterFixerMenu, glhSection);
                break;
            case "Other":
                selectOption(driveR, otherMenu, glhSection);
                break;
            case "Review":
                selectOption(driveR, reviewMenu, glhSection);
                break;
            case "Backup":
                selectOption(driveR, backUpMenu, glhSection);
                break;

            default:
                log.error("No such Menu is present : " + glhSection);
                Assert.fail("No such Menu is present : " + glhSection);
        }
    }
    public void scrollDown() throws Throwable {
        log.info("Scrolling down on Stock Information page");
        //driveR.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        MobileHelper.scroll(driveR, 500, 1515, 1000,1000);
    }
    public void iVerifyLastOrderStatus() throws Throwable {
        log.info("Verifying Last Order status");
        //driveR.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        MobileHelper.scroll(driveR, 500, 1515, 1000,1000);
    }


}
