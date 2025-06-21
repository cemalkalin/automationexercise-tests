package com.cemalkalin.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckProductPage {

    public static void main(String [] args){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://automationexercise.com");
        driver.manage().window().maximize();

        WebElement products = driver.findElement(By.xpath("//*[@id='header']/div/div/div/div[2]/div/ul/li[2]/a"));
        products.click();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://automationexercise.com/products";

        Assert.assertEquals(currentUrl, expectedUrl,"URLs are not match. Test is failed");

        System.out.println("Messages are match. Test is passed");

        driver.quit();

    }
}
