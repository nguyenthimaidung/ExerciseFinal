package demowebshop.helper;


import demowebshop.common.BaseTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("-------Test Start");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Log.info("---------- " + result.getName() + " Success test ----------");
        Object testClass = result.getInstance();
        WebDriver webDriver = ((BaseTest) testClass).getDriver();
        saveScreenShot(webDriver);
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("-------Test Skip");
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("-------Start");
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }

    @Attachment()
    public  static void saveScreenShot(WebDriver driver){
        ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Log.info("---------- " + result.getName() + " FAILED test ----------");
        Object testClass = result.getInstance();
        WebDriver webDriver = ((BaseTest) testClass).getDriver();
        saveScreenShot(webDriver);

    }



}
