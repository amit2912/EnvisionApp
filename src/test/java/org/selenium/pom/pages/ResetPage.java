package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.Objects.LoginInfo;
import org.selenium.pom.base.BasePage;

public class ResetPage extends BasePage
{
    private final By accountId=By.cssSelector("#mat-input-3");
    private final By emailId=By.cssSelector("#mat-input-4");
    private final By submit=By.cssSelector("button[type='submit'] span[class='mat-button-wrapper']");
    private final By title=By.cssSelector(".resetPwdText.resetPwdSuccess.ng-star-inserted");
    private final By backBtn=By.cssSelector("button[type='button'] span[class='mat-button-wrapper']");
    public ResetPage(WebDriver driver)
    {
        super(driver);
    }
    public void enterAccountId(String text)
    {
        driver.findElement(accountId).sendKeys(text);
    }
    public void enterEmailId(String txt)
    {
        driver.findElement(emailId).sendKeys(txt);
    }
    public void clickSubmit()
    {
        driver.findElement(submit).click();
    }
   public String getTitle()
   {
     return driver.findElement(title).getText();

    }
    public LoginMainPage clickBackBtn()
    {
        driver.findElement(backBtn).click();
        return new LoginMainPage(driver);
    }


}
