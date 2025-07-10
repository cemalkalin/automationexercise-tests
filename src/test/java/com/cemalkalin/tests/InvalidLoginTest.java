package com.cemalkalin.tests;

import com.cemalkalin.utils.BaseClass;
import com.cemalkalin.utils.ConfigsReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class InvalidLoginTest extends BaseClass {

    public static void main(String[]args){

        /*
       1. Launch browser
       2. Navigate to url 'http://automationexercise.com'
       3. Click on 'Signup / Login' button
       4. Enter incorrect email address and password
       7. Click 'login' button
       8. Verify error 'Your email or password is incorrect!' is visible
       */

        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        setUp();

        //3. Click on 'Signup / Login' button
        WebElement signUpLoginButton = driver.findElement(By.xpath("//*[@id='header']/div/div/div/div[2]/div/ul/li[4]/a"));
        signUpLoginButton.click();

        //4. Enter incorrect email address and password
        String wrongMail = "testcemal3838@gmail.com";
        String wrongPassword = "wrongpass123";
        WebElement loginEmail = driver.findElement(By.xpath("//div[@class='login-form']/form/input[@data-qa='login-email']"));
        WebElement loginPassword = driver.findElement(By.xpath("//div[@class='login-form']/form/input[@data-qa='login-password']"));
        WebElement loginButton = driver.findElement(By.xpath("//div[@class='login-form']/form/button[@data-qa='login-button']"));

        loginEmail.sendKeys(wrongMail);
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

        tearDown();

    }
}
