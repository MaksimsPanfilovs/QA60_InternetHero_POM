package com.internethero.tests;

import com.internethero.pages.FramePage;
import com.internethero.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FrameTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getFrames();
    }

    @Test
    public void frameTest() {
        new FramePage(driver).selectIframe().verifyIframe("TinyMCE WYSIWYG");
    }

    @Test
    public void nestedFrameTest() {
        new FramePage(driver).selectNestedFrame()
                .verifyFrameChildrenByTitle("BOTTOM");
        // "LEFT", "MIDDLE", "RIGHT", "BOTTOM"
    }
}
