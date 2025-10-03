package org.example.pageObjects.common;

import org.example.pageObjects.BasePage;
import org.example.utils.JsonUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;
import java.util.stream.Collectors;

public class CartPage extends BasePage {

    @FindBy(xpath = "//li[contains(text(), 'Shopping Cart')]")
    private WebElement shoppingCart;

    @FindBy(xpath = "//tr[@class='cart_menu']")
    private WebElement cartMenu;

    @FindBy(xpath = "//td[@class='cart_description']/h4/a")
    private List<WebElement> productsInCart;

    @FindBy(xpath = "//td[@class='cart_price']/p")
    private List<WebElement> productsPriceInCart;


    @FindBy(css = ".cart_quantity button")
    private WebElement cartQuantity;

    @FindBy(css = ".cart_quantity_delete")
    private List<WebElement> cartQuantityDelete;

    @FindBy(xpath = "//a[contains(text(), 'Proceed To Checkout')]")
    private WebElement proceedToCheckout;

    @FindBy(partialLinkText = "Register / Login")
    private WebElement signupLoginLink;



//  Methods
    public WebElement getShoppingCart(){
        return shoppingCart;
    }

    public WebElement getCartMenu(){
        return cartMenu;
    }

    public List<String> getExpectedProductNames(){

        List<String> expected = new ArrayList<>(Arrays.asList(JsonUtils.readArrayData(getCallingMethodName(), "Product Names")));
        return expected;
    }

    public List<String> getExpectedProductPrices(){
        List<String> expected = new ArrayList<>(Arrays.asList(JsonUtils.readArrayData(getCallingMethodName(), "Product Prices")));
        return expected;
    }

    public List<String> getActualProductNames(){
        scrollTillelement(getCartMenu());
        return productsInCart.stream().map(WebElement::getText).collect(Collectors.toList());
    }


    public List<String> getActualProductPrices(){
        return productsPriceInCart.stream().map(WebElement::getText).map(text->text.replaceAll("[^0-9]", "")).collect(Collectors.toList());
    }

    public String getActualCartQuantity(){
        return cartQuantity.getText();
    }

    public String getExpectedCartQuantity(){

        return JsonUtils.readNestedData(getCallingMethodName(), "Product Quantity");
    }

    public void clearCart(){
    cartQuantityDelete.forEach(WebElement::click);
    }

    public void clickProceedToCheckout(){
        click(proceedToCheckout, "Proceed to checkout is clicked");
    }


    public void clickRegisterLogin(){
        waitTillElementVisible(signupLoginLink);
        click(signupLoginLink, "Register / Login is clicked");

    }




}
