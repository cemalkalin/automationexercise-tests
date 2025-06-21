package com.cemalkalin.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SubscribeNewsletterTest {

    public static void main(String[]args){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        String userEmail="testcemal38@gmail.com";

        driver.get("https://automationexercise.com");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");

        WebElement subscribeEmail = driver.findElement(By.xpath("//*[@id='susbscribe_email']"));
        subscribeEmail.sendKeys(userEmail);

        WebElement subscribeEmailButton = driver.findElement(By.xpath("//*[@id='subscribe']/i"));
        subscribeEmailButton.click();

        WebElement subscribeMessage = driver.findElement(By.xpath("//*[@id='success-subscribe']/div"));

        String currentSubscribeMessage = subscribeMessage.getText();
        String expectedSubscribeMessage = "You have been successfully subscribed!";

        System.out.println("Expected Message is " + expectedSubscribeMessage);
        System.out.println("Actual Title is " + currentSubscribeMessage);

        Assert.assertEquals(currentSubscribeMessage, expectedSubscribeMessage,"Messages are not match. Test is failed");

        System.out.println("Messages are match. Test is passed");

        driver.quit();

    }
}
