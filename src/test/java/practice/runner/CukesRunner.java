package practice.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/html-reports/cucumber-report.html",
                "json:target/json-reports/json-report.json",
                "rerun:target/rerun.txt"},
        features = "src/test/resources/features",
        glue = "practice/step_defs",
        dryRun = false,
        tags = "@nbaNav ",
        monochrome = true,
        publish = false
)
public class CukesRunner {
}
