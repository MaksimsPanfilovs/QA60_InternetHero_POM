package com.internethero.tests;

import com.internethero.pages.HomePage;
import com.internethero.pages.HoverPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HoverTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getHover();
    }

    @Test
    public void checkFirstHover() {
        new HoverPage(driver).selectFirstHover().verifyFirst("name: user1");
    }

    @Test
    public void checkLastHover() {
        new HoverPage(driver).selectLastHover().verifyLast("name: user3");
    }


}
