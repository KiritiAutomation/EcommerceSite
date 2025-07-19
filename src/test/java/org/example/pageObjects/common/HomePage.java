package org.example.pageObjects.common;

import org.example.pageObjects.BaseObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class HomePage extends BaseObject {

    @FindBy(partialLinkText = "Signup / Login")
    public WebElement signupLoginLink;

    @FindBy(partialLinkText = "Products")
    public WebElement productsLink;

}
