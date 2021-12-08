package tests;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/cucumber/features/", plugin={"pretty","html:testResults.html"}, glue="tests")

public class TestRunner {

}
