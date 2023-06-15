package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/resources/Features" },
				 glue = {"StepDefinitions"},
			plugin = {"pretty", "html:target/cucumber-reports", "json:target/cucumber.json"}					)

public class TestRunner extends AbstractTestNGCucumberTests {
	
	
}
