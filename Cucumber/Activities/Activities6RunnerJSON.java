package org.example;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "Features",
        glue = {"stepDefinitions"},
        tags = "@Activity6",
        plugin = {"json: test-reports/json-report.json"},
        monochrome = true
)

public class Activities6RunnerJSON {
}
