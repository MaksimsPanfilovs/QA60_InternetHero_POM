package com.internethero.tests;

import com.internethero.config.ApplicationManeger;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class TestBase {

    private final ApplicationManeger app = new ApplicationManeger(System.getProperty("browser", "chrome"));
    public WebDriver driver;
    Logger logg = LoggerFactory.getLogger(TestBase.class);


    @BeforeMethod
    public void init(Method method) {
        driver = app.startTest();
        logg.info("Start test: " + method.getName());
    }

    @AfterMethod(enabled = true)
    public void tearDown(ITestResult result) {
        if (result.isSuccess()) {
            logg.info("Test result: PASSED " + result.getMethod().getMethodName());
        } else {
            logg.info("Test result: FAILED " + result.getMethod().getMethodName());
        }
        app.stopTest();
    }


}
