package runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "C:\\Users\\VARUN REDDY\\eclipse-workspace\\ECommerce\\src\\main\\resources\\features\\ProductSorting.feature",
				glue = {"stepdefinitions" , "hooks"},
				plugin = {"pretty", "html:target/cucumber-reports/login-report.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
				monochrome = true
				)

public class TestRunner extends AbstractTestNGCucumberTests{
	
	@Override
	@DataProvider(parallel = true)
	
	public Object[][] scenarios()
	{
		return super.scenarios();
	}

}
