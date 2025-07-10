package com.cemalkalin.tests;

import com.cemalkalin.utils.BaseClass;
import com.cemalkalin.utils.ConfigsReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterUser extends BaseClass {

    public static void main(String[]args) throws InterruptedException {

    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Click on 'Signup / Login' button
    4. Enter name and email address and Click on 'Signup' button
    5. Fill details:
    Title, Name, Email, Password, Date of birth
    First name, Last name, Company, Address, Address2,
    Country, State, City, Zipcode, Mobile Number
    6. Click 'Create Account button'
    7. Verify that 'ACCOUNT CREATED!' is visible
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

        //4. Enter name and email address and Click on 'Signup' button
        WebElement newUserName = driver.findElement(By.xpath("//*[@id='form']/div/div/div[3]/div/form/input[2]"));
        WebElement newUserEmail = driver.findElement(By.xpath("//*[@id='form']/div/div/div[3]/div/form/input[3]"));
        WebElement newUserButton = driver.findElement(By.xpath("//*[@id='form']/div/div/div[3]/div/form/button"));
        newUserName.sendKeys(name);
        newUserEmail.sendKeys(mail);
        newUserButton.click();

        //5. Fill details:
        //Title, Name, Email, Password, Date of birth
        //First name, Last name, Company, Address, Address2,
        //Country, State, City, Zipcode, Mobile Number
        WebElement maleRB = driver.findElement(By.xpath("//*[@id='id_gender1']"));
        WebElement femaleRB = driver.findElement(By.xpath("//*[@id='id_gender2']"));
        WebElement userName=driver.findElement(By.xpath("//*[@id='name']"));
        WebElement password=driver.findElement(By.xpath("//*[@id='password']"));

        WebElement firstName=driver.findElement(By.id("first_name"));
        WebElement lastName=driver.findElement(By.id("last_name"));
        WebElement company=driver.findElement(By.id("company"));
        WebElement address1=driver.findElement(By.id("address1"));
        WebElement address2=driver.findElement(By.id("address2"));
        WebElement country=driver.findElement(By.id("country"));
        WebElement state=driver.findElement(By.id("state"));
        WebElement city=driver.findElement(By.id("city"));
        WebElement zipcode=driver.findElement(By.id("zipcode"));
        WebElement mobileNumber=driver.findElement(By.id("mobile_number"));
        WebElement days=driver.findElement(By.id("days"));
        WebElement months=driver.findElement(By.id("months"));
        WebElement years=driver.findElement(By.id("years"));
        WebElement createNewAccount = driver.findElement(By.xpath("//*[@id='form']/div/div/div/div[1]/form/button"));

        femaleRB.click();
        password.sendKeys(newPassword);

        Select selDays = new Select(days);
        Select selMonths = new Select(months);
        Select selYears = new Select(years);
        Select SelCountry = new Select(country);

        //1st way to select
        selDays.selectByIndex(2);

        //2nd way to select
        selMonths.selectByValue("11");

        //3rd way to select
        selYears.selectByVisibleText("1984");

        firstName.sendKeys("Cemal");
        lastName.sendKeys("Tester");
        company.sendKeys("Tester LLC");
        address1.sendKeys("123 Abc Blvd");
        address2.sendKeys("Apt 1234");

        SelCountry.selectByVisibleText("United States");

        state.sendKeys("Florida");
        city.sendKeys("Orlando");
        zipcode.sendKeys("32765");
        mobileNumber.sendKeys("+1 222 333 44 55");

        //6. Click 'Create Account button'
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
        Thread.sleep(2000);
        createNewAccount.click();

        //7. Verify that 'ACCOUNT CREATED!' is visible
        WebElement message = driver.findElement(By.xpath("//*[@id='form']/div/div/div/h2/b"));
        String expectedMessage = "ACCOUNT CREATED!";
        String actualMessage = message.getText();

        if (actualMessage.equals(expectedMessage)) {
            System.out.println("Test is passed");
            System.out.println("Actual Title: " + actualMessage);
        } else {
            System.out.println("Test is failed");
            System.out.println("Actual Title: " + actualMessage);
        }

        tearDown();
    }
}
