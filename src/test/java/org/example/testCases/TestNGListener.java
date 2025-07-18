package org.example.testCases;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.utils.Reporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class TestNGListener implements ITestListener {

    static Logger log;

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest extentTest = Reporter.extentReport.createTest(result.getMethod().getDescription());
        Reporter.reportLogger.set(extentTest);
        Reporter.reportLogger.get().log(Status.INFO, "Current Thread Name "+Thread.currentThread().getName());

    }


    @Override
    public void onTestSuccess(ITestResult result) {
//        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
//        ITestListener.super.onTestFailure(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onFinish(ITestContext context) {
//        ITestListener.super.onFinish(context);
        Reporter.extentReport.flush();
        }

}
