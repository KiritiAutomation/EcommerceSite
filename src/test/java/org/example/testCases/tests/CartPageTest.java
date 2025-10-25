package org.example.testCases.tests;

import org.example.testCases.BaseTest;
import org.example.utils.Settings;
import org.testng.annotations.Test;

public class CartPageTest extends BaseTest {

    @Test(description = "Add products in cart and verify the products", groups = {"Regression", "Smoke", "Sanity"})
    public void addProductsAndVerifyInCart() throws InterruptedException {
        home.get().goToHomepage();
        assertAttribute(home.get().getTitle(), Settings.getGlobalProperty("expectedHomeTitle"));
        home.get().goToSignupLogin();
        assertIfVisible(loginSignup.get().getLoginHeading(), "Log in heading");
        loginSignup.get().userLogin("existingEmailCart", "existingPassword");
        assertAttribute(loginSignup.get().getLoggedInAs(), Settings.getGlobalProperty("signupName"));
        home.get().goToProducts();
        assertIfVisible(plp.get().getAllProductsHeading(), "All products heading");
        assertTrueBoolean(plp.get().areProductsAvailable(), "Products are available");
        plp.get().addToCartProductNumber(1);
        plp.get().addToCartProductNumber(4);
        plp.get().goToCart();
        assertIfVisible(cart.get().getShoppingCart(), "Cart page");
        assertAttributeList(cart.get().getActualProductNames(), cart.get().getExpectedProductNames());
        assertAttributeList(cart.get().getActualProductPrices(), cart.get().getExpectedProductPrices());
        softAssert.assertAll();

    }

    @Test(description = "Verify Product quantity in Cart", groups = {"Regression", "Smoke", "Sanity"})
    public void validateProductQuantityInCart(){
        home.get().goToHomepage();
        assertAttribute(home.get().getTitle(), Settings.getGlobalProperty("expectedHomeTitle"));
        home.get().goToSignupLogin();
        assertIfVisible(loginSignup.get().getLoginHeading(), "Log in heading");
        loginSignup.get().userLogin("existingEmail1", "existingPassword");
        assertAttribute(loginSignup.get().getLoggedInAs(), Settings.getGlobalProperty("signupName1"));
        home.get().goToProducts();
        assertIfVisible(plp.get().getAllProductsHeading(), "All products heading");
        assertTrueBoolean(plp.get().areProductsAvailable(), "Products are available");
        plp.get().clickViewCartOnProduct(3);
        assertIfVisible(pdp.get().getProductName(), "Product Name");
        assertIfVisible(pdp.get().getProductName(), "Product Name");
        assertTrueBoolean(pdp.get().productHasCategory(), "Product has Category");
        assertTrueBoolean(pdp.get().productHasBrand(), "Product has Brand");
        assertTrueBoolean(pdp.get().productHasCondition(), "Product has Condition");
        pdp.get().increaseQuantityTo(4);
        pdp.get().clickAddToCart();
        plp.get().goToCart();
        assertAttribute(cart.get().getActualCartQuantity(), cart.get().getExpectedCartQuantity());
        cart.get().clearCart();
        softAssert.assertAll();


    }

}
