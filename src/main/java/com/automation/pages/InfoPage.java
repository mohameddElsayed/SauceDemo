package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InfoPage extends PageBase{
    public InfoPage(WebDriver driver) {
        super(driver);
    }

    By txtFirstName = By.cssSelector("input[id='first-name']");
    By txtLastName = By.id("last-name");
    By txtPostalCode = By.id("postal-code");
    By btnContinue = By.id("continue");

    public void setFirstName(String firstname){
        click(txtFirstName);
        setText(txtFirstName, firstname);
    }

    public void setLastName(String lastName){
        setText(txtLastName, lastName);
    }

    public void setPostalCode(String postalCode){
        setText(txtPostalCode, postalCode);
    }

    public void clickContinue(){
        click(btnContinue);
    }

}
