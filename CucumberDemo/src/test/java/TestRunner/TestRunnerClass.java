package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src\\test\\resources\\Features",
    glue = "stepdefinations",
   plugin = {
	        "pretty",
	        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
	    }
   // tags = "@SmokeTest",
   // monochrome = true
)

public class TestRunnerClass {

}
