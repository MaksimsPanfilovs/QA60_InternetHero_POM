package com.internethero.tests;

import com.internethero.pages.HomePage;
import com.internethero.pages.HorizontalSliderPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HorizontalSliderTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getHorizontalSlider();
    }

    @Test
    public void setHorizontalSliderTest() {
        new HorizontalSliderPage(driver).setSlider().verifySlider("5");
    }


}
