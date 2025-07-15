package org.example.testCases;

import org.example.pageMethods.BaseMethod;
import org.example.pageMethods.common.Home;
import org.example.pageMethods.common.Login_Signup;
import org.example.pageObjects.common.HomePage;
import org.example.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {


    protected ThreadLocal<Home> home = new ThreadLocal<>();
    protected ThreadLocal<Login_Signup> loginSignup = new ThreadLocal<>();

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws IOException {
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        home.set(new Home());
        loginSignup.set(new Login_Signup());
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        DriverFactory.quitDriver();
    }
}
