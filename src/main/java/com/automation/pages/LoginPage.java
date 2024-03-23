package com.automation.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By txtUsername = By.id("user-name");
    By txtPassword = By.id("password");
    By btnLogin = By.id("login-button");

    @Step("Set username")
    public void setUsername(String username){
        setText(txtUsername, username);
    }

    @Step("Set password")
    public void setPassword(String password){
        setText(txtPassword, password);
    }

    @Step("Click Login")
    public void clickLogin() {
        click(btnLogin);
    }
}
