package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class D_O_B {

    WebDriver   driver;

    @BeforeSuite
    public void Setup()

    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABRAR2105\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");

        ChromeOptions option = new ChromeOptions();
        option.addArguments("--allow-running-insecure-content--");
        option.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(option);
    }

    @BeforeTest
    public void Get_url()
    {
        driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");

        driver.manage().window().maximize();

    }
    @Test
    public void Date_of_Birth(){

        driver.findElement(By.xpath("//input[@id='dob']")).click();

        driver.findElement(By.xpath("//select[@aria-label='Select month']")).click();

        driver.findElement(By.xpath("//select[@aria-label='Select month']")).click()



    }

    @AfterTest
    public void screenshot() throws IOException {
        File sscrsht = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sscrsht,new File("C:\\Users\\ABRAR2105\\Documents\\Selenium Screenshots\\Autosuggest.jpg"));

    }
}
