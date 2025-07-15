package com.internethero.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class JavaScriptAlertsPage extends BasePage {

    public JavaScriptAlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[.='Click for JS Alert']")
    WebElement jsAlert;
    public JavaScriptAlertsPage verifyAlertPresent() {
        clickWithJS(jsAlert, 0, 300);
        Assert.assertTrue(isAlertPresent());
//        driver.switchTo().alert().accept();
        return this;
    }

    @FindBy(xpath = "//button[.='Click for JS Confirm']")
    WebElement jsConfirm;
    public JavaScriptAlertsPage selectResult(String result) {
        click(jsConfirm);
        if (result != null && result == "Ok") {
            driver.switchTo().alert().accept();
        } else if (result != null && result == "Cancel") {
            driver.switchTo().alert().dismiss();
        }
        return this;
    }

    @FindBy(id = "result")
    WebElement result;
    public JavaScriptAlertsPage verifyResult(String text) {
        Assert.assertTrue(result.getText().contains(text));
        return this;
    }

    @FindBy(xpath = "//button[.='Click for JS Prompt']")
    WebElement jsPromt;
    public JavaScriptAlertsPage sendCommentToAlert(String comment) {
        click(jsPromt);
        driver.switchTo().alert().sendKeys(comment);
        driver.switchTo().alert().accept();
        return this;
    }

    public JavaScriptAlertsPage verifyComment(String text) {
        Assert.assertTrue(result.getText().contains(text));
        return this;
    }
}
