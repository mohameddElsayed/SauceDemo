package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepTwo extends PageBase {
    public CheckoutStepTwo(WebDriver driver) {
        super(driver);
    }

    By btnFinish = By.id("finish");

    public void clickFinish(){
        click(btnFinish);
    }
}
