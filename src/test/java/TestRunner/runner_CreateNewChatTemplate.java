package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\java\\Features\\CreateNewChatTemplate.feature",
        glue = {"StepDefinition.CrateNewChatTemplate"},
        plugin = {"pretty"}

)
public class runner_CreateNewChatTemplate {

}
