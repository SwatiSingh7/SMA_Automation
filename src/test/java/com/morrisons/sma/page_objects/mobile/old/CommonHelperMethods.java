package com.morrisons.sma.page_objects.mobile.old;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

//import static com.morrisons.common.helper.clickElement;


public class CommonHelperMethods {

    private static final Logger log = Logger.getLogger(CommonHelperMethods.class);

    public static void selectOption(WebDriver dr, WebElement optionElement, String optionString) {
        //log.info(optionElement);
        verifyIfDisplayed(dr, optionElement, optionString);
        //clickElement(dr, optionElement);
        optionElement.click();
    }

    public static void verifyIfDisplayed(WebDriver dr, WebElement element, String expectedValue) {
        log.info("Verifying if displayed : " + expectedValue);
        //String actualText = getText(dr, element);
        String actualText = element.getText();
        log.info("Actual Text : " + actualText);
        Assert.assertEquals(actualText, expectedValue);
    }

    public static void verifyIfDisplayed(WebDriver dr, By xpath, String expectedValue) {
        log.info("Xpath : " + xpath);
        String actual = dr.findElement(xpath).getText();
        log.info("Actual Value : " + actual);
        log.info("Expected Value : " + expectedValue);
        Assert.assertEquals(actual, expectedValue);
    }

}
