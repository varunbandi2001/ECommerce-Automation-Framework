package stepdefinitions;

import drivers.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.CheckoutPage;

public class CheckoutSteps {

    private CheckoutPage getCheckoutPage() {
        return new CheckoutPage(DriverFactory.getDriver());
    }

    @And("the user clicks the checkout button")
    public void theUserClicksCheckoutButton() {
        getCheckoutPage().clickCheckout();
    }

    @And("the user enters checkout details {string}, {string}, {string}")
    public void theUserEntersCheckoutDetails(
            String firstName, String lastName, String postalCode) {

        getCheckoutPage().enterCustomerDetails(
                firstName, lastName, postalCode);
    }

    @And("the user continues checkout")
    public void theUserContinuesCheckout() {
        getCheckoutPage().clickContinue();
    }

    @Then("the checkout overview should be displayed")
    public void theCheckoutOverviewShouldBeDisplayed() {
        Assert.assertTrue(
                getCheckoutPage().isOverviewDisplayed(),
                "Checkout overview was not displayed.");
    }

    @And("the user finishes the order")
    public void theUserFinishesTheOrder() {
        getCheckoutPage().clickFinish();
    }

    @Then("the order confirmation should be displayed")
    public void theOrderConfirmationShouldBeDisplayed() {
        Assert.assertEquals(
                getCheckoutPage().getCompleteHeader(),
                "Thank you for your order!",
                "Order confirmation was not displayed.");
    }

    @Then("the checkout error should be displayed")
    public void theCheckoutErrorShouldBeDisplayed() {
        String message = getCheckoutPage().getErrorMessage();

        Assert.assertTrue(
                message.contains("First Name is required"),
                "Unexpected checkout error: " + message);

        System.out.println("Validation Error: " + message);
    }
}