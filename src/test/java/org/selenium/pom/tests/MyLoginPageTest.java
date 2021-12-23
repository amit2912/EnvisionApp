package org.selenium.pom.tests;

import org.openqa.selenium.By;
import org.selenium.pom.Objects.LoginInfo;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.LoginMainPage;
import org.selenium.pom.pages.LoginPage;
import org.selenium.pom.pages.ResetPage;
import org.selenium.pom.utilis.JacksonUtilis;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.selenium.pom.utilis.JacksonUtilis.deserializeJson;

public class MyLoginPageTest extends BaseTest {
    @Test(description = "Should be reset the passsword")
    public void Reset() throws InterruptedException {
       // driver.get("https://java11.enact-systems.com/login");
        LoginMainPage page=new LoginMainPage(getDriver()).load();
        LoginInfo info=new LoginInfo();
       // info.setAccountID("AMITIND");
       // info.setEmailID("amit34@enact-systems.com");
       ResetPage reset= page.clickRestPage();
      reset.enterAccountId("AMITIND");
       reset.enterEmailId("amit34@enact-systems.com");
       reset.clickSubmit();
       Thread.sleep(4000);
     Assert.assertEquals(reset.getTitle(),"A link to reset your password has been emailed to the address you provided.");

    LoginMainPage Page= reset.clickBackBtn();
    Thread.sleep(10000);
   // main.enterAccId("AMITUSA19");
    //    Thread.sleep(10000);
   //main.enterMailId("amit@enact-systems.com");
    //    Thread.sleep(10000);
   // main.enterPassCode("B0XEQIM");
    //    Thread.sleep(10000);
   // main.clickBtn();


        //driver.findElement(By.cssSelector("button[class='mat-focus-indicator marginleft10 uppercase mat-raised-button mat-button-base mat-primary'] span[class='mat-button-wrapper']")).click();


    }

    @Test(description = "should be able to login")
    public void Login() throws IOException {

        InputStream is =getClass().getClassLoader().getResourceAsStream("My LoginInfo.json");
      LoginInfo info= deserializeJson("My LoginInfo.json",LoginInfo.class);

       LoginPage main=new LoginPage(getDriver()).load();

     //   LoginInfo info=new LoginInfo("AMITUSA19","amit@enact-systems.com","B0XEQIM");
      //  main.setLoginInfo(info).
        //        clickBtn();
      // LoginInfo info=new LoginInfo().setAccID("AMITUSA19").
      // setMailID("amit@enact-systems.com").
      // setPassID("B0XEQIM");

       //Thread.sleep(5000);
       // main.enterAccId("AMITUSA19");


       // main.enterMailId("amit@enact-systems.com");

       // main.enterPassCode("B0XEQIM");




    }
}
