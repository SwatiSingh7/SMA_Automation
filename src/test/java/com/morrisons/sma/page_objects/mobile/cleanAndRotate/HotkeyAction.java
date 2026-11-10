package com.morrisons.sma.page_objects.mobile.cleanAndRotate;

import com.morrisons.common.action.Hook;
import com.morrisons.common.helper.CommonHelperMethods;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import static com.morrisons.common.helper.CommonHelperMethods.selectOption;

public class HotkeyAction {
    private static AndroidDriver driveR;
    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    private final Logger log = Logger.getLogger(HotkeyAction.class);

    public HotkeyAction() {
        log.info("Inside : " + HotkeyAction.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    /**
     * Web Elements
     */

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Counts']")
    public WebElement countMenu;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Prompted Counts']")
    public WebElement promptedCountMenu;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Stock Adjustments']")
    public WebElement stockAdjustmentMenu;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Stock Information']")
    public WebElement stockInformationMenu;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Gaps, Lows, Highs']")
    public WebElement gLHMenu;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Fresh Code Check']")
    public WebElement freshCodeCheckMenu;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Clean and Rotate']")
    public WebElement cleanAndRotateMenu;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Markdowns']")
    public WebElement markdownMenu;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Price Integrity']")
    public WebElement priceIntegrityMenu;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Market Street']")
    public WebElement marketStreetMenu;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Main Menu']")
    public WebElement mainMenu;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Stock Adjustments']")
    public WebElement stockAdjustmentMainPage;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Stock Information']")
    public WebElement stockInformationMainPage;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'context_menu')]")
    public WebElement hotKeyOption;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Markdowns']")
    public WebElement markdownsPage;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Fresh Code Check']")
    public WebElement freshCodePage;

    /**
     * Public Methods
     **/

    public void clickOnOptionFromHotkeysMenu(String option) throws Throwable {

        log.info("Clicking on Home Page Option : " + option);
        switch (option) {
            case "Counts":
                selectOption(driveR, countMenu, option);
                break;
            case "Prompted Counts":
                selectOption(driveR, promptedCountMenu, option);
                break;
            case "Stock Adjustments":
                selectOption(driveR, stockAdjustmentMenu, option);
                break;
            case "Fresh Code Check":
                selectOption(driveR, freshCodeCheckMenu, option);
                break;
            case "Gaps, Lows, Highs":
                selectOption(driveR, gLHMenu, option);
                break;
            case "Clean and Rotate":
                selectOption(driveR, cleanAndRotateMenu, option);
                break;
            case "Markdowns":
                selectOption(driveR, markdownMenu, option);
                break;
            case "Price Integrity":
                selectOption(driveR, priceIntegrityMenu, option);
                break;
            case "Market Street":
                selectOption(driveR, marketStreetMenu, option);
                break;
            case "Stock Information":
                selectOption(driveR, stockInformationMenu, option);
                break;
            case "Main Menu":
                selectOption(driveR, mainMenu, option);
                break;


            default:
                log.error("No Such Menu Option : " + option);
                Assert.fail("No Such Menu Option : " + option);

        }
    }


    public void verifyOptionFromHotkeysMenu(String option) throws Throwable {

        log.info("Clicking on Home Page Option : " + option);
        switch (option) {
            case "Counts":
                CommonHelperMethods.verifyIfDisplayed(driveR, countMenu);
                break;
            case "Prompted Counts":
                CommonHelperMethods.verifyIfDisplayed(driveR, promptedCountMenu);
                break;
            case "Stock Adjustments":
                CommonHelperMethods.verifyIfDisplayed(driveR, stockAdjustmentMenu);
                break;
            case "Fresh Code Check":
                CommonHelperMethods.verifyIfDisplayed(driveR, freshCodeCheckMenu);
                break;
            case "Gaps, Lows, Highs":
                CommonHelperMethods.verifyIfDisplayed(driveR, gLHMenu);
                break;
            case "Clean and Rotate":
                CommonHelperMethods.verifyIfDisplayed(driveR, cleanAndRotateMenu);
                break;
            case "Markdowns":
                CommonHelperMethods.verifyIfDisplayed(driveR, markdownMenu);
                break;
            case "Price Integrity":
                CommonHelperMethods.verifyIfDisplayed(driveR, priceIntegrityMenu);
                break;
            case "Market Street":
                CommonHelperMethods.verifyIfDisplayed(driveR, marketStreetMenu);
                break;
            case "Stock Information":
                CommonHelperMethods.verifyIfDisplayed(driveR, stockInformationMenu);
                break;
            case "Main Menu":
                CommonHelperMethods.verifyIfDisplayed(driveR, mainMenu);
                break;
            default:
                log.error("No Such Menu Option : " + option);
                Assert.fail("No Such Menu Option : " + option);

        }
    }

    public void verifyOptionNotDisplayedOnHotkeys(String option) throws Throwable {

        log.info("Checking option is not displayed in Hotkeys menu : " + option);
        switch (option) {

            case "Stock Adjustments":
                CommonHelperMethods.verifyIfNotDisplayed(driveR, stockAdjustmentMenu,option);
                break;
            case "Markdowns":
                CommonHelperMethods.verifyIfNotDisplayed(driveR, markdownMenu,option);
                break;
            case "Stock Information":
                CommonHelperMethods.verifyIfNotDisplayed(driveR, stockInformationMenu,option);
                break;
            default:
                log.error("No Such Menu Option : " + option);
                Assert.fail("No Such Menu Option : " + option);

        }
    }


    public void clickOnHotkeys() throws Throwable {
        hotKeyOption.isDisplayed();
        log.info("hotKeyOption.isDisplayed()"+ hotKeyOption.isDisplayed());

        hotKeyOption.click();
    }

    public void verifyStockAdjustmentPageDisplayed() throws Throwable {
        stockAdjustmentMainPage.isDisplayed();
    }

    public void verifyFreshCodePageDisplayed() throws Throwable {
        freshCodePage.isDisplayed();
    }

    public void verifyStockinformationPageDisplayed() throws Throwable {
        stockInformationMainPage.isDisplayed();
    }

    public void verifyMarkdownsPageDisplayed() throws Throwable {
        markdownsPage.isDisplayed();
    }
}