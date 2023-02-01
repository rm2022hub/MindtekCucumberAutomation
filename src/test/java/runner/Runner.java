package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json","rerun:target/rerun.txt"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@RTB-5",
        dryRun = false,
        publish = true
)
public class Runner {
}


// Runner class is an empty class
// runner class links feature file and the step definition file.
// for features, you provide the path of the feature file. (root content path)
// for glue, you provide step definition file where we write the steps.
// The purpose of dryRun is to provide unimplemented steps.
// Scenario outline is used as a parameter of scenarios.
// This is used when the same scenario needs to be executed for multiple sets of data;
// however, the test steps remain the same.
// Scenario Outline must be followed by the keyword 'Examples', which specify the set of values for each parameter.
// can say tags = "@RTB-1 and @RTB-2" // tags = "@RTB-1 or @RTB-2"
// publish = true is to publish reports for 24 hours.
// json is a format of data and other way to store, convert, transfer and exchange data.
// can use and or to put multiple tags.