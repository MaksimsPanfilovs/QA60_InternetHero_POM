package com.internethero.tests;

import com.internethero.pages.DropdownListPage;
import com.internethero.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownListTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getDropdown();
    }


    @Test
    public void selectFromDropdownListTest() {
        new DropdownListPage(driver).checkSelectTest().verifySelectedOption();
    }



}
