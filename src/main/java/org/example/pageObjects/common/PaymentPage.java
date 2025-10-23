package org.example.pageObjects.common;

import org.example.pageObjects.BasePage;
import org.example.utils.Settings;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage {

    @FindBy(xpath = "//h2[contains(text(), 'Payment')]")
    private WebElement paymentHeading;

    @FindBy(name = "name_on_card")
    private WebElement nameField;

    @FindBy(name = "card_number")
    private WebElement cardNumberField;

    @FindBy(name = "cvc")
    private WebElement cvcField;

    @FindBy(name = "expiry_month")
    private WebElement expiryField;

    @FindBy(name = "expiry_year")
    private WebElement yearField;

    @FindBy(xpath = "//button[@data-qa='pay-button']")
    private WebElement payButton;

    @FindBy(xpath = "//h2[@data-qa='order-placed']/b")
    private WebElement orderPlacedTxt;


    public WebElement getPaymentHeading(){
        return paymentHeading;
    }

    public void fillPaymentDetails(String name, String cardNo, String cvc, String expiryMonth, String expiryYear){
        sendKeys(nameField, Settings.getGlobalProperty(name), name + " is filled");
        sendKeys(cardNumberField, Settings.getGlobalProperty(cardNo), cardNo + " is filled");
        sendKeys(cvcField, Settings.getGlobalProperty(cvc), cvc + " is filled");
        sendKeys(expiryField, Settings.getGlobalProperty(expiryMonth), expiryMonth + " is filled");
        sendKeys(yearField, Settings.getGlobalProperty(expiryYear), expiryYear + " is filled");

    }

    public void clickPlaceOrder(){
        scrollTillelement(payButton);
        click(payButton, "Place order is clicked");
    }

    public String getOrderPlaced(){
        waitTillElementVisible(orderPlacedTxt);
        return orderPlacedTxt.getText();
    }
}
