package com.cemalkalin.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AddToCartTest {

    public static void main(String []args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://automationexercise.com");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 700);");

        WebElement secondProductContainer = driver.findElement(By.xpath("//div[@class='features_items']/div[3]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(secondProductContainer).perform();
        Thread.sleep(1000);

        WebElement addToCart = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[3]/div/div[1]/div[2]/div/a"));

        addToCart.click();

        Thread.sleep(2000);

        WebElement viewCard = driver.findElement(By.xpath("//*[@id='cartModal']/div/div/div[2]/p[2]/a/u"));

        viewCard.click();

        WebElement product = driver.findElement(By.xpath("//*[@id='product-2']/td[2]/h4/a"));

        if (product.isDisplayed()) {
            System.out.println("Add to Cart test PASSED ✅");
        } else {
            System.out.println("Add to Cart test FAILED ❌");
        }

        driver.quit();

    }
}
