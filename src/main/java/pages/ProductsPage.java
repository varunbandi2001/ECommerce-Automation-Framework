
package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Products page
    private final By productsTitle = By.className("title");

    private final By backpackAddButton =
            By.id("add-to-cart-sauce-labs-backpack");

    private final By backpackRemoveButton =
            By.id("remove-sauce-labs-backpack");

    // Shopping cart
    private final By cartLink =
            By.className("shopping_cart_link");

    private final By cartBadge =
            By.className("shopping_cart_badge");

    private final By cartItems =
            By.className("cart_item");

    private final By cartItemName =
            By.className("inventory_item_name");

    private final By cartItemPrice =
            By.className("inventory_item_price");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(
                driver, Duration.ofSeconds(10));
    }

    public boolean isProductsPageDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        productsTitle))
                .getText()
                .equals("Products");
    }

    public void addBackpackToCart() {
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        backpackAddButton))
                .click();
    }

    public boolean isBackpackRemoveButtonDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        backpackRemoveButton))
                .isDisplayed();
    }

    public String getCartItemCount() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        cartBadge))
                .getText();
    }

    public boolean isCartBadgeDisplayed() {
        return !driver.findElements(cartBadge).isEmpty();
    }

    public void openShoppingCart() {
        wait.until(
                ExpectedConditions.elementToBeClickable(cartLink))
                .click();
    }

    public boolean isBackpackInCart() {
        List<WebElement> items = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        cartItems));

        for (WebElement item : items) {
            String name = item.findElement(cartItemName).getText();

            if (name.equals("Sauce Labs Backpack")) {
                return true;
            }
        }

        return false;
    }

    public String getBackpackPrice() {
        List<WebElement> items = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        cartItems));

        for (WebElement item : items) {
            String name = item.findElement(cartItemName).getText();

            if (name.equals("Sauce Labs Backpack")) {
                return item.findElement(cartItemPrice).getText();
            }
        }

        throw new AssertionError(
                "Sauce Labs Backpack was not found in the cart");
    }

    public void removeBackpackFromCart() {
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        backpackRemoveButton))
                .click();
    }

    public boolean isCartEmpty() {
        wait.until(
                ExpectedConditions.invisibilityOfElementLocated(
                        cartItems));

        return driver.findElements(cartItems).isEmpty();
    }
    
    
    public String getCartProductsName()
    {
    	return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_item_name ")
    			)
    			).getText();
    }
    
    
    public String getCartProductPrice() {
    	return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_item_price")
    			)
    			).getText();
    }
    
    public boolean isCartItemDisplayed()
    {
    	return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("cart_item")
    			)
    			).isDisplayed();
    }
}
