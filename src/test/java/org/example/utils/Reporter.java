package org.example.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Reporter {


    public static ThreadLocal<ExtentTest> reportLogger = new ThreadLocal<>();
    public static final Logger consoleLogger = Reporter.getConsoleLogger();
    public static final ExtentReports extentReport = Reporter.getReportLogger();


    public synchronized static ExtentReports getReportLogger(){

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

    public synchronized static Logger getConsoleLogger(){
        Logger logger = LogManager.getLogger("console");
        return logger;
    }
}
