package org.example.testCases.tests;

import org.example.testCases.BaseTest;
import org.example.utils.Settings;
import org.testng.annotations.Test;

public class HomepageTest extends BaseTest {

    @Test(description = "Verify Subscription in home page", groups = {"Regression", "Smoke"})
    public void verifySubscription() throws InterruptedException {
        home.get().goToHomepage();
        assertAttribute(home.get().getTitle(), Settings.getGlobalProperty("expectedHomeTitle"));
        home.get().scrollToSubscribeSection();
        softAssertIfVisible(home.get().getSubscribeSection(), "SubscribeHeading");
        home.get().subscribeUsing("subscribeEmail");
        assertAttribute(home.get().getSubscribeSuccessmessage(), Settings.getGlobalProperty("subscribeSuccessMessage"));
        softAssert.assertAll();

    }
}
