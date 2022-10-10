package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Dropdownsorting {
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

    @BeforeClass
    public void Get_url()
    {
        driver.get("https://www.twoplugs.com/");

        driver.manage().window().maximize();
    }

    @Test
    public void get_list(){

        driver.findElement(By.xpath("//a[@href='/newsearchserviceneed']")).click();

        WebElement searchbox = driver.findElement(By.xpath("//input[@id='autocomplete']"));

        searchbox.sendKeys("Toronto OH");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        List<WebElement> pugilist = driver.findElements(By.xpath("//div[@class='pac-item']"));

        for (WebElement e : pugilist) {

            System.out.println(e.getText());
        }


    }
}
