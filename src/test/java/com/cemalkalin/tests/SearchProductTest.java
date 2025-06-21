package com.cemalkalin.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SearchProductTest {

    public static void main(String[]args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.get("https://automationexercise.com");

        WebElement productsMenu = driver.findElement(By.xpath("//a[@href='/products']"));
        productsMenu.click();

        Thread.sleep(2000);

        WebElement searchBox = driver.findElement(By.xpath("//*[@id='search_product']"));
        searchBox.sendKeys("Tshirt");
        WebElement searchButton = driver.findElement(By.xpath("//*[@id='submit_search']"));
        searchButton.click();

        Thread.sleep(2000);

        WebElement resultText = driver.findElement(By.xpath("//h2[contains(text(),'Searched Products')]"));

        Assert.assertTrue(resultText.isDisplayed(), "Search result section is not displayed!");

        System.out.println("Search Product Test PASSED ✅");

        driver.quit();

    }
}
