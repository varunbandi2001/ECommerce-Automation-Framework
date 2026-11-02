
package hooks;

import drivers.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class Hooks {

    @Before
    public void setUp() {

        DriverFactory.getDriver().get(
                ConfigReader.getProperty("url")
        );
    }

    @After
    public void tearDown(Scenario scenario) {

        try {
            if (scenario.isFailed()) {
                System.out.println(
                        "Scenario failed: " + scenario.getName()
                );
            }

        } finally {
            DriverFactory.quitDriver();
        }
    }
}
