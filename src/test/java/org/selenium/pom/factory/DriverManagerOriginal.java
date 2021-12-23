package org.selenium.pom.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.selenium.pom.constants.DriverType;

import java.time.Duration;

public class DriverManagerOriginal
{
    public WebDriver initializeDriver(String browser)
    {
        WebDriver driver;


       //  browser=System.getProperty("browser",browser);

        switch (DriverType.valueOf(browser))
        {
            case CHROME:
                    {
                        WebDriverManager.chromedriver().cachePath("Drivers").setup();
                        driver=new ChromeDriver();
                        break;
                    }
            case FIREFOX:
                            {
                                WebDriverManager.firefoxdriver().cachePath("Driver").setup();
                                driver=new FirefoxDriver();
                                break;
                            }
            default:
                throw new IllegalArgumentException("Invalid browser name"+browser);
        }


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
}
