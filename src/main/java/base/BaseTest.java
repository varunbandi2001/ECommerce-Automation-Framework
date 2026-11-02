
package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import drivers.DriverFactory;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.out.println("Starting test setup...");
        driver = DriverFactory.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        try {
            if (driver != null) {
                System.out.println("Browser will close in 2 minutes...");
                Thread.sleep(120000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            DriverFactory.quitDriver();
            driver = null;
        }
    }
}
