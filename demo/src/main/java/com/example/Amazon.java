package com.example;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.firefox.GeckoDriverService;

import org.openqa.selenium.support.ui.Select;

public class Amazon {

    /**
     * @param args
     */
    public static void main(String[] args) {
  
        WebDriver driver;
        
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABRAR2105\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        
        //chrome driver object
        driver=new ChromeDriver();
        
        driver.get("https://www.amazon.sa");
        
        //maximizing the URL
        driver.manage().window().maximize();

        driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
        
        //finding email element by "id" locator and entering email
        driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("aymnsh1@gmail.com");

        driver.findElement(By.id("continue")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        
        //finding pass element by "id" locator and entering password
        driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("selenium@1234");
        
        //finding "Login" element by "id" locator and performing click action
        driver.findElement(By.id("signInSubmit")).click();
        
        WebElement searchbox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        searchbox.sendKeys("Philips 5400 Series 1500W Fully Automatic 12 Cup Espresso Maker Ep5447/90, 2 Years Warranty Uae Version");

        searchbox.sendKeys(Keys.ENTER);
        
        driver.findElement(By.linkText("Philips 5400 Series 1500W Fully Automatic 12 Cup Espresso Maker Ep5447/90, 2 Years Warranty Uae Version")).click();

        driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();

        driver.findElement(By.linkText("Today's Deals")).click();

        driver.findElement(By.xpath("//a[@value='Computers & Accessories']")).click();

        WebElement searchboxx = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        searchboxx.sendKeys("Zotac Gaming Geforce Rtx 3080 Ti Amp Holo 12Gb Gddr6X 384-Bit 19 Gbps Pcie 4.0 Gaming Graphics Card, Holoblack, Icestorm 2.0 Advanced Cooling, Spectra 2.0 Rgb Lighting, Zt-A30810F-10P");

        searchboxx.sendKeys(Keys.ENTER);

        driver.findElement(By.linkText("Zotac Gaming Geforce Rtx 3080 Ti Amp Holo 12Gb Gddr6X 384-Bit 19 Gbps Pcie 4.0 Gaming Graphics Card, Holoblack, Icestorm 2.0 Advanced Cooling, Spectra 2.0 Rgb Lighting, Zt-A30810F-10P")).click();

        driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();

        driver.findElement(By.cssSelector("#nav-cart-count-container"));

        driver.findElement(By.name("proceedToRetailCheckout")).click();
        

        
        //driver.quit();

    }    
    
}
