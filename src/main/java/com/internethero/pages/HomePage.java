package com.internethero.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "JavaScript Alerts")
    WebElement javaScriptAlert;
    public JavaScriptAlertsPage getJavaScriptAlerts() {
        click(javaScriptAlert);
        return new JavaScriptAlertsPage(driver);
    }

    @FindBy(linkText = "Horizontal Slider")
    WebElement horizontalSlider;
    public HorizontalSliderPage getHorizontalSlider() {
        click(horizontalSlider);
        return new HorizontalSliderPage(driver);
    }

    @FindBy(linkText = "Frames")
    WebElement frames;
    public FramePage getFrames() {
        click(frames);
        return new FramePage(driver);
    }

    @FindBy(linkText = "Hovers")
    WebElement hovers;
    public HoverPage getHover() {
        click(hovers);
        return new HoverPage(driver);
    }

    @FindBy(linkText = "Context Menu")
    WebElement contextMenu;
    public ContextMenuPage getContextMenu() {
        click(contextMenu);
        return new ContextMenuPage(driver);
    }

    @FindBy(linkText = "Drag and Drop")
    WebElement dragAndDrop;
    public DragAndDropPage getDragAndDrop() {
        click(dragAndDrop);
        return new DragAndDropPage(driver);
    }

    @FindBy(linkText = "Dropdown")
    WebElement dropdown;
    public DropdownListPage getDropdown() {
        click(dropdown);
        return new DropdownListPage(driver);
    }
}
