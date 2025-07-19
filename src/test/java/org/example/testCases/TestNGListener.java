package org.example.testCases;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.utils.Reporter;
import org.example.utils.Settings;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.util.Properties;

public class TestNGListener implements ITestListener {

    protected Properties globalProperties;

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest extentTest = Reporter.extentReport.createTest(result.getMethod().getDescription());
        Reporter.reportLogger.set(extentTest);
        Reporter.reportLogger.get().log(Status.INFO, "Current Thread Name "+Thread.currentThread().getName());
        globalProperties = Settings.getInstanceGlobal();

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
