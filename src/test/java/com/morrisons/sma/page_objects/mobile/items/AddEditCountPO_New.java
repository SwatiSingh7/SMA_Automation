package com.morrisons.sma.page_objects.mobile.items;

import com.morrisons.common.action.Hook;
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

public class AddEditCountPO_New {

    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    private static AndroidDriver driveR;

    private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
    String env = applicationConfig.getWebElementEnviroment().getEnv();
    private final Logger log = Logger.getLogger(AddEditCountPO_New.class);


    public AddEditCountPO_New() {
        log.info("Inside : " + AddEditCountPO_New.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='ADD TO COUNT']")
    public WebElement addToCountButton;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='EDIT COUNT']")
    public WebElement editCountButton;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'waste_validation_list_item_quantity')]")
    public WebElement qty;

    public void clickAddCountButton() {
        log.info("Clicking on Add To Count Button");
        //clickElement(driveR, addToCountButton);
        addToCountButton.click();
    }

    public void clickEditCountButton() {
        log.info("Clicking on Edit Count Button");
        //clickElement(driveR, editCountButton);
        editCountButton.click();
    }

    public void verifyAddCountButton(String addedQty) {
        By dispAddedQty = By.xpath("//android.widget.TextView[contains(@resource-id,'waste_validation_list_item_quantity')]");
        verifyIfDisplayed(addedQty, dispAddedQty);
    }

    public void verifyEditButton(String editedQty) {
        By dispAddedQty = By.xpath("//android.widget.TextView[contains(@resource-id,'waste_validation_list_item_quantity')]");
        verifyIfDisplayed(editedQty, dispAddedQty);
    }

    private void verifyIfDisplayed(String value, By xpath) {
        log.info("Xpath : " + xpath);
        String actual = driveR.findElement(xpath).getText();
        log.info("Actual Value : " + actual);
        log.info("Expected Value : " + value);
        Assert.assertEquals(actual, value);
    }

    public void verifyButtonsDisplayed(String addCount, String editCount) throws Throwable {
        verifyButtons(addCount, editCount);
    }

    private void verifyButtons(String addCount, String editCount) throws Throwable {
        log.info("Getting buttons displayed");
        String actualButton1 = /*getText(driveR, addToCountButton)*/addToCountButton.getText();
        String actualButton2 = /*getText(driveR, editCountButton)*/editCountButton.getText();
        log.info("Verifying Buttons displayed");
        Assert.assertEquals(actualButton1, addCount);
        Assert.assertEquals(actualButton2, editCount);
    }
}

