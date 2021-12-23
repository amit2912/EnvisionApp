package org.selenium.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenium.pom.Objects.LoginInfo;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.utilis.JacksonUtilis;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class LoginPage extends BasePage
{
/*private final By accId=By.xpath("//input[@id='mat-input-0']");*/
/*private final By mailId=By.xpath("//input[@id='mat-input-1']");*/
/*private final By passCode=By.xpath("//*[@id=\"mat-input-2\"]");*/
/*private final By loginBtn= By.xpath("//button[@type='submit']");*/
    @FindBy(xpath = "//input[@id='mat-input-0']") private WebElement accId;
    @FindBy(xpath = "//input[@id='mat-input-1']") private WebElement mailId;
     @FindBy(xpath = "//*[@id=\"mat-input-2\"]") private WebElement passCode;
      @FindBy(xpath = "//button[@type='submit']") private WebElement loginBtn;


    public LoginPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    public LoginPage enterAccId(String text)
    {
        accId.sendKeys(text);
        //driver.findElement(accId).sendKeys(text);
        return this;

    }
    public LoginPage  enterMailId(String txt)
    {
        mailId.sendKeys(txt);
       // driver.findElement(mailId).sendKeys(txt);
        return this;
    }
    public LoginPage enterPassCode(String txt)
    {
        passCode.sendKeys(txt);
       // driver.findElement(passCode).sendKeys(txt);
        return this;
    }
    public LoginPage clickBtn()

    {
        loginBtn.click();
        //driver.findElement(loginBtn).click();
        return this;
    }
    public LoginPage load()
    {
        load("/");
        return this;
    }


    // @DataProvider(name="getLoginDetails")
//public Object[] getLoginDetails() throws IOException {
       //  return JacksonUtilis.deserializeJson("My LoginInfo.json",LoginInfo[].class);
   //  }

}

