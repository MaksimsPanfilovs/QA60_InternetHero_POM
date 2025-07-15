package com.internethero.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class FramePage extends BasePage {

    public FramePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = ".example")
    WebElement iframeExample;

    @FindBy(linkText = "iFrame")
    WebElement iframe;

    public FramePage selectIframe() {
        click(iframe);
        return this;
    }

    public FramePage verifyIframe(String text) {
        Assert.assertTrue(iframeExample.getText().contains(text));
        return this;
    }


    @FindBy(linkText = "Nested Frames")
    WebElement nestedFrames;

    public FramePage selectNestedFrame() {
        click(nestedFrames);
        return this;
    }

    @FindBy(tagName = "body")
    WebElement body;

    public FramePage verifyFrameChildrenByTitle(String title) {
        if (title == "LEFT") {
            driver.switchTo().frame(0);
            driver.switchTo().frame(0);
            System.out.println("The Frame is: " + body.getText());
            Assert.assertEquals(body.getText(), title);
        } else if (title == "MIDDLE") {
            driver.switchTo().frame(0);
            driver.switchTo().frame(1);
            System.out.println("The Frame is: " + body.getText());
            Assert.assertEquals(body.getText(), title);
        } else if (title == "RIGHT") {
            driver.switchTo().frame(0);
            driver.switchTo().frame(2);
            System.out.println("The Frame is: " + body.getText());
            Assert.assertEquals(body.getText(), title);
        } else if (title == "BOTTOM") {
            driver.switchTo().frame(1);
            System.out.println("The Frame is: " + body.getText());
            Assert.assertEquals(body.getText(), title);
        }
        return this;
    }
}
