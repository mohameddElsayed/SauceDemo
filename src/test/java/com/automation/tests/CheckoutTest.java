package com.automation.tests;

import Utils.ExcelFileManager;
import org.junit.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.IOException;

public class CheckoutTest extends TestBase {

    @Test
    public void checkout() throws IOException, InterruptedException {
        loginPage.setUsername(ExcelFileManager.setDataFromExcelFile(0, 1));
        loginPage.setPassword(ExcelFileManager.setDataFromExcelFile(1, 1));
        loginPage.clickLogin();
        homePage.clickAddToCart();
        homePage.clickCartIcon();
        cartPage.clickCheckout();
        infoPage.setFirstName(ExcelFileManager.setDataFromExcelFile(2,1));
        infoPage.setLastName(ExcelFileManager.setDataFromExcelFile(3,1));
        infoPage.setPostalCode(ExcelFileManager.setDataFromExcelFile(4,1));
        infoPage.clickContinue();
        checkoutStepTwo.clickFinish();
        Reporter.log("Success Test case");
        Assert.assertEquals("Thank you for your order!",checkoutCompletePage.getSuccessMessage());
        Assert.assertTrue(checkoutCompletePage.isSuccessMessageDisplayed());

    }
}
