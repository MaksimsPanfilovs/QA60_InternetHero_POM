package com.internethero.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ContextMenuPage extends BasePage {

    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "hot-spot")
    WebElement hotSpot;
    public ContextMenuPage selectRightClickMenu() {
        new Actions(driver).contextClick(hotSpot).perform();
        return this;
    }

    public ContextMenuPage verifyRightClickMenu() {
        Assert.assertTrue(isAlertPresent());
        return this;
    }
}
