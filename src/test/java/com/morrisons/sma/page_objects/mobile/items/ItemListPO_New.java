package com.morrisons.sma.page_objects.mobile.items;

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

import java.util.List;

public class ItemListPO_New {

    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    private static AndroidDriver driveR;

    private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
    String env = applicationConfig.getWebElementEnviroment().getEnv();
	private final Logger log = Logger.getLogger(ItemListPO_New.class);


    public ItemListPO_New() {
        log.info("Inside : " + ItemListPO_New.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    /**
     * Web Elements
     */

    @FindBy(how = How.XPATH, using = "//android.widget.LinearLayout[contains(@resource-id,'singleItemHeader')]")
    public WebElement viewList;

    @FindBy(how = How.XPATH, using = "//android.widget.Button[@text='DONE' or @text='Done']")
    public WebElement doneButton;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id ,'id/value')]")
    public List<WebElement> itemList;


/** Protected Methods **/

	/*protected String getBrandXpath(String name){
		log.debug(name);
		return "//div[@id='facetFilterOptions']//label[contains(.,'" + name + "')]";
	}*/

    /**
     * Public Methods
     **/

    public void clickOnViewList() throws Throwable {
        log.info("Clicking on Confirm Button");
        //clickElement(driveR, viewList);
        viewList.click();
    }

    public void clickOnDoneButton() throws Throwable {
        log.info("Clicking on Done Button");
        Thread.sleep(3000);
        //clickElement(driveR, confirmButton);
        doneButton.click();
    }

    public static String productName = null;
    public void clickOnItemList() throws Throwable {
        log.info("Clicking on Product list");
        for (WebElement product : itemList) {
            productName = product.getText();
            log.info("Product Name : " + productName);
            product.click();
            break;
        }
    }
}
