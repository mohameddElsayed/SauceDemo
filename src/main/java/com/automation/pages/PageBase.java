package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {

    WebDriver driver;
    public PageBase(WebDriver driver){
        this.driver = driver;
    }

    protected WebElement action(By locator){
        return driver.findElement(locator);
    }

    protected void waitElement(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void setText(By locator, String data) {
        waitElement(locator);
        action(locator).clear();
        action(locator).sendKeys(data);
    }

    protected void click(By locator){
        waitElement(locator);
        action(locator).click();
    }

    public void selectData(By locator, int index) {
        Select select;
        select = new Select(action(locator));
        select.selectByIndex(index);
    }

    protected void waitPageToLoad(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public boolean isDisplayed(By locator){
        return action(locator).isDisplayed();
    }

    public String getContent(By locator){
        return action(locator).getText();
    }

}
