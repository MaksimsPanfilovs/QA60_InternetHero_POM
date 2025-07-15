package com.internethero.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HorizontalSliderPage extends BasePage {

    public HorizontalSliderPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(xpath = "//input")
    WebElement inputSlider;
    public HorizontalSliderPage setSlider() {
        pause(1000);
        moveWithJS(0, 200);
        new Actions(driver).dragAndDropBy(inputSlider, 60, 0).perform();
        return this;
    }

    public HorizontalSliderPage setSlider2() {
        pause(1000);
        moveWithJS(0, 200);
        new Actions(driver).clickAndHold(inputSlider).sendKeys(range,"bla-bla").release().perform();
        return this;
    }


    @FindBy(id = "range")
    WebElement range;
    public HorizontalSliderPage verifySlider(String number) {
        Assert.assertEquals(range.getText(), number);
        return this;
    }
}
