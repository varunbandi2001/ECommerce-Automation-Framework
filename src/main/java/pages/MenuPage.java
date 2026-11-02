package pages;



import java.time.Duration;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MenuPage {
	
	
	private final WebDriver driver;
	private final WebDriverWait wait;
	
	private final By menuButton = By.id("react-burger-menu-btn");
	
	private final By logoutLink = By.id("logout_sidebar_link");
	
	private final By loginButton = By.id("login-button");
	
	
	public MenuPage(WebDriver driver)
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
	}
	
	public void openMenu()
	{
		wait.until(ExpectedConditions.elementToBeClickable(menuButton))
		.click();
		
	     // Wait until the Logout link is visible
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        logoutLink));
		
	}
	

    public void clickLogout() {
        wait.until(
                ExpectedConditions.elementToBeClickable(logoutLink))
                .click();
    }

	
	public boolean isLoginPageDisplayed()
	{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton))
				.isDisplayed();
	}

}
