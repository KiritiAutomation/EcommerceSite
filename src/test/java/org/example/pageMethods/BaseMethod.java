package org.example.pageMethods;

import org.example.pageObjects.BaseObject;
import org.example.testCases.BaseTest;
import org.example.utils.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    public WebDriver driver;
    public JavascriptExecutor js;

    public BaseMethod(){
        this.driver = DriverFactory.getDriver();
        try{
            this.scriptConfigs.load(Files.newInputStream(Paths.get(System.getProperty("user.dir") + "//src//test//java//org//example//resources//scriptConfig.properties")));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(scriptConfigs.getProperty("time"))));
        this.js = (JavascriptExecutor) driver;
    }


    protected void openUrl(){
        driver.get("https://www.automationexercise.com/");
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
    }

}
