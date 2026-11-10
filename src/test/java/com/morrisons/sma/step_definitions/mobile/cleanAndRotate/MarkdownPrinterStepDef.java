package com.morrisons.sma.step_definitions.mobile.cleanAndRotate;

import com.morrisons.sma.page_objects.mobile.cleanAndRotate.MarkdownPrinterPage;
import io.cucumber.java.en.Then;

public class MarkdownPrinterStepDef {


    MarkdownPrinterPage markdownPrinterPage = new MarkdownPrinterPage();

    @Then("I Enter Printer Barcode number {string}")
    public void enterPrinterBarcode(String barcodeNumber) throws Throwable {
        markdownPrinterPage.enterPrinterBarcode();
    }

    @Then("I click On ADD To Queue button")
    public void clickOnAddToQueue() throws Throwable {
        markdownPrinterPage.clickOnAddToQueue();
    }

    @Then("I Click on Print button on Product details page")
    public void clickOnPrintButton() throws Throwable {
        markdownPrinterPage.clickOnPrintButton();
    }

    @Then("I verify Product details on Print List page")
    public void verifyProducDetails() throws Throwable {
        markdownPrinterPage.verifyProducDetails();
    }
}
