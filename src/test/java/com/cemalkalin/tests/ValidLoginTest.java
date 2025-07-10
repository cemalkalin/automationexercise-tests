package com.cemalkalin.tests;

import com.cemalkalin.utils.BaseClass;
import com.cemalkalin.utils.ConfigsReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ValidLoginTest extends BaseClass {

    public static void main(String[]args){

        /*
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Click on 'Signup / Login' button
        4. Enter correct email address and password
        5. Click 'login' button
        6. Verify that 'Logged in as username' is visible

         */

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        setUp();

        //3. Click on 'Signup / Login' button
        WebElement signUpLoginButton = driver.findElement(By.xpath("//*[@id='header']/div/div/div/div[2]/div/ul/li[4]/a"));
        signUpLoginButton.click();

        String mail = ConfigsReader.getProperty("username");
        String name = "Cemal";
        String password = ConfigsReader.getProperty("password");
        WebElement loginEmail = driver.findElement(By.xpath("//div[@class='login-form']/form/input[@data-qa='login-email']"));
        WebElement loginPassword = driver.findElement(By.xpath("//div[@class='login-form']/form/input[@data-qa='login-password']"));
        WebElement loginButton = driver.findElement(By.xpath("//div[@class='login-form']/form/button[@data-qa='login-button']"));

        //4. Enter correct email address and password
        loginEmail.sendKeys(mail);
        loginPassword.sendKeys(password);

        //5. Click 'login' button
        loginButton.click();

        //6. Verify that 'Logged in as username' is visible
        WebElement userName = driver.findElement(By.xpath("//*[@id='header']/div/div/div/div[2]/div/ul/li[10]/a"));

        String actualUserName = userName.getText();
        String expectedUserName = "Logged in as Cemal";

        if(expectedUserName.equals(actualUserName)){
            System.out.println("Login error test PASSED");
            System.out.println(actualUserName+"-->"+expectedUserName);
        }else{
            System.out.println("Login error test FAILED");
            System.out.println(actualUserName+"-->"+expectedUserName);
        }

        tearDown();
    }

}
