package TestRunner;

import StepDefinition.BaseClass.WebDriverSingleton;
import io.cucumber.java.AfterStep;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\java\\Features\\CreateNewChatTemplate.feature",
        glue = {"StepDefinition.CrateNewChatTemplate"},
        plugin = {"pretty"}
)
public class runner_CreateNewChatTemplate {
    @AfterClass
    public static void tearDown() {
        WebDriverSingleton.quitDriver();
    }
}
