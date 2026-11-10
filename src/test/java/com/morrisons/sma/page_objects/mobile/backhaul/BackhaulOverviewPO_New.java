package com.morrisons.sma.page_objects.mobile.backhaul;

import com.morrisons.common.action.Hook;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import com.morrisons.sma.page_objects.mobile.pallets.BackhaulPalletPO_New;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

public class BackhaulOverviewPO_New {

    public static final int PAGE_FACTORY_TIME_OUT_IN_SECONDS = 10;
    private static AndroidDriver driveR;

    private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
    String env = applicationConfig.getWebElementEnviroment().getEnv();
    private final Logger log = Logger.getLogger(BackhaulOverviewPO_New.class);

    BackhaulPalletPO_New backhaul = new BackhaulPalletPO_New();
    public BackhaulOverviewPO_New() {
        log.info("Inside : " + BackhaulOverviewPO_New.class);
        this.driveR = (AndroidDriver) Hook.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driveR, PAGE_FACTORY_TIME_OUT_IN_SECONDS), this);
    }

    /**
     * Web Elements
     */
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Backhaul Overview']")
    public WebElement overviewBackhaul;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'confirmDescription')]")
    public WebElement overviewconfirmDescription;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Trays for Backhaul']")
    public WebElement trayscountlabel;

    @FindBy(how = How.XPATH, using = "//android.widget.EditText[contains(@resource-id,'editText_BackhaulCount')]")
    public WebElement trayscountvalue;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Pallets for Backhaul']")
    public WebElement palletcountlabel;

    @FindBy(how = How.XPATH, using = "//android.widget.EditText[contains(@resource-id,'editText_PalletCount')]")
    public WebElement palletcountvalue;

    @FindBy(how = How.XPATH, using = "//android.widget.Button[contains(@resource-id,'inner_button') or text()='CONFIRM']")
    public WebElement confirmButton;

    @FindBy (how = How.XPATH, using = "//android.widget.TextView[@text='Backhaul']//following::android.widget.TextView[1]")
    public WebElement backhualstatus;

    @FindBy(how = How.XPATH, using = "//android.widget.ImageView[contains(@resource-id,'backhaul_edit_btn')]")
    public WebElement backhualeditButton;

    @FindBy(how = How.XPATH, using = "//android.widget.ImageView[contains(@resource-id,'pallet_edit_btn')]")
    public WebElement palleteditButton;


    public void verifybackhauloverviewsheader() {
        log.info("Backhaul Overview");
        /*checkElementExist(overviewBackhaul);*/
        overviewBackhaul.isDisplayed();
    }

    public void verifybackhualoverviewDescription(String expectedMessage) {
        log.info("Backhaul Overview Description");
        String actualMessage = /*getText(driveR, overviewconfirmDescription)*/overviewconfirmDescription.getText();
        log.info("Verifying Backhaul Overview Description");
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    public void verifytrayscountlabel() {
        log.info("Trays Count Label");
        /*checkElementExist(trayscountlabel);*/
        trayscountlabel.isDisplayed();
    }

    public void Verifypalletcountlabel() {
        log.info("Pallet Count Label");
        /*checkElementExist(palletcountlabel);*/
        palletcountlabel.isDisplayed();
    }

    public void verifytrayscountvalue(String noOfTray) {
        log.info("Trays Count Value");
        String actualValue = /*getText(driveR, trayscountvalue)*/trayscountvalue.getText();
        log.info("Verifying Trays Count Value");
        Assert.assertEquals(actualValue, noOfTray);
    }

    public void verifypalletscountvalue(String noOfPallet) {
        log.info("Pallet Count Value");
        String actualValue = /*getText(driveR, palletcountvalue)*/palletcountvalue.getText();
        log.info("Verifying Pallet Count Value");
        Assert.assertEquals(actualValue, noOfPallet);
    }

    public void clickOnConfirmButton() throws Throwable {
        log.info("Clicking on Confirm Button " + confirmButton);
        /*clickElement(driveR, confirmButton);*/
        confirmButton.click();
    }
    private void verifystatus(String status) throws InterruptedException {
        log.info("backhaul status"); ///backhaul status
        Thread.sleep(2000);
        String actulstatus = /*getText(driveR, backhualstatus)*/backhualstatus.getText();
        log.info("Verifying Backhaul status");
        Assert.assertEquals(actulstatus, status);
    }

    public void editbackhualcount(String editqty){
        log.info("edit tray for backhaul count");
        /*clickElement(driveR, backhualeditButton);*/
        backhualeditButton.click();
        /*enterText(trayscountvalue, editqty);*/
        trayscountvalue.sendKeys(editqty);
    }
    public void editpalletcount(String editqty){
        log.info("edit pallets for backhaul count");
        /*clickElement(driveR, palleteditButton);*/
        palleteditButton.click();
        /*enterText(palletcountvalue, editqty);*/
        palletcountvalue.sendKeys(editqty);
    }
    public void verifyOverviewScreennMessage(String expectedMessage) {
        verifybackhauloverviewsheader();  //backhual overview screen
        verifybackhualoverviewDescription(expectedMessage);
        verifytrayscountlabel();
        Verifypalletcountlabel();
    }

    public void verifybackhaulpalletNtrayCount(String noOfTray, String noOfPallet) {
        verifytrayscountvalue(noOfTray);
        verifypalletscountvalue(noOfPallet);
    }

    public void confirmBackhaul() throws Throwable {
        clickOnConfirmButton();
    }

    public void verifybackhaulstatus(String status) throws InterruptedException {
        verifystatus(status);
    }

    public void editcountfortray(String editcount1, String  editcount2) throws Throwable {
        editbackhualcount(editcount1);
        backhaul.clickOnMobileGo();
        editpalletcount(editcount2);
        backhaul.clickOnMobileGo();

    }
public void isbackhaulOverviewEditable(){
    boolean istraycount = trayscountvalue.isSelected();
    boolean ispalletcount = palletcountvalue.isSelected();
    log.info("verify backhaul overview is not editable");
    Assert.assertEquals(istraycount, false , "Tray is Editable");
    Assert.assertEquals(ispalletcount, false , "Pallet is Editable");

    }
}
