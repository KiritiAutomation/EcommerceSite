package org.example.pageMethods.common;

import org.example.pageMethods.BaseMethod;
import org.example.pageObjects.common.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class Home extends BaseMethod {

    HomePage homePage = new HomePage();

    public void goToHomepage(){
        String expectedTitle = "Automation Exercise";
        openUrl();
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    public void goToSignupLogin(){
        homePage.signupLoginLink.click();
    }







}
