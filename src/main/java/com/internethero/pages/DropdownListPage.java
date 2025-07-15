package com.internethero.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DropdownListPage extends BasePage {

    public DropdownListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "dropdown")
    WebElement dropdown;
    public DropdownListPage checkSelectTest() {
        new Select(dropdown).getFirstSelectedOption().click();
        return this;
    }

    public DropdownListPage verifySelectedOption() {
        String option1 = new Select(dropdown).getFirstSelectedOption().getText();
        Assert.assertTrue(shouldHaveText(dropdown, option1, 5));
        return this;
    }
}
