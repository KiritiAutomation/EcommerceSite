package org.example.pageObjects.common;

import org.example.pageObjects.BasePage;
import org.example.utils.JsonUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PdpPage extends BasePage {


    @FindBy(css = ".product-information h2")
    private WebElement productName;

    @FindBy(css = ".product-information p:nth-of-type(1)")
    private WebElement catergoryElement;

    @FindBy(css = ".product-information p:nth-of-type(3)")
    private WebElement conditionElement;

    @FindBy(css = ".product-information p:nth-of-type(4)")
    private WebElement brandElement;

    @FindBy(id = "quantity")
    private WebElement quantity;

    @FindBy(xpath = "//button[contains(@class, 'cart')]")
    private WebElement addToCart;

    @FindBy(xpath = "//button[@data-dismiss='modal']")
    private WebElement continueShopping;



    public WebElement getProductName(){
        return productName;
    }

    public boolean productHasCategory(){
        String category = getText(catergoryElement);
        return category.contains("Category");
    }

    public boolean productHasCondition(){
        String condition = getText(conditionElement);
        return condition.contains("Condition");
    }

    public boolean productHasBrand(){
        String brand = getText(brandElement);
        return brand.contains("Brand");
    }

    public void increaseQuantityTo(int num) {
        quantity.clear();
        sendKeys(quantity, String.valueOf(num), num + " quantity is sent");

    }

    public void clickAddToCart(){
        click(addToCart, "Add to Cart is clicked");
        waitTillElementVisible(continueShopping);
        click(continueShopping, "Continue shopping is clicked");
        String caller = getCallingMethodName();
        JsonUtils.writeArrayData(caller, "Product Name", productName.getText());
        JsonUtils.writeArrayData(caller, "Product Quantity", quantity.getAttribute("value"));

    }





}
