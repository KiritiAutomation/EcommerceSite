package org.example.testCases.tests;

import org.example.testCases.BaseTest;
import org.testng.annotations.Test;

public class SignUpLogInTest extends BaseTest {

    @Test(description = "Register User and delete account")
    public void validateRegistrationAndDeletion(){
        home.get().goToHomepage();
        home.get().goToSignupLogin();
        loginSignup.get().fillDetailsSignup();
        loginSignup.get().fillAccountInformationAndRegister();
        loginSignup.get().verifyAccountcreated();
        loginSignup.get().deleteAccount();
    }

    @Test(description = "Login User with incorrect email and password")
    public void validateIncorrectLogIn(){
        home.get().goToHomepage();
        home.get().goToSignupLogin();
        loginSignup.get().errorMsgIncorrectLogin();

    }


}
