package org.selenium.pom.base;

import org.openqa.selenium.WebDriver;
import org.selenium.pom.utilis.ConfigLoader;

public class BasePage
{
    public WebDriver driver;

    public BasePage(WebDriver driver)
    {

        this.driver=driver;
    }
    public void load(String endPoint)
    {
        driver.get(ConfigLoader.getInstance().getBaseUrl() +endPoint);
    }
}
