package com.cemalkalin.tests;

import com.cemalkalin.utils.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ContactForm extends BaseClass {

    public static void main(String [] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://automationexercise.com");
        driver.manage().window().maximize();

        WebElement contactUs = driver.findElement(By.xpath("//*[@id='header']/div/div/div/div[2]/div/ul/li[8]/a"));

        contactUs.click();

        WebElement name = driver.findElement(By.xpath("//*[@id='contact-us-form']/div[1]/input"));
        WebElement email = driver.findElement(By.xpath("//*[@id='contact-us-form']/div[2]/input"));
        WebElement subject = driver.findElement(By.xpath("//*[@id='contact-us-form']/div[3]/input"));
        WebElement message = driver.findElement(By.xpath("//*[@id='message']"));



        String userName="Cemal";
        String userEmail="testcemal38@gmail.com";
        String usersSubject = "Test message";
        String userMessage = "We are looking for bug";

        name.sendKeys(userName);
        email.sendKeys(userEmail);
        subject.sendKeys(usersSubject);
        message.sendKeys(userMessage);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 300);");
        Thread.sleep(2000);
        WebElement submitButton = driver.findElement(By.xpath("//*[@id='contact-us-form']/div[6]/input"));

        submitButton.click();

        Alert alt = driver.switchTo().alert();
        alt.accept();

        Thread.sleep(2000);

        WebElement infoMessage = driver.findElement(By.xpath("//*[@id='contact-page']/div[2]/div[1]/div/div[2]"));

        String expectedInfoMessage = "Success! Your details have been submitted successfully.";
        String actualInfoMessage = infoMessage.getText();
        System.out.println("Expected Title is " + expectedInfoMessage);
        System.out.println("Actual Title is " + actualInfoMessage);

        Assert.assertEquals(expectedInfoMessage, actualInfoMessage,"Messages are not match. Test is failed");

        System.out.println("Messages are match. Test is passed");

        driver.quit();



    }
}
