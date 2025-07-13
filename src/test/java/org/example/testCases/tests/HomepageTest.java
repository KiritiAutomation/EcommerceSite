package org.example.testCases.tests;

import org.example.testCases.BaseTest;
import org.testng.annotations.Test;

public class HomepageTest extends BaseTest {

    @Test(description = "Register User and delete account")
    public void validateRegistrationAndDeletion(){
        home.goToHomepage();
        home.goToSignupLogin();
        loginSignup.fillDetailsSignup("Abir", "testeattrbir@gmail.com");
        loginSignup.fillAccountInformationAndRegister();
        loginSignup.verifyAccountcreated();
        loginSignup.deleteAccount();
    }


}
