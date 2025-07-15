package com.internethero.tests;

import com.internethero.pages.ContextMenuPage;
import com.internethero.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContextMenuTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getContextMenu();
    }

    @Test
    public void rightClickMenuTest() {
        new ContextMenuPage(driver).selectRightClickMenu().verifyRightClickMenu();
    }


}
