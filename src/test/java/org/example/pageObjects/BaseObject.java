package org.example.pageObjects;

import org.example.pageMethods.BaseMethod;
import org.example.testCases.BaseTest;
import org.example.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class BaseObject {

    protected WebDriver driver;

    public BaseObject(){
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }
}
