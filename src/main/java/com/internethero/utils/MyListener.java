package com.internethero.utils;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Random;

public class MyListener implements WebDriverListener {

    Logger logg = LoggerFactory.getLogger(MyListener.class);

    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        WebDriverListener.super.onError(target, method, args, e);
        logg.info("Test have a problem");
        logg.info("**********************************");

        logg.info("Method --> " + method.getName());
        logg.info("**********************************");

        logg.info("TargetException --> " + e.getTargetException());
        logg.info("**********************************");

        logg.info("Object target --> " + target.toString());
        logg.info("**********************************");

        int i = new Random().nextInt(1000) + 1000;
        String link = "screenshots/screen-" + i + ".png";
        WebDriver driver = (ChromeDriver) target;
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File tmp = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(tmp, new File(link));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        WebDriverListener.super.beforeFindElement(driver, locator);
        logg.info("The locator will find " + locator);
        logg.info("**********************************");

    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        WebDriverListener.super.afterFindElement(driver, locator, result);
        logg.info("The locator is " + locator);
        logg.info("**********************************");

    }

    @Override
    public void beforeFindElements(WebDriver driver, By locator) {
        WebDriverListener.super.beforeFindElements(driver, locator);
        logg.info("Before Find Elements " + locator);
        logg.info("**********************************");
    }

    @Override
    public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
        WebDriverListener.super.afterFindElements(driver, locator, result);
        logg.info("List size is " + result.size());
        logg.info("**********************************");
    }

}
