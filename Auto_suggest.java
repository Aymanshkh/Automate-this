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
import java.time.Duration;
import java.util.List;

public class Auto_suggest {

    WebDriver driver;

    @BeforeSuite
    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABRAR2105\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");

        ChromeOptions option = new ChromeOptions();
        option.addArguments("--allow-running-insecure-content--");
        option.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(option);
    }

    @BeforeTest
    public void Get_url() {
        driver.get("https://www.google.com/webhp?hl=en");

        driver.manage().window().maximize();

    }

    @Test
    public void Auto_sggst() {

        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("java tutorial");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        List<WebElement> serchlist = driver.findElements(By.xpath("//ul[@role='listbox']/li"));

        for (WebElement m : serchlist) {

            System.out.println(m.getText());

        }
        for (WebElement m : serchlist) {

            if (m.getText().trim().contains("w3schools")) {
                m.click();
                break;
            }
        }
    }
    @AfterTest
    public void screenshot() throws IOException {
        File sscrsht = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sscrsht,new File("C:\\Users\\ABRAR2105\\Documents\\Selenium Screenshots\\Autosuggest.jpg"));

    }
}


