package org.example;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "Features",
        glue = {"stepDefinitions"},
        tags = "@Activity6",
        plugin = {"html: test-reports"},
        monochrome = true
)

public class Activities6RunnerHTML {
}
