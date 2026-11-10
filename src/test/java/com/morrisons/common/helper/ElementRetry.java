package com.morrisons.common.helper;

import com.morrisons.common.PageFactory.InitClass;
import com.morrisons.common.action.ApplicationLaunch;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.morrisons.common.helper.CommonHelperMethods.clickDynamicObject;
import static java.util.concurrent.TimeUnit.SECONDS;

public class ElementRetry {
    private static WebDriverWait wait;
    private static final Logger log = Logger.getLogger(ApplicationLaunch.class);


    public static void clickElement(AndroidDriver dr, WebElement element) throws InterruptedException {
        int j = 0;
        while (j < 5) {
            log.info("Retrying element to click : " + (j + 1));
            try {
                if (element == null) {
                    log.info("Element is null");
                    break;
                }
                element.isDisplayed();
                element.click();
                //wait.until(ExpectedConditions.visibilityOf(element)).click();
                break;
            } catch (Exception e) {
                ++j;
                if (j > 4) {
                    log.info("Element is clicked with javascript : " + " number : " + j);
                    clickDynamicObject(dr, element);
                }
            }
        }

    }
    static int ctr;
    public static void clickElement7(AndroidDriver dr, WebElement element) throws InterruptedException {
        while(ctr<10) {
            Thread.sleep(1000);
            try {
                ctr++;
                if(element.isEnabled()) {
                    element.click();
                }
            } catch (StaleElementReferenceException se) {
                if(ctr>=0){
                    clickDynamicObject(dr, element);
                }
                clickElement7(dr, element);
            }
        }
    }

    public static void clickElementFromListWithText(AndroidDriver dr, String webElementListXpath, String findElementByText) throws InterruptedException {
        log.info("Finding all Elements with Xpath : " + webElementListXpath);
        Thread.sleep(3000);
        List<WebElement> listOfElement = dr.findElements(By.xpath(webElementListXpath));
        for (WebElement eachElement :
				listOfElement) {
            log.info("Each element text : " + eachElement.getText());
            log.info("Find element text : " + findElementByText);
            if (eachElement.getText().equalsIgnoreCase(findElementByText)) {
                try {
                    eachElement.click();
                }
                catch(StaleElementReferenceException se) {
                    clickElement(dr, eachElement);
                }
                break;
            }
        }
    }

    public static void enterText(WebElement element, String textValue) {
        int j = 0;
        while (j < 5) {
            log.info("Searching Element : " + (j + 1));
            try {
                element.clear();
                element.sendKeys(textValue);
                break;
            } catch (Exception e) {
                ++j;
                if (j > 4) {
                    log.info("Element cannot be found to enter text : " + " Retry Count :  " + j);
                    log.error(e);
                }
            }
        }
    }

    public static void waitForElementVisible(AndroidDriver dr, WebElement element) throws InterruptedException {
        int j = 0;
        if (element == null) {
            log.info("Element is null");
        }
        //=========================
        Wait<AndroidDriver> wait = new FluentWait<AndroidDriver>(dr)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(driver -> {
            return element;
        });
        //==============================
        System.out.println("Entered into Sync func" + element.isEnabled());
        if(!element.isEnabled()) {
            while (!element.isEnabled()) {
                Thread.sleep(1000);
                if(j>10){
                    break;
                }
                j++;
            }
        }
    }

    public static String getText(WebDriver dr, WebElement element) {
        int j = 0;
        String text = null;
        while (j < 3) {
            log.info("Finding Element : " + (j + 1));
            try {
                text = element.getText();
                break;
            } catch (Exception var1) {
                hardSleep(1000);
                ++j;
                if (j > 2) {
                    log.info("Error finding the element : " + j);
                }
            }
        }
        return text;
    }


    public static void SelectDropdownByText(WebDriver dr, WebElement element, String value) {

        int j = 0;
        while (j < 3) {
            try {
                log.info("Selecting Text : " + value + " :: Select Count : " + (j + 1));
                Select selElement = new Select(element);
                selElement.selectByVisibleText(value);
                break;
            } catch (Exception var1) {
                hardSleep(1000);
                ++j;
            }
        }

    }

    public static void SelectDropdownByIndex(WebDriver dr, WebElement element, int value) {

        int j = 0;
        while (j < 3) {
            try {
                log.info("Selecting Value : " + value + " :: Select Count : " + (j + 1));
                Select selElement = new Select(element);
                selElement.selectByIndex(value);
                break;
            } catch (Exception var1) {
                hardSleep(1000);
                ++j;
            }
        }

    }

