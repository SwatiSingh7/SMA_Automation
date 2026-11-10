package com.morrisons.sma.page_objects.mobile.stockAdjustment;

import com.morrisons.common.action.Hook;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import static com.morrisons.common.helper.CommonHelperMethods.selectOption;
import static com.morrisons.common.helper.CommonHelperMethods.verifyIfDisplayed;

public class ActionWastePO_New {

    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    public static final String WASTE_DAMAGED = "Waste - Damaged";
    public static final String WASTE_OUT_OF_DATE = "Waste - Out of Date";
    public static final String CHARITY_DAMAGED = "Charity - Damaged";
    public static final String CHARITY_OUT_OF_DATE = "Charity - Out of Date";
    public static final String WASTE_WITHDRAWAL = "Waste - Withdrawal";
    public static final String WASTE_REVERSE = "Waste - Reverse";
    public static final String FREE_FRUITS_FOR_KIDS = "Free Fruits for Kids";
    public static final String TOO_GOOD_TO_GO = "Too Good To Go";
    private static AndroidDriver driveR;

    private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
    String env = applicationConfig.getWebElementEnviroment().getEnv();
    private final Logger log = Logger.getLogger(ActionWastePO_New.class);


    public ActionWastePO_New() {
        log.info("Inside : " + ActionWastePO_New.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    /**
     * Web Elements
     */

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Waste - Damaged']")
    public WebElement optWasteDamaged;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Waste - Out of Date']")
    public WebElement optWasteOutOfDate;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Charity - Damaged']")
    public WebElement optCharityDamaged;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Charity - Out of Date']")
    public WebElement optCharityOutofDate;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Waste - Withdrawal']")
    public WebElement optWasteWithdrawal;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Waste - Reverse']")
    public WebElement optWasteReverse;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Free Fruits for Kids']")
    public WebElement optFreeFruitsforKids;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Too Good To Go']")
    public WebElement optTooGoodToGo;

/** Protected Methods **/

	/*protected String getBrandXpath(String name){
		log.debug(name);
		return "//div[@id='facetFilterOptions']//label[contains(.,'" + name + "')]";
	}*/

    /**
     * Public Methods
     **/
    public void clickOnActionWasteOption(String optActionWaste) throws Throwable {
        log.info("Verifying all options on Action Waste Page");
        //verifyAllReasonCodeDisplayedForActionWaste();
        log.info("Clicking on Action Waste Page Option : " + optActionWaste);
        switch (optActionWaste) {
            case WASTE_DAMAGED:
                selectOption(driveR, optWasteDamaged, optActionWaste);
                break;
            case WASTE_OUT_OF_DATE:
                selectOption(driveR, optWasteOutOfDate, optActionWaste);
                break;
            case CHARITY_DAMAGED:
                selectOption(driveR, optCharityDamaged, optActionWaste);
                break;
            case CHARITY_OUT_OF_DATE:
                selectOption(driveR, optCharityOutofDate, optActionWaste);
                break;
            case WASTE_WITHDRAWAL:
                selectOption(driveR, optWasteWithdrawal, optActionWaste);
                break;
            case WASTE_REVERSE:
                selectOption(driveR, optWasteReverse, optActionWaste);
                break;
            case FREE_FRUITS_FOR_KIDS:
                selectOption(driveR, optFreeFruitsforKids, optActionWaste);
                break;
            case TOO_GOOD_TO_GO:
                selectOption(driveR, optTooGoodToGo, optActionWaste);
                break;
            default:
                log.error("No Such Menu Option : " + optActionWaste);
                Assert.fail("No Such Menu Option : " + optActionWaste);
        }
    }

    private void verifyAllReasonCodeDisplayedForActionWaste() {
        verifyIfDisplayed(driveR, optWasteDamaged, WASTE_DAMAGED);
        verifyIfDisplayed(driveR, optWasteOutOfDate, WASTE_OUT_OF_DATE);
        verifyIfDisplayed(driveR, optCharityDamaged, CHARITY_DAMAGED);
        verifyIfDisplayed(driveR, optCharityOutofDate, CHARITY_OUT_OF_DATE);
        verifyIfDisplayed(driveR, optWasteWithdrawal, WASTE_WITHDRAWAL);
        verifyIfDisplayed(driveR, optWasteReverse, WASTE_REVERSE);
        verifyIfDisplayed(driveR, optFreeFruitsforKids, FREE_FRUITS_FOR_KIDS);
        verifyIfDisplayed(driveR, optTooGoodToGo, TOO_GOOD_TO_GO);
    }


}
