package pages;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProductSortingPage {
	
	
	private final WebDriver driver;
	private final WebDriverWait wait;
	
	private final By sortDropDown = By.className("product_sort_container");
	
	private final By productNames = By.className("inventory_item_name ");
	
	private final By productPrice = By.className("inventory_item_price");
	private By productPrices;
	
	
	public ProductSortingPage(WebDriver driver)
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		
		
	}
	
	//selecting sorting options
	
	public void selectSortingOption(String option) {
		WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(sortDropDown));
		
		Select select = new Select(dropdown);
		
		select.selectByVisibleText(option);
		
	}
	
	public List<String> getProductNames(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                productNames));

        List<WebElement> elements =
                driver.findElements(productNames);

        List<String> names = new ArrayList<>();

        for (WebElement element : elements) {
            names.add(element.getText());
        }

        return names;
    }

    // Get all product prices
    public List<Double> getProductPrices() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                productPrices));

        List<WebElement> elements =
                driver.findElements(productPrices);

        List<Double> prices = new ArrayList<>();

        for (WebElement element : elements) {
            String price = element.getText().replace("$", "");
            prices.add(Double.parseDouble(price));
        }

        return prices;
    }
}
	
	


