package org.selenium.pom.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.constants.DriverType;
import org.selenium.pom.factory.DriverManager;
import org.selenium.pom.factory.DriverManagerFactory;
import org.selenium.pom.factory.DriverManagerOriginal;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class BaseTest
{
    private ThreadLocal <WebDriver> driver=new ThreadLocal<>();
    private void setDriver(WebDriver driver)
    {
        this.driver.set(driver);
    }
    protected WebDriver getDriver()
    {
        return this.driver.get();
    }
    @Parameters("browser")
    @BeforeMethod
    public void  startDriver(@Optional String browser)
    {
       browser=System.getProperty("browser",browser);
       // browser="CHROME";
     //setDriver(new DriverManagerOriginal().initializeDriver(browser));
        setDriver(DriverManagerFactory.getManager(DriverType.valueOf(browser)).createDriver());
     System.out.println("Current Thread"+Thread.currentThread().getId()+","+"Driver="+getDriver());
    }
    @Parameters("browser")
   @AfterMethod
   public void quitDriver(@Optional String browser,ITestResult result) throws IOException {
       System.out.println("Current Thread"+Thread.currentThread().getId()+","+"Driver="+getDriver());
       if(result.getStatus()==ITestResult.FAILURE)
       {
          File destFile=new File("src"+File.separator+browser+File.separator+result.getTestClass().getRealClass().
                  getSimpleName()+" "+result.getMethod().getMethodName()+".png");
        //  takeScreenShot(destFile);
           takeScreenshotUsingAshot(destFile);
       }
   getDriver().quit();
   }
   private void takeScreenShot(File destFile) throws IOException {
       TakesScreenshot takesScreenshot= (TakesScreenshot) getDriver();
       File srcFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
       FileUtils.copyFile(srcFile,destFile);

   }
   private void takeScreenshotUsingAshot(File destFile)
   {
       Screenshot screenshot= new AShot()
               .shootingStrategy(ShootingStrategies.viewportPasting(100))
               .takeScreenshot(getDriver());
       try
       {
           ImageIO.write(screenshot.getImage(),"PNG",destFile);

       }catch (Exception e)
       {
            e.printStackTrace();
       }
   }
}
