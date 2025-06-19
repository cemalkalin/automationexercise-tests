package com.cemalkalin.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountTest {

    public static void main(String[]args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().deleteAllCookies();
        driver.navigate().to("https://automationexercise.com");
        driver.manage().window().maximize();

        String mail = "testcemal38@gmail.com";
        String name = "Cemal";
        String newPassword = "12345678";

        WebElement signUpLoginButton = driver.findElement(By.xpath("//*[@id='header']/div/div/div/div[2]/div/ul/li[4]/a"));
        signUpLoginButton.click();

        WebElement newUserName = driver.findElement(By.xpath("//*[@id='form']/div/div/div[3]/div/form/input[2]"));
        WebElement newUserEmail = driver.findElement(By.xpath("//*[@id='form']/div/div/div[3]/div/form/input[3]"));
        WebElement newUserButton = driver.findElement(By.xpath("//*[@id='form']/div/div/div[3]/div/form/button"));

        newUserName.sendKeys(name);
        newUserEmail.sendKeys(mail);
        newUserButton.click();

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

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
        Thread.sleep(2000);
        createNewAccount.click();

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

        driver.quit();
    }
}
