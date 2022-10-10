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
import java.util.List;

public class Bootstrap {

    WebDriver driver;

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
        driver.get("https://www.hdfcbank.com/");

        driver.manage().window().maximize();

    }

    @Test   (priority = 0)
    public void Dynamic_dd(){

        driver.findElement(By.xpath("//a[contains(text(), 'Select Product Type')]")).click();

        List<WebElement> products = driver.findElements(By.xpath("//ul[@class = 'dropdown1 dropdown-menu']"));

        for (WebElement e : products) {

            System.out.println(e.getText());
        }

        driver.findElement(By.xpath("//ul[@class = 'dropdown1 dropdown-menu']//li[@value ='2']")).click();

        driver.findElement(By.xpath("//div[@class ='drp2']")).click();

        List<WebElement> Accnt = driver.findElements(By.xpath("//ul[@class='dropdown2 dropdown-menu']"));

        for (WebElement g : Accnt) {

            System.out.println(g.getText());
        }

        driver.findElement(By.xpath("//ul[@class='dropdown2 dropdown-menu']//li[@value='1']")).click();
    }

    @AfterTest
    public void screenshot() throws IOException {
        File sscrsht = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sscrsht,new File("C:\\Users\\ABRAR2105\\Documents\\Selenium Screenshots\\Autosuggest.jpg"));

    }





    }


