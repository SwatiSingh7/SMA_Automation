package com.morrisons.sma.step_definitions.mobile.cleanAndRotate;

import com.morrisons.sma.page_objects.mobile.cleanAndRotate.HotkeyAction;
import io.cucumber.java.en.When;

public class HotKeysActionStepDef {
    HotkeyAction hotkeyAction = new HotkeyAction();

    @When("I verify {string} is not available in hotkeys")
    public void iVerifyOptionNotAvailable(String Option) throws Throwable {
        hotkeyAction.verifyOptionNotDisplayedOnHotkeys(Option);
    }

    @When("I verify option {string} is available in hotkeys")
    public void iVerifyOptionAvailable(String Option) throws Throwable {
        hotkeyAction.verifyOptionFromHotkeysMenu(Option);
    }

    @When("I click on option {string} from hotkeys")
    public void iClickOnOptionFromHotkeys(String option) throws Throwable {
        hotkeyAction.clickOnOptionFromHotkeysMenu(option);
    }

    @When("I verify Stock Adjustment page  is displayed")
    public void iVerifyStockAdjustmentPageDisplayed() throws Throwable {
        hotkeyAction.verifyStockAdjustmentPageDisplayed();
    }
    @When("I verify Fresh Code Check page  is displayed")
    public void iVerifyFreshCodePageDisplayed() throws Throwable {
        hotkeyAction.verifyFreshCodePageDisplayed();
    }

    @When("I verify Stock Information page is displayed")
    public void iVerifyStockInformationPageDisplayed() throws Throwable {
        hotkeyAction.verifyStockinformationPageDisplayed();
    }
    @When("I click on hotkeys option")
    public void iClickOnHotkeys() throws Throwable {
        Thread.sleep(3000);
        hotkeyAction.clickOnHotkeys();
    }

    @When("I verify Markdowns page is displayed")
    public void iVerifyMarkdownsPageDisplayed() throws Throwable {
        hotkeyAction.verifyMarkdownsPageDisplayed();
    }

}
