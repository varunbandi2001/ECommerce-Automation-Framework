
package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import utils.ConfigReader;

public class LaunchTest extends BaseTest {

    @Test
    public void verifySauceDemoWebsiteLaunch() {

        String url = ConfigReader.getProperty("url");

        System.out.println("Test started.");
        System.out.println("URL from config: " + url);

        driver.get(url);

        String currentUrl = driver.getCurrentUrl();
        String pageTitle = driver.getTitle();

        System.out.println("Current URL: " + currentUrl);
        System.out.println("Page title: " + pageTitle);

        Assert.assertTrue(
                currentUrl.contains("saucedemo.com"),
                "SauceDemo URL did not open. Current URL: " + currentUrl
        );

        Assert.assertEquals(
                pageTitle,
                "Swag Labs",
                "Unexpected SauceDemo page title."
        );
    }
}
