package stepdefinitions;




import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;

import drivers.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProductSortingPage;


public class ProductSortingSteps {
	
	private ProductSortingPage sortingPage;
	
	private ProductSortingPage getSortingPage()
	{
		if(sortingPage == null) {
			sortingPage = new ProductSortingPage(DriverFactory.getDriver());
			
		}
		
		return sortingPage;
	}
	@When("the user sorts products by {string}")
	
	public void theUserSortsProductsBy(String option) {
		getSortingPage().selectSortingOption(option);
	}
	
	 @Then("products should be displayed in alphabetical order")
	 
	 public void productsShouldBeDisplayedInAlphabeticalOrder() {
		 
		 List<String> actual = getSortingPage().getProductNames();
		 
		 List<String> expected = new ArrayList<>(actual);
		 
		 Collections.sort(expected);
		 
		 Assert.assertEquals(actual, expected,
	                "Products are not sorted by lowest price first");
		 
	 }
	 
	 @Then("products should be displayed from highest price to lowest price")
	    public void productsShouldBeDisplayedFromHighestToLowest() {

	        List<Double> actual =
	                getSortingPage().getProductPrices();

	        List<Double> expected =
	                new ArrayList<>(actual);

	        expected.sort(Collections.reverseOrder());

	        Assert.assertEquals(actual, expected,
	                "Products are not sorted by highest price first");
	
	 }
}
