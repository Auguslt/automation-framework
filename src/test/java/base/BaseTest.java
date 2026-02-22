package base;

import org.openqa.selenium.*;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class BaseTest {

    protected WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) {
        DriverFactory.initDriver(browser);
        driver = DriverFactory.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    // Se usa desde el Listener
    public String captureScreenshot(String testName) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = "screenshots/" + testName + ".png";
        FileUtils.copyFile(src, new File(path));
        return path;
    }
}