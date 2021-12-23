package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class LoginMainPage extends BasePage
{
    private final By resetPage=By.xpath("//a[normalize-space()='Reset Password']");


    public LoginMainPage(WebDriver driver)
    {
        super(driver);
    }
    public ResetPage clickRestPage()
    {
      driver.findElement(resetPage).click();
      return new ResetPage(driver);
    }
    public LoginMainPage load()
    {
        load("/");
        return this;
    }
}
