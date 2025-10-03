package org.example.pageObjects.common;

import org.example.pageObjects.BasePage;
import org.example.utils.Settings;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Set;

public class SignUpPage extends BasePage {

    @FindBy(xpath = "//h2[contains(text(), 'New User')]")
    private WebElement signUpHeading;


    @FindBy(name = "name")
    private WebElement nameField;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private WebElement emailField;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    private WebElement signUpButton;

    @FindBy(xpath = "//h2/b[contains(text(), 'Enter Account')]")
    private WebElement enterAccountInfoHeading;

    @FindBy(id="uniform-id_gender1")
    private WebElement genderMr;

    @FindBy(id="password")
    private WebElement passwordField;

    @FindBy(id="days")
    private WebElement daySelect;

    @FindBy(id="months")
    private WebElement monthSelect;

    @FindBy(id="years")
    private WebElement yearSelect;

    @FindBy(id="newsletter")
    private WebElement newsletterCheckBox;

    @FindBy(xpath = "//h2/b[contains(text(), 'Address')]")
    private WebElement addressInformationHeading;

    @FindBy(id="first_name")
    private WebElement firstNameField;

    @FindBy(id="last_name")
    private WebElement lastNameField;

    @FindBy(id="company")
    private WebElement companyField;

    @FindBy(id="address1")
    private WebElement addressField;

    @FindBy(id="country")
    private WebElement countryChoice;

    @FindBy(id="state")
    private WebElement stateField;

    @FindBy(id="city")
    private WebElement cityField;

    @FindBy(id="zipcode")
    private WebElement zipcodeField;

    @FindBy(id="mobile_number")
    private WebElement mobileNumberField;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    private WebElement createAccoutButton;

    @FindBy(xpath = "//h2[@data-qa='account-created']/b")
    private WebElement accountCreatesuccesmsg;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    private WebElement continueButton;

    @FindBy(css = ".fa-user+b")
    private WebElement loggedInASText;

    @FindBy(partialLinkText = "Delete Account")
    private WebElement deleteAccoutLink;

    @FindBy(xpath = "//h2[@data-qa='account-deleted']/b")
    private WebElement accountDeletedmsg;

    @FindBy(css = ".login-form h2")
    private WebElement loginFormHeading;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    private WebElement emailFieldLogin;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//input[@data-qa='login-password']/following-sibling::p")
    private WebElement incorrectWarningMsg;

    @FindBy(xpath = "//input[@data-qa='signup-email']/following-sibling::p")
    private WebElement incorrectWarningMsgSignUp;



    public void signupUser(String name, String email){
        sendKeys(nameField, Settings.getGlobalProperty(name), "Name Entered");
        sendKeys(emailField, Settings.getGlobalProperty(email), "Email Entered");
        click(signUpButton, "Signup button clicked");
    }

    public void fillAccountInformationAndRegister(){
        click(genderMr, "Mr. Gender is selected");
        scrollTillelement(passwordField);
        sendKeys(passwordField, Settings.getGlobalProperty("signuppassword"), "password is entered");
        String[] dob = Settings.getGlobalProperty("dateOfBirth").split("-");
        selectByValueText(daySelect, dob[0]);
        selectByValueText(monthSelect, dob[1]);
        selectByValueText(yearSelect, dob[2]);
        click(newsletterCheckBox, "Newsletter chcekbox is clicked");
        assertIfVisible(addressInformationHeading, "Address Information heading is visible");
        scrollTillelement(firstNameField);
        sendKeys(firstNameField, Settings.getGlobalProperty("signupFirstName"), "First Name is Entered");
        sendKeys(lastNameField, Settings.getGlobalProperty("signupLastName"), "Last Name is Entered");
        sendKeys(companyField, Settings.getGlobalProperty("signupCompanyName"), "Company Name is Entered");
        sendKeys(addressField, Settings.getGlobalProperty("signupAddress"), "Address is entered");
        selectByValueText(countryChoice, Settings.getGlobalProperty("signupCountry"));
        scrollTillelement(stateField);
        sendKeys(stateField, Settings.getGlobalProperty("signupState"), "state is entered");
        sendKeys(cityField,  Settings.getGlobalProperty("signupCity"), "City is entered");
        sendKeys(zipcodeField,  Settings.getGlobalProperty("signupZipCode"), "Zip code is entered");
        sendKeys(mobileNumberField, Settings.getGlobalProperty("signupPhone"), "Phone number is entered");
        click(createAccoutButton, "Create Account button is Clicked");
    }

    public void clickContinue(){
        click(continueButton, "Continue button clicked");
    }

    public void deleteAccount(){
        click(deleteAccoutLink, "Delete Account link is clicked");
    }

    public void userLogin(String email, String password){
        sendKeys(emailFieldLogin, Settings.getGlobalProperty(email), "Email is entered");
        sendKeys(inputPassword, Settings.getGlobalProperty(password), "Password is entered");
        click(loginButton, "Log in Button is clicked");
    }


    public String geterrorMsgExistingEmail(){
        waitTillElementVisible(incorrectWarningMsgSignUp);
        return getText(incorrectWarningMsgSignUp);
    }

    public String getIncorrectSignInMsg(){
       waitTillElementVisible(incorrectWarningMsg);
       return getText(incorrectWarningMsg);
    }

    public WebElement getSignUpHeading(){
        return signUpHeading;
    }

    public WebElement getLoginHeading(){
        return loginFormHeading;
    }

    public String getNamePlaceholderTxt(){
        return nameField.getAttribute("placeholder");
    }

    public String getEmailPlaceholderTxt(){
        return emailField.getAttribute("placeholder");
    }

    public WebElement getAcccountInfoHeading(){
        return enterAccountInfoHeading;
    }

    public String getAccountCreatedMsg(){
        return getText(accountCreatesuccesmsg);
    }

    public String getLoggedInAs(){
        return getText(loggedInASText);
    }

    public String getAccountDeleteMsg(){
        return getText(accountDeletedmsg);
    }


}
