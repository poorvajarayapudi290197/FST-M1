package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features",
        glue = {"stepDefinitions"},
        tags = "@activity1,@activity2,@activity3,@activity4,@activity5"
)

public class ActivitiesRunner {
    //empty
}