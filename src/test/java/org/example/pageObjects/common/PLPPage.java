package org.example.pageObjects.common;

import org.example.pageObjects.BaseObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PLPPage extends BaseObject {

    @FindBy(xpath = "//div[@class='features_items']/h2")
    public WebElement allProductsheading;

    @FindBy(xpath = "//div[@id='cartModal']/following-sibling::div")
    public List<WebElement> products;


}
