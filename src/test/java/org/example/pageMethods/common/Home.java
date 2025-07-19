package org.example.pageMethods.common;

import org.example.pageMethods.BaseMethod;
import org.example.pageObjects.common.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class Home extends BaseMethod {

    HomePage homePage = new HomePage();

    public void goToHomepage(){
        openUrl();
        assertAttribute(getTitle(), globalProperties.getProperty("expectedHomeTitle"));
    }

    public void goToSignupLogin(){

        click(homePage.signupLoginLink, "Signup/Login hyperlink clicked");
    }

    public void goToProducts(){
        click(homePage.productsLink, "Product hyperlink is clicked");
    }







}
