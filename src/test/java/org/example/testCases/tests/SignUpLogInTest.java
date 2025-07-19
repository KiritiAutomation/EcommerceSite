package org.example.testCases.tests;

import org.example.testCases.BaseTest;
import org.testng.annotations.Test;

public class SignUpLogInTest extends BaseTest {

    @Test(description = "Register User and delete account")
    public void validateRegistrationAndDeletion(){
        home.get().goToHomepage();
        home.get().goToSignupLogin();
        loginSignup.get().signupUser("signupName", "signupEmail");
        loginSignup.get().fillAccountInformationAndRegister();
        loginSignup.get().verifyAccountcreated();
        loginSignup.get().loggedInAsShowing("signupName");
        loginSignup.get().deleteAccount();
    }

    @Test(description = "Login User with incorrect email and password")
    public void validateIncorrectLogIn(){
        home.get().goToHomepage();
        home.get().goToSignupLogin();
        loginSignup.get().userLogin("incorrectEmail", "incorrectPassword");
        loginSignup.get().errorMsgIncorrectSignIn();

    }

    @Test(description = "Register user with existing email")
    public void validateRegisteruserWithExistingEmail(){
        home.get().goToHomepage();
        home.get().goToSignupLogin();
        loginSignup.get().signupUser("validName", "existingEmail");
        loginSignup.get().errorMsgExistingEmail();


    }



}
