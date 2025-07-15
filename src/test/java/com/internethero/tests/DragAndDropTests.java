package com.internethero.tests;

import com.internethero.pages.DragAndDropPage;
import com.internethero.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDropTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getDragAndDrop();
    }

    @Test
    public void actionDragAndDropTest() {
        new DragAndDropPage(driver).actionDragAndDrop().verifyDropped("A");
    }



}
