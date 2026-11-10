package com.morrisons.sma.page_objects.mobile.marketStreet;

import com.morrisons.common.action.Hook;
import com.morrisons.common.helper.MobileHelper;
import com.morrisons.sma.page_objects.mobile.cleanAndRotate.ActionLog;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import static com.morrisons.common.helper.CommonHelperMethods.selectOption;

public class MarketStreetPO_New {
    private static AndroidDriver driveR;
    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    private final Logger log = Logger.getLogger(MarketStreetPO_New.class);


    public MarketStreetPO_New() {
        log.info("Inside : " + MarketStreetPO_New.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Sales Orders']")
    public WebElement salesOrderMenu;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Gaps, Lows, Highs']")
    public WebElement glhMenu;

    public void clickOnMarketStreetMenu(String glhSection) throws Throwable {
        log.info("Clicking on Market Street Option : " + glhSection);
        switch (glhSection) {
            case "Sales Orders":
                selectOption(driveR, salesOrderMenu, glhSection);
                break;
            case "Gaps, Lows, Highs":
                selectOption(driveR, glhMenu, glhSection);
                break;
            default:
                log.error("No such Menu is present : " + glhSection);
                Assert.fail("No such Menu is present : " + glhSection);
        }
    }

    public void scrollDown() throws Throwable {
        log.info("Scrolling down on Stock Information page");
        //driveR.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        MobileHelper.scroll(driveR, 500, 1515, 800, 800);
    }

}
