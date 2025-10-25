package org.example.testCases;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.example.pageObjects.BasePage;
import org.example.pageObjects.common.*;
import org.example.utils.DriverFactory;
import org.example.utils.Reporter;
import org.example.utils.Settings;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.*;

public class BaseTest {


    protected ThreadLocal<HomePage> home = new ThreadLocal<>();
    protected ThreadLocal<SignUpPage> loginSignup = new ThreadLocal<>();
    protected ThreadLocal<PLPPage> plp = new ThreadLocal<>();
    protected ThreadLocal<PdpPage> pdp = new ThreadLocal<>();
    protected ThreadLocal<CartPage> cart = new ThreadLocal<>();
    protected ThreadLocal<CheckoutPage> checkout = new ThreadLocal<>();
    protected ThreadLocal<PaymentPage> payment = new ThreadLocal<>();

    protected SoftAssert softAssert;


    @BeforeMethod(alwaysRun = true)
    public void setUp(Method currentMethod) throws IOException {
        // Initialize WebDriver
        initializeWebDriver();

        // Setting Extent Report
        ExtentTest extentTest = Reporter.extentReport.createTest(currentMethod.getAnnotation(Test.class).description());
        Reporter.reportLogger.set(extentTest);
        Reporter.reportLogger.get().log(Status.INFO, "Current Thread Name "+Thread.currentThread().getName());

        // Initialize page objects
        initializePageObjects();

        // Initialize Soft Assertion
        softAssert = new SoftAssert();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(ITestResult result){

        // Cleanup page objects
        cleanupPageObjects();

        // Saving extent Report
        Reporter.extentReport.flush();

        // Quit driver
        DriverFactory.quitDriver();
    }


    private void initializeWebDriver() {
        try {
            DriverFactory.getDriver().manage().window().maximize();
            DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        } catch (Exception e) {
            System.err.println("Error initializing driver: " + e.getMessage());
            throw e;
        }
    }

    private void initializePageObjects() {
        try {
            home.set(new HomePage());
            loginSignup.set(new SignUpPage());
            plp.set(new PLPPage());
            pdp.set(new PdpPage());
            cart.set(new CartPage());
            checkout.set(new CheckoutPage());
            payment.set(new PaymentPage());
        } catch (Exception e) {
            System.err.println("Error initializing page objects: " + e.getMessage());
            throw e;
        }
    }

    private void cleanupPageObjects() {
        try {
            home.remove();
            loginSignup.remove();
            plp.remove();
            pdp.remove();
            cart.remove();
            checkout.remove();
            payment.remove();

        } catch (Exception e) {
            System.err.println("Error cleaning up page objects: " + e.getMessage());
        }
    }

    protected void assertAttribute(String actual, String expected){
        try {
            Assert.assertEquals(actual, expected);
            Reporter.log(Status.PASS, "Expected value= " + expected + ", Actual value= " + actual);
        }
        catch (Throwable e){
            Reporter.logFailed("Expected value= " + expected + ", Actual value= " + actual);
            Assert.fail("Expected value= " + expected + ", Actual value= " + actual);
        }
    }

    protected void softAssertIfVisible(WebElement element, String msg){
        try {
//            waitTillElementVisible(element);
            softAssert.assertTrue(element.isDisplayed());
            Reporter.log(Status.PASS, msg+" is Displaying");
        }
        catch (Exception e){
            Reporter.logFailed(msg+" is not Displaying");
            softAssert.fail();
            throw e;
        }
    }

    protected void assertTrueBoolean(boolean bool, String value){
        try{
            Assert.assertTrue(bool);
            Reporter.log(Status.PASS, value);
        }

        catch (Throwable e){
            Reporter.logFailed("Error while "+ value);
            throw e;
        }
    }

    protected void assertIfVisible(WebElement element, String msg){
        try {
//            waitTillElementVisible(element);
            Assert.assertTrue(element.isDisplayed());
            Reporter.log(Status.PASS, msg+" is Displaying");
        }
        catch (Exception e){
            Reporter.logFailed(msg+" is not Displaying");
            Assert.fail();
            throw e;
        }
    }

    protected void softassertAttribute(String actual, String expected){
        if(actual.equals(expected)) {
            Reporter.log(Status.PASS, "Expected value= " + expected + ", Actual value= " + actual);
        }
        else{
            Reporter.logFailed("Expected value= " + expected + ", Actual value= " + actual);
            softAssert.fail("Expected value= " + expected + ", Actual value= " + actual);
        }
        softAssert.assertEquals(actual, expected);
    }


    protected void assertAttributeList(List<String> actual, List<String> expected){
        try {
            Assert.assertEquals(actual, expected);
            Reporter.log(Status.PASS, "Expected value= " + expected + ", Actual value= " + actual);
        }
        catch (Throwable e){
            Reporter.logFailed("Expected value= " + expected + ", Actual value= " + actual);
            Assert.fail("Expected value= " + expected + ", Actual value= " + actual);
        }
    }

    protected Map<String,HashMap<String, String>> getJosonDataToHashMap(String path) throws IOException {
        // convert the json into string
        String data = FileUtils.readFileToString(new File(path), StandardCharsets.UTF_8);

        // convert string to Hashmap
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,HashMap<String, String>> final_data = objectMapper.readValue(data, new TypeReference<Map<String, HashMap<String, String>>>() {
        });

        return final_data;

    }

}
