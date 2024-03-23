package com.automation.tests;

import com.automation.pages.*;
import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.util.ArrayList;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public class TestBase {
    WebDriver driver;
    HomePage homePage;
    CartPage cartPage;
    LoginPage loginPage;
    InfoPage infoPage;
    CheckoutStepTwo checkoutStepTwo;
    CheckoutCompletePage checkoutCompletePage;
    private final String url="https://www.saucedemo.com/";

    @BeforeSuite
    void setEnvironment() {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", "Chrome")
                        .put("Browser.Version", "97.0.4692.71")
                        .put("URL", url)
                        .build(), System.getProperty("user.dir")
                        + "/allure-results/");
    }

    @BeforeClass
    public void setUp(){
        //WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        cartPage = new CartPage(driver);
        infoPage = new InfoPage(driver);
        checkoutStepTwo = new CheckoutStepTwo(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
        driver.manage().window().maximize();
        driver.navigate().to(url);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    public void switchTab(){
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

}
