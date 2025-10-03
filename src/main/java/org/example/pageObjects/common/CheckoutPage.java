package org.example.pageObjects.common;

import org.example.pageObjects.BasePage;
import org.example.utils.Settings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CheckoutPage extends BasePage {


    @FindBy(id = "address_delivery")
    private WebElement deliveryAddressSection;

    @FindBy(xpath = "//a[contains(text(), 'Place Order')]")
    private WebElement placeOrder;



    public List<String> getExpectedDeliveryAddress(){
        List<String> data = new ArrayList<>();
        data.add("Mr.");
        data.add(Settings.getGlobalProperty("signupFirstName"));
        data.add(Settings.getGlobalProperty("signupLastName"));
        data.add(Settings.getGlobalProperty("signupCompanyName"));
        data.add(Settings.getGlobalProperty("signupAddress"));
        data.add(Settings.getGlobalProperty("signupCity"));
        data.add(Settings.getGlobalProperty("signupState"));
        data.add(Settings.getGlobalProperty("signupZipCode"));
        data.add(Settings.getGlobalProperty("signupCountry"));
        data.add(Settings.getGlobalProperty("signupPhone"));

        return data;

    }

    public List<String> getActualDeliveryAddress(){

        List<String> acutalData = new ArrayList<>();
        WebElement first = deliveryAddressSection.findElement(By.cssSelector(".address_firstname"));
        String[] first_data = first.getText().split(" ");
        acutalData.add(first_data[0]);
        acutalData.add(first_data[1]);
        acutalData.add(first_data[2]);

        List<WebElement> second = deliveryAddressSection.findElements(By.cssSelector(".address_address1"));
        acutalData.add(second.get(0).getText());
        acutalData.add(second.get(1).getText());

        WebElement third = deliveryAddressSection.findElement(By.cssSelector(".address_postcode"));
        String[] third_data = third.getText().split(" ");
        acutalData.add(third_data[0]);
        acutalData.add(third_data[1]+" "+third_data[2]);
        acutalData.add(third_data[3]);

        WebElement fourth = deliveryAddressSection.findElement(By.cssSelector(".address_country_name"));
        acutalData.add(fourth.getText());

        WebElement fifth = deliveryAddressSection.findElement(By.cssSelector(".address_phone"));
        acutalData.add(fifth.getText());

        return acutalData;

    }

    public void clickPlaceOrder(){
        scrollTillelement(placeOrder);
        click(placeOrder, "Place order is clicked");
    }

}
