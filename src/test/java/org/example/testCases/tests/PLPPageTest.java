package org.example.testCases.tests;

import org.example.testCases.BaseTest;
import org.example.utils.Settings;
import org.testng.annotations.Test;

public class PLPPageTest extends BaseTest {

    @Test(description = "Verify All Products and product detail page")
    public void verifyProductListPage(){
        home.get().goToHomepage();
        assertAttribute(home.get().getTitle(), Settings.getGlobalProperty("expectedHomeTitle"));
        home.get().goToSignupLogin();
        assertIfVisible(loginSignup.get().getLoginHeading(), "Log in heading");
        loginSignup.get().userLogin("existingEmail", "existingPassword");
        assertAttribute(loginSignup.get().getLoggedInAs(), Settings.getGlobalProperty("signupName"));
        home.get().goToProducts();
        assertIfVisible(plp.get().getAllProductsHeading(), "All products heading");
        assertTrueBoolean(plp.get().areProductsAvailable(), "Products are available");
        plp.get().clickViewCartOnProduct(1);
        assertIfVisible(pdp.get().getProductName(), "Product Name");
        assertTrueBoolean(pdp.get().productHasCategory(), "Product has Category");
        assertTrueBoolean(pdp.get().productHasBrand(), "Product has Brand");
        assertTrueBoolean(pdp.get().productHasCondition(), "Product has Condition");
        softAssert.assertAll();
    }

    @Test(description = "Verify Search Product")
    public void verifySearchProduct(){
        home.get().goToHomepage();
        assertAttribute(home.get().getTitle(), Settings.getGlobalProperty("expectedHomeTitle"));
        home.get().goToSignupLogin();
        assertIfVisible(loginSignup.get().getLoginHeading(), "Log in heading");
        loginSignup.get().userLogin("existingEmail", "existingPassword");
        assertAttribute(loginSignup.get().getLoggedInAs(), Settings.getGlobalProperty("signupName"));
        home.get().goToProducts();
        assertIfVisible(plp.get().getAllProductsHeading(), "All products heading");
        assertTrueBoolean(plp.get().areProductsAvailable(), "Products are available");
        plp.get().searchProduct("searchProduct");
        assertIfVisible(plp.get().getSearchedProductsHeading(), "Searched product heading");
        assertTrueBoolean(plp.get().resultContainsSearcheditems(), "Search result contains searched item");
        softAssert.assertAll();

    }
}
