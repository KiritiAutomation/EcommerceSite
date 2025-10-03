package org.example.testCases.tests;

import org.example.testCases.BaseTest;
import org.example.utils.Settings;
import org.testng.annotations.Test;

public class PlaceOrderTest extends BaseTest {


    @Test(description = "Place Order: Register while Checkout")
    public void placeOrderRegisterwhileCheckout() throws InterruptedException {

        home.get().goToHomepage();
        assertAttribute(home.get().getTitle(), Settings.getGlobalProperty("expectedHomeTitle"));
        home.get().goToProducts();
        assertIfVisible(plp.get().getAllProductsHeading(), "All products heading");
        assertTrueBoolean(plp.get().areProductsAvailable(), "Products are available");
        plp.get().addToCartProductNumber(4);
        plp.get().addToCartProductNumber(5);
        plp.get().goToCart();
        assertIfVisible(cart.get().getShoppingCart(), "Cart page");
        assertAttributeList(cart.get().getActualProductNames(), cart.get().getExpectedProductNames());
        assertAttributeList(cart.get().getActualProductPrices(), cart.get().getExpectedProductPrices());
        cart.get().clickProceedToCheckout();
        cart.get().clickRegisterLogin();
        assertIfVisible(loginSignup.get().getSignUpHeading(), "Sign up heading");
        //Soft Assertion
        softassertAttribute(loginSignup.get().getNamePlaceholderTxt(), Settings.getGlobalProperty("nameFieldPlaceholder"));
        softassertAttribute(loginSignup.get().getEmailPlaceholderTxt(), Settings.getGlobalProperty("emailFieldPlaceholder"));
        loginSignup.get().signupUser("signupName2", "signupEmail1");
        assertIfVisible(loginSignup.get().getAcccountInfoHeading(), "Account Info heading");
        loginSignup.get().fillAccountInformationAndRegister();
        assertAttribute(loginSignup.get().getAccountCreatedMsg(), Settings.getGlobalProperty("accountCreatedmsg"));
        loginSignup.get().clickContinue();
        assertAttribute(loginSignup.get().getLoggedInAs(), Settings.getGlobalProperty("signupName2"));
        plp.get().goToCart();
        assertIfVisible(cart.get().getShoppingCart(), "Cart page");
        assertAttributeList(cart.get().getActualProductNames(), cart.get().getExpectedProductNames());
        assertAttributeList(cart.get().getActualProductPrices(), cart.get().getExpectedProductPrices());
        cart.get().clickProceedToCheckout();
        assertAttributeList(checkout.get().getActualDeliveryAddress(), checkout.get().getExpectedDeliveryAddress());
        checkout.get().clickPlaceOrder();
        assertIfVisible(payment.get().getPaymentHeading(), "Payment page");
        payment.get().fillPaymentDetails("nameOnCard", "cardNumber", "cvv", "expiryMonth", "expiryYear");
        payment.get().clickPlaceOrder();
        assertAttribute(payment.get().getOrderPlaced(), Settings.getGlobalProperty("orderPlacedTxt"));
        loginSignup.get().deleteAccount();
        assertAttribute(loginSignup.get().getAccountDeleteMsg(), Settings.getGlobalProperty("accountDeletedMsg"));
        loginSignup.get().clickContinue();
        softAssert.assertAll();



    }
}
