package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Multi_frames {

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
        driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");

        driver.manage().window().maximize();

    }
    @Test
    public void Multiiple_frames(){

        driver.switchTo().frame("packageListFrame");

        driver.switchTo().defaultContent();

        driver.switchTo().frame("packageFrame");

        driver.switchTo().defaultContent();

        driver.switchTo().frame("classFrame");

        driver.findElement(By.xpath("//a[contains(text(),'org.openqa.selenium.bidi')][1]")).click();

    }

    @AfterTest
    public void screenshot() throws IOException {
        File sscrsht = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sscrsht,new File("C:\\Users\\ABRAR2105\\Documents\\Selenium Screenshots\\Autosuggest.jpg"));

    }


}
