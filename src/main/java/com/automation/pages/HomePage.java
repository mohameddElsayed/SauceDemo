package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    By btnAddToCart = By.id("add-to-cart-sauce-labs-bike-light");
    By btnCart = By.xpath("//*[@id=\"shopping_cart_container\"]/a");

    public void clickAddToCart(){
        click(btnAddToCart);
    }

    public void clickCartIcon(){
        click(btnCart);
    }

}
