package com.cemalkalin.tests;

import com.cemalkalin.utils.BaseClass;
import com.cemalkalin.utils.ConfigsReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class RegisterUserExistingMail extends BaseClass {

    public static void main(String []args){

        /*
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Click on 'Signup / Login' button
        4. Enter name and already registered email address
        5. Click 'Signup' button
        6. Verify error 'Email Address already exist!' is visible
         */

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        setUp();

        String mail = ConfigsReader.getProperty("username");
        String name = "Cemal";
        String newPassword = ConfigsReader.getProperty("password");

        //3. Click on 'Signup / Login' button
        WebElement signUpLoginButton = driver.findElement(By.xpath("//*[@id='header']/div/div/div/div[2]/div/ul/li[4]/a"));
        signUpLoginButton.click();

        //4. Enter name and already registered email address
        WebElement newUserName = driver.findElement(By.xpath("//*[@id='form']/div/div/div[3]/div/form/input[2]"));
        WebElement newUserEmail = driver.findElement(By.xpath("//*[@id='form']/div/div/div[3]/div/form/input[3]"));
        WebElement newUserButton = driver.findElement(By.xpath("//*[@id='form']/div/div/div[3]/div/form/button"));
        newUserName.sendKeys(name);
        newUserEmail.sendKeys(mail);

        //5. Click 'Signup' button
        newUserButton.click();

        //6. Verify error 'Email Address already exist!' is visible
        WebElement loginMessage = driver.findElement(By.xpath("//*[@id='form']/div/div/div[3]/div/form/p"));

        String expectedMessage = "Email Address already exist!";
        String actualMessage = loginMessage.getText();

        Assert.assertEquals(expectedMessage,actualMessage,"Message are not match. Test is failed");

        System.out.println("Messages are match. Test is passed");

        tearDown();
        

    }
}
