package org.example.pageObjects.common;

import com.aventstack.extentreports.Status;
import org.example.pageObjects.BasePage;
import org.example.utils.Reporter;
import org.example.utils.Settings;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {


    @FindBy(partialLinkText = "Signup / Login")
    private WebElement signupLoginLink;

    @FindBy(partialLinkText = "Products")
    private WebElement productsLink;

    @FindBy(css = ".single-widget h2")
    private WebElement subscriptionSection;

    @FindBy(id = "susbscribe_email")
    private WebElement subscribeEmailField;

    @FindBy(id = "subscribe")
    private WebElement subscribeSubmit;

    @FindBy(css = ".alert-success")
    private WebElement subscribeSuccessmessage;


    public void goToHomepage(){
        openUrl();
        waitTillElementVisible(getSignupLoginLink());

    }

    public String getTitle(){
        String value = driver.getTitle();
        Reporter.log(Status.INFO, "Site title is "+value);
        return value;
    }

    public void goToSignupLogin(){

        click(signupLoginLink, "Signup/Login hyperlink clicked");
    }

    public void goToProducts(){
        click(productsLink, "Product hyperlink is clicked");
    }

    public void subscribeUsing(String email){
        sendKeys(subscribeEmailField, Settings.getGlobalProperty(email), Settings.getGlobalProperty(email)+ " is entered");
        click(subscribeSubmit, "Submit is clicked");
        waitTillElementVisible(subscribeSuccessmessage);
//        assertAttribute(subscribeSuccessmessage.getText(), getGlobalProperty("subscribeSuccessMessage"));

    }


    public void scrollToSubscribeSection() throws InterruptedException {
        scrollTillelement(subscriptionSection);
        Thread.sleep(5000);
    }

    public WebElement getSubscribeSection(){
        return subscriptionSection;
    }

    public String getSubscribeSuccessmessage(){
        waitTillElementVisible(subscribeSuccessmessage);
        return subscribeSuccessmessage.getText();
    }

    public WebElement getSignupLoginLink(){
        return signupLoginLink;
    }




}
