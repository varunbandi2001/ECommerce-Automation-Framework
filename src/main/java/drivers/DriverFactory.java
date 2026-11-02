package drivers;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import utils.ConfigReader;

public class DriverFactory{
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public static WebDriver getDriver()
	{
		if(driver.get() == null) {
			
		 String browser = ConfigReader.getProperty("browser");
		 
		 if(browser == null || browser.trim().isEmpty()) {
			 
			 throw new IllegalArgumentException("Browser is not configured in config.properties");
			 
		 }
		 
		 if(browser.equalsIgnoreCase("chrome"))
		 {
			 ChromeOptions options = new ChromeOptions();
			 WebDriver webDriver = new ChromeDriver(options);
			 
			 webDriver.manage().window().maximize();
			 
			 driver.set(webDriver);
			 

             System.out.println(
                     "Browser started: " + browser
                     + " | Thread: " + Thread.currentThread().getId());

         } else {

             throw new IllegalArgumentException(
                     "Unsupported browser: " + browser
                     + ". Currently supported: chrome");
         }
     }

     return driver.get();
 }

 public static void quitDriver() {

     WebDriver webDriver = driver.get();

     if (webDriver != null) {

         try {
             webDriver.quit();

             System.out.println(
                     "Browser closed | Thread: "
                     + Thread.currentThread().getId());

         } finally {
             driver.remove();
         }
		}
	}
	
}