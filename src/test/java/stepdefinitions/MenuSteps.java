package stepdefinitions;


import org.testng.Assert;

import drivers.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.MenuPage;


public class MenuSteps {
	
	private MenuPage menuPage;
	
	private MenuPage getMenuPage()
	{
		if(menuPage == null)
		{
			menuPage = new MenuPage(DriverFactory.getDriver());
			
		}
		return menuPage;
		
	}
	
	@And("the user opens the side menu")
	
	public void theUserOpensTheSideMenu() {
		getMenuPage().openMenu();
		
	}
	
	@And("the user clicks logout")
	
	public void theUserClicksLogout()
	{
		getMenuPage().clickLogout();
	}

	 @Then("the login page should be displayed after logout")
	    public void theLoginPageShouldBeDisplayedAfterLogout() {
	        Assert.assertTrue(
	                getMenuPage().isLoginPageDisplayed(),
	                "Login page should be displayed after logout");
	    }
	
}
