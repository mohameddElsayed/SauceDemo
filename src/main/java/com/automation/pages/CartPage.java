package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends PageBase {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    By btnCheckout = By.id("checkout");

    public void clickCheckout(){
        click(btnCheckout);
    }
}
