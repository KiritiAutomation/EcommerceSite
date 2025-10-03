package org.example.testCases.tests;

import org.example.testCases.BaseTest;
import org.example.utils.Settings;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignUpLogInTest extends BaseTest {

    @Test(description = "Register User and delete account")
    public void validateRegistrationAndDeletion(){
        home.get().goToHomepage();
        assertAttribute(home.get().getTitle(), Settings.getGlobalProperty("expectedHomeTitle"));
        home.get().goToSignupLogin();
        //Hard assertion
        assertIfVisible(loginSignup.get().getSignUpHeading(), "Sign up heading");

        //Soft Assertion
        softassertAttribute(loginSignup.get().getNamePlaceholderTxt(), Settings.getGlobalProperty("nameFieldPlaceholder"));
        softassertAttribute(loginSignup.get().getEmailPlaceholderTxt(), Settings.getGlobalProperty("emailFieldPlaceholder"));
        loginSignup.get().signupUser("signupName", "signupEmail");
        assertIfVisible(loginSignup.get().getAcccountInfoHeading(), "Account Info heading");
        loginSignup.get().fillAccountInformationAndRegister();
        assertAttribute(loginSignup.get().getAccountCreatedMsg(), Settings.getGlobalProperty("accountCreatedmsg"));
        loginSignup.get().clickContinue();
        assertAttribute(loginSignup.get().getLoggedInAs(), Settings.getGlobalProperty("signupName"));
        loginSignup.get().deleteAccount();
        assertAttribute(loginSignup.get().getAccountDeleteMsg(), Settings.getGlobalProperty("accountDeletedMsg"));
        loginSignup.get().clickContinue();
        softAssert.assertAll();
    }

    @Test(description = "Login User with incorrect email and password")
    public void validateIncorrectLogIn(){
        home.get().goToHomepage();
        assertAttribute(home.get().getTitle(), Settings.getGlobalProperty("expectedHomeTitle"));
        home.get().goToSignupLogin();
        assertIfVisible(loginSignup.get().getLoginHeading(), "Log in heading");
        loginSignup.get().userLogin("incorrectEmail", "incorrectPassword");
        assertAttribute(loginSignup.get().getIncorrectSignInMsg(), Settings.getGlobalProperty("incorrectSignInMsg"));
        softAssert.assertAll();

    }

    @Test(description = "Register user with existing email")
    public void validateRegisteruserWithExistingEmail(){
        home.get().goToHomepage();
        assertAttribute(home.get().getTitle(), Settings.getGlobalProperty("expectedHomeTitle"));
        home.get().goToSignupLogin();

        assertIfVisible(loginSignup.get().getSignUpHeading(), "Sign up heading");

        //Soft Assertion
        softassertAttribute(loginSignup.get().getNamePlaceholderTxt(), Settings.getGlobalProperty("nameFieldPlaceholder"));
        softassertAttribute(loginSignup.get().getEmailPlaceholderTxt(), Settings.getGlobalProperty("emailFieldPlaceholder"));
        loginSignup.get().signupUser("validName", "existingEmail");
        assertAttribute(loginSignup.get().geterrorMsgExistingEmail(), Settings.getGlobalProperty("alreadyExistingSignUpMsg"));
        softAssert.assertAll();

    }


}
