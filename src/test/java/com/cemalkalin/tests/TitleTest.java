package com.cemalkalin.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TitleTest {

    public static void main(String []args){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://automationexercise.com");
        driver.manage().window().maximize();

        String expectedTitle = "Automation Exercise";
        String actualTitle = driver.getTitle();
        System.out.println("Expected Title is " + expectedTitle);
        System.out.println("Actual Title is " + actualTitle);

        Assert.assertEquals(expectedTitle, actualTitle,"Titles are not match. Test is failed");

        System.out.println("Titles are match. Test is passed");

        driver.quit();






    }
}
