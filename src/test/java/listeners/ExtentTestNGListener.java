package listeners;

import base.BaseTest;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.*;

public class ExtentTestNGListener implements ITestListener {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        ExtentSparkReporter spark =
                new ExtentSparkReporter("reports/ExtentReport.html");

        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("OS", "Windows");
    }

   @Override
    public void onTestStart(ITestResult result) {

        String testName = result.getMethod().getDescription();
        if (testName == null || testName.isEmpty()) {
            testName = result.getMethod().getMethodName();
        }

        test.set(extent.createTest(testName));

        String browser = result.getTestContext()
            .getCurrentXmlTest()
            .getParameter("browser");

        test.get().assignCategory(browser.toUpperCase());
        test.get().info("Browser: " + browser);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        attachScreenshot(result, Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        attachScreenshot(result, Status.FAIL,
                result.getThrowable() != null ? result.getThrowable().getMessage() : "Test failed");
    }

    private void attachScreenshot(ITestResult result, Status status, String message) {
    try {
        BaseTest baseTest = (BaseTest) result.getInstance();
        String path = baseTest.captureScreenshot(result.getMethod().getMethodName());

        test.get().log(status, message);
        test.get().addScreenCaptureFromPath(path);

    } catch (Exception e) {
        test.get().log(status, "Screenshot error: " + e.getMessage());
    }
}

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}