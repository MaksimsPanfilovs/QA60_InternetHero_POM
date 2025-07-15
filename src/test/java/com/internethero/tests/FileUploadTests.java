package com.internethero.tests;

import com.internethero.pages.FileUploadPage;
import com.internethero.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getFileUploud();
    }

    @Test
    public void fileUploudTest() {
        new FileUploadPage(driver)
                .apployedFile("C:/Users/uragv/Downloads/hiker-looks-out-over-bay-surrounded-by-mountains.jpg")
                .verifyFileIsApployed("File Uploaded!")
        ;
    }


}
