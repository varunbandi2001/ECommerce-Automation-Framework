package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Cart page
    private final By checkoutButton = By.id("checkout");

    // Checkout information page
    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By continueButton = By.id("continue");

    // Checkout overview page
    private final By overviewTitle = By.className("title");
    private final By finishButton = By.id("finish");

    // Confirmation and validation
    private final By errorMessage =
            By.cssSelector("[data-test='error']");
    private final By completeHeader =
            By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(
                driver, Duration.ofSeconds(15));
    }

    public void clickCheckout() {
        WebElement button = wait.until(
                ExpectedConditions.elementToBeClickable(checkoutButton));
        button.click();

        wait.until(ExpectedConditions.urlContains("checkout-step-one.html"));
    }

    public void enterCustomerDetails(
            String first, String last, String postal) {

        WebElement firstField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(firstName));
        WebElement lastField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(lastName));
        WebElement postalField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(postalCode));

        firstField.clear();
        firstField.sendKeys(first);

        lastField.clear();
        lastField.sendKeys(last);

        postalField.clear();
        postalField.sendKeys(postal);

        // Verify values entered in the actual browser fields
        String actualFirst = firstField.getAttribute("value");
        String actualLast = lastField.getAttribute("value");
        String actualPostal = postalField.getAttribute("value");

        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("First Name: " + actualFirst);
        System.out.println("Last Name: " + actualLast);
        System.out.println("Postal Code: " + actualPostal);

        if (!first.equals(actualFirst)
                || !last.equals(actualLast)
                || !postal.equals(actualPostal)) {
            throw new AssertionError(
                    "Checkout form values do not match the test data.");
        }
    }

    public void clickContinue() {
        wait.until(
                ExpectedConditions.elementToBeClickable(continueButton))
                .click();
    }

    public boolean isOverviewDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(overviewTitle))
                .getText().equals("Checkout: Overview");
    }

    public void clickFinish() {
        wait.until(
                ExpectedConditions.elementToBeClickable(finishButton))
                .click();
    }

    public String getCompleteHeader() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(completeHeader))
                .getText();
    }

    public String getErrorMessage() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(errorMessage))
                .getText();
    }
}