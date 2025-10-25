package org.example.pageObjects;

import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.Level;
import org.example.utils.DriverFactory;
import org.example.utils.Reporter;
import org.example.utils.Settings;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

public class BasePage {

    private WebDriverWait wait;
    private JavascriptExecutor js;
    private Actions actions;

    protected WebDriver driver;

    public BasePage(){
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Settings.getScriptConfigPropertyAsInt("time")));
        this.js = (JavascriptExecutor) driver;
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);

    }


    protected void click(WebElement element, String msg){
        try {
//            waitTillElementVisible(element);
            element.click();
            Reporter.log(Status.PASS, msg);
        }
        catch (Exception e){
            Reporter.logFailed("Error while "+msg);
            throw e;
        }

    }

    protected void assertIfVisible(WebElement element, String msg){
        try {
//            waitTillElementVisible(element);
            element.isDisplayed();
            Reporter.log(Status.PASS, msg);
        }
        catch (Exception e){
            Reporter.logFailed("Error while "+msg);
            throw e;
        }
    }

    protected void sendKeys(WebElement element, String value, String msg){
        try {
//            waitTillElementVisible(element);
            element.sendKeys(value);
            Reporter.log(Status.INFO, msg);
        }
        catch (Exception e){
            Reporter.logFailed("Error while "+msg);
            throw e;
        }
    }


    protected String getText(WebElement element){
        try {
//            waitTillElementVisible(element);
            String value = element.getText();
            Reporter.log(Status.INFO, value);
            return value;
        }
        catch (Exception e) {
            Reporter.logFailed("Error while fetching the text");
        }
        return null;
    }


    protected void openUrl(){
        driver.get("https://www.automationexercise.com/");
        Reporter.log(Status.INFO, "Site is opened");
    }

    protected void waitTillElementVisible(WebElement webElement){
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }


    protected void scrollTillelement(WebElement webElement){
        try {
            js.executeScript("arguments[0].scrollIntoView(true);", webElement);
            String tagName = webElement.getAccessibleName();
            Reporter.log(Status.INFO, "Scrolled to "+tagName);
        }

        catch (Throwable e){
            Reporter.logFailed("Error while scrolling");
            throw e;
        }
    }


    protected void selectByValueText(WebElement element, String value){
        Select select = new Select(element);
        select.selectByValue(value);
        Reporter.log(Status.INFO, "Selected value " +value);

    }

    protected void actionMoveToElement(WebElement webElement) throws InterruptedException {
        actions.moveToElement(webElement).perform();
        Thread.sleep(1000);
    }

    protected void actionClick(WebElement webElement) throws InterruptedException {
        actions.click(webElement).perform();
        Thread.sleep(1000);
    }

    protected String getCallingMethodName(){
        return Thread.currentThread().getStackTrace()[3].getMethodName();
    }


}
