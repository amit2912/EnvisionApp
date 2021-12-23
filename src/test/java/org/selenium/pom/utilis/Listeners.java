package org.selenium.pom.utilis;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.selenium.pom.base.ExtentReporterNG;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener
{
    ExtentTest test;
 ExtentReports extent=ExtentReporterNG.getReportObject();
    public void onTestSuccess(ITestResult result)
    {

         test.log(Status.PASS,"Test Pass");


    }


    public void onTestFailure(ITestResult result)
    {

         test.fail(result.getThrowable());
    }


    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub

    }


    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub

    }


    public void onStart(ITestContext context)
    {
        test=extent.createTest("Initial ");


    }


    public void onFinish(ITestContext context)
    {
       extent.flush();


    }
}
