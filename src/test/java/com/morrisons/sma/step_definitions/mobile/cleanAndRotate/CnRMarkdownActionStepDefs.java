package com.morrisons.sma.step_definitions.mobile.cleanAndRotate;

import com.morrisons.sma.page_objects.mobile.cleanAndRotate.CnRMarkdownAction;
import io.cucumber.java.en.Then;

public class CnRMarkdownActionStepDefs {
    CnRMarkdownAction cnRMarkdownAction = new CnRMarkdownAction();

    @Then("^I Click on No Printer Available$")
    public void clickOnNoPrinterAvailable() throws Throwable {
        cnRMarkdownAction.clickOnNoPrinterAvailable();
    }

    @Then("^I Click on Add to Print Queue button$")
    public void clickOnAddToPrintQueue() throws Throwable {
        cnRMarkdownAction.clickOnAddToPrintQueue();
    }

    @Then("^I verify Product details on Summary page$")
    public void VerifyItemDetailsInSummary() throws Throwable {
        cnRMarkdownAction.VerifyItemDetailsInSummary();
    }

}
