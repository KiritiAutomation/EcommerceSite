package org.example.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();



    public static WebDriver getDriver(){
        if(driver.get() == null){
            initilizeDriver();
        }
        return driver.get();
    }


    public static void quitDriver(){
        if(driver.get()!=null){
            driver.get().quit();
            driver.remove();
        }
    }

    private static void initilizeDriver(){
        Properties prop = new Properties();
            try {
                FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//browser.properties");
                prop.load(fis);
            }
            catch (Exception e){
                e.printStackTrace();
            }

        String browserName = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");




        if (browserName.equalsIgnoreCase("chrome")) {
            driver.set(new ChromeDriver());
        } else if (browserName.equalsIgnoreCase("Edge")) {
            driver.set(new EdgeDriver());
        }

        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
}
