package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

    @RunWith(Cucumber.class)
    @CucumberOptions(
            format = {"pretty", "html:target/cucumber-html-report"},
            glue = {"StepDefinitions"},
            features = "src/test/resources"
    )
    public class TestRunner {

    }


