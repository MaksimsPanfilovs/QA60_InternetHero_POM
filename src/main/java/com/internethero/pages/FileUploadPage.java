package com.internethero.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class FileUploadPage extends BasePage {

    public FileUploadPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "file-upload")
    WebElement uploadFile;
    @FindBy(id = "file-submit")
    WebElement fileSubmit;
    public FileUploadPage apployedFile(String path) {
        uploadFile.sendKeys(path);
        click(fileSubmit);
        return this;
    }

    @FindBy(tagName = "h3")
    WebElement successText;
    public FileUploadPage verifyFileIsApployed(String result) {
        Assert.assertTrue(shouldHaveText(successText, result, 5));
        return this;
    }
}
