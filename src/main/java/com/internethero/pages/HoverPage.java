package com.internethero.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HoverPage extends BasePage {

    public HoverPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".figure:nth-child(3)")
    WebElement first;
    public HoverPage selectFirstHover() {
        new Actions(driver).clickAndHold(first).perform();
        return this;
    }

    public HoverPage verifyFirst(String result) {
        Assert.assertTrue(first.getText().contains(result));
        return this;
    }

    @FindBy(css = ".figure:nth-child(5)")
    WebElement last;
    public HoverPage selectLastHover() {
        new Actions(driver).clickAndHold(last).perform();
        return this;
    }

    public HoverPage verifyLast(String result) {
        Assert.assertTrue(last.getText().contains(result));
        return this;
    }
}
