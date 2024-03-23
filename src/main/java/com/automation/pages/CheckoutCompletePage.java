package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends PageBase {
    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    By lblSuccessMessage = By.xpath("//*[@id=\"checkout_complete_container\"]/h2");

    public boolean isSuccessMessageDisplayed(){
        return isDisplayed(lblSuccessMessage);
    }

    public String getSuccessMessage(){
        return getContent(lblSuccessMessage);
    }
}

