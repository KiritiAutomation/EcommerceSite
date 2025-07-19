package org.example.testCases.tests;

import org.example.testCases.BaseTest;
import org.testng.annotations.Test;

public class PLPPageTest extends BaseTest {

    @Test(description = "Verify All Products and product detail page")
    public void verifyProductListPage(){
        home.get().goToHomepage();
        home.get().goToSignupLogin();
        loginSignup.get().userLogin("existingEmail", "existingPassword");
        loginSignup.get().loggedInAsShowing("signupName");
        home.get().goToProducts();
        plp.get().validateAllProductHeadingShowing();
        plp.get().validateProductsAvailable();
        plp.get().openFistProduct();

    }
}
