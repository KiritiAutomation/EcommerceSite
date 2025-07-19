package org.example.pageMethods.common;

import org.example.pageMethods.BaseMethod;
import org.example.pageObjects.common.PLPPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PLP extends BaseMethod {

    PLPPage pageObjects = new PLPPage();

    public void validateAllProductHeadingShowing(){
        assertIfVisible(pageObjects.allProductsheading, "All Products heading is visible");
    }

    public void validateProductsAvailable(){
        Assert.assertFalse(pageObjects.products.isEmpty());
    }

    public void openFistProduct(){
        WebElement firstProduct = pageObjects.products.get(0);
        scrollTillelement(firstProduct);
        WebElement viewProductCTA = firstProduct.findElement(By.partialLinkText("View Product"));
        click(viewProductCTA, "View Product CTA clicked of First Product");
    }

}
