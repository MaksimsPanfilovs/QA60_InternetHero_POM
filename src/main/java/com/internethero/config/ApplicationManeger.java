package com.internethero.config;

import com.internethero.utils.MyListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.time.Duration;

public class ApplicationManeger {

    String browser;
    WebDriver driver;

    public ApplicationManeger(String browser) {
        this.browser = browser;
    }

    public WebDriver startTest() {
        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equals("edge")) {
            driver = new EdgeDriver();
        } else if (browser != null
                && !browser.equals("chrome")
                && !browser.equals("firefox")
                && !browser.equals("edge")) {
            throw new IllegalArgumentException("Browser entered is not correct");
        }
        driver = new EventFiringDecorator(new MyListener()).decorate(driver);
        driver.get("https://the-internet.herokuapp.com");
        driver.manage().window().maximize();
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }

    public void stopTest() {
        driver.quit();
    }
}
