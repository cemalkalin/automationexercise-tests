package com.cemalkalin.tests;

import com.cemalkalin.utils.BaseClass;
import com.cemalkalin.utils.ConfigsReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LogoutTest extends BaseClass {

    public static void main(String [] args){

        setUp();
        String mail = ConfigsReader.getProperty("username");
        String password = ConfigsReader.getProperty("password");

        WebElement signUpLoginButton = driver.findElement(By.xpath("//*[@id='header']/div/div/div/div[2]/div/ul/li[4]/a"));
        signUpLoginButton.click();

        WebElement loginEmail = driver.findElement(By.xpath("//div[@class='login-form']/form/input[@data-qa='login-email']"));
        WebElement loginPassword = driver.findElement(By.xpath("//div[@class='login-form']/form/input[@data-qa='login-password']"));
        WebElement loginButton = driver.findElement(By.xpath("//div[@class='login-form']/form/button[@data-qa='login-button']"));

        loginEmail.sendKeys(mail);
        loginPassword.sendKeys(password);
        loginButton.click();

        WebElement logout = driver.findElement(By.xpath("//*[@id='header']/div/div/div/div[2]/div/ul/li[4]/a"));

        logout.click();

        WebElement loginHeader = driver.findElement(By.xpath("//*[@id='header']"));

        Assert.assertTrue(loginHeader.isDisplayed(),"Login Header is not displayed");

        System.out.println("Logout Test PASSED ✅");

        tearDown();


    }
}
