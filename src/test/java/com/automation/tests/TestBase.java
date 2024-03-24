package com.automation.tests;

import com.automation.pages.*;
import com.automation.remarks.video.enums.RecordingMode;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.collect.ImmutableMap;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TestBase {
    WebDriver driver;
    HomePage homePage;
    CartPage cartPage;
    LoginPage loginPage;
    InfoPage infoPage;
    CheckoutStepTwo checkoutStepTwo;
    CheckoutCompletePage checkoutCompletePage;

    public static ExtentReports report ;
    public static ExtentTest logger;

    private final String url="https://www.saucedemo.com/";

    @BeforeClass
    public void setUp(){
        //WebDriverManager.chromedriver().setup();
        System.setProperty("video.save.mode", RecordingMode.ALL.toString());

        ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir") + "\\src\\test\\java\\TestReports\\SauceDemo task report "+ GetCurrentTime() + " .html"));
        report = new ExtentReports();
        report.attachReporter(extent);



        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        cartPage = new CartPage(driver);
        infoPage = new InfoPage(driver);
        checkoutStepTwo = new CheckoutStepTwo(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
        driver.manage().window().maximize();
        driver.navigate().to(url);
        logger = report.createTest("Open Sauce Demo ");
        logger.info("Successfully Opened URL on Browser " );
    }
    @AfterMethod
    public void getResult(ITestResult result) throws IOException {
        if(result.getStatus() == ITestResult.FAILURE) {
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
            logger.fail(result.getThrowable());
            String temp=  Screenshot(driver);
            logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED " , ExtentColor.GREEN));
            String temp=  Screenshot(driver);
            logger.pass(result.getMethod().getMethodName(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
        }
        else {
            logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
            logger.skip(result.getThrowable());
        }
        report.flush();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    public void switchTab(){
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public static String Screenshot(WebDriver driver) {

        TakesScreenshot ts=(TakesScreenshot) driver;

        File src=ts.getScreenshotAs(OutputType.FILE);

        String path=System.getProperty("user.dir")+"\\src\\test\\java\\TestReports\\"+GetCurrentTime()+".jpg";

        File destination=new File(path);

        try
        {
            FileUtils.copyFile(src, destination);
        } catch (IOException e)
        {
            System.out.println("Capture Failed "+e.getMessage());
        }

        return path;
    }
    public static String GetCurrentTime () {
        DateFormat format = new SimpleDateFormat("dd MMMM YYYY hh.mm.ss");
        Date date=new Date();
        return  format.format(date);
    }

}
