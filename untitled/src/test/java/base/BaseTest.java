package base;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import util.DriverFactory;

public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createChrome();
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] attachScreenshot(){
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
