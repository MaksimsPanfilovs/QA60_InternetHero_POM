package com.internethero.tests;

import com.internethero.pages.HomePage;
import com.internethero.pages.JavaScriptAlertsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScripAlertTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getJavaScriptAlerts();
    }


    @Test
    public void jsAlertTest() {
        new JavaScriptAlertsPage(driver).verifyAlertPresent();
    }

    @Test
    public void jsConfirmAlertTest() {
        new JavaScriptAlertsPage(driver).selectResult("Ok").verifyResult("Ok");
    }

    @Test
    public void jsPromtAlertTest() {
        new JavaScriptAlertsPage(driver).sendCommentToAlert("Hi Max!").verifyComment("Hi Max!");
    }


}
