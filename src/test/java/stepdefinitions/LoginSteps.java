
package stepdefinitions;

import org.testng.Assert;

import drivers.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginSteps {

    private LoginPage loginPage;

    @Given("the user opens the SauceDemo login page")
    public void openLoginPage() {
        loginPage = new LoginPage(DriverFactory.getDriver());
    }
    
    //Data driven Login step
    
    @When ("the  user enters username {string} and password{string}")
    
    public void enterUsernameAndPassword(String username,String password) {
    	loginPage.enterUsername(username);
    	loginPage.enterPassword(password);
    }
    
    

    @When("the user logs in with valid credentials")
    public void loginWithValidCredentials() {
        String username =
                ConfigReader.getProperty("validUsername");
        String password =
                ConfigReader.getProperty("validPassword");

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("the user logs in with invalid credentials")
    public void loginWithInvalidCredentials() {
        String username =
                ConfigReader.getProperty("invalidUsername");
        String password =
                ConfigReader.getProperty("invalidPassword");

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("the user logs in with a valid username and invalid password")
    public void loginWithValidUsernameAndInvalidPassword() {
        String username =
                ConfigReader.getProperty("validUsername");
        String password =
                ConfigReader.getProperty("invalidPassword");

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("the user logs in with an empty username")
    public void loginWithEmptyUsername() {
        loginPage.enterUsername("");
        loginPage.enterPassword(
                ConfigReader.getProperty("validPassword"));
    }

    @When("the user logs in with an empty password")
    public void loginWithEmptyPassword() {
        loginPage.enterUsername(
                ConfigReader.getProperty("validUsername"));
        loginPage.enterPassword("");
    }

    @When("the user logs in with locked-out user credentials")
    public void loginWithLockedOutUserCredentials() {
        String username =
                ConfigReader.getProperty("lockedOutUsername");
        String password =
                ConfigReader.getProperty("lockedOutPassword");

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("the user clicks the login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("the products page should be displayed")
    public void verifyProductsPage() {
        Assert.assertTrue(
                loginPage.isProductsPageDisplayed(),
                "Products page was not displayed after login");
    }

    @Then("the login error should contain {string}")
    public void verifyLoginError(String expectedMessage) {
        String actualMessage = loginPage.getErrorMessage();

        Assert.assertTrue(
                actualMessage.toLowerCase().contains(
                        expectedMessage.toLowerCase()),
                "Expected: " + expectedMessage
                        + ", Actual: " + actualMessage);
    }
    
    
    //data  driven result validation
    
    @Then("the login result should be{string}")
    public void verifyLoginresult(String expectedResult) {
    	if(expectedResult.equalsIgnoreCase("success")) {
    		Assert.assertTrue(loginPage.isProductsPageDisplayed(),"Expected successful login, but Products page was not displayed");
    		
    	}else if(expectedResult.equalsIgnoreCase("failure")){
    		
    		String actualError = loginPage.getErrorMessage();
    		
    		Assert.assertFalse(actualError.trim().isEmpty(),"Expected login failure, but no error message was displayed");
    	}
    	else
    	{
    		Assert.fail("Invalid expected result: " + expectedResult);
    	}
    }
    
    
    
    @Given("the user is logged in with valid credentials")
    public void userIsLoggedInWithValidCredentials() {
        loginPage = new LoginPage(DriverFactory.getDriver());

        loginPage.enterUsername(
                ConfigReader.getProperty("validUsername"));
        loginPage.enterPassword(
                ConfigReader.getProperty("validPassword"));
        loginPage.clickLoginButton();

        Assert.assertTrue(
                loginPage.isProductsPageDisplayed(),
                "Login failed; products page was not displayed");
    }
}
