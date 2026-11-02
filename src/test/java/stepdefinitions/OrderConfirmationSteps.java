
package stepdefinitions;

import org.testng.Assert;

import drivers.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.OrderConfirmationPage;

public class OrderConfirmationSteps {

    private OrderConfirmationPage orderConfirmationPage;

    private OrderConfirmationPage getOrderConfirmationPage() {
        if (orderConfirmationPage == null) {
            orderConfirmationPage =
                    new OrderConfirmationPage(DriverFactory.getDriver());
        }
        return orderConfirmationPage;
    }

    @Then("the order confirmation page should be displayed")
    public void verifyConfirmationPage() {
        Assert.assertTrue(
                getOrderConfirmationPage().isConfirmationPageDisplayed(),
                "Order confirmation page was not displayed"
        );
    }

    @Then("the confirmation message should be displayed")
    public void verifyConfirmationMessage() {
        String message =
                getOrderConfirmationPage().getConfirmationTitle();

        Assert.assertEquals(message, "Thank you for your order!");
    }

    @Then("the order completion message should be displayed")
    public void verifyOrderCompletionMessage() {
        String message =
                getOrderConfirmationPage().getConfirmationMessage();

        Assert.assertFalse(
                message.trim().isEmpty(),
                "Order completion message is empty"
        );
    }

    @Then("the Back Home button should be displayed")
    public void verifyBackHomeButton() {
        Assert.assertTrue(
                getOrderConfirmationPage().isBackHomeButtonDisplayed(),
                "Back Home button was not displayed"
        );
    }

    @When("the user clicks the Back Home button")
    public void clickBackHomeButton() {
        getOrderConfirmationPage().clickBackHomeButton();
    }
}
