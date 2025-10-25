package org.example.testCases;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.example.utils.Reporter;
import org.example.utils.Settings;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Properties;

public class TestNGListener implements ITestListener {

    protected Properties globalProperties;

    @Override
    public void onTestStart(ITestResult result) {



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

        }


}
