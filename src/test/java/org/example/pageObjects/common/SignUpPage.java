package org.example.pageObjects.common;

import org.example.pageObjects.BaseObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BaseObject {

    @FindBy(xpath = "//h2[contains(text(), 'New User')]")
    public WebElement signUpHeading;

    @FindBy(name = "name")
    public WebElement nameField;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    public WebElement emailField;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    public WebElement signUpButton;

    @FindBy(xpath = "//h2/b[contains(text(), 'Enter Account')]")
    public WebElement enterAccountInfoHeading;

    @FindBy(id="uniform-id_gender1")
    public WebElement genderMr;

    @FindBy(id="password")
    public WebElement passwordField;

    @FindBy(id="days")
    public WebElement daySelect;

    @FindBy(id="months")
    public WebElement monthSelect;

    @FindBy(id="years")
    public WebElement yearSelect;

    @FindBy(id="newsletter")
    public WebElement newsletterCheckBox;

    @FindBy(xpath = "//h2/b[contains(text(), 'Address')]")
    public WebElement addressInformationHeading;

    @FindBy(id="first_name")
    public WebElement firstNameField;

    @FindBy(id="last_name")
    public WebElement lastNameField;

    @FindBy(id="company")
    public WebElement companyField;

    @FindBy(id="address1")
    public WebElement addressField;

    @FindBy(id="country")
    public WebElement countryChoice;

    @FindBy(id="state")
    public WebElement stateField;

    @FindBy(id="city")
    public WebElement cityField;

    @FindBy(id="zipcode")
    public WebElement zipcodeField;

    @FindBy(id="mobile_number")
    public WebElement mobileNumberField;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    public WebElement createAccoutButton;

    @FindBy(xpath = "//h2[@data-qa='account-created']/b")
    public WebElement accountCreatesuccesmsg;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    public WebElement continueButton;

    @FindBy(css = ".fa-user+b")
    public WebElement loggedInASText;

    @FindBy(partialLinkText = "Delete Account")
    public WebElement deleteAccoutLink;

    @FindBy(xpath = "//h2[@data-qa='account-deleted']/b")
    public WebElement accountDeletedmsg;
}
