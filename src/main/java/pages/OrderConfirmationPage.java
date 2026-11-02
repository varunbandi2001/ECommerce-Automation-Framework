
package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderConfirmationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By confirmationContainer =
            By.className("checkout_complete_container");

    private By confirmationTitle =
            By.className("complete-header");

    private By confirmationMessage =
            By.className("complete-text");

    private By backHomeButton =
            By.id("back-to-products");

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isConfirmationPageDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        confirmationContainer)).isDisplayed();
    }

    public String getConfirmationTitle() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        confirmationTitle)).getText();
    }

    public String getConfirmationMessage() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        confirmationMessage)).getText();
    }

    public boolean isBackHomeButtonDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        backHomeButton)).isDisplayed();
    }

    public void clickBackHomeButton() {
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        backHomeButton)).click();
    }
}
