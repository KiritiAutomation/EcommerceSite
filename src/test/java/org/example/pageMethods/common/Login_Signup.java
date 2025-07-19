package org.example.pageMethods.common;

import org.example.pageMethods.BaseMethod;
import org.example.pageObjects.common.SignUpPage;
import org.testng.Assert;

public class Login_Signup extends BaseMethod {

    SignUpPage signUpPage = new SignUpPage();

    public void signupUser(String name, String email){
        assertIfVisible(signUpPage.signUpHeading, "Sign up heading is displaying");
        sendKeys(signUpPage.nameField, globalProperties.getProperty(name), "Name Entered");
        sendKeys(signUpPage.emailField, globalProperties.getProperty(email), "Email Entered");
        click(signUpPage.signUpButton, "Signup button clicked");
    }

    public void fillAccountInformationAndRegister(){
        assertIfVisible(signUpPage.enterAccountInfoHeading, "Account Info heading is visible");
        click(signUpPage.genderMr, "Mr. Gender is selected");
        scrollTillelement(signUpPage.passwordField);
        sendKeys(signUpPage.passwordField, globalProperties.getProperty("signuppassword"), "password is entered");
        String[] dob = globalProperties.getProperty("dateOfBirth").split("-");
        selectByValueText(signUpPage.daySelect, dob[0]);
        selectByValueText(signUpPage.monthSelect, dob[1]);
        selectByValueText(signUpPage.yearSelect, dob[2]);
        click(signUpPage.newsletterCheckBox, "Newsletter chcekbox is clicked");
        assertIfVisible(signUpPage.addressInformationHeading, "Address Information heading is visible");
        scrollTillelement(signUpPage.firstNameField);
        sendKeys(signUpPage.firstNameField, globalProperties.getProperty("signupFirstName"), "First Name is Entered");
        sendKeys(signUpPage.lastNameField, globalProperties.getProperty("signupLastName"), "Last Name is Entered");
        sendKeys(signUpPage.companyField, globalProperties.getProperty("signupCompanyName"), "Company Name is Entered");
        sendKeys(signUpPage.addressField, globalProperties.getProperty("signupAddress"), "Address is entered");
        selectByValueText(signUpPage.countryChoice, globalProperties.getProperty("signupCountry"));
        scrollTillelement(signUpPage.stateField);
        sendKeys(signUpPage.stateField, globalProperties.getProperty("signupState"), "state is entered");
        sendKeys(signUpPage.cityField,  globalProperties.getProperty("signupCity"), "City is entered");
        sendKeys(signUpPage.zipcodeField,  globalProperties.getProperty("signupZipCode"), "Zip code is entered");
        sendKeys(signUpPage.mobileNumberField, globalProperties.getProperty("signupPhone"), "Phone number is entered");
        click(signUpPage.createAccoutButton, "Create Account button is Clicked");
    }

    public void verifyAccountcreated(){
        assertIfVisible(signUpPage.accountCreatesuccesmsg, "Account Created");
        click(signUpPage.continueButton, "Continue button clicked");
    }

    public void deleteAccount(){
        click(signUpPage.deleteAccoutLink, "Delete Account link is clicked");
        assertIfVisible(signUpPage.accountDeletedmsg, "Account deleted msg is visible");
        click(signUpPage.continueButton, "Continue button is clicked");
    }

    public void userLogin(String email, String password){
        assertIfVisible(signUpPage.loginFormHeading, "SignIn form heading is displaying");
        sendKeys(signUpPage.emailFieldLogin, globalProperties.getProperty(email), "Email is entered");
        sendKeys(signUpPage.inputPassword, globalProperties.getProperty(password), "Password is entered");
        click(signUpPage.loginButton, "Log in Button is clicked");
    }

    public void loggedInAsShowing(String name){
        assertIfVisible(signUpPage.loggedInASText, "Logged in UserName is visible");
        assertAttribute(getTitle(), globalProperties.getProperty("expectedHomeTitle"));
        assertAttribute(getText(signUpPage.loggedInASText), globalProperties.getProperty(name));
    }

    public void errorMsgExistingEmail(){
        assertAttribute(signUpPage.incorrectWarningMsgSignUp.getText(), globalProperties.getProperty("expectedSignUperrormsg"));
    }

    public void errorMsgIncorrectSignIn(){
        assertIfVisible(signUpPage.incorrectWarningMsg, "Incorrect error message is displaying");
        assertAttribute(signUpPage.incorrectWarningMsg.getText(), globalProperties.getProperty("expectedInvalidaccountErrormsg"));
    }


}
