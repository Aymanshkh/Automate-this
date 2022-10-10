package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Tooltip {

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
        driver.get("https://jqueryui.com/tooltip/");

        driver.manage().window().maximize();

    }

    @Test
    public void tool(){

        Actions act = new Actions(driver);

        JavascriptExecutor j = (JavascriptExecutor) driver;

        j.executeScript("window.scrollBy(0,500)");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.switchTo().frame(0);

        WebElement age = driver.findElement(By.xpath("//label[contains(text(),'age')]"));

        act.moveToElement(age).perform();

        driver.findElement(By.xpath("//label[contains(text(),'age')]")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement ele = driver.findElement(By.xpath("//div[@role='tooltip']"));

        System.out.println(ele.getText());

    }
}
