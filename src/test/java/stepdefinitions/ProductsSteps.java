
package stepdefinitions;

import org.testng.Assert;

import drivers.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.ProductsPage;

public class ProductsSteps {

    private ProductsPage productsPage;

    @Given("the user is on the products page")
    public void userIsOnProductsPage() {
        productsPage = new ProductsPage(
                DriverFactory.getDriver());

        Assert.assertTrue(
                productsPage.isProductsPageDisplayed(),
                "Products page is not displayed");
    }

    @When("the user adds the Sauce Labs Backpack to the cart")
    public void addBackpackToCart() {
        productsPage = new ProductsPage(
                DriverFactory.getDriver());

        productsPage.addBackpackToCart();
    }

    @Then("the cart badge should display {string}")
    public void verifyCartBadge(String expectedCount) {
        Assert.assertEquals(
                productsPage.getCartItemCount(),
                expectedCount,
                "Cart item count is incorrect");
    }

    @Then("the Add to cart button should change to Remove")
    public void verifyRemoveButtonDisplayed() {
        Assert.assertTrue(
                productsPage.isBackpackRemoveButtonDisplayed(),
                "The Remove button was not displayed");
    }

    @When("the user opens the shopping cart")
    public void openShoppingCart() {
        productsPage.openShoppingCart();
    }

    @Then("the cart should contain Sauce Labs Backpack")
    public void verifyBackpackInCart() {
        Assert.assertTrue(
                productsPage.isBackpackInCart(),
                "Sauce Labs Backpack was not found in the cart");
    }

    @Then("the backpack price should be displayed")
    public void verifyBackpackPrice() {
        String price = productsPage.getBackpackPrice();

        Assert.assertTrue(
                price.matches("\\$\\d+\\.\\d{2}"),
                "Invalid backpack price: " + price);
    }

    @When("the user removes the Sauce Labs Backpack from the cart")
    public void removeBackpackFromCart() {
        productsPage.removeBackpackFromCart();
    }

    @Then("the shopping cart should be empty")
    public void verifyCartIsEmpty() {
        Assert.assertTrue(
                productsPage.isCartEmpty(),
                "The shopping cart was not empty");
    }

    @Then("the cart badge should not be displayed")
    public void verifyCartBadgeNotDisplayed() {
        Assert.assertFalse(
                productsPage.isCartBadgeDisplayed(),
                "Cart badge should not be displayed");
    }
    
   
    @Then("the cart should contain the Sauce Labs Backpack")
    public void theCartShouldContainTheBackpack() {

        Assert.assertTrue(
            productsPage.isCartItemDisplayed(),
            "Cart item should be displayed"
        );

        Assert.assertEquals(
            productsPage.getCartProductsName(),
            "Sauce Labs Backpack",
            "Incorrect product name in cart"
        );

        Assert.assertEquals(
            productsPage.getCartProductPrice(),
            "$29.99",
            "Incorrect product price in cart"
        );
    }
}
