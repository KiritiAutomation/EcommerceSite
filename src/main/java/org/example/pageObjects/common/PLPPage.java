package org.example.pageObjects.common;

import org.example.pageObjects.BasePage;
import org.example.utils.DriverFactory;
import org.example.utils.JsonUtils;
import org.example.utils.Settings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.lang.reflect.Method;
import java.util.List;

public class PLPPage extends BasePage {


    @FindBy(xpath = "//div[@class='features_items']/h2")
    private WebElement allProductsheading;

    @FindBy(xpath = "//div[@id='cartModal']/following-sibling::div")
    private List<WebElement> products;

    @FindBy(id = "search_product")
    private WebElement searchProductField;

    @FindBy(id = "submit_search")
    private WebElement submitSearch;

    @FindBy(xpath = "//div[@class='features_items']/h2[contains(text(), 'Searched')]")
    private WebElement searchedProductsHeading;

    @FindBy(xpath = "//button[@data-dismiss='modal']")
    private WebElement continueShopping;

    @FindBy(partialLinkText = "Cart")
    private WebElement cartButton;




    public WebElement getAllProductsHeading(){
        return allProductsheading;
    }

    public boolean areProductsAvailable(){

        return !products.isEmpty();
    }

    public void clickViewCartOnProduct(int num){
        WebElement product = products.get(num-1);
        scrollTillelement(product);
        WebElement viewProductCTA = product.findElement(By.partialLinkText("View Product"));
        click(viewProductCTA, "View Product CTA clicked of First Product");
    }

    public void searchProduct(String productName){
        scrollTillelement(searchProductField);
        sendKeys(searchProductField, Settings.getGlobalProperty(productName), Settings.getGlobalProperty(productName)+ " is Entered in the search field");
        click(submitSearch, "Clicked on Search icon");
    }


    public WebElement getSearchedProductsHeading(){
        return searchedProductsHeading;
    }

    public boolean resultContainsSearcheditems(){
        scrollTillelement(searchedProductsHeading);
        List<WebElement> productNames = DriverFactory.getDriver().findElements(By.cssSelector(".p"));
        boolean productsContains = productNames.stream().allMatch(s->s.getText().contains(Settings.getGlobalProperty("searchProduct")));
        return productsContains;

    }

    public void addToCartProductNumber(int num) throws InterruptedException {
        WebElement product = products.get(num-1);
        scrollTillelement(product);
        WebElement addToCartCTA = product.findElements(By.tagName("a")).get(0);
        WebElement addToCartCTAsecond = product.findElements(By.tagName("a")).get(1);
        actionMoveToElement(addToCartCTA);
        click(addToCartCTAsecond, "Add to cart is clicked");
        String price = product.findElements(By.tagName("h2")).get(0).getText().split(" ")[1].trim();
        String productName = product.findElements(By.tagName("p")).get(0).getText();
        String caller = getCallingMethodName();
        JsonUtils.writeArrayData(caller, "Product Names", productName);
        JsonUtils.writeArrayData(caller, "Product Prices", price);
        waitTillElementVisible(continueShopping);
        click(continueShopping, "continue shopping clicked");

    }

    public void goToCart(){
        click(cartButton, "Cart button clicked");
    }








}
