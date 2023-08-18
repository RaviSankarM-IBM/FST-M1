package org.example;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "features",
        glue = {"stepDefinitions"},
        tags = "@Activity6",
        plugin = {"pretty"},
        monochrome = true
)

public class Activities6RunnerPretty {
    //This is intentionally blank
}
