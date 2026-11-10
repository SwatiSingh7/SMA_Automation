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

public class AmbientFrozenPromptedCountMenu_New {
    private static AndroidDriver driveR;
    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    private final Logger log = Logger.getLogger(FrozenClearenceBayPage.class);
    public static String actionStatus = null;


    public AmbientFrozenPromptedCountMenu_New() {
        log.info("Inside : " + AmbientFrozenPromptedCountMenu_New.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    /**
     * Web Elements
     */

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Fixture']")
    public WebElement fixtureMenu;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Off Shelf']")
    public WebElement offShelfMenu;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Petrol']")
    public WebElement petrolMenu;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Warehouse']")
    public WebElement warehouseMenu;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Actions & Next Steps']")
    public WebElement actionsNextStepsMenu;

    /**
     * Public Methods
     **/
    public void clickOnAmbientPromptedCountOption(String option) throws Throwable {
        log.info("Clicking on Home Page Option : " + option);
        switch (option) {
            case "Fixture":
                selectOption(driveR, fixtureMenu, option);
                break;
            case "Petrol":
                selectOption(driveR, petrolMenu, option);
                break;

            case "Actions & Next Steps":
                selectOption(driveR, actionsNextStepsMenu, option);
                break;
            case "Warehouse":
                selectOption(driveR, warehouseMenu, option);
                break;
            case "Off Shelf":
                selectOption(driveR, offShelfMenu, option);
                break;
            default:
                log.error("No Such Menu Option : " + option);
                Assert.fail("No Such Menu Option : " + option);
        }

    }

    public void scrollDown() throws Throwable {
        log.info("Scrolling down on Stock Information page");
        //driveR.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        MobileHelper.scroll(driveR, 500, 1515, 800,800);
    }


}
