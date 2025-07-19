package org.example.pageMethods;

import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.Level;
import org.example.pageObjects.BaseObject;
import org.example.testCases.BaseTest;
import org.example.utils.DriverFactory;
import org.example.utils.Reporter;
import org.example.utils.Settings;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;

public class BaseMethod extends BaseObject {

    public WebDriverWait wait;
    public Properties scriptConfigs = new Properties();
    public Properties globalProperties = Settings.getInstanceGlobal();
    public WebDriver driver;
    public JavascriptExecutor js;


    public BaseMethod(){
        this.driver = DriverFactory.getDriver();
        try{
            this.scriptConfigs.load(Files.newInputStream(Paths.get(System.getProperty("user.dir") + "//src//test//resources//scriptConfig.properties")));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(scriptConfigs.getProperty("time"))));
        this.js = (JavascriptExecutor) driver;
    }

    protected void logInfoToHtml(String msg){
        Reporter.reportLogger.get().log(Status.INFO, msg);
    }

    protected void logPassToHtml(String msg){
        Reporter.reportLogger.get().log(Status.PASS, msg);
    }

    protected void logFailToHtml(String msg){
        Reporter.reportLogger.get().log(Status.FAIL, msg);
    }

    protected void logToConsole(String msg){
        Reporter.consoleLogger.log(Level.INFO, msg);
    }


    protected void click(WebElement element, String msg){
        try {
            waitTillElementVisible(element);
            element.click();
            logInfoToHtml(msg);
            logToConsole(msg);
        }
        catch (Exception e){
            logFailToHtml("Error while performing "+msg);
            logToConsole("Error while performing "+msg);
        }

    }

    protected void assertIfVisible(WebElement element, String msg){
        try {
            waitTillElementVisible(element);
            element.isDisplayed();
            logPassToHtml(msg);
            logToConsole(msg);
        }
        catch (Exception e){
            logFailToHtml("Error while "+msg);
            logToConsole("Error while "+msg);
        }
    }

    protected void sendKeys(WebElement element, String value, String msg){
        try {
            waitTillElementVisible(element);
            element.sendKeys(value);
            logInfoToHtml(msg);
            logToConsole(msg);
        }
        catch (Exception e){
            logFailToHtml("Error while "+msg);
            logToConsole("Error while "+msg);
        }
    }

    protected void assertAttribute(String actual, String expected){
        try {
            Assert.assertEquals(actual, expected);
            logPassToHtml("Expected value= " + expected + ", Actual value= " + actual);
            logToConsole("Expected value= " + expected + ", Actual value= " + actual);
        }
        catch (Exception e){
            logFailToHtml("Expected value= " + expected + ", Actual value= " + actual);
            logToConsole("Expected value= " + expected + ", Actual value= " + actual);
        }
    }

    protected String getText(WebElement element){
        try {
            waitTillElementVisible(element);
            String value = element.getText();
            logInfoToHtml(value);
            logToConsole(value);
            return value;
        }
        catch (Exception e){
            logFailToHtml("Error while fetching the text");
            logToConsole("Error while fetching the text");
        }
        return null;
    }


    protected String getTitle(){
        String value = driver.getTitle();
        logInfoToHtml("Site title is "+value);
        logToConsole("Site title is "+value);
        return value;
    }




    protected void openUrl(){
        driver.get("https://www.automationexercise.com/");
        logInfoToHtml("Site is opened");
        logToConsole("Site is opened");
    }

    protected void waitTillElementVisible(WebElement webElement){
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }


    protected void scrollTillelement(WebElement webElement){
        js.executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    protected void selectByValueText(WebElement element, String value){
        Select select = new Select(element);
        select.selectByValue(value);
        logInfoToHtml("Selected value " +value);
        logToConsole("Selected value " +value);

    }

}
