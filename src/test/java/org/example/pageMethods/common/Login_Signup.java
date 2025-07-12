package org.example.pageMethods.common;

import org.example.pageMethods.BaseMethod;
import org.example.pageObjects.common.SignUpPage;

public class Login_Signup extends BaseMethod {

    SignUpPage signUpPage = new SignUpPage();

    public void fillDetailsSignup(String name, String email){
        waitTillElementVisible(signUpPage.signUpHeading);
        signUpPage.nameField.sendKeys(name);
        signUpPage.emailField.sendKeys(email);
        signUpPage.signUpButton.click();
    }

    public void fillAccountInformationAndRegister(){
        waitTillElementVisible(signUpPage.enterAccountInfoHeading);
        signUpPage.genderMr.click();
        scrollTillelement(signUpPage.passwordField);
        signUpPage.passwordField.sendKeys("Krishna");
        selectByValueText(signUpPage.daySelect, "5");
        selectByValueText(signUpPage.yearSelect, "2000");
        signUpPage.newsletterCheckBox.click();
        waitTillElementVisible(signUpPage.addressInformationHeading);
        scrollTillelement(signUpPage.firstNameField);
        signUpPage.firstNameField.sendKeys("Abir");
        signUpPage.lastNameField.sendKeys("Mahato");
        signUpPage.companyField.sendKeys("TFC");
        signUpPage.addressField.sendKeys("Kolkata");
        signUpPage.addressField.sendKeys("Kolkata");
        selectByValueText(signUpPage.countryChoice, "India");
        scrollTillelement(signUpPage.stateField);
        signUpPage.stateField.sendKeys("Kolkata");
        signUpPage.cityField.sendKeys("Kokata");
        signUpPage.zipcodeField.sendKeys("204384");
        signUpPage.mobileNumberField.sendKeys("7395739535");
        signUpPage.createAccoutButton.click();






    }
}
