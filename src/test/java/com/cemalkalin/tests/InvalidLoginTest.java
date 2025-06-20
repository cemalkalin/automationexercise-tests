package com.cemalkalin.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvalidLoginTest {

    public static void main(String[]args){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://automationexercise.com");
        driver.manage().window().maximize();

        String mail = "testcemal38@gmail.com";
        String wrongPassword = "wrongpass123";
        WebElement signUpLoginButton = driver.findElement(By.xpath("//*[@id='header']/div/div/div/div[2]/div/ul/li[4]/a"));

        signUpLoginButton.click();


        WebElement loginEmail = driver.findElement(By.xpath("//div[@class='login-form']/form/input[@data-qa='login-email']"));
        WebElement loginPassword = driver.findElement(By.xpath("//div[@class='login-form']/form/input[@data-qa='login-password']"));
        WebElement loginButton = driver.findElement(By.xpath("//div[@class='login-form']/form/button[@data-qa='login-button']"));


        loginEmail.sendKeys(mail);
        loginPassword.sendKeys(wrongPassword);
        loginButton.click();
        
        WebElement invalidLoginMessage = driver.findElement(By.xpath("//*[@id='form']/div/div/div[1]/div/form/p"));


        String actualInvalidLoginMessage = invalidLoginMessage.getText();
        String expectedInvalidLoginMessage = "Your email or password is incorrect!";

        if(expectedInvalidLoginMessage.equals(actualInvalidLoginMessage)){
            System.out.println("Login error test PASSED");
            System.out.println(actualInvalidLoginMessage+"-->"+expectedInvalidLoginMessage);
        }else{
            System.out.println("Login error test FAILED");
            System.out.println(actualInvalidLoginMessage+"-->"+expectedInvalidLoginMessage);
        }

        driver.quit();

    }
}
