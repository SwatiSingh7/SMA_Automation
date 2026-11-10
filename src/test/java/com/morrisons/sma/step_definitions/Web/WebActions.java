package com.morrisons.sma.step_definitions.Web;

import com.morrisons.common.helper.WebApplicationHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;

import java.util.List;

import static com.morrisons.common.helper.WebApplicationHelper.driver;

public class WebActions {
    @BeforeClass
    public void WebActions() {
        WebApplicationHelper oo = new WebApplicationHelper();
        WebDriver driver = WebApplicationHelper.driver;
    }
    @Given("I launch the Browser and navigate to the application")
    public void iLaunchTheBrowserAndNavigateToTheApplication() {
        WebApplicationHelper oo = new WebApplicationHelper();
        driver.manage().window().maximize();
        //driver.manage().deleteAllCookies();
        driver.get("https://www.tesco.com/groceries/");
    }

    @And("I click on Groceries Fresh Food")
    public void iClickOnGroceries() throws InterruptedException {
        //WebDriver driver = WebApplicationHelper.driver;

        //driver.findElement(By.xpath("//li/a[contains(.,'Groceries')]")).click();
        List<WebElement> oELe = driver.findElements(By.xpath("//span[contains(.,'Fresh Food')]"));
        oELe.get(0).click();
    }

    @And("I click on Fresh Fruit - Bananas")
    public void iClickOnFreshFruitBananas() throws InterruptedException {
        Thread.sleep(3000);
        List<WebElement> oELe = driver.findElements(By.xpath("//span[contains(.,'Fresh Food')]"));
        List<WebElement> oEle1 = oELe.get(0).findElements(By.xpath("//span[contains(.,'Fresh Fruit')]"));
        oEle1.get(0).click();
        Thread.sleep(3000);
        WebElement oEle3 = driver.findElement(By.xpath("//ul[contains(.,'Fresh Food')]//span[contains(.,'Bananas')]"));
        oEle3.click();
    }

    @And("I select an item Tesco Organic Fair Trade Bananas {int} Pack")
    public void iSelectAnItemTescoOrganicFairTradeBananasPack(int arg0) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElements(By.xpath("//div[@class = 'product-details--wrapper']//a[contains(.,'Tesco Organic Fair Trade Bananas 5 Pack')]")).get(0).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[contains(.,'Add')]")).click();
    }
}
