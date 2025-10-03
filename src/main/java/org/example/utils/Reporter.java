package org.example.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Reporter {


    public static ThreadLocal<ExtentTest> reportLogger = new ThreadLocal<>();
    public static final Logger consoleLogger = Reporter.getConsoleLogger();
    public static final ExtentReports extentReport = Reporter.getReportLogger();


    private static ExtentReports getReportLogger(){

        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("src/test/ExtentReport/Spark.html");
        extentSparkReporter.config().setReportName("Ecommerce site Test");
        extentSparkReporter.config().setDocumentTitle("Automation tests");
        ExtentReports reports = new ExtentReports();
        reports.attachReporter(extentSparkReporter);
        reports.setSystemInfo("Environment", "QA");
        reports.setSystemInfo("Tester", "Kiriti");
        reports.setSystemInfo("Platform", "WEB");

        return reports;
    }

    private synchronized static Logger getConsoleLogger(){
        Logger logger = LogManager.getLogger("console");
        return logger;
    }

    public static void log(Status status, String message) {
        try {
            consoleLogger.log(Level.INFO, message);
            ExtentTest test = reportLogger.get();
            if (test != null) {
                test.log(status, message);
            }
        } catch (Exception e) {
            System.out.println("Logging error: " + e.getMessage());
        }
    }

    public static void logFailed(String message) {
        try {
            String screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BASE64);
            String imgTag = "<img src=\"data:image/png;base64," + screenshot + "\" />";
            reportLogger.get().log(Status.FAIL, message + "\n" + imgTag);
            consoleLogger.log(Level.INFO, message);
        } catch (Exception e) {
            System.out.println("Screenshot logging error: " + e.getMessage());
        }
    }

}
