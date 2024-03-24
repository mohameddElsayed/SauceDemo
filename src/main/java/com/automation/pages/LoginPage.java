package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By txtUsername = By.id("user-name");
    By txtPassword = By.id("password");
    By btnLogin = By.id("login-button");


    public void setUsername(String username){
        setText(txtUsername, username);
    }

    public void setPassword(String password){
        setText(txtPassword, password);
    }

    public void clickLogin() {
        click(btnLogin);
    }
}
