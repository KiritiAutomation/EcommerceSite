package org.example.pageMethods.common;

import org.example.pageMethods.BaseMethod;
import org.example.pageObjects.common.SignUpPage;
import org.testng.Assert;

public class Login_Signup extends BaseMethod {

    SignUpPage signUpPage = new SignUpPage();

    public void fillDetailsSignup(){
        waitTillElementVisible(signUpPage.signUpHeading);
        signUpPage.nameField.sendKeys(globalProperties.getProperty("signupName"));
        signUpPage.emailField.sendKeys(globalProperties.getProperty("signupEmail"));
        signUpPage.signUpButton.click();
    }

    public void fillAccountInformationAndRegister(){
        waitTillElementVisible(signUpPage.enterAccountInfoHeading);
        signUpPage.genderMr.click();
        scrollTillelement(signUpPage.passwordField);
        signUpPage.passwordField.sendKeys(globalProperties.getProperty("signuppassword"));
        String[] dob = globalProperties.getProperty("dateOfBirth").split("-");
        selectByValueText(signUpPage.daySelect, dob[0]);
        selectByValueText(signUpPage.monthSelect, dob[1]);
        selectByValueText(signUpPage.yearSelect, dob[2]);
        signUpPage.newsletterCheckBox.click();
        waitTillElementVisible(signUpPage.addressInformationHeading);
        scrollTillelement(signUpPage.firstNameField);
        signUpPage.firstNameField.sendKeys(globalProperties.getProperty("signupFirstName"));
        signUpPage.lastNameField.sendKeys(globalProperties.getProperty("signupLastName"));
        signUpPage.companyField.sendKeys(globalProperties.getProperty("signupCompanyName"));
        signUpPage.addressField.sendKeys(globalProperties.getProperty("signupAddress"));
        selectByValueText(signUpPage.countryChoice, globalProperties.getProperty("signupCountry"));
        scrollTillelement(signUpPage.stateField);
        signUpPage.stateField.sendKeys(globalProperties.getProperty("signupState"));
        signUpPage.cityField.sendKeys(globalProperties.getProperty("signupCity"));
        signUpPage.zipcodeField.sendKeys(globalProperties.getProperty("signupZipCode"));
        signUpPage.mobileNumberField.sendKeys(globalProperties.getProperty("signupPhone"));
        signUpPage.createAccoutButton.click();
    }

    public void verifyAccountcreated(){
        waitTillElementVisible(signUpPage.accountCreatesuccesmsg);
        System.out.println(signUpPage.accountCreatesuccesmsg.getText());
        signUpPage.continueButton.click();
        waitTillElementVisible(signUpPage.loggedInASText);
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, globalProperties.getProperty("expectedHomeTitle"));
        Assert.assertEquals(signUpPage.loggedInASText.getText(), globalProperties.getProperty("signupName"));
    }

    public void deleteAccount(){
        signUpPage.deleteAccoutLink.click();
        waitTillElementVisible(signUpPage.accountDeletedmsg);
        System.out.println(signUpPage.accountDeletedmsg.getText());
        signUpPage.continueButton.click();
    }

    public void errorMsgIncorrectLogin(){
        waitTillElementVisible(signUpPage.loginFormHeading);
        signUpPage.emailFieldLogin.sendKeys(globalProperties.getProperty("incorrectEmail"));
        signUpPage.inputPassword.sendKeys(globalProperties.getProperty("incorrectPassword"));
        signUpPage.loginButton.click();
        waitTillElementVisible(signUpPage.incorrectWarningMsg);
        Assert.assertEquals(signUpPage.incorrectWarningMsg.getText(), globalProperties.getProperty("expectedInvalidaccountErrormsg"));

    }
}