    public static boolean checkElementExist(WebElement ele) {
        boolean res = false;
        try {
            if (ele == null) {
                throw new NoSuchElementException("No element found");
            } else if (ele.isDisplayed()) {
                res = true;
            }
        } catch (NoSuchElementException e) {
            res = false;
        }
        return res;
    }

    public static void scrollTo(WebDriver dr, WebElement element) {
        ((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView();", element);
    }


    public static void javaScriptClickElement(WebDriver dr, WebElement element) {
        JavascriptExecutor j = ((JavascriptExecutor) dr);
        ((JavascriptExecutor) dr).executeScript("arguments[0].click();", element);
    }

    public static void hardSleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean waitForElementWithPageRefresh(WebDriver dr, WebElement element) {
        int n = 0;
        boolean isClickFailed = false;
        boolean visible = false;
        log.info("Refreshing Page...");
        dr.navigate().refresh();
        //waitForElementVisible(dr, element);
        for (int i = 0; i < 5; i++) {
            try {
                log.info("Waiting for element to be clikable " + element.toString());
                if (!isClickFailed) {
                    //wait.until(ExpectedConditions.visibilityOf(element));
                }
                log.info("Retry " + i);
                visible = true;
                break;
            } catch (Exception e) {
                log.info("Refreshing Page...");
                dr.navigate().refresh();
                dr.manage().timeouts().pageLoadTimeout(30, SECONDS);
                isClickFailed = true;
                n = n + 2;
                log.info("Waiting for element to be clikable");
            }
        }
        log.info("total time taken by element to clikable is-" + n + "Sec");
        return visible;
    }

/*    public static void verifyIfDisplayed(WebDriver dr, WebElement webElement, String expectedValue) {
        String actual = getText(dr, webElement);
        log.info("Actual Value : " + actual);
        log.info("Expected Value : " + expectedValue);
        Assert.assertEquals(actual, expectedValue);
    }*/

	/*
	public static void clickElementNavigatesToDifferentPage(WebDriver dr, WebElement element)
	{
		int n = 0;
		boolean isClickFailed = false;
		String currentUrl = dr.getCurrentUrl();
		for (int i = 0; i < 5; i++)
		{
			try
			{
				if (!isClickFailed)
				{
					//wait.until(ExpectedConditions.elementToBeClickable(element)).click();
				} else
				{
					javaScriptClickElement(dr, element);
				}
				if (dr.getCurrentUrl().equalsIgnoreCase(currentUrl))
				{
					log.info("Current url after click : " + dr.getCurrentUrl() + " Current url before click :"
							+ currentUrl);
					throw new Exception();
				}
				log.info("Number of time waiting for the element to be clickable  "
						+ i + " Number");
				break;
			} catch (Exception e)
			{
				isClickFailed = true;
				n = n + i;
				log.info("Waiting for element to be clickable");
			} finally
			{
				n = n + i;

			}

		}
		log.info("total time taken by element to clikable is-" + n + "times");
	}*/


/*
	public static void waitForElementVisible(WebDriver dr, String xpath)
	{
		Boolean f = true;
		for (int i = 0; i < 5; i++)
		{
			try
			{
				log.info("Retrying " + i + "Wait for element to display " + xpath);
				f = dr.findElement(By.xpath(xpath)).isDisplayed();
				if (!f)
				{
					hardSleep(1000);
					// dr.navigate().refresh();
				} else
				{
					break;
				}
			} catch (Exception e)
			{
				hardSleep(1000);
				// dr.navigate().refresh();
			}
		}
		// log.info("Time waiting for the element " + xpath + " Number " + i);
	}*/


/*
	public static void clickElement(WebDriver dr, String xpath)
	{
		try
		{
			//wait.until(ExpectedConditions.elementToBeClickable(dr.findElement(By.xpath(xpath)))).click();

			// dr.findElement(By.xpath(xpath)).click();
		} catch (Exception e)
		{
			hardSleep(1000);
			//wait.until(ExpectedConditions.elementToBeClickable(dr.findElement(By.xpath(xpath)))).click();

		}

	}*/

/*
	public void waitForElementVisible(String xpath, int time)
	{
		Boolean f = false;
		for (int i = 0; i < time; i++)
		{
			try
			{
				f = dr.findElement(By.xpath(xpath)).isDisplayed();
				if (!f)
				{

					f = dr.findElement(By.xpath(xpath)).isDisplayed();
					if (!f)
					{
						hardSleep(1000);
					} else
					{
						break;
					}

				}
			} catch (Exception e)
			{
				hardSleep(1000);
			}
		}

	}*/


/*
	public static void type(WebDriver dr, String xpath, String txt)
	{

		if (isElementVisible(dr, xpath))
		{
			dr.findElement(By.xpath(xpath)).sendKeys(txt);
		}

	}*/

/*
	public static String getText(WebDriver dr, String xpath)
	{
		String strVal = "";
		if (xpath.contains("Service Delivery Status") || xpath.contains("Service delivery status"))
		{
			waitForElementVisible(dr, xpath);
		}
		if (isElementVisible(dr, xpath))
		{
			strVal = dr.findElement(By.xpath(xpath)).getText();
		}
		log.info("Extracted text value for " + xpath + " is " + strVal);
		return strVal;
	}*/

/*
	public void clickWebElement(WebElement element)
	{
		try
		{
			element.click();

			// dr.findElement(By.xpath(xpath)).click();
		} catch (Exception e)
		{
			hardSleep(1000);
			javaScriptClickElement(element);

		}

	}*/

/*
	public static void takeScreenShot(WebDriver dr, String methodName, String filepath)
	{
		// get the driver
		// dr=classname.getDriver();
		File scrFile = ((TakesScreenshot) dr).getScreenshotAs(OutputType.FILE);
		// The below method will save the screen shot in d drive with test
		// method name
		try
		{
			FileUtils.copyFile(scrFile, new File(filepath + methodName + ".png"));
			System.out.println("***Placed screen shot in " + filepath + " ***");
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}*/

/*
	public static void awaitResponse(ThrowingRunnable assertion)
	{
		await().atMost(30, SECONDS).pollInterval(1, SECONDS).pollInSameThread().untilAsserted(assertion);
	} // by Asir

	// Asir commment after format
	public List<WebElement> formatCSS(WebDriver dr, String css)
	{
		List<WebElement> element = null;
		int j = 0;

		while (j < 3)
		{
			try
			{
				log.info("Finding Element : " + element + " :: Search Count : " + (j + 1));
				element = dr.findElements(By.cssSelector(css));
				break;
			} catch (Exception var5)
			{
				// AwaitUtil.hardSleep(1000); //by Asir
				++j;
				if (j > 2)
				{
					Assert.fail("Error finding the element : " + var5);
				}
			}
		}

		return dr.findElements(By.cssSelector(css));
	}*/

/*
	public List<WebElement> formatXpath(WebDriver dr, String xpath)
	{
		List<WebElement> element = null;
		int j = 0;

		while (j < 3)
		{
			try
			{
				log.info("Finding Element : " + element + " :: Search Count : " + (j + 1));
				element = dr.findElements(By.xpath(xpath));
				break;
			} catch (Exception var5)
			{
				// AwaitUtil.hardSleep(1000); //by Asir
				++j;
				if (j > 2)
				{
					Assert.fail("Error finding the element : " + var5);
				}
			}
		}

		return dr.findElements(By.xpath(xpath));
	}*/

/*
	public static String clear(WebDriver dr, String xpath)
	{
		String strVal = "";
		waitForElementVisible(dr, xpath);
		if (isElementVisible(dr, xpath))
		{
			dr.findElement(By.xpath(xpath)).clear();
		}
		return strVal;
	}*/

/*
	public void filterAndSelectBusinessArea(WebDriver webdriver, String xpath, String listXpath, String filtervalue)
	{
		try
		{
			webdriver.findElement(By.xpath(xpath)).click();
			waitForElementVisible(webdriver, listXpath);
			List<WebElement> filterDwnstatisticValues = webdriver.findElement(By.xpath(listXpath))
					.findElements(By.tagName("li"));
			;
			for (WebElement element : filterDwnstatisticValues)
			{
				if (element.getText().equalsIgnoreCase(filtervalue))
				{
					element.click();
					break;
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}*/


    public static void verifyElement(WebDriver dr, WebElement element) {

        log.info("Verifying element is visible");
        try {
            if (element == null) {
                log.info("Element is null");
            }
            element.isDisplayed();
            //wait.until(ExpectedConditions.visibilityOf(element)).click();
        } catch (Exception e) {
            log.info("Element is not visible : " + e.getMessage());
        }
    }
}